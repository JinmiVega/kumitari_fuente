<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Matr&iacute;cula - Registro</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
	   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">

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

  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">

   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">


    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

<script>


function ejecutarFunctionusuarios(){
	listadosUsuarioAlumno();
}

		      function listadosUsuarioAlumno(){

				 	var codigoInst =$('#lblInstitu').val();
					var codigoSitu= 0;
					var codigoinscLen = $('#codigoInscripcionDetalle').val();

					var html = "";
					iniciarBloqueo();
					$.ajax({
						type : "GET",//listadousuarios
						url : "${pageContext.request.contextPath}/asignarUsuarioController/recargarlistadousuarios?codigoInst="+codigoInst+"&situacion="+codigoSitu+"&codinscrlen="+codigoinscLen,
						success : function(data) {
			  			/* 	for(var i=0;i<data.length;i++){

									//<td>"+data[i].inscripcionLenguaBean.inscripcionBean.institucion.codigo+"</td><td>"+data[i].matriculaBean.codigo+"</td>
			  					html=html+"<tr><td>"+data[i].usuarioBean.nombreUsuario+"</td><td>"+data[i].alumnoBean.personaBean.nombreCompleto+"</td><td>"+data[i].matriculaBean.lengua.nombre+"</td><td>"+data[i].situacion.nombreCorto+"</td>";

								if(data[i].situacion.codigoRegistro ==1){
									html=html+"<td>  <button type='button' onclick='confirmar_accion_1(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button>  </td>";
									}

								if(data[i].situacion.codigoRegistro ==2){
									html=html+"<td> -- </td>";
								}


			  					html=html+"</tr>";

			  					}
			  				document.getElementById("idTablaUsuarioMatricula").innerHTML=html; */
							/* console.log("SUCCESS: ", data); */
							$('#listadoDetalleMatAlumno').html(data);

						},
						error : function() {
							/* console.log("ERROR: "); */
						},
					    complete: function(){
					    	finBloqueo();
				        }
					});

				 }

		      function confirmar_accion_1(codigo){
		           prmCodigoEliminarUsuario = codigo;
		           tipoTab="3";
		           $('#md_confirmacion').modal('show');
		        }


		      function darDeBajaUsuarioAsignado(codigoAlumno){



					var html = "";
					iniciarBloqueo();
					$.ajax({
						type : "GET",
						url : "${pageContext.request.contextPath}/asignarUsuarioController/bajausuarioasignado?codigo="+codigoAlumno,
						success : function(data) {

							if(data=="1"){
								listadosUsuarioAlumno();
								msg_exito();
								}else{

									msg_info('Ocurrio un Error al Eliminar');
									}

						},
						error : function() {
							/* console.log("ERROR: "); */
						},
					    complete: function(){
					    	finBloqueo();
				        }
					});

				 }




		      $(document).ready(function(){

		    	  $('#lblInstitu').prop('disabled', true);
		    	  $('#lblLengua').prop('disabled', true);
		    	  $('#lblPeriodo').prop('disabled', true);
		    	  $('#lblciclo').prop('disabled', true);
		    	  $('#inscripcionDetalle').prop('disabled', true);
		    	  $('#lblNivel').prop('disabled', true);



		    	  var codDetalleInsLeng =$('#codigoInscripcionDetalle').val();
		    	  if(codDetalleInsLeng=='0'){
		    		  $('#codigoInscripcionDetalle').val('');
		    	  }


		    	  if ( $('#codigoMatricula').val()>=1) {
		    		  $('#limpiar').attr("disabled", true);
		    		  $('#idtituloM').text("Modificar matrícula");
		    		  $(document).attr("title", "Modificar matrícula");
					}else{
						 $("#lblEstadoMatricula").val("2");
					}


		    	  var prmCodigoMatriculaAlumno = "";
		    	  var prmCodigoMatriculaDocente = "";
		    	  var tipoTab = "";
		    	  var prmCodigoEliminarUsuario="";

		/* 		      $('#lblLengua').change(function () {

				    	  var numero =document.getElementById("lblInstitu").value;
					      var poblacio = document.getElementById("lblLengua").value;
			    	 		$.ajax({
				    			type : "POST",

				    			url : "${pageContext.request.contextPath}/matriculaController/obtenerNumCupos",
				    			data : {codigoinst:numero,codigolengua:poblacio},

				    			success : function(data) {
				    				console.log("SUCCESS: ", data);

				    				$('#numCupos').val(data);

				    			},
				    			error : function() {
				    				console.log("ERROR: ");

				    				 alert(numero+" -" +poblacio+"-");
			    				}
			    			});

				      }); */


				      var msj = $("#mensaje").val();//1
				  	if(msj=='1'){
				  		msg_exito();
				  	}else if(msj=='0'){
				  		msg_error();
				  	}

				      var msjmensajeNumCu = $("#mensajeNumCu").val();//1
					  	if(msjmensajeNumCu=='1'){
					  		msg_info('El numero de Cupos esta en 0, por lo tanto ya no puede hacer mas registros.');
					  	}



				  	var valor = $(".optionReset").val();
				  /* 	if(valor=='0'){ */
				  		$(".optionReset").val("");
				 /*  	} */

				  		/* $('#botonagregarDetalle').click(function() {

				  	        var valores = "";

				  	        // Obtenemos todos los valores contenidos en los <td> de la fila
				  	        // seleccionada
				  	        $(this).parents('#idTablainscripcionLenguaBean >tr').find(".numero").each(function() {

				  	          valores += $(this).html() + "\n";
				  	        });
				  	        console.log(valores);
				  	        alert(valores);
				  	      });
 */
				  		/*  var numCU=$('#numCupos').val();
				  	        var Dis= $('#numCuposDisponible').val();
				  	      	alert(parseFloat(numCU)-parseFloat(Dis)); */

				  	/*       $("#numCuposDisponible").keyup(function() {
				  	    	   var numCU=$('#numCupos').val();
					  	        var Dis= $('#numCuposDisponible').val();
					  	    if (parseFloat(Dis)>parseFloat(numCU)) {
						  	   	msg_info('El numero de cupos Solicitante es mayor al numero de cupos Disponible, por favor Ingrese un numero menor.');
						  	  	 $('#numCuposDisponible').val('');
					  	    	 $('#numCuposRestantes').val('');
						  	}else if (numCU<=Dis) {
						  	    $('#numCuposRestantes').val(parseFloat(numCU)-parseFloat(Dis));
						  	}else {
						  		$('#numCuposRestantes').val(parseFloat(numCU)-parseFloat(Dis));
							}

				  	      }); */

				  /* 		   var numCU=$('#numCupos').val();
				  	        var Dis= $('#numCuposDisponible').val();
				  	    if (Dis<=numCU) {
					  	    $('#numCuposRestantes').val(parseFloat(numCU)-parseFloat(Dis));
					  	}else {
					  		 $('#numCuposRestantes').val('-');
						} */
					
				  	   
							/* var msgErrorLogin=document.getElementById('msgErrorLogin').value;
							if(msgErrorLogin.length>0){
				                //$("#boxMsgx").append(infoHtml);
				                $("#boxMsgx").html(infoHtml);
				                $("#boxMsg").fadeIn("slow");
				                $(".msgValidar").html(msgErrorLogin);
							} */
						
				  				
		      });
		      $(document).ready(function() {
		    	  $("#frmSede").keypress(function(e) {//Para deshabilitar el uso de la tecla "Enter"
		    	  if (e.which == 13) {
		    	  return false;
		    	  }
		    	  });
		    	  });

		      </script>
			 <!-- <script type="text/javascript">
			 function youFunction() {
				  $('#numCuposDisponible').change(function(){

			  	        var numCU=$('#numCupos').val();
			  	        var Dis= $('#numCuposDisponible').val();
			  	      	alert(parseFloat(numCU)+parseFloat(Dis));
			  	      //$('#numCuposRestantes').val();

			  	     });
			}


			 </script> -->

   <script src="${pageContext.request.contextPath}/assets/js/page/busqueda-institucion-lengua.js" type="text/javascript"></script>
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
                  <li class="breadcrumb-item">Académico
                  </li>
                  <li class="breadcrumb-item active">Matr&iacute;cula
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>

        <input type="hidden" value="${swMensaje}"  id="mensaje"  />
        <input type="hidden" value="${swMensajeNumCupos}"  id="mensajeNumCu"  />
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id="idtituloM">Registro de matr&iacute;cula</h4>
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

                                    <div class="col-md-12">
                                      <ul class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Registro</a>
                                        </li>
                                       <!--  <li class="nav-item">
                                          <a class="nav-link" id="base-tab14" data-toggle="tab" aria-controls="tab14" href="#tab14" aria-expanded="false">Grupos</a>
                                        </li> -->
                                        <c:if test="${matriculaForm.matriculaBean.codigo>0}">

                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Docente</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab13" data-toggle="tab" onclick="ejecutarFunctionusuarios();" aria-controls="tab13" href="#tab13" aria-expanded="false">Estudiante</a>
                                        </li>
                                        </c:if>
                                      </ul>
                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                         <%--  <form class="form mt-1"> --%>
                                           <f:form id="frmRegistroMatricula1" class="form-horizontal" role="form" method="post" action="grabar">
                                            <div class="form-body">
                                              <div class="row">
                                              <!--  -->

                                              <div class="col-md-12">
                                              	  <%-- <div class="form-group col-md-8">
                                                    <label >Inscripcion <span class="required">*</span></label>


												<div class="form-inline">
                                                    <div class="controls">

                                                      <f:input type="text" path="matriculaBean.inscripcionLenguaBean.codigo"  id="codigoInscripcionDetalle"  name="codigoInscripcionDetalle"  data-validation-required-message="Este campo es requerido" required="required" style="opacity: 0;width: 0%;"/>
                                                      <f:input type="text"  class="form-control" path="matriculaBean.insti.nombreInstitucion" id="inscripcionDetalle" name="inscripcionDetalle" style="width: 98%;"/>


													</div>
													</div>
                                                 </div> --%>
                                                 <c:if test="${matriculaBean.codigo==0}">

                                                 	<div class="form-group col-md-3" >
                                                  		<button type="button" class="btn btn-outline-info btn-min" data-toggle="modal" data-target="#bootstrap2" onclick="cargarPopupListadoInscripcion()">

                                                 		<i class="ft-plus"></i>Buscar inscripcion</button>
                                                	</div>
                                                </c:if>
                                                <div class="form-group col-md-7" >
                                                <div class="form-inline" style="margin-top: 10px;">
	                                                 <label style="font-weight: 700;font-size: 14px;">Número total de cupos disponibles :  </label>
	                                                  <f:input type="text" path="matriculaBean.inscripcion.numCupos" class="form-control"   id="lblNumCuposTotal"  name="lblNumCuposTotal" style="width: 10%;text-align: center;" readonly="true"/>
                                                 </div>
                                                </div>
                                               </div>

                                               <!--  -->
                                                <div class="form-group col-md-6 mb-2">
                                                      <label >Instituci&oacute;n <span class="required">*</span></label>

                                                    <f:input type="hidden" path="matriculaBean.codigo"  id="codigoMatricula"/>
                                                    	<div class="form-inline">
                                                    <div class="controls">
                                                    <f:input type="text" path="matriculaBean.inscripcionLenguaBean.codigo"  id="codigoInscripcionDetalle"  name="codigoInscripcionDetalle"  data-validation-required-message="Este campo es requerido" required="required" style="opacity: 0;width: 0%;"/>
                                                    <f:select id="lblInstitu" path="matriculaBean.insti.codigo"   name="lblInstitu" class="form-control" style="width: 98%;"><!-- onchange="buscarLenguaxInstitucion();" -->

															<f:option value="0" label="Seleccionar" />
															<f:options items="${lstInstitucionBean}" itemValue="codigo" itemLabel="nombreInstitucion" />
													</f:select>
													</div>
													</div>

                                                  </div>

                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="lblSituacion">Situaci&oacute;n <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:select id="lblSituacion"  path="matriculaBean.situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="" class="optionReset" label="Seleccionar" />
															<f:options items="${lstSituacion}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
													</div>
												  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="lblEstadoMatricula">Estado matr&iacute;cula <span class="required">*</span></label>
                                                 <div class="controls">
                                                     <f:select id="lblEstadoMatricula" path="matriculaBean.flagEstado.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="" class="optionReset" label="Seleccionar" />
															<f:options items="${lstEstadoMatricula}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
													</div>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="lblLenguas">Lengua  <span class="required">*</span></label>
                                                  <div class="controls">
                                                    <f:select id="lblLengua" path="matriculaBean.lengua.codigo" name="lblLengua"  class="form-control" data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="0"  class="optionReset" label="Seleccionar" />
															<f:options items="${lstLenguaBean}" itemValue="codigo" itemLabel="nombre" />
													</f:select>
													</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Nivel <span class="required">*</span></label>
                                                 <div class="controls">
                                                     	<f:select id="lblNivel"
		                                                path="matriculaBean.nivel.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
		                                                <f:option value="" label="Seleccionar"/>
		                                                <f:options  items="${lstnivel}"
		                                                            itemValue="codigoRegistro"
		                                                            itemLabel="nombreCorto"/>
                                            			</f:select>
                                            		</div>
                                                  </div>
                                                 <%--  <div class="form-group col-md-3 mb-2" style="visibility: hidden;">
                                                    <label for="situacionUsuario">Sub Nivel</label>

                                                     <f:select id="lblSubnivel"
                                                path="matriculaBean.subNivel.codigoRegistro" class="form-control">
                                                <f:option value="" label="Seleccionar"/>
                                                <f:options  items="${lstsubNivel}"
                                                            itemValue="codigoRegistro"
                                                            itemLabel="nombreCorto"/>
                                            	</f:select>
                                                  </div> --%>
                                               <%--    <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">N&uacute;mero de cupos Disponible <span class="required">*</span></label>
                                               <div class="controls">
                                                   <f:input id="numCupos" type="text" class="form-control" path="matriculaBean.inscripcion.numCupos"  onkeypress="return justNumbers(event);"  data-validation-required-message="Este campo es requerido" required="required" readonly="true" /><!-- readonly="true" path="matriculaBean.inscripcionLenguaBean.numeroCuposDisp" -->
                                               </div>
                                                </div> --%>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="lblPeriodo">Per&iacute;odo <span class="required">*</span></label>
                                                   <div class="controls">
                                                    <f:select id="lblPeriodo" path="matriculaBean.periodo.codigoRegistro" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
															<f:option value="" label="Seleccionar" />
															<f:options items="${lstPeriodo}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
													</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Semestre <span class="required">*</span></label>
                                                    <div class="controls">
                                                    <f:select id="lblciclo" path="matriculaBean.ciclo.codigoRegistro" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
															<f:option value=""  class="optionReset" label="Seleccionar" />
															<f:options items="${lstCiclo}" itemValue="codigoRegistro" itemLabel="nombreCorto" />
													</f:select>
													</div>
                                                  </div>
                                              <%--   <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">N&uacute;mero de cupos Solicitante <span class="required">*</span></label>
                                               <div class="controls">
                                                   <f:input id="numCuposDisponible" path="matriculaBean.vNumcuposrest" name="numCuposDisponible" type="text" class="form-control" onkeypress="return justNumbers(event);"/>
                                               </div>
                                                </div> --%>
                                              <!--   <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">N&uacute;mero de cupos Restantes <span class="required">*</span></label>
                                               <div class="controls">
                                                   <input id="numCuposRestantes"   name="numCuposRestantes" type="text" class="form-control"  disabled="disabled" onkeypress="return justNumbers(event);"/>
                                               </div>
                                                </div> -->
                                              </div>

                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                  <a class="btn btn-secondary mr-1" href="${pageContext.request.contextPath}/matriculaController/listado"><i class="fa fa-close"></i> Cancelar</a>
                                                      	<button type="reset" id="limpiar" class="btn btn-secondary mr-1" onclick="window.location='${pageContext.request.contextPath}/matriculaController/nuevo'">
                                         				   <i class="fa fa-eraser"></i> Limpiar
                                          				</button>
                                          				
                                          				
                                          				<button id="btn-save-reg"	 class="btn btn-flat btn-primary" ><!-- type="submit" onclick="agregarDetalles();" -->
                                       						<i class="fa fa-floppy-o"></i> Guardar
                                       					</button>
                                                  </div>
                                              </div>

                                            </div>
                                          </f:form>
                                        </div>
                                        <div id="modal">
                                        </div>
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                          <f:form class="form mt-1">
                                            <div class="form-body">

                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right ">
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#bootstrap" onclick="pruebaAjax()"> <!-- data-toggle="modal" data-target="#grupo-docente-modal" -->
                                                        <i class="ft-search"></i> Agregar
                                                      </button>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12" id="listadoDetalleDocente">
                                                  <table id = "idtable" class="table table-striped table-bordered zero-configuration">
                                                      <thead>
                                                          <tr>
                                                              <th width="15">N°</th>
                                                              <th>Nombre del docente</th>
                                                              <th>Fecha</th>
                                                              <th>Tipo</th>
                                                              <th width="20">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="idtbodymatricula">
                                                          <c:forEach var="matriculaDocenteBean" items="${lstMatriculaDocenteBean}" varStatus="theCount">
									                      <tr>
									                      	  <td>${theCount.count}</td>
									                          <td>${matriculaDocenteBean.docenteBean.personaBean.nombrePersona} ${matriculaDocenteBean.docenteBean.personaBean.apellidoPaterno} ${matriculaDocenteBean.docenteBean.personaBean.apellidoMaterno}</td>
									                           <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${matriculaDocenteBean.fechaCreacion}"/></td>
									                          <td>${matriculaDocenteBean.tipoDocente.nombreCorto}</td>
									                          <td>
									                           <!--  <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
									                          <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacionDocente('${matriculaDocenteBean.codigo}')"><i class="icon-trash"></i></a>
									                          </td>
									                      </tr>
									                      </c:forEach>
                                                      </tbody>
                                                      <tfoot>
                                                          <tr>
                                                              <th width="15">N°</th>
                                                              <th>Nombre del docente</th>
                                                              <th>Fecha</th>
                                                              <th>Tipo</th>
                                                              <th width="20">Acci&oacute;n</th>
                                                          </tr>
                                                      </tfoot>
                                                  </table>

                                                </div>
                                              </div>
                                            </div>
                                          </f:form>
                                        </div>
                                        <div class="tab-pane" id="tab13" aria-labelledby="base-tab13">
                                          <form class="form mt-1" onsubmit="return false" role="form" method="post">
                                            <div class="form-body">

                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right ">
                                                    <!--   <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#trasladar-alumno-modal">
                                                        <i class="ft-search"></i> Trasladar Alumno
                                                      </button> -->

                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" onclick="listarAlumnoxInstitucion()"> <%-- data-toggle="modal" data-target="#alumno-modal" --%> 
                                                        <i class="ft-search"></i> Estudiante
                                                      </button>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12" id="listadoDetalleMatAlumno"><!-- listadoDetalleInscripcion -->
                                                 <table id="tb_addalumnodet" class="table table-striped table-bordered">
                                                      <thead>
                                                          <tr>
                                                        <th width="15">N°</th>
								                      	<th width="100">Usuario</th>
                                                        <th width="150">Estudiante</th>
                                                        <th width="100">Lengua</th>
                                                        <th width="70">Condicion del nivel</th>
                                                        <th width="30">Nota</th>
                                                        <th width="100">Situaci&oacute;n</th>
                                                        <th width="20">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>

                                                      </tbody>
                                                      <tfoot>
                                                          <tr>
                                                        <th width="15">N°</th>
								                      	<th width="100">Usuario</th>
                                                        <th width="150">Estudiante</th>
                                                        <th width="100">Lengua</th>
                                                        <th width="70">Condicion del nivel</th>
                                                        <th width="30">Nota</th>
                                                        <th width="100">Situaci&oacute;n</th>
                                                        <th width="20">Acci&oacute;n</th>
                                                          </tr>
                                                      </tfoot>
                                                  </table>
