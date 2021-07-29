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
  
  var elemDropOpt = this;
  
  
	$.ajax({
		 async: true,
		type : "GET",
		data : {dato1 : tempData , dato2 : tempRsp , tipo : 1},
		url  : context+'/ejercicio/verificarValor',
		success : function(data){
			//console.log("rpt eval crypt data: "+data);
		  if(data){ 
			    // envetoPuntos("c");
				  show_msj_masc_exito($("#msj_1").val());
				  $(elemDropOpt).addClass("active-item-txt");
				  $(elemDropOpt).children(".rspt").html(draggable.text()).attr("data-val","true");
			      draggable.draggable("disable").css({
			        'cursor': 'default',
			        'opacity': '.5'
			      });
			      valid_one();  
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
//	    	if(punto == tamanoPReg.length){
//		  $('#btnevaluar').removeClass('disabled');
//		  show_msj_masc_exito($("#msj_1").val());
////		  show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
//	  	}
	    }
	}); 
	 
}

var num = 0;
function valid_one(){
	  $('#lst-resp-tti li .rspt').each(function(index) {
		     var values = $(this).attr("data-val");
		      if(values){
		        num++;
		      }else{
		        num--;
		      }
		      if(num ==tamanoPReg.length){
		        $("#lst-resp-tti li").draggable({
		          helper:'clone'
		        }).css('cursor', 'move');

		        $("#lst-preg-nex li").droppable({
		          drop:eventoDropNext,
		          "disabled": false
		        });
		      }

		    });
}

//$("#lst-resp-img li").droppable({
//"disabled": true
//});

$("#lst-preg-nex li").droppable({
	  "disabled": true
	});



function eventoDropNext(evento, ui){
//debugger;
var draggable = ui.draggable;
var tempData = draggable.data('rsp');
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
		data : {dato1 : tempData , dato2 : tempRsp , tipo : 2},
		url  : context+'/ejercicio/verificarValor',
		success : function(data){
			//console.log("rpt eval crypt data: "+data);
		  if(data){ 
			     envetoPuntos("c");
			     show_msj_masc_exito($("#msj_1").val());
			     $(elemDropOpt).addClass("active-item-txt");
//			     $(this).children(".rspt").html(draggable.text()).attr("data-val","true");
			     $(elemDropOpt).css({'border-color': 'green'});
			      //$(this).children(".rspt").html(draggable.text()).css({'display': 'table'});;
			      draggable.draggable("disable").css({
			        'cursor': 'default',
			        'opacity': '.5'
			      });
			      // continuarEjercio();  
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
////		  show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
	  	}
	    }
	});   
}



var punto=0;
function envetoPuntos(val){
 if(val=="c"){
    punto++;
    }//else{
     if(punto==tamanoPReg.length){
  	show_msj_masc_exito($("#msj_1").val());
//     show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
     $("#btnevaluar").removeClass("disabled");

    }
 

} 
  
var punto=0;
function envetoPuntos(val){
   if(val=="c"){
      punto++;
      } 

 }