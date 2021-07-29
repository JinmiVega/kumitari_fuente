<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<style type="text/css">
	.fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}')
	}
	.img-icon-indicacion{
	    margin-right: 10px;
	    color: #FF4D4C;
	}
	.bloquear{
		pointer-events: none;
	}
</style>

<!-- preguntas-respuestas -->
	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fondo-lectura fadeInUp animated">

			<div class="row main-nav-pag">
				<div class="col-md-12">
					<c:if test="${not empty materialTipoEjercicioBean.comprension}">
						<span class="material-style">${materialTipoEjercicioBean.comprension}</span>
					</c:if>
				</div>
			</div> 

			<div class="row main-nav-pag">
				<div class="col-md-12">
					<nav id="pagination-leccion">
						<ul class="control-box pager">
							<li><a id="glosario-link" onclick="mostrarGlosario()" href="#">Glosario <i class="fa fa-sort-alpha-desc"></i></a></li>
							<c:choose>
								<c:when test="${usuarioEstudiante.codPerfilUsuSelec == 4}">
									<c:if test="${(empty evaluacionDetalle.codigo) or (evaluacionDetalle.codigo==0)}">
										<li><a data-slide="prev" onclick="beforeBtn()" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
										<li><a data-slide="next" onclick="nextBtn()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
									</c:if>
								</c:when>
								<c:otherwise>
										<li><a data-slide="prev" onclick="beforeBtn()" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
										<li><a data-slide="next" onclick="nextBtn()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
								</c:otherwise>
							</c:choose>
							<!-- <a data-slide="next" href="#myCarousel" class=""></a> -->
						</ul>
					</nav>
				</div>
			</div>

			<div style="display:none;">
				<input id="codEvaluacionDet" type="hidden"  value="${evaluacionDetalle.codigo}">
				<input id="intent1" type="hidden" value="${intentoConfiguracionBean.intento1}">
				<input id="intent2" type="hidden" value="${intentoConfiguracionBean.intento2}">
				<input id="intent3" type="hidden" value="${intentoConfiguracionBean.intento3}">
				<input id="codigoMTE" type="hidden" value="${materialTipoEjercicioBean.codigo}">
				<input id="codTipoEjer" type="hidden" value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">
				<input id="flgPreguEjer" type="hidden" value="${materialTipoEjercicioBean.flgPregu}">
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

			<div class="row">
				<div class="col-md-12" id="nav-link-name">
					<!-- <i class="icon-pencil pull-left pencil-styel"></i> -->
					<i class="pull-left pencil-styel">
						<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/PyRx50.png" height="17" style="margin-bottom: 20px;">
					</i>
					<h4 class="sub-title-app">${materialTipoEjercicioBean.titulo}</h4>
				</div>

				<div class="col-md-12 text-right">
					<!-- <button type="button" class="btn btn-primary btn_Ojo" onclick="show_material_preg_rpt()"> -->
					<span onclick="show_material_preg_rpt()" style="cursor: pointer;">
						<!-- <i class="fa fa-eye"></i> -->
						<c:choose>
							<c:when test="${(material.situacionLeccionMaterial.codigoRegistro==1) or (material.situacionLeccionMaterial.codigoRegistro==2)}">
								<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS.png" >
							</c:when>
							<c:when test="${(material.situacionLeccionMaterial.codigoRegistro==3) or (material.situacionLeccionMaterial.codigoRegistro==6)}">
								<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-3.png" >
							</c:when>
							<c:otherwise>
								<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-2.png" >
							</c:otherwise>
						</c:choose>
					<!-- </button> -->
					</span>
				</div>
			</div>

			<c:forEach var="pregunta" items="${listaPreguntas}" varStatus = "status">

				<%-- <div class="row tabs_elements" ${status.first ? '' : 'style = "display:none"'} id="tab_${status.index}" data-id="${pregunta.codigo}"> --%>
				<div class="row tabs_elements" style = "display:none" id="tab_${status.index}" data-id="${pregunta.codigo}">
					<div class="col-md-12">
						<%-- <p class="title-minendu ttpregunta" id="title-preg-${pregunta.codigo}" style="margin-top: 50px;">${pregunta.descripcion}</p> --%>
						<div class="title-minendu ttpregunta" id="title-preg-${pregunta.codigo}" style="margin-top: 30px;margin-bottom: 20px">${pregunta.descripcion}</div>
					</div>
					<div id="lstRadioSelect-${pregunta.codigo}"  class="col-md-12 lstRadioSelect">
				        <c:forEach var="alternativa" items="${pregunta.listaAlternativa}">

				        	<c:if test="${not empty alternativa.descripcion && alternativa.descripcion != '' && !alternativa.descripcion.contains('<p><br></p>')}">
				        		<div class="rsp-link">
						            <input type="radio" name="Oneradio" id="radio-${alternativa.codigo}" value="${alternativa.codigo}" class="btn-sm" />
						            <label for="radio-${alternativa.codigo}">${alternativa.descripcion}</label>
						        </div>
				        	</c:if>
				        </c:forEach>
					</div>
				</div>
			</c:forEach>
	
			<c:if test="${ materialTipoEjercicioBean.expresionGramatical.trim()  != '' }">
				<div class="row">
				<c:choose>
					<c:when test="${lenguaBean.codigo==24}">
						<div class="col-md-12" style="margin-top: 15px;">
					   		<div id="content-text-castellano">
								${materialTipoEjercicioBean.expresionGramatical}
					   		</div>
						</div>
					</c:when>
					<c:otherwise>
					    <div class="col-md-12" style="margin-top: 15px;">
							<span onclick="mostrarDivNew()" id="idShowIndGram">
					   				<i class="icon-notebook"></i>
					   		</span>
						</div>
						<div class="col-md-12" style="margin-top: 15px;">
					   		<div id="content-text-info">
					   			<span id="content-icon-m">
					   				<i class="icon-notebook"></i>
					   			</span>
								${materialTipoEjercicioBean.expresionGramatical}
								<span class="close-conten" onclick="ocultarDivNew()"></span>
					   		</div>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			</c:if>

			<div class="row">
				<div class="col-md-12">
					<div class="form-group text-center" id="divEvaluarEjercicio">
					<input type="hidden" id="codigoMaterialActual" value="${material.codigo}">
					<c:choose>
						<c:when test="${evaluacionDetalle.codigo>0}">
							<button type='button' id='btn_validar_ejercicio'
								onclick='nextBtn()'
								class='btn btn-primary btn-lg btn-min-width icon-arrow' >
								<i class="icon-arrow-right2"></i>
							</button>
						</c:when>
						<c:otherwise>
						<a id="btnevaluar" class="btn btn-primary btn-lg icon-arrow" onclick="nextBtn()" href="#" style="margin-top: 15px"> <i class="icon-arrow-right2"></i>
						</a>
						</c:otherwise>
					</c:choose>


					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="divModalMaterialPregRpt"></div>

