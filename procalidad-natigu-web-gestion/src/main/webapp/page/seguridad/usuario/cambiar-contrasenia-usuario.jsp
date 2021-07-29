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
    <title>Registro Usuario</title>
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
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar" id="paginaRegistroUsuario">

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
                   <li class="breadcrumb-item">Otros
                  </li>
                  <li class="breadcrumb-item active">Seguridad
                  </li>
                  <li class="breadcrumb-item active">Cambiar contrase&ntilde;a
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
                                  <h4 class="card-title">Cambiar contrase&ntilde;a</h4>
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



                             <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1 card-body collapse in">
                              <div class="card-block">
                                 <f:form class="form-horizontal form-simple" role="form" action="${pageContext.request.contextPath}/usuarioController/cambiarPass" onsubmit="return validar();">
			                        <input type="text" id="msgError" value="${msgError}" style="display: none !important;">
			                     	<input id="Mensaje" type="hidden" value="${Mensaje}">
			                        <f:input type="hidden"
			                            		 class="form-control form-control-lg input-lg"
			                            		 id="codigoUsuario"
			                            		 path="codigoUsuario"
			                            		 required="true"/>

			                        <label for="textClave">Contrase&ntilde;a actual<span class="required">*</span></label>
			                        <fieldset class="form-group position-relative has-icon-left valid-msg">
			                            <input type="password"
			                            		 class="form-control form-control-lg input-lg"
			                            		 id="textClave"
			                            		 required="true"
			                            		 maxlength="150"/>
			                          	<f:input type="hidden" id="textEnPass" path="passwordUsuario"/>
			                            <div class="form-control-position">
			                                <i class="fa fa-key"></i>
			                            </div>
			                        </fieldset>
			                        <label for="textNewClave">Nueva contrase&ntilde;a<span class="required">*</span></label>
			                        <fieldset class="form-group position-relative has-icon-left valid-msg">
			                            <input type="password"
			                            		 class="form-control form-control-lg input-lg"
			                            		 id="textNewClave"
			                            		 required="true"
			                            		 maxlength="150"/>
			                            <f:input type="hidden" id="textEnNewPass" path="newPassword"/>
			                            <div class="form-control-position">
			                                <i class="fa fa-key"></i>
			                            </div>
			                        </fieldset>
			                        <label for="textReClave">Confirmar nueva contrase&ntilde;a<span class="required">*</span></label>
			                        <fieldset class="form-group position-relative has-icon-left valid-msg">
			                            <input type="password"
			                            		 class="form-control form-control-lg input-lg"
			                            		 id="textReClave"
			                            		 required 
			                            		 maxlength="150"/>
			                            <div class="form-control-position">
			                                <i class="fa fa-key"></i>
			                            </div>
			                        </fieldset>

			                        <div id="boxMsgx"></div>

			                        <!-- <a href="inicio.jsp" class="btn btn-primary btn-lg" title=""><i class="ft-unlock"></i> Iniciar</a> -->
			                        <button id="btnResetPass" type="submit" class="btn btn-primary btn-lg btn-block"><i class="ft-unlock"></i> Actualizar</button>
			                    </f:form>
                                </div>
                            </div>
                            <div class="card-footer">
				                <div class="">
				                    <!-- <p class="float-sm-left text-xs-center m-0"><a href="recordar-contrasenia.jsp" class="card-link">Recuperar contrase&ntilde;a</a></p> -->
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
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/galeria-imagen-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
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

    <script src="${pageContext.request.contextPath}/assets/js/page/seguridad/registro-usuario-script.js" type="text/javascript"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/aes.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/pbkdf2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/AesUtil.js"></script>
    <script type="text/javascript" charset="utf-8" >
    var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

    $("#textClave, #textNewClave, #textReClave").keyup(function(){
        if( $("#textClave").val() == "" ){
            $("#textClave").focus();
            var contentInput = $("#textClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese contraseña actual");
        }else{
            $("#textUsuario").parents(".valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }
    });

    $("#textNewClave").keyup(function(){
        if( $("#textNewClave").val() == "" ){
            $("#textNewClave").focus();
            var contentInput = $("#textNewClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese su nueva contrase&ntilde;a");
        }else{
        	var cadena = $("#textNewClave").val();
        	var mensaje = "La nueva contraseña debe: ";
 		    if(cadena.length < 8) {
 		    	mensaje+= "tener mínimo 8 dígitos, ";
 		    }
 		    if(!cadena.match(/[a-z]/)){
 		    	mensaje+= "contener al menos una minúscula, ";
 		    }
 		   	if(!cadena.match(/[A-Z]/)){
 		   		mensaje+= "contener al menos una mayúscula, ";
		    }
 		   	if(!cadena.match(/[0-9]/)){
 		   		mensaje+= "contener al menos un número, ";
		    }
 		    
 		   if(mensaje == "La nueva contraseña debe: ") {
 			  mensaje = "";
 			  $("#textClave").parents(".valid-msg").removeClass("has-error");
	          $("#boxMsg").fadeOut();
			} else {
				mensaje = mensaje.substr(0,mensaje.length-2);
 		    	$("#textNewClave").focus();
                var contentInput = $("#textNewClave").parents(".valid-msg");
                $(contentInput).addClass("has-error");
	       		$("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html(mensaje);
			}
 		    	
        }
    });

    $("#textReClave").keyup(function(){
        if( $("#textReClave").val() == "" ){
            $("#textReClave").focus();
            var contentInput = $("#textReClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, confirme su nueva contrase&ntilde;a");
        }else{
            $("#textClave").parents(".valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }
    });

    function validar(){
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

        var txtUsuario = $("#textClave").val();
        var txtClave = $("#textNewClave").val();
        var txtReClave = $("#textReClave").val();

        if( txtUsuario == ""){
            $("#textClave").focus();
            var contentInput = $("#textClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese contraseña actual");
            return false;
        }

        if(txtUsuario != ""){
            $("#textClave").parents(".valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }


        if(txtClave == ""){
            $("#textNewClave").focus();
            var contentInput = $("#textNewClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, ingrese su nueva contrase&ntilde;a");
            return false;
        }

        if(txtClave != ""){
        	var cadena = $("#textNewClave").val();
        	var mensaje = "La nueva contraseña debe: ";
 		    if(cadena.length < 8) {
 		    	mensaje+= "tener mínimo 8 dígitos, ";
 		    }
 		    if(!cadena.match(/[a-z]/)){
 		    	mensaje+= "contener al menos una minúscula, ";
 		    }
 		   	if(!cadena.match(/[A-Z]/)){
 		   		mensaje+= "contener al menos una mayúscula, ";
		    }
 		   	if(!cadena.match(/[0-9]/)){
 		   		mensaje+= "contener al menos un número, ";
		    }
 		    //alert("Hola "+mensaje);
 		   if(mensaje == "La nueva contraseña debe: ") {
 			  mensaje = "";
                $("#textNewClave").parents("valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();     		   
 		   } else {
 			  mensaje = mensaje.substr(0,mensaje.length-2);
 			  $("#textNewClave").focus();
              var contentInput = $("#textNewClave").parents(".valid-msg");
              $(contentInput).addClass("has-error");
              //$("#boxMsgx").append(infoHtml);
              $("#boxMsgx").html(infoHtml);
              $("#boxMsg").fadeIn("slow");
              $(".msgValidar").html(mensaje);
 			  return false;
 		   }
        }

        if(txtReClave == ""){
            $("#textReClave").focus();
            var contentInput = $("#textReClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("Por favor, confirme su nueva contrase&ntilde;a");
            return false;
        }

        if(txtReClave != ""){
            $("#textReClave").parents("valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
        }

        if(txtClave != txtReClave){
        	$("#textReClave").focus();
            var contentInput = $("#textReClave").parents(".valid-msg");
            $(contentInput).addClass("has-error");
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html("La contrase&ntilde;a no coincide");
            return false;
        }else{
        	$("#textReClave").parents("valid-msg").removeClass("has-error");
            $("#boxMsg").fadeOut();
         }
        validarGrabar();
		return true;
    };
    
    function validarGrabar(){

		var iterationCount = 1000;
	  	var keySize = 128;
	  	
	    var txtPass = $("#textClave").val();
	    var txtNewPass = $("#textNewClave").val();
	    
	    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    
	    var aesUtil = new AesUtil(keySize, iterationCount);
	    var txtEnPass = aesUtil.encrypt(salt, iv, "password", txtPass);
	    var txtEnNewPass = aesUtil.encrypt(salt, iv, "newpassword", txtNewPass);
	    $("#textEnPass").val(txtEnPass);
	    $("#textEnNewPass").val(txtEnNewPass);
	    
	}

	$(document).ready(function() {
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"
		var msgError=document.getElementById('msgError').value;
		if(msgError.length>0){
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html(msgError);
		}
	});
    </script>
  </body>
</html>