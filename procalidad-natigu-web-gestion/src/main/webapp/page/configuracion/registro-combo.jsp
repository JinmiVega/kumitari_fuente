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
    <title>Registro de combo</title>
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

       function validarRequired(idfrom){
    	   
    	   
//     var $myForm = $(idfrom);
//     if(! $myForm[0].checkValidity()) {
//        msg_advertencia("Debe completar correctamente todos los campos requeridos");
//     }


    	 
    		    var $myForm = $(idfrom);

    		    var nombre = document.getElementById("idnombreCombo").value;
    			var situacion = document.getElementById("lblSituacion").value;
    			var costoCmb = document.getElementById("monto").value;
// 				console.log(nombre);
// 				console.log(situacion);
// 				! $myForm[0].checkValidity()
    		    if(  nombre == '' || situacion == '' || costoCmb=='') {
    		    	$("#idnombreCombo").css("border", "2px solid rgba(22, 211, 154, .5)");
    				//$("#lblSituacion").css("border", "2px solid rgba(22, 211, 154, .5)");
    				ejecutarGuardar = false;
    		       msg_advertencia("Debe completar correctamente todos los campos requeridos");
					
    		        if(nombre == null || nombre.length <= 0){
    					$("#idnombreCombo").css("border", "2px solid rgba(210, 60, 60, .5)");
    					$("#idnombreCombo").focus();
    				   }
    				if(situacion == null || situacion.length <= 0){
    				 	$("#lblSituacion").css("border", "2px solid rgba(210, 60, 60, .5)");
    					$("#lblSituacion").focus();
    				 
    				//	situacion.focus();
    				}
    				if(costoCmb == null || costoCmb.length <= 0){
    				 	$("#monto").css("border", "2px solid rgba(210, 60, 60, .5)");
    					$("#monto").focus();
    				 
    				//	situacion.focus();
    				}

    		    } else {
    		    	ejecutarGuardar = true;
    		    	document.getElementById("frmRegistroCombo").submit();
    		    }

    		 
  }
       $(document).ready(function() {
    var msj = $("#mensaje").val();//1
    if(msj=='1'){
      msg_exito();
    }else if(msj=='0'){
      msg_advertencia("Ya existe un registro con ese nombre");
    }
      var codigo = document.getElementById("codigoCombo").value;
      if (codigo != '0') {
        $("#limpiar").attr("disabled", true);
        $('#titulo_combo').html("Modificar combo");
       
  	  $("#cancelar").removeAttr("href")
      $("#cancelar").attr("href","${pageContext.request.contextPath}/comboController/buscar");
       }else{
      	  $("#cancelar").removeAttr("href")
  			$("#cancelar").attr("href","${pageContext.request.contextPath}/comboController/listado");
  			 
        }
      
      
    });

       
       function valida(e){
   	    tecla = (document.all) ? e.keyCode : e.which;

   	    //Tecla de retroceso para borrar, siempre la permite
   	    if (tecla==8){
   	        return true;
   	    }
   	        
   	    // Patron de entrada, en este caso solo acepta numeros
   	    patron =/[0-9]/;
   	    tecla_final = String.fromCharCode(tecla);
   	    return patron.test(tecla_final);
   	}
