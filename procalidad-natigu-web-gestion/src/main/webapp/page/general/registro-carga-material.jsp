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
    <title>Registro Carga Material</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
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
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

    <style>
          .thumb {
            height: 300px;
            border: 0px solid #000;
            margin: 10px 5px 0 0;
            max-height: 300px;
            max-width: 300px;
            overflow: hidden;
          }
          .thumb-mini {
            height: 180px;
            border: 0px solid #000;
            margin: 10px 5px 0 0;
            max-height: 120px;
            max-width: 120px;
            overflow: hidden;
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
                  <li class="breadcrumb-item"><a href="#">General</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Material</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Carga Directa </a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Registro Carga Material </a>
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
                                  <h4 class="card-title">Registro Carga Material</h4>
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
                                      <f:form method="post" class="form" action="buscarActividad">
                                        <div class="">
										<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
                                              <div class="row" id="contentBuscar">
                                                  <div class="col-md-3">
                                                    <fieldset class="form-group list-select">
                                                      <label for="cboLengua">Lengua</label>
                                                      <f:select id="cboLengua" path="lengua.codigo" class="form-control" onchange="cargarNiveles()">
                                                         <!--  <option selected="selected">Quechua</option> -->
                                                          <f:options items="${lstLengua}"
                                                          				itemValue="codigo"
                                                          				itemLabel="nombre"/>
                                                          <!-- <option>Quechua Collou</option>
                                                          <option>Aymara</option>
                                                          <option>Shawi</option> -->
                                                      </f:select>
                                                    </fieldset>
                                                    <%-- <fieldset class="form-group list-select">
                                                      <label for="countrySelect">Número Lecci&oacute;n</label>
                                                      <input type="number" id="nombreUnidadLec" class="form-control" name="fname">
                                                    </fieldset> --%>
                                                  </div>
                                                  <div class="col-md-7">
                                                    <div class="row">
                                                      <div class="form-group col-md-4 mb-2">
                                                        <label for="cboNivel">Nivel</label>
                                                        <f:select id="cboNivel" path="nivel.codigoRegistro" class="form-control" onchange="cargarSubNiveles()">
                                                            <f:option value="0" label="Todos"/>
                                                            <f:options items="${lstNivel}"
                                                            			itemValue="codigoRegistro"
                                                            			itemLabel="nombreCorto"/>
                                                            <!-- <option value="development">Intermedio</option>
                                                            <option selected value="illustration">Avanzado</option> -->
                                                        </f:select>
                                                      </div>
                                                      <div class="form-group col-md-4 mb-2">
                                                        <label for="cboSubNivel">Sub Nivel</label>
                                                        <%-- <f:select id="cboSubNivel"
                                                        path="leccion.unidadBean.lenguaEstructuraBean.codigo"
                                                        class="form-control" onchange="cargarUnidades()">
                                                            <f:option value="0" label="Seleccione"/>

                                                        </f:select> --%>
                                                        <f:select id="cboSubNivel" path="subNivel.codigoRegistro" class="form-control" onchange="cargarUnidades()">
                                                            <f:option value="0" label="Todos"/>
		                                                 <!--    	<f:options items="${lstSubNivel}"
		                                                    			itemValue="codigoRegistro"
		                                                    			itemLabel="nombreCorto"/>-->
                                                        </f:select>
                                                      </div>
                                                      <div class="form-group col-md-4 mb-2" id="idDivContenidoSeleccionarUnidades"  >
                                                        <label for="cboUnidad">Unidades</label>
                                                        <%-- <f:select id="cboUnidad" path="leccion.unidadBean.codigo" class="form-control">
                                                            <f:option value="0" label="Seleccione"/>
                                                        </f:select> --%>
                                                        <f:select id="cboUnidad" path="unidad.codigoRegistro" class="form-control">
                                                            <f:option value="0" label="Todos"/>
                                                           <!--  <f:options items="${lstUnidad}"
		                                                    			itemValue="codigoRegistro"
		                                                    			itemLabel="nombreCorto"/>-->
                                                        </f:select>
                                                      </div>
                                                    </div>

                                                  </div>
                                                  <div class="col-md-2  text-right">
                                                  	<div class="form-group col-md-12  text-right ">
		                                                  <label for="">&nbsp;</label><br />
		                                                  <button type="button" class="btn btn-info btn-flat" onclick="actividadCargarModal()">
		                                                    <i class="ft-search"></i> Crear Actividad
		                                                  </button>
													</div>
													<!-- <div class="form-group col-md-4 text-right">
													 	<label for="">&nbsp;</label><br />
		                                                <button type="submit" class="btn btn-flat btn-secondary">
		                                                  <i class="ft-search"></i> Buscar
		                                                </button>
		                                              </div> -->
                                                  </div>
                                              </div>


                                          <div id="contentActividad">

											<div id="actividad" class="row" style="display:none"></div>
											</div>
                                        <div class="row" id="busquedaActividad" style="display:none">
                                          <div class="col-xs-12">





                                            <table class="table table-striped table-hover table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                        <th>Nivel</th>
                                                        <th>Sub-Nivel</th>
                                                       <th>Unidad</th>
                                                       <th>Lecci&oacute;n</th>
                                                       <th>Ejercicio</th>

                                                        <th width="80">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                 <f:input type="hidden" path="codigo"  id="codigoEjercicio"/>
                                                <c:forEach var="ejercicioBean" items="${lstEjercicioBean}">
                                                    <tr>




                                                        <td>${ejercicioBean.leccion.tm2Nivel.nombreCorto}</td>
                                                        <td>${ejercicioBean.leccion.tm2SubNivel.nombreCorto}</td>
                                                        <td>${ejercicioBean.leccion.tm2Unidad.nombreCorto}</td>
                                                        <td>${ejercicioBean.leccion.nombreLeccion}</td>
                                                        <td>${ejercicioBean.tituloEjercicio}</td>
                                                        <td>
                                                            <button type="button" class="btn btn-outline-success btn-sm "
                                                            data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                            <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>



                                                    </tr>

                                                    </c:forEach>

                                                   <!-- <tr>

                                                        <td>Llave</td>
                                                        <td>se consigue facilmente</td>
                                                        <td><img class="media-object" src="${pageContext.request.contextPath}/assets/img/pr1.jpg" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                        </td>
                                                        <td>250</td>
                                                        <td>Medalla - B&aacute;sica</td>
                                                        <td>Activo</td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>   -->
                                                    </tbody>
                                            </table>


















                                          <!--
                                            <table class="table table-striped table-bordered zero-configuration dataTable">
                                                <thead>
                                                    <tr>
                                                        <th width="70">Nivel</th>
                                                        <th width="60">Sub-Nivel</th>
                                                        <th colspan="3">Informaci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                              <tbody>
                                              <tr>
                                                <th rowspan="42">Básico</th>
                                                <th rowspan="14">B1</th>
                                                <th colspan="3">UNIDAD 01</th>
                                              </tr>
                                              <tr>
                                                <td rowspan="3" width="180">Lecci&oacute;n 01</td>
                                                <td>Ejercicio 01</td>
                                                <td width="80">
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 02</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <th colspan="3">UNIDAD 02</th>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 01</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 02</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <th rowspan="14">B2</th>
                                                <th colspan="3">UNIDAD 01</th>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 01</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 02</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <th colspan="3">UNIDAD 02</th>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 01</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 02</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td rowspan="14">B3</td>
                                                <th colspan="3">UNIDAD 01</th>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 01</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 02</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <th colspan="3">UNIDAD 02</th>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 01</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td rowspan="3">Lecci&oacute;n 02</td>
                                                <td>Ejercicio 01</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 02</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              <tr>
                                                <td>Ejercicio 03</td>
                                                <td>
                                                    <button type="button" class="btn btn-outline-success btn-sm "
                                                    data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                </td>
                                              </tr>
                                              </tbody>
                                            </table>
                                            -->









                                          <!-- OLD -->
<!--                                             <table class="table table-striped table-bordered zero-configuration dataTable">
                                                <thead>
                                                    <tr>
                                                        <th width="70">Idioma</th>
                                                        <th width="60">Nivel</th>
                                                        <th colspan="3">Informaci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                   <tr>
                                                      <th rowspan="24">Quechua</th>
                                                      <th rowspan="8">B1</th>
                                                      <th colspan="2">UNIDAD 01</th>
                                                    </tr>
                                                    <tr>
                                                      <td>Actividad 01</td>
                                                      <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>Activdad 02</td>
                                                      <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 03</td>
                                                      <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                      <th colspan="2">UNIDAD 02</th>
                                                    </tr>
                                                    <tr>
                                                      <td colspan="2">actividad 01</td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 02</td>
                                                      <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 03</td>
                                                      <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                      <th rowspan="8">B2</th>
                                                      <th colspan="2">Unidad 01</th>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 01</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 02</td>
                                                      <td></td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 03</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <th colspan="2">Unidad 02</th>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 01</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 02</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 04</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <th rowspan="8">B3</th>
                                                      <th colspan="2">UNIDAD 01</th>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 01</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 02</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 03</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <th colspan="2">UNIDAD 02</th>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 01</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 02</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                      <td>actividad 03</td>
                                                      <td width="70">
                                                        <button type="button" class="btn btn-outline-success btn-sm">
                                                          <i class="icon-pencil"></i>
                                                        </button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm">
                                                            <i class="icon-trash"></i>
                                                        </button>
                                                      </td>
                                                    </tr>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                      <th colspan="3" style="text-align:right" rowspan="1">Total Activades:</th>
                                                      <th rowspan="1" colspan="1">25</th></tr>
                                                </tfoot>
                                            </table> -->
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

	<script>



	function validarCombos(idNivel,idSubNivel,idUnidad)
	{
		let val = false;
		//console.log("valoresniv: "+ idNivel + "/"+ idSubNivel + "/"+ idUnidad);
		let cadena = 'Para agregar una actividad ';
		if(idNivel == 0)
		{
			msg_advertencia(cadena + 'debe seleccionar un nivel.');
			val = false;
		}
		else if(idSubNivel == 0)
		{
			msg_advertencia(cadena + 'debe seleccionar un sub nivel.');
			val = false;
		}
		else if(idUnidad == 0)
		{
			msg_advertencia(cadena + 'debe seleccionar una unidad.');
			val = false;
		} else {
			val = true;
		}
		return val;
	}

    function actividadCargarModal(){
    	let cadena = 'Para agregar una actividad ';
    	var idLengua = document.getElementById("cboLengua").value;
    	var idNivel = document.getElementById("cboNivel").value;
    	var idSubNivel = document.getElementById("cboSubNivel").value;
    	var idUnidad = document.getElementById("cboUnidad").value;
    	//console.log("idLengua: " + idLengua);
    	//console.log("valores: "+ idNivel + "/"+ idSubNivel + "/"+ idUnidad);
    	/*if(idLengua=="0"){
    		msg_advertencia(cadena + 'debe seleccionar una lengua.');
    	} else if(idNivel=="0"){
    		msg_advertencia(cadena + 'debe seleccionar un nivel.');
    	} else if(idSubNivel=="0"){
    		msg_advertencia(cadena + 'debe seleccionar un sub nivel.');
    	} else if(idUnidad=="0"){
    		msg_advertencia(cadena + 'debe seleccionar una unidad.');
    	}else{*/
			iniciarBloqueo();
			$.ajax({
				type : "GET",

				url : "${pageContext.request.contextPath}/cargaMaterialController/actividadCargarModal",
				data : {codigolengua:idLengua, codigonivel:idNivel, codigosubnivel:idSubNivel,liCodUnid:idUnidad},
				success : function(data)
				{
					finBloqueo();
					//console.log("SUCCESSX: ", data);
					$('#contentActividad').html(data);
					$("#busquedaActividad").hide();
					$("#contentBuscar").hide();
					//$('#create_actividad').modal('show');
	//				alert("${lenguaActividad}");

				/* 	actividadCargarModal2(idLengua,idNivel,idSubNivel); */
					//cargarModalNiveles();
					//cargarModalSubNiveles();
					//cargarModalUnidades();
					//cargarContenido("999");
					/* alert(idNivel); */
					/* $('#modalCboNivel').val(idNivel); */
					/* alert(idSubNivel); */
					/* $('#modalCboSubNivel').val(idSubNivel); */
					/* alert(idUnidad); */
					/* $('#modalCboUnidad').val(idUnidad); */


					/* function refrescarInformes(); */

					/* document.getElementById("modalNombreLengua").innerHTML = data.nombre; */
				},
				error : function()
				{
					finBloqueo();
					//alert("Seleccione la lengua AWAJUN para pruebas");
					//console.log("ERROR: ");
				}
			});
		//}
	}




   /*  function cargarContenido(val)
    {
		var valor 		= val;
    	var idLengua 	= document.getElementById("cboLengua").value;
    	var idNivel 	= document.getElementById("cboNivel").value;
    	var idSubNivel 	= document.getElementById("cboSubNivel").value;
    	var url = "${pageContext.request.contextPath}/cargaMaterialController/cargarContenido";
    	//alert(valor);
    	if(valor = "999")
        {
    		url = "${pageContext.request.contextPath}/cargaMaterialController/cargarContenidoPrincipal"
				alert(url);
    			$.ajax({
    				type 	: "POST",
    				data 	: {valor:valor, codigolengua:idLengua, codigonivel:idNivel, codigosubnivel:idSubNivel},
    				url 	: url,

    				success : function(data1)
    				{
    					document.getElementById("content-md-frm").innerHTML = data1;
    				},
    				error : function()
    				{
    					//console.log("ERROR: ");
    				}
    			});
        }
    	else
        {
            alert(url);
    		$.ajax({
    			type 	: "POST",
    			data 	: {valor:valor},
    			url 	: url,

    			success : function(data1)
    			{
    				document.getElementById("content-md-frm").innerHTML = data1;
    			},
    			error : function()
    			{
    				//console.log("ERROR: ");
    			}
    		});
        }
	} */

	</script>

    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/../layout/galeria-imagen-view.jsp" />
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/ui/scrollable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/actividad.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
	<!-- BEGIN SCRIPT PERSONALIZADO -->
	<script src="${pageContext.request.contextPath}/assets/js/page/general/material/carga-directa-script.js" type="text/javascript" charset="utf-8"></script>
	<!-- END SCRIPT PERSONALIZADO -->
    <!-- END PAGE LEVEL JS-->

     <script type="text/javascript" charset="utf-8" >

     	$(document).ready(function(){
     		$("#contentBuscar").hide();
     		actividadCargarModal();

	 	});

        function ejercion_modal(){
          $('#create_actividad').modal('show');
          informe_lengua();
        }
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
    </script>
  </body>
</html>