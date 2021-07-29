<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<%@page isELIgnored="false" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarEjercicioDocs();habilitarWYSIWYG('txtCuerpo');$('.note-editor').addClass('form-control');" id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
<%-- 	<li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li>--%>
</ul>
<f:form class="form" id="frmRegistoTextoTexto" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body">
	         
	         
			<div class="row">
			
				<div class="col-xs-6">
				
					<div class="form-group">
						<input type="hidden" id="idEjercicio" value="0"/>
						<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
					<label id="titulo" for="timesheetinput1">Indicaci&oacute;n*</label>
						<div class="position-relative ">
							<input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" maxlength="1200" value="${ejercicio.tituloEjercicio}">
						</div>
					</div>
					<div class="form-group">
						<label for="ejercicioTxtComprension">Comprensi&oacute;n</label>
						<div class="position-relative ">
							<input type="text" id="ejercicioTxtComprension" class="form-control" name="ejercicioTxtComprension" maxlength="1200" value="${ejercicio.comprension}">
						</div>
				    </div>	
				    <%-- <div class="form-group">
						<label for="ejercicioTxtComprension">Expresi&oacute;n Gramatical</label>
						<div class="position-relative ">
							<textarea id="ejercicioTxtExpGramatic" rows="2" class="form-control input-sm" name="ejercicioTxtExpGramatic">${ejercicio.expresionGramatical}</textarea>
						</div>
				    </div> --%> 
				    <div class="form-group">
						<label for="ejercicioTxtComprension">Expresi&oacute;n gramatical</label>
						<br /><br />
						<div class="position-relative " id="bodyEjercicioTxtExpGramatic">
							<div class="" id="ejercicioTxtExpGramatic"></div>
						</div>
				    </div> 
				<div class="form-group text-right mb-1">					
					<button type="button" id="btn_nuevo_ejercicio" onclick="nuevo()" class="btn btn-outline-info btn-min-width">
					<i class="fa fa-file-o"></i> Nuevo
					</button>
					<button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
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
				                <th width="110">Acci&oacute;n</th>
				            </tr>
				         </thead>
				                <tbody id="idBodyListadoMaterialTipoEjercicio">
				                </tbody>
				         </table>
				    </div>
				</div>
			
			</div>	
	        
	        
	      </div>
	</div>

	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42">
		<div class="row">
		<input type="hidden" id="idRelacionCabecera" value="0"/>
		
	    
	    <div class="col-xs-6">
	    	<div class="col-xs-7">
	    		<div class="row">
					<div class="form-group">
		         		<label for="timesheetinput7">T&iacute;tulo <span class="required"> *</span></label>
		         		<input type="text" id="txtTitulo" class="form-control input-sm" maxlength="300">
		        	</div>
	        	</div>
        	</div>
	    	<div class="col-xs-5">
	    		<div class="row">
					<div class="form-group">
		         		<label for="timesheetinput7">Tipo de documento <span class="required"> *</span></label>
		         		<select id="cbTipoDoc" class="form-control input-sm">
		         			<option value="0">Seleccione</option>
		         		</select>
		        	</div>
	        	</div>
        	</div>
        	
         
			<div class="col-xs-12">
				<div class="row">
				<div class="form-group text-right mb-1" >
				  <button type="button" id="btnNuevoCabecera" onclick="nuevoArmarDocsCabecera()" class="btn btn-outline-info btn-min-width button-sm">
				  <i class="fa fa-file-o"></i> Nuevo
				  </button>			 
				 <button type="button" class="btn btn-outline-info btn-min-width input-sm" onclick="guardarArmarDocsCabecera()" >
				 <i class="fa fa-floppy-o"></i> Guardar
				 </button>
				 </div> 	
				 </div>
			</div>
         
		         
	     </div>
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                       
						<thead>
                            <tr>
                                <th width="30">N°</th>
                                <th>T&iacute;tulo</th>
                                <th>Tipo de documento</th>
                                <th width="82">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="bodyListArmarTextoCab"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>
	      <hr />
	    <div class="row">
			<input type="hidden" id="idRelacionRelacionarTexto" value="0"/>
	      	 <div class="col-xs-6">
	      	 	<div class="col-xs-6">
	        		<div class="row">
			        	<div class="form-group">
			         		<label for="timesheetinput7">Parte de documento <span class="required"> *</span></label>
			         		<select id="cbParteDoc" class="form-control input-sm" disabled="true" required>
			         			<option value="0">Seleccione</option>
			         		</select>
			        	</div>
			        	
		        	</div>
	        	</div>
	        	<div class="col-xs-6">
	        		<div class="row">
	        			<div class="form-group">
							<label for="timesheetinput7">Traducci&oacute;n <span class="required"> *</span></label>
							<div class="position-relative has-icon-left">
								<input id="txtTraduccion" required disabled="true"  class="form-control input-sm" maxlength="1000"/>
								<div class="form-control-position">
									<i class="ft-file"></i>
								</div>
							</div>
						</div> 
	        		</div>
	        	</div>
	        	<div class="col-xs-12">
	        		<div class="row">
	        			<div class="form-group">
							<label for="timesheetinput7" style="visibility:hidden">Descripci&oacute;n <span class="required"> *</span></label>
							<!-- <div class="position-relative has-icon-left">
								<textarea id="txtCuerpo" required disabled="true"  class="form-control input-sm" rows="2" ></textarea>
								<div class="form-control-position">
									<i class="ft-file"></i>
								</div>
							</div>-->
							<div class="" id="bodyParrafo">
				         <div class="" id="txtCuerpo"></div>
				      </div>
						</div> 
	        		</div>
	        	</div>
	        	<div class="col-xs-12">
	        		<div class="row">
	        		<div class="form-group text-right mb-1" >
					  <button type="button" id="btn_nuevo_texto" onclick="nuevoArmarDocumento()" disabled="true" class="btn btn-outline-info btn-min-width input-sm">
					  <i class="fa fa-file-o"></i> Nuevo
					  </button>			 
					 <button type="button" class="btn btn-outline-info btn-min-width input-sm" disabled="true" id="btnGuardarArmarDoc" onclick="guardarArmarDocumento()" >
					 <i class="fa fa-floppy-o"></i> Guardar
					 </button>
					 </div>
					 </div>
				</div>
	      	 </div>
			<div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped table-hover zero-configuration" id="tableActividadArmarDocCab">
						<thead>
                            <tr>
                                <th width="30">N°</th>
  								<th>Parte de documento</th>
  								<th>Traducci&oacute;n</th>
                                <th width="82">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="bodyListArmarTextoDet"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>

</div>
</f:form> 
