<%@ page session="false"%>
<%@ include file="../resources.jsp"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />

<!-- <div class="container">
	<form>
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-user"></i></span> <input id="email" type="text"
				class="form-control" name="email" placeholder="Email">
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-lock"></i></span> <input id="password"
				type="password" class="form-control" name="password"
				placeholder="Password">
		</div>
		<br>
		<div class="input-group">
			<span class="input-group-addon">Text</span> <input id="msg"
				type="text" class="form-control" name="msg"
				placeholder="Additional Info">
		</div>
	</form>
</div> -->

<div class="container">

	<c:choose>
		<c:when test="${userForm['new']}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/admin/users/add" var="userActionUrl" />

	<%-- <form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}" onsubmit='return onSubmit(this)'> --%>
	<form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">

		<form:hidden path="id" />
		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name" placeholder="Name" required="required"/>
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="username">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Username</label>
				<div class="col-sm-10">
					<form:input path="username" type="text" class="form-control " id="username" placeholder="Username" required="required"/>
					<form:errors path="username" class="control-label" />
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

		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email" placeholder="Email" required="required"/>
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:password path="password" class="form-control" id="password" placeholder="Password" required="required"/>
					<form:errors path="password" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Confirm Password</label>
				<div class="col-sm-10">
				<%-- <form:password path="confirmPassword" class="form-control" id="password" placeholder="password" /> --%>
				<input name='confirmPassword' type="password" class="form-control" placeholder="Password" required>
			</div>
		</div>

		<spring:bind path="address1">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:textarea path="address1" rows="5" class="form-control" id="address1" placeholder="address" />
					<form:errors path="address1" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">User Roles</label>
				<div class="col-sm-10">
					<form:checkboxes name="userRoles" path="userRoles" items="${userRoles}" element="label class='checkbox-inline'" />
					<br />
					<form:errors path="userRoles" class="control-label" />
				</div>
			</div>

		<%--
		<spring:bind path="newsletter">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Newsletter</label>
				<div class="col-sm-10">
					<div class="checkbox">
						<label> <form:checkbox path="newsletter" id="newsletter" />
						</label>
						<form:errors path="newsletter" class="control-label" />
					</div>
				</div>
			</div>
		</spring:bind>
		--%>
		<%-- 
		<spring:bind path="framework">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Web Frameworks</label>
				<div class="col-sm-10">
					<form:checkboxes path="framework" items="${frameworkList}" element="label class='checkbox-inline'" />
					<br />
					<form:errors path="framework" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="sex">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Sex</label>
				<div class="col-sm-10">
					<label class="radio-inline"> <form:radiobutton path="sex" value="M" /> Male
					</label> <label class="radio-inline"> <form:radiobutton path="sex" value="F" /> Female
					</label> <br />
					<form:errors path="sex" class="control-label" />
				</div>
			</div>
		</spring:bind>
		--%>
		
		<%--
		<spring:bind path="number">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Number</label>
				<div class="col-sm-10">
					<form:radiobuttons path="number" items="${numberList}" element="label class='radio-inline'" />
					<br />
					<form:errors path="number" class="control-label" />
				</div>
			</div>
		</spring:bind>
		--%>
		
		<!-- Custom Script, Spring map to model via 'name' attribute
		<div class="form-group">
			<label class="col-sm-2 control-label">Number</label>
			<div class="col-sm-10">

				<c:forEach items="${numberList}" var="obj">
					<div class="radio">
						<label> 
							<input type="radio" name="number" value="${obj}">${obj}
						</label>
					</div>
				</c:forEach>
			</div>
		</div>
 		-->
		<%--
		<spring:bind path="country">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Country</label>
				<div class="col-sm-5">
					<form:select path="country" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${countryList}" />
					</form:select>
					<form:errors path="country" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>
		--%>
		
		<%--
		<spring:bind path="skill">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Java Skills</label>
				<div class="col-sm-5">
					<form:select path="skill" items="${javaSkillList}" multiple="true" size="5" class="form-control" />
					<form:errors path="skill" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>
		--%>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${userForm['new']}">
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
<div class="starter-template">
	<h1>Search Form</h1>
	<br>
	<div id="feedback"></div>
	<form class="form-horizontal" id="search-form">
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Username</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="username">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="email">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Search</button>
				</div>
			</div>
		</form>
</div>
${_csrf.parameterName} 
<br>
${_csrf.token}
<c:url var="home" value="/" scope="request" />
<script>

jQuery(document).ready(function($) {
	$("#search-form").submit(function(event) {

		// Prevent the form from submitting via the browser.
		event.preventDefault();
		searchViaAjax();

	});
});

function searchViaAjax() {
	
	//alert(${home} + "search/api/getSearchResult");

	var search = {}
	search["username"] = $("#username").val();
	search["email"] = $("#email").val();
	search["_csrf"] = '${_csrf.token}';
	
	//alert(JSON.stringify(search));
	
	//search[${_csrf.parameterName} ] = ${_csrf.token};
	//alert(${home} + "search/api/getSearchResult");
	//alert(JSON.stringify(search));

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "${home}search/api/getSearchResult2?_csrf=${_csrf.token}",
		data : JSON.stringify(search),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		}
	}).done(function(e) {
		console.log("DONE");
		alert("test");
		enableSearchButton(true);
	});

}

function display(data) {
	var json = "<h4>Ajax Response</h4><pre>"
			+ JSON.stringify(data, null, 4) + "</pre>";
	$('#feedback').html(json);
}

function enableSearchButton(flag) {
	$("#btn-search").prop("disabled", flag);
}

function onSubmit( form ){
	  var data = JSON.stringify($(form).serializeArray() ); //  <-----------
	  console.log( data );
	  
	  
	  var person = JSON.stringify({
		    "firstName": $('#firstName').val(), 
		    "lastName":$('#lastName').val(),
		    "userRoles": $("input[name='userRoles']:checked").map(function(){
		        	return this.value;
		    	}).get()
		   });
	  
	  /* var array =  $("input[name='Question1']:checked").map(function(){
		    return this.value;
		}).get()
 */
	  console.log( person );
	  
	  return false; //don't submit
	}


</script>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>