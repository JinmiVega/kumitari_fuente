<%@ page contentType="text/html; charset=UTF-8" %>
<div id="info-empezar-modal-index" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" data-backdrop="static" data-keyboard="false" >
<div id="info-modal-index" >
  <div class="modal-dialog modal-sm" role="document" style="">
    <div class="modal-content">
	    <div class="modal-header-success">
       <a id="close-modal" href="#" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a> 
	        <section class="text-center">
				<i class="fa fa-check-square-o fa-5x"></i>
	        	<h3 id="tituloEvalIni">Evaluación</h3> 
	        </section>
	    </div>
    	<div class="modal-body">
    		        <div class="caption">
    		  <!-- <div id="msgNota" class="col-md-12" style="text-align: center;color: #5cb85c;font-weight: bolder;font-size: 22px;"></div> -->
              <!-- <h2 style="text-align: center;"></h2> -->
             <!-- <div style="text-align: center"><b style="font-size: 23px;color: #ff4d4c;" id="notaF1"></b></div> -->
              
            </div>
            <div class="modal-footer" style="text-align: left">
<!--            <div class="progress">
    <div id="procen" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" >style="width:40%"
      
    </div>
			  </div> -->
			  <div class="row row-bottom-padded-md">
					<div class="col-md-12">
						<div class="row">
				 
                <div class="col-md-12"><small id="tituloHoraIniEva">Hora Inicio</small><br/><b id="horIni"></b></div>
                <!-- <div class="col-md-6"><b id="horFin"></b><br/><small>Hora Termino</small></div> -->
                               
				<div class="col-md-12"><small id="tituloTotalEje">Total de Ejercicios :</small><br/><b id="totalEjerc"></b></div>
                <!-- <div class="col-md-4"><b id="correcErrad"></b><br/><small>Correc./Erra.</small></div>              
               	
               	<div class="col-md-4"><b id="notaF"></b><br/><small>Nota Final</small></div> -->
						
						</div></div></div>
         <!--      <div class="row">
              
              </div> -->
            </div>
    		<footer class="text-center">
				<a id="emEval1" onclick="actulizarEvaluacion();" class="btn btn-success">Empezar</a><%--  href="${pageContext.request.contextPath}/lengua/${lenguaBean.codigo}/evaluacion/${evaluacionBean.codigo}" --%>
    		</footer>
    	</div>
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

window.onload = function() {
	traducirModalEvaluacionInicio();
	//console.log('prueba Empezar');
};

var context=$('#contexturl').val();
function cargar_modal_info_empezar_datos(valor,valorEncrypt,valor2,valor2Encrypt){
	//console.log("valor..."+valor);
	var idcodeval   = valor;
	var url      = context+'/lengua/obtenerEvaluacionxCod';


	$.ajax({
		 async: true,
		type : "GET",
		data : {p_codevalua : idcodeval},
		url  : url,
		success : function(data){
			if(data!=null){
				//console.log("data.vfechaactual:: "+ data.vfechaactual);
				$('#horIni').text(data.vfechaactual);
				$('#totalEjerc').text(data.totalEjercicio);
				$('#emEval1').attr('href',context+'/lengua/'+valor2Encrypt+'/evaluacion/'+valorEncrypt);
			}else{
				//console.log('null');
			}
		},
		error: function(xhr,status,er) {
			//console.log("error: " + xhr + " status: " + status + " er:" + er);
		    if(xhr.status==500) {
		    	//console.log(er);
		    }
		    if(xhr.status==901) {
		    	//console.log(er);
		    }
	   }
	});
}
	function modal_info_empezar(val,valEncrypt,val2,val2Encrypt){
		
		$('#info-empezar-modal-index').modal("show");
		
		cargar_modal_info_empezar_datos(val,valEncrypt,val2,val2Encrypt);
	}
	function actulizarEvaluacion(){		
		localStorage.setItem('TEXTO-PARRAFO-RELOAD', '0');
		localStorage.setItem('PARTES-DOCUMENTO', '0');
		var p_codeva      = $("#codEvaluacion").val();  	
		var p_tm1siteva = 2;
		 
		var url      = context+'/lengua/actulizarEvaluacion';
		//showLoad();
		$.ajax({
			 async: true,
			type : "POST",
			data : {p_codeva : p_codeva,
					p_tm1siteva:p_tm1siteva},
			url  : url,
			success : function(data){
				 if (data != 0) {
					//console.log("data != 0");
				}else{
					//console.log("data == null");
				}
			},
			error: function(xhr,status,er) {
				//console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			    }
			    if(xhr.status==901) {
			    	//console.log(er);
			    }
		   },
		   complete : function(){
			  
		   }
		});
	}
		

</script>