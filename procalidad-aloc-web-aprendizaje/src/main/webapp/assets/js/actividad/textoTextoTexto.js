/**
 * Texto + Texto + Texto
 */
var contextPath = $('#contextPathUrl').val();

var  numEjercicio = 0;

/*Codigos  */
var mteCodigos = [];
var parrafcab = [];
var tamanoPReg= [];

/** Número de  intentos **/
 

 

function listarTextoTextoTexto(){
	 var codmte =  $('#codigoMTE').val();
	 var url =  contextPath+"/lengua/listarTextoImagen";
	 var htmlTitulo = "";
	 var htmlTexto1 = "";
	 var htmlTexto2 = "";
	 var htmlTexto3 = "";
	    $.ajax({
	    	 async: true,
	        type : 'GET',
	        data :{p_codmatpej : codmte },
	        url : url,
	      success : function(data)
	      {
	    	  if (data != null) {
	    	      tamanoPReg=[];
	    	      for(var m=0;m<data.length;m++){
	    	          tamanoPReg.push(data[m].codigo);
	    	        }

	    		  htmlTitulo = htmlTitulo   + icono_titulo
	       		 +'<h4 class="sub-title-app">' + data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo + '</h4><p class="title-minendu ttpregunta" id="title-preg">'+ ''+ '</p>';

	    		  $("#tituloTextoTextoTexto").html(htmlTitulo);

	    		  var listaTexto1 = data;
	    		  var listaTexto2 = data;
	    		  var listaTexto3 = data;

	    		  shuffle(listaTexto1);

	    		  for (var int = 0; int < listaTexto1.length; int++) {

	    			  var texto1 = listaTexto1[int];

	    			  htmlTexto1 = htmlTexto1 + "<li data-preg='"+texto1.valPreguEncrypt+"' ><span></span>"+texto1.texto+"</li>";
				}
	    		  $("#textoTextoTexto1").html("<ul id='lst-preg-tti'>"+htmlTexto1+"</ul>");

	    	      $("#lst-preg-tti li").draggable({
	    	          helper:'clone'
	    	        });


	    		  shuffle(listaTexto2);

	    		  for (var i = 0; i < listaTexto2.length; i++) {
					var texto2 = listaTexto2[i];
					htmlTexto2 = htmlTexto2 + "<li data-rsp='"+texto2.valAlterEncrypt+"'  ><span></span>"+texto2.texto2+"<span class='rspt'></span></li>";
				}
	    		  $("#textoTextoTexto2").html("<ul id='lst-resp-tti'>"+htmlTexto2+"</ul>");

	    	       $("#lst-resp-tti li").droppable({
	    	            drop:eventoDrop
	    	          });


	    		  shuffle(listaTexto3);

	    		  for (var j = 0; j < listaTexto3.length; j++) {
	    			  var texto3 = listaTexto3[j];

	    			  htmlTexto3 = htmlTexto3 + "<li class='textoStyle' data-rsp='"+texto3.valRelEncrypt+"' ><span></span>"+texto3.texto3+"<label class='rspt'></label><span class='rspt'></span></li>";

				}
	    		  $("#textoTextoTexto3").html("<ul id='lst-preg-nex'>"+htmlTexto3+"</ul>");



	    		  $("#lst-preg li").draggable({
	    			  helper:'clone'
	    			});

	    			$("#lst-resp li").droppable({
	    			  drop:eventoDrop
	    			});



			}else{

			}

	      },
	      error : function(data) {
	    	//console.log("error ");
	      }
	    });
}
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

 
function valor(){
  var p_int1 =  $('#intent1').val();
  var p_int2 =  $('#intent2').val();
  var p_int3 =  $('#intent3').val();
  var p_evalDt = $('#codEvaluacionDet').val();

 //if(punto == tamanoPReg.length){
  var p_evalDt = $('#codEvaluacionDet').val();

  //if(punto == tamanoPReg.length){
   if (p_evalDt != 0) {
		
	if (n_intento == 1) {
		//correcto
		actulizarEjercicioEvaluacion(p_evalDt,'1');
	}else{
		actulizarEjercicioEvaluacion(p_evalDt,'0');
	}
		
		
	}else{
  if(numerodeintento == 1){ 
	   guardarMonedas(p_int1,0); 
  	   grabarSeguimientoAlumnoEjercicio(p_int1); 
  	 }else if(numerodeintento==2){
  		guardarMonedas(p_int2,0); 
  	     grabarSeguimientoAlumnoEjercicio(p_int2); 
  	 } else if (numerodeintento==3){
  		 guardarMonedas(p_int3,0);
  	    grabarSeguimientoAlumnoEjercicio(p_int3); 
  	 } else { 
  	    grabarSeguimientoAlumnoEjercicio(0);  
  	 }

      punto=0; 
      resetImgMascota(1);
      siguiente_ejercicio();


}
}

