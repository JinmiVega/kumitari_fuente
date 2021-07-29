<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>

<f:form>
<div class="form-body">
	<div class="row">
	  <div class="col-xs-12">
	    <table id="md_table-lecccion" class="table table-striped table-bordered  ">
	        <thead>
	            <tr>
	                <th width="40">N°</th>
	                <th>Lecciones 
	               <%--  --->  ${lstLeccion}
 --%>
						<!-- <div id="table_select_lengua">
		                    <select class="form-control input-sm" style="width: 130px">
		                        <option selected value="0">B&aacute;sico</option>
		                        <option value="1">Intermedio</option>
		                        <option value="2">Avanzado</option>
		                    </select>
		                    <select class="form-control input-sm">
		                        <option selected value="0">B1</option>
		                        <option value="1">B2</option>
		                        <option value="2">B3</option>
		                    </select>
		                    <select class="form-control input-sm" style="width: 120px">
		                        <option value="1">unidad 01</option>
		                        <option value="2">unidad 02</option>
		                        <option value="2">unidad 03</option>
		                    </select>
						</div> -->
	                </th>
	                <th width="90">Acci&oacute;n</th>
	            </tr>
	        </thead>
	        <tbody id="tbodyLeccion">
	        <c:forEach var="leccion" items="${lstLeccion}" varStatus="indexLeccion">
	            <tr id="${leccion.codigo}">
	            
	                <td>${indexLeccion.index+1}</td>
	                <td>${leccion.nombre}</td>
	                <td class="text-xs-center td">
	                  <%-- <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="eliminarLeccionGrilla(${leccion.codigo});"><i class="icon-trash"></i></button> --%>

					  <button type="button" data-showp="0" data-id="1" class="btn btn-outline-success btn-sm btn-show" data-toggle="tooltip" onclick="editarLeccionCargarModal2(${leccion.codigo});" data-original-title="Mostar"><i class="ft-eye"></i></button>
	                </td>
	            
	            </tr>
	        </c:forEach>
	            
	            <!-- <tr id="tb_ejercio_1" class="ocultar_tb_ejercicios">
	            	<td colspan="4">
	            		<h5>Ejercicios</h5>
	            		<table class="table">
	            			<tbody>
	            				<tr>
	            					<td>Ejercio #01</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>Ejercio #02</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>Ejercio #03</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            			</tbody>
	            		</table>
	            	</td>
	            </tr> -->
	           <!--  <tr>
	                <td>2</td>
	                <td>Segunda Lecci&oacute;n</td>
	                <td>
	                  <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>

					  <button type="button" data-showp="0" data-id="2" class="btn btn-outline-success btn-sm btn-show" data-toggle="tooltip" data-original-title="Mostar"><i class="ft-eye"></i></button>
	                </td>
	            </tr>
	            <tr id="tb_ejercio_2" class="ocultar_tb_ejercicios">
	            	<td colspan="4">
	            		<h5>Ejercicios</h5>
	            		<table class="table">
	            			<tbody>
	            				<tr>
	            					<td>Ejercio #01</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>Ejercio #02</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>Ejercio #03</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            			</tbody>
	            		</table>
	            	</td>
	            </tr>
	            <tr>
	                <td>3</td>
	                <td>Tercera Lecci&oacute;n</td>
	                 <td>
	                  <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>

					  <button type="button" data-showp="0" data-id="3" class="btn btn-outline-success btn-sm btn-show" data-toggle="tooltip" data-original-title="Mostar"><i class="ft-eye"></i></button>
	                </td>
	            </tr>
	            <tr id="tb_ejercio_3" class="ocultar_tb_ejercicios">
	            	<td colspan="4">
	            		<h5>Ejercicios</h5>
	            		<table class="table">
	            			<tbody>
	            				<tr>
	            					<td>Ejercio #01</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>Ejercio #02</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>Ejercio #03</td>
	            					<td width="90">
										<button type="button" class="btn btn-outline-success btn-sm" data-toggle="tooltip" data-original-title="Modificar"><i class="icon-pencil"></i></button>
										<button type="button" class="btn btn-outline-danger btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" ><i class="icon-trash"></i></button>
	            					</td>
	            				</tr> -->
	            			</tbody>
	            		</table>
	            	</td>
	            </tr>

	        </tbody>

	    </table>
	  </div>
	</div>
</div>
</f:form>

<script  type="text/javascript" charset="utf-8">

$("#md_table-lecccion .btn-show").click(function() {
		//debugger;
	var ted = $(this).attr('data-showp');
	var idted = $(this).attr('data-id');


		if(ted=='0'){
			$("#tb_ejercio_"+idted).show();
			$(this).attr("data-showp","1");
		}
		if(ted==1){
			$("#tb_ejercio_"+idted).hide();
			$(this).attr("data-showp","0");
		}
});

</script>