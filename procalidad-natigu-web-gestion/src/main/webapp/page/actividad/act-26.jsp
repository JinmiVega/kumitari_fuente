<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<%@page isELIgnored="false" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Ejercicio</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" onclick="listarEjercicioCrucigrama()"  id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
	<!-- <li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> -->
</ul>

<f:form class="form" id="frmRegistoCrucigrama" method="post" action="">
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
							<input type="text" id="ejercicioTxtTitulo" required class="form-control" name="employeename" maxlength="1200" value="${ejercicio.tituloEjercicio}">
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
						<label for="ejercicioTxtComprension">Guía</label>
						<div class="position-relative ">
							<textarea rows="5" id="ejercicioTxtSubTitulo" class="form-control" name="ejercicioTxtSubTitulo" maxlength="1200" value="${ejercicio.comprension}"></textarea>
						</div>
				    </div>
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
	        	 <div class="row">
	        	 <div class="col-xs-4">
	        	 <div class="form-group">  
	            <label for="timesheetinput7">Letra(s)*</label>
		         <input id="idsilaba" type ="text" onkeypress="pulsar(event)" 
		          maxlength="2" style="width:100px;height:35px;" required  class="form-control input-sm" name="notes"/>
		       </div>
		        </div>
		       <div class="col-xs-4">   
	          <button   type="button" class="btn btn-outline-info btn-min"  style="margin-top:25px;width:50px;height:35px;" id="btn_agregarsilaba" onclick="agregarsilaba()" >
		 <i class="ft-plus"></i>
		 </button> 
	        
	         </div>
	 				</div>
	        
	        
         
		 <input id="idPalabraSeparada" type ="text"  disabled
          maxlength="2" required  class="form-control input-sm"/>
       
	        
	        
     	 <div class="form-group">
     	  <input type="hidden" id="idRelacionCabecera" value="0"/>
         <input type="hidden" id="idRelacionCrucigrama" value="0"/>
         <label for="timesheetinput7">Palabra*</label>
         <div class="position-relative has-icon-left disabled">
         <input id="idPalabraCrucigrama" type ="text" required disabled  class="form-control input-sm disabled" name="notes"/>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
        </div>
     	 <div class="form-group">
         <label for="timesheetinput7">Definici&oacute;n*</label>
         <div class="position-relative has-icon-left">
         <textarea id="idDefinicionCrucigrama" rows="2" required class="form-control input-sm" name="definition" maxlength="4000"></textarea>
         <div class="form-control-position">
         <i class="ft-file"></i>
         </div>
         </div>
         </div> 
         <div class="row">
         	 
         	 <div class="col-xs-4">
         	  <label for="">X*</label>  <input id="x" type ="text" onkeypress="return valida(event)"  required  class="form-control input-sm" name="x"  maxlength="2" style="width:50px;height:35px;" onpaste="return false;" /> 
         	 </div>
         	 <div class="col-xs-4">
         	  <label for="">Y*</label>  <input id="y" type ="text" onkeypress="return valida(event)"  required  class="form-control input-sm" name="y"  maxlength="2" style="width:50px;height:35px;" onpaste="return false;" /> 
         	 </div>
         	 <div class="col-xs-4">
         	  <label for="">N&uacute;mero*</label>  <input id="idnumero" type ="text" onkeypress="return valida(event)"  required  class="form-control input-sm" name="idnumero"  maxlength="3" style="width:50px;height:35px;"  onpaste="return false;" /> 
         	 </div>
         	 <!--
         	 <div class="col-xs-3">
         	  <label for="situacionUsuario">Orden*</label>  <input id="idCmbOrden" type ="text" onkeypress="return valida(event)"  required  class="form-control input-sm" name="order"  maxlength="2" style="width:50px;height:35px;" /> 
         	 </div>  -->

         	 <div class="col-xs-6">
         	 <label for="situacionUsuario">Orientaci&oacute;n*</label>
			   <select id="idCmbOrientacion" class="form-control" style="width:150px;height:35px;"> 
					<option value="0">Seleccionar</option>   
		         	<option value="1">Horizontal</option> 
		         	<option value="2">Vertical</option>		
				</select>
         	 </div> 
			<!-- 
         	 <div class="col-xs-6">
         	 <label for="situacionUsuario">posici&oacute;n*</label>
			   <select id="idCmbOrden" class="form-control" style="width:150px;height:35px;"> 
					<option value="0">Seleccionar</option>   
		         	<option value="1">Normal</option> 
		         	<option value="2">Invertido</option>		
				</select>
         	 </div>
         	 -->

         
	     	 
          
         </div>
         
		 <div class="form-group text-right mb-1">
		 <button type="button" id="btn_nuevo_crucigrama" onclick="nuevoCrucigrama()"  style="margin-top:15px" class="btn btn-outline-info btn-min-width">
		 <i class="fa fa-file-o"></i> Nuevo
		 </button>	
		 <button type="button" class="btn btn-outline-info btn-min-width"  style="margin-top:15px" id="btn_guardar_crucigrama" onclick="validarCrucigrama()" >
		 <i class="fa fa-floppy-o"></i> Guardar
		 </button>
		 </div>                
  
	        </div>
	        <div class="col-xs-7">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                       
						<thead>
                            <tr>
                                <th width="40">N°</th>
                                <th>Palabra</th>
                                <th>Definici&oacute;n</th> 
                                <th>Orientaci&oacute;n</th>
                                <th width="107">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody id="bodyListeCrucigrama"> 
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>

</div>
</f:form> 