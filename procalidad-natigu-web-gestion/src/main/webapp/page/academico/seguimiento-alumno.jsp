<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%
UsuarioBean usuarioBean = new UsuarioBean();
//cboPerfilSesionActual
usuarioBean = (UsuarioBean) session.getAttribute("usuarioSesion");
if (usuarioBean.getPersona() == null){
	String path = request.getContextPath();
	response.sendRedirect(path+"/");
}
%>

<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title> Seguimiento de estudiantes</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../app-assets/images/ico/favicon.ico">
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

  	<script type="text/javascript">
 //\webapp\layout\notas-modal-view.jsp
$( document ).ready(function() {
	var idLengua = "";
	var idDocente = "";

	document.getElementById('idDescargarDis').style.display = 'none';
	document.getElementById('idDescargarEna').style.display = 'none';
	document.getElementById('contentCaptcha').style.display = 'none';

	$('#listadoSeguimiento').empty();
	$('#listadoSeguimiento').html("<tr><td colspan='9'><center>Sin registros para mostrar</center></td></tr>");
	
	var valor = $(".optionReset").val();
	if(valor=='0'){
		$(".optionReset").val("");
	}
});

	 function buscarLengua(){
		var id = $("#lblInstitu").val();
		document.getElementById("lblLengua").options[document.getElementById("lblLengua").innerHTML="0"];
		document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option("Seleccionar", "0");
		document.getElementById("lblDocente").options[document.getElementById("lblDocente").innerHTML="0"];
		document.getElementById("lblDocente").options[document.getElementById("lblDocente").options.length]=new Option("Todos", "0");
		iniciarBloqueo();
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/seguimientoController/buscarLengua?codigoinstitucion="+id,
	//			data : {codigoinst:numero},
			success : function(data) {
				/* console.log("SUCCESS: ", data); */
	// 			$('#provincia').html(data);
	// 			alert(data[1].codigo);
	// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

				if(data!=''){
					for(var i=0; i<data.length;i++){
						//alert(data[i]);
						document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option(data[i].nombre, data[i].codigo);
					}
				}
			},
			error : function() {
				//console.log("ERROR: ");
			},
			complete : function() {
				finBloqueo();
			}
		});

	}

	function buscarDocente(iddocente) {

		var idInstitucion = $("#lblInstitu").val();
		var idLengua = $("#lblLengua").val();
		document.getElementById("lblDocente").options[document.getElementById("lblDocente").innerHTML="0"];
		document.getElementById("lblDocente").options[document.getElementById("lblDocente").options.length]=new Option("Todos", "0");
		iniciarBloqueo();
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/seguimientoController/buscarDocente?codigoinstitucion="+idInstitucion+"&codigolengua="+idLengua,
	//			data : {codigoinst:numero},
			success : function(data) {
				/* console.log("SUCCESS: ", data); */
	// 			$('#provincia').html(data);
	// 			alert(data[1].codigo);
	// 			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

				if(data!=''){
					for(var i=0; i<data.length;i++){
						document.getElementById("lblDocente").options[document.getElementById("lblDocente").options.length]=new Option(data[i].personaBean.nombreCompleto, data[i].codigo);
					}
				}
        	    $("#lblDocente").val(iddocente);

			},
			error : function() {
				//console.log("ERROR: ");
			},
			complete : function() {
				finBloqueo();
			}
		});
	}

	function setterIdDocente(){
		//$("#lblDocente").val('0');
		idDocente = '0';
	}

	function validarRequired(idfrom){
		var $myForm = $(idfrom);

		var idInstitucion = $("#lblInstitu").val();
		var idLengua = $("#lblLengua").val();
	    var idDocente = $("#lblDocente").val();

		if(idInstitucion == "0"){
			msg_info("Debe seleccionar una institución");
		}else if(idLengua == "0"){
			msg_info("Debe seleccionar una lengua");
		}
		/* else if(idDocente == "0"){
			msg_info("Debe seleccionar un docente");
		} */
		// validar todos los required
		//if((!$myForm[0].checkValidity())) {
		//	 msg_advertencia("Debe completar los campos requeridos correctamente");
		//}
		/*else if( $("#lblLengua").val() == "0"){
			 msg_advertencia("Debe completar los campos requeridos correctamente");
		}else if( $("#lblDocente").val() == "0"){
			 msg_advertencia("Debe completar los campos requeridos correctamente");
		}*/
		else{
			//obtener los dos valores que se setean
		    idLengua = $("#lblLengua").val();
		    idDocente = $("#lblDocente").val();

			//alert("lengua codigo : "+idLengua);
			//alert("docente codigo : "+idDocente);

			var actionForm = $(idfrom).attr("action");
			//var url = "${pageContext.request.contextPath}" + actionForm;
			iniciarBloqueo();
			$.ajax({
		           type: "POST",
		           url:  "${pageContext.request.contextPath}/seguimientoController/buscar",
		           data: $(idfrom).serialize(),
		           success: function(data)
		           {
			   			//$("#lblLengua").val(idLengua);
						//buscarDocente(idDocente);

			           //#listadoSeguimiento
			           $('#listadoSeguimiento').empty();
			           var htmlTabla = "";

				    	if(data!=null && data.length>0){
				    		for (var i = 0; i < data.length; i++) {
								//habilitar los botones de imprimir
								document.getElementById('contentCaptcha').style.display = 'block';
								EnableCaptcha();
					    		var objMaestra = data[i];
					    		var options = { year: 'numeric', month: 'long', day: 'numeric' };
								var fechaRegistro = new Date(objMaestra.matriculaBean.inscripcion.fechaRegistro);
								var fechaModificacion = new Date(objMaestra.matriculaBean.inscripcion.fechaModificacion);
								//alert(objMaestra.codigo);

								//fechaRegistro.toLocaleString()
								/*
			    					"<td>"+fechaRegistro.getDate()+"/"+(fechaRegistro.getMonth()+1)+"/"+fechaRegistro.getFullYear()+" - "+fechaModificacion.getDate()+"/"+(fechaModificacion.getMonth()+1)+"/"+fechaModificacion.getFullYear()+"</td>"+*/
					    		htmlTabla +=
					    			"<tr>"+
					    			"<td>"+(i+1)+"</td>"+
			    					"<td>"+objMaestra.matriculaBean.insti.nombreInstitucion+"</td>"+
			    					"<td>"+objMaestra.matriculaBean.docenteBean.personaBean.nombreCompleto+"</td>"+
			    					"<td>"+objMaestra.alumnoBean.personaBean.nombreCompleto+"</td>"+
			    					"<td>"+objMaestra.alumnoBean.usuario+"</td>"+
			    					"<td>"+objMaestra.matriculaBean.lengua.nombre+" - "+objMaestra.matriculaBean.nivel.nombreCorto+" - "+objMaestra.matriculaBean.periodo.codigoRegistro+" - "+objMaestra.matriculaBean.ciclo.nombreCorto+"</td>"+
			    					"<td>"+objMaestra.matriculaBean.situacion.nombreLargo+"</td>"+
			    				 	"<td>"+objMaestra.nota+"</td>"+
			    				 
			    					
			    					  "<td><button data-toggle='tooltip' data-placement='top' data-original-title='Ver' title='Ver' type=" + "button" +" class=" + "btn btn-outline-secondary btn-min-width" + 
			    					  " data-toggle="+"modal"+" "+ "data-target="+"#bootstrap"+
			    					  " onclick="+ "verNotas("+objMaestra.matriculaBean.codigo+")" + ">"+  
                                      "<i class="+"ft-search"+"></i>"+
                                      "</button>"+
			    			 "</tr>";
							}
							$('#tblListaSeguimientoAlumno').DataTable().destroy();
				  	    	$('#listadoSeguimiento').empty();
				  	    	$('#listadoSeguimiento').html(htmlTabla);
				  	    	$('#tblListaSeguimientoAlumno').DataTable();
				    	}else{

				    		$('#listadoSeguimiento').html("<tr><td colspan='9'><center>Sin registros para mostrar</center></td></tr>");
							document.getElementById('idDescargarDis').style.display = 'none';
							document.getElementById('idDescargarEna').style.display = 'none';
				    		document.getElementById('contentCaptcha').style.display = 'none';
					    }
		           },
					 error: function(xhr,status,er) {
					 msg_error();
				     //console.log("error: " + xhr + " status: " + status + " er:" + er);
					    if(xhr.status==500) {
					    	//console.log(er);
					 //   	Error_500(er);
					    }
					    if(xhr.status==901) {
				    	//console.log(er);
				    //	spire_session_901(er);
		    			}
				    },
				    complete: function(){
				    	finBloqueo();
			        }
		         });
		}
	}
	
	function verNotas(codigo) {
		var codUsuMat = codigo;  
		var html = "";
  		$.ajax({
  			type : "GET",

  			url : "${pageContext.request.contextPath}/seguimientoController/listarNotas",
  			data : {CodUsuMat:codUsuMat},

  			success : function(data) {
 				/* console.log("SUCCESS: ", data); */
 				$('#modal').html(data);
				$('#notas-modal').modal('show');
				//if(data!=null && data.length>0){
					/* for (var i = 0; i < data.length; i++) {
						html = 	html+
						"<tr><td>"+(i+1)+"</td></tr>";
				
					} */
					 
				//}
 
				//document.getElementById("evaluacionBody").innerHTML=html;
				//$("#evaluacionBody").html(html);
 			
  			},
  			error : function() {
  				//console.log("ERROR: ");
  			}
  		});

	}


	function limpiarFiltroSeguimiento(){
		document.getElementById('frmBuscarSeguimientoAlumno').reset();

		document.getElementById("lblLengua").options[document.getElementById("lblLengua").innerHTML="0"];
		document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option("Seleccionar", "0");
		document.getElementById("lblDocente").options[document.getElementById("lblDocente").innerHTML="0"];
		document.getElementById("lblDocente").options[document.getElementById("lblDocente").options.length]=new Option("Todos", "0");
		document.getElementById('idDescargarDis').style.display = 'none';
		document.getElementById('idDescargarEna').style.display = 'none';
		document.getElementById('contentCaptcha').style.display = 'none';

	}
	
	//id #listadoSeguimiento
	/*
	 $( "#frmBuscarSeguimientoAlumno" ).submit(function( event ) {
		  alert( "Handler for .submit() called." );
		  //event.preventDefault();
	});*/
	
	var key = "HD63HF73B6VD52BFJ9GNEHN38DNF94BW6N49WNDRNDVNOENIVEEN894N8V30MV03MVNM5N3C3C3"

		function CreaIMG(texto) {
		    var ctxCanvas = document.getElementById('captcha').getContext('2d');
		    var fontSize = "30px";
		    var fontFamily = "Arial";
		    var width = 200;
		    var height = 38;
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
		    var alpha = new Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
		    var i;
		    for (i = 0; i < 6; i++) {
		        var a = alpha[Math.floor(Math.random() * alpha.length)];
		        var b = alpha[Math.floor(Math.random() * alpha.length)];
		        var c = alpha[Math.floor(Math.random() * alpha.length)];
		        var d = alpha[Math.floor(Math.random() * alpha.length)];
		    }
		    var code = a + b + c + d;
		    localStorage.setItem('KEY_VALID', md5(code, key));
		    CreaIMG(code);
		}

		function ValidCaptcha() {
		    var string1 = localStorage.getItem('KEY_VALID');
		    var string2 = document.getElementById("txtInput").value;
		    if (string1 == md5(string2, key)) {
		        localStorage.removeItem('KEY_VALID');
		        document.getElementById('idDescargarDis').style.display = 'none';
				document.getElementById('idDescargarEna').style.display = 'block';
		        document.getElementById("txtInput").disabled = true;
		    }
		}
		
		function EnableCaptcha(){
	        document.getElementById("txtInput").value = "";
			document.getElementById('idDescargarDis').style.display = 'block';
			document.getElementById('idDescargarEna').style.display = 'none';
	        document.getElementById("txtInput").disabled = false;
		}


  	</script>




  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar" onload="Captcha();">

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
                   <li class="breadcrumb-item"><a href="#" style="cursor: default;">Estudiante</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#" style="cursor: default;">Seguimiento</a>
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
                                  <h4 class="card-title"> Seguimiento de Estudiantes </h4>
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
                                    <f:form id="frmBuscarSeguimientoAlumno" class="form"  role="form" method="post" action="buscar" onsubmit="return false">
                                      <div class="form-body">
                                        <div class="row">
                                            <div class="form-group col-md-4 mb-2">
                                              <label for="projectinput6">Instituci&oacute;n</label>
                                               <div class="controls">
                                            	<f:select id="lblInstitu" path="insti.codigo" class="form-control" onchange="buscarLengua();"  data-validation-required-message="Este campo es requerido" required="required" >
															<f:option value="0" label="Seleccionar"  />
															<f:options items="${lstInstitucionBean}" itemValue="codigo" itemLabel="nombreInstitucion" />
												</f:select>
											   </div>
                                            </div>
                                            <div class="form-group col-md-2 mb-2">
                                              <label for="projectinput6">Lengua</label>
                                              <div class="controls">
                                              <f:select id="lblLengua" path="lengua.codigo"   class="form-control" onchange="buscarDocente(0);" onclick="setterIdDocente();"  data-validation-required-message="Este campo es requerido" required="required" >
															<f:option value="0" label="Seleccionar" />
															<f:options items="${lstLenguaBean}" itemValue="codigo" itemLabel="nombre" />
											  </f:select>
											  </div>
                                            </div>
                                            <div class="form-group col-md-3 mb-2">
                                              <label for="projectinput6">Docente</label>
                                              <!--
                                              <select id="projectinput6" name="interested" class="form-control">
                                                  <option value="none" selected="" disabled="">Todos</option>
                                                  <option value="design">Jeniffer Soto Paredes</option>
                                                  <option value="design">Aracelly Melgar Diaz</option>
                                                  <option value="design">Carlos Soto Pascasio</option>
                                              </select>
                                              -->
                                              <div class="controls">
                                               <f:select id="lblDocente" path="docenteBean.codigo" class="form-control"  data-validation-required-message="Este campo es requerido" required="required" >
                                                <f:option value="0" label="Todos" />
                                                <f:options  items="${lstDocenteBean}"
                                                            itemValue="codigo"
                                                            itemLabel="personaBean.nombreCompleto"/>
                                            	</f:select>
                                            	</div>
                                            </div>
                                            <div class="form-group col-md-3 mb-2">
                                              <label for="projectinput6">Nivel</label>
                                             <!--
                                              <select id="projectinput6" name="interested" class="form-control">
                                                  <option value="none" selected="" disabled="">Todos</option>
                                                  <option value="design">B&aacute;sico 1</option>
                                                  <option value="design">B&aacute;sico 2</option>
                                                  <option value="design">B&aacute;sico 3</option>
                                                  <option value="design">Intermedio 1</option>
                                                  <option value="design">Intermedio 2</option>
                                                  <option value="design">Intermedio 3</option>
                                                  <option value="design">Avanzado 1</option>
                                                  <option value="design">Avanzado 2</option>
                                              </select>
                                              -->
                                              <f:select id="lblNivel"
                                                path="nivel.codigoRegistro" class="form-control">
                                                <f:option value="0" label="Todos"/>
                                                <f:options  items="${lstnivel}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            	</f:select>
                                            </div>

                                        <div class="row">
                                        	</div>
                                        	<div class="form-group col-md-2 mb-2">
                                              <label for="situacionUsuario">Periodo</label>
                                              <!--
                                              <select id="situacionUsuario" name="interested" class="form-control">
                                                  <option value="none" selected="" disabled="">Todos</option>
                                                  <option value="design">Activo</option>
                                                  <option value="development">No activo</option>
                                              </select>
                                              -->
                                              <f:select id="lblSituacion"
                                                path="periodo.codigoRegistro" class="form-control">
                                                <f:option value="0" label="Todos"/>
                                                <f:options  items="${lstPeriodo}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            	</f:select>
                                            </div>
                                            <div class="form-group col-md-2 mb-2">
                                              <label for="situacionUsuario">Situaci&oacute;n</label>
                                              <!--
                                              <select id="situacionUsuario" name="interested" class="form-control">
                                                  <option value="none" selected="" disabled="">Todos</option>
                                                  <option value="design">Activo</option>
                                                  <option value="development">No activo</option>
                                              </select>
                                              -->
                                              <f:select id="lblSituacion"
                                                path="situacion.codigoRegistro" class="form-control">
                                                <f:option value="0" label="Todos"/>
                                                <f:options  items="${lstSituacion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            	</f:select>
                                            </div>

                                            <div class="form-group col-md-8 text-right">
                                                <div id="idDescargarDis" >
	                                                <button class="btn btn-outline-secondary mt-2" disabled>
	                                                	<i class="fa fa-file-excel-o"></i> Descargar Excel
	                                                </button>                                                                              
	                                                <button class="btn btn-outline-secondary  mt-2" disabled>
	                                                	<i class="fa fa-file-pdf-o"></i> Descargar PDF
	                                                </button>
                                                </div>
                                                <div id="idDescargarEna" >
	                                                <a class="btn btn-outline-secondary  mt-2" target="_Blank" href="<c:url value='/seguimientoController/descargarExcel'/>">
	                                                 <i class="fa fa-file-excel-o"></i> Descargar Excel</a>
	                                                  <a class="btn btn-outline-secondary  mt-2"  target="_Blank" href="<c:url value='/seguimientoController/descargarPDF'/>">
                                                 	 <i class="fa fa-file-pdf-o"></i> Descargar PDF</a>
                                                </div>
                                                <div id="contentCaptcha" >                
		                                            <div class="row" style="display: flex;justify-content: flex-end;">
														<table style="margin: 10px 13px 0px 10px;text-align: center;">
													        <tr>
													            <td class="text-center">
													            	<table style="width:100%">
																	    <tr>
																	                                                    	
																		    <td>
																		       <canvas id="captcha"></canvas>
																		    </td>
																		    <td>
																		       <input type="button" id="refresh" value="&#x21bb;" onclick="Captcha();EnableCaptcha();" class="btn btn-primary btn-lg" style="color:#fff !important"/>
																		    </td>
																	                                                    	
																	    </tr>
																	                                                    	
																	</table>
													            
													            
													                
													                <div style="display: flex;">
														                <input onkeyup="ValidCaptcha()" type="text" id="txtInput"  class="form-control" style="margin-top:5px" placeholder="Ingrese el texto de la imagen"/>
														                
													                </div>
													            </td>
													        </tr>
													    </table>
													</div>
	                                            </div>
                                                <button type="button"  class="btn btn-secondary  mt-2" onclick="limpiarFiltroSeguimiento();limpiarDataTable('#tblListaSeguimientoAlumno')">
                                                   <i class="fa fa-eraser"></i> Limpiar
                                                </button>
                                                <button type="button"  class="btn btn-secondary  mt-2" onclick="validarRequired('#frmBuscarSeguimientoAlumno');">
                                                  <i class="ft-search"></i> Buscar
                                                </button>
                                            </div>
                                            
                                        </div>
                                        <div class="row">
                                          <div class="col-xs-12">
                                            <table id="tblListaSeguimientoAlumno" class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                    	<th width="20">N°</th>
                                                        <th width="150">Instituci&oacute;n</th>
                                                        <th>Docente</th>
                                                        <th>Estudiante</th>
                                                        <th>Usuario</th>
                                                        <th width="120">Lengua - Nivel - A&ntilde;o - Semestre</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="40">Nota</th>
                                                        <th width="20">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody  id="listadoSeguimiento">
                                                 <c:forEach var="matriculaBean" items="${lstMatriculaBean}" varStatus="theCount">
                                                    <tr>
                                                    	<td>${theCount.count}</td>
                                                        <td>${matriculaBean.insti.nombreInstitucion}</td>
                                                        <td>${matriculaBean.docenteBean.personaBean.nombreCompleto}</td>
                                                        <td>${matriculaBean.alumnoBean.personaBean.nombreCompleto}</td>
                                                        <td>${matriculaBean.alumnoBean.usuario}</td>
                                                        
                                                            

                                                        <td>${matriculaBean.lengua.nombre}
                                                        - ${matriculaBean.nivel.nombreCorto}
                                                        <!-- - ${matriculaBean.subNivel.nombreCorto} -->
                                                        - ${matriculaBean.ciclo.nombreCorto}
                                                        - ${matriculaBean.periodo.codigoRegistro}  drag</td>
														<!--   <td>16/08/2017 - 16/08/2017	</td> -->
                                                        <td>${matriculaBean.situacion.nombreLargo}</td>
                                                        <td><button type="button" class="btn btn-outline-success btn-sm"  onclick="agregarMatriculaAlumno(${alumnoBean.codigo})"><i class="icon-arrow-right"></i></button></td>
                                                    </tr>

        										 </c:forEach>
                                                    <!--
                                                    <tr>
                                                        <td>BENIGNO AYALA ESQUIVEL</td>
                                                         <td> Jordan Valencia Trujillo</td>
                                                        <td>Juan Soto Palacios </td>
                                                         <td> Quechua-AvanzadoI-U1-L2-CI-2017 </td>
                                                         <td>02/04/2017 - 04/07/2017</td>
                                                        <td>Activo </td>
                                                    </tr>
                                                    <tr>
                                                        <td>BENIGNO AYALA ESQUIVEL</td>
                                                        <td>Manuel Perez Castillo </td>
                                                         <td> Kevin Leyva Torres</td>
                                                         <td>Aimara-IntermedioII-U1-L2-CI-2017 </td>
                                                         <td>05/04/2017 - 09/06/2017</td>
                                                        <td>Activo </td>
                                                    </tr>
                                                     -->
                                                </tbody>
                                                  <tfoot>
                                                    <tr>
                                                    	<th width="20">N°</th>
                                                        <th width="150">Instituci&oacute;n</th>
                                                        <th>Docente</th>
                                                        <th>Estudiante</th>
                                                        <th>Usuario</th>
                                                        <th width="120">Lengua - Nivel - A&ntilde;o - Semestre</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="40">Nota</th>
                                                        <th width="20">Acci&oacute;n</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                          </div>
                                        </div>
                                      </div>
                                    </f:form>
                                  </div>
                              </div>
                          </div>
                      </div>
                     
                  </div>
                  <div id ="modal"></div>
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/../layout/notas-modal-view.jsp" />
    
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
       <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>

    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/md5.min.js" type="text/javascript"></script>

   <!--  <script type="text/javascript" charset="utf-8" >
      function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
    </script> -->
  </body>
</html>