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
    <title>Sincronizar</title>
    <link rel="apple-touch-icon" href="../app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/custom.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/checkboxes-radios.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">

    <link href="${pageContext.request.contextPath}/assets/css/upload/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assets/css/upload/themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <style type="text/css" media="screen">
      .kv-file-zoom{
        display: none;;
      }
      .btn-secondary:hover{
       background: #626E82;
       color:#fff;
      }
    </style>
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
                  <li class="breadcrumb-item"><a href="#">Otros</a>
                  </li>
                  <li class="breadcrumb-item active">Configuraci&oacute;n
                  </li>
                  <li class="breadcrumb-item active">Ficha de Puntajes
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body">
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title">Sincronizar <b>archivo</b></h4>
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
                                      <ul class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link  active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="false">Generar archivo</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link " id="base-tab15" data-toggle="tab" aria-controls="tab15" href="#tab15" aria-expanded="false">Subir archivo</a>
                                        </li>
                                      </ul>

                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <div class="col-md-12">
                                            <div class="form-body">
                                              <div class="row">
                                                <div class="col-md-3">
                                                  <div class="form-group">
                                                    <label for="situacionPersonal">Tabla <span class="required">*</span></label>
                                                    <div class="controls">
                                                       <select id="cbTablas" onchange="escogerTabla()" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                                    <option value="" selected="true" disabled="disabled" label="Seleccionar">
                                                                   </option><option value="gene-leotbc_lengua" label="gene.leotbc_lengua">
                                                        </option></select>
                                                    <div class="help-block"></div></div>
                                                  </div>
                                                </div>
                                                </div>
                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">

                                                      <a href="/procalidad-natigu-web-gestion/offlineKumitsari/descargarArchivo/" id="enlaceDescargar" class="btn btn-primary" target="_blank" download="">Generar archivo</a>
                                                  </div>
                                              </div>
                                            </div>

                                          </div>
                                        </div>

                                        <div class="tab-pane " id="tab15" aria-labelledby="base-tab15">
                                          <div class="col-md-12">
                                            <form enctype="multipart/form-data" accept-charset="utf-8">
                                                <div class="form-group">
                                                    <div class="file-loading">
                                                        <input id="file-4" type="file" class="file" data-upload-url="#">
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
                      </div>
                  </div>
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />



    <jsp:include page="../../layout/confirmacion-modal-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="../app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script> -->
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- <script src="../app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script> -->
    <!-- <script src="../app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script> -->
    <!-- <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script> -->
    <!-- <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script> -->
<!--     <script src="../app-assets/js/scripts/forms/extended/form-typeahead.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/extended/form-inputmask.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/extended/form-maxlength.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/page/general/institucion/registro-institucion-script.js"></script>


    <script src="${pageContext.request.contextPath}/assets/js/upload/plugins/sortable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/upload/fileinput.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/upload/locales/fr.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/upload/locales/es.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/css/upload/themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/css/upload/themes/fa/theme.js" type="text/javascript"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>


     <script type="text/javascript" charset="utf-8" >
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }


    $("#file-4").fileinput({
        theme: 'fa',
        language: 'es',
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['jpg', 'png', 'gif'],
        maxFileSize: 1000,
        maxFilesNum: 10,
        uploadExtraData: {kvId: '10'}
    });
    $(".btn-warning").on('click', function () {
        var $el = $("#file-4");
        if ($el.attr('disabled')) {
            $el.fileinput('enable');
        } else {
            $el.fileinput('disable');
        }
    });
    $(".btn-info").on('click', function () {
        $("#file-4").fileinput('refresh', {previewClass: 'bg-info'});
    });

    </script>
  </body>
</html>