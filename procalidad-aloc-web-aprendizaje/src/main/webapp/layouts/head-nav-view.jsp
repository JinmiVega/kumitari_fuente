<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean"%>

	<header role="banner" id="oterPageHeader">
		    <div id="div-fondo-ajax">
		    </div>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" style="background: #FF4D4C">
    <input type="hidden" id="codusumatriBean" value="${usuarioMatriculaBean.codigo}">
    <input type="hidden" id="monedasUsuario" value="${alumnoMonedaGBean.numeroMonedas}">
	<input type="hidden" id="gemasUsuario" 	 value="${alumnoMonedaGBean.numeroGemas}">
	<input type="hidden" id="codigousarioBean" value="${usuarioEstudiante.codigo}">
	<input type="hidden" id="nombrefotouser" value="${usuarioEstudiante.persona.nombrefotouser}">
	<c:forEach var="traduccion" items="${lstTraduccion}">
		<input type="hidden" id="trad_${traduccion.etiqueta.codigoEtiqueta}"
				<c:choose>
				    <c:when test="${(not empty traduccion.traduccion) and (traduccion.traduccion != '')}">
				        value="${traduccion.traduccion}"
				    </c:when>
				    <c:otherwise>
				        value="${traduccion.etiqueta.descripcion}"
				    </c:otherwise>
				</c:choose>
			/>
	</c:forEach>
	<div class="container">
    <div class="navbar-header" style="display: flex;">
		<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<c:choose>
			<c:when test="${codEvaluacion > 0}">
 				<a class="navbar-brand"  href="#"><i class="icon-minedu-kumitsari"></i></a>
			</c:when>
			<c:otherwise>
			 <a class="navbar-brand"  href="${pageContext.request.contextPath}/inicio/home"><i class="icon-minedu-kumitsari"></i></a>
			</c:otherwise>
		</c:choose>
		<div class="div-version" style="display: flex;align-items: flex-end;color: #fff;">
			v 0.0.3
		</div>
	</div>


	<div id="navbarFixed" class="collapse navbar-collapse js-navbar-collapse">

		<ul class="nav navbar-nav navbar-right">
            <c:if test="${(usuarioEstudiante.codPerfilUsuSelec==4) and (lenguaBean.codigo>0) }">
            	<li class="lst-head">
            		<div class="item-btn-head" onclick="showTIenda()">
            			<span class="item-km"><i class="icon-minedu-tienda"></i></span>
            		</div>
            	</li>
            </c:if>

            <li class="lst-head">
            	<div class="item-btn-head">
            		<span class="item-km">
            			<i class="small-ico icon-minedu-entrenar"></i>
            			<div id="clock" class="valor-moneda"></div></span>
            		</div>
            </li>

            <c:if test="${(usuarioEstudiante.codPerfilUsuSelec==4) and (lenguaBean.codigo>0)}">
            	<li class="lst-head">
            		<div class="item-btn-head" onclick="showTPremio()"><span class="item-km"><i class="small-ico icon-minedu-colecciones"></i></span></div>
            	</li>
            </c:if>

           <li class="lst-head">
           		<div class="item-btn-head" style="cursor:default"><span class="item-km">
           		<i class="small-ico icon-minedu-gema" style="margin-right: 3px;z-index: 5;position: relative;"></i>
           		<div class="valor-gema" id="gemasDisponibles">${alumnoMonedaGBean.numeroGemas}</div></span>
           		</div>
           	</li>

            <li class="lst-head">
            	<div class="item-btn-head">
            		<span class="item-km"><i class="icon-minedu-precio"></i><div class="valor-moneda" id="monedasDisponibles">${alumnoMonedaGBean.numeroMonedas}</div></span>
            	</div>
            </li>
            <li class="lst-head">
            	<div class="item-btn-head"><span class="item-km"><i class="fa fa-gift fa-2x" style="margin-top: -3px;"></i><div class="valor-moneda" id="bonosDisponibles">${alumnoMonedaGBean.numeroBono}</div></span></div>
            </li>
            <!-- <li></li> -->
			        <li id="menu-select-notificaion" class="dropdown lst-head" style="display: none">
			          <a href="#"><span class="item-km"><i class="small-ico icon-minedu-notificaciones"></i><b class="badge">3</b></span></a>
			          <ul class="dropdown-menu" style="font-weight: 500">
			            <li><strong style="padding: 5px 15px;display: table;color:#111">Notificaciones</strong></li>
			            <li>
							<a href="#" class="list-group-item">
							  <div class="rounded-circle">
								<i class="fa fa-exclamation-circle"></i>
							  </div>
							  <div class="msg-text"><p class="notification-text">Tienes un examen programado en...</p><p class="text-date-not">Hace 5 horas</p></div>
							</a>
			            </li>
			            <li class="divider"></li>
			            <li>
							<a href="#" class="list-group-item">
							  <div class="rounded-circle">
								<i class="icon-minedu-gallito" style="font-size: 29px;color: #ff5757;background: #fff;border-radius: 50%;padding: 5px;display: table;height: 40px;width: 40px;text-align: center;"></i>
							  </div>
							  <div class="msg-text"><p class="notification-text"><strong>Plumilla :</strong> no olvides que tienes un pendie...</p><p class="text-date-not">Hace 15 horas</p></div>
							</a>
			            </li>
			            <li class="divider"></li>
			            <li>
							<a href="#" class="list-group-item">
							  <div class="rounded-circle">
								<i class="icon-minedu-gallito" style="font-size: 29px;color: #ff5757;background: #fff;border-radius: 50%;padding: 5px;display: table;height: 40px;width: 40px;text-align: center;"></i>
							  </div>
							  <div class="msg-text"><p class="notification-text"><strong>Plumilla :</strong> no olvides que tienes un pendie...</p><p class="text-date-not">16 jul. 2017</p></div>
							</a>
			            </li>
			            <li class="divider"></li>
			            <li><a href="#" class="btn btn-sm btn-one" style="margin-bottom: 5px">Ver más</a></li>
			          </ul>
			        </li>

			        <li id="menu-select-notificaion" class="dropdown lst-head" style="display: none">
			          <a href="#"><span class="item-km"><i class="small-ico icon-minedu-notificaciones"></i><b class="badge">3</b></span></a>
			          <ul class="dropdown-menu" style="font-weight: 500">
			            <li><strong style="padding: 5px 15px;display: table;color:#111">Notificaciones</strong></li>
			            <li>
							<a href="#" class="list-group-item">
							  <div class="rounded-circle">
								<i class="fa fa-exclamation-circle"></i>
							  </div>
							  <div class="msg-text"><p class="notification-text">Tienes un examen programado en...</p><p class="text-date-not">Hace 5 horas</p></div>
							</a>
			            </li>
			            <li class="divider"></li>
			            <li>
							<a href="#" class="list-group-item">
							  <div class="rounded-circle">
								<i class="icon-minedu-gallito" style="font-size: 29px;color: #ff5757;background: #fff;border-radius: 50%;padding: 5px;display: table;height: 40px;width: 40px;text-align: center;"></i>
							  </div>
							  <div class="msg-text"><p class="notification-text"><strong>Plumilla :</strong> no olvides que tienes un pendie...</p><p class="text-date-not">Hace 15 horas</p></div>
							</a>
			            </li>
			            <li class="divider"></li>
			            <li>
							<a href="#" class="list-group-item">
							  <div class="rounded-circle">
								<i class="icon-minedu-gallito" style="font-size: 29px;color: #ff5757;background: #fff;border-radius: 50%;padding: 5px;display: table;height: 40px;width: 40px;text-align: center;"></i>
							  </div>
							  <div class="msg-text"><p class="notification-text"><strong>Plumilla :</strong> no olvides que tienes un pendie...</p><p class="text-date-not">16 jul. 2017</p></div>
							</a>
			            </li>
			            <li class="divider"></li>
			            <li><a href="#" class="btn btn-sm btn-one" style="margin-bottom: 5px">Ver más</a></li>
			          </ul>
			        </li>

					<li id="menu-select-lengua" class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<small><b class="name-user">${usuarioEstudiante.persona.nombreCompleto} </b> </small>
				          <c:if test="${usuarioEstudiante.persona.nombrefotouser!=null && usuarioEstudiante.persona.nombrefotouser!=''}">
				          	<img src="${pageContext.request.contextPath}/fotouser/${usuarioEstudiante.persona.nombrefotouser}" class="img-responsive img-circle" alt="" width="52px"> <b class="caret"></b>
				          </c:if>
				          <c:if test="${usuarioEstudiante.persona.nombrefotouser==null}">
				          	<img src="${pageContext.request.contextPath}/assets/images/photo-cam-user.jpg" class="img-responsive img-circle" alt="" width="52px"> <b class="caret"></b>
				          </c:if>
						</a>

						<ul class="dropdown-menu">
					        <li>
					        	<a href="#" onclick="cargarperfil();" style="margin-top: 5px"><span class="txt-link-url" id="tituloPerfil">Perfil</span><i class="fa fa-user"></i></a>
					        </li>
				            <c:if test="${usuarioEstudiante.codPerfilUsuSelec==4}">
				            	<li><a href="#" onclick="cargarOffline()"><span class="txt-link-url" id="tituloConfiguracion">Configuración</span><i class="fa fa-cog"></i></a></li>
				            </c:if>
					            <!-- <li><a href="#"><span class="txt-link-url" id="tituloMisReportes">Mis reportes</span><i class="fa fa-pie-chart "></i></a></li> -->
					            <%-- <li><a href="${pageContext.request.contextPath}" onclick="linkSalir()" style="margin-bottom: 5px"><span class="txt-link-url">Cerrar Sesión</span><i class="fa fa-power-off"></i></a></li> --%>
					        <li>
					        	<a href="#" onclick="javascript:confirmarSalirSistema('¿Desea cerrar sesión?','${pageContext.request.contextPath}/logoutController/cerrarSesion')" style="margin-bottom: 5px"><span class="txt-link-url" id="tituloCerrarSesion">Cerrar Sesión</span><i class="fa fa-power-off"></i></a>
					        </li>
						</ul>
					</li>
		</ul>

	</div><!-- /.nav-collapse -->
	</div>
</nav>
		    <span id="barraIdentidad"></span>
		    <input type="hidden" id="contextPathUrl" value="${pageContext.request.contextPath}">

	</header>

<script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/page/tienda-script.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/page/premio-script.js"></script>
<script type="text/javascript" charset="utf-8" >
/*$( document ).ready(function() {
	listarFondoBeanSwPredet();
    traducir();
});*/
	window.onload -= function() {
		  traducir();
		  listarFondoBeanSwPredet();
	};

	function confirmarSalirSistema(msg,url) {

		window.location.href=url;

	};
	///procalidad/fondo/FONDOS-4.png
	function fondoPrincipal(valor) {
		$("#oterPageHeader #div-fondo-ajax").html('<style type="text/css">.bg-fondo-app::after{background-image:url("${pageContext.request.contextPath}/fondo/'+valor+'");} </style>');
	}
	function cargarperfil() {
		window.location='${pageContext.request.contextPath}/perfil/nuevo';
	}

	function cargarOffline() {
		window.location='${pageContext.request.contextPath}/perfil/carga/';
	}
</script>
