$("#lst-rsp-oracion li").draggable({
  helper:'clone'
});

$("#lst-oracion label").droppable({
  drop:eventoDrop
});

function eventoDrop(evento, ui){

  var draggable = ui.draggable;
  var tempData = draggable.data('preg');
  var tempRsp = $(this).data('rsp');

     // $(this).children(".rspt").html(draggable.text());
     //  draggable.draggable("disable").css({
     //    'cursor': 'normal',
     //    'opacity': '.3'
     //  });
	$.ajax({
	  async: true,
		type : "GET",
		data : {dato1 : tempData , dato2 : tempRsp , tipo : 3},
		url  : context+'/ejercicio/verificarValor',
		success : function(data){
			if(data){
				envetoPuntos("c");
			     $(this).children(".rspt").html(draggable.text());
			      draggable.draggable("disable").css({
			        'cursor': 'default',
			        'opacity': '.3'
			      });
			}else{
				envetoPuntos("d");
		         $(this).children(".rspt").html(draggable.text());
		         draggable.draggable("disable").css({
		           'cursor': 'default',
		           'opacity': '.3'
		         });
			}
		     
		},
		error: function(xhr,status,er) {
		    if(xhr.status==500) {
		    }
		    if(xhr.status==901) {
		    }
	    },
	    complete: function(){
	    }
	});
}

  var punto=0;
  var puntox=0;
  function envetoPuntos(val){
    if(val=="c"){
       punto++;
       }
    if(val=="d"){
    	puntox++;
        }
    if ((punto+puntox)==tamanoPReg.length) {   	

	}

  }
  
  
  function valorEvaluacion(){
//		debugger;
		var codEvaDe =$('#codEvaluacionDet').val();
	if (punto == tamanoPReg.length) {
		actulizarEjercicioEvaluacion(codEvaDe,'1');
		$('#codEvaluacionDet').val('0');
	}else{
		actulizarEjercicioEvaluacion(codEvaDe,'0');
		$('#codEvaluacionDet').val('0');
	}
	}