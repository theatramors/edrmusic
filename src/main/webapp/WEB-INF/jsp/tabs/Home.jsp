<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<%--@elvariable id="song" type="amors.entity.Song"--%>

<div class = "row m-0 pl-3 pr-3 p-2">
	<div class = "col p-0">
		<h4 class="mb-0 border-bottom">Popular artists</h4>
	</div>
</div>
<div class = "row m-0 p-0">
	<c:forEach var = "artist" items = "${artists}">
		<div class = "col-3 p-0 text-center">
			<a href="/artist/${artist.id}" style="text-decoration: none;">
				<div id = "artistLogo" style = "background-image: url('/artist/${artist.id}/logo');"></div>
			</a>
			<br>
			<b>${artist.name}</b>
		</div>
	</c:forEach>
</div>
<div class = "row m-0 pl-3 pr-3 p-2">
	<div class = "col p-0">
		<h4 class="mb-0 border-bottom">Popular albums</h4>
	</div>
</div>
<div class = "row m-0 p-0">
	<c:forEach var = "album" items = "${albums}">
		<div class = "col-3 p-0 text-center">
			<a href="/album/${album.id}" style="text-decoration: none;">
				<div id = "albumCover"><div id="albumCoverInner" style = "background-image: url('/album/${album.id}/cover')"></div></div>
			</a>
			<br>
			<b>${album.name}</b>
			<br>
			<span>${album.artist.name}</span>
		</div>
	</c:forEach>
</div>
<div class = "row m-0 pl-3 pr-3 p-2">
	<div class = "col p-0">
		<h4 class="mb-0 border-bottom">Popular songs</h4>
	</div>
</div>
<c:forEach var = "song" items = "${songs}" varStatus = "loop">
	<div class = "song row m-0 pl-3 pr-3 p-2" id = "songId${song.id}" onclick = "setSongId(<c:out value = "${song.id}" />)">
		<div class = "col-auto p-0" style = "width: 40px;">
			<span class = "song-id">
				<span><c:out value = "${loop.index + 1}" /></span>
				<i class = "play far fa-play-circle" style = "display: none;"></i>
				<i class = "pause far fa-pause-circle" style = "display: none;"></i>
			</span>
		</div>
		<div class = "col-4 p-0">
			<a class = "hover-light-red" href = ""><c:out value = "${song.name}" /></a>
		</div>
		<div class = "col-5 p-0">
			<a class = "hover-light-red" href = "artist/${song.artist.id}"><c:out value = "${song.artist.name}" /></a>
		</div>
		<div class = "col p-0 text-right">
			<span>0:00</span>
		</div>
	</div>
</c:forEach>
