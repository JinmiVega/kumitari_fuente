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
    <title>Listado Carga Material </title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/../assets/css/base-natigu.css">
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
                 <li class="breadcrumb-item">General
                  </li>
                  <li class="breadcrumb-item active">Material
                  </li>
                  <li class="breadcrumb-item active">Carga directa
                  </li>
                  <li class="breadcrumb-item active">Listado Carga Material
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
                                  <h4 class="card-title">Listado Carga Material </h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                    <f:form method="post" action="buscar">
                                      <div class="form-body">
                                 		<div class="row">
                                        	<div class="col-md-4">
                                                <label for="projectinput1">Lengua</label>
                                                <f:select id="lblLengua" path="lengua.codigo" class="form-control">
                                                    <f:option value="0" label="Todos" />
                                                    <f:options items="${lstLengua}"
	                                                    		itemValue="codigo"
	                                                    		itemLabel="nombre"/>
                                                </f:select>
                                         	</div>
                                    	<div class="col-md-8">
                                            <div class="row">
                                              <div class="form-group col-md-4 mb-2">
                                                <label for="situacionUsuario">Situaci&oacute;n</label>
                                                <f:select id="lblSituacion" path="situacion.codigoRegistro" class="form-control">
                                                      <f:option value="0" label="Todos"/>
                                                    <f:options items="${lstSituacion}"
                                                    			itemValue="codigoRegistro"
                                                    			itemLabel="nombreCorto"/>
                                                    <!-- <option value="development">No activo</option> -->
                                                </f:select>
                                              </div>
                                            </div>
                                          </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-12 text-right">
                                                <a href="${pageContext.request.contextPath}/cargaMaterialController/nuevo" class="btn btn-primary" title=""> <i class="icon-plus"></i> Nuevo</a>
                                                <button type="submit" class="btn btn-secondary">
                                                  <i class="ft-search"></i> Buscar
                                                </button>
                                            </div>
                                        </div>
                                    <div class="row">
                                      <div class="col-xs-12">
                                        <table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                    <th>Nombre Lengua</th>
                                                    <th width="70">B&aacute;sico</th>
                                                    <th width="70">Intermedio</th>
                                                    <th width="70">Avanzado</th>
                                                    <th width="70">Unidades</th>
                                                    <th width="70">Situaci&oacute;n</th>
                                                    <th width="60">Acci&oacute;n</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="lenguaEstructuraBean" items="${lstLenguaEstructuraBean}" varStatus="loop">
                                             <tr>
                                                   <td>
                                                     <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/lengua/${lenguaEstructuraBean.lenguaBean.imagenNombre}" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                               ${lenguaEstructuraBean.lenguaBean.nombre}
                                                            </div>
                                                          </div>
                                                    </td>
                                                    <td>${lenguaEstructuraBean.basico}</td>
                                                    <td>${lenguaEstructuraBean.intermedio}</td>
                                                    <td>${lenguaEstructuraBean.avanzado}</td>
                                                    <td>${lenguaEstructuraBean.cantidadLeccion}</td>
                                                    <td>Activo</td>
                                                    <td>

                                                    <button id="idBtnEditarLengua" type="button"
																						onclick="lenguaCargarModal()"
																						class="btn btn-outline-success btn-sm">
																						<i class="icon-pencil"></i>
																					</button>
                                                    </td>
                                                </tr>
                                                 </c:forEach>
                                            </tbody>
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


    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
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
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/ui/scrollable.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script type="text/javascript" charset="utf-8" >
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
    </script>
  </body>
</html>