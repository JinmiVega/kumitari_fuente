<%@ page contentType="text/html; charset=UTF-8" %>
<div id="info-info-correcta-modal-index" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" data-backdrop="static" data-keyboard="false"  >
<div id="info-modal-index1" >
  <div class="modal-dialog" role="document" style="width: 30%;margin-top: 30px;">
    <div class="modal-content">
	    <div class="modal-header-info">
       <a id="close-modal" href="#" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a> 
	        <section class="text-center">
				<i class="fa fa-spinner fa-pulse fa-3x fa-fw" style="color: white"></i>
	        	<h3 style="color: white" id="tituloEvaluacionCon">Evaluación Concluida</h3>
	        </section>
	    </div>
    	<div class="modal-body">
    		        <div class="caption">
    		  <div id="msgNota1" class="col-md-12" style="text-align: center;color: #5cb85c;font-weight: bolder;font-size: 22px;"></div>
              <h2 style="text-align: center;" id="tituloPuntuacion">Puntuacion Final</h2>
             <div style="text-align: center"><b style="font-size: 23px;color: #ff4d4c;" id="notaF11"></b></div>
              
            </div>
            <div class="modal-footer" style="text-align: left">
           <div class="progress">
    <div id="procen1" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" ><!-- style="width:40%" -->
      
    </div>
			  </div>
			  <div class="row row-bottom-padded-md">
					<div class="col-md-12">
						<div class="row">
				 
                <div class="col-md-6"><small id="tituloHoraIni">Hora Inicio</small><br/><b id="horIni1"></b></div>
                <div class="col-md-6"><small id="tituloHoraFin">Hora Termino</small><br/><b id="horFin1"></b></div>
                               
				<div class="col-md-6"><small id="tituloResultadoFin">Resultado Final</small><br/><b id="totalEjerc1"></b></div>            
               	
               	<div class="col-md-4"><small id="tituloNotaFin">Nota Final</small><br/><b id="notaF12"></b></div>
						
						</div></div></div>
         <!--      <div class="row">
              
              </div> -->
            </div>
    		<footer class="text-center">
				<button type="button" class="btn btn-info" id="tituloFinalizar" >Finalizar</button>
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
	traducirModalEvaluacion();
	traducirModalEvaluacionCaducado();
	//console.log('prueba Correcta');
};

var context=$('#contexturl').val();
function sacarporcentajexnumero1(val,val2) {
	var num=val;
	var num2=val2;
	
	var num3=num2*100/num;
	//console.log("num3.toPrecision(2) "+num3.toPrecision(2));
	$('#procen1').text(num3.toPrecision(2)+'% Correcto');
	$('#procen1').css('width', num3+'%');
	$('#procen1').attr('aria-valuenow', num3);
	
}

function cargar_MsjxNota1(imgmed,nomPre){
	var nomimg =context+'/premio/'+imgmed;
	var nombrePre =nomPre
	var tipomsj="";
	if ($('#notaF11').text()>=11) {
		tipomsj=9;
		modal_premio_evaluacion(nomimg,nombrePre);
	}else {
		tipomsj=8;
	}
	//console.log("tipomsj:: "+ tipomsj);
	var idcodeval   = $('#codlenguaTreeVal').val();//$('#codEvaluacion').val();
	var url      = context+'/lengua/obtenerLstEvaluacionxMsjNota';


	$.ajax({ 
		async: true,
		type : "GET",
		data : {p_codLengua : idcodeval,p_codTipoMsj:tipomsj},
		url  : url,
		success : function(data){
			if(data!=null){
				//console.log("data:: "+ data);
				//console.log("data[0].mensajes "+data[0].mensajes);
			//	$('#msgNota1').text(data[0].mensajes);
				
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
 function cargar_modal_info_termino_datos(){
	
	var idcodeval  = $('#codEvaluacion').val();
	var url      = context+'/lengua/obtenerEvaluacionxCod';
//	debugger;

	$.ajax({
		 async: true,
		type : "GET",
		data : {p_codevalua : idcodeval},
		url  : url,
		success : function(data){
			if(data!=null){
				//console.log("data:: "+ data.vfechaini);
		    //    debugger;		
				$('#horIni1').text(data.vfechaini);
				$('#horFin1').text(data.vfechaactual);				
				$('#totalEjerc1').text(data.correctos +' / '+data.totalEjercicio);
				//$('#correcErrad').text(data.correctos +'/'+ data.erradas);
				$('#notaF11').text(data.nota);
				$('#notaF12').text(data.nota);	

				$('#notaObtenida').val(data.nota);	
				
				sacarporcentajexnumero1(data.totalEjercicio,data.correctos);
				cargar_MsjxNota1(data.medalla.imagenNombre,data.medalla.nombre); 
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
	
 
 	
	function modal_info_correcta_evaluacion(){				
		$('#info-info-correcta-modal-index').modal("show");
		cargar_modal_info_termino_datos();
		
	}
	
	$('#tituloFinalizar').click(function(){
		//console.log("tituloFinalizar");
	//	debugger;
		localStorage.setItem("TiempoExamen",0);
		//alert($('#notaObtenida').val());
		if(parseInt($('#notaObtenida').val()) < parseInt($('#notaMinima').val())){		
			//alert("pasar historico");
			pasarHistorico();
			$('#notaObtenida').val('0');
			if($('#tm2TipoEvaluacion').val() == 2){
				//alert("Nueva evaluacion final");
				insertarEvaluacionFinal();
				}
			}else{
				//if($('#codSubNivel').val() )
				$('#notaObtenida').val('0');
			   	 calcularPromedio();
				 //$(location).attr('href',context+'/lengua/detalle/'+$('#codigoLengua').val()); 
				}
		
		});
</script>