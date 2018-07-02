<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html;charset=UTF-8" %>

<div class = "modal fade" id = "modal-file-upload" tabindex = "-1" role = "dialog">
	<div class = "modal-dialog modal-sm" role = "document">
		<div class = "modal-content">
			<form:form method = "POST" action = "/upload_file" enctype = "multipart/form-data">
				<div class = "modal-header">
					<span class = "modal-title">Select file to upload</span>
					<span class = "modal-close align-self-center" onclick = "hideModal('modal-file-upload')"></span>
				</div>
				<div class = "modal-body">
					<input class = "form-control mb-2" type = "text" name = "artistName" placeholder = "Artist" />
					<input class = "form-control mb-2" type = "text" name = "songTitle" placeholder = "Song title" />
					<div class = "custom-file mb-2">
						<input class = "custom-file-input" type = "file" id = "customFile" name = "file">
						<label class = "custom-file-label" for = "customFile">Choose file</label>
					</div>
					<small class = "pl-2">MP3 only.</small>
				</div>
				<div class = "modal-footer">
					<button class = "btn btn-primary" type = "submit">Upload</button>
					<button class = "btn" type = "button" onclick = "hideModal('modal-file-upload')">Close</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
