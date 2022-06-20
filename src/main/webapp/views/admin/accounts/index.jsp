<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/SOF3021_ASM/css/bootstrap.min.css">
</head>
<body>
	<div class="table-responsive col-10 offset-1">
	<h2>Accounts Manage</h2>
		<a class="btn btn-success"
			href="/SOF3021_ASM/admin/accounts/create">
			Add New
		</a>
		<table class="table">
			<thead>
			<tr>
				<th>ID</th>
				<th>Full name</th>
				<th>User name</th>
				<th>Email</th>
				<th>Photo</th>
				<th>Activated</th>
				<th>Role</th>
				<th colspan="2">Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ data.content }" var="acc">
				<tr>
					<td>${ acc.id }</td>
					<td>${ acc.fullname }</td>
					<td>${ acc.username }</td>
					<td>${ acc.email }</td>
					<td>
						<img src="${ acc.photo }" />
					</td>
					<td>${ acc.activated == 0 ? "In-Active" : "Active" }</td>
					<td>${ acc.admin == 1 ? "Admin" : "Member" }</td>
					<td>
						<a class="btn btn-primary"
							href="/SOF3021_ASM/admin/accounts/edit/${ acc.id }"
						>
							Update
						</a>
					</td>
					<td class="">
					<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal_delete_${ acc.id }">
						Delete
					</button>
						<div class="modal fade" id="modal_delete_${ acc.id }"
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
										<a type="button" class="btn btn-danger" href="/SOF3021_ASM/admin/accounts/delete/${ acc.id }">Delete</a>
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
			<c:forEach var="index" begin="0" end="${ data.totalPages - 1 }">
				<li class="page-item">
					<a class="page-link"
						href="/SOF3021_ASM/admin/accounts/index?page=${ index }">${ index + 1 }</a>
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