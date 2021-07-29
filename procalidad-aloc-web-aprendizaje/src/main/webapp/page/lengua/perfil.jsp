<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${lenguaBean.nombre}</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="${lenguaBean.nombre}" />


<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="apple-touch-icon" sizes="57x57"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="${pageContext.request.contextPath}/assets/images/favicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="${pageContext.request.contextPath}/assets/images/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${pageContext.request.contextPath}/assets/images/favicon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="${pageContext.request.contextPath}/assets/images/favicon/favicon-16x16.png">
<link rel="manifest"
	href="${pageContext.request.contextPath}/assets/images/favicon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="${pageContext.request.contextPath}/assets/images/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">


<!-- Bootstrap  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

<!-- font-awesome -->
<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" media="all">

<!-- Styleswitcher ( This style is for demo purposes only, you may delete this anytime. ) -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/toastr.min.css">


<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/desing-app-view.css">
<!-- End demo purposes only -->
<!-- umbrella -->
<link href="${pageContext.request.contextPath}/assets/css/animate.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/gp_product_carousel_advance.min.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/assets/css/notifIt.min.css" rel="stylesheet">
<!-- Modernizr JS -->

<style type="text/css">
	.bloqueoTotal {
		pointer-events: none;
		opacity: 0.4;
	}
</style>

<script src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	<style type="text/css">
		.circle-lengua-opt:hover{
			z-index: 2;
			transform: scale(1.1);
		}
	</style>

