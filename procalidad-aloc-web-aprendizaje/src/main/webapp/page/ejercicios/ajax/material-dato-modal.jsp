<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- Modal Material Dato -->
<div class="modal fade text-xs-left" id="modal-app-material" tabindex="-1" role="dialog" aria-labelledby="myModalLabel21" aria-hidden="true">
  <div class="modal-dialog" role="document">
 <div class="modal-content">
   <div class="modal-header">
  <a id="close-modal" href="#" onclick="detenerAudio()" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a>
  <!-- <h4 class="modal-title" id="myModalLabel21">Basic Modal</h4> -->
  	<c:if test="${not empty material.indicacion}">
		<div class="row">
			<div class="col-md-12" id="nav-link-name">
						<i class="icon-pencil pull-left pencil-styel"></i>
						<h4 class="sub-title-app">${material.indicacion}</h4>
			</div>
		</div>
	</c:if>
   </div>

   	<input type="hidden" id="codmaterialVal" value="${material.codigo}">
   	<input type="hidden" id="codmaterialValEncrypt" value="${material.codigoEncrypt}">
	<input type="hidden" id="tipoMaterialVal" value="${material.situacionLeccionMaterial.codigoRegistro}">

   <div class="modal-body">
	<div class="row">
		<div class="col-md-12">
			<h2 class="title-minendu format-size">${material.descripcionMaterial}</h2>
		</div>
	</div>

	<c:if test="${material.situacionLeccionMaterial.codigoRegistro!=1}">
	<div class="row">
		<div class="col-md-12">
   			<div class="text-format resetCSS" style="margin-bottom: 30px">${material.contexto}</div>
		</div>
	</div>
	</c:if>

	<c:if test="${material.situacionLeccionMaterial.codigoRegistro==1}">
	<div class="row">
		<div class="col-md-12">
			<audio id="music" preload="true">
		  		<c:if test="${not empty material.rutaAudio}">
	  				<source src="${pageContext.request.contextPath}/material/${material.rutaAudio}">
	  			</c:if>
	  			<c:if test="${empty material.rutaAudio}">
	  				<source src="http://www.alexkatz.me/codepen/music/interlude.mp3">
	  				<source src="http://www.alexkatz.me/codepen/music/interlude.ogg">
	  			</c:if>
			</audio>
			<div id="audioplayer">
			  <div id="timeline">
			          <div id="playhead"></div>
			  </div>
			  <div id="main_btns">
			    <span id="pButton" class="btn-music icon-minedu-play"></span>
			    <span id="pVolumen" class="btn-music icon-minedu-volumen"></span>
			    <span id="pSpeed" class="btn-music icon-minedu-audio-lento"></span>

			    <span onclick="skip1()" class="btn-music icon-minedu-retroceder"></span>
			    <span onclick="skip()" class="btn-music icon-minedu-avanzar"></span>
			  </div>
			</div>

		</div>
	</div>
	</c:if>
   </div>

 </div>
  </div>
</div>

<script type="text/javascript">

var music = document.getElementById('music'); // id for audio element

