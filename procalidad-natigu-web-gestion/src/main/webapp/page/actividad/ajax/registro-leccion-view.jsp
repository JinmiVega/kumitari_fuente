<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item" style="display: none;">
		<a class="nav-link" id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="true">Registro de lecci&oacute;n</a>
	</li>
	 <li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="false">Listado del material</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" id="base-tab44" data-toggle="tab" aria-controls="tab44" href="#tab44" aria-expanded="false">Registro del material</a>
	</li>
	 <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="false">Ejercicios del material</a>
	</li>

</ul>
<div class="tab-content px-1 pt-1 row">
	<div role="tabpanel" class="tab-pane" id="tab42" aria-expanded="true" aria-labelledby="base-tab42">
		<f:form class="form" id="frmRegLeccion"  method="post" >
			<input type="hidden" id="idLeccion" />
			<div class="form-body">
			        <div class="col-xs-12">
			          <div class="form-group">
			            <label id="titulo" for="timesheetinput1">Nombre de la Lecci&oacute;n</label>
			            <div class="position-relative ">
			              <input type="text" id="ejercicioTxtTitulo" class="form-control" name="employeename" value="${unidadLeccion.nombre}">
			            </div>
			          </div>
	
			        </div>
	
					<div class="col-xs-3">
						<div class="form-group">
						    <label >Situaci&oacute;n</label>
						      <input type="hidden" id="txtLeccionSituacion" class="form-control" name="employeename" value="${unidadLeccion.situacion.codigoRegistro}">
						  	<f:select id="cboLeccionSituacion" path="situacion.codigoRegistro" itemValue="codigoRegistro" itemLabel="codigoRegistro"   class="form-control">
						        <option value="0">Borrador</option>
						        <option value="1">Publicado</option>
						        <option value="2">Proceso</option>
						    </f:select>
						</div>
					</div>
					<div class="col-xs-12">
						<div class="form-group text-right">
						  <button type="button" id="btn_guardar_ejercicio" onclick="grabarLeccion()" class="btn btn-outline-info btn-min-width">
						    <i class="fa fa-floppy-o"></i> Guardar
						  </button>
						</div>
					</div>
	    	</div>
    	</f:form>
	</div>
	
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="row">
	      	<div class="col-xs-12">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th width="40" class="text-xs-center">N°</th>
                                <th width="100" >Tipo de material</th>
                                <th>T&iacute;tulo</th>
                                <th width="111" >Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyTipoMaterial">
                            
                        </tbody>
                    </table>
                </div>
	      	</div>	  
	      </div>
	</div>

	 <div class="tab-pane" id="tab44" aria-labelledby="base-tab44">
	 <f:form class="form" id="frmRegMaterial"  method="post" action=""  >
	 	<input type="hidden" id="idMaterial" />
		<div class="row">
    	<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
					    <label >Tipo de material<span class="required"> *</span></label>
					    <input type="hidden" id="txtTipoMaterial" value="${leccionMaterialBean.situacionLeccionMaterial.codigoRegistro}" />
					  	<select id="modalCboTipoMaterial" onchange="obtenerTipoMaterial()" name="leccionMaterialBean.situacionLeccionMaterial.codigoRegistro" class="form-control input-sm">
					        <option value="0" selected="selected">Seleccionar</option>
					        <option value="1">Texto, audio, imagen</option>
					        <option value="2">Texto, audio</option>
					        <option value="6">Texto, imagen</option>
					        <option value="3">Texto</option>
					        <option value="4">Sin material</option>
					        <option value="5">Tarea</option>
					    </select>
					</div>
				</div>
				<div class="col-xs-6">
					<div class="form-group">
		         		<label for="timesheetinput7">Tipo de documento</label>
		         		<select id="cbTipoDoc" class="form-control input-sm">
		         			<option value="0">Seleccione</option>
		         		</select>
		        	</div>
	        	</div>
	        	<div class="col-xs-12" >
					<div class="form-group">
					    <label >Competencia</label>
						<div class="position-relative has-icon-left">
						  <input id="txtComprensionMat" maxlength="200" value="${leccionMaterialBean.comprension}" class="form-control input-sm" />
						  <div class="form-control-position">
						    <i class="ft-file"></i>
						  </div>
						</div>
					</div>
				</div>
				<div class="col-xs-12" >
					<div class="form-group">
					    <label >Indicaci&oacute;n</label>
						<div class="position-relative has-icon-left">
						  <input id="txtIndicacion" maxlength="500" value="${leccionMaterialBean.indicacion}" class="form-control input-sm" />
						  <div class="form-control-position">
						    <i class="ft-file"></i>
						  </div>
						</div>
					</div>
				</div>
				
				<div id="idDivIndicExtra" class="col-xs-12" style="display: none;">
					<div class="form-group">
					    <label >Indicaci&oacute;n de texto</label>
						<div class="position-relative has-icon-left">
						  <input id="txtIndExtraMat" maxlength="500" value="${leccionMaterialBean.indicacionExtra}" class="form-control input-sm" />
						  <div class="form-control-position">
						    <i class="ft-file"></i>
						  </div>
						</div>
					</div>
				</div>
				
				<div class="col-xs-12" id="contentAllTitulo">
					<div class="form-group">
					    <label>Situaci&oacute;n comunicativa</label><br /><br />
					    <div class="position-relative" id="bodyDescripcionMaterial">
			      			<div class="" id="descripcionMaterial"></div>
						</div>
						<!-- <div class="position-relative has-icon-left">
						  <input id="descripcionMaterial"  value="${leccionMaterialBean.descripcionMaterial}" class="form-control input-sm" />
						  <div class="form-control-position">
						    <i class="ft-file"></i>
						  </div>
						</div> -->
					</div>
				</div>
				<div class="col-xs-12" id="contentAllImagen">
					<label>Recomendaciones al subir la imagen</label>
					<ol>
						<li>Formato recomendado (.jpg, .jpeg, .png)</li>
						<li>El nombre de la imagen debe ser <= 45 caracteres</li>
						<li>Tamaño máximo hasta 5 MB</li>
					</ol>
					<fieldset class="form-group">
					    <label for="basicInputFile">Imagen<span class="required"> * <i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 50 megabytes, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 50 megabytes" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></span></label>
					    <input type="file" multiple accept="image/*" class="form-control-file"
					     id="basicInputFile" name="basicInputFile[]" onchange="handleFileSelect(event);" style="display:none">
					     <input type="hidden" value="0" id="tieneImagen" />
					    <div id="bodyImagen" onclick="obtenerImagen();" style="cursor: pointer;">
							<c:choose>
						        <c:when test="${not empty leccionMaterialBean.nombreImagen}">
						        <input type="hidden" value="1" id="hiddenImg" />
						        	<div id="contentImg"><label for=""><img src="${pageContext.request.contextPath}/material/${leccionMaterialBean.nombreImagen}" alt="${leccionMaterialBean.nombreImagen}" title="${leccionMaterialBean.nombreImagen}" style="cursor: pointer;max-width:30%" class="thumb2"></label>
						        	</div>
						        </c:when>
						        <c:otherwise>
						        	<input type="hidden" value="0" id="hiddenImg" />
						        	<div id="contentImg">
						        		<label for=""><img src="../assets/img/usar_imagen.jpg" alt="element 01" class="img-fluid" style="cursor: pointer;max-width:30%"></label>
						        	</div>
						        </c:otherwise>
					        </c:choose>
							<!-- <label for=""><img src="../assets/img/usar_imagen.jpg" onclick="obtener_imagen();" alt="element 01" class="img-fluid" style="cursor: pointer;"></label> -->
							
						</div> 
					</fieldset>
				</div>
				<div class="col-xs-12"  id="contentAllAudio">
					<label>Recomendaciones al subir el audio</label>
					<ol>
						<li>Formato recomendado (.mp3)</li>
						<li>El nombre de la imagen debe ser <= 150 caracteres</li>
						<li>Tamaño máximo hasta 5 MB</li>
					</ol>
					<fieldset class="form-group">
					    <label for="basicInputAudio">Audio<span class="required"> * <i title="Formato aceptado mp3 - Tamaño máximo permitido hasta 50 megabytes, el nombre no debe contener espacios" data-original-title="Formato aceptado mp3 - Tamaño máximo permitido hasta 50 megabytes" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></span></label>
					    <input type="file" class="form-control-file" accept="audio/*" id="basicInputAudio" 
					    		name="basicInputAudio[]" style="display:none" onchange="handleAudioSelect(event)">
					    <br />
					    <img src="../assets/img/usar_audio.jpg" width="36" onclick="obtenerAudio()" class="img-fluid"  style="cursor: pointer;">
					    <span id="spanNombreMp3"></span>
					    <input type="hidden" value="0" id="tieneAudio" />
					    <c:choose>
							<c:when test="${not empty leccionMaterialBean.rutaAudio}">
								<input type="hidden" value="1" id="hiddenAud" />
								
								<div id="contentAudio">
									<audio id="audioAct02"  preload="auto" controls>
										<source src="${pageContext.request.contextPath}/material/${leccionMaterialBean.rutaAudio}" 
										id="audioSourceAct02" type="audio/mp3" title="${leccionMaterialBean.rutaAudio}" />
										<p>Tu navegador no implementa el elemento audio</p>
									</audio> 
								</div>
							</c:when>
							<c:otherwise>
								<input type="hidden" value="0" id="hiddenAud" />
								<div id="contentAudio">
								</div>
							     <label for=""></label>
							</c:otherwise>
						 </c:choose>
					</fieldset>
				</div>
				<div class="col-xs-12" id="contentAllContexto">
					<div class="form-group">
					    <label >Contexto <span class="required"> *</span></label>
					   <br /><br />
					    <div class="position-relative" id="bodyParrafo">
			      
						         <div class="" id="ejercicioTxtDescripcion"></div>
						      </div>
						<!-- <div class="position-relative has-icon-left">
						  <textarea id="ejercicioTxtDescripcion" value="${leccionMaterialBean.contexto}" rows="3" class="form-control" name="notes"></textarea>
						  <div class="form-control-position">
						    <i class="ft-file"></i>
						  </div>
						</div> -->
					</div>
					
				</div>
				<div class="col-xs-12">
					<div class="form-group">
					    <label >Reflexi&oacute;n gramatical</label>
					    <br /><br />
					    <div class="position-relative" id="bodyEjercicioTxtComentario">
			      			<div class="" id="ejercicioTxtComentario"></div>
						</div>
						<!-- <div class="position-relative has-icon-left">
						  <textarea id="ejercicioTxtComentario" rows="2" class="form-control input-sm" name="notes">${leccionMaterialBean.comentario}</textarea>
						  <div class="form-control-position">
						    <i class="ft-file"></i>
						  </div>
						</div> -->
					</div>
				</div>
				<div class="col-xs-12">
					<div class="form-group text-right">
					 <button type="button" id="btn_nuevo_ejercicio" onclick="nuevoMaterial()" class="btn btn-outline-info btn-min-width">
					    <i class="fa fa-file-o"></i> Nuevo
					  </button>
					  <button type="button" id="btn_guardar_ejercicio" onclick="grabarMaterial()" class="btn btn-outline-info btn-min-width">
					    <i class="fa fa-floppy-o"></i> Guardar
					  </button>
					</div>
					</div>
		      </div>
    	</div>
    	</div>
	      
		</f:form>
	</div>
	 <div class="tab-pane" id="tab43" aria-labelledby="base-tab43">
		<div class="col-xs-12">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped table-hover zero-configuration" id="tableListaEjercicios">
                        <thead>
                            <tr>
                                <th width="40" class="text-xs-center">N°</th>
                                <th width="350" >Ejercicio</th>
                                 <th width="400" >Tipo de ejercicio</th>
                                 <th width="70" >Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyListaEjercicios">
                            
                        </tbody>
                    </table>
                </div>
	      	</div>
	 </div>
