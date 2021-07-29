<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Admin</title>
    <link rel="apple-touch-icon" href="../app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/charts/jquery-jvectormap-2.0.3.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/charts/morris.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/extensions/unslider.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/weather-icons/climacons.min.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="../app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="../app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <!-- link(rel='stylesheet', type='text/css', href='../app-assets/css#{rtl}/pages/users.css')-->
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="../assets/css/base-natigu.css">
    <!-- END Custom CSS-->
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="index.html" class="navbar-brand"><img id="logo-k" alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text" style="font-size: 1.54rem;"><img alt="stack admin logo" src="${pageContext.request.contextPath}/assets/img/Logo-Kumitsari-white.png" class="brand-logo"></h2></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="fa fa-ellipsis-v"></i></a></li>
          </ul>
        </div>
        <div class="navbar-container content container-fluid">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
              <jsp:include page="../layout/head-nav-view.jsp" />
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
        <ul id="main-menu-navigation" data-menu="menu-navigation" class="navigation navigation-main">
          <li class=" navigation-header"><span>General</span><i data-toggle="tooltip" data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
          </li>
          <li class=" nav-item"><a href="index.html"><i class="ft-home"></i><span data-i18n="" class="menu-title">Inicio</span></a>
          </li>
          <li class=" nav-item"><a href="lengua.html"><i class="ft-printer"></i><span data-i18n="" class="menu-title">Lengua</span></a>
          </li>
          <li class=" nav-item"><a href="carga-lengua.html"><i class="ft-printer"></i><span data-i18n="" class="menu-title">Carga Lengua</span></a>
          </li>
          <li class=" nav-item"><a href="pregunta.html"><i class="ft-printer"></i><span data-i18n="" class="menu-title">Preguntas</span></a>
          </li>
          <li class=" nav-item"><a href="institucion-listado.html"><i class="ft-printer"></i><span data-i18n="" class="menu-title">Instituci&oacute;n</span></a>
          </li>
          <li class=" nav-item"><a href="usuario.html"><i class="ft-user"></i><span data-i18n="" class="menu-title">Usuario</span></a>
          </li>
          <li class=" nav-item"><a href="#"><i class="ft-share"></i><span data-i18n="" class="menu-title">Timelines</span></a>
            <ul class="menu-content">
              <li><a href="timeline-center.html" class="menu-item">Timelines Center</a>
              </li>
              <li><a href="timeline-horizontal.html" class="menu-item">Timelines Horizontal</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
