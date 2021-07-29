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
    <title>Registro de modal</title>
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

<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->

<script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
 
    <script type="text/javascript">

		function validateName(){

			var value = $('#nombremodal').val();
		    var listword = value.split(" ");
		    var newWord = "";
			for (var i = 0; i < listword.length; i++) {
				if(listword[i].length>0){
					console.log('i',i);
					newWord+=listword[i]+" ";
				}
			}
			newWord = newWord.substring(0,newWord.length-1);
			$('#nombremodal').val(newWord);
		}
    
       function validarRequired(idfrom){
    	    validateName();
		    var $myForm = $(idfrom);
		    if(! $myForm[0].checkValidity()) {
		       msg_advertencia("Debe completar correctamente todos los campos requeridos");
		    }
	  }
       $(document).ready(function() {
    	   setInputHidden();
		    var msj = $("#mensaje").val();//1
		    if(msj=='1'){
		      msg_exito();
		    }else if(msj=='0'){
		      msg_advertencia("Ya existe un registro con ese nombre");
		    }
	//       var codigo = document.getElementById("codigoModal2").value;
	//       alert(codigo);
	//       if (codigo != '0') {
	//         $("#limpiar").css("display", "none");
	//       }
    });
	
       
       function setInputHidden(){

     	  var tipo =$("#codigomodal").val();

           if (tipo != "0") {
        	   $("#limpiar").css("display", "none");
         	  $("#titulo_modal").text('Modifcar modal');
         	  
 		}  

       }
       
       
        function handleFileSelect(evt)
  {
    var files = evt.target.files; // FileList object

      // Loop through the FileList and render image files as thumbnails.
      for (var i = 0, f; f = files[i]; i++)
    {
          // Only process image files.
        if (!f.type.match('image.*'))
      {
            continue;
        }
        var reader = new FileReader();
          // Closure to capture the file information.
        reader.onload = (function(theFile)
        {
          return function(e)
          {

              document.getElementById("list").innerHTML = ['<img class="img-fluid" alt="Responsive image" onclick="obtener_imagen()" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');

            };
      })(f);

        reader.readAsDataURL(f);
      }
  }

  function obtener_imagen()
    {
      document.getElementById('file4').click();
    }


    </script>

    <style>
          .thumb {
            height: 220px;
            border: 0px solid #000;
            margin: 10px 5px 0 0;
            max-height: 220px;
            max-width: 220px;
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
                   <li class="breadcrumb-item">Configuracion</a>
                  </li>
                  <li class="breadcrumb-item active"> Modal</a>
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
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id="titulo_modal"> Registro de modal</h4>
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
                                     <f:form id="frmRegistroModal" class="form-horizontal" role="form"   enctype="multipart/form-data" method="post" action="grabar" novalidate="true">
                                  <div class="form-body">

                                  <!--
                                  <div class="col-xs-5">
                                         <div class="form-group">
                                          <c:if test="${ empty modalBean.imagenNombre}">
                                         <div class="controls">
                                      <f:input type="file" class="filestyle" path="file" id="" data-validation-required-message="Este campo es requerido"/>
                                         </div>
                                         </c:if>
                                         <c:if test="${not empty modalBean.imagenNombre}">
                                      <f:input type="file" class="filestyle" path="file" id=""  />
                                           <img class="media-object "   src="${pageContext.request.contextPath}/modal/${modalBean.imagenNombre}" alt="Generic placeholder image" style="width: 90px;height: 64px;" />
                                         </c:if>
                                         </div>
                                  </div>  -->



                                          <div class="form-group col-md-3"  >
                                          <center><label> Imagen <i title="Formato aceptado .jpg, .png, .jpeg - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" 
                                                  	data-original-title="Formato aceptado .jpg, .png, .jpeg - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i>  </label></center>
                                          <div id="list"   style="cursor: pointer;">
                                             <c:choose>
                                               <c:when test="${not empty modalBean.imagenNombre}">
                                                <label for=""><img onclick="obtener_imagen()" src="${pageContext.request.contextPath}/modal/${modalBean.imagenNombre}" alt="${modalBean.imagenNombre}"  class="img-fluid" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label>
                                              </c:when>
                                              <c:otherwise>
                                                <label for=""><img src="../assets/img/usar_imagen.jpg" onclick="obtener_imagen()" alt="element 01" class="img-fluid" style="cursor: pointer;"></label>
                                              </c:otherwise>
                                             </c:choose>
                                          </div></div>



                                          <div class="row">
                                         <%--  <div class="form-group col-md-3">
                                                <label for="situacionUsuario">Tipo <span class="required">*</span></label>
                                                <div class="controls">
                                                 <f:select id="lblTipo"  path="tipo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                 <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                            <f:options  items="${lstTipo}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                                  </f:select>
                                                </div>
                                            </div> --%>
                                           <div class="form-group col-md-3 ">
                                                  <label for="nombre">Nombre de modal<span class="required">*</span></label>
                                                  <div class="controls">
                                                  <f:input type="hidden" path="codigo"  id="codigomodal"/>
                                                  <f:input type="text" class="form-control" id="nombremodal"  path="nombre" data-validation-required-message="Este campo es requerido" required="required" maxlength="70" />
                                                 <input type="hidden"  id="codigomodal2"   value = "${modalBean.codigo}"   /> 
                                                  </div>
                                           </div>


                                            <div class="row">

                                             <div class="form-group col-md-2">
                                                <label for="situacionModal">Situaci&oacute;n<span class="required">*</span></label>
                                                <div class="controls">
                                                <f:select id="lblSituacion"  path="situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                               <f:option value="" selected="true" disabled="disabled" label="Seleccionar"/>
                                                  <f:options  items="${lstSituacion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            </f:select>
                                            </div>
                                            </div>

                                            <div class="form-group col-md-8 text-right">
                                               <a class="btn btn-secondary mr-1" href = "${pageContext.request.contextPath}/modalController/listado">
                                                  <i class="fa fa-close"></i> Cancelar
                                                      </a>
                                                   <button type="reset"  id="limpiar"    class="btn btn-flat btn-secondary">
                                                    <i class="fa fa-eraser"></i> Limpiar
                                                  </button>
                                                  <button id="btn-save-reg" type="submit"
                                            class="btn btn-flat btn-primary" onclick="validarRequired('#frmRegistroModal');">
                                           <i class="fa fa-floppy-o"></i>
                                            Guardar
                                          </button>
                                         
                                    </div>

                                             <div class="form-group col-md-11 ">
                                            <c:if  test="${ empty modalBean.imagenNombre}">
                                  <div class="controls">
                                   <f:input  type="file"  style="display:none" path="file"   required="required"  onchange="handleFileSelect(event);" name="files[]" id="file4" data-validation-required-message="Se requiere Imagen"/>
                                   </div>  </c:if>
                                   <c:if  test="${not empty modalBean.imagenNombre}">

                                   <f:input style="display:none" type="file"  path="file"    onchange="handleFileSelect(event);" name="files[]" id="file4"   accept="application/jpg, .png, .jpeg"/>
                                     </c:if></div>

                                          </div>

                                           </div>


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
    <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>


<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
  </body>
</html>