</div>
<script type="text/javascript" charset="utf-8">
	
	function obtenerAudio(){
		document.getElementById("basicInputAudio").click();
	}
	function obtenerImagen(){
		document.getElementById('basicInputFile').click();
	}
	

	function handleAudioSelect(evt){
		$("#hiddenAud").val("0");
		var fullPath = document.getElementById('basicInputAudio').value;
		if (fullPath) {
		    var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
		    var filename = fullPath.substring(startIndex);
		    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
		        filename = filename.substring(1);
		    }
		    $("#tieneAudio").val("1");
			$("#spanNombreMp3").text(filename);
		}
	}
	function handleFileSelect(evt){
		$("#hiddenImg").val("0");
		var files = evt.target.files; // FileList object
 	    for (var i = 0, f; f = files[i]; i++){
	 	    if (!f.type.match('image.*')){
	 	        continue;
	 	    }
	 	    var reader = new FileReader();
	 	    reader.onload = (function(theFile){
	 	    	return function(e){
	 	        	document.getElementById("contentImg").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	 	        };
			})(f);
	 	   	reader.readAsDataURL(f);
 	    }
 	   $("#tieneImagen").val("1");
	}
	
	$('#tbodyTipoMaterial').sortable({
		start: function(event, ui) {
			ui.item.startPos = ui.item.index();
		},
		update: function(event, ui) {
			$('#tbodyTipoMaterial  > tr').each(function(index) {
				//console.log($(this).children().attr("id")+"-"+index);
				 actualizarOrdenMaterialLeccion($(this).children().attr("id").substr(14),index);
				 $(this).find("td.td").text(index+1);
			});
			//console.log("terminó")
			//buscarLeccionMaterial();
			//return false;
		 }
	});
	
	$('#tbodyListaEjercicios').sortable({
		start: function(event, ui) {
			ui.item.startPos = ui.item.index();
		},
		update: function(event, ui) {
			$('#tbodyListaEjercicios  > tr').each(function(index) {
				//console.log($(this).children().attr("id").substr(19)+"-"+index);
				actualizarOrdenEjercicioMaterial($(this).children().attr("id").substr(19),index);
				$(this).find("td.td").text(index+1);
			});
			//console.log("terminó")
			//buscarLeccionMaterial();
			//return false;
		 }
	});
	
	function actualizarOrdenEjercicioMaterial(liCodEjer,liNewOrde){
		$.ajax({
			type : "POST",
			url : $('#contextPathUrl').val() +"/cargaMaterialController/actualizarOrdenEjercicioMaterial",
			data : {liCodEjer:liCodEjer,liNewOrde:liNewOrde},
			success : function(data){
				//console.log("rpta:" + data);
			},
			error : function(){
				//console.log("ERROR: ");
			}
		});
	
	}
	
	
</script>

