<%@ page session="false"%>
<%@ include file="../resources.jsp"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${product['new']}">
			<h1>Add Order</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Order</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/admin/orders/add" var="orderActionUrl" />
	<form:form class="form-horizontal" method="post" modelAttribute="order" action="${orderActionUrl}">

		<%-- <form:hidden path="id" /> --%>
		
		<spring:bind path="id">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">ID</label>
				<div class="col-sm-10">
					<form:input path="id" type="text" class="form-control " id="id" placeholder="" readonly="true"/>
				</div>
			</div>
		</spring:bind>
		
		<!-- Orders -->
		<table class="table table-striped table-hover" id="ordersTable">
			<c:forEach var="order" items="${orders}">
				<tr>
					<td>${order.id}</td>
					<td>${order.productName}</td>
					<td>${order.productName}</td>
					<td>
						<%-- <spring:url value="/admin/products/${supplier.id}" var="productUrl" /> --%>
						<button class="btn btn-info"
							onclick="location.href='${productUrl}'">Select</button>
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${product['new']}">
						<button type="submit" class="btn btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>		
	</form:form>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#customerModal" data-keyboard="false" data-backdrop="static" >Choose Customer</button>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#productModal" data-keyboard="false" data-backdrop="static" >Choose Product</button>
</div>
<%-- 
<!-- Customers Modal -->
<div id="customerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="customerModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-responsive">
            Customer Modal!
            <table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>Name</th>
				</tr>
			</thead>
			<form id="searchForm" class="form-horizontal" method="GET" action="${searchUrl}">
			<tr id="searchRow" >
				<td><input name='id' id='id' type="text" class="form-control" placeholder="Id" value="${id}"></td>
				<td><input name='name'  id='name' type="text" class="form-control" placeholder="Last Name"  value="${productName}"></td>
				<td>
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
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.lastName}</td>
					<td>
						<spring:url value="/admin/products/${supplier.id}" var="productUrl" />
						<button class="btn btn-info" onclick="location.href='${productUrl}'">Select</button>
					</td>
				</tr>
			</c:forEach>
		</table>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#customerModal" data-keyboard="false" data-backdrop="static" >Close</button>
        </div>
    </div>
  </div>
</div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#customerModal" data-keyboard="false" data-backdrop="static" >Choose Customer</button>


<!-- Product Modal -->
<div id="productModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="productModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-responsive">
            Customer Modal!
            <table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Name</th>
				</tr>
			</thead>
			<form id="searchForm" class="form-horizontal" method="GET" action="${searchUrl}">
			<tr id="searchRow" >
				<td><input name='id' id='id' type="text" class="form-control" placeholder="Id" value="${id}"></td>
				<td><input name='name'  id='name' type="text" class="form-control" placeholder="Last Name"  value="${productName}"></td>
				<td>
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
					<td>
						<spring:url value="/admin/products/${supplier.id}" var="productUrl" />
						<button class="btn btn-info" onclick="location.href='${productUrl}'">Select</button>
					</td>
				</tr>
			</c:forEach>
		</table>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#productModal" data-keyboard="false" data-backdrop="static" >Close</button>
        </div>
    </div>
  </div>
</div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#productModal" data-keyboard="false" data-backdrop="static" >Choose Product</button>
 --%>
 
<jsp:include page="customers-modal.jsp" />
<jsp:include page="products-modal.jsp" />

<script>

	$(document).ready(function() {
		/* $("#registrationDate").datepicker({
			dateFormat : "yy-mm-dd"
		}); */
	});
	
	function centerModal() {
		$(this).css('display', 'block');
		var $dialog = $(this).find(".modal-dialog");
		var offset = ($(window).height() - $dialog.height()) / 2;
		// Center modal vertically in window
		$dialog.css("margin-top", offset);
	}
	

/* 	$('#customerModal').modal({
	    backdrop: 'static',
	    keyboard: false
	}); */
	
</script>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>