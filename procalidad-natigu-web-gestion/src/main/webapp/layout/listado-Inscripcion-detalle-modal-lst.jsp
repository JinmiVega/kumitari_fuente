<%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>     
	
         <table  class="table table-striped table-bordered zero-configuration" >
                  <thead>
                      <tr >
                      	  <th width="15">N&deg;</th>
           				  <th>Nom. instituci&oacute;n</th>
           				  <th>Nom. de la lengua</th>
           				  <th>Nivel</th>
           				  <th>Periodo</th>
           				  <th>Semestre</th>          				  
           				  <th>Núm. cupos</th>
           				  <!-- <th>Num. Cupos D.</th> -->
                          <th width="20">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody id="idTablainscripcionLenguaBean">
                      <c:forEach var="inscripcionLenguaBean" items="${lstInscripcionLenguaBean}" varStatus="theCount">
                      <tr>
                      	  <td >${theCount.count}</td><!-- ${inscripcionLenguaBean.codigo} -->
                      	  <td style="display:none;"> ${inscripcionLenguaBean.codigo}</td>
                  		  <td >${inscripcionLenguaBean.institucion.nombreInstitucion}</td>
                  		  <td >${inscripcionLenguaBean.lenguainscr.nombre}</td>
                  		  <td >${inscripcionLenguaBean.nivel.nombreCorto}</td>
                  		  <td >${inscripcionLenguaBean.inscripcionBean.periodo.codigoRegistro}</td>
                  		  <td >${inscripcionLenguaBean.inscripcionBean.ciclo.nombreCorto}</td>                  		  
                  		  <td >${inscripcionLenguaBean.numeroCuposInsc}</td>
                  		  <%-- <td >${inscripcionLenguaBean.numeroCuposDisp}</td> --%>
                          <td >
                           <!--  <button type="button" class="btn btn-outline-success btn-sm" id="botonagregarDetalle"><i class="icon-arrow-right"></i></button> -->
                            <a class='l1s' title='seleccionar'><i class="icon-arrow-right"></i></a>
                          </td>
                      </tr>
                      </c:forEach>
                  </tbody>
                  <tfoot>
                      <tr >
                      	  <th width="15">N&deg;</th>
           				  <th>Nom. instituci&oacute;n</th>
           				  <th>Nom. de la lengua</th>
           				  <th>Nivel</th>
           				  <th>Periodo</th>
           				  <th>Semestre</th>          				  
           				  <th>Núm. cupos</th>
           				  <!-- <th>Num. Cupos D.</th> -->
                          <th width="20">Acci&oacute;n</th>
                      </tr>
                  </tfoot>
              </table>
                