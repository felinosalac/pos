<%@ include file="../resources.jsp"%>
<!-- Product Modal -->
<div id="productModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="productModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <%-- <img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-responsive"> --%>
            Product Modal!
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
						<%-- <spring:url value="/admin/products/${supplier.id}" var="productUrl" /> --%>
						<button class="btn btn-info" onclick="addOrder('${product.id}',1)">Select</button>
					</td>
				</tr>
			</c:forEach>
		</table>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#productModal" data-keyboard="false" data-backdrop="static" >Close</button>
        </div>
    </div>
  </div>
</div>

<script>
function addOrder(productId, customerId){
	//alert(customerId + ' order will be added! ' + productId);
	//alert("add/" + productId + "/" + customerId + "?_csrf=${_csrf.token}");
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "add/" + productId + "/" + customerId + "?_csrf=${_csrf.token}",
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			/* $('#confirmDelete').modal('hide');
			$('#deleteConfirmationModal').modal('toggle'); */
			
			/* what  i have to put here to updte my table <table id="table_grid"> */
			/* $.each(data.orders,function(key, order) {
	            var htmlrow ="<tr><td>" + order.id + "</td><td>" + order.productName + "</td><td>button</td></tr>";         
	            $('#ordersTable').append(htmlrow);
	        }); */
	        
			window.location.reload(true);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			alert(e);
		}
	}).done(function(e) {
		console.log("DONE");
	});
	
	
	$('#productModal').modal('toggle');
}
</script>