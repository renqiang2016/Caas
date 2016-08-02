<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<%@include file="/views/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<%=contextPath%>/resources/pui/assets/global/plugins/jstree/dist/jstree.min.js"></script>
<script src="<%=contextPath%>/views/js/ui-tree.js"></script>
<title>Insert title here</title>
</head>
<body style="background: transparent;">
	<h3 class="page-title">
		Tree View <small>customizable fuelux tree view</small>
	</h3>
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
				class="fa fa-angle-right"></i></li>
			<li><a href="#">UI Features</a> <i class="fa fa-angle-right"></i>
			</li>
			<li><a href="#">Tree View</a></li>
		</ul>
		<div class="page-toolbar">
			<div class="btn-group pull-right">
				<button type="button"
					class="btn btn-fit-height grey-salt dropdown-toggle"
					data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
					data-close-others="true">
					Actions <i class="fa fa-angle-down"></i>
				</button>
				<ul class="dropdown-menu pull-right" role="menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#">Separated link</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- END PAGE HEADER-->
	<!-- BEGIN PAGE CONTENT-->
	<div class="row">
		<div class="col-md-6">
			<div class="portlet blue-hoki box">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>Default Tree
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse"> </a> <a
							href="#portlet-config" data-toggle="modal" class="config"> </a> <a
							href="javascript:;" class="reload"> </a> <a href="javascript:;"
							class="remove"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div id="tree_1" class="tree-demo">
						<ul>
							<li>Root node 1
								<ul>
									<li data-jstree='{ "selected" : true }'><a href="#">
											Initially selected </a></li>
									<li
										data-jstree='{ "icon" : "fa fa-briefcase icon-state-success " }'>
										custom icon URL</li>
									<li data-jstree='{ "opened" : true }'>initially open
										<ul>
											<li data-jstree='{ "disabled" : true }'>Disabled Node</li>
											<li data-jstree='{ "type" : "file" }'>Another node</li>
										</ul>
									</li>
									<li
										data-jstree='{ "icon" : "fa fa-warning icon-state-danger" }'>
										Custom icon class (bootstrap)</li>
								</ul>
							</li>
							<li data-jstree='{ "type" : "file" }'><a
								href="http://www.jstree.com"> Clickanle link node </a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="portlet green-meadow box">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>Checkable Tree
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse"> </a> <a
							href="#portlet-config" data-toggle="modal" class="config"> </a> <a
							href="javascript:;" class="reload"> </a> <a href="javascript:;"
							class="remove"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div id="tree_2" class="tree-demo"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END PAGE CONTENT-->
	<div class="row">
		<div class="col-md-6">
			<div class="portlet yellow-lemon box">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>Contextual Menu with Drag & Drop
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse"> </a> <a
							href="#portlet-config" data-toggle="modal" class="config"> </a> <a
							href="javascript:;" class="reload"> </a> <a href="javascript:;"
							class="remove"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div id="tree_3" class="tree-demo"></div>
					<div class="alert alert-success no-margin margin-top-10">
						Note! Opened and selected nodes will be saved in the user's
						browser, so when returning to the same tree the previous state
						will be restored.</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="portlet red-pink box">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>Ajax Tree with Drag & Drop
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse"> </a> <a
							href="#portlet-config" data-toggle="modal" class="config"> </a> <a
							href="javascript:;" class="reload"> </a> <a href="javascript:;"
							class="remove"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div id="tree_4" class="tree-demo"></div>
					<div class="alert alert-info no-margin margin-top-10">Note!
						The tree nodes are loaded from demo/jstree_ajax_data.php via ajax.
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
        jQuery(document).ready(function() {       
           Metronic.init(); // init metronic core components
           UITree.init();
        });
    </script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>