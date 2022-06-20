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
	<form:form action="/SOF3021_ASM/admin/orders/store"
	method="post" modelAttribute="order">
			<div>
				<label>Account ID</label>
				<form:select path="accounts" class="form-select">
					<c:forEach items="${ dsAcc }" var="acc">
						<form:option value="${ acc.id }">
							${ acc.fullname }
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<label>Shipping address</label>
				<form:input path="address" class="form-control" />
				<form:errors path="address"/>
			</div>
<%-- 			<div>
				<label>Order date</label>
				<form:input path="createDate" type="date"
					class="form-control" />
			</div> --%>
			
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