<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<script type="text/javascript">
	$( document ).ready(function() {
		$("#tblSede").DataTable();
	});
</script>

<table id="tblSede" class="table table-striped table-bordered zero-configuration">
																		<thead>
																			<tr>
																			<th>Nº</th>	
																			<th width="150">Nombre</th>
																			<th width="150">Ubicaci&oacute;n</th>
																			<th>Datos</th>
																			<th width="120">Acciones</th>
																			</tr>
																		</thead>
                                                          <tbody id="idBodyListaInstSede">
													<c:forEach var="institucionSedeBean" items="${lstInstitucionSede}"  varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${institucionSedeBean.nombreSede}</td>
															<td><i class="ft-map-pin media-left media-middle"></i>
																<div class="media-body">
																	${institucionSedeBean.ubigeoRegionBean.nombreUbigeo} /
																	${institucionSedeBean.ubigeoProvinBean.nombreUbigeo} /
																	${institucionSedeBean.ubigeoDistriBean.nombreUbigeo} <br>
																	${institucionSedeBean.direccionInstitucion}
																</div></td>
															<td>
																<div class="mb-0">
																	<i class="ft-map-pin media-left media-middle"></i>
																	<div class="media-body">${institucionSedeBean.telefono}</div>
																</div>
																<div class="mb-0">
																	<i class="icon-envelope media-left media-middle"></i>
																	<div class="media-body">${institucionSedeBean.correo}</div>
																</div>
																<div class="mb-0">
																	<i class="ft-info media-left media-middle"></i>
																	<div class="media-body">${institucionSedeBean.contacto}</div>
																</div>
															</td>
															<td>
																<button type="button" class="btn btn-outline-success btn-sm "
																	data-toggle="tooltip" onclick="modificarInstitucionSede(${institucionSedeBean.codigo})"
																	data-original-title="Editar">
																	<i class="icon-pencil"></i>
																</button>
																<button type="button" class="btn btn-outline-danger btn-sm "
																	data-toggle="tooltip" data-placement="top" title="" onclick="confirmar_eliminar('sede',${institucionSedeBean.codigo});"
																	data-original-title="Eliminar" >
																	<i class="icon-trash"></i>
																</button>
																<%-- onclick="eliminarInstitucionSede(${institucionSedeBean.codigo});"--%>
															</td>
														</tr>
													</c:forEach>
                                                      </tbody>
                                                                                                            <tfoot>
														<tr>
														<th>Nº</th>	
														<th width="150">Nombre</th>
														<th width="150">Ubicaci&oacute;n</th>
														<th>Datos</th>
														<th width="120">Acciones</th>
													    </tr>                                                     
                                                      </tfoot>
</table>