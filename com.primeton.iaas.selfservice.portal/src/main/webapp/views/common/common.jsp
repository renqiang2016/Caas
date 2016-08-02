<%
	String contextPath=request.getContextPath();
%>

<script>
	var contextPath = '<%=contextPath%>';
</script>

<!-- BEGIN GLOBAL MANDATORY STYLES 全局样式类 -->
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/uniform/css/uniform.default.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" />
<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PLUGIN STYLES 插件样式类 -->
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/admin/pages/css/login3.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/jstree/dist/themes/default/style.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap-datepicker/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/admin/pages/css/tasks.css" />
<!-- END PAGE LEVEL PLUGIN STYLES -->

<link rel="shortcut icon" href="<%=contextPath%>/favicon.ico" type="image/x-icon">

<!-- BEGIN THEME STYLES 主题样式类-->
<!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/css/components.css" id="style_components" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/css/pui_extend.css" id="style_components" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/global/css/plugins.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/admin/layout2/css/layout.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/admin/layout2/css/themes/grey.css" id="style_color"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/pui/assets/admin/layout2/css/custom.css" />

<!-- BEGIN CORE PLUGINS -->
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/jquery.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/jquery-migrate.min.js" ></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/jquery.blockui.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/jquery.cokie.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/uniform/jquery.uniform.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" ></script>

<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/scripts/datatable.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/scripts/datatableNoSearch.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js"></script>
<!-- END PAGE LEVEL PLUGINS  -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/scripts/metronic.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/admin/layout2/scripts/layout.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/admin/layout2/scripts/demo.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/admin/pages/scripts/login.js" ></script>
<!-- END PAGE LEVEL SCRIPTS -->

<script type="text/javascript" src="<%=contextPath %>/resources/pui/pui-util.js"></script>

