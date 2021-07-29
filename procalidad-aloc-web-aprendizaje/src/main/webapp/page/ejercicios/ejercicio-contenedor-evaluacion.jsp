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
	<title>Lecci&oacute;n ${lenguaBean.nombre}</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Lecci&oacute;n ${lenguaBean.nombre}" />


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
	<!-- font-awesome -->
	<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" media="all">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/assets/css/animate.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/desing-app-view.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/evaluacion_minedu.min.css">


	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
	<![endif]-->

		<style type="text/css">
			#idShowIndGram {
				cursor:pointer;
				border-radius: 50%;
				background: #3176AD;
				font-size: 32px;
				padding: 10px;
				display: none;
				float: left;
				margin-right: 20px;
				line-height: 18px;
				color: #fff;
			}

			.material-style{
			    font-weight: bold;
			    font-size: 15px;
			    border: 1px solid #7465ff;
			    background: #e4e5ff;
				color: #2a1c98;
			}

			#pagination-leccion li #glosario-link{
				color: #FF4D4C;
				margin-right: 0px;
			}

			#content-text-castellano{
			    min-height: 94px;
			    background: #c4e8cc;
			    color: #1fa02a;
			    font-size: 13px;
			    line-height: 18px;
			    padding: 20px;
			    padding-right:40px;
			    word-spacing: 2px;
			    font-weight: 400;
			    border: 1px solid #65ff84;
			    text-rendering: optimizeLegibility;
			    border-radius: 4px;
			    margin-bottom: 20px;
			    position: relative;
			    display: table;
			    width: 100%;
			}
		</style>

	</head>
	<body class="page-header-color" onKeyDown="javascript:capturarHoraF5()">
	<jsp:include page="${pageContext.request.contextPath}/../layouts/head-nav-view.jsp"></jsp:include>
	<c:forEach var="mensajes" items="${lstMensajes}">
							<input type="hidden"
								id="msj_${mensajes.tipoMensaje.codigoRegistro}"
								value="${mensajes.mensajes}">
						</c:forEach>
	<!-- <section id="fh5co-work" style="padding-top: 130px;"> -->
	<section id="lst-lengua" class="bg-fondo-app">
		<div class="container">
			<!-- <input type="hidden" id="codlenguaTreeVal" value="${lenguaBean.codigo}">
			<input type="hidden" id="nomlenguaTreeVal" value="${lenguaBean.nombre}">
			<input type="hidden" id="pageActualTreeVal" value="${pageContext.request.requestURI}">  -->
			<div id="menu-app" style="display: none;">
			   <div class="bseccion">
			   	 <nav>
			   		<ul>
			   			<li id="lengua-actual">
			   				<%-- <a href="${pageContext.request.contextPath}/rutalengua/quechua">
			   					<img src="${pageContext.request.contextPath}/assets/images/lengua/SIMBOLO-AIMARA.png" alt="" class="img-responsive" width="62">
			   				</a> --%>
			   				<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}">
								<c:choose>
									<c:when test="${not empty lenguaBean.imagenNombre}">
										<img src="${pageContext.request.contextPath}/lengua/${lenguaBean.imagenNombre}" alt="${lenguaBean.imagenNombre}" class="img-responsive" width="72">
									</c:when>
									<c:otherwise>
										<img src="${pageContext.request.contextPath}/assets/images/lengua/SIMBOLO-AIMARA.png" alt="" class="img-responsive" width="72">
									</c:otherwise>
								</c:choose>
							</a>
			   			</li>

			   			<li>
			   				<%-- <a href="${pageContext.request.contextPath}/rutalengua/quechua/basico/b1">
			   					<img src="${pageContext.request.contextPath}/assets/images/icono-panel/basico-1.png" alt="" class="img-responsive" width="62">
			   				</a> --%>
			   				<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}/nivel/${lenguaEstructuraBean.codigoEncrypt}">
								<span class="circle-item name-leccion tooltipx circle_color_0${lenguaEstructuraBean.subNivel.valor2}">
									<span class="name-one">${lenguaEstructuraBean.lenguaNivelBean.inicialNombre}</span>
									<span class="name-two">${lenguaEstructuraBean.subNivel.valor2}</span>
									<span class="tooltiptext tooltip-right">${lenguaEstructuraBean.lenguaNivelBean.nombreNivel}</span>
								</span>

							</a>
			   			</li>
			   			<li>
			   				<a href="${pageContext.request.contextPath}/lengua/detalle/${lenguaBean.codigoEncrypt}/nivel/${lenguaEstructuraBean.codigoEncrypt}/unidad/${unidadBean.codigoEncrypt}">

										<span class="circle-item name-leccion tooltipx">
							   				<span class="name-one">${unidadBean.lenguaUnidadBean.inicialNombre}</span>
			   								<span class="name-two">${unidadBean.unidad.codigoRegistro}</span>
											<c:if test="${not empty unidadBean.nombre}"><span class="tooltiptext tooltip-right">${unidadBean.nombre}</span></c:if>
						   				</span>
							</a>
			   			</li>
			   			<li>
			   				<%-- <span class="circle-item">
			   					<span class="name-one">L</span>
			   					<span class="name-two">${unidadLeccionBean.leccion.codigoRegistro}</span>
			   				</span> --%>
			   				<span class="circle-item name-leccion tooltipx">
				   					<span class="name-one">${unidadLeccionBean.lenguaLeccionBean.inicialNombre}</span>
				   					<span class="name-two">${unidadLeccionBean.leccion.codigoRegistro}</span>
				   					<c:if test="${not empty unidadLeccionBean.nombre}"><span class="tooltiptext tooltip-right">${unidadLeccionBean.nombre}</span></c:if>
				   				</span>
			   			</li>
			   		</ul>
			   	 </nav>

					<div id="box-masct">

						<input type="hidden" id="timepoHora" value="${hora}">
						<input type="hidden" id="tiempoMinuto" value="${minuto}">
						<input type="hidden" id="tiempoSegundo" value="${segundo}">

						<input type="hidden" id="idValImgNormal" value="${beanMascota.imagenNormal}">
						<input type="hidden" id="idValImgAlegre" value="${beanMascota.imagenAlegre}">
						<input type="hidden" id="idValImgTriste" value="${beanMascota.imagenTriste}">
						<input type="hidden" id="idValImgExclam" value="${beanMascota.imagenExclamativa}">
						<input type="hidden" id="idValImgNormalAnim" value="${beanMascota.imagenNormalAlter}">
						<div id="show-msg"></div>
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
								<img src="${pageContext.request.contextPath}/assets/images/plumillaNeutro.png" alt="No disponible" class="img-responsive">
							</c:otherwise>
						</c:choose>
			   		</div>
			   </div>
			</div>

			<div style="display:none;">

			<%--

				<input type="hidden" id="codusuariomat" value="${usuarioMatriculaBean.codigo}">
				<input type="hidden" id="codAluMoneG"  	value="${alumnoMonedaGBean.codigo}">
				<input type="hidden" id="codlenguaVal" 	value="${lenguaBean.codigo}">
				<input type="hidden" id="codlenestVal"	value="${lenguaEstructuraBean.codigo}">
				<input type="hidden" id="codunidadVal" 	value="${unidadBean.codigo}">
				<input type="hidden" id="codleccionVal" value="${unidadLeccionBean.codigo}">--%>
				<input type="hidden" id="codEvaluacion" value="${codEvaluacion}">
				<input type="hidden" id="tm2TipoEvaluacion" value="${tipoEvaluacion}">
				<input type="hidden" id="codMatTipoEjerBono" value="0">
				<input type="hidden" id="codigoLengua" 	value="${codigoLengua}">
				<input type="hidden" id="codlenguaEncrypt" value="${codigoEncryptLengua}">

				<input type="hidden" id="codlenguaTreeVal" value="${codigoLengua}">

				<input type="hidden" id="codSubNivel" value="${lenguaEstructuraBean.subNivel.codigoRegistro}">
				<input type="hidden" id="codusuariomat" value="${usuarioMatriculaBean.codigo}">
				<input type="hidden" id="lenguanivel" value="${lenguaEstructuraBean.nivel.codigoRegistro}">
				<input type="hidden" id="notaMinima" value="${maestraBean.nombreCorto}">
				<input type="hidden" id="notaObtenida" value="0">

				<%-- <input type="hidden" id="codtipomaterialVal" value="${material.situacionLeccionMaterial.codigoRegistro}">

				<input type="text" id="codmaterialVal" value="${material.codigo}">
   				<input type="hidden" id="codmaterialValEncrypt" value="${material.codigoEncrypt}">
				<input type="hidden" id="codtipomaterialVal" value="${material.situacionLeccionMaterial.codigoRegistro}"> --%>
				<input type="hidden" id="glosarioLengua" value="${glosarioBean.detalle}">
				<input type="hidden" id="glosarioArchivo" value="${pageContext.request.contextPath}/glosario/${glosarioBean.lenguaBean.codigo}_${glosarioBean.fileName}">
				<input type="hidden" id="contexturl" value="${pageContext.request.contextPath}">
				<input type="hidden" id="swEsUltimoEj" value="${swEsUltimoEj}">
				<input type="hidden" id="posEjercicio" value="${posEjercicio}">
	<%-- 		<input type="hidden" id="codEvaluacion" value="${codEvaluacion}">--%>
				<input type="hidden" id="idhoralenguanivel" value="">
				<input type="hidden" id="idhora1" value="">
				<input type="hidden" id="idmin1" value="">
				<input type="hidden" id="idseg1" value="">
				<input type="hidden" id="totalsegundos" value="">
				<input type="hidden" id="timelenguanivel" value="">


				<input type="hidden" id="tiempoBono" value="0">
				<%-- <input type="hidden" id="valStrListaMaterial" value="${strListaMaterial}"> --%>
			</div>

			<div id="id-lista-ejercicio-material_evaluacion" style="display: none;">
				<c:forEach var="evaluacion" items="${lstEvaluacionDetalleBeans}">
					<span class="elementos_ejercicio_material_evaluacion"
					id="${evaluacion.materialTipoEjercicioBean.codigo}"
					data-tipo="${evaluacion.materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}"></span>

				</c:forEach>
			</div>

			<div id="content-ejercicio-actual-evaluacion-ajax">
				<div id="content-app" style="float: left;width: 100%">
					<!-- Aqui el contenido del material -->
				</div>
				<!--<div id="idDivLoadAjaxEvaluacion" style="position: relative;">
					<div class="main-ajax">
						<div class="preloader"></div>
						<i class="icon-minedu-kumitsari"></i>
					</div>
				</div>
			</div>-->


		</div>
		</div>
	</section>

	<!-- Modal Glosario -->
    <div class="modal fade text-xs-left" id="Glosario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel21" aria-hidden="true">
	      <div class="modal-dialog" role="document">
		     <div class="modal-content">
		       <div class="modal-header" style="cursor: move;">
		      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		        <span aria-hidden="true">&times;</span>
		      </button>
		      <h4 class="modal-title" id="txt_confir_Vd" style="text-transform: uppercase;font-weight: bold;">Glosario</h4>
		       </div>
		       <div class="modal-body">
			      <div class="row">
		               <div id="dataInfoModal" class="form-group col-lg-12">
		                </div>

		           </div>

			      </div>
		       <!-- <div class="modal-footer">
		      <button type="button" class="btn grey btn-outline-secondary" data-dismiss="modal" id="btnCerrarModal">Cerrar</button>

		       </div> -->
		     </div>
	      </div>
    </div>

	<%-- <jsp:include page="${pageContext.request.contextPath}/../layouts/footer-view.jsp"></jsp:include>
	 <jsp:include page="../../layout/confirmacion-modal-view.jsp" />--%>



	<jsp:include page="${pageContext.request.contextPath}/../layouts/tienda-modal-view.jsp"></jsp:include>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/premio-modal-view.jsp"></jsp:include>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/detalle-tienda-modal-view.jsp"></jsp:include>


	<c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><jsp:include page="${pageContext.request.contextPath}/../layouts/tree-view.jsp"/></c:if>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
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
	<script src="${pageContext.request.contextPath}/assets/js/scroll.js" type="text/javascript" charset="utf-8"></script>

	<!--======= Customize =========-->
	<script src="${pageContext.request.contextPath}/assets/js/responsive_bootstrap_carousel.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/popover.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/assets/js/main-app.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/actividad/Evaluacion.js" type="text/javascript"></script>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/info-modal-view.jsp"></jsp:include>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/info-correcta-modal-view.jsp"></jsp:include>
	<jsp:include page="${pageContext.request.contextPath}/../layouts/ganar-premio-evaluacion-modal-view.jsp"></jsp:include>
<!--	<script src="${pageContext.request.contextPath}/assets/js/actividad/monedasyGemas.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/actividad/SeguimientoAlumLen.js" type="text/javascript"></script>-->
	<c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><script src="${pageContext.request.contextPath}/assets/js/tree-view.js" type="text/javascript" charset="utf-8"></script></c:if>


	<script src="${pageContext.request.contextPath}/assets/js/timerCountdown/jquery.countdown.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/timerCountdown/cargartiempoxEvaluacion.js" type="text/javascript"></script>

	<script type="text/javascript">
	function cargarmodal_termino_evalua() {

	obtenerNota();

	}
	/*jQuery(document).ready(function(){
	    jQuery('.scrollbar-inner').scrollbar();
	});*/

	$("#Glosario").draggable({
	    handle: ".modal-header"
	});

	</script>
	</body>
</html>