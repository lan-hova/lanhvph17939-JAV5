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
<form:form method="POST" action="/SOF3021_ASM/admin/products/store"
		modelAttribute="pro">
	<h2 class="text-center">Thêm sản phẩm</h2>
		<div>
			<label class="form-label" for="name">Name</label>
			<form:input type="text" path="name" name="name" class="form-control"	/> 
			<form:errors path="name"/>
		</div>
		<div>
			<label class="form-label">Image</label>
			<input type="file" name="image" class="form-control" /> 
		</div>
		<div>
			<label class="form-label">Price</label>
			<form:input type="number" path="price" name="price" class="form-control"	/> 
		</div>
		<div>
			<label class="form-label">Category Id</label>
			<form:select class="form-select" path="categories.id">
					<form:options items="${dsCategory}" itemValue="id" itemLabel="name" />
			</form:select>
		</div>
		
		<div class="mt-3">
			<button class="btn btn-primary">Thêm mới</button>
		</div>	
</form:form>

	<script src="/SOF3021_ASM/js/jquery.min.js"></script>
	<script src="/SOF3021_ASM/js/popper.min.js"></script>
	<script src="/SOF3021_ASM/js/bootstrap.min.js"></script>
</body>
</html>