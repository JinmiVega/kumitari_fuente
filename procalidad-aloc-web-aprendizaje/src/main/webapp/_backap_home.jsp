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
	<title>Kumitsari</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />


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
	<link rel="apple-touch-icon" sizes="57x57" href="assets/images/favicon/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="assets/images/favicon/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="assets/images/favicon/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="assets/images/favicon/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="assets/images/favicon/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="assets/images/favicon/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="assets/images/favicon/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="assets/images/favicon/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="assets/images/favicon/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="assets/images/favicon/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="assets/images/favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/images/favicon/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon/favicon-16x16.png">
<!-- 	<link rel="manifest" href="assets/images/favicon/manifest.json"> -->
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="assets/images/favicon/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">

	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,600i,700,800" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Coustard:400,900" rel="stylesheet">
	<!-- Animate.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/icomoon.css">
	<!-- Simple Line Icons -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/simple-line-icons.css">

	<!-- font-awesome -->
	<link href="${pageContext.request.contextPath}/assets/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet" media="all">

	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">

	<!-- Styleswitcher ( This style is for demo purposes only, you may delete this anytime. ) -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-minedu.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/desing-index-view.css">
	<!-- End demo purposes only -->

	<link href="${pageContext.request.contextPath}/assets/css/animate.min.css" rel="stylesheet">

	<!--======= Responsive Bootstrap Carousel StyleSheets =========-->
	<link href="${pageContext.request.contextPath}/assets/css/simple_carousel.css" rel="stylesheet" media="all">

	<!-- End demo purposes only -->


	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
	<header role="banner" id="fh5co-header">
			<div class="container">
				<!-- <div class="row"> -->
			    <nav class="navbar navbar-default">
		        <div class="navbar-header" id="logo-kumutsari">
		        	<!-- Mobile Toggle Menu Button -->
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
		         	<a class="navbar-brand" href="index.html"><i class="icon-minedu-kumitsari"></i></a>
		        </div>
		        <div id="navbar" class="navbar-collapse collapse">
		          <ul class="nav navbar-nav navbar-right">
		            <!-- <li class="active"><a href="#" data-nav-section="inicio"><span>Inicio</span></a></li> -->
			        <!-- <li id="menu-select-lengua" class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><small>Idioma: <strong> Castellano</strong> </small> <b class="caret"></b></a>
			          <ul class="dropdown-menu">
			            <li><a href="#"><img src="${pageContext.request.contextPath}/assets/images/icono-lengua/lengua-01.jpg" alt="" class="img-circle img-responsive"> Quechua</a></li>
			            <li><a href="#"><img src="${pageContext.request.contextPath}/assets/images/icono-lengua/lengua-02.jpg" alt="" class="img-circle img-responsive"> Aymara</a></li>
			            <li><a href="#"><img src="${pageContext.request.contextPath}/assets/images/icono-lengua/lengua-03.jpg" alt="" class="img-circle img-responsive"> Ashaninka</a></li>
			            <li class="divider"></li>
			            <li><a href="#"><img src="${pageContext.request.contextPath}/assets/images/icono-lengua/lengua-04.jpg" alt="" class="img-circle img-responsive"> Castellano</a></li>
			          </ul>
			        </li> -->
		            <!-- <li><a href="#" data-nav-section="work"><span>Lenguas</span></a></li> -->
		            <li><a href="#" id="btn-iniciar-session" onclick="OpenLogin()"><span>Iniciar Sesión</span></a></li>
		            <!-- <li><a href="#" data-nav-section="testimonials"><span>Testimonials</span></a></li> -->
<!-- 		            <li><a href="#" data-nav-section="services"><span>Services</span></a></li>
		            <li><a href="#" data-nav-section="about"><span>About</span></a></li>
		            <li><a href="#" data-nav-section="contact"><span>Contact</span></a></li> -->
		          </ul>
		        </div>
			    </nav>
			  <!-- </div> -->
			<!-- <span id="barraIdentidad"></span> -->
		  </div>
	</header>

