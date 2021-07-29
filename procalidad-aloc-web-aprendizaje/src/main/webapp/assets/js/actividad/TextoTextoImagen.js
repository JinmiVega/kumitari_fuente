 var contextPath = $('#contextPathUrl').val();
  numEjer =0;
  var mteCodigos = [];
	var tamanoPReg=[];
  var dataValor= [];
 
  
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


 function ListarEjercicio()
 {
	 var codmte =  $('#codigoMTE').val();
     var url =  contextPath+"/lengua/ArrastrarTexto";
    // var htmlPreg = "";
     var htmlRsp = "";
     $.ajax({
    	 async: true,
       type : 'GET',
       data :{p_codmatpej : codmte },
       url : url,
     success : function(data)
     {
      tamanoPReg=[];
      for(var m=0;m<data.length;m++){
          tamanoPReg.push(data[m].codigo);
        }


         var prt1=data;
         var prt2=data;
         var prt3=data;

     /*

    	 var listaPreguntas=data;
    	 var listaRespuestas=data;
    	 shuffle(listaPreguntas);  */
       shuffle(prt1);
       var	parte1 = '<ul id="lst-preg-tti">';

       for(var m=0;m<prt1.length;m++){
    	    var one = prt1[m];
           parte1 = parte1+"<li data-preg="+one.valPreguEncrypt+" ><span>"+one.texto+"</span></li>";
       }
       parte1 = parte1+"</ul>";
       document.getElementById("parte1").innerHTML=parte1;

       $("#lst-preg-tti li").draggable({
          helper:'clone'
        });

       
       shuffle(prt2);


       var  parte2 = '<ul id="lst-resp-tti">';

       for(var m=0;m<prt2.length;m++){
        var two = prt2[m];
        // var preg = listaPreguntas[m];
           parte2 = parte2+"<li data-rsp="+two.valAlterEncrypt+" ><span>"+two.texto2+"</span><span class='rspt'></span></li>";
       }
       parte2 = parte2+"</ul>";
       document.getElementById("parte2").innerHTML=parte2;

       $("#lst-resp-tti li").droppable({
            drop:eventoDrop
          });
       


       shuffle(prt3);

       var parte3='<ul id="lst-resp-img">';
           for(var i=0;i<prt3.length;i++){
            var three = prt3[i];
            parte3= parte3+ '<li data-rsp-img="'+three.valRelEncrypt+'" ><img src="'+contextPath+'/material/'+three.imagen+'" alt="" class="img-responsive"><label class="rspt"></label><span class="rspt"></span></li>'
           }
           $('#parte3').html(parte3 + '</ul>');


 
       $('#titulos').html(	icono_titulo
      		 +'<h4 class="sub-title-app">' + data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo + '</h4><p class="title-minendu ttpregunta" id="title-preg">'+ ''+ '</p>' );

 

       
			
			 

     },
     error : function(data) {
    	//console.log("error ");
     }
   });
 }

//


 
 function valor(){
   var p_int1 =  $('#intent1').val();
   var p_int2 =  $('#intent2').val();
   var p_int3 =  $('#intent3').val();
   var p_evalDt = $('#codEvaluacionDet').val();
   if (p_evalDt != 0) {
		
		if (numerodeintento == 1) {
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
    
       siguiente_ejercicio();
     

 }}
