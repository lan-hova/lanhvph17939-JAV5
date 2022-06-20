<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


	<div class="col-lg-8 offset-lg-2 text-center">
		<div class="section-title">	
			<h3><span class="orange-text">Our</span> Products</h3>
			<p>Tại đây có bán nho mỹ, cherry, cam, sầu riêng, măng cụt,… phổ biến như người yêu cũ của bạn.</p>
		</div>
	</div>
	
<c:forEach items="${ lstproduct.content }" var="product" >
	<div class="col-4 text-center">
		<div class="single-product-item">
			<div class="product-image">
				<a href="single-product.html">
				<img src="/SOF3021_ASM/images/${ product.image }" alt=""></a>
			</div>
			<h3>${ product.name }</h3>
			<p class="product-price">
				${ product.price }$
			</p>
			<a href="#" class="cart-btn"><i
				class="fas fa-shopping-cart"></i> Add to Cart</a>
		</div>
	</div>
</c:forEach>

<div class="col-12">
	<ul class="pagination d-flex justify-content-center">
			<c:forEach var="index" begin="0" end="${ lstproduct.totalPages - 1 }">
				<li class="page-item">
					<a class="page-link"
						href="/SOF3021_ASM/home?page=${ index }">${ index + 1 }</a>
				</li>
			</c:forEach>
	</ul>
</div>