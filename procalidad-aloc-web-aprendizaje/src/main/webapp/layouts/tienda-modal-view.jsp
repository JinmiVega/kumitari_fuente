<div id="modal-tienda-app" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
		<div id="nav-modal-minendu">
			<ul class="nav nav-pills nav-stacked">
				<li class="nav-item carousel-item active">
					<a onclick="cargarContenidoTienda(1)" class="nav-link active" id="base-pill1" data-toggle="pill" href="#pill1" aria-expanded="true"><i class="icon-minedu-icono-mascotas"></i> <div id="tituloMascota">Mascota</div></a>
				</li>
				<li class="nav-item">
					<a onclick="cargarContenidoTienda(2)" class="nav-link" id="base-pill2" data-toggle="pill" href="#pill2" aria-expanded="false"><i class="icon-minedu-icono-fondos"></i> <div id="tituloFondo">Fondos</div></a>
				</li>
				 <li class="nav-item">
					<a onclick="cargarContenidoTienda(3)" class="nav-link" id="base-pill3" data-toggle="pill" href="#pill3" aria-expanded="false"><i class="icon-minedu-icono-combos"></i> <div id="tituloCombo">Combos</div></a>
				</li>
				<!-- <li class="nav-item">
					<a onclick="cargarContenidoTienda(4)" class="nav-link" id="base-pill4" data-toggle="pill" href="#pill4" aria-expanded="false"><i class="icon-minedu-icono-bonus"></i> <div id="tituloBonus">Bonus</div></a>
				</li> -->
			</ul>
		</div>
		<div id="content-modal-minendu">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="tituloTienda">Tienda</h3>
		  </div>
		  <div class="modal-body">
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="pill1" aria-expanded="true" aria-labelledby="base-pill1">
					<div class="row" id="idRowContentMascota">

					</div>
				</div>
				<div class="tab-pane" id="pill2" aria-labelledby="base-pill2">
					<div class="row" id="idRowContentFondo">

					</div>
				</div>
				<div class="tab-pane" id="pill3" aria-labelledby="base-pill3">
					<div class="row" id="idRowContentCombos">

					</div>
				</div>
				<div class="tab-pane" id="pill4" aria-labelledby="base-pill4">
					<div class="row" id="idRowContentBonos">

					</div>
				</div>
				
				<div class="tab-pane" id="pill4" aria-labelledby="base-pill4">
					<div class="row" id="idRowContentBonus">
						<div class="col-md-4">
							<div class="item-tienda">
								<div class="item-img-tienda">
									<img src="${pageContext.request.contextPath}/assets/images/items/no-disponible.jpg" class="img-responsive" alt="">
								</div>
								<div class="item-info-tienda">
									<ul>
										<li class="pull-right"> <button type="button" disabled class="btn btn-sm btn-item-comprar" id="tituloComprar">Comprar</button> </li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="item-tienda">
								<div class="item-img-tienda">
									<img src="${pageContext.request.contextPath}/assets/images/items/no-disponible.jpg" class="img-responsive" alt="">
								</div>
								<div class="item-info-tienda">
									<ul>
										<li class="pull-right"> <button type="button" disabled class="btn btn-sm btn-item-comprar" id="tituloComprar">Comprar</button> </li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="item-tienda">
								<div class="item-img-tienda">
									<img src="${pageContext.request.contextPath}/assets/images/items/no-disponible.jpg" class="img-responsive" alt="">
								</div>
								<div class="item-info-tienda">
									<ul>
										<li class="pull-right"> <button type="button" disabled class="btn btn-sm btn-item-comprar" id="tituloComprar">Comprar</button> </li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		  </div>
		</div>

    </div>
  </div>
</div>