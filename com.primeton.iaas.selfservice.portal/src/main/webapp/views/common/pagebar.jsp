<%@page import="com.primeton.iaas.selfservice.portal.loginmanager.filter.SessionFilter"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i> 
			<%-- <a href="<%= request.getContextPath() %><%= SessionFilter.getDefault().getLoginPage() %>">首页</a> --%> 
			<a href="">首页</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#" id="parentMenuId"> </a> 
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#" id="childMenuId"> </a>
		</li>
	</ul>
</div>