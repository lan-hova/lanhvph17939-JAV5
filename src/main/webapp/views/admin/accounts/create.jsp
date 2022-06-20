<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<form:form
		method="POST"
		action="/SOF3021_ASM/admin/accounts/store"
		modelAttribute="account">
		<div>
			<label>Fullname</label>
			<form:input path="fullname" class="form-control" name="fullname" />
			<form:errors path="fullname" />
		</div>
		<div>
			<label>Email</label>
			<form:input path="email" class="form-control" type="email" />
			<form:errors path="email" />
		</div>
		<div>
			<label>Username</label>
			<form:input path="username" class="form-control" />
			<form:errors path="username" />
		</div>
		<div>
			<label>Password</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" />
		</div>
		<div>
			<label>Photo</label>
			<form:input path="photo" class="form-control" />
		</div>
		<div class="mt-3">
			<label>Admin</label>
			<form:select path="admin">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
	    <div class="mt-3">
		<button class="btn btn-primary">Save</button>
		</div>
	</form:form>