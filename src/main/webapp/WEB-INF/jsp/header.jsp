<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "security" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page isELIgnored = "false" %>

<nav class = "navbar navbar-expand justify-content-between pl-3 pr-3 p-2 border-bottom bg-opacity-white-25">
	<ul class = "navbar-nav align-items-center">
		<li class = "nav-item">
			<a class = "navbar-brand" href = "/"><h5 class = "mb-0">EmptyDarkRoom.Music</h5></a>
		</li>
		<li class = "nav-item mr-3" style = "width: 250px;">
			<div class = "input-group input-group-sm">
				<input type = "text" class = "form-control" placeholder = "Track, artist, album" aria-describedby = "basic-addon2">
				<div class = "input-group-append">
					<button type = "button" class = "btn"><i class = "fas fa-search"></i></button>
				</div>
			</div>
		</li>
		<li class = "nav-item">
			<a class = "btn" href = "games">Games</a>
		</li>
	</ul>
	<security:authorize access = "isAnonymous()">
		<ul class = "navbar-nav align-items-center">
			<li class = "nav-item">
				<button class = "btn" type = "button" onclick = "showLoginModal()">Login</button>
			</li>
		</ul>
	</security:authorize>
	<security:authorize access = "isAuthenticated()">
		<ul class = "navbar-nav align-items-center">
			<li class = "nav-item">
				<button class = "btn" type = "button" onclick = "showFileUploadModal()">Upload an audio file</button>
			</li>
			<li class = "nav-item">
				<button class = "btn ml-2" type = "button"><i class = "fas fa-heart"></i></button>
			</li>
			<li class = "nav-item dropdown ml-2">
				<a href = "" class = "nav-link dropdown-toggle" id = "navbarDropdown" role = "button" data-toggle = "dropdown" aria-haspopup = "true" aria-expanded = "false">
					<security:authentication property = "principal.username" />
				</a>
				<div class = "dropdown-menu dropdown-menu-right" aria-labelledby = "navbarDropdown">
					<a class = "dropdown-item" href = "<c:url value = "/logout" />">Logout</a>
				</div>
			</li>
		</ul>
	</security:authorize>
</nav>
