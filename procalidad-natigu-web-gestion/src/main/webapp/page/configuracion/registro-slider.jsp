<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title id="titulo_web">Registro de slider</title>
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
    ejecutarGuardar = false;
    
    function validateName(){

		var value = $('#nombreSlider').val();
	    var listword = value.split(" ");
	    var newWord = "";
		for (var i = 0; i < listword.length; i++) {
			if(listword[i].length>0){
				newWord+=listword[i]+" ";
			}
		}
		newWord = newWord.substring(0,newWord.length-1);
		$('#nombreSlider').val(newWord);
	}

    function validarRequired(idfrom){
    validateName();
    var $myForm = $(idfrom);

    var nombre = document.getElementById("nombreSlider");
	var situacion = document.getElementById("lblSituacion");
    if(! $myForm[0].checkValidity() || nombre == '' || situacion == '') {
    	$("#nombre").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#situacion").css("border", "2px solid rgba(22, 211, 154, .5)");
       msg_advertencia("Debe completar correctamente todos los campos requeridos");

        if(nombre == null || nombre.length <= 0){
			$("#nombreSlider").css("border", "2px solid rgba(210, 60, 60, .5)");
			nombre.focus();
		   }
		if(situacion == null || situacion.length <= 0){
			$("#lblSituacion").css("border", "2px solid rgba(210, 60, 60, .5)");
			$("#lblSituacion").css("border", "2px solid rgba(210, 60, 60, .5)");
			situacion.focus();
		}

    } else {
    	ejecutarGuardar = true;
    }

  }

       $(document).ready(function() {
//     	   validarRequired(frmRegistroSlider);
     var msj = $("#mensaje").val();//1
     if(msj=='1'){
       msg_exito();
     }else if(msj=='0'){
       msg_advertencia("Ya existe un registro con ese nombre");
     }
       var codigo = document.getElementById("codigoSlider").value;
      if (codigo != '0') {
         $("#limpiar").attr("disabled", true);
    	 $('#titulo_slider').html("Modificar slider");
    	 $('#titulo_web').html("Modificar slider");
		 
      $("#cancelar").removeAttr("href")
      $("#cancelar").attr("href","${pageContext.request.contextPath}/sliderController/buscar");
       }else{
      	  $("#cancelar").removeAttr("href")
  			$("#cancelar").attr("href","${pageContext.request.contextPath}/sliderController/listado");
  			 
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

    <input type="hidden" name="country" value="${pageContext.request.contextPath}">
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
                   <li class="breadcrumb-item"> Configuraci&oacute;n 
                  </li>
                    <li class="breadcrumb-item active"> Sliders
                  </li>
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
                       <f:form id="frmRegistroSlider" class="form-horizontal" role="form"  enctype="multipart/form-data" method="post" action="grabar" novalidate="true" onSubmit="return validarGrabar()">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id = "titulo_slider"> Registro de slider</h4>
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
                                      <form class="form">
                                        <div class="form-body">


                                          <div class="row">
                                                <f:input type="hidden" path="sliderBean.codigo"  id="codigoSlider"/>
                                          <%--
                                           <div class="form-group col-md-2">
                                                <label for="nombr">Nombre<span class="required">*</span></label>
                                                <div class="controls">

                                                  <f:input type="text" class="form-control" id="nombreSlider" name="nombreSlider" path="nombre" data-validation-required-message="Este campo es requerido" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]+" required="required" />
                                                </div>
                                           </div>
                                           --%>
                                           <div class="form-group col-md-3">
                                                  <label for="apellidoPaterno">Nombre de slider <span class="required">*</span></label>
                                                  <div class="controls">
                                                      <f:input type="text" id="nombreSlider" class="form-control" name="nombreSlider"  path="SliderBean.nombre"  data-validation-required-message="Este campo es requerido"  required="required" maxlength="70"/>
                                                  </div>
                                           </div>

                                           <div class="form-group col-md-5">
                                             <div class="controls">
                                                    <label for="descripci">Descripci&oacute;n</label>
                                                    <f:input type="text" class="form-control" path="SliderBean.descripcion" maxlength="70"/>
                                              </div>
                                            </div>

 											<div class="form-group col-md-2">
                                                <label for="situacionSlider">Situaci&oacute;n<span class="required">*</span></label>
                                                <div class="controls">
                                                <f:select id="lblSituacion" onchange="onColorVerde('#combodistrito');" path="SliderBean.situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
	                                                <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
	                                                <f:options  items="${lstSituacion}"
	                                                            itemValue="codigoRegistro"
	                                                            itemLabel="nombreCorto"/>
                                            </f:select>
                                            </div>
                                              </div>

                                           <div class="form-group col-md-12 text-right">
                                             <div class="controls">
                                                    <label for="" style="height: 15px;display: block;"></label>
                                                   <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/sliderController/listado" id="cancelar">
                                                     	 <i class="fa fa-close"></i> 					   Cancelar
                                                    						  </a>
                                                  <button type="reset"  id="limpiar"    class="btn btn-flat btn-secondary">
                                                    <i class="fa fa-eraser"></i> Limpiar
                                                  </button>
                                                   <button id="btn-save-reg" type="submit" class="btn btn-flat btn-primary" onclick="validarRequired('#frmRegistroSlider');" >
                                            		<i class="fa fa-floppy-o"></i> Guardar
                                         			</button>
                                         			  

                                              </div>
                                            </div>
                                          </div>


                                          <div class="row">
                                            <div class="form-group col-md-12">
                                              <hr>
                                            </div>
                                          </div>

										<c:if test="${sliderForm.sliderBean.codigo > 0}">

                                          <div class="row">
                                            <div class="form-group col-md-12 text-right">
                                              <button type="button" class="btn btn-outline-secondary btn-min-width mb-1" onclick="mdUloadImg()"><i class="icon-plus"></i> Agregar imagen</button>
                                            </div>
                                          </div>

                                          <div class="row" id="idRowListaDetalle">


                                          	<c:forEach var="sliderDetalleBean" items="${lstSliderDetalleBean}">
                                          	<div class="col-md-4">


	                                              <img src="${pageContext.request.contextPath}/slider/${sliderDetalleBean.nombreSlider}" alt= "${sliderDetalleBean.nombreSlider}" class="img-thumbnail img-fluid">
	                                              <div class="box-edit text-right">
 	                                                <span class="date-img">${sliderDetalleBean.strFechaCreacion}</span>
	                                                <button type="button" onclick="eliminarSliderDetalle(${sliderDetalleBean.codigo})" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-placement="top" data-original-title="Eliminar"><i class="icon-trash"></i></button>
	                                              </div>
	                                            </div>
                                          	</c:forEach>



                                          </div>
                                          </c:if>


                                        </div>
                                </f:form>
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
  <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
  <jsp:include page="${pageContext.request.contextPath}/../layout/upload-img-modal-view.jsp" />

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
    <!-- END PAGE LEVEL JS-->
  
    <script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript"></script>

    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
      <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf-8">
     function mdUloadImg(){

         cargarModal();
         resetFileInput();
     }
     function validarGrabar(){
 		return ejecutarGuardar;
 	}

     function cargarModal() {

		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/sliderController/cargarModal",

			success : function(data) {
				//console.log("SUCCESS: ", data);

				$("#file").val("");

				$("#bootstrap #md_upload-img").append(data);
				$(".optionReset").val("");
				$("#md_upload-img").modal("show");

			},
			error : function() {
				//console.log("ERROR: ");
				msg_advertencia("Ocurrio un error");
			}
		});
		return false;

	}

     function eliminarSliderDetalle(id) {

    	var result = false;

 		$.ajax({
 			type : "GET",
			data : "codigo="+id,
 			url : "${pageContext.request.contextPath}/sliderController/eliminarSliderDetalle",

 			success : function(data) {
 				//console.log("SUCCESS: ", data);

 				if(data=='1'){
 					result = true;
 				}

 			},
 			error : function() {
 				//console.log("ERROR: ");
 				msg_advertencia("Ocurrio un error");
 			},
 			complete : function() {
 				if(result){
 					refrescarListaSliderDetalle();
 				}
 			}
 		});

 	}

     function refrescarListaSliderDetalle() {

    	var codigoSlider = $('#codigoSlider').val();
    	var html='';

 		$.ajax({
 			type : "GET",
 			data : "codigo="+codigoSlider,
 			url : "${pageContext.request.contextPath}/sliderController/refrescarListaSliderDetalle",

 			success : function(data) {
 				//console.log("SUCCESS: ", data);
 				
				//alert(data);
				
 				if(data!=null && data.length>0){
 					for (var i = 0; i < data.length; i++) {
 						var sliderDetslle = data[i];

 						html+= '<div class="col-md-4">';
 						if(sliderDetslle.nombreSlider!=null){
 							html+= '<img src="${pageContext.request.contextPath}/slider/'+sliderDetslle.nombreSlider+'" alt="'+sliderDetslle.nombreSlider+'" class="img-thumbnail img-fluid">';
 						}else{
 							html+= '<img src="${pageContext.request.contextPath}/assets/img/slider/slider-02.jpg" alt="No Imagen" class="img-thumbnail img-fluid">';
 						}
                        html+= '<div class="box-edit text-right">'+
                        	'<span class="date-img">"'+sliderDetslle.strFechaCreacion+'"</span>'+
 //                          '<span class="date-img">29/08/2017</span>'+
                          '<button type="button" onclick="eliminarSliderDetalle('+sliderDetslle.codigo+')" class="btn btn-icon btn-pure danger" data-toggle="tooltip" data-placement="top" data-original-title="Eliminar"><i class="icon-trash"></i></button>'+
                        '</div>'+
                      '</div>';
					}
 					//console.log(html);
 					$('#idRowListaDetalle').empty();
 					$('#idRowListaDetalle').html(html);
 				}else{
 					$('#idRowListaDetalle').empty();
 				}

 			},
 			error : function() {
 				//console.log("ERROR: ");
 				msg_advertencia("Ocurrio un error");
 			}
 		});

 	}


    </script>
  </body>
</html>