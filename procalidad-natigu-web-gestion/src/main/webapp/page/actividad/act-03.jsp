<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab44" data-toggle="tab" aria-controls="tab44" href="#tab44" aria-expanded="true">Actividad </a>
	</li>
<!-- 	<li class="nav-item"> -->
<!-- 		<a class="nav-link" id="base-tab46" data-toggle="tab" aria-controls="tab46" href="#tab46" aria-expanded="true">Traducci&oacute;n</a> -->
<!-- 	</li> -->
</ul>
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab44" aria-expanded="true" aria-labelledby="base-tab44">
		<div class="row">
	        <div class="col-xs-6">
				<div class="form-group">
		            <label for="timesheetinput7">T&iacute;tulo </label>
		            <div class="position-relative">
		              <input id="txtTitulo" class="form-control" type="text">
		            </div>
	          	</div>
	            <div class="row">  	
					<div class="form-group">
						<div class="col-xs-6">
					  		<label for="timesheetinput7">Palabra 1 </label>
							<div class="position-relative has-icon-left">
								<input id="txtPalabra1" class="form-control input-sm" type="text">
								<div class="form-control-position">
									<i class="ft-file"></i>
								</div>
							</div>
					  	</div>
					</div>
		         	<div class="form-group">
						<div class="col-xs-6">
					   		<label for="imgEjercicio">Palabra relacionada 1</label>
				            <div class="position-relative has-icon-left">
								<input id="txtPalabraRel1" class="form-control input-sm" />
								<div class="form-control-position">
								  <i class="ft-file"></i>
								</div>
				            </div>
						</div>
		         	</div>
				  	
				</div>
				<div class="row">  	
					<div class="form-group">
						<div class="col-xs-6">
					  		<label for="timesheetinput7">Palabra 2 </label>
							<div class="position-relative has-icon-left">
								<input id="txtPalabra2" class="form-control input-sm" type="text">
								<div class="form-control-position">
									<i class="ft-file"></i>
								</div>
							</div>
					  	</div>
					</div>
		         	<div class="form-group">
						<div class="col-xs-6">
					   		<label for="imgEjercicio">Palabra relacionada 2</label>
				            <div class="position-relative has-icon-left">
								<input id="txtPalabraRel2" class="form-control input-sm" />
								<div class="form-control-position">
								  <i class="ft-file"></i>
								</div>
				            </div>
						</div>
		         	</div>
				  	
				</div>
				<div class="row">  	
					<div class="form-group">
						<div class="col-xs-6">
					  		<label for="timesheetinput7">Palabra 3 </label>
							<div class="position-relative has-icon-left">
								<input id="txtPalabra3" class="form-control input-sm" type="text">
								<div class="form-control-position">
									<i class="ft-file"></i>
								</div>
							</div>
					  	</div>
					</div>
		         	<div class="form-group">
						<div class="col-xs-6">
					   		<label for="imgEjercicio">Palabra relacionada 3</label>
				            <div class="position-relative has-icon-left">
								<input id="txtPalabraRel3" class="form-control input-sm" />
								<div class="form-control-position">
								  <i class="ft-file"></i>
								</div>
				            </div>
						</div>
		         	</div>
				  	
				</div>
				<br />
					<div class="form-group text-right mb-1">
						<button type="button" class="btn btn-outline-info btn-min-width">
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
                                <th>Ejercicio de material</th>
                                <th>T&iacute;tulo</th>
                                <th width="107">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyPalabras">
                            <c:forEach items="${actAudioPalab}" var="item" varStatus="loop"  >
								<tr id="${item.materialTipoEjercicioBean.codigo}${item.codigo}">
									<td>${loop.index+1}</td>
									<td>${item.materialTipoEjercicioBean.titulo}</td>
									<td>${item.titulo}</td>
									<td>
	                                    <button type="button" class="btn btn-outline-success btn-sm " data-toggle="tooltip" onclick="editarMatTEjerPreg('${item.materialTipoEjercicioBean.codigo}','${item.codigo}','${item.materialTipoEjercicioBean.titulo}','${item.titulo}')" data-original-title="Editar"><i class="icon-pencil"></i></button>
	                                    <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" onclick="eliminarMatTEjerPreg('${item.materialTipoEjercicioBean.codigo}')" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                    </td>
								</tr>
						   	</c:forEach>
                        </tbody>
                    </table>
                </div>
	      	</div>
		</div>
	</div>
</div>