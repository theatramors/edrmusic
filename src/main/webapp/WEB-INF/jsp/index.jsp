<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ page isELIgnored = "false" %>

<div class = "container-fluid rounded mt-3 p-0 bg-opacity-white-25" style = "width: 1200px;">
	<ul class = "nav nav-tabs" role = "tablist">
		<li class = "nav-item">
			<a class = "nav-link active" href = "/" style = "background-color: transparent">Home</a>
		</li>
		<li class = "nav-item">
			<a class = "nav-link" href = "/artists" style = "background-color: transparent">Artists</a>
		</li>
		<li class = "nav-item">
			<a class = "nav-link" href = "/albums" style = "background-color: transparent">Albums</a>
		</li>
	</ul>
	<div class = "tab-content">
		<div class = "tab-pane fade show active" id = "tabContent" role = "tabpanel">
			<tiles:insertAttribute name = "tabContent" />
		</div>
	</div>
</div>
<%--<ul class = "nav nav-tabs" id = "myTab" role = "tablist">
	<li class = "nav-item mr-1">
		<a class = "nav-link active" data-toggle = "tab" href = "#panel:1" role = "tab" aria-selected = "true">Calendar</a>
	</li>
	<li class = "nav-item mr-1">
		<a class = "nav-link" data-toggle = "tab" href = "#panel:2" role = "tab" aria-selected = "false">Gallery</a>
	</li>
	<li class = "nav-item mr-1">
		<a class = "nav-link" data-toggle = "tab" href = "#panel:3" role = "tab" aria-selected = "false">Some Other Tab</a>
	</li>
</ul>
<div class = "tab-content" id = "myTabContent">
	<div class = "tab-pane fade show active" id = "panel:1" role = "tabpanel">
		<div class = "row align-items-center m-0 pl-2 pr-2 p-0">
			<div class = "col-auto p-0">
				<h3 class = "mt-2">Second Floor (216)</h3>
			</div>
		</div>
		<div class = "row m-0 pl-2 p-0">
			<div class = "col p-0">
				<span class = "badge badge-lightgreen p-1">My reserves</span>
				<span class = "badge badge-primary p-1">I'm participant</span>
				<span class = "badge badge-danger p-1">Already reserved</span>
			</div>
		</div>
		<div class = "row mt-2 m-0 pl-2 p-0">
			<div class = "col p-0">
				<button class = "btn btn-success" data-toggle = "modal" data-target = "#modal-reserve"><span class = "mb-0 h5">Reserve</span></button>
			</div>
		</div>
		<div class = "row align-items-center justify-content-between mt-2 m-0 pl-2 pr-2 p-0">
			<div class = "col-2 p-0">
				<div class = "row align-items-center justify-content-between m-0 p-0">
					<div class = "col-auto p-0">
						<span class = "btn btn-sm btn-secondary">L</span>
					</div>
					<div class = "col-auto p-0">
						<span class = "">March 2018</span>
					</div>
					<div class = "col-auto p-0">
						<span class = "btn btn-sm btn-secondary">R</span>
					</div>
				</div>
			</div>
			<div class = "row m-0 p-0">
				<div class = "col-auto mr-2 p-0">
					<button class = "btn btn-link" type = "button"><span>Expand all</span></button>
				</div>
				<div class = "col-auto p-0">
					<div class = "btn-group btn-group-toggle" data-toggle = "buttons">
						<label class = "btn btn-secondary active">
							<input type = "radio" name = "options" id = "option1" checked>Day
						</label>
						<label class = "btn btn-secondary">
							<input type = "radio" name = "options" id = "option2">Week
						</label>
						<label class = "btn btn-secondary">
							<input type = "radio" name = "options" id = "option3">Month
						</label>
					</div>
				</div>
			</div>
		</div>
		<div class = "row m-0 mt-2 mb-2 p-0">
			<div class = "col pl-1 pr-1 border-top border-bottom">Monday</div>
			<div class = "col pl-1 pr-1 border-top border-bottom">Tuesday</div>
			<div class = "col pl-1 pr-1 border-top border-bottom">Wednesday</div>
			<div class = "col pl-1 pr-1 border-top border-bottom">Thursday</div>
			<div class = "col pl-1 pr-1 border-top border-bottom">Friday</div>
			<div class = "col pl-1 pr-1 border-top border-bottom">Saturday</div>
			<div class = "col pl-1 pr-1 border-top border-bottom">Sunday</div>
		</div>
		<c:forEach begin = "1" end = "2" varStatus = "loop">
			<div class = "row m-0 p-0">
				<c:forEach begin = "1" end = "7" varStatus = "loop">
					<div class = "col p-0">
						<div class = "card rounded-0">
							<div class = "card-header pt-1 pb-1 pl-2 pr-2 bg-light" data-toggle = "modal" data-target = "#modal-reserve" style = "cursor: pointer;">
								1
							</div>
							<div class = "card-body pl-1 pr-1 pb-1 pt-0">
								<c:forEach begin = "1" end = "2" varStatus = "loop">
									<div class = "card mt-1 pt-0">
										<div class = "card-header pt-1 pb-1 pl-2 pr-2 bg-lightgreen" data-toggle = "modal" data-target = "#modal-event-details"
											 style = "cursor: pointer;">8:00
										</div>
										<div class = "card-body pt-1 pb-1 pl-2 pr-2 bg-palegreen">Meeting with new employees</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div>
	<div class = "tab-pane fade" id = "panel:2" role = "tabpanel">
		<div class = "row justify-content-center">
			<div class = "col-xl-8">
				<div class = "card mt-5 text-center ">
					<div class = "card-header">
						<h3>Gallery</h3><span class = "badge badge-secondary">Primary</span>
					</div>
					<div class = "card-body">
						<div id = "carouselExampleIndicators" class = "carousel slide" data-ride = "carousel">
							<ol class = "carousel-indicators">
								<li data-target = "#carouselExampleIndicators" data-slide-to = "0" class = "active"></li>
								<li data-target = "#carouselExampleIndicators" data-slide-to = "1"></li>
								<li data-target = "#carouselExampleIndicators" data-slide-to = "2"></li>
							</ol>
							<div class = "carousel-inner border rounded">
								<div class = "carousel-item active">
									<img class = "d-block w-100" src = "<c:url value="/static/img/img-1.jpg"/>" alt = "First slide">
								</div>
								<div class = "carousel-item">
									<img class = "d-block w-100" src = "<c:url value="/static/img/img-2.jpg"/>" alt = "Second slide">
								</div>
								<div class = "carousel-item">
									<img class = "d-block w-100" src = "<c:url value="/static/img/img-3.jpg"/>" alt = "Third slide">
								</div>
							</div>
							<a class = "carousel-control-prev" href = "#carouselExampleIndicators" role = "button" data-slide = "prev">
								<span class = "carousel-control-prev-icon" aria-hidden = "true"></span>
								<span class = "sr-only">Previous</span>
							</a>
							<a class = "carousel-control-next" href = "#carouselExampleIndicators" role = "button" data-slide = "next">
								<span class = "carousel-control-next-icon" aria-hidden = "true"></span>
								<span class = "sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class = "tab-pane fade" id = "panel:3" role = "tabpanel">
		<span>There is nothing.</span>
	</div>
</div>--%>
