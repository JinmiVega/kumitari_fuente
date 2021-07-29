<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- sopa-letras -->
	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fondo-lectura fadeInUp animated">

			<div class="row main-nav-pag">
				<div class="col-md-7">
					<c:if test="${not empty materialTipoEjercicioBean.comprension}">
						<span class="material-style">${materialTipoEjercicioBean.comprension}</span>
					</c:if>
				</div>
				<div class="col-md-5">
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
				<input id="codigoMaterialTipoEjercicio" type="hidden" value="${materialTipoEjercicioBean.codigo}">
				<input id="codigoLeccion" type="hidden" value="${materialTipoEjercicioBean.leccionMaterialBean.codigo}">
				<input id="codigoTipoEjercicio" type="hidden" value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">

				<div class="col-md-12" id="tituloOrdenarParrafo">
				</div>
			</div>


			<div id="baseSL" class="row">
				<div class="col-md-12">
					<div style="display: flex">
						<div id='play_content'></div>
						<div id='words'></div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-md-12">
					<div class="form-group text-center">
						<br>
			 			<a id="btnevaluar"
						   class="btn btn-primary btn-lg icon-arrow ${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'disabled' : ''}"
						   onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'siguiente_ejercicio()' : 'siguiente_ejercicio()'}" >
						   <i class="icon-arrow-right2"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>


<!--======= Customize =========-->
<script src="${pageContext.request.contextPath}/assets/js/wordfind.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/wordfindgame.js"></script>

<!-- Js Personal -->
<script src="${pageContext.request.contextPath}/assets/js/page/sopa-letras.js" type="text/javascript"></script>

<script type="text/javascript" charset="utf-8">
	var words = ['HOLA', 'MOLINA', 'FOXLOVE', 'PERU', 'MATIUS', 'LEONES'];
	traducirSub();
</script>