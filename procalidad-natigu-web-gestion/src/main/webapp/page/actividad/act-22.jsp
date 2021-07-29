<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" onclick="limpiar();" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio </a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarParrafoCabecera();habilitarWYSIWYG('parrafo');$('.note-editor').addClass('form-control');"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
</ul>

<f:form class="form" id="frmregistromodalactividadParrafo" method="post" action="">
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
	<div class="col-xs-6">
	<div class="form-group">
	<input id="idOrdenParrafoCabecera" type="hidden" value="0"/>
	<label for="tituloActividad">T&iacute;tulo de actividad</label>
	<input type="text" id="tituloActividad" class="form-control" required name="tituloActividad" maxlength="255">
	<br>
	<div class="form-group text-right mb-1" >
	<!--  
	<button type="button" id="btn_nuevo_parrafo_cabecera" onclick="nuevo_TituloCabecera()" class="btn btn-outline-info btn-min-width">
	<i class="fa fa-file-o"></i> Nuevo
	</button>-->	
	<button type="button" class="btn btn-outline-info btn-min-width" id="btnTituloParrafoCabecera" onclick="validarParrafoCabecera()" >
	<i class="fa fa-floppy-o"></i> Guardar
	</button>
	</div>
	</div>
	</div>
	<div class="col-xs-6">

	
	<div class="table-responsive">
    <label for="comentarioParrafo">Comentario</label>
    <div class="position-relative has-icon-left">
	    <textarea id="comentarioParrafo" rows="4" class="form-control input-sm" name="notes" maxlength="4000"></textarea>
	    <div class="form-control-position">
	    <i class="ft-file"></i>
	    </div>
    </div> 
			      
	<!-- 
	<table class="table table-bordered table-striped">
	<thead>
	 <tr>
	    <th width="30">N°</th>
	    <th>T&iacute;tulo</th>
	    <th width="107">Acci&oacute;n</th>
	</tr>
	</thead>
	<tbody id="idListadoParrafoCabecera"> 
	</tbody>
	</table>	-->
	</div>	 
	
	</div>
	</div>		
		
		
		<hr>
		
		<div class="row">
		
			<div class="col-xs-6">
				<table id="tblPregunta" class="table table-striped table-bordered zero-configuration">
					<thead>
						<tr>
							<div class="form-group" style="margin-bottom: 8px;">
								<label >P&aacute;rrafo*</label> 
							</div>
							<div class="form-group">
							<input id="idOrdenarParrafo" type="hidden" value="0"/>
							 <label for="timesheetinput7" style="visibility:hidden">P&aacute;rrafo</label> 
								<div class="position-relative" id="bodyParrafo">
			      
						         <div class="" id="parrafo"></div>
						      </div>
								<!--  <div class="position-relative has-icon-left">
								<textarea id="parrafo" rows="5" class="form-control"  name="notes"></textarea>
									<div class="form-control-position">
									<i class="ft-file"></i>
									</div>
								</div>-->
							</div>	
						</tr>	
					</thead>	
				<tbody >
				<tr>
				<div class="form-group">
					<div class="col-md-12">
						<label for="nombreUnidadLec">N&uacute;mero de orden*</label> 
						<div class="input-group input-group-sm ">
							<input id="numeroOrdenParrafo" name="numeroOrdenParrafo" onkeypress="return valida(event)" type="text" class="form-control" maxlength="8" onpaste="return false;" >
						</div>

					</div>	
				
				</div>
				</tr>	
				
				</tbody>
				<tfoot>
				<tr >  &nbsp;&nbsp;&nbsp;
				</tr>
				
					<div class="form-group text-right mb-1" >
						<button type="button" id="btn_nuevo_parrafo" onclick="nuevo_parrafo()" class="btn btn-outline-info btn-min-width">
						<i class="fa fa-file-o"></i> Nuevo
						</button>						
						<button type="button" id="btnGuardarParrafo" class="btn btn-outline-info btn-min-width" onclick="validarParrafo()" >
						<i class="fa fa-floppy-o"></i> Guardar
						</button>
					</div>
				</tfoot>
				</table>	
			</div>	
			<div class="col-xs-6">
					<div class="table-responsive">
				        <table class="table table-bordered table-striped">
				                       
						<thead>
				            <tr>
				                <th width="30">N°</th>
				                <th>P&aacute;rrafo</th>
				                <th width="107">Acci&oacute;n</th>
				            </tr>
				         </thead>
				                <tbody id="idBodyListadoParrafo">
				                </tbody>
				         </table>
				    </div>				
			</div>
		</div>
	</div>

</div>
</f:form>