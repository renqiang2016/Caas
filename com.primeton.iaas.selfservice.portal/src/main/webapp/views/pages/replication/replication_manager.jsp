<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<%@include file="/views/common/common.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<script src="<%=contextPath%>/views/pages/replication/js/replication_manager.js"></script>
<title>ReplicationController列表</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12 portlet light ">
			<div class="table-container">
				<div class="table-actions-wrapper">
					<a class="btn btn-success fa fa-plus" onclick="addRow()"> 新建 </a>
				</div>
				
				
				<table class="table table-striped table-bordered table-hover" id="pageReplicationControllerGrid">
					<thead>
						<tr role="row">
							<th width="2%"><input type="checkbox" class="group-checkable"></th>
							<th>名字</th>
							<th>namespace</th>
							<th>labels</th>
							<th>selector</th>
							<th>副本数量</th>
							<th>镜像</th>
							<th>重启策略</th>
							<th>创建时间</th>
							<th width="5%">操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div><%-- 
	<%@include file="/views/permission/user/user_edit.jsp"%>
	<%@include file="/views/permission/user/user_auth.jsp"%> --%>
</body>
</html>