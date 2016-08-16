<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title></title>
</head>
<body>
	<div id="replicationModal" class="modal fade bs-modal-lg">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body">
					<div class="scroller" style="height: 300px" data-always-visible="1" data-rail-visible1="1">
						<div class="form">
							<form id= "uploadForm" action="<%=request.getContextPath() %>/UploadHandleServlet" method="post" enctype="multipart/form-data" >
						        	上传人名:<input type="text" name="name" /><br/>      
						          	上传文件:<input type="file" name="file" /><br/>
						          	<input type="submit" name="submit" value="提交" />
						    </form>
							<!-- <form id= "uploadForm">  
						       <input type="file" id="file" name="file"/>  
						       <input type="button" value="上传" onclick="ajaxFileUpload()" />  
							</form> -->  
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn default">取消</button>
					<button type="button" class="btn green" id="uploadBtn">创建</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>