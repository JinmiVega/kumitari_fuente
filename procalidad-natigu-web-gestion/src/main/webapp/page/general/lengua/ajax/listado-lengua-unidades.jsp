<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">

<table id="tblUnidad" class="table table-striped table-bordered zero-configuration">
	<thead>
		<tr>
			<th width="20">N°</th>
			<th width="20">Nivel</th>
			<th width="30">Sub-Nivel</th>
			<th width="40">Unidad</th>
			<th width="120">Lecciones</th>
			<th width="60">Acciones</th>
		</tr>
	</thead>
	<!--  style='display: none' -->
	<tbody>
		<c:forEach var="unidadBean" items="${lstUnidadBean}" varStatus="loop">
			<tr>
				<td>${loop.count}</td>
				<td>${unidadBean.lenguaEstructuraBean.nivel.nombreCorto}</td>
				<td>${unidadBean.lenguaEstructuraBean.subNivel.nombreCorto}</td>
				<td>${unidadBean.unidad.nombreCorto}</td>
				<td>${unidadBean.nombreLecciones}</td>
				<td>
					<button id="idBtnBuscarLeccion" type="button"
						onclick="lenguaCargarModalUnidadLeccion(${unidadBean.codigo})"
						class="btn btn-outline-success btn-sm"
						title="Asignar Lecci&oacute;n">
						<i class="icon-plus"></i>Lección

					</button>
					<button id="idBtnEditarUnidad" type="button"
						onclick="modificarUnidad(${unidadBean.codigo})"
						class="btn btn-outline-success btn-sm" title="Editar">
						<i class="icon-pencil"></i>
					</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						data-toggle="tooltip" data-placement="top" title="Eliminar"
						data-original-title="Eliminar"
						onclick="confirmar_accion(${unidadBean.codigo},'unidad');">
						<i class="icon-trash"></i>
					</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js"
		type="text/javascript"></script>
