<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-md-3 mb-2">
	<fieldset class="form-group">
	 	<label>Lengua<span class="required">*</span> </label>
	 	<div class="controls">
		  	<f:select id="codigoLengua" name="interested" class="form-control"
		  	path="institucionLenguaBean.lenguaBean.codigo" data-validation-required-message="Este campo es requerido">
	      	<f:option value="0" id="optionLengua" selected="true" disabled="disabled" label="Seleccionar"/>
		          <f:options  items="${lstLengua}"
		                           itemValue="codigo"
		                           itemLabel="nombre"/>
		   </f:select>
	    </div>
   </fieldset>
</div>
		
		
<div class="form-group col-md-9 text-right ">
	<a class="btn btn-secondary mr-1" href="${pageContext.request.contextPath}/institucionController/listado"><i class="fa fa-close"></i> Cancelar</a>
     
	<button type="submit"
	onclick="guardarGenericoTabsInstitucion('${pageContext.request.contextPath}/institucionController/','#frmInsertarLengua')"
					class="btn btn-outline-secondary btn-min-width">
					<i class="ft-search"></i> Agregar
	</button>
</div>