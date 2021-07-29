<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%> 
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
<script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
	<%-- 
	<li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> --%>
</ul>
<f:form class="form" id="frmRegistroPalabrasDesordenadas" method="post" action="">
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
							<input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename"  value="${ejercicio.tituloEjercicio}">
						</div>
					</div>	
				<div class="form-group text-right mb-1">					
					<button type="button" id="btn_nuevo" onclick="nuevo()" class="btn btn-outline-info btn-min-width">
					<i class="ft-plus"></i> Nuevo
					</button>
					<button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
					<i class="ft-search"></i> Guardar
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
	<%--        <div class="col-xs-5">
	          <img src="../assets/img/usar_imagen.jpg" alt="element 01" class="img-fluid" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;">
	        </div>
	        <div class="col-xs-7">
	          <div class="form-group">
	            <label for="timesheetinput1">T&iacute;tulo</label>
	            <div class="position-relative has-icon-left">
	              <input type="text" id="timesheetinput1" class="form-control" name="employeename">
	              <div class="form-control-position">
	                <i class="ft-user"></i>
	              </div>
	            </div>
	          </div>
	          <div class="form-group">
				<img src="../assets/img/usar_audio.jpg" width="36" class="img-fluid" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;">
	          </div>
	          
			  <div class="form-group text-right mb-1">
			      <button type="button" class="btn btn-outline-info btn-min-width">
			        <i class="ft-search"></i> Guardar
			      </button>
			  </div>
	        </div>
	        --%> 
	      </div>
	</div>
	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42">
<div class="row">
	<div class="col-xs-6">

	    <div class="form-group">
	    <label for="timesheetinput7">Tiempo para resolverlo</label>
	    <div class="position-relative has-icon-left">
	    <textarea id="timesheetinput7"   rows="2" class="form-control input-sm" name="notes"></textarea>
	    <div class="form-control-position">
	    <i class="ft-file"></i>
	    </div>
	    </div>
	    </div>

	    <div class="row">
	    	<div class="col-xs-5">
	    	<label for="nombreUnidadLec">Letra </label>
	    	</div>
	    	<div class="col-xs-5">
	    	<label for="nombreUnidadLec">N&uacute;mero de orden</label>	
	    	</div>
	    	<div class="col-xs-2">
	    	<button type="button" id="nuevoInput" class="btn btn-outline-info btn-min" onclick="crearInput()"><i class="ft-plus"></i></button>	
	    	</div>
	    </div>
	    <div class="row">
	    </div>

	</div>
	<div class="col-xs-6">
		
	</div>
</div>		
		
		<%--
			<div class="row">
	        <div class="col-xs-6">
	          <div class="form-group">
	            <label for="timesheetinput7">Tiempo para resolverlo</label>
	            <div class="position-relative has-icon-left">
	              <textarea id="timesheetinput7"   rows="2" class="form-control input-sm" name="notes"></textarea>
	              <div class="form-control-position">
	                <i class="ft-file"></i>
	              </div>
	            </div>
	          </div>
	           
			    <div class=" col-md-7">
			    <label for="nombreUnidadLec">Letra 1</label>
			     </div> 
			     <div class=" col-md-3">
			    <label for="nombreUnidadLec">Nº Orden</label>
			     </div> 

                 <div class="form-group col-md-2 "> 	           		
				      <button type="button" class="btn btn-outline-info btn-min">
				        <i class="ft-plus"></i></button>
			 		 </div>
			       <div class="form-group col-md-6">
				<fieldset>
					<div class="input-group input-group-xs">
						<span class="input-group-addon" id="radio-addon1">
							<label class="custom-control custom-radio inline">
								<input type="radio" name="rpst" class="custom-control-input">
								<span class="custom-control-indicator"></span>
							</label>
						</span>
						<input type="text" class="form-control" aria-describedby="radio-addon1">
					</div>
				</fieldset>  
	          </div>

	          



			 	<div class="form-group col-md-6">
			    
				<fieldset>
					<div class="input-group input-group-xs">
						<span class="input-group-addon" id="radio-addon1">
							<label class="custom-control custom-radio inline">
								<input type="radio" name="rpst" class="custom-control-input">
								<span class="custom-control-indicator"></span>
							</label>
						</span>
						<input type="text" class="form-control" aria-describedby="radio-addon1">
					</div>
				</fieldset>
	          </div>
	          <div class="form-group col-md-6">
			    
				<fieldset>
					<div class="input-group input-group-xs">
						<span class="input-group-addon" id="radio-addon1">
							<label class="custom-control custom-radio inline">
								<input type="radio" name="rpst" class="custom-control-input">
								<span class="custom-control-indicator"></span>
							</label>
						</span>
						<input type="text" class="form-control" aria-describedby="radio-addon1">
					</div>
				</fieldset>
	          </div>
	          <div class="form-group col-md-6">
			    
				<fieldset>
					<div class="input-group input-group-xs">
						<span class="input-group-addon" id="radio-addon1">
							<label class="custom-control custom-radio inline">
								<input type="radio" name="rpst" class="custom-control-input">
								<span class="custom-control-indicator"></span>
							</label>
						</span>
						<input type="text" class="form-control" aria-describedby="radio-addon1">
					</div>
				</fieldset>
	          </div>

			  <div class="form-group text-right mb-1">
			      <button type="button" class="btn btn-outline-info btn-min-width">
			        <i class="ft-search"></i> Guardar
			      </button>
			  </div>
	        </div>
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>   
                                <th width="0.5">N°</th>
                                
                                <th width="1.5">Letras faltantes</th>
                                <th width="2">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody>   
                            <tr> 
                                <td>1</td>
                                
                                <td>L</td>
                                 <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                            <tr>
                                <td>2</td>
                               
                                <td>A</td>
                                <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                            <tr>
                                <td>3</td>
                               
                                <td>A</td>
                                <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                          
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>
	      
	    

	</div>
	<%-- 
	<div class="tab-pane" id="tab43" aria-labelledby="base-tab43">
		<p>Sugar plum tootsie roll biscuit caramels. Liquorice brownie pastry cotton candy oat cake fruitcake jelly chupa chups. Pudding caramels pastry powder cake soufflÃ© wafer caramels. Jelly-o pie cupcake.</p>
	</div>
</div>  --%>
</f:form>

