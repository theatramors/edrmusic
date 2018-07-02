<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page isELIgnored = "false" %>

<div class = "jam_player-container">
	<div class = "jam_player-media">
		<audio class = "player-audio" id = "player-audio" preload = "auto"></audio>
	</div>
	<div class = "jam_player-play">
		<span class = "fas fa-play"></span>
		<span class = "fas fa-pause"></span>
	</div>
	<div class = "jam_player-current-time">0:00</div>
	<div class = "jam_player-duration-outer">
		<div class = "jam_player-duration-inner"></div>
	</div>
	<div class = "jam_player-duration-text"></div>
</div>
