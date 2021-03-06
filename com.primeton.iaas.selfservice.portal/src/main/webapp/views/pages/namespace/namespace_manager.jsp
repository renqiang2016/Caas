<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<%@include file="/views/common/common.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<script src="<%=contextPath%>/views/pages/namespace/js/namespace_manager.js"></script>
<title>Namespace列表</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12 portlet light ">
			<div class="table-container">
				<div class="table-actions-wrapper">
					<a class="btn btn-success fa fa-plus" onclick="addRow()"> 新建 </a>
				</div>
				
				
				<table class="table table-striped table-bordered table-hover" id="pageNamespaceGrid">
					<thead>
						<tr role="row">
							<th width="2%"><input type="checkbox" class="group-checkable"></th>
							<th>名字</th>
							<th>CPU</th>
							<th>MEMORY</th>
							<th>POD</th>
							<th>状态</th>
							<th>创建时间</th>
							<th>变更时间</th>
							<th width="5%">操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div> 
	<%@include file="/views/pages/namespace/namespace_edit.jsp"%>
	<%--<%@include file="/views/permission/user/user_auth.jsp"%> --%>
</body>
</html>