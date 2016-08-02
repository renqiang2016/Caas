//让回车生效
if (document.addEventListener) { // Firefox
	document.addEventListener("keypress", fireFoxHandler, true);
} else {
	document.attachEvent("onkeypress", ieHandler);
}

function fireFoxHandler(event) {
	if (event.keyCode == 13) {
		doCheck();
	}
}

function ieHandler(event) {
	if (event.keyCode == 13) {
		doCheck();
	}
}

    function doCheck(){
    	var data = formHelper.getData();
//    	var roleName = null;
//    	var userRole = <%=request.getSession().getAttribute("userRole")%>;
    	$.ajax({
    		url:contextPath+"/rest/permission/user/check",
    		type: "POST",
    		async: false,
    		contentType:'application/json',
    		data:JSON.stringify({"user":data}),
    		dataType:'json',
    		success:function(ret){
    			if (ret['data'] != null){
    	    		window.location.href=contextPath+"/views/loginmanager/index.jsp";
    	    	}
    	    	else {
    	    		alert("用户名或密码错误!");
    	    	}
    		},
    		error:function(ret){
    		}
    		
    	});
    	   	
    }

    var formHelper;
    $(function(){
    	Metronic.init();
        $('#formModal').on("hidden.bs.modal", function() {
        	$("#logForm")[0].reset();
        });
        formHelper = new FormHelper("logForm");
    });
