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
	<div class="table-responsive col-10 offset-1">
	<h2>OrderDetails Manage</h2>
		<a class="btn btn-success"
			href="/SOF3021_ASM/admin/orderDetails/create">
			Add New
		</a>
		<table class="table">
			<thead>
			<tr>
				<th>ID</th>
				<th>Order ID</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>
				
				<th colspan="2">Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ dataOds.content }" var="ods">
				<tr>
					<td>${ ods.id }</td>
					<td>${ ods.orders.id }</td>
					<td>${ ods.products.name }</td>
					<td>${ ods.price } </td>
					<td>${ ods.quantity } </td>
					<td>
						<a class="btn btn-primary"
							href="/SOF3021_ASM/admin/orderDetails/edit/${ ods.id }">
							Update
						</a>
					</td>
					<td class="">
					<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal_delete_${ ods.id }">
						Delete
					</button>
						<div class="modal fade" id="modal_delete_${ ods.id }"
							tabindex="-1" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">Alert</h5>
										<button type="button"
										class="btn-close"
										data-bs-dismiss="modal"
										aria-label="Close"></button>
									</div>
									<div class="modal-body">
									<h4>Do you want to delete it ?</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
										<a type="button" class="btn btn-danger" href="/SOF3021_ASM/admin/orderDetails/delete/${ ods.id }">Delete</a>
									</div>
								</div>
							</div>
						</div>
				</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<div class="row m-0">
			<ul class="pagination">
			<c:forEach var="index" begin="0" end="${ dataOds.totalPages - 1 }">
				<li class="page-item">
					<a class="page-link"
						href="/SOF3021_ASM/admin/orderDetails/index?page=${ index }">${ index + 1 }</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>

	<script src="/SOF3021_ASM/js/jquery.min.js"></script>
	<script src="/SOF3021_ASM/js/popper.min.js"></script>
	<script src="/SOF3021_ASM/js/bootstrap.min.js"></script>
</body>
</html>