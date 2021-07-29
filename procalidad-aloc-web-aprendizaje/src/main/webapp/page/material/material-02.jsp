<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- marial 02 -->

	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fondo-lectura fadeInUp animated">
			<span class="bg-img-mt-top"></span>

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
						<li><a id="glosario-link" onclick="mostrarGlosario()" href="#">Glosario <i class="fa fa-sort-alpha-desc"></i></a></li>
						<li><a data-slide="prev" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
						<li><a data-slide="next" onclick="irHaciaEjercicios()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
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

			<c:if test="${not empty material.indicacion}">
				<div class="row">
					<div class="col-md-10" id="nav-link-name">
								<!-- <i class="icon-pencil pull-left pencil-styel"></i> -->
								<i class="pull-left img-icon-indicacion">
									<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS.png" height="20px" style="margin-bottom: 40px;">
								</i>
								<h4 class="sub-title-app format-size">${material.indicacion}</h4>
								<br>
					</div>
				</div>
			</c:if>
			
			<div class="row">
				<div class="col-md-10">
					<img src="${pageContext.request.contextPath}/assets/images/fondo-mterial/audio-fondo.jpg" alt="" class="img-responsive" style="border-radius: 20px;opacity: 0.7;">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-10 text-center">
					<h2 class="title-minendu format-size">${material.descripcionMaterial}</h2>
				</div>
			</div>

			<div class="row" style="display: none;">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-10">
							<div class="text-format resetCSS">${material.contexto}</div>
						</div>
						<div class="col-md-2" style="display: none;">
							<div id="show-text">
						   		<span id="btn_ojo_show" data-show="0" class="icon-minedu-ver-texto"></span>
						   		<div id="content-text-audio">
									<c:choose>
										<c:when test="${not empty material.comentario}">
											<span class="pull-left" style="margin-right: 6px;"><img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/LIBRO-1.png" width="25px"></span>
											${material.comentario}
										</c:when>
										<c:otherwise>
											Sin comentario
										</c:otherwise>
									</c:choose>
						   		</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-10">
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
			
			<c:if test="${not empty material.comentario}">
				<br>
				<div class="row">
				<c:choose>
					<c:when test="${lenguaBean.codigo==24}">
						<div class="col-md-10">
					   		<div id="content-text-castellano">
								${material.comentario}
					   		</div>
						</div>
					</c:when>
					<c:otherwise>
					    <div class="col-md-10">
							<span onclick="mostrarDivNew()" id="idShowIndGram">
					   				<i class="icon-notebook"></i>
					   		</span>
						</div>
						<div class="col-md-10">
					   		<div id="content-text-info">
					   			<span id="content-icon-m">
					   				<i class="icon-notebook"></i>
					   			</span>
								${material.comentario}
								<span class="close-conten" onclick="ocultarDivNew()"></span>
					   		</div>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			</c:if>

			<div class="row">
				<br>
				<div class="col-md-10">
					<div class="form-group text-center">
						<a id="btnNextMaterial" class="btn btn-primary icon-arrow btn-lg" onclick="irHaciaEjercicios()" href="#"><i class="icon-arrow-right2"></i></a>
					</div>
				</div>
			</div>

		</div>
	</div>
<script type="text/javascript" charset="utf-8">
	traducirSub();
	function skip() {
	    music.currentTime += 2;
	}

	function skip1() {
	    music.currentTime += -2;
	}

	</script>