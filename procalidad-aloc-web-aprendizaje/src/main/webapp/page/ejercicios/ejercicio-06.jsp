<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- ejercicio-06 -->
	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fondo-lectura fadeInUp animated">
			<div class="row">
				<div class="col-md-12">
					<nav id="pagination-leccion">
					<ul class="control-box pager">
						<li><a id="glosario-link" onclick="mostrarGlosario()" href="#">Glosario <i class="fa fa-sort-alpha-desc"></i></a></li>
						<li><a data-slide="prev" onclick="anterior_ejercicio()" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
						<li><a data-slide="next" onclick="siguiente_ejercicio()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li><a data-slide="next" href="#myCarousel" class="">
					</a></ul>
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

			<div class="row">
				<div class="col-md-12">
					<h4 class="sub-title-app">Huntay</h4>
					<p class="title-minendu ttpregunta" id="title-preg">Kay qillqasqapi pisiqkunata siminkunawan huntapaykuy.</p>
				</div>
			</div>
			<div class="row">
			  <div class="col-md-12">
				<p class="font-text">
					<select name="" class="select-app">
					 	<option value="" selected="">Seleccionar</option>
					 	<option value="">Kikin suti</option>
					 	<option value="">sutimanta willakuq</option>
					 	<option value="">Qampapas, ñuqapapas, paypapas</option>
					 </select> llaqtakunaqa sutiyuq Pisisqanpi huntachiqninta akllaykuy
				</p>
			  </div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="form-group text-center">
						<br>
						<a id="btnevaluar"
						   class="btn btn-primary icon-arrow btn-lg ${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'disabled' : ''}"
						   onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'siguiente_ejercicio()' : 'siguiente_ejercicio()'}" >
						   <i class="icon-arrow-right2"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>


<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-img.js" type="text/javascript"></script>