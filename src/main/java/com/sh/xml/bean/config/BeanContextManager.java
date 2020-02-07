package com.sh.xml.bean.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanContextManager {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(BeanContextManager.class);

	/** The context. */
	private static ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

	public static Object getBean(String beanName, Object beanParams) throws Exception {
		Object bean = null;
		try {
			if (null != beanParams) {
				bean = context.getBean(beanName, beanParams);
			} else {
				bean = context.getBean(beanName);
			}
		} catch (BeansException e) {
			LOGGER.error("Not able to load Bean " + beanName, e);
			throw new Exception("Not able to load Bean ", e);
		}

		return bean;

	}

	public static <T> T getBean(Class<T> class1) {
		T bean = context.getBean(class1);
		return bean;
	}

}
