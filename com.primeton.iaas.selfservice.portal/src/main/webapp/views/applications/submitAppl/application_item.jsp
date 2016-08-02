<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title></title>
</head>
<body>
	<div id="formModal" class="modal fade bs-modal-lg">
		<div class="modal-dialog" style="width:80%">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body">
					<div class="scroller" style="height: 350px" data-always-visible="1" data-rail-visible1="1">
						<div class="form">
							<form role="form" id="orderForm" class="form-horizontal">
								<div class="form-body">
									<input type="hidden" id="id" class="form-control">
									<table style="width:100%;height:80%">
										<tr>
											<td>
												<div class="form-group">
													<label class="col-md-3 control-label">申请单号</label>
													<div class="col-md-4">
														<input type="text" readonly="readonly" id="id" class="form-control" maxlength="15"></input>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">申请单状态</label>
													<div class="col-md-4">
														<input type="text" readonly="readonly" id="status" class="form-control" maxlength="25"></input>
													</div>
												</div>
											</td>
											<td>
												<div class="form-group"> 
													<label class="col-md-3 control-label">创建时间</label>
													<div class="col-md-4">
														<input type="text" readonly="readonly" id="createTime" class="form-control" maxlength="25"></input>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">变更时间</label>
													<div class="col-md-4">
														<input type="text" readonly="readonly" id="modifiedTime" class="form-control" maxlength="30"></input>
													</div>
												</div>
											</td>
										</tr>
									</table>
								</div>
								<div>
									<table class="table table-striped table-bordered table-hover" id="orderItemGrid">
										<thead>
											<tr role="row">
												<th width="2%"><input type="checkbox" class="group-checkable"></th>
												<th>名字</th>
												<th>CPU</th>
												<th>内存</th>
												<th>POD</th>
												<th>说明</th>
												<th width="5%">操作</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">	
					<button type="button" class="btn green" id="submitBtn" onclick="doSubmit()">提交</button>	
					<button type="button" class="btn yellow" id="revokeBtn" onclick="doRevoke()">撤销</button>
					<button type="button" class="btn red" id="deleteBtn" onclick="doDelete()">删除</button>
					<button type="button" data-dismiss="modal" class="btn default">返回</button>					
				</div>
			</div>
		</div>
	</div>
</body>
</html>