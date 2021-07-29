<%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>      
    <script type="text/javascript">
		      $(document).ready(function() {
		  		$("a.l1s").click(function(){
		  			id = $(this).parents("#idTablainscripcionLenguaBean >tr").find("td").eq(0).html();
		  			codDetalleInstLen = $(this).parents("#idTablainscripcionLenguaBean >tr").find("td").eq(1).html();
		  			nombreInstitu = $(this).parents("#idTablainscripcionLenguaBean >tr").find("td").eq(2).html();
		  			/* alert(id + codDetalleInstLen + nombreInstitu); */
		  			document.getElementById("codigoInscripcionDetalle").value=codDetalleInstLen;
		  			/* document.getElementById("inscripcionDetalle").value=nombreInstitu; */
		  			$('#bootstrap2').modal('hide');
		  		
		  		/* 	document.getElementById("lblInstitu").value=5;
					$('#lblLengua').val(55);
					$('#lblPeriodo').val(2017);
					$('#lblciclo').val(1);
					$('#lblNumCuposTotal').val(10);
					$('#numCupos').val(10);//numeroCuposDisp
					//$('#numCuposDisponible').val(data.numeroCuposDisp);
					$('#lblNivel').val(1); 
					msg_info('Se agrego correctamente el Detalle'); */
		  			obtenerCodigoDetalleInscripcion(codDetalleInstLen);
		  			 
		  		});
		  	  (function ($) {
		  		 
	                $('#nomInsti').keyup(function () {
	 
	                    var rex = new RegExp($(this).val(), 'i');
	                    $('#idTablainscripcionLenguaBean tr').hide();
	                    $('#idTablainscripcionLenguaBean tr').filter(function () {
	                        return rex.test($(this).text());
	                    }).show();
	 
	                })
	 
	            }(jQuery));
		  		});
		      </script>
    <!-- Modal -->
<%--     <div class="modal fade text-xs-left" id="alumno-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Alumno</b></label>
        </div>
        <form> --%>
        <div class="modal-body">
          <div class="row">
            <div class="col-md-8 mb-2">
                <label>Nombre de la institución</label>
                <input type="text" class="form-control" name="fname" id="nomInsti">
            </div>

              <!-- <div class="form-group col-md-4 text-right">
                  <button type="button" class="btn btn-default mt-2">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div> -->
          </div>

          <div class="row">
            <div class="col-xs-12">
              <table  class="table table-striped table-bordered">
                  <thead>
                      <tr >
                      	  <th width="15">N&deg;</th>
           				  <th>Nom. instituci&oacute;n</th>
           				  <th>Nom. de la lengua</th>
           				  <th>Nivel</th>
           				  <th>Periodo</th>
           				  <th>Semestre</th>          				  
           				  <th>Núm. cupos</th>
           				  <!-- <th>Num. Cupos D.</th> -->
                          <th width="20">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody id="idTablainscripcionLenguaBean">
                      <c:forEach var="inscripcionLenguaBean" items="${lstInscripcionLenguaBean}" varStatus="theCount">
                      <tr>
                      	  <td >${theCount.count}</td><!-- ${inscripcionLenguaBean.codigo} -->
                      	  <td style="display:none;"> ${inscripcionLenguaBean.codigo}</td>
                  		  <td >${inscripcionLenguaBean.institucion.nombreInstitucion}</td>
                  		  <td >${inscripcionLenguaBean.lenguainscr.nombre}</td>
                  		  <td >${inscripcionLenguaBean.nivel.nombreCorto}</td>
                  		  <td >${inscripcionLenguaBean.inscripcionBean.periodo.codigoRegistro}</td>
                  		  <td >${inscripcionLenguaBean.inscripcionBean.ciclo.nombreCorto}</td>                  		  
                  		  <td >${inscripcionLenguaBean.numeroCuposInsc}</td>
                  		  <%-- <td >${inscripcionLenguaBean.numeroCuposDisp}</td> --%>
                          <td >
                           <!--  <button type="button" class="btn btn-outline-success btn-sm" id="botonagregarDetalle"><i class="icon-arrow-right"></i></button> -->
                            <a class='l1s' title='seleccionar'><i class="icon-arrow-right"></i></a>
                          </td>
                      </tr>
                      </c:forEach>
                  </tbody>
                  <tfoot>
                      <tr >
                      	  <th width="15">N&deg;</th>
           				  <th>Nom. instituci&oacute;n</th>
           				  <th>Nom. de la lengua</th>
           				  <th>Nivel</th>
           				  <th>Periodo</th>
           				  <th>Semestre</th>          				  
           				  <th>Núm. cupos</th>
           				  <!-- <th>Num. Cupos D.</th> -->
                          <th width="20">Acci&oacute;n</th>
                      </tr>
                  </tfoot>
              </table>
            </div>
          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
        </div>
<%--         </form>
      </div>
      </div>
    </div> --%>
        <script type="text/javascript">
 /*        $(document).ready(function () {
        	 
            (function ($) {
 
                $('#nomInsti').keyup(function () {
 
                    var rex = new RegExp($(this).val(), 'i');
                    $('.idTablainscripcionLenguaBean tr').hide();
                    $('.idTablainscripcionLenguaBean tr').filter(function () {
                        return rex.test($(this).text());
                    }).show();
 
                })
 
            }(jQuery));
 
        }); */
        </script>