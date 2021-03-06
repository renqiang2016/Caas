<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title></title>
</head>
<body>
	<div id="userModal" class="modal fade bs-modal-lg">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body">
					<div class="scroller" style="height: 300px" data-always-visible="1" data-rail-visible1="1">
						<div class="form">
							<form role="form" id="userForm" class="form-horizontal">
								<div class="form-body">
									<input type="hidden" id="id" class="form-control">
									<div class="form-group">
										<label class="col-md-3 control-label">用户名</label>
										<div class="col-md-8">
											<input type="text" id="name" class="form-control" maxlength="15"></input>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">性别</label>
										<div class="col-md-8">
											<select id="gender" class="form-control">
												<option  value ="男">男</option>
 												<option  value ="女">女</option>
											</select>
											<!-- <input type="radio" id="gender" name="dender" class="form-control" value="男"/>男
											<input type="radio" id="gender" name="dender" class="form-control" value="女"/>女 -->
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">密码</label>
										<div class="col-md-8">
											<input type="password" id="password" class="form-control" maxlength="25"></input>
										</div>
									</div>
									<div class="form-group"> 
										<label class="col-md-3 control-label">确认密码</label>
										<div class="col-md-8">
											<input type="password" id="password2" class="form-control" maxlength="25"></input>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">电子邮箱</label>
										<div class="col-md-8">
											<input type="email" id="email" class="form-control" maxlength="30"></input>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">电话号码</label>
										<div class="col-md-8">
											<input type="text" id="tel" class="form-control" maxlength="30"></input>
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