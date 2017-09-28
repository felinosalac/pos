<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page session="true"%>
<html>
<%-- <head>
<link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<jsp:include page="fragments/header.jsp" />
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

.form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #555;
    font-size: 18px;
    font-weight: 400;
    display: block;
}
.profile-img
{
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}

</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<!-- <h1>Spring Security Login Form (Database Authentication)</h1> -->
<%-- 
	<div class="container">
		<h1>Login</h1>
		<!-- <h3>Login with Username and Password</h3> -->
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' action="<c:url value='/login' />" method='POST' class="form-horizontal">
			<table class="table">
				<tr>
					<td><label class="control-label">User:</label></td>
					<td><input type='text' name='username' class="form-control">
					</td>
				</tr>
				<tr>
					<td><label class="control-label">Password:</label></td>
					<td><input type='password' name='password'
						class="form-control" /></td>
				</tr>
				<tr>
					<td colspan='2'>
						<button type="submit" class="btn btn-primary active pull-right">Login</button>
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div> --%>
	
	<div class="container">
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
    	<div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in to continue to felinosalac.com</h1>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
                <form name='loginForm' action="<c:url value='/login' />" method='POST' class="form-signin">
                <input name='username' type="text" class="form-control" placeholder="Email" required autofocus>
                <input name='password' type="password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me
                </label>
                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
            <!-- <a href="#" class="text-center new-account">Create an account </a> -->
        </div>
   	 </div>
</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>