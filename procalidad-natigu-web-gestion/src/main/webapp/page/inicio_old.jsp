<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Indicador</title>
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
          <jsp:include page="../layout/menu-view.jsp" />
      </div>
    </div>

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
          <div class="row" style="display: none">
              <div class="col-xs-12">
                  <div class="card">
                      <div class="card-body">
                          <div class="card-block">
                              <div class="row">
                                  <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5 clearfix">
                                      <div class="media">
                                          <div class="media-left">
                                              <img class="media-object img-xl" src="../app-assets/images/portrait/small/avatar-s-5.png" alt="Generic placeholder image">
                                          </div>
                                          <div class="media-body">
                                              <h6 class="text-bold-500 pt-1 mb-0">Alumnos</h6>
                                              <p>4500</p>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5 clearfix">
                                      <p>Distance <span class="text-muted">(Last Week)</span></p>
                                      <progress class="progress progress-sm progress-success mb-1" value="45" max="100"></progress>
                                      <h6 class="text-bold-500 mb-0">80 KM</h6>
                                  </div>
                                  <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5 clearfix py-2 text-xs-center">
                                      <div id="fitness-stats"><canvas width="216" height="30" style="display: inline-block; width: 216px; height: 30px; vertical-align: top;"></canvas></div>
                                  </div>
                                  <div class="col-xl-3 col-lg-6 col-md-12 text-xs-center clearfix">
                                      <h6 class="pt-1"><span class="icon-clock"></span> 56:55 Hrs</h6>
                                      <p>Anverage Running Time</p>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>

          <div class="row">
              <div class="col-xs-12">
                  <div class="card">
                      <div class="card-body">
                          <div class="row">
                              <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1">
                                      <div class="card-header mb-2 pt-0 text-xs-center">
                                          <h5 class="primary">Total Alumnos</h5>
                                          <h3 class="font-large-2 text-bold-200">3600</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                              <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1 text-xs-center">
                                      <div class="card-header mb-2 pt-0">
                                          <h5 class="danger">B&aacute;sico</h5>
                                          <h3 class="font-large-2 text-bold-200">2600</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                              <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1 text-xs-center">
                                      <div class="card-header mb-2 pt-0">
                                          <h5 class="warning">Intermedio</h5>
                                          <h3 class="font-large-2 text-bold-200">800</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                              <div class="col-xl-3 col-lg-6 col-md-12">
                                  <div class="my-1 text-xs-center">
                                      <div class="card-header mb-2 pt-0">
                                          <h5 class="success">Avanzado</h5>
                                          <h3 class="font-large-2 text-bold-200">200</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>

          <div class="row">
              <div class="col-xs-12">
                  <div class="card">
                      <div class="card-body">
                          <div class="row">
                              <div class="col-xl-9 col-lg-9 col-md-9 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1">
                                      <div class="card-header mb-0 pt-1 text-xs-center">
                                          <h5 class="primary">Cuadro Estad&iacute;stico General</h5>
                                      </div>
                                      <div class="card-body">
                                        <div class="ml-1">
                                          <div id="daily-activity" class="table-responsive ps-container ps-theme-default ps-active-y">
                                              <table class="table table-hover mb-0">
                                                  <thead>
                                                      <tr>
                                                          <th>Lenguas</th>
                                                          <th>B&aacute;sico</th>
                                                          <th>Internedio</th>
                                                          <th>Avanzado</th>
                                                          <th>Finalizados</th>
                                                      </tr>
                                                  </thead>
                                                  <tbody>
                                                      <tr>
                                                          <td class="text-truncate">
                                                            <span class="tag tag-default tag-pill bg-default float-xs-right">4500</span>
                                                            <div class="media-left">
                                                              <img class="media-object" src="../assets/img/idioma_01.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">

                                                            </div>
                                                            <div class="media-body">
                                                              Quechua
                                                            </div>
                                                          </td>
                                                          <td class="text-truncate">650</td>
                                                          <td class="text-truncate">256</td>
                                                          <td class="text-truncate">150</td>
                                                          <td class="text-truncate">25</td>
                                                      </tr>
                                                      <tr>
                                                          <td class="text-truncate">
                                                            <span class="tag tag-default tag-pill bg-default float-xs-right">4100</span>
                                                            <div class="media-left">
                                                              <img class="media-object" src="../assets/img/idioma_03.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">

                                                            </div>
                                                            <div class="media-body">
                                                              Chanka
                                                            </div>
                                                          </td>
                                                          <td class="text-truncate">350</td>
                                                          <td class="text-truncate">256</td>
                                                          <td class="text-truncate">180</td>
                                                          <td class="text-truncate">15</td>
                                                      </tr>
                                                      <tr>
                                                          <td class="text-truncate">
                                                            <span class="tag tag-default tag-pill bg-default float-xs-right">6100</span>
                                                            <div class="media-left">
                                                              <img class="media-object" src="../assets/img/idioma_04.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">

                                                            </div>
                                                            <div class="media-body">
                                                              Quechua collao
                                                            </div>
                                                          </td>
                                                          <td class="text-truncate">350</td>
                                                          <td class="text-truncate">216</td>
                                                          <td class="text-truncate">180</td>
                                                          <td class="text-truncate">21</td>
                                                      </tr>
                                                      <tr>
                                                          <td class="text-truncate">
                                                            <span class="tag tag-default tag-pill bg-default float-xs-right">3100</span>
                                                            <div class="media-left">
                                                              <img class="media-object" src="../assets/img/idioma_05.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">

                                                            </div>
                                                            <div class="media-body">
                                                             Ashaninka
                                                            </div>
                                                          </td>
                                                          <td class="text-truncate">890</td>
                                                          <td class="text-truncate">186</td>
                                                          <td class="text-truncate">350</td>
                                                          <td class="text-truncate">25</td>
                                                      </tr>
                                                  </tbody>
                                              </table>
                                          </div>
                                        </div>
                                      </div>
                                  </div>
                              </div>
                              <div class="col-xl-3 col-lg-3 col-md-3">
                                  <div class="my-1 text-xs-center">
                                      <div class="card-header mb-2 pt-0">

                                      </div>
                                      <div class="card-body">
                                          <div style="display:inline;width:130px;height:130px;"></div>
                                          <ul class="list-inline clearfix pt-1 mb-0">
                                              <li>
                                                  <h2 class="grey darken-1 text-bold-400">125</h2>
                                                  <span class="success">Otra Estad&iacute;stica</span>
                                              </li>
                                          </ul>
                                      </div>
                                  </div>
                              </div>
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