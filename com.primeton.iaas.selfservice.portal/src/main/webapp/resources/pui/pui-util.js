	var FormHelper = function(formId){
		var controls = $("form#"+formId+" .form-control");
		return{
			setData:function(data){
				if(controls){
					controls.each(function(index,element){
						var id = $(this).attr("id");
						if(id && data[id]){
							$(this).val(data[id]);
						}
					});
				}
			},
			getData:function(){
				var data = {};
				if(controls){
					controls.each(function(index,element){
						var id = $(this).attr("id");
						if(id){
							data[id] = $(this).val();
						}
					});
					return data;
				}
			}
		}
	}
	
	function ajaxLoadDom(id, url, method) {
		if (null == method || method.length == 0) {
			method = "get";
		}
		$.ajax({
			url: url,
			type: method,
			success: function(result) {
				if(result.indexOf("1234567890abcdefg") > 0){
					window.location.href = contextPath;
					return;
				}
				$("#" + id).append(result);
			},
			error: function(result) {
				alert("Load " + url + " error.");
			}
		});
	}

	/**
	 * 
	 * @param id
	 */
	function showLoading() {
		var html = "<img src=\"" + contextPath + "/resources/imgs/loading.gif\" width=\"32\" height=\"32\"/>"
		html = "<div class=\"modal fade bs-modal-lg\" id=\"__loading_div__\">\n\t" + html + "\n</div>"
		
		var width = $(window).width();
		var height = $(window).height();
		var top = height/2 - 16;
		var left = width/2 - 16;
		
		$("#__loading_div__").remove();
		$("body").append(html);
		$("#__loading_div__").css({ position:'absolute',  top: '0px', left: '0px', width: $(window).width() + 'px', textAlign: 'left'});
		$("#__loading_div__ img").css({ position:'absolute',  top: top + 'px', left: left + 'px', width: '32px', textAlign: 'left'});
		
		$("#__loading_div__").modal('show');
	}

	/**
	 * 
	 * @param id
	 */
	function closeLoading() {
		$("#__loading_div__").empty();
		$("#__loading_div__").modal('hide');
		$("#__loading_div__").remove();
	}