<!--                                                   <table class="table table-striped table-bordered zero-configuration"> -->
<!--                                                       <thead> -->
<!--                                                           <tr> -->
<!--                                                               <th width="15">Codigo</th> -->
<!--                                                               <th width="300">Nombre del Alumno</th> -->
<!--                                                               <th width="60">N° de Doc.</th> -->
<!--                                                               <th width="60">Fecha</th> -->
<!--                                                               <th width="60">Acci&oacute;n</th> -->
<!--                                                           </tr> -->
<!--                                                       </thead> -->

<!--                                                       <tbody> -->
<%--                                                           <c:forEach var="matriculaAlumno" items="${lstmatriculaAlumno}" varStatus="theCount"> --%>
<!--                                                           <tr> -->
<%-- 									                      	  <td>${matriculaAlumno.codigo}</td> --%>
<%-- 									                          <td>${matriculaAlumno.alumnoBean.personaBean.nombrePersona} ${matriculaAlumno.alumnoBean.personaBean.apellidoPaterno} ${matriculaAlumno.alumnoBean.personaBean.apellidoMaterno}</td> --%>
<%-- 									                          <td>${matriculaAlumno.alumnoBean.personaBean.numeroDocumento}</td> --%>
<%-- 									                          <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${matriculaAlumno.fechaCreacion}"/></td> --%>
<!-- 									                          <td> -->
<!-- 									                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
<%-- 									                          <a title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('${matriculaAlumno.codigo}')"><i class="icon-trash"></i></a> --%>
<!-- 									                          </td> -->
<!-- 									                      </tr> -->
<%-- 									                      </c:forEach> --%>
<!--                                                       </tbody> -->
<!--                                                   </table> -->


                                                  <!--  comienzo -->

    <!--                                               <table class="table table-striped table-bordered zero-configuration">
                                                <thead>

                                                    <tr>
                                                        <th width="40">C&oacute;digo Instituci&oacute;n</th>
                                                        <th>Matr&iacute;cula</th>
                                                        <th>Usuario</th>
                                                        <th>Estudiante</th>
                                                        <th>Lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="60">Acci&oacute;n</th>
                                                    </tr>

                                                </thead>
                                                <tbody id="idTablaUsuarioMatricula" > -->
