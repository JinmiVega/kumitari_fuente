<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- ejercicio-11 -->
	<div class="row row-bottom-padded-md">
		<div class="col-md-12 to-animate fondo-lectura fadeInUp animated">
			<div class="row">
				<div class="col-md-12">
					<nav id="pagination-leccion">
					<ul class="control-box pager">
						<li><a id="glosario-link" onclick="mostrarGlosario()" href="#">Glosario <i class="fa fa-sort-alpha-desc"></i></a></li>
						<li><a data-slide="prev" onclick="anterior_ejercicio()" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
						<li><a data-slide="next" onclick="siguiente_ejercicio()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li><a data-slide="next" href="#myCarousel" class="">
					</a></ul>
					</nav>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
			   		<div id="content-text-glosario" style="display: none;">
			   			<span id="content-icon-m">
			   				<i class="icon-notebook"></i>
			   			</span>
						<div id="textoGlosario"></div>
						<span class="close-conten" onclick="ocultarDivGlosario()"></span>
			   		</div>
				</div>
			</div>

			<div class="row">
			<input id="codigoMTE" type="hidden" value="${materialTipoEjercicioBean.codigo}">
			<input id="codLeccion" type="hidden" value="${materialTipoEjercicioBean.leccionMaterialBean.codigo}">
			<input id="codTipoEjer" type="hidden" value="${materialTipoEjercicioBean.tipoEjercicio.codigoRegistro}">
				<div class="col-md-12" id="titulos"> <!--

				--> </div>
			</div>
			<div class="row">
			  <div class="col-md-6 col-xs-6" id="pregunta2"> <!--

			    </ul> -->
			  </div>
			  <div class="col-md-6 col-xs-6" id="prueba"> <!--

			   --> </ul>

			  </div>

			  <div class="col-md-6 col-xs-6" id="prueba2">
			   <!-- <ul id="lst-resp-img">
				    <li data-rsp="3">
				    	<img src="${pageContext.request.contextPath}/assets/images/person1.jpg" alt="" class="img-responsive"><label class="rspt"></label>
				    </li>
				    <li data-rsp="1"><img src="${pageContext.request.contextPath}/assets/images/person2.jpg" alt="" class="img-responsive"><label class="rspt"></label>
				    </li>
				    <li data-rsp="2">
				    	<img src="${pageContext.request.contextPath}/assets/images/person3.jpg" alt="" class="img-responsive"><label class="rspt"></label>
				    </li> -->
			    </ul>
			  </div>

			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="form-group text-center">
						<br>
						<a id="btnevaluar"
						   class="btn btn-primary icon-arrow btn-lg ${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'disabled' : ''}"
						   onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'valor()' : 'siguiente_ejercicio()'}" >
						   <i class="icon-arrow-right2"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>


<script src="${pageContext.request.contextPath}/assets/js/actividad/RelacionVariada.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-texto.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-img.js" type="text/javascript"></script>

<script type="text/javascript">
	//window.onload = function() {
   		ListarcodMTP();
   		traducirSub();
	//};
</script>