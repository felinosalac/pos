<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />
<body>

	<div class="container" style="width: 90%">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Dealers</h1>
		<spring:url value="/admin/customers/search" var="searctUrl" />
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number</th>
					<th>Maximum Credit Line</th>
					<th>Credit Term</th>
					<th>Registration Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<form id="searchForm" class="form-horizontal" method="GET" action="${searctUrl}">
			<tr id="searchRow" >
				<td><input name='id' id='id' type="text" class="form-control" placeholder="Customer Id" value="${id}"></td>
				<td><input name='firstName'  id='firstName' type="text" class="form-control" placeholder="First Name"  value="${firstName}"></td>
				<td><input name='lastName' id='lastName'type="text" class="form-control" placeholder="Last Name" value="${lastName}"></td>
				<td><input name='phoneNumber'  id='phoneNumber' type="text" class="form-control" placeholder="Phone Number" value="${phoneNumber}"></td>
				<td><input name='maximumCreditLine' id='maximumCreditLine' type="number" class="form-control" placeholder="Credit Line" value="${maximumCreditLine}"></td>
				<td><input name='creditTerm' id='creditTerm' type="text" class="form-control" placeholder="Credit Term" value="${creditTerm}"></td>
				<td><input name='registrationDate' id='registrationDate' type="text" class="form-control" placeholder="Registration Date" value="${registrationDate}"></td>
				<td>
					<button class="btn" onclick="search()">
						<i class="glyphicon glyphicon-search"></i>
						Search
					</button>
					<spring:url value="/admin/customers" var="showAllCustomers" />
					<button class="btn btn-danger" onclick="clearSearch()">
						<i class="glyphicon glyphicon-search"></i>
						Clear
					</button>
				</td>
			</tr>
			</form>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.phoneNumber}</td>
					<td>${customer.maximumCreditLine}</td>
					<td>
					<c:choose>
						<c:when test="${customer.creditTerm == 1}">
            				Cash
         				</c:when> 
         				<c:otherwise>
           					Credit
         				</c:otherwise>
         			</c:choose>
					</td>
					<td>
						<fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${customer.registrationDate}" />
					</td>
					<td>
						<spring:url value="/admin/customers/${customer.id}" var="customerUrl" />
						<spring:url value="/admin/users/${user.id}/delete" var="deleteUrl" /> 
						<spring:url value="/admin/customers/${customer.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${customerUrl}'">View</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" type="button" 
								data-toggle="modal" 
								data-url="${deleteUrl}"
								data-target="#confirmDelete" 
								data-title="Delete User" 
								data-message="Are you sure you want to delete this user?">
	        				<i class="glyphicon glyphicon-trash"></i> Delete
	    				</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<spring:url value="/admin/customers/add" var="urlAddCustomer" />
		<button type="button" class="btn" onclick="location.href='${urlAddCustomer}'">Add Customer</button>
	</div>
	<script>
	function search(){
		$("searchForm").submit();
		  /* var searchCriteria = JSON.stringify({
			    "id": $('#id').val(), 
			    "firstName":$('#firstName').val()});
		  console.log( searchCriteria );
		  
		  location.href = "${home}/admin/customers?id" + $('#id').val(); */
		 // return false; 
		  
		}
	
	function clearSearch(){
		$('#id').val("");
		$('#firstName').val("");
		$('#lastName').val("");
		$('#phoneNumber').val("");
		$('#maximumCreditLine').val("");
		$('#creditTerm').val("");
		$('#registrationDate').val("");
		$("searchForm").submit();
	}
	</script>
	<jsp:include page="../fragments/footer.jsp" />
</body>
</html>