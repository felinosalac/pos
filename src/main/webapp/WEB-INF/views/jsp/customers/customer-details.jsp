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

	<h1>Customer Detail</h1>
	<br />
	
	<div class="row">
			<div class="col-sm-10">
				<c:if test="${not empty customer.profilePicture}">
					<img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-rounded" alt="Cinque Terre" width="304" height="236"/>
				</c:if>
				<c:if test="${empty customer.profilePicture}">
					<img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-rounded" alt="Cinque Terre" width="304" height="236"/>
				</c:if>
				<br/>
				<div>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">View Image</button>
				</div>
			</div>
			<label class="col-sm-2"></label>
		</div>
	
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${customer.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Fist Name</label>
		<div class="col-sm-10">${customer.firstName}</div>
	</div>
	
	<div class="row">
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
	</div>
	
	<div class="row">
		<label class="col-sm-2">Registration Date</label>
		<div class="col-sm-10">${customer.registrationDate}</div>
	</div>
	<spring:url value="/admin/customers/${customer.id}/update" var="updateUrl" />
	<button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
	
	<spring:url value="/admin/customers" var="customerListUrl" />
	<button class="btn btn-info" onclick="location.href='${customerListUrl}'">Go Back to Customer List</button>
	
</div>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-responsive">
        </div>
    </div>
  </div>
</div>

<jsp:include page="../fragments/footer.jsp" />

<script>
	function centerModal() {
		$(this).css('display', 'block');
		var $dialog = $(this).find(".modal-dialog");
		var offset = ($(window).height() - $dialog.height()) / 2;
		// Center modal vertically in window
		$dialog.css("margin-top", offset);
	}
</script>
</body>
</html>