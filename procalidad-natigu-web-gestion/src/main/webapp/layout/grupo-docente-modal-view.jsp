<%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
    
    <!-- Modal -->
<!--    <div class="modal fade text-xs-left" id="grupo-docente-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog" role="document"> 
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Docente</b></label>
        </div> -->
       <%--  <form> --%>
       	<script type="text/javascript">
   	   
      	$(document).ready(function () {

            $('#tb_docentegrupoDet').DataTable( {
  	            "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
  	        } );

      	var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"
				  	  $("#numeroDocumentofil").on("keydown keyup change", function(){
			            var value =  $("#numeroDocumentofil").val();
			           	
				            if (value.length == 0){
				            	$("#numeroDocumentofil").parents(".valid-msg").removeClass("has-error");
				              	$("#boxMsg").fadeOut();
				              
				            	
				            }else if (value.length < 8){
				            	var contentInput = $("#numeroDocumentofil").parents(".valid-msg");
				           		$(contentInput).addClass("has-error");
				            	$("#boxMsgx").html(infoHtml);
					            $("#boxMsg").fadeIn("slow");
					            $(".msgValidar").html("Por favor, ingrese 8 caracteres como mínimo");
					           
				            	
				            } else{
				            	$("#numeroDocumentofil").parents(".valid-msg").removeClass("has-error");
				            	$("#boxMsg").fadeOut();
				            	
				            } 
				          
			            
			        });
      	$('#numeroDocumentofil').on('input', function () { 
      	    this.value = this.value.replace(/[^0-9]/g,'');
      	});
        }); 
        function myFunctionnombreDocentefil() {
        	  // Declare variables 
        	  var input, filter, table, tr, td, i;
        	  $('#numeroDocumentofil').val('');
        	  input = document.getElementById("nombreDocentefil");
        	  filter = input.value.toUpperCase();
        	  table = document.getElementById("idTablaPremio");
        	  tr = table.getElementsByTagName("tr");

        	  // Loop through all table rows, and hide those who don't match the search query
        	  for (i = 0; i < tr.length; i++) {
        	    td = tr[i].getElementsByTagName("td")[1];
        	    if (td) {
        	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        	        tr[i].style.display = "";
        	      } else {
        	        tr[i].style.display = "none";
        	      }
        	    } 
        	  }
        	}
        function myFunctionnumeroDocumentofil() {
      	  // Declare variables 
      	  var input, filter, table, tr, td, i;
      	  $('#nombreDocentefil').val('');
      	  input = document.getElementById("numeroDocumentofil");
      	  filter = input.value.toUpperCase();
      	  table = document.getElementById("idTablaPremio");
      	  tr = table.getElementsByTagName("tr");

      	  // Loop through all table rows, and hide those who don't match the search query
      	  for (i = 0; i < tr.length; i++) {
      	    td = tr[i].getElementsByTagName("td")[2];
      	    if (td) {
      	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
      	        tr[i].style.display = "";
      	      } else {
      	        tr[i].style.display = "none";
      	      }
      	    } 
      	  }
      	}
        

		</script>
        <div class="modal-body">
          <div class="row">
            <!-- <div class="col-md-4 form-group">
                    <label for="projectinput2">Grupo</label>
                     <select id="situacionUsuario" name="interested" class="form-control">
                      <option value="none" selected="" disabled="">Selecionar</option>
                  </select>
            </div> -->
            <div class="col-md-7 mb-2">
                <label>Nombre de docente</label>
                <input type="text" class="form-control" name="nombreDocentefil" id="nombreDocentefil"  placeholder="Nombre del Docente" maxlength="90">
            </div>
            <div class="col-md-5 mb-2">
                <label>N&uacute;mero de documento</label>
                <input type="text" class="form-control" name="numeroDocumentofil" id="numeroDocumentofil" placeholder="N° de documento" maxlength="15">
            </div>
            <!-- <div class="col-md-3 mb-2">
                <button type="button" class="btn btn-default mt-2">
                    <i class="ft-search"></i> Buscar
                  </button>
            </div> -->
          </div>
          <div id="boxMsgx"></div>
           <div class="row">
			
              <div class="form-group col-md-12 text-right">
               <button type="button" class="btn btn-default mt-2" onclick="ejecutar_dos_funciones()">
                    <i class="fa fa-eraser"></i> Limpiar
                  </button>
                  <button type="button" class="btn btn-default mt-2" onclick="recargarListadoxInscripcionDetalle()">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div>
          </div> 

          <div class="row">
            <div class="col-xs-12" id="listadoGrupoDocenteModalview">
              <table id="tb_docentegrupoDet" class="table table-striped table-bordered zero-configuration">
                  <thead>
                      <tr>
                      	  <th width="10">N°</th>
                          <th width="130">Docente</th>
                          <th width="30">N° de doc.</th>
                          <th width="100">Tipo de rol</th>
                          <th width="10">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody id="idTablaPremio" class="idTablaPremio">
                       <c:forEach var="docenteBean" items="${lstDocenteBean}" varStatus="theCount">
                      <tr>
                      	  <td>${docenteBean.codigo}</td>
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
                          <th width="10">Acci&oacute;n</th>
                      </tr>
                  </tfoot>
              </table>
            </div>
          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
        </div>
        <script type="text/javascript">
        function limpiarmodal() {
        	$("#numeroDocumentofil").val("");
        	$("#nombreDocentefil").val("");
        	$("#numeroDocumentofil").parents(".valid-msg").removeClass("has-error");
        	$("#boxMsg").fadeOut();
		}
        
        function ejecutar_dos_funciones()
			        {	
        				limpiarmodal();
        				recargarListadoxInscripcionDetalle();
        				
			        }
		</script>
        <%-- </form> --%>
    <!--   </div>
      </div>
    </div>  -->