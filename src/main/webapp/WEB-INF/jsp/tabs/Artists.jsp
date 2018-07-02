<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<%--@elvariable id="artist" type="amors.entity.Artist"--%>

<div class = "row m-0 p-0">
	<c:forEach var = "artist" items = "${artists}" varStatus = "loop">
		<div class = "col-3 mt-4 p-0 text-center">
			<a href = "/artist/${artist.id}" style="text-decoration: none;">
				<div id = "artistLogo" style = "background-image: url('/artist/${artist.id}/logo')"></div>
			</a>
			<br>
			<b>${artist.name}</b>
		</div>
	</c:forEach>
</div>
