<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- ejercicio-07 -->
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
				<div class="col-md-12">
					<h4 class="sub-title-app">Masachay</h4>
					<p class="title-minendu ttpregunta" id="title-preg">Rimaykunapa mañakusqanta tinkuchiykuy</p>
				</div>
			</div>
			<div class="row">
			  <div class="col-md-4 col-xs-4">
			    <ul id="lst-preg-tti">
			    <li data-preg="1"><span>Llaqtapa sutin</span></li>
			    <li data-preg="2"><span>Kawsaykunapa sutin</span></li>
			    <li data-preg="3"><span>Uywakunapa sutin</span></li>
			    </ul>
			  </div>
			  <div class="col-md-4 col-xs-4">
			    <ul id="lst-resp-tti">
			    <li data-rsp="3"><span>Uwuha, waka, kawallu, asnu, llama, wikuña, taruka</span><span class="rspt"></span></li>
			    <li data-rsp="1"><span>Wankapampam</span><span class="rspt"></span></li>
			    <li data-rsp="2"><span>Papa, siwara, maswa, uqa, ulluku, tarwi, kiwna</span><span class="rspt"></span></li>
			    </ul>
			  </div>
			  <div class="col-md-4 col-xs-4">
			    <ul id="lst-resp-img">
			    <li data-rsp-img="2"><img src="${pageContext.request.contextPath}/assets/images/person1.jpg" alt="" class="img-responsive"><label class="rspt"></label><span class="rspt"></span></li>
			    <li data-rsp-img="3"><img src="${pageContext.request.contextPath}/assets/images/person2.jpg" alt="" class="img-responsive"><span class="rspt"></span></li>
			    <li data-rsp-img="1"><img src="${pageContext.request.contextPath}/assets/images/person3.jpg" alt="" class="img-responsive"><span class="rspt"></span></li>
			    </ul>
			  </div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="form-group text-center">
						<br>
						<a id="btnevaluar"
						   class="btn btn-primary icon-arrow btn-lg ${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'disabled' : ''}"
						   onclick="${usuarioEstudiante.codPerfilUsuSelec == 4 ? 'siguiente_ejercicio()' : 'siguiente_ejercicio()'}" >
						   <i class="icon-arrow-right2"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>


<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-texto-img.js" type="text/javascript"></script>