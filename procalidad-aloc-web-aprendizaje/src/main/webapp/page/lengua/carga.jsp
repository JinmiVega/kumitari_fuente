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
<title>Modo Offline Kumitsari</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Modo Offline Kumitsari" />

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

<!-- <link
	href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600,400italic,700'
	rel='stylesheet' type='text/css'>

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,600i,700,800"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Coustard:400,900"
	rel="stylesheet"> -->

<link
	href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" media="all">

<!-- Magnific Popup -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/magnific-popup.min.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

<!-- Styleswitcher ( This style is for demo purposes only, you may delete this anytime. ) -->

<!-- End demo purposes only -->

<link
	href="${pageContext.request.contextPath}/assets/css/animate.min.css"
	rel="stylesheet">


<link href="${pageContext.request.contextPath}/assets/css/notifIt.min.css" rel="stylesheet">
<!-- Modernizr JS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/desing-app-view.css">
<script
	src="${pageContext.request.contextPath}/assets/js/modernizr-2.6.2.min.js"></script>

<link
	href="${pageContext.request.contextPath}/assets/css/gp_product_carousel_advance.min.css"
	rel="stylesheet" media="all">
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

    <link href="${pageContext.request.contextPath}/assets/css/upload/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assets/js/upload/themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>

		<style>
		#frm-main-upload .kv-fileinput-caption{
			display:none
		}
		#boxMsg {
			font-size:1em !important;
		}
	</style>

