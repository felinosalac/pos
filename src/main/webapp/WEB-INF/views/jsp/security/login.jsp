<%@ page session="false"%>
<%@ include file="../resources.jsp"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>

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

		<h1>Login</h1>
		<spring:url value="/login" var="userActionUrl" />
		<form:form class="form-horizontal" method="post"
			modelAttribute="loginCredentialForm" action="${userActionUrl}">

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<form:input path="email" class="form-control" id="email"
							placeholder="Email" />
						<form:errors path="email" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<form:password path="password" class="form-control" id="password"
							placeholder="password" />
						<form:errors path="password" class="control-label" />
					</div>
				</div>
			</spring:bind>

		<button type="submit" class="btn btn-primary active pull-right">Login</button>
		</form:form>
	</div>

	<jsp:include page="../fragments/footer.jsp" />
</body>
</html>