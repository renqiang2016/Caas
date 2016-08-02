<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>Primeton IaaS7.0</title>
</head>
<body class="page-container-bg-solid page-sidebar-closed-hide-logo ">

	<%@include file="/views/common/header.jsp" %>

	<div class="page-container">
	
		<%@include file="/views/common/siderbar.jsp" %>
		
		<div class="page-content-wrapper">
			<div class="page-content" >

				<%@include file="/views/common/pagebar.jsp" %>

				<div class="page-content-body">
				
				 	<%@include file="/views/demo/dashboard.jsp" %>
				 	
				 </div>
			</div>
		</div>
	</div>

	<%@include file="/views/common/footer.jsp" %>
</body>
</html>