<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Conocer Quechua</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Conocer Quechua" />

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
	<link rel="manifest" href="${pageContext.request.contextPath}/assets/images/favicon/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/assets/images/favicon/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">

<!-- 	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600,400italic,700' rel='stylesheet' type='text/css'>

	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,600i,700,800" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Coustard:400,900" rel="stylesheet"> -->

	<!-- font-awesome -->
	<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" media="all">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/magnific-popup.min.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

	<link href="${pageContext.request.contextPath}/assets/css/notifIt.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/desing-app-view.css">
	<!-- End demo purposes only -->

	<link href="${pageContext.request.contextPath}/assets/css/animate.min.css" rel="stylesheet">

	<link href="${pageContext.request.contextPath}/assets/css/gp_product_carousel_advance.min.css" rel="stylesheet" media="all">

	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body class="page-header-color">
	<jsp:include page="${pageContext.request.contextPath}/../layouts/head-nav-view.jsp"></jsp:include>

	<section id="fh5co-work" style="padding-top: 100px;">
		<div class="container">
			<div class="row">
					<div class="col-md-12 to-animate">
							<div class="row">
								<div class="col-md-5 mt-2">
									<img src="${pageContext.request.contextPath}/assets/images/mascota/mascota-04.png" alt="" class="img-responsive">
								</div>
								<div class="col-md-7 mt-2">
									<div class="row">
										<div class="col-md-12">
											<div class="txt-mensaje dialog-msg" style="background-image: url('assets/images/dialogo-fondo.png')">¿Quieres un recorrido para conocer más de Plataforma?</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 mt-2">
											<button class="btn btn-default btn-border-radius">Si, deseo conocer.</button>
											<!-- <button class="btn btn-default btn-border-radius"></button> -->
											<a href="quechua" class="btn btn-default btn-border-radius">No, gracias</a>

										</div>
									</div>
								</div>
							</div>

					</div>
				</div>

			</div>
	</section>




	<jsp:include page="${pageContext.request.contextPath}/../layouts/tienda-modal-view.jsp"></jsp:include>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/premio-modal-view.jsp"></jsp:include>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/detalle-tienda-modal-view.jsp"></jsp:include>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.stellar.min.js"></script>
	<!-- Counter -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.magnific-popup.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/magnific-popup-options.js"></script>
	<!-- Google Map -->
<!-- 	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
	<script src="${pageContext.request.contextPath}/assets/js/google_map.js"></script> -->

	<!-- For demo purposes only styleswitcher ( You may delete this anytime ) -->
	<!-- <script src="${pageContext.request.contextPath}/assets/js/jquery.style.switcher.js"></script> -->

	<!--======= Touch Swipe =========-->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.touchSwipe.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/notifIt.min.js"></script>
	<!--======= Customize =========-->
	<script src="${pageContext.request.contextPath}/assets/js/responsive_bootstrap_carousel.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/popover.min.js" type="text/javascript"></script>

	<script>
		function linkSalir(){
			window.location = "${pageContext.request.contextPath}";
		}
		function show_detalle_moneda(){
			$(".tab-medalla").hide();
			$("#md-detalle-medalla").show();
		}
		// new WOW().init();
	</script>

	<script src="${pageContext.request.contextPath}/assets/js/main-app.js"></script>

	</body>
</html>
