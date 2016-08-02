package com.primeton.iaas.selfservice.portal.log;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 日志服务
 * 
 * @author guwei (mailto:guwei@primeton.com)
 */
public class LoggerService {
	
	public static Logger getTraceLogger(Class<?>clazz){
		return LoggerFactory.getLogger(clazz);
	}
	
	public static void initLogger(String logPath){
		ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
		LoggerContext loggerContext = (LoggerContext) loggerFactory;
		loggerContext.reset();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(loggerContext);
		try {
			configurator.doConfigure(logPath);
		} catch (JoranException e) {
			e.printStackTrace();
		}
	}
	
}
