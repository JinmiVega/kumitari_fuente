<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Registro de glosario</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
  <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">

       
       $(document).ready(function() { 
	      var codigo = document.getElementById("codigoGlosario").value;
	     
	      if (codigo != '') { 
	        $('#titulo_glosario').html("Modificar glosario"); 
	      
	  	$("#cancelar").removeAttr("href")
		$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/buscar");
		 }else{
			  $("#cancelar").removeAttr("href")
				$("#cancelar").attr("href","${pageContext.request.contextPath}/glosarioController/listado");
				 
		  }
		 
    });

    </script>
   
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="#" class="navbar-brand"><img id="logo-k" alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text" style="font-size: 1.54rem;"><img alt="stack admin logo" src="${pageContext.request.contextPath}/assets/img/Logo-Kumitsari-white.png" class="brand-logo"></h2></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="fa fa-ellipsis-v"></i></a></li>
          </ul>
        </div>
        <div class="navbar-container content container-fluid">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
              <jsp:include page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
          <jsp:include page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
      </div>
    </div>

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                   <li class="breadcrumb-item"> Configuracion 
                  </li>
                  <li class="breadcrumb-item active"> Glosario 
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <input type="hidden" value="${swGlosario}"  id="glosario"  />
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">

                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id = "titulo_glosario"> Registro de glosario</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements" style="display: none">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div>
                              </div>
                              <div class="card-body collapse in">

                                  <div class="card-block card-dashboard">

                                    <div class="col-md-12 offset-md-0">
                                    <div class="col-md-12">
                                     <f:form id="frmRegistroGlosario" enctype="multipart/form-data" onsubmit="return false" class="form-horizontal" role="form"   method="post" action="grabar">
                                  <div class="form-body">

                                          <div class="row">

                                          <div class="form-group col-md-12">
											<div class="form-group col-md-6">
												<div class="form-group col-md-10">
		                                            <label for="situacionModal">Lengua <span class="required">*</span></label>
		                                            <div class="controls">
			                                            <f:select id="codLenguaGlosario"  path="lenguaBean.codigo" class="form-control"
				                                            data-validation-required-message="Este campo es requerido" required="required">
				                                           <f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
				                                              <f:options  items="${lstLenguaBean}"
				                                                        itemValue="codigo"
				                                                        itemLabel="nombre"/>
				                                        </f:select>
			                                        </div>
												</div>
											</div>
                                          <label for="nombre">Glosario* <i title="Formato aceptado pdf - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado pdf - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i><span class="required"></span></label>
                                         <div class="controls" class="col-md-12">
                                         	<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}">
                                         	<f:input type="hidden" path="codigoGlosario"  value="${glosarioBean.codigoGlosario}" id="codigoGlosario"/>
											<f:input type="hidden" path="fileName"  value="${pageContext.request.contextPath}/glosario/${glosarioBean.lenguaBean.codigo}_${glosarioBean.fileName}" id="fileName"/>
                                         	<div class="form-group col-md-6"  >
	                                          	<f:input type="file" path="file" name="file" id="file" required="required"  accept="application/pdf"/>
	                                          </div>
	                                          
	                                          
                                         </div>
										
                                        </div>

                                           </div>
                                           <div class="row">
                                           <div class="form-group col-md-8"></div>
                                            <div class="form-group col-md-8 text-right">
                                                <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/glosarioController/listado" id="cancelar">
                                                     				 <i class="fa fa-close"></i> 		   Cancelar
                                                    						  </a>
                                                   <button type="reset"  id="limpiar"  class="btn btn-flat btn-secondary">
                                                    <i class="fa fa-eraser"></i> Limpiar
                                                  </button>
                                                  
                                                 
				                                          <button type="button" <c:if test="${glosarioBean.fileName == null || glosarioBean.fileName==''}"> style="display:none"</c:if>
																	name="verDocumento"
																	data-toggle="modal"
																	class="btn btn-labeled btn-primary"
																	id="onshowbtn" data-target="#onshow"
																	onclick="verDocumentoGlosario();" >Ver Doc. Adjunto
											        			<span class="btn-label">
								                					<i class="icon-clipboard"></i>
								                				</span>
								                			</button>
								                	
                                                  
                                                  <button id="btn-save-reg" type="submit"
		                                            class="btn btn-flat btn-primary" onclick="insertarGlosario();" >
		                                           <i class="fa fa-floppy-o"></i>
		                                            Guardar
		                                          </button>
		                                          	
		                                          
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
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

	
	
   <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
   <!-- Modal -->
    <div class="modal fade text-xs-left" id="onshow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel21" aria-hidden="true">
	      <div class="modal-dialog" role="document">
		     <div class="modal-content">
		       <div class="modal-header">
		      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		        <span aria-hidden="true">&times;</span>
		      </button>
		      <h4 class="modal-title" id="txt_confir_Vd">Titulo Nro Expediente</h4>
		       </div>
		       <div class="modal-body">
			      <div class="row">
		               <div id="dataInfoModal" class="form-group col-lg-12">
		                </div> 
		              
		           </div>
			      
			      </div>
		       <div class="modal-footer">
		      <button type="button" class="btn grey btn-outline-secondary" data-dismiss="modal">Cerrar</button>
		     
		       </div>
		     </div>
	      </div>
    </div>
   
  
   
    <!-- BEGIN VENDOR JS-->
    
 
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->

    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

