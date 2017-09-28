<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />
<body>

	<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Dealers</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>
						${user.id}
					</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td><c:forEach var="role" items="${user.userRole}" varStatus="loop">
						${role.role}
    					<c:if test="${not loop.last}">,</c:if>
						</c:forEach></td>
					<td>
						<spring:url value="/admin/users/${user.id}" var="userUrl" />
						<spring:url value="/admin/users/${user.id}/delete" var="deleteUrl" /> 
						<spring:url value="/admin/users/${user.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">View</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<%-- <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> --%>
						<%-- <form method="POST" action="${deleteUrl}?_csrf=${_csrf.token}" accept-charset="UTF-8" style="display:inline"> --%>
							<button class="btn btn-danger" type="button" 
								data-toggle="modal" 
								data-url="${deleteUrl}"
								data-target="#confirmDelete" 
								data-title="Delete User" 
								data-message="Are you sure you want to delete this user?">
	        				<i class="glyphicon glyphicon-trash"></i> Delete
	    					</button>
    					<!-- </form> -->
					</td>
				</tr>
			</c:forEach>
		</table>
		<spring:url value="/admin/users/add" var="urlAddUser" />
		<button type="button" class="btn" onclick="location.href='${urlAddUser}'">Add Dealer</button>
		<%-- <a href="${urlAddUser}">Add Dealer</a> --%>
	</div>
	<jsp:include page="../fragments/delete.jsp" />
	<jsp:include page="../fragments/footer.jsp" />
</body>
</html>