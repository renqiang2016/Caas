<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<script type="text/javascript">
$("#uploadBtn").click(function(){
    var dialog = $("#uploadDiv").clone().dialog({
        title: "附件上传",
        width : '75%',
        height : 500,
        modal : true
    });
    $('#fileupload', dialog).fileupload({
        dataType: 'json',
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar', dialog).css(
                'width',
                progress + '%'
            ).html(progress + '%');
            $("#msgDiv", dialog).html("处理中……");
        },
        add: function (e, data) {
            data.url = "ra/suspiciousCase/uploadTotal";
            data.submit();
            $("#uploadBtn", dialog).off('click').on('click', function () {
                var id = getUrlParam('id');
                data.url = "ra/suspiciousCase/upload?id="+id;
                data.submit();
                setTimeout(function(){handleUploadTable();}, 3000);//延迟执行刷新
            });
        },
        done: function (e, data) {
            var isTotal = data.url.indexOf("uploadTotal") > -1;
            var tip = isTotal ? "解析成功，请点击“确认上传”" : "上传";
            var result = data.result;
            var msg = "<b>" + tip + "</b>"
            var bar = $('#progress .progress-bar');
            bar.removeClass("progress-bar-warning progress-bar-success");
            if(!result.success){
                msg = "<b>" + tip + "失败：</b>"+result.error;
                bar.addClass("progress-bar-warning");
                $("#uploadBtn", dialog).addClass("disabled");
            }else{
                bar.addClass("progress-bar-success");
                msg = "<b>" + tip + "成功：</b>";
                if(isTotal){
                    $("#uploadBtn", dialog).removeClass("disabled");
                     
                }
            }
            if(result.totalInfo){
                msg += "<br>";
                msg += "<b>提示信息：</b>" + result.totalInfo;
            }
            msg += "<br><b>文件名称：</b>" + data.files[0].name;
            $("#msgDiv", dialog).html(msg);
        }
    })
})

</script>
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
							<form role="form" id="replicationForm" class="form-horizontal">
								<div class="form-body" id="uploadDiv">
							         <!-- The fileinput-button span is used to style the file input field as button -->
							        <span class="btn btn-success fileinput-button">
							            <i class="glyphicon glyphicon-plus"></i>
							            <span>文件选择</span>
							            <!-- The file input field used as target for the file upload widget -->
							            <input id="fileupload" type="file" name="file" >
							        </span>
							        <button id="uploadBtn" class="btn btn-primary disabled" >确认上传</button>
							        <br>
							        
							        <!-- The global progress bar -->
							        <div id="progress" class="progress">
							            <div class="progress-bar progress-bar-success"></div>
							        </div>
							        <!-- The container for the uploaded files -->
							        <div id="msgDiv" class="files"></div>
							    </div>
								<div class="form-body">
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
										</div>
									</div>
								</div>
							</form>
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