package com.boliangshenghe.eqim.common.datasource;


import static java.lang.reflect.Proxy.newProxyInstance;
import static org.apache.ibatis.reflection.ExceptionUtil.unwrapThrowable;
import static org.mybatis.spring.SqlSessionUtils.closeSqlSession;
import static org.mybatis.spring.SqlSessionUtils.isSqlSessionTransactional;
import static org.springframework.util.Assert.notNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.sql.DataSource;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.alibaba.cobar.client.router.support.IBatisRoutingFact;
import com.alibaba.cobar.client.support.utils.MapUtils;
import com.alibaba.fastjson.JSON;

/**
 * Thread safe, Spring managed, {@code SqlSession} that works with Spring
 * transaction management to ensure that that the actual SqlSession used is the
 * one associated with the current Spring transaction. In addition, it manages
 * the session life-cycle, including closing, committing or rolling back the
 * session as necessary based on the Spring transaction configuration.
 * <p>
 * The template needs a SqlSessionFactory to create SqlSessions, passed as a
 * constructor argument. It also can be constructed indicating the executor type
 * to be used, if not, the default executor type, defined in the session factory
 * will be used.
 * <p>
 * This template converts MyBatis PersistenceExceptions into unchecked
 * DataAccessExceptions, using, by default, a {@code MyBatisExceptionTranslator}.
 * <p>
 * Because MultipleSourceSqlSessionTemplate is thread safe, a single instance
 * can be shared by all DAOs; there should also be a small memory savings by
 * doing this. This pattern can be used in Spring configuration files as
 * follows:
 * 
 * <pre class="code">
 * {@code
 * <bean id="sqlSessionTemplate" class="org.mybatis.spring.MultipleSourceSqlSessionTemplate">
 *   <constructor-arg ref="sqlSessionFactory" />
 * </bean>
 * }
 * </pre>
 * 
 * @see SqlSessionFactory
 * @see MyBatisExceptionTranslator
 * @version $Id: MultipleSourceSqlSessionTemplate.java 4898 2012-03-12 10:19:45Z
 *          simone.tripodi $
 */
public class MultipleSourceSqlSessionTemplate extends SqlSessionTemplate {

	private final SqlSessionFactory sqlSessionFactory;

	private final ExecutorType executorType;

	private final SqlSession sqlSessionProxy;

	private final PersistenceExceptionTranslator exceptionTranslator;
	private RouterInvoker routerInvoker;
	// 保存查找数据源的条件
	private final ThreadLocal<IBatisRoutingFact> routingFact = new ThreadLocal<IBatisRoutingFact>();

	/**
	 * Constructs a Spring managed SqlSession with the {@code SqlSessionFactory}
	 * provided as an argument.
	 * 
	 * @param sqlSessionFactory
	 */
	public MultipleSourceSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		this(sqlSessionFactory, sqlSessionFactory.getConfiguration().getDefaultExecutorType());
	}

	/**
	 * Constructs a Spring managed SqlSession with the {@code SqlSessionFactory}
	 * provided as an argument and the given {@code ExecutorType}
	 * {@code ExecutorType} cannot be changed once the
	 * {@code MultipleSourceSqlSessionTemplate} is constructed.
	 * 
	 * @param sqlSessionFactory
	 * @param executorType
	 */
	public MultipleSourceSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
		this(sqlSessionFactory, executorType, new MyBatisExceptionTranslator(sqlSessionFactory.getConfiguration()
				.getEnvironment().getDataSource(), true));
	}

	/**
	 * Constructs a Spring managed {@code SqlSession} with the given
	 * {@code SqlSessionFactory} and {@code ExecutorType}. A custom
	 * {@code SQLExceptionTranslator} can be provided as an argument so any
	 * {@code PersistenceException} thrown by MyBatis can be custom translated
	 * to a {@code RuntimeException} The {@code SQLExceptionTranslator} can also
	 * be null and thus no exception translation will be done and MyBatis
	 * exceptions will be thrown
	 * 
	 * @param sqlSessionFactory
	 * @param executorType
	 * @param exceptionTranslator
	 */
	public MultipleSourceSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType,
			PersistenceExceptionTranslator exceptionTranslator) {
		super(sqlSessionFactory, executorType, exceptionTranslator);
		notNull(sqlSessionFactory, "Property 'sqlSessionFactory' is required");
		notNull(executorType, "Property 'executorType' is required");

		this.sqlSessionFactory = sqlSessionFactory;
		this.executorType = executorType;
		this.exceptionTranslator = exceptionTranslator;
		this.sqlSessionProxy = (SqlSession) newProxyInstance(SqlSessionFactory.class.getClassLoader(),
				new Class[] { SqlSession.class }, new SqlSessionInterceptor());
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return this.sqlSessionFactory;
	}

	public ExecutorType getExecutorType() {
		return this.executorType;
	}

	public PersistenceExceptionTranslator getPersistenceExceptionTranslator() {
		return this.exceptionTranslator;
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T selectOne(String statement) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, null);
		routingFact.set(fact);
		T result = this.sqlSessionProxy.<T> selectOne(statement);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T selectOne(String statement, Object parameter) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		T result = this.sqlSessionProxy.<T> selectOne(statement, parameter);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, null);
		routingFact.set(fact);
		Map<K, V> result = this.sqlSessionProxy.<K, V> selectMap(statement, mapKey);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		Map<K, V> result = this.sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		Map<K, V> result = this.sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey, rowBounds);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <E> List<E> selectList(String statement) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, null);
		routingFact.set(fact);
		List<E> result = this.sqlSessionProxy.<E> selectList(statement);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <E> List<E> selectList(String statement, Object parameter) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		List<E> result = this.sqlSessionProxy.<E> selectList(statement, parameter);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		List<E> result = this.sqlSessionProxy.<E> selectList(statement, parameter, rowBounds);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void select(String statement, ResultHandler handler) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, null);
		routingFact.set(fact);
		this.sqlSessionProxy.select(statement, handler);
	}

	/**
	 * {@inheritDoc}
	 */
	public void select(String statement, Object parameter, ResultHandler handler) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		this.sqlSessionProxy.select(statement, parameter, handler);
	}

	/**
	 * {@inheritDoc}
	 */
	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		this.sqlSessionProxy.select(statement, parameter, rowBounds, handler);
	}

	/**
	 * {@inheritDoc}
	 */
	public int insert(String statement) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, null);
		routingFact.set(fact);
		int result = this.sqlSessionProxy.insert(statement);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public int insert(String statement, Object parameter) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		int result = this.sqlSessionProxy.insert(statement, parameter);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public int update(String statement) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, null);
		routingFact.set(fact);
		int result = this.sqlSessionProxy.update(statement);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public int update(String statement, Object parameter) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, parameter);
		routingFact.set(fact);
		int result = this.sqlSessionProxy.update(statement, parameter);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public int delete(String statement) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement, null);
		routingFact.set(fact);
		int result = this.sqlSessionProxy.delete(statement);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public int delete(String statement, Object parameter) {
		IBatisRoutingFact fact = new IBatisRoutingFact(statement,parameter);
		routingFact.set(fact);
		int result = this.sqlSessionProxy.delete(statement, parameter);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T getMapper(Class<T> type) {
		return getConfiguration().getMapper(type, this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void commit() {
		throw new UnsupportedOperationException("Manual commit is not allowed over a Spring managed SqlSession");
	}

	/**
	 * {@inheritDoc}
	 */
	public void commit(boolean force) {
		throw new UnsupportedOperationException("Manual commit is not allowed over a Spring managed SqlSession");
	}

	/**
	 * {@inheritDoc}
	 */
	public void rollback() {
		throw new UnsupportedOperationException("Manual rollback is not allowed over a Spring managed SqlSession");
	}

	/**
	 * {@inheritDoc}
	 */
	public void rollback(boolean force) {
		throw new UnsupportedOperationException("Manual rollback is not allowed over a Spring managed SqlSession");
	}

	/**
	 * {@inheritDoc}
	 */
	public void close() {
		throw new UnsupportedOperationException("Manual close is not allowed over a Spring managed SqlSession");
	}

	/**
	 * {@inheritDoc}
	 */
	public void clearCache() {
		this.sqlSessionProxy.clearCache();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	public Configuration getConfiguration() {
		return this.sqlSessionFactory.getConfiguration();
	}

	/**
	 * {@inheritDoc}
	 */
	public Connection getConnection() {
		return this.sqlSessionProxy.getConnection();
	}

	/**
	 * 获取数据库连接工分页用
	 * 
	 * @param action
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String action, Object param) throws SQLException {
		SortedMap<String, DataSource> map = getRouterInvoker().lookupDataSourcesByRouter(action, param);
		if (MapUtils.isNotEmpty(map)) {
			return map.get(map.firstKey()).getConnection();
		}
		throw new SQLException("根据条件没找到数据源" + action + ":" + JSON.toJSONString(param));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 1.0.2
	 * 
	 */
	public List<BatchResult> flushStatements() {
		return this.sqlSessionProxy.flushStatements();
	}

	public RouterInvoker getRouterInvoker() {
		return routerInvoker;
	}

	public void setRouterInvoker(RouterInvoker routerInvoker) {
		this.routerInvoker = routerInvoker;
	}

	/**
	 * Proxy needed to route MyBatis method calls to the proper SqlSession got
	 * from Spring's Transaction Manager It also unwraps exceptions thrown by
	 * {@code Method#invoke(Object, Object...)} to pass a
	 * {@code PersistenceException} to the
	 * {@code PersistenceExceptionTranslator}.
	 */
	private class SqlSessionInterceptor implements InvocationHandler {
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			SqlSession sqlSession = null;
			try {
				// 根据条件查找数据源
				IBatisRoutingFact fact = routingFact.get();
				SortedMap<String, DataSource> map = getRouterInvoker().lookupDataSourcesByRouter(fact.getAction(),
						fact.getArgument());
				Configuration config = MultipleSourceSqlSessionTemplate.this.sqlSessionFactory.getConfiguration();
				TransactionFactory tf = config.getEnvironment().getTransactionFactory();
				if (MapUtils.isEmpty(map)) {
					throw new SQLException("根据条件没找到数据源" + ":" + JSON.toJSONString(fact));
				}
				Transaction tx = tf.newTransaction(map.get(map.firstKey()), null, false);
				Executor executor = config.newExecutor(tx, config.getDefaultExecutorType());
				sqlSession = new DefaultSqlSession(config, executor);

				Object result = method.invoke(sqlSession, args);
				if (!isSqlSessionTransactional(sqlSession, MultipleSourceSqlSessionTemplate.this.sqlSessionFactory)) {
					// force commit even on non-dirty sessions because some
					// databases require
					// a commit/rollback before calling close()
					sqlSession.commit(true);
				}
				return result;
			} catch (Throwable t) {
				Throwable unwrapped = unwrapThrowable(t);
				if (MultipleSourceSqlSessionTemplate.this.exceptionTranslator != null
						&& unwrapped instanceof PersistenceException) {
					Throwable translated = MultipleSourceSqlSessionTemplate.this.exceptionTranslator
							.translateExceptionIfPossible((PersistenceException) unwrapped);
					if (translated != null) {
						unwrapped = translated;
					}
				}
				throw unwrapped;
			} finally {
				if (sqlSession != null) {
					closeSqlSession(sqlSession, MultipleSourceSqlSessionTemplate.this.sqlSessionFactory);
				}
				MultipleSourceSqlSessionTemplate.this.routingFact.remove();
			}
		}
	}

}
