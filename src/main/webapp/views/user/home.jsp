<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>FFruit Shop</title>
	<!-- favicon -->
	<link rel="shortcut icon" type="image/png" href="/SOF3021_ASM/assets/img/favicon.png">
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
	<!-- fontawesome -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/css/all.min.css">
	<!-- bootstrap -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/bootstrap/css/bootstrap.min.css">
	<!-- owl carousel -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/css/owl.carousel.css">
	<!-- magnific popup -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/css/magnific-popup.css">
	<!-- animate css -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/css/animate.css">
	<!-- mean menu css -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/css/meanmenu.min.css">
	<!-- main style -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/css/main.css">
	<!-- responsive -->
	<link rel="stylesheet" href="/SOF3021_ASM/assets/css/responsive.css">
</head>
<body>
	
	<!-- header -->
	<div class="top-header-area" id="sticker">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12 text-center">
					<div class="main-menu-wrap">
						<!-- logo -->
						<div class="site-logo">
							<a href="/SOF3021_ASM/home">
								<img src="assets/img/favicon.png" alt=""> 
								<h5 class="text-warning">FFruit Shop</h5> 
							</a>
						</div>
						<!-- logo -->

						<!-- menu start -->
						<nav class="main-menu">
							<ul>
								<li class="current-list-item"><a href="#">Home</a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">Pages</a></li>
								<li><a href="#">News</a></li>
								<li><a href="#">Contact</a></li>
								<c:if test="${!empty sessionScope.login}">
									<li>
										<div class="header-icons">
											<a class="shopping-cart" href="#">
											<i class="fas fa-shopping-cart"></i></a>
										</div>
									</li>
								</c:if>

								<li>
									<div class="header-icons">
										<a class="mobile-hide " href="#"><i class="fas fa-user"></i></a>
									</div>
									<ul class="sub-menu">
									<c:if test="${empty sessionScope.login}">
										<li><a href="login">Login</a></li>
									</c:if>
									<c:if test="${!empty sessionScope.login && sessionScope.login.admin == 1}">
										<li><a href="/SOF3021_ASM/admin/layout/admin">Manage</a></li>
									</c:if>
									<c:if test="${!empty sessionScope.login}">
										<li><a href="logout">Logout</a></li>
									</c:if>
										
									</ul>
								</li>
								
							</ul>
						</nav>
						<a class="mobile-show" href="#"><i class="fas fa-user"></i></a>
						<div class="mobile-menu"></div>
						<!-- menu end -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end header -->

	<!-- hero area -->
	<div class="hero-area hero-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-9 offset-lg-2 text-center">
					<div class="hero-text">
						<div class="hero-text-tablecell">
							<p class="subtitle">Fresh & Organic</p>
							<h1>Delicious Seasonal Fruits</h1>
							<div class="hero-btns">
								<a href="#" class="boxed-btn">Fruit Collection</a>
								<a href="#" class="bordered-btn">Contact Us</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end hero area -->

	<!-- features list section -->
	<div class="list-section pt-80 pb-80">
		<div class="container">

			<div class="row">
				<div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
					<div class="list-box d-flex align-items-center">
						<div class="list-icon">
							<i class="fas fa-shipping-fast"></i>
						</div>
						<div class="content">
							<h3>Free Shipping</h3>
							<p>When order over $75</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
					<div class="list-box d-flex align-items-center">
						<div class="list-icon">
							<i class="fas fa-phone-volume"></i>
						</div>
						<div class="content">
							<h3>24/7 Support</h3>
							<p>Get support all day</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="list-box d-flex justify-content-start align-items-center">
						<div class="list-icon">
							<i class="fas fa-sync"></i>
						</div>
						<div class="content">
							<h3>Refund</h3>
							<p>Get refund within 3 days!</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- end features list section -->

	<!-- product section -->
	<div class="product-section mt-150 mb-150">
		<div class="container">
				<div class="row">
					<jsp:include page="${ viewhome }"></jsp:include>
				</div>
			</div>
	</div>
	<!-- end product section -->

	<!-- logo carousel -->
	<div class="logo-carousel-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="logo-carousel-inner">
						<div class="single-logo-item">
							<img src="assets/img/company-logos/1.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="assets/img/company-logos/2.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="assets/img/company-logos/3.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="assets/img/company-logos/4.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="assets/img/company-logos/5.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end logo carousel -->

	<!-- footer -->
	<div class="footer-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="footer-box about-widget">
						<h2 class="widget-title">About us</h2>
						<p>A fresh fruit shop</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="footer-box get-in-touch">
						<h2 class="widget-title">Get in Touch</h2>
						<ul>
							<li>58/23 Tran Binh, Mai Dich, Cau Giay, Ha Noi</li>
							<li>lanhvph17939@fpt.edu.vn</li>
							<li>+84 3344 07 886</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="footer-box pages">
						<h2 class="widget-title">Pages</h2>
						<ul>
							<li><a href="#">Home</a></li>
							<li><a href="#">About</a></li>
							<li><a href="#">Shop</a></li>
							<li><a href="#">News</a></li>
							<li><a href="#">Contact</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="footer-box subscribe">
						<h2 class="widget-title">Subscribe</h2>
						<p>Subscribe to our mailing list to get the latest updates.</p>
						<form action="#">
							<input type="email" placeholder="Email">
							<button type="submit"><i class="fas fa-paper-plane"></i></button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end footer -->
	
	
	<!-- jquery -->
	<script src="/SOF3021_ASM/assets/js/jquery-1.11.3.min.js"></script>
	<!-- bootstrap -->
	<script src="/SOF3021_ASM/assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- count down -->
	<script src="/SOF3021_ASM/assets/js/jquery.countdown.js"></script>
	<!-- isotope -->
	<script src="/SOF3021_ASM/assets/js/jquery.isotope-3.0.6.min.js"></script>
	<!-- waypoints -->
	<script src="/SOF3021_ASM/assets/js/waypoints.js"></script>
	<!-- owl carousel -->
	<script src="/SOF3021_ASM/assets/js/owl.carousel.min.js"></script>
	<!-- magnific popup -->
	<script src="/SOF3021_ASM/assets/js/jquery.magnific-popup.min.js"></script>
	<!-- mean menu -->
	<script src="/SOF3021_ASM/assets/js/jquery.meanmenu.min.js"></script>
	<!-- sticker js -->
	<script src="/SOF3021_ASM/assets/js/sticker.js"></script>
	<!-- main js -->
	<script src="/SOF3021_ASM/assets/js/main.js"></script>

</body>
</html>