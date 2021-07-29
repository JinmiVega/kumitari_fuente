<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" onclick="limpiarDocCab();" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio </a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarParrafoCabeceraDoc(1);habilitarWYSIWYG('parrafo');$('.note-editor').addClass('form-control');"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
</ul>

<f:form class="form" id="frmregistromodalactividadParrafoDoc" method="post" action="">
<div class="tab-content px-1 pt-1">

	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body">
			<div class="row">
			
				<div class="col-xs-6">
				
					<div class="form-group">
						<input type="hidden" id="idEjercicio" value="0"/>
						<input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">
					<label id="titulo" for="timesheetinput1">T&iacute;tulo</label>
						<div class="position-relative ">
							<input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${ejercicio.tituloEjercicio}">
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
				                <th>T&iacute;tulo</th>
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
					<input type="text" id="tituloActividad" class="form-control" required name="tituloActividad">
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
					    <textarea id="comentarioParrafo" rows="4" class="form-control input-sm" name="notes"></textarea>
					    <div class="form-control-position">
					    	<i class="ft-file"></i>
					    </div>
				    </div>	
				</div>	 
			</div>
		</div>		
		<hr />
		<div class="row">
			<div class="col-xs-6">
				<div class="form-group">
					<input id="idOrdenarParrafo" type="hidden" value="0"/>
					<label for="timesheetinput7" style="visibility:hidden">P&aacute;rrafo</label>
					 <div class="" id="bodyParrafo">
				         <div class="" id="parrafo"></div>
				      </div>
					<!-- <div class="position-relative has-icon-left">
						<textarea id="parrafo" rows="5" class="form-control"  name="notes"></textarea>
						<div class="form-control-position">
							<i class="ft-file"></i>
						</div>
					</div> -->
				</div>	
				<div class="form-group" style="display:none">
					<div class="col-md-12">
						<label for="nombreUnidadLec">N&uacute;mero de orden</label> 
						<div class="input-group input-group-sm ">
							<input id="numeroOrdenParrafo" name="numeroOrdenParrafo"  type="text" class="form-control" onpaste="return false;">
						</div>

					</div>	
				
				</div>
				<div class="form-group">
					<div class="col-md-12 row">
						<div class="input-group input-group-sm " style="display:inline-block !important;width:20px">
							<input id="ordennarParrafo" name="ordennarParrafo" value="0"  type="checkbox" >
						</div>
						<label for="Ordenar" style="display:inline-block !important">Arrastrar parrafo</label> 
						

					</div>	
				
				</div>
				<div class="form-group text-right" >
					<button type="button" id="btn_nuevo_parrafo" onclick="nuevo_parrafoDoc()" class="btn btn-outline-info btn-min-width">
						<i class="fa fa-file-o"></i> Nuevo
					</button>						
					<button type="button" id="btnGuardarParrafo" class="btn btn-outline-info btn-min-width" onclick="validarParrafoDoc()" >
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
				                <th>P&aacute;rrafo</th>
				                <th width="85">Arrastrar</th>
				                <th width="85">Acci&oacute;n</th>
				            </tr>
				         </thead>
				         <tbody id="idBodyListadoParrafo" class="tBodyParrafoDoc">
				         </tbody>
					</table>
				</div>				
			</div>
		</div>
	</div>
</div>
</f:form>