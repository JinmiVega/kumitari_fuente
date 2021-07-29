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

	<!-- Animate.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.min.css">
	<!-- font-awesome -->
	<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" media="all">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/desing-index-view.css">

	</head>
	<body onload="Captcha();validarSesionLoad(); ">
	<header role="banner" id="fh5co-header">
			<div class="container">
				<!-- <div class="row"> -->
			    <nav class="navbar navbar-default">
			        <div class="navbar-header" id="logo-kumutsari">
			         	<a class="navbar-brand" href=""><i class="icon-minedu-kumitsari"></i></a>
			        </div>
			        <div id="navbar">
			          <ul class="nav navbar-nav navbar-right">
			            <li><a href="" id="btn-iniciar-session" class="btn-movil" onclick="OpenLogin()"><span>Iniciar Sesión</span></a></li>
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
									<img src="${pageContext.request.contextPath}/assets/images/slider/slider-01.jpg" alt="slider 01" />
								</c:if>
								<div class="carousel-caption simple_carousel_caption" data-animation="animated fadeInLeft">
								</div>
							</div>
 						</c:when>

 			            <c:otherwise>
 			            	<div class="item">
 			            	    <c:if test="${not empty sliderDetalleBean.nombreSlider}">
									<img src="${pageContext.request.contextPath}/slider/${sliderDetalleBean.nombreSlider}"
									     alt="${sliderDetalleBean.nombreSlider}" />
								</c:if>
								<c:if test="${empty sliderDetalleBean.nombreSlider}">
									<img src="${pageContext.request.contextPath}/assets/images/slider/slider-02.jpg" alt="slider 02">
								</c:if>
								<div class="carousel-caption simple_carousel_caption" data-animation="animated fadeInLeft">
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
								<div class="efecto-img-hover wow zoomIn" data-wow-delay=".3s" data-wow-delay="300ms" data-wow-duration="1s">
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
						<div class="col-md-12">
							<h2 class="to-animate text-center title-minendu">¿Qué significa kumitsari?</h2>
							<div class="row">
								<div class="col-md-10 col-md-offset-1 subtext to-animate">
									<p class="text-secction-minendu text-justify">
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
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-xs-12">
					<div class="row">
						<div class="col-md-12 text-center">
							<h2 class="to-animate title-minendu text-center">¿Qué es Kumitsari?</h2>
							<p class="text-justify text-secction-minendu">
								 Kumitsari es un programa informático que te permite reforzar tus habilidades comunicativas en lengua originaria y castellano. Encontrarás lecciones desde el nivel básico hasta el avanzado y aprenderás jugando. En cada unidad podrás interactuar con tu mascota virtual, quien te ayudará a superar cada ejercicio. Podrás juntar monedas por cada actividad resuelta correctamente y con ellas comprar diversos premios en la tienda virtual.
								 <br><br>
								 Por ello, ¡explora, diviértete y aprende!
							</p>
							<div class="row">
								<div class="col-md-8 col-md-offset-2 subtext to-animate">
									<!-- <button id="btn-descarga" class="btn btn-default">Descargar</button> -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-xs-12">
					<div id="box-descarga-animate">
						<ul>
							<li>
								<div class="efecto-img-hover wow fadeInDownBig" data-wow-delay=".9s" data-wow-delay="200ms" data-wow-duration="1.6s">
									<img src="${pageContext.request.contextPath}/assets/images/seccion-descarga/taza-medio.png"
										srcset="${pageContext.request.contextPath}/assets/images/seccion-descarga/taza-large.png  1600w,
										 		${pageContext.request.contextPath}/assets/images/seccion-descarga/taza-medio.png  1200w,
												${pageContext.request.contextPath}/assets/images/seccion-descarga/taza-smallx2.png  960w,
												${pageContext.request.contextPath}/assets/images/seccion-descarga/taza-smallx1.png   480w"
									    class="img-responsive item-img-d-1">
								</div>
							</li>
							<li>
								<div class="efecto-img-hover wow fadeInUpBig" data-wow-delay=".6s" data-wow-delay="200ms" data-wow-duration="1.2s">
									<img src="${pageContext.request.contextPath}/assets/images/seccion-descarga/laptop-medio.png"
										srcset="${pageContext.request.contextPath}/assets/images/seccion-descarga/laptop-large.png  1600w,
										 		${pageContext.request.contextPath}/assets/images/seccion-descarga/laptop-medio.png  1200w,
												${pageContext.request.contextPath}/assets/images/seccion-descarga/laptop-smallx2.png  960w,
												${pageContext.request.contextPath}/assets/images/seccion-descarga/laptop-smallx1.png   480w"
										class="img-responsive item-img-d-2">
								</div>
							</li>
							<li>
								<div class="efecto-img-hover wow fadeInDownBig" data-wow-delay="1.5s" data-wow-delay="200ms" data-wow-duration="1.9s">
									<img src="${pageContext.request.contextPath}/assets/images/seccion-descarga/periodico-medio.png"
										srcset="${pageContext.request.contextPath}/assets/images/seccion-descarga/periodico-large.png  1600w,
										 		${pageContext.request.contextPath}/assets/images/seccion-descarga/periodico-medio.png  1200w,
												${pageContext.request.contextPath}/assets/images/seccion-descarga/periodico-smallx2.png  960w,
												${pageContext.request.contextPath}/assets/images/seccion-descarga/periodico-smallx1.png   480w"
									 	class="img-responsive item-img-d-3">
								</div>
							</li>
						</ul>



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
				<div class="table-responsive">
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
	</div>