<%--                                                   <c:forEach var="usuarioAlumno" items="${lstUsuarioMatricula}"> --%>

<!--                                                     <tr> -->
<%--                                                         <td>${usuarioAlumno.inscripcionLenguaBean.inscripcionBean.institucion.codigo}</td> --%>
<%--                                                         <td>${usuarioAlumno.matriculaBean.codigo}</td> --%>
<%--                                                         <td>${usuarioAlumno.usuarioBean.nombreUsuario}</td> --%>
<%--                                                         <td>${usuarioAlumno.alumnoBean.personaBean.nombreCompleto}</td> --%>
<%--                                                         <td>${usuarioAlumno.matriculaBean.lengua.nombre}</td> --%>
<%--                                                         <td>${usuarioAlumno.situacion.nombreCorto}</td> --%>
<!--                                                          <td> -->
<%--                                                           <c:if test="${usuarioAlumno.situacion.codigoRegistro ==1}"> --%>
<%--                                                            <a title="Retirar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${usuarioAlumno.codigo}"><i class="icon-trash"></i></a> --%>
<!-- <!--                                                           <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Retirrar" onclick="confirmar_accion();"><i class="icon-trash"></i></button> -->
<%-- 														</c:if> --%>
<%-- 															<c:if test="${usuarioAlumno.situacion.codigoRegistro ==2}"> --%>
<!--    															<button type="button" class="btn_asignar_alumno btn btn-outline-success btn-sm " -->
<!--                                                           data-toggle="tooltip" onclick="asignar_usuario()"  data-original-title="Asignar"><i class="icon-pencil"></i></button> -->
<%--                                                         </c:if> --%>
<!-- <!--                                                           <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Retirrar" onclick="confirmar_accion();"><i class="icon-trash"></i></button> -->
<!--                                                         </td> -->
<!--                                                     </tr> -->
<%--                                                      </c:forEach> --%>




