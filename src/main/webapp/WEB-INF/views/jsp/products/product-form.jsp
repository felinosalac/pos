<%@ page session="false"%>
<%@ include file="../resources.jsp"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${product['new']}">
			<h1>Add product</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Add product</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/admin/products/add" var="productActionUrl" />
	<form:form class="form-horizontal" method="post" modelAttribute="product" action="${productActionUrl}">

		<%-- <form:hidden path="id" /> --%>
		
		<spring:bind path="id">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">ID</label>
				<div class="col-sm-10">
					<form:input path="id" type="text" class="form-control " id="id" placeholder="" readonly="true"/>
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="productName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Product Name</label>
				<div class="col-sm-10">
					<form:input path="productName" type="text" class="form-control " id="productName" placeholder="Product Name" required="required"/>
					<form:errors path="productName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="supplier">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Supplier</label>
				<div class="col-sm-5">
					<form:select path="supplier" class="form-control" multiple="false">
						<form:option value="-" label="--Please Select--"/>
						<form:options items="${suppliers}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="supplier" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>
		
		<%-- <spring:bind path="address">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:textarea path="address" class="form-control " id="address" placeholder="Address" required="required"/>
					<form:errors path="address" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="contactPersonName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Contact Person Name</label>
				<div class="col-sm-10">
					<form:input path="contactPersonName" type="text" class="form-control " id="contactPersonName" placeholder="Contact Person Name" required="required"/>
					<form:errors path="contactPersonName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="phonePrimary">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Phone Number</label>
				<div class="col-sm-10">
					<form:input path="phonePrimary" type="text" class="form-control " id="phonePrimary" placeholder="Phone Number" required="required"/>
					<form:errors path="phonePrimary" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="fax">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Fax</label>
				<div class="col-sm-10">
					<form:input path="fax" type="text" class="form-control " id="fax" placeholder="Fax" required="required"/>
					<form:errors path="fax" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="discount">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Discount</label>
				<div class="col-sm-10">
					<form:input path="discount" type="text" class="form-control " id="discount" placeholder="Discount" required="required"/>
					<form:errors path="discount" class="control-label" />
				</div>
			</div>
		</spring:bind>
		 --%>
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
</div>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <%-- <img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-responsive"> --%>
            Test Modal!
            <table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Supplier ID</th>
					<th>Name</th>
				</tr>
			</thead>
			<form id="searchForm" class="form-horizontal" method="GET" action="${searchUrl}">
			<tr id="searchRow" >
				<td><input name='id' id='id' type="text" class="form-control" placeholder="Supplier Id" value="${id}"></td>
				<td><input name='name'  id='name' type="text" class="form-control" placeholder="Name"  value="${productName}"></td>
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
			<c:forEach var="supplier" items="${suppliers}">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>
						<%-- <spring:url value="/admin/products/${supplier.id}" var="productUrl" /> --%>
						<button class="btn btn-info" onclick="location.href='${productUrl}'">Select</button>
					</td>
				</tr>
			</c:forEach>
		</table>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-keyboard="false" data-backdrop="static" >Close</button>
        </div>
    </div>
  </div>
</div>

<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-keyboard="false" data-backdrop="static" >View Image</button>
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
	

/* 	$('#myModal').modal({
	    backdrop: 'static',
	    keyboard: false
	}); */
	
</script>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>