</section>

	<footer id="footer" role="contentinfo" style="padding:20px 0;">
		<!-- <a href="#" class="gotop js-gotop"><i class="icon-arrow-up2"></i></a> -->
		<div class="container" style="width: auto;">
			<div class="row">
				<div class="col-md-4 text-center">
						<br>
						<img data-src="${pageContext.request.contextPath}/assets/images/logos-institucional/procalidad.png" src="data:image/gif;base64,R0lGODdhAQABAPAAAMPDwwAAACwAAAAAAQABAAACAkQBADs=" height="90">
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
						<img data-src="${pageContext.request.contextPath}/assets/images/logos-institucional/logo_ministerio_educacion-x1.png" src="data:image/gif;base64,R0lGODdhAQABAPAAAMPDwwAAACwAAAAAAQABAAACAkQBADs="  height="50">
					</div>
				</div>
			</div>
		</div>
	</footer>

<div id="fondo-transparente">
	<div id="panel-login" style="top: 13%;">
		<f:form id="formLoginEstudiante" class="form-horizontal" method="POST" role="form" action="${pageContext.request.contextPath}/inicio/acceso">
		<div class="login-main">
	<!-- 		<span id="img-login-left"></span>
			<span id="img-login-rigth"></span> -->
			<div id="box-input-form-login" class="col-md-12">
				<h4>Iniciar Sesión</h4>

				<div class="input-group">
				  <label for="txtUsernameLogin" class="sr-only">Usuario</label>
				  <span class="input-group-addon" id="basic-addon1"><i class="icon-user"></i></span>
				  <input id="txtUsernameLogin" class="form-control" placeholder="Usuario" type="text" maxlength="50" autocomplete="off"/>
				  <f:input type="hidden" id="textEnUsuario" path="nombreUsuario" autocomplete="off"/>
				</div>

				<div class="input-group">
				  <label for="txtPasswordLogin" class="sr-only">Contraseña</label>
				  <span class="input-group-addon" id="basic-addon1"><i class="icon-lock"></i></span>
				  <input onkeyup="quitarEspacios()" id="txtPasswordLogin" class="form-control" placeholder="Contraseña" type="password" maxlength="150" autocomplete="off"/>
				  <f:input type="hidden" id="textEnPassword" path="contrasena" autocomplete="off"/>
				</div>
				
				<table>
			        <tr>
			            <td class="text-center">
			            	<table style="width:100%">
                               <tr>
                               <td style="padding-top: 5px;">
	                               <canvas id="captcha" style="width:100%"></canvas>
	                            </td>
	                            <td>
	                               
	                             	<input type="button" id="refresh" value="&#x21bb" onclick="Captcha();" class="btn btn-primary btn-lg" style="margin-top:10px;margin-bottom:10px;border-radius: 5px;"/>
	                             </td>
                               
			                   </tr>
                                                    	
                              </table>
			                
			                <input type="text" id="txtInput"  maxlength="7" class="form-control" style="margin-top:20px" placeholder="Ingrese el texto de la imagen"/>
			                <!-- input type="button" id="refresh" value="Actualizar" onclick="Captcha();" class="btn btn-primary btn-lg" style="margin-top:20px"/-->
			            </td>
			        </tr>
			    </table>

				<div class="form-group" style="margin-top: 20px;margin-bottom: 0; text-align: center">
					<div style="display: block;width: 100%;padding: 0 15px;margin-bottom: 5px;">
						<button type="button" id="btn-iniciar-sesion" onclick="validarSesion()" class="btn btn-primary btn-lg">Ingresar</button>
						<input id="btn-close-login" class="btn btn-default btn-lg btn-movil" value="Salir" onclick="CloseBottom();" type="button">


						<div id="boxMsgValid"></div>
					</div>
					<u id="optionOlv" style="font-size: 14px;cursor: pointer;" onclick="mostrarMensaje()">Olvidé mi contraseña? </u> 

                    <div id="boxMsgxOlvidar" style="margin-top: 5px;font-size: 13px;"></div>
					
					
					
					
					
					
					

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
</div>