</head>
<body class="page-header-color">
<% String variable = request.getParameter("variable"); %>
<p>Me han pasado <%= variable %></p>
	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/head-nav-view.jsp"></jsp:include>

	<div id="Subheader" style="display: none">
		<div class="container">
			<div class="column one">
				<h1 class="title">Iniciar Sesión</h1>
			</div>
		</div>
	</div>

	<section id="lst-lengua" class="bg-fondo-app">
		<div id="main-perfil" class="container">
			<input type="hidden" id="codlenguaTreeVal" value="${lenguaBean.codigo}">
			<input type="hidden" id="codlenguaValEncrypt" value="${lenguaBean.codigoEncrypt}">

			<input type="hidden" id="nomlenguaTreeVal" value="${lenguaBean.nombre}">
			<input type="hidden" id="pageActualTreeVal" value="${pageContext.request.requestURI}">
			<input type="hidden" id="codigousarioBean" value="${usuarioEstudiante.codigo}">
			<input type="hidden" id="nombrefotouser" value="${usuarioEstudiante.persona.nombrefotouser}">
			<input type="hidden" id="codigoPersona" value="">
			<div id="menu-app">
				<div class="bseccion">

				<c:if test="${lenguaBean.codigo > 0}">
					<nav>
				   		<ul>
				   		<c:if test="${lenguaBean.codigo > 0}">
				   			<li id="lengua-actual">
								<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}" class="circle-lengua-opt tooltipx">
									<c:choose>
										<c:when test="${not empty lenguaBean.imagenNombre}">
											<img src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="${lenguaBean.imagenNombre}" class="img-responsive" width="72">
										</c:when>
										<c:otherwise>
											<img src="${pageContext.request.contextPath}/assets/images/nivel/link-quechua.png" alt="" class="img-responsive" width="72">
										</c:otherwise>
									</c:choose>
									<span class="tooltiptext tooltip-right">${lenguaBean.nombre}</span>
								</a>
				   			</li>
				   		</c:if>

						<c:if test="${lenguaEstructuraBean.codigo > 0}">
				   			<li class="grises grises-hover">

								<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}/nivel/${lenguaEstructuraBean.codigoEncrypt}">
									<%-- <img src="${pageContext.request.contextPath}/assets/images/icono-panel/basico-1.png" alt="" class="img-responsive"> --%>

						   				<span class="circle-item gris-item-circle tooltipx circle_color_0${lenguaEstructuraBean.subNivel.valor2}">
							   				<span class="name-one">${lenguaEstructuraBean.lenguaNivelBean.inicialNombre}</span>
			   								<span class="name-two">${lenguaEstructuraBean.subNivel.valor2}</span>
			   								<span class="tooltiptext tooltip-right">${lenguaEstructuraBean.lenguaNivelBean.nombreNivel}</span>
						   				</span>
								</a>
				   			</li>
				   		</c:if>
				   		<c:if test="${unidadBean.codigo > 0}">
				   			<li class="grises grises-hover">
								<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}/nivel/${lenguaEstructuraBean.codigoEncrypt}/unidad/${unidadBean.codigoEncrypt}">
									<%-- <img src="${pageContext.request.contextPath}/assets/images/icono-panel/unidad-1.png" alt="" class="img-responsive"> --%>

						   				<span class="circle-item gris-item-circle tooltipx">
							   				<span class="name-one">${unidadBean.lenguaUnidadBean.inicialNombre}</span>
			   								<span class="name-two"> ${unidadBean.unidad.codigoRegistro} </span>
			   								<c:if test="${not empty unidadBean.nombre}"><span class="tooltiptext tooltip-right">${unidadBean.nombre}</span></c:if>
						   				</span>
								</a>
				   			</li>
				   		</c:if>
				   		<c:if test="${unidadLeccionBean.leccion.codigoRegistro > 0}">
				   			<li>
				   				<span class="circle-item name-leccion tooltipx">
				   					<span class="name-one"><c:choose>
												<c:when
													test="${unidadLeccionBean.leccion.codigoRegistro == '9'}">
														E
												</c:when>
														<c:otherwise>
															${unidadLeccionBean.lenguaLeccionBean.inicialNombre}
														</c:otherwise>
										</c:choose></span>
				   					<span class="name-two">
				   					  <c:choose>
												<c:when
													test="${unidadLeccionBean.leccion.codigoRegistro == '9'}">
													v
											   </c:when>
											   <c:otherwise>
											   		${unidadLeccionBean.leccion.codigoRegistro}
											   </c:otherwise>
											</c:choose>

											</span>
									<c:if test="${(unidadLeccionBean.leccion.codigoRegistro != '9') and (not empty unidadLeccionBean.nombre)}"><span class="tooltiptext tooltip-right">${unidadLeccionBean.nombre}</span></c:if>
				   				</span>
				   			</li>
				   			</c:if>
				   		</ul>
				   	</nav>
				   	</c:if>
					<div style="display:none;">
						<input type="hidden" id="codusuariomat" value="${usuarioMatriculaBean.codigo}">
						<input type="hidden" id="codAluMoneG"  	value="${alumnoMonedaGBean.codigo}">
						<input id="contextPath" type="hidden"   value="${pageContext.request.contextPath}">
						<input type="hidden" id="idValImgNormal" value="${beanMascota.imagenNormal}">
						<input type="hidden" id="idValImgAlegre" value="${beanMascota.imagenAlegre}">
						<input type="hidden" id="idValImgTriste" value="${beanMascota.imagenTriste}">
						<input type="hidden" id="idValImgExclam" value="${beanMascota.imagenExclamativa}">
						<input type="hidden" id="idValImgNormalAnim" value="${beanMascota.imagenNormalAlter}">
					</div>
					<div id="box-masct">
						<c:choose>
							<c:when test="${not empty beanMascota.imagenNormal}">
								<c:if test="${not empty beanMascota.imagenNormalAlter}">
									<div id="check_mascota" class="text-center">
										<div class="flip-switch">
										  <input type="checkbox" id="idCheckActiveAnimMasc" value="${swActivoMascotaAnim}" <c:if test="${swActivoMascotaAnim == 1}">checked</c:if> >
										  <label for="idCheckActiveAnimMasc"></label>
										</div>
									</div>
								</c:if>
								<c:if test="${swActivoMascotaAnim==1}">
									<img
									src="${pageContext.request.contextPath}/mascota/${beanMascota.imagenNormalAlter}"
									alt="${beanMascota.imagenNormalAlter}" class="img-responsive">
								</c:if>
								<c:if test="${swActivoMascotaAnim!=1}">
									<img
									src="${pageContext.request.contextPath}/mascota/${beanMascota.imagenNormal}"
									alt="${beanMascota.imagenNormal}" class="img-responsive">
								</c:if>
							</c:when>
							<c:otherwise>
								<img
									src="${pageContext.request.contextPath}/assets/images/plumillaNeutro.png"
									alt="No disponible" class="img-responsive">
							</c:otherwise>
						</c:choose>

					</div>
				</div>

			</div>

			<div id="content-app" class="bg-perfil-content">
				<section id="banner-perfil">
					<div id="content-foto">
						<div class="row">
							<div class="col-sm-12" id="box-img-perfil">
							<f:form id="frmsubirfotouser" class="form-horizontal" role="form"
		enctype="multipart/form-data" method="post"  onsubmit="return false;"
		action="actualizarDatosFotoUser">

								<%-- <label for="btn-img-perfil">
									<img src="${pageContext.request.contextPath}/assets/images/avatar.png" class="img-circle img-responsive" alt="">
								</label>
								<input type="file" name="" id="btn-img-perfil" value="" placeholder=""> --%>
								<input type="hidden" id="imgnomUser" value="">
								<f:input type="file" path="usuario.persona.filefotouser" name="fileSubNivel"
						id="fileSubNivel"
						onchange="return validar_file('fileSubNivel','imgNivel','${pageContext.request.contextPath}/fotouser/${nombrefotouser}','${usuarioEstudiante.codigo}')"
						value="" accept="image/png, .jpeg, .jpg, image/gif"
						style="display:none" />
					<div id="list1" style="cursor: pointer;"
						class="form-group col-md-12 text-center">
						<c:choose>
							<c:when test="${not empty nombrefotouser}">
								<label for="">
								<img id="imgNivel"
									onclick="abrir_input('fileSubNivel')"
									src="${pageContext.request.contextPath}/fotouser/${nombrefotouser}"
									class="img-circle img-responsive" alt="" data-toggle="modal"
									data-target="#xlarge" style="cursor: pointer;"></label>
								<div id="fake-btn-1" style="width: 320px; height: 320px; display: none"
									class="form-input text-xs-center truncate"></div>
							</c:when>

							<c:otherwise>
								<label for=""><img id="imgNivel"
									src="${pageContext.request.contextPath}/assets/images/avatar.png"
									onclick="abrir_input('fileSubNivel')" class="img-circle img-responsive" alt="" style="cursor: pointer;"></label>
							</c:otherwise>
						</c:choose>
					</div>
								<!-- <label id="labelPerfil" for="btn-img-perfil">Modificar foto perfil<i class="icon-edit"></i></label> -->
								<button type="button" class="btn btn-link" type="submit" onclick="grabarfotouser();"><i class="icon-save"></i></button>
									</f:form>
							</div>
						</div>
					</div>
					<div id="content-foto-info">
						<div class="row">
							<div class="col-sm-12">
								<p > Perfil: </p>
								<b id="nomPerfil"></b>
								<p>Fecha ultima sesión:</p>
								<b id="fechaoculta" style="display: none;"></b>
								<b id="fechaNueva"></b>
							</div>
						</div>
					</div>
				</section>
				<aside id="content-perfil">
					<div class="row">
						<div class="col-md-12 to-animate fadeInUp animated">
							<div class="row">
								<div class="col-sm-12">
									<h2 id="title-perfil"></h2>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<hr>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<form class="form-horizontal" id="frm-info"  onsubmit="return false;">
									  <div class="form-group">
									    <label class="col-sm-4 control-label">Institución</label>
									    <div class="col-sm-8">
									      <p class="form-control-static" id="nomInstitucion">Nombre del institución</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-4 control-label">Teléfono<span class="required">*</span></label>
									    <div class="col-sm-8">
									      <input type="text" id="telefonoUser" class="form-control" required="required" disabled >
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="mail_user" class="col-sm-4 control-label">C. electrónico<span class="required">*</span></label>
									    <div class="col-sm-8">
									      <input type="email" class="form-control" id="mail_user" required="required" maxlength="50" disabled>
									    </div>
									  </div>
									  <div class="form-group">
									    <div class="col-sm-8 col-md-offset-4" id="msg-info-d">

									  	</div>
									  </div>
									  <div class="form-group">
									    <div class="col-sm-8 col-md-offset-4">
									      <button type="button" class="btn btn-default mdf-btn-info" onclick="btnModicar('1')">Modificar datos</button>
									      <button type="submit" class="btn btn-primary" id="mGuardar-btn-info" onclick="grabardatosUser();">Guardar</button>
									    </div>
									  </div>
									</form>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<hr>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<form class="form-horizontal" id="frm-passw" autocomplete="off" onsubmit="return false;">
									  <div class="form-group">
									    <label class="col-sm-4 control-label">Usuario</label>
									    <div class="col-sm-8">
									      <p class="form-control-static" id="nomUser" >Nombre usuaro</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-4 control-label">Contraseña actual</label>
									    <div class="col-sm-8" id="claveActual">
									      <input onkeyup="quitarEspacios()" type="password" class="form-control" id="passwa" required="required"  maxlength="150" autocomplete="off"  disabled>
									      <input  onkeyup="quitarEspacios()" type="text" class="form-control" placeholder="password" id="passwaocul"  maxlength="150" autocomplete="off" required="required" style="display: none;" disabled>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-4 control-label">Nueva contraseña</label>
									    <div class="col-sm-8">
									      <input onkeyup="quitarEspacios()" type="password" class="form-control" id="passwn" required="required"  maxlength="150" autocomplete="off" disabled>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-4 control-label">Repetir nueva contraseña</label>
									    <div class="col-sm-8">
									      <input onkeyup="quitarEspacios()" type="password" class="form-control" id="passwr" required="required" maxlength="150" autocomplete="off" disabled>
									    </div>
									  </div>
									  <div class="form-group">
									    <div class="col-sm-8 col-md-offset-4" id="msg-passw">

									  	</div>
									  </div>

									  <div class="form-group">
									    <div class="col-sm-8 col-md-offset-4">
									      <button type="button" class="btn btn-default mdf-btn-contrasenia" onclick="btnModicar('2')">Modificar datos</button>
									      <button type="submit" class="btn btn-primary" id="mGuardar-contrasenia" onclick="btnGuardar('2');">Guardar</button>
									    </div>
									  </div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</aside>
			</div>

		</div>
	</section>

