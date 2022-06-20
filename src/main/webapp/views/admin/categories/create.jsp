<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/SOF3021_ASM/css/bootstrap.min.css" />
</head>
<body>
	<form:form method="POST" action="/SOF3021_ASM/admin/categories/store"
		modelAttribute="cate">
		<div>
		    <h1>Add New Category</h1>
		    <br>
			<form:label path="name">Category Name: </form:label>
			<form:input class="form-control" path="name" />
			<form:errors path="name" />
		</div>
		<div class="mt-3">
		<button class="btn btn-primary">Save</button>
		</div>

	</form:form>
	
	<script src="/SOF3021_ASM/js/jquery.min.js"></script>
	<script src="/SOF3021_ASM/js/popper.min.js"></script>
	<script src="/SOF3021_ASM/js/bootstrap.min.js"></script>
</body>
</html>