<section id="inicio" data-section="inicio">
	<span id="barraIdentidad"></span>
		<div id="simple_carousel" class="carousel simple_scale animate_text simple_carousel_wrapper" data-ride="carousel" data-interval="6000" data-pause="hover">
			<!--========= Wrapper for slides =========-->
			<div class="carousel-inner" role="listbox">
				<c:forEach var="sliderDetalleBean" items="${listaSliderDetalleBean}">
             	    <c:choose>
 						<c:when test="${sliderDetalleBean.item==1}">
 							<div class="item active">
								<c:if test="${not empty sliderDetalleBean.nombreSlider}">
									<img src="${pageContext.request.contextPath}/slider/${sliderDetalleBean.nombreSlider}" alt="${sliderDetalleBean.nombreSlider}" />
								</c:if>
								<c:if test="${empty sliderDetalleBean.nombreSlider}">
									<img src="${pageContext.request.contextPath}/assets/images/slider-01.jpg" alt="slider 01" />
								</c:if>
								<div class="carousel-caption simple_carousel_caption" data-animation="animated fadeInLeft">
								</div>
							</div>
 						</c:when>

 			            <c:otherwise>
 			            	<div class="item">
 			            	    <c:if test="${not empty sliderDetalleBean.nombreSlider}">
									<img src="${pageContext.request.contextPath}/slider/${sliderDetalleBean.nombreSlider}" alt="${sliderDetalleBean.nombreSlider}" />
								</c:if>
								<c:if test="${empty sliderDetalleBean.nombreSlider}">
									<img src="${pageContext.request.contextPath}/assets/images/slider-02.jpg" alt="slider 02">
								</c:if>
								<div class="carousel-caption simple_carousel_caption" data-animation="animated fadeInLeft">
<!-- 									<h1 data-animation="animated fadeInUp">Aprende desde casa</h1> -->
<!-- 									<p data-animation="animated fadeInUp">No solo puedes aprender en línea, ahora también puedes descargar y seguir aprendiendo</p> -->
									<!-- <a href="#" class="simple_carousel_transparent_button" data-animation="animated fadeInUp">DESCARGAR</a> -->
								</div>
							</div>
 			            </c:otherwise>
 			    	</c:choose>

                 </c:forEach>

			</div>

			<!--======= Navigation Buttons =========-->

			<!--======= Left Button =========-->
			<a class="left carousel-control simple_carousel_control_left" href="#simple_carousel" role="button" data-slide="prev">
				<span class="fa fa-angle-left simple_carousel_control_icons" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>

			<!--======= Right Button =========-->
			<a class="right carousel-control simple_carousel_control_right" href="#simple_carousel" role="button" data-slide="next">
				<span class="fa fa-angle-right simple_carousel_control_icons" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>

		</div>

