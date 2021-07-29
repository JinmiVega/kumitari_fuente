<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
   <table class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                          <th width="40">N°</th>
                                                        <th>Nombre de la lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="80">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="lenguaBean" items="${lstLenguaBean}"  varStatus="loop">
                                                    <tr>
														<td>${loop.count}</td>
                                                        <td>
                                                          <div class="media">
                                                            <a class="media-left media-middle" href="#">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="Generic placeholder image" style="width: 64px;height: 64px;" />
                                                            </a>
                                                            <div class="media-body media-middle">
                                                              <h5 class="media-heading">${lenguaBean.nombre}</h5>
                                                            </div>
                                                          </div>
                                                        </td>
                                                        <td>${lenguaBean.situacion.nombreCorto}</td>
                                                         <td>
                                                         <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" href="modificar?codigo=${lenguaBean.codigo}"><i class="icon-pencil"></i></a>
                                                       <!--   <a title="Eliminar" data-placement="top" data-toggle="tooltip" 
                                                         class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${lenguaBean.codigo}"><i class="icon-trash"></i></a> -->
                                                        
                                                        <button type="button" class="btn btn-outline-danger btn-sm eliminarLengua"
															data-toggle="tooltip" data-placement="top" title="" onclick="confirmar_accion(${lenguaBean.codigo})"
															data-original-title="Eliminar" id="eliminarLengua${loop.index}" >
															<i class="icon-trash"></i>
														</button> 
 														 </td>
                                                    </tr>
                                                 </c:forEach>

                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                         <th width="40">N°</th>
                                                        <th>Nombre de la lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="80">Acciones</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                            
                                            
                                            
     <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>