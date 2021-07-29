 var contextPath = $('#contextPathUrl').val();
  numEjer =0;
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
{
    var url =  contextPath+"/lengua/ListArrastrar";
    var html = "";
    var codmte =  $('#codigoMTE').val();
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

     var oracorregida = '';
         oracorregida = data[0].arrastraOraciBean.oracion;
         for(var i=0;i<19;i++){
         oracorregida = oracorregida.replace('%'+i+'%' ,  '<label data-rsp="'+i+'"  ><span class="rspt" id="idspan'+i+'"></span></label> ' );

           }


            var rspt='';
            for(var e=0;e<listaRandom.length;e++){
             var random=listaRandom[e];
           if(random.orden !=null || random.orden !=  ''){
            rspt= rspt+ '<li  data-preg="'+random.valPreguEncrypt+'" ><span >'+random.descripcion+'</span></li> '
             }
           }


             if (data != null) {
             $('#alternativas').html('<ul id="lst-rsp-oracion">'+rspt+'</ul>');
             $("#lst-rsp-oracion li").draggable({
                  helper:'clone'
                });
             $('#lst-oracion').html(oracorregida);
             $("#lst-oracion label").droppable({
                  drop:eventoDrop
                });
             $('#titulos').html(icono_titulo		 
            		 +'<h4 class="sub-title-app">' + data[0].arrastraOraciBean.materialTipoEjercicioBean.titulo + '</h4><p class="title-minendu ttpregunta" id="title-preg">'+ data[0].arrastraOraciBean.titulo+ '</p>' );

      }else{
        return false;
      }
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
    
