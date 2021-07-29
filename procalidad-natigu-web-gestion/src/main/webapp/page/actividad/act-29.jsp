<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" onclick="limpiartab2Arras();limpiartab3Arras()"  id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item"> 
		<a class="nav-link" onclick="mostrarArrastrarxTEM();habilitarWYSIWYG('contentParrafo');$('.note-editor').addClass('form-control');" id="base-tab42" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Oraci&oacute;n</a>
	</li>
	<li class="nav-item">
		<a class="nav-link"     onclick="listadoRespxOracionGeneral();habilitarWYSIWYG('oracionxArrast');$('.note-editor').addClass('form-control');"   id="base-tab43" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li> 
	     
</ul>  
<f:form class="form" id="frmregistromodalactividad" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="row"> 
	        <div class="col-xs-7">
	          <div class="form-group">
	          	<input type="hidden" id="idEjercicio"  value="0" />
	          	
	          	<%--   --%> 
	            <label id="titulo" for="timesheetinput1">Indicaci&oacute;n*</label>
	            <div class="position-relative ">
	              <input type="text" id="ejercicioTxtTitulo" class="form-control" maxlength="1200" name="employeename" > 
	            </div>
	          </div>
	          
	          <div class="form-group">
					<label for="ejercicioTxtComprension">Comprensi&oacute;n</label>
					<div class="position-relative ">
						<input type="text" id="ejercicioTxtComprension" class="form-control" name="ejercicioTxtComprension" maxlength="1200" value="${ejercicio.comprension}">
					</div>
			    </div> 
			    
			   <%--  <div class="form-group">
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
			  <button type="button" id="btn_nuevo_ejercicio" onclick="nuevoMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
					<i class="fa fa-file-o"></i> </i> Nuevo
					</button>
			      <button type="button"  onclick="grabarMaterialTipoEjercicio();" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-floppy-o"></i> Guardar
			      </button>
			  </div>
	        </div> 
	        <div class="col-xs-5">
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
 



	<div  role="tabpanel" class="tab-pane " id="tab43" aria-expanded="true" aria-labelledby="base-tab43">
		<div class="form-body"> 
	        <div class="col-xs-10"> 
	        <div class="form-group"> 
	            <label   for="timesheetinput1">T&iacute;tulo de la oraci&oacute;n</label>
	            <div class="position-relative ">
	              <input type="text" id="tituloArrast" class="form-control" name="employeename" maxlength="255" value="${ejercicio.tituloEjercicio}"> 
	            </div>
	          </div> 
			<label for="timesheetinput7" >Oraci&oacute;n : <span style="color:#FF0000;font-weight: bold;" > (Colocar entre porcentajes el n&uacute;mero de espacio en blanco, además solo deben ser n&uacute;meros enteros del 1-9. Ejemplo: %1%)</span> </label>
			 
	          <div class="form-group">
	          <input type="hidden" id="idArrasOra"  value="0" />
			     <!-- <label for="timesheetinput7">Oraci&oacute;n</label> -->
			        <br />
			      <div class="" id="bodyParrafo">
			       <!-- <textarea id="OracionTxtArea" rows="9" class="form-control" name="notes"> </textarea>
			        <div class="form-control-position"> <i class="ft-file"></i>
			        </div> -->
			         <div class="" id="contentParrafo"></div>
			      </div>
		       </div>
			  <div class="form-group text-right mb-1"> 
			  	 <!--  <button type="button" id="Modifbtn"  onclick="desModi()" class="btn btn-outline-info btn-min-width" style="margin-top:10px">
					<i class="fa fa-pencil"></i>   Modificar
					</button> -->
			      <button type="button" id="GuardarBtn" onclick="guardarArrastrar();" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-floppy-o"></i> Guardar
			      </button>
			  </div>
	        </div> 
	         
	      </div>
	</div>  
	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42"> 
		<div class="row">
			<input type="hidden" id="idPregunta" value=""/>  
		    <input  type="hidden" id="txtPreguntaDescripcion"     value="descif"/> 
	        <div class="col-xs-7 row"> 
	        	<div class="form-group"> 
		           <div class="position-relative">
		           	 <div class="col-md-9"><label   for="timesheetinput1" style="margin-top:5px">N&uacute;mero de orden :</label> </div>
		            <div class="col-md-3">
		                 <input   type="text" id="inorden" onkeypress="return valida(event)" class="form-control" name="employeenamed"  maxlength="1" onpaste="return false;" style="padding-right: 12px;"> 
		            </div>
		           </div>
		          </div> 
				<br /><br />
			    <div class="form-group"> 
			       <input type="hidden" id="idoracionxArrast"  value="0" />
				     <label for="timesheetinput7">Oraci&oacute;n</label>
				     <br />
				     <div class="" id="bodyParrafo2">
		       
		        		 <div class="" id="oracionxArrast"></div>
		      		</div>
				     <!--  <div class="position-relative has-icon-left">
				       <textarea id="oracionxArrast" rows="5" class="form-control" name="notes"> </textarea>
				        <div class="form-control-position"> <i class="ft-file"></i>
				        </div>
				   	  </div>--> 
			    </div> 
			      
				  <div class="form-group text-right mb-0 col-md-12" >
				  	<button type="button" id="btn_nuevo3" onclick="nuevoTab3Arras()"  class="btn btn-outline-info btn-min-width" style="margin-top:10px">
						<i class="fa fa-file-o"></i>   Nuevo
					</button>
				      <button type="button"  onclick="guardarRespuestaArra();" id="btn-guardar-respuesta" class="btn btn-outline-info btn-min-width"   style="margin-top:10px">
				        <i class="fa fa-floppy-o"></i> Guardar
				      </button>
				  </div>
					
	        </div> 
	        <div class="col-xs-5">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped"> 
						<thead>
                            <tr>
                                <th width="60">N°</th> 
                                <th> N&uacute;mero de espacio </th> 
                                <th width="78">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="idTablaArrastrarOracion"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>
	 
</div>
</f:form> 