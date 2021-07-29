<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title> Notificaci&oacute;n</title>
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
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Otros</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Configuraci&oacute;n</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#"> Notificaci&oacute;n</a>
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
                                  <h4 class="card-title">Notificaci&oacute;n</h4>
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
                                          <div class="container-aside">
                                            <div id="nav-notificacion">
                                              <!-- Emails list -->
                                            <div id="md-material-search" class="col-xs-12">
                                              <div class="card-block">
                                                <fieldset>
                                                  <div class="input-group">
                                                    <input type="text" class="form-control" placeholder="Buscar..." aria-describedby="button-addon4">
                                                    <span class="input-group-btn" id="button-addon4">
                                                      <button class="btn btn-primary" type="button"><i class="ft-search"></i></button>
                                                    </span>
                                                  </div>
                                                </fieldset>
                                              </div>
                                            </div>
                                              <div class="visible-scroll always-visible scroll-example height-450" style="margin-top: 80px;">
                                                <div class="vertical-scroll">
                                                  <ul class="panel media-list media-list-linked media-list-bordered emails-list no-border-top">
                                                    <li class="media notification-active border-left-xlg border-left-info cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img11.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media border-left-xlg border-left-danger cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img10.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media border-left-xlg border-left-info cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img9.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus.

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media border-left-xlg border-left-grey-200 cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img8.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Nullam dictum felis eu pede mollis pretium. Integer tincidunt.

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media">
                                                      <div class="media-link border-left-xlg border-left-warning cursor-pointer">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img7.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Donec quam felis, ultricies nec, pellentesque eu, pretium quis

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img6.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Donec quam felis, ultricies nec, pellentesque eu, pretium quis,

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media cursor-pointer">
                                                      <div class="media-link border-left-xlg border-left-success">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img7.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Nullam dictum felis eu pede mollis pretium.

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img8.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Donec quam felis, ultricies nec, pellentesque eu

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img9.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Aenean massa. Cum sociis natoque penatibus et magnis dis

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img10.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Nullam dictum felis eu pede mollis pretium. Integer tincidunt.

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>

                                                    <li class="media cursor-pointer">
                                                      <div class="media-link">
                                                        <div class="media-left">
                                                          <img src="../assets/img/user/img11.jpg" class=" rounded-circle" height="45px" width="45px" alt="">
                                                        </div>

                                                        <div class="media-body">
                                                          <div class="media-heading">Revisi&oacute;n Lengua</div>
                                                          Donec quam felis, ultricies nec, pellentesque eu, pretium quis

                                                          <div class="media-options">
                                                            <button type="button" class="btn btn-sm " data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar"><i class="icon-trash"></i></button>
<!--                                                             <i class="icon-attachment"></i>
                                                            <span class="date">10:15 am</span>
                                                            <div class="star">
                                                              <input type="checkbox" value="1" checked="">
                                                                <label></label>
                                                            </div> -->
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </li>
                                                  </ul>
                                                </div>
                                              </div>
                                              <!-- /Emails list -->
                                            </div>
                                            <div id="detalle-notificion">
                                              <!-- Single email -->
                                              <div class="panel panel-flat email" >
                                                <div class="panel-body p-20">
                                                  <h1 class="text-light no-margin-t">Revisi&oacute;n de Lengua</h1>
                                                  <hr>
                                                  <ul class="media-list">
                                                    <li class="media">
                                                      <div class="media-left p-r-15">
                                                        <a href="#"><img src="../assets/img/user/img11.jpg" class="rounded-circle" height="45px" width="45px" alt=""></a>
                                                      </div>
                                                      <div class="media-body">
                                                        <p class="m-b-0">Usuario 01</p>
                                                        <p class="text-sm">Hoy, 10 min</p>
                                                      </div>
                                                    </li>
                                                  </ul>
                                                  <hr>
                                                  <p>Cambios Subido en la lengua Quechua.</p>
                                                  <a href="#Link">Ver Cambios</a>
                                                </div>
                                              <!-- /Single email -->
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
    <script src="../app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="../app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/ui/scrollable.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  </body>
</html>