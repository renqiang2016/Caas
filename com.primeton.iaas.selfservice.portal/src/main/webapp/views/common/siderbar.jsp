<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
		<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu"	data-keep-expanded="false" data-auto-scroll="true"	data-slide-speed="200">
			<li class="start active">
				<a> 
					<i class="icon-home"></i> 
					<span class="title">门户</span> 
					<span class="selected"></span>
				</a>
			</li>
			<li>
				<a href=""> 
					<i class="icon-settings"></i> 
					<span class="title">基础设施管理</span> 
					<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li><a href="<%=request.getContextPath() %>/views/resmanager/datacenter/data_center_manager.jsp"> 数据中心管理</a></li>
					<li><a href="<%=request.getContextPath() %>/views/resmanager/machineroom/machine_room_manager.jsp"> 机房管理</a></li>
					<li><a href="<%=request.getContextPath() %>/views/resmanager/machinerack/machine_rack_manager.jsp"> 机柜管理</a></li>
					<li><a href="<%=request.getContextPath() %>/views/resmanager/machinebox/machine_box_manager.jsp"> 机箱管理</a></li>
				</ul>
			</li>
			
			<li>
				<a href=""> 
					<i class="icon-settings"></i> 
					<span class="title">资源池管理</span> 
					<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li><a href="<%=request.getContextPath() %>/views/resmanager/poolstorage/pool_storage_manager.jsp">存储资源池</a></li>
					<li><a href="<%=request.getContextPath() %>/views/resmanager/poolnetwork/pool_network_manager.jsp">网络资源池</a></li>
				</ul>
			</li>
			
			<li>
				<a href=""> 
					<i class="icon-settings"></i> 
					<span class="title">计算资源管理</span> 
					<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li><a href="<%=request.getContextPath() %>/views/resmanager/volume/volume_manager.jsp">存储管理</a></li>
					<li><a href="<%=request.getContextPath() %>/views/resmanager/image/image_manager.jsp">镜像管理</a></li>
				</ul>
			</li>
			
			<li>
				<a href=""> 
					<i class="icon-settings"></i> 
					<span class="title">配置管理</span> 
					<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li><a href="<%=request.getContextPath() %>/views/configmanager/tenant/tenant_manager.jsp">租户管理</a></li>
				</ul>
			</li>
			
			<li>
				<a href=""> 
					<i class="icon-settings"></i> 
					<span class="title">监控管理</span> 
					<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li><a href="<%=request.getContextPath() %>/views/monitor/template/template_manager.jsp">监控模版管理</a></li>
				</ul>
			</li>

			<!-- <li><a> <i class="icon-settings"></i> <span class="title">示例</span>
					<span class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a href="vm_manager.jsp"> 云主机管理</a></li>
					<li><a href="ui_tree_iframe.jsp"> 树示例</a></li>
				</ul></li>

			<li><a> <i class="icon-settings"></i> <span class="title">权限管理</span>
					<span class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a> 菜单管理</a></li>
					<li><a> 功能管理</a></li>
					<li><a> 角色管理</a></li>
				</ul></li> -->
		</ul>
	</div>
</div>