<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro Instituci&oacute;n</title>
    <link rel="apple-touch-icon" href="../app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="../app-assets/vendors/css/extensions/sweetalert.css">
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
    <link rel="stylesheet" type="text/css" href="../app-assets/fonts/font-awesome/css/font-awesome.min.css">
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
                  <li class="breadcrumb-item"><a href="index.html">General</a>
                  </li>
                  <li class="breadcrumb-item active">Registro Instituci&oacute;n
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
                                  <h4 class="card-title">Registro Instituci&oacute;n</h4>
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
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">General</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Ubicaci&oacute;n</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab13" data-toggle="tab" aria-controls="tab13" href="#tab13" aria-expanded="false">Informaci&oacute;n de Contacto</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab14" data-toggle="tab" aria-controls="tab14" href="#tab14" aria-expanded="false">Sedes / Filiales / Locales</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab15" data-toggle="tab" aria-controls="tab15" href="#tab15" aria-expanded="false">Lengua</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab16" data-toggle="tab" aria-controls="tab16" href="#tab16" aria-expanded="false">Operador Institucional (OI)</a>
                                        </li>
                                      </ul>
                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <form class="form mt-1">
                                            <div class="form-body">
                                              <div class="row">
                                                  <div class="col-md-8">
                                                      <label for="nombreInstitucion">Nombre Instituci&oacute;n</label>
                                                      <fieldset class="form-group position-relative">
                                                          <input type="text" class="form-control form-control-xl " id="nombreInstitucion">
                                                          <div class="form-control-position">
                                                          <i class="fa fa-building-o info font-medium-3"></i>
                                                          </div>
                                                      </fieldset>
                                                  </div>
                                                  <div class="form-group col-md-4 mb-2">
                                                    <label >Situaci&oacute;n</label>
                                                    <select id="situacionUsuario" name="interested" class="form-control">
                                                        <option value="none" selected="" disabled="">Seleccionar</option>
                                                        <option value="design" selected>Activo</option>
                                                        <option value="development">No activo</option>
                                                    </select>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                <div class="form-group col-md-4 mb-2">
                                                  <label >Tipo</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">ISE</option>
                                                      <option value="development">IESP</option>
                                                  </select>
                                                </div>
                                                <div class="form-group col-md-4 mb-2">
                                                  <label >Tipo Actividad</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">P&uacute;blica</option>
                                                      <option value="development">Privada</option>
                                                  </select>
                                                </div>
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">UGEL</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">C&oacute;digo Modular</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">C&oacute;digo Local</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                              </div>
                                              <div class="row">
                                                <div class="form-group col-md-12 mb-2">
                                                    <label for="descriptionInsticion">Descripci&oacute;n</label>
                                                    <textarea class="form-control" id="descriptionInsticion" rows="3"></textarea>

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
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                          <form class="form mt-1">
                                            <div class="form-body">
                                              <div class="row">
                                                  <div class="form-group col-md-4 mb-2">
                                                    <label for="projectinput6">Regi&oacute;n</label>
                                                    <select id="projectinput6" name="interested" class="form-control">
                                                        <option value="none" selected="" disabled="">Seleccionar</option>
                                                        <option value="design">AMAZONAS</option>
                                                        <option value="development">CUZCO</option>
                                                    </select>
                                                  </div>
                                                  <div class="form-group col-md-4 mb-2">
                                                    <label for="projectinput6">Provincia</label>
                                                    <select id="projectinput6" name="interested" class="form-control">
                                                        <option value="none" selected="" disabled="">Seleccionar</option>
                                                        <option value="design">Yungay</option>
                                                    </select>
                                                  </div>
                                                  <div class="form-group col-md-4 mb-2">
                                                    <label for="projectinput6">Distrito</label>
                                                    <select id="projectinput6" name="interested" class="form-control">
                                                        <option value="none" selected="" disabled="">Seleccionar</option>
                                                        <option value="design">Yungay</option>
                                                    </select>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                  <div class="col-md-12 mb-2">
                                                      <label for="nombreInstitucion">Direcci&oacute;n</label>
                                                      <input type="text"  class="form-control" name="fname">
                                                  </div>

                                              </div>
                                              <div class="row">
                                                <div class="form-group col-md-4 mb-2">
                                                  <label >&Aacute;rea Geográfica</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">Urbana</option>
                                                      <option value="development">Rural</option>
                                                  </select>
                                                </div>
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Latitud</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Longitud</label>
                                                    <input type="text"  class="form-control" name="fname">
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
                                        <div class="tab-pane" id="tab13" aria-labelledby="base-tab13">
                                          <form class="form mt-1">
                                            <div class="form-body">
                                              <div class="row">
                                                  <div class="col-md-8 mb-2">
                                                      <label for="nombreInstitucion">Nombre Director(a)</label>
                                                      <input type="text" disabled class="form-control" name="fname">
                                                  </div>
                                                  <div class="form-group col-md-2 mt-2">
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#bootstrap3">
                                                        <i class="ft-search"></i> Asignar
                                                      </button>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-md-8">
                                                  <label >Web Institucional</label>
                                                  <fieldset class="form-group position-relative has-icon-left">
                                                      <input type="text" class="form-control">
                                                      <div class="form-control-position">
                                                          <i class="icon-globe"></i>
                                                      </div>
                                                  </fieldset>
                                                </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-md-6">
                                                  <label>Tel&eacute;fono</label>
                                                  <fieldset class="form-group position-relative has-icon-left">
                                                      <input type="text" class="form-control phone-inputmask" id="phone-mask">
                                                      <div class="form-control-position">
                                                          <i class="ft-phone"></i>
                                                      </div>
                                                  </fieldset>
                                                </div>

                                                <div class="col-md-6">
                                                  <div class="form-group">
                                                    <label>Correo Electr&oacute;nico Institucional</label>
                                                    <fieldset class="form-group position-relative has-icon-left">
                                                        <input type="text" class="form-control email-inputmask" id="email-mask">
                                                        <div class="form-control-position">
                                                            <i class="icon-envelope"></i>
                                                        </div>
                                                    </fieldset>
                                                  </div>
                                                </div>

                                              </div>


                                              <div class="row">
                                                <div class="form-group col-md-12 mb-2">
                                                    <label for="descriptionInsticion">Descripci&oacute;n</label>
                                                    <textarea class="form-control" id="descriptionInsticion" rows="3"></textarea>

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

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th width="60">Fecha</th>
                                                              <th width="150">Director</th>
                                                              <th width="150">Web Institucional</th>
                                                              <th width="110">Tel&eacute;fono</th>
                                                              <th width="90">Correo</th>
                                                              <th >Descripci&oacute;n</th>
                                                              <th width="85">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                          <tr>
                                                          <td>01/04/2017</td>
                                                              <td>Kiara Reyes Mora</td>
                                                              <td>
                                                                <i class="ft-map-pin media-left media-middle"></i>
                                                                <div class="media-body">avantgard.edu.pe/
                                                              </td>
                                                              <td> Cel: 987823123 </td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">micorreo@correo.com</div>
                                                                </div>
                                                              </td>
                                                              <td>  Colegio de educaci&oacute;n primaria y secundaria</td>
                                                              <td>
                                                                <button type="button" class="btn btn-outline-success btn-sm "
                                                                data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                                <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>


                                                      </tbody>
                                                  </table>
                                                </div>
                                              </div>

                                            </div>
                                          </form>
                                        </div>

                                        <div class="tab-pane" id="tab14" aria-labelledby="base-tab14">
                                          <form class="form mt-1">
                                            <div class="form-body">
                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#bootstrap">
                                                        <i class="ft-search"></i> Agregar
                                                      </button>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th width="150">Nombre</th>
                                                              <th>Ubicaci&oacute;n</th>
                                                              <th>Datos</th>
                                                              <th width="120">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                          <tr>
                                                              <td>Sede Norte</td>
                                                              <td>
                                                                <i class="ft-map-pin media-left media-middle"></i>
                                                                <div class="media-body">Region/ Provincia / Distrito <br> Direc. Av Augusto Salazar cuadra 4</div>
                                                              </td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="ft-map-pin media-left media-middle"></i>
                                                                  <div class="media-body">Cel: 5581458 / telef: 0143656</div>
                                                                </div>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">micorreo@correo.com</div>
                                                                </div>
                                                                <div class="mb-0">
                                                                  <i class="ft-info media-left media-middle"></i>
                                                                  <div class="media-body">Informaci&oacute;n del contacto</div>
                                                                </div>
                                                              </td>
                                                              <td>
                                                                <button type="button" class="btn btn-outline-success btn-sm "
                                                              data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                                <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                          <tr>
                                                              <td>Sede Sur</td>
                                                              <td>
                                                                <i class="ft-map-pin media-left media-middle"></i>
                                                                <div class="media-body">Region/ Provincia / Distrito <br> Direc. Av Augusto Salazar cuadra 4</div>
                                                              </td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="ft-map-pin media-left media-middle"></i>
                                                                  <div class="media-body">Cel: 5581448 / telef: 0993656</div>
                                                                </div>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">micorreo@correo.com</div>
                                                                </div>
                                                                <div class="mb-0">
                                                                  <i class="ft-info media-left media-middle"></i>
                                                                  <div class="media-body">Informaci&oacute;n del contacto</div>
                                                                </div>
                                                              </td>
                                                              <td>
                                                                <button type="button" class="btn btn-outline-success btn-sm "
                                                              data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                                <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                              </td>
                                                              </td>
                                                          </tr>
                                                          <tr>
                                                              <td>Sede Oeste</td>
                                                              <td>
                                                                <i class="ft-map-pin media-left media-middle"></i>
                                                                <div class="media-body">Region/ Provincia / Distrito <br> Direc. Av Augusto Salazar cuadra 4</div>
                                                              </td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="ft-map-pin media-left media-middle"></i>
                                                                  <div class="media-body">Cel: 5981458 / telef: 9143656</div>
                                                                </div>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">micorreo@correo.com</div>
                                                                </div>
                                                                <div class="mb-0">
                                                                  <i class="ft-info media-left media-middle"></i>
                                                                  <div class="media-body">Informaci&oacute;n del contacto</div>
                                                                </div>
                                                              </td>
                                                              <td>
                                                                <button type="button" class="btn btn-outline-success btn-sm "
                                                              data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                                <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                      </tbody>
                                                  </table>
                                                </div>
                                              </div>
                                            </div>
                                          </form>
                                        </div>
                                        <div class="tab-pane" id="tab15" aria-labelledby="base-tab15">
                                          <form class="form mt-1">
                                            <div class="form-body">

                                              <div class="row">
                                                  <div class="col-md-3 mb-2">
                                                    <label >Lengua</label>
                                                    <select id="projectinput6" name="interested" class="form-control">
                                                        <option value="none" selected="" disabled="">Seleccionar</option>
                                                        <option value="design">Quechua</option>
                                                        <option value="development">Aymara</option>
                                                    </select>
                                                  </div>
                                                  <div class="form-group col-md-9 text-right ">
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width mt-2" onclick="agregar_accion();">
                                                        <i class="ft-search"></i> Agregar
                                                      </button>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th>Lengua</th>
                                                              <th width="210">Fecha</th>
                                                              <th width="120">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                          <tr>
                                                              <td>Aymara</td>
                                                              <td>10/07/2017</td>
                                                              <td class="text-sm-center">
                                                                <button type="button" class="btn btn-outline-danger btn-sm" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                          <tr>
                                                              <td>Quechua</td>
                                                              <td>01/06/2017</td>
                                                              <td class="text-sm-center">
                                                                <button type="button" class="btn btn-outline-danger btn-sm" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                          <tr>
                                                              <td>Ashaninka</td>
                                                              <td>01/06/2017</td>
                                                              <td class="text-sm-center">
                                                                <button type="button" class="btn btn-outline-danger btn-sm" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                      </tbody>
                                                  </table>
                                                </div>
                                              </div>
                                            </div>
                                          </form>
                                        </div>
                                        <div class="tab-pane" id="tab16" aria-labelledby="base-tab16">
                                          <form class="form mt-1">
                                            <div class="form-body">

                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#bootstrap2">
                                                        <i class="ft-search"></i> Asignar
                                                      </button>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th >Nombres</th>
                                                              <th>Cargo</th>
                                                              <th>N&ordm; Documento</th>
                                                              <th width="150">Correo</th>
                                                              <th>Fecha Reg.</th>
                                                              <th width="120">Situaci&oacute;n</th>
                                                              <th width="80">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                          <tr>
                                                              <td>Gabriel Luna Canto</td>
                                                              <td>Secretario </td>
                                                              <td>15977556</td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">glunac@correo.com</div>
                                                                </div>
                                                              </td>
                                                              <td>04/04/2017 </td>
                                                              <td>Activo </td>
                                                              <td>
                                                                <button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                              </td>
                                                          </tr>
                                                          <tr>
                                                              <td>Pablo Chinga Ramirez</td>
                                                              <td>Encargado de Obe </td>
                                                              <td>12377326</td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">pchingar@correo.com</div>
                                                                </div>
                                                              </td>
                                                              <td>01/07/2016 </td>
                                                              <td>No Activo </td>
                                                              <td>
                                                                <button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                              </td>
                                                          </tr>

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
                  </div>
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <footer class="footer footer-static footer-light navbar-border">
      <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
      <span class="float-md-left d-xs-block d-md-inline-block">Copyright  &copy; 2017 <a href="#" target="_blank" class="text-bold-800 grey darken-2">Natigu </a>, Todos los derechos reservados. </span><span class="float-md-right d-xs-block d-md-inline-block">Galaxy Business</span></p>
    </footer>

    <!-- Modal -->
    <div class="modal fade text-xs-left" id="bootstrap" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Registro sede/filial/local</b></label>
        </div>
        <form>
        <div class="modal-body">
          <div class="row">
            <div class="col-md-12 mb-2">
                <label>Nombre (sede/filial/local)</label>
                <input type="text" class="form-control" name="fname">
            </div>
          </div>
          <div class="row">
              <div class="form-group col-md-4 mb-2">
                <label for="projectinput6">Regi&oacute;n</label>
                <select id="projectinput6" name="interested" class="form-control">
                    <option value="none" selected="" disabled="">Seleccionar</option>
                    <option value="design">AMAZONAS</option>
                    <option value="development">CUZCO</option>
                </select>
              </div>
              <div class="form-group col-md-4 mb-2">
                <label for="projectinput6">Provincia</label>
                <select id="projectinput6" name="interested" class="form-control">
                    <option value="none" selected="" disabled="">Seleccionar</option>
                    <option value="design">Yungay</option>
                </select>
              </div>
              <div class="form-group col-md-4 mb-2">
                <label for="projectinput6">Distrito</label>
                <select id="projectinput6" name="interested" class="form-control">
                    <option value="none" selected="" disabled="">Seleccionar</option>
                    <option value="design">Yungay</option>
                </select>
              </div>
          </div>
          <div class="row">
            <div class="col-md-12 mb-2">
                <label>Direcci&oacute;n</label>
                <input type="text" class="form-control" name="fname">
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 mb-2">
                <label>Informaci&oacute;n Contacto</label>
                <input type="text" class="form-control" name="fname">
            </div>
          </div>
          <div class="row">
            <div class="col-md-6 mb-2">
                <label>Correo</label>
                <input type="email" class="form-control" name="fname">
            </div>
            <div class="col-md-6 mb-2">
                <label>Telf/Cel</label>
                <input type="email" class="form-control" name="fname">
            </div>
          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
          <button type="button" class="btn btn-primary"><i class="fa fa-floppy-o"></i> Guardar</button>
        </div>
        </form>
      </div>
      </div>
    </div>



    <!-- Modal 2 -->
                                          <div class="modal fade text-xs-left" id="bootstrap2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel25" aria-hidden="true">
                                             <div class="modal-dialog" role="document">
                                              <div class="modal-content">
                                                <div class="modal-header">
                                                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                 <span aria-hidden="true">&times;</span>
                                                   </button>
                                                  <label class="modal-title text-text-bold-600" id="myModalLabel25"><b>Registro Operador Institucional</b></label>
                                                </div>
                                                  <form>
                                                    <div class="modal-body">
                                                    <div class="row">
                                                     <div class="form-group col-md-5 mb-2">
                                                    <label for="situacionUsuario">Tipo de documento</label>
                                                    <select id="situacionUsuario" name="interested" class="form-control">
                                                     <option value="design">DNI</option>
                                                     <option value="development">Pasaporte</option>
                                                     <option value="development">Otro</option>
                                                    </select>
                                                    </div>

                                                      <div class="form-group col-md-4 mb-2">
                                                          <label for="projectinput2">N&uacute;mero de documento</label>
                                                          <input type="text" id="projectinput2" class="form-control" name="lname">
                                                      </div>
                                                      <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1">
                                                            <i class="ft-search"></i> Buscar
                                                          </button>
                                                      </div>
                                                    </div>
                                                  <div class="row">
                                                      <div class="form-group col-md-5 mb-2">
                                                          <label for="projectinput1">Nombre completo</label>
                                                          <input type="text" id="projectinput1" disabled class="form-control" name="fname">
                                                      </div>
                                                      <div class="form-group col-md-4 mb-2">
                                                          <label for="projectinput2">Cargo</label>
                                                          <input type="text" id="projectinput2" disabled class="form-control" name="lname">
                                                      </div>
                                                      <div class="form-group col-md-3 mb-2">
                                                       <label for="situacionUsuario">Situaci&oacute;</label>
                                                         <select id="situacionUsuario" name="interested" class="form-control">
                                                           <option value="design">Activo</option>
                                                           <option value="development">No Activo</option>
                                                         </select>
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                       <div class="form-group col-md-4 mb-2">
                                                          <label for="projectinput2">Tel&eacute;fono/Celular</label>
                                                          <input type="text" id="projectinput2" disabled class="form-control" name="lname">
                                                      </div>

                                                      <div class="form-group col-md-4 mb-2">
                                                          <label for="projectinput2">Correo electr&oacute;nico</label>
                                                          <input type="text" id="projectinput2" disabled class="form-control" name="lname">
                                                      </div>

                                                  </div>



                                               </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
          <button type="button" class="btn btn-primary"><i class="fa fa-floppy-o"></i> Asignar</button>
        </div>
        </form>
      </div>
      </div>
    </div>

     <!-- Modal 3 -->
                                          <div class="modal fade text-xs-left" id="bootstrap3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel25" aria-hidden="true">
                                             <div class="modal-dialog" role="document">
                                              <div class="modal-content">
                                                <div class="modal-header">
                                                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                 <span aria-hidden="true">&times;</span>
                                                   </button>
                                                  <label class="modal-title text-text-bold-600" id="myModalLabel25"><b>Asignar Director(a)</b></label>
                                                </div>
                                                  <form>
                                                    <div class="modal-body">
                                                    <div class="row">
                                                     <div class="form-group col-md-5 mb-2">
                                                    <label for="situacionUsuario">Tipo Documento</label>
                                                    <select id="situacionUsuario" name="interested" class="form-control">
                                                     <option value="design">DNI</option>
                                                     <option value="development">Pasaporte</option>
                                                     <option value="development">Otro</option>
                                                    </select>
                                                    </div>

                                                      <div class="form-group col-md-4 mb-2">
                                                          <label for="projectinput2">N&uacute;mero Documento</label>
                                                          <input type="text" id="projectinput2" class="form-control" name="lname">
                                                      </div>
                                                      <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1">
                                                            <i class="ft-search"></i> Buscar
                                                          </button>
                                                      </div>
                                                    </div>
                                                  <div class="row">
                                                      <div class="form-group col-md-8 mb-2">
                                                          <label for="projectinput1">Nombres completos</label>
                                                          <input type="text" id="projectinput1" disabled class="form-control" name="fname">
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                       <div class="form-group col-md-4 mb-2">
                                                          <label for="projectinput2">Tel&eacute;fono/Celular</label>
                                                          <input type="text" id="projectinput2" disabled class="form-control" name="lname">
                                                      </div>

                                                      <div class="form-group col-md-4 mb-2">
                                                          <label for="projectinput2">Correo Electr&oacute;nico</label>
                                                          <input type="text" id="projectinput2" disabled class="form-control" name="lname">
                                                      </div>

                                                  </div>



                                               </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
          <button type="button" class="btn btn-primary"><i class="fa fa-floppy-o"></i> Asignar</button>
        </div>
        </form>
      </div>
      </div>
    </div>


    <jsp:include page="../layout/confirmacion-modal-view.jsp" />
    <jsp:include page="../layout/registrar-modal-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="../app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="../app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/extended/form-typeahead.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/extended/form-inputmask.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/extended/form-maxlength.js" type="text/javascript"></script>
     <script type="text/javascript" charset="utf-8" >
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
        function agregar_accion(){
        $('#md_reg_confirmacion').modal('show');
       }
    </script>
  </body>
</html>