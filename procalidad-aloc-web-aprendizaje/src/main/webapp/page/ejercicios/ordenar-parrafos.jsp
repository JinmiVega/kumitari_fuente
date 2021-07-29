<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- ordenar-parrafos -->
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
			<input id="codigoLeccion" type="hidden" value="${materialTipoEjercicioBean.leccionMaterialBean.codigo}">
			<input id="codigoTipoEjercicio" type="hidden" value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">
			<input id="urlSiguiente" type="hidden" value="${material.codigo}">
			<!-- Intentos por ejercicios -->

			<input id="intento1" type="hidden" value="${intentoConfiguracionBean.intento1}">
			<input id="intento2" type="hidden" value="${intentoConfiguracionBean.intento2}">
			<input id="intento3" type="hidden" value="${intentoConfiguracionBean.intento3}">

			<!-- CodigoLengua -->
			<input id="codLengua" type="hidden" value="${lengua.codigo}">
			<!-- CodigoUsuario -->
			<input id="codUsuario" type="hidden" value="${usuario.codigo}">
				<div class="col-md-12" id="tituloOrdenarParrafo">
				<!--  	<h4 class="sub-title-app">${materialTipoEjercicioBean.titulo}</h4>
					<p class="title-minendu ttpregunta" id="title-preg">${ordenarParrafoCabecera.titulo}</p> --><!-- Kay chaqwasqa qillqasqata ñiqinchaykuy -->
				</div>
			</div>


			<div class="row">
			  <div class="col-md-12" id="parrafos">
<!--				<ul id="sortable">
				<c:forEach var="parrafo" items="${lstOrdenarParrafoBeans}">
				  <li class="ui-state-default" id="${parrafo.numeroOrden}">${parrafo.parrafo}</li>
				 </c:forEach>
	  	  <li class="ui-state-default">Kunan pachapiqa Pakucha llaqtaqa quchapa waqtachanpim tarikun. Ñawpaq pachapiqa, Pakucha llaqtaqa hatun pampas kasqa. Chaysi saqsa/lanka pachayuq machucha kasarakuy wasiman mikunata mañakuq yaykusqa. Hinaptinsi, kusa kusa wasiyuq runaqa rupaq yakuwan wischuykusqa. Llakisqas machuqa huk ischu wasiman yaykusqa. Chaypis wawayuq mamalla mikunata qaraykusqa.</li>
				  <li class="ui-state-default">Chaysi machuchaqa mamallataqa kaynata nisqa: Ama qipaykita qawarikuspayki Kunanpuni ripuy. Chayllamansi wapurikuqta paraykusqa, yana puyuraqsi pampataqa tutayaykachisqa, runtu chikchipas, nina illapapas mancharikuytas chayaykusqa. Irqi runakunas sutinmanta mamallataqa qaparkachaykusqa. Chaysi mamallaqa qipan qawarikusqanpi illaman tukurqusqa; llaqtañata quchaman tukurqusqa.</li>
				</ul>-->
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
								onclick='validarOrdenParrafo()'
								class='btn btn-primary btn-lg btn-min-width icon-arrow'>
								<i class="icon-arrow-right2"></i>
							</button>
						</c:when>
						<c:otherwise>
						<!--  <a id="btnevaluar"
						   class="btn btn-primary btn-lg icon-arrow"
						   onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'validarOrdenParrafo()' : 'siguiente_ejercicio()'}" >
						   <i class="icon-arrow-right2"></i>
						</a> -->
						<a id="btnevaluar"
						   class="btn btn-primary btn-lg icon-arrow"
						   onclick="validarOrdenParrafo();" >
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
	<script src="${pageContext.request.contextPath}/assets/js/page/ordenar-oracion.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/evaluacion/ordenarParrafoEvaluacion.js"
	type="text/javascript"></script>
	</c:when>
	<c:otherwise>

	<script src="${pageContext.request.contextPath}/assets/js/page/ordenar-oracion.js" type="text/javascript"></script>
	<!-- Js Personal -->
	<script src="${pageContext.request.contextPath}/assets/js/actividad/ordenarParrafo.js" type="text/javascript"></script>
	</c:otherwise>
</c:choose>




<script type="text/javascript">
	//window.onload = function() {
	if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
		traducirSub();
		 
		 BuscarIntentosRealizados();
		 monedaGemaObtenidas();

		}
	listarParrafosTemporal();

	 function listarParrafosTemporal(){
		 var codmte =  $('#codigoMTE').val();
		 var url =  contextPath+"/lengua/listarParrafos";
		 var htmlTitulo = "";
		 var htmlParrafo = "";
		    $.ajax({
		    	 async: true,
		        type : 'GET',
		        data :{p_codmatpej : codmte },
		        url : url,
		      success : function(data)
		      {
		    	  if (data != null) {

		    		  htmlTitulo = htmlTitulo + icono_titulo
							  +"<h4 class='sub-title-app'>"+data[0].materialTipoEjercicioBean.titulo+"</h4>" +
				  		"<p class='title-minendu ttpregunta' id='title-preg'>"+data[0].ordenarParrafoCabeceraBean.titulo+"</p>";
		    		//console.log(htmlTitulo);
		    		  document.getElementById("tituloOrdenarParrafo").innerHTML=htmlTitulo;
		    		  htmlParrafo = "<ul id='sortable'>";
		    		  for (var int = 0; int < data.length; int++) {
		    			  htmlParrafo  = htmlParrafo +"<li class='ui-state-default' id='"+data[int].numeroOrden+"'>"+data[int].parrafo+"</li>";
					}
		    		  htmlParrafo=htmlParrafo+"</ul>";
		    		  document.getElementById("parrafos").innerHTML=htmlParrafo;

		    			    $( "#sortable" ).sortable({
		    			      revert: true
		    			    });
		    			    $( "#draggable" ).draggable({
		    			      connectToSortable: "#sortable",
		    			      helper: "clone",
		    			      revert: "invalid"
		    			    });
		    			    $( "ul, li" ).disableSelection();

				}else{

				}

		      },
		      error : function(data) {
		    	//console.log("error ");
		      }
		    });
	 }
	//};
</script>