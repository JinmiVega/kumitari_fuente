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

	.frb-group {
	  margin: 15px 0;
	}

	.frb ~ .frb {
	  margin-top: 15px;
	}

	.frb input[type="radio"]:empty,
	.frb input[type="checkbox"]:empty {
	  display: none;
	}

	.frb input[type="radio"] ~ label:before,
	.frb input[type="checkbox"] ~ label:before {
	  font-family: FontAwesome;
	  content: '\f096';
	  position: absolute;
	  top: 9px;
	  left: 20px;
	  font-size: 20px;
	}

	.frb input[type="radio"]:checked ~ label:before,
	.frb input[type="checkbox"]:checked ~ label:before {
	  content: '\f046';
	}

	.frb input[type="radio"] ~ label,
	.frb input[type="checkbox"] ~ label {
	  position: relative;
	  cursor: pointer;
	  width: 100%;
	  border: 2px solid #ccc;
	  border-radius: 5px;
	  background-color: #f2f2f2;
	}

	.frb input[type="radio"] ~ label:focus,
	.frb input[type="radio"] ~ label:hover,
	.frb input[type="checkbox"] ~ label:focus,
	.frb input[type="checkbox"] ~ label:hover {
	  box-shadow: 0px 0px 3px #333;
	}

	.frb input[type="radio"]:checked ~ label,
	.frb input[type="checkbox"]:checked ~ label {
	  color: #fafafa;
	}

	.frb input[type="radio"]:checked ~ label,
	.frb input[type="checkbox"]:checked ~ label {
	  background-color: #f2f2f2;
	}

	.frb.frb-default input[type="radio"]:checked ~ label,
	.frb.frb-default input[type="checkbox"]:checked ~ label {
	  color: #333;
	}

	.frb.frb-primary input[type="radio"]:checked ~ label,
	.frb.frb-primary input[type="checkbox"]:checked ~ label {
	  background-color: #337ab7;
	}

	.frb.frb-success input[type="radio"]:checked ~ label,
	.frb.frb-success input[type="checkbox"]:checked ~ label {
	    background: #4CBE6B !important;
	    color: #fff !important;
	    border: 2px solid #3ba458 !important;
	}

	.frb.frb-info input[type="radio"]:checked ~ label,
	.frb.frb-info input[type="checkbox"]:checked ~ label {
	  background-color: #5bc0de;
	}

	.frb.frb-warning input[type="radio"]:checked ~ label,
	.frb.frb-warning input[type="checkbox"]:checked ~ label {
	  background-color: #f0ad4e;
	}

	.frb.frb-danger input[type="radio"]:checked ~ label,
	.frb.frb-danger input[type="checkbox"]:checked ~ label {
	    background: #FF4D4C !important;
	    color: #fff !important;
	    border: 2px solid #fe3938 !important;
	}

	.frb input[type="radio"]:empty ~ label span,
	.frb input[type="checkbox"]:empty ~ label span {
	  display: inline-block;
	}

	.frb input[type="radio"]:empty ~ label span.frb-title,
	.frb input[type="checkbox"]:empty ~ label span.frb-title {
		font-size: 16px;
		font-weight: 500;
		/*	  margin: 5px 5px 5px 50px;*/
		padding: 10px 15px 10px 50px;
		display: block;
	}

	.frb input[type="radio"]:empty ~ label span.frb-description,
	.frb input[type="checkbox"]:empty ~ label span.frb-description {
	  font-weight: normal;
	  font-style: italic;
	  color: #999;
	  margin: 5px 5px 5px 50px;
	}

	.frb input[type="radio"]:empty:checked ~ label span.frb-description,
	.frb input[type="checkbox"]:empty:checked ~ label span.frb-description {
	  color: #fafafa;
	}

	.frb.frb-default input[type="radio"]:empty:checked ~ label span.frb-description,
	.frb.frb-default input[type="checkbox"]:empty:checked ~ label span.frb-description {
	  color: #999;
	}
</style>

<!-- marcar-alternativas -->
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
				<div class="col-md-12" id="nav-link-name">
					<i class="pull-left pencil-styel">
						<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/EyG.png" height="17" style="margin-bottom: 20px;">
					</i>
					<h4 class="sub-title-app">${materialTipoEjercicioBean.titulo}</h4>
				</div>
			</div>

			<c:forEach var="pregunta" items="${listaPreguntas}" varStatus = "status">
		        <div class="row tabs_elements" style = "display:none" id="tab_${status.index}" data-id="${pregunta.codigo}">
		          <div class="col-md-12">
		            <div class="title-minendu ttpregunta" id="title-preg-${pregunta.codigo}" style="margin-top: 30px;margin-bottom: 20px">${pregunta.descripcion}</div>
		          </div>
		          <div id="lstRadioSelect-${pregunta.codigo}" class="col-md-12 frb-group">
		              <c:forEach var="alternativa" items="${pregunta.listaAlternativa}">
		                <c:if test="${not empty alternativa.descripcion}">
		                  <div id="divAlter-${alternativa.codigo}" class="content-alter frb frb-default">
		                    <input type="radio" id="radio-button-${alternativa.codigo}" name="radio-button" value="${alternativa.codigo}">
		                    <label for="radio-button-${alternativa.codigo}">
		                      <span class="frb-title">${alternativa.descripcion}</span>
		                    </label>
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
								class='btn btn-primary btn-lg btn-min-width icon-arrow' disabled='true'>
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
	traducirSub();
	if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){

			monedaGemaObtenidas();
	   		BuscarIntentosRealizados();
	}
</script>