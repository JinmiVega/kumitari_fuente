<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean"%>
<ul class="nav navbar-nav">
  <li class="nav-item hidden-sm-down"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu"></i></a></li>
  <!-- li class="nav-item hidden-sm-down"><a href="#" class="nav-link nav-link-expand"><i class="ficon ft-maximize"></i></a></li -->
</ul>
<ul class="nav navbar-nav float-xs-right">

<!--               <li class="dropdown dropdown-language nav-item">
    <a id="dropdown-flag" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle nav-link">
      <i class="flag-icon flag-icon-gb"></i><span class="selected-language"></span>
    </a>
    <div aria-labelledby="dropdown-flag" class="dropdown-menu">
      <a href="#" class="dropdown-item"><i class="flag-icon flag-icon-gb"></i> English</a>
      <a href="#" class="dropdown-item"><i class="flag-icon flag-icon-fr"></i> French</a>
      <a href="#" class="dropdown-item"><i class="flag-icon flag-icon-cn"></i> Chinese</a>
      <a href="#" class="dropdown-item"><i class="flag-icon flag-icon-de"></i> German</a></div>
  </li> -->
<!--   <li class="dropdown dropdown-notification nav-item">
    <a href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i class="ficon ft-bell"></i>
      <span class="tag tag-pill tag-default tag-danger tag-default tag-up">5</span>
    </a>
    <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
      <li class="dropdown-menu-header">
        <h6 class="dropdown-header m-0">
          <span class="grey darken-2">Notificaciones</span>
          <span class="notification-tag tag tag-default tag-danger float-xs-right m-0">5 Nuevos</span>
        </h6>
      </li>
      <li class="list-group scrollable-container">
        <a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left valign-middle"><i class="ft-plus-square icon-bg-circle bg-cyan"></i></div>
            <div class="media-body">
              <h6 class="media-heading">Tienes un nuevo pedido!</h6>
              <p class="notification-text font-small-3 text-muted">Lorem ipsum dolor sit amet, consectetuer elit.</p><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">30 min ago</time></small>
            </div>
          </div>
        </a>
        <a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left valign-middle"><i class="ft-download-cloud icon-bg-circle bg-red bg-darken-1"></i></div>
            <div class="media-body">
              <h6 class="media-heading red darken-1">Aprovaci&oacute;n Actividad</h6>
              <p class="notification-text font-small-3 text-muted">Aliquam tincidunt mauris eu risus.</p><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">5 horas ago</time></small>
            </div>
          </div>
        </a>
        <a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left valign-middle"><i class="ft-alert-triangle icon-bg-circle bg-yellow bg-darken-3"></i></div>
            <div class="media-body">
              <h6 class="media-heading yellow darken-3">Aprovaci&oacute;n de Actividad</h6>
              <p class="notification-text font-small-3 text-muted">Vestibulum auctor dapibus neque.</p><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Hoy</time></small>
            </div>
          </div>
        </a>
        <a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left valign-middle"><i class="ft-check-circle icon-bg-circle bg-cyan"></i></div>
            <div class="media-body">
              <h6 class="media-heading">Aprovaci&oacute;n Materal</h6><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Semana Pasada</time></small>
            </div>
          </div>
        </a>
        <a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left valign-middle"><i class="ft-file icon-bg-circle bg-teal"></i></div>
            <div class="media-body">
              <h6 class="media-heading">Aprovaci&oacute;n Lengua</h6><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Mes pasado</time></small>
            </div>
          </div>
        </a>
      </li>
      <li class="dropdown-menu-footer">
        <a href="notificacion.jsp" class="dropdown-item text-muted text-xs-center">Leer todas las notificaciones</a>
      </li>
    </ul>
  </li> -->
