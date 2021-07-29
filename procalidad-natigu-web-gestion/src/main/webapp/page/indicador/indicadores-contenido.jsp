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
    <title> Indicador</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/extensions/responsive.dataTables.min.css">
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
                  <li class="breadcrumb-item active"> Indicador
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
                                  <h4 class="card-title">Indicadores</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <!-- <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div> -->
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
									  <input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
									  <input type="hidden" id="idInstitucionUsu" value="${idInstitucion}">
                                      <ul class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Inscripciones</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab12" onclick="selectTabSeg()" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Seguimiento</a>
                                        </li>
                                      </ul>

                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <f:form class="form mt-1" id="formBusqInscripcion">
		                                      <div class="form-body">
		                                        <div class="row">
		                                            <div class="form-group col-md-6 mb-2">
		                                                <label for="cboInstRptInscr">Instituci&oacute;n</label>
		                                                <f:select id="cboInstRptInscr" path="${inst.codigo}"   class="form-control select-del">
															   <f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
<%-- 															<c:forEach var="inst" items="${lstInstitucionBean}"> --%>
<%--                                                             	<option value="${inst.codigo}" label="${inst.nombreInstitucion}"/> --%>
<%--                                                             </c:forEach> --%>
 															<f:options  items="${lstInstitucionBean}"
                                                            itemValue="codigo"
                                                            itemLabel="nombreInstitucion"/>
<%-- 																	<c:forEach var="inst" items="${lstInstitucionBean}">   --%>
<%--                                                             		<option value="${inst.codigo}" label="${inst.nombreInstitucion}"/> --%>
<%--                                                              	</c:forEach> --%>
														</f:select>
		                                            </div>

		                                            <div class="form-group col-md-4 mb-2">
		                                              	<label for="cboSitRptInscr">Situaci&oacute;n</label>
<!-- 														<select id="cboSitRptInscr"  class="form-control select-del"> -->
<!-- 															<option value="0" label="Seleccionar" /> -->
<%-- 															<c:forEach var="situacion" items="${lstSituacion}"> --%>
<%--                                                             	<option value="${situacion.codigoRegistro}" label="${situacion.nombreCorto}"/> --%>
<%--                                                             </c:forEach> --%>
<!-- 		                                            	</select> -->
		                                            	<f:select id="cboSitRptInscr"   path="${situacion.codigoRegistro}"  class="form-control select-del" >
															 <f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
<%-- 															<c:forEach var="situacion" items="${lstSituacion}"> --%>
<%--                                                             	<option value="${situacion.codigoRegistro}" label="${situacion.nombreCorto}"/> --%>
<%--                                                             </c:forEach> --%>
                                                            
                                                            
                                                            <f:options  items="${lstSituacion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                                            
		                                            	</f:select>
		                                            </div>
		                                        </div>

		                                        <div class="row">
		                                            <div class="form-group col-md-12 text-right">
		                                            	<button onclick="limpiarFiltros('#formBusqInscripcion','#tablaRptInscripcion')" type="button" class="btn btn-secondary mt-2">
		                                                    <i class="fa fa-eraser"></i> Limpiar
		                                                </button>
											        	<button class="btn btn-flat btn-secondary mt-2" type="button" onclick="reporteInscripciones()">
											        		<i class="ft-search"></i> Buscar
											        	</button>
		                                            </div>
		                                        </div>
		                                       </div>
											</f:form>

                                              <div class="row">
		                                          <div class="col-xs-12">
		                                            <table id="tablaRptInscripcion" class="table table-striped table-bordered zero-configuration">
		                                                <thead>
		                                                    <tr>
		                                                        <th width="40">N°</th>
		                                                        <th>Instituci&oacute;n</th>
		                                                        <th width="70">Per&iacute;odo - Semestre</th>
		                                                        <th width="70">Fecha de registro</th>
		                                                        <th width="120">Fecha de sincronización</th>
		                                                        <th width="70">Situaci&oacute;n</th>
		                                                    </tr>
		                                                </thead>
		                                                <tbody id="tbodyReportInscr"></tbody>
		                                                <tfoot>
		                                                    <tr>
		                                                        <th>N°</th>
		                                                        <th>Instituci&oacute;n</th>
		                                                        <th>Per&iacute;odo - Semestre</th>
		                                                        <th>Fecha registro</th>
		                                                        <th>Fecha sincronización</th>
		                                                        <th>Situaci&oacute;n</th>
		                                                    </tr>
		                                                </tfoot>
		                                            </table>
		                                          </div>
		                                        </div>

                                        </div>
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">

                                          <f:form id="frmBuscarSeguimientoAlumno" class="form"  role="form" method="post" action="buscar" onsubmit="return false">
		                                      <div class="form-body">
		                                        <div class="row">
		                                            <div class="form-group col-md-4 mb-2">
		                                              <label for="lblInstitu">Instituci&oacute;n</label>
		                                              <div class="controls">
		                                                <f:select id="lblInstitu" class="form-control select-del" path="${inst.codigo}" onchange="buscarLengua()">
															 <f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
															 <f:options items = "${lstInstitucionBean}" 
															 itemValue="codigo" 
															 itemLabel="nombreInstitucion" />
															    
