<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/SOF3021_ASM/css/bootstrap.min.css">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/SOF3021_ASM/admin/products/update/${pro.id}" method="POST" modelAttribute="pro">
		
			<div>
				<label class="label-control mt-1">Name</label> 
				<form:input class="form-control" path="name" name="name" />
				<form:errors path="name"/>
			</div>
			<div>
				<label class="label-control mt-1">Image</label> 
				<input type="file" name="image" class="form-control" value="${ pro.image }" /> 
			</div>
			<div>
				<label class="label-control mt-1">Price</label> 
				<form:input class="form-control" path="price" name="price" />
			</div>
			<div>
			<label class="label-control mt-1">CategoryID</label>
			<form:select class="form-select" path="categories.id"> 
					<form:options items="${dsCategory}" itemValue="id" itemLabel="name" />
			</form:select> 
			</div>

			
			<div  class="col mt-3">
			<label class="label-control mt-1">Available</label> 
				<div class="col form-check">
					<input class="form-check-input" type="radio" name="available"
					value="1" ${pro.available == 1 ? "checked" : ""}> 
						<label class="form-check-label">Available</label>
				</div>
				<div class="col form-check">
					<input class="form-check-input" type="radio" name="available" 
					value="0" ${pro.available == 0 ? "checked" : ""}> 
						<label class="form-check-label">Unavailable</label>
				</div>
			</div>
			
		<div>
			<button class="btn btn-primary">Update</button>
		</div>
	</form:form>
	
	<script src="/SOF3021_ASM/js/jquery.min.js"></script>
	<script src="/SOF3021_ASM/js/popper.min.js"></script>
	<script src="/SOF3021_ASM/js/bootstrap.min.js"></script>
</body>
</html>