<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/SOF3021_ASM/admin/categories/update/${cate.id}" method="POST" modelAttribute="cate">
			<h1>Update Category</h1>
			<br>
			<label class="label-control mt-1">Name</label> 
			<form:input class="form-control" path="name" name="name" />
			<form:errors path="name"/>
		<div class="mt-3">
			<button class="btn btn-primary">Update</button>
		</div>
	</form:form>
</body>
</html>