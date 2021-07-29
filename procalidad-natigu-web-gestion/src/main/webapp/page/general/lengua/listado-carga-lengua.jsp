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
    <title>Carga Lengua Listado</title>
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
                <h2 class="brand-text">Natigua</h2></a></li>
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
                  <li class="breadcrumb-item"><a href="#">Inicio</a>
                  </li>
                  <li class="breadcrumb-item active">Carga Lengua Listado
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
                                  <h4 class="card-title">Lengua Listado</h4>
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
                                    <form class="form">
                                      <div class="form-body">
                                        <div class="row">
                                            <div class="form-group col-md-3 mb-2">
                                                <label for="projectinput1">Nombre Lengua</label>
                                                <input type="text" id="projectinput1" class="form-control" name="fname">
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
                                                <a href="carga-lengua-registro.jsp" class="btn btn-primary" title=""> <i class="icon-plus"></i> Nuevo</a>
                                                <button type="button" class="btn btn-secondary">
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
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="60">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                 <c:forEach var="cargaMaterialBean" items="${lstCargaMaterialBean}">
                                                    <tr>

                                                        <td>
                                                          <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_01.jpg" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                              <h5 class="media-heading">${cargaMaterialBean.strLengua}</h5>
                                                            </div>
                                                          </div>
                                                        </td>
                                                        <td>${cargaMaterialBean.basico}</td>
                                                        <td>${cargaMaterialBean.intermedio}</td>
                                                        <td>${cargaMaterialBean.avanzado}</td>
                                                        <td>${cargaMaterialBean.strSituacion}</td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();">
                                                          <i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                     </c:forEach>
 <%--                                                    <tr>

                                                        <td>
                                                          <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_02.jpg" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                              <h5 class="media-heading">Chanka</h5>
                                                            </div>
                                                          </div>
                                                        </td>
                                                        <td>B1, B2, B3</td>
                                                        <td>I1, I2</td>
                                                        <td>A1, A2</td>
                                                        <td>Activo</td>
                                                         <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>

                                                        <td>
                                                          <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_03.jpg" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                              <h5 class="media-heading">Quechua collao</h5>
                                                            </div>
                                                          </div>
                                                        </td>
                                                        <td>B1</td>
                                                        <td>I1, I2</td>
                                                        <td>A1, A2</td>
                                                        <td>Activo</td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>

                                                        <td>
                                                          <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_04.jpg" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                              <h5 class="media-heading">Aimara</h5>
                                                            </div>
                                                          </div>
                                                        </td>
                                                        <td>B1, B2, B3</td>
                                                        <td>I1</td>
                                                        <td>A1</td>
                                                        <td>Activo</td>
                                                         <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>

                                                        <td>
                                                          <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_05.jpg" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                              <h5 class="media-heading">Shawi</h5>
                                                            </div>
                                                          </div>
                                                        </td>
                                                        <td>B1</td>
                                                        <td>-</td>
                                                        <td>-</td>
                                                        <td>Activo</td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                    --%>                             </tbody>
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
    <!-- END PAGE LEVEL JS-->
     <script type="text/javascript" charset="utf-8" >
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
    </script>
  </body>
</html>