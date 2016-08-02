<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html >
<%@include file="/views/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/resources/pui/assets/admin/pages/scripts/form-wizard.js"></script>
<script src="<%=contextPath%>/views/js/table-ajax.js"></script>
<title>Insert title here</title>
</head>
<!-- BEGIN BODY -->
<body >
<!-- BEGIN PAGE HEADER-->
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
				class="fa fa-angle-right"></i></li>
			<li><a href="#">云资源管理</a> <i class="fa fa-angle-right"></i>
			</li>
			<li><a href="#">云主机管理</a></li>
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
		<div class="col-md-12 portlet light ">
			<div class="table-container">
				<div class="table-actions-wrapper">
					<span> </span>
					<!-- <button class="btn btn-sm blue table-group-action-new" onclick="createVm()"><i class="fa fa-check"></i> New</button> -->
					<a class="btn btn-success fa fa-plus" data-toggle="modal"
						href="#wizard"> 向导 </a> <a class="btn btn-success fa fa-plus"
						data-toggle="modal" href="#form"> 新建 </a> <select
						class="table-group-action-input form-control input-inline input-small input-sm">
						<option value="">Select...</option>
						<option value="Cancel">Cancel</option>
						<option value="Cancel">Hold</option>
						<option value="Cancel">On Hold</option>
						<option value="Close">Close</option>
					</select>
					<!-- <button class="btn btn-success table-group-action-submit">
								<i class="fa fa-check"></i> Submit
							</button> -->
				</div>
				<table class="table table-striped table-bordered table-hover"
					id="datatable_ajax">
					<thead>
						<tr role="row">
							<th width="2%"><input type="checkbox"
								class="group-checkable"></th>
							<th>云主机名称</th>
							<th>镜像名称</th>
							<th>IP地址</th>
							<th>套餐</th>
							<th>状态</th>
							<th>计算资源池</th>
							<th>创建时间</th>
							<th>动作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			<!-- End: life time stats -->
		</div>
	</div>
	<!-- <a class="btn default" data-toggiewle="modal" href="#responsive12">
		View Demo </a> -->

	
	<div id="form" class="modal fade bs-modal-lg" tabindex="-1">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">Responsive & Scrollable</h4>
				</div>
				<div class="modal-body">
					<div class="scroller" style="height: 300px" data-always-visible="1"
						data-rail-visible1="1">
						<div class="row">
							<div class="col-md-6">
								<h4>Some Input</h4>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
							</div>
							<div class="col-md-6">
								<h4>Some More Input</h4>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
								<p>
									<input type="text" class="col-md-12 form-control">
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn default">Close</button>
					<button type="button" class="btn green">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<div id="wizard" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width: 800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">创建虚拟机</h4>
				</div>
				<div class="modal-body">
					<div class="scroller" style="height: 600px;"
						data-always-visible="1" data-rail-visible1="1">
						<div class="row">
							<div class="col-md-12">
								<div class="" id="form_wizard_1">
									<form action="#" class="form-horizontal" id="submit_form"
										method="POST">
										<div class="form-wizard">
											<div class="form-body">
												<ul class="nav nav-pills nav-justified steps">
													<li><a href="#tab1" data-toggle="tab" class="step">
															<span class="number"> 1 </span> <span class="desc">
																<i class="fa fa-check"></i> 基础配置
														</span>
													</a></li>
													<li><a href="#tab2" data-toggle="tab" class="step">
															<span class="number"> 2 </span> <span class="desc">
																<i class="fa fa-check"></i> 访问&安全
														</span>
													</a></li>
													<li><a href="#tab3" data-toggle="tab"
														class="step active"> <span class="number"> 3 </span> <span
															class="desc"> <i class="fa fa-check"></i> 网络
														</span>
													</a></li>
													<li><a href="#tab4" data-toggle="tab" class="step">
															<span class="number"> 4 </span> <span class="desc">
																<i class="fa fa-check"></i> 高级选项
														</span>
													</a></li>
												</ul>
												<div id="bar" class="progress progress-striped"
													role="progressbar">
													<div class="progress-bar progress-bar-success"></div>
												</div>
												<div class="tab-content">
													<div class="alert alert-danger display-none">
														<button class="close" data-dismiss="alert"></button>
														You have some form errors. Please check below.
													</div>
													<div class="alert alert-success display-none">
														<button class="close" data-dismiss="alert"></button>
														Your form validation is successful!
													</div>
													<div class="tab-pane active" id="tab1">
														<div class="form-group">
															<label class="control-label col-md-3">云主机名称 <span
																class="required"> * </span>
															</label>
															<div class="col-md-4">
																<input type="text" class="form-control" name="username" />
																<span class="help-block"> 请输入云主机名称 </span>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">计算资源池 <span
																class="required"> * </span>
															</label>
															<div class="col-md-4">
																<select class="form-control">
																	<option>计算资源池01</option>
																	<option>计算资源池02</option>
																	<option>计算资源池03</option>
																	<option>计算资源池04</option>
																	<option>计算资源池05</option>
																</select> <span class="help-block"> 请选择计算资源池. </span>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">CPU <span
																class="required"> * </span>
															</label>
															<div class="col-md-8">
																<div class="btn-group" data-toggle="buttons">
																	<label class="btn blue active"> <input
																		type="radio" class="toggle"> 1
																	</label> <label class="btn blue"> <input type="radio"
																		class="toggle"> 2
																	</label> <label class="btn blue"> <input type="radio"
																		class="toggle"> 3
																	</label> <label class="btn blue"> <input type="radio"
																		class="toggle"> 4
																	</label> <label class="btn blue"> <input type="radio"
																		class="toggle"> 5
																	</label> <label class="btn blue"> <input type="radio"
																		class="toggle"> 6
																	</label> <label class="btn blue"> <input type="radio"
																		class="toggle"> 7
																	</label> <label class="btn blue"> <input type="radio"
																		class="toggle"> 8
																	</label>
																</div>
																<span class="help-block"> 请选择CPU核数 </span>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Email <span
																class="required"> * </span>
															</label>
															<div class="col-md-4">
																<input type="text" class="form-control" name="email" />
																<span class="help-block"> Provide your email
																	address </span>
															</div>
														</div>
													</div>
													<div class="tab-pane" id="tab2">
														<h3 class="block">Provide your profile details</h3>
														<div class="form-group">
															<label class="control-label col-md-3">Fullname <span
																class="required"> * </span>
															</label>
															<div class="col-md-4">
																<input type="text" class="form-control" name="fullname" />
																<span class="help-block"> Provide your fullname </span>
															</div>
														</div>
													</div>
													<div class="tab-pane" id="tab3">
														<h3 class="block">Provide your billing and credit
															card details</h3>
														<div class="form-group">
															<label class="control-label col-md-3">Card Holder
																Name <span class="required"> * </span>
															</label>
															<div class="col-md-4">
																<input type="text" class="form-control" name="card_name" />
																<span class="help-block"> </span>
															</div>
														</div>
													</div>
													<div class="tab-pane" id="tab4">
														<h3 class="block">Confirm your account</h3>
														<h4 class="form-section">Account</h4>
														<div class="form-group">
															<label class="control-label col-md-3">Username:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="username">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Email:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="email">
																</p>
															</div>
														</div>
														<h4 class="form-section">Profile</h4>
														<div class="form-group">
															<label class="control-label col-md-3">Fullname:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="fullname">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Gender:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="gender">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Phone:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="phone">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Address:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="address">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">City/Town:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="city">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Country:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="country">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Remarks:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="remarks">
																</p>
															</div>
														</div>
														<h4 class="form-section">Billing</h4>
														<div class="form-group">
															<label class="control-label col-md-3">Card Holder
																Name:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="card_name">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Card
																Number:</label>
															<div class="col-md-4">
																<p class="form-control-static"
																	data-display="card_number"></p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">CVC:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="card_cvc">
																</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Expiration:</label>
															<div class="col-md-4">
																<p class="form-control-static"
																	data-display="card_expiry_date"></p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3">Payment
																Options:</label>
															<div class="col-md-4">
																<p class="form-control-static" data-display="payment[]">
																</p>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions">
												<div class="row">
													<div class="col-md-offset-3 col-md-9">
														<a href="javascript:;" class="btn default button-previous">
															<i class="m-icon-swapleft"></i> Back
														</a> <a href="javascript:;" class="btn blue button-next">
															Continue <i class="m-icon-swapright m-icon-white"></i>
														</a> <a href="javascript:;" class="btn green button-submit">
															Submit <i class="m-icon-swapright m-icon-white"></i>
														</a>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn default">Close</button>
					<button type="button" class="btn green">Save changes</button>
				</div>
			</div>
		</div>
	</div>
<script>
        jQuery(document).ready(function() {    
           Metronic.init(); // init metronic core components
           TableAjax.init();
           FormWizard.init();
        });
        
    </script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>