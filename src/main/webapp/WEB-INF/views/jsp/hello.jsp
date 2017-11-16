
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
					<span class="label label-success"> <a
					href="javascript:formSubmit()"> Logout</a>
				</span>
			</c:if>
		</sec:authorize>
		
		<!-- jumbutron -->
		<div class="jumbotron">
			<h1>Marketing Stuff</h1>
			<p class="lead">Marketing is the pervasive set of activities that
				attempt to influence individual or organizational choice.</p>
			<p>
				<a class="btn btn-lg btn-success" href="#" role="button">Get
					started today</a>
			</p>
		</div>

		<div>
			<!-- Card Flip -->
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Product List</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Product List</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="/admin/products"/>" role="button">Enter</a>
					</div>
				</div>
			</div>
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Customer List</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Customer List</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="#"/>" role="button">Enter</a>
					</div>
				</div>
			</div>

			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Supplier List</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Supplier List</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="#"/>" role="button">Enter</a>
					</div>
				</div>
			</div>
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Orders</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Orders</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="#"/>" role="button">Enter</a>
					</div>
				</div>
			</div>
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Payment</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Payment</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="#"/>" role="button">Enter</a>
					</div>
				</div>
			</div>
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Inventory</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Inventory</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="#"/>" role="button">Enter</a>
					</div>
				</div>
			</div>
<!-- 			<div class="grid">
				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12"></div>
				</div>
			</div> -->
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Invoice</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Invoice</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="#"/>" role="button">Enter</a>
					</div>
				</div>
			</div>
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>Return from Customers</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>Return from Customers</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div>
						<a class="btn btn-lg btn-info" href="<c:url value="#"/>" role="button">Enter</a>
					</div>
				</div>
			</div>
			<div class="info-card">
				<div class="front">
					<!-- <img class="card-image" src="http://i.imgur.com/QHxnyes.jpg?1"> -->
					<h2>About Us</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social"></div>
				</div>
				<div class="back">
					<h2>About Us</h2>
					<p>Globally facilitate timely bandwidth vis-a-vis user friendly
						core competencies. Uniquely architect covalent e-tailers through
						viral Lorem ipsum dolor sit amet, con.</p>
					<div class="social">
						<a href="#" class="social-icon facebook  animate"><span
							class="fa fa-facebook"></span></a> <a
							href="https://twitter.com/MichaelCanlas7" target="_blank"
							class=" social-icon twitter  animate"><span
							class="fa fa-twitter"></span></a> <a
							href="https://github.com/ironprice91" target="_blank"
							class=" social-icon github  animate"><span
							class="fa fa-github-alt"></span></a>
					</div>
				</div>
			</div>
		</div>
		<div class="grid">
			<div class="row">
				<!-- <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">I am the last DIV</div> -->
			</div>
		</div>
		<jsp:include page="fragments/footer.jsp" />
	</div>
</body>
</html>