</section>




	<section id="quienes-somos" data-section="quienes-somos" style="background-image: url(${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/fondo.jpg);">
		<div class="container">
			<div class="row">
				<div id="content-persona-peru" class="col-md-6 col-xs-12">
					<div class="row">
						<div class="col-md-12">
							<div class="col-md-6 col-xs-6">
							 <div class="efecto-img-hover wow zoomIn" data-wow-delay="2.2s">
								<img class="left-img-one" src="${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/caritas2.png" alt="" class="">
							 </div>
							</div>
							<div class="col-md-6 col-xs-6">
							 	<div class="efecto-img-hover wow zoomIn" data-wow-delay="1.8s">
									<img class="right-img-one" src="${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/caritas3.png" alt="">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="col-md-4 col-xs-4">
								<div class="efecto-img-hover wow zoomIn" data-wow-delay="1.4s">
									<img class="left-img" src="${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/caritas1.png" alt="">
								</div>
							</div>
							<div class="col-md-4 col-xs-4">
								<div class="efecto-img-hover wow zoomIn" data-wow-delay="1s">
									<img class="center-img" src="${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/caritas4.png" alt="">
								</div>
							</div>
							<div class="col-md-4 col-xs-4">
								<div class="efecto-img-hover wow zoomIn" data-wow-delay=".6s" data-wow-delay="300ms" data-wow-duration="2s">
									<img class="right-img img-responsive" src="${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/caritas5.png" alt="">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							 <div id="sombraId" class="span3 wow zoomInDown" data-wow-delay="3s" data-wow-delay="300ms">
								<img src="${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/sombra.png" alt="" class="img-responsive">
							</div>
						</div>
					</div>
				</div>
				<div id="quienes-somos-texto" class="col-md-6 col-xs-12">
					<div class="row">
						<div class="col-md-12 section-heading text-center">
							<h2 class="to-animate title-minendu" style="font-size: 30px;"><b>¿Qué significa kumitsari?</b></h2>
							<div class="row">
								<div class="col-md-10 col-md-offset-1 subtext to-animate">
									<p class="text-secction-minendu" style="text-align: justify;">
										<!-- Kumitsari es un programa informático que te permite reforzar tus habilidades comunicativas en lengua originaria y castellano.Encontrarás lecciones desde el nivel básico hasta el avanzado y aprenderás jugando. En cada unidad podrás interactuar con tu mascota virtual, quien te ayudará a superar cada ejercicio.
										<br>
										<br>
										Podrás juntar monedas por cada actividad resuelta correctamente y con ellas comprar diversos premios en la tienda virtual. -->
										Kumitsari es una palabra en lengua kukama kukamiria y significa ‘conversando’. Se eligió este nombre porque representa la necesidad de los pueblos originarios por mantener y desarrollar sus lenguas originarias.
										<br><br>
										Un dato adicional es que el kukama kukamiria es una lengua originaria, como muchas de las 47 que se hablan en Perú, que se encuentran en proceso de revitalización. Sus hablantes están haciendo todos los esfuerzos por transmitirla a sus nuevas generaciones. Este espíritu de transmisión queremos que se refleje a través de este programa.
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</section>


	<section id="secction-descarga"  data-section="secction-descarga" style="background-image: url(${pageContext.request.contextPath}/assets/images/seccion-descarga/fondo.jpg);">
		<div class="container" style="margin-bottom: -25px;">
			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-12 section-heading text-center">
							<!-- <br>
							<br> -->
							<!-- <h2 class="to-animate title-minendu"><b> Por ello,<br>¡explora, diviértete <br>y aprende!</b></h2> -->
							<h4 class="to-animate title-minendu" style="text-align: justify;font-size: 16px;"><b> <span style="font-size: 30px;">¿Qué es Kumitsari?</span>
																	 <br><br>
																	 Kumitsari es un programa informático que te permite reforzar tus habilidades comunicativas en lengua originaria y castellano. Encontrarás lecciones desde el nivel básico hasta el avanzado y aprenderás jugando. En cada unidad podrás interactuar con tu mascota virtual, quien te ayudará a superar cada ejercicio. Podrás juntar monedas por cada actividad resuelta correctamente y con ellas comprar diversos premios en la tienda virtual.
																	 <br><br>
																	 Por ello, ¡explora, diviértete y aprende!
																</b>
							</h4>
							<br>
							<br>
							<div class="row">
								<div class="col-md-8 col-md-offset-2 subtext to-animate">
									<!-- <button id="btn-descarga" class="btn btn-default">Descargar</button> -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div id="box-descarga-animate">
						<div class="efecto-img-hover wow fadeInDownBig" data-wow-delay=".9s" data-wow-delay="200ms" data-wow-duration="1.6s">
							<img src="${pageContext.request.contextPath}/assets/images/seccion-descarga/taza.png" alt="" class="img-responsive item-img-d-1">
						</div>
						<div class="efecto-img-hover wow fadeInUpBig" data-wow-delay=".6s" data-wow-delay="200ms" data-wow-duration="1.2s">
							<img src="${pageContext.request.contextPath}/assets/images/seccion-descarga/laptop.png" alt="" class="img-responsive item-img-d-2">
						</div>

						<div class="efecto-img-hover wow fadeInDownBig" data-wow-delay="1.5s" data-wow-delay="200ms" data-wow-duration="1.9s">
							<img src="${pageContext.request.contextPath}/assets/images/seccion-descarga/periodico.png" alt="" class="img-responsive item-img-d-3">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

