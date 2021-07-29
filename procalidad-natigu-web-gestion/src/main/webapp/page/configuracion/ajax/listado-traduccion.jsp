<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">

<table class="table table-striped table-bordered zero-configuration" id="tablaTraduccion">
                                                <thead>
                                                    <tr>
                                                    	<th  width="50">Item</th>
                                                        <th width="100">Etiqueta</th>
                                                        <th width="60">Tipo Etiqueta</th>	
														<th width="100">Lengua</th>	
                                                         <th width="60">Traducci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
											<c:forEach var="traduccion" items="${lstTraduccionBean}" varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${traduccion.etiqueta.descripcion}</td>
												<td>${traduccion.etiqueta.tipoEtiqueta.nombreCorto}</td>
												<td>${traduccion.lengua.nombre}</td>
												

												<td>
													<input type="hidden"  value="${traduccion.etiqueta.codigoEtiqueta}" id="item_${loop.count}" />
													<input type="text"  value="${traduccion.traduccion}" id="traduccion_${loop.count}" />

												</td>

											</tr>
										</c:forEach>                                               
										 </tbody>
										<tfoot>
											<tr>
												
                                        <th  width="50">Item</th>
                                        <th>Glosario</th>
										<th>Lengua</th>			
                                        <th width="60">Acci&oacute;n</th>
											</tr>
										</tfoot>
                                                   
									</table>

<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js"
		type="text/javascript"></script>