<button id="backToTop" class="mdl-button mdl-button--fab back-to-top"><i class="icon-chevron-down"></i></button>

<div id="idDivIndexModal"></div>
<input type="hidden" id="valNomImgModal" value="${((not empty modalBean) and (not empty modalBean.imagenNombre)) ? modalBean.imagenNombre : ''}">

<jsp:include page="${pageContext.request.contextPath}/../layouts/index-modal-view.jsp" />

	<!-- Md5 JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/md5.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/aes.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/pbkdf2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/AesUtil.js"></script>
	<!-- Modernizr JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	<!-- jQuery -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath}/assets/js/blazy.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.easing.1.3.min.js"></script>

	<!-- Waypoints -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.stellar.min.js"></script>
	<!-- Counter -->
	<script type="text/javascript" src="assets/js/jquery.touchSwipe.min.js"></script>

	<!--======= Customize =========-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/responsive_bootstrap_carousel.min.js"></script>
	<!-- <script src="https:////cdnjs.cloudflare.com/ajax/libs/wow/0.1.12/wow.min.js" type="text/javascript" charset="utf-8" ></script> -->
	<script src="${pageContext.request.contextPath}/assets/js/wow-0.1.12.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/main.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.7/hammer.min.js"></script>

	<!-- BEGIN BOWSER JS-->
	<script src="${pageContext.request.contextPath}/assets/js/bowser.min.js" type="text/javascript"></script>
	<!-- END BOWSER JS-->

	<script type="text/javascript" charset="utf-8">
	
	var key = "HD63HF73B6VD52BFJ9GNEHN38DNF94BW6N49WNDRNDVNOENIVEEN894N8V30MV03MVNM5N3C3C3"

	function CreaIMG(texto) {
	    var ctxCanvas = document.getElementById('captcha').getContext('2d');
	    var fontSize = "30px";
	    var fontFamily = "Arial";
	    var width = 250;
	    var height = 50;
	    ctxCanvas.canvas.width = width;
	    ctxCanvas.canvas.height = height;
	    ctxCanvas.fillStyle = "whitesmoke";
	    ctxCanvas.fillRect(0, 0, width, height);
	    ctxCanvas.setLineDash([10, 10]);
	    ctxCanvas.lineDashOffset = 5;
	    ctxCanvas.beginPath();
	    var line;
	    for (var i = 0; i < (width); i++) {
	        line = i * 10;
	        ctxCanvas.moveTo(line, 0);
	        ctxCanvas.lineTo(0, line);
	    }
	    ctxCanvas.stroke();
	    ctxCanvas.direction = 'ltr';
	    ctxCanvas.font = fontSize + " " + fontFamily;
	    var x = (width / 3.5);
	    var y = (height / 3) * 2;
	    ctxCanvas.strokeStyle = "yellow";
	    ctxCanvas.strokeText(texto, x, y);
	    ctxCanvas.fillStyle = "red";
	    ctxCanvas.fillText(texto, x, y);
	}

	function Captcha() {
	    var alpha = new Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
	    var i;
	    for (i = 0; i < 6; i++) {
	        var a = alpha[Math.floor(Math.random() * alpha.length)];
	        var b = alpha[Math.floor(Math.random() * alpha.length)];
	        var c = alpha[Math.floor(Math.random() * alpha.length)];
	        var d = alpha[Math.floor(Math.random() * alpha.length)];
	        var e = alpha[Math.floor(Math.random() * alpha.length)];
	        var f = alpha[Math.floor(Math.random() * alpha.length)];
	        var g = alpha[Math.floor(Math.random() * alpha.length)];
	    }
	    var code = a + b + c + d + e + f + g;
	    localStorage.setItem('KEY_VALID', md5(code, key));
	    CreaIMG(code);
	    autenticartoken_in();
	   
	    
	}

	function ValidCaptcha() {
	    var string1 = localStorage.getItem('KEY_VALID');
	    var string2 = document.getElementById("txtInput").value;
	    if (string1 == md5(string2, key)) {
	        document.getElementById("txtInput").value = "";
	        localStorage.removeItem('KEY_VALID');
	        Captcha();
	        return true;
	    }
	    else {
	        document.getElementById("txtInput").value = "";
	        localStorage.removeItem('KEY_VALID');
	        Captcha();
	        return false;
	    }
	}


	var navegadores = ["Chrome", "Firefox"];
	var versiones = ["60", "50"];
	
	
	function quitarEspacios(){
		var passwa = $("#txtPasswordLogin").val().trim();
		$("#txtPasswordLogin").val(passwa);
	}

	function navegador() {
		var agente = bowser.name;
	    for (var i in navegadores) {
	        if (agente.indexOf(navegadores[i]) != -1 && parseInt(bowser.version) >= versiones[i]) {
	            return true;
	        }
	    }
	    return false;
	}

	/** INI : main **/
	var strNav = "";
	for (var i = 0; i < navegadores.length; i++) {
	    strNav += navegadores[i] + " " + versiones[i] + ".x";
	    if (i < navegadores.length - 1) {
	        strNav += ",";
	    }
	}

	if (!navegador()) {
		window.location = window.location.origin+window.location.pathname+"error/NavegadorNoSoportado";
	}
	/** FIN : main **/


		var consulta = window.matchMedia('(max-width: 768px)');
		consulta.addListener(mediaQuery);
		var $burguerButton = document.getElementById('btn-iniciar-session');
		var $menu = document.getElementById('fondo-transparente');
		function toggleMenu(){
			$menu.classList.toggle('active')
		};
		function showMenu(){
			$menu.classList.add('active');
		};
		function hideMenu(){
			$menu.classList.remove('active');
		};
		function mediaQuery() {
		if (consulta.matches) {
			  // si se cumple hagamos esto
			  //console.log('se cumplió la condicion');
			  $("#btn-iniciar-session").attr('onclick', 'toggleMenu()');
			  //$("#btn-close-login").css('display', 'none');
			  $burguerButton.addEventListener('touchstart', toggleMenu);
			} else {

			  $("#btn-iniciar-session").attr('onclick', 'OpenLogin()');
			  $("#btn-close-login").css('display', '');

			  $burguerButton.removeEventListener('touchstart', toggleMenu);
			  // si no se cumple hagamos esto
			  //console.log('no se cumplió la condicion');
			}
		}
		mediaQuery();

		var $body = document.body;
		var gestos = new Hammer($body);
		gestos.on('swipeleft', hideMenu);
		gestos.on('swiperight', showMenu);

		new WOW().init();

		var valNomImgModal = $('#valNomImgModal').val();
		if(valNomImgModal){
			$('#modal-index').modal("show");
		}

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
		
		function encryptedValue(key,value){
			var iterationCount = 1000;
		  	var keySize = 128;
		    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
		    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
		    var aesUtil = new AesUtil(keySize, iterationCount);
		    return aesUtil.encrypt(salt, iv, key, value);
		}
		
		function validarSesionLoad(){
			
			//showLoad();
			var context  = '${pageContext.request.contextPath}';	
			
					
			$.ajax(
			{
						 async: true,
						type: "POST",
						data: {
							"cod": 'xhxhhxh34324324'
							
						},
					    url: context+"/inicio/autenticarload",
				        success: function(data)
				        {
				        	console.log(data);

				        },
					    error: function(xhr,status,er) {
					    	console.log(er);
					   },
					   complete: function(){
						   console.log('completado....');
					   	
						}
			});
			
					
					
		};
		function autenticartoken_in(){
			
			//showLoad();
			var context  = '${pageContext.request.contextPath}';	
			var key=localStorage.getItem('KEY_VALID')+'XSbSg4r&5dRwV2yoElRDZwWsLn$lT*F*fAwlrH2H';
					
			$.ajax(
			{
						 async: true,
						type: "POST",
						data: {
							"cod": key
							
						},
					    url: context+"/inicio/autenticartoken_in",
				        success: function(data)
				        {
				        	console.log('====== resp: '+data);

				        },
					    error: function(xhr,status,er) {
					    	console.log(er);
					   },
					   complete: function(){
						   console.log('completado....');
					   	
						}
			});
			
					
					
		};

		function validarSesion(){
			if(ValidCaptcha()){
				showLoad();
				var username = $('#txtUsernameLogin').val();
				var password = $('#txtPasswordLogin').val();
				var context  = '${pageContext.request.contextPath}';

				var mensaje = '';
				var validado = false;
				var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

				var userEncrypted = encryptedValue("usuario", username);
				var passEncrypted = encryptedValue("clave", password);
				var key=localStorage.getItem('KEY_VALID')+'XSbSg4r&5dRwV2yoElRDZwWsLn$lT*F*fAwlrH2H';
				
				$("#textEnUsuario").val(userEncrypted);
			    $("#textEnPassword").val(passEncrypted);
				
				$.ajax({
					 async: true,
					type: "POST",
					data: {
						"username": userEncrypted,
						"password": passEncrypted,
						"key": key
					},
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
			   	    			case '6': validado = true;localStorage.removeItem('KEY_VALID');
	 	    					  		  break;
			   	    			case '7': mensaje = 'Sólo los estudiantes pueden ingresar a la plataforma';
	 	    					  		  break;
			   	    			case '8': mensaje = 'Usuario y/o contraseña incorrecta. Vuelve a intentarlo.';
	 	    					  		  break;
			   	    			case '9': mensaje = 'Has intentado más de 3 veces, inicio de sesión se habilitará en 30 minutos';
						  		  		  break;
	 	    					default: mensaje = data;break;
			   	    		}

			   	    	}else{
			   	    		mensaje = '';
			   				validado = false;
			   	    	}

			        },
				    error: function(xhr,status,er) {
					    //console.log("error: " + xhr + " status: " + status + " er:" + er);
					    if(xhr.status==500) {
						   //console.log(er);
					 //    Error_500(er);
					    }
					    if(xhr.status==901) {
						   //console.log(er);
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
			}else {
				alert("Ingrese correctamente los datos de la imagen");
			}
		}

		$('#backToTopx').click(function(event){
			debugger;
			cont++;
			if(cont==3){
				$('#backToTop').css('transform','rotate(180deg)');
			}
			if(cont == seccionPage.length){
				cont=0;
				$('#backToTop').css('transform','rotate(0deg)');
			}
			console.log(seccionPage[cont]);
			$('html, body').animate({
				scrollTop: $('#'+seccionPage[cont]).offset().top
			}, 500);
		});


		jQuery(document).ready(function() {

			var offset = 250;

			var duration = 300;

			jQuery(window).scroll(function() {

				if (jQuery(this).scrollTop() > offset) {
					jQuery('.back-to-top').fadeIn(duration);
				} else {

				jQuery('.back-to-top').fadeOut(duration);

				}

			});

			jQuery('.back-to-top').click(function(event) {
				event.preventDefault();
				jQuery('html, body').animate({scrollTop: 0}, duration);
				return false;
			})

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

		var bLazy = new Blazy({
		    selector: 'img'
		});
		
		function mostrarMensaje(){
            var infoHtml = "<div id='optionOlvi' class='alert alert-danger'><button onclick='ocultarMensaje()' type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Estimado(a) usuario(a): Porfavor contactarse con el especialista de plataforma al correo: esp_deib@minedu.gob.pe.</span></div>";
            $("#boxMsgxOlvidar").html(infoHtml);
            $("#optionOlvi").fadeIn("slow");
        }

        function ocultarMensaje(){
            $("#optionOlvi").fadeOut();
        }
        
		

	</script>

	</body>
</html>