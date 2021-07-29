<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:forEach var="lenguaNivel" items="${lstLenguaNivelBean}"
			varStatus="loop">
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
						<i class="icon-plus"></i>Sub-Nivel

					</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>