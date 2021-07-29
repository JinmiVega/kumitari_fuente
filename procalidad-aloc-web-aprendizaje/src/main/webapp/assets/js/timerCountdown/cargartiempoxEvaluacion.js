/**
 * 
 */
window.setTimeout("init()",1500);
var  tiempoSegundos = 0;
var  tiempoAdicionalSegundos = 0;
	function convertirtiempo(){
		//alert('convertirtiempo');
		
		var result="";
			var id1=$('#idhora1').val();
	 		var id2=$('#idmin1').val();
	 		var id3=$('#idseg1').val();
	 		
	 		if (id1=='00') {
	 			id1=0;
			}
	 		if (id2=='00') {
	 			id2=0;
			}
	 		if (id3=='00') {
	 			id3=0;
			}
	 		
	 		var timepoHora =$('#timepoHora').val();
	 		var tiempoMinuto=$('#tiempoMinuto').val();
	 		var tiempoSegundo=$('#tiempoSegundo').val();

	 		if(id1 < timepoHora){
	 			id1 = 0;
	 		}else{
	 			id1 = id1 - timepoHora;
	 		}
	 		if(id2 < tiempoMinuto){
	 			id2 = 0;
	 		}else{
	 			id2 = id2 - tiempoMinuto;
	 		}
	 		if(id3 < tiempoSegundo){
	 			id3 = 0;
	 		}else{
	 			id3 = id3 - tiempoSegundo;
	 			
	 		}
	 		
	 		var hora= Math.floor(id1 * 3600);
			var min = Math.floor(id2 * 60);
			var seg = id3;
			
			result = parseInt(hora + min +seg);
		
			//console.log("result "+parseInt(result));
			$('#totalsegundos').val(result);
			pruebahora();
	}
	
	 function pruebahora() {
		 //alert('listar hora');
		 
//		 debugger;
		 var $clock = $('#clock')
		    .on('update.countdown', function(event) {
		      var format = '%H:%M:%S';
		      if(event.offset.totalDays > 0) {
		        format = '%-d day%!d ' + format;
		      }
		      if(event.offset.weeks > 0) {
		        format = '%-w week%!w ' + format;
		      }
		      $(this).html(event.strftime(format));
		      
		    })
		    .on('finish.countdown', function(event) {
		    	$('#clock').html('00:00:00');
		      //alert('This offer has expired!');
		      //$('#premio-ganar-modal').modal('show');
//		    	if($('#tiempoBono').val() == '0'){
//		    		
//		    	}
		    	localStorage.setItem("TiempoExamen",0);
				
				obtenerNota();


		    });
				
//	 	 	debugger;
		 	var ok = '';
		 	if (tiempoSegundos == 0 || 
		 			tiempoSegundos== "0") {				
				
				if (tiempoAdicionalSegundos == 0 || tiempoAdicionalSegundos == '0') {
					
					ok=$('#totalsegundos').val()+"s";
					
				}else{
					
					$('#totalsegundos').val(tiempoAdicionalSegundos);
					
					ok=$('#totalsegundos').val()+"s";
					
					tiempoAdicionalSegundos = 0;
				}
			}else{
				
		 		$('#totalsegundos').val(tiempoSegundos);
		 		
		 		ok=$('#totalsegundos').val()+"s";
		 		
		 		tiempoSegundos = 0;
			}

	 		
			
//			var ok=$('#totalsegundos').val()+"s";
	 		
		 	//console.log("ok "+ok);
		    var val = ok.toString().match(/^([0-9\.]{1,})([a-z]{1})$/),
		        qnt = parseFloat(val[1]),
		        mod = val[2];
		    switch(mod) {
		      case 's':
		        val = qnt * 1000;
		        break;
		      case 'h':
		        val = qnt * 60 * 60 * 1000;
		        break;
		      case 'd':
		        val = qnt * 24 * 60 * 60 * 1000;
		        break;
		      case 'w':
		        val = qnt * 7 * 24 * 60 * 60 * 1000;
		        break; // Break here to no enter the else value
		      default:
		        val = 0;
		    }
		  //console.log('val'+val +'qnt'+ qnt);
		    selectedDate = new Date().valueOf() + val;
		    $clock.countdown(selectedDate.toString());

	 
	}
	
	function cargar_listarHoraxLengua_Nivel(id){
		//alert('cargar_listarHoraxLengua_Nivel');
		
		var valido   = false;
		var url      = context+'/tmaestraController/listarhoraxnivel';
		//console.log("Variable  localStore " + localStorage.getItem("TiempoExamen"));
		 
		$.ajax({
			async: true,
			type : "GET",
			data : {p_nivellengua : id},
			url  : url,
			success : function(data){
				if(data!=null){
					
					//console.log("data[0].valor1:::: "+data[0].valor1);
					$('#idhoralenguanivel').val(data[0].valor1);
					$('#timelenguanivel').val(data[0].nombreCorto);
					
					var datesol = data[0].nombreCorto; // tomo el valor introducido del campo
					var array_datesol = datesol.split(":"); // 
					$('#idhora1').val(array_datesol[0]);
					$('#idmin1').val(array_datesol[1]);
					$('#idseg1').val(array_datesol[2]);
					convertirtiempo();
					
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
	
	function init() {
		var idlenguanivel = '1';//$('#lenguanivel');
		cargar_listarHoraxLengua_Nivel(idlenguanivel);
	}
	function sacarporcentajexnumero(val,val2) {
		var num=val;
		var num2=val2;
		
		var num3=num2*100/num;
		//console.log("num3.toPrecision(2) "+num3.toPrecision(2));
		$('#procen').text(num3.toPrecision(2)+'% Correcto');
		$('#procen').css('width', num3+'%');
		$('#procen').attr('aria-valuenow', num3);
		
	}
	
	function cargar_notaxEvaluacion_conTiempo(){
		//alert('cargar_listarHoraxLengua_Nivel');
		var idcodeval   = $('#codEvaluacion').val();
		var url      = context+'/lengua/obtenerEvaluacionxCod';
	//	debugger;
	
		$.ajax({
			 async: true,
			type : "GET",
			data : {p_codevalua : idcodeval},
			url  : url,
			success : function(data){
				if(data!=null){
					//console.log("data:: "+ data);
					$('#horIni').text(data.vfechaini);
					$('#horFin').text(data.vfechafin);
					$('#totalEjerc').text(data.correctos +' / '+data.totalEjercicio);
					//$('#correcErrad').text(data.correctos +'/'+ data.erradas);
					$('#notaF1').text(data.nota);
					$('#notaF').text(data.nota);
					$('#notaObtenida').val(data.nota);	
					sacarporcentajexnumero(data.totalEjercicio,data.correctos);
					cargar_MsjxNota(data.medalla.imagenNombre,data.medalla.nombre);
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
	
	function cargar_MsjxNota(imgmed,nomPre){
		//var nomimg =context+'/premio/'+imgmed;
		var nombrePre =nomPre
		var tipomsj="";
		if (parseInt($('#notaF1').val())>=$('#notaMinima').val()) {
			tipomsj=9;
//			modal_premio_evaluacion(nomimg,nombrePre);
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
					//$('#msgNota').text(data[0].mensajes);
					
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
    function capturarHoraF5(){
   
    var tecla=window.event.keyCode;
    //00:00:00
//    debugger;
    if (tecla==116) {
		var tiempo=$('#clock').text();   	
		var h = parseInt(tiempo.substr(0,1));
		var m = parseInt(tiempo.substr(3,4));
		var s = parseInt(tiempo.substr(6,7));
		tiempoSegundos = h*3600 + m*60 + s;
 		localStorage.setItem("TiempoExamen",tiempoSegundos);

    }
    }
    $(document).ready(function(){
    	//console.log(localStorage.getItem("TiempoExamen"));
    	 if(localStorage.getItem("TiempoExamen") != undefined){
    		 tiempoSegundos  = parseInt(localStorage.getItem("TiempoExamen"));
    		 
    	 }else{
        	 localStorage.setItem("TiempoExamen",0);             	 
         }
	  });
    
    
    
    function adicionarTiempoBono(){
//    	alert("ingreso a  adicionar  tiempoBon");
//    	debugger;
    	var tiempoActual = $('#clock').text();
    	var tiempoBonoSegundos = parseInt($('#tiempoBono').val());
    	
		var h = parseInt(tiempoActual.substr(0,1));
		var m = parseInt(tiempoActual.substr(3,4));
		var s = parseInt(tiempoActual.substr(6,7));
		
		var tiempoActualSegundos = h*3600 + m*60 + s;
		
		tiempoAdicionalSegundos = parseInt(tiempoActualSegundos) +
									  parseInt(tiempoBonoSegundos);
		
		
		pruebahora();
    	
    	
    }