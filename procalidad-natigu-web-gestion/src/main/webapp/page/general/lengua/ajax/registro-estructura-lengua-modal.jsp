<%@ page contentType="text/html; charset=UTF-8" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
 
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

 <!-- Modal -->

<div class="modal-header">
        <button type="button" id ="btnCerrar" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Estructura de ense&ntilde;anza</b></label>
       </div>
        <div class="modal-body">
           
           <f:form id="frmRegistroLenguaEstructura" class="form-horizontal" role="form"
	enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/lenguaController/grabarEstructura">
           <input id="contextPath" type="hidden" value="${pageContext.request.contextPath}"> 
           
                                        <div class="form-body">
                                          <div class="row">
                                            <div class="col-xs-7">
                                              <div id="blok-check" class="row skin skin-square">

                                                  <div class="form-group col-md-12 mb-0">
                                                      <label  class="card-title"><small>Nivel</small></label>
                                                  </div>
                                                  <div class="form-group col-md-12 mb-2">
                                                  <c:forEach var="nivel" items="${lstNivel}"> 
                                                    <fieldset> 
                                                     <div class="col-xs-5">
                                                      <input disabled="true" type="checkbox" id="input-${nivel.codigoRegistro}" ${nivel.valor1}>
                                                      <label for="input-${nivel.codigoRegistro}">${nivel.nombreCorto}</label>
                                                      </div>
                                                     <div class="col-xs-7">
                                                      <input   class="get_valueNombre" type="hidden" value="${nivel.valor4}" name="ali" id="${nivel.codigoRegistro}" />
                                                      </div>
                                                      
                                                    </fieldset> 
                                                    </c:forEach>
                                                  </div>
											
                                                  <div class="form-group col-md-12 mb-0">
                                                      <label  class="card-title"><small>Sub-niveles</small></label>
                                                  </div>
										<!--  <c:forEach var="nivel" items="${lstNivel}"> 
											  <div id="cl_${nivel.nombreLargo}" class="form-group col-md-12 mb-2">
                                                  <c:forEach var="subNivel" items="${lstSubNivel}"> 
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input type="checkbox" id="input-s${subNivel.codigoRegistro}">
                                                      <span class="custom-control-description">${subNivel.nombreCorto}</span>
                                                    </label> 
                                                    </c:forEach>
                                                  </div>
											 </c:forEach> -->
											    <div id="cl_B" class="form-group col-md-12 mb-2">
                                                  <c:forEach var="subNivel1" items="${lstSubNivel1}"> 
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input disabled="true" type="checkbox" class="get_value" value ="${subNivel1.codigoRegistro}" 
                                                       id="input-s${subNivel1.codigoRegistro}"  ${subNivel1.valor1}>
                                                      <span class="custom-control-description">${subNivel1.nombreCorto}</span>
                                                    </label> 
                                                    </c:forEach>
                                                  </div>
                                                  <div id="cl_I" class="form-group col-md-12 mb-2" style="display:${I}" >
                                                  <c:forEach var="subNivel2" items="${lstSubNivel2}"> 
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input disabled="true" type="checkbox" class="get_value" value ="${subNivel2.codigoRegistro}" 
                                                      		id="input-s${subNivel2.codigoRegistro}"  ${subNivel2.valor1}>
                                                      <span class="custom-control-description">${subNivel2.nombreCorto}</span>
                                                    </label> 
                                                    </c:forEach>
                                                  </div>
                                                  <div id="cl_A" class="form-group col-md-12 mb-2" style="display:${A}">
                                                  <c:forEach var="subNivel3" items="${lstSubNivel3}"> 
                                                    <label class="display-inline-block custom-control custom-checkbox">
                                                      <input disabled="true" type="checkbox"  class="get_value" value ="${subNivel3.codigoRegistro}"  id="input-s${subNivel.codigoRegistro}"  ${subNivel3.valor1}>
                                                      <span class="custom-control-description">${subNivel3.nombreCorto}</span>
                                                    </label> 
                                                    </c:forEach>
                                                  </div>
                                              </div>
                                            </div>
                                          </div>

                                        </div>
        
        	<div class="modal-footer">
        	
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button> 
          <!--  <button type="button" onclick="grabarLenguaEstructura()" class="btn btn-primary">
          <i class="fa fa-floppy-o"></i> Guardar</button>-->
 
          <h4 id="result"></h4>
        </div>
        </f:form>
        </div>  
         <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js" type="text/javascript"></script>
       <!--  <script src="${pageContext.request.contextPath}/app-assets/js/jquery.form.js" type="text/javascript"></script>   --> 
         <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
         
   <script type="text/javascript" charset="utf-8">

      $('#input-1').on('ifChecked', function(event){
        $("#cl_B").show(300);
      });
      $('#input-1').on('ifUnchecked', function(event){
        $("#cl_B").hide(300);
        $('#cl_B input').iCheck('uncheck');
      });

      $('#input-2').on('ifChecked', function(event){
        $("#cl_I").show(300);
      });
      $('#input-2').on('ifUnchecked', function(event){
        $("#cl_I").hide(300);
        $('#cl_I input').iCheck('uncheck');
      });

      $('#input-3').on('ifChecked', function(event){
        $("#cl_A").show(300);
      });
      $('#input-3').on('ifUnchecked', function(event){
        $("#cl_A").hide(300);
        $('#cl_A input').iCheck('uncheck');
      });

     
    </script>
    
   