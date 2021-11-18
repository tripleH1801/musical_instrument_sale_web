<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/index_page/Slider.css"/>">


<link rel="stylesheet"
	href="<c:url value="/static/assets/css/index_page/index.css"/>">

</head>
<body>


	<!-- Slider and  category -->
	<div class="container slider_caterogies">

		<div class="row">

			<!-- category -->
			<div class="col-2 pl-0 pr-0 ">


				<!-- categories -->
				<div class="categories">

					<div class="category__adjust" style="background-color: #e6e6e6;">
						<div class="item">

							<i class="fas fa-bars category__icon"></i> <a
								class="category__name">Danh mục sản phẩm</a>
						</div>

						<c:forEach items="${ map }" var="loaiSP">

							<div class="category">
								<div class="item">
									<i class="fas fa-guitar category__icon"></i> <a
										class="category__name"
										href="<c:url value="/danh-sach-san-pham/${ loaiSP.key.id }?page=1"/>">${ loaiSP.key.tenLoaiSanPham }</a>
								</div>

								<div class="sub-category">
									<div class="category-detail">
										<c:forEach items="${ loaiSP.value }" var="thuongHieu">
											<div class="category__line">
												<a
													href="<c:url value="/danh-sach-san-pham/${ loaiSP.key.id }/${ thuongHieu.id }?page=1"/>"><img
													src="data:image/jpg;base64,${thuongHieu.hinhAnhBase64}"
													alt="${ thuongHieu.tenThuongHieu }"></a>

												<p
													onclick="location.href='<c:url value="/danh-sach-san-pham/${ loaiSP.key.id }/${ thuongHieu.id }?page=1"/>'">
													<b>${ thuongHieu.tenThuongHieu }</b>
												</p>
												<hr>
												<c:forEach items="${ dongSanPhams }" var="dongSP">
													<c:if test="${ dongSP.thuongHieu.id eq thuongHieu.id }">
														<c:if test="${ dongSP.loaiSanPham.id eq loaiSP.key.id }">

															<p
																onclick="location.href='<c:url value="/danh-sach-san-pham/${ dongSP.id }?page=1"/>'">${ dongSP.tenDongSanPham }</p>

														</c:if>
													</c:if>
												</c:forEach>
											</div>
										</c:forEach>

									</div>
								</div>
							</div>
						</c:forEach>

						<div class="category">
							<div class="item">
								<i class="fas fa-guitar category__icon"></i> <a
									class="category__name"
									href="<c:url value="/danh-sach-san-pham?page=1"/>">Tất cả
									sản phẩm</a>
							</div>
						</div>
					</div>

				</div>
			</div>



			<!-- slider -->
			<div class="col-7 slider ml-2">
				<div class="row">
					<div id="demo" class="carousel slide" data-ride="carousel">

						<!-- Indicators -->
						<ul class="carousel-indicators">
							<li data-target="#demo" data-slide-to="0" class="active"></li>
							<li data-target="#demo" data-slide-to="1"></li>
							<li data-target="#demo" data-slide-to="2"></li>
						</ul>

						<!-- The slideshow -->
						<div class="carousel-inner">


							<c:forEach items="${ quangCaoDTOs }" var="quangCaoDTO"
								varStatus="counter">
								<c:if test="${ counter.count <= 3 }">
									<div
										class="carousel-item <c:if test="${ counter.count == 1 }">active</c:if>">
										<a href="${ quangCaoDTO.link }"> <img
											src="data:image/jpg;base64,${ quangCaoDTO.hinhAnhBase64 }"
											alt="" width="100%" height="400">
										</a>
									</div>
								</c:if>

							</c:forEach>


						</div>

						<!-- Left and right controls -->
						<a class="carousel-control-prev" href="#demo" data-slide="prev">
							<span class="carousel-control-prev-icon"></span>
						</a> <a class="carousel-control-next" href="#demo" data-slide="next">
							<span class="carousel-control-next-icon"></span>
						</a>
					</div>
				</div>
			</div>


			<!-- side -->
			<div class="col ml-2 sider">
				<c:forEach items="${ quangCaoDTOs }" var="quangCaoDTO"
					varStatus="counter">
					<c:if test="${ counter.count > 3 }">
						<div class="row">
							<a href="${ quangCaoDTO.link }"><img
								src="data:image/jpg;base64,${ quangCaoDTO.hinhAnhBase64 }"
								alt=""></a>
						</div>
					</c:if>
				</c:forEach>

			</div>

		</div>
	</div>

	<!-- Sản phẩm nổi bật -->
	<div class="container  mt-3 best_sell_product">

		<!-- Chổ này load lên 5 10 hoặc 15 sản phẩm cho nó full dòng -->
		<h2 class="product__title ">SẢN PHẨM NỔI BẬT</h2>


		<div class="row pl-0 pr-0 list__product--sell">

			<c:forEach items="${ sanPhamBanChays }" var="sanPhamBanChay"
				varStatus="counter">

				<c:if test="${ counter.count <=5 }">
					<div class="product"
						onclick="location.href = '/WebsiteBanNhacCu/san-pham?id=${sanPhamBanChay.id}'">
						<div class="product__img">
							<img
								src="data:image/jpg;base64,${ sanPhamBanChay.hinhAnhBase64 }"
								style="object-fit: contain;" alt="">
						</div>
						<p class="product__name">
							<b>${ sanPhamBanChay.tenSanPham }</b>
						</p>

						<div class="additional">
							<p>
								Thương hiệu: <b>${ sanPhamBanChay.tenThuongHieu }</b>
							</p>
							<p>
								Xuất xứ: <b>${ sanPhamBanChay.xuatXu }</b>
							</p>
						</div>

						<p class="money">
							<fmt:formatNumber type="currency"
								value="${ sanPhamBanChay.giaBan }" currencySymbol="" />
							VNĐ
						</p>
						<!-- <div class="start-ratting">
		                        <span class="fa fa-star checked"></span>
		                        <span class="fa fa-star checked"></span>
		                        <span class="fa fa-star checked"></span>
		                        <span class="fa fa-star checked"></span>
		                        <span class="fa fa-star"></span>
		                    </div> -->
					</div>
				</c:if>

			</c:forEach>

		</div>

	</div>

	<!-- Row logo -->
	<div class="container mt-3 mb-3 container__brand">
		<div class="row list__brand">
			<c:forEach items="${ thuongHieus }" var="thuongHieu"
				varStatus="counter">
				<c:if test="${ counter.count <= 4 }">
					<a
						href="<c:url value="/danh-sach-san-pham/${ thuongHieu.id }?page=1"/>">
						<img class="brand--img"
						src="data:image/jpg;base64,${thuongHieu.hinhAnhBase64}"
						alt="${ thuongHieu.tenThuongHieu }" alt="">
					</a>

				</c:if>
			</c:forEach>

		</div>
	</div>


	<!-- Sản phẩm bán chạy -->

	<div class="container mt-2 best_sell_product">

		<!-- Chổ này load lên 5 10 hoặc 15 sản phẩm cho nó full dòng -->
		<h2 class="product__title">SẢN PHẨM BÁN CHẠY</h2>

		<div class="row pl-0 pr-0 list__product--sell">
			<c:forEach items="${ sanPhamBanChays }" var="sanPhamBanChay"
				varStatus="counter">
				<c:if test="${ counter.count > 5 }">
					<div class="product"
						onclick="location.href = '/WebsiteBanNhacCu/san-pham?id=${sanPhamBanChay.id}'">
						<div class="product__img">
							<img
								src="data:image/jpg;base64,${ sanPhamBanChay.hinhAnhBase64 }"
								alt="">
						</div>
						<p class="product__name">
							<b>${ sanPhamBanChay.tenSanPham }</b>
						</p>

						<div class="additional">
							<p>
								Thương hiệu: <b>${ sanPhamBanChay.tenThuongHieu }</b>
							</p>
							<p>
								Xuất xứ: <b>${ sanPhamBanChay.xuatXu }</b>
							</p>
						</div>

						<p class="money">
							<fmt:formatNumber type="currency"
								value="${ sanPhamBanChay.giaBan }" currencySymbol="" />
							VNĐ
						</p>
					</div>
				</c:if>

			</c:forEach>

		</div>

		<!-- ------------------------ -->

		<c:forEach items="${ sanPhamLoaiSanPham }" var="map">
			<div class="container mt-3 mb-2 product__options highlight">

				<div class="row">
					<h2 class="product__title__slider">${ map.key }</h2>
					<div class="product__list--wrapper">
						<div class="product__option__list">

							<c:forEach items="${ map.value }" var="sanPhamDTO">
								<div class="option__item"
									onclick="location.href = '/WebsiteBanNhacCu/san-pham?id=${sanPhamDTO.id}'">
									<div class="option__item__img">
										<img src="data:image/jpg;base64,${ sanPhamDTO.hinhAnhBase64 }"
											alt="">
									</div>
									<p class="option__item__name">
										<b>${ sanPhamDTO.tenSanPham }</b>
									</p>

									<div class="option__item__additional">
										<p>
											Thương hiệu: <b>${ sanPhamDTO.tenThuongHieu }</b>
										</p>
										<p>
											Xuất xứ: <b>${ sanPhamDTO.xuatXu }</b>
										</p>
									</div>
									<p class="option__item__money">
										<fmt:formatNumber type="currency"
											value="${ sanPhamDTO.giaBan }" currencySymbol="" />
										VNĐ
									</p>
								</div>

							</c:forEach>

						</div>
						<i class="fas fa-chevron-right move arrow"></i> <i
							class="fas fa-chevron-left move arrow--left"></i>

					</div>

				</div>

			</div>


		</c:forEach>

	</div>
	
	<script src="<c:url value="/static/assets/js/index_page/Slider.js"/>"></script>
</body>
</html>