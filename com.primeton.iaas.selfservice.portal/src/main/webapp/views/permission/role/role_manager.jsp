<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script
	src="<%=request.getContextPath()%>/views/permission/role/js/role_manager.js"></script>
<div class="row">
	<div class="col-md-12 portlet light ">
		<div class="table-container">
			<div class="table-actions-wrapper">
				<a class="btn btn-success fa fa-plus" onclick="addRow()"> 新建 </a>
			</div>

			<table class="table table-striped table-bordered table-hover"
				id="permissionRoleGrid">
				<thead>
					<tr role="row">
						<th width="2%"><input type="checkbox" class="group-checkable"></th>
						<th>角色名称</th>
						<th>创建时间</th>
						<th>更新时间</th>
						<th width="5%">操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="/views/permission/role/role_auth.jsp"%>
<%@include file="/views/permission/role/role_edit.jsp"%>

