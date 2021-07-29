<div class="modal fade" id="item_detalle_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  	<div class="modal-dialog" role="document">
    	<div class="modal-content">
      		<div class="modal-body">
				<div class="row">
					<input type="hidden" id="codigoArticulo" value="" />
					<input type="hidden" id="tipoArticulo" value="" />
					<input type="hidden" id="cantidadMonedas" value="" />
					<div class="col-md-6">
						<div class="item-tienda">
							<div class="item-img-tienda">
								<img src="${pageContext.request.contextPath}/assets/images/mascota/mascota-01.png" class="img-responsive" alt="" id="tiendaImagenDetalle">
							</div>
						</div>
					</div>
					<div class="col-md-6 text-center">
						<h3>¿Deseas comprar este artículo?</h3>
						<span class="item-precio-icon" id="precio"><i class="icon-minedu-precio"></i> 100</span>
						<button type="button" class="btn btn-sm btn-item-comprar" onclick="realizarCompra();" data-dismiss="modal" id="tituloComprar">Comprar</button>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="item-tienda">
						
		
						</div>
		      		</div>
		      	</div>
    		</div>
  		</div>
	</div>
</div>
