<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<%--@elvariable id="album" type="amors.entity.Album"--%>

<div class = "row m-0 p-0">
	<c:forEach var = "album" items = "${albums}" varStatus = "loop">
		<div class = "col-3 mt-4 p-0 text-center">
			<a href = "/album/${album.id}" style="text-decoration: none;">
				<div id = "albumCover"><div id="albumCoverInner" style = "background-image: url('/album/${album.id}/cover')"></div></div>
			</a>
			<br>
			<b>${album.name}</b>
			<br>
			<span>${album.artist.name}</span>
		</div>
	</c:forEach>
</div>