<!-- Modal Material Dato -->
<div class="modal fade text-xs-left" id="modal-app-material" tabindex="-1" role="dialog" aria-labelledby="myModalLabel21" aria-hidden="true">
  <div class="modal-dialog" role="document">
 <div class="modal-content">
   <div class="modal-header" style="cursor: move;">
  <a id="close-modal" href="#" onclick="detenerAudio()" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a>
  <!-- <h4 class="modal-title" id="myModalLabel21">Basic Modal</h4> -->
  	<c:if test="${not empty material.indicacion}">
		<div class="row">
			<div class="col-md-12" id="nav-link-name">
				<!-- <i class="icon-pencil pull-left pencil-styel"></i> -->
				<i class="pull-left img-icon-indicacion">
					<c:choose>
						<c:when test="${(material.situacionLeccionMaterial.codigoRegistro==1) or (material.situacionLeccionMaterial.codigoRegistro==2)}">
							<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS.png" height="20px" style="margin-bottom: 20px;">
						</c:when>
						<c:when test="${(material.situacionLeccionMaterial.codigoRegistro==3) or (material.situacionLeccionMaterial.codigoRegistro==6)}">
							<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-3.png" height="20px" style="margin-bottom: 20px;">
						</c:when>
						<c:otherwise>
							<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-2.png" height="20px" style="margin-bottom: 20px;">
						</c:otherwise>
					</c:choose>
				</i>
				<h4 class="sub-title-app">${material.indicacion}</h4>
			</div>
		</div>
	</c:if>
   </div>

   	<input type="hidden" id="codmaterialVal" value="${material.codigo}">
   	<input type="hidden" id="codmaterialValEncrypt" value="${material.codigoEncrypt}">
   	
	<input type="hidden" id="tipoMaterialVal" value="${material.situacionLeccionMaterial.codigoRegistro}">

   <%-- <div class="modal-body <c:if test="${not empty material.nomImgTipoTramDoc}">fondo-img-material</c:if>"> --%>
	<div class="modal-body">
		<div class="row">
		<div class="col-md-12">
			<h2 class="title-minendu format-size">${material.descripcionMaterial}</h2>
		</div>
	</div>

	<c:if test="${(material.situacionLeccionMaterial.codigoRegistro==3) or (material.situacionLeccionMaterial.codigoRegistro==6)}">
	<div class="row">
		<div class="col-md-12">
   			<div class="text-format resetCSS" style="margin-bottom: 30px">${material.contexto}</div>
		</div>
	</div>
	</c:if>

	<c:if test="${(material.situacionLeccionMaterial.codigoRegistro==1) or (material.situacionLeccionMaterial.codigoRegistro==2)}">
	<div class="row">
		<div class="col-md-12">
			<audio id="musicPR" preload="true">
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

	traducirSub();
	var music = document.getElementById('musicPR'); // id for audio element

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

<c:choose>
	<c:when test="${evaluacionDetalle.codigo>0}">
		<script
			src="${pageContext.request.contextPath}/assets/js/page/evaluacion/preg-rspt-evaluacion.js"
			type="text/javascript"></script>

	</c:when>
	<c:otherwise>
		<script src="${pageContext.request.contextPath}/assets/js/page/preg-rspt.js" type="text/javascript"></script>
	</c:otherwise>
</c:choose>

<script type="text/javascript">

if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){

		monedaGemaObtenidas();
   		BuscarIntentosRealizados();
}

</script>

<script  type="text/javascript">
$("#modal-app-material").draggable({
    handle: ".modal-header"
});

</script>