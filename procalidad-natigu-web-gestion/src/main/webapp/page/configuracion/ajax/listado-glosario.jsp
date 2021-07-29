<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">

<table class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                    	<th  width="50">Item</th>
                                                        <th>Lengua</th>
                                                        <th>Archivo</th>
														<th>Peso</th>			
                                                         <th width="60">Acci&oacute;n</th>
                                                   
                                                       
                                                    </tr>
                                                </thead>
                                                <tbody>
											<c:forEach var="glosario"
											items="${lstGlosarioBean}" varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${glosario.lenguaBean.nombre}</td>
												<td>${glosario.fileName}</td>
												<td>${glosario.peso}</td>
												
												

												<td>
													<button type="button" class="btn btn-outline-success btn-sm "
	                                                          data-toggle="tooltip"   data-original-title="Editar" onclick="modificarGlosario(${glosario.codigoGlosario},'${pageContext.request.contextPath}/glosarioController');"><i class="icon-pencil"></i></button>

	                                                
													<button type="button"
														class="btn btn-outline-danger btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														onclick="confirmar_eliminar(${glosario.codigoGlosario})"
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
                                        <th>Glosario</th>
										<th>Lengua</th>			
                                        <th width="60">Acci&oacute;n</th>
											</tr>
										</tfoot>
                                                   
                                            </table>

<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js"
		type="text/javascript"></script>
