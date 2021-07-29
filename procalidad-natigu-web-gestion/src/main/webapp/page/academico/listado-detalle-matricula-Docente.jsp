<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
							<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 								 <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                             <th width="15">N°</th>
                                                              <th>Nombre del docente</th>
                                                              <th>Fecha</th>
                                                              <th>Tipo</th>
                                                              <th width="20">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                          <c:forEach var="matriculaDocenteBean" items="${lstMatriculaDocenteBean}" varStatus="theCount">
									                      <tr>
									                      	  <td>${theCount.count}</td>
									                          <td>${matriculaDocenteBean.docenteBean.personaBean.nombrePersona} ${matriculaDocenteBean.docenteBean.personaBean.apellidoPaterno} ${matriculaDocenteBean.docenteBean.personaBean.apellidoMaterno}</td>
									                          <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${matriculaDocenteBean.fechaCreacion}"/></td>
									                          <td>${matriculaDocenteBean.tipoDocente.nombreCorto}</td>
									                          <td>
									                           <!--  <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
									                          <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacionDocente('${matriculaDocenteBean.codigo}')"><i class="icon-trash"></i></a>
									                          </td>
									                      </tr>
									                      </c:forEach>
                                                      </tbody>
                                                      <tfoot>
                                                          <tr>
                                                             <th width="15">N°</th>
                                                              <th>Nombre del docente</th>
                                                              <th>Fecha</th>
                                                              <th>Tipo</th>
                                                              <th width="20">Acci&oacute;n</th>
                                                          </tr>
                                                      </tfoot>
                                                  </table>