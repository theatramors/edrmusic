var songId;
var duration;

//region Modals event functions
function showFileUploadModal() {
	$("#modal-file-upload").modal("show");
}

function showLoginModal() {
	$("#modal-login").modal("show");
}

function hideModal(modalId) {
	$("#" + modalId).modal("hide");
}

function hideModalAndShowAnother(modalIdForHide, modalIdForShow) {
	$("#" + modalIdForHide).modal("hide");
	setTimeout(function () {
		$("#" + modalIdForShow).modal("show");
	}, 350);
}

//endregion

function getRecent() {
	$.ajax({
		url: "/songs",
		success: function (html) {
			// $("#tabContent").html(html);
		},
		error: function () {
			alert("Ajax error.");
		}
	});
}

function getArtists() {
	$.ajax({
		url: "/artists",
		success: function (html) {
			// $("#tabContent").html(html);
		},
		error: function () {
			alert("Ajax error.");
		}
	});
}

function getAlbums() {
	$.ajax({
		url: "/albums",
		success: function (html) {
			// $("#tabContent").html(html);
		},
		error: function () {
			alert("Ajax error.");
		}
	});
}

function setSongId(id) {
	songId = id;
}

jQuery(document).ready(function ($) {
	var modalLogin = $("#modal-login");
	var audioPlayer = $("#player-audio");
	var audioPlayerPlayBtn = $(".jam_player-play");
	var currentlyPlaying;
	
	modalLogin.modal({
		show: false
	});
	
	$('.custom-file-input').on('change', function () {
		let fileName = $(this).val().split('\\').pop();
		$(this).siblings('.custom-file-label').addClass("selected").html(fileName);
	});
	
	var song = $(".song");
	var songs = [];
	var songDurationHtml;
	
	$("html").find(".song").each(function (index, element) {
		songs.push($(this).attr("id").slice(6));
	});
	
	console.log("Current playlist: " + songs);
	
	currentlyPlaying = 0;
	audioPlayer.attr("src", "/audio/" + songs[currentlyPlaying]);
	
	audioPlayerPlayBtn.click(function () {
		audioPlayer.get(0).paused ? audioPlayer.get(0).play() : audioPlayer.get(0).pause();
	});
	
	audioPlayer.on("canplay", function () {
		duration = this.duration;
		$(".jam_player-duration-text").text(Math.floor(duration / 60) + ":" + Math.floor(duration % 60));
	});
	
	audioPlayer.on("timeupdate", function () {
		$(".jam_player-duration-inner").width((audioPlayer.get(0).currentTime / duration) * 100 + "%");
		var minutes = Math.floor(audioPlayer.get(0).currentTime / 60);
		var seconds = Math.floor(audioPlayer.get(0).currentTime % 60);
		if (seconds < 10) {
			seconds = "0" + seconds;
		}
		$(".jam_player-current-time").text(minutes + ":" + seconds);
	});
	
	audioPlayer.on("ended", function () {
		$(".song").removeClass("playing");
		currentlyPlaying++;
		var curSong = songs[currentlyPlaying];
		var nextSong = "#songId" + curSong;
		$(nextSong).addClass("playing");
		audioPlayer.attr("src", "/audio/" + curSong);
		audioPlayer.get(0).play();
		console.log("Currently playing index: " + currentlyPlaying);
	});
	
	audioPlayer.on("play", function () {
		audioPlayerPlayBtn.find(".fa-play").hide();
		audioPlayerPlayBtn.find(".fa-pause").show();
	});
	
	audioPlayer.on("pause", function () {
		audioPlayerPlayBtn.find(".fa-play").show();
		audioPlayerPlayBtn.find(".fa-pause").hide();
	});
	
	song.click(function () {
		if ($(this).hasClass("playing")) {
			$(this).removeClass("playing");
			$(this).addClass("paused");
			$(this).find(".song-id").find(".play").hide();
			$(this).find(".song-id").find(".pause").show();
			audioPlayer.get(0).pause();
		} else if ($(this).hasClass("paused")) {
			$(this).removeClass("paused");
			$(this).addClass("playing");
			$(this).find(".song-id").find(".pause").hide();
			$(this).find(".song-id").find(".play").show();
			audioPlayer.get(0).play();
		} else {
			$(".song").removeClass("playing");
			$(".song").removeClass("paused");
			$(".song").find(".song-id").find(".play").hide();
			$(".song").find(".song-id").find(".pause").hide();
			$(".song").not(this).find(".song-id").find("span").show();
			currentlyPlaying = $(this).find(".song-id").find("span").text() - 1;
			audioPlayer.get(0).pause();
			audioPlayer.get(0).currentTime = 0;
			$(this).addClass("playing");
			$(this).find(".song-id").find(".play").show();
			audioPlayer.attr("src", "/audio/" + songId);
			audioPlayer.get(0).load();
			audioPlayer.get(0).play();
		}
		console.log("Currently playing index: " + currentlyPlaying);
	});
	
	song.mouseenter(function () {
		if (!($(this).hasClass("playing") || $(this).hasClass("paused"))) {
			$(this).find(".song-id").find("span").hide();
			$(this).find(".song-id").find(".play").show();
		}
	});
	
	song.mouseleave(function () {
		if (!($(this).hasClass("playing") || $(this).hasClass("paused"))) {
			$(this).find(".song-id").find(".play").hide();
			$(this).find(".song-id").find("span").show();
		}
	});
});
