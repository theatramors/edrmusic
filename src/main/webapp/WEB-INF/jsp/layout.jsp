<%@ taglib prefix = "security" uri = "http://www.springframework.org/security/tags" %>
<%@ taglib uri = "http://tiles.apache.org/tags-tiles" prefix = "tiles" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType = "text/html;charset=UTF-8" %>

<!DOCTYPE HTML>
<html lang = "en">
<head>
	<!--Required meta tags-->
	<meta charset = "utf-8">
	<meta name = "viewport" content = "width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>EmptyDarkRoom.Music</title>
	
	<%--JQuery 3.3.1--%>
	<script src = "https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<%--Proper.js--%>
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	
	<%--Bootstrap 4.0.0--%>
	<script src = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<link rel = "stylesheet" href = "<c:url value="/resources/css/bootstrap/bootstrap.css"/>">
	
	<%--Font Awesome 5.0.8--%>
	<script defer src = "https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
	
	<%--Google fonts--%>
	<link rel = "stylesheet" href = "https://fonts.googleapis.com/css?family=Ubuntu">
	<link rel = "stylesheet" href = "https://fonts.googleapis.com/css?family=Roboto">
	
	<%--Custom scripts--%>
	<script src = "<c:url value="/resources/js/app.js"/>" rel = "script"></script>
	
	<%--Custom styles--%>
	<link rel = "stylesheet" href = "<c:url value="/resources/css/bootstrap-override.css"/>">
	<link rel = "stylesheet" href = "<c:url value="/resources/css/jam-audioplayer.css"/>">
	<link rel = "stylesheet" href = "<c:url value="/resources/css/template.css"/>">
</head>
<body>
<tiles:insertAttribute name = "header" />
<jsp:include page = "index.jsp" />
<%--<tiles:insertAttribute name = "audio-player" />--%>

<%--Modals--%>
<security:authorize access = "isAnonymous()">
	<jsp:include page = "/WEB-INF/jsp/modals/login.jsp" />
	<jsp:include page = "/WEB-INF/jsp/modals/registration.jsp" />
</security:authorize>
<security:authorize access = "isAuthenticated()">
	<jsp:include page = "/WEB-INF/jsp/modals/fileUpload.jsp" />
</security:authorize>
</body>
</html>