<%-- 															<c:forEach var="inst" items="${lstInstitucionBean}"> --%>
<%--                                                             	<option value="${inst.codigo}" label="${inst.nombreInstitucion}"/> --%>
<%--                                                             </c:forEach> --%>
														</f:select>
													  </div>
		                                            </div>
		                                            <div class="form-group col-md-2 mb-2">
		                                              <label for="lblLengua">Lengua</label>
		                                              <div class="controls">
<!-- 		                                              	<select id="lblLengua" class="form-control select-del" onchange="buscarDocente(0)"> -->
<!-- 															<option value="0" label="Seleccionar" /> -->
<!-- 														</select> -->
														<f:select id="lblLengua" class="form-control select-del" path="${lenguaBean.codigo}" onchange="buscarDocente(0)">
																<f:option value="0" label="Seleccionar" /> 
																	<f:options items="${lstLenguaBean}" itemValue="lenguaBean.codigo" itemLabel="nombre" />
														</f:select>
													  </div>
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="lblDocente">Docente</label>
		                                              <div class="controls">
<!-- 		                                              	<select id="lblDocente" class="form-control select-del"> -->
<!-- 															<option value="0" label="Todos" /> -->
<!-- 														</select> -->
															<f:select id="lblDocente" path="${docenteBean.codigo}" class="form-control select-del" >
																<f:option value="0" label="Todos" /> 
																<f:options items="${lstDocenteBean}" itemValue="codigo" itemLabel="personaBean.nombreCompleto" />
															</f:select>
		                                              </div>
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="lblNivel">Nivel</label>
<!-- 		                                              <select id="lblNivel" class="form-control select-del"> -->
<!-- 															<option value="0" label="Todos" /> -->
<%-- 															<c:forEach var="nivel" items="${lstnivel}"> --%>
<%--                                                             	<option value="${nivel.codigoRegistro}" label="${nivel.nombreCorto}"/> --%>
<%--                                                             </c:forEach> --%>
<!-- 													  </select> -->
													     <f:select id="lblNivel" path="${nivel.codigoRegistro}" class="form-control select-del">
															<f:option value="0" label="Todos" /> 
															 <f:options items = "${lstnivel}" 
															 itemValue="codigoRegistro" 
															 itemLabel="nombreCorto" />
<%-- 															<c:forEach var="nivel" items="${lstnivel}"> --%>
<%--                                                             	<option value="${nivel.codigoRegistro}" label="${nivel.nombreCorto}"/> --%>
<%--                                                             </c:forEach> --%>
													  	</f:select>
		                                            </div>

		                                        <div class="row">
		                                        	</div>
		                                        	<div class="form-group col-md-2 mb-2">
		                                              <label for="lblPeriodo">Periodo</label>
