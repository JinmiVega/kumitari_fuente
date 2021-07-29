<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 <script type="text/javascript">
	$( document ).ready(function() {
		$("#tblOperador").DataTable();
	});
</script>
<table id="tblOperador" class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                          	  <th>Nº</th>
                                                              <th >Nombres</th>
                                                              <th>Cargo</th>
                                                              <th>N&ordm; documento</th>
                                                              <th width="150">Correo</th>
                                                              <th>Fecha reg.</th>
                                                              <th width="120">Situaci&oacute;n</th>
                                                              <th width="80">Acciones</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="idBodyListaInstOperador">
                                                      	  <c:forEach var="instOperador" items="${lstInstitucionOperadorBean}" varStatus="loop">
                                                      	  	<tr>
															  <td>${loop.count}</td>
                                                              <td>${instOperador.personaBean.nombreCompleto}</td>
                                                              <td>${instOperador.cargo.nombreCorto} </td>
                                                              <td>${instOperador.personaBean.numeroDocumento}</td>
                                                              <td>
                                                                <div class="mb-0">
                                                                  <i class="icon-envelope media-left media-middle"></i>
                                                                  <div class="media-body">${instOperador.personaBean.correo}</div>
                                                                </div>
                                                              </td>
                                                              <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${instOperador.fechaCreacion}" />
                                                               </td>
                                                              <td>${instOperador.nombreSituacion} </td>
                                                              <td>
                                                              	<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Editar" onclick="modificarInstitucionOperador(${instOperador.codigo});"><i class="icon-pencil"></i></button>
                                                             	<button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_eliminar('operador',${instOperador.codigo});"><i class="icon-trash"></i></button>
                                                              </td>
                                                          	</tr>
                                                      	  </c:forEach>
                                                      </tbody>
                                                       <tfoot>
                                                          <tr>
                                                          	  <th>Nº</th>
                                                              <th >Nombres</th>
                                                              <th>Cargo</th>
                                                              <th>N&ordm; documento</th>
                                                              <th width="150">Correo</th>
                                                              <th>Fecha reg.</th>
                                                              <th width="120">Situaci&oacute;n</th>
                                                              <th width="80">Acciones</th>
                                                          </tr>                                                      
                                                      </tfoot>                                                     
                                                      
                                                  </table>
                                                  
