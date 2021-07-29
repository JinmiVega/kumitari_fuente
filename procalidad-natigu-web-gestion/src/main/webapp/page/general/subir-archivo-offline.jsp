<%@ page contentType="text/html; charset=UTF-8" %>
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
    <title>Subir archivo offline</title>
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
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                   <li class="breadcrumb-item"><a href="#">General</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Subir archivo offline</a>
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
                                  <h4 class="card-title">Sincronizar archivo</h4>
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
                                    <div class="col-md-12">

                                        <div class="form-body">
                                          <div class="row">
                                            <!-- <div class="col-md-3">
                                              <div class="form-group">
                                                <label for="situacionPersonal">Acción <span class="required">*</span></label>
                                                <div class="controls">
                                                   <select id="cbAccion" class="form-control" data-validation-required-message="Este campo es requerido" onchange="onchangeAccion()" required="required" >
                                                  				 <option value="" selected disabled="disabled" label="Seleccionar"/>
                                                                <option value="1">Sincronización</option>
                                                                <option value="2">Actualización</option>
                                                    </select>
                                                </div>
                                              </div>
                                            </div> -->
                                            <div class="col-md-3">
                                              <div class="form-group"> 
                                                <label for="situacionPersonal">Subir datos a<span class="required">*</span></label>
                                                <div class="controls">
                                                   <select id="cbTipoServidor" class="form-control" onchange="onchangeServidor()" data-validation-required-message="Este campo es requerido" required="required" >
                                                  				<!--  <option value="0">Seleccionar</option> -->
                                                                <option value="1">Servidor Local</option>
                                                                <option value="2">Servidor Externo</option>
                                                    </select>
                                                </div>
                                              </div>
                                            </div> 
                                            <div class="col-md-3">
                                              <div class="form-group">
                                                <label for="situacionPersonal">Escoger archivo <span class="required">*</span></label>
                                                <i title="Formato aceptado txt - Tamaño máximo permitido hasta 20 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado txt - Tamaño máximo permitido hasta 50 megabytes" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i>
                                                <div class="controls">
                                                   <input type="file" id="txtFile" accept="text/plain" multiple name="txtFile[]">
                                                </div>
                                              </div>
                                            </div>
                                            </div>
                                          <div class="row">
                                              <div class="form-group col-md-12 text-right" id="contentSubmit">
												
                                                  <button  id="subirArchivo"  class="btn btn-primary" onclick="subirArchivo()">Sincronizar Archivo</button>
                                              </div>
                                              <div id="contentDownload">
                                              </div>
                                          </div>
                                        </div>

                                    </div>
                                  </div>
                                  <!-- <div id="resultadoSubida"> -->
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </section>
        </div>
      </div>
    </div>
	  <input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
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
    <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
  	<script type="text/javascript">
		$(window).load(function(){
			 var lsTipoSrv = ${accesoBean.flgServer} +"";
	  		if(lsTipoSrv==1){
	  			$("#cbTipoServidor option[value='2']").remove();
	  			//console.log("configurado para funcionar como local");
	  		} else{
	  			$("#cbTipoServidor option[value='1']").remove();
	  		} 
	  	});
	  	function onchangeAccion(e){
	  		//console.log($(this).attr("id"));
	  	}
	  	
	  	$("#cbAccion").on("change", function() {
			var liAccions = $(this).val();
	  		$("#contentSubmit").empty();
			if(liAccions== 1){
  				$("#contentSubmit").html('<button  id="subirArchivo"  class="btn btn-primary" onclick="subirArchivo()">Sincronizar Archivo</button>');

 			} else if(liAccions == 2) {
				$("#contentSubmit").html('<button  id="subirArchivo"  class="btn btn-primary" onclick="subirArchivo()">Sincronizar Archivo</button>');
 			} 
	  	});
	  	function onchangeServidor(){
	  		$("#resultadoSubida").empty();
	  	}
	  	function subirArchivo(){
	
	  		let url = $("#contextPathUrl").val()+"/offlineKumitsari/leerArchivoOffline";
	  		var inputFile = document.getElementById("txtFile");
	  		var file = inputFile.files[0];
	  		var srve = $("#cbTipoServidor").val();
	  		var acci = 1;
	  		var data = new FormData();
	  		data.append("fileOffline",file);
	  		data.append("liCodServ",srve);
	  		data.append("liAccions",acci);
	  		if(srve==0){
	  			msg_advertencia("Debe seleccionar el tipo de servidor");
	  		} else if(document.getElementById("txtFile").files.length == 0){
	  			msg_advertencia("Debe especificar archivo");
	  		} else{
		  		iniciarBloqueo();
		  		$.ajax({
			   		url:url,
			    	type:"POST",
			   		contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data){
			 	       	
			 	       if(data=="1"){
			 	    	  msg_exito();
							tieneData = true;
							//$("#resultadoSubida").html("<ul>");
							//for(var i=0;i<data.length;i++){
							//	$("#resultadoSubida ul").append("<li>"+ data[i] + "</li>");
								//console.log("data:"+ data[i]);
							//}
							//$("#contentDownload").html('<a href="${pageContext.request.contextPath}/offlineKumitsari/leerDescargaArchivo/" id="enlaceDescargar"  style="display:None" class="btn btn-primary" target="_blank" download>Generar Archivo</a>');
							//document.getElementById('enlaceDescargar').click();
							//$("#contentDownload").empty();
							//$("#cbAccion").val("");
							//$("#cbTipoServidor").val("0");
							$("#txtFile").val();
						} else{
							console.log("data: ");
							//msg_advertencia(data);
							msg_advertencia("Archivo no procesado: El formato del archivo debe ser en texto plano, extensión .txt, verificar que el contenido tenga el formato permitido.");
						}
			  			//console.log("ERROR: Se insertó el registro con éxito!!!");
			        },
			 		error: function(er){
			 			console.log("ERROR: ");
			 			//msg_advertencia(er);
			 			msg_advertencia("Archivo no procesado: El formato del archivo debe ser en texto plano, extensión .txt, verificar que el contenido tenga el formato permitido.");
			 		},
			 		complete: function(c){
			 			finBloqueo();
			 		}
				});
	  		}
	  	}

  	</script>

  </body>
</html>