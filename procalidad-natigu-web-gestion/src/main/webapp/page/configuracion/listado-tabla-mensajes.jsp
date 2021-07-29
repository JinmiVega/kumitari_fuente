<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
                                            <table class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                    	<th  width="50">Item</th>
                                                        <th>Mensaje</th>
														<th>Lengua</th>														
                                                        <th>Tipo mensaje</th>	
                                                         <th width="60">Acci&oacute;n</th>
                                                   
                                                       
                                                    </tr>
                                                </thead>
                                                <tbody>
											<c:forEach var="mensaje"
											items="${lstMensajesBean}" varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${mensaje.mensajes}</td>
												<td>${mensaje.lenguaBean.nombre}</td>
												<td>${mensaje.tipoMensaje.nombreCorto}</td>
												

												<td><a title="Modificar" data-placement="top"
													data-toggle="tooltip"
													class="btn btn-outline-success btn-sm"
													href="modificar?codigo=${mensaje.codigo}"><i
														class="icon-pencil"></i></a> <!--  <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${institucionBean.codigo}"><i class="icon-trash"></i></a> -->
													<button type="button"
														class="btn btn-outline-danger btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														onclick="confirmar_eliminar(${mensaje.codigo})"
														data-original-title="Eliminar">
														<%--id="eliminarLengua${loop.index}" --%>
														<i class="icon-trash"></i>
													</button></td>

											</tr>
										</c:forEach>                                               
										 </tbody>
										<tfoot>
											<tr>
												
                                        <th  width="50">Item</th>
                                        <th>Mensaje</th>
										<th>Lengua</th>														
                                        <th>Tipo mensaje</th>	
                                        <th width="60">Acci&oacute;n</th>
											</tr>
										</tfoot>
                                                   
                                            </table>

<script
	src="../app-assets/js/scripts/tables/datatables/datatable-basic.js"
	type="text/javascript"></script>
