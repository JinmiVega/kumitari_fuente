<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Lengua Registro</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/checkboxes-radios.css">
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
                  <li class="breadcrumb-item active"><a href="#">Registro Lengua</a>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="card">
                        <div class="card-header">
                          <h4 class="card-title" id="basic-layout-icons">Registro Lengua </h4>
                          <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                          <div class="heading-elements">
                            <ul class="list-inline mb-0">
                              <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                              <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                              <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                              <li><a data-action="close"><i class="ft-x"></i></a></li>
                            </ul>
                          </div>
                        </div>
                        <div class="card-body collapse in">
                          <div class="card-block">
                            <ul class="nav nav-tabs nav-top-border no-hover-bg">
                              <li class="nav-item">
                                <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Registro</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Estructura de Ense&ntilde;anza</a>
                              </li>
                            </ul>

                            <div class="tab-content px-1 pt-1">
                              <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                 <f:form id="frmRegistroLengua" class="form-horizontal" role="form" method="post" enctype="multipart/form-data" action="grabar">
                                  <div class="form-body">
	                                  	<div class="col-xs-5">
	                                       <div class="form-group">
												<f:input type="file" class="filestyle" path="file" id="" />
	                                       </div>
	                                       <div class="form-group">
	                                       		<c:if test="${not empty lenguaBean.imagenNombre}">
				                                   <img class="media-object" src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
												</c:if>
	                                       </div>
										 </div>
                                    <%-- <div class="col-xs-5">

                                      <img src="${pageContext.request.contextPath}/assets/img/${lenguaBean.imagenNombre}" alt="element 01"  class="img-fluid" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;">
                                     </div>

                                      <img src="${pageContext.request.contextPath}/assets/img/${imagenNombre}" alt="element 01"  class="img-fluid" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;">
                                    </div> --%>

                                    <div class="col-xs-7">
                                      <div class="form-group">
                                        <label for="timesheetinput1">Nombre Lengua</label>
                                        <div class="position-relative has-icon-left">
                                          <f:input type="hidden" path="codigo"  id="codigoLengua"/>
                                          <input id="contextPath" type="hidden" value="${pageContext.request.contextPath}">
                                          <f:input type="text" class="form-control" path="nombre"/>
                                          <div class="form-control-position">
                                            <i class="ft-user"></i>
                                          </div>
                                        </div>
                                      </div>
 										<div class="form-group">
										<label for="lblSituacion" class="col-sm-4 control-label">Situaci&oacute;n</label>
											<f:select id="lblSituacion" path="situacion.codigoRegistro"
												class="form-control">
												<f:option value="0" label="Seleccionar" />
												<f:options items="${lstSituacion}"
													itemValue="codigoRegistro" itemLabel="nombreCorto" />
											</f:select>
									</div>
                                      <div class="form-group">
                                        <label for="timesheetinput7">Descripci&oacute;n</label>
                                        <div class="position-relative has-icon-left">
                                          <f:textarea rows="5" class="form-control" path="descripcion" ></f:textarea>
                                          <div class="form-control-position">
                                            <i class="ft-file"></i>
                                          </div>
                                        </div>
                                      </div>
                                      <div class="form-group text-right">
                                           <!--  <button type="button" class="btn btn-secondary mr-1">
                                            <i class="ft-search"></i> Limpiar
                                          </button>-->
                                          <a href="${pageContext.request.contextPath}/lenguaController/nuevo" class="btn btn-secondary" title=""> <i class="fa fa-eraser"></i> Limpiar</a>
                                          	<button id="btn-save-reg"	type="submit"
                                       			class="btn btn-flat btn-primary">
                                       			<i class="fa fa-floppy-o"></i>
                                       			Guardar
                                       		</button>

                                         <!--  <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a> -->
                                      </div>
                                    </div>

                                  </div>
                                </f:form>
                              </div>
                              <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                <form class="form mt-1">
                                  <div class="form-body">
                                    <div class="row">
                                        <div class="form-group col-md-3 mb-2">
                                            <label for="projectinput1">Nombre Lengua</label>
                                            <label  class="form-control">${lenguaBean.nombre}</label>
                                        </div>

                                        <div class="form-group col-md-3 mb-2">
                                          <label for="situacionUsuario">Situaci&oacute;n</label>
                                          <select id="situacionUsuario" name="interested" class="form-control">
                                              <option value="none" selected="" disabled="">Todos</option>
                                              <option value="design">Activo</option>
                                              <option value="development">No activo</option>
                                          </select>
                                        </div>
                                    </div>

                                    <div class="row">

                                        <div class="form-group col-md-12 text-right">
                                         <button id="idBtnCargarLengua" type="button" onclick="cargarLenguaEstructura()"
                                         class="btn btn-outline-secondary btn-min-width" >
                                            <i class="ft-search"></i> Agregar</button>

                                           <button class="btn btn-flat btn-primary" type="submit">
                                                <i class=" glyphicon glyphicon-search space-icon"></i> Buscar</button>

                                     </div>
                                    </div>
                                    <div class="row">
                                      <div class="col-xs-12">
                                        <table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                   <!--  <th>Nombre Lengua</th> -->
                                                    <th width="140">B&aacute;sico</th>
                                                    <th width="140">Intermedio</th>
                                                    <th width="140">Avanzado</th>
                                                    <th width="70">Acci&oacute;n</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="lenguaEstructuraBean" items="${lstLenguaEstructuraBean}">
                                                <tr>
                                                    <td>${lenguaEstructuraBean.basico}</td>
                                                    <td>${lenguaEstructuraBean.intermedio}</td>
                                                    <td>${lenguaEstructuraBean.avanzado}</td>
                                                    <td>
                                                      <button type="button" class="btn btn-outline-success btn-sm "
                                                      data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                      <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                    </td>
                                                </tr>
                                                 </c:forEach>

                                            </tbody>
                                        </table>

                                      </div>
                                    </div>

                                  </div>
                                </form>
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
    <!-- Modal -->
       <div class="modal fade text-xs-left" id="modalLenguaEstructura" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
	      <div class="modal-dialog" role="document">
		      <div class="modal-content" id="modalLenguaEstructuraContent">

		        </div>
	        </div>
        </div>
 	<div class="modal fade" id="modalLenguaEstructura_4" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-lg">
            <div class="modal-content" >

            </div>
          </div>
        </div>

    <jsp:include page="${pageContext.request.contextPath}/../layout/galeria-imagen-view.jsp" />
	  <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
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
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/select/form-select2.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/ui/scrollable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js" type="text/javascript"></script>



    <script >
    var path =null;
    $(document).ready(function() {
	 	path=document.getElementById("contextPath").value;

	 });

    function cargarLenguaEstructura(){
        var codigo 	=	document.getElementById("codigoLengua").value;
        var dirURL = 	path;
        dirURL  += "/lenguaController/listaEstructura?codigo="+codigo;
          $.ajax({
            url : dirURL,
            type : 'GET',
            success : function(data) {
              	$("#modalLenguaEstructura").modal('show');
              	$("#modalLenguaEstructuraContent").html(data);
            },
            error : function(request, status, error) {
            	//alert(error);
            }
          });
         }
    </script>

  </body>
</html>