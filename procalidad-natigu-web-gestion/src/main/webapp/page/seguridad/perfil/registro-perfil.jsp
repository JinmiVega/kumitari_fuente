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
    <title>Registro Perfil</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
 
 	 <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
     <script type="text/javascript"> 

     function validateName(){

			var value = $('#nameProfile').val();
		    var listword = value.split(" ");
		    var newWord = "";
			for (var i = 0; i < listword.length; i++) {
				if(listword[i].length>0){
					console.log('i',i);
					newWord+=listword[i]+" ";
				}
			}
			newWord = newWord.substring(0,newWord.length-1);
			$('#nameProfile').val(newWord);
		}
		
		     function validarRequired(idfrom){
		 	    validateName();
				    var $myForm = $(idfrom);
				    if(! $myForm[0].checkValidity()) {
				       msg_advertencia("Debe completar correctamente todos los campos requeridos");
				    }
			  }
     
	       $(document).ready(function() { 
	    	   setInputHidden();

	    	   var msj = $("#mensaje").val();//1
			    if(msj=='1'){
			      msg_exito();
			    }else if(msj=='0'){
			      msg_advertencia("Ya existe un registro con ese nombre");
			    }
			    
// 		      var codigo = document.getElementById("codigoPerfil").value;
// 		     	alert(codigo);
// 		      if (codigo != '') { 
// 		        $('#titulo_glosario').html("Modificar glosario");  
// 			  	$("#cancelar").removeAttr("href")
// 				$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/buscar");
// 			 }else{
// 				  	$("#cancelar").removeAttr("href")
// 		 			$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/listado");
					 
// 			  }
		 
    });
	       
	       function setInputHidden(){
	   		
	       	  var tipo =$("#codigoPerfil").val();
// 	       	alert(tipo);
	       	if (tipo != 0) { 
	           	  $("#titulo-perfil").text('Modificar perfil'); 
	           	  $("#cancelar").removeAttr("href");
	        	  $("#cancelar").attr("href","${pageContext.request.contextPath}/perfilController/buscar");
	        }else{
	       	  	$("#cancelar").removeAttr("href");
	   			$("#cancelar").attr("href","${pageContext.request.contextPath}/perfilController/listado");
	   			 
	         }
	       	

	         }

    </script>
   
  
  
  
  
  
  
  
  
  
  
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <!-- navbar-fixed-top-->
    <%-- <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
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
            <ul class="nav navbar-nav">
              <li class="nav-item hidden-sm-down"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu"></i></a></li>

              <li class="nav-item hidden-sm-down"><a href="#" class="nav-link nav-link-expand"><i class="ficon ft-maximize"></i></a></li>

<!--               <li class="nav-item nav-search"><a href="#" class="nav-link nav-link-search"><i class="ficon ft-search"></i></a>
                <div class="search-input">
                  <input type="text" placeholder="Explore Stack${pageContext.request.contextPath}." class="input">
                </div>
              </li> -->
            </ul>
            <ul class="nav navbar-nav float-xs-right">

              <li class="dropdown dropdown-user nav-item">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link dropdown-user-link">
                  <span class="avatar avatar-online"><img src="${pageContext.request.contextPath}/app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span>
                  <span class="user-name">Juan Carlo Chavez</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                <a href="#" class="dropdown-item"><i class="ft-user"></i> Modificar Perfil</a>
                  <div class="dropdown-divider"></div><a href="login-admin.jsp" class="dropdown-item"><i class="ft-power"></i> Cerrar Sesi&oacute;n</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav> --%>
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
                 
                  <li class="breadcrumb-item active">Seguridad
                  </li>
                  <li class="breadcrumb-item active">Perfil
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <input type="hidden" value="${swMensaje}"  id="mensaje"  />
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id="titulo-perfil">Registro de perfil</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <!-- <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div> -->
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                    <div class="col-md-6 offset-md-3">
                                      <f:form id="frmRegistroPerfil" class="form-horizontal" role="form" method="post" action="grabar">
	                                        <div class="form-body">
	                                          <div class="row">
	                                          	<f:input type="hidden" name="fname" class="form-control" path="codigoPerfil" id="codigoPerfil"/>
		                                              <div class="form-group col-md-12 mb-2">
		                                                  <label for="projectinput1">Nombre de perfil</label>
		                                                  <div class="position-relative has-icon-left">
					                                          <f:input id="nameProfile" type="text" name="fname" class="form-control" required="true" path="nombrePerfil" maxlength="50"/>
					                                          <div class="form-control-position">
					                                            <i class="ft-user"></i>
					                                          </div>
					                                        </div>


		                                              </div>


		                                              <div class="form-group col-md-6 mb-2">
		                                                  <label for="projectinput2">Situaci&oacute;n perfil </label>

		                                                  <f:select id="situacionPerfil" name="interested" class="form-control" path="situacion.codigoRegistro">
		                                                    <f:option value="1">Activo</f:option>
		                                                    <f:option value="2">Inactivo</f:option>
		                                                    <!--<f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>-->

		                                                </f:select>
		                                              </div>


			                                          <div class="row">
			                                      
			                                              <div class="form-group col-md-12 text-right">
			                                                   <button id="btn-save-reg"	type="submit"
			                                       						class="btn btn-flat btn-primary" onclick="validarRequired('#frmRegistroPerfil');">
			                                       						<i class="fa fa-floppy-o"></i>
			                                       						Guardar
			                                       				</button>
			                                              <a type="button" class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/perfilController/listado" id="cancelar">
			                                                  <i class="fa fa-close"></i>    Cancelar
			                                                  </a> 
			                                                  <a type="button" class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/perfilController/nuevo">
			                                                    <i class="fa fa-eraser"></i> Limpiar
			                                                  </a>
			                                                  <!-- <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a> -->
																                   
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
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
  </body>
</html>