if(music){
	var duration = music.duration; // Duration of audio clip, calculated here for embedding purposes
	var pButton = document.getElementById('pButton'); // play button
	var pVolumen = document.getElementById('pVolumen'); // volumen button
	var pSpeed = document.getElementById('pSpeed'); // velocidad button

	var playhead = document.getElementById('playhead'); // playhead
	var timeline = document.getElementById('timeline'); // timeline

	// timeline width adjusted for playhead
	var timelineWidth = timeline.offsetWidth - playhead.offsetWidth;

	// play button event listenter
	pButton.addEventListener("click", play);
	pVolumen.addEventListener("click", volume);
	pSpeed.addEventListener("click", speedAudio);

	// timeupdate event listener
	music.addEventListener("timeupdate", timeUpdate, false);

	// makes timeline clickable
	timeline.addEventListener("click", function(event) {
	    moveplayhead(event);
	    music.currentTime = duration * clickPercent(event);
	}, false);

	// returns click as decimal (.77) of the total timelineWidth
	function clickPercent(event) {
	    return (event.clientX - getPosition(timeline)) / timelineWidth;
	}

	// makes playhead draggable
	playhead.addEventListener('mousedown', mouseDown, false);
	window.addEventListener('mouseup', mouseUp, false);

	// Boolean value so that audio position is updated only when the playhead is released
	var onplayhead = false;

	// mouseDown EventListener
	function mouseDown() {
	    onplayhead = true;
	    window.addEventListener('mousemove', moveplayhead, true);
	    music.removeEventListener('timeupdate', timeUpdate, false);
	}

	// mouseUp EventListener
	// getting input from all mouse clicks
	function mouseUp(event) {
	    if (onplayhead == true) {
	        moveplayhead(event);
	        window.removeEventListener('mousemove', moveplayhead, true);
	        // change current time
	        music.currentTime = duration * clickPercent(event);
	        music.addEventListener('timeupdate', timeUpdate, false);
	    }
	    onplayhead = false;
	}
	// mousemove EventListener
	// Moves playhead as user drags
	function moveplayhead(event) {
	    var newMargLeft = event.clientX - getPosition(timeline);

	    if (newMargLeft >= 0 && newMargLeft <= timelineWidth) {
	        playhead.style.marginLeft = newMargLeft + "px";
	    }
	    if (newMargLeft < 0) {
	        playhead.style.marginLeft = "0px";
	    }
	    if (newMargLeft > timelineWidth) {
	        playhead.style.marginLeft = timelineWidth + "px";
	    }
	}

	// timeUpdate
	// Synchronizes playhead position with current point in audio
	function timeUpdate() {
		var pButton = $("#pButton");
	    var playPercent = timelineWidth * (music.currentTime / duration);
	    playhead.style.marginLeft = playPercent + "px";
	    if (music.currentTime == duration) {
	        pButton.removeClass('icon-minedu-stop');
	        pButton.addClass('icon-minedu-play');
	    }
	}

	//Play and Pause
	function play() {
	    // start music
	    var pButton = $("#pButton");
	    if (music.paused) {
	        music.play();
	        // remove play, add pause
	        pButton.removeClass('icon-minedu-play');
	        pButton.addClass('icon-minedu-stop');
	    } else { // pause music
	        music.pause();
	        // remove pause, add play
	        pButton.removeClass('icon-minedu-stop');
	        pButton.addClass('icon-minedu-play');
	    }
	}

	function volume() {
	    var pVolumen = $("#pVolumen");
	    if (music.volume) {
	        music.volume= 0;
	        pVolumen.removeClass('icon-minedu-volumen');
	        pVolumen.addClass('icon-minedu-volumen-mute');
	        // remove play, add pause
	    } else { // pause music
	        music.volume= 1;
	        pVolumen.removeClass('icon-minedu-volumen-mute');
	        pVolumen.addClass('icon-minedu-volumen');
	        // remove pause, add play
	    }
	}

	function speedAudio() {
	    var pSpeed = $("#pSpeed");
	    	//console.log(music.playbackRate);
	     if (music.playbackRate == 1) {
	       music.playbackRate = 0.5;
	       pSpeed.css("color","red");
	     } else {
	       music.playbackRate = 1.0;
	       pSpeed.css("color","#000");

	     }
	}
	function skip() {
	    music.currentTime += 2;
	}
	
	function skip1() {
	    music.currentTime += -2;
	}

	// Gets audio file duration
	music.addEventListener("canplaythrough", function() {
	    duration = music.duration;
	}, false);

	// getPosition
	// Returns elements left position relative to top-left of viewport
	function getPosition(el) {
	    return el.getBoundingClientRect().left;
	}
}

function detenerAudio(){
	if(music){
		var pButton = $("#pButton");
		music.pause();
        // remove pause, add play
        pButton.removeClass('icon-minedu-stop');
        pButton.addClass('icon-minedu-play');
	}
}

</script>