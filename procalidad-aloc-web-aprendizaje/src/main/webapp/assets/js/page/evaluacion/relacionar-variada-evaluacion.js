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

     // $(this).children(".rspt").html(draggable.text());
     //  draggable.draggable("disable").css({
     //    'cursor': 'normal',
     //    'opacity': '.3'
     //  });

  if(tempData == tempRsp){
      envetoPuntos("c"); 
//     $(this).css({'border-color': 'green'});
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
     // $(this).addClass('active-txt-orafail');  
//      show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
//      insertarIntento();
      
     }
}

  var punto=0;
  var  puntox=0;
 function envetoPuntos(val){
    if(val=="c"){
       punto++;
       }   
    if (val == "d") {
   		puntox++;
   	}
       if ((punto+puntox)==tamanoPReg.length) {   	

//       	$('#btn_validar_ejercicio').attr("disabled", false);
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