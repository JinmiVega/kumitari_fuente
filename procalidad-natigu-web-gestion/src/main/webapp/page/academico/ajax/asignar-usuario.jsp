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
    <title>Asignar Usuario</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
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
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
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
                  <li class="breadcrumb-item"><a href="#">General</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#">Asignar Usuario</a>
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
                                  <h4 class="card-title"> Asignar Usuario</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                    <f:form class="form" role="form" method="post" action="buscar">
                                      <div class="form-body">
                                        <div class="row">
                                          <div class="form-group col-md-4">
                                                <label for="situacionUsuario">Instituci&oacute;n</label>
                                               <f:select id="lblInstitu" path="inscripcionLenguaBean.inscripcionBean.institucion.codigo" class="select2 form-control">

															<f:options items="${lstInstitucion}" itemValue="codigo" itemLabel="nombreInstitucion" />
														</f:select>
                                            </div>
                                            <div class="form-group col-md-2 mb-2">
                                                <label for="projectinput1">C&oacute;digo Usuario</label>
<!--                                                 <input type="text" id="projectinput1" class="form-control" name="fname"> -->
  											<f:input type="text" id="idCodigoUsuario" class="form-control" onkeyup="validarCodigoUsuario();" path="usuarioBean.codigo"/>
                                            </div>

                                            <div class="form-group col-md-3 mb-2">
                                                <label for="projectinput2">Nombre Alumno</label>
                                                <f:input type="text" class="form-control" path="alumnoBean.personaBean.nombrePersona"/>
<!--                                                 <input type="text" id="projectinput2" class="form-control" name="lname"> -->
                                            </div>

                                            <div class="form-group col-md-3 mb-2">
                                              <label for="situacionUsuario">Situaci&oacute;n</label>
                                             <f:select  path="situacion.codigoRegistro" class="form-control">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-2 mb-2">
                                                <label>Nro Cupos total</label>
                                                <input id="nroCuposTotales" type="text" disabled value="0" class="form-control" name="fname">
                                            </div>
                                            <div class="form-group col-md-2 mb-2">
                                                <label>Cupos Asignados</label>
                                                <input id="nroCuposAsignados"  type="text" disabled value="0" class="form-control" name="fname">
                                            </div>
                                            <div class="form-group col-md-2 mb-2">
                                                <label>Cupos Libres</label>
                                                <input id="nroCuposLibres"  type="text" disabled value="0" class="form-control" name="fname">
                                            </div>
                                            <div class="form-group col-md-6 text-right">
                                                <button type="submit" class="btn btn-secondary mt-2">
                                                  <i class="ft-search"></i> Buscar
                                                </button>
                                            </div>
                                        </div>
                                        <div class="row">
                                          <div class="col-xs-12">
                                            <table class="table table-striped table-bordered zero-configuration">
                                                <thead>

                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Matr&iacute;cula</th>
                                                        <th>Usuario</th>
                                                        <th>Alumno</th>
                                                        <th>Lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="60">Acciones</th>
                                                    </tr>

                                                </thead>
                                                <tbody >
                                                  <c:forEach var="usuarioAlumno" items="${lstUsuarioMatricula}" varStatus="theCount">

                                                    <tr>
                                                        <td>${theCount.count}</td><!-- ${usuarioAlumno.inscripcionLenguaBean.inscripcionBean.institucion.codigo} -->
                                                        <td>${usuarioAlumno.matriculaBean.codigo}</td>
                                                        <td>${usuarioAlumno.usuarioBean.nombreUsuario}</td>
                                                        <td>${usuarioAlumno.alumnoBean.personaBean.nombreCompleto}</td>
                                                        <td>${usuarioAlumno.matriculaBean.lengua.nombre}</td>
                                                        <td>${usuarioAlumno.situacion.nombreCorto}</td>
                                                         <td>
                                                          <c:if test="${usuarioAlumno.situacion.codigoRegistro ==1}">
                                                           <a title="Retirar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${usuarioAlumno.codigo}"><i class="icon-trash"></i></a>
<!--                                                           <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Retirrar" onclick="confirmar_accion();"><i class="icon-trash"></i></button> -->
														</c:if>
															<c:if test="${usuarioAlumno.situacion.codigoRegistro ==2}">
   															<button type="button" class="btn_asignar_alumno btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip" onclick="asignar_usuario()"  data-original-title="Asignar"><i class="icon-pencil"></i></button>
                                                        </c:if>
<!--                                                           <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Retirrar" onclick="confirmar_accion();"><i class="icon-trash"></i></button> -->
                                                        </td>
                                                    </tr>
                                                     </c:forEach>




                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Matr&iacute;cula</th>
                                                        <th>Usuario</th>
                                                        <th>Alumno</th>
                                                        <th>Lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
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
    <jsp:include page="${pageContext.request.contextPath}/../layout/asignar-alumno-modal-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/select/form-select2.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->


     <script type="text/javascript" charset="utf-8" >
     $( document ).ready(function() {
    	 obtenerCupos();
    	});

function validarCodigoUsuario(){

	if(document.getElementById("idCodigoUsuario").value==0){
		document.getElementById("idCodigoUsuario").value=0;
		}

}

     function obtenerCupos(){

			var codinst =$('#lblInstitu').val();

			var html = "";
			$.ajax({

				type : "GET",

				url : "${pageContext.request.contextPath}/asignarUsuarioController/numerocupos?codigoinst="+codinst,
//				data : {codigoinst:numero},

				success : function(data) {

	 				$('#nroCuposTotales').val(data[0]);
	 				$('#nroCuposAsignados').val(data[1]);
	 				$('#nroCuposLibres').val(data[2]);
				},
				error : function() {
					//console.log("ERROR: ");
				}
			});

	}


       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }
       function asignar_usuario(){
           $('#alumno-modal').modal('show');
          }
    </script>
  </body>
</html>