<div id="modal-premio-app" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

		    <a id="close-modal" href="#" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a>

		<div id="nav-premio-minendu">
			<ul class="nav nav-pills nav-stacked">
				<li class="nav-item active">
					<a class="nav-link active" onclick="cargarContenidoPremio(5,'base-mvict')"  id="base-mvict" data-toggle="pill"  href="#mvict" aria-expanded="true"> <div id="tituloMedalla">Medallas</div></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" onclick="cargarContenidoPremio(1,'base-masc')" id="base-masc" data-toggle="pill" href="#masc" aria-expanded="false" > <div id="tituloMascotaPremio">Mascotas</div></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" onclick="cargarContenidoPremio(2,'base-fdpanta')" id="base-fdpanta" data-toggle="pill" href="#fdpanta" aria-expanded="false" > <div id="tituloFondoPantalla">Fondos de Pantalla</div></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" onclick="cargarContenidoPremio(4,'base-bono')" id="base-bono" data-toggle="pill" href="#bono" aria-expanded="false" > <div id="tituloBono">Bonos</div></a>
				</li>
				<!-- <li class="nav-item">
					<a class="nav-link"  id="base-miBonus" data-toggle="pill" href="#miBonus" aria-expanded="false" > <div id="tituloMiBonus">Mi Bonus</div></a>
				</li> -->
				<span class="ajaxEfect">
					<div class="main-ajax" style="display: none;">
						<div class="preloader"></div>
						<i class="icon-minedu-kumitsari"></i>
					</div>
				</span>
			</ul>
		</div>
		<div id="content-premio-minendu">
		  <div class="modal-body">
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="mvict" aria-expanded="true" aria-labelledby="base-mvict">
					<div class="tab-medalla" style="width: 100%">

						<div id="gp_medallas_victoriosa" class="carousel slide three_shows_one_move gp_medallas_carousel_wrapper" data-ride="carousel" data-interval="2000">

							<div class="gp_medallas_carousel_header">
								<span id="1"><div id="tituloMedallaBasica">Medallas B&aacute;sicas</div></span>
							</div>

							<!--========= Wrapper for slides =========-->
							<div class="carousel-inner" role="listbox" id="medallasVictoriosas" style="width: 100%">

								<div class="item active" style="display: none">
									<div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image" onclick="show_detalle_moneda()"><img src="${pageContext.request.contextPath}/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></div></div></div>
								</div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></div></div></div></div>
							</div>

							<!--======= Navigation Buttons =========-->

							<!--======= Left Button =========-->
							<a class="left carousel-control gp_products_carousel_control_left" href="#gp_medallas_victoriosa" role="button" data-slide="prev">
								<span class="fa fa-angle-left gp_products_carousel_control_icons" aria-hidden="true"></span>
								<span class="sr-only" >Previous</span>
							</a>

							<!--======= Right Button =========-->
							<a class="right carousel-control gp_products_carousel_control_right" href="#gp_medallas_victoriosa" role="button" data-slide="next">
								<span class="fa fa-angle-right gp_products_carousel_control_icons" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>

						</div>

						<div id="gp_medallas_honorifica" class="carousel slide three_shows_one_move gp_medallas_carousel_wrapper" data-ride="carousel" data-interval="2000">

							<div class="gp_medallas_carousel_header">
								<span id="2"><div id="tituloMedallaHonorifica">Medallas Honor&iacute;ficas</div></span>
							</div>

							<!--========= Wrapper for slides =========-->
							<div class="carousel-inner" role="listbox" id="medallasHonorificas">
							 	<div class="item active" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="${pageContext.request.contextPath}/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
							</div>

							<!--======= Navigation Buttons =========-->

							<!--======= Left Button =========-->
							<a class="left carousel-control gp_products_carousel_control_left" href="#gp_medallas_honorifica" role="button" data-slide="prev">
								<span class="fa fa-angle-left gp_products_carousel_control_icons" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a>

							<!--======= Right Button =========-->
							<a class="right carousel-control gp_products_carousel_control_right" href="#gp_medallas_honorifica" role="button" data-slide="next">
								<span class="fa fa-angle-right gp_products_carousel_control_icons" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>

						</div>

						<div id="gp_medallas_premium" class="carousel slide three_shows_one_move gp_medallas_carousel_wrapper" data-ride="carousel" data-interval="2000">

							<div class="gp_medallas_carousel_header">
								<span id="3"><div id="tituloMedallaPremium">Medallas Premium</div></span>
							</div>

							<!--========= Wrapper for slides =========-->
							<div class="carousel-inner" role="listbox" id="medallasPremium">
								  <div class="item active" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="${pageContext.request.contextPath}/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
								<div class="item" style="display: none"><div class="col-xs-12 col-sm-4 col-md-4 gp_products_item"><div class="gp_medallas_inner"><div class="gp_medallas_item_image"><a href="#" onclick="show_detalle_moneda()"><img src="/procalidad-natigu-web-gestion/premio/basico loro.png" alt="basico loro.png" class="img-responsive img-circle"></a></div></div></div></div>
							</div>

							<!--======= Navigation Buttons =========-->

							<!--======= Left Button =========-->
							<a class="left carousel-control gp_products_carousel_control_left" href="#gp_medallas_premium" role="button" data-slide="prev">
								<span class="fa fa-angle-left gp_products_carousel_control_icons" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a>

							<!--======= Right Button =========-->
							<a class="right carousel-control gp_products_carousel_control_right" href="#gp_medallas_premium" role="button" data-slide="next">
								<span class="fa fa-angle-right gp_products_carousel_control_icons" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>

						</div>
					</div>

					<div id="md-detalle-medalla" style="display: none">
						<div class="row">
							<div class="col-md-6">
								<img src="${pageContext.request.contextPath}/assets/images/recompensas/MEDALLA-VICTORIOSA.png" alt="">
							</div>
							<div class="col-md-6 info-head-detalle">
								<p>Tipo: <span>Premio</span></p>
								<p>Motivo: <span>Wiracocha</span></p>
								<p>Cultura: <span>Incaica</span></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 box-btn-content">
								<button class="btn btn-sm btn-gris">Agregar</button>
								<button class="btn btn-sm btn-gris">Descargar</button>
								<button class="btn btn-sm btn-gris">Imprimir</button>
							</div>
							<div class="col-md-12">
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p>Wiracocha  es  el  gran  dios,  el  creador  en  la  mitoligía  pre-Inca  e  Inca  en  la
								región  andina  de  América  del  Sur.  Su  nombre  completo  es  Apu  Qun  Tiqsi
								Wiraqucha y Con-Tici (también deletreado Kon-Tiki) Wiracocha.</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<button id="btn_regresar_modal_tab" onclick="hide_detalle_moneda()" type="button" class="btn btn-sm btn-link"><i class="fa fa-angle-left"></i> Atras</button>
							</div>
						</div>
					</div>

				</div>
				<div class="tab-pane" id="masc" aria-labelledby="base-masc">

				</div>
				<div class="tab-pane" id="fdpanta" aria-labelledby="base-fdpanta">

				</div>
				<div class="tab-pane" id="miBonus" aria-labelledby="base-bono">

				</div>
			</div>
		  </div>
		</div>

    </div>
  </div>
</div>
<script type="text/javascript" charset="utf-8">
	traducirPremios();
	function traducirPremios(){

		$("#tituloMascotaPremio").html($("#trad_3").val());
		$("#tituloFondoPantalla").html($("#trad_16").val());

		$("#tituloMedalla").html($("#trad_15").val());
		$("#tituloFondoPantalla").html($("#trad_16").val());
		$("#tituloMiBonus").html($("#trad_17").val());

		$("#tituloMedallaBasica").html($("#trad_18").val());
		$("#tituloMedallaHonorifica").html($("#trad_19").val());
		$("#tituloMedallaPremium").html($("#trad_20").val());
	}
</script>