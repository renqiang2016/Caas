<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html >
<%@include file="/views/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<script
	src="<%=contextPath%>/resources/pui/assets/admin/pages/scripts/index.js"
	type="text/javascript"></script>
<title>Primeton IaaS7.0</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<title>Insert title here</title>
</head>
<!-- BEGIN BODY -->
<body style="background: transparent;">
	<!-- BEGIN PAGE HEADER-->
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
				class="fa fa-angle-right"></i></li>
			<li><a href="#">Dashboard</a></li>
		</ul>
		<div class="page-toolbar">
			<div id="dashboard-report-range"
				class="tooltips btn btn-fit-height btn-sm green-haze btn-dashboard-daterange"
				data-container="body" data-placement="left"
				data-original-title="Change dashboard date range">
				<i class="icon-calendar"></i>&nbsp;&nbsp; <i
					class="fa fa-angle-down"></i>
			</div>
		</div>
	</div>
	<!-- END PAGE HEADER-->
	<!-- BEGIN DASHBOARD STATS -->
	<div class="row">
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<a class="dashboard-stat dashboard-stat-light blue-soft" href="#">
				<div class="visual">
					<i class="fa fa-comments"></i>
				</div>
				<div class="details">
					<div class="number">1349</div>
					<div class="desc">New Feedbacks</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<a class="dashboard-stat dashboard-stat-light red-soft" href="#">
				<div class="visual">
					<i class="fa fa-trophy"></i>
				</div>
				<div class="details">
					<div class="number">12,5M$</div>
					<div class="desc">Total Profit</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<a class="dashboard-stat dashboard-stat-light green-soft" href="#">
				<div class="visual">
					<i class="fa fa-shopping-cart"></i>
				</div>
				<div class="details">
					<div class="number">549</div>
					<div class="desc">New Orders</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<a class="dashboard-stat dashboard-stat-light purple-soft" href="#">
				<div class="visual">
					<i class="fa fa-globe"></i>
				</div>
				<div class="details">
					<div class="number">+89%</div>
					<div class="desc">Brand Popularity</div>
				</div>
			</a>
		</div>
	</div>
	<!-- END DASHBOARD STATS -->
	<div class="clearfix"></div>

	<div class="row">
		<div class="col-md-6 col-sm-6">
			<div class="portlet light ">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-share font-blue-steel hide"></i> <span
							class="caption-subject font-blue-steel bold uppercase">Recent
							Activities</span>
					</div>
					<div class="actions">
						<div class="btn-group">
							<a class="btn btn-sm btn-default btn-circle" href="#"
								data-toggle="dropdown" data-hover="dropdown"
								data-close-others="true"> Filter By <i
								class="fa fa-angle-down"></i>
							</a>
							<div
								class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
								<label><input type="checkbox" /> Finance</label> <label><input
									type="checkbox" checked="" /> Membership</label> <label><input
									type="checkbox" /> Customer Support</label> <label><input
									type="checkbox" checked="" /> HR</label> <label><input
									type="checkbox" /> System</label>
							</div>
						</div>
						<a class="btn btn-circle btn-icon-only btn-default fullscreen"
							href="#"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="scroller" style="height: 300px;"
						data-always-visible="1" data-rail-visible="0">
						<ul class="feeds">
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-info">
												<i class="fa fa-check"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												You have 4 pending tasks. <span
													class="label label-sm label-warning "> Take action <i
													class="fa fa-share"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">Just now</div>
								</div>
							</li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-sm label-success">
													<i class="fa fa-bar-chart-o"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">Finance Report for year 2013 has
													been released.</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">20 mins</div>
									</div>
							</a></li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-danger">
												<i class="fa fa-user"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">You have 5 pending membership that
												requires a quick review.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">24 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-info">
												<i class="fa fa-shopping-cart"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												New order received with <span
													class="label label-sm label-success"> Reference
													Number: DR23923 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">30 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-success">
												<i class="fa fa-user"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">You have 5 pending membership that
												requires a quick review.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">24 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-default">
												<i class="fa fa-bell-o"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												Web server hardware needs to be upgraded. <span
													class="label label-sm label-default "> Overdue </span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">2 hours</div>
								</div>
							</li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-sm label-default">
													<i class="fa fa-briefcase"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">IPO Report for year 2013 has been
													released.</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">20 mins</div>
									</div>
							</a></li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-info">
												<i class="fa fa-check"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												You have 4 pending tasks. <span
													class="label label-sm label-warning "> Take action <i
													class="fa fa-share"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">Just now</div>
								</div>
							</li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-sm label-danger">
													<i class="fa fa-bar-chart-o"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">Finance Report for year 2013 has
													been released.</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">20 mins</div>
									</div>
							</a></li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-default">
												<i class="fa fa-user"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">You have 5 pending membership that
												requires a quick review.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">24 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-info">
												<i class="fa fa-shopping-cart"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												New order received with <span
													class="label label-sm label-success"> Reference
													Number: DR23923 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">30 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-success">
												<i class="fa fa-user"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">You have 5 pending membership that
												requires a quick review.</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">24 mins</div>
								</div>
							</li>
							<li>
								<div class="col1">
									<div class="cont">
										<div class="cont-col1">
											<div class="label label-sm label-warning">
												<i class="fa fa-bell-o"></i>
											</div>
										</div>
										<div class="cont-col2">
											<div class="desc">
												Web server hardware needs to be upgraded. <span
													class="label label-sm label-default "> Overdue </span>
											</div>
										</div>
									</div>
								</div>
								<div class="col2">
									<div class="date">2 hours</div>
								</div>
							</li>
							<li><a href="#">
									<div class="col1">
										<div class="cont">
											<div class="cont-col1">
												<div class="label label-sm label-info">
													<i class="fa fa-briefcase"></i>
												</div>
											</div>
											<div class="cont-col2">
												<div class="desc">IPO Report for year 2013 has been
													released.</div>
											</div>
										</div>
									</div>
									<div class="col2">
										<div class="date">20 mins</div>
									</div>
							</a></li>
						</ul>
					</div>
					<div class="scroller-footer">
						<div class="btn-arrow-link pull-right">
							<a href="#">See All Records</a> <i class="icon-arrow-right"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6 col-sm-6">
			<div class="portlet light tasks-widget">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-share font-green-haze hide"></i> <span
							class="caption-subject font-green-haze bold uppercase">Tasks</span>
						<span class="caption-helper">tasks summary...</span>
					</div>
					<div class="actions">
						<div class="btn-group">
							<a class="btn green-haze btn-circle btn-sm" href="#"
								data-toggle="dropdown" data-hover="dropdown"
								data-close-others="true"> More <i class="fa fa-angle-down"></i>
							</a>
							<ul class="dropdown-menu pull-right">
								<li><a href="#"> <i class="i"></i> All Project
								</a></li>
								<li class="divider"></li>
								<li><a href="#"> AirAsia </a></li>
								<li><a href="#"> Cruise </a></li>
								<li><a href="#"> HSBC </a></li>
								<li class="divider"></li>
								<li><a href="#"> Pending <span
										class="badge badge-danger"> 4 </span>
								</a></li>
								<li><a href="#"> Completed <span
										class="badge badge-success"> 12 </span>
								</a></li>
								<li><a href="#"> Overdue <span
										class="badge badge-warning"> 9 </span>
								</a></li>
							</ul>
						</div>
						<a class="btn btn-circle btn-icon-only btn-default fullscreen"
							href="#"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="task-content">
						<div class="scroller" style="height: 305px;"
							data-always-visible="1" data-rail-visible1="1">
							<!-- START TASK LIST -->
							<ul class="task-list">
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> Present 2013 Year IPO
											Statistics at Board Meeting </span> <span
											class="label label-sm label-success">Company</span> <span
											class="task-bell"> <i class="fa fa-bell-o"></i>
										</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> Hold An Interview for
											Marketing Manager Position </span> <span
											class="label label-sm label-danger">Marketing</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> AirAsia Intranet System
											Project Internal Meeting </span> <span
											class="label label-sm label-success">AirAsia</span> <span
											class="task-bell"> <i class="fa fa-bell-o"></i>
										</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> Technical Management
											Meeting </span> <span class="label label-sm label-warning">Company</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> Kick-off Company CRM
											Mobile App Development </span> <span
											class="label label-sm label-info">Internal Products</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> Prepare Commercial Offer
											For SmartVision Website Rewamp </span> <span
											class="label label-sm label-danger">SmartVision</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> Sign-Off The Comercial
											Agreement With AutoSmart </span> <span
											class="label label-sm label-default">AutoSmart</span> <span
											class="task-bell"> <i class="fa fa-bell-o"></i>
										</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li>
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> Company Staff Meeting </span> <span
											class="label label-sm label-success">Cruise</span> <span
											class="task-bell"> <i class="fa fa-bell-o"></i>
										</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li class="last-line">
									<div class="task-checkbox">
										<input type="checkbox" class="liChild" value="" />
									</div>
									<div class="task-title">
										<span class="task-title-sp"> KeenThemes Investment
											Discussion </span> <span class="label label-sm label-warning">KeenThemes
										</span>
									</div>
									<div class="task-config">
										<div class="task-config-btn btn-group">
											<a class="btn btn-xs default" href="#" data-toggle="dropdown"
												data-hover="dropdown" data-close-others="true"> <i
												class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="#"> <i class="fa fa-check"></i>
														Complete
												</a></li>
												<li><a href="#"> <i class="fa fa-pencil"></i> Edit
												</a></li>
												<li><a href="#"> <i class="fa fa-trash-o"></i>
														Cancel
												</a></li>
											</ul>
										</div>
									</div>
								</li>
							</ul>
							<!-- END START TASK LIST -->
						</div>
					</div>
					<div class="task-footer">
						<div class="btn-arrow-link pull-right">
							<a href="#">See All Records</a> <i class="icon-arrow-right"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-6 col-sm-6">
			<div class="portlet light ">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-cursor font-purple-intense hide"></i> <span
							class="caption-subject font-purple-intense bold uppercase">General
							Stats</span>
					</div>
					<div class="actions">
						<a href="javascript:;"
							class="btn btn-sm btn-circle btn-default easy-pie-chart-reload">
							<i class="fa fa-repeat"></i> Reload
						</a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div class="col-md-6 col-sm-6">
			<div class="portlet light ">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-equalizer font-purple-plum hide"></i> <span
							class="caption-subject font-red-sunglo bold uppercase">Server
							Stats</span> <span class="caption-helper">monthly stats...</span>
					</div>
					<div class="tools">
						<a href="" class="collapse"> </a> <a href="#portlet-config"
							data-toggle="modal" class="config"> </a> <a href=""
							class="reload"> </a> <a href="" class="remove"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="row"></div>
				</div>
			</div>
		</div>
	</div>
	<script>
jQuery(document).ready(function() {    
   Metronic.init();
   Index.init();
});
</script>
</body>
<!-- END BODY -->
</html>