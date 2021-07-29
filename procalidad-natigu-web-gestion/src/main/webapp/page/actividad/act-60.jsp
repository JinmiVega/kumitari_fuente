<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item"> 
		<a class="nav-link" onclick="mostrarTextoPalabraEncerredaxTEM();habilitarWYSIWYG('contentParrafo');$('.note-editor').addClass('form-control');" id="base-tab42" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="false">Texto</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listadoDePalabraEncerradaxTexto();" id="base-tab43" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li> 
	     
</ul>  
<f:form class="form" id="frmregistromodalactividad" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body"> 
	        <div class="col-xs-7">
	          <div class="form-group">
	          	<input type="hidden" id="idEjercicio"  value="0" />
	          	
	          	<%-- ${ejercicio.tituloEjercicio}  onclick="mostrarOracionxTEM(130)"  onclick="listadoPreguntaActividad();"--%> 
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
			  <button type="button" id="btn_nuevo" onclick="nuevo()" class="btn btn-outline-info btn-min-width">
					<i class="fa fa-file-o"></i> Nuevo
					</button>
			      <button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio();" class="btn btn-outline-info btn-min-width">
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
 



	<div  role="tabpanel" class="tab-pane " id="tab43" aria-expanded="true" aria-labelledby="base-tab43">
		<div class="form-body"> 
	        <div class="col-xs-12"> 
	        <div class="form-group"> 
	            <label   for="timesheetinput1">T&iacute;tulo del Texto</label>
	            <div class="position-relative ">
	              <input type="text" id="idoraciontitulo" class="form-control" name="employeename" > 
	            </div>
	            <div class="position-relative ">
	              <strong style="color:red">* Las palabras incorrectas se pondrán de la siguiente manera, ejemplo: %1%. Luego el n&uacute;mero ir&aacute; aumentando de la posici&oacute;n donde se encuentre la palabra.</strong>
	            </div>
	          </div> 

	          <div class="form-group">
	          <input type="hidden" id="idoraciondesc"  value="0" />
			     <br />
			      <div class="" id="bodyParrafo">
			         <div class="" id="contentParrafo"></div>
			      </div>
		       </div>
		       <div class="form-group" style="display: none;">
				    <label >Comentario</label>
					<div class="position-relative has-icon-left">
					  <textarea id="TxtComentario1" rows="2" class="form-control input-sm" name="notes"> </textarea>
					  <div class="form-control-position">
					    <i class="ft-file"></i>
					  </div>
					</div>
				</div> 
			  <div class="form-group text-right mb-1">
			      <button type="button" id="btn_guardar_ejercicio11" onclick="guardarTextoPalabraEncerrada();" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-floppy-o"></i> Guardar
			      </button>
			  </div>
	        </div> 
	         
	      </div>
	</div>  
	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42"> 
		<input type="hidden" id="idPregunta" value=""/>  
		<input  type="hidden" id="txtPreguntaDescripcionDet"  value="0"/>
		
		<div class="row"> 
            <div class="form-group col-md-4"> 
            	<label for="txtnumeroespacioEn3" style="margin-top:5px">N&uacute;mero de espacio:</label> 
            	<input type="text" id="txtnumeroespacioEn3" class="form-control" onkeypress="return valida(event)" maxlength="8" name="txtnumeroespacioEn3"  onpaste="return false;"> 
          	</div> 
          	<div class="form-group col-md-4"> 
            	<label for="idespacio" style="margin-top:5px">Infinitivo:</label>
             	<input type="text" class="form-control" id="idespacio" class="form-control" name="idespacio" maxlength="1000">
          	</div>
          	<div class="form-group col-md-4"> 
            	<label for="txtPalabraRpta" style="margin-top:5px">Imperativo:</label> 
             	<input type="text" class="form-control" id="txtPalabraRpta" class="form-control" name="txtPalabraRpta" maxlength="500"> 
          	</div>
	    </div>
	    
	    <div class="row">
	    	<div class="col-xs-12 text-right">
			  <button type="button" id="btn_nuevo" onclick="nuevoAlternativasPalabraEncerrada();" class="btn btn-outline-info btn-min-width">
				<i class="fa fa-file-o"></i>   Nuevo
			  </button>
		      <button type="button" class="btn btn-outline-info btn-min-width" id="btn-guardar-oracionPed" onclick="enviarAlternativasTextoPalabraEncerrada(1)">
		        <i class="fa fa-floppy-o"></i> Guardar
		      </button>
		    </div>
	    </div> 
			  
		<div class="row" style="margin-top: 20px;">
			<div class="col-xs-12">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped"> 
						<thead>
                            <tr>
                                <th width="60">N°</th> 
                                <th>Infinitivo</th>
                                <th>Imperativo</th> 
                                <th width="110">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="idTablaEspaciosListado27APE"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
		</div>	      
	</div> 	       
	 
</div>
</f:form>