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
</div>

<jsp:include page="../../fragments/footer.jsp" />

</body>
</html>