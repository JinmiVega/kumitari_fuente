 var contextPath = $('#contextPathUrl').val();
  numEjer =0;
  var mteCodigos = [];
	var tamanoPReg=[];
  var dataValor= []; 
  //$('#btnevaluar').addClass('disabled'); 

 function shuffle(array) { 
	  var currentIndex = array.length, temporaryValue, randomIndex; 
	  while (0 !== currentIndex) { 
	    randomIndex = Math.floor(Math.random() * currentIndex);
	    currentIndex -= 1; 
	    temporaryValue = array[currentIndex];
	    array[currentIndex] = array[randomIndex];
	    array[randomIndex] = temporaryValue;
	  }

	  return array;
	}


 function ListarEjercicio(){ 
	 var codmte =  $('#codigoMTE').val();  
	    var url =  contextPath+"/lengua/ListAlternTextoPalabraCorrectaTodoxTE";
	    var html = "";
	     $.ajax({
	      async: true,
	      type : 'GET',
	      data :{p_codmatpej : codmte },
	      url  : url,
	       success : function(data) {
	    	  // tamanoPReg=[];
	         var oracorregida = '';
	         var $var_oracorregida;
	         var listDetalle = '';
	         var combo='';
	         var final='';
	         
	         if(data != null && data.length > 0){

		         oracorregida = data[0].textoPalabraCorrectaBean.texto;

		         $("#contentCambio").html(oracorregida)
//		         oracorregida = $("#contentCambio").text();
//		         $("#contentCambio").html("");
//		         var idOra = document.getElementById("contentCambio");
//		         var spans = idOra.getElementsByTagName("span");
		         $('#codCabPC').val(data[0].textoPalabraCorrectaBean.codigo);
		       //console.log("data[0].textoPalabraCorrectaBean.codigo "+data[0].textoPalabraCorrectaBean.codigo);
		         var cont=0;
			         for(var m=0;m<data.length;m++){
			        	 if (data[m].respuestaEstado==1) {
			        		 
			                 tamanoPReg.push(data[m].palabraCorrecta);

						}
			           }

			         var index = 0;
			         var header=0; 

			           for(var e=0;e<10;e++){
			        		  var hora =""; 
			           for(var i=0;i<data.length ;i++)
			           {

			        	 
			        	   if(data[i].nroOrden==e)
				              {
				                hora = data[i].palabraCorrecta;

				               }

			           } 

			           oracorregida = oracorregida.replace("%"+e+"%" , '<span class="contentPalabra" id="'+e+'">'+hora+'</span>');
			             }   
			           
			           if (data[0].textoPalabraCorrectaBean.comentario!='') {
		   	            	/*$(".comentariotPC").html('<span id="content-icon-m">'
					   				+'<i class="icon-notebook"></i>'
						   			+'</span>' + data[0].textoPalabraCorrectaBean.comentario
						   			+ '<span class="close-conten" onclick="ocultarDiv()"></span>');
		   	            	//console.log('data[i].textoPalabraCorrectaBean.comentario '+data[0].textoPalabraCorrectaBean.comentario);*/
		   				}else {

		   					//var htmlattri="display: none;";
		   					//$('#coment').attr('style', htmlattri);
		   					//$('#coment').hide();
		   					//$("#coment").html('style="display: none;"');
		   				//console.log('no trajo comentario::: ');
		   				} 
			           
		              if (data != null) {
		                $('#cambio').html('<p class="font-text" style="text-align: center;font-weight: bold;">  '+ data[0].textoPalabraCorrectaBean.titulo +' </p><p class="font-text" style="text-align: justify;">  '+ oracorregida + ' </p>');
		                $('#titulos').html(icono_titulo
						  		+'<h4 class="sub-title-app" style="opacity: 1;">'+ data[0].textoPalabraCorrectaBean.materialTipoEjercicioBean.titulo + '</h4>' );

		            }else{
		                 return false;
		            }

	         }
	         
          },
	        error : function(data) {
	        	//console.log("error ");
	    }
	  });
	}


 var n_intento = 1;

 function valor(){ 
	 var p_int1 =  $('#intent1').val();
	   var p_int2 =  $('#intent2').val();
	   var p_int3 =  $('#intent3').val();
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
    siguiente_ejercicio();  
 }
 }

 
 var tamanoRespC= [];	 
  
 function changeComboPalabra1(obj){
	  
	 
	//console.log("obj :::"+obj);
	 if ($("#cbComboPalabra").val()==1) {
		//console.log($("#cbComboPalabra option:selected").text());
		 $('#'+obj).attr('class', "democlassPC");
		 $('#'+obj).removeClass("contentPalabra");
		 $('#'+obj).removeClass('selec-invalid-opt');
		 $('#'+obj).addClass('selec-valid-opt');
		 tamanoRespC.push($("#cbComboPalabra").val());
		 $('#'+obj).text($("#cbComboPalabra option:selected").text());
		// $('#'+obj.textContent+'').css('font-weight','600');
		
		//console.log('tamanoRespC.push:::: ' + tamanoRespC);
		 
		 var contPC=0;
		 var contPC1=0;
			for(var m=0;m<tamanoRespC.length;m++){
				if (tamanoRespC.length>=tamanoPReg.length) {
					contPC=contPC+1;
				}else{
					contPC=contPC+0;
			 	}
	        }
			//console.log('contPC:::'+contPC);
		 
		 if (contPC==tamanoPReg.length) {
				for(var i=0;i<tamanoRespC.length;i++){
					if (tamanoRespC[i]==1) {
						contPC1=contPC1+1;
					}else{
						contPC1=contPC1+0;
				 	}
		        }
				//console.log('contPC1:::'+contPC1);
			 
				if (contPC1==tamanoPReg.length) {
					 show_msj_masc_exito($("#msj_1").val());
//					 show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
					 $('#btnevaluar').removeClass('disabled');
					 
					 
				}else{
					//console.log('nada');
				}

		}
	}else if ($("#cbComboPalabra").val()==0) {
//		contPC1=0;
//		contPC=0;
//		tamanoPReg=[];
//		tamanoRespC=[];
//		 ListarEjercicio();
//	      show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
		$('#'+obj).removeClass('selec-valid-opt');
		$('#'+obj).addClass('selec-invalid-opt');
		  show_msj_masc_fallo($("#msj_2").val());
	      insertarIntento();
	}
	 

 }

 $(document).ready(function(){
	 	contPC1=0;
		contPC=0;
		tamanoRespC=[];
	    $("#antPC").click(function(){
	    	contPC1=0;
			contPC=0;
			tamanoRespC=[];
	    });
	    $("#nextPC").click(function(){
	    	contPC1=0;
			contPC=0;
			tamanoRespC=[];
	    });
	});