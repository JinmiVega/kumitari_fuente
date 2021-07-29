<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
							
 								<table class="table table-striped table-bordered zero-configuration">
								                  <thead>
								                      <tr>
								                      	   <th>N°</th>
								                          <th>Lengua</th>
								                          <th>Nivel</th>
								                          <th width="250">N° de cupos</th>
								                          <th width="150">Acciones</th>
								                      </tr>
								                  </thead>
								                  <tbody>
								                  <c:forEach var="inscripcionLenguaBean" items="${lstInscripcionLenguaBean}" varStatus="theCount">
								                      <tr>
								                      	  <td>${theCount.count}</td>
								                          <td>${inscripcionLenguaBean.lenguainscr.nombre}</td>
								                          <td>${inscripcionLenguaBean.nivel.nombreCorto}</td>
								                          <td>${inscripcionLenguaBean.numeroCuposInsc}</td>
								                          
								                            <td>
                                                           <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" onclick="modificarLengua(${inscripcionLenguaBean.codigo},1)"><i class="icon-pencil"></i></a>
                                                         <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacionDet(${inscripcionLenguaBean.codigo})"><i class="icon-trash"></i></a>
                                                           <!--    ******************   -->
                                                         <a title="Asignar Docente" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="activarAsignarDocente(${inscripcionLenguaBean.codigo} , ${inscripcionLenguaBean.institucion.codigo},'${inscripcionLenguaBean.lenguainscr.nombre}');"><i class="icon-arrow-right"></i></a>
                                                       <!--    ******************   -->
                                                       <a title="Agregar más cupos"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" onclick="modificarLengua(${inscripcionLenguaBean.codigo},2)"><i class="fa fa-plus" aria-hidden="true"></i></a>
                                                        </td>
								                      </tr>
								                      </c:forEach>
								                     
								                    
								
								                  </tbody>
								                   <tfoot>
								                      <tr>
								                      	   <th>N°</th>
								                          <th>Lengua</th>
								                          <th>Nivel</th>
								                          <th width="250">N° de cupos</th>
								                          <th width="150">Acciones</th>
								                      </tr>
								                  </tfoot>
								              </table>