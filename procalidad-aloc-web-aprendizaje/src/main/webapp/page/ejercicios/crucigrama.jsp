<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <script src="${pageContext.request.contextPath}/assets/js/js/jpit_api.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/js/activity/jpit_activity.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/js/activity/crossword/jpit_activity_crossword.js" type="text/javascript"></script>

	<!-- crucigrama -->
	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fondo-lectura fadeInUp animated">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles/crossword_style2.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles/jquery-ui-custom2.css">
			
			<div class="row">
				<div class="col-md-12">
					<c:if test="${not empty materialTipoEjercicioBean.comprension}">
						<span class="material-style">${materialTipoEjercicioBean.comprension}</span>
					</c:if>
				</div>
			</div>
			
			<div class="row">
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
				<div class="row">
				<div class="col-md-12" id="titulos">

				</div>
			</div>
				<br>
			</div>
			<div class="row" id="jpit_activity_container">
	            <div class="jpit_activity_crossword_content_body col-md-9 col-xs-9">
	                <div id="jpit_activity_crossword"></div>
	            </div>

				<div class="col-md-3 col-xs-3" id="alternativas" >
					<ul id="lst-rsp-oracion">
					</ul>
				</div>
			</div>
			<c:if test="${not empty materialTipoEjercicioBean.subTitulo}">
				<div class="row">
					<div class="col-md-12" style="margin-top: 15px;">
				   		<div class="cont-guia">
							${materialTipoEjercicioBean.subTitulo}
				   		</div>
					</div>
				</div>
			</c:if>

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
						<!-- <a id="btnevaluar" class="btn btn-primary disabled btn-lg jpit_activity_crossword_verify_btn"> Continuar
						</a> -->
					<c:choose>
						<c:when test="${evaluacionDetalle.codigo>0}">
							<button type='button' id='btn_validar_ejercicio'
								onclick='verify_()'
								class='btn btn-primary icon-arrow btn-lg btn-min-width'>
								<i class="icon-arrow-right2"></i>
							</button>
						</c:when>
						<c:otherwise>
						<a id="btnevaluar"
						   class="btn icon-arrow btn-primary btn-lg jpit_activity_crossword_verify_btn ${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'disabled' : ''}" >
						   <i class="icon-arrow-right2"></i>
						</a>
						<a id="btnevaluar2" class="btn icon-refresh btn-primary btn-lg jpit_activity_crossword_modify_btn" style="display: none;"> 
						</a>
						<a style="display:none" id="btnAyuda" class="btn icon-info btn-primary btn-lg jpit_activity_crossword_help_btn"> 
						</a>
						</c:otherwise>
					</c:choose>


					</div>
				</div>
			</div>
		</div>
	</div>
<!-- </div> -->

<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-img.js" type="text/javascript"></script>
 
<c:choose>
	<c:when test="${evaluacionDetalle.codigo>0}">

<script
	src="${pageContext.request.contextPath}/assets/js/actividad/evaluacion/crucigramaEvaluacion.js"
	type="text/javascript"></script>
	</c:when>
	<c:otherwise>
<script src="${pageContext.request.contextPath}/assets/js/actividad/crucigrama.js" type="text/javascript"></script>

	</c:otherwise>
</c:choose>



<script type="text/javascript">
	//window.onload = function() {
	if($('#codEvaluacionDet').val()==''||$('#codEvaluacionDet').val()==0){
		traducirSub();
		monedaGemaObtenidas();
		BuscarIntentosRealizados();
		}
	 ListarEjercicioTemporal();

     function ListarEjercicioTemporal(){
         var codmte =  $('#codigoMTE').val();
         var url =  contextPath+"/lengua/listarCrucigrama";
         var html = "";
         $.ajax({
           async: true,
           type : 'GET',
           data :{idEjercicio : codmte },
           url  : url,
           success : function(data) {
             tamanoPReg=[];
             for(var m=0;m<data.length;m++)
             {
                 tamanoPReg.push(data[m].codigo);
             }

                 datos=data;
                 init_puzzle();

                if (data != null) {
                 var ayudas='';
                 for(var m=0;m<tamanoPReg.length;m++){
                 	if (datos[m].orden==0){
                 ayudas=ayudas + '<li style="cursor:auto"><span>'+(m+1)+'.-'+' '+ data[m].texto+'</span></li>'
                 	}else{
                 		ayudas=ayudas + '<li style="cursor:auto"><span style="font-size: 12px;">'+(data[m].orden)+'.-'+' '+ data[m].texto+'</span></li>'
                       	}
                 }

               $('#lst-rsp-oracion').html(ayudas);
               $('#titulos').html(icono_titulo+' <h4 class="sub-title-app">' + data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo + '</h4>' );





                   }else{
                        return false;
                   }
                   $("#btnevaluar").removeClass("disabled");
                 },
               error : function(data) {
                       //console.log("error ");
                       }
                     });
                   }
     
	//};
</script>   
<style>
.cont-guia{
    min-height: 94px;
    background: #bbece3;
    color: #1fa09a;
    font-size: 13px;
    line-height: 18px;
    padding: 20px;
    padding-right: 40px;
    word-spacing: 2px;
    font-weight: 400;
    border: 1px solid #c0ffff;
    text-rendering: optimizeLegibility;
    border-radius: 4px;
    margin-bottom: 20px;
    position: relative;
    display: table;
    width: 100%;
}
</style>    