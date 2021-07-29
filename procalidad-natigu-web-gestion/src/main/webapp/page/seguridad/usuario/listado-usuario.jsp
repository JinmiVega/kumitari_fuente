<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading" >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Listado de usuarios</title>
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
    
    
<script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

  <script type="text/javascript">

  //mensaje
    $(document).ready(function() {
   //  alert("XD");
   });

  

 </script>
 
 
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar" id="paginaUsuario">

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
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title"> Listado de usuarios</h4>
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
                                    <f:form class="form" id="formularioBusqueda" role="form"  method="POST" action="${pageContext.request.contextPath}/usuarioController/buscar"><!-- buscar -->
                                      <div class="form-body">
                                        <div class="row">
                                            <div class="form-group col-md-3 mb-2">
                                                <label for="projectinput1">Nombre de usuario</label>
                                                <f:input type="text" class="form-control" path="nombreUsuario" maxlength="50"/>
                                            </div>
                                         
                                            <div class="form-group col-md-3 mb-2">
                                              <label for="projectinput1">Perfil</label>
                                                 <f:select id="perfilUsuario" name="interested" class="form-control select-del" path="codigoPerfil" >
                                              <f:option value="0" label="Todos"/>
                                               <f:options  items="${lstPerfiles}" 
                                                            itemValue="codigoPerfil"
                                                            itemLabel="nombrePerfil"/>
<!-- <option -->
                                              
                                              
                                              
<%-- 	                                                  <c:forEach var="perfil" items="${lstPerfiles}"> --%>
<!-- 	                                                  	<option -->
<%-- 	                                                  		<c:if test="${(usuarioSesion.codPerfilUsuSelec==6) and (perfil.codigoPerfil!=2)}">style="display:none;"</c:if>  --%>
<%-- 	                                                  		value="${perfil.codigoPerfil}">${perfil.nombrePerfil}</option> --%>
<%-- 	                                                  </c:forEach> --%>
                                              </f:select>
                                            </div>
<%-- 					   <f:option value="0" label="Todos"/> --%> 
<%--                                                 <f:options  items="${lstPerfiles}" --%>
<%--                                                             itemValue="codigoRegistro" --%>
<%--                                                             itemLabel="nombreCorto"/> --%>
<!-- <option -->
<%-- 	                                                  		<c:if test="${(usuarioSesion.codPerfilUsuSelec==6) and (perfil.codigoPerfil!=2)}">style="display:none;"</c:if>  --%>
<%-- 	                                                  		value="${perfil.codigoPerfil}">${perfil.nombrePerfil}</option> --%>
                                            <div class="form-group col-md-3 mb-2">
                                              <label for="situacionUsuario">Situaci&oacute;n</label>
	                                              <f:select id="situacionUsuario" name="interested" class="form-control select-del" path="situacion.codigoRegistro" >
	                                                  <option value="" >Todos</option>
	                                                  <f:options  items="${lstSituacion}"
	                                                                    itemValue="codigoRegistro"
	                                                                    itemLabel="nombreCorto"/>
	                                              </f:select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-12 text-right">
                                                <a class="btn btn-primary" title="" href = "${pageContext.request.contextPath}/usuarioController/nuevo"> <i class="icon-plus"></i> Nuevo</a>
                                                <a type="button" href="${pageContext.request.contextPath}/usuarioController/listado" class="btn btn-flat btn-secondary">
		                                                    <i class="fa fa-eraser"></i> Limpiar
		                                                </a>
                                                <button type="submit" class="btn btn-secondary mr-1" ><!-- onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/listado','GET')" -->
                                                  <i class="ft-search"></i> Buscar
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                 </f:form>
                                        <div class="row">
                                          <div class="col-xs-12">
                                            <table class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                        <th width="30">N°</th>
                                                        <th>Nombres completos</th>
                                                        <th>Nombre de usuario</th>
                                                        <th>Perfil</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="60">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                	<c:forEach var="usuarioBean" items="${lstUsuarioBean}" varStatus="theCount">
	                                                    <tr>
	                                                        <td>${theCount.count}</td>
	                                                        <td>${usuarioBean.persona.nombreCompleto}</td>
	                                                        <td>${usuarioBean.nombreUsuario}</td>
	                                                        <td>${usuarioBean.nombrePerfiles}</td>
	                                                        <td>${usuarioBean.situacion.nombreCorto}</td>
	                                                        <td>
	                                                         <a title="Modificar" 
                                                         	data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm"
                                                         	onclick="javascript:modificarElementoGenerico('/usuarioController/doObtenerxCodusu','${usuarioBean.codigoUsuario}')"
                                                         	><i class="icon-pencil"></i></a>
	                                                        <!-- 
	                                                        <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" href="doObtenerxCodusu?codigo=${usuarioBean.codigoUsuario}"><i class="icon-pencil"></i></a>
	                                                        -->
	                                                         <%--  <button type="button" class="btn btn-outline-success btn-sm " onclick="modificarUsuario(${usuarioBean.codigoUsuario},'${pageContext.request.contextPath}/usuarioController');" --%>
