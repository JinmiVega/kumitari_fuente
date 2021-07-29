<%@ page  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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
    <title>Descargar archivo offline</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
   	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

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
    	<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                   <li class="breadcrumb-item"><a href="#">General</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Descargar archivo offline</a>
                  </li>
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
                                  <h4 class="card-title">Generar Archivo</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      <!-- 
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                      -->
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                    <div class="col-md-8">

                                        <div class="form-body">
											<div class="row">
											<div class="col-md-3">
	                                              <div class="form-group">
	                                                <label for="">Opción <span class="required">*</span></label> 
	                                                <f:select id="cbTablas"  onchange="escogerTabla()"
														path="accesoBean.estado" 
														class="form-control" >
														<f:option value="0" label="Seleccionar" />
														<f:options items="${lstOpcionDescarga}"
															itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
	                                                 <!--  <select id="cbTablas" onchange="escogerTabla()" class="form-control" >
	                                                        <option value="" selected disabled="disabled">Seleccionar </option>
	                                                   		<option value="4">Docente</option>
	                                                   		<option value="5">Inscripción</option>
	                                                   		<option value="6">Matrícula</option>
	                                                   		 <option value="1">Usuarios Academicos</option> 
	                                                   		<option value="2">Seguimiento de Alumnos</option>
	                                                   		<option value="3">Material</option> 
	                                                   </select>  --> 
	                                              </div>
	                                            </div> 
	                                            <div class="col-md-3">
	                                              <div class="form-group">
	                                                <label for="situacionPersonal">Generar de <span class="required">*</span></label>
	                                                <div class="controls">
	                                                   <select id="cbTipoServidor" class="form-control" onchange="escogerTabla()"  >
	                                                  				<!-- <option value="0">Seleccionar</option> -->
	                                                                <option value="1">Servidor Local</option>
	                                                                <option value="2">Servidor Remoto</option>
	                                                    </select>
	                                                </div>
	                                              </div>
	                                            </div> 
	                                           
                                            </div>
                                           <div class="row">
                                           <div class="col-md-6"  id="lblInstitucion"  style="display: none">
	                                              <div class="form-group">
	                                                <label for="">Institución <span class="required">*</span></label>
	                                                <div class="controls">
	                                                   <select id="cbInstitucion"  class="form-control" >
	                                                  	 <option value="0" >Seleccionar </option>
	                                                               
	                                                    </select>
	                                                </div>
	                                              </div>
	                                       </div> 
	                                            <div class="col-md-3" id="lblLengua" style="display: none">
	                                              <div class="form-group">
	                                                <label for="">Lengua <span class="required">*</span></label>
	                                                <div class="controls">
	                                               
	                                                <f:select id="cbLengua"  onchange="escogerTabla()"
														path="accesoBean.estado" 
														class="form-control" >
														<f:option value="0" label="Seleccionar" />
														<f:options items="${lstLenguaBean}"
															itemValue="codigo" itemLabel="nombre" />
													</f:select>
													
	                                                <!--   <select id="cbLengua" class="form-control" onchange="escogerTabla()" >
	                                                  				  <option value="" selected disabled="disabled">Seleccionar </option>
	                                                               
	                                                    </select> --> 
	                                                </div>
	                                              </div>
	                                            </div>
                                           </div> 
                                            <div class="row">
											<div class="form-group col-md-3 mb-2"  id="lblPeriodo" style="display: none">
												<label for="lblPeriodo">Per&iacute;odo </label>
												<div class="controls">
													<f:select id="liCodPeriodo"
														path="accesoBean.estado" 
														class="form-control" >
														<f:option value="0" label="Seleccionar" />
														<f:options items="${lstPeriodo}"
															itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-3 mb-2"  id="lblSemestre" style="display: none">
												<label for="lblCiclo">Semestre </label>
												<div class="controls">
													<f:select id="liCodSemestre"
														path="accesoBean.estado"
														class="form-control" >
														<f:option value="0" label="Seleccionar" />
														<f:options items="${lstCiclo}"
															itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
												</div>
											</div>
                                          </div>
                                          <div class="row">
                                            <div class="form-group col-md-8 text-right">
                                            	 <button  id="generarArchivo"  class="btn btn-primary" onclick="generarArchivo()">Generar Archivo</button>
                                                <!--  <a href="${pageContext.request.contextPath}/offlineKumitsari/descargarArchivoDatos/"  id="enlaceDescargar"   class="btn btn-primary enlaceDescargar" target="_blank" download>Generar Archivo</a>-->
                                            </div>
                                       </div>
                                         <!--  <div class="row">
                                              <div class="form-group col-md-12 text-right">

                                                  <a href="${pageContext.request.contextPath}/offlineKumitsari/descargarArchivo/" id="enlaceDescargar"  class="btn btn-primary" target="_blank" download>Generar Archivo</a>
                                              </div>
                                          </div> -->
                                          <div id="contentDownload">
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
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
   <!-- <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script> --> 
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
  	<script src="http://jqueryfiledownload.apphb.com/Scripts/jquery.fileDownload.js" type="text/javascript"></script>
  	
  	<script
		src="${pageContext.request.contextPath}/assets/js/page/general/offline/offline.js"
		type="text/javascript" charset="utf-8"></script>
		
  	<script type="text/javascript">
  	/*$(document).on("click", "a.enlaceDescargar", function () {
  	    $.fileDownload($(this).prop('href'))
  	        .done(function () { alert('File download a success!'); })
  	        .fail(function () { alert('File download failed!'); });
  	 
  	    return false; //this is critical to stop the click event which will trigger a normal file download
  	});*/

  	$(window).load(function(){
  		 var lsTipoSrv = ${accesoBean.flgServer} +"";
  		if(lsTipoSrv==1){
  			$("#cbTipoServidor option[value='2']").remove();
  			//console.log("configurado para funcionar como local");
  		} else{
  			$("#cbTipoServidor option[value='1']").remove();
  		} 
  		listarInstitucion();
		/*var lsTipoSrv = ${accesoBean.flgServer} +"";
  		if(lsTipoSrv==1){
  			$("#cbTipoServidor option[value='2']").remove();
  			//console.log("configurado para funcionar como local");
  		} else{
  			//console.log("servidor conectado de internet");
  		}*/
  	}); 

  	/**
  	 * 
  	 */



  	var href = $('#enlaceDescargar').attr("href");
  	  	function escogerTabla(){ 
  	  		
  	  		$('#enlaceDescargar').attr("href","");
  	  		$('#enlaceDescargar').attr("href",href+$("#cbTipoServidor").val()+'/'+$("#cbTablas").val()+'/'+$("#cbInstitucion").val()+'/'+$("#cbLengua").val());
  	  		
  	  	    var cbTablas = $('#cbTablas').val();
  	  	    if(cbTablas == 4){
  	  	    	
  	  	    document.getElementById('lblInstitucion').style.display = 'block'; 
			document.getElementById('lblLengua').style.display = 'none';
			document.getElementById('lblPeriodo').style.display = 'none'; 
 			document.getElementById('lblSemestre').style.display = 'none'; 
  	  	    }
  	  	 	if(cbTablas == 5){
	  	    	
   	  	    document.getElementById('lblInstitucion').style.display = 'block'; 
 			document.getElementById('lblLengua').style.display = 'none';
 			document.getElementById('lblPeriodo').style.display = 'block'; 
 			document.getElementById('lblSemestre').style.display = 'block'; 
 			
   	  	    }
  	  	 
  	  		if(cbTablas == 3){
  	  		 document.getElementById('lblInstitucion').style.display = 'none'; 
 			 document.getElementById('lblLengua').style.display = 'block';
 			 document.getElementById('lblPeriodo').style.display = 'none'; 
 			 document.getElementById('lblSemestre').style.display = 'none'; 
  	  		}
  	  		if(cbTablas == 2){
 	  		 document.getElementById('lblInstitucion').style.display = 'none'; 
			 document.getElementById('lblLengua').style.display = 'none';
			 document.getElementById('lblPeriodo').style.display = 'none'; 
			 document.getElementById('lblSemestre').style.display = 'none'; 
 	  		}
  	  		
  	  		if(cbTablas == 6){ // matricula
 	  		 document.getElementById('lblInstitucion').style.display = 'block'; 
			 document.getElementById('lblLengua').style.display = 'none';
			 document.getElementById('lblPeriodo').style.display = 'block'; 
			 document.getElementById('lblSemestre').style.display = 'block'; 
 	  		}
  	  	}
  	  	
  	  	function generarArchivo(){	
  	  	//	debugger;
  			var url = $("#contextPath").val()+"/offlineKumitsari/descargarArchivoDatos";
  			var html = "";
  			var data = new FormData();
  			var liCodServ = $("#cbTipoServidor").val();
  			var liCodOpci = $("#cbTablas").val();
  			var liCodInst = $("#cbInstitucion").val();
  			var liCodLeng = $("#cbLengua").val();
  			var liCodPeriodo = $("#liCodPeriodo").val();
  			var liCodSemestre = $("#liCodSemestre").val();
  			
  			var valida ="1";
  			//console.log("liCodLeng " + liCodLeng);
  			
  			if(liCodOpci == 0 || liCodOpci =="" || liCodOpci == null ){
  				msg_advertencia("Debe seleccionar opción de descarga.");
  				valida ="0";
  				return false;
  			}
  			if(liCodOpci == 4){   // Docente
  				if (liCodInst == 0 || liCodInst =="" || liCodInst == null) {
  					msg_advertencia("Debe seleccionar institución.");
  					valida ="0";
  					return false;
  				}
  			}
  			if(liCodOpci == 5){   // Inscripción
  				if (liCodInst == 0 || liCodInst =="" || liCodInst == null ) {
  					msg_advertencia("Debe seleccionar institución.");
  					valida ="0";
  					return false;
  				}
  				if (liCodPeriodo == 0 || liCodPeriodo =="" || liCodPeriodo == null ) {
  					msg_advertencia("Debe seleccionar periodo.");
  					valida ="0";
  					return false;
  				}
  				if (liCodSemestre == 0 || liCodSemestre =="" || liCodSemestre == null ) {
  					msg_advertencia("Debe seleccionar semestre.");
  					valida ="0";
  					return false;
  				}
  			}
  			
  			if(liCodOpci == 6){   // Matricula
  				if (liCodInst == 0 || liCodInst =="" || liCodInst == null ) {
  					msg_advertencia("Debe seleccionar institución.");
  					valida ="0";
  					return false;
  				}
  				if (liCodPeriodo == 0 || liCodPeriodo =="" || liCodPeriodo == null ) {
  					msg_advertencia("Debe seleccionar periodo.");
  					valida ="0";
  					return false;
  				}
  				if (liCodSemestre == 0 || liCodSemestre =="" || liCodSemestre == null ) {
  					msg_advertencia("Debe seleccionar semestre.");
  					valida ="0";
  					return false;
  				}
  			}
  			
  			if(liCodOpci == 2){ // seguimiento de alumnos
  				if(liCodServ == 0 || liCodInst == "" || liCodLeng == null ){
  					msg_advertencia("Debe completar los filtros.");
  					return false;
  				}  
  			}
  			
  			if(liCodOpci == 3){ // material
  				if(liCodLeng == 0 || liCodLeng =="" || liCodLeng == null  ){
  					msg_advertencia("Debe seleccionar lengua.");
  					return false;
  				}  
  			}
  			
  			 
  				if(valida =="1"){
  					iniciarBloqueo();
  					$.ajax({
  						type : 'POST',
  						data: {liCodServ : liCodServ, 
  							liCodOpci :liCodOpci,
  							liCodInst:liCodInst,
  							liCodLeng:liCodLeng,
  							liCodPeriodo:liCodPeriodo,
  							liCodSemestre:liCodSemestre
  						},
  						url : url,
  						success : function(data) {
  							//console.log("data: " + data);
  							if (data==1) {
  								$("#contentDownload").html('<a href="${pageContext.request.contextPath}/offlineKumitsari/descargarArchivoGenerar/" id="enlaceDescargar"  style="display:None" class="btn btn-primary" target="_blank" download></a>');
  								document.getElementById('enlaceDescargar').click();
  								$("#contentDownload").empty();
  							}else{
  								msg_advertencia(data);
  							}
  						},
  						error : function(data) {
  							//console.log("error de listarTipoDocs :" + data);
  						}, complete: function(data){
  							finBloqueo();
  						}
  					});
  				} 
  		}
  	  	
  	  	function listarInstitucion(){	
  			var url = $("#contextPath").val()+"/offlineKumitsari/listarInstitucionUsuario";
  			var html = "";
  			$.ajax({
  				type : 'POST',
  				contentType:false,
  				processData:false,
  		   		cache:false,
  				url : url,
  				success : function(data) {
  					if (data != null) {
  						for (var i = 0; i < data.length; i++) {
  							$('#cbInstitucion').append($('<option>', { 
  						       	value: data[i].codigo,
  						       	text : data[i].nombreInstitucion
  						   	}));
  						}
  					}else{
  						 $('#cbInstitucion').append($('<option>', { 
  						        value: '0',
  						        text : 'Seleccione'
  						    }));
  					}
  				},
  				error : function(data) {
  					//console.log("error de listarTipoDocs :" + data.error);
  				}
  			});
  		}
  	  	
  	  	
  	  	function listarLenguas(){	
  			var url = $("#contextPath").val()+"/offlineKumitsari/listarInstitucionLengua";
  			var html = "";
  			var data = new FormData();
  			data.append("liInstitu",$('#cbInstitucion').val());
  			$.ajax({
  				type : 'POST',
  				data: data,
  				contentType:false,
  				processData:false,
  		   		cache:false,
  				url : url,
  				success : function(data) {
  					$('#cbLengua').empty();
  					if (data != null) {
  						for (var i = 0; i < data.length; i++) {
  							$('#cbLengua').append($('<option>', { 
  						       	value: data[i].lenguaBean.codigo,
  						       	text : data[i].lenguaBean.nombre
  						   	}));
  						}
  					}else{
  						 $('#cbLengua').append($('<option>', { 
  						        value: '0',
  						        text : 'Seleccione'
  						    }));
  					}
  				},
  				error : function(data) {
  					//console.log("error de listarTipoDocs :" + data.error);
  				}, complete: function(data){
  					escogerTabla();
  				}
  			});
  		}
  	</script>

  </body>
</html>