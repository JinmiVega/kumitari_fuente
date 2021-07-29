<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>   
<%@ page contentType="text/html; charset=UTF-8" %>  
<%@page isELIgnored="false" %>

<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" onclick="limpiarActividad();" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item">
		<a class="nav-link"  onclick="mostrarTituloxTEM();listarRelacionCabecerav();"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
<!-- 		<a class="nav-link" onclick="listadoRelacionActividad()"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>   onclick="listarRelacionCabecerav()"
 -->	</li>
	<!-- <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> -->
</ul>

<f:form class="form" id="frmregistromodalactividad" method="post" action="">
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="row">
	         
	        <div class="col-xs-6">
	          <div class="form-group">
	          	<input type="hidden" id="idEjercicio" value="0"  />
	          	<%-- ${ejercicio.tituloEjercicio} --%>
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
	           
	          <div class="form-group">
	          <%--   <label for="timesheetinput7">Descripci&oacute;n</label>
	            <div class="position-relative has-icon-left">
	              <textarea id="ejercicioTxtDescripcion" rows="5" class="form-control" name="notes">${ejercicio.descripcionEjercicio}</textarea>
	              <div class="form-control-position">
	                <i class="ft-file"></i>
	              </div>
	            </div> --%>
	          
			<!--   <div class="form-group text-right mb-1">
			      
			  </div>	 -->          
	          
			 <div class="form-group text-right mb-1">
			  	  <button type="button" id="btn_nuevo_ejercicio" onclick="nuevoMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-file-o"></i> Nuevo
			      </button>
			      <button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterialTipoEjercicio()" class="btn btn-outline-info btn-min-width">
			        <i class="fa fa-floppy-o"></i> Guardar
			      </button>
			  </div>
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

	
	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42">
	
		<div class="row">
	        <div class="col-xs-6">
	        <table id="tblRelacionv">
	        	<thead>
	        		<tr>
	        			 <td colspan="4">
	        				<div class="form-group">
					          	<input type="hidden" id="idtitulocab" value="0"  />
					          	<%-- ${ejercicio.tituloEjercicio} --%>
					            <label id="" for="timesheetinput1">T&iacute;tulo*</label>
					            <div class="position-relative ">
					              <input type="text" id="relacionTitulov" class="form-control" name="employeename" value="">
					            </div>
					        </div> 
					        </td>

	        		</tr>
	        		<tr>
	        		<td colspan="4">
	        			
	        		<div class="form-group">
					    <label >Tipo de ejercicio*</label>
					    <input type="hidden" id="txtTipoEj"  />
					  	<select id="modalCboTipoEj" onchange="obtenerTipoEj()" class="form-control">
					        <option value="0" selected="selected">Seleccionar</option>
					        <option value="1">Imagen , texto </option>
					        <option value="2">Texto, texto</option>
					    </select>
					</div> 
					</td>
	        		</tr>
	        		<tr> 

	        			<td  colspan="1" align="center">
	        				<label id="td1" for="">Imagen* <i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label>
	        			</td>
	        			<td  colspan="2" align="center">
	        				<label id="td2" for="timesheetinput7">Palabra*</label>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td id="td3" colspan="2" align="center">
	        				<label for="">Texto 1*</label>
	        			</td>
	        			<td id="td4" colspan="2" align="center">
	        				<label for="timesheetinput7">Texto 2*</label>
	        			</td>
	        		</tr>
	        		
	        		
	        	</thead>
	        	<tbody>
	        		<tr>  
			          <td>
						 
							<!-- <input type="file" id="file0" name="files[]" multiple onchange="handleFileSelect_mini(event); " /> -->
							<input id="idRelacionDetalle1v" type="hidden" value="0"/>
							<input id="idNombreImg1v" type="hidden" value=""/>
							<f:input type="file" path="relacion.file" name="file1v" id="file1v" onchange="return validar_file('file1v','imgmas1v','${pageContext.request.contextPath}/material/','idRelacionDetalle1v')" value="" accept="image/png, .jpeg, .jpg, image/gif" style="display:none" />
							<div id="list1"   style="cursor: pointer; " class="form-group col-md-12"  >
                            	<c:choose>
                                	<c:when test="${not empty relacion.imagen}">
	                                    <label for=""><img id="imgmas1v" onclick="abrir_input('file1v')" src="${pageContext.request.contextPath}/material/${ejercicio.nombeImagen}" alt=""  class="img-fluid thumb-mini" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
	                                    <div id="fake-btn-1" style="display:none" class="form-input text-xs-center truncate"></div>
                                 	</c:when>
                                             	 
                            		<c:otherwise>
                                		<label for=""><img id="imgmas1v" src="../assets/img/usar_imagen.jpg" onclick="abrir_input('file1v')" alt="element 01" class="img-fluid thumb-mini" style="cursor: pointer;"></label> 
                                  	</c:otherwise>
                              	</c:choose>
                        	</div>
						 
			          </td>   
			          
			          <td>
						 
							 
					        <div class="position-relative has-icon-left" >
					        <textarea id="txtPalabra1v" rows="5" class="form-control input-sm" name="notes" maxlength="500"></textarea>
					        <div class="form-control-position">
					         
					        </div>
					        </div> 
			          </td> 
			          <td > 
					        <div class="position-relative has-icon-left" >
					        <textarea id="txtPalabra2v" rows="5" class="form-control input-sm" name="notes" maxlength="500"></textarea>
					        <div class="form-control-position">
					         
					        </div>
					        </div> 
			          </td>
		          </tr> 
	        	</tbody>
	        	<tfoot>
	        		<tr>
	        		 
		        		<td colspan="4">
		        			<div class="form-group text-right">
			      				<button type="button" id="btn_nuevo_actividad" onclick="IniciarActividad();limpiarActividad();" class="btn btn-outline-info btn-min-width">
			        			<i class="fa fa-file-o"></i> Nuevo
			      				</button>
			      				<button type="button" id="btn_guardar_actividad" class="btn btn-outline-info btn-min-width" 
			      				onclick="guardarTituloRelaVari()">
								<i class="fa fa-floppy-o"></i> Guardar
								</button>
			  				</div>
		        			<!-- <div class="form-group text-right mt-2" >      onclick="insertarRelacionCabecerav()">
								
							</div> -->
		        		</td>
	        		</tr>
	        	</tfoot>
	        </table>
			  
	        </div>
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
						<thead>
                            <tr>
                                <th width="30">N°</th>
                                <th>Palabra</th>
                                <th width="107">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="idTablaRelacionListado"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
		</div>
	</div>
</div>
</f:form> 