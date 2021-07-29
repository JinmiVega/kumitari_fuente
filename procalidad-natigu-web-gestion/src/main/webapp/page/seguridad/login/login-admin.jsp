<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Login Kumitsari">
    <meta name="keywords" content="login, admin">
    <meta name="author" content="GALAXYBIS">
    <title>Login Kumitsari</title>

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
        body{
            background: url(${pageContext.request.contextPath}/assets/img/bg-fondo.jpg);
            background-size: cover;
        }
        #img-logo{
            background: url(${pageContext.request.contextPath}/assets/img/long-admin.jpg)no-repeat;
            background-size: cover;
            background-position: center;
            background-origin: border-box;
        }
        #box-main-logo #img-logo{
            position: relative;
        }
        #div-info{
            background: rgba(0,0,0,0.5);
            position: absolute;
            padding: 30px;
            bottom: 0;
            top:0;
        }
        #div-info h3, #div-info p{
            color:#fff;
            text-align: justify;
        }
        #btnIniciarSesion{
            margin-bottom: 10px;
        }
        #optionOlv{
        	cursor: pointer;
        }
        #boxMsgxOlvidar{
        	margin-top: 8px;
        }
    </style>

  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="1-column" class="vertical-layout vertical-menu 1-column  blank-page blank-page" onload="nobackbutton();Captcha();">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><section class="flexbox-container">
            <div id="box-main-logo" class="box-shadow-2 p-0">
                <div id="img-logo">

                </div>
                <div id="content-logo">
                    <div class="card border-grey border-lighten-3 m-0">
                        <div class="card-header no-border pt-3">
                            <div class="content-ix col-md-6 col-sm-12 pt-2 ">
                                <div class="card-title text-xs-center ">
                                    <div class="p-1"><img src="${pageContext.request.contextPath}/assets/img/Logo-Kumitsari.png" class="img-fluid" alt="branding logo"></div>
                                </div>
                                <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2"><span>Iniciar sesi&oacute;n </span></h6>
                                <div class="card-body collapse in">
                                    <div class="card-block">
                                        <f:form class="form-horizontal form-simple" role="form" action="${pageContext.request.contextPath}/inicioController/controlAcceso" style="text-align: center;">
                                            <input type="text" id="msgErrorLogin" value="${msgErrorLogin}" style="display: none !important;">
                                            <input id="Mensaje" type="hidden" value="${Mensaje}">
                                            <fieldset class="form-group position-relative has-icon-left mb-0 valid-msg">
                                                <input type="text"
                                                         class="form-control form-control-lg input-lg"
                                                         id="textUsuario"
                                                         placeholder="Usuario"
                                                         required="true"
                                                         maxlength="15" autocomplete="off"/>
                                                 		 <f:input type="hidden" id="textEnUsuario" path="nombreUsuario" autocomplete="off"/>
                                                 		 <f:input type="hidden" id="textKey" path="key" autocomplete="off"/>
                                                <div class="form-control-position">
                                                    <i class="ft-user"></i>
                                                </div>
                                            </fieldset>
                                            <br>
                                            <fieldset class="form-group position-relative has-icon-left valid-msg">
                                                <input type="password"
                                                         class="form-control form-control-lg input-lg"
                                                         id="textClave"
                                                         placeholder="Contraseña"
                                                         required="true"
                                                         maxlength="15" autocomplete="off"/>
                                                         <f:input type="hidden" id="textEnContraseña" path="contrasena" autocomplete="off"/>
                                                <div class="form-control-position">
                                                    <i class="fa fa-key"></i>
                                                </div>
                                            </fieldset>
                                            
                                            <table style="width:100%">
                                                <tr>
                                                    <td class="text-center"  style="text-align:center;">
                                                    	<div class="login-capcha">
                                                    	<table style="width:100%">
                                                    	<tr>
                                                    	
	                                                    	<td style="padding-top: 5px;">
	                                                    	<canvas id="captcha" style="width:100%"></canvas>
	                                                    	</td>
	                                                    	<td>
	                                                    	<input type="button" id="refresh" value="&#x21bb;" onclick="Captcha();autenticartoken_in();" class="btn btn-primary btn-lg" style="margin-top:10px;margin-bottom:10px;"/>
	                                                    	</td>
                                                    	
                                                    	</tr>
                                                    	
                                                    	</table>
                                                    	
                                                    	
                                                    	
                                                    	
                                                    	
                                                    	</div>
                                                        
                                                         <input type="text" id="txtInput"  maxlength="7" class="form-control" style="margin-top:10px; margin-bottom:10px" placeholder="Ingrese el texto de la imagen"/>
                                                         <!-- input type="button" id="refresh" value="Actualizar" onclick="Captcha();autenticartoken_in();" class="btn btn-primary btn-lg" style="margin-top:10px;margin-bottom:10px;"/-->
  
                                                    </td>
                                                    
                                                </tr>
                                                
                                            </table>

                                            <div id="boxMsgx"></div>

                                            <!-- <a href="inicio.jsp" class="btn btn-primary btn-lg" title=""><i class="ft-unlock"></i> Iniciar</a> -->
                                            <button id="btnIniciarSesion" type="submit" class="btn btn-primary btn-lg btn-block"><i class="ft-unlock"></i> Iniciar</button>
                                            
                                            <u id="optionOlv" onclick="mostrarMensaje()">Olvidé mi contraseña? </u> 
                                            
                                            <div id="boxMsgxOlvidar"></div>
                                            
                                        </f:form>
                                    </div>
                                </div>
                            </div>
                            <div id="box-info-kumitsari"  class="content-ix col-md-6 col-sm-12 pt-2 pb-3">
                                <div class="pl-2 pr-2" style="border-left: 1px solid #eee">
                                    <h3 class="text-center mb-1">¿Qué es Kumitsari?</h3>
                                    <p class="text-justify">
                                    Kumitsari es un programa informático que te permite reforzar tus habilidades comunicativas en lengua originaria y castellano. Encontrarás lecciones desde el nivel básico hasta el avanzado y aprenderás jugando. En cada unidad podrás interactuar con tu mascota virtual, quien te ayudará a superar cada ejercicio. Podrás juntar monedas por cada actividad resuelta correctamente y con ellas comprar diversos premios en la tienda virtual.
                                    <br>
                                    <br>
                                    Por ello, ¡explora, diviértete y aprende!
                                    </p>
                                </div>
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

	
	<!-- BEGIN BOWSER JS -->
	<script src="${pageContext.request.contextPath}/app-assets/js/scripts/bowser/bowser.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/aes.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/pbkdf2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/AesUtil.js"></script>
	<!-- 
	<script src="${pageContext.request.contextPath}/assets/js/soportar-navegador.js" type="text/javascript"></script>
	-->
	<!-- END BOWSER JS-->
	<script src="${pageContext.request.contextPath}/assets/js/md5.min.js" type="text/javascript"></script>

    <script type="text/javascript" charset="utf-8">

    	var key = "HD63HF73B6VD52BFJ9GNEHN38DNF94BW6N49WNDRNDVNOENIVEEN894N8V30MV03MVNM5N3C3C3"
        
        function CreaIMG(texto) {
    	    var ctxCanvas = document.getElementById('captcha').getContext('2d');
    	    var fontSize = "30px";
    	    var fontFamily = "Arial";
    	    var width = 250;
    	    var height = 60;
    	    ctxCanvas.canvas.width = width;
    	    ctxCanvas.canvas.height = height;
    	    ctxCanvas.fillStyle = "whitesmoke";
    	    ctxCanvas.fillRect(0, 0, width, height);
    	    ctxCanvas.setLineDash([10, 10]);
    	    ctxCanvas.lineDashOffset = 5;
    	    ctxCanvas.beginPath();
    	    var line;
    	    for (var i = 0; i < (width); i++) {
    	        line = i * 10;
    	        ctxCanvas.moveTo(line, 0);
    	        ctxCanvas.lineTo(0, line);
    	    }
    	    ctxCanvas.stroke();
    	    ctxCanvas.direction = 'ltr';
    	    ctxCanvas.font = fontSize + " " + fontFamily;
    	    var x = (width / 3.5);
    	    var y = (height / 3) * 2;
    	    ctxCanvas.strokeStyle = "yellow";
    	    ctxCanvas.strokeText(texto, x, y);
    	    ctxCanvas.fillStyle = "red";
    	    ctxCanvas.fillText(texto, x, y);
    	}

    	function Captcha() {
    	    var alpha = new Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    	    var i;
    	    for (i = 0; i < 6; i++) {
    	        var a = alpha[Math.floor(Math.random() * alpha.length)];
    	        var b = alpha[Math.floor(Math.random() * alpha.length)];
    	        var c = alpha[Math.floor(Math.random() * alpha.length)];
    	        var d = alpha[Math.floor(Math.random() * alpha.length)];
    	        var e = alpha[Math.floor(Math.random() * alpha.length)];
    	        var f = alpha[Math.floor(Math.random() * alpha.length)];
    	        var g = alpha[Math.floor(Math.random() * alpha.length)];
    	    }
    	    var code = a + b + c + d + e + f + g;
    	    localStorage.setItem('KEY_VALID', md5(code, key));
    	    CreaIMG(code);
    	    autenticartoken_in();
    	}
		function autenticartoken_in(){
			
			//showLoad();
			var context  = '${pageContext.request.contextPath}';	
			var key=localStorage.getItem('KEY_VALID') + 'XSbSg4r&5dRwV2yoElRDZwWsLn$lT*F*fAwlrH2H';
			console.log(context + "/inicioController/autenticartoken");
			
			
					
			$.ajax(
			{
						async: true,
						type: "POST",
						data: {
							"cod": key
							
						},
					    url: context + "/inicioController/controlAccesoTk",
				        success: function(data)
				        {
				        	console.log('====== resp: '+data);

				        },
					    error: function(xhr,status,er) {
					    	console.log(er);
					   },
					   complete: function(){
						   console.log('completado....');
						   $("#textKey").val(key);
					   	
						}
			});
			
					
					
		};

    	function ValidCaptcha() {
    	    var string1 = localStorage.getItem('KEY_VALID');
    	    var string2 = document.getElementById("txtInput").value;
    	    if (string1 == md5(string2, key)) {
    	    	document.getElementById("txtInput").value = "";
    	        localStorage.removeItem('KEY_VALID');
    	        return true;
    	    }else{
    	    	document.getElementById("txtInput").value = "";
    	        localStorage.removeItem('KEY_VALID');
    	        Captcha();
    	        return false;
    	    }
    	}
    
		/********************************/
		var navegadores = ["Chrome", "Firefox"];
		var versiones = ["60", "50"];
		
		function navegador() {
			var agente = bowser.name;
		    for (var i in navegadores) {
		        if (agente.indexOf(navegadores[i]) != -1 && parseInt(bowser.version) >= versiones[i]) {
		            return true;
		        }
		    }
		    return false;
		}
				
		/** INI : main **/
		var strNav = "";
		for (var i = 0; i < navegadores.length; i++) {
		    strNav += navegadores[i] + " " + versiones[i] + ".x";
		    if (i < navegadores.length - 1) {
		        strNav += ",";
		    }
		}
		
		if (!navegador()) {
			window.location = window.location.origin+window.location.pathname+"errorController/NavegadorNoSoportado";
		}
		/** FIN : main **/		
		/******************************/
    
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

        $("#textUsuario, #textClave").keyup(function(){
            if( $("#textUsuario").val() == "" ){
                $("#textUsuario").focus();
                var contentInput = $("#textUsuario").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese el nombre de usuario");
                
            }else{	
                $("#textUsuario").parents(".valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();
            }
        });

        $("#textClave").keyup(function(){
            if( $("#textClave").val() == "" ){
                $("#textClave").focus();
                var contentInput = $("#textClave").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese su contrase&ntilde;a");
            }else{
            	/*var cadena = $("#textClave").val();
     			console.log('cadena: ',cadena);
     		    if((cadena.length < 8) || !cadena.match(/[a-z]/) || !cadena.match(/[A-Z]/) || !cadena.match(/[0-9]/) || !cadena.match(/[$&+,:;=?@#|'<>.^*()%!-]/))   {
     		    	$("#textClave").focus();
                    var contentInput = $("#textClave").parents(".valid-msg");
                    $(contentInput).addClass("has-error");
		       		$("#boxMsgx").html(infoHtml);
	                $("#boxMsg").fadeIn("slow");
	                $(".msgValidar").html("Por favor, ingrese el formato correcto de usuario");
     		    } else {*/
	                $("#textClave").parents(".valid-msg").removeClass("has-error");
	                $("#boxMsg").fadeOut();
     		    /*}*/
            }
        });
        
       /*  $("#textUsuario").on("keydown keyup change", function(){
            var value =  $("#textUsuario").val();
           	
	            if (value.length == 0){
	            	$("#textUsuario").parents(".valid-msg").removeClass("has-error");
	              	$("#boxMsg").fadeOut();
	              	$("#btnIniciarSesion").prop('disabled', false);
	              
	            	
	            }else if (value.length < 8){
	            	var contentInput = $("#textUsuario").parents(".valid-msg");
	           		$(contentInput).addClass("has-error");
	            	$("#boxMsgx").html(infoHtml);
		            $("#boxMsg").fadeIn("slow");
		            $(".msgValidar").html("Por favor, ingrese 8 caracteres como mínimo");
		            $("#btnIniciarSesion").prop('disabled', true);
		           
	            	
	            } else{
	            	$("#textUsuario").parents(".valid-msg").removeClass("has-error");
	            	$("#boxMsg").fadeOut();
	            	$("#btnIniciarSesion").prop('disabled', false);
	            	
	            } 
	          
            
        });*/
        
        $("#btnIniciarSesion").click(function (){
            var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

            var txtUsuario = $("#textUsuario").val();
            var txtClave = $("#textClave").val();

            if( txtUsuario == ""){
                $("#textUsuario").focus();
                var contentInput = $("#textUsuario").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese el nombre de usuario");
                return false;
            }

            if(txtUsuario != ""){
                $("#textUsuario").parents(".valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();
            }


            if(txtClave == ""){
                $("#textClave").focus();
                var contentInput = $("#textClave").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese su contrase&ntilde;a");
                return false;
            }

            if(txtClave != ""){
                $("#textClave").parents("valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();
            }
            
            if(!ValidCaptcha()){
				alert("Ingrese correctamente los datos de la imagen");
            	return false;
            }

            console.log("comprobar");

            //encrypt
            validarGrabar();
        
        });

		$(document).ready(function() {
            var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"
			var msgErrorLogin=document.getElementById('msgErrorLogin').value;
            if(msgErrorLogin.length>0){
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html(msgErrorLogin);
                Captcha();
            }

		});
		
		function nobackbutton(){
		    window.location.hash = "no-back-button";
		    window.location.hash = "Again-No-back-button"
		    window.onhashchange  = function(){window.location.hash="no-back-button";}
			//window.location.hash = "";
			//window.location.hash = "";
		    //window.onhashchange  = function(){window.location.hash="";}
		    autenticartoken_in()
		    
		}

		function validarGrabar(){

			var iterationCount = 1000;
		  	var keySize = 128;
		  	
		    var txtUsuario = $("#textUsuario").val();
		    var txtClave = $("#textClave").val();
		    
		    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
		    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
		    
		    var aesUtil = new AesUtil(keySize, iterationCount);
		    var txtUser = aesUtil.encrypt(salt, iv, "usuario", txtUsuario);
		    var txtPass = aesUtil.encrypt(salt, iv, "clave", txtClave);
		    //var key=localStorage.getItem('KEY_VALID') + 'XSbSg4r&5dRwV2yoElRDZwWsLn$lT*F*fAwlrH2H';
		    //alert('validarGrabar: '+key)
		    $("#textEnUsuario").val(txtUser);
		    $("#textEnContraseña").val(txtPass);
		   
		    
		}

		function mostrarMensaje(){
            var infoHtml = "<div id='optionOlvi' class='alert alert-danger'><button onclick='ocultarMensaje()' type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Estimado(a) usuario(a): Porfavor contactarse con el especialista de plataforma al correo: esp_deib@minedu.gob.pe.</span></div>";
            $("#boxMsgxOlvidar").html(infoHtml);
            $("#optionOlvi").fadeIn("slow");
		}

		function ocultarMensaje(){
			$("#optionOlvi").fadeOut();
		}

	</script>

  </body>
</html>