<%@ page contentType="text/html; charset=UTF-8" %>
<%--    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
	


    <!-- Modal -->
<%-- 	<f:form id="frmGuardarAgregaLengua" class="form-horizontal" role="form"
	method="post" action="${pageContext.request.contextPath}/inscripcionController/agregarlengua"> --%>

    <!-- <div class="modal fade text-xs-left" id="inscripcion-lengua-modal-registro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Agregar Lengua y Cupos</b></label>
        </div> -->
        <%--  <form id="loginForm" method="post"> --%>
        <div class="modal-body" ><!-- id="listado_docente_modal"  -->
          <div class="row">
            <div class="form-group col-md-4 mb-2">
                                                    <label for="lblLenguas">Lengua<span class="required">*</span></label>
                                                    <div class="controls">
                                                   <f:input type="hidden" path="inscripcionLenguaBean.codigo"  id="codigoinscrlen"/>
                                                    <input type="hidden" value="${swcod}"  id="swcod"  /> 
                                                    <f:select id="lblLenguamodal" path="inscripcionLenguaBean.lenguainscr.codigo" onchange="cargarNivelesInsc()" class="form-control selectReset" name="lblLenguamodal" data-validation-required-message="Este campo es requerido" required="required" >
															<f:option value="0" class="optionReset" label="Seleccionar"  />
															<f:options items="${lstlenguaBeanCombo}" itemValue="codigo" itemLabel="nombre" />
													</f:select>
													</div>
                                                  </div>
            <div class="form-group col-md-3 mb-2">
                                                  <label for="cmm_nivel">Nivel</label>
                                                  <f:select id="cmm_nivel" path="inscripcionLenguaBean.nivel.codigoRegistro" onchange="muestraCamposCupos();" class="form-control selectReset" name="lblLenguamodal" data-validation-required-message="Este campo es requerido" required="required" >
                                                    <f:option value="" label="Seleccione"/>
                                                     <f:options items="${lstnivelbean}"
                                                    			itemValue="codigoRegistro"
                                                    			itemLabel="nombreCorto"/> 
                                                  </f:select>
                                                </div>
                	 <div class="form-group col-md-4">
                                                  <label for="telefonoUsuario">N&uacute;mero de cupos<span class="required">*</span></label>
                                                   <div class="controls">
                                                   <f:input type="text" path="inscripcionLenguaBean.numeroCuposInsc" onkeypress="return justNumbers(event);"  class="form-control"  pattern="[0-9]{1,}" required="required" maxlength="3" onpaste="return false;"  id="numCupos"/> 
          											</div>	
           			</div>
          
              <div class="form-group col-md-3 text-right">
              <!--     <button type="submit" class="btn btn-default mt-2"
				onclick="crudSede()">onclick="agregarLengua()"
                    <i class="ft-search"></i> Agregar
                  </button> -->
              </div>
          </div>
          
          
<!--           <div class="row"> -->
          
          
           
<!--             <div id ="contenedorCuposNuevos" class="form-group col-md-4"> -->
<!--                                                   <label for="telefonoUsuario">Cupos Nuevos<span class="required">*</span></label> -->
<!--                                                    <div class="controls"> -->
<!--                                                    <input  id="cuposNuevos" type="text" class="form-control" onKeyUp ="calcularTotalCupos();"  onkeypress="return justNumbers(event);" name="cuposNuevos" class="form-control" data-validation-required-message="Este campo es requerido"  pattern="[0-9]{1,}" required="required"/>  -->
<!--           											</div>	 -->
<!--            </div> -->
           
           
<!--             <div id ="contenedorCuposAntiguos" class="form-group col-md-4"> -->
<!--                                                   <label for="telefonoUsuario">Cupos Antiguos<span class="required">*</span></label> -->
<!--                                                    <div class="controls"> -->
<!--                                                    <input  id="cuposAntiguo" type="text" class="form-control" onKeyUp ="calcularTotalCupos();"  onkeypress="return justNumbers(event);" name="cuposAntiguo" class="form-control" data-validation-required-message="Este campo es requerido"  pattern="[0-9]{1,}" required="required"/>  -->
<!--           											</div>	 -->
<!--            </div> -->
           
<!--            	 <div class="form-group col-md-4"> -->
<!--                                                   <label for="telefonoUsuario">Total Cupos<span class="required">*</span></label> -->
<!--                                                    <div class="controls"> -->
<%--                                                    <f:input  id="numCupos" type="text" class="form-control" path="inscripcionLenguaBean.numeroCuposInsc" onkeypress="return justNumbers(event);" name="numCupos" class="form-control" data-validation-required-message="Este campo es requerido"  pattern="[0-9]{1,}" required="required" disabled="true"/>  --%>
<!--           											</div>	 -->
<!--            </div> -->
          
          
<!--           </div> -->
          
          
		
  

        </div>
<!-- ///registro -->
 
        <div class="modal-footer">
         
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
          <button type="submit" id="guardarbtninscr-lengua-registro-modal-view"
			onclick="crudSede()" class="btn btn-primary">
			<i class="fa fa-floppy-o"></i> Guardar
		</button>
        </div>
<%--        </form> --%>
    <!--   </div>
      </div>
    </div> -->
<%-- 	</f:form> --%>
<script type="text/javascript">
//console.log('entro modal inscripcion registro modal view');

if ($("#codigoinscrlen").val()>0) {
	  $("#guardarbtninscr-lengua-registro-modal-view").prop("disabled",true);
	
}

var valor = $("#numCupos").val();
 	if(valor=='0'){ 
		$("#numCupos").val("");	
 	}
 	
 	
 	function muestraCamposCupos(){
 		var cboNivel = $('#cmm_nivel').val();
 		//console.log('cboNivel',cboNivel);
 		//var txtCuposNuevos = document.getElementById("contenedorCuposNuevos").style.display ="none";
 		//var txtCuposNuevos = document.getElementById("contenedorCuposAntiguos").style.display ="none";
 		if(cboNivel==1){
 		
 		}
 		
 	}
 	
 	
 	function calcularTotalCupos(){
 		
 		
 		
 	var numCupos 		=	$('#numCupos').val();
 	var numCuposNuevos  =	$('#cuposNuevos').val();
 	var numCuposAntiguo =	$('#cuposAntiguo').val();
 	
 	if(numCupos==""){
 		numCupos =0;
		}
 	
	if(numCuposNuevos==""){
		numCuposNuevos =0;
		}
	
	if(numCuposAntiguo==""){
		numCuposAntiguo =0;
		}

 	var numCupos = 	parseInt(numCuposNuevos) + parseInt(numCuposAntiguo);
 		
 	document.getElementById("numCupos").value=numCupos; 	
 		
 	}
</script>
