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
    <title>Listado de glosarios</title>
    <link rel="apple-touch-icon" href="../app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/checkboxes-radios.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
  <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

  </head>
  <body data-open="click" id="paginaGlosario" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">
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
                   <li class="breadcrumb-item">Configuraci&oacute;n
                  </li>
                  <li class="breadcrumb-item active">Glosario 
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>

        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title">Listado de glosarios </h4>
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
                                     <f:form method="GET" action="buscar" id="formularioBusqueda">
                                      <div class="form-body">
                                        <div class="row">

                                            <div class="form-group col-md-3 mb-2">

                                                <label for="situacionModal">Lengua </label>

                                                <f:select id="codLenguaGlosario"  path="lenguaBean.codigo" class="form-control select-del"
                                               >
                                               <f:option value="0" selected="true" disabled="disabled" label="Seleccionar"/>
                                                  <f:options  items="${lstLenguaBean}"
                                                            itemValue="codigo"
                                                            itemLabel="nombre"/>
                                            </f:select>
                                                </div>


                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-12 text-right">
                                                <a href="${pageContext.request.contextPath}/glosarioController/nuevo"
                                                class="btn btn-primary" title=""> <i class="icon-plus"></i> Nuevo</a>
<!-- 													<button onclick="limpiarFiltros('#formularioBusqueda')" type="button" class="btn btn-flat btn-secondary"> -->
													<a href="${pageContext.request.contextPath}/glosarioController/listado" class="btn btn-flat btn-secondary">
													 <i class="fa fa-eraser"></i> Limpiar
													</a>
		                                                   
<!-- 		                                                </button> -->
                                                <button class="btn btn-flat btn-secondary" id="buscarGlosario" type="submit">
                                                 <i class="ft-search"></i> Buscar</button>
                                            </div>
                                        </div>
                                        <div class="row">
                                          <div class="col-xs-12" id ="bodyListadoGlosario">
                                            <table class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                    	<th  width="50">N°</th>
                                                    	<th>Lengua</th>
                                                        <th>Archivo</th>
                                                        <th>Peso (byte)</th>
														
                                                         <th width="60">Acciones</th>


                                                    </tr>
                                                </thead>
                                                <tbody>
											<c:forEach var="glosario"
											items="${lstGlosarioBean}" varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${glosario.lenguaBean.nombre}</td>
												<td>${glosario.fileName}</td>
												<td>${glosario.peso}</td>


												<td>
												<!-- 
													<button type="button" class="btn btn-outline-success btn-sm "
	                                                          data-toggle="tooltip"   data-original-title="Modificar" onclick="modificarGlosario(${glosario.codigoGlosario},'${pageContext.request.contextPath}/glosarioController');"><i class="icon-pencil"></i></button>
												-->
												 <a title="Modificar" 
                                                    	data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm"
                                                    	onclick="javascript:modificarElementoGenerico('/glosarioController/modificar','${glosario.codigoGlosario}')"
                                                    	><i class="icon-pencil"></i></a>

													<button type="button"
														class="btn btn-outline-danger btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														onclick="confirmar_eliminar(${glosario.codigoGlosario})"
														data-original-title="Eliminar">
														<%--id="eliminarLengua${loop.index}" --%>
														<i class="icon-trash"></i>
													</button></td>

											</tr>
										</c:forEach>
										 </tbody>
										<tfoot>
										 
                                                    <tr>
                                                    	<th  width="50">N°</th>
                                                    	<th>Lengua</th>
                                                        <th>Archivo</th>
                                                        <th>Peso (byte)</th>
														
                                                         <th width="60">Acciones</th>


                                                    </tr>
                                           
										</tfoot>

                                            </table>
                                          </div>
                                        </div>
                                      </div>
                                    </f:form>
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
    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
    <!-- BEGIN VENDOR JS-->
   <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
<!--     <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script> -->
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <!--estodearribasirve -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

        <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
<!--     <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script> -->
 <!--    <script src="../app-assets/js/core/app.js" type="text/javascript"></script> -->
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->

    <!-- END PAGE LEVEL JS-->

<%--     <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script> --%>

    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js" type="text/javascript"></script>
<%--     <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script> --%>

 	<script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>

<script>
  var accion_tab = "";
  var codigoEliminar="";

  function confirmar_eliminar(codigo){
	 // debugger;
  	//console.log("entro a coonfirmar eliminar");
  	codigoEliminar = codigo;
  	$('#md_confirmacion').modal('show');

  };
  $('#btnConfirmarGeneric').click(function() {
	  //console.log("entro a btnConfirmarGeneric");
	  eliminarGlosario(codigoEliminar);
	});

  function modificarGlosario(id,prmUrl){
	  iniciarBloqueo();
    	 var codigo = id;

    	var dirURL = prmUrl;
    	 dirURL += "/modificar";
	        $.ajax({
	          url : dirURL,
	          type : 'GET',
	          data : {
	        	  		codigo : codigo
		          },
	          success : function(data) {
		        //  console.log("resultado: ",data);
		          $("#paginaGlosario").html(data);

	          },
	          error : function(request, status, error) {
	        	//alert(error);
	          },
	          complete: function(){
	        	 // $('#md_confirmacion').modal('hidden');
	        	  finBloqueo();
		      }
	        });

 };

  function eliminarGlosario(codigo){

	        $.ajax({
	          url : "${pageContext.request.contextPath}/glosarioController/eliminar",
	          type : 'POST',
	          data : {
      	  		codigo : codigo
	          },
	          success : function(data) {

		        	 $('#md_confirmacion').modal('hide');
		        	  refrescarTablaListadoGlosario();
		        	  msg_exito();



	          },
	          error : function(request, status, error) {
	        	//alert(error);
	          }
	         });
    		};
         	 function refrescarTablaListadoGlosario() {
       			$.ajax({
     	   			url : "${pageContext.request.contextPath}/glosarioController/recargarListado",
     	   			type : 'POST',
	     	   		data : {
	     	   			glosarioBean : {
	     	   					lenguaBean : {codigo : $("#codLenguaGlosario").val()}
		     	   			}
	    	          },
     	   			success : function(data) {
     	   				console.log("SUCCESS: ", data);
     	   				$('#bodyListadoGlosario').html(data);


     	   			},
     	   			error : function() {
     	   				//console.log("ERROR: ");
     	   			}
       		});

       	}

             function limpiarFiltros(form){ 
      		 	$(form+" input[type='text']").val("");
           	$(form+" input[type='date']").val("");
           	$(form+" .select-del").prop('selectedIndex',0);
          // 	$('#bodyListadoGlosario').empty();
           
           	
      		 }

 </script>

  </body>
</html>