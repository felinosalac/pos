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

	<spring:url value="/users/image/upload?_csrf=${_csrf.token}" var="userUploadUrl" />
	${_csrf.parameterName} = ${_csrf.token}
     <input type="file" id="files" multiple/>    
	 <img id="image"/>
</div>

<script >
document.getElementById("files").onchange = function () {
    var reader = new FileReader();
    reader.onload = function (e) {
        //document.getElementById("image").src = e.target.result;
        //document.getElementById("image").width = 304;
        //document.getElementById("image").height = 236;
        $('#image').attr('class', 'img-rounded');
        $('#image').attr('height', 236);
        $('#image').attr('width', 304);
        $('#image').attr('src', e.target.result);
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};
</script>
<jsp:include page="../../fragments/footer.jsp" />
</body>
</html>

