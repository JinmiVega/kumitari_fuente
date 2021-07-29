<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- arrastrar-oracion -->
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
			<div class="row">
			<input id="codEvaluacionDet" type="hidden"  value="${evaluacionDetalle.codigo}">
			<input id="intent1" type="hidden" value="${intentoConfiguracionBean.intento1}">
			<input id="intent2" type="hidden" value="${intentoConfiguracionBean.intento2}">
			<input id="intent3" type="hidden" value="${intentoConfiguracionBean.intento3}">
			<input id="codigoMTE" type="hidden" value="${materialTipoEjercicioBean.codigo}">
			<input id="codLeccion" type="hidden" value="${materialTipoEjercicioBean.leccionMaterialBean.codigo}">
			<input id="codTipoEjer" type="hidden" value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">
				<div class="col-md-12" id="titulos">
				</div>
			</div>
			<div class="row">
			  <div class="col-md-9 col-xs-9">
			    <div id="lst-oracion">
			   <!-- Lorem ipsum dolor sit amet,<label data-rsp="3"><span class="rspt"></span></label>
			    input consectetur adipisicing elit, sed do eiusmod
			    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
			    consequat. Duis aute irure dolor <label data-rsp="2"><span class="rspt"></span></label>
			    input in reprehenderit in voluptate velit esse
			    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
			    proident, <label data-rsp="1"><span class="rspt"></span></label>
			    input sunt in culpa qui officia deserunt mollit anim id est laborum. -->
			    </div>
			  </div>
			  <div class="col-md-3 col-xs-3" id="alternativas" >
			    <!--<ul id="lst-rsp-oracion">
			    <li data-preg="1"><span>Llaqtapa sutin</span></li>
			    <li data-preg="2"><span>Kawsaykunapa sutin</span></li>
			    <li data-preg="3"><span>Uywakunapa sutin</span></li>
			    </ul> -->
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
								class='btn btn-primary icon-arrow btn-lg btn-min-width' >
								<i class="icon-arrow-right2"></i>
							</button>
						</c:when>
						<c:otherwise>
							<a id="btnevaluar"
							   class="btn btn-primary icon-arrow btn-lg ${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'disabled' : ''}"
							   onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'valor()' : 'siguiente_ejercicio()'}" >
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
	<c:when test="${evaluacionDetalle.codigo>0}">
<script
	src="${pageContext.request.contextPath}/assets/js/page/evaluacion/relacionar-oracion-evaluacion.js"
	type="text/javascript"></script>
<%-- <script
	src="${pageContext.request.contextPath}/assets/js/actividad/evaluacion/ArrastrarOracionEvaluacion.js"
	type="text/javascript"></script>--%>
	</c:when>
	<c:otherwise>

	<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-oracion.js" type="text/javascript"></script>

	</c:otherwise>
</c:choose>


	<script src="${pageContext.request.contextPath}/assets/js/actividad/ArrastrarOracion.js" type="text/javascript"></script>

	<script type="text/javascript">
		//window.onload = function() {
		if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
			monedaGemaObtenidas();
			traducirSub();
	   		BuscarIntentosRealizados();
	   		
			}
			
	   		ListarEjercicio();

		//};
	</script>