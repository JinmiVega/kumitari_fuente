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
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="${pageContext.request.contextPath}/assets/images/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<!-- font-awesome -->
<link
	href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" media="all">

<!-- Magnific Popup -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/magnific-popup.min.css">

<!-- Bootstrap  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

<link
	href="${pageContext.request.contextPath}/assets/css/animate.min.css"
	rel="stylesheet">


<link href="${pageContext.request.contextPath}/assets/css/notifIt.min.css" rel="stylesheet">
<!-- Modernizr JS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/desing-app-view.css">

<link
	href="${pageContext.request.contextPath}/assets/css/gp_product_carousel_advance.min.css"
	rel="stylesheet" media="all">
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
	<input type="hidden" id="glosarioLengua" value="${glosarioBean.detalle}">
						<c:forEach var="mensajes" items="${lstMensajes}">
							<input type="hidden" id="msj_${mensajes.tipoMensaje.codigoRegistro}" value="${mensajes.mensajes}">
						</c:forEach>
	<section id="lst-lengua"
		class="bg-fondo-app">
		<div class="container">
			<input type="hidden" id="codlenguaTreeVal" value="${lenguaBean.codigo}">
			<input type="hidden" id="codlenguaValEncrypt" value="${lenguaBean.codigoEncrypt}">

			<input type="hidden" id="nomlenguaTreeVal" value="${lenguaBean.nombre}">
			<input type="hidden" id="pageActualTreeVal" value="${pageContext.request.requestURI}">

			<div id="menu-app">
				<div class="bseccion">
					<nav>
						<ul>
							<li id="lengua-actual"><c:choose>
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
								</c:choose></li>
						</ul>
					</nav>
					<div style="display:none;">
					<input type="hidden" id="codusuariomat" value="${usuarioMatriculaBean.codigo}">
					<input type="hidden" id="codAluMoneG"  	value="${alumnoMonedaGBean.codigo}">
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

			<div id="content-app">
				<div class="row row-bottom-padded-md">
					<div class="col-md-12 icon-desing-nv">
						<div class="row" id="ico-base-link">
							<c:forEach var="lenguaEstructura" items="${listaLenguaEstructura}">
								<div class="col-md-4 col-xs-6 col-sm-6">
									<!-- ESTE ELEMENTO a ES CON VALIDACION PARA ESTUDIANTE Y DOCENTE - DESCOMENTAR PARA EL WAR -->
									<a style="width: 205px;height: 135px;" class="fh5co-project-item image-popup to-animate fadeInUp animated ${usuarioEstudiante.codPerfilUsuSelec == 4 ? (lenguaEstructura.swActivo != '0' ? '' : 'grises disable-icon') : ''}"
									    <c:if test="${usuarioEstudiante.codPerfilUsuSelec == 4 ? (lenguaEstructura.swActivo != '0' ? true : false) : true}">href="${lenguaBean.codigoEncrypt}/nivel/${lenguaEstructura.codigoEncrypt}"</c:if> >
								   	<!-- ESTE ELEMENTO a ES SIN VALIDACION PARA ESTUDIANTE Y DOCENTE - DESCOMENTAR PARA PRUEBAS -->
								   	<%-- <a class="fh5co-project-item image-popup to-animate fadeInUp animated"
											   href="${lenguaBean.codigo}/nivel/${lenguaEstructura.codigo}"> --%>

								   		<c:choose>
								   			<c:when test="${not empty lenguaEstructura.nombreImagen}">
								   			  <img src="${pageContext.request.contextPath}/subNivel/${lenguaEstructura.nombreImagen}"
											 		 alt="${lenguaEstructura.nombreImagen}" class="img-responsive">
								   			</c:when>
								   			<c:otherwise>
								   				<c:choose>
													<c:when test="${lenguaEstructura.nivel.codigoRegistro==1}">
														<img
															src="${pageContext.request.contextPath}/assets/images/nivel/basico-${lenguaEstructura.subNivel.codigoRegistro}.png"
															alt="" class="img-responsive">
													</c:when>
													<c:when test="${lenguaEstructura.nivel.codigoRegistro==2}">
														<img
															src="${pageContext.request.contextPath}/assets/images/nivel/intermedio-${lenguaEstructura.subNivel.codigoRegistro}.png"
															alt="" class="img-responsive">
													</c:when>
													<c:when test="${lenguaEstructura.nivel.codigoRegistro==3}">
														<img
															src="${pageContext.request.contextPath}/assets/images/nivel/avanzando-${lenguaEstructura.subNivel.codigoRegistro}.png"
															alt="" class="img-responsive">
													</c:when>
											 	</c:choose>
								   			</c:otherwise>
								   		</c:choose>
									</a>
								</div>

							</c:forEach>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

<%-- 	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/footer-view.jsp"></jsp:include> --%>


	<jsp:include page="${pageContext.request.contextPath}/../layouts/tienda-modal-view.jsp"/>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/premio-modal-view.jsp"/>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/detalle-tienda-modal-view.jsp"/>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/ganar-premio-modal-view.jsp"/>

	<c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}">
		<jsp:include page="${pageContext.request.contextPath}/../layouts/tree-view.jsp"/>
	</c:if>

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
		src="${pageContext.request.contextPath}/assets/js/popover.min.js"
		type="text/javascript"></script>

	<!--======= Touch Swipe =========-->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.touchSwipe.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/scroll.js" type="text/javascript" charset="utf-8"></script>
	<!--======= Customize =========-->
	<script	src="${pageContext.request.contextPath}/assets/js/actividad/monedasyGemas.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/responsive_bootstrap_carousel.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/notifIt.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main-app.js"></script>
	<c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><script src="${pageContext.request.contextPath}/assets/js/tree-view.js" type="text/javascript" charset="utf-8"></script></c:if>
	<script type="text/javascript" charset="utf-8">
		jQuery(document).ready(function(){
		    jQuery('.scrollbar-inner').scrollbar();
		});
		function linkSalir() {
			window.location = "${pageContext.request.contextPath}";
		}
		function show_detalle_moneda() {
			$(".tab-medalla").hide();
			$("#md-detalle-medalla").show();
		}

	</script>

</body>
</html>