<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro de carga directa</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/summernote/summernote.css">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

    <style>
          .thumb {
            height: 300px;
            border: 0px solid #000;
            margin: 10px 5px 0 0;
            max-height: 300px;
            max-width: 300px;
            overflow: hidden;
          }
          .thumb-mini {
            height: 180px;
            border: 0px solid #000;
            margin: 10px 5px 0 0;
            max-height: 120px;
            max-width: 120px;
            overflow: hidden;
          }

          .thumb2{
		    border: 0px solid #000;
		    margin: 10px 5px 0 0;
		    max-height: 30%;
		    max-width: 30%;
		    overflow: hidden;
		  }
		  .cke_textarea_inline {
			border: 1px solid #ccc;
			overflow-y: scroll;
	    	height: 122px;
	    	resize: vertical;
			/*min-height: 300px;*/
		  }
		  .note-editor .btn{
			background-color:#fff !important;
			border:1px solid #ccc !important;
		  }
		  .note-toolbar{
			position: absolute;
			z-index: 1;
			top: -31px;
			left: 0px;
	      }
	      #left-md-material{
	    	width:260px !important;
	      }
	      #right-md-material {
	    	width: calc(100% - 260px);
	      }
	      .note-popover .popover-content, .panel-heading.note-toolbar{
	      	padding:0px !important;
	      }
	      .note-popover .popover-content>.btn-group, .panel-heading.note-toolbar>.btn-group{
	      	margin-right:1.5px !important
	      }
		  .note-editor .btn-fullscreen{
		  	display:none
		  }
		  .note-btn-group.btn-group.note-insert .btn:nth-child(1),.note-btn-group.btn-group.note-insert .btn:nth-child(3),.note-btn-group.btn-group.note-view .btn{
		  	display:none
		  }
		  #valores_lengua select {
		    width: 160px;
		  }
		  .panel-heading.note-toolbar .dropdown-menu.note-check li a i{
		  	display:none !important;
		  }
		  .btn-codeview{
		  	display:block !important;
		  }
		  .note-fontname{
		  	display:none
		  }
		  div[class^="ui-helper-hidden-accessible"]{
		  	display:none !important;
		  }
		  .custom-control-indicator{
		  	background-color:#a1a4a7; 
		  }
    </style>
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="#" class="navbar-brand"><img id="logo-k" alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text" style="font-size: 1.54rem;"><img alt="stack admin logo" src="${pageContext.request.contextPath}/assets/img/Logo-Kumitsari-white.png" class="brand-logo"></h2></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="fa fa-ellipsis-v"></i></a></li>
          </ul>
        </div>
        <div class="navbar-container content container-fluid">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
              <jsp:include page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
          <jsp:include page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
      </div>
    </div>

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item">General
                  </li>
                  <li class="breadcrumb-item active">Material
                  </li>
                  <li class="breadcrumb-item active">Carga directa
                  </li>
                  <!-- <li class="breadcrumb-item active">Carga material
                  </li>
                  -->
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title">Registro de carga directa</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                 <!--  <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div> -->
                              </div>

                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                        <div class="form-body">
											<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
                                       		<div class=""  id="create_actividad" >
										      <f:form class="form" id="frmregistromodal" name="frmregistromodal" method="post" action="grabarleccion">
										      <div class="dialogx" role="document">
										        <div class="row">
										          <div class="header">
										         	<input type="hidden" id="modalIdTipoEjercicio" value=""/>
										          </div>
										        </div>
										        <div id="content-md-materail">
								                  <div id="left-md-material">
								                    <div id="md-material-search" class="col-xs-12">
								                      <div class="card-block" style="padding: 1.5rem 0px !important;">
								                        <fieldset>
								                          <div class="input-group">
								                            <input type="text" id="inputSearchExerciseByName" class="form-control" placeholder="Buscar ejercicio..." aria-describedby="button-addon4" onkeyup="buscarEjercicioXNombre()">
								                            <span class="input-group-btn" id="button-addon4">
								                              <button class="btn btn-primary" type="button" onclick="buscarEjercicioXNombre()"><i class="ft-search"></i></button>
								                            </span>
								                          </div>
								                        </fieldset>
								                      </div>
								                    </div>
								                    <div id="list-md-material" class="media-list">
								                        <div class="visible-scroll always-visible scroll-example height-400">
								                            <div class="vertical-scroll" id="idBodyTablaMenus">
								                            <c:forEach var="tipoEjercicio" items="${lstTipoEjercicio}">
								                            <div class="media fila_seleccionada" id="tr_selecc_${tipoEjercicio.codigoRegistro}" actividad-data="${tipoEjercicio.codigoRegistro}" onclick="cargarContenido(${tipoEjercicio.codigoRegistro});seleccionarFilaTabla('${tipoEjercicio.codigoRegistro}');listarMaterialTipoEjercicio();">
								                                <a class="media-left" href="#">
								                                <!-- ${tipoEjercicio.orden} -->
								                                  <img class="media-object" src="${pageContext.request.contextPath}/app-assets/images/portrait/small/avatar-tipo-ejercicio.png" alt="Generic placeholder image" style="width: 44px;height: 44px;">
								                                </a>
								                                <div class="media-body">
								                                  <h4 class="media-heading"><small id="tr_selecc_nameExc_${tipoEjercicio.codigoRegistro}">${tipoEjercicio.nombreLargo}</small></h4>
								                                  <p id="tr_selecc_text_${tipoEjercicio.codigoRegistro}" class="fila_seleccionada_text">${tipoEjercicio.valor1}</p>
								                                </div>
								                              </div>
								                            </c:forEach>
								                            </div>
								                        </div>
								                    </div>
								                  </div>

								                  <div id="right-md-material">
								                    <div class="row">
								                      <div class="col-xs-12">
								                        <div class="card mb-0">
								                          <div class="card-block pb-1 pt-1 pl-1 pr-1">
								                            <div class="row">
								                              <div class="col-md-5 form-group  mb-0">

								                                <div id="content-lengua-active">
								                                  <h3>
								                                  	<input type="hidden" value="${lenguaBean.codigo}" id="modalTxtIdLengua"/>
								                                  </h3>
								                                </div>

								                                <div id="valores_lengua" >
								                                  <div>
								                                  	<span class="vl_txt_nivel">Lengua</span>:
								                                	<f:select id="cboLenguazzz" path="lengua.codigo" class="form-control input-sm" onchange="cargarModalNiveles()">
								                                        <f:option value="0">Seleccione</f:option>
								                                        <f:options items="${lstLengua}"
								                                        				itemValue="codigo"
								                                        				itemLabel="nombre"/>
								                                    </f:select>
								                                  </div>
								                                  <div>
								                                    <span class="vl_txt_nivel">Nivel</span>:
								                                    <f:select id="modalCboNivel" path="nivel.codigoRegistro" class="form-control input-sm" onchange="cargarModalSubNiveles()">
								                                       <f:option value="0">Seleccione</f:option>
								                                       <%-- <f:options items="${lstNivel}"
								                                                  itemValue="codigoRegistro"
								                                                  itemLabel="nombreCorto"/> --%>
								                                    </f:select>
								                                  </div>
								                                  <div>
								                                    <span class="vl_txt_nivel">Sub nivel</span>:
								                                    <f:select id="modalCboSubNivel" path="subNivel.codigoRegistro" class="form-control input-sm" onchange="cargarModalUnidades()">
									                                    <f:option value="0">Seleccione</f:option>
									                                    <f:options items="${lstSubNivel}"
											                                       itemValue="codigoRegistro"
											                                       itemLabel="nombreCorto"/>
								                                    </f:select>
								                                  </div>
								                                  <div>
								                               		<span class="vl_txt_nivel">Unidad</span>:
								                                    <f:select id="modalCboUnidad" path="unidad.codigoRegistro" class="form-control input-sm" onchange="cargarContenido('999')">
								                                    	<f:option value="0">Seleccione</f:option>
								                                        <f:options items="${lstUnidad}"
										                                           itemValue="codigoRegistro"
										                                           itemLabel="nombreCorto"/>
								                                    </f:select>
								                                  </div>
								                              </div>
								                            </div>
								                            <div class="form-group col-md-7 mb-0">
								                                <div class="row" id="edicion_actividad_actividad" >
								                                  <div id="content_unidad_mtp" class="form-group col-md-8 mb-0" style="display: none">
								                                    <label for="unidadSelect" class="mb-0">Unidad</label>
								                                     <f:select id="modalSelectCboUnidad" path="unidad.codigoRegistro" class="form-control input-sm">
								                                        <f:options items="${lstUnidad}"
										                                           itemValue="codigoRegistro"
										                                           itemLabel="nombreCorto"/>
								                                    </f:select>
								                                  </div>

								                                  <div id="content_leccion_mtp" class="form-group col-md-12 mb-0">
								                                    <div class="form-group mb-1 col-md-9">
								                                    	<input id="modalIdLeccion" type="hidden" value="">
								                                        <label for="projectinput1" class="mb-0">Lecci&oacute;n</label>
																		<!-- buscarLeccionMaterial(); -->
								                                      <f:select id="modalCboLeccion" path="leccion.codigo" onchange="cargarComboMaterial();editarLeccionCargarModal();" class="form-control input-sm">
								                                            <f:option value="0" label="Seleccione"></f:option>
								                                            <f:options items="${lstLeccion}"
										                                               itemValue="codigo"
										                                               itemLabel="nombre"/>
								                                        </f:select>

								                                        <input type="text" id="modalTxtNombreLeccion" value="" class="form-control" name="fname" style="display: none">

								                                         <input id="modalIdMaterial" type="hidden" value="">
									                                     <label for="projectinput1" class="mb-0">Material</label>
								                                       <!--  onchange="listarMaterialTipoEjercicio();limpiarMaterialTipoEjercicio()"  -->
									                                       <f:select id="modalCboMaterial" path="material.codigo"
									                                    	onchange="listarMaterialTipoEjercicio();limpiarMaterialTipoEjercicio()"
									                                        class="form-control input-sm">
									                                           <f:option value="0" label="Seleccionar Material"></f:option>
									                                           <f:options items="${lstMaterial}"
									                                                   itemValue="codigo"
									                                                   itemLabel="nombreLeccion"/>
									                                       </f:select>
								                                    </div>

								                                    <div class="col-md-3">
								                                    	<button type="button" id="btn_editar_leccion" onclick="editarLeccionCargarModal()" class="btn btn-outline-success btn-sm mt-2" data-toggle="tooltip" data-original-title="Modificar" data-placement='top'><i class="ft-search"></i></button>
								                                    </div>
								                                  </div>
								                                </div>
								                              </div>
								                          </div>
								                        </div>
								                      </div>
								                    </div>
								                    <div class="row">
								                      <div class="col-xs-12">
								                        <div class="card">
								                          <div id="content-md-frm" class="card-block pt-0 pb-0">

								                          </div>
								                        </div>
								                      </div>
								                    </div>
								                  </div>
								              </div>
										    </div>
										  </div>
										</f:form>
									</div>
                                  </div>
                                </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </section>
        </div>
      </div>
    </div>

    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/galeria-imagen-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" charset="utf-8" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/ui/scrollable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/actividad.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript" charset="utf-8"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
	<script src="${pageContext.request.contextPath}/assets/js/summernote.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/summernote-es-ES.js"></script>
	<!-- END PAGE LEVEL JS-->
	<!-- BEGIN SCRIPT PERSONALIZADO -->
	<script src="${pageContext.request.contextPath}/assets/js/page/general/material/carga-directa-script.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/page/general/material/carga-directa-gestion-script.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/materialTipoEjercicio.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/relacion.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/actividad/relacionVariada.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/actividad/ArrastrarOracion.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/actividad/oracionCompletar.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/actividad/textoPalabraCorrecta.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/palabrasDesordenadas.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/textoTexto.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/crucigrama.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/OrdenarParrafo.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/textoPalabraEncerrada.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/textoTextoImagen.js" type="text/javascript" charset="utf-8"></script>
	<!-- END SCRIPT PERSONALIZADO -->
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script type="text/javascript" charset="utf-8" >

     	$(document).ready(function(){
     		prmCodigo="";
     		validarLeccionMaterial();
	 	});

        function ejercion_modal(){
          $('#create_actividad').modal('show');
          informe_lengua();
        }
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }

      function amv_accion_unidad(){
        $("#content_unidad_mtp").show(100);
        $("#btn_salir_unidad").show(100);

        $("#accionUnidad").hide();
        $("#content_leccion_mtp").hide();
      }
      function amv_accion_unidad_salir(){

    	let idUnidad = $("#modalSelectCboUnidad").val();

        $("#content_unidad_mtp").hide();
        $("#content_leccion_mtp").show(100);
        $("#btn_salir_unidad").hide();
        $("#accionUnidad").show();

        $('#modalCboUnidad').val(idUnidad);


      }
      function capturar_valor(){
          var valorSelect = $("#amv_select_leccion option:selected").text();
          $("#modalTxtNombreLeccion").val("");
          $("#modalTxtNombreLeccion").val(valorSelect);
      }

      // function amv_save() {
      //   $("#edicion_campo_actividad").show(100);
      //   $("#edicion_campo_actividad").show(100);
      //  }

       function amv_salir_edicion_leccion(){
          $("#amv_select_leccion").show(100);
          $("#modalTxtNombreLeccion").hide();
          $("#btn_salir_leccion").hide();
          $("#btn_editar_leccion").show(100);
          $("#btn_save_leccion").show(100);

       }

       function amv_editar_leccion(){
          capturar_valor();
          $("#btn_editar_leccion").hide();
          $("#amv_select_leccion").hide();
          $("#btn_guardar_leccion").show(100);
          $("#btn_nuevo_leccion").show(100);
          $("#btn_salir_leccion").show(100);

          $("#modalTxtNombreLeccion").show(100);
       }

       // function amv_guardar_leccion(){
       //    $("#modalTxtNombreLeccion").hide();
       //    $("#btn_salir_leccion").hide();
       //    $("#btn_guardar_leccion").hide();
       //    $("#amv_select_leccion").show(100);
       //    $("#btn_editar_leccion").show(100);
       //   /*  grabarLeccion(); */
       // }

       // function amv_agregar_leccion(){
       //    $("#modalTxtNombreLeccion").show(100).val("");
       //     $("#btn_guardar_leccion").show(100);
       //    $("#btn_editar_leccion").hide();
       //    $("#amv_select_leccion").hide();
       //    $("#btn_nuevo_leccion").hide();
       //    $("#btn_salir_leccion").show(100);

       // }


      function informe_lengua(){
       /*  $("#list-md-material .media").removeClass("media-active");
        var url="";
        url="actividad/informes.jsp";

        $(this).addClass("media-active");
        $( "#content-md-frm" ).load(url); */
		let valor = "999";
        cargarContenido(valor);

      }

	$("#btn_guardar_leccion").click(function()
 	{
 		var url = "${pageContext.request.contextPath}/cargaMaterialController/" + $("#frmregistromodal").attr("action");
 	 	var p_nombleccion 	= $("#modalTxtNombreLeccion").val();
		var p_codlengua 	= $("#modalTxtIdLengua").val();
		var p_tm2nivel		= $("#modalCboNivel").val();
		var p_tm2subnivel 	= $("#modalCboSubNivel").val();
		var p_tm2unidad 	= $("#modalCboUnidad").val();

		document.getElementById("modalCboLeccion").options[document.getElementById("modalCboLeccion").innerHTML=""];
		document.getElementById("modalCboLeccion").options[document.getElementById("modalCboLeccion").options.length]=new Option("Seleccione", "0");

		if(p_nombleccion != "")
		{
			$.ajax({
	 	 		type 	: "POST",
		  		url 	: "${pageContext.request.contextPath}/cargaMaterialController/" + $("#frmregistromodal").attr("action"),
		  		data 	: {nombreleccion:	p_nombleccion,
			  				codigolengua:	p_codlengua,
			  				codigonivel:	p_tm2nivel,
			  				codigosubnivel:	p_tm2subnivel,
			  				codigounidad:	p_tm2unidad},
		  		success : function(data)
		  		{
		  			for(var i=0; i<data.length;i++)
			  		{
						document.getElementById("modalCboLeccion").options[document.getElementById("modalCboLeccion").options.length]=new Option(data[i].nombreLeccion, data[i].codigo);
					}
		  		},
		  		error : function()
		  		{
		  			//console.log("ERROR: ");
		  		}
	 	 	 });
		}
		else
		{
			//alert("Debe ingresar un nombre para la lecci�n.");
		}
	});


	function confirmar_accion(valor)
	{
		prmCodigo=valor;
		//alert(valor);
		$("#idPregunta").val(valor);
		var tipoaccion = accionPregunta;
 		//console.log("acc:" + tipoaccion);
 		var p_codejercicio 	= $("#idEjercicio").val();
		var p_descripcion 	= $("#txtPreguntaDescripcion").val();
		var p_codpregunta =$("#idPregunta").val() == "" ?  0 : $("#idPregunta").val();
		//console.log("cp:" + p_codpregunta);
		if(validarCombos(p_codejercicio)){
			let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarPregunta";
			$.ajax({
					type : 	"POST",
					url	 :	url,
					data : {codejercicio: p_codejercicio,
							descripcion	:p_descripcion,
							pregunta: p_codpregunta},
		  			success : function(data){
              			listadoPreguntaActividad27();
		  				listadoPreguntaActividad();

		  				accionPregunta = 1;
		  				limpiarPreguntaRptas();
		  		  	},
		  		  	error : function(){
			  		  	msg_error();
		  		  		//console.log("ERROR: ");
		  		  	}
			});
		}
		else {
			msg_advertencia("Debe agregar un ejercicio.");
		}
	}

 	function obtenerAudio(){
		document.getElementById("basicInputAudio").click();
	}
	function obtenerImagen(){
		document.getElementById('basicInputFile').click();
	}

	function handleAudioSelect(evt){
		$("#hiddenAud").val("0");
		var fullPath = document.getElementById('basicInputAudio').value;
		if (fullPath) {
		    var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
		    var filename = fullPath.substring(startIndex);
		    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
		        filename = filename.substring(1);
		    }
		    $("#tieneAudio").val("1");
			$("#spanNombreMp3").text(filename);
		}
	}

	function handleFileSelect(evt){
		$("#hiddenImg").val("0");
		var files = evt.target.files; // FileList object
 	    for (var i = 0, f; f = files[i]; i++){
	 	    if (!f.type.match('image.*')){
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	    reader.onload = (function(theFile){
	 	    	return function(e){
	 	        	document.getElementById("contentImg").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	        };
			})(f);
	 	   	reader.readAsDataURL(f);
 	    }
 	   $("#tieneImagen").val("1");
	}

	function obtener_imagen_mini()
    {
    	document.getElementById('files').click();
    }

	function handleFileSelect(evt){
		$("#hiddenImg").val("0");
		var files = evt.target.files; // FileList object
 	    for (var i = 0, f; f = files[i]; i++){
	 	    if (!f.type.match('image.*')){
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	    reader.onload = (function(theFile){
	 	    	return function(e){
	 	        	document.getElementById("contentImg").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	        };
			})(f);
	 	   	reader.readAsDataURL(f);
 	    }
 	   $("#tieneImagen").val("1");
	}


	//::::Steven.d3v
	function handleFileAudio(evt) {
		var files = evt.target.files; // FileList object
 	    // Loop through the FileList and render image files as thumbnails.
 	    for (var i = 0, f; f = files[i]; i++)
 	 	{
	 	      // Only process image files.
	 	      //console.log("file:" + f.type);
	 	    if (!f.type.match('video*'))
	 	 	{
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	      // Closure to capture the file information.
	 	    reader.onload = (function(theFile)
	 	   	{
	 	    	return function(e)
	 	    	{
	 	        // Render thumbnail.
	 	        	document.getElementById("list").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	         /*  var span = document.createElement('span');
	 	          span.innerHTML = ['<img class="thumb" src="', e.target.result,
	 	                            '" title="', escape(theFile.name), '"/>'].join('');
	 	          document.getElementById('list').insertBefore(span, null); */
	 	        };
			})(f);
	 	      // Read in the image file as a data URL.
	 	   	reader.readAsDataURL(f);
 	    }
	}

	function leccionCargarModal(){

		var data = new FormData();
		data.append('liCodLecc',0);
		$("#idLeccion").val("");
		$("#modalCboLeccion").val(0);

			//iniciarBloqueo();
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/cargaMaterialController/leccionCargarModal",
				contentType:false,
		   		processData:false,
		   		cache:false,
				data : data,
				success : function(data){
					//finBloqueo();
					$("#content-md-frm").html(data);
					validarLeccionMaterial();
					//buscarLeccionMaterial();
					//$('#create_actividad').modal('show');

				},
				error : function(){
					//finBloqueo();
					//console.log("ERROR: ");
				}
			});



	}

	function grabarLeccion(){
		var lsAccLecc = "";
		var liLeccion = $("#idLeccion").val() == "" ? 0 : $("#idLeccion").val();
		var lsNomLecc = $("#ejercicioTxtTitulo").val();
		var llSitLecc = $("#cboLeccionSituacion").val();
		var liCodUnid = $("#cboUnidad").val();
		var data = new FormData();
		lsAccLecc = liLeccion=="" ? 1 : 2;
		data.append('liTipoSQL',lsAccLecc);
		data.append('liLeccion',liLeccion);
		data.append('lsNomLecc',lsNomLecc);
		data.append('llSitLecc',llSitLecc);
		data.append('liCodUnid',liCodUnid);
		if(lsNomLecc != ""){
			$.ajax({
	 	 		type : "POST",
		  		url : "${pageContext.request.contextPath}/cargaMaterialController/grabarLeccion",
		  		//contentType:false,
		   		//processData:false,
		   		//cache:false,
		  		data:{liTipoSQL:lsAccLecc,liLeccion:liLeccion,lsNomLecc:lsNomLecc,llSitLecc:llSitLecc,liCodUnid:liCodUnid},
		  		success : function(data){
		  			if(data>0){
		  				$("#idLeccion").val(data);
		  				//console.log("Se ha registrado con éxito.");
		  				if(lsAccLecc==1){
		  					$('#modalCboLeccion').append($('<option>', {
			  				    value: data,
			  				    text: lsNomLecc
			  				}));
		  				} else {
		  					$("#modalCboLeccion  option[value=" + data +"]").text(lsNomLecc);
		  				}
		  				$('#modalCboLeccion').val(data);
		  				$("#base-tab42").click();
		  				buscarLeccionMaterial();
		  				msg_exito();
		  				$("#contentAllImagen").hide();
		  				$("#contentAllAudio").hide();
		  			}
		  		},
		  		error : function(){
		  			//console.log("ERROR: ");
		  			msg_error();
		  		}
	 	 	 });
		}else{
			//alert("Debe ingresar un nombre para la lección.");
		}
	}

	function eliminarLeccion(){
		var liLeccion = $("#modalCboLeccion").val();
		if(liLeccion == "0"){
			//console.log("Debe seleccionar lección para eliminar");
			return false;
		}
		let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarLeccion";
		$.ajax({
			type : 	"POST",
			url	 :	url,
			data : {liLeccion: liLeccion},
  			success : function(data){
  				if(data==1){
  					//console.log("Se eliminó con éxito");
  					msg_exito();
  				} else{
  					//console.log("No se pudo eliminar.");
  					msg_error();
  				}
  				//$("#create_actividad").modal("hide");
  				//buscarLeccionMaterial();
  				 $("#modalCboLeccion").val("0");
  				$("#modalCboLeccion option[value='"+liLeccion+"']").remove();
  				//actividadCargarModal();
  				$("#tbodyLeccion tr#"+liLeccion).empty();
  		  	},
  		  	error : function(){
  		  	//alert("No se pudo ingresar el registro");
  		  		//console.log("ERROR: ");
  		  		msg_error();
  		  	}
		});

	}

	function eliminarLeccionGrilla(liLeccion){
		//var liLeccion = $("#modalCboLeccion").val();
		if(liLeccion == "0"){
			//console.log("Debe seleccionar lección para eliminar");
			return false;
		}
		let url = "${pageContext.request.contextPath}/cargaMaterialController/eliminarLeccion";
		$.ajax({
			type : 	"POST",
			url	 :	url,
			data : {liLeccion: liLeccion},
  			success : function(data){
  				if(data==1){
  					//console.log("Se eliminó con éxito");
  					msg_exito();
  				} else{
  					//console.log("No se pudo eliminar.");
  					msg_error();
  				}

  				//buscarLeccionMaterial();
  				 $("#modalCboLeccion").val("0");
  				$("#modalCboLeccion option[value='"+liLeccion+"']").remove();
  				$("#tbodyLeccion tr#"+liLeccion).empty();
  		  	},
  		  	error : function(){
	  		  	//console.log("No se pudo ingresar el registro");
  		  		//console.log("ERROR: ");
  		  		msg_error();
  		  	}
		});

	}

	function isNull(parametro)
	{
		if(parametro == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

    </script>
  </body>
</html>