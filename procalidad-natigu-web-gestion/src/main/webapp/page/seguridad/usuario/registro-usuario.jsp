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
    <title>Registro de usuario</title>
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

       
       $(document).ready(function() { 
    	   setInputHidden();
// 	      var codigo = document.getElementById("codigoGlosario").value;
	     
// 	      if (codigo != '') { 
// 	        $('#titulo_glosario').html("Modificar glosario"); 
	      
// 	  	$("#cancelar").removeAttr("href")
// 		$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/buscar");
// 		 }else{
// 			  $("#cancelar").removeAttr("href")
// 				$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/listado");
				 
// 		  }
		 
    });
       
       function setInputHidden(){
	   		
	       	  var tipo =$("#codigoUsuario").val(); 
			       	if (tipo != 0) { 
			           	  $("#titulo-usuario").text('Modificar usuario');
			           	  $("#titulo-usuario2").text('Modificar usuario'); 
			           	  
			       	  	$("#numeroDoc").removeAttr("disabled");
		        	  	$("#tipoDocumento").removeAttr("disabled");
		        	  	
			        	  $("#numeroDoc").attr("disabled","true");
			        	  $("#tipoDocumento").attr("disabled","true");
			           	  
			       
			           	  $("#cancelar").removeAttr("href");
			        	  $("#cancelar").attr("href","${pageContext.request.contextPath}/usuarioController/buscar");
			        }else{
			        	
			          	$("#numeroDoc").removeAttr("disabled");
			          	$("#tipoDocumento").removeAttr("disabled");
			          	
// 			        	  $("#numeroDoc").attr("disabled","true");
// 			        	  $("#tipoDocumento").attr("disabled","true");
			        	  
			       	  	$("#cancelar").removeAttr("href");
			   			$("#cancelar").attr("href","${pageContext.request.contextPath}/usuarioController/listado"); 
			         } 
	         }
       function setInputHidden2(){
	   		
	       	  var tipo =$("#codigoUsuario").val(); 
	       	  //console.log(tipo);
	       	  
			       	if (tipo != 0) { 
			        
			           	  $("#titulo-usuario2").text('Modificar usuario'); 
			           	  
			       	  	$("#numeroDoc").removeAttr("disabled");
		        	  	$("#tipoDocumento").removeAttr("disabled");
		        	  	
			        	  $("#numeroDoc").attr("disabled","true");
			        	  $("#tipoDocumento").attr("disabled","true");
			           	  
			       
			           	  $("#cancelar").removeAttr("href");
			        	  $("#cancelar").attr("href","${pageContext.request.contextPath}/usuarioController/buscar");
			        }else{
			        	
			          	$("#numeroDoc").removeAttr("disabled");
			          	$("#tipoDocumento").removeAttr("disabled");
			          	
//			        	  $("#numeroDoc").attr("disabled","true");
//			        	  $("#tipoDocumento").attr("disabled","true");
			        	  
			       	  	$("#cancelar").removeAttr("href");
			   			$("#cancelar").attr("href","${pageContext.request.contextPath}/usuarioController/listado"); 
			         } 
	         }
       
    </script>
    
    
    
    
    
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
 
                  <li class="breadcrumb-item active">Seguridad
                  </li>
                  <li class="breadcrumb-item active">Usuario
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body" id="pruebaform"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id="titulo-usuario"> Registro de usuario</h4>
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

                                     <ul id="idUlContentTab" class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Datos Generales</a>
                                        </li>
                                        <c:if test="${usuarioBean.codigoUsuario != null && usuarioBean.codigoUsuario > 0}">
	                                        <li class="nav-item">
	                                          <a  class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Usuario</a>
	                                        </li>
                                        </c:if>
                                      </ul>

                             <div class="tab-content px-1 pt-1">
                              <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                 <f:form class="form mt-1" id="formularioPersona">
                                 <input type="hidden" value="${msgconfir}"  id="mensaje"  />
                                      <div class="form-body">
                                          <div class="row">
                                                <div class="col-md-12">
                                                	<f:input type="hidden" id="codigoPersona" class="form-control" name="lname" path="persona.codigo"/>
                                                  <div class="row">
                                                      <div class="form-group col-md-3 mb-2">
                                                        <label for="situacionUsuario">Tipo de documento</label>

                                                        <f:select id="tipoDocumento" name="interested" class="form-control" path="persona.tipoDocumento.codigoRegistro" onchange="formatoNumeroDocumento()">
																<option value="" >Seleccione</option>
			                                                  <f:options  items="${lstTipoDocumento}"
			                                                                    itemValue="codigoRegistro"
			                                                                    itemLabel="nombreCorto"/>
			                                              </f:select>
                                                      </div>

                                                      <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">N&uacute;mero de documento</label>
                                                          <f:input type="text" id="numeroDoc" class="form-control" name="lname" path="persona.numeroDocumento" onkeypress="return justNumbers(event);" onpaste="return false;" maxlength="15"/>
                                                      </div>
                                                      <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajaxv3('${pageContext.request.contextPath}/usuarioController/buscarPersona','POST','#formularioPersona')">
                                                            <i class="ft-search"></i> Buscar
                                                          </button>
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                      <div class="form-group col-md-6 mb-2">
                                                          <label for="projectinput1">Nombres completos</label>
                                                          <f:input type="text" id="projectinput1" disabled="true" class="form-control" name="fname" path="persona.nombreCompleto"/>
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                       <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">Tel&eacute;fono/Celular</label>
                                                          <f:input type="text" id="projectinput3" disabled="true" class="form-control" name="lname" path="persona.telefono"/>
                                                      </div>

                                                      <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">Correo electr&oacute;nico</label>
                                                          <f:input type="text" id="projectinput4" disabled="true" class="form-control" name="lname" path="persona.correo"/>
                                                      </div>

                                                  </div>


                                                </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-6 text-right">
                                                  	  <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/usuarioController/listado" id = "cancelar">
                                                      	 <i class="fa fa-close"></i> 	  Cancelar
                                                      </a>
                                                      <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/usuarioController/nuevo">
                                                        <i class="ft-search"></i> Limpiar
                                                      </a>

                                                      <c:if test="${(usuarioBean.persona.codigo!=null && usuarioBean.persona.codigo>0) && (usuarioBean.codigoUsuario == null || usuarioBean.codigoUsuario == 0)}">
                                                      	<button type="button" class="btn btn-primary" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/asignar','POST','#formularioPersona')"><i class="fa fa-floppy-o"></i> Asignar</button>
                                                      </c:if>
                                                  </div>
                                              </div>
                                      </div>
                                 </f:form>
                                </div>

                              <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                  <f:form class="form mt-1" id="formularioRegistroUsuario" action="${pageContext.request.contextPath}/usuarioController/grabar">
                                            <div class="form-body">
											<f:input type="hidden" id="codigoUsuario" class="form-control" name="codigoUsuario" path="codigoUsuario"/>

                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput1">Nombre de usuario</label>
                                                      <f:input type="text" id="nomUsu" class="form-control" name="fname" required="true" readonly="true" path="nombreUsuario" maxlength="50"/>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Situaci&oacute;n</label>
                                                    <f:select id="situacionUsuario" name="interested" class="form-control" path="situacion.codigoRegistro" >
		                                                  <option value="" >Seleccione</option>
		                                                  <f:options  items="${lstSituacion}"
		                                                                    itemValue="codigoRegistro"
		                                                                    itemLabel="nombreCorto"/>
		                                              </f:select>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="passwordUsuario">Contrase&ntilde;a</label>
                                                      <fieldset class="form-group position-relative">
                                                          <f:input type="password" class="form-control form-control-xl " readonly="true" id="passwordUsuario" required="true" path="passwordUsuario" maxlength="150"/>
                                                          <div class="form-control-position">
                                                          <i class="icon-key info font-medium-3"></i>
                                                          </div>
                                                      </fieldset>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="projectinput6">Perfil</label>
                                                    <f:select id="codigoPerfil" name="codigoPerfil" class="form-control" path="codigoPerfil" >
		                                                  <option value="" >Seleccione</option>
		                                                  <c:forEach var="perfil" items="${lstPerfiles}">
		                                                  	<option
		                                                  		<c:if test="${(usuarioSesion.codPerfilUsuSelec==6) and (perfil.codigoPerfil!=2)}">style="display:none;"</c:if> 
		                                                  		value="${perfil.codigoPerfil}" >${perfil.nombrePerfil}</option>
		                                                  </c:forEach>
		                                              </f:select>
                                                  </div>
                                                   <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajaxPerfil('${pageContext.request.contextPath}/usuarioController/asignarPerfil','POST','#formularioRegistroUsuario')">
                                                            <i class="fa fa-floppy-o"></i> Agregar perfil
                                                          </button>
                                                      </div>
                                              </div>
                                              <div class="row">
                                          <div class="col-xs-8">
                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Perfil</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
	                                                <c:forEach var="usuarioPerfilBean" items="${lstUsuarioPerfil}" varStatus="theCount">
	                                                    <tr>
	                                                        <td>${theCount.count}</td>
	                                                        <td>${usuarioPerfilBean.perfil.nombrePerfil} </td>
	                                                        <td><button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="eliminarPerfil(${usuarioPerfilBean.codigoUsuarioPerfil},'${pageContext.request.contextPath}/usuarioController');"><i class="icon-trash"></i></button></td>
	                                                    </tr>
                                                    </c:forEach>



                                                </tbody>
												<tfoot>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Perfil</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                          </div>
                                        </div>
                                              <div class="row">
                                                  <div class="form-group col-md-6 text-right">

                                                      <button type="submit" class="btn btn-primary"  title="Grabar"><i class="fa fa-floppy-o"></i> Guardar</button>
                                                      <c:if test="${usuarioBean.codigoUsuario!=null && usuarioBean.codigoUsuario>0}">
	                                                      <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/resetPassword','POST','#formularioRegistroUsuario')">
	                                                        <i class="ft-reload"></i> Reestablecer contrase&nacute;a
	                                                      </button>
	                                                  </c:if>
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
    <script src="${pageContext.request.contextPath}/assets/js/page/seguridad/registro-usuario-script.js" type="text/javascript"></script>

    <script type="text/javascript" charset="utf-8" >
	    var codigo=0;
	    var url="";
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }

       function eliminarPerfil(id,prmUrl){
       	 	codigo = id;
       	 	url = prmUrl;
	       	$("#md_confirmacion #txt_confir").html("Esta acci&oacute;n eliminar&aacute; el registro seleccionado,\n para continuar haga clic en Confirmar");
	      	$("#md_confirmacion #myModalLabel19").html("Eliminar Perfil");
	      	//$("#valorDato").val("GRABAR");
	      	$("#md_confirmacion #btnConfirmarGeneric").attr("onclick","eliminar_perfil()");
	       	 $('#md_confirmacion').modal('show');

         };

       function eliminar_perfil(){
      		//console.log("codigo enviado desde html: ",codigo);
      		var usuarioPerfil ={
      				codigoUsuarioPerfil : codigo,

      				codigoUsuario : $("#formularioRegistroUsuario #codigoUsuario").val()


      	      		};
	      	//console.log("datos: ",usuarioPerfil);

          	var dirURL = url;
	       	 dirURL += "/eliminarPerfil";
	      
	       	iniciarBloqueo();
		        $.ajax({
		          url : dirURL,
		          type : 'POST',
		          data : usuarioPerfil,
		          success : function(data) {
			          //console.log("resultado: ",data);
			        	  $("#pruebaform").empty();
		        		 $("#pruebaform").html(data);
						 $('#base-tab12').tab('show');
			          // $("#paginaRegistroUsuario").html(data);
			          msg_exito();
		          },
		          error : function(request, status, error) {
		        	  //console.log("error: "+error);
		        	  msg_error();
		          },
		          complete: function(){
		              	  finBloqueo();
		              	$('#md_confirmacion').modal('hide');
			      }
		        });
        };
       function enviar_ajaxPerfil(page,method,form){
   		//showLoad_info_ajax();
   		var codigoPerfil = $("#formularioRegistroUsuario #codigoPerfil").val();
   		if(codigoPerfil == null || codigoPerfil == "" || codigoPerfil == "0" ){
   			msg_info("Debe seleccionar un perfil");
   	   		return;
   	   	}
   		 var dirURL = page;
      	 	//dirURL += page; // El script a dónde se realizará la petición.
   		    iniciarBloqueo();
   		    $.ajax({
   		           type: method,
   		           url: dirURL,
   		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
   		           success: function(data)
   		           {	
   		        		
   		        		 $("#pruebaform").empty();
		        		 $("#pruebaform").html(data);
		        		$('#base-tab12').tab('show');
   		               //$("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.
   		               msg_exito();
   		           },
   					error: function(xhr,status,er) {
   						//console.log("error: "+error);
  		        	    msg_error();
   				    },
   		           complete: function(){
   		        	   finBloqueo();
   		        	  // $('#md_confirmacion').modal('hidden');
   		             }
   		         });
   		    //confirmacionGenericoHidden();
   		    return false; // Evitar ejecutar el submit del formulario.
   	}

       function enviar_ajax(page,method,form){
      		//showLoad_info_ajax();

      		 var dirURL = page;
      		 
      		var tipoDocumento = $('#tipoDocumento').val();
      		//alert(tipoDocumento);
      		if(tipoDocumento == 0){
      			msg_advertencia("Seleccione un tipo de documento.");
      		}
    	 	if(tipoDocumento == 1){
    	 		
    	 		if ($('#numeroDoc').val()=='') {
        	 		msg_advertencia("Ingrese un número de documento, Por favor.");
        	 		$('#numeroDoc').focus();
				}else if($('#numeroDoc').val().length<8 ){
					msg_advertencia("Ingrese un número de documento de 8 caracteres, Por favor.");
					$('#numeroDoc').focus();
					$('#numeroDoc').val() ='';
				}else if($('#numeroDoc').val().length==8 ){
					 iniciarBloqueo();
		      		    $.ajax({
		      		           type: method,
		      		           url: dirURL,
		      		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
		      		           success: function(data)
		      		           {	
		      		        		 $("#pruebaform").empty();
		      		        		 $("#pruebaform").html(data);
		      		        		
		      		        		 console.log(data.msgconfir);
		      		        		 
		      		              // $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

		      		           },
		      					error: function(xhr,status,er) {
		      						//console.log("error: "+error);
		      		        	    msg_error();
		      				    },
		      		           complete: function(){
		      		        	   finBloqueo();
		      		        	   $('#md_confirmacion').modal('hide');
		      		             }
		      		         });
		     		    //confirmacionGenericoHidden();
				}
    	 	} 
    	 	
				if(tipoDocumento ==  2){
    	 		
    	 		if ($('#numeroDoc').val()=='') {
        	 		msg_advertencia("Ingrese un número de documento, Por favor.");
        	 		$('#numeroDoc').focus();
				}else if($('#numeroDoc').val().length<12 ){
					msg_advertencia("Ingrese un número de documento de 12 caracteres, Por favor.");
					$('#numeroDoc').focus();
					$('#numeroDoc').val() ='';
				}else if($('#numeroDoc').val().length==12 ){
					 iniciarBloqueo();
		      		    $.ajax({
		      		           type: method,
		      		           url: dirURL,
		      		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
		      		           success: function(data)
		      		           {	
		      		        		 $("#pruebaform").empty();
		      		        		 $("#pruebaform").html(data);
		      		        		
		      		        		 
		      		        		 
		      		              // $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

		      		           },
		      					error: function(xhr,status,er) {
		      						//console.log("error: "+error);
		      		        	    msg_error();
		      				    },
		      		           complete: function(){
		      		        	   finBloqueo();
		      		        	   $('#md_confirmacion').modal('hide');
		      		             }
		      		         });
		     		    //confirmacionGenericoHidden();
				}
    	 	} 
      		 
         	 	//dirURL += page; // El script a dónde se realizará la petición.
      		
      		    //confirmacionGenericoHidden();
      		    return false; // Evitar ejecutar el submit del formulario.
      	}
       
       function enviar_ajaxv2(page,method,form){
     		//showLoad_info_ajax();

     		 var dirURL = page;
        	 	//dirURL += page; // El script a dónde se realizará la petición.
     		 iniciarBloqueo();
     		    $.ajax({
     		           type: method,
     		           url: dirURL,
     		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
     		           success: function(data)
     		           {	
     		        		 $("#pruebaform").empty();
     		        		 $("#pruebaform").html(data);
     		        		 $('#base-tab12').tab('show');
     		        		
     		              // $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

     		           },
     					error: function(xhr,status,er) {
     						//console.log("error: "+error);
     		        	    msg_error();
     				    },
     		           complete: function(){
     		        	   finBloqueo();
     		        	   //$('#md_confirmacion').modal('hide');
     		             }
     		         });
     		    //confirmacionGenericoHidden();
     		    return false; // Evitar ejecutar el submit del formulario.
     	}
       
       function enviar_ajaxv3(page,method,form){
     		//showLoad_info_ajax();
			
     		 var dirURL = page;
        	 	//dirURL += page; // El script a dónde se realizará la petición.
        	 	var tipoDocumento = $('#tipoDocumento').val();
        	 	
        	 	if(tipoDocumento == 1){
        	 		
        	 		if ($('#numeroDoc').val()=='') {
            	 		msg_advertencia("Ingrese un número de documento, Por favor.");
            	 		$('#numeroDoc').focus();
    				}else if($('#numeroDoc').val().length<8 ){
    					msg_advertencia("Ingrese un número de documento de 8 caracteres, Por favor.");
    					$('#numeroDoc').focus();
    					$('#numeroDoc').val() ='';
    				}else if($('#numeroDoc').val().length==8 ){
    			 		 iniciarBloqueo();
    		     		    $.ajax({
    		     		           type: method,
    		     		           url: dirURL,
    		     		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
    		     		           success: function(data)
    		     		           {	
    		     		        	   
    		     		        		 $("#pruebaform").empty();
    		     		        		 $("#pruebaform").html(data);
    		     		        		if ($('#codigoPersona').val()=='0') {
    		     		        			 $("#pruebaform").empty();
    		         		        		 $("#pruebaform").html(data);
    		         		        		msg_info("No se encontraron resultados con el DNI ingresado.");
    		         		        		$('#numeroDoc').val("");
    		         		        		$('#tipoDocumento').val(0);
    									}
    		     		              // $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

    		     		           },
    		     					error: function(xhr,status,er) {
    		     						//console.log("error: "+error);
    		     		        	    msg_error();
    		     				    },
    		     		           complete: function(){
    		     		        	   finBloqueo();
    		     		        	   $('#md_confirmacion').modal('hide');
    		     		             }
    		     		         });
    		     		    //confirmacionGenericoHidden();
    				}
        	 	} else if (tipoDocumento == 2){
        	 		if ($('#numeroDoc').val()=='') {
            	 		msg_advertencia("Ingrese un número de documento, Por favor.");
            	 		$('#numeroDoc').focus();
    				}else if($('#numeroDoc').val().length<12 ){
    					msg_advertencia("Ingrese un número de documento de 12 caracteres, Por favor.");
    					$('#numeroDoc').val() ='';
    					$('#numeroDoc').focus();
    				}else if($('#numeroDoc').val().length==12){
//     					alert("entro");
    			 		 iniciarBloqueo();
    		     		    $.ajax({
    		     		           type: method,
    		     		           url: dirURL,
    		     		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
    		     		           success: function(data)
    		     		           {	
    		     		        	   
    		     		        		 $("#pruebaform").empty();
    		     		        		 $("#pruebaform").html(data);
    		     		        		if ($('#codigoPersona').val()=='0') {
    		     		        			 $("#pruebaform").empty();
    		         		        		 $("#pruebaform").html(data);
    		         		        		msg_info("No se encontraron resultados con el pasaporte ingresado.");
    		         		        		$('#numeroDoc').val("");
    		         		        		$('#tipoDocumento').val(0);
    									}else{
    										setInputHidden();
    									}
    		     		              // $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

    		     		           },
    		     					error: function(xhr,status,er) {
    		     						//console.log("error: "+error);
    		     		        	    msg_error();
    		     				    },
    		     		           complete: function(){
    		     		        	   finBloqueo();
    		     		        	   $('#md_confirmacion').modal('hide');
    		     		             }
    		     		         });
    		     		    //confirmacionGenericoHidden();
    				}
        	 	} else if (tipoDocumento == 3){
        	 		if ($('#numeroDoc').val()=='') {
            	 		msg_advertencia("Ingrese un número de documento, Por favor.");
            	 		$('#numeroDoc').focus();
    				 
    				}else{
//     					alert("entro");
    			 		 iniciarBloqueo();
    		     		    $.ajax({
    		     		           type: method,
    		     		           url: dirURL,
    		     		           data: $("#paginaRegistroUsuario " + form).serialize(), // Adjuntar los campos del formulario enviado.
    		     		           success: function(data)
    		     		           {	
    		     		        	   
    		     		        		 $("#pruebaform").empty();
    		     		        		 $("#pruebaform").html(data);
    		     		        		if ($('#codigoPersona').val()=='0') {
    		     		        			 $("#pruebaform").empty();
    		         		        		 $("#pruebaform").html(data);
    		         		        		msg_info("No se encontraron resultados con el documento ingresado.");
    		         		        		$('#numeroDoc').val("");
    		         		        		$('#tipoDocumento').val(0);
    									}
    		     		              // $("#paginaRegistroUsuario").html(data); // Mostrar la respuestas del script.

    		     		           },
    		     					error: function(xhr,status,er) {
    		     						//console.log("error: "+error);
    		     		        	    msg_error();
    		     				    },
    		     		           complete: function(){
    		     		        	   finBloqueo();
    		     		        	   $('#md_confirmacion').modal('hide');
    		     		             }
    		     		         });
    		     		    //confirmacionGenericoHidden();
    				}
        	 	}  	else if (tipoDocumento == 0){
        	 		msg_advertencia("Seleccione un tipo de documento. Por favor");
        	 	}
        	 	
        	 	
         
    
     		    return false; // Evitar ejecutar el submit del formulario.
     	}
       
       
       function justNumbers(e) {
    	    
   		var numeroDocumento = $('#numeroDoc').val();
   		var tipoDocumento = $('#tipoDocumento').val();
   		if (tipoDocumento != 0) {
   			/*DNI*/
   			if (tipoDocumento == 1) {
   				if (numeroDocumento.length < 8) {
   					var keynum = window.event ? window.event.keyCode
   							: e.which;
   					if ((keynum == 8) || (keynum == 46))
   						return false;
   					return /\d/.test(String.fromCharCode(keynum));
   				} else {
   					var keynum = window.event ? window.event.keyCode
   							: e.which;
   					if ((keynum == 8))
   						return true;
   					e.preventDefault();
   				}
   			}
   			/*PASAPORTE*/
   			if (tipoDocumento == 2) {
   				if (numeroDocumento.length < 12) {
   					 key = e.keyCode || e.which;
   					    tecla = String.fromCharCode(key).toString();
   					    letras = "1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
   					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.
// 						alert(tecla);
//    					    alert(e.keyCode);
   					    tecla_especial = false
   					    for(var i in especiales) {
   					        if(key == especiales[i]  ) {
//    					           alert(entro);
   					        	tecla_especial = true;
   					            break;
   					        }
   					        
   					    }
   					 if((e.keyCode == 32) || (e.keyCode == 46)){
//    							hya = "especia"
//    							 alert(hya);
					         return false;
					        }
//    					 if (tecla == "32" ) {
//    						 return false;
//    					 }

   					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
   					/* alert('Tecla no aceptada');*/
   					        return false;
   					      }
   				} else {
   					e.preventDefault();
   				}
   			}
   			
   			/*OTRO*/
					if (tipoDocumento == 3) {
//    				if (numeroDocumento.length < 12) {
   					 key = e.keyCode || e.which;
   					    tecla = String.fromCharCode(key).toString();
   					    letras = "1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
   					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.
 	 
   					    tecla_especial = false
   					 if(e.keyCode == 32){
//							hya = "especia"
//							 alert(hya);
				         return false;
				        }
   					    for(var i in especiales) {
   					        if(key == especiales[i]  ) {
//    					           alert(entro);
   					        	tecla_especial = true;
   					            break;
   					        }
   					        
   					    }
   					
//    					 if (tecla == "32" ) {
//    						 return false;
//    					 }

   					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
   					/* alert('Tecla no aceptada');*/
   					        return false;
   					      }
//    				} else {
//    					e.preventDefault();
//    				}
   			}
   		}
   	}
       
       function formatoNumeroDocumento(){
   		var tipoDocumento = $('#tipoDocumento').val();
//    		alert(tipoDocumento)
   		if(tipoDocumento==1){
//    	   		alert(tipoDocumento)
   			$("#numeroDoc").val('');
   			$("#numeroDoc").attr("pattern","[0-9]{8}");
   			//$("#numeroDocumentoPersona").val("");
   		}
   		if(tipoDocumento==2){
   			$("#numeroDoc").val('');
   			$("#numeroDoc").attr("pattern","[a-zA-Z]{5,12}");
   			//$("#numeroDocumentoPersona").val("");
   		}
   		if(tipoDocumento==3){
   			$("#numeroDoc").val('');
   			 $("#numeroDoc").removeAttr("pattern");
   			 //$("#numeroDocumentoPersona").val("");
   		}

   	}
	
//        		window.onload = function() {
//     	   var myInput = document.getElementById('numeroDoc');
//     	   myInput.onpaste = function(e) {
//     	     e.preventDefault();
//     	   }
//     	  }
    </script>
  </body>
</html>