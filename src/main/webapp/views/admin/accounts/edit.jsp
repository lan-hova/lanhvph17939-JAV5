<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Account</title>
<link rel="stylesheet" href="/SOF3021_ASM/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>
<body>
	<form:form action="/SOF3021_ASM/admin/accounts/update/${acc.id}" method="POST" modelAttribute="acc">
	<div class="border">
		<h1>Cập nhật thông tin</h1>
		<div class="col mt-3">
			<label for="fullname">Fullname</label>
			<form:input class="form-control" path="fullname" />
		</div>
		<div class="col mt-3">
			<label for="email">Email</label>
			<form:input class="form-control" path="email" type="email" />
		</div>
		<div class="col mt-3">
			<label for="username">Username</label>
			<form:input class="form-control" path="username" />
		</div>
		<div class="col mt-3">
			<label for="password">Password</label>
			<form:password class="form-control" path="password" />
		</div>
		<div class="col mt-3">
			<label for="photo">Photo</label>
			<form:input class="form-control" path="photo" />
		</div>
		<div class="row">
		<div  class="col mt-3">
			<label>Activated</label> 
				<div class="col form-check">
					<input class="form-check-input" type="radio" name="activated"
					value="1" ${acc.activated == 1 ? "checked" : ""}> 
						<label class="form-check-label">Active</label>
				</div>
				<div class="col form-check">
					<input class="form-check-input" type="radio" name="activated" 
					value="0" ${acc.activated == 0 ? "checked" : ""}> 
						<label class="form-check-label">In-Active</label>
				</div>
		</div>
		<div class="col mt-3">
			<label>Admin</label>
			<form:select path="admin">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		</div>
		</div>
		<br>
		<div>
			<button class="btn btn-primary">Update</button>
		</div>
	</form:form>
	
	<script src="/SOF3021_ASM/js/jquery.min.js"></script>
	<script src="/SOF3021_ASM/js/popper.min.js"></script>
	<script src="/SOF3021_ASM/js/bootstrap.min.js"></script>
</body>

</html>