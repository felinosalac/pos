<%@ page session="false"%>
<%@ include file="../resources.jsp"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${customer['new']}">
			<h1>Add Customer</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Dealer</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/admin/customers/add" var="customerActionUrl" />
	<form:form class="form-horizontal" method="post" modelAttribute="customer" action="${customerActionUrl}">

		<%-- <form:hidden path="id" /> --%>
		
		<c:if test="${!customer['new']}">
		<div class="row">
			<label class="col-sm-2"></label>
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
				<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/customers/image/add?id=${customer.id}&fileType=1"/>'">Change Picture</button>
				<br/><br/>
				</div>
			</div>
		</div>
		</c:if>
		
		<spring:bind path="id">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">ID</label>
				<div class="col-sm-10">
					<form:input path="id" type="text" class="form-control " id="id" placeholder="" readonly="true"/>
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="firstName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-10">
					<form:input path="firstName" type="text" class="form-control " id="firstName" placeholder="First Name" required="required"/>
					<form:errors path="firstName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="lastName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-10">
					<form:input path="lastName" type="text" class="form-control " id="lastName" placeholder="Last Name" required="required"/>
					<form:errors path="lastName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		
		<spring:bind path="address">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:textarea path="address" class="form-control " id="address" placeholder="Address" required="required"/>
					<form:errors path="address" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="phoneNumber">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Phone Number</label>
				<div class="col-sm-10">
					<form:input path="phoneNumber" type="text" class="form-control " id="phoneNumber" placeholder="Phone Number" required="required"/>
					<form:errors path="phoneNumber" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="maximumCreditLine">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Maximum Credit Line</label>
				<div class="col-sm-10">
					<form:input path="maximumCreditLine" type="text" class="form-control " id="maximumCreditLine" placeholder="Maximum Credit Line" required="required"/>
					<form:errors path="maximumCreditLine" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<%-- <spring:bind path="creditTerm">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Credit Term</label>
				<div class="col-sm-10">
					<form:input path="creditTerm" type="text" class="form-control " id="creditTerm" placeholder="Credit Term" required="required"/>
					<form:errors path="creditTerm" class="control-label" />
				</div>
			</div>
		</spring:bind> --%>
		
		<spring:bind path="registrationDate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Registration Date</label>
				<div class="col-sm-10">
					<form:input path="registrationDate" type="text" class="form-control " id="registrationDate" placeholder="Registration Date" required="required" onkeydown="return false;"/>
					<form:errors path="registrationDate" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="creditTerm">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Credit Term</label>
				<div class="col-sm-5">
					<form:select path="creditTerm" class="form-control">
						<%-- <form:option value="NONE" label="--- Select ---" /> --%>
						<form:options items="${creditTerms}" />
					</form:select>
					<form:errors path="creditTerm" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${customer['new']}">
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
            <img src="<c:url value="/image/customers/${customer.id}/1"/>" class="img-responsive">
        </div>
    </div>
  </div>
</div>

<script>

	$(document).ready(function() {
		$("#registrationDate").datepicker({
			dateFormat : "yy-mm-dd"
		});
		
	});
</script>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>