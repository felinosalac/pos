<%@ include file="../resources.jsp"%>
<!-- Customers Modal -->
<div id="customerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="customerModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <%-- <img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-responsive"> --%>
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
						<%-- <spring:url value="/admin/products/${supplier.id}" var="productUrl" /> --%>
						<button class="btn btn-info" >Select</button>
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
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#customerModal" data-keyboard="false" data-backdrop="static" >Close</button>
        </div>
    </div>
  </div>
</div>


<!-- Modal Dialog -->
<!-- <div class="modal fade" id="confirmDelete" role="dialog" aria-labelledby="confirmDeleteLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Delete Parmanently</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure about this ?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-danger" id="confirm">Delete</button>
      </div>
    </div>
  </div>
</div> -->
