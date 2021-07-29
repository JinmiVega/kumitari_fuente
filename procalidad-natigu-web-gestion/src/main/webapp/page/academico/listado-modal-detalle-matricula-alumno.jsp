<%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<script type="text/javascript">
$(document).ready(function() {
    $('#tb_alumno').DataTable( {
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    } );
} );
</script> 				
 			     <table id="tb_alumno" class="table table-striped table-bordered">
                  <thead>
                      <tr>
                      	  <th width="15">N°</th>
                          <th>Nombre de alumno</th>
                          <th>N&uacute;mero de doc.</th>
                          <th width="20">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="alumnoBean" items="${lstAlumnoBean}" varStatus="theCount">
                      <tr>
                      	  <td>${theCount.count}</td><!-- ${alumnoBean.codigo} -->
                          <td>${alumnoBean.personaBean.nombrePersona} ${alumnoBean.personaBean.apellidoPaterno} ${alumnoBean.personaBean.apellidoMaterno}</td>
                          <td>${alumnoBean.personaBean.numeroDocumento}</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"  onclick="agregarMatriculaAlumno(${alumnoBean.codigo})"><i class="icon-arrow-right"></i></button>
                          </td>
                      </tr>
                      </c:forEach>
                  </tbody>
                  <tfoot>
                      <tr>
                      	  <th width="15">N°</th>
                          <th>Nombre de alumno</th>
                          <th>N&uacute;mero de doc.</th>
                          <th width="20">Acci&oacute;n</th>
                      </tr>
                  </tfoot>
              </table>