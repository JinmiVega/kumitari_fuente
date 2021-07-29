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
    <title>Listado de estudiantes</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
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

    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

 <script type="text/javascript">
	  $(document).ready(function() {
		//variable global
		prmCodigo = "";
		//Mensaje de Validacion
		var msj = $("#mensaje").val();//1
		if(msj=='1'){
			msg_exito();
		}else if(msj=='0'){
			msg_error();
		}
		//location.href ="buscar";
	 });

	function validatee(){
		if(document.getElementById("codigo").value==0){
			document.getElementById("codigo").value="0";
		}
	}

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

    <!-- //////////////////////////////////////////////////////////////////////////// -->


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
                  <li class="breadcrumb-item"><a href="#" style="cursor: default;">Acad&eacute;mico</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#" style="cursor: default;">Estudiante</a>
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
                        <f:form id="frmRegistroAlumno" class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/alumnoController/buscar">
	                      <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title">Listado de estudiantes </h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      <!-- 
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                      -->
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                    <form class="form">
                                      <div class="form-body">
                                        <div class="row">
                                        <%--
                                            <div class="form-group col-md-2  mb-2">
	                                            <label for="codigo">C&oacute;digo Estudiante</label>
	                                             <div class="controls">
	                                                 <f:input type="text" id="codigo"  onchange="validatee();" class="form-control" name="codigo" path="codigo" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"  />
	                                            </div>
                                            </div>
										--%>
                                            <div class="form-group col-md-4 mb-2">
                                                <label for="nombrePersona">Nombre de estudiante</label>
                                                <div class="controls">
                                                 	<f:input type="text" id="nombrePersona" class="form-control" name="nombrePersona" path="personaBean.nombrePersona" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]{0,}" maxlength="30"/>
                                            	 </div>
                                            </div>

                                             <div class="form-group col-md-2 mb-2">
                                                <label for="numeroDocumento">N&uacute;mero de documento</label>
                                                <div class="controls">
                                                <f:input type="text" id="numeroDocumento" class="form-control numdoc" name="numeroDocumento" path="personaBean.numeroDocumento"  pattern="[0-9]{0,8}" maxlength="15"/>
                                            	</div>
                                            </div>

                                            <div class="form-group col-md-4 mb-2">
                                            <div class="controls">
                                                <label for="nombreInstitucion">Nombre de instituci&oacute;n</label>
                                                <f:input type="text" id="nombreInstitucion" class="form-control" name="nombreInstitucion" path="institucionBean.nombreInstitucion" pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]{0,}" maxlength="80"/>
                                            </div>
                                             </div>



                                            <div class="form-group col-md-2 mb-2">
                                              <label for="situacionUsuario">Situaci&oacute;n</label>
                                               <f:select id="tm1Situacion" name="tm1Situacion" path="tm1Situacion.codigoRegistro" class="form-control select-del">
                                                    <f:option value="0" selected=""  label="Todos" />
                                                    <f:options  items="${lstSituacion}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                                	</f:select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-12 text-right">
                                                <a href="nuevo" class="btn btn-primary" title=""> <i class="icon-plus"></i> Nuevo</a>
                                                <button onclick="limpiarFiltrosv2('#frmRegistroAlumno');limpiarDataTable('#tblListaAlumno');" type="button" class="btn btn-flat btn-secondary">
		                                                    <i class="fa fa-eraser"></i> Limpiar
		                                                </button>
                                                <button type="submit" class="btn btn-secondary" >
                                                  <i class="ft-search"></i> Buscar
                                                </button>
                                            </div>
                                        </div>
                                        <div class="row">
                                          <div class="col-xs-12" id="tagListaAlumno">
                                            <table id="tblListaAlumno" class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                    	<th>N°</th>
                                                        <th>Nombre de estudiante</th>
                                                        <th>Nombre de instituci&oacute;n</th>
                                                        <th>N&uacute;mero de documento</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="60">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="alumnoBean" items="${lstAlumnoBean}" varStatus="theCount">
                                                  <tr>
                                                 	 <td>${theCount.count}</td>
                                                   	<td>${alumnoBean.personaBean.nombrePersona} ${alumnoBean.personaBean.apellidoPaterno} ${alumnoBean.personaBean.apellidoMaterno}</td>
                                                    <td>${alumnoBean.institucionBean.nombreInstitucion}</td>
                                                    <td>${alumnoBean.transformDNI(alumnoBean.personaBean.numeroDocumento)}</td>
                                                    <td>${alumnoBean.tm1Situacion.nombreCorto}</td>
                                                    <td>
                                                    <!--
                                                      <button type="button" class="btn btn-outline-success btn-sm "
                                                      data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                    -->
                                                     <a title="Modificar" 
                                                         	data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm"
                                                         	onclick="javascript:modificarElementoGenerico('/alumnoController/modificar','${alumnoBean.codigo}')"
                                                         	><i class="icon-pencil"></i></a>
                                                    <!-- 
                                                         <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" href="modificar?codigo=${alumnoBean.codigo}"><i class="icon-pencil"></i></a>
                                                      -->
                                                     <!--  <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${alumnoBean.codigo}"><i class="icon-trash"></i></a> -->
													<button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="Eliminar" data-original-title="Eliminar" onclick="confirmar_accion('${alumnoBean.codigo}');"><i class="icon-trash"></i></button>
                                                    </td>
                                                   </tr>
                                                 </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                    	<th>N°</th>
                                                        <th>Nombre de estudiante</th>
                                                        <th>Nombre de instituci&oacute;n</th>
                                                        <th>N&uacute;mero de documento</th>
                                                        <th>Situaci&oacute;n</th>
                                                        <th>Acciones</th>
                                                    </tr>
                                                </tfoot>

                                            </table>
                                          </div>
                                        </div>
                                      </div>
                                    </form>
                                  </div>
                              </div>
                          </div>
                        </f:form>
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
    <jsp:include page="../../layout/confirmacion-modal-view.jsp" />
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>

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
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <!--  <script type="text/javascript" charset="utf-8" >
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
    </script>-->
    <script type="text/javascript">
    //LEVANTAR MODAL
    function confirmar_accion(codigo){
        prmCodigo = codigo;
        $('#md_confirmacion').modal('show');
     }

    //CLICK EN CONFIRMAR DEL MODAL
    $( "#btnConfirmarGeneric" ).click(function() {
        
		iniciarBloqueo();
        //location.href ="eliminar?codigo="+prmCodigo;
		$.ajax({
          url : "${pageContext.request.contextPath}/alumnoController/eliminar?codigo="+prmCodigo,
          type : 'GET',
          success : function(data) {

			  //$("#tagListaAlumno").html(data);
              
        	  $('#md_confirmacion').modal('hide');
        	  finBloqueo();
        	  msg_exito();
        	  location.href ="buscar";
          },
          error : function(request, status, error) {
            //alert(error);
          }
        });
	
		
      });

    function crypt(){
		return "hola";
    }

    </script>
  </body>
</html>