/**
 * Ejercicio Relación Texto - Imagen.
 */
 var contextPath = $('#contextPathUrl').val();

 //$('#btnevaluar').addClass('disabled');

 /*Codigos  */
 var mteCodigos = [];
 var parrafcab = [];
 var tamanoPReg= [];

 function listarTextoImagen(){

	 var codmte =  $('#codigoMTE').val();

	 var url =  contextPath+"/lengua/listarTextoImagen";
	 var htmlTitulo = "";
	 var htmlPalabra = "";
	 var htmlImagen = "";

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

	    		  htmlTitulo = htmlTitulo + icono_titulo
	    		  						  + "<h4 class='sub-title-app' style='opacity: 1;'>"+data[0].relacionCabeceraBean.materialTipoEjercicioBean.titulo+"</h4>"+
	    		  "<p class='title-minendu ttpregunta' id='title-preg'>"+data[0].relacionCabeceraBean.titulo+"</p>";
	    		  document.getElementById("tituloTextoImagen").innerHTML=htmlTitulo;

	    		  var listPalabara = data;
	    		  var listaImagen = data;

	    		  shuffle(listPalabara);

	    		  htmlPalabra ="<ul id='lst-preg2' >";

	    		  for (var int = 0; int < listPalabara.length; int++) {
	    			  var palabra = listPalabara[int];

	    			  htmlPalabra = htmlPalabra + "<li data-preg='"+palabra.valPreguEncrypt+"' class='lst-prg-pruebaRelTI'><span style='font-size: 14px;font-weight: 700;color: black;text-transform:none'>"+palabra.texto+"</span></li>";
				}


	    		  htmlPalabra = htmlPalabra + "</ul>";
	    		  document.getElementById("textoImagenPalabra").innerHTML=htmlPalabra;

	    		  $("#lst-preg2 li").draggable({
	                  helper:'clone'
	                });

	                $("#lst-resp li").droppable({
	                  drop:eventoDrop
	                });

	              shuffle(listaImagen);

	    		  htmlImagen = "<ul id='lst-resp-img'>";
	    		  for (var i = 0; i < listaImagen.length; i++) {
	    			  var img = listaImagen[i];
	    			  htmlImagen    = htmlImagen+ '<li data-rsp="'+img.valAlterEncrypt+'" class="item-img-lst-o"><span class="circle-borde-rp"><img src="'+contextPath+'/material/'+img.imagen+'" alt="" class="img-circle" style="border-radius: 50%;border: 4px solid #c9c9c9;box-shadow: 0px 3px 16px rgba(0,0,0,0.5);"></span><label class="rspt"></label></li>'
	    		  }
	    		  htmlImagen = htmlImagen + "</ul>";
	    		  document.getElementById("textoImagenImagen").innerHTML=htmlImagen;

	    		  $("#lst-preg-img li").draggable({
	    			  helper:'clone'
	    			});

	    			$("#lst-resp-img li").droppable({
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

   var p_int1 =  $('#intento1').val();
   var p_int2 =  $('#intento2').val();
   var p_int3 =  $('#intento3').val();
   var p_evalDt = $('#codEvaluacionDet').val();

  //if(punto == tamanoPReg.length){
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
       resetImgMascota(1);
       siguiente_ejercicio();

 }
 }