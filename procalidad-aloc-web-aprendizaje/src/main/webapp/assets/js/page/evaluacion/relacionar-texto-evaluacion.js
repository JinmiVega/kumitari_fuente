$("#lst-preg li").draggable({
  helper:'clone'
});

$("#lst-respRV li").droppable({
  drop:eventoDrop
});

function eventoDrop(evento, ui){
//debugger;
  var draggable = ui.draggable;
  var tempData = draggable.data('preg');
  var tempRsp = $(this).data('rsp');
  var elemDropOpt = this;
  $.ajax({
	  async: true,
		type : "GET",
		data : {dato1 : tempData , dato2 : tempRsp , tipo : 1},
		url  : context+'/ejercicio/verificarValor',
		success : function(data){
			//console.log("rpt eval crypt data: "+data);
		  if(data){
		      envetoPuntos("c");
//		     $(this).addClass('ui-droppable-correcto');
		      $(elemDropOpt).children(".rspt").html(draggable.text());
		      draggable.draggable("disable").css({
		        'cursor': 'default',
		        'opacity': '.3'
		      });
		      $(elemDropOpt).children(".rspt").draggable({disabled: true});
			  }else{
			    	 envetoPuntos("d");
			    	 $(elemDropOpt).children(".rspt").html(draggable.text());
			         draggable.draggable("disable").css({
			             'cursor': 'default',
			             'opacity': '.3'
			           });
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
	    complete: function(){
//	    	if(punto == tamanoPReg.length){
//  		  $('#btnevaluar').removeClass('disabled');
//  		  show_msj_masc_exito($("#msj_1").val());
////  		  show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
//  	  	}
	    }
	});
}

  var punto=0;
  var puntox=0;
 function envetoPuntos(val){

    if(val=="c"){
       punto++;
       }
    if (val == "d") {
		puntox++;
	}
    if ((punto+puntox)==tamanoPReg.length) {
//    	$('#btn_validar_ejercicio').attr("disabled", false);
	}
  }

 function valorEvaluacion(){
//		debugger;
		var codEvaDe =$('#codEvaluacionDet').val();
	if (punto == tamanoPReg.length) {
		actulizarEjercicioEvaluacion(codEvaDe,'1');
	}else{
		actulizarEjercicioEvaluacion(codEvaDe,'0');
	}
	}