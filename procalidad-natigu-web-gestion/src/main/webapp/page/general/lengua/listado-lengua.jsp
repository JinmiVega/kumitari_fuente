<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
   <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Listado de lengua </title>
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
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
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
                 <li class="breadcrumb-item"> General 
                  </li>
                  <li class="breadcrumb-item active"> Lengua 
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
                                  <h4 class="card-title">Listado de Lenguas </h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                    <f:form method="post" action="buscar">
                                      <div class="form-body">
                                        <div class="row">
                                            <div class="form-group col-md-3 mb-2">
                                                <label for="projectinput1">Nombre de la lengua</label>
                                                  <f:input type="text" maxlength="50" path="nombre" class="form-control"/>
                                            </div>
                                            <div class="form-group col-md-3 mb-2">
                                              <label for="situacionUsuario">Situaci&oacute;n</label>
                                              <f:select id="lblSituacion"  path="situacion.codigoRegistro" class="form-control">
                                                <f:option value="0" label="Seleccionar"/>
                                                <f:options  items="${lstSituacion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            </f:select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-12 text-right">
                                                <a href="${pageContext.request.contextPath}/lenguaController/nuevo" class="btn btn-primary" title=""> <i class="icon-plus"></i> Nuevo</a>
                                                 <button onclick="limpLeng();$('#tbllistadolengua').dataTable().fnClearTable();" type="button" class="btn btn-flat btn-secondary">
                                                    <i class="fa fa-eraser"></i> Limpiar
                                                </button>
                                                <button class="btn btn-secondary" type="submit">
                                                <i class="ft-search"></i> Buscar</button>
                                                 
                                            </div>
                                        </div>
                                        <div class="row">
                                          <div class="col-xs-12" id="listadoDetalleLengua">

                                            <table  id="tbllistadolengua" class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Nombre de la lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="80">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="lenguaBean" items="${lstLenguaBean}"  varStatus="loop">
                                                	
                                                    <tr>
														<td>${loop.count}</td>
                                                        <td>
                                                          <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                              <h5 class="media-heading">${lenguaBean.nombre}</h5>
                                                            </div>
                                                          </div>
                                                        </td>
                                                        <td>${lenguaBean.situacion.nombreCorto}</td>
                                                        <td>
                                                    <!--   <a title="Modificar" data-placement="top"
														data-toggle="tooltip"
														class="btn btn-outline-success btn-sm"
														href="modificar?codigo=${lenguaBean.codigo}"><i
															class="icon-pencil"></i></a>
															
														<a title="Eliminar" data-placement="top" data-toggle="tooltip"
                                                         class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${lenguaBean.codigo}"><i class="icon-trash"></i></a>
                                                         -->
                                                         <a title="Modificar" 
                                                         	data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm"
                                                         	onclick="javascript:modificarElementoGenerico('/lenguaController/modificar','${lenguaBean.codigo}')"
                                                         	><i class="icon-pencil"></i></a> 
                                                         	
                                                        <button type="button" class="btn btn-outline-danger btn-sm eliminarLengua"
															data-toggle="tooltip" data-placement="top" title="" onclick="confirmar_accion(${lenguaBean.codigo})"
															data-original-title="Eliminar" id="eliminarLengua${loop.index}" >
															<i class="icon-trash"></i>
														</button>
 														 </td>
                                                    </tr>
                                                 </c:forEach>

                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                         <th width="40">N°</th>
                                                        <th>Nombre de la lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="80">Acciones</th>
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
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
		<div class="modal fade text-xs-left" id="md_confirmacion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel19" aria-hidden="true">
		  <div class="modal-dialog modal-sm" role="document">
		  <div class="modal-content">
		    <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		      <span aria-hidden="true">&times;</span>
		    </button>
		    <h4 class="modal-title" id="myModalLabel19">Mensaje de confirmación</h4>
		    </div>
		    <div class="modal-body">
		    <p id="txt_confir">¿Estás seguro que deseas eliminar el registro seleccionado?</p>
		    </div>
		    <div class="modal-footer">
		    <button type="button" class="btn grey btn-outline-secondary" data-dismiss="modal">NO</button>
		    <button id="btnConfirmarGeneric" type="button" class="btn btn-outline-primary" onclick="eliminar?codigo=${lenguaBean.codigo}">SI</button>
		    
		    
		    </div>
		  </div>
		  </div>
		</div>


   <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="../app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
 
    <script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
		type="text/javascript"></script>
		<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
		type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
       <script>
		var accion_tab = "";
		function consultaEliminarLengua(idButton,codigoSede ){
			accion_tab = idButton;
			codSede =codigoSede;
			$('#md_confirmacion').modal('show');
		}
</script>
     <script type="text/javascript" charset="utf-8" >
        var accion_tab = "";
		var codigoLengua="";
		/* $("#eliminarSede").click(function() {
			console.log("id: " + this.id);
			accion_tab = this.id;
			$('#md_confirmacion').modal('show');
		}); */

		function limpLeng(){
		$("#nombre").val("");
		$("#lblSituacion").val("0");
		}

		function confirmar_accion(codigo) {
			codigoLengua = codigo;
			$('#md_confirmacion').modal('show');

		}
		function agregar_accion() {
			$('#md_reg_confirmacion').modal('show');
		}

		$("#btnConfirmarGeneric").click(function() {
				eliminarLengua(codigoLengua);
				accion_tab="";

		});

       function eliminarLengua(codigo){
         //  alert("eliminarLengua " + codigo);
	        $.ajax({
	          url : "${pageContext.request.contextPath}/lenguaController/eliminar?codigo="+codigo,
	          type : 'GET',
	          success : function(data) {
	        	  $('#md_confirmacion').modal('hide');
	        	  msg_exito();
	        	  refrescarTablaListadoLengua();
	          },
	          error : function(request, status, error) {
	        	//alert(error);
	          }
	        });

       		};

       	 function refrescarTablaListadoLengua() {
   			$.ajax({
	   			url : "${pageContext.request.contextPath}/lenguaController/listarLenguas?codigo=0",
	   			type : 'GET',

	   			success : function(data) {
	   				//console.log("SUCCESS: ", data);
	   				$('#listadoDetalleLengua').html(data);
	   			},
	   			error : function() {
	   				//console.log("ERROR: ");
	   			}
   		});

   	}
    </script>
  </body>
</html>