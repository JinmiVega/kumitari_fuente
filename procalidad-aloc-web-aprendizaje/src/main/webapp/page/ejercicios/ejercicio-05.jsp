<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!-- ejercicio-05 -->
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
					<h4 class="sub-title-app">Pantasqa simi allinchanapaq</h4>
					<p class="title-minendu ttpregunta" id="title-preg">Pusuquy llaqta</p>
				</div>
			</div>
			<div class="row">
			  <div class="col-md-12">
				<p class="font-text">
					<select name="" class="select-app">
					 	<option value="">Posoqoy</option>
					 	<option value="">Posoqoy</option>
					 </select> llaqtaqa quñi pacham. Tayta
					 <select name="" class="select-app">
					 	<option value="">entipas</option>
					 	<option value="">entipas</option>
					 </select> allintam kankan. Chaymantam
					 <select name="" class="select-app">
					 	<option value="">ronakunapas</option>
					 	<option value="">ronakunapas</option>
					 </select>,
					 <select name="" class="select-app">
					 	<option value="">oywakunapas</option>
					 	<option value="">oywakunapas</option>
					 </select>,
					 <select name="" class="select-app">
					 	<option value="">kurakunapas</option>
					 	<option value="">kurakunapas</option>
					 </select>
					 , quñi kasqanmanta kawsarikunku.
					Pusuquy llaqtapiqa kay kawsaykunan wiñan: sapallu, hawinka, purutukuna, trigo, sara. Miski ruruq
					hatun sachakunapas kallantaq: chirimuya, durazno, peras, pakay. Huchuy qurakunapas qillu uchu,
					pipinillu, tumati ima wiñan. Chaynataq tunaspas kallanpuni.
					Hinallataq, lima quwi, luru, kawra uywakunapas kawsanku. Sachakunapas, tara, mulli, hinallataq
					wira chillka, muqu muqu, chamana ima wiñan.
					Chaynam Pusuquy llaqtaqa. Qampapas, ñuqapapas, paypapas llaqtanchikqa sutiyuqmi.
				</p>
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


<script src="${pageContext.request.contextPath}/assets/js/page/relacionar-img.js" type="text/javascript"></script>