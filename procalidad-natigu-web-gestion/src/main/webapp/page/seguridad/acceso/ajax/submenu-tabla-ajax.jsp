<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<table id="idTablaSubMenusOpt" class="table table-striped table-hover table-bordered zero-configuration">
    <thead>
        <tr>
            <th width="30">Item</th>
            <th>SubMen&uacute;</th>
            <th width="50">Lectura</th>
            <th width="50">Escritura</th>
            <th width="50">Eliminaci&oacute;n</th>
            <th width="50">Exportaci&oacute;n</th>
        </tr>
    </thead>
    <tbody>
    	<c:choose>
    		<c:when test="${totalSubMenus>0}">
    			<c:forEach var="submenu" items="${lstAccesoBeanDetalle}">
		    		<tr>
			            <td>${submenu.item}</td>
			            <td>${submenu.componente.descripcion}</td>
			            <td>
			            	<c:choose>
							    <c:when test="${submenu.flgRead}">
							    	<input type="checkbox" value="${submenu.codigo}" id="col-A-${submenu.componente.codigo}" checked="checked" />
							    </c:when>
							    <c:otherwise>
							    	<input type="checkbox" value="${submenu.codigo}" id="col-A-${submenu.componente.codigo}" />
							    </c:otherwise>
						    </c:choose>
			            </td>
			            <td>
			            	<c:choose>
							    <c:when test="${submenu.flgWrite}">
							    	<input type="checkbox" value="${submenu.codigo}" id="col-B-${submenu.componente.codigo}" checked="checked" />
							    </c:when>
							    <c:otherwise>
							    	<input type="checkbox" value="${submenu.codigo}" id="col-B-${submenu.componente.codigo}" />
							    </c:otherwise>
						    </c:choose>
			            </td>
			            <td>
			            	<c:choose>
							    <c:when test="${submenu.flgDelete}">
							    	<input type="checkbox" value="${submenu.codigo}" id="col-C-${submenu.componente.codigo}" checked="checked" />
							    </c:when>
							    <c:otherwise>
							    	<input type="checkbox" value="${submenu.codigo}" id="col-C-${submenu.componente.codigo}" />
							    </c:otherwise>
						    </c:choose>
			            </td>
			            <td>
			              	<c:choose>
							    <c:when test="${submenu.flgExport}">
							    	<input type="checkbox" value="${submenu.codigo}" id="col-D-${submenu.componente.codigo}" checked="checked" />
							    </c:when>
							    <c:otherwise>
							    	<input type="checkbox" value="${submenu.codigo}" id="col-D-${submenu.componente.codigo}" />
							    </c:otherwise>
						    </c:choose>
			            </td>
			        </tr>
		    	</c:forEach>
    		</c:when>
    		<c:otherwise>
    			<tr><td colspan="6"><p>Sin registros para mostrar</p></td></tr>
    		</c:otherwise>
    	</c:choose>
    </tbody>
</table>

<input type="hidden" id="idTotalSubMenus" value="${totalSubMenus}"/>

<c:if test="${totalSubMenus>0}">
	<div class="row">
	   <div class="col-xs-12 text-right">           
	      <button id="btn-save-reg-acc"	
	              type="button" 
	   			  class="btn btn-flat btn-primary"
	   			  onclick="guardarCambiosAcceso(2)">
	   			<i class="glyphicon glyphicon-floppy-disk"></i>
	   			Guardar
	   	  </button>      
	   </div>
	</div>
</c:if>