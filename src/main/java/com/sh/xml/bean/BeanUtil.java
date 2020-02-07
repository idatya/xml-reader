package com.sh.xml.bean;

import com.sh.xml.bean.config.BeanContextManager;
import com.sh.xml.common.config.service.CommonsConfigurationService;

public class BeanUtil {

	public static CommonsConfigurationService getCommonsConfigurationService() throws Exception {
		CommonsConfigurationService commonsConfigurationService = (CommonsConfigurationService) BeanContextManager
				.getBean("commonsConfigurationService", null);
		return commonsConfigurationService;
	}

	/*public static LookupService getLookupService() throws Exception {
		LookupService lookupService = (LookupService) BeanContextManager.getBean(LookupServiceImpl.class);
		return lookupService;
	}*/

}
