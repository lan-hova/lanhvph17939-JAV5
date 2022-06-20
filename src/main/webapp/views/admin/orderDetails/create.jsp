<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/SOF3021_ASM/css/bootstrap.min.css">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<form:form action="/SOF3021_ASM/admin/orderDetails/store"
	method="post" modelAttribute="ods">
			<div>
				<label>Order ID</label>
				<form:select path="orders" class="form-select">
					<c:forEach items="${ dsOrder }" var="ord">
						<form:option value="${ ord.id }">
							${ ord.id }
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<label>Product ID</label>
				<form:select path="products.id" class="form-select">
						<form:options items="${ dsProduct }" itemValue="id" itemLabel="name"/>
				</form:select>
			</div>
			<div>
				<label>Price</label>
				<form:input path="price" class="form-control" />
			</div>
			<div>
				<label>Quantity</label>
				<form:input path="quantity" class="form-control" />
			</div>
			
			<br>
			<div class="mt-3">
				<button class="btn btn-primary">Thêm mới</button>
			</div>
	</form:form>	
	
	<script src="/SOF3021_ASM/js/jquery.min.js"></script>
	<script src="/SOF3021_ASM/js/popper.min.js"></script>
	<script src="/SOF3021_ASM/js/bootstrap.min.js"></script>
</body>
</html>