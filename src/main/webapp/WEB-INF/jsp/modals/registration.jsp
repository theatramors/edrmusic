<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page isELIgnored = "false" %>

<div class = "modal fade" id = "modal-registration" tabindex = "-1" role = "dialog">
	<div class = "modal-dialog modal-sm" role = "document">
		<div class = "modal-content">
			<form method = "POST" action = "<c:url value = "/login" />">
				<div class = "modal-header">
					<span class = "modal-title">Registration</span>
					<span class = "modal-close align-self-center" onclick = "hideModal('modal-registration')"></span>
				</div>
				<div class = "modal-body">
					<input class = "form-control mb-2" id = "email" type = "text" name = "email" placeholder = "Email">
					<input class = "form-control mb-2" type = "text" name = "username" placeholder = "Login">
					<input class = "form-control mb-2" type = "password" name = "password" placeholder = "Password">
					<input class = "form-control mb-2" id = "confirmPassword" type = "password" placeholder = "Confirm password">
				</div>
				<div class = "modal-footer">
					<button class = "btn btn-primary" type = "submit">Register</button>
					<button class = "btn" type = "button" onclick = "hideModal('modal-registration')">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>