<!-- 		                                                <select id="lblPeriodo" class="form-control select-del"> -->
<!-- 															<option value="0" label="Todos" /> -->
<%-- 															<c:forEach var="periodo" items="${lstPeriodo}"> --%>
<%--                                                             	<option value="${periodo.codigoRegistro}" label="${periodo.nombreCorto}"/> --%>
<%--                                                             </c:forEach> --%>
<!-- 													  </select> -->
		                                              <f:select id="lblPeriodo" path="${periodo.codigoRegistro}" class="form-control select-del">
															<f:option value="0" label="Todos" />
															<f:options items="${lstPeriodo}" itemValue="codigoRegistro"
															itemLabel="nombreCorto"     />
 
													  </f:select>
		                                            </div>
		                                            <div class="form-group col-md-2 mb-2">
		                                              <label for="lblSituacion">Situaci&oacute;n</label>
<!-- 		                                              <select id="lblSituacion" class="form-control select-del"> -->
<!-- 															<option value="0" label="Todos" /> -->
<%-- 															<c:forEach var="situacion" items="${lstSituacion}"> --%>
<%--                                                             	<option value="${situacion.codigoRegistro}" label="${situacion.nombreCorto}"/> --%>
<%--                                                             </c:forEach> --%>
<!-- 													  </select> -->
													   <f:select id="lblSituacion" path="${situacion.codigoRegistro}" class="form-control select-del">
															<f:option value="0" label="Todos" />
															<f:options items="${lstSituacion}" 
															itemValue="codigoRegistro"
															itemLabel="nombreCorto"/>
															 
													  </f:select>
		                                            </div>

		                                            <div class="form-group col-md-8 text-right">
		                                            	<button onclick="limpiarFiltros('#frmBuscarSeguimientoAlumno','#tablaRptSeguimiento')" type="button" class="btn btn-secondary mt-2">
		                                                    <i class="fa fa-eraser"></i> Limpiar
		                                                </button>
		                                                <button type="button" onclick="reporteSeguimiento()" class="btn btn-flat btn-secondary  mt-2">
		                                                  <i class="ft-search"></i> Buscar
		                                                </button>
		                                            </div>
		                                        </div>
		                                        <div class="row">
		                                          <div class="col-xs-12">
		                                            <table id="tablaRptSeguimiento" class="table table-striped table-hover table-bordered zero-configuration">
		                                                <thead>
		                                                    <tr>
		                                                    	<th width="20">N°</th>
		                                                        <th width="150">Instituci&oacute;n</th>
		                                                        <th>Docente</th>
		                                                        <th>Estudiante</th>
		                                                        <th>Usuario</th>
		                                                        <th width="120">Lengua - Nivel - Unidad - Lecci&oacute;n</th>
		                                                        <th width="50">Situaci&oacute;n</th>
		                                                    </tr>
		                                                </thead>
		                                                <tbody  id="listadoSeguimiento"></tbody>
		                                                <tfoot>
		                                                    <tr>
		                                                    	<th>N°</th>
		                                                        <th>Instituci&oacute;n</th>
		                                                        <th>Docente</th>
		                                                        <th>Estudiante</th>
		                                                        <th>Usuario</th>
		                                                        <th>Lengua - Nivel - Unidad - Lecci&oacute;n</th>
		                                                        <th>Situaci&oacute;n</th>
		                                                    </tr>
		                                                </tfoot>
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
                      </div>
                  </div>
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.responsive.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/buttons.colVis.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.colReorder.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/buttons.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.fixedHeader.min.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
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
	<!-- BEGIN SCRIPT PERSONALIZADO -->
	<script src="${pageContext.request.contextPath}/assets/js/page/indicadores-script.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
	
	<!-- END SCRIPT PERSONALIZADO -->

	<script type="text/javascript">
		//initDataTable('#tablaRptInscripcion');
		/*$('.dataex-res-controlright').DataTable({
	        responsive: {
	            details: {
	                type: 'column',
	                target: -1
	            }
	        },
	        columnDefs: [{
	            className: 'control',
	            orderable: false,
	            targets: -1
	        }]
	    });*/
	</script>

<%-- 	<script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables-extensions/datatable-responsive.js" type="text/javascript"></script> --%>
  </body>
</html>