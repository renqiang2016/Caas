<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<%@include file="/views/common/common.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<script src="<%=contextPath%>/views/applications/approvalAppl/js/application_manager.js"></script>
<title>资源申请单列表</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12 portlet light ">
			<div class="table-container">
				
				<table class="table table-striped table-bordered table-hover" id="orderGrid">
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
	<%@include file="/views/applications/approvalAppl/application_item.jsp"%>
</body>
</html>