<%-- 	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/footer-view.jsp"></jsp:include> --%>


	<jsp:include page="${pageContext.request.contextPath}/../layouts/tienda-modal-view.jsp"/>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/premio-modal-view.jsp"/>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/detalle-tienda-modal-view.jsp"/>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/ganar-premio-modal-view.jsp"/>

	<%-- <c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><jsp:include page="${pageContext.request.contextPath}/../layouts/tree-view.jsp"/></c:if> --%>

	<script
		src="${pageContext.request.contextPath}/assets/js/aes.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/pbkdf2.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/AesUtil.js"></script>
	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.stellar.min.js"></script>
	<!-- Counter -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.countTo.js"></script>

	<script
		src="https:////cdnjs.cloudflare.com/ajax/libs/wow/0.1.12/wow.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/popover.min.js"
		type="text/javascript"></script>

	<!--======= Touch Swipe =========-->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.touchSwipe.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scroll.js" type="text/javascript" charset="utf-8"></script>
	<!--======= Customize =========-->
	<script src="${pageContext.request.contextPath}/assets/js/responsive_bootstrap_carousel.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/notifIt.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/page/password.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jqBootstrapValidation.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/toastr.min.js" type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/moment/moment.js"></script>
		<script
		src="${pageContext.request.contextPath}/assets/js/moment/moment-with-locales.js"></script>
	<%-- <c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><script src="${pageContext.request.contextPath}/assets/js/tree-view.js" type="text/javascript" charset="utf-8"></script></c:if>
 --%>
