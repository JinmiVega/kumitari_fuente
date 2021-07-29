<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<style type="text/css">

	.selec-invalid-opt{
        color:#fe3938!important;
        border:2px solid #fe3938!important;
        border-radius: 10px;
    	padding: 3px;
    }
    .selec-valid-opt{
        color:#3ba458!important;
        border:2px solid #3ba458!important;
        border-radius: 10px;
    	padding: 3px;
    }
</style>
<!-- texto-palabras-correctas -->
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
				<div class="col-md-12" id="titulos">
				</div>
			</div>
			<div class="row">
			    <input id="codEvaluacionDet" type="hidden"  value="${evaluacionDetalle.codigo}">
				<input id="intent1" 	type="hidden" value="${intentoConfiguracionBean.intento1}">
				<input id="intent2" 	type="hidden" value="${intentoConfiguracionBean.intento2}">
				<input id="intent3" 	type="hidden" value="${intentoConfiguracionBean.intento3}">
			 	<input id="codigoMTE" 	type="hidden" value="${materialTipoEjercicioBean.codigo}">
				<input id="codLeccion" 	type="hidden" value="${materialTipoEjercicioBean.leccionMaterialBean.codigo}">
				<input id="codTipoEjer" type="hidden" value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">
				<input id="codCabPC" 	type="hidden" value="">
			</div>
			<div class="row">
			  <div class="col-md-12" id="cambio">

			  </div>
			  <div id="contentCambio" style="display:none" ></div>
			  <div class="col-md-12" id="list-Alter">
			  </div>
			</div>

			<!-- <div class="row">
				<div class="col-md-12" id="coment">

						<div id="show-text">
							<div id="content-text-info" class="comentariotPC" style="display:block;position: relative;left: 0px;">

						   		</div>
						</div>

				</div>
			</div> -->

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
						<input id="direccion" type="hidden" value="${material.codigo}">
					<c:choose>
						<c:when test="${evaluacionDetalle.codigo>0}">
						<button type='button' id='btn_validar_ejercicio'
								onclick='valorEvaluacion()'
								class='btn icon-arrow btn-primary btn-lg btn-min-width' >
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

	<div id="box-shadow-div" style="position:absolute;"></div>


<%-- <script src="${pageContext.request.contextPath}/assets/js/page/relacionar-texto.js" type="text/javascript"></script> --%>


<c:choose>
	<c:when test="${evaluacionDetalle.codigo>0}">
	<script src="${pageContext.request.contextPath}/assets/js/actividad/evaluacion/texto-palabraCorrectaEvaluacion.js" type="text/javascript"></script>
	</c:when>
	<c:otherwise>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/texto-palabraCorrecta.js" type="text/javascript"></script>

	</c:otherwise>
</c:choose>

<script type="text/javascript">
	//window.onload = function() {
		//ListarcodMTPTexto();
		if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
			BuscarIntentosRealizados();
			monedaGemaObtenidas();
		
			traducirSub();
			}
		
		//ListarEjercicioTemporal();
		ListarEjercicio();



		 function ListarEjercicioTemporal(){
			 alert('entro ListarEjercicioTemporal');
			 var codmte =  $('#codigoMTE').val();  
			 var url =  context+"/lengua/listarCompletarPalabrasInputTodoxTE";
			 var html = '';
			 $.ajax({
		    	 async: true,
			      type : 'GET',
			      data :{p_codmatpej : codmte },
			      url  : url,
			      success : function(data) {
			    	//console.log(data);
			    	 
			    	 if(data!=null && data.length>0){
			    		 cantidadpalabras = data.length;
			    		 var titulo    = (data[0].textoPalabraEncerradaBean!=null) ? data[0].textoPalabraEncerradaBean.titulo : '';
			    		 var contenido = (data[0].textoPalabraEncerradaBean!=null) ? data[0].textoPalabraEncerradaBean.texto : '';
			    		 var count = -1;
			    		 
			    		 if(contenido!=null && contenido!=''){
			    			 for(var e=0; e<50; e++)
					         {
				    			count++; 
					            var input = '';
					            if(count<=data.length){
					            	for(var i=0;i<data.length ;i++)
						            {
					            	  if(data[i].nroOrden==e)
					            	  {
					            		  input = '<input type="text" data-esp="'+data[i].nroOrden+'" data-texto="'+data[i].valPreguEncrypt+'" >&nbsp('+data[i].palabraEncerrada+')&nbsp';
					            		  break;
					            	  }
						            }
					            	contenido = contenido.replace("%"+e+"%" , input );
					            }else{
					            	break;
					            }
					         }
				    		 
				    		 html += '<p class="sub-title-app" style="text-align: center;">  '+ titulo +' </p>'; 
					    	 html += contenido;
			    		 }
			    		 
				    	 $('#text-input-parrafo').html(html);
			    	 }

			      },
			      error : function(data) {
			    	//console.log("error ");
			      }
			  });
			}
	//};
</script>
<style>
.democlassPC {
    font-weight: 600;
}
</style>