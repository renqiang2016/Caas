<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script src="<%=request.getContextPath()%>/views/applications/dealAppl/js/application_manager.js"></script>
<div class="row">
	<div class="col-md-12 portlet light ">
		<div class="table-container">

			<table class="table table-striped table-bordered table-hover"
				id="orderGrid">
				<thead>
					<tr role="row">
						<th width="2%"><input type="checkbox" class="group-checkable"></th>
						<th>申请单号</th>
						<th>申请单状态</th>
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
<%@include file="/views/applications/dealAppl/application_item.jsp"%>
