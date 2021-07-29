<%@page session="true" %>
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
    <title>Login</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/custom.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/pages/login-register.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
    <!-- END Custom CSS-->
    
    <style>
        .has-error .form-control {
	    	border-color: #a94442!important;
	    	-webkit-box-shadow: none;
	    	box-shadow: none;
		}
    </style>
    
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="1-column" class="vertical-layout vertical-menu 1-column  blank-page blank-page" onload="nobackbutton();">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><section class="flexbox-container">
    <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1  box-shadow-2 p-0">
        <div class="card border-grey border-lighten-3 m-0">
            <div class="card-header no-border">
                <div class="card-title text-xs-center">
                    <div class="p-1"><img src="${pageContext.request.contextPath}/assets/img/logo.png" class="img-fluid" alt="branding logo"></div>
                </div>
                <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span>Iniciar sesi&oacute;n con Kumitsari</span></h6>
            </div>
            <div class="card-body collapse in">
                <div class="card-block">
                    <f:form class="form-horizontal form-simple" role="form" action="${pageContext.request.contextPath}/inicioController/inicio" onsubmit="return validar();">
                        <input type="text" id="msgErrorLogin" value="${msgErrorLogin}" style="display: none !important;">
                     	<input id="Mensaje" type="hidden" value="${Mensaje}">
                        <f:input type="hidden" 
                            		 class="form-control form-control-lg input-lg" 
                            		 id="codigoUsuario"
                            		 path="codigoUsuario"
                            		 required="true"/>
                            		 
                        <fieldset class="form-group position-relative has-icon-left mb-0 valid-msg">
                            <f:input type="password" 
                            		 class="form-control form-control-lg input-lg" 
                            		 id="textClave"
                            		 path="passwordUsuario" 
                            		 placeholder="Ingrese contrasena actual" 
                            		 required="true"/>
                            <div class="form-control-position">
                                <i class="fa fa-key"></i>
                            </div>
                        </fieldset>
                        <fieldset class="form-group position-relative has-icon-left valid-msg">
                            <f:input type="password" 
                            		 class="form-control form-control-lg input-lg" 
                            		 id="textNewClave"
                            		 path="newPassword" 
                            		 placeholder="Ingresar nueva contrasena" 
                            		 required="true"/>
                            <div class="form-control-position">
                                <i class="fa fa-key"></i>
                            </div>
                        </fieldset>
                        <fieldset class="form-group position-relative has-icon-left valid-msg">
                            <input type="password" 
                            		 class="form-control form-control-lg input-lg" 
                            		 id="textReClave"
                            		 placeholder="Confirme nueva contrasena" 
                            		 required />
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
</section>

        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/form-login-register.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    
    
    <script type="text/javascript" charset="utf-8">	
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";
        
        $("#textClave, #textNewClave, #textReClave").keyup(function(){
            if( $("#textClave").val() == "" ){            
                $("#textClave").focus();
                var contentInput = $("#textClave").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese clave actual");
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
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese su nueva contrase&ntilde;a");
            }else{
            	var cadena = $("#textNewClave").val();
            	var mensaje = "La contraseña debe: ";
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
     		    
     		   if(mensaje == "La contraseña debe: ") {
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
                $(".msgValidar").html("Por favor, ingrese clave actual");
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
			return true;
        };

		$(document).ready(function() {
            var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"            
			var msgErrorLogin=document.getElementById('msgErrorLogin').value;
			if(msgErrorLogin.length>0){
                //$("#boxMsgx").append(infoHtml);                
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html(msgErrorLogin);
			}
		});

		function nobackbutton(){
			 
		    window.location.hash = "cambiar-clave";
		    window.location.hash = "cambiar-clave"
		    window.onhashchange  = function(){window.location.hash="cambiar-clave";}
			//window.location.hash = "";
			//window.location.hash = "";
		    //window.onhashchange  = function(){window.location.hash="";}
		}			 			
		
	</script>
    
  </body>
</html>