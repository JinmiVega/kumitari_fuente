<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<!-- Modal -->

<div class="modal-header">
	<button type="button" id="btnCerrar" class="close" data-dismiss="modal"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Registro
			de unidades y lecciones</b></label>
</div>
<div class="modal-body">

	<f:form id="frmInsertarLeccion" class="form-horizontal" role="form"
		 method="post" onsubmit="return false"
		action="grabarLeccion">
		<input id="contextPath" type="hidden"
			value="${pageContext.request.contextPath}">

		<div class="form-body">
			<div class="row">
				<div class="col-xs-5">
					<div class="form-group">
						<label for="situacion" class="col-sm-4 control-label">Situación<span
							class="required">*</span></label>
						<div class="controls">
							<f:select id="situacionLeccion" path="situacion.codigoRegistro"
								data-validation-required-message="Este campo es requerido"
								class="form-control">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstSituacionLeccion}"
									itemValue="codigoRegistro" itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
			</div>
				<div class="col-xs-5"> 
				   <div class="form-group">
					<label for="cmm_leccion">Lecci&oacute;n<span
							class="required">*</span></label>
					<div class="controls">		
					<f:select id="cmm_leccion" path="leccion.codigoRegistro" 
						data-validation-required-message="Este campo es requerido"
						class="form-control">
						<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled"/>
						<f:options items="${lstLeccion}" itemValue="codigoRegistro"
							itemLabel="nombreCorto" />
					</f:select>
					</div>
				   </div>
				 </div>
				 </div>
				 <div class="row">  
				 <div class="col-xs-10">
					<div class="form-group">
						<label for="timesheetinput1">Nombre de lecci&oacute;n<span
							class="required">*</span></label>
						<div class="position-relative has-icon-left">
							<div class="controls">
								<f:input type="text" class="form-control" id="nombreLeccion"
									path="nombre" maxlength="150"
									data-validation-required-message="Este campo es requerido" />
							</div>
							<div class="form-control-position">
								<i class="ft-user"></i>
							</div>
						</div>
					</div>				   
				</div>
				</div>
						

				<f:input type="hidden" path="unidadBean.codigo" id="codigoUnidad" />
				<f:input type="hidden" path="codigo" id="codigoLeccion" />
				<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}">


			
			
			<div class="col-xs-5" style="display: none;">
				<label> Imagen Lecci&oacute;n* <i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label>
																
																
				<input id="nombreImagenLeccion" type="hidden" value=""/>
															
				<f:input type="file" path="" name="file2v" id="file2v" onchange="return validar_file('file2v','imgmas2v','${pageContext.request.contextPath}/leccion/${unidadBean.nombreImagen}','codigoUnidad')" value="" 
				accept="image/png, .jpeg, .jpg, image/gif" style="display:none" />
				<div id="list1"   style="cursor: pointer; " class="form-group col-md-12"  >
                <c:choose>
                <c:when test="${not empty relacion.imagen}">
	            <label for=""><img id="imgmas2v" onclick="abrir_input('file2v')" src="${pageContext.request.contextPath}/leccion/${unidadBean.nombreImagen}" alt=""  
	            class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
	            <div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
                </c:when>
                                             	 
                <c:otherwise>
                <label for=""><img id="imgmas2v" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file2v')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
                </c:otherwise>
                </c:choose>
                </div>
				
				</div>		
	<!-- 		<div class="row">
				<div class="col-xs-7">
					<div class="form-group">
						<label for="timesheetinput1">Nombre Lecci&oacute;n<span
							class="required">*</span></label>
						<div class="position-relative has-icon-left">
							<div class="controls">
								<f:input type="text" class="form-control" id="nombreLeccion"
									path="nombre"
									data-validation-required-message="Este campo es requerido" />
							</div>
							<div class="form-control-position">
								<i class="ft-user"></i>
							</div>
						</div>
					</div>
				</div>
			</div> -->


		</div>

		<div class="modal-footer">

			<button type="button" class="btn btn-outline-secondary"
				data-dismiss="modal">Salir</button>
				<button id="btn-save-reg" type="button"
					onclick="limpiarLeccion()"
					class="btn btn-secondary">
					<i class="fa fa-eraser"></i> Nuevo
				</button>
			<button type="submit" onclick="grabarLeccion()"
				
				class="btn btn-primary">
				<i class="fa fa-floppy-o"></i> Guardar
			</button>

			<h4 id="result"></h4>
		</div>
		<div class="row">
			<div class="col-xs-12" id="listadoUnidadesLengua">
				<table class="table table-striped table-bordered zero-configuration">
					<thead>
						<tr>
							<!--  <th>Nombre Lengua</th> -->
							<th>N°</th>
							<th>Unidad</th>
							<th>Nombre de lección</th>
							<th width="110">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="leccionBean" items="${lstUnidadLeccionBean}"
							varStatus="loop">
							<tr>
								<td>${loop.count}</td>
								<td>${leccionBean.unidadBean.unidad.nombreCorto}</td>
								<td>${leccionBean.nombre}</td>
								<td>
									<button type="button"
										class="btn btn-outline-danger btn-sm eliminarLengua"
										data-toggle="tooltip" data-placement="top" title=""
										onclick="confirmar_accion(${leccionBean.codigo},'leccion')"
										data-original-title="Eliminar">
										<i class="icon-trash"></i>
									</button>
									<button id="idBtnEditarUnidad" type="button"
										onclick="modificarLeccion(${leccionBean.codigo})"
										class="btn btn-outline-success btn-sm">
										<i class="icon-pencil"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</f:form>
</div>
<script
	src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js"
	type="text/javascript"></script>
<!-- <script
	src="${pageContext.request.contextPath}/app-assets/js/jquery.form.js"
	type="text/javascript"></script> -->
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
	type="text/javascript"></script>