<%--       <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script> --%>
<%--     <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script> --%>
<%--     <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script>   --%>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
<%--     <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script> --%>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
	
   

    
     <script type="text/javascript">

     $(document).ready(function() {
//     	 $('#onshow').on('show.bs.modal', verDocumentoGlosario());
    });

     
			var existArchivo = false;
		
		    function control(f){
		        if(f!=null && f.value!=null && f.value!=""){
		        	existArchivo = true;
		        }
		    }
			
		    function insertarGlosario() {
		    	var exist = false;
		    	var url = "${pageContext.request.contextPath}/glosarioController/grabar";
		    	var codLengua = $("#codLenguaGlosario").val();
				var codGlosario = $("#codigoGlosario").val();
				var glosario = $("#file").val();
		
		    	var formData = new FormData($("#frmRegistroGlosario")[0]);
				
		    	if(codGlosario != null && codGlosario>0){
					exist = true;
				}
		
				if (codLengua == "0" ) {
					msg_advertencia("Seleccione una lengua.");
				} else {
					 iniciarBloqueo();
			    	$.ajax({
			               type: "POST",
			               url: url,
			               data: formData, // Adjuntar los campos del formulario enviado.
			               contentType: false,
			               processData: false,
			               success: function(data) {

			            	   if (data != null) {
								 	msg_exito();
								 	limpiar();
								 	/*
								 	if(exist){
								 		$("#paginaGlosario").html(data);
								 		location.href="${pageContext.request.contextPath}/glosarioController/buscar";
									 }
								 	*/
								}
				  				else{
			
								}
			
			               },
			    		   error: function(xhr,status,er) {
			
			    			   //console.log("ERROR: ");
			    		    },
			               complete: function() {
			            	   finBloqueo();
			               }
			        });
				}
		    }
		    
			function limpiar(){
				$("#codLenguaGlosario").val("0");
				$("#codigoGlosario").val("0");
				$("#glosarioLenguaOriginaria").val("");
			}
		
			function verDocumentoGlosario() {

				$("#txt_confir_Vd").html("Vista del documento de Glosario");
				$("#dataInfoModal").empty();
		
				//$('#modalVerdocumento').modal('show');
		
				var object = "<object data='"+$("#fileName").val()+"' type='application/pdf' width='100%' height='450px'>"+ "<embed src='"+$("#fileName").val()+"' type='application/pdf' />" +"</object>";
		
				$( "#onshow #dataInfoModal" ).empty();
				$( "#onshow #dataInfoModal" ).append( object );
			}
			
    </script>
  </body>
</html>