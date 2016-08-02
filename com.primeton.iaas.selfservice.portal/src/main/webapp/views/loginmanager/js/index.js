	function initMenu () {
		showLoading();
		$.ajax({
			url:contextPath+"/rest/permission/menu/listUserMenu",
    		type:'GET',
    		contentType:'application/json',
    		dataType:'json',
    		success:function(ret){
    			var menuTree = ret.data;
    			showMenu(menuTree);
    			closeLoading();
    		},
    		error:function(ret){
    			closeLoading();
    		}
    		
    	});
    }
	
	function showMenu(menuTree){
		$("#menuContainer").empty();
		var len = menuTree.length;
	    var index = null;
	    var flag = false;
	    var firstBar = null;
		for (var i = 0; i < len; i++){
			 var lev1Menu = "<li>" +
							"<a href=''>" +
								"<i class='icon-settings'></i>" + 
								"<span class='title'>" + menuTree[i].name + "</span>" +
								"<span class='arrow '></span>" +
							"</a>" +
							"<ul class='sub-menu' id='" + "subMenu" + i +"'>" +
							"</ul>" +
						    "</li>";
			 
			 var childMenu = menuTree[i].childrens;
			 var childLen = childMenu.length;
			 if(childLen > 0 ){			 
				 $("#menuContainer").append(lev1Menu);
				 flag = true;
			 }
			 for (var j = 0; j < childLen; j++){
				 if (null == index && flag == true && j == 0){
					 index = contextPath + childMenu[j].funcAction;
					 firstBar = i;
				 }
//				 var lev2Menu = "<li><a class='ajaxify' href='javascript:ajaxLoadDom("page-content-body",contextPath+childMenu[j].funcAction , "get")'>" + childMenu[j].name + "</a></li>"
				 var lev2Menu = "<li>\n"
					 + "	<a id='__subMenu-" + i + "-" + j + "' class='ajaxify' onclick=\"loadBody("
					 + "'" + contextPath + childMenu[j].funcAction + "', '" + childMenu[j].name + "', '" + menuTree[i].name + "'); return false;\" >"
					 + childMenu[j].name
					 +		"</a>"
					 + "</li>";
				 $("#subMenu" + i).append(lev2Menu);
			 }
			 
		}
//		loadBody(index);
//		$("#__subMenu-0-0").click(function(){
//        });
		if(null == firstBar){
			firstBar = 0;
		}

		$("#__subMenu-" + firstBar + "-0").trigger("click");
	}
	
	function loadBody(url, child, parent) {
		$("#__pageBody__").empty();
		ajaxLoadDom('__pageBody__', url, 'get');
		$("#childMenuId").empty();
		$("#childMenuId").append(child);
		$("#parentMenuId").empty();
		$("#parentMenuId").append(parent);
	}
    
    $(function(){
    	Metronic.init(); 
        //getMenu();
    });
