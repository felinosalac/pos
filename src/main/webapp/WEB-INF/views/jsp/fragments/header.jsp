<%@	taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>POS - Dealer Information</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/core/css/jquery-ui.min.css" var="jqueryUICss" />

<spring:url value="/resources/core/icons/favicon.ico" var="favicon" />

<spring:url value="/resources/core/js/jquery-3.2.1.min.js" var="jqueryJs" />
<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/jquery-ui.min.js" var="jqueryUIJs" />


<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${jqueryUICss}" rel="stylesheet" />

<link rel="shortcut icon" href="${favicon}"/>

<script src="${jqueryJs}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${jqueryUIJs}"></script>
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<spring:url value="/users/image/add" var="uploadImage" />

<%-- <nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">POS - Dealer Module</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add Dealer</a></li>
			</ul>
		</div>
	</div>
</nav> --%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="<c:url value="/"/>">88-KTPENS CORP</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        	<li class="active"><a href="#">Home</a></li>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        	<li class="dropdown">
          		<a class="dropdown-toggle" data-toggle="dropdown" href="#">Accounts<span class="caret"></span></a>
          	<ul class="dropdown-menu">
            	<li><a href="<c:url value="/admin/users"/>">Users</a></li>
            	<li><a href="<c:url value="/admin/customers"/>">Dealers</a></li>
            	<li><a href="<c:url value="/admin/suppliers"/>">Suppliers</a></li>
          	</ul>
        	</li>
        	<li><a href="<c:url value="/users/file"/>">Upload File</a></li>
        	<li><a href="#">Page 3</a></li>
        </c:if>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${pageContext.request.userPrincipal.name == null}">
     	 <li><a href="<c:url value='/login' />"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      	</c:if>
      	<!-- 
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      	<li class="active"><a href="${urlAddUser}">Add Dealer</a></li>
      	<li class="active"><a href="${uploadImage}">Upload Image</a></li>
      	 -->
      	<sec:authorize access="hasRole('ROLE_USER')">
			<!-- For login user -->
			<c:url value="/logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li> <a href="#"> Welcome back, ${pageContext.request.userPrincipal.name} </a></li>
				<li class="active"><a href="javascript:formSubmit()"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</c:if>
		</sec:authorize>
      </ul>
    </div>
  </div>
</nav>
<%-- <c:if test="${not empty pageContext.request.userPrincipal}">

    <c:if test="${pageContext.request.isUserInRole('ADMIN')}">

        User ${pageContext.request.userPrincipal.name} in ADMIN Group

    </c:if>

</c:if> --%>