<!--   <li class="dropdown dropdown-notification nav-item">
    <a href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i class="ficon ft-mail"></i>
      <span class="tag tag-pill tag-default tag-warning tag-default tag-up">3</span>
    </a>
    <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
      <li class="dropdown-menu-header">
        <h6 class="dropdown-header m-0">
          <span class="grey darken-2">Messages</span>
          <span class="notification-tag tag tag-default tag-warning float-xs-right m-0">4 New</span>
        </h6>
      </li>
      <li class="list-group scrollable-container"><a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left"><span class="avatar avatar-sm avatar-online rounded-circle"><img src="../app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span></div>
            <div class="media-body">
              <h6 class="media-heading">Margaret Govan</h6>
              <p class="notification-text font-small-3 text-muted">I like your portfolio, let's start the project.</p><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Today</time></small>
            </div>
          </div></a><a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left"><span class="avatar avatar-sm avatar-busy rounded-circle"><img src="../app-assets/images/portrait/small/avatar-s-2.png" alt="avatar"><i></i></span></div>
            <div class="media-body">
              <h6 class="media-heading">Bret Lezama</h6>
              <p class="notification-text font-small-3 text-muted">I have seen your work, there is</p><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Tuesday</time></small>
            </div>
          </div></a><a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left"><span class="avatar avatar-sm avatar-online rounded-circle"><img src="../app-assets/images/portrait/small/avatar-s-3.png" alt="avatar"><i></i></span></div>
            <div class="media-body">
              <h6 class="media-heading">Carie Berra</h6>
              <p class="notification-text font-small-3 text-muted">Can we have call in this week ?</p><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">Friday</time></small>
            </div>
          </div></a><a href="javascript:void(0)" class="list-group-item">
          <div class="media">
            <div class="media-left"><span class="avatar avatar-sm avatar-away rounded-circle"><img src="../app-assets/images/portrait/small/avatar-s-6.png" alt="avatar"><i></i></span></div>
            <div class="media-body">
              <h6 class="media-heading">Eric Alsobrook</h6>
              <p class="notification-text font-small-3 text-muted">We have project party this saturday night.</p><small>
                <time datetime="2015-06-11T18:29:20+08:00" class="media-meta text-muted">last month</time></small>
            </div>
          </div></a></li>
      <li class="dropdown-menu-footer"><a href="javascript:void(0)" class="dropdown-item text-muted text-xs-center">Read all messages</a></li>
    </ul>
  </li> -->

  <li class="nav-item">
  	<c:set var="listaPerfilesUsu" value="${usuarioSesion.lstUsuarioPerfil}"/>
  	<c:choose>
		<c:when test="${(totalPerfiles>0) and (totalPerfiles==1)}">
			<%-- <span class="form-control"
				  style="margin-top: 12px;margin-right: 10px;border: 0px;font-weight: bold;">
				  ${listaPerfilesUsu[0].perfil.nombrePerfil}
			</span> --%>
			<div style="padding: 20px 10px;font-weight: bold;">${listaPerfilesUsu[0].perfil.nombrePerfil}</div>
		</c:when>
		<c:otherwise>
			<select id="cboPerfilSesionActual"
					name="cboPerfilSesionActual"
					class="form-control"
					style="margin-top: 10px;margin-right: 10px"
					onchange="obtenerAccesos()">
		        <c:forEach var="usuarioPerfil" items="${listaPerfilesUsu}">
		        	<option <c:if test="${usuarioPerfil.perfil.codigoPerfil==usuarioSesion.codPerfilUsuSelec}">selected</c:if>
				            value="${usuarioPerfil.perfil.codigoPerfil}">
				            ${usuarioPerfil.perfil.nombrePerfil}
		        	</option>
		        </c:forEach>
		    </select>
		</c:otherwise>
	</c:choose>
  </li>
	
	

  <li class="dropdown dropdown-user nav-item" style="padding: 5px;">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link dropdown-user-link">
      <!-- <span class="avatar avatar-online"><img src="../app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span> -->
      <span class="user-name">${usuarioSesion.persona.nombreCompleto}</span>
    </a>
    <div class="dropdown-menu dropdown-menu-right">
    <!-- <a href="#" class="dropdown-item"><i class="ft-user"></i> Modificar Perfil</a> -->
    <a href="${pageContext.request.contextPath}/usuarioController/cambiarPassUsuario" class="dropdown-item"><i class="fa fa-key"></i> Cambiar de contrase&ntilde;a</a>
      <div class="dropdown-divider"></div>
      <a onclick="javascript:confirmarSalirSistema('�Desea cerrar sesi�n?','${pageContext.request.contextPath}/logoutController/cerrarSesion')" href="#" class="dropdown-item"><i class="ft-power"></i> Cerrar sesi&oacute;n</a>
      <!-- <a href="login-admin.jsp" class="dropdown-item"><i class="ft-power"></i> Cerrar Sesi&oacute;n</a> -->
    </div>
  </li>
</ul>
<input type="hidden" id="url_base-proyecto" value="${pageContext.request.contextPath}">

<!-- BEGIN BOWSER JS-->
<script src="${pageContext.request.contextPath}/app-assets/js/scripts/bowser/bowser.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/soportar-navegador.js" type="text/javascript"></script>
<!-- END BOWSER JS-->


<script type="text/javascript" charset="utf-8" >

	function confirmarSalirSistema(msg,url) {

		window.location.href=url;

	};

	function obtenerAccesos() {

		var codperfil = $('#cboPerfilSesionActual').val();

		  $.ajax({
		    type: "GET",
		    url: "${pageContext.request.contextPath}/inicioController/obtenerAccesos?codperfil="+codperfil,
		    success: function(){
		    	//location.reload();
		    	location.href='${pageContext.request.contextPath}/inicioController/listar';
		    },error: function(xhr,status,er) {
	            console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	console.log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    		console.log(er);
		    		//spire_session_901(er);
     			}
		    }
		  });
	}

	function doPost(path, params, method) {
        method = method || "post";

        var form = document.createElement("form");

        form._submit_function_ = form.submit;

        form.setAttribute("method", method);
        form.setAttribute("action", path);

        for(var key in params) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
        }

        document.body.appendChild(form);
        form._submit_function_();
    }

	function modificarElementoGenerico(url, idElemento){
		var urlComplete = document.getElementById('url_base-proyecto').value + url;
		doPost(urlComplete, { codigo : idElemento } );
	}

	
</script>


