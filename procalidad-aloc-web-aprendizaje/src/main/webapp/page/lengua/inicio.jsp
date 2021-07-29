 <%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Inicio Kumitsari</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />


  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="apple-touch-icon" sizes="57x57" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/assets/images/favicon/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="${pageContext.request.contextPath}/assets/images/favicon/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/assets/images/favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/assets/images/favicon/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/assets/images/favicon/favicon-16x16.png">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/assets/images/favicon/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
	<!-- font-awesome -->
	<link href="${pageContext.request.contextPath}/assets/css/notifIt.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/css/animate.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/desing-app-view.css">
	<!-- Modernizr JS -->
	<!-- <script src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script> -->
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<!-- jQuery -->  
	</head>
	<body class="page-header-color">
	<jsp:include page="/layouts/head-nav-view.jsp" />

	<div id="Subheader" style="display: none">
	    <div class="container">
	        <div class="column one">
	            <h1 class="title">Iniciar Sesión</h1>
	        </div>
	    </div>
	</div>

	<section id="lst-lengua" data-section="lengua" class="main-content-lst bg-fondo-app" style="padding: 6em 0 2em 0">
		<div class="container">
			<div class="row">
				<div class="col-md-12 section-heading text-center" style="margin-bottom: 10px;padding-bottom: 20px;">
					<h2 id="title-lengua-reforzar" class="title-minendu img-adorno-title">¿Qué lengua deseas reforzar?</h2>
				</div>
			</div>
			<div id="main-lst-lengua" class="row row-bottom-padded-sm" style="padding-left: 30px;padding-right: 30px;">

				<c:choose>
					<c:when test="${esEstudiante}">
						<c:forEach var="lenguaBean" items="${listaLenguaBean}">
							<c:if test="${lenguaBean.matriculaBean.codigo>0}">
								<div class="col-md-3 col-sm-4 col-xs-6 text-center">
									<%-- <a href="${pageContext.request.contextPath}/lengua/detalle?codigo=${lenguaBean.codigo}" class="fh5co-project-item image-popup "> --%>
									<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}" class="fh5co-project-item image-popup ">
										<c:choose>
											<c:when test="${not empty lenguaBean.imagenNombre}">
												<img src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="${lenguaBean.imagenNombre}" class="img-responsive">
											</c:when>
											<c:otherwise>
												<img src="${pageContext.request.contextPath}/assets/images/lengua/SIMBOLO-AIMARA.svg" alt="Image" class="img-responsive">
											</c:otherwise>
										</c:choose>
										<div class="fh5co-text">
											<h2 style="line-height: 31px;" class="text-center text-name-lengua" style="line-height: 31px;"><span>${lenguaBean.nombre}</span></h2>
										</div>
									</a>
								</div>
							</c:if>
							<c:if test="${lenguaBean.matriculaBean.codigo==0}">
								<div class="grises disable-icon">
									<div class="col-md-3 col-sm-6 col-xs-12 text-center">
										<a class="fh5co-project-item image-popup ">
											<c:choose>
												<c:when test="${not empty lenguaBean.imagenNombre}">
													<img style="max-width: 200px;min-width: 200px;min-height: 200px;max-height: 200px;" src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="${lenguaBean.imagenNombre}" class="img-responsive">
												</c:when>
												<c:otherwise>
													<img src="${pageContext.request.contextPath}/assets/images/lengua/SIMBOLO-AIMARA.svg" alt="Image" class="img-responsive">
												</c:otherwise>
											</c:choose>
											<div class="fh5co-text">
											<h2 style="line-height: 31px;" class="text-center text-name-lengua"><span>${lenguaBean.nombre}</span></h2>
											<!-- <span>Branding</span> -->
											</div>
										</a>
									</div>
								</div>
							</c:if>

					    </c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="lenguaBean" items="${listaLenguaBean}">

							<c:if test="${lenguaBean.situacion.codigoRegistro >0}">
								<div class="col-md-3 col-sm-4 col-xs-6 text-center">
									<%-- <a href="${pageContext.request.contextPath}/lengua/detalle?codigo=${lenguaBean.codigo}" class="fh5co-project-item image-popup "> --%>
									<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}" class="fh5co-project-item image-popup ">
										<c:choose>
											<c:when test="${not empty lenguaBean.imagenNombre}">
												<img style="max-width: 200px;min-width: 200px;min-height: 200px;max-height: 200px;" src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="${lenguaBean.imagenNombre}" class="img-responsive">
											</c:when>
											<c:otherwise>
												<img src="${pageContext.request.contextPath}/assets/images/lengua/SIMBOLO-AIMARA.svg" alt="Image" class="img-responsive">
											</c:otherwise>
										</c:choose>
										<div class="fh5co-text">
											<h2 style="line-height: 31px;" class="text-center text-name-lengua"><span>${lenguaBean.nombre}</span></h2>
										</div>
									</a>
								</div>
							</c:if>
							<c:if test="${lenguaBean.situacion.codigoRegistro == 0}">
								<div class="grises disable-icon">
									<div class="col-md-3 col-sm-6 col-xs-12 text-center">
										<a class="fh5co-project-item image-popup ">
											<c:choose>
												<c:when test="${not empty lenguaBean.imagenNombre}">
													<img style="max-width: 200px;min-width: 200px;min-height: 200px;max-height: 200px;" src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="${lenguaBean.imagenNombre}" class="img-responsive">
												</c:when>
												<c:otherwise>
													<img src="${pageContext.request.contextPath}/assets/images/lengua/SIMBOLO-AIMARA.svg" alt="Image" class="img-responsive">
												</c:otherwise>
											</c:choose>
											<div class="fh5co-text">
											<h2 style="line-height: 31px;" class="text-center text-name-lengua"><span>${lenguaBean.nombre}</span></h2>
											<!-- <span>Branding</span> -->
											</div>
										</a>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</section>

	<jsp:include page="/layouts/tienda-modal-view.jsp"/>
	<jsp:include page="/layouts/premio-modal-view.jsp"/>
	<jsp:include page="/layouts/detalle-tienda-modal-view.jsp"/>
	<jsp:include page="/layouts/ganar-premio-modal-view.jsp"/>


	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.min.js"></script>

	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/notifIt.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.touchSwipe.min.js"></script>
	<!--======= Customize =========-->
	<script src="${pageContext.request.contextPath}/assets/js/popover.min.js" type="text/javascript"></script>

	<!--======= Customize =========-->


	<script type="text/javascript" charset="utf-8">
		function linkSalir(){
			window.location = "${pageContext.request.contextPath}";
		}
		function show_detalle_moneda(){
			$(".tab-medalla").hide();
			$("#md-detalle-medalla").show();
		}
		function premio_ganar_modal() {
			$('#premio-ganar-modal').modal("show");
		}
		//premio_ganar_modal();
		// 28-09-2020 jinmi
		function customScapeHtml(str) {
		     return str.replace(/[&<>"']/g, function(m) {
				    
				    switch (m) {
				      case '&':
				        return '%;';
				      case '<':
				        return '%;';
				      case '>':
				        return '%;';
				      case '"':
				        return '%;';
				      default:
				        return '%;';
				    }
				  }).replace(/prompt/gi, "&#js;")
				    .replace(/href/gi, "&#ht;")
				    .replace(/javascript/gi, "&#js;")
					.replace(/inser into/gi, "&#js;")
				    .replace(/onerror/gi, "&#js;");
		}

		
		

	</script>

	<script src="${pageContext.request.contextPath}/assets/js/main-app.js"></script>

	</body>
</html>