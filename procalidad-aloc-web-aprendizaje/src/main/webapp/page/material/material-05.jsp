<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<style type="text/css">
	.fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}')
	}
	.fondo-img-material{
		background: url('${pageContext.request.contextPath}/assets/images/fondo-mterial/clipboard-1.png'),
					url('${pageContext.request.contextPath}/assets/images/fondo-mterial/clipboard-2.png'),
					url('${pageContext.request.contextPath}/assets/images/fondo-mterial/clipboard-3.png'),
	}
</style>

<!-- marial 05 -->

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
							<li><a id="glosario-link" onclick="mostrarGlosario()" href="#">Glosario <i class="fa fa-sort-alpha-desc"></i></a></li>
							<li><a data-slide="prev" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
							<li><a data-slide="next" onclick="irHaciaEjercicios()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
						</ul>
						</nav>
					</div>
				</div>


				<input type="hidden" id="codmaterialVal" value="${material.codigo}">
				<input type="hidden" id="codmaterialValEncrypt" value="${material.codigoEncrypt}">
		
				<input type="hidden" id="tipoMaterialVal" value="${material.situacionLeccionMaterial.codigoRegistro}">

				<c:if test="${not empty material.indicacion}">
					<div class="row">
						<div class="col-md-12" id="nav-link-name">
									<i class="pull-left img-icon-indicacion">
										<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-2.png"  height="20px" style="margin-bottom: 40px;">
									</i>
									<h4 class="sub-title-app">${material.indicacion}</h4>
									<br>
						</div>
					</div>
				</c:if>

				<c:if test="${not empty material.descripcionMaterial}">
					<div class="row">
						<div class="col-md-12">
							<h2 class="title-minendu format-size">${material.descripcionMaterial}</h2>
						</div>
					</div>
				</c:if>
				
				<div class="row">
					<div class="col-md-12">
						<div class="text-format resetCSS">${material.contexto}</div>
					</div>
					<div class="col-md-12">
					<br>
						<div class="form-group text-center">
							<a id="btnNextMaterial" class="btn btn-primary btn-lg icon-arrow" onclick="irHaciaEjercicios()" href="#">
							<i class="icon-arrow-right2"></i></a>
						</div>
					</div>
				</div>
			</div>
	</div>
<script type="text/javascript" charset="utf-8">
	traducirSub();
	</script>