<%@	taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Modal Dialog -->
<div class="modal fade" id="confirmDelete" role="dialog" aria-labelledby="confirmDeleteLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Delete Parmanently</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure about this ?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-danger" id="confirm">Delete</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteConfirmationModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Deleted!</h4>
        </div>
        <div class="modal-body">
          <p>User Successfully Deleted.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-dismiss="modal">Ok</button>
        </div>
      </div>
    </div>
  </div>


<!-- Dialog show event handler -->
<script type="text/javascript">
  $('#confirmDelete').on('show.bs.modal', function (e) {
      $message = $(e.relatedTarget).attr('data-message');
      $(this).find('.modal-body p').text($message);
      
      $title = $(e.relatedTarget).attr('data-title');
      $(this).find('.modal-title').text($title);
      
      $url = $(e.relatedTarget).attr('data-url');
      
      var form = $(e.relatedTarget).closest('form');
      $(this).find('.modal-footer #confirm').data('delete_endpoint', $url);

      // Pass form reference to modal for submission on yes/ok
      //var form = $(e.relatedTarget).closest('form');
      //$(this).find('.modal-footer #confirm').data('form', form);
  });

  <!-- Form confirm (yes/ok) handler, submits form -->
  $('#confirmDelete').find('.modal-footer #confirm').on('click', function(){
	  
	  $deleteEndpoint = $(this).data('delete_endpoint');
	  //alert($deleteEndpoint + "?_csrf=${_csrf.token}");
	  
	  $.ajax({
			type : "DELETE",
			contentType : "application/json",
			url : $deleteEndpoint + "?_csrf=${_csrf.token}",
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				$('#confirmDelete').modal('hide');
				$('#deleteConfirmationModal').modal('toggle');
				
				 //location.reload();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				alert(e);
			}
		}).done(function(e) {
			console.log("DONE");
		});
     
	  //submit the form
	  //$(this).data('form').submit();
  });
</script>