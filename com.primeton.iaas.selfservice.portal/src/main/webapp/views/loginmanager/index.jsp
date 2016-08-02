<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html >
<%@include file="/views/common/common.jsp" %>
<%@include file="/views/permission/user/user_edit.jsp"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<script src="<%=contextPath %>/views/loginmanager/js/index.js"></script>
<title>普元云计算自助服务门户</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<%-- <link rel="shortcut icon" href="<%=contextPath%>/favicon.ico" type="image/x-icon"> --%>
</head>
<!-- BEGIN BODY -->
<body class="page-container-bg-solid page-sidebar-closed-hide-logo">
	<%@include file="/views/common/header.jsp" %>
	<div class="page-container">
		<%@include file="/views/common/menu.jsp" %>
		<div class="page-content-wrapper">
			<div class="page-content" >
				<%@include file="/views/common/pagebar.jsp" %>
				 <div id="__pageBody__" class="page-content-body">
				 	<%-- <jsp:include page="<%=target%>" flush="true"></jsp:include> --%>
				 </div> 
			</div>
		</div>
	</div>
	<%@include file="/views/common/footer.jsp" %>
	<script type="text/javascript">
	initMenu () ;
	</script>
</body>
<!-- END BODY -->
</html>