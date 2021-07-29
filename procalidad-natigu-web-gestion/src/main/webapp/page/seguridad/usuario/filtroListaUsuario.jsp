<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
	
	 
    
   <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id="titulo-usuario2"> Registro de usuario</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <!-- <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div> -->
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">

                                     <ul id="idUlContentTab" class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Datos Generales</a>
                                        </li>
                                        <c:if test="${usuarioBean.codigoUsuario != null && usuarioBean.codigoUsuario > 0}">
	                                        <li class="nav-item">
	                                          <a  class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Usuario</a>
	                                        </li>
                                        </c:if>
                                      </ul>

                             <div class="tab-content px-1 pt-1">
                              <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                 <f:form class="form mt-1" id="formularioPersona">
                                 	<input type="hidden" value="${msgconfir}"  id="mensaje"  />
                                      <div class="form-body">
                                          <div class="row">
                                                <div class="col-md-12">
                                                	<f:input type="hidden" id="codigoPersona" class="form-control" name="lname" path="persona.codigo"/>
                                                  <div class="row">
                                                      <div class="form-group col-md-3 mb-2">
                                                        <label for="situacionUsuario">Tipo de documento</label>
													
                                                        <f:select id="tipoDocumento" name="interested" class="form-control" path="persona.tipoDocumento.codigoRegistro"    onchange="formatoNumeroDocumento()" >
															<option value="0" >Seleccione</option>
			                                                  <f:options  items="${lstTipoDocumento}"
			                                                                    itemValue="codigoRegistro"
			                                                                    itemLabel="nombreCorto"/>
			                                              </f:select>
                                                      </div>

                                                      <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">N&uacute;mero de documento</label>
                                                          <f:input type="text" id="numeroDoc" class="form-control" name="lname" path="persona.numeroDocumento" onkeypress="return justNumbers(event);" onchange="setInputHidden2()"  />
                                                      </div>
                                                      <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/buscarPersona','POST','#formularioPersona')">
                                                            <i class="ft-search"></i> Buscar
                                                          </button>
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                      <div class="form-group col-md-6 mb-2">
                                                          <label for="projectinput1">Nombres completos</label>
                                                          <f:input type="text" id="projectinput1" disabled="true" class="form-control" name="fname" path="persona.nombreCompleto"/>
                                                      </div>
                                                  </div>
                                                  <div class="row">
                                                       <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">Tel&eacute;fono/Celular</label>
                                                          <f:input type="text" id="projectinput3" disabled="true" class="form-control" name="lname" path="persona.telefono"/>
                                                      </div>

                                                      <div class="form-group col-md-3 mb-2">
                                                          <label for="projectinput2">Correo electr&oacute;nico</label>
                                                          <f:input type="text" id="projectinput4" disabled="true" class="form-control" name="lname" path="persona.correo"/>
                                                      </div>

                                                  </div>


                                                </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-6 text-right">
                                                   <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/usuarioController/listado" id = "cancelar">
                                                        Cancelar
                                                      </a>
                                                      <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/usuarioController/nuevo">
                                                        <i class="ft-search"></i> Limpiar
                                                      </a>

                                                      <c:if test="${(usuarioBean.persona.codigo!=null && usuarioBean.persona.codigo>0) && (usuarioBean.codigoUsuario == null || usuarioBean.codigoUsuario == 0)}">
                                                      	<button type="button" class="btn btn-primary" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/asignar','POST','#formularioPersona')"><i class="fa fa-floppy-o"></i> Asignar</button>
                                                      </c:if>
                                                  </div>
                                              </div>
                                      </div>
                                 </f:form>
                                </div>

                              <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                  <f:form class="form mt-1" id="formularioRegistroUsuario" action="${pageContext.request.contextPath}/usuarioController/grabar">
                                            <div class="form-body">
											<f:input type="hidden" id="codigoUsuario" class="form-control" name="codigoUsuario" path="codigoUsuario"/>

                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput1">Nombre de usuario</label>
                                                      <f:input type="text" id="nomUsu" class="form-control" name="fname" required="true" readonly="true" path="nombreUsuario" maxlength="50"/>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Situaci&oacute;n</label>
                                                    <f:select id="situacionUsuario" name="interested" class="form-control" path="situacion.codigoRegistro" >
		                                                  <option value="" >Seleccione</option>
		                                                  <f:options  items="${lstSituacion}"
		                                                                    itemValue="codigoRegistro"
		                                                                    itemLabel="nombreCorto"/>
		                                              </f:select>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="passwordUsuario">Contrase&ntilde;a</label>
                                                      <fieldset class="form-group position-relative">
                                                          <f:input type="password" class="form-control form-control-xl " readonly="true" id="passwordUsuario" required="true" path="passwordUsuario" maxlength="150"/>
                                                          <div class="form-control-position">
                                                          <i class="icon-key info font-medium-3"></i>
                                                          </div>
                                                      </fieldset>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="projectinput6">Perfil</label>
                                                    <f:select id="codigoPerfil" name="codigoPerfil" class="form-control" path="codigoPerfil" >
		                                                  <option value="" >Seleccione</option>
		                                                  <c:forEach var="perfil" items="${lstPerfiles}">
		                                                  	<option
		                                                  		<c:if test="${(usuarioSesion.codPerfilUsuSelec==6) and (perfil.codigoPerfil!=2)}">style="display:none;"</c:if> 
		                                                  		value="${perfil.codigoPerfil}" >${perfil.nombrePerfil}</option>
		                                                  </c:forEach>
		                                              </f:select>
                                                  </div>
                                                   <div class="form-group col-md-3 mb-2">
                                                      <br>
                                                          <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajaxPerfil('${pageContext.request.contextPath}/usuarioController/asignarPerfil','POST','#formularioRegistroUsuario')">
                                                            <i class="fa fa-floppy-o"></i> Agregar perfil
                                                          </button>
                                                      </div>
                                              </div>
                                              <div class="row">
                                          <div class="col-xs-8">
                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Perfil</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
	                                                <c:forEach var="usuarioPerfilBean" items="${lstUsuarioPerfil}" varStatus="theCount">
	                                                    <tr>
	                                                        <td>${theCount.count}</td>
	                                                        <td>${usuarioPerfilBean.perfil.nombrePerfil} </td>
	                                                        <td>
	                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="eliminarPerfil(${usuarioPerfilBean.codigoUsuarioPerfil},'${pageContext.request.contextPath}/usuarioController');"><i class="icon-trash"></i></button>
	                                                        </td>
	                                                    </tr>
                                                    </c:forEach>



                                                </tbody>
												<tfoot>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Perfil</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                          </div>
                                        </div>
                                              <div class="row">
                                                  <div class="form-group col-md-6 text-right">

                                                      <button type="submit" class="btn btn-primary"  title="Grabar"><i class="fa fa-floppy-o"></i> Guardar</button>
                                                      <c:if test="${usuarioBean.codigoUsuario!=null && usuarioBean.codigoUsuario>0}">
	                                                      <button type="button" class="btn btn-secondary mr-1" onclick="enviar_ajax('${pageContext.request.contextPath}/usuarioController/resetPassword','POST','#formularioRegistroUsuario')">
	                                                        <i class="ft-reload"></i> Reestablecer contrase&nacute;a
	                                                      </button>
	                                                  </c:if>
                                                  </div>
                                              </div>
                                            </div>
                                 </f:form>
                              </div>
                            </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </section>
              
                <script type="text/javascript">

       
       $(document).ready(function() { 
    	   var obj = $("#mensaje").val();
           if(obj!='' ){
        	   /* msg_info(obj); */
        	   msg_exito();
           }
    	   setInputHidden2();
// 	      var codigo = document.getElementById("codigoGlosario").value;
	     
// 	      if (codigo != '') { 
// 	        $('#titulo_glosario').html("Modificar glosario"); 
	      
// 	  	$("#cancelar").removeAttr("href")
// 		$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/buscar");
// 		 }else{
// 			  $("#cancelar").removeAttr("href")
// 				$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/listado");
				 
// 		  }
		 
    });
       
 
	 
       function setInputHidden2(){
	   		
	       	  var tipo =$("#codigoUsuario").val(); 
	       	  //console.log(tipo);
	       	  
			       	if (tipo != 0) { 
			        
			           	  $("#titulo-usuario2").text('Modificar usuario'); 
			           	  
			       	  	$("#numeroDoc").removeAttr("disabled");
		        	  	$("#tipoDocumento").removeAttr("disabled");
		        	  	
			        	  $("#numeroDoc").attr("disabled","true");
			        	  $("#tipoDocumento").attr("disabled","true");
			           	  
			       
			           	  $("#cancelar").removeAttr("href");
			        	  $("#cancelar").attr("href","${pageContext.request.contextPath}/usuarioController/buscar");
			        }else{
			        	
			          	$("#numeroDoc").removeAttr("disabled");
			          	$("#tipoDocumento").removeAttr("disabled");
 
			        	  
			       	  	$("#cancelar").removeAttr("href");
			   			$("#cancelar").attr("href","${pageContext.request.contextPath}/usuarioController/listado"); 
			         } 
	         }
       
    </script>