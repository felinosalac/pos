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

		<h1>All products</h1>
		<spring:url value="/admin/products/search" var="searchUrl" />
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>product ID</th>
					<th>Name</th>
					<!-- <th>Address</th>
					<th>Contact Person</th>
					<th>Phone #</th>
					<th>Fax #</th>
					<th>Discount</th>
					<th>Action</th> -->
				</tr>
			</thead>
			<form id="searchForm" class="form-horizontal" method="GET" action="${searchUrl}">
			<tr id="searchRow" >
				<td><input name='id' id='id' type="text" class="form-control" placeholder="Customer Id" value="${id}"></td>
				<td><input name='productName'  id='productName' type="text" class="form-control" placeholder="Product Name"  value="${productName}"></td>
				<%-- <td><input name='address' id='address'type="text" class="form-control" placeholder="Address" value="${address}"></td>
				<td><input name='contactPersonName'  id='contactPersonName' type="text" class="form-control" placeholder="Contact Person" value="${contactPersonName}"></td>
				<td><input name='phonePrimary' id='phonePrimary' type="number" class="form-control" placeholder="Phone" value="${phonePrimary}"></td>
				<td><input name='fax' id='fax' type="text" class="form-control" placeholder="Fax" value="${fax}"></td>
				<td><input name='discount' id='discount' type="text" class="form-control" placeholder="Discount" value="${discount}"></td>
 --%>				<td>
					<button class="btn" onclick="search()">
						<i class="glyphicon glyphicon-search"></i>
						Search
					</button>
					<spring:url value="/admin/products" var="showAllproducts" />
					<button class="btn btn-danger" onclick="clearSearch()">
						<i class="glyphicon glyphicon-search"></i>
						Clear
					</button>
				</td>
			</tr>
			</form>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<%-- <td>${product.address}</td>
					<td>${product.contactPersonName}</td>
					<td>${product.phonePrimary}</td>
					<td>${product.fax}</td>
					<td>${product.discount}</td> --%>
					<td>
						<spring:url value="/admin/products/${product.id}" var="productUrl" />
						<spring:url value="/admin/products/${product.id}/delete" var="deleteUrl" /> 
						<spring:url value="/admin/products/${product.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${productUrl}'">View</button>
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
		<%-- <spring:url value="/admin/orders/add" var="addOrderUrl"/> --%>
		<spring:url value="/admin/products/add" var="addProductUrl" />
		<button type="button" class="btn" onclick="location.href='${addProductUrl}'">Add Product</button>
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
		$('#name').val("");
		$('#address').val("");
		$('#contactPersonName').val("");
		$('#phonePrimary').val("");
		$('#fax').val("");
		$('#discount').val("");
		$("searchForm").submit();
	}
	</script>
	<jsp:include page="../fragments/footer.jsp" />
</body>
</html>