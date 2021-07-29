<%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

 <script type="text/javascript">
$(document).ready(function() {
    $('#tb_docentegrupoDet').DataTable( {
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    } );
} );
</script> 				
 				 <table id="tb_docentegrupoDet"  class="table table-striped table-bordered zero-configuration">
                  <thead>
                      <tr>
                      	  <th width="10">N°</th>
                          <th width="130">Docente</th>
                          <th width="30">N° de doc.</th>
                          <th width="100">Tipo de rol</th>
                          <th width="10">Acción</th>
                      </tr>
                  </thead>
                  <tbody id="idTablaPremio" class="idTablaPremio">
                       <c:forEach var="docenteBean" items="${lstDocenteBean}" varStatus="theCount">
                      <tr>
                      	  <td>${docenteBean.codigo}</td><!--${docenteBean.codigo}  -->
                          <td>${docenteBean.personaBean.nombrePersona} ${docenteBean.personaBean.apellidoPaterno} ${docenteBean.personaBean.apellidoMaterno}</td>
                          <td>${docenteBean.personaBean.numeroDocumento}</td>
                          <td>
                          	<f:select id="lbltipoDocente" path="matriculaDocenteBean.tipoDocente.codigoRegistro" name="lbltipoDocente" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="" label="Seleccionar" />
															<f:options items="${lstTipoDocente}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
							</f:select>
                          </td>
                          <td>
                            <button type="submit" class="btn btn-outline-success btn-sm" onclick="recorrertabla(${docenteBean.codigo})"><i class="icon-arrow-right"></i></button>
                          </td>
                      </tr>
                      </c:forEach>
                  </tbody>
                  <tfoot>
                      <tr>
                      	  <th width="10">N°</th>
                          <th width="130">Docente</th>
                          <th width="30">N° de doc.</th>
                          <th width="100">Tipo de rol</th>
                          <th width="10">Acción</th>
                      </tr>
                  </tfoot>
              </table>