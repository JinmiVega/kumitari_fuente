<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<table id="tblListaAlumno" class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                    	<th>N°</th>
                                                        <th>Nombre de estudiante</th>
                                                        <th>Nombre de instituci&oacute;n</th>
                                                        <th>N&uacute;mero de documento</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="60">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="alumnoBean" items="${lstAlumnoBean}" varStatus="theCount">
                                                  <tr>
                                                  	 <td>${theCount.count}</td>
                                                   <td>${alumnoBean.personaBean.nombrePersona} ${alumnoBean.personaBean.apellidoPaterno} ${alumnoBean.personaBean.apellidoMaterno}</td>
                                                    <td>${alumnoBean.institucionBean.nombreInstitucion}</td>
                                                    <td>${alumnoBean.personaBean.numeroDocumento}</td>
                                                    <td>${alumnoBean.tm1Situacion.nombreCorto}</td>
                                                    <td>
                                                    <!--
                                                      <button type="button" class="btn btn-outline-success btn-sm "
                                                      data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    -->
                                                     <a title="Modificar" 
                                                         	data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm"
                                                         	onclick="javascript:modificarElementoGenerico('/alumnoController/modificar','${alumnoBean.codigo}')"
                                                         	><i class="icon-pencil"></i></a>
                                                    <!-- 
                                                         <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" href="modificar?codigo=${alumnoBean.codigo}"><i class="icon-pencil"></i></a>
                                                      -->
                                                     <!--  <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${alumnoBean.codigo}"><i class="icon-trash"></i></a> -->
													<button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="Eliminar" data-original-title="Eliminar" onclick="confirmar_accion('${alumnoBean.codigo}');"><i class="icon-trash"></i></button>
                                                    </td>
                                                   </tr>
                                                 </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                    	<th>N°</th>
                                                        <th>Nombre de estudiante</th>
                                                        <th>Instituci&oacute;n</th>
                                                        <th>N&uacute;mero de documento</th>
                                                        <th>Situaci&oacute;n</th>
                                                        <th>Acciones</th>
                                                    </tr>
                                                </tfoot>

                                            </table>
                                            
                                            
                                            
     <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>