<section id="secction-credito"  data-section="secction-credito" style="background-image: url(${pageContext.request.contextPath}/assets/images/seccion-quienes-somos/fondo.jpg);">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="title-minendu text-center"><b>¿Quiénes participaron en la elaboración de Kumitsari?</b></h2>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Lenguas</th>
							<th>Elaboradores del contenido</th>
							<th>Revisores de redacción</th>
							<th>Lingüistas Asesoras</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="name-lengu">aimara</td>
							<td>
								José Marcial Mamani Condori <br>
								Gloria Huancapaza Alarcón
							</td>
							<td>
								Nolberto Juli Laqui <br>
								Hernán Lauracio Ticona <br>
								Leoncio Sejje Mamani

							</td>
							<td>Norma Meneses Tutaya <br>
								Erika Amalec Shicshi Romero
							</td>
						</tr>

						<tr>
							<td class="name-lengu">ashaninka</td>
							<td>
								Janet Gonzales Puyenti <br>
								Elmer Quinchori Castro
							</td>
							<td>
								Javier Jumanga Shopa <br>
								Elfren Ramos Espíritu
							</td>
							<td>Licett Ramos Ríos <br>
								Karin Estefany Flores Espinoza
							</td>
						</tr>

						<tr>
							<td class="name-lengu">awajún</td>
							<td>
							Javier Chuintam Anjis <br>
							Matut Micaela Impi Ismiño <br>
							Pedro Shibucat Taish

							</td>
							<td>
								Segundo Bakuants Cuñachi <br>
								José Luis Shimbucat Taish <br>
								Claudio Wampuch Bitap
							</td>
							<td>Yris Barraza De la Cruz <br>
								Karin Estefany Flores Espinoza
							</td>
						</tr>
						<tr>
							<td class="name-lengu">quechua chanka</td>
							<td>
							Maximo Contreras Cana <br>
							Yuly Tacas Salcedo

							</td>
							<td>
								Moisés Cárdenas Guzmán <br>
								Oscar Chávez Gonzales
							</td>
							<td>Norma Meneses Tutaya <br>
								Erika Amalec Shicshi Romero
							</td>
						</tr>
						<tr>
							<td class="name-lengu">quechua collao</td>
							<td>
							Emperatriz Torres Cabrera <br>
							Nonato Rufino Chuquimamani Valer <br>
							Luis Víctor Araoz Chacón <br>
							León Huancachoque Quispe

							</td>
							<td>
								Valentin Ccasa Champi <br>
								Melquiades Quintasi Mamani <br>
								Oscar Chávez Gonzales
							</td>
							<td>Norma Meneses Tutaya <br>
								Erika Amalec Shicshi Romero
							</td>
						</tr>
						<tr>
							<td class="name-lengu">shawi</td>
							<td>
							Sara Flor Chanchari Pascual <br>
							Nestor Lancha Torres

							</td>
							<td>Manuel Pizango Huiñap</td>
							<td>Yris Barraza De la Cruz <br>
								Karin Estefany Flores Espinoza
							</td>
						</tr>

						<tr>
							<td class="name-lengu">shipibo-konibo</td>
							<td>
							Luis Gonzales Sánchez <br>
							Reydelinda Saldaña Ochavana

							</td>
							<td>
								Richard Soria Gonzales <br>
								Lidia Gonzales Sánchez <br>
								Josué Rodriguez Gonzales

							</td>
							<td>Carolina Rodríguez Alzza  <br>
								Karin Estefany Flores Espinoza
							</td>
						</tr>
						<tr>
							<td class="name-lengu">castellano</td>
							<td>
								Roberto García Zevallos
							</td>
							<td>Roberto García Zevallos</td>
							<td>Nila Vigil Oliveros <br>
								Mabel Mori Clement
							</td>
						</tr>
						<tr>
							<td colspan="4" class="text-center name-coord">
								<b>Coordinación General:</b> Karina Natalia Sullón Acosta
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</section>

	<footer id="footer" role="contentinfo" style="padding:20px 0;">
		<!-- <a href="#" class="gotop js-gotop"><i class="icon-arrow-up2"></i></a> -->
		<div class="container" style="width: auto;">
			<div class="row">
				<div class="col-md-4 text-center">
					<!-- <div class="text-footer">
						<div class="main-autores">
							<p><b>Tomas Agusto Sanche</b> <small>Cordinador</small></p>
							<p><b>Mónica Lopez Tamara</b> <small>Jefe proyecto</small></p>
							<p><b>Luis Medina Pacheco</b> <small>Representante</small></p>
						</div>
						<p><span>Contactos, dudas y consultas :</span><br>
						(51) 456 8239 <br>
						www.minendu.edu.pe <br>
						minendu@gmail.pe
						</p>
					</div> -->

						<br>
						<img src="${pageContext.request.contextPath}/assets/images/logos-institucional/procalidad.png" alt="" height="90">
				</div>
				<div class="col-md-4 line-h-r">
					<div class="row">
						<div class="text-footer-center">
							<div class="col-md-12">
								<div class="text-center" id="lst-red-social">
									<p>Síguenos en nuestras redes sociales :</p>
									<ul class="social social-circle">
										<li><a href="#"><i class="icon-twitter"></i></a></li>
										<li><a href="#"><i class="icon-facebook-f"></i></a></li>
										<li><a href="#"><i class="icon-youtube"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="col-md-12 text-center">
								<br>
								<p>&copy; Kumitsari. Todos los derechos reservados. <br>Creado por <a href="#" target="_blank">galaxybis</a></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="text-center text-footer-rigth">
						<br>
						<br>
						<img src="${pageContext.request.contextPath}/assets/images/logos-institucional/logo_ministerio_educacion.png" alt="" height="50">
					</div>
				</div>
			</div>
		</div>
	</footer>