<div class="row">
    <div class="col-lg-12 col-md-12 col-xs-12">
        <div class="card">
            <div class="card-header no-border-bottom">
                <h4 class="card-title">Lecciones Listado</h4>
                <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                        <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-block card-dashboard">
                <div class="row">
                    <div class="form-group col-md-3 mb-2">
                        <label for="projectinput1">Nombre Lecci&oacute;n</label>
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
                        <a href="carga-lengua.html" class="btn btn-primary" title=""> <i class="icon-plus"></i> Nuevo</a>
                        <button type="button" class="btn btn-secondary mr-1">
                          <i class="ft-search"></i> Buscar
                        </button>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-bordered">
                      <thead>
                        <th>Informacion</th>
                        <th width="160">Acccion</th>
                      </thead>
                        <tbody>
                            <tr>
                                <td>
                                  <div class="media-left">
                                    <img class="media-object" src="../assets/img/idioma_01.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;"></div>
                                    <div class="media-body">
                                      <h5 class="media-heading">Quechua</h5>
                                    </div>
                                </td>
                                <td >
                                    <a href="lengua-lecciones-registro.html" class="btn btn-icon btn-pure secondary" data-toggle="tooltip" data-original-title="<b>Modificar</b> Lecci&oacute;n" data-html="true"><i class="ft-edit"></i></a>
                                    <button type="button" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-original-title="<b>Eliminar</b> Lecci&oacute;n" data-html="true"><i class="ft-trash-2"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                  <div class="media-left">
                                    <img class="media-object" src="../assets/img/idioma_02.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;"></div>
                                    <div class="media-body">
                                      <h5 class="media-heading">Chanka</h5>
                                    </div>
                                </td>
                                <td>
                                    <a href="lengua-lecciones-registro.html" class="btn btn-icon btn-pure secondary" data-toggle="tooltip" data-original-title="<b>Modificar</b> Lecci&oacute;n" data-html="true"><i class="ft-edit"></i></a>
                                    <button type="button" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-original-title="<b>Eliminar</b> Lecci&oacute;n" data-html="true"><i class="ft-trash-2"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                  <div class="media-left">
                                    <img class="media-object" src="../assets/img/idioma_03.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;"></div>
                                    <div class="media-body">
                                      <h5 class="media-heading">Quechua collao</h5>
                                    </div>
                                </td>
                                <td>
                                    <a href="lengua-lecciones-registro.html" class="btn btn-icon btn-pure secondary" data-toggle="tooltip" data-original-title="<b>Modificar</b> Lecci&oacute;n" data-html="true"><i class="ft-edit"></i></a>
                                    <button type="button" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-original-title="<b>Eliminar</b> Lecci&oacute;n" data-html="true"><i class="ft-trash-2"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                  <div class="media-left">
                                    <img class="media-object" src="../assets/img/idioma_04.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;"></div>
                                    <div class="media-body">
                                      <h5 class="media-heading">Aimara</h5>
                                    </div>
                                </td>
                                <td>
                                    <a href="lengua-lecciones-registro.html" class="btn btn-icon btn-pure secondary" data-toggle="tooltip" data-original-title="<b>Modificar</b> Lecci&oacute;n" data-html="true"><i class="ft-edit"></i></a>
                                    <button type="button" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-original-title="<b>Eliminar</b> Lecci&oacute;n" data-html="true"><i class="ft-trash-2"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                  <div class="media-left">
                                    <img class="media-object" src="../assets/img/idioma_05.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;"></div>
                                    <div class="media-body">
                                      <h5 class="media-heading">Shawi</h5>
                                    </div>
                                </td>
                                <td>
                                    <a href="lengua-lecciones-registro.html" class="btn btn-icon btn-pure secondary" data-toggle="tooltip" data-original-title="<b>Modificar</b> Lecci&oacute;n" data-html="true"><i class="ft-edit"></i></a>
                                    <button type="button" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-original-title="<b>Eliminar</b> Lecci&oacute;n" data-html="true"><i class="ft-trash-2"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                  <div class="media-left">
                                    <img class="media-object" src="../assets/img/idioma_06.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;"></div>
                                    <div class="media-body">
                                      <h5 class="media-heading">Awajún</h5>
                                    </div>
                                </td>
                                <td>
                                    <a href="lengua-lecciones-registro.html" class="btn btn-icon btn-pure secondary" data-toggle="tooltip" data-original-title="<b>Modificar</b> Lecci&oacute;n" data-html="true"><i class="ft-edit"></i></a>
                                    <button type="button" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-original-title="<b>Eliminar</b> Lecci&oacute;n" data-html="true"><i class="ft-trash-2"></i></button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <footer class="footer footer-static footer-light navbar-border">
      <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
      <span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="#" target="_blank" class="text-bold-800 grey darken-2">Natigu </a>, Todos los derechos reservados. </span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy business</span></p>
    </footer>

    <!-- BEGIN VENDOR JS-->
    <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../app-assets/vendors/js/extensions/jquery.knob.min.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/extensions/knob.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/charts/raphael-min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/charts/morris.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/charts/jvector/jquery-jvectormap-2.0.3.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/charts/jvector/jquery-jvectormap-world-mill.js" type="text/javascript"></script>
    <script src="../app-assets/data/jvector/visitor-data.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/charts/chart.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/charts/jquery.sparkline.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/extensions/unslider-min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../app-assets/css/core/colors/palette-climacon.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/simple-line-icons/style.min.css">
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="../app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
  </body>
</html>