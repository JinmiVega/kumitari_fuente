 var contextPath = $('#contextPathUrl').val();
  numEjer =0;
  var mteCodigos = [];
	var tamanoPReg=[];
  var dataValor= []; 
  $('#btnevaluar').addClass('disabled'); 

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
		   	            	$(".comentariotPC").html('<span id="content-icon-m">'
					   				+'<i class="icon-notebook"></i>'
						   			+'</span>' + data[0].textoPalabraCorrectaBean.comentario
						   			+ '<span class="close-conten" onclick="ocultarDiv()"></span>');
		   	           //console.log('data[i].textoPalabraCorrectaBean.comentario '+data[0].textoPalabraCorrectaBean.comentario);
		   				}else {

		   					var htmlattri="display: none;";
		   					$('#coment').attr('style', htmlattri);
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

 function valorEvaluacion(){ 
	   var p_evalDt = $('#codEvaluacionDet').val();
	   //if(punto == tamanoPReg.length){		
	 	if (numerodeintento == 1) {
	 		//correcto
	 		actulizarEjercicioEvaluacion(p_evalDt,'1');
	 	}else{
	 		actulizarEjercicioEvaluacion(p_evalDt,'0');
	 	}
	 		
	 		

 }

 var tamanoRespC= [];	 
 
 var punto = 0;
 function changeComboPalabra1(obj){
	 	 

		// $('#'+obj.textContent+'').css('font-weight','600');		
		
	 if ($("#cbComboPalabra").val()==1 ) {

		//console.log("obj :::"+obj);
		//console.log($("#cbComboPalabra option:selected").text());
			 $('#'+obj).attr('class', "democlassPC");
			 $('#'+obj).removeClass("contentPalabra");
			 tamanoRespC.push($("#cbComboPalabra").val());
			 $('#'+obj).text($("#cbComboPalabra option:selected").text());
			//console.log('tamanoRespC.push:::: ' + tamanoRespC);
			 punto++;
//		 var contPC=0;
//		 var contPC1=0;
//			for(var m=0;m<tamanoRespC.length;m++){
//				if (tamanoRespC.length>=tamanoPReg.length) {
//					contPC=contPC+1;
//				}else{
//					contPC=contPC+0;
//			 	}
//	        }
//		 console.log('contPC:::'+contPC);
//		 
//		 if (contPC==tamanoPReg.length) {
//				for(var i=0;i<tamanoRespC.length;i++){
//					if (tamanoRespC[i]==1) {
//						contPC1=contPC1+1;
//					}else{
//						contPC1=contPC1+0;
//				 	}
//		        }
//				 console.log('contPC1:::'+contPC1);
//			 
//				if (contPC1==tamanoPReg.length) {
//					correcto = 1;
////					 show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
////					 $('#btnevaluar').removeClass('disabled');
//					
//					 
//					 
//				}else{
//					console.log('nada');
//				}
//
//		}
	}else if ($("#cbComboPalabra").val()==0) {
		//console.log("obj :::"+obj);
		//console.log($("#cbComboPalabra option:selected").text());
			 $('#'+obj).attr('class', "democlassPC");
			 $('#'+obj).removeClass("contentPalabra");
//		contPC1=0;
//		contPC=0;
//		tamanoPReg=[];
//		tamanoRespC=[];
//		 ListarEjercicio();
//	      show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
//	      insertarIntento();
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
 function valorEvaluacion(){
		 
		var codEvaDe =$('#codEvaluacionDet').val();
	if (punto ==tamanoPReg.length) {
		actulizarEjercicioEvaluacion(codEvaDe,'1');
		$('#codEvaluacionDet').val('0');
	}else{
		actulizarEjercicioEvaluacion(codEvaDe,'0');
		$('#codEvaluacionDet').val('0');
	}
	}
 
 function changeComboPalabra(){
		//console.log("title:" + $("#cbComboPalabra").attr("id"));
		 //$("#esp"+ $("#cbComboPalabra").attr("title")).val($("#cbComboPalabra").val());
		 $("#esp"+ $("#cbComboPalabra").attr("id")+" option").each(function(){
			//console.log($(this).text());
			   if( $(this).text() == $("#cbComboPalabra option:selected").text() ) {
				 //console.log("entro");
			     $(this).prop("selected","selected");
			   } else{
				 //console.log("no entrpo");
			 }
			 });
	 }
 
 $(document).ready(function(){
	 $('#cbComboPalabra').empty();
	 $(document).on('click', '.contentPalabra', function (e) {
		 	//debugger;
		    // Avoid the real one
		    e.preventDefault();

		  //console.log("idpalabra: " + $(this).attr("id"));
		    var idpal= $(this).attr("id");
		    $("#box-shadow-div").empty();
		    $("#box-shadow-div").show(100).css({
		        top: e.pageY + "px",
		        left: e.pageX + "px"
		    }).html('<select id="cbComboPalabra" class="select-app"  onchange="changeComboPalabra();changeComboPalabra1('+idpal+');"><option value="0" >-----------</option> </select>');//title="'+$(this).attr("id")+'"

		    //$('#cbComboPalabra').empty();
		    //

		    var url = contextPath+"/lengua/ListAlternTextoPalabraCorrectaXNombrePCYcodigoCab?p_palabracorrecta="+$(this).attr("id").trim()+"&p_codtextopalabracorrec="+$("#codCabPC").val();
			 var html = "";
		     $.ajax({
		    	 async: true,
		         type : 'GET',
		          url  : url,
		          success : function(data) {
		        	//console.log("data: " + data);
			         if (data != null) {
			              for(var i=0;i<data.length;i++){
			            	  $('#cbComboPalabra').append($('<option>', {
				  				    value: data[i].respuestaEstado,
				  				    text:  data[i].descripcion
				  				}));
			                }

					}else{}
		          },
		          error : function(data) {
		        	//console.log("error ");
		           }
		     });
		    //$("#box-shadow-div").html("Alternativa" +  $(this).attr("id"));
		    // In the right position (the mouse)
		     return false;
		});


		// If the document is clicked somewhere
		$(document).bind("mousedown", function (e) {


		    // If the clicked element is not the menu
		    if (!$(e.target).parents("#box-shadow-div").length > 0) {

		        // Hide it
		        $("#box-shadow-div").hide(100);
		    }
		});

 });