<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>User Detail</h1>
	<br />
	
	<c:if test="${not empty user.picture}">
		<div class="row">
			<label class="col-sm-2"></label>
			<div class="col-sm-10">
				<img src="<c:url value="/image/picture/${user.id}"/>" class="img-rounded" alt="Cinque Terre" width="304" height="236"/>
				<br/>
				<div>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">View Image</button>
				<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/users/image/add?userId=${user.id}"/>'">Change Picture</button>
				</div>
			</div>
		</div>
	</c:if>
	
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${user.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${user.name}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${user.email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${user.address1}</div>
	</div>

	<%-- <div class="row">
		<label class="col-sm-2">Newsletter</label>
		<div class="col-sm-10">${user.newsletter}</div>
	</div> --%>

	<%-- <div class="row">
		<label class="col-sm-2">Web Frameworks</label>
		<div class="col-sm-10">${user.framework}</div>
	</div> --%>

	<div class="row">
		<label class="col-sm-2">Gender</label>
		<div class="col-sm-10">${user.gender}</div>
	</div>

	<%-- <div class="row">
		<label class="col-sm-2">Number</label>
		<div class="col-sm-10">${user.number}</div>
	</div> --%>

	<%-- <div class="row">
		<label class="col-sm-2">Country</label>
		<div class="col-sm-10">${user.country}</div>
	</div> --%>

	<%-- <div class="row">
		<label class="col-sm-2">Skill</label>
		<div class="col-sm-10">${user.skill}</div>
	</div> --%>

</div>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <img src="<c:url value="/image/picture/${user.id}"/>" class="img-responsive">
        </div>
    </div>
  </div>
</div>

<jsp:include page="../fragments/footer.jsp" />

<script>

function centerModal() {
    $(this).css('display', 'block');
    var $dialog = $(this).find(".modal-dialog");
    var offset = ($(window).height() - $dialog.height()) / 2;
    // Center modal vertically in window
    $dialog.css("margin-top", offset);
}

$('.modal').on('show.bs.modal', centerModal);
$(window).on("resize", function () {
    $('.modal:visible').each(centerModal);
});
</script>
</body>
</html>