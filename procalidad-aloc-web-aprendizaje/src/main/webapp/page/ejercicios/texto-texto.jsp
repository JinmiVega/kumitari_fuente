<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- texto-texto -->
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
						<li><a id="glosario-link" href="#">Glosario <i
								class="fa fa-sort-alpha-desc"></i></a></li>
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
						
						<!-- <a data-slide="next" href="#myCarousel" class=""> </a> -->
					</ul>
				</nav>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12" id="titulos"></div>
			<!-- 							<div class="col-md-12"> -->
			<!-- 								<h4 class="sub-title-app">Masachay</h4> -->
			<!-- 								<p class="title-minendu ttpregunta" id="title-preg">Rimaykunapa mañakusqanta tinkuchiykuy</p> -->
			<!-- 							</div>   <input id="codusuariomat" type="text" value="${usuarioMatriculaBean.codigo}"> <input id="codAluMoneG" type="text" value="${alumnoMonedaGBean.codigo}">  -->
		</div>
		<div class="row">
			<input id="codEvaluacionDet" type="hidden"
				value="${evaluacionDetalle.codigo}"> <input id="codigoMTE"
				type="hidden" value="${materialTipoEjercicioBean.codigo}"> <input
				id="codLeccion" type="hidden"
				value="${materialTipoEjercicioBean.leccionMaterialBean.codigo}">
			<input id="codTipoEjer" type="hidden"
				value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">
			<input id="intent1" type="hidden"
				value="${intentoConfiguracionBean.intento1}"> <input
				id="intent2" type="hidden"
				value="${intentoConfiguracionBean.intento2}"> <input
				id="intent3" type="hidden"
				value="${intentoConfiguracionBean.intento3}">


			<div id="ListaTexto" class="col-md-6 col-xs-6"></div>
			<div id="ListaTextoRelacionado" class="col-md-6 col-xs-6"></div>
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
								class='btn btn-primary icon-arrow btn-lg btn-min-width ' >
								<i class="icon-arrow-right2"></i>
							</button>
						</c:when>
						<c:otherwise>
							<a id="btnevaluar"
								class="btn btn-primary icon-arrow btn-lg ${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'disabled' : ''}"
								onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'valor()' : 'siguiente_ejercicio()'}">
								<i class="icon-arrow-right2"></i></a>
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
	src="${pageContext.request.contextPath}/assets/js/page/evaluacion/relacionar-texto-evaluacion.js" type="text/javascript"></script>
	</c:when>
	<c:otherwise>
		<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-texto.js" type="text/javascript"></script>
	</c:otherwise>
</c:choose>

<script src="${pageContext.request.contextPath}/assets/js/actividad/ArrastrarTexto.js" type="text/javascript"></script>
		
<script type="text/javascript">
	if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
		
		traducirSub();
		BuscarIntentosRealizados();
		//BuscarIntentosRealizados();
		monedaGemaObtenidas();
	}

	ListarEjercicioTextoTemporal();

	 function ListarEjercicioTextoTemporal()
	 {
	     var url =  contextPath+"/lengua/ArrastrarTexto";
	     var htmlPreg = "";
	     var htmlRsp = "";
	     var codmte =  $('#codigoMTE').val();
	     $.ajax({
	         async: true,
	       type : 'GET',
	       data :{p_codmatpej : codmte },
	       url : url,
	     success : function(data)
	     {
		     //console.log(data);
	    	// dataValor = data;
	    	      tamanoPReg=[];
	         for(var m=0;m<data.length;m++){
	             tamanoPReg.push(data[m].codigo);
	           }
	
	    	 var listaPreguntas=data;
	    	 var listaRespuestas=data;
	    	 
	    	 var htmlResp = "<ul style='background:#ffffff;' id="+"lst-resp"+">";
	
	         for(var m=0;m<listaRespuestas.length;m++){  
	      	   var resp = listaRespuestas[m]; 
	      	   	htmlResp = htmlResp+"<li style='border-style: none;margin-bottom:1px;' data-rsp="+resp.valAlterEncrypt+" id="+"rela-"+resp.valAlterEncrypt+" ><span id="+resp.valAlterEncrypt+" class='estiloparrafo' >"+resp.texto2+"</span>" +
	     	   		"<span id= "+"idspan"+resp.codigo+" style='font-size: 11px;' class="+"rspt"+"></span></li>";
	         }
	         htmlResp = htmlResp+"</ul>"; 
	         document.getElementById("ListaTextoRelacionado").innerHTML=htmlResp;
	
	    	 shuffle(listaPreguntas);
	       var	htmlPreg = "<ul id="+"lst-preg"+">";
	
	       for(var m=0;m<listaPreguntas.length;m++){
	    	   var preg = listaPreguntas[m];
	           htmlPreg = htmlPreg+"<li data-preg="+preg.valPreguEncrypt+" id=rela-"+preg.valPreguEncrypt+" style='border-radius: 3px;box-shadow: 4px 4px 0px 0px rgba(193, 190, 189, 0.61);'><span style='font-size: 14px;font-weight: 700;color: black;margin-top:10px;'>"+preg.texto+"</span></li>";//<span style='margin-left: 30px;'>
	       }
	       htmlPreg = htmlPreg+"</ul>";
	       document.getElementById("ListaTexto").innerHTML=htmlPreg; 
	        
	       	
	       var p_titu= '' ;
	        if(data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo != null){
	        p_titu=data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo
	       }else{
	        p_titu=''
	       }
	       $('#titulos').html(icono_titulo
	    		   			+	'<h4 class="sub-title-app"> '+ p_titu + '</h4></br>' );
	
	       $("#lst-preg li").draggable({
	    	   helper:'clone'
	    	 });
	
	    	 $("#lst-resp li").droppable({
	    	   drop:eventoDrop
	    	 });
	      
	
	     },
	     complete: function(){  
	//   	 $( ".MsoNormal" ).attr( "style" , "margin-bottom:0em;text-align:justify;"); 
		 $(".MsoNormal").css("margin-bottom","0em"); 
	  
	     }, 
	     error : function(data) {
	    	//console.log("error ");
	     }
	   });
	 }
	
	
</script>
