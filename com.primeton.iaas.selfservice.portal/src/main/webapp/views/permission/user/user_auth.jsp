<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

</head>
<body>
	<div id="formModalAuth" class="modal fade bs-modal-lg" >
		<div class="modal-dialog" style="width:80%">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body">			
					<table id="authtable" style="width:100%;height:80%" border="1">
						<tr>
							<td valign="top">
								<table class="table table-striped table-bordered table-hover"  id="table1">
									<thead>
										<tr role="row">								
											<th width="2%"><input type="checkbox" class="group-checkable"></th>
											<th>角色代码</th>
											<th>角色名称</th>								
										</tr>							
									</thead>
									<tbody>
									</tbody>
								</table>
							</td>
							<td style="width:120px;text-align:center;">
				                <input type="button" value=">" onclick="add()" style="width:40px;"/><br />
				                <!-- <input type="button" value=">>" onclick="addAll()" style="width:40px;"/><br />
				                <input type="button" value="&lt;&lt;" onclick="removeAll()" style="width:40px;"/><br /> -->
				                <input type="button" value="<" onclick="removes()" style="width:40px;"/><br />
				
				            </td>
				            <td valign="top">
								<table class="table table-striped table-bordered table-hover" id="table2">
									<thead>
										<tr role="row">								
											<th width="2%"><input type="checkbox" class="group-checkable"></th>
											<th>角色代码</th>
											<th>角色名称</th>								
										</tr>							
									</thead>
									<tbody>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn default">取消</button>
					<button type="button" class="btn green" id="saveBtn" onclick="doSaveAuth()">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>