<!--                                                 </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th width="40">C&oacute;digo</th>
                                                        <th>Matr&iacute;cula</th>
                                                        <th>Usuario</th>
                                                        <th>Estudiante</th>
                                                        <th>Lengua</th>
                                                        <th width="70">Situaci&oacute;n</th>
                                                        <th width="60">Acci&oacute;n</th>
                                                    </tr>
                                                </tfoot>
                                            </table> -->

                                                  <!--  Fin  -->
                                                </div>
                                              </div>
                                            </div>
                                          </form>
                                        </div>
                                        <div class="tab-pane" id="tab14" aria-labelledby="base-tab14">
                                          <form class="form mt-1">
                                            <div class="form-body">

                                              <div class="row">
                                                 <div class="form-group col-md-3">
                                                    <label for="rg_mat_aula">Aula</label>
                                                    <input type="text" id="rg_mat_aula" class="form-control" name="lname">
                                                  </div>
                                                 <div class="form-group col-md-3">
                                                    <label for="rg_mat_seccion">Secci&oacute;n</label>
                                                    <input type="text" id="rg_mat_seccion" class="form-control" name="lname">
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Turno</label>
                                                    <select id="situacionUsuario" name="interested" class="form-control">
                                                        <option value="none" selected="" disabled="">Seleccionar</option>
                                                        <option value="design">Mañana</option>
                                                        <option value="development">Tarde</option>
                                                    </select>
                                                  </div>
                                                 <div class="form-group col-md-3">
                                                    <label for="rg_mat_seccion">Capacidad maxima</label>
                                                    <input type="text" id="rg_mat_seccion" class="form-control" name="lname">
                                                  </div>
                                              </div>
                                              <div class="row">
                                                 <div class="form-group col-md-12">
                                                    <label for="rg_mat_observacion">Observaci&oacute;n</label>
                                                    <textarea id="rg_mat_observacion" class="form-control" rows="3"></textarea>
                                                  </div>
                                              </div>
                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right ">
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width" data-toggle="modal" data-target="#migrar-grupo-modal">
                                                        <i class="ft-search"></i> Migrar Grupo(s)
                                                      </button>
                                                      <button type="button" class="btn btn-outline-secondary btn-min-width">
                                                        <i class="ft-search"></i> Crear Grupo
                                                      </button>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered">
                                                      <thead>
                                                          <tr>
                                                              <th>Aula</th>
                                                              <th>Secci&oacute;n</th>
                                                              <th>Cap. maxima</th>
                                                              <th>Observaci&oacute;n</th>
                                                              <th>Fecha</th>
                                                              <th width="120">Acci&oacute;n</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                          <tr>
                                                              <td>Aula 1</td>
                                                              <td>A</td>
                                                              <td>25</td>
                                                              <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita mollitia sed, reprehenderit fugit, doloribus voluptatibus earum ducimus ipsam. Nulla, placeat!</td>
                                                              <td>01/17/17</td>
                                                              <td class="text-sm-center">
                                                                <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#md_confirmacion_obs"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                          <tr>
                                                              <td>Aula 2</td>
                                                              <td>B</td>
                                                              <td>30</td>
                                                              <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita mollitia sed, reprehenderit fugit, doloribus voluptatibus earum ducimus ipsam. Nulla, placeat!</td>
                                                              <td>08/17/17</td>
                                                              <td class="text-sm-center">
                                                                <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#md_confirmacion_obs"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                          <tr>
                                                              <td>Aula 3, Aula 4</td>
                                                              <td>C</td>
                                                              <td>45</td>
                                                              <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita mollitia sed, reprehenderit fugit, doloribus voluptatibus earum ducimus ipsam. Nulla, placeat!</td>
                                                              <td>10/17/17</td>
                                                              <td class="text-sm-center">
                                                                <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#md_confirmacion_obs"><i class="icon-trash"></i></button>
                                                              </td>
                                                          </tr>
                                                      </tbody>
                                                  </table>
                                                </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-xs-12 mt-2">
                                                  <h5 class="mb-0">Historial</h5>
                                                  <br>
                                                </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <table class="table table-striped table-bordered">
                                                      <thead>
                                                          <tr>
                                                              <th>Motivo</th>
                                                              <th>Observaci&oacute;n</th>
                                                              <th>Fecha</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                          <tr>
                                                              <td>Migrar</td>
                                                              <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita mollitia sed, reprehenderit fugit, doloribus voluptatibus earum ducimus ipsam. Nulla, placeat!</td>
                                                              <td>01/17/17</td>
                                                          </tr>
                                                          <tr>
                                                              <td>Eliminar</td>
                                                              <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita mollitia sed, reprehenderit fugit, doloribus voluptatibus earum ducimus ipsam. Nulla, placeat!</td>
                                                              <td>08/17/17</td>
                                                          </tr>
                                                      </tbody>
                                                  </table>
                                                </div>
                                              </div>
                                            </div>
                                          </form>
                                        </div>
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


	<!-- MODAL 2 -->
	<div class="modal fade text-xs-left" id="bootstrap" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						id="btnCloseSede" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Docente</b></label>
				</div>
				 <f:form id="frmSede" onsubmit="return false"></f:form>
			</div>
		</div>
	</div>


		<!-- MODAL 2 -->
	<div class="modal fade text-xs-left" id="bootstrap2" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						id="btnCloseSede2" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Busqueda de inscripciones</b></label>
				</div>
				 <f:form id="frmSede2" onsubmit="return false"></f:form>
			</div>
		</div>
	</div>


	<jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/docente-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/migra-grupo-modal-view.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/../layout/alumno-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/traladar-alumno-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/alumno-filtro-modal-view.jsp" />
    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-obs-modal-view.jsp" />
