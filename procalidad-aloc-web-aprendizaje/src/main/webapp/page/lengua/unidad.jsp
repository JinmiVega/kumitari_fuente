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
<title>UNIDADES ${lenguaBean.nombre}</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="${lenguaBean.nombre}" />


<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="apple-touch-icon" sizes="60x60"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="57x57"
	href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-57x57.png">
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

<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="${pageContext.request.contextPath}/assets/images/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<!-- font-awesome -->
<link
	href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/assets/css/notifIt.min.css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/css/animate.min.css"
	rel="stylesheet">

<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/desing-app-view.css">

<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body class="page-header-color">
	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/head-nav-view.jsp"></jsp:include>

	<div id="Subheader" style="display: none">
		<div class="container">
			<div class="column one">
				<h1 class="title">Iniciar Sesión</h1>
			</div>
		</div>
	</div>

	<section id="lst-lengua"
		class="bg-fondo-app">
		<div class="container">
			<input type="hidden" id="codlenguaTreeVal" value="${lenguaBean.codigo}">
			<input type="hidden" id="codlenguaValEncrypt" value="${lenguaBean.codigoEncrypt}">

			<input type="hidden" id="nomlenguaTreeVal" value="${lenguaBean.nombre}">
			<input type="hidden" id="pageActualTreeVal" value="${pageContext.request.requestURI}">
			<input type="hidden" id="codlenestTreeVal" value="${lenguaEstructuraBean.codigo}">
			<input type="hidden" id="codlenestTreeValEncrypt" value="${lenguaEstructuraBean.codigoEncrypt}">
			<input type="hidden" id="codlenuniTreeVal" value="${unidadBean.codigo}">
			<input type="hidden" id="codlenuniTreeValEncrypt" value="${unidadBean.codigoEncrypt}">
			<input type="hidden" id="nivelActualTreeVal" value="${lenguaEstructuraBean.nivel.codigoRegistro}">
			<div id="menu-app">
				<div class="bseccion">
					<nav>
						<div style="display: none;">
							<input type="hidden" id="codusuariomat"
								value="${usuarioMatriculaBean.codigo}"> <input
								type="hidden" id="codAluMoneG"
								value="${alumnoMonedaGBean.codigo}">
							<input type="hidden" id="nomMascimagenNormal" value="${beanMascota.imagenNormal}">
							<input type="hidden" id="idValImgNormal" value="${beanMascota.imagenNormal}">
							<input type="hidden" id="idValImgAlegre" value="${beanMascota.imagenAlegre}">
							<input type="hidden" id="idValImgTriste" value="${beanMascota.imagenTriste}">
							<input type="hidden" id="idValImgExclam" value="${beanMascota.imagenExclamativa}">
							<input type="hidden" id="idValImgNormalAnim" value="${beanMascota.imagenNormalAlter}">
						</div>
						<ul>
							<li id="lengua-actual"><a
								href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}">
									<c:choose>
										<c:when test="${not empty lenguaBean.imagenNombre}">
											<img
												src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}"
												alt="${lenguaBean.imagenNombre}" class="img-responsive"
												width="72">
										</c:when>
										<c:otherwise>
											<img
												src="${pageContext.request.contextPath}/assets/images/nivel/link-quechua.png"
												alt="" class="img-responsive" width="72">
										</c:otherwise>
									</c:choose>
							</a></li>
							<li class="grises grises-hover">
								<a
								href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}/nivel/${lenguaEstructuraBean.codigoEncrypt}">
								<span class="circle-item name-leccion tooltipx circle_color_0${lenguaEstructuraBean.subNivel.valor2}">
									<span class="name-one">${lenguaEstructuraBean.lenguaNivelBean.inicialNombre}</span>
									<span class="name-two">${lenguaEstructuraBean.subNivel.valor2}</span>
									<span class="tooltiptext tooltip-right">${lenguaEstructuraBean.lenguaNivelBean.nombreNivel}</span>
								</span>
								</a>
							</li>

							<li>
								<span class="circle-item name-leccion tooltipx">
									<span class="name-one">${unidadBean.lenguaUnidadBean.inicialNombre}</span>
									<span class="name-two">${unidadBean.unidad.codigoRegistro}</span>
									<c:if test="${not empty unidadBean.nombre}"><span class="tooltiptext tooltip-right">${unidadBean.nombre}</span></c:if>
								</span>
							</li>
						</ul>
					</nav>
					<div id="box-masct">
						<%-- <img src="${pageContext.request.contextPath}/assets/images/plumillaNeutro.png" alt="" class="img-responsive"> --%>
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
			<div id="content-app">
				<div class="row row-bottom-padded-md">
					<div class="col-md-10 col-md-offset-1">
						<div class="row">
							<div class="col-md-12 title-subtitle">
								<div class="sub-title-ou"><span>${unidadBean.nombre}</span></div>
								<h2 class="title-minendu format-title">${unidadBean.descripcion}</h2>
							</div>
						</div>
						<div class="row" id="ico-base-link">
							<c:forEach var="leccion" items="${listaLeccion}">
								<div class="col-md-4 col-xs-6 col-sm-6">
									<a
										<c:if test="${usuarioEstudiante.codPerfilUsuSelec == 4 ? (leccion.unidadBean.codigo != '0' ? true : false) : true}">
									href="${unidadBean.codigoEncrypt}/leccion/${leccion.codigoEncrypt}"</c:if>>
										<c:choose>
												<c:when
													test="${not empty leccion.lenguaLeccionBean.nombreImagen}">

													<c:choose>
														<c:when test="${leccion.unidadBean.codigo != '0'}">
														<!--<img
															src="${pageContext.request.contextPath}/assets/images/leccion/Leccion-${leccion.leccion.codigoRegistro}.png"
															alt="" class="img-responsive">-->
															  <img
																src="${pageContext.request.contextPath}/leccion/${leccion.lenguaLeccionBean.nombreImagen}"
																alt="${leccion.lenguaLeccionBean.nombreImagen}"
																class="img-responsive">

														</c:when>
														<c:otherwise>
														<!--<img
															src="${pageContext.request.contextPath}/assets/images/leccion/Leccion-${leccion.leccion.codigoRegistro}.png"
															alt="" class="img-responsive">-->

															<img
																src="${pageContext.request.contextPath}/leccion/${leccion.lenguaLeccionBean.nombreImagenBloq}"
																alt="${leccion.lenguaLeccionBean.nombreImagenBloq}"
																class="img-responsive">

														</c:otherwise>
													</c:choose>

												</c:when>
												<c:otherwise>
													<img
												src="${pageContext.request.contextPath}/assets/images/leccion/Leccion-${leccion.leccion.codigoRegistro}.png"
												alt="" class="img-responsive">
												</c:otherwise>
										</c:choose>
										<!-- <span class="round_hover">
											<span class="text-round-hv">Lorem ipsum dolor sit</span>
										</span> -->
									</a>
									<!--
												<c:choose>
													<c:when test="${leccion.item==1}">
														<img src="${pageContext.request.contextPath}/assets/images/leccion/lec-01.png" alt="" class="img-responsive">
													</c:when>
													<c:when test="${leccion.item==2}">
														<img src="${pageContext.request.contextPath}/assets/images/leccion/lec-02.png" alt="" class="img-responsive">
													</c:when>
													<c:when test="${leccion.item==3}">
														<img src="${pageContext.request.contextPath}/assets/images/leccion/lec-03.png" alt="" class="img-responsive">
													</c:when>
													<c:when test="${leccion.item==4}">
														<img src="${pageContext.request.contextPath}/assets/images/leccion/lec-04.png" alt="" class="img-responsive">
													</c:when>
													<c:otherwise>
														<img src="${pageContext.request.contextPath}/assets/images/leccion/lec-04.png" alt="" class="img-responsive">
													</c:otherwise>
												</c:choose>
  -->

								</div>
							</c:forEach>
					<!--<div style="display: none">
					<a href="${pageContext.request.contextPath}/lengua/${lenguaBean.codigoEncrypt}/evaluacion/1">
					<button type="button" id="btn_evaluacion"   class="btn btn-outline-info btn-min-width">
					<i class="fa fa-floppy-o"></i> Evaluacion
					</button></a>	</div>
					-->
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>



	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/tienda-modal-view.jsp"></jsp:include>
	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/premio-modal-view.jsp"></jsp:include>
	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/detalle-tienda-modal-view.jsp"></jsp:include>

	<c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><jsp:include page="${pageContext.request.contextPath}/../layouts/tree-view.jsp"/></c:if>
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

	<script src="${pageContext.request.contextPath}/assets/js/scroll.js" type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/popover.min.js"
		type="text/javascript"></script>

	<!--======= Touch Swipe =========-->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.touchSwipe.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/notifIt.min.js"></script>

	<!--======= Customize =========-->
	<script
		src="${pageContext.request.contextPath}/assets/js/actividad/monedasyGemas.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/responsive_bootstrap_carousel.js"></script>
<%--
	<script
		src="${pageContext.request.contextPath}/assets/js/actividad/Evaluacion.js"></script> --%>

	<c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><script src="${pageContext.request.contextPath}/assets/js/tree-view.js" type="text/javascript" charset="utf-8"></script></c:if>



	<script type="text/javascript" charset="utf-8">
		jQuery(document).ready(function(){
		    jQuery('.scrollbar-inner').scrollbar();
		});

		function show_detalle_moneda() {
			$(".tab-medalla").hide();
			$("#md-detalle-medalla").show();
		}
		function linkSalir() {
			window.location = "index.html";
		}
	</script>

	<script src="${pageContext.request.contextPath}/assets/js/main-app.js"></script>

</body>
</html>

