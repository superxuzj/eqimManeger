package com.boliangshenghe.eqim.common.datasource;

import com.alibaba.cobar.client.transaction.MultipleDataSourcesTransactionManager;


public class MultiDataSourceTransactionManager extends MultipleDataSourcesTransactionManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2280154135234778335L;

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		// 不同步,不然报错,spring2.5没有此问题
		this.setTransactionSynchronization(SYNCHRONIZATION_NEVER);
	}
}
