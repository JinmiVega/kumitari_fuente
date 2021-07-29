 var contextPath = $('#contextPathUrl').val();
  numEjer =0;
   numEjer1 =0;
  var mteCodigos = [];
  var tamanoPReg= [];



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
{   var codmte =  $('#codigoMTE').val();
    var url =  contextPath+"/lengua/ListRelacionVariada";
    var html = "";
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

        var listaRandom=data;
        shuffle(listaRandom);

            var rspt='';
            for(var e=0;e<data.length;e++){
            var random=listaRandom[e];
            rspt= rspt+ '<li id="text'+e+ '"  data-preg="'+random.codigo+'" ><span >'+random.texto+'</span></li> '

           }

           var prueba='';
            for(var i=0;i<data.length;i++){
           if(data[i].tipoRelacion  == '2'){
            prueba= prueba+ '<li  data-rsp="'+data[i].codigo+'" ><span>'+data[i].texto2+'</span><span class="rspt"></span></li>'
             }
           }
           var prueba2='';
           for(var i=0;i<data.length;i++){
           if(data[i].tipoRelacion  == '1'){
            prueba2= prueba2+ '<li data-rsp="'+data[i].codigo+'" ><img src="'+contextPath+'/material/'+data[i].imagen+'" alt="" class="img-responsive"><label class="rspt"></label></li>'
             }
           }

             $('#prueba2').html('<ul id="lst-resp-img">' + prueba2 + '</ul>');

             $("#lst-preg-img li").draggable({
                helper:'clone'
              });

              $("#lst-resp-img li").droppable({
                drop:eventoDrop
              });

             $('#prueba').html('<ul id="lst-resp">' + prueba + '</ul>');
             $('#pregunta2').html('<ul id="lst-preg">' + rspt + '</ul>');

             $("#lst-preg li").draggable({
                helper:'clone'
              });

              $("#lst-resp li").droppable({
                drop:eventoDrop
              });

             $('#titulos').html(icono_titulo
			  		+'<h4 class="sub-title-app">' + data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo + '</h4><p class="title-minendu ttpregunta" id="title-preg">'+ data[0].relacionCabeceraBean.titulo+ '</p>' );


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
  var p_evalDt = $('#codEvaluacionDet').val();

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
     

}
