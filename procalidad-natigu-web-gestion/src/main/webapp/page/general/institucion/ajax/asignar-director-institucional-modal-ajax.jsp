<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<f:form id="frmGuardarInstDirector" class="form-horizontal" role="form"
	method="post" action="${pageContext.request.contextPath}/institucionController/guardarInstDirector">
	<div class="modal-body">
		<div class="row">
		<f:input type="hidden"  id="codigoPersonaDirector_dato" class="form-control" name="lname" path="codigo" />
			<div class="col-md-5">
				<fieldset class="form-group">
					<label>Tipo de documento <span class="required">*</span></label>
					<f:select id="tipoDocumentoPersona_dato1"
						path="tipoDocumento.codigoRegistro" class="form-control">
						<f:option value="0" label="Seleccionar" />
						<f:options items="${lstTipoDocumento}" itemValue="codigoRegistro"
							itemLabel="nombreCorto" />

					</f:select>
				</fieldset>
			</div>
			<div class="col-md-4">
				<label for="projectinput2">N&uacute;mero de documento <span class="required">*</span></label>
				<div class="controls">
				<f:input type="text" id="numeroDocumentoPersona_dato1" required="required" data-validation-required-message="Este campo es requerido"
					class="form-control" name="lname" path="numeroDocumento" maxlength="8" pattern="[0-9]{8}" />
			</div>
			</div>
			<div class="col-md-3 text-right">
				<br>
				<button type="button" class="btn btn-secondary"
					onclick="buscarPersonaPorDocumento()"><%--buscarPersonaPorDocumento() --%>
					<i class="ft-search"></i> Buscar
				</button>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12 mb-2">
				<label for="projectinput1">Nombre completo</label>
				<f:input type="text" id="nombresPersona_dato" class="form-control"
					name="lname" path="nombreCompleto" disabled="true" />
			</div>


		</div>
		<div class="row">
			<div class="form-group col-md-4 mb-2">
				<label for="projectinput2">Tel&eacute;fono/Celular</label>
				<f:input type="text" id="telefonoPersona_dato" disabled="true"
					class="form-control" name="lname" path="telefono" />
			</div>

			<div class="form-group col-md-8 mb-2">
				<label for="projectinput2">Correo electr&oacute;nico</label>
				<f:input type="text" id="correoPersona_dato" disabled="true"
					class="form-control" name="lname" path="correo" />
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button id="closeModalBtnFrmBqdDirector" type="button"
			class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
		<button type="button" class="btn btn-primary"
			onclick="asignarDirectorBuscado()">
			<i></i> Asignar
		</button>
	</div>
</f:form>