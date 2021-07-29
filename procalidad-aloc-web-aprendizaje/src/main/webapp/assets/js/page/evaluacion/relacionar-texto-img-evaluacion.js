$("#lst-preg-tti li").draggable({
  helper:'clone'
});

$("#lst-resp-tti li").droppable({
  drop:eventoDrop
});


function eventoDrop(evento, ui){
  // debugger;
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
		data : {dato1 : tempData , dato2 : tempRsp , tipo : 1},
		url  : context+'/ejercicio/verificarValor',
		success : function(data){
		  if(data){
					$(this).children(".rspt").html(draggable.text()).attr("data-val","true");
				      draggable.draggable("disable").css({
				        'cursor': 'default',
				        'opacity': '.5'
				      }); 
					num++;
			     }else{
			      $(this).children(".rspt").html(draggable.text()).attr("data-val","true");
		         draggable.draggable("disable").css({
		           'cursor': 'default',
		           'opacity': '.5'
		         });  
					num--;
			  }
	         valid_one();
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

var num = 0;
function valid_one(){
  if(num ==tamanoPReg.length){
    	  $("#lst-resp-tti li").draggable({
			  helper:'clone'
    	  }).css('cursor', 'move');

			$("#lst-resp-img li").droppable({
			  drop:eventoDropNext
			});  
      } 
}

//$("#lst-resp-img li").droppable({
//  "disabled": true
//});



function eventoDropNext(evento, ui){
  //debugger;
  var draggable = ui.draggable;
  var tempData = draggable.data('rsp');
  var tempRsp = $(this).data('rsp-img');

     // $(this).children(".rspt").html(draggable.text());
     //  draggable.draggable("disable").css({
     //    'cursor': 'normal',
     //    'opacity': '.3'
     //  });

$.ajax({
		 async: true,
		type : "GET",
		data : {dato1 : tempData , dato2 : tempRsp , tipo : 2},
		url  : context+'/ejercicio/verificarValor',
		success : function(data){
		  if(data){
			envetoPuntos("c");
		     $(this).children(".rspt").html(draggable.text()).attr("data-val","true");
		      draggable.draggable("disable").css({
		        'cursor': 'default',
		        'opacity': '.5'
		      });
		     }else{
		      envetoPuntos("d");
	         $(this).children(".rspt").html(draggable.text()).attr("data-val","true");
	         draggable.draggable("disable").css({
	           'cursor': 'default',
	           'opacity': '.5'
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
var  puntox=0;
function envetoPuntos(val){
   if(val=="c"){
      punto++;
      }
   if(val=="d"){
	      puntox++;
	  }   	

   if ((punto+puntox)==tamanoPReg.length) {   	
// 	$('#btn_validar_ejercicio').attr("disabled", false);
	}
 }

function valorEvaluacion(){
//	debugger;
	var codEvaDe =$('#codEvaluacionDet').val();
if (punto == tamanoPReg.length) {
	actulizarEjercicioEvaluacion(codEvaDe,'1');
	$('#codEvaluacionDet').val('0');
}else{
	actulizarEjercicioEvaluacion(codEvaDe,'0');
	$('#codEvaluacionDet').val('0');
}
}