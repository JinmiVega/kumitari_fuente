<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Usuario</title>
    <link rel="apple-touch-icon" href="../app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/forms/icheck/custom.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="../app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="../app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/css/plugins/forms/checkboxes-radios.css">

    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="../assets/css/base-natigu.css">
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="index.html" class="navbar-brand"><img id="logo-k" alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text">Natigua</h2></a></li>
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
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="index.html">Inicio</a>
                  </li>
                  <li class="breadcrumb-item active">Usuario Listado
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
                                  <h4 class="card-title">Carga Lengua</h4>
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
                                    <div class="col-md-12">
                                      <form class="form">
                                        <div class="form-body">
                                          <div class="row">
                                            <div class="col-md-3">
                                              <label for="basicTextarea" class="card-title">Seleccionar Lengua</label>
                                              <div class="visible-scroll always-visible scroll-example height-300">
                                                <div class="vertical-scroll">
                                                  <div class="row">
                                                    <div class="card-body">
                                                      <div class="list-group">
                                                          <a href="#" class="list-group-item list-group-item-action media active">
                                                              <div class="media-left">
                                                                  <img class="media-object" src="../assets/img/idioma_01.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;">
                                                              </div>
                                                              <div class="media-body">
                                                                  <h5 class="list-group-item-heading">Quechua</h5>
                                                              </div>
                                                          </a>
                                                          <a href="#" class="list-group-item list-group-item-action media">
                                                              <div class="media-left">
                                                                  <img class="media-object" src="../assets/img/idioma_02.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;">
                                                              </div>
                                                              <div class="media-body">
                                                                  <h5 class="list-group-item-heading">Chanka</h5>
                                                              </div>
                                                          </a>
                                                          <a href="#" class="list-group-item list-group-item-action media">
                                                              <div class="media-left">
                                                                  <img class="media-object" src="../assets/img/idioma_03.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;">
                                                              </div>
                                                              <div class="media-body">
                                                                  <h5 class="list-group-item-heading">Quechua collao</h5>
                                                              </div>
                                                          </a>
                                                          <a href="#" class="list-group-item list-group-item-action media">
                                                              <div class="media-left">
                                                                  <img class="media-object" src="../assets/img/idioma_04.jpg" alt="Generic placeholder image" style="width: 48px;height: 48px;">
                                                              </div>
                                                              <div class="media-body">
                                                                  <h5 class="list-group-item-heading">Aimara</h5>
                                                              </div>
                                                          </a>
                                                      </div>
                                                    </div>
                                                  </div>
                                                </div>
                                              </div>
                                              <a href="lengua.jsp" title="" class="mt-1 btn btn-outline-secondary btn-min-width"><i class="ft-plus-circle"></i> Agregar Lengua</a>
                                            </div>

                                            <div class="col-xs-9">
                                              <div class="row skin skin-square">

                                                  <div class="form-group col-md-12 mb-0">
                                                      <label  class="card-title"><small>Nivel</small></label>
                                                  </div>
                                                  <div class="form-group col-md-12 mb-2">
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-11" checked>
                                                      <span class="custom-control-description">B&aacute;sico</span>
                                                    </label>
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-12">
                                                      <span class="custom-control-description">Medio</span>
                                                    </label>
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-13">
                                                      <span class="custom-control-description">Avanzado</span>
                                                    </label>
                                                  </div>

                                                  <div class="form-group col-md-12 mb-0">
                                                      <label  class="card-title"><small>Sub Niveles</small></label>
                                                  </div>

                                                  <div id="cl_B" class="form-group col-md-12 mb-2">
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-14">
                                                      <span class="custom-control-description">B1</span>
                                                    </label>
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-15">
                                                      <span class="custom-control-description">B2</span>
                                                    </label>
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-16">
                                                      <span class="custom-control-description">B3</span>
                                                    </label>
                                                  </div>

                                                  <div id="cl_I" class="form-group col-md-12 mb-2" style="display: none">
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-16">
                                                      <span class="custom-control-description">I1</span>
                                                    </label>
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-17">
                                                      <span class="custom-control-description">I2</span>
                                                    </label>
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-18">
                                                      <span class="custom-control-description">I3</span>
                                                    </label>
                                                  </div>

                                                  <div id="cl_A" class="form-group col-md-12 mb-2" style="display: none">
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-19">
                                                      <span class="custom-control-description">A1</span>
                                                    </label>
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-20">
                                                      <span class="custom-control-description">A2</span>
                                                    </label>
                                                  </div>
                                              </div>
                                            </div>
                                          </div>

                                          <div class="row">
                                              <div class="form-group col-md-12 text-right">
                                                  <button type="button" class="btn btn-secondary mr-1">
                                                    <i class="ft-search"></i> Limpiar
                                                  </button>
                                                  <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a>
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
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <footer class="footer footer-static footer-light navbar-border">
      <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
      <span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="https://themeforest.net/user/pixinvent/portfolio?ref=pixinvent" target="_blank" class="text-bold-800 grey darken-2">Natiguo </a>, Todos los derechos reservados. </span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy Business</span></p>
    </footer>
    <!-- BEGIN VENDOR JS-->
    <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="../app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../app-assets/js/scripts/ui/scrollable.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/checkbox-radio.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script type="text/javascript" charset="utf-8">

      $('#input-11').on('ifChecked', function(event){
        $("#cl_B").show(300);
      });
      $('#input-11').on('ifUnchecked', function(event){
        $("#cl_B").hide(300);
        $('#cl_B input').iCheck('uncheck');
      });

      $('#input-12').on('ifChecked', function(event){
        $("#cl_I").show(300);
      });
      $('#input-12').on('ifUnchecked', function(event){
        $("#cl_I").hide(300);
        $('#cl_I input').iCheck('uncheck');
      });

      $('#input-13').on('ifChecked', function(event){
        $("#cl_A").show(300);
      });
      $('#input-13').on('ifUnchecked', function(event){
        $("#cl_A").hide(300);
        $('#cl_A input').iCheck('uncheck');
      });

    </script>
  </body>
</html>