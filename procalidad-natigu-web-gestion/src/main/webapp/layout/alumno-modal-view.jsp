<%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>      
   
    <!-- Modal -->
    <div class="modal fade text-xs-left" id="alumno-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true" data-backdrop="static" data-keyboard="false">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Alumno</b></label>
        </div>
        <form onsubmit="return false">
        <div class="modal-body">
          <div class="row">
            <div class="col-md-10 mb-2">
                <label>Nombre alumno</label>
                <input type="text" class="form-control" name="nomAlum" id="nomAlum" maxlength="90">
            </div>

              <div class="form-group col-md-12 text-right">
              		<button type="button" class="btn btn-default" onclick="ejecutar_dos_funcionesModalAlumno()">
                    <i class="fa fa-eraser"></i> Limpiar
                  </button>
                  <button type="button" class="btn btn-default" onclick="listarAlumnoxInstitucionmodal()">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div>
          </div>

          <div class="row">
            <div class="col-xs-12" id="listadoalumModalview">
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
                      	  <td>${theCount.count}</td>
                          <td>${alumnoBean.personaBean.nombrePersona} ${alumnoBean.personaBean.apellidoPaterno} ${alumnoBean.personaBean.apellidoMaterno}</td>
                          <td>${alumnoBean.transformDNI(alumnoBean.personaBean.numeroDocumento)}</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"  onclick="agregarMatriculaAlumno(${alumnoBean.codigo})"><i class="icon-arrow-right"></i></button><!-- agregarMatriculaAlumno(${alumnoBean.codigo}) -->
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
            </div>
          </div>

        </div>
       
        </form>
         <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
        </div>
      </div>
      </div>
    </div>
    
    
    <script type="text/javascript">
    $(document).ready(function() {
        $('#tb_alumno').DataTable( {
            "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
        } );
    } );
    
    function limpiarmodal() {
    	$("#nomAlum").val("");
	}
    
    function ejecutar_dos_funcionesModalAlumno()
	    {	
    		limpiarmodal();
			listarAlumnoxInstitucionmodal();
			
	    }
	</script>
