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
    <title>Listado de perfiles</title>
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
    
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar" id="paginaPerfil">

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

    <div class="app-content content container-fluid" >
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
               
                  <li class="breadcrumb-item active">Seguridad
                  </li>
                  <li class="breadcrumb-item active"> Perfil
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
                                  <h4 class="card-title"> Listado de perfiles</h4>
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
                                    <f:form class="form" id="formularioBusqueda" method="POST" role="form"  action="${pageContext.request.contextPath}/perfilController/buscar">
                                      <div class="form-body">
                                        <div class="row">
                                            <div class="form-group col-md-3 mb-2">
                                                <label for="projectinput1">Nombre de perfil </label>
                                                <f:input type="text" id="projectinput1" class="form-control" name="fname" path="nombrePerfil" maxlength="50"/>
                                            </div>



                                            <div class="form-group col-md-3 mb-2">
                                              <label for="situacionPerfil">Situaci&oacute;n</label>
                                              <f:select id="situacionPerfil" name="interested" class="form-control" path="situacion.codigoRegistro">
		                                                    <option value="" >Todos</option>
		                                                    <f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>

		                                       </f:select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-12 text-right">
                                                <a  class="btn btn-primary" title="" href = "${pageContext.request.contextPath}/perfilController/nuevo"> <i class="icon-plus"></i> Nuevo</a>

                                                <a href = "${pageContext.request.contextPath}/perfilController/listado" class="btn btn-secondary mr-1">
                                                    <i class="fa fa-eraser"></i> Limpiar
                                                </a>
												 <button type="submit" class="btn btn-secondary mr-1" > 
<%--                                                <button onclick="enviar_ajax('${pageContext.request.contextPath}/perfilController/buscar','GET')" type="button" class="btn btn-secondary mr-1"> --%>
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
                                                        <th width="40">N°</th>

                                                        <th>Nombre de perfil</th>

                                                        <th width="70">Tipo de situaci&oacute;n</th>
                                                        <th width="60">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                	<c:forEach var="perfilBean" items="${lstPerfilBean}" varStatus="theCount">
	                                                    <tr>
	                                                        <td>${theCount.count}</td><%--  <td>${perfilBean.codigoPerfil}</td> --%>
	                                                        <td>${perfilBean.nombrePerfil} </td>
	                                                        <td>${perfilBean.situacion.nombreCorto}</td>
	                                                        <td>
	                                                        
																 <a title="Modificar" 
	                                                         	 data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm"
	                                                         	 onclick="modificarPerfil(${perfilBean.codigoPerfil},'${pageContext.request.contextPath}/perfilController');"
	                                                         	 ><i class="icon-pencil"></i></a>
	                                                         	
	                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="eliminarPerfil(${perfilBean.codigoPerfil},'${pageContext.request.contextPath}/perfilController');"><i class="icon-trash"></i></button>
	                                                          <!-- <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button> -->
	                                                        </td>
	                                                    </tr>
	                                                 </c:forEach>




                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th>N°</th>
                                                        <th>Nombre de perfil</th>
                                                        <th>Tipo de situaci&oacute;n</th>
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
    <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="../app-assets/js/core/app.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
     <script type="text/javascript" charset="utf-8" >
     $(document).ready(function() { 
 	    var msj = $("#mensaje").val();//1
 	    if(msj=='1'){
 	      msg_exito();
 	    }else if(msj=='0'){
 	      msg_advertencia("Ya existe un registro con ese nombre");
 	    }
     });
     
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
       var codigo=0;
       var url="";

       function eliminarPerfil(perfil,prmUrl){


     	 codigo = perfil;
     	 url = prmUrl;
     	$("#md_confirmacion #txt_confir").html("Esta acci&oacute;n eliminar&aacute; el registro seleccionado,\n para continuar haga clic en Confirmar");
    	$("#md_confirmacion #myModalLabel19").html("Eliminar Perfil");
    	//$("#valorDato").val("GRABAR");
    	$("#md_confirmacion #btnConfirmarGeneric").attr("onclick","eliminar_perfil()");
     	 $('#md_confirmacion').modal('show');

       };
       function modificarPerfil(id,prmUrl){
	       	 codigo = id;

	       	var dirURL = prmUrl;
	       	 dirURL += "/obtener";

	       	//var urlComplete = document.getElementById('url_base-proyecto').value + url;
			doPost(dirURL, { codigoPerfil : codigo } );
	       	/*
	       	iniciarBloqueo();
		        $.ajax({
		          url : dirURL,
		          type : 'POST',
		          data : {
		        	  		codigoPerfil : codigo
			          },
		          success : function(data) {
			          //console.log("resultado: ",data);
			          $("#paginaPerfil").html(data);

		          },
		          error : function(request, status, error) {
		        	//alert(error);
		          },
		          complete: function(){
		        	  finBloqueo();
		        	  $('#md_confirmacion').modal('hidden');
			      }
		        });
		        */
		        return false;

        };
       	function eliminar_perfil(){
       		//console.log("codigo enviado desde html: ",codigo);
           	var dirURL = url;
	       	 dirURL += "/eliminar";
	       	iniciarBloqueo();
			 $.ajax({
		          url : dirURL,
		          type : 'POST',
		          data : {
		        	  		codigoPerfil : codigo
			          },
		          success : function(data) {
			          //console.log("resultado: ",data);
			          $("#paginaPerfil").html(data);
			          msg_exito();
		          },
		          error : function(request, status, error) {
					  //console.log('error: '+error);
		        	  msg_error();
		          },
		          complete: function(){
		        	  finBloqueo();
		        	//alert('take');
		        	  $('#md_confirmacion').modal('hide');
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
        		           data: $("#paginaPerfil #formularioBusqueda").serialize(), // Adjuntar los campos del formulario enviado.
        		           success: function(data)
        		           {	  
        		        	   
        		        	  
        		               $("#paginaPerfil").html(data); // Mostrar la respuestas del script.
        		                
        		           },
        					error: function(xhr,status,er) {
        					 	//console.log(er);
        					   /*box_msg(3,"Hubo un error al realizar la petición al servidor.");
        				     //console.log("error: " + xhr + " status: " + status + " er:" + er);
        					    if(xhr.status==500) {
        					    	//console.log(er);
        					    	Error_500(er);
        					    }
        					    if(xhr.status==901) {
        				    	//console.log(er);
        				    	spire_session_901(er);
        	         			}*/
        				    },
        		           complete: function(){
        		        	   finBloqueo();
        		         
        		        	  /*$('#md_confirmacion').modal('hidden');*/
        		        	 
        		             }
        		         });
//         		    confirmacionGenericoHidden();
        		    return false; 
        		    // Evitar ejecutar el submit del formulario.
        		   
        	}
    </script>
  </body>
</html>