<div id="panel-login">
<f:form id="formLoginEstudiante" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/inicio/acceso" method="POST">
		<div class="login-main">
	<!-- 		<span id="img-login-left"></span>
			<span id="img-login-rigth"></span> -->
			<div id="box-input-form-login" class="col-md-12">
				<h4>Iniciar Sesión</h4>

				<div class="input-group">
				  <label for="txtUsernameLogin" class="sr-only">Usuario</label>
				  <span class="input-group-addon" id="basic-addon1"><i class="icon-user"></i></span>
				  <f:input id="txtUsernameLogin" class="form-control" placeholder="Usuario" type="text" path="nombreUsuario"/>
				</div>

				<div class="input-group">
				  <label for="txtPasswordLogin" class="sr-only">Contraseña</label>
				  <span class="input-group-addon" id="basic-addon1"><i class="icon-lock"></i></span>
				  <f:input id="txtPasswordLogin" class="form-control" placeholder="Contraseña" type="password" path="contrasena"/>
				</div>


				<div class="form-group" style="margin-top: 20px;margin-bottom: 0;text-align: center;">
					<div style="display: block;width: 100%;padding: 0 15px;">
						<button type="button" id="btn-iniciar-sesion" onclick="validarSesion()" class="btn btn-primary btn-lg">Ingresar</button>
						<!-- <button type="submit" id="btn-iniciar-sesion" class="btn btn-primary btn-lg">Ingresar</button> -->
						<%-- <a id="btn-iniciar-sesion" class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/lengua/">Ingresar</a> --%>
						<!-- <input id="btn-iniciar-sesion" class="btn btn-primary btn-lg" value="Ingresar" type="submit"> -->
						<input  class="btn btn-default btn-lg" value="Salir" onclick="CloseBottom();" type="button">

						<div id="boxMsgValid"></div>
					</div>

				</div>
<!-- 				<div class="form-group">
					<a href="#" id="olvide-passw" >Olvide mi contraseña</a><br>
					Nuevo aquí <a href="#" id="olvide-passw" style="text-decoration: underline;color: #45bdf0;"> Crear una cuenta</a>
				</div> -->
			</div>
		</div>
		<div class="main-ajax">
			<div class="preloader">
			</div>
			<i class="icon-minedu-kumitsari"></i>
		</div>
	</f:form>
</div>
<button id="backToTop" class="mdl-button mdl-button--fab back-to-top"><i class="icon-chevron-down"></i></button>

<div id="idDivIndexModal"></div>
<input type="hidden" id="valNomImgModal" value="${((not empty modalBean) and (not empty modalBean.imagenNombre)) ? modalBean.imagenNombre : ''}">

<jsp:include page="${pageContext.request.contextPath}/../layouts/index-modal-view.jsp" />



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
	<!-- <script src="${pageContext.request.contextPath}/assets/js/jquery.countTo.js"></script> -->
	<!-- Magnific Popup -->
	<!-- <script src="assets/js/jquery.magnific-popup.min.js"></script> -->
	<!-- <script src="assets/js/magnific-popup-options.js"></script> -->
	<!-- Google Map -->
<!-- 	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script> -->
	<!-- <script src="assets/js/google_map.js"></script> -->

	<!-- For demo purposes only styleswitcher ( You may delete this anytime ) -->
	<!-- <script src="assets/js/jquery.style.switcher.js"></script> -->

	<!--======= Touch Swipe =========-->
	<script src="assets/js/jquery.touchSwipe.min.js"></script>

	<!--======= Customize =========-->
	<script src="${pageContext.request.contextPath}/assets/js/responsive_bootstrap_carousel.js"></script>
	<!-- <script src="https:////cdnjs.cloudflare.com/ajax/libs/wow/0.1.12/wow.min.js" type="text/javascript" charset="utf-8" ></script> -->
	<script src="${pageContext.request.contextPath}/assets/js/wow-0.1.12.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
	<script type="text/javascript" charset="utf-8">
		new WOW().init();

		var valNomImgModal = $('#valNomImgModal').val();
		if(valNomImgModal){
			$('#modal-index').modal("show");
		}



		//showModal();

