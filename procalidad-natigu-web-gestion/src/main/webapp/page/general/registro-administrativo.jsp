<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title id="title_web">Registro de gestores</title>
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/app.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/colors.css">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
<%--    	<script src="${pageContext.request.contextPath}/assets/js/page/busqueda-ubigeo.js" type="text/javascript"></script> --%>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
<script>
	//   alert(document.getElementById('frmRegistroPersonal').addEventListener('submit', handleFileSelect, false));

	ejecutarGuardar = false;

	$(document).ready(function() {

		var codigo = $("#codigoPersonal").val();
		//console.log(codigo);
		if(codigo != '0'){
	
			$('#limpiar').attr("disabled", true);
			$("#titulo_gestor").html("Modificar gestor");
			$("#title_web").html("Modificar gestor");

			transformDNI();
			
		}
		
		var valor = $(".optionReset").val();
		if (valor == '0') {
			$(".optionReset").val("");
		}

	});

	prmRegion = "";
	prmProvincia = "";
	prmDistrito = "";

	/*********************************/ 
	function transformDNI(){
  		var iterationCount = 1000;
	  	var keySize = 128;
	  	
	    var txtDocumentoPersona = $("#numeroDocumentoPersona").val();
	    
	    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    
	    var aesUtil = new AesUtil(keySize, iterationCount);
	    var txtDocPer = aesUtil.decrypt(salt, iv, "numeroDocumentoGestor", txtDocumentoPersona);
	    $("#numeroDocumentoPersona").val(txtDocPer);
	}
	
	function buscarProvinciaXCodigos(codDep, codPro) {


		if (prmRegion != $("#provinciaSelect").val()) {

			  		// alert("hola");
			//  			  var numero =document.getElementById("lblInstitu").value;
			var id = codDep;
			var urlubigeo = $("#urlubigeo").val();
			//console.log(urlubigeo);
			//  			for(var f=0;f<document.getElementById("comboprovincia").length;f++){
			//  				if (document.getElementById("comboprovincia").length > 0) {

			//  					document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
			//  			    }

			//  				}
			document.getElementById("comboprovincia").options[document
					.getElementById("comboprovincia").innerHTML = ""];
			document.getElementById("combodistrito").options[document
					.getElementById("combodistrito").innerHTML = ""];
			document.getElementById("comboprovincia").options[document
					.getElementById("comboprovincia").options.length] = new Option(
					"Seleccionar", "");
			document.getElementById("combodistrito").options[document
					.getElementById("combodistrito").options.length] = new Option(
					"Seleccionar", "");
			$.ajax({
						type : "GET",

						url : "../baseController/buscarProvincia?codigodepartamento="
								+ id,
						//  				data : {codigoinst:numero},

						success : function(data) {
							//console.log("SUCCESS: ", data);

							for (var i = 0; i < data.length; i++) {
								document.getElementById("comboprovincia").options[document
										.getElementById("comboprovincia").options.length] = new Option(
										data[i].nombreUbigeo,
										data[i].codigoProvincia);

							}

							//
						},

						error : function() {
							//console.log("ERROR: ");
						},
						complete : function() {

							if (codPro != null && codPro != "") {
								$("#comboprovincia").val(codPro);
							} else {

								$("#comboprovincia").val("");
							}

						}

					});

		}

	}

	function buscarDistritoXCodigos(codDep, codPro, codDis) {
		if (prmProvincia != $("#comboprovincia").val()) {

			//  			  var numero =document.getElementById("lblInstitu").value;
			var id = codDep;
			var id2 = codPro;
			document.getElementById("combodistrito").options[document
					.getElementById("combodistrito").innerHTML = ""];
			document.getElementById("combodistrito").options[document
					.getElementById("combodistrito").options.length] = new Option(
					"Seleccionar", "");

			$.ajax({
						type : "GET",
						///baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
						url : "../baseController/buscarDistrito?codigodepartamento="
								+ id + "&" + "codigoprovincia=" + id2,
						//  				data : {codigoinst:numero},

						success : function(data) {
							//console.log("SUCCESS: ", data);
							//  				$('#provincia').html(data);
							//  				alert(data[1].codigo);
							//  				document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

							//  				for(var f=0;f<document.getElementById("combodistrito").length;f++){
							//  					if (document.getElementById("combodistrito").length > 0) {
							//  						document.getElementById("combodistrito").remove(document.getElementById("combodistrito").length-1);
							//  				    }

							//  					}

							for (var i = 0; i < data.length; i++) {

								document.getElementById("combodistrito").options[document
										.getElementById("combodistrito").options.length] = new Option(
										data[i].nombreUbigeo,
										data[i].codigoDistrito);

							}

						},
						error : function() {
							//console.log("ERROR: ");
						},
						complete : function() {
							if (codDis != null && codDis != "") {
								$("#combodistrito").val(codDis);
							}else{
							//	$("#combodistrito").val("");
							}

						}
					});
		}else{
			//$("#combodistrito").val("");
		}
	}

	/*********************************/ 
	var primerslap = false;
	var segundoslap = false;
	function formateafecha(fecha) {
		var fechaActual = new Date();
		var long = fecha.length;
		var dia;
		var mes;
		var ano;
		if ((long >= 2) && (primerslap == false)) {
			dia = fecha.substr(0, 2);
			if ((IsNumeric(dia) == true) && (dia <= 31) && (dia != "00")) {
				fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
				primerslap = true;
			} else {
				fecha = "";
				primerslap = false;
			}
		} else {
			dia = fecha.substr(0, 1);
			if (IsNumeric(dia) == false) {
				fecha = "";
			}
			if ((long <= 2) && (primerslap = true)) {
				fecha = fecha.substr(0, 1);
				primerslap = false;
			}
		}
		if ((long >= 5) && (segundoslap == false)) {
			mes = fecha.substr(3, 2);
			if ((IsNumeric(mes) == true) && (mes <= 12) && (mes != "00")) {
				fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
				segundoslap = true;
			} else {
				fecha = fecha.substr(0, 3);
				;
				segundoslap = false;
			}
		} else {
			if ((long <= 5) && (segundoslap = true)) {
				fecha = fecha.substr(0, 4);
				segundoslap = false;
			}
		}
		if (long >= 7) {
			ano = fecha.substr(6, 4);
			if (IsNumeric(ano) == false) {
				fecha = fecha.substr(0, 6);
			} else {
				if (long == 10) {
					if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
						fecha = fecha.substr(0, 6);
					}
				}
			}
		}
		if (long >= 10) {
			fecha = fecha.substr(0, 10);
			dia = fecha.substr(0, 2);
			mes = fecha.substr(3, 2);
			ano = fecha.substr(6, 4);
			// Año no viciesto y es febrero y el dia es mayor a 28
			if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
				fecha = fecha.substr(0, 2) + "/";
			}
		}

		if (fecha.length == 10) {

			//console.log(fecha.length);

			if (fechaCorrecta(fecha, convertirFecha(fechaActual)) == true) {
				fecha = convertirFecha(fechaActual);
				msg_advertencia("Por Favor ingrese una Fecha menor a la Actual");

			}

		}
		return (fecha);
	}
