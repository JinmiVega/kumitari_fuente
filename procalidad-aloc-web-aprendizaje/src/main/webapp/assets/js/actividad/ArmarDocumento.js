  var arrayIdArmarDocu = [];

  
  function shuffle(array) {

    var currentIndex = array.length, temporaryValue, randomIndex;

    // Si existen elementos
    while (0 !== currentIndex) {

      // Chocolateo
      randomIndex = Math.floor(Math.random() * currentIndex);
      currentIndex -= 1;

      // Chancar del temp al array
      temporaryValue = array[currentIndex];
      array[currentIndex] = array[randomIndex];
      array[randomIndex] = temporaryValue;
    }

    return array;
  }

 function listarArmarDocumentoTodo()
{
    var url =  context+'/lengua/ListArmarDocumentoTodoxTE';
    var html = '';
    var codmte =  $('#codigoMTE').val();
    var valido = false;
    var tituloCabArmaDocu = '';
    
    var	htmlPreg = '';
    var	htmlResp = '';
    
    //showLoad();
    $.ajax({
        async: true,
      type : 'GET',
      data :{p_codmatpej : codmte },
      url : url,
      success : function(data)
      {
    	  if(data!=null && data.length>0){
    		  valido = true;
    		  tituloCabArmaDocu = data[0].armarDocumentoCabBean.titulo;
    		  
    		  for(var i=0;i<data.length;i++){
    			  arrayIdArmarDocu.push(data[i].codigo);
    	      }
    		//console.log(arrayIdArmarDocu);
    		//console.log(data);
    	      
    	      var listaPreguntas = data;
    	      var listaRespuestas = data;
    	      
    	      /** IZQUIERDO **/
    	      //shuffle(listaPreguntas);
    	      
    	      htmlPreg += '<ul id=lst-preg>';
    	      for(var m=0;m<listaPreguntas.length;m++){
    	    	  var preg = listaPreguntas[m];
    	          htmlPreg += '<li data-preg="'+preg.codigo+'" id="rela-'+preg.codigo+'" style="border-radius: 3px;box-shadow: 4px 4px 0px 0px rgba(193, 190, 189, 0.61);">'+
    	          				'<span style="font-size: 14px;font-weight: 700;color: black;margin-top:10px;">'+preg.descripcion+'</span>'+
    	          			  '</li>';
    	      }
    	      htmlPreg += '</ul>';

    	      /** DERECHO **/
    	      shuffle(listaRespuestas);
    	      
    	      htmlResp += '<ul id=lst-resp>';
    	      for(var m=0;m<listaRespuestas.length;m++){
    	    	  var resp = listaRespuestas[m];
    	    	  htmlResp += '<li data-rsp="'+resp.codigo+'" id="rela-'+resp.codigo+'" >'+
    	    	  				'<span>'+resp.traduccionParteDoc+'</span>'+
    	   	   				  	'<span id="idspan-'+resp.codigo+'" class="rspt"></span>'+
    	   	   				  '</li>';
    	      }
    	      htmlResp += '</ul>';
    	  }
    	  
    	  $('#tituloArmarDocuCab').html('<p class="title-minendu ttpregunta">'+tituloCabArmaDocu+'</p>');
      },
      error : function(data) {
    	//console.log("error ");
      },
	  complete : function(){
		  //hideLoad();
		  if(valido){
			//console.log('hay data');
			  $('#listaArmarDocu').html(htmlPreg);
			  $('#listaArmarDocuRel').html(htmlResp);
			  $("#lst-preg li").draggable({
				  helper:'clone'
	    	  });

	    	  $("#lst-resp li").droppable({
	    		  drop:eventoDrop
	    	  });
		  }else{
			//console.log('no hay data');
		  }
	   }
  });
}

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

  if(localStorage.getItem('PARTES-DOCUMENTO') == '0'){
	if(tempData == tempRsp){
	      envetoPuntosEvaluacion("c"); 
	     $(this).css({'border-color': 'green'});
	     $(this).children(".rspt").html(draggable.text()); 
	      draggable.draggable("disable").css({
	        'cursor': 'default',
	        'opacity': '.3'
	      });
	     }else{
	     envetoPuntosEvaluacion("d"); 
     	}
	}else{
		if(tempData == tempRsp){
	      envetoPuntos("c"); 
	     $(this).css({'border-color': 'green'});
	     $(this).children(".rspt").html(draggable.text()); 
	      draggable.draggable("disable").css({
	        'cursor': 'default',
	        'opacity': '.3'
	      });
	     }else{
	     // $(this).addClass('active-txt-orafail');  
	      show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
	      insertarIntento();
     	}
	}
}

var punto=0;
 function envetoPuntos(val){ 
    if(val=="c"){
       punto++;
       }//else{
        if(punto==arrayIdArmarDocu.length){
        show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
        $("#btnevaluar").removeClass("disabled");
      
       }
     //  punto-1;
      // }

//  alert(punto);

   //alert(punto);

  }

var  puntox=0;
function envetoPuntosEvaluacion(val){
   if(val=="c"){
      punto++;
      }
   if(val=="d"){
	      puntox++;
	  }

   if ((punto+puntox)==arrayIdArmarDocu.length) {   	
		$("#btnevaluar").removeClass("disabled");
	}
 }

function valorEvaluacion(){
	var codEvaDe =$('#codEvaluacionDet').val();
	if (punto == arrayIdArmarDocu.length) {
		localStorage.removeItem('PARTES-DOCUMENTO')
		actulizarEjercicioEvaluacion(codEvaDe,'1');
		$('#codEvaluacionDet').val('0');
	}else{
		localStorage.removeItem('PARTES-DOCUMENTO')
		actulizarEjercicioEvaluacion(codEvaDe,'0');
		$('#codEvaluacionDet').val('0');
	}
}