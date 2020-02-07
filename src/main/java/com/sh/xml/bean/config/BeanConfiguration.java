package com.sh.xml.bean.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sh.xml.common.config.service.CommonsConfigurationService;
import com.sh.xml.common.config.service.CommonsConfigurationServiceImpl;

@Configuration
public class BeanConfiguration {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(BeanConfiguration.class);

	/**
	 * Gets the commons configuration service.
	 *
	 * @return the commons configuration service
	 */
	@Bean(name = "commonsConfigurationService")
	public CommonsConfigurationService getCommonsConfigurationService() {
		CommonsConfigurationService commonsConfigurationService = CommonsConfigurationServiceImpl.getInstance();

		return commonsConfigurationService;
	}

}
