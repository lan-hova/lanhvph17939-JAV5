<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>IT16309 - QL Category</title>
<link rel="stylesheet" href="/SOF3021_ASM/css/bootstrap.min.css">
</head>
<body>
	<div class="table-responsive col-10 offset-1">
	<h2>Products Manage</h2>
		<a class="btn btn-success"
			href="/SOF3021_ASM/admin/products/create">
			Add New
		</a>
		<table class="table">
			<thead>
			<tr>
				<th>ID</th>
				<th>Image</th>
				<th>Name</th>
				<th>Price</th>
				<th>Created Date</th>
				<th>Category</th>
				<th>Available</th>
				
				<th colspan="2">Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ dataPro.content }" var="pro">
				<tr>
					<td>${ pro.id }</td>
					<td>${ pro.image }</td>
					<td>${ pro.name }</td>
					<td>${ pro.price }</td>
					<td ><fmt:formatDate value="${ pro.createdDate }" pattern="dd/MM/yyyy"/> </td>
					<td>${ pro.categories.name }</td>
					<td>${ pro.available == 0 ? "False" : "True" } </td>
					<td>
						<a class="btn btn-primary"
							href="/SOF3021_ASM/admin/products/edit/${ pro.id }">
							Update
						</a>
					</td>
					<td class="">
					<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal_delete_${ pro.id }">
						Delete
					</button>
						<div class="modal fade" id="modal_delete_${ pro.id }"
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
										<a type="button" class="btn btn-danger" href="/SOF3021_ASM/admin/products/delete/${ pro.id }">Delete</a>
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
			<c:forEach var="index" begin="0" end="${ dataPro.totalPages - 1 }">
				<li class="page-item">
					<a class="page-link"
						href="/SOF3021_ASM/admin/products/index?page=${ index }">${ index + 1 }</a>
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