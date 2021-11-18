<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title /></title>

<link rel="icon" href="<c:url value="/static/assets/img/logo.png"/>"
	type="image/x-icon">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">

<!-- Custom fonts for this template-->
<link
	href="<c:url value="/static/assets/vendor/fontawesome-free/css/all.min.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Custom styles for this template-->
<link href='<c:url value="/static/assets/css/sb-admin-2.min.css"/>'
	rel="stylesheet">

<%-- <link rel="stylesheet"
	href="<c:url value="/static/assets/css/style.css"/>"> --%>
	
<style type="text/css">
#toast-container{
	margin-top: 60px !important;
}


.toast {
	background-color: #33CC33 !important;
	z-index: 2000000000;
}
.toast-error {
	background-color: #e62e2d !important;
	z-index: 2000000000;
}
</style>

<dec:head></dec:head>

</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper" class="sidebar-toggled">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion toggled"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="<c:url value='/admin/quan-ly'/>">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					Small <sup>2</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<!-- <li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>

			Divider
			<hr class="sidebar-divider"> -->



			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed"
				href="<c:url value ="/admin/quan-li-don-hang/danh-sach-don-hang"/>"> <i
					class="fas fa-receipt fa-fw fa-cog"></i> <span>Quản lý đơn
						hàng</span>
			</a>
				<%-- <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item"
							href='<c:url value ="/admin/quan-li-don-hang/danh-sach-don-hang"/>'>Danh
							sách đơn hàng</a> <a class="collapse-item"
							href='<c:url value ="/admin/quan-li-don-hang/danh-sach-don-hang"/>'>Cards</a>
					</div>
				</div> --%>
				</li>
			<li class="nav-item"><a class="nav-link collapsed"
				href="<c:url value='/admin/nguoi-dung/danh-sach-nguoi-dung'/>"> <i
					class="fas fa-receipt fa-fw fa-cog"></i> <span>Quản lý người dùng</span>
			</a>
				<%-- <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item"
							href='<c:url value ="/admin/quan-li-don-hang/danh-sach-don-hang"/>'>Danh
							sách đơn hàng</a> <a class="collapse-item"
							href='<c:url value ="/admin/quan-li-don-hang/danh-sach-don-hang"/>'>Cards</a>
					</div>
				</div> --%>
				</li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-guitar"></i> <span>Quản lý sản phẩm </span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Sản phẩm:</h6>
						<a class="collapse-item"
							href="<c:url value='/admin/san-pham/danh-sach-san-pham'/>">Danh
							sách sản phẩm</a> <a class="collapse-item"
							href="<c:url value='/admin/san-pham/them-san-pham'/>">Thêm
							sản phẩm</a>
						<div class="collapse-divider"></div>

						<h6 class="collapse-header">Loại sản phẩm:</h6>
						<a class="collapse-item"
							href="<c:url value='/admin/loai-san-pham/danh-sach-loai-san-pham'/>">Danh
							sách loại sản phẩm</a> <a class="collapse-item"
							href="<c:url value='/admin/loai-san-pham/them-loai-san-pham'/>">Thêm
							loại sản phẩm</a>
						<div class="collapse-divider"></div>

						<h6 class="collapse-header">Dòng sản phẩm:</h6>
						<a class="collapse-item"
							href="<c:url value='/admin/dong-san-pham/danh-sach-dong-san-pham'/>">Danh
							sách dòng sản phẩm</a> <a class="collapse-item"
							href="<c:url value='/admin/dong-san-pham/them-dong-san-pham'/>">Thêm
							dòng sản phẩm</a>
						<div class="collapse-divider"></div>

						<h6 class="collapse-header">Màu:</h6>
						<a class="collapse-item"
							href="<c:url value='/admin/mau/danh-sach-mau'/>">Danh sách
							màu</a> <a class="collapse-item"
							href="<c:url value='/admin/mau/them-mau'/>">Thêm màu</a>
						<div class="collapse-divider"></div>
					</div>
				</div></li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Khác</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Nhà cung cấp:</h6>
						<a class="collapse-item"
							href="<c:url value='/admin/nha-cung-cap/danh-sach-nha-cung-cap'/>">Danh
							sách nhà cung cấp</a> <a class="collapse-item"
							href="<c:url value='/admin/nha-cung-cap/them-nha-cung-cap'/>">Thêm
							nhà cung cấp</a>
						<div class="collapse-divider"></div>

						<h6 class="collapse-header">Thương hiệu:</h6>
						<a class="collapse-item"
							href="<c:url value='/admin/thuong-hieu/danh-sach-thuong-hieu'/>">Danh
							sách thương hiệu</a> <a class="collapse-item"
							href="<c:url value='/admin/thuong-hieu/them-thuong-hieu'/>">Thêm
							thương hiệu</a>
						<div class="collapse-divider"></div>



						<h6 class="collapse-header">Quảng cáo:</h6>
						<a class="collapse-item" href="<c:url value='/admin/quang-cao'/>">Danh
							sách quảng cáo</a>
						<div class="collapse-divider"></div>

						<h6 class="collapse-header">Cửa hàng:</h6>
						<a class="collapse-item"
							href="<c:url value='/admin/thong-tin-cua-hang'/>">Thông tin
							cửa hàng</a>
						<div class="collapse-divider"></div>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<!-- 			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
 -->

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">



					<!-- Topbar Search -->


					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->

						<!-- Nav Item - Messages -->
						<li class="nav-item dropdown no-arrow mx-1">
							<a class="nav-link dropdown-toggle" href="<c:url value="/"/>" id="messagesDropdown"> 
								<i class="fab fa-internet-explorer fa-sm fa-fw mr-2 text-gray-400"></i>
									Trang chủ
							</a> 
							
						</li>
						
						
						<div class="topbar-divider d-none d-sm-block"></div>
						<li class="nav-item dropdown no-arrow mx-1">
							<a class="nav-link dropdown-toggle" href="<c:url value="/logout"/>" id="messagesDropdown"
									data-toggle="modal" data-target="#logoutModal"> 
								 <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>Đăng xuất
							</a> 
							
						</li>
					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<dec:body />
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Bạn có muốn đăng xuất?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<!-- <div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div> -->
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Không</button>
					<a class="btn btn-primary" href="<c:url value='/logout'/>">Có</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src='<c:url value="/static/assets/vendor/jquery/jquery.min.js"/>'></script>
	<script
		src='<c:url value="/static/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"/>'></script>

	<!-- Core plugin JavaScript-->
	<script
		src='<c:url value="/static/assets/vendor/jquery-easing/jquery.easing.min.js"/>'></script>

	<!-- Custom scripts for all pages-->
	<script src='<c:url value="/static/assets/js/sb-admin-2.min.js"/>'></script>

	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</body>
</html>