<div id="info-modal-index" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" data-backdrop="static" data-keyboard="false" >
  <div class="modal-dialog" role="document" style="width: 30%;margin-top: 30px;">
    <div class="modal-content">
	    <div class="modal-header">
       <a id="close-modal" href="#" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a> 
	        <section class="text-center">
				<i class="icon-hourglass"></i>
	        	<h3 id="tituloTiempoCaducadoEva">Tiempo caducado</h3>
	        </section>
	    </div>
    	<div class="modal-body">
    		        <div class="caption">
    		  <div id="msgNota" class="col-md-12" style="text-align: center;color: #5cb85c;font-weight: bolder;font-size: 22px;"></div>
              <h2 style="text-align: center;" id="tituloPuntuacionFin">Puntuación Final</h2>
             <div style="text-align: center"><b style="font-size: 23px;color: #ff4d4c;" id="notaF1"></b></div>
              
            </div>
            <div class="modal-footer" style="text-align: left">
           <div class="progress">
    <div id="procen" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" ><!-- style="width:40%" -->
      
    </div>
			  </div>
			  <div class="row row-bottom-padded-md">
					<div class="col-md-12">
						<div class="row">
				 
                <div class="col-md-6"><small id="tituloHoraIniCad">Hora Inicio</small><br/><b id="horIni"></b></div>
                <div class="col-md-6"><small id="tituloHoraFinCad">Hora Termino</small><br/><b id="horFin"></b></div>
                               
				<div class="col-md-6"><small id="tituloResultFinCad">Resultado Final</small><br/><b id="totalEjerc"></b></div>             
               	
               	<div class="col-md-4"><small id="tituloNotaCad">Nota Final</small><br/><b id="notaF"></b></div>
						
						</div></div></div>
         <!--      <div class="row">
              
              </div> -->
            </div>
    		<footer class="text-center">
				<!-- <button type="button" class="btn btn-primary" id="tituloContinuarCad">Continuar</button> -->
				<button type="button" class="btn btn-primary icon-arrow" id="tituloContinuarCad">
					<i class="icon-arrow-right2"></i>
				</button>
    		</footer>
    	</div>
    </div>
  </div>
</div>
<style>
.row-fluid .span4{
    width: 31.623931623931625%;
    margin-left: 0;
}
</style>
<script type="text/javascript" charset="utf-8">
	/*window.onload = function() {
		traducirModalEvaluacionCaducado();
		//console.log('prueba caducado');
	};*/
	var context=$('#contexturl').val();
	function modal_info(){
		
		$('#info-modal-index').modal("show");
		traducirModalEvaluacionCaducado();
		//console.log('prueba caducado');

	}

	$('#tituloContinuarCad').click(function(){
		//debugger;
		if(parseInt($('#notaObtenida').val()) < parseInt($('#notaMinima').val())){
			
		pasarHistorico();
		$('#notaObtenida').val('0');
		if($('#tm2TipoEvaluacion').val() == 2){
			//alert("Nueva evaluacion final");
			insertarEvaluacionFinal();
			}
		}else{
			
			$('#notaObtenida').val('0');
			calcularPromedio();
			//$(location).attr('href',context+'/lengua/detalle/'+$('#codigoLengua').val());		
			}
	});

</script>