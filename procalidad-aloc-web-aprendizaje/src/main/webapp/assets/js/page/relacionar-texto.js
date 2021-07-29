$("#lst-preg li").draggable({
  helper:'clone'
});

$("#lst-respRV li").droppable({
  drop:eventoDrop
});

function eventoDrop(evento, ui){
//  debugger;
  var draggable = ui.draggable;
  var tempData = draggable.data('preg');
  var tempRsp = $(this).data('rsp');

     // $(this).children(".rspt").html(draggable.text());
     //  draggable.draggable("disable").css({
     //    'cursor': 'normal',
     //    'opacity': '.3'
     //  });
  var elemDropOpt = this;
  $.ajax({
	  async: true,
		type : "GET",
		data : {dato1 : tempData , dato2 : tempRsp , tipo : 1},
		url  : context+'/ejercicio/verificarValor',
		success : function(data){
			//console.log("rpt eval crypt data: "+data);
		  if(data){
			 show_msj_masc_exito($("#msj_1").val());
			 envetoPuntos("c");
		     $(elemDropOpt).children(".rspt").html(draggable.text());
		     $(elemDropOpt).addClass('ui-droppable-correcto');
		      draggable.draggable("disable").css({
		        'cursor': 'default',
		        'opacity': '.3'
		      });
		      $(elemDropOpt).children(".rspt").draggable({disabled: true});
			  }else{
				  show_msj_masc_fallo($("#msj_2").val());
//				  show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
			      insertarIntento();
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
	    	if(punto == tamanoPReg.length){
  		  $('#btnevaluar').removeClass('disabled');
  		  show_msj_masc_exito($("#msj_1").val());
//  		  show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
  	  	}
	    }
	});
}



















  var punto=0;
  function envetoPuntos(val){
     if(val=="c"){
        punto++;
     }//else{
     //  punto-1;
      // }

//  alert(punto);

   //alert(punto);

  }

