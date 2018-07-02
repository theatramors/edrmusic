<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page isELIgnored = "false" %>

<div class = "modal fade" id = "modal-login" tabindex = "-1" role = "dialog">
	<div class = "modal-dialog modal-sm" role = "document">
		<div class = "modal-content">
			<form method = "POST" action = "<c:url value = "/login" />">
				<div class = "modal-header">
					<span class = "modal-title">Authorization</span>
					<span class = "modal-close align-self-center" onclick = "hideModal('modal-login')"></span>
				</div>
				<div class = "modal-body">
					<input class = "form-control mb-2" id = "username" type = "text" name = "username" placeholder = "Login">
					<input class = "form-control mb-2" id = "password" type = "password" name = "password" placeholder = "Password">
					<div class = "text-center">
						<span>No account? </span><a href = "#" onclick = "hideModalAndShowAnother('modal-login', 'modal-registration')">Register now</a>
					</div>
				</div>
				<div class = "modal-footer">
					<button class = "btn btn-primary" type = "submit">Login</button>
					<button class = "btn" type = "button" onclick = "hideModal('modal-login')">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>
