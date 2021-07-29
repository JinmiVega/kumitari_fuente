<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es" data-textdirection="ltr" class="loading">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Lengua Registro</title>
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<!-- <script
	src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js"
	type="text/javascript"></script> -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/icheck.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/custom.css">
<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/app.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/colors.css">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/checkboxes-radios.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">

<!-- END Page Level CSS-->
	<style type="text/css">
	    .form-invalid select{
	     	color: #FF7588 !important;
    		border-color: #FF7588 !important;
	    }
	    .form-invalid .controls::after{
	        content: "Este campo es requerido";
		    line-height: 1.8;
		    color: #ff7588;
		    padding-left: 21px;
	    }
    </style>
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
	
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">

	<!-- navbar-fixed-top-->
	<nav
		class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
						href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu font-large-1"></i></a></li>
					<li class="nav-item"><a href="#" class="navbar-brand"><img id="logo-k" alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text" style="font-size: 1.54rem;"><img alt="stack admin logo" src="${pageContext.request.contextPath}/assets/img/Logo-Kumitsari-white.png" class="brand-logo"></h2></a></li>
					<li class="nav-item hidden-md-up float-xs-right"><a
						data-toggle="collapse" data-target="#navbar-mobile"
						class="nav-link open-navbar-container"><i
							class="fa fa-ellipsis-v"></i></a></li>
				</ul>
			</div>
			<div class="navbar-container content container-fluid">
				<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
					<jsp:include
						page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
				</div>
			</div>
		</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->

	<div data-scroll-to-active="true"
		class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
		<div class="main-menu-content">
			<jsp:include
				page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
		</div>
	</div>

	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"> General </li>
								<li class="breadcrumb-item active"> Lengua</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<div class="content-body">
				<!-- Analytics spakline & chartjs  -->
				<section id="configuration">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="basic-layout-icons">Registro de
										Lengua</h4>
									<a class="heading-elements-toggle"><i
										class="fa fa-ellipsis-v font-medium-3"></i></a>
									<div class="heading-elements">
										 
									</div>
								</div>
								<div class="card-body collapse in">
									<div class="card-block">
										<ul class="nav nav-tabs nav-top-border no-hover-bg">
											<li class="nav-item"><a class="nav-link active"
												id="base-tab11" data-toggle="tab" aria-controls="tab11"
												href="#tab11" aria-expanded="true">Registro</a></li>

											<li class="nav-item"><a class="nav-link" id="base-tab12"
												data-toggle="tab" aria-controls="tab12" href="#tab12"
												aria-expanded="false">Estructura de ense&ntilde;anza</a></li>

											<li class="nav-item"><a class="nav-link" id="base-tab13"
												data-toggle="tab" aria-controls="tab13" href="#tab13"
												aria-expanded="false">Agregar unidad</a></li>
												
											<li class="nav-item" ><a onclick="listarLenguaUnidad();" class="nav-link" id="base-tab14"
												data-toggle="tab" aria-controls="tab14" href="#tab14"
												aria-expanded="false">Cargar imagen unidad</a></li>	
											<li class="nav-item" ><a onclick="listarLenguaLeccion();" class="nav-link" id="base-tab15"
												data-toggle="tab" aria-controls="tab15" href="#tab15"
												aria-expanded="false">Cargar imagen lección</a></li>												
										</ul>

										<div class="tab-content px-1 pt-1">
											<div role="tabpanel" class="tab-pane active" id="tab11"
												aria-expanded="true" aria-labelledby="base-tab11">

												<f:form id="frmRegistroLengua" class="form-horizontal"
													role="form" enctype="multipart/form-data" method="post"
													action="${pageContext.request.contextPath}/lenguaController/grabarLengua">
													<div class="form-body">
														<div class="col-xs-4">
														<div class="form-group"> 
												<div class="row"  style="display: none;" >
												<f:input type="file" path="lenguaBean.file" name="fileLengua" id="fileLengua" onchange="return validar_file('fileLengua','imgmas4','${pageContext.request.contextPath}/lengua/${lenguaForm.lenguaBean.imagenNombre}','codigoLengua')" accept="image/png, .jpeg, .jpg, image/gif, image/svg+xml"/>
												</div>		 	 
											
											<center><label> Imagen de la lengua<i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label></center>  
										 <div id="list4"   style="cursor: pointer;text-align: center;">
	                                             <c:choose>
	                                              <c:when test="${not empty lenguaForm.lenguaBean.imagenNombre}">
	                                                <label for=""><img id="imgmas4" onclick="abrir_input('fileLengua')" src="${pageContext.request.contextPath}/lengua/${lenguaForm.lenguaBean.imagenNombre}" 
	                                                alt="${lenguaForm.lenguaBean.imagenNombre}"  class="img-fluid thumb" 
	                                                data-toggle="modal" data-target="#xlarge" style="width: 320px; height: 320px; cursor: pointer;"></label>
	                                                <div id="fake-btn-4" style="display:none" class="form-input text-xs-center truncate"></div>
	                                              </c:when>
	                                              <c:otherwise>
	                                                <label for="">   
	                                                <img id="imgmas4" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('fileLengua')" alt="element 01" class="img-fluid thumb " style="width: 320px; height: 320px; cursor: pointer;"></label>
	                                              </c:otherwise>
	                                             </c:choose>
	                                          </div>
											 	
												
												</div>
														</div>
														<div class="col-xs-7">
															<div class="form-group">
																<label for="timesheetinput1">Nombre de la lengua<span
																	class="required">*</span></label>
																<div class="position-relative has-icon-left">
																	<f:input maxlength="50" type="hidden" path="lenguaBean.codigo"
																		id="codigoLengua"  val="0"/>
																	<input id="contextPath" type="hidden"
																		value="${pageContext.request.contextPath}">
																	<div class="controls">
																		<f:input type="text" class="form-control"
																			id="nombreLengua" path="lenguaBean.nombre"
																			data-validation-required-message="Este campo es requerido" />
																	</div>
																	<div class="form-control-position">
																		<i class="ft-user"></i>
																	</div>
																</div>
															</div>
															<input type="hidden" value="${swMensaje}" id="mensaje" />
															<div class="form-group">
																<label for="situacion" >Situaci&oacute;n<span
																	class="required">*</span></label>
																<div class="controls">
																	<f:select id="situacion"
																		path="lenguaBean.situacion.codigoRegistro"
																		data-validation-required-message="Este campo es requerido"
																		class="form-control">
																		<f:option value="" label="Seleccionar" selected="true"
																			disabled="disabled" />
																		<f:options items="${lstSituacion}"
																			itemValue="codigoRegistro" itemLabel="nombreCorto" />
																	</f:select>
																</div>
															</div>
															<div class="form-group">
																<label for="timesheetinput7">Descripci&oacute;n</label>
																<div class="position-relative has-icon-left">
																	<f:textarea  maxlength="150"  id="descripcion" rows="5"
																		class="form-control" path="lenguaBean.descripcion"></f:textarea>
																	<div class="form-control-position">
																		<i class="ft-file"></i>
																	</div>
																</div>
															</div>

															<div class="form-group text-right">
																<a
																	href="${pageContext.request.contextPath}/lenguaController/nuevo"
																	class="btn btn-secondary" title=""> <i
																	class="fa fa-eraser"></i> Nuevo
																</a>
																<button id="btn-save-reg" type="submit"
																	class="btn btn-flat btn-primary">
																	<i class="fa fa-floppy-o"></i> Guardar
																</button>
															</div>
														</div>
													</div>
												</f:form>

											</div>
											<div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
												<f:form id="frmRegistroLenguaNivel"
													onsubmit="return false" class="form-horizontal" 
													role="form" method="post" action="grabarNivel">
													
													<div class="form-body">
														<div class="row">
															<div class="form-group col-md-3 mb-2">
															<div class="form-group">
																<label for="cboNivel">Nivel</label>
																<span class="required">*</span>
																<div class="controls">
																<f:select id="cboNivel"
																	path="lenguaNivelBean.nivel.codigoRegistro"
																	data-validation-required-message="Este campo es requerido"
																	class="form-control">
																	<f:option value="" label="Seleccione" />
																	<f:options items="${lstNivel}"
																		itemValue="nivel.codigoRegistro"
																		itemLabel="nivel.nombreCorto" />
																</f:select> 
																</div>
																</div>
															</div>
															<f:input type="hidden" path="lenguaBean.codigo"
																		id="codigoLenguaNivel" />
															<f:input type="hidden" path="lenguaNivelBean.codigo"
																			id="codigoNivelBean" />
															<div class="form-group col-md-4 mb-2"> 
																<label for="projectinput1">Nombre de nivel</label>   
																  <f:input type="text" class="form-control"
																	id="nombreNivel" maxlength="120" path="lenguaNivelBean.nombreNivel"/>															 
															</div>
														</div>
														<div class="row"> 
															
															<div class="form-group col-md-12 text-right">
															<button id="btn-save-reg" type="button"
																onclick="limpiarNivel()" class="btn btn-secondary">
																<i class="fa fa-eraser"></i> Nuevo
															</button>

															<button id="btn-save-reg" type="submit"
																onclick="grabarNivel()"
																class="btn btn-flat btn-primary">
																<i class="fa fa-floppy-o"></i> Guardar
															</button> 
																<button id="idBtnCargarLengua" type="button"
																	onclick="lenguaCargarModal()"
																	class="btn btn-outline-secondary btn-min-width">
																	<i class="ft-search"></i> Estructura
																</button>
																<!--     <button class="btn btn-flat btn-primary" type="submit">
                                                <i class=" glyphicon glyphicon-search space-icon"></i> Buscar</button>    -->

															</div>
														</div>
														<div class="row">
															<div class="col-xs-12" id="listadoDetalleLengua">
																<table class="table table-striped ">
																	<thead>
																		<tr>
																			<th width="50">N°</th>
																			<th width="140">Nivel</th>
																			<th width="140">Nombre de nivel</th>
																			<th width="140">Sub-niveles</th>
																			<th width="70">Acciones</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="lenguaNivel"
																			items="${lstLenguaNivelBean}" varStatus="loop">
																			<tr> 
																				<td>${loop.count}</td>
																				<td>${lenguaNivel.nivel.nombreCorto}</td>
																				<td>${lenguaNivel.nombreNivel}</td>
																				<td>${lenguaNivel.subNiveles}</td>
																				<td>
																					<button id="idBtnEditarLengua" type="button"
																						onclick="modificarNivel(${lenguaNivel.codigo})"
																						class="btn btn-outline-success btn-sm">
																						<i class="icon-pencil"></i>
																					</button>  
																					<button id="idBtnBuscarLeccion" type="button"
																						onclick="lenguaCargarModalNivel(${lenguaNivel.codigo},${lenguaNivel.nivel.codigoRegistro})"
																						class="btn btn-outline-success btn-sm"
																						title="Asignar Lecci&oacute;n">
																						<i class="icon-plus"></i>Sub-nivel

																					</button>
																				</td>
																			</tr>
																		</c:forEach>

																	</tbody>
																</table>

															</div>
														</div>

													</div>

												</f:form>
											</div>
											<div class="tab-pane" id="tab13" aria-labelledby="base-tab13">
												<f:form id="frmInsertarUnidad" onsubmit="return false"
													class="form-horizontal" role="form" method="post"
													action="grabarUnidad" enctype="multipart/form-data" >
													<div class="form-body">
													
														<div class="row">
															<div class="col-xs-8">
															<div class = "row">
															<div class = "col-xs-6">
													        <div class="form-group" id="select-invalidate-nivel">
																<label for="cmm_nivel">Nivel</label>
																<class="required">*</span></label>
																<div class="controls">
																	<f:select id="cmm_nivel"
																	path="lenguaEstructuraBean.nivel.codigoRegistro"
																	data-validation-required-message="Este campo es requerido"
																	class="form-control" onchange="cargarSubNiveles(0)">
																	<f:option value="0" label="Seleccione" />
																	<f:options items="${lstNivel}"
																		itemValue="nivel.codigoRegistro"
																		itemLabel="nivel.nombreCorto" />
																		</f:select>	
															        </div>	
														        </div>														
															</div>
															<div class = "col-xs-6">
														        <div class="form-group" id="select-invalidate-subnivel">
																	<label for="cmm_sub_nivel">Sub nivel<span
																	class="required">*</span></label>
																	<div class="controls">
																		<f:select id="cmm_sub_nivel"
																		path="lenguaEstructuraBean.codigo"
																		data-validation-required-message="Este campo es requerido"
																		class="form-control" onchange="cargarUnidades()">
																		<f:option value="0" label="Seleccione" />
																		</f:select>
																	</div>
																</div>																
															</div>
															</div> 
																<div class="row">
																	<div class="col-xs-6">
																		<div class="form-group">
																		<label for="timesheetinput1">Nombre de unidad<span
																		class="required">*</span></label>
																		
																		<div class="position-relative has-icon-rigth">
																		<f:input type="hidden" path="unidadBean.codigo"
																		id="codigoUnidadBean" val="0"/>
																		<div class="controls">
																		<f:input type="text" class="form-control"
																		id="nombreUnidad" maxlength="50" path="unidadBean.nombre"
																		data-validation-required-message="Este campo es requerido"
																		 />
																		</div>
																		</div>
																		</div>
																    </div>	
																	<div class="col-xs-6">
														
																		<div class="form-group">
																		<label for="situacion" class="col-sm-4 control-label">Unidad<span
																		class="required">*</span></label>
																		<div class="controls">
																			<f:select id="unidad"
																			path="unidadBean.unidad.codigoRegistro"
																			data-validation-required-message="Este campo es requerido"
																			class="form-control">
																			<f:option value="" label="Seleccionar" selected="true" />
																			<c:forEach var="unidad" items="${lstUnidad}">
			                                                  	<option
			                                                  		<c:if test="${unidad.codigoRegistro==5}">style="display:none;"</c:if>
			                                                  		value="${unidad.codigoRegistro}" >${unidad.nombreCorto}</option>
			                                                  </c:forEach>
																			</f:select>
																		</div>
																		</div>
														
																	</div>														
																	</div>
																		<div class="form-group">
																		<label for="timesheetinput7">Descripci&oacute;n</label>
																		<div class="position-relative has-icon-left">
																		<f:textarea id="descripcionUnidad" rows="4" maxlength="400"
																		class="form-control" path="unidadBean.descripcion"></f:textarea>
																		<div class="form-control-position">
																		<i class="ft-file"></i>
																		</div>
																		</div>
																		</div> 
																</div>
															
															<div class="col-xs-4"  style="display: none;" >
																<label> Imagen unidad*<i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label>
															<input id="nombreImagenUnidad" type="hidden" value=""/>
															
															<f:input type="file" path="unidadBean.file" name="file1v" id="file1v" onchange="return validar_file('file1v','imgmas1v','${pageContext.request.contextPath}/unidad/${nombreImagen}','codigoUnidad')" value="" accept="image/png, .jpeg, .jpg, image/gif" style="display:none" />
															<div id="list1"   style="cursor: pointer; " class="form-group col-md-12"  >
                            								<c:choose>
                                							<c:when test="${not empty unidadBean.nombreImagen}">
	                                    					<label for=""><img id="imgmas1v" onclick="abrir_input('file1v')" src="${pageContext.request.contextPath}/unidad/${nombreImagen}" alt=""  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
	                                    					<div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
                                 							</c:when> 
                            								<c:otherwise>
                                							<label for=""><img id="imgmas1v" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file1v')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
                                  							</c:otherwise>
                              								</c:choose>
                        									</div>	
															</div>
														</div>
														<div class="form-group text-right">
														<button id="btn-save-reg" type="button"
																onclick="limpiarUnidad()"
																class="btn btn-secondary">
																<i class="fa fa-eraser"></i> Nuevo
															</button>
														
															<button id="btn-save-reg" type="submit"
																onclick="grabarUnidad()"
																class="btn btn-flat btn-primary">
																<i class="fa fa-floppy-o"></i> Guardar
															</button>
														</div>
														<div class="row">
															<div class="col-xs-12" id="listadoUnidadesLengua">
																<table
																	class="table table-striped table-bordered zero-configuration">
																	<thead>
																		<tr> 
																		    <th width="20">N°</th>
																			<th width="20">Nivel</th>
																			<th width="30">Sub-nivel</th>
																			<th width="40">Unidad</th>
																			<th width="120">Lecciones</th>
																			<th width="60">Acciones</th>
																		</tr>
																	</thead>
																	<!--  style='display: none' -->
																	<tbody id="bodylstUnidadBean">
																		<c:forEach var="unidadBean" items="${lstUnidadBean}"
																			varStatus="loop" >
																			<tr>
																				<td>${loop.count}</td>
																				<td>${unidadBean.lenguaEstructuraBean.nivel.nombreCorto}</td>
																				<td>${unidadBean.lenguaEstructuraBean.subNivel.nombreCorto}</td>
																				<td>${unidadBean.unidad.nombreCorto}</td>
																				<td>${unidadBean.nombreLecciones} </td>
																				<td>
																					<button id="idBtnBuscarLeccion" type="button"
																						onclick="lenguaCargarModalUnidadLeccion(${unidadBean.codigo})"
																						class="btn btn-outline-success btn-sm" title="Asignar Lecci&oacute;n" >
																						<i class="icon-plus"></i>Lección
																						
																					</button>
																					<button id="idBtnEditarUnidad" type="button"
																						onclick="modificarUnidad(${unidadBean.codigo})"
																						class="btn btn-outline-success btn-sm" title="Editar" >
																						<i class="icon-pencil"></i>
																					</button>
																					 <button type="button" class="btn btn-outline-danger btn-sm" 
																					 data-toggle="tooltip" data-placement="top" title="Eliminar" 
																					 		data-original-title="Eliminar" onclick="confirmar_accion(${unidadBean.codigo},'unidad');">
                                                          							<i class="icon-trash"></i>
                                                          							</button>
																				</td>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>
													</div>
												</f:form>
											</div>
										<div class="tab-pane" id="tab14" aria-labelledby="base-tab14">
										<f:form id="frmInsertarLenguaUnidad"  onsubmit="return false"
										class="form-horizontal" role="form" method="post"
										action="" enctype="multipart/form-data" >
										<div class="row">

											<div class="col-xs-2">	
											<center><label>Imagen*<i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label></center>
											<div class="row"  style="display: none;" >
											<input id="codLenguaUnidad" type="hidden" value="0"/>
											<input id="nombreImagenUnidad" type="hidden" value=""/>
												
												<f:input type="file" path="lenguaUnidadBean.file" name="fileLenguaUnidad" id="fileLenguaUnidad" onchange="return validar_file('fileLenguaUnidad','imagenLenguaUnidad','${pageContext.request.contextPath}/unidad/${lenguaUnidadBean.nombreImagen}','codigoUnidad')"  accept="image/png, .jpeg, .jpg, image/gif"  />
											</div>	
											
											
											
											<div id="list1"   style="cursor: pointer; " class="form-group col-md-12"  >
											<c:choose>
											<c:when test="${not empty lenguaUnidadBean.nombreImagen}">
											<label for=""><img id="imagenLenguaUnidad" onclick="abrir_input('fileLenguaUnidad')" src="${pageContext.request.contextPath}/unidad/${lenguaUnidadBean.nombreImagen}" alt=""  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
											<div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
												</c:when>
											
											<c:otherwise>
											<label for=""><img id="imagenLenguaUnidad" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('fileLenguaUnidad')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
												</c:otherwise>
												</c:choose>
											</div>	 
					
											</div>
											<div class="col-xs-2">	 
											<center><label>Imagen bloqueada*<i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label></center>
												<div class="row"  style="display: none;" >
											<input id="nombreImagenUnidadBloc" type="hidden" value=""/>
											
											<f:input type="file" path="lenguaUnidadBean.fileBloq" name="fileLenguaUnidadBloq" id="fileLenguaUnidadBloq" onchange="return validar_file('fileLenguaUnidadBloq','imagenLenguaUnidadBloq','${pageContext.request.contextPath}/unidad/${nombreImagenBloqueado}','codigoUnidad')"  accept="image/png, .jpeg, .jpg, image/gif" />
												
									
											</div>	
											
											
											<div id="list1"   style="cursor: pointer; " class="form-group col-md-12"  >
											<c:choose>
											<c:when test="${not empty lenguaUnidadBean.nombreImagenBloqueado}">
											<label for=""><img id="imagenLenguaUnidadBloq" onclick="abrir_input('fileLenguaUnidadBloq')" src="${pageContext.request.contextPath}/unidad/${nombreImagenBloqueado}" alt=""  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
											<div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
												</c:when>
											
											<c:otherwise>
											<label for=""><img id="imagenLenguaUnidadBloq" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('fileLenguaUnidadBloq')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
												</c:otherwise>
												</c:choose>
											</div>											
											
											
					
											</div>											
											
											<div class="col-xs-4">
											<div class="form-group">
											<label for="situacion" >Unidad<span
											class="required">*</span></label>
											<div class="controls">
											<f:select id="lenguaUnidad"
											path=""
											data-validation-required-message="Este campo es requerido"
											class="form-control">
											<f:option value="0" label="Seleccionar" selected="true" />
											<f:options items="${lstUnidad}"
											itemValue="codigoRegistro" 
											itemLabel="nombreCorto" />
											</f:select>
											</div>
											</div>											

											<label for="timesheetinput1">Nombre de unidad<span
											class="required">*</span></label>
											<div class="position-relative has-icon-rigth">
											<div class="controls">
											<f:input type="text" class="form-control"
											id="nombreLenguaUnidad" path="" maxlength="50"
											data-validation-required-message="Este campo es requerido" />
											</div>
											</div>	
											<br>
											<div class="form-group text-right">
											
											<button id="btnNuevoLenguaUnidad" type="button"
													onclick="nuevoLenguaUnidad()"
													class="btn btn-secondary">
													<i class="fa fa-eraser"></i> Nuevo
												</button>
											
												<button id="btnGrabarLenguaUnidad" type="submit"
													onclick="grabarLenguaUnidad();" 
													class="btn btn-flat btn-primary">
													<i class="fa fa-floppy-o"></i> Guardar
												</button>
											</div>
															
											</div>
											<div class = "col-xs-4">
											<div class="table-responsive">
										        <table class="table table-bordered table-striped">
										                       
												<thead>
										            <tr>
										                <th width="30">N°</th>
										                <th>Unidad</th>									                
										                <th width="107">Acciones</th>
										            </tr>
										         </thead>
										                <tbody id="idBodyLenguaUnidad">
										                </tbody>
										         </table>
										    </div>												
											
											</div>			
										</div>	
										</f:form>
																					
										</div>
										
										<div class="tab-pane" id="tab15" aria-labelledby="base-tab15">
										<f:form id="frmInsertarLenguaLeccion" onsubmit="return false" class="form-horizontal" role="form" method="post" action = "grabarLenguaLeccion" >
										<div class="row">

											<div class="col-xs-2">																					
											
											<center><label>Imagen*<i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label></center>
											
											<input id="codLenguaLeccion" type="hidden" value="0"/>
											<input id="nombreImagenLeccion" type="hidden" value=""/>
											
											<f:input type="file" path="lenLeccionBean.file" name="fileLenguaLeccion" id="fileLenguaLeccion" onchange="return validar_file('fileLenguaLeccion','imagenLenguaLeccion','${pageContext.request.contextPath}/leccion/${nombreImagen}','codigoLeccion')" accept="image/png, .jpeg, .jpg, image/gif" style="display:none" />
											<div id="list1"   style="cursor: pointer; " class="form-group col-md-12"  >
											<c:choose>
												<c:when test="${not empty nombreImagen}">
													<label for=""><img id="imagenLenguaLeccion" onclick="abrir_input('fileLenguaLeccion')" src="${pageContext.request.contextPath}/leccion/${nombreImagen}" 
													alt=""  class="img-fluid thumb-mini" 
													data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
													<div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
												</c:when>
											
												<c:otherwise>
													<label for=""><img id="imagenLenguaLeccion" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('fileLenguaLeccion')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
												</c:otherwise>
											</c:choose>
											
											
											</div>																																						
											</div>
											
											<div class="col-xs-2">																					
											
											<center><label>Imagen bloqueada*<i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label></center>
																					
											<input id="nombreImagenLeccionBloq" type="hidden" value=""/>
											
											<f:input type="file" path="lenLeccionBean.fileBloq" name="fileLenguaLeccionBloq" id="fileLenguaLeccionBloq" onchange="return validar_file('fileLenguaLeccionBloq','imagenLenguaLeccionBloq','${pageContext.request.contextPath}/leccion/${fileLenguaLeccion.nombreImagenBloq}','codigoLeccion')" value="" accept="image/png, .jpeg, .jpg, image/gif" style="display:none" />
											<div id="list2"   style="cursor: pointer; " class="form-group col-md-12"  >
											<c:choose>
												<c:when test="${not empty lenLeccionBean.nombreImagenBloq}">
													<label for=""><img id="imagenLenguaLeccionBloq" onclick="abrir_input('fileLenguaLeccionBloq')" src="${pageContext.request.contextPath}/leccion/${fileLenguaLeccion.nombreImagenBloq}" alt=""  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
													<div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
												</c:when>
											
													<c:otherwise>
														<label for=""><img id="imagenLenguaLeccionBloq" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('fileLenguaLeccionBloq')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
													</c:otherwise>
											</c:choose>
											</div>																																						
											</div>											
											
											<div class="col-xs-4">	
											<div class="form-group">
											<label for="situacion">Lección<span
											class="required">*</span></label>
											<div class="controls">
											<f:select id="lenguaLeccion"
											path=""
											data-validation-required-message="Este campo es requerido"
											class="form-control">
											<f:option value="0" label="Seleccionar" selected="true" />
											<f:options items="${lstLecciones}"
											itemValue="codigoRegistro" 
											itemLabel="nombreCorto" />
											</f:select>
											</div>
											</div>												
											
											
											<label for="timesheetinput1">Nombre de lección<span
											class="required">*</span></label>
											<div class="position-relative has-icon-rigth">
											<div class="controls">
											<f:input type="text" class="form-control"
											id="nombreLenguaLeccion" path="" maxlength="50"
											data-validation-required-message="Este campo es requerido" />
											</div>
											</div>	
											<br>
											<div class="form-group text-right">
											
											<button id="btnNuevoLenguaUnidad" type="button"
													onclick="nuevoLenguaLeccion();"
													class="btn btn-secondary">
													<i class="fa fa-eraser"></i> Nuevo
												</button>
											
												<button id="btnGrabarLenguaUnidad" type="submit"
													onclick="grabarLenguaLeccion();"
													class="btn btn-flat btn-primary">
													<i class="fa fa-floppy-o"></i> Guardar
												</button>
											</div>																			
															
											</div>
											<div class = "col-xs-4">
											<div class="table-responsive">
										        <table class="table table-bordered table-striped">
										                       
												<thead>
										            <tr>
										                <th width="30">N°</th>
										                <th>Lección</th>										                
										                <th width="107">Acciones</th>
										            </tr>
										         </thead>
										                <tbody id="idBodyLenguaLeccion">
										                </tbody>
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
			</div>
			</section>
		</div>
	</div>
	</div>
	<!-- ////////////////////////////////////////////////////////////////////////////-->


	<jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
	<!-- Modal -->
	<div id="modalLengua"></div>
	<div class="modal fade text-xs-left" id="modalLenguaEstructura"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalLenguaEstructuraContent"></div>
		</div>
	</div>

	<div class="modal fade text-xs-left" id="modalLenguaEstructuraUnidad"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalLenguaEstructuraUnidadContent"></div>
		</div>
	</div>

	<jsp:include
		page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
	 
	<!-- BEGIN VENDOR JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js"
		type="text/javascript"></script>
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js"
		type="text/javascript"></script>
	<!-- <script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js"
		type="text/javascript"></script> -->
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN STACK JS-->

	<script
		src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/core/app.js"
		type="text/javascript"></script>
	<!-- END STACK JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL JS-->
	<script
		src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/select/form-select2.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/ui/scrollable.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
		type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/general/lengua/lengua-script.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/validation.js"
		type="text/javascript" charset="utf-8"></script>
		
	<script>
	
	
	
		$(document).ready(function() {

			var msj = $("#mensaje").val();
			var lengua = $("#nombreLengua").val();//1
			if (msj == '1') {
				msg_exito();
			} else if (msj == '0') {
				msg_error();
			}else if (msj == '3') {
				msg_advertencia("La lengua "+lengua+" ya fue registrada.");
			}else if (msj == '2') {
				msg_advertencia("Formato imagen incorrecto.");
			}
		});

		var accion_tab = "";
		function consultaEliminarLenguaEstructura(idButton, codigoSede) {
			accion_tab = idButton;
			codSede = codigoSede;
			$('#md_confirmacion').modal('show');
		}

		var path = null;
		$(document).ready(function() {
			path = document.getElementById("contextPath").value;

		}); 
	</script>

</body>
</html>