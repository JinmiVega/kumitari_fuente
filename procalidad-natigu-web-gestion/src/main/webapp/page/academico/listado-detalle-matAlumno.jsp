<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<script type="text/javascript">
$(document).ready(function() {
    $('#tb_addalumnodet').DataTable( {
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    } );
} );
</script> 
 								<table id="tb_addalumnodet" class="table table-striped table-bordered">
								                  <thead>
								                      <tr>
								                      	<th width="15">N°</th>
								                      	<th width="150">Usuario</th>
                                                        <th width="250">Estudiante</th>
                                                        <th width="150">Lengua</th>
                                                        <th width="70">Condicion del nivel</th>
                                                        <th width="30">Nota</th>
                                                        <th width="50">Situaci&oacute;n</th>
                                                        <th width="15">Acci&oacute;n</th>
								                      </tr>
								                  </thead>
								                  <tbody>
								                  <c:forEach var="usuarioMatricula" items="${lstUsuarioMatricula}" varStatus="theCount">
								                      <tr>
								                      	  <td style="text-align: center;">${theCount.count}</td>
								                          <td style="text-align: center;">${usuarioMatricula.usuarioBean.nombreUsuario}</td>
								                          <td style="text-align: center;">${usuarioMatricula.alumnoBean.personaBean.nombreCompleto}</td>
								                          <td style="text-align: center;">${usuarioMatricula.matriculaBean.lengua.nombre}</td>
								                          <td style="text-align: center;">${usuarioMatricula.vCondicion}</td>
								                          <td style="text-align: center;">${usuarioMatricula.nNota}</td>
								                          <td style="text-align: center;">${usuarioMatricula.situacion.nombreCorto}</td>
								                       	<c:if test="${usuarioMatricula.situacion.codigoRegistro ==1}">
								                       		<td style="text-align: center;"><button type="button" onclick="confirmar_accion_1('${usuarioMatricula.codigo}');" class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button></td>
								                       	</c:if>
								                       	<c:if test="${usuarioMatricula.situacion.codigoRegistro ==2}">
								                       		<td style="text-align: center;"> -- </td>
								                       	</c:if>
								                      </tr>
								                      </c:forEach>
								                     
								                    
								
								                  </tbody>
								                      <tfoot>
                                                    <tr>
                                                       <th width="15">N°</th>
								                      	<th width="150">Usuario</th>
                                                        <th width="250">Estudiante</th>
                                                        <th width="150">Lengua</th>
                                                        <th width="70">Condicion del nivel</th>
                                                        <th width="30">Nota</th>
                                                        <th width="50">Situaci&oacute;n</th>
                                                        <th width="15">Acci&oacute;n</th>
                                                    </tr>
                                                </tfoot>
								              </table>