<!-- 	                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button> -->
	                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="eliminarUsuario(${usuarioBean.codigoUsuario},'${pageContext.request.contextPath}/usuarioController');"><i class="icon-trash"></i></button>
	                                                        </td>
	                                                    </tr>
	                                                </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th>N°</th>
                                                        <th>Nombres completos</th>
                                                        <th>Nombre de usuario</th>
                                                        <th>Perfil</th>
                                                        <th>Situaci&oacute;n</th>
                                                        <th>Acciones</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
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
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf-8" >
    function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }

//     function validarCodigoUsuario(){

// 		if(document.getElementById("idCodigoPersonal").value==0 || document.getElementById("idCodigoPersonal").value==""){
// 			document.getElementById("idCodigoPersonal").value=0;
// 			}

// 	}
    
    
       var codigo=0;
       var url="";

       function eliminarUsuario(id,prmUrl){


     	 codigo = id;
     	 url = prmUrl;
     	$("#md_confirmacion #txt_confir").html("Esta acci&oacute;n eliminar&aacute; el registro seleccionado,\n para continuar haga clic en Confirmar");
    	$("#md_confirmacion #myModalLabel19").html("Eliminar Usuario");
    	//$("#valorDato").val("GRABAR");
    	$("#md_confirmacion #btnConfirmarGeneric").attr("onclick","eliminar_usuario()");
     	 $('#md_confirmacion').modal('show');

       };
       function modificarUsuario(id,prmUrl){
	       	 codigo = id;

	       	var dirURL = prmUrl;
	       	 dirURL += "/obtener";
	       	iniciarBloqueo();
		        $.ajax({
		          url : dirURL,
		          type : 'POST',
		          data : {
		        	  		codigoUsuario : codigo
			          },
		          success : function(data) {
			          //console.log("resultado: ",data);
			          //alert("llegue papu");
			          $("#paginaUsuario").html(data);
			          var actual= document.getElementById('paginaUsuario');
			          actual.id="paginaRegistroUsuario";

		          },
		          error : function(request, status, error) {
		            //console.log('error: '+error);
		            msg_error();
		          },
		          complete: function(){
		        	  finBloqueo();
		        	  $('#md_confirmacion').modal('hidden');
			      }
		        });

        };
       	function eliminar_usuario(){
       		//console.log("codigo enviado desde html: ",codigo);
           	var dirURL = url;
	       	 dirURL += "/eliminar";
	       	iniciarBloqueo();
		        $.ajax({
		          url : dirURL,
		          type : 'POST',
		          data : {
		        	  		codigoUsuario : codigo
			          },
		          success : function(data) {
			          //console.log("resultado: ",data);
			          $("#paginaUsuario").html(data);
			          msg_exito();
		          },
		          error : function(request, status, error) {
		        	  //console.log('error: '+error);
			          msg_error();
		          },
		          complete: function(){
		        	  finBloqueo();
		        	  $('#md_confirmacion').modal('hidden');
			      }
		        });
         };

        function enviar_ajax(page,method){
        		//showLoad_info_ajax();
        		 var dirURL = page;
	       	 	//dirURL += page; // El script a dónde se realizará la petición.
        		iniciarBloqueo();
        		    $.ajax({
        		           type: method,
        		           url: dirURL,
        		           data: $("#paginaUsuario #formularioBusqueda").serialize(), // Adjuntar los campos del formulario enviado.
        		           success: function(data)
        		           {	
        		        	   $("#paginaUsuario").empty();
        		               $("#paginaUsuario").html(data); // Mostrar la respuestas del script.

        		           },
        					error: function(xhr,status,er) {
        						//console.log('error: '+error);
        				        msg_error();
        				    },
        		           complete: function(){
        		        	   finBloqueo();
        		        	   $('#md_confirmacion').modal('hidden');
        		             }
        		         });
        		    //confirmacionGenericoHidden();
        		    return false; // Evitar ejecutar el submit del formulario.
        	}
        function limpiarFiltros(form){
        	$(form+" input[type='text']").val("");
        	$(form+" input[type='date']").val("");
        	$(form+" .select-del").prop('selectedIndex',0);
        	  
        }
    </script>
  </body>
</html>