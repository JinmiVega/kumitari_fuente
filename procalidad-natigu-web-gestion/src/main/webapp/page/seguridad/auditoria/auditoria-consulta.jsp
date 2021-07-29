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
    <title> Auditor&iacute;a general</title>
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
                  <li class="breadcrumb-item">Seguridad
                  </li>
                  <li class="breadcrumb-item active"> Auditor&iacute;a
                  </li>
<!--                   <li class="breadcrumb-item active"> Auditoría general -->
<!--                   </li> -->
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
                                  <h4 class="card-title">Auditor&iacute;a general</h4>
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
                                      <ul class="nav nav-tabs nav-top-border no-hover-bg">
                                      	<!--  
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Auditoría</a>
                                        </li>
                                        -->
                                         
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="true">Acceso</a>
                                        </li>
                                      </ul>

                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <f:form class="form mt-1" id="formBusqAuditoria">
		                                      <div class="form-body">
		                                        <div class="row">
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboTabla">Tabla</label>
		                                              <f:select id="cboTabla" name="cboTabla" class="form-control select-del" path="auditoriaBean.nomTabla">
				                                                    <option value="" >Todos</option>
				                                                    <f:options  items="${lstAuditoriaTabla}"
				                                                    			itemValue="nomTabla"
		                                                                        itemLabel="nomEsqTabConcat2"/>
				                                       </f:select>
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                                <label for="textUsuAud">Usuario</label>
		                                                <f:input type="text"
		                                                		 id="textUsuAud"
		                                                		 name="textUsuAud"
		                                                		 path="auditoriaBean.nomUsuario"
		                                                		 class="form-control"
		                                                		 maxlength="50" />
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboPerfilAud">Perfil</label>
		                                              <f:select id="cboPerfilAud" name="cboPerfilAud" class="form-control select-del" path="auditoriaBean.codPerfil">
				                                                    <option value="0" >Todos</option>
				                                                    <f:options  items="${lstPerfiles}"
				                                                    			itemValue="codigoPerfil"
		                                                                        itemLabel="nombrePerfil"/>
				                                       </f:select>
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboAccionAud">Acci&oacute;n</label>
		                                              <f:select id="cboAccionAud" name="cboAccionAud" class="form-control select-del" path="auditoriaBean.tipoAccion.codigoRegistro">
				                                                    <option value="0" >Todos</option>
				                                                    <f:option value="1" label="Insertar" />
				                                                    <f:option value="2" label="Actualizar" />
				                                                    <f:option value="3" label="Eliminar" />
				                                       </f:select>
		                                            </div>
		                                        </div>

		                                        <div class="row">
		                                        	<f:input type="hidden" id="textFecIniAud" path="auditoriaBean.strFecInicio" class="form-control" />
		                                        	<f:input type="hidden" id="textFecFinAud" path="auditoriaBean.strFecFin" class="form-control" />

		                                            <div class="form-group col-md-3 mb-2">
		                                                <label for="calendarFecIniAud">Fecha inicio</label>
		                                                <input type="date"
		                                                	   id="calendarFecIniAud"
		                                                	   class="form-control" />
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                                <label for="calendarFecFinAud">Fecha fin</label>
		                                                <input type="date"
		                                                	   id="calendarFecFinAud"
		                                                	   class="form-control" />
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboLimiteAud">L&iacute;mite</label>
		                                              <f:select id="cboLimiteAud" name="cboLimiteAud" class="form-control select-del" path="auditoriaBean.limite">
				                                                    <f:option value="50" label="50" />
				                                                    <f:option value="100" label="100" />
				                                                    <f:option value="200" label="200" />
				                                                    <f:option value="500" label="500" />
				                                       </f:select>
		                                            </div>
		                                        </div>

		                                        <div class="row">
		                                            <div class="form-group col-md-12 text-right">
		                                                <a href="${pageContext.request.contextPath}/auditoriaController/consulta" type="button" class="btn btn-secondary mr-1">
		                                                    <i class="fa fa-eraser"></i> Limpiar
		                                                </a>
		                                                <button onclick="buscarAudInit(1,'#formBusqAuditoria','GET')" type="button" class="btn btn-flat btn-secondary">
		                                                  <i class="ft-search"></i> Buscar
		                                                </button>
		                                            </div>
		                                        </div>
		                                       </div>
											</f:form>

                                              <div class="row">
		                                          <div class="col-xs-12">
		                                            <table id="idTablaAuditoria" class="table table-striped table-bordered">
		                                                <thead>
		                                                    <tr>
		                                                        <th width="30">N°</th>
		                                                        <th width="50">Tabla</th>
		                                                        <th width="50">Key</th>
		                                                        <th width="50">Operaci&oacute;n</th>
																<th width="120">Fecha</th>
																<th width="50">Usuario</th>
																<th >Nombre</th>
																<th width="50">Ip</th>
																<th width="50">Detalle</th>
																<th></th>
		                                                    </tr>
		                                                </thead>
		                                                <tbody id="idBodyTablaAuditoria">
		                                                	<%-- <c:forEach var="auditoria" items="${listaAuditoria}" varStatus="status">
		                                                		<tr id="row-data-${auditoria.codigo}">
													 				<td>${status.index+1}</td>
																	<td>${not empty auditoria.nomTabla ? auditoria.nomTabla : '---'}</td>
																	<td>${not empty auditoria.codRegistroAud ? auditoria.codRegistroAud : '---'}</td>
																	<td>${not empty auditoria.tipoAccion.nombreCorto ? auditoria.tipoAccion.nombreCorto : '---'}</td>
																	<td>${not empty auditoria.strFechaHoraAud ? auditoria.strFechaHoraAud : '---'}</td>
																	<td>${not empty auditoria.nomUsuario ? auditoria.nomUsuario : '---'}</td>
																	<td>${not empty auditoria.nomPersonaUsu ? auditoria.nomPersonaUsu : '---'}</td>
																	<td>${not empty auditoria.ipCreacion ? auditoria.ipCreacion : '---'}</td>
																	<td class="btn-bqd-submenu">
														                <button type="button"
														                		class="btn btn-outline-success btn-sm"
														                		data-toggle="tooltip"
														                		data-original-title="Detalle"
														                		onclick="verDetalle('${auditoria.codigo}')">
														                		<i class="ft-search"></i>
														                </button>
														            </td>
																</tr>
		                                                	</c:forEach> --%>
		                                                </tbody>
		                                                <tfoot>
		                                                    <tr>
		                                                        <th>N°</th>
		                                                        <th>Tabla</th>
		                                                        <th>Key</th>
		                                                        <th>Operaci&oacute;n</th>
																<th>Fecha</th>
																<th>Usuario</th>
																<th>Nombre</th>
																<th>Ip</th>
																<th>Detalle</th>
																<th></th>
		                                                    </tr>
		                                                </tfoot>
		                                            </table>
		                                          </div>
		                                        </div>

		                                        <div id="contentDetalleAud" class="row" style="display:none;">
		                                          <h4 class="card-title"></h4>
		                                          <div class="col-xs-6">
		                                            <table id="idTablaAuditoriaDetalle" class="table table-striped table-bordered">
		                                                <thead>
		                                                    <tr>
		                                                        <th width="30">N°</th>
											                    <th width="50">Campo</th>
											                    <th width="50">Anterior</th>
											                    <th width="50">Nuevo</th>
		                                                    </tr>
		                                                </thead>
		                                                <tbody id="idBodyTablaAuditoriaDetalle">
		                                                </tbody>
		                                                <!-- <tfoot>
		                                                    <tr>
		                                                        <th>#</th>
											                    <th>Campo</th>
											                    <th>Anterior</th>
											                    <th>Nuevo</th>
		                                                    </tr>
		                                                </tfoot> -->
		                                            </table>
		                                          </div>
		                                        </div>

                                        </div>
                                        <div class="tab-pane active" id="tab12" aria-labelledby="base-tab12">

                                            <f:form class="form mt-1" id="formBusqAudAcceso">
		                                      <div class="form-body">
		                                        <div class="row">
		                                            <div class="form-group col-md-3 mb-2">
		                                                <label for="textUsuAudAcc">Usuario</label>
		                                                <f:input type="text"
		                                                		 id="textUsuAudAcc"
		                                                		 name="textUsuAudAcc"
		                                                		 path="auditoriaAccesoBean.nomUsuario"
		                                                		 class="form-control" 
		                                                		 maxlength="50"/>
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboPerfilAudAcc">Perfil</label>
		                                              <f:select id="cboPerfilAudAcc" name="cboPerfilAudAcc" class="form-control select-del" path="auditoriaAccesoBean.codPerfil">
				                                                    <option value="0" >Todos</option>
				                                                    <f:options  items="${lstPerfiles}"
				                                                    			itemValue="codigoPerfil"
		                                                                        itemLabel="nombrePerfil"/>
				                                       </f:select>
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboSistemaAudAcc">Sistema</label>
		                                              <f:select id="cboSistemaAudAcc" name="cboSistemaAudAcc" class="form-control select-del" path="auditoriaAccesoBean.tipoSistema.codigoRegistro">
				                                                    <option value="0" >Todos</option>
				                                                    <f:option value="1" label="Procalidad" />
				                                                    <f:option value="2" label="Aprendizaje" />
				                                       </f:select>
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboAccionAudAcc">Acci&oacute;n</label>
		                                              <f:select id="cboAccionAudAcc" name="cboAccionAudAcc" class="form-control select-del" path="auditoriaAccesoBean.tipoAccion.codigoRegistro">
				                                                    <option value="0" >Todos</option>
				                                                    <f:option value="4" label="Acceder" />
				                                                    <f:option value="5" label="Usuario Inactivo" />
				                                                    <f:option value="6" label="Acceso Fallido" />
				                                                    <f:option value="7" label="Sin Privilegio de Acceso" />
				                                       </f:select>
		                                            </div>
		                                        </div>

		                                        <div class="row">
		                                        	<f:input type="hidden" id="textFecIniAudAcc" path="auditoriaAccesoBean.strFecInicio" class="form-control" />
		                                        	<f:input type="hidden" id="textFecFinAudAcc" path="auditoriaAccesoBean.strFecFin" class="form-control" />

		                                            <div class="form-group col-md-3 mb-2">
		                                                <label for="calendarFecIniAudAcc">Fecha Inicio</label>
		                                                <input type="date"
		                                                	   id="calendarFecIniAudAcc"
		                                                	   class="form-control" />
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                                <label for="calendarFecFinAudAcc">Fecha Fin</label>
		                                                <input type="date"
		                                                	   id="calendarFecFinAudAcc"
		                                                	   class="form-control" />
		                                            </div>
		                                            <div class="form-group col-md-3 mb-2">
		                                              <label for="cboLimiteAudAcc">L&iacute;mite</label>
		                                              <f:select id="cboLimiteAudAcc" name="cboLimiteAudAcc" class="form-control select-del" path="auditoriaAccesoBean.limite">
				                                                    <f:option value="50" label="50" />
				                                                    <f:option value="100" label="100" />
				                                                    <f:option value="200" label="200" />
				                                                    <f:option value="500" label="500" />
				                                       </f:select>
		                                            </div>
		                                        </div>

		                                        <div class="row">
		                                            <div class="form-group col-md-12 text-right">
		                                                <button onclick="limpiarCampos('#formBusqAudAcceso')" type="button" class="btn btn-secondary mr-1">
		                                                    <i class="fa fa-eraser"></i> Limpiar
		                                                </button>
		                                                <button onclick="buscarAudInit(2,'#formBusqAudAcceso','GET')" type="button" class="btn btn-flat btn-secondary">
		                                                  <i class="ft-search"></i> Buscar
		                                                </button>
		                                            </div>
		                                        </div>
		                                       </div>
											</f:form>

                                          <div class="row">
	                                          <div class="col-xs-12">
	                                            <table id="idTablaAuditoriaAcceso" class="table table-striped table-bordered zero-configuration">
	                                                <thead>
	                                                    <tr>
	                                                        <th width="30">N°</th>
															<th width="50">Sistema</th>
															<th width="90">Acci&oacute;n</th>
															<th width="120">Fecha</th>
															<th width="70">Usuario</th>
															<th >Nombre</th>
															<th width="70">IP</th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody id="idBodyTablaAuditoriaAcceso"></tbody>
	                                                <tfoot>
	                                                    <tr>
	                                                        <th>N°</th> 
															<th>Sistema</th>
															<th>Acci&oacute;n</th>
															<th>Fecha</th>
															<th>Usuario</th>
															<th>Nombre</th>
															<th>IP</th>
	                                                    </tr>
	                                                </tfoot>
	                                            </table>
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
	<script src="${pageContext.request.contextPath}/assets/js/page/seguridad/auditoria-consulta-script.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
	<!-- END SCRIPT PERSONALIZADO -->

	<script type="text/javascript">
	configDataTable('#idTablaAuditoria');
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