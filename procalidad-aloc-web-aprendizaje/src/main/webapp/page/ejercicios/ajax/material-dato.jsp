<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<style type="text/css">
	.fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}')
	}
</style>

<!-- material-datos -->
	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fondo-lectura fadeInUp animated <c:if test="${not empty material.nomImgTipoTramDoc}">fondo-img-material</c:if>">

			<div class="row main-nav-pag">
				<div class="col-md-12">
					<c:if test="${not empty material.comprension}">
						<span class="material-style">${material.comprension}</span>
					</c:if>
				</div>
			</div>

			<div class="row main-nav-pag">
				<div class="col-md-12">
					<nav id="pagination-leccion">
					<ul class="control-box pager">
						<li><a id="glosario-link" onclick="mostrarGlosario()" href="#">Glosario <i class="fa-sort-alpha-desc"></i></a></li>
						<li><a data-slide="prev" onclick="volverAPregRptDesdeMaterial()" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
						<li><a data-slide="next" onclick="siguiente_ejercicio()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
					</ul>
					</nav>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
			   		<div id="content-text-glosario" style="display: none;">
			   			<span id="content-icon-m">
			   				<i class="icon-notebook"></i>
			   			</span>
						<div id="textoGlosario"></div>
						<span class="close-conten" onclick="ocultarDivGlosario()"></span>
			   		</div>
				</div>
			</div>

			<input type="hidden" id="codmaterialVal" value="${material.codigo}">
   			<input type="hidden" id="codmaterialValEncrypt" value="${material.codigoEncrypt}">
			<input type="hidden" id="tipoMaterialVal" value="${material.situacionLeccionMaterial.codigoRegistro}">

			<c:if test="${not empty material.indicacionExtra}">
				<div class="row">
					<div class="col-md-12" id="nav-link-name">
								<!-- <i class="icon-pencil pull-left pencil-styel"></i> -->
								<i class="pull-left pencil-styel">
									<c:choose>
										<c:when test="${(material.situacionLeccionMaterial.codigoRegistro==1) or (material.situacionLeccionMaterial.codigoRegistro==2)}">
											<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS.png"  height="20px" style="margin-bottom: 40px;">
										</c:when>
										<c:when test="${(material.situacionLeccionMaterial.codigoRegistro==3) or (material.situacionLeccionMaterial.codigoRegistro==6)}">
											<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-3.png"  height="20px" style="margin-bottom: 40px;">
										</c:when>
										<c:otherwise>
											<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-2.png"  height="20px" style="margin-bottom: 40px;">
										</c:otherwise>
									</c:choose>
								</i>
								<h4 class="sub-title-app">${material.indicacionExtra}</h4>
								<br>
					</div>
				</div>
			</c:if>

			<div class="row">
				<div class="col-md-12">
					<h2 class="title-minendu format-size">${material.descripcionMaterial}</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
		   			<div class="text-format resetCSS" style="margin-bottom: 30px">${material.contexto}</div>
				</div>
			</div>

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

			<div class="row">
				<br>
				<div class="col-md-12">
					<div class="form-group text-center">
						<a class="btn btn-primary icon-arrow btn-lg btn-km" onclick="siguiente_ejercicio()" href="#"><i class="icon-arrow-right2"></i></a>
					</div>
				</div>
			</div>

		</div>
	</div>


<script type="text/javascript">
	traducirSub();
	var music = document.getElementById('music'); // id for audio element
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
	     if (music.playbackRate == 1) {
	       music.playbackRate = 0.5;
	       pSpeed.css("color","red");
	     } else {
	       music.playbackRate = 1.0;
	       pSpeed.css("color","#000");

	     }
	}
	function skip() {
	    music.currentTime += 10;
	}

	function skip1() {
	    music.currentTime += -10;
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

</script>