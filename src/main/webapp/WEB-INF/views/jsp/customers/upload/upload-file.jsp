<%@ page session="false"%>
<%@ include file="../../resources.jsp"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../fragments/header.jsp" />

<div class="container">
	<div class="alert alert-${css} alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>${msg}</strong>
	</div>

	<spring:url value="/customers/image/upload?_csrf=${_csrf.token}&fileType=${fileType}&id=${customer.id}" var="userUploadUrl" />
	
	<h1>${formTitle}</h1>
	
	<div>
		User: ${customer.firstName}
	</div>
	
	<form method="POST" enctype="multipart/form-data"
		action="${userUploadUrl}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="userId" value="${customer.id}" />
		<div class="form-horizontal">
			<div class="col-sm-3">
				<label class="control-label">File to upload:</label> 
				<input type="file" name="file" class="form-control"> 
				<!-- <label class="control-label">Name:</label>
				<input type="text" name="name" class="form-control"> -->
				<br />
				<button type="submit" class="btn btn-primary">Upload</button>
			</div>
		</div>
	</form>
</div>

<jsp:include page="../../fragments/footer.jsp" />

</body>
</html>