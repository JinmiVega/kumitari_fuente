<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<f:form id="frmGuardarInstSede" onsubmit="return false" class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/institucionController/guardarInstSede">
<div class="modal-body">
	<f:input type="hidden" id="codigo_instsede"  path="codigo" class="form-control" /> 
	<f:input type="hidden" id="codigoInstitucion_instsede" path="institucionBean.codigo" class="form-control"/> 

	<div class="row">
		<div class=" col-md-12">
			<div class="form-group">
				<label  for="projectinput1">Nombre (sede/filial/local)<span class="required">*</span></label> 
				<div class="controls">
					<f:input type="text"
						id="nombreSede" class="form-control" title="Solo se permiten letras"
						path="nombreSede" data-validation-required-message="Este campo es requerido" 
						required="required" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" maxlength="80"/>
				</div>
			</div>	
		</div>
	</div>
	
   <div class="row">
        <div class="col-xs-12 form-group">
        <b><label class="modal-title text-text-bold-600"> Ubicaci&oacute;n </label></b>
        <br>
        </div>
   </div>	
	
	
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label for="cbRegionSede">Regi&oacute;n<span class="required">*</span></label>
				<div class="controls">
					<f:select path="codigoRegion" data-validation-required-message="Este campo es requerido"
						onchange="buscarProvinciaSede();" id="cbRegionSede"  name="cbRegionSede"
						class="form-control" required="required">
						<f:option value="00" label="Seleccionar"  selected="true" disabled="disabled"  />
						<f:options items="${lstRegion}" 
							itemValue="codigoRegion"
							itemLabel="nombreUbigeo" />
					</f:select>
				</div>
			</div>	
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label for="cbProvinciaSede">Provincia<span class="required">*</span></label>
				<div class="controls">
					<f:select path="codigoProvincia"  name="cbProvinciaSede"
						data-validation-required-message="Este campo es requerido"
						onchange="buscarDistritoSede();" id="cbProvinciaSede"
						class="form-control" required="required">
						<f:option value="00" label="Seleccionar" selected="true" disabled="disabled" />
						<f:options items="${lstProvincia}" itemValue="codigoProvincia"
							itemLabel="nombreUbigeo" />
					</f:select>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label for="cbDistritoSede">Distrito<span class="required">*</span></label>
				<div class="controls">
					<f:select path="codigoDistrito" id="cbDistritoSede" name="cbDistritoSede"
						class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
						<f:option value="00" label="Seleccionar" selected="true" disabled="disabled" />
						<f:options items="${lstDistrito}" 
								   itemValue="codigoDistrito"
								   itemLabel="nombreUbigeo" />
					</f:select>
				</div>
			</div>	
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="form-group">
				<label for="direccion">Direcci&oacute;n <span class="required">*</span></label> 
				<div class="controls">
					<f:input type="text"
						path="direccionInstitucion" data-validation-required-message="Este campo es requerido" 
						class="form-control" id="direccion" required="required" maxlength="50"/>
						
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="form-group">
			<label for="contacto">Informaci&oacute;n de contacto<span class="required">*</span></label>
			<div class="controls">
				<f:input type="text" data-validation-required-message="Este campo es requerido" required="required" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+"
					path="contacto" class="form-control"
					 id="contacto" maxlength="80"/>
					
			</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="correoUsuario">Correo<span class="required">*</span></label>
				<div class="controls">
					<f:input type="email" class="form-control email-inputmask"
						path="correo"
						  
						 
						data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})"
						id="idcorreo"
						data-validation-regex-message="Ingresa un correo valido"
						data-validation-required-message="Este campo es requerido" 
					 
						required="required" maxlength="50"
					  />
					<!-- <input type="email" class="form-control" value="${correo}"
					name="correo" id="correo" > -->
					
				</div>
			</div>
		</div>
		<div class="col-md-6 ">
			<div class="form-group">
				<label>Tel&eacute;fono/Celular<span class="required">*</span></label>
				<div class="controls">
					<f:input type="tel" class="form-control" required="required"
					path="telefono" data-validation-required-message="Este campo es requerido" 
					id="telefono"/>
					<p class="help-block"></p>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal-footer">
	<button type="button" id="closeModalBtnFrmInstSede" class="btn btn-outline-secondary"
		data-dismiss="modal">Salir</button>
	<button type="submit"
		onclick="validar('#frmGuardarInstSede')" class="btn btn-primary">
		<i class="fa fa-floppy-o"></i> Guardar
	</button>
</div>
</f:form>
<script type="text/javascript">

$( document ).ready(function() {
	//Phone with extra
	   
		$('#telefono').inputmask("(999) 999-9999 / 999-999-999");
		// Email mask

	   
	});

// function validateMail(idMail)
// {
// 	//Creamos un objeto 
// 	object=document.getElementById(idMail);
// 	valueForm=object.value;
 
// 	// Patron para el correo
// 	var patron=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
// 	if(valueForm.search(patron)==0)
// 	{
// 		//Mail correcto
// 		object.style.color="#000";
// 		return;
// 	}
// 	//Mail incorrecto
// 	object.style.color="#f00";
// }
function validar(idfrom) {
	var $myForm = $(idfrom);
	
	var departamento = document.getElementById("cbRegionSede");
	var provincia = document.getElementById("cbProvinciaSede");
	var distrito = document.getElementById("cbDistritoSede");
	
	if (!$myForm[0].checkValidity() ||  departamento.value == "00" ||
			 provincia.value == "00" || distrito.value == "00") {
		$("#cbRegionSede").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#cbProvinciaSede").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#cbDistritoSede").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#cbRegionSede").css("color", "#16D39A");
		$("#cbProvinciaSede").css("color", "#16D39A");
		$("#cbDistritoSede").css("color", "#16D39A");

		// mensaje
		 msg_advertencia("Debe completar los campos requeridos correctamente");

		 if(departamento.value == "00" ){
				$("#cbRegionSede").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#cbRegionSede").css("color", "#444");
				departamento.focus();
			}
		 if(provincia.value == "00"){
				$("#cbProvinciaSede").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#cbProvinciaSede").css("color", "#444");
				provincia.focus();
			}
		 if(distrito.value == "00"){
				$("#cbDistritoSede").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#cbDistritoSede").css("color", "#444");
				distrito.focus();
			}
			
	
	} else {
		//$("#telefono").val($("#telefono").val().replace(/[^\d]/, ''));
		enviar_ajax_sede();
	}	
}
</script>
