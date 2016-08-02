<%
	session.invalidate();
	response.sendRedirect(request.getContextPath() + "/views/loginmanager/login.jsp");
%>