<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- relacion-variada -->
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
			<input id="codigoMTE" type="hidden" value="${materialTipoEjercicioBean.codigo}">
			<input id="codLeccion" type="hidden" value="${materialTipoEjercicioBean.leccionMaterialBean.codigo}">
			<input id="codTipoEjer" type="hidden" value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">
			<input id="intent1" 	type="hidden" value="${intentoConfiguracionBean.intento1}">
			<input id="intent2" 	type="hidden" value="${intentoConfiguracionBean.intento2}">
			<input id="intent3" 	type="hidden" value="${intentoConfiguracionBean.intento3}">
				<div class="col-md-12" id="titulos"></div>
			</div>
			<div class="row">
			  <div class="col-md-6 col-xs-6" id="pregunta2">
			  </div>
			  <div class="col-md-6 col-xs-6" id="prueba">
			  </div>

			  <div class="col-md-6 col-xs-6" id="prueba2">
			   <!-- <ul id="lst-resp-img">
				    <li data-rsp="3">
				    	<img src="${pageContext.request.contextPath}/assets/images/person1.jpg" alt="" class="img-responsive"><label class="rspt"></label>
				    </li>
				    <li data-rsp="1"><img src="${pageContext.request.contextPath}/assets/images/person2.jpg" alt="" class="img-responsive"><label class="rspt"></label>
				    </li>
				    <li data-rsp="2">
				    	<img src="${pageContext.request.contextPath}/assets/images/person3.jpg" alt="" class="img-responsive"><label class="rspt"></label>
				    </li> -->
			    </ul>
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
								class='btn btn-primary btn-lg btn-min-width icon-arrow' >
								<i class="icon-arrow-right2"></i>
							</button>
						</c:when>
						<c:otherwise>
						<%-- <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/cargaMaterialController/ejercicio-04"> Continuar --%>
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
	src="${pageContext.request.contextPath}/assets/js/page/evaluacion/relacionar-variada-evaluacion.js"
	type="text/javascript"></script>

	</c:when>
	<c:otherwise>

		<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-variada.js" type="text/javascript"></script>

	</c:otherwise>
</c:choose>


<script src="${pageContext.request.contextPath}/assets/js/actividad/RelacionVariada.js" type="text/javascript"></script>

<!--<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-img.js" type="text/javascript"></script> -->

<script type="text/javascript">
	//window.onload = function() {
	if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
   		monedaGemaObtenidas();
   		BuscarIntentosRealizados();
   		traducirSub();
		}
	
   		ListarEjercicio();

   	$.browser = {}; 
   	/*(function () {
   		console.log('BROWSER 1');
		$.browser.msie = false;
		$.browser.version = 0;
		if(navigator.userAgent.match(/MSIE ([0-9]+)\./)){
			$.browser.msie = true;
			$.browser.version = RegExp.$1;
		}
   	})();*/
   	
	//};
</script>