</script>

    <style>
          .thumb {
            height: 220px;
            border: 0px solid #000;
            margin: 10px 5px 0 0;
            max-height: 300px;
            max-width: 600px;
            overflow: hidden;
          }

    </style>



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
		                   		<li class="breadcrumb-item"> Configuracion </li>
		                  		<li class="breadcrumb-item active"> Combos </li>
		               		</ol>
		              	</div>
		            </div>
				</div>
			</div>
	        <input type="hidden" value="${swMensaje}"  id="mensaje"  />
	        <div class="content-body"><!-- Analytics spakline & chartjs  -->
				<section id="configuration">
					<div class="row">
	                	<div class="col-xs-12">
	                    	<div class="card">
	                        	<div class="card-header">
	                            	<h4 class="card-title" id= "titulo_combo"> Registro de combo</h4>
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
												<f:form id="frmRegistroCombo" class="form-horizontal" role="form"   enctype="multipart/form-data" onSubmit="return validarGrabar()" method="post" action="grabar"   novalidate="true">
													<div class="form-body">
															<div class="row col-xs-12"  >
					                                           <div class="form-group col-md-9 ">
				                                                  <label for="nombre">Nombre de combo<span class="required">*</span></label>
				                                                  <div class="controls">
					                                                  <f:input type="hidden" path="codigo"  id="codigoCombo"/>
					                                                  <f:input type="text" class="form-control" maxlength="50"   id = "idnombreCombo" path="titulo" data-validation-required-message="Este campo es requerido" required="required"/>
				                                                  </div>
					                                           	</div>
					                                           	<div class="form-group col-md-3 ">
															    	<label for="monto">Costo de combo<span class="required">*</span></label>
															       	<div class="controls">
															       		<f:input type="text" class="form-control" onkeypress="return valida(event)" path="monto" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"  maxlength="10" required="required"/>
															    	</div>
																</div>


					                                        </div>
					                                        <div class="row col-xs-12">
					                                        	<div class="form-group col-md-12">
					                                                  <label for="descripcion">Descripci&oacute;n</label>
					                                                  <div class="controls">
					                                                  <f:textarea maxlength="100"  type="text" rows="3" data-validation-required-message="Este campo es requerido" required="required"  class="form-control" path="descripcion"  ></f:textarea>
					                                                  </div>
					                                           	</div>
					                                        </div>
					                                        <div class="row col-xs-12">
					                                        	<div class="form-group col-md-3">
															   		<label for="situacionFondo">Mascota</label>
															   		<f:checkbox id="chkMascota" path="mascota" />
															   		<div class="controls">
																		<f:select id="cbMascota" disabled="true" onchange="changeMascota()" path="mascotaBean.codigo" class="form-control">
																			<f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
																	  		<f:options  items="${lstMascota}"
																	            itemValue="codigo"
																	            itemLabel="nombre"/>
																			</f:select>
																	</div>
																</div>
																<div class="form-group col-md-3">
															   		<label >Fondo</label>
															   		<f:checkbox id="chkFondo"  path="fondo" />
															   		<div class="controls">
																		<f:select id="cbFondo" disabled="true" onchange="changeFondo()"  path="fondoBean.codigo" class="form-control">
																			<f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
																	  		<f:options  items="${lstFondo}"
																	            itemValue="codigo"
																	            itemLabel="nombre"/>
																			</f:select>
																	</div>
																</div>
																<div class="form-group col-md-2 ">
															    	<label for="monedas">Monedas</label>
															    	<f:checkbox id="chkMonedas" path="moneda" />
															       	<div class="controls">
															       		<f:input type="text" id="txtMonedas" onkeypress="return valida(event)" disabled="true" class="form-control" path="monedas" pattern="[0-9]{1,}"  maxlength="10"/>
															    	</div>
																</div>
																<div class="form-group col-md-2 ">
															    	<label for="gemas">Gemas</label>
															    	<f:checkbox id="chkGemas" path="gema" />
															       	<div class="controls">
															       		<f:input type="text" id="txtGemas"  onkeypress="return valida(event)" disabled="true" class="form-control" path="gemas" pattern="[0-9]{1,}"  maxlength="10" />
															    	</div>
																</div>


																<div class="form-group col-md-2">
															   		<label for="situacionFondo">Situaci&oacute;n<span class="required">*</span></label>
															   		<div class="controls">
																		<f:select id="lblSituacion"  path="situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
																			<f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
																	  		<f:options  items="${lstSituacion}"
																	            itemValue="codigoRegistro"
																	            itemLabel="nombreCorto"/>
																			</f:select>
																	</div>
																</div>
					                                        </div>

															<div class="row col-xs-12">
					                                            <div class="form-group col-md-12 text-right">
																	 <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/comboController/listado" id="cancelar">
                                                     						  <i class="fa fa-close"></i>   Cancelar
                                                    						  </a>
																	<button type="reset"  id="limpiar"    class="btn btn-flat btn-secondary">
					                                                	<i class="fa fa-eraser"></i> Limpiar
					                                                </button>
					                                               
					                                           			    
                                                    						   <button id="btn-save-reg"   class="btn btn-flat btn-primary" onclick="validarRequired('#frmRegistroCombo');">
					                                           			<i class="fa fa-floppy-o"></i> Guardar</button>
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
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->

    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script> -->
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
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
 
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script>
    $(document).ready(function(){
            if($('#chkMascota').is(":checked")) {
            	$("#cbMascota").attr("disabled",false);
            } else{
            	$("#cbMascota").attr("disabled",true).val("0");
            }

            if($('#chkFondo').is(":checked")) {
            	$("#cbFondo").attr("disabled",false);
            } else{
            	$("#cbFondo").attr("disabled",true).val("0");
            }
            if($('#chkMonedas').is(":checked")) {
            	$("#txtMonedas").attr("disabled",false);
            } else{
            	$("#txtMonedas").attr("disabled",true).val("0");
            }
            if($("#chkGemas").is(":checked")) {
            	$("#txtGemas").attr("disabled",false);
            } else{
            	$("#txtGemas").attr("disabled",true).val("0");
            }
    });
    function changeMascota(){
    	if($("#cbMascota").val()=="0" && $("#chkMascota").is(":checked")){
    		$("#chkMascota").prop("checked",false);
    		$("#cbMascota").prop("disabled",true);
    	}
    }
    function validarGrabar(){
 		return ejecutarGuardar;
 	}
    function changeFondo(){
    	if($("#cbFondo").val()=="0" && $("#chkFondo").is(":checked")){
    		$("#chkFondo").prop("checked",false);
    		$("#cbFondo").prop("disabled",true);
    	}
    }
    $('#chkMascota').change(function() {
        if($(this).is(":checked")) {
        	$("#cbMascota").attr("disabled",false);
        } else{
        	$("#cbMascota").attr("disabled",true).val("0");
        }
    });
    $('#chkFondo').change(function() {
        if($(this).is(":checked")) {
        	$("#cbFondo").attr("disabled",false);
        } else{
        	$("#cbFondo").attr("disabled",true).val("0");
        }
    });
    $('#chkMonedas').change(function() {
        if($(this).is(":checked")) {
        	$("#txtMonedas").attr("disabled",false);
        } else{
        	$("#txtMonedas").attr("disabled",true).val("0");
        }
    });
    $('#chkGemas').change(function() {
        if($(this).is(":checked")) {
        	$("#txtGemas").attr("disabled",false);
        } else{
        	$("#txtGemas").attr("disabled",true).val("0");
        }
    });
    </script>
  </body>
</html>