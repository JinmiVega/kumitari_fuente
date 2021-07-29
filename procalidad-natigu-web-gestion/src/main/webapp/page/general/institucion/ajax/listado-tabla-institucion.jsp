<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<table
	class="table table-striped table-hover table-bordered zero-configuration">
	<thead>
		<tr>
			<th width="50">Nº</th>
			<th>Nombre de instituci&oacute;n</th>
			<th>Regi&oacute;n</th>
			<th>Tipo de instituci&oacute;n</th>
			<th width="70">Situaci&oacute;n</th>
			<th width="60">Acciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="institucionBean" items="${lstInstitucionBean}"
			varStatus="loop">
			<tr>
				<td>${loop.count}</td>
				<td>${institucionBean.nombreInstitucion}</td>
				<td>${institucionBean.ubigeoBean.nombreUbigeo}</td>
				<td>${institucionBean.tipoInstitucion.nombreCorto}</td>
				<td>${institucionBean.situacion.nombreCorto}</td>

				<td><a title="Modificar" data-placement="top"
					data-toggle="tooltip" class="btn btn-outline-success btn-sm"
					href="modificar?codigo=${institucionBean.codigo}"><i
						class="icon-pencil"></i></a> <!--  <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${institucionBean.codigo}"><i class="icon-trash"></i></a> -->
					<button type="button"
						class="btn btn-outline-danger btn-sm eliminarLengua"
						data-toggle="tooltip" data-placement="top" title=""
						onclick="confirmar_accion(${institucionBean.codigo})"
						data-original-title="Eliminar" id="eliminarLengua${loop.index}">
						<i class="icon-trash"></i>
					</button></td>

			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th width="50">Nº</th>
			<th>Nombre de instituci&oacute;n</th>
			<th>Regi&oacute;n</th>
			<th>Tipo de instituci&oacute;n</th>
			<th width="70">Situaci&oacute;n</th>
			<th width="60">Acciones</th>
		</tr>
	</tfoot>
</table>

<script
	src="../app-assets/js/scripts/tables/datatables/datatable-basic.js"
	type="text/javascript"></script>