/* 		function showModal(){
			var context  = '${pageContext.request.contextPath}';

			$.ajax({
				type: "GET",
			    url: context+"/inicio/mostrarModal",
		        success: function(data)
		        {
		        	$('#idDivIndexModal').empty();
		        	$('#idDivIndexModal').html(data);
		        },
			    error: function(xhr,status,er) {
				    console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
					   console.log(er);
				 //    Error_500(er);
				    }
				    if(xhr.status==901) {
					   console.log(er);
			    //	   spire_session_901(er);
	 		    	}
			   },
			   complete: function(){
				   $('#modal-index').modal("show");
			   }
		    });

		} */

		// $(function(){
		// 	$('#colour-variations ul').styleSwitcher({
		// 		defaultThemeId: 'theme-switch',
		// 		hasPreview: false,
		// 		cookie: {
		//           	expires: 30,
		//           	isManagingLoad: true
		//       	}
		// 	});
		// 	$('.option-toggle').click(function() {
		// 		$('#colour-variations').toggleClass('sleep');
		// 	});
		// });

		$("#txtUsernameLogin").keypress(function(e) {
	       if(e.which == 13) {
	    	   validarSesion();
	       }
	    });

		$("#txtPasswordLogin").keypress(function(e) {
	       if(e.which == 13) {
	    	   validarSesion();
	       }
	    });

		function validarSesion(){
			showLoad();
			var username = $('#txtUsernameLogin').val();
			var password = $('#txtPasswordLogin').val();
			var context  = '${pageContext.request.contextPath}';

			var mensaje = '';
			var validado = false;
			var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

			$.ajax({
				 async: true,
				type: "GET",
				data: "username="+username+"&password="+password,
			    url: context+"/inicio/autenticar",
		        success: function(data)
		        {
		   	    	if(data!=null){

		   	    		switch(data){
		   	    			case '1': mensaje = 'Ingrese su usuario';
		   	    					  $('#txtUsernameLogin').focus();
 	    					  	      break;
		   	    			case '2': mensaje = 'Ingrese su contraseña';
		   	    					  $('#txtPasswordLogin').focus();
 	    					  		  break;
		   	    			case '3': mensaje = 'Su usuario se encuentra inactivo';
 	    					  		  break;
		   	    			case '4': mensaje = 'No ha cambiado su contraseña';
 	    					  		  break;
		   	    			case '5': mensaje = 'Su usuario no cuenta con un perfil asignado';
 	    					  		  break;
		   	    			case '6': validado = true;
 	    					  		  break;
		   	    			case '7': mensaje = 'Sólo los estudiantes pueden ingresar a la plataforma';
 	    					  		  break;
		   	    			case '8': mensaje = 'No se encontró usuario con los datos ingresados';
 	    					  		  break;
		   	    		}

		   	    	}else{
		   	    		mensaje = '';
		   				validado = false;
		   	    	}

		        },
			    error: function(xhr,status,er) {
				    console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
					   console.log(er);
				 //    Error_500(er);
				    }
				    if(xhr.status==901) {
					   console.log(er);
			    //	   spire_session_901(er);
	 		    	}
			   },
			   complete: function(){
			   	hideLoad();
					if(validado){
						/** VALIDADO - EXEC POST **/
						$('#boxMsgValid').empty();
						$('#formLoginEstudiante').submit();
					}else{
						/** NO VALIDADO USUARIO **/
						$('#boxMsgValid').empty();
						$("#boxMsgValid").html(infoHtml);
		                $("#boxMsg").fadeIn("slow");
		                $(".msgValidar").html(mensaje);
					}
			   }
		    });

		}
       	let cont=-1;
        $('#backToTop').click(function(event){
        	cont++;
        	var position = ["quienes-somos","secction-descarga","secction-credito","inicio"];
        	if (position[cont]=="inicio" || position[cont]== undefined) {
        		let tempNum = -1;
				$('html, body').animate({
					scrollTop: $('html').offset().top
				}, 500);
				$('#backToTop').css('transform','rotate(0deg)');
				cont=tempNum;
        	}
        	if (position[cont]=="credito" || position[cont]== undefined) {
        		let tempNum = -2;
				$('html, body').animate({
					scrollTop: $('html').offset().top
				}, 500);
				$('#backToTop').css('transform','rotate(0deg)');
				cont=tempNum;
        	}
        	else{
        		if (position[cont]=="secction-descarga") {
        			$('#backToTop').css('transform','rotate(0)');
        		}
		    	$('html, body').animate({
		        	scrollTop: $('[data-section="' + position[cont] + '"]').offset().top
		    	}, 500);
        	}
            console.log(position[cont]);
		    event.preventDefault();
		    return false;
        });
	</script>

	<!-- Main JS (Do not remove) -->


	</body>
</html>