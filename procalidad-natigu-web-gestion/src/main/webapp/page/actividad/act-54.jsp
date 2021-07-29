<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<%@page isELIgnored="false" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarEjercicioTextoTextoTexto()" id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
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
				    </div>  --%>
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
		
	     <div class="col-xs-5">
     	 <div class="form-group">
     	  <input type="hidden" id="idRelacionCabecera" value="0"/>
         <input type="hidden" id="idRelacionTextoTexto" value="0"/>
         <label for="timesheetinput7">Texto 1*</label>
         <div class="position-relative has-icon-left">
         <textarea id="textoTexto" rows="2" class="form-control input-sm" name="notes" maxlength="4000"></textarea>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
        </div>

     	 <div class="form-group">
         <label for="timesheetinput7">Texto 2*</label>
         <div class="position-relative has-icon-left">
         <textarea id="textoRelacionado" rows="2" class="form-control input-sm" name="notes" maxlength="4000"></textarea>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
         </div> 
         
         <div class="form-group">
         <label for="timesheetinput7">Texto 3*</label>
         <div class="position-relative has-icon-left">
         <textarea id="textoRelacionado2"  rows="2" class="form-control input-sm" name="notes" maxlength="4000"></textarea>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
         </div> 
         
		 <div class="form-group text-right mb-1" >
		  <button type="button" id="btn_nuevo_texto" onclick="nuevoTextoTextoTexto()" class="btn btn-outline-info btn-min-width">
		  <i class="fa fa-file-o"></i> Nuevo
		  </button>			 
		 <button type="button" class="btn btn-outline-info btn-min-width" onclick="validarTextoTextoTexto()" >
		 <i class="fa fa-floppy-o"></i> Guardar
		 </button>
		 </div> 	        
	        
	
	        </div>
	        <div class="col-xs-7">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                       
						<thead>
                            <tr>
                                <th width="30">N°</th>
                                <th>Texto 1</th>
                                <th>Texto 2</th>
                                <th>Texto 3</th>
                                <th>Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="bodyListeTextoTextoTexto"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>

</div>
</f:form> 