<%--     <jsp:include page="${pageContext.request.contextPath}/../layout/grupo-docente-modal-view.jsp" /> --%>
    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-grupo-alumno-modal-view.jsp" />


   <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
        <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
<%--     <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script> --%>
    <!-- END PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
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
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/select/form-select2.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
   	<script type="text/javascript">
    $(document).ready(function() {
        
        $('#tb_addalumnodet').DataTable( {
            "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
        } );
    } );
   	
    function pruebaAjax() {
		  var numero =document.getElementById("codigoInscripcionDetalle").value;
		  iniciarBloqueo();
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/listarDocenteCodigoInsti",
			data : {codigoinst:numero},

			success : function(data) {
				/* console.log("SUCCESS: ", data); */
				/* $('#modal').html(data);
				$('#grupo-docente-modal').modal('show'); */
				$("#bootstrap #frmSede").empty();
				$("#bootstrap #frmSede").append(data);
			},
			error : function() {
			/* 	console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

    function cargarPopupListadoInscripcion() {
    	iniciarBloqueo();
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/cargarPopupListadoInstitucion",

			success : function(data) {
				/* console.log("SUCCESS: ", data); */
				/* $('#modal').html(data);
				$('#grupo-docente-modal').modal('show'); */
				$("#bootstrap2 #frmSede2").empty();
				$("#bootstrap2 #frmSede2").append(data);
			},
			error : function() {
				/* console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

    function listarAlumnoxInstitucion() {
 
    		
		  var numero 	=document.getElementById("lblInstitu").value;
		  var codinslen =document.getElementById("codigoInscripcionDetalle").value;
		  var nomP		='';
		  iniciarBloqueo();
			$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/listarAlumnoCodigoInsti",
			data : {codigoinst:numero,codinscrlengua:codinslen,tiponivel:0,nombrePerso:nomP},

			success : function(data) {
				/* console.log("SUCCESS: ", data); */
				$('#modal').empty();
				$('#modal').html(data);
				$('#alumno-modal').modal('show');
			},
			error : function() {
				/* console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

    function listarAlumnoxInstitucionmodal() {
		  var numero 	=document.getElementById("lblInstitu").value;
		  var codinslen =document.getElementById("codigoInscripcionDetalle").value;
		  var nomP		=document.getElementById("nomAlum").value;
		  iniciarBloqueo();
			$.ajax({
			type : "POST",
// 			listarAlumnoCodigoInsti listarAlumnoCodigoInstiDetModalView
			url : "${pageContext.request.contextPath}/matriculaController/listarAlumnoCodigoInstiDetModalView",
			data : {codigoinst:numero,codinscrlengua:codinslen,tiponivel:0,nombrePerso:nomP},

			success : function(data) {
				/* console.log("SUCCESS: ", data); */
					$('#listadoalumModalview').empty();
			 	$('#listadoalumModalview').html(data);
				//$('#listadoalumModalview').html(data);
				/* $('#modal').html(data);
				$('#alumno-modal').modal('show'); */
			},
			error : function() {
				/* console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}
    
    function limpiarTabla(idTabla,idBodyTable){
//     	console.log(idTabla);
//     	console.log(idBodyTable);
    	$(idTabla).DataTable().destroy();
    	$(idBodyTable).empty();
    	$(idTabla).DataTable();
    }

    function refrescarTablaDetalleMatriculaAlumno() {
		  var id =document.getElementById("codigoMatricula").value;
		  iniciarBloqueo();
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/matriculaController/recargarAlumnoXMatricula",
			data : {codigo:id},

			success : function(data) {
				/* console.log("SUCCESS: ", data); */
				$('#listadoDetalleInscripcion').html(data);
			},
			error : function() {
				/* console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

  function agregarMatriculaAlumno(codAlu) {
		  var codA =codAlu;
		  var id =document.getElementById("codigoMatricula").value;
		  var status = '';
		  var inscLen=document.getElementById("codigoInscripcionDetalle").value;
		  /*****************/
		  var codigoInst =$('#lblInstitu').val();
					var codigoinscLen = $('#codigoInscripcionDetalle').val();

		  iniciarBloqueo();
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/agregarAlumnoXMatricula",
			data : {codMatri:id,codAlu:codA,codInscLen:inscLen,codigoInst:codigoInst,codinscrlen:codigoinscLen},

			success : function(data) {
				//refrescarTablaDetalleMatriculaAlumno();
				/* console.log("SUCCESS: ", data); */
				listadosUsuarioAlumno();
				status=data;
				if (data=="1") {
					agregarSeguimientoAlumnoLengua(codA);
					/* msg_info('Se agrego correctamente al Alumno'); */
					msg_exito();
					$('#alumno-modal').modal('hide');

				}else if(data=="2"){
					//alert("Se actualizo la Lengua");
					/* console.log('data 2::: '+ data); */
					$('#alumno-modal').modal('hide');
				}else if(data=="3"){
					msg_advertencia("Los cupos de la matricula ya esta llena.");
					$('#alumno-modal').modal('hide');
				}else if(data=="5"){
				msg_advertencia("Alumno no tiene registro nivel Basico.");
				$('#alumno-modal').modal('hide');
				}else if(data=="6"){
					msg_advertencia("Alumno no tiene registro nivel Intermedio.");
					$('#alumno-modal').modal('hide');
				}else if(data=="7"){
				msg_advertencia("Alumno no aprobó el nivel Basico.");
				$('#alumno-modal').modal('hide');
				}



	
				else {
				msg_error();
			}
			},
			error : function() {
				/* console.log("ERROR: "); */
				msg_error();
			},
  			complete: function()
  			{
  				finBloqueo();
			}
		});

	}

  function agregarSeguimientoAlumnoLengua(varcodAlu) {
	  //console.log('varcodAlu ::: '+varcodAlu);
	  var codA =varcodAlu;
	  var id =document.getElementById("codigoMatricula").value;
	  var status = '';
	  iniciarBloqueo();
	$.ajax({
		type : "POST",

		url : "${pageContext.request.contextPath}/matriculaController/agregarSeguimientoAlumnoLengua",
		data : {codMatri:id,codAlu:codA},

		success : function(data) {
			/* console.log("SUCCESS: ", data); */
			if (data>0) {
				/* console.log('Se agrego correctamente al SeguimientoAlumnoLengua'); */

			}else if(data=="0")  {
				/* console.log('No se agrego SeguimientoAlumnoLengua'); */
			}else if(data=="9999999"){
				/* console.log('Error SeguimientoAlumnoLengua'); */
			}


		},
		error : function(e) {
			/* console.log("ERROR: SeguimientoAlumnoLengua::: " + e); */
			//msg_error();
		},
	    complete: function(){
	    	finBloqueo();
        }
	});

}

  function eliminarConfirmacion(cod) {
      //almacenar datos
  		prmCodigoMatriculaAlumno = cod;
  		tipoTab="1";
		//mostrar modal
		$('#md_confirmacion').modal('show');


	}

  $("#btnConfirmarGeneric").click(function(e) {

		if (tipoTab=="1") {

			  eliminarMatriculaAlumno(prmCodigoMatriculaAlumno);
			  $('#md_confirmacion').modal('hide');
			  prmCodigoMatriculaAlumno="";
			  e.stopPropagation();
			  return;
		}else if(tipoTab=="2"){

			eliminarMatriculaDocente(prmCodigoMatriculaDocente);
			 $('#md_confirmacion').modal('hide');
			 prmCodigoMatriculaDocente="";
			  e.stopPropagation();
			  return;
		}else if(tipoTab=="3"){

			darDeBajaUsuarioAsignado(prmCodigoEliminarUsuario);
			 $('#md_confirmacion').modal('hide');
			 prmCodigoEliminarUsuario="";
			  e.stopPropagation();
			  return;
		}else{

		}


	});

	//click en boton confirmar

  function eliminarMatriculaAlumno(cod) {

		  var id =cod;
		  iniciarBloqueo();
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/eliminarAlumnoXMatricula",
			data : {codigo:id},

			success : function(data) {
				refrescarTablaDetalleMatriculaAlumno();
				/* console.log("SUCCESS: ", data); */
				//$('#modal').html(data);
				if (data>0) {
					msg_exito();


				}else {
					msg_error();
				}


			},
			error : function() {
				/* console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

  /**Docente****/
     function refrescarTablaDetalleMatriculaDocente() {
		  var id =document.getElementById("codigoMatricula").value;
		  iniciarBloqueo();
		$.ajax({
			type : "GET",

			url : "${pageContext.request.contextPath}/matriculaController/recargarDocenteXMatricula",
			data : {codigo:id},

			success : function(data) {
				/* console.log("SUCCESS: ", data); */
				$('#listadoDetalleDocente').html(data);
			},
			error : function() {
				/* console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}
	function recorrertabla(cod){
		  var codigoTip=0;
       	  var iddocete=cod;

		var iddocSelect=0;
		var idCodigoTipSelect=0;



        for(var i=0;i<$('#idTablaPremio >tr').length;i++){



       				var codigoDocente=document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
       				//alert(codigoDocente);
					var codigoTip     = document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('select')[0].value;

       				if(codigoDocente==iddocete){
           					//alert("fila Grabada: "+i);
           					iddocSelect=iddocete;
           					idCodigoTipSelect=codigoTip;
// 					 agregarMatriculaDocente(iddocete,codigoTip);
					//alert(iddocSelect + idCodigoTipSelect + ' 1');
					}else{
						//alert("pasa");
						document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('select')[0].removeAttribute('required');


						}

//     	if (document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('select')[0].value!=0) {
//     		//alert(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('select')[0].value);
//     		codigoTip     = document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('select')[0].value;

// 		}




     	 }
		//alert(iddocSelect + idCodigoTipSelect + ' 2');

        agregarMatriculaDocente(iddocSelect,idCodigoTipSelect);

	}
	/*traer al detalle*/
	  function obtenerCodigoDetalleInscripcion(cod) {
		  var codDetalle =cod;
		  //alert(codDetalle +'asdasd');
		/*   var id =document.getElementById("codigoMatricula").value; */

	iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/matriculaController/obtenerInscripcionLenguaDetalle?codigoDetalle="+codDetalle,

			success : function(data) {
				//alert('paso');
				/* console.log("SUCCESS: ", data); */
				document.getElementById("lblInstitu").value=data.institucion.codigo;
				$('#lblLengua').val(data.lenguainscr.codigo);
				$('#lblPeriodo').val(data.inscripcionBean.periodo.codigoRegistro);
				$('#lblciclo').val(data.inscripcionBean.ciclo.codigoRegistro);
				$('#lblNumCuposTotal').val(data.numeroCuposInsc);
				$('#numCupos').val(data.numeroCuposInsc);//numeroCuposDisp
				//$('#numCuposDisponible').val(data.numeroCuposDisp);
				$('#lblNivel').val(data.nivel.codigoRegistro);

		/* 		 var numCU=$('#numCupos').val();
		  	     var Dis= $('#numCuposDisponible').val();
		  	  	if (parseFloat(Dis)>parseFloat(numCU)) {
			  	   	msg_info('El numero de cupos Solicitante es mayor al numero de cupos Disponible, por favor Ingrese un numero menor.');
			  	  	 $('#numCuposDisponible').val('');
		  	    	 $('#numCuposRestantes').val('');
			  	}else if (numCU<=Dis) {
			  	    $('#numCuposRestantes').val(parseFloat(numCU)-parseFloat(Dis));
				}else {
			  		$('#numCuposRestantes').val(parseFloat(numCU)-parseFloat(Dis));
				} */
				//msg_info('Se agrego correctamente el Detalle');
				msg_exito();
			},
			error : function() {
				/* console.log("ERROR: "); */
				msg_error();
			},
  			complete: function()
  			{
  				finBloqueo();

			}
		});

	}

  function agregarMatriculaDocente(codAlu,codti) {
		  var codA =codAlu;
		  var id =document.getElementById("codigoMatricula").value;
		  var tiDoc =codti;
		  var status = '';
		  var $myForm = $('#frmSede');
	   		// validar todos los required
	   		if(! $myForm[0].checkValidity()) {
	   			 msg_advertencia("Debe completar los campos requeridos correctamente");
	   			 for(var i=0;i<$('#idTablaPremio >tr').length;i++){
	   			document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('select')[0].setAttribute("required", "");
	   			 }
	   		}else{
	   	iniciarBloqueo();
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/agregarDocenteXMatricula",
			data : {codMatri:id,codDoc:codA,tipDoc:tiDoc},

			success : function(data) {
				refrescarTablaDetalleMatriculaDocente();
				/* console.log("SUCCESS: ", data); */
				status=data;
				if (data=="1") {
					msg_info('Se agrego correctamente al Docente');
					/* $('#grupo-docente-modal').modal('hide'); */
					$("#bootstrap #frmSede").empty();
						$('#bootstrap').modal('hide');
				}else if(data=="2"){
					//alert("Se actualizo el Docente");

					/* $('#grupo-docente-modal').modal('hide'); */
					$("#bootstrap #frmSede").empty();
					$('#bootstrap').modal('hide');
				}else if (data=="3") {
					msg_advertencia('El docente ya esta agregado como principal');
						/* $('#grupo-docente-modal').modal('hide'); */
						$("#bootstrap #frmSede").empty();
							$('#bootstrap').modal('hide');
				}else {
					msg_error();
				}

				 for(var i=0;i<$('#idTablaPremio >tr').length;i++){
			   			document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('select')[0].setAttribute("required", "");
			   	}
			},
			error : function() {
				/* console.log("ERROR: "); */
				msg_error();
			},
  			complete: function()
  			{
  				finBloqueo();
			}
		});
	   }
	}

  function eliminarConfirmacionDocente(cod) {
      //almacenar datos
  		prmCodigoMatriculaDocente = cod;
  		tipoTab="2";
		//mostrar modal
		$('#md_confirmacion').modal('show');
	}
  function eliminarMatriculaDocente(cod) {

		  var id =cod;
		  iniciarBloqueo();
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/eliminarDocenteXMatricula",
			data : {codigo:id},

			success : function(data) {
				refrescarTablaDetalleMatriculaDocente();
				/* console.log("SUCCESS: ", data); */
				//$('#modal').html(data);
				if (data>0) {
					msg_exito();


				}else {
					msg_error();
				}


			},
			error : function() {
				/* console.log("ERROR: "); */
				msg_error();
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

	function justNumbers(e)
	{
	   var keynum = window.event ? window.event.keyCode : e.which;
	   if ((keynum == 8) || (keynum == 46))
	        return true;
	    return /\d/.test(String.fromCharCode(keynum));
	}

	/*   function agregarDetalles() {

		  actualizarNumCupoDisp();
		 // actualizarNumCupoSoli();

	} */

	  function actualizarNumCupoSoli() {

		  var numCupoSoli =$('#numCuposDisponible').val();
		  iniciarBloqueo();
		$.ajax({
			type : "POST",

			url : "${pageContext.request.contextPath}/matriculaController/actualizarNumCuposRestMatri",
			data : {numCuposRest:numCupoSoli},

			success : function(data) {

				/* console.log("SUCCESS: ", data); */

			},
			error : function() {
				/* console.log("ERROR: "); */
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

/* 	  function actualizarNumCupoDisp() {

		  var id =$('#codigoInscripcionDetalle').val();
		  var numCuposD =$('#numCuposRestantes').val();
		  var numVal =$('#numCupos').val();

		if (numVal>=1) {
				$.ajax({
					type : "POST",

					url : "${pageContext.request.contextPath}/matriculaController/actualizarNumCuposDispInscripLengua",
					data : {codigo:id,numCuposDisp:numCuposD},

					success : function(data) {

						console.log("SUCCESS: ", data);

					},
					error : function() {
						console.log("ERROR: ");
					}
				});
		}else {
			console.log(numVal);

		}


	} */
    function recargarListadoxInscripcionDetalle() {
		  	var id =document.getElementById("codigoInscripcionDetalle").value;
			var nombreDoce =document.getElementById("nombreDocentefil").value;
			var nombreDocu =document.getElementById("numeroDocumentofil").value;
			iniciarBloqueo();
		$.ajax({
			type : "POST",
			data : {codigoDInslen:id,nombre:nombreDoce,numDocumento:nombreDocu},
			url : "${pageContext.request.contextPath}/matriculaController/recargarListadoxInscripcionDetalle",


			success : function(data) {
				console.log(data);
				/* console.log("SUCCESS: ", data); */
				$('#listadoGrupoDocenteModalview').html(data);
			},
			error : function() {
				/* console.log("ERROR: "); */
				msg_advertencia("Ocurrio un error");
			},
		    complete: function(){
		    	finBloqueo();
	        }
		});

	}

	function grabarInscripcionGnral() {



		 var actionForm = $('#frmRegistroMatricula1').attr("action");
		var url = "${pageContext.request.contextPath}/matriculaController/" + actionForm+"jj";
		 var $myForm = $('#frmRegistroMatricula1');
		 //alert($myForm);
		//var dataee = new FormData(document.getElementById("frmRegistroDetDocumentoInstitucion"));

		// validar todos los required
		if(! $myForm[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos correctamente");

		}else{
			iniciarBloqueo();
			console.log("-----------------------------------------");
			console.log($myForm);
			console.log(url);
			//alert($myForm);
			
			$.ajax({
						type : "POST",
						url : url,

				success : function(data) {
				/* console.log("SUCCESS: ", data); */

					msg_exito();



			},
			error : function(xhr, status, er) {
			        //console.log("error: " + xhr + " status: " + status + " er:" + er);
						msg_error();
						/* console.log("errot:" + data); */
					},
		  			complete: function()
		  			{
		  				finBloqueo();

					}
		});
	}
	}

	</script>
  </body>
</html>