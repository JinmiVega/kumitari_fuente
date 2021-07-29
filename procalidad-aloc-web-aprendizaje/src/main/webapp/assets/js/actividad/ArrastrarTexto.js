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


 function ListarEjercicioTexto()
 {
     var url =  contextPath+"/lengua/ArrastrarTexto";
     var htmlPreg = "";
     var htmlRsp = "";
     var codmte =  $('#codigoMTE').val();
     $.ajax({
         async: true,
       type : 'GET',
       data :{p_codmatpej : codmte },
       url : url,
     success : function(data)
     {
    	// dataValor = data;
    	      tamanoPReg=[];
         for(var m=0;m<data.length;m++){
             tamanoPReg.push(data[m].codigo);
           }

    	 var listaPreguntas=data;
    	 var listaRespuestas=data;

    	 shuffle(listaPreguntas);
       var	htmlPreg = "<ul id="+"lst-preg"+">";

       for(var m=0;m<listaPreguntas.length;m++){
    	   var preg = listaPreguntas[m];
           htmlPreg = htmlPreg+"<li data-preg="+preg.valPreguEncrypt+" id=rela-"+preg.valPreguEncrypt+" style='border-radius: 3px;box-shadow: 4px 4px 0px 0px rgba(193, 190, 189, 0.61);'><span style='font-size: 14px;font-weight: 700;color: black;margin-top:10px;'>"+preg.texto+"</span></li>";//<span style='margin-left: 30px;'>
       }
       htmlPreg = htmlPreg+"</ul>";
       document.getElementById("ListaTexto").innerHTML=htmlPreg;

       shuffle(listaRespuestas);
       	var htmlResp = "<ul id="+"lst-resp"+">";

       for(var m=0;m<listaRespuestas.length;m++){
    	   var resp = listaRespuestas[m];

    	   	htmlResp = htmlResp+"<li data-rsp="+resp.valAlterEncrypt+" id="+"rela-"+resp.valAlterEncrypt+" style='overflow-y:  scroll;' ><span id="+resp.valAlterEncrypt+">"+resp.texto2+"</span>" +
   	   		"<span id= "+"idspan"+resp.valAlterEncrypt+" class="+"rspt"+"></span></li>";
       }
       htmlResp = htmlResp+"</ul>";


       document.getElementById("ListaTextoRelacionado").innerHTML=htmlResp;
       var p_titu= '' ;
        if(data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo != null){
        p_titu=data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo
       }else{
        p_titu=''
       }
       $('#titulos').html(icono_titulo
    		   			+	'<h4 class="sub-title-app"> '+ p_titu + '</h4></br>' );

       $("#lst-preg li").draggable({
    	   helper:'clone'
    	 });

    	 $("#lst-resp li").droppable({
    	   drop:eventoDrop
    	 });
        

     },
     error : function(data) {
    	//console.log("error ");
     }
   });
 }

 
function valor(){ 
  var p_int1 =  $('#intent1').val();
  var p_int2 =  $('#intent2').val();
  var p_int3 =  $('#intent3').val(); 
 //if(punto == tamanoPReg.length){
 
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





