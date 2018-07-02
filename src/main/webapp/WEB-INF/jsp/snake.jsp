<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script src = "<c:url value="/static/js/snake.js" />" rel = "script"></script>

<div class = "row mt-3 m-0 p-0">
	<div class = "col-auto ml-auto mr-auto p-0">
		<h1 class = "mb-0">Snake.js</h1>
	</div>
</div>
<div class = "container-fluid mt-3 p-0 rounded" id = "canvas" style = "position: relative; display: none; background-color: rgb(255, 255, 255)">
	<div class = "bg-primary rounded" id = "snakeHead" style = "position: absolute; width: 20px; height: 20px;"></div>
</div>
