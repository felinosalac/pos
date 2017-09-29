<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Product Detail</h1>
	<br />
	
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${product.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Product Name</label>
		<div class="col-sm-10">${product.productName}</div>
	</div>
	
	<%-- <div class="row">
		<label class="col-sm-2">Last Name</label>
		<div class="col-sm-10">${customer.lastName}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${customer.address}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Phone Number</label>
		<div class="col-sm-10">${customer.phoneNumber}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Maximum Credit Line</label>
		<div class="col-sm-10">${customer.maximumCreditLine}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Credit Term</label>
		<div class="col-sm-10">
			<c:choose>
				<c:when test="${customer.creditTerm == 1}">
            		Cash
       			</c:when> 
     			<c:otherwise>
    				Credit
         		</c:otherwise>
         	</c:choose>
		</div>
	</div> --%>
	
	<spring:url value="/admin/products/${product.id}/update" var="updateUrl" />
	<button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
	
	<spring:url value="/admin/products" var="productListUrl" />
	<button class="btn btn-info" onclick="location.href='${productListUrl}'">Go Back to Product List</button>
	
</div>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>