<script src="${pageContext.request.contextPath}/assets/js/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
 	<script type="text/javascript" charset="utf-8">
		jQuery(document).ready(function(){
			//Phone with extra
	    	$('#telefonoUser').inputmask("(999) 999-9999 / 999-999-999");
	    	//$('#telefonoUsuario').inputmask("(999) 999-9999 / 999-999-999");

		    jQuery('.scrollbar-inner').scrollbar();

			var codUsu=$('#codigousarioBean').val();



			$.ajax({
				 		async: true,
						type : "GET",
						data:{codigo:codUsu},
						url : "${pageContext.request.contextPath}/perfil/obtenerDatosUsuarioPerfil",

				success : function(data) {
					//console.log("SUCCESS: ", data);
				if (data!=null) {

					//console.log("data.perfil.nombrePerfil " + data.perfil.nombrePerfil)
					$('#codigoPersona').val(data.usuario.persona.codigo);

					$('#nomPerfil').text(data.perfil.nombrePerfil);
					$('#title-perfil').text(data.usuario.persona.nombreCompleto);

					$('#nomInstitucion').text(data.usuario.persona.lenguaBean.matriculaBean.insti.nombreInstitucion);
					$('#mail_user').val(data.usuario.persona.correo);
					$('#telefonoUser').val(data.usuario.persona.telefono);

					$('#nomUser').text(data.usuario.nombreUsuario);
					//alert('1');
					//$('#passwa').val(data.usuario.decryptpasswordUsuario);
					$('#passwaocul').val(data.usuario.passwordUsuario);
					$('#imgnomUser').val(data.usuario.persona.nombrefotouser);
					if (data.usuario.ultfechaAcceso!=null) {
						$('#fechaNueva').text(moment(data.usuario.ultfechaAcceso).locale("es").format('LLL'));
					}else {
						$('#fechaNueva').text('-');
					}



						//var element = $("#fechaoculta").text().split(' ');
				      //  var fecha = element[0].split('-');
				       // alert('Fecha formateada: '+fecha[2]+'/'+fecha[1]+'/'+fecha[0]);
				       // $('#fechaNueva').text('Fecha formateada: '+fecha[2]+'/'+fecha[1]+'/'+fecha[0]);
				        //var tiempo = element[1].split(':');
				        //alert('Tiempo formateado: '+tiempo[0]+'h '+tiempo[1]+'min '+tiempo[2]+' seg');


					if (data.usuario.persona.nombrefotouser!=null) {
						//console.log('contextPath+"/fotouser/"+data.usuario.persona.nombrefotouser' + contextPath+"/fotouser/"+data.usuario.persona.nombrefotouser);
						var imgid = "imgNivel";
						var file = "fileSubNivel";
						// var idDetalle = "idRelacionDetalle"+(i+1);
						var imgsrc = contextPath+"/fotouser/"+data.usuario.persona.nombrefotouser;
						$('#'+imgid).attr('src',imgsrc);
						$("#fileSubNivel").attr("value",data.usuario.persona.nombrefotouser);
					}


				}else {
					//console.log('error::::data');
				}



			},
			error : function(xhr, status, er) {
				//console.log("error: " + xhr + " status: " + status + " er:" + er);

					}
		});

		});
		function linkSalir() {
			window.location = "${pageContext.request.contextPath}";
		}
		function show_detalle_moneda() {
			$(".tab-medalla").hide();
			$("#md-detalle-medalla").show();
		}
		new WOW().init();




    $(function() {

        $('#passwa').password().on('show.bs.passwa', function(e) {

            $('#eventLog').text('On show event');

            $('#methods').prop('checked', true);

        }).on('hide.bs.passwa', function(e) {

                    $('#eventLog').text('On hide event');

                    $('#methods').prop('checked', false);

                });
        $('#methods').click(function() {

            $('#passwa').password('toggle');

        });
    });

	WebFontConfig = {
	google: { families: ['Quicksand:300,400,500,700'] } };
	(function() {
		var wf = document.createElement('script');
		wf.src = ('https:' == document.location.protocol ? 'https' : 'http') + '://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
		wf.type = 'text/javascript';
		wf.async = 'true';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(wf, s);
	})();
	
	

</script>

	<script src="${pageContext.request.contextPath}/assets/js/main-app.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/page/page-perfil.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/page/page-usuario-perfil.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/page/validation.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>