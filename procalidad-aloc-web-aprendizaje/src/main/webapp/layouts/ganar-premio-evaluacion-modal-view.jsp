<%@ page contentType="text/html; charset=UTF-8" %>
<div id="premio-ganar-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div id="cont-premio">
			 <!-- <img id="imgmedalla" src="" class="img-responsive" alt=""> -->
    	</div>
		<div id="text-premio">
			<h4 style="color: red;" id="msjFelicidadesGPEva">¡Felicidades!</h4>
			<p style="color: white;" id="msjObtMedGPEva">Obtuvistes una medalla de colección <br>
			 victoriosa del <b id="nombrePre">Dios Wiracocha</b>
			</p>
		</div>
		<div id="baul-premio">
			<%-- <img src="${pageContext.request.contextPath}/assets/images/items/cofre.png" class="img-responsive" alt=""> --%>
			<img id="imgmedalla" src="" class="img-responsive" alt="" width="35%">
		</div>
		<div id="box-continuar-premio" class="text-center">
			<div id="link-salir">
				<span class="fa fa-angle-right"></span>
				<p id="tituloContinuarGPEva">Continuar</p>
			</div>
		</div>
    </div>
  </div>
</div>

<script type="text/javascript" charset="utf-8">
	
	window.onload = function() {
		traducirModalMedEva();
	};
	function modal_premio_evaluacion(nomimg,nomP){
		traducirModalMedEva();
		//console.log('nomimg111 '+ nomimg);
		$('#premio-ganar-modal').modal("show");
		$('#imgmedalla').attr('src', nomimg);
		$('#imgmedalla').attr('alt', nomimg);
		$('#nombrePre').text(nomP);
		
	}
</script>