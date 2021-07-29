<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<!-- Modal -->

<div class="modal-header">
	<button type="button" id="btnCerrarSubNivel" class="close" data-dismiss="modal"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Registro
			de sub-nivel</b></label>
</div>
<div class="modal-body">

	<f:form id="frmInsertarSubNivel" class="form-horizontal" role="form"
		enctype="multipart/form-data" method="post" onsubmit="return false"
		action="grabarEstructura">
		<input id="contextPath" type="hidden"
			value="${pageContext.request.contextPath}">

		<div class="form-body">
			<div class="row">
				<div class="col-xs-5">
					<div class="form-group">
						<label for="cboLenguasubNivel">Sub-nivel<span class="required">*</span></label>
						<div class="controls">
							<f:select id="cboLenguasubNivel" path="subNivel.codigoRegistro"
								data-validation-required-message="Este campo es requerido"
								class="form-control">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstSubNivel}" itemValue="codigoRegistro"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
				</div>
				<div class="col-xs-4">
					<label> Imagen <i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label> <input id="nombreImagenUnidad"
						type="hidden" value="" />

					<f:input type="file" path="fileImagen" name="fileSubNivel"
						id="fileSubNivel"
						onchange="return validar_file('fileSubNivel','imgNivel','${pageContext.request.contextPath}/subNivel/${nombreImagen}','codigoUnidad')"
						value="" accept="image/png, .jpeg, .jpg, image/gif"
						alt="${nombreImagen}"
						style="display:none" />
					<div id="list1" style="cursor: pointer;"
						class="form-group col-md-12"> 
						
						<c:choose>
							<c:when test= "${not empty nombreImagen}">
							<!--  -->
								<label for="">
								<img id="imgNivel"
									onclick="abrir_input('fileSubNivel')"
									src="${pageContext.request.contextPath}/subNivel/${nombreImagen}"
									alt="imagen sub-nivel" class="img-fluid thumb-mini" data-toggle="modal"
									data-target="#xlarge" style="cursor: pointer;"></label>
								<div id="fake-btn-1" style="width: 320px; height: 320px; display: none"
									class="form-input text-xs-center truncate"></div>
							</c:when>

							<c:otherwise>
								<label for=""><img id="imgNivel"
									src="../assets/img/usar_imagen.jpg"
									onclick="abrir_input('fileSubNivel')" alt="imagen sub-nivel"
									class="img-fluid thumb-mini" style="cursor: pointer;"></label>
							</c:otherwise>
						</c:choose>
					</div>


				</div>
			</div>
			<f:input type="hidden" path="lenguaNivelBean.codigo" id="codigoNivelBean" />
			<f:input type="hidden" path="nivel.codigoRegistro" id="codigoNivel" />
			<f:input type="hidden" path="lenguaBean.codigo" id="codigoLengua" />
			<f:input type="hidden" path="codigo" id="codigoEstructura" />
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">


		</div>


<div class="modal-footer">

	<button type="button" class="btn btn-outline-secondary"
		data-dismiss="modal">Salir</button>
	<button type="submit" onclick="grabarEstructura()"
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
					<th>Nivel</th>
					<th>Sub-nivel</th>
					<th width="110">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lenguaEstructuraBean" items="${lstLenguaEstructuraBean}"
					varStatus="loop">
					<tr>
						<td>${loop.count}</td>
						<td>${lenguaEstructuraBean.nivel.nombreCorto}</td>
						<td>${lenguaEstructuraBean.subNivel.nombreCorto}</td>
						<td>
							<button type="button"
								class="btn btn-outline-danger btn-sm eliminarLengua"
								data-toggle="tooltip" data-placement="top" title=""
								onclick="confirmar_accion(${lenguaEstructuraBean.codigo},'lenguaEstructura')"
								data-original-title="Eliminar">
								<i class="icon-trash"></i>
							</button>
							<button id="idBtnEditarUnidad" type="button"
								onclick="modificarLenguaEstructura(${lenguaEstructuraBean.codigo})"
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
 
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
	type="text/javascript"></script>