</head>
<body class="page-header-color">
	<jsp:include
		page="${pageContext.request.contextPath}/../layouts/head-nav-view.jsp"></jsp:include>

	<div id="Subheader" style="display: none">
		<div class="container">
			<div class="column one">
				<h1 class="title">Modo Offline Kumitsari</h1>
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
			<input type="hidden" id="nomMascimagenNormal" value="${beanMascota.imagenNormal}">
					<input type="hidden" id="idValImgNormal" value="${beanMascota.imagenNormal}">
						<input type="hidden" id="idValImgAlegre" value="${beanMascota.imagenAlegre}">
						<input type="hidden" id="idValImgTriste" value="${beanMascota.imagenTriste}">
						<input type="hidden" id="idValImgExclam" value="${beanMascota.imagenExclamativa}">
						<input type="hidden" id="idValImgNormalAnim" value="${beanMascota.imagenNormalAlter}">
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
						<input type="text" id="codusuariomat" value="${usuarioMatriculaBean.codigo}">
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

			<div  id="content-app">
			   <div class="col-md-12">
			     <!-- Nav tabs -->
			     <div class="card">
			       <ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab"><i class="icon-cloud-download2"></i>  <span>Descarga</span></a></li>
						<li role="presentation" ><a href="#home" aria-controls="home" role="tab" data-toggle="tab"><i class="icon-cloud-upload2"></i>  <span>Subida</span></a></li>

			       </ul>

			       <!-- Tab panes -->
			       <div class="tab-content">
				         <div role="tabpanel" class="tab-pane" id="home">
				         	<section id="banner-perfil">
								<div id="content-foto">
									<div class="row">
										<div class="col-sm-12" id="box-img-perfil">
											<img src="${pageContext.request.contextPath}/assets/images/flecha-hacia-arriba.png" class="img-responsive" alt="">
										</div>
									</div>
								</div>
								<div id="content-foto-info">
									<div class="row">
										<div class="col-sm-12">
											<h4>INDICACIONES</h4>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<ul id="lst-idiciaciones">
												<li>Suba el archivo que ha generado para sincronizar su seguimiento.</li>

											</ul>
											<br>
										</div>
									</div>
								</div>
							</section>
							<aside id="content-perfil" style="font-family: 'Quicksand',sans-serif;">
								<div class="row">
                                            <!-- <div class="col-md-12">
                                              <div class="form-group">
                                                <label for="situacionPersonal">Acción <span class="required">*</span></label>
                                                <div class="controls">
                                                   <select id="cbAccion" class="form-control" style="height: auto !important;" data-validation-required-message="Este campo es requerido" onchange="onchangeAccion()" required="required" >
                                                  				 <option value="" selected disabled="disabled" label="Seleccionar"/>
                                                                <option value="1">Sincronización</option>
                                                                <option value="2">Actualización</option>
                                                    </select>
                                                </div>
                                              </div>
                                            </div> -->
                                            <div class="col-md-12">
                                              <div class="form-group">
                                                <label for="situacionPersonal">Subir Datos A<span class="required">*</span></label>
                                                <div class="controls">
                                                   <select id="cbTipoServidorA" class="form-control cbTipoServidor" style="height: auto !important;"  onchange="onchangeServidor()" data-validation-required-message="Este campo es requerido" required="required" >
                                                  				 <option value="0">Seleccionar</option>
                                                                <option value="1">Servidor Local</option>
                                                                <option value="2">Servidor Remoto</option>
                                                    </select>
                                                </div>
                                              </div>
                                            </div>
                                            <div class="col-md-12">
                                              <div class="form-group">
                                                <label for="situacionPersonal">Escoger archivo <span class="required">*</span> <i title="Formato aceptado txt - Tamaño máximo permitido hasta 20 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado txt - Tamaño máximo permitido hasta 20 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label>
                                                <div class="controls">
                                                   <input type="file" id="txtFile" accept="text/plain" multiple name="txtFile[]">
                                                </div>
                                              </div>
                                            </div>
                                            </div>
                                          <div class="row">
                                              <div class="form-group col-md-12 text-right" id="contentSubmit">
												<button  id="subirArchivo"  class="btn btn-primary" onclick="subirArchivo()">Sincronizar Archivo</button>
                                              </div>

                                          </div>
                                          <div class="row">
                                          	  <div class="form-group col-md-12" id="contentDownload">
                                              </div>
                                          </div>
								<!--  <div class="row">
									<div class="col-md-12 icon-desing-nv">
										<div class="row">
											<div class="col-sm-12">
												<h2 id="title-perfil" class="text-center" style="font-weight: 100">Sincronizar <b style="font-weight: 500">Archivo</b></h2>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12">
												<hr>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-12" id="frm-main-upload">
									        	<form enctype="multipart/form-data" accept-charset="utf-8">
											        <div class="form-group">
											            <div class="file-loading">
											                <input id="upload_archivo" type="file" class="file" data-upload-url="#">
											            </div>
											        </div>
									            </form>
											</div>
										</div>

									</div>
								</div>-->
							</aside>
				         </div>
				         <div role="tabpanel" class="tab-pane active" id="profile">
				         	<section id="banner-perfil">
								<div id="content-foto">
									<div class="row">
										<div class="col-sm-12" id="box-img-perfil">
											<img src="${pageContext.request.contextPath}/assets/images/flecha-hacia-abajo.png" class="img-responsive" alt="">
										</div>
									</div>
								</div>
								<div id="content-foto-info">
									<div class="row">
										<div class="col-sm-12">
											<h4>INDICACIONES</h4>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<ul id="lst-idiciaciones">
												<li>Genere y descargue su archivo de seguimiento.</li>

											</ul>
											<br>
										</div>
									</div>
								</div>
							</section>
							<aside id="content-perfil"  style="font-family: 'Quicksand',sans-serif;">
								<div class="row">
									<div class="col-md-12 icon-desing-nv" style="font-family: 'Quicksand',sans-serif;">
										<div class="row">
											<div class="col-sm-12">
												<h2 id="title-perfil" style="font-family: 'Quicksand',sans-serif;" class="text-center" style="font-weight: 100">Descargar <b style="font-weight: 500">Archivo</b></h2>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12">
												<hr>
											</div>
										</div>
										<div class="row">
												<div class="col-md-12">
				                                <div class="form-group">
				                                  <label for="situacionPersonal">Mis Lenguas <span class="required">*</span></label>
				                                  <div class="controls">
				                                     <select id="cbLengua" class="form-control" style="height:auto !important" onchange="escogerTabla()" data-validation-required-message="Este campo es requerido" required="required" >
				                                    				 <option value="" selected disabled="disabled" label="Seleccionar"/>

				                                      </select>
				                                  </div>
				                                </div>
				                              </div>
				                              <div class="col-md-12">
				                                <div class="form-group">
				                                  <label for="situacionPersonal">Generar de <span class="required">*</span></label>
				                                  <div class="controls">
				                                     <select id="cbTipoServidorB" class="form-control cbTipoServidor" style="height:auto !important" onchange="escogerTabla()" data-validation-required-message="Este campo es requerido" required="required" >
				                                    				<option value="0">Seleccionar</option>
				                                                  <option value="1">Servidor Local</option>
				                                                  <option value="2">Servidor Remoto</option>
				                                      </select>
				                                  </div>
				                                </div>
				                              </div>
				                              <div class="col-md-12">
				                                <div class="form-group">
				                                  <label for="">Opción <span class="required">*</span></label>
				                                  <div class="controls">
				                                     <select id="cbTablas" onchange="escogerTabla()" class="form-control"style="height:auto !important" data-validation-required-message="Este campo es requerido" required="required" >
				                                          <option value="" disabled="disabled" label="Seleccionar"/>
				                                     		<option value="2">Mi Seguimiento</option>
				                                     </select>
				                                  </div>
				                                </div>
				                              </div>
				                              <div class="col-md-12">
				                                	<div class="form-group">
				                                		<!-- <a href="${pageContext.request.contextPath}/perfil/descargarArchivoDatos/"  id="enlaceDescargar"   class="btn btn-primary enlaceDescargar" target="_blank" download>Generar Archivo</a> -->
				                                		 <button  id="generarArchivo"  class="btn btn-primary" onclick="generarArchivo()">Generar Archivo</button>
				                                	</div>
				                              </div>

				                         </div>
				                          <div class="row">
                                          	  <div class="form-group col-md-12" id="contentRpta">
                                              </div>
                                          </div>
									</div>
								</div>
							</aside>

				         </div>
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
	<c:if test="${usuarioEstudiante.codPerfilUsuSelec != 4}"><script src="${pageContext.request.contextPath}/assets/js/tree-view.js" type="text/javascript" charset="utf-8"></script></c:if>

    <script src="${pageContext.request.contextPath}/assets/js/upload/plugins/sortable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/upload/fileinput.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/upload/locales/es.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/upload/themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/upload/themes/fa/theme.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>

	<script type="text/javascript" charset="utf-8">
		$(window).load(function(){
			listarLenguas();
			var lsTipoSrv = ${accesoBean.flgServer} +"";
	  		if(lsTipoSrv==1){
	  			$("#cbTipoServidorA option[value='2']").remove();
	  			$("#cbTipoServidorB option[value='2']").remove();
	  			//console.log("configurado para funcionar como local");
	  		} else{
	  			$("#cbTipoServidorA option[value='1']").remove();
	  			$("#cbTipoServidorB option[value='1']").remove();
	  		}
	  	});
		function onchangeAccion(e){
			//console.log($(this).attr("id"));
	  	}
		jQuery(document).ready(function(){

		    jQuery('.scrollbar-inner').scrollbar();
		});
		var href = $('#enlaceDescargar').attr("href");
		function escogerTabla(){
	  		$('#enlaceDescargar').attr("href","");
	  		$('#enlaceDescargar').attr("href",href+$("#cbTipoServidorB").val()+'/'+$("#cbTablas").val()+'/'+$("#cbLengua").val());
	  	}
		function generarArchivo(){
			var url = $("#contextPathUrl").val()+"/perfil/descargarArchivoDatos";
			var html = "";
			var data = new FormData();
			var liCodServ = $("#cbTipoServidorB").val();
			var liCodOpci = $("#cbTablas").val();
			//var liCodInst = $("#cbInstitucion").val();
			var liCodLeng = $("#cbLengua").val();
			if(liCodServ == 0 || liCodOpci == 0 || (liCodLeng == 0 || liCodLeng==null) ){
				var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">Debe completar los filtros.</span></div></div>';
				$("#contentRpta").html(msg);
				return false;
			} else{
				//iniciarBloqueo();
				$.ajax({
					 async: true,
					type : 'POST',
					data: {liCodServ : liCodServ, liCodOpci :liCodOpci,liCodLeng:liCodLeng},
					url : url,
					success : function(data) {
						//console.log("data: " + data);
						if (data==1) {
							$("#contentRpta").html('<a href="${pageContext.request.contextPath}/perfil/descargarArchivoGenerar/" id="enlaceDescargar"  style="display:None" class="btn btn-primary" target="_blank" download></a>');
							document.getElementById('enlaceDescargar').click();
							$("#contentRpta").empty();
						}else{
							var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">'+data+'</span></div></div>';
							$("#contentRpta").html(msg);
						}
					},
					error : function(data) {
						var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">'+data+'</span></div></div>';
						$("#contentRpta").html(msg);
					}, complete: function(data){
						//finBloqueo();
					}
				});
			}
		}
		$("#cbAccion").on("change", function() {
		  	  var liAccions = $(this).val();
		  		$("#contentSubmit").empty();
		  	  if(liAccions== 1){
		  		  $("#contentSubmit").html('<button  id="subirArchivo"  class="btn btn-primary" onclick="subirArchivo()">Sincronizar Archivo</button>');

		  	  } else if(liAccions == 2) {
		  		$("#contentSubmit").html('<button  id="subirArchivo"  class="btn btn-primary" onclick="subirArchivo()">Sincronizar Archivo</button>');
		  		  //
		  	  }
		  	});
		  	function onchangeServidor(){
		  		//$("#resultadoSubida").empty();
		  	}
		  	function subirArchivo(){

		  		let url = $("#contextPathUrl").val()+"/perfil/leerArchivoOffline";
		  		var inputFile = document.getElementById("txtFile");
		  		var file = inputFile.files[0];
		  		var srve = $("#cbTipoServidorA").val();
		  		var acci = 1;
		  		var data = new FormData();
		  		data.append("fileOffline",file);
		  		data.append("liCodServ",srve);
		  		data.append("liAccions",acci);
		  		if(srve==0){
		  			var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">Debe seleccionar el tipo de servidor.</span></div></div>';
					$("#contentDownload").html(msg);
		  		} else if(document.getElementById("txtFile").files.length == 0){
		  			var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">Debe especificar archivo.</span></div></div>';
					$("#contentDownload").html(msg);
		  		} else{
			  		$.ajax({
			  			 async: true,
				   		url:url,
				    	type:"POST",
				   		contentType:false,
				   		data:data,
				   		processData:false,
				   		cache:false,
				   		success: function(data){
				 	       //	msg_exito();
				 	       if(data=="1"){
								tieneData = true;
								//$("#resultadoSubida").html("<ul>");
								//for(var i=0;i<data.length;i++){
								//	$("#resultadoSubida ul").append("<li>"+ data[i] + "</li>");
									//console.log("data:"+ data[i]);
								//}
								//$("#contentDownload").html('<a href="${pageContext.request.contextPath}/perfil/leerDescargaArchivo/" id="enlaceDescargar"  style="display:None" class="btn btn-primary" target="_blank" download>Generar Archivo</a>');
								//document.getElementById('enlaceDescargar').click();
								//$("#contentDownload").empty();
								//$("#cbAccion").val("");
								$("#cbTipoServidorA").val("0");
								$("#txtFile").val("");
								var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">El archivo ha sido subido y los datos sincronizados.</span></div></div>';
								$("#contentDownload").html(msg);
							} else{
								var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">'+data+'</span></div></div>';
								$("#contentDownload").html(msg);
							}
				  			//console.log("ERROR: Se insertó el registro con éxito!!!");
				        },
				 		error: function(er)
				 		{
				 			var msg = '<div id="boxMsgValid"><div id="boxMsg" class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button><span class="msgValidar">'+data+'</span></div></div>';
							$("#contentDownload").html(msg);
				 			//msg_error();
				 		},
				 		complete: function(c){
				 			//finBloqueo();
				 		}
					});
		  		}
		  	}

		function listarLenguas(){
			var url = $("#contextPathUrl").val()+ "/perfil/listarLenguaUsuario";
			var html = "";
			$.ajax({
				 async: true,
				type : 'POST',
				contentType:false,
				processData:false,
		   		cache:false,
				url : url,
				success : function(data) {
					if (data != null) {
						for (var i = 0; i < data.length; i++) {
							if(data[i].matriculaBean.codigo>0){
								$('#cbLengua').append($('<option>', {
							       	value: data[i].codigo,
							       	text : data[i].nombre
							   	}));
							}
						}
					}else{
						 $('#cbLengua').append($('<option>', {
						        value: '0',
						        text : 'Seleccione'
						    }));
					}
				},
				error : function(data) {
					//console.log("error de cbLengua :" + data.error);
				}
			});
		}
		function linkSalir() {
			window.location = "${pageContext.request.contextPath}";
		}
		function show_detalle_moneda() {
			$(".tab-medalla").hide();
			$("#md-detalle-medalla").show();
		}
		new WOW().init();

	    $("#upload_archivo").fileinput({
	        theme: 'fa',
	        maxFileSize: 51000,
	        language: 'es',
	        allowedFileExtensions: ['txt'],
        	maxFilesNum: 1,
	        uploadExtraData: {kvId: '10'}
	    });
	    $(".btn-warning").on('click', function () {
	        var $el = $("#upload_archivo");
	        if ($el.attr('disabled')) {
	            $el.fileinput('enable');
	        } else {
	            $el.fileinput('disable');
	        }
	    });
	    $(".btn-info").on('click', function () {
	        $("#upload_archivo").fileinput('refresh', {previewClass: 'bg-info'});
	    });
	</script>
	<script src="${pageContext.request.contextPath}/assets/js/main-app.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/page/page-perfil.js"></script>

</body>
</html>