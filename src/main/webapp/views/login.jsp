<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập</title>
    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="/SOF3021_ASM/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="/SOF3021_ASM/css/signin.css" rel="stylesheet">
  
</head>
<body class="text-center">


	<main class="form-signin border rounded-3 border-primary">
		<form:form method="POST" action="/SOF3021_ASM/xnlogin" modelAttribute="login">
		<img class="mb-4" src="/SOF3021_ASM/images/shop.svg" alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-bold fst-italic text-secondary">Poly Fashion</h1>

 	<c:if test="${ !empty sessionScope.messageLg}">
		<div class="alert alert-danger">${sessionScope.messageLg}</div>
		<c:remove var="messageLg" scope="session"></c:remove>
	</c:if> 

			<div class="form-floating">
				<form:input class="form-control" path="email" name="email"
					id="floatingInput" placeholder="name@example.com"/> 
					<label for="floatingInput">Email address</label>
					<form:errors path="email"/>
			</div>
			<div class="form-floating">
				<form:input type="password" class="form-control" path="password" name="password"
					id="floatingPassword" placeholder="Password"/> 
					<label for="floatingPassword">Password</label>
					<form:errors path="password"/>
			</div>

<%-- 			<div class="checkbox mb-3">
				<label> <form:input path="" type="checkbox" value="remember-me"/>
					Remember me
				</label>
			</div> --%>
			<button class="w-100 btn btn-lg btn-primary" type="submit">
			Đăng nhập
			</button>
		</form:form>
	</main>

	<script src="/SOF3021_ASM/js/jquery.min.js"></script>
	<script src="/SOF3021_ASM/js/popper.min.js"></script>
	<script src="/SOF3021_ASM/js/bootstrap.min.js"></script>
</body>
</html>