</script>

</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">

	<!-- navbar-fixed-top-->
	<nav
		class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
						href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu font-large-1"></i></a></li>
					<li class="nav-item"><a href="#" class="navbar-brand">
<!-- 							<img -->
<!-- 							alt="stack admin logo" -->
<%-- 							src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" --%>
<!-- 							class="brand-logo"> -->
							<h2 class="brand-text" style="font-size: 1.54rem;"><img alt="stack admin logo" src="${pageContext.request.contextPath}/assets/img/Logo-Kumitsari-white.png" class="brand-logo"></h2></a></li>
					<li class="nav-item hidden-md-up float-xs-right"><a
						data-toggle="collapse" data-target="#navbar-mobile"
						class="nav-link open-navbar-container"><i
							class="fa fa-ellipsis-v"></i></a></li>
				</ul>
			</div>
			<div class="navbar-container content container-fluid">
				<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
					<jsp:include
						page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
				</div>
			</div>
		</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->

	<div data-scroll-to-active="true"
		class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
		<div class="main-menu-content">
			<jsp:include
				page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
		</div>
	</div>

	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item" style="cursor: default;"><a href="#">General</a></li>
								<li class="breadcrumb-item active" style="cursor: default;"><a href="#">Gestor</a></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<div class="content-body">
				<!-- Analytics spakline & chartjs  -->
				<section id="configuration">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="titulo_gestor">Registro de gestor</h4>
									<a class="heading-elements-toggle"><i
										class="fa fa-ellipsis-v font-medium-3"></i></a>
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
										<div class="col-md-12">
											<f:form id="frmRegistroPersonal" onsubmit="return false"
												class="form-horizontal" role="form" method="post"
												action="grabar" novalidate="true"
												onSubmit="return validarGrabar()">
												
												<input id="contextPath" type="hidden"
												value="${pageContext.request.contextPath}">
																		
												<div class="form-body">
													<div class="row">
														<div class="col-xs-12">
															<h5>DATOS GENERALES</h5>
														</div>
													</div>

													<div class="row">
														<f:input type="hidden" path="codigo" id="codigoPersonal" />
														<f:input type="hidden" path="personaBean.codigo"
															id="codigoPersona" />

														<div class="col-md-3">
															<div class="form-group">
																<label for="situacionPersonal">Situaci&oacute;n
																	<span class="required">*</span>
																</label>
																<div class="controls">
																	<f:select id="situacionPersonal"
																		path="situacionPersonal.codigoRegistro"
																		class="form-control"
																		data-validation-required-message="Este campo es requerido"
																		required="required">
																		<f:option value="" selected="true" disabled="disabled"
																			label="Seleccionar" />
																		<f:options items="${lstSituacion}"
																			itemValue="codigoRegistro" itemLabel="nombreCorto" />
																	</f:select>
																</div>
															</div>
														</div>

														<div class="col-md-3">
															<div class="form-group">
																<label for="situacionUsuario">Tipo de documento <span
																	class="required">*</span></label>
																<div class="controls">
																	<f:select id="codigoTipoDocumento"
																		path="personaBean.tipoDocumento.codigoRegistro"
																		class="form-control" onChange="formatoDocumento();"
																		data-validation-required-message="Este campo es requerido"
																		required="required">
																		<f:option value="" selected="true" disabled="disabled"
																			label="Seleccionar" />
																		<f:options items="${lstTipoDocumento}"
																			itemValue="codigoRegistro" itemLabel="nombreCorto" />
																	</f:select>
																</div>
															</div>
														</div>

														<div class="form-group col-md-3">
															<label for="projectinput2">N&uacute;mero de documento <span class="required">*</span>
															</label>
															<div class="controls">
																<f:input id="numeroDocumentoPersona"
																    onKeyUp="this.value = this.value.toUpperCase();"
																	onkeypress="buscarPersona(event);return justNumbers(event);"
																	type="text" class="form-control"
																	path="personaBean.numeroDocumento"
																	data-validation-required-message="Este campo es requerido"
																	maxlength="15" required="required" onpaste="return false;"/>
																	<f:input type="hidden" id="textNumeroDocumentoPersona" path="personaBean.numeroDocumento"/>
															</div>
														</div>

														<div class="form-group col-md-3">
															<label for="situacionUsuario">Nacionalidad <span
																class="required">*</span></label>
															<div class="controls">
																<f:select id="nacionalidadPersonal"
																	path="personaBean.nacionalidad.codigoRegistro"
																	class="form-control"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="" label="Seleccionar" selected="true"
																		disabled="disabled" />
																	<f:options items="${lstNacionalidad}"
																		itemValue="codigoRegistro" itemLabel="nombreCorto" />
																</f:select>
															</div>
														</div>
													</div>


													<div class="row">
														<div class="form-group col-md-3">
															<label for="projectinput1">Nombres <span
																class="required">*</span></label>
															<div class="controls">
																<f:input id="nombrePersonal"
																	onKeyUp="this.value = this.value.toUpperCase();"
																	type="text" class="form-control"
																	path="personaBean.nombrePersona"
																	data-validation-required-message="Este campo es requerido"
																	required="required" 
																	maxlength="30"/>
																	<f:input type="hidden" id="textNombrePersona" path="personaBean.nombrePersona"/>
															</div>
														</div>

														<div class="form-group  col-md-3">
															<label for="apellidopaterno">Apellido paterno <span
																class="required">*</span></label>
															<div class="controls">
																<f:input id="apellidoPaternoPersonal"
																	onKeyUp="this.value = this.value.toUpperCase();"
																	type="text" class="form-control"
																	path="personaBean.apellidoPaterno"
																	maxlength="30"/>
																	<f:input type="hidden" id="textApellidoPaterno" path="personaBean.apellidoPaterno"/>
															</div>
														</div>

														<div class="form-group col-md-3">
															<label for="projectinput2">Apellido materno <span
																class="required">*</span></label>
															<div class="controls">
																<f:input id="apellidoMaternoPersonal"
																	onKeyUp="this.value = this.value.toUpperCase();"
																	type="text" class="form-control"
																	path="personaBean.apellidoMaterno"
																	maxlength="30"/>
																	<f:input type="hidden" id="textApellidoMaterno" path="personaBean.apellidoMaterno"/>
															</div>
														</div>

														<div class="form-group col-md-3">
															<label for="fechanacimiento">Fecha de nacimiento
																<span class="required">*</span>
															</label>
															<div class="controls">
																<f:input id="strfechaNacimiento" name="fecha"
																	type="text" class="form-control"
																	onchange="cambiarfecha();"
																	path="personaBean.strFechaNac" size="10"
																	data-validation-required-message="Este campo es requerido"
																	maxlength="10"
																	onKeyUp="this.value=formateafecha(this.value);"
																	required="required" />
																	<f:input type="hidden" id="textStrFechaNac" path="personaBean.strFechaNac"/>
																<%--                                                     <f:input id="fechaNacimiento"  name="fecha" type="hidden"  class="form-control"   path="personaBean.fechaNac" size="10" maxlength="10" onKeyUp = "this.value=formateafecha(this.value);" /> --%>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="form-group col-md-3">
															<label for="projectinput2">Grado o t&iacute;tulo
																<span class="required">*</span>
															</label>
															<div class="controls">
																<f:select id="gradoPersonal"
																	path="gradoPersonal.codigoRegistro"
																	class="form-control"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="" label="Seleccionar" />
																	<f:options items="${lstGrado}"
																		itemValue="codigoRegistro" itemLabel="nombreCorto" />
																</f:select>
															</div>
														</div>

														<div class="form-group col-md-3">
															<label for="telefonoUsuario">Cargo <span
																class="required">*</span></label>
															<div class="controls">
																<f:select id="cargoPersonal"
																	path="cargoPersonal.codigoRegistro"
																	class="form-control"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="" label="Seleccionar" />
																	<f:options items="${lstCargo}"
																		itemValue="codigoRegistro" itemLabel="nombreCorto" />
																</f:select>
															</div>
														</div>


														<div class="form-group col-md-3">
															<label for="telefonoUsuario">Lengua materna <span
																class="required">*</span></label>
															<div class="controls">
																<f:select id="lenguaMaterna"
																	path="personaBean.lenguaBean.codigo"
																	class="form-control selectReset"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="0" class="optionReset"
																		label="Seleccionar" />

																	<f:options items="${lstLengua}" itemValue="codigo"
																		itemLabel="nombre" />
																</f:select>
															</div>
														</div>


														<div class="form-group col-md-3 mb-2">
															<label for="situacionUsuario">Perfil</label>
															<div class="controls">

																<f:textarea path="personaBean.tipoPersona.nombreCorto"
																	class="form-control" id="my-text-box" disabled="true"
																	style="resize: none;"></f:textarea>

															</div>
														</div>


													</div>

													<div class="row">
														<div class="form-group col-md-3">
															<label for="projectinput2">G&eacute;nero <span
																class="required">*</span></label>
															<div class="controls">
																<f:select id="sexoPersonal"
																	path="personaBean.sexo.codigoRegistro"
																	class="form-control"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="" label="Seleccionar" />
																	<f:options items="${lstSexo}"
																		itemValue="codigoRegistro" itemLabel="nombreCorto" />
																</f:select>
															</div>
														</div>

														<div class="form-group col-md-3">
															<label for="telefonoUsuario">Tel&eacute;fono /
																Celular <span class="required">*</span>
															</label>
															<div class="controls">
																<f:input id="telefonoUsuario" type="text"
																	class="form-control" path="personaBean.telefono"
																	data-validation-required-message="Este campo es requerido"
																	required="required" onpaste="return false;"/>
																	<f:input type="hidden" id="textTelefono" path="personaBean.telefono"/>
															</div>
														</div>

														<div class="form-group col-md-3">
															<label for="correoElectronico">Correo
																electr&oacute;nico <span class="required">*</span>
															</label>
															<div class="controls">
																<f:input id="correoElectronico" type="email"
																	class="form-control" path="personaBean.correo"
																	     onKeyUp="this.value = this.value.toLowerCase();" 
																	data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})"
																	data-validation-regex-message="Ingresa un correo valido"
																	data-validation-required-message="Este campo es requerido"
																	required="required" 
																	maxlength="50"/>
																	<f:input type="hidden" id="textCorreo" path="personaBean.correo"/>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="col-xs-12">
															<h5>DATOS DE RESIDENCIA</h5>
															<br>
														</div>
													</div>

													<div class="row">
														<div class="form-group col-md-3">
															<label for="cboRegion">Región <span
																class="required">*</span></label>
															<div class="controls">
																<f:select path="personaBean.ubigeoBean.codigoRegion"
																	onchange="buscarProvincia();" id="provinciaSelect"
																	class="form-control"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="" label="Seleccionar" />
																	<f:options items="${lstRegion}"
																		itemValue="codigoRegion" itemLabel="nombreUbigeo" />
																</f:select>
																<f:input type="hidden" id="textCodigoRegion" path="personaBean.ubigeoBean.codigoRegion"/>
															</div>
														</div>
														<div class="form-group col-md-3">
															<label for="cboProvincia">Provincia <span
																class="required">*</span></label>
															<div class="controls">
																<f:select path="personaBean.ubigeoBean.codigoProvincia"
																	onchange="buscarDistrito();" id="comboprovincia"
																	name="comboprovincia" class="form-control"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="" label="Seleccionar" />
																	<f:options items="${lstProvincia}"
																		itemValue="codigoProvincia" itemLabel="nombreUbigeo" />
																</f:select>
																	<f:input type="hidden" id="textCodigoProvincia" path="personaBean.ubigeoBean.codigoProvincia"/>
															</div>
														</div>
														<div class="form-group col-md-3">
															<label for="cboDisctrito">Distrito <span
																class="required">*</span></label>
															<div class="controls">
																<f:select path="personaBean.ubigeoBean.codigoDistrito"
																	id="combodistrito" name="combodistrito"
																	class="form-control"
																	data-validation-required-message="Este campo es requerido"
																	required="required">
																	<f:option value="" label="Seleccionar" />
																	<f:options items="${lstDistrito}"
																		itemValue="codigoDistrito" itemLabel="nombreUbigeo" />
																</f:select>
																<f:input type="hidden" id="textCodigoDistrito" path="personaBean.ubigeoBean.codigoDistrito"/>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-md-9">
															<label for="direccionPersona">Dirección <span
																class="required">*</span></label>
															<div class="controls">
																<f:input id="direccionPersona" type="text"
																	class="form-control"
																	path="personaBean.direccionPersona"
																	data-validation-required-message="Este campo es requerido"
																	maxlength="50" required="required" />
																	<f:input type="hidden" id="textDireccionPersona" path="personaBean.direccionPersona"/>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="form-group col-md-12 text-right">
                                                  			<a class="btn btn-secondary mr-1" href="${pageContext.request.contextPath}/personalController/listado">
                                                  				 <i class="fa fa-close"></i> 	Cancelar</a>
                                                  			<button type="button" id="limpiar" onclick="limpiarformpersonal();"
																class="btn btn-secondary mr-1">
																<i class="fa fa-eraser"></i> Limpiar
															</button>
															<button type="submit" id="btnRegistroPersonal"
																class="btn btn-primary"
																onclick="registrarPersonal();activateGuardar = false;">
																<i class="ft-search"></i> Guardar
															</button>
														</div>
													</div>
												</div>
											</f:form>
											
											<f:form id="frmListado" class="form-horizontal" 
													role="form" method="post" action="lista">
												<button type="submit" id="btnListadoAdministrativo"
																style='display:none;'
																class="btn btn-primary" >
																<i class="ft-search"></i> busca
															</button>	
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

	<script type="text/javascript">
		function validarRequired(idfrom) {

			var departamento = document.getElementById("provinciaSelect");
			var provincia = document.getElementById("comboprovincia");
			var distrito = document.getElementById("combodistrito");

			var $myForm = $(idfrom);
			if (!$myForm[0].checkValidity() || departamento.value == "00"
					|| provincia.value == "00" || distrito.value == "00") {

				$("#provinciaSelect").css("border",
						"2px solid rgba(22, 211, 154, .5)");
				$("#comboprovincia").css("border",
						"2px solid rgba(22, 211, 154, .5)");
				$("#combodistrito").css("border",
						"2px solid rgba(22, 211, 154, .5)");

				msg_advertencia("Debe completar los campos requeridos correctamente");

				if (departamento.value == "00") {
					$("#provinciaSelect").css("border",
							"2px solid rgba(210, 60, 60, .5)");
					$("#provinciaSelect").css("color", "#444");
					departamento.focus();
				}
				if (provincia.value == "00") {
					$("#comboprovincia").css("border",
							"2px solid rgba(210, 60, 60, .5)");
					$("#comboprovincia").css("color", "#444");
					provincia.focus();
				}
				if (distrito.value == "00") {
					$("#combodistrito").css("border",
							"2px solid rgba(210, 60, 60, .5)");
					$("#combodistrito").css("color", "#444");
					distrito.focus();
				}

			} else {

				ejecutarGuardar = true;
				
				$(".optionReset").val("");
				
				registrarPersonal();
			}

		}

		function cambiarfecha() {

			// 		var date = document.getElementById("strfechaNacimiento").value;

			// 		document.getElementById("fechaNacimiento").value= date;
			// 		alert(document.getElementById("fechaNacimiento").value);

		}

		document.getElementById("btnRegistroPersonal").addEventListener(
				"click", function() {

					prmRegion = $('#provinciaSelect').val();
					prmProvincia = $('#comboprovincia').val();
					prmDistrito = $('#combodistrito').val();

					// 	  if($('#provinciaSelect').val()=="00"){

					// // 		  $('#provinciaSelect').val("");
					// 	  }

					// 	  if($('#comboprovincia').val()=="00"){

					// 	  }

					// 	  if($('#combodistrito').val()=="00"){

					// 	  }
				});
	</script>

	<jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
	<!-- BEGIN VENDOR JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js"
		type="text/javascript"></script>
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
		type="text/javascript"></script>

	<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script> -->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN STACK JS-->
	<script
		src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/js/core/app.js"
		type="text/javascript"></script>
	<!-- END STACK JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<script
		src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/page/general/gestor/gestor.js"
		type="text/javascript"></script>		
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/aes.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/pbkdf2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/AesUtil.js"></script>
	<!-- END PAGE LEVEL JS-->
	<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		function validarGrabar() {

			
			return ejecutarGuardar;
		}
		
		   function justNumbers(e) {
	    	    
		   		var numeroDocumento = $('#numeroDocumentoPersona').val();
		   		var tipoDocumento = $('#codigoTipoDocumento').val();
		   		if (tipoDocumento != 0) {
		   			/*DNI*/
		   			if (tipoDocumento == 1) {
		   				if (numeroDocumento.length < 8) {
		   					var keynum = window.event ? window.event.keyCode
		   							: e.which;
		   					if ((keynum == 8) || (keynum == 46))
		   						return true;
		   					return /\d/.test(String.fromCharCode(keynum));
		   				} else {
		   					var keynum = window.event ? window.event.keyCode
		   							: e.which;
		   					if ((keynum == 8))
		   						return true;
		   					e.preventDefault();
		   				}
		   			}
		   			/*PASAPORTE*/
		   			if (tipoDocumento == 2) {
		   				if (numeroDocumento.length < 12) {
		   					 key = e.keyCode || e.which;
		   					    tecla = String.fromCharCode(key).toString();
		   					    letras = "1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
		   					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.
//		 						alert(tecla);
//		    					    alert(e.keyCode);
		   					    tecla_especial = false
		   					    for(var i in especiales) {
		   					        if(key == especiales[i]  ) {
//		    					           alert(entro);
		   					        	tecla_especial = true;
		   					            break;
		   					        }
		   					        
		   					    }
		   						 if(e.keyCode == 32){
//		    							hya = "especia"
//		    							 alert(hya);
							         return false;
							        }
//		    					 if (tecla == "32" ) {
//		    						 return false;
//		    					 }

		   					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
		   					/* alert('Tecla no aceptada');*/
		   					        return false;
		   					      }
		   				} else {
		   					e.preventDefault();
		   				}
		   			}
		   			
		   			/*OTRO*/
							if (tipoDocumento == 3) {
//		    				if (numeroDocumento.length < 12) {
		   					 key = e.keyCode || e.which;
		   					    tecla = String.fromCharCode(key).toString();
		   					    letras = "1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
		   					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.
		 	 
		   					    tecla_especial = false
		   					 if(e.keyCode == 32){
//									hya = "especia"
//									 alert(hya);
						         return false;
						        }
		   					    for(var i in especiales) {
		   					        if(key == especiales[i]  ) {
//		    					           alert(entro);
		   					        	tecla_especial = true;
		   					            break;
		   					        }
		   					        
		   					    }
		   					
//		    					 if (tecla == "32" ) {
//		    						 return false;
//		    					 }

		   					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
		   					/* alert('Tecla no aceptada');*/
		   					        return false;
		   					      }
//		    				} else {
//		    					e.preventDefault();
//		    				}
		   			}
		   		}
		   	}
		   function formatoNumeroDocumento(){
		   		var tipoDocumento = $('#codigoTipoDocumento').val();
//		    		alert(tipoDocumento)
		   		if(tipoDocumento==1){
//		    	   		alert(tipoDocumento)
		   			$("#numeroDocumentoPersona").val('');
		   			$("#numeroDocumentoPersona").attr("pattern","[0-9]{8}");
		   			//$("#numeroDocumentoPersona").val("");
		   		}
		   		if(tipoDocumento==2){
		   			$("#numeroDocumentoPersona").val('');
		   			$("#numeroDocumentoPersona").attr("pattern","[a-zA-Z]{5,12}");
		   			//$("#numeroDocumentoPersona").val("");
		   		}
		   		if(tipoDocumento==3){
		   			$("#numeroDocumentoPersona").val('');
		   			 $("#numeroDocumentoPersona").removeAttr("pattern");
		   			 //$("#numeroDocumentoPersona").val("");
		   		}

		   	}
			
		
	</script>

</body>
</html>