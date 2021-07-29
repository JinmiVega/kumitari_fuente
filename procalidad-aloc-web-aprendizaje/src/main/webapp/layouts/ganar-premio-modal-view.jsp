<%@ page contentType="text/html; charset=UTF-8" %>
<div id="premio-ganar-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div id="cont-premio">
			<img src="${pageContext.request.contextPath}/assets/images/recompensas/medalla-vicotoriosa-small.png" class="img-responsive" alt="">
    	</div>
		<div id="text-premio">
			<h4 id="msjFelicidadesGP">¡Felicidades!</h4>
			<p id="msjObtMedGP">Obtuvistes una medalla de colección <br>
			 victoriosa del <b>Dios Wiracocha</b>
			</p>
		</div>
		<div id="baul-premio">
			<img src="${pageContext.request.contextPath}/assets/images/items/cofre.png" class="img-responsive" alt="">
		</div>
		<div id="box-continuar-premio" class="text-center">
			<div id="link-salir">
				<span class="fa fa-angle-right"></span>
				<p id="tituloContinuarGP">Continuar</p>
			</div>
		</div>
    </div>
  </div>
</div>

<script type="text/javascript" charset="utf-8">
window.onload = function() {
	traducirModalMed();
};
	
</script>