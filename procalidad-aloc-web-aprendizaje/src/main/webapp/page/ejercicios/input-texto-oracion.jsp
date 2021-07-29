<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<style type="text/css">
	.fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}')
	}

	.input-invalid-opt{
        color:#fe3938!important;
        border-bottom:2px solid #fe3938!important;
    }
    .input-valid-opt{
        color:#3ba458!important;
        border-bottom:2px solid #3ba458!important;
    }
</style>

<!-- input-texto-oracion-->
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
										<li><a data-slide="prev" onclick="anterior_ejercicio()" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
										<li><a data-slide="next" onclick="siguiente_ejercicio()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
									</c:if>	
								</c:when>
								<c:otherwise>
										<li><a data-slide="prev" onclick="anterior_ejercicio()" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
										<li><a data-slide="next" onclick="siguiente_ejercicio()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
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
						<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/EyG.png" height="17" style="margin-bottom: 20px;">
					</i>
					<h4 class="sub-title-app">${materialTipoEjercicioBean.titulo}</h4>
				</div>
			</div>

				<div class="row">
					<div class="col-md-12">
						<div class="title-minendu ttpregunta" id="title-preg-${pregunta.codigo}" style="margin-top: 30px;margin-bottom: 20px">${pregunta.descripcion}</div>
					</div>
					<div class="col-md-12">
						<div id="text-input-parrafo">
							<!-- Lorem ipsum dolor sit amet,
							<input type="text" name="" value="" placeholder="...">
							adipisicing elit. Pariatur dolorem, deleniti reiciendis, distinctio nobis consectetur
							<input type="text" name="" value="" placeholder="...">
							nihil voluptatibus dolorum harum asperiores
							<input type="text" name="" value="" placeholder="...">
							atque ab in aliquam? Fugiat libero impedit qui accusantium maiores. -->
						</div>
					</div>
				</div>

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
						<br>
					<c:choose>
						<c:when test="${evaluacionDetalle.codigo>0}">
							<button type='button' id='btn_validar_ejercicio'
								onclick='valorEvaluacion()'
								class='btn btn-primary icon-arrow btn-lg btn-min-width'>
								<i class="icon-arrow-right2"></i>
							</button>
						</c:when>
						<c:otherwise>
						<a id="btnevaluar"
						   class="btn btn-primary btn-lg icon-arrow"
						   onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'valor()' : 'valor()'}" >
						   <i class="icon-arrow-right2"></i>
						</a>
						</c:otherwise>
					</c:choose>


					</div>
				</div>
			</div>
		</div>
	</div>





<c:choose>
	<c:when test="${evaluacionDetalle.codigo > 0}">
<script
	src="${pageContext.request.contextPath}/assets/js/page/evaluacion/completar-palabras-script_Evaluacion.js"
	type="text/javascript"></script>

	</c:when>
	<c:otherwise>
<script src="${pageContext.request.contextPath}/assets/js/actividad/completar-palabras-script.js" type="text/javascript"></script>

	</c:otherwise>
</c:choose>

<script type="text/javascript">
if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
	traducirSub();
	monedaGemaObtenidas();
	BuscarIntentosRealizados();
}

	ListarEjercicio();

</script>