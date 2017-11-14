package com.boliangshenghe.eqim.common.datasource;

import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;

import com.alibaba.cobar.client.datasources.ICobarDataSourceService;
import com.alibaba.cobar.client.router.ICobarRouter;
import com.alibaba.cobar.client.router.support.IBatisRoutingFact;
import com.alibaba.cobar.client.support.utils.CollectionUtils;

public class RouterInvoker implements InitializingBean {
	private ICobarRouter<IBatisRoutingFact> router;
	private ICobarDataSourceService cobarDataSourceService;

	public RouterInvoker() {
		// router = SpringBeanUtil.getBean(ICobarRouter.class);
		// cobarDataSourceService =
		// SpringBeanUtil.getBean(ICobarDataSourceService.class);
		
	}

	public SortedMap<String, DataSource> lookupDataSourcesByRouter(final String statementName,
			final Object parameterObject) {
		SortedMap<String, DataSource> resultMap = new TreeMap<String, DataSource>();
		if (router != null && cobarDataSourceService != null) {
			List<String> dsSet = router.doRoute(new IBatisRoutingFact(statementName, parameterObject))
					.getResourceIdentities();
			if (CollectionUtils.isNotEmpty(dsSet)) {
				Collections.sort(dsSet);
				for (String dsName : dsSet) {
					resultMap.put(dsName, cobarDataSourceService.getDataSources().get(dsName));
				}
			}
		}
		return resultMap;
	}

	public ICobarRouter<IBatisRoutingFact> getRouter() {
		return router;
	}

	public void setRouter(ICobarRouter<IBatisRoutingFact> router) {
		this.router = router;
	}

	public ICobarDataSourceService getCobarDataSourceService() {
		return cobarDataSourceService;
	}

	public void setCobarDataSourceService(ICobarDataSourceService cobarDataSourceService) {
		this.cobarDataSourceService = cobarDataSourceService;
	}

	public void afterPropertiesSet() throws Exception {

	}

}
