<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title></title>
</head>
<body>
	<div id="namespacesModal" class="modal fade bs-modal-lg">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body">
					<div class="scroller" style="height: 300px" data-always-visible="1" data-rail-visible1="1">
						<div class="form">
							<form role="form" id="namespacesForm" class="form-horizontal">
								<div class="form-body">
									<input type="hidden" id="id" class="form-control">
									<div class="form-group">
										<label class="col-md-3 control-label">namespace名字</label>
										<div class="col-md-8">
											<input type="text" id="name" class="form-control" maxlength="15"></input>
										</div>
									</div>
									
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn default">取消</button>
					<button type="button" class="btn green" id="saveBtn" onclick="doSave()">保存</button>
					<button type="button" class="btn green" id="updateBtn" onclick="doUpdate()">更新</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>