<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- texto-imagen -->
	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fadeInUp animated"><!-- fondo-lectura  -->

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

				<div class="col-md-12" id="tituloTextoImagen">

		<!--  			<h4 class="sub-title-app">Masachay</h4>
					<p class="title-minendu ttpregunta" id="title-preg">Sutikunata siqinwan tinkuchiykuy:</p>-->
					</div>
					<%-- <f:form>
					${lstRelacionBean}
					</f:form>
					${lstRelacionBean} --%>
					<%--  <c:forEach var="relacionBean" items="${lstRelacionBean}" varStatus="loop">
			    	<li data-preg="1"><span>${relacionBean.palabra}
			    	 <c:out value="${relacionBean.count}" />
			    	</span>
			    	 </li>
			    </c:forEach> --%>

			</div>
			<br>

			<div class="row">
				  <div class="col-md-12" id="textoImagenPalabra">
				  </div>

				  <div class="col-md-12" id="textoImagenImagen">
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
					<div class="form-group text-center"  id="divEvaluarEjercicio">
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
	src="${pageContext.request.contextPath}/assets/js/page/evaluacion/relacionar-img-evaluacion.js"
	type="text/javascript"></script>

	</c:when>
	<c:otherwise>
	<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-img.js" type="text/javascript"></script>

	</c:otherwise>
</c:choose>



<!-- Js Personal -->
<script src="${pageContext.request.contextPath}/assets/js/actividad/textoImagen.js" type="text/javascript"></script>

<script type="text/javascript">
	//window.onload = function() {
	if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
		traducirSub();
	 	monedaGemaObtenidas();
	 	BuscarIntentosRealizados();
		}

	listarTextoImagenTemporal();

 	 function listarTextoImagenTemporal(){

 		 var codmte =  $('#codigoMTE').val();

 		 var url =  contextPath+"/lengua/listarTextoImagen";
 		 var htmlTitulo = "";
 		 var htmlPalabra = "";
 		 var htmlImagen = "";

 		    $.ajax({
 		    	 async: true,
 		        type : 'GET',
 		        data :{p_codmatpej : codmte },
 		        url : url,
 		      success : function(data)
 		      {
 		    	  if (data != null) {

 		    	        tamanoPReg=[];
 		    	        for(var m=0;m<data.length;m++){
 		    	            tamanoPReg.push(data[m].codigo);
 		    	         }

 		    		  htmlTitulo = htmlTitulo + icono_titulo
 		    		  						  + "<h4 class='sub-title-app' style='opacity: 1;'>"+data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo+"</h4>"+
 		    		  "<p class='title-minendu ttpregunta' id='title-preg'>"+data[0].relacionCabeceraBean.titulo+"</p>";
 		    		  document.getElementById("tituloTextoImagen").innerHTML=htmlTitulo;

 		    		  var listPalabara = data;
 		    		  var listaImagen = data;

 		    		  shuffle(listPalabara);

 		    		  htmlPalabra ="<ul id='lst-preg2' >";

 		    		  for (var int = 0; int < listPalabara.length; int++) {
 		    			  var palabra = listPalabara[int];

 		    			  htmlPalabra = htmlPalabra + "<li data-preg='"+palabra.valPreguEncrypt+"' class='lst-prg-pruebaRelTI'><span style='font-size: 14px;font-weight: 700;color: black;text-transform:none'>"+palabra.texto+"</span></li>";
 					}


 		    		  htmlPalabra = htmlPalabra + "</ul>";
 		    		  document.getElementById("textoImagenPalabra").innerHTML=htmlPalabra;

 		    		  $("#lst-preg2 li").draggable({
 		                  helper:'clone'
 		                });

 		                $("#lst-resp li").droppable({
 		                  drop:eventoDrop
 		                });

 		              shuffle(listaImagen);

 		    		  htmlImagen = "<ul id='lst-resp-img'>";
 		    		  for (var i = 0; i < listaImagen.length; i++) {
 		    			  var img = listaImagen[i];
 		    			  htmlImagen    = htmlImagen+ '<li data-rsp="'+img.valAlterEncrypt+'" class="item-img-lst-o"><span class="circle-borde-rp"><img src="'+contextPath+'/material/'+img.imagen+'" alt="" class="img-circle" style="border-radius: 50%;border: 4px solid #c9c9c9;box-shadow: 0px 3px 16px rgba(0,0,0,0.5);"></span><label class="rspt"></label></li>'
 		    		  }
 		    		  htmlImagen = htmlImagen + "</ul>";
 		    		  document.getElementById("textoImagenImagen").innerHTML=htmlImagen;

 		    		  $("#lst-preg-img li").draggable({
 		    			  helper:'clone'
 		    			});

 		    			$("#lst-resp-img li").droppable({
 		    			  drop:eventoDrop
 		    			});

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