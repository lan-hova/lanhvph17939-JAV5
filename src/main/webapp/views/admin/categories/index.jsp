<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


	<div class="table-responsive col-10 offset-1">
	<h2>Categories Manage</h2>
		<a class="btn btn-success"
			href="/SOF3021_ASM/admin/categories/create">
			Add New
		</a>
		<table class="table">
			<thead>
			<tr>
				<th>ID</th>
				<th>Category Name</th>
				<th colspan="2">Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ dataCate.content }" var="cat">
				<tr>
					<td>${ cat.id }</td>
					<td>${ cat.name }</td>
					<td>
						<a class="btn btn-primary"
							href="/SOF3021_ASM/admin/categories/edit/${ cat.id }">
							Update
						</a>
					</td>
					<td class="">
					<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal_delete_${ cat.id }">
						Delete
					</button>
						<div class="modal fade" id="modal_delete_${ cat.id }"
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
										<a type="button" class="btn btn-danger" href="/SOF3021_ASM/admin/categories/delete/${ cat.id }">Delete</a>
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
			<c:forEach var="index" begin="0" end="${ dataCate.totalPages - 1 }">
				<li class="page-item">
					<a class="page-link"
						href="/SOF3021_ASM/admin/categories/index?page=${ index }">${ index + 1 }</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>



