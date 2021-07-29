<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 								 <table class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                             <th width="15">N°</th>
                                                              <th width="300">Nombre del alumno</th>
                                                              <th width="60">N° de doc.</th>
                                                              <th width="60">Fecha</th>
                                                              <th width="60">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                       <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
                                                      <tbody>
                                                          <c:forEach var="matriculaAlumno" items="${lstmatriculaAlumno}" varStatus="theCount">
									                      <tr>
									                      	  <td>${theCount.count}</td>
									                          <td>${matriculaAlumno.alumnoBean.personaBean.nombrePersona} ${matriculaAlumno.alumnoBean.personaBean.apellidoPaterno} ${matriculaAlumno.alumnoBean.personaBean.apellidoMaterno}</td>
									                          <td>${matriculaAlumno.alumnoBean.personaBean.numeroDocumento}</td>
									                          <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${matriculaAlumno.fechaCreacion}"/></td>
									                          <td>
									                            <!-- <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
									                          <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${matriculaAlumno.codigo}')"><i class="icon-trash"></i></a>
									                          </td>
									                      </tr>
									                      </c:forEach>
                                                      </tbody>
                                                      <tfoot>
                                                          <tr>
                                                             <th width="15">N°</th>
                                                              <th width="300">Nombre del alumno</th>
                                                              <th width="60">N° de doc.</th>
                                                              <th width="60">Fecha</th>
                                                              <th width="60">Acci&oacute;n</th>
                                                          </tr>
                                                      </tfoot>
                                                  </table>