/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Jan 4, 2016
 *******************************************************************************/

package com.primeton.iaas.selfservice.portal.loginmanager.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import com.primeton.iaas.selfservice.portal.log.LoggerService;
import com.primeton.iaas.selfservice.portal.permission.vo.UserVO;

/**
 * UserLoginFilter. <br>
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class SessionFilter implements Filter {
	
	private static Logger logger = LoggerService.getTraceLogger(SessionFilter.class);
	
	public static final String SESSION_USER = "user"; //$NON-NLS-1$
	
	private String excludedPages;
	private String homePage;
	private String loginPage;
	
	private String[] excludedPageArray;
	
	private static SessionFilter sessionFilter;
	
	/**
	 * Default. <br>
	 */
	public SessionFilter() {
		super();
		sessionFilter = this;
	}
	
	public static SessionFilter getDefault(){
		return sessionFilter;
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		logger.info("Destroy filter {} success.", this.toString()); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        String path = servletRequest.getRequestURI();
        
        // Setting current thread context
        // DataContextManager.getCurrent().setContext(session);
        
        Object obj = session.getAttribute(SESSION_USER);
        UserVO user = (null != obj && obj instanceof UserVO) ? (UserVO)obj : null;
        
        // if already login and visit login page then go home
        if (null != user && path.contains(servletRequest.getContextPath() + loginPage)) {
        	redirectHomePage(servletRequest, servletResponse);
        	return;
        }
        // No need login can visit resource
        if (isExcludedPath(path)) {
        	chain.doFilter(servletRequest, servletResponse);
			return;
        }
        // Redirect login page if not login
        if (null == user) {
        	redirectLoginPage(servletRequest, servletResponse);
			return;
        }
        // can visit
        chain.doFilter(servletRequest, servletResponse);
	}


	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		homePage = config.getInitParameter("homePage"); //$NON-NLS-1$
		homePage = StringUtils.isEmpty(homePage) ? "/index.jsp" : homePage; //$NON-NLS-1$
		logger.info("Home page is {}.", homePage);
		
		loginPage = config.getInitParameter("loginPage"); //$NON-NLS-1$
		loginPage = StringUtils.isEmpty(loginPage) ? "/login.jsp" : loginPage; //$NON-NLS-1$
		logger.info("Login page is {}.", loginPage);
		
		excludedPages = config.getInitParameter("excludedPages"); //$NON-NLS-1$
		if (StringUtils.isNotEmpty(excludedPages)) {
			excludedPageArray = excludedPages.split(",");
			if (null != excludedPageArray && excludedPageArray.length > 0) {
				List<String> urls = new ArrayList<String>();
				for (String url : excludedPageArray) {
					if (null == url) {
						continue;
					}
					String page = url.trim();
					if (page.length() > 0) {
						urls.add(page);
					}
				}
				excludedPageArray = urls.toArray(new String[urls.size()]);
			}
		}
		logger.info("Init filter {} success.", this.toString()); //$NON-NLS-1$
	}

	/**
	 * @param path
	 * @return
	 */
	private boolean isExcludedPath(String path) {
		if (null == path || path.trim().length() == 0) {
			return false;
		}
		if (null != excludedPageArray && excludedPageArray.length > 0) {
			for (String page : excludedPageArray) {
				if (path.endsWith(page)) {
					return true;
				}
				if (page.endsWith("*")
						&& path.contains(page.substring(0, page.length() - 1))) {
					return true;
				}
				if (page.startsWith("*") && path.contains(page.substring(1))) {
					return true;
				}
				if (page.endsWith("*") && page.startsWith("*")
						&& page.length() > 2
						&& path.contains(page.substring(1, page.length() - 1))) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void redirectHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (null == request || null == response) {
			return;
		}
		String url = request.getContextPath() + this.homePage;
		response.sendRedirect(url); //$NON-NLS-1$
		logger.info("Redirect to {}.", url);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void redirectLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (null == request || null == response) {
			return;
		}
		String url = request.getContextPath() + this.loginPage;
		response.sendRedirect(url); //$NON-NLS-1$
		logger.info("Redirect to {}.", url);
	}

	/**
	 * @return Returns the excludedPages.
	 */
	public String getExcludedPages() {
		return excludedPages;
	}

	/**
	 * @return Returns the homePage.
	 */
	public String getHomePage() {
		return homePage;
	}

	/**
	 * @return Returns the loginPage.
	 */
	public String getLoginPage() {
		return loginPage;
	}
	
}

/*
 * Change history
 * $Log$ 
 */