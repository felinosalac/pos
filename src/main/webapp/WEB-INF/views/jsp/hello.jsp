
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
<html>
<head>
	<link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head> 
--%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp" />
<body>
	<div class="container">
		<h3>Title : ${title}</h3>
		<p>Message : ${message}</p>

		<sec:authorize access="hasRole('ROLE_USER')">
			<!-- For login user -->
			<c:url value="/logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
					User : ${pageContext.request.userPrincipal.name} | 
					<span class="label label-success">
						<a href="javascript:formSubmit()"> Logout</a>
					</span>
			</c:if>
		</sec:authorize>
		<!-- jumbutron -->
		<div class="jumbotron">
			<h1>Marketing Stuff</h1>
			<p class="lead">Marketing is the pervasive set of activities that attempt to influence individual or organizational choice.</p>
			<p>
			<a class="btn btn-lg btn-success" href="#" role="button">Get started today</a>
			</p>
		</div>
		
	
	<!-- Grid -->
	<!-- row 1 -->
	<div class="row" style="text-align:center;">
		<div class="col-lg-4"  style="background-color:lavender;">
			<h2>STORE</h2>
			<p><a class="btn btn-lg btn-warning" href="Store.html" role="button">Store</a></p>
		</div>
		<div class="col-lg-4" style="background-color:lavenderblush;">
			<h2>PRODUCT</h2>
			<p><a class="btn btn-lg btn-primary" href="#" role="button">Product</a></p>
		</div>
		<div class="col-lg-4"  style="background-color:lavender;">
			<h2>SUPPORT</h2>
			<p><a class="btn btn-lg btn-success" href="#" role="button">Support</a></p>
		</div>
	</div>
	<!-- row 2 -->
	<div class="row" style="text-align:center;">
		<div class="col-lg-4"  style="background-color:lavenderblush;">
			<h2>CUSTOMER</h2>
			<p><a class="btn btn-lg btn-info" href="#" role="button">Customers</a></p>
		</div>
		<div class="col-lg-4" style="background-color:lavender;">
			<h2>ORDERS</h2>
			<p><a class="btn btn-lg btn-warning" href="#" role="button">Orders</a></p>
		</div>
		<div class="col-lg-4"  style="background-color:lavenderblush;">
			<h2>INVENTORY</h2>
			<p><a class="btn btn-lg btn-danger" href="#" role="button">Inventory</a></p>
		</div>
	</div>
	<!-- row 3 -->
	<div class="row" style="text-align:center;">
		<div class="col-lg-4" style="background-color:lavender;">
			<h2>PAYMENT</h2>
			<p><a class="btn btn-lg btn-danger" href="#" role="button">Payments</a></p>
		</div>
		<div class="col-lg-4" style="background-color:lavenderblush;">
			<h2>ROC</h2>
			<p><a class="btn btn-lg btn-primary" href="#" role="button">Return From Customers</a></p>
		</div>
		<div class="col-lg-4" style="background-color:lavender;">
			<h2>INVOICE</h2>
			<p><a class="btn btn-lg btn-success" href="#" role="button">Invoice</a></p>
		</div>
		</div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>