numEjer =0;
var cantidadpalabras=0;

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


 function ListarEjercicio(){
	 var codmte =  $('#codigoMTE').val();  
	 var url =  context+"/lengua/listarCompletarPalabrasInputTodoxTE";
	 var html = '';
	 $.ajax({
         async: true,
	      type : 'GET',
	      data :{p_codmatpej : codmte },
	      url  : url,
	      success : function(data) {
	    	//console.log(data);
	    	 
	    	 if(data!=null && data.length>0){
	    		 cantidadpalabras = data.length;
	    		 var titulo    = (data[0].textoPalabraEncerradaBean!=null) ? data[0].textoPalabraEncerradaBean.titulo : '';
	    		 var contenido = (data[0].textoPalabraEncerradaBean!=null) ? data[0].textoPalabraEncerradaBean.texto : '';
	    		 var count = -1;
	    		 
	    		 if(contenido!=null && contenido!=''){
	    			 for(var e=0; e<50; e++)
			         {
		    			count++; 
			            var input = '';
			            if(count<=data.length){
			            	for(var i=0;i<data.length ;i++)
				            {
			            	  if(data[i].nroOrden==e)
			            	  {
			            		  input = '<input type="text" data-esp="'+data[i].nroOrden+'" data-texto="'+data[i].valPreguEncrypt+'" >&nbsp('+data[i].palabraEncerrada+')&nbsp';
			            		  break;
			            	  }
				            }
			            	contenido = contenido.replace("%"+e+"%" , input );
			            }else{
			            	break;
			            }
			         }
		    		 
		    		 html += '<p class="sub-title-app" style="text-align: center;">  '+ titulo +' </p>'; 
			    	 html += contenido;
	    		 }
	    		 
		    	 $('#text-input-parrafo').html(html);
	    	 }

	      },
	      error : function(data) {
	    	//console.log("error ");
	      }
	  });
	}

function removeValidacion(){
	$("#text-input-parrafo input").each(function (){
		$(this).removeClass('input-valid-opt');
		$(this).removeClass('input-invalid-opt'); 
	});
} 
 
 function valor(){
	  var p_int1 =  $('#intent1').val();
	  var p_int2 =  $('#intent2').val();
	  var p_int3 =  $('#intent3').val(); 
	 /*var p_evalDt = $('#codEvaluacionDet').val();
	 
	   if (p_evalDt != 0) {		
		   //correcto
		   actulizarEjercicioEvaluacion(p_evalDt,'1');
	   }else{  
		   grabarSeguimientoAlumnoEjercicio(0); 
		   siguiente_ejercicio();
	   }*/
	 
	 var array = [];
	 
	 $("#text-input-parrafo input").each(function () 
	 {
		 var objeto = {
			nroOrden : 0,
			valPreguEncrypt : null,
			palabraRpta: null
		 }
		 
		 objeto.nroOrden = $(this).attr('data-esp');
		 objeto.valPreguEncrypt = $(this).attr('data-texto');
		 objeto.palabraRpta = $(this).val();
		 
		 array.push(objeto);
	 });
	 
	 var result;
	 var response;
	 
	//console.log(array);
		$.ajax({
	          async: true,
			contentType: "application/json",
	        type: "POST",
	        data: JSON.stringify(array),
			url  : context+'/ejercicio/validarCompletarPalabras',
			success : function(data){
				//console.log('SUCCESS response');
				//console.log(data);
				$("#text-input-parrafo input").each(function () 
				 {
					$(this).removeClass('input-valid-opt');
					$(this).removeClass('input-invalid-opt');
					for (var i = 0; i < data.length; i++) {
						if($(this).attr('data-esp') == data[i].nroOrden){
							if(data[i].valValid){
								$(this).addClass('input-valid-opt');
							}else{
								$(this).addClass('input-invalid-opt');
							}
						}
					}
				 });
				response = data;
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
		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
		    			if(response[i].valValid){
		    				result = true;
						}else{
							result = false;
							break;
						}
					}
		    	}
		    	
		    	if(result){
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
		    	}else{
		    		show_msj_masc_fallo($("#msj_2").val()); 
				      insertarIntento(); 
		    	}
		    }
		});
	 
 }