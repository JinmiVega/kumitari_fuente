<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page isELIgnored="false"%>
<style>
	.note-table, .note-insert {
		display: none
	}

	.onoffswitch {
	    position: relative; width: 180px;
	    -webkit-user-select:none; -moz-user-select:none; -ms-user-select: none;
	}
	
	.onoffswitch-checkbox {
	    display: none;
	}
	
	.onoffswitch-label {
	    display: block; overflow: hidden; cursor: pointer;
	    border: 2px solid #999999; border-radius: 30px;
	}
	
	.onoffswitch-inner {
	    display: block; width: 200%; margin-left: -100%;
	    -moz-transition: margin 0.3s ease-in 0s; -webkit-transition: margin 0.3s ease-in 0s;
	    -o-transition: margin 0.3s ease-in 0s; transition: margin 0.3s ease-in 0s;
	}
	
	.onoffswitch-inner:before, .onoffswitch-inner:after {
	    display: block; float: left; width: 50%; height: 30px; padding: 0; line-height: 30px;
	    font-size: 14px; color: white; font-family: Trebuchet, Arial, sans-serif; font-weight: bold;
	    -moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box;
	    border-radius: 30px;
	    box-shadow: 0px 15px 0px rgba(0,0,0,0.08) inset;
	}
	
	.onoffswitch-inner:before {
	    content: "Responder";
	    padding-left: 10px;
	    background-color: #2FCCFF; color: #FFFFFF;
	    border-radius: 30px 0 0 30px;
	}
	
	.onoffswitch-inner:after {
	    content: "Marcar";
	    padding-right: 10px;
	    background-color: #EEEEEE; color: #999999;
	    text-align: right;
	    border-radius: 0 30px 30px 0;
	}
	
	.onoffswitch-switch {
	    display: block; width: 90px; margin: 0px;
	    background: #FFFFFF;
	    border: 2px solid #999999; border-radius: 30px;
	    position: absolute; top: 0; bottom: 0; right: 90px;
	    -moz-transition: all 0.3s ease-in 0s; -webkit-transition: all 0.3s ease-in 0s;
	    -o-transition: all 0.3s ease-in 0s; transition: all 0.3s ease-in 0s; 
	    background-image: -moz-linear-gradient(center top, rgba(0,0,0,0.1) 0%, rgba(0,0,0,0) 80%); 
	    background-image: -webkit-linear-gradient(center top, rgba(0,0,0,0.1) 0%, rgba(0,0,0,0) 80%); 
	    background-image: -o-linear-gradient(center top, rgba(0,0,0,0.1) 0%, rgba(0,0,0,0) 80%); 
	    background-image: linear-gradient(center top, rgba(0,0,0,0.1) 0%, rgba(0,0,0,0) 80%);
	    box-shadow: 0 1px 1px white inset;
	}
	
	.onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-inner {
	    margin-left: 0;
	}
	
	.onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-switch {
	    right: 0px; 
	}
</style>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item"><a class="nav-link active" id="base-tab41"
		data-toggle="tab" aria-controls="tab41" href="#tab41"
		aria-expanded="true">Ejercicio</a></li>
	<li class="nav-item"><a class="nav-link" id="base-tab42"
		data-toggle="tab" aria-controls="tab42" href="#tab42"
		onclick="limpiarPreguntaRptas();busarPreguntasMatTEjer();habilitarChecksValidar();habilitarWYSIWYG('txtPreguntaDescripcion');habilitarWYSIWYG('rptaDescripcion0');habilitarWYSIWYG('rptaDescripcion1');;habilitarWYSIWYG('rptaDescripcion2');;habilitarWYSIWYG('rptaDescripcion3')"
		aria-expanded="false">Actividad</a></li>
	<!-- <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> -->
</ul>

<f:form class="form" id="frmregistromodalactividad" method="post"
	action="">
	<div class="tab-content px-1 pt-1">
		<div role="tabpanel" class="tab-pane active" id="tab41"
			aria-expanded="true" aria-labelledby="base-tab41">
			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
						<input type="hidden" id="idEjercicio" value="0" /> <input
							type="hidden" id="idMaterialTipoEjercicio" value="0" /> <label
							id="titulo" for="timesheetinput1">Indicaci&oacute;n*</label>
						<div class="position-relative ">
							<input type="text" id="ejercicioTxtTitulo" class="form-control" maxlength="1200"
								name="employeename" value="${ejercicio.tituloEjercicio}">
						</div>
					</div>

					<div class="form-group">
						<label for="ejercicioTxtComprension">Comprensi&oacute;n</label>
						<div class="position-relative ">
							<input type="text" id="ejercicioTxtComprension" maxlength="1200"
								class="form-control" name="ejercicioTxtComprension"
								value="${ejercicio.comprension}">
						</div>
					</div>

					<%--  <div class="form-group">
						<label for="ejercicioTxtComprension">Expresi&oacute;n Gramatical</label>
						<div class="position-relative ">
							<textarea id="ejercicioTxtExpGramatic" rows="2" class="form-control input-sm" name="ejercicioTxtExpGramatic">${ejercicio.expresionGramatical}</textarea>
						</div>
				    </div>  --%>
					<div class="form-group">
						<label for="ejercicioTxtComprension">Expresi&oacute;n
							gramatical</label>
						<br><br>
						<div class="position-relative " id="bodyEjercicioTxtExpGramatic">
							<div class="" id="ejercicioTxtExpGramatic"></div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="checkTipoPreg">Tipo</label>
						<div class="position-relative ">
							<div class="onoffswitch">
							    <input type="checkbox" name="checkTipoPreg" class="onoffswitch-checkbox" id="checkTipoPreg" checked>
							    <label class="onoffswitch-label" for="checkTipoPreg">
							        <span class="onoffswitch-inner"></span>
							        <span class="onoffswitch-switch"></span>
							    </label>
						    </div>
						</div>
					</div>

					<div class="form-group text-right mb-1">
						<button type="button" id="btn_nuevo_ejercicio" onclick="nuevo();"
							class="btn btn-outline-info btn-min-width">
							<i class="fa fa-file-o"></i> </i> Nuevo
						</button>
						<button type="button" id="btn_guardar_ejercicio"
							onclick="grabarMaterialTipoEjercicio();habilitarChecksValidar();"
							class="btn btn-outline-info btn-min-width">
							<i class="fa fa-floppy-o"></i> Guardar
						</button>
					</div>
				</div>
				<div class="col-xs-6">
					<div class="table-responsive">
						<table class="table table-bordered table-striped">

							<thead>
								<tr>
									<th width="30">N°</th>
									<th>Indicaci&oacute;n</th>
									<th width="107">Acci&oacute;n</th>
								</tr>
							</thead>
							<tbody id="idBodyListadoMaterialTipoEjercicio">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<div class="tab-pane" id="tab42" aria-labelledby="base-tab42"
			aria-expanded="false">
			<input type="hidden" id="idEjercicio" />
			<div class="row">

				<div class="col-xs-6">

					<table id="tblPregunta"
						class="table table-striped table-bordered zero-configuration">
						<thead>
							<tr>
								<div class="form-group">
									<input type="hidden" id="idPregunta" value="" /> <label
										for="timesheetinput7">Pregunta <span class="required">*</span>
									</label> <br />
									<br />
									<div class="position-relative" id="bodyParrafo">
										<div class="" id="txtPreguntaDescripcion"></div>
									</div>
									<!--  <div class="position-relative has-icon-left">
		              <textarea id="txtPreguntaDescripcion" rows="3"  class="form-control input-sm" required="true" name="notes"></textarea>
		              <div class="form-control-position">
		                <i class="ft-file"></i>
		              </div>
		            </div> -->
								</div>
							</tr>
						</thead>
						<tbody>

							<tr>
								<div class="form-group row">
									<div class="col-md-1">
										<label for="nombreUnidadLec">Rpta. 1 <span
											class="required">*</span>
										</label>
									</div>
									<div class="col-md-11">
										<fieldset>
											<div class="input-group input-group-sm ">
												<span class="input-group-addon" id="radio-addon1"> <label
													class="custom-control custom-radio inline"> <input
														id="0" type="radio" name="rpst" required
														class="custom-control-input"> <span
														class="custom-control-indicator"></span>
												</label>
												</span>
												<div class="position-relative" id="bodyrpt0">
													<div class="" id="rptaDescripcion0"></div>
												</div>

												<!-- <input id="rptaDescripcion0" name="rptaDescripcion0" type="text" 
											required="true" class="form-control" aria-describedby="radio-addon1"> -->
											</div>
										</fieldset>
									</div>

									<!-- <div class="form-group col-md-2 "> 
									<button type="button" onc class="btn btn-outline-info btn-min" style="margin-top:-18px">
									<i class="ft-plus"></i></button>
							 	</div> -->
								</div>
								<br />
											
							</tr>

							<tr>
								<div class="form-group row">
									<div class="col-md-1">
										<label for="nombreUnidadLec">Rpta. 2 <span
											class="required">*</span>
										</label>
									</div>
									<div class="col-md-11">
										<fieldset>
											<div class="input-group input-group-sm ">
												<span class="input-group-addon" id="radio-addon1"> <label
													class="custom-control custom-radio inline"> <input
														id="1" type="radio" name="rpst" required
														class="custom-control-input"> <span
														class="custom-control-indicator"></span>
												</label>
												</span> 
												<div class="position-relative" id="bodyrpt1">
													<div class="" id="rptaDescripcion1"></div>
												</div>
												<!-- <input id="rptaDescripcion1" name="rptaDescripcion1"
													required="true" type="text" class="form-control"
													aria-describedby="radio-addon1"> -->
											</div>
										</fieldset>
									</div>
								</div><br />
							</tr>
							<tr>
								<div class="form-group row">
									<div class="col-md-1">
										<label for="nombreUnidadLec">Rpta. 3</label>
									</div>
									<div class="col-md-11">
										<fieldset>
											<div class="input-group input-group-sm ">
												<span class="input-group-addon" id="radio-addon1"> <label
													class="custom-control custom-radio inline"> <input
														id="2" type="radio" name="rpst"
														class="custom-control-input"> <span
														class="custom-control-indicator"></span>
												</label>
												
												</span> 
												<div class="position-relative" id="bodyrpt2">
													<div class="" id="rptaDescripcion2"></div>
												</div>
												<!-- <input id="rptaDescripcion2" name="rptaDescripcion2"
													type="text" class="form-control"
													aria-describedby="radio-addon1"> -->
											</div>
										</fieldset>
									</div>
								</div><br />
							</tr>
							<tr>
								<div class="form-group row">
									<div class="col-md-1">
										<label for="nombreUnidadLec">Rpta. 4</label>
									</div>
									<div class="col-md-11">
										<fieldset>
											<div class="input-group input-group-sm ">
												<span class="input-group-addon" id="radio-addon1"> <label
													class="custom-control custom-radio inline"> <input
														id="3" type="radio" name="rpst"
														class="custom-control-input"> <span
														class="custom-control-indicator"></span>
												</label>
												</span> 
												<div class="position-relative" id="bodyrpt3">
													<div class="" id="rptaDescripcion3"></div>
												</div>
												<!-- <input id="rptaDescripcion3" name="rptaDescripcion3"
													type="text" class="form-control"
													aria-describedby="radio-addon1"> -->
											</div>
										</fieldset>
									</div>
								</div>

							</tr>
						</tbody>


						<tfoot>

						</tfoot>
					</table>
					<div class="form-group text-right">
						<button type="button" class="btn btn-outline-info btn-min-width"
							onclick="nuevoMaterialTipoEjercicio2()" style="margin-top: 15px">
							<i class="fa fa-file-o"></i> Nuevo
						</button>
						<button type="button" class="btn btn-outline-info btn-min-width"
							onclick="grabarPreguntasMaterialTEjer2()"
							style="margin-top: 15px">
							<i class="fa fa-floppy-o"></i> Guardar
						</button>
					</div>
				</div>



				<div class="col-xs-6">
					<div class="table-responsive">
						<table class="table table-bordered table-striped"
							id="tblListaMatTEjerPreg">
							<thead>
								<tr>
									<th width="40">N°</th>
									<th width="120">Pregunta</th>
									<th width="76">Acciones</th>
								</tr>
							</thead>
							<tbody id="tbodyMatTEjerPreg">
							</tbody>
						</table>
					</div>

				</div>
			</div>

		</div>
		<div class="tab-pane" id="tab43" aria-labelledby="base-tab43">
			<p>Sugar plum tootsie roll biscuit caramels. Liquorice brownie
				pastry cotton candy oat cake fruitcake jelly chupa chups. Pudding
				caramels pastry powder cake soufflÃ© wafer caramels. Jelly-o pie
				cupcake.</p>
		</div>
	</div>
</f:form>


