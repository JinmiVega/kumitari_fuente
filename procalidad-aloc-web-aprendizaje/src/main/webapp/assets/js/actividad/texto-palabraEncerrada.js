 var contextPath = $('#contextPathUrl').val();
  numEjer =0;
  var mteCodigos = [];
	var tamanoPReg=[];
  var dataValor= [];
  var mteCodigos1=[];

// function ListarcodMTPTexto(){
//	    //var codmte =  $('#codigoMTE').val();
//	    var p_TipEje =  $('#codTipoEjer').val();
//	    var p_Leccion =  $('#codLeccion').val();
//
//	    var url =  contextPath+"/lengua/MTE";
//	    var html = "";
//
//	     $.ajax({
//	      type : 'GET',
//	      data :{p_codmatpej : p_Leccion, p_tipo:p_TipEje },
//	      url  : url,
//	       success : function(data) {
//
//	        for(var m=0;m<data.length;m++){
//	          mteCodigos.push(data[m].codigo);
//	        }
//          if(mteCodigos.length>0){
//        	 alert('mteCodigos[0] '+mteCodigos[0]);
//        	  console.log('mteCodigos[0] '+mteCodigos[0]);
//        	  ListarEjercicio(mteCodigos[0]);
//        }
//           $("#btnevaluar").removeClass("disabled");
//
//	          },
//	        error : function(data) {
//	                console.log("error ");
//	    }
//	  });
//	}

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
	    //var codmte =  $('#codigoMTE').val();
	    var codmte =  $('#codigoMTE').val();
	    // var codmte =  codigo;
	    var url =  contextPath+"/lengua/ListAlternTextoPalabraEncerradaTodoxTE";
	    var html = "";
	     $.ajax({
	      async: true,
	      type : 'GET',
	      data :{p_codmatpej : codmte },
	      url  : url,
	       success : function(data) {
	    	 
	    	 tamanoPReg=[];
	         var oracorregida = '';
	         var listDetalle = '';
	         var combo='';
	         var final='';
	         
	         if(data != null && data.length > 0){

		         oracorregida = data != null ? data[0].textoPalabraEncerradaBean.texto : '';

	//
//			          for(var i=0;i<data.length ;i++)
//			          {
//			        		  hora = data[i].palabraEncerrada;
	//
//			        		  oracorregida = oracorregida.replace(hora+"%" , '<strong style="border: aqua;border-style: double;border-radius: 50%;padding: 3px;background: aqua;">'+hora+'</strong>' );
////			        		  listDetalle=data[i].palabraEncerrada;
////		        			  console.log('listDetalle :: '+listDetalle);
	//
//			        	         if (data[i].textoPalabraEncerradaBean.comentario!='' || data[i].textoPalabraEncerradaBean.comentario!=null) {
//			 		            	$(".comentariotPC").html('<span class="pull-left" style="margin-right: 6px;">'
//			 		            						+	'<img src="'+contextPath+'/assets/images/icono-ejercicio/LIBRO-1.png" width="25px">'
//			 		            						+ '</span>' + data[i].textoPalabraEncerradaBean.comentario);
//			 					}else {
//			 						var htmlattri="display: none;";
//			 						$('#coment').attr('style', htmlattri);
//			 						console.log('no trajo comentario::: ');
//			 					}
//			          }
		          for(var e=0;e<50;e++)
		          {
		              var hora='';

		              for(var i=0;i<data.length ;i++)
		              {
			              if(data[i].nroOrden==e)
			              {
			                hora = data[i].palabraEncerrada;
			              }		        
		              }
		              oracorregida = oracorregida.replace("%"+e+"%" , '<strong style="border: aqua solid;border-radius: 50%;padding: 0px 7px;vertical-align: sub;">'+hora+'</strong>' );
		            }



//			           for(var i=0;i<data.length ;i++)
//			           {
//			        	   if (data[i].palabraEncerrada!=null) {
//			        		   html=
//	  			  					'<li style="color: #020202;font-weight: 500;">'+
//	  			  						data[i].palabraEncerrada
//	     							'</li>';
	//
//			        	 //  $('#list-Alter').html(html);
//			        	   final =final+ html;
//						}else {
//							final ='';
//						}
	//
//			           }
//			           $('#list-Alter').html('<ul style="list-style-type:decimal;">'+final+'</ul>');
//			           final =final+ html;
//			             }


//		          console.log("cnt:" + data[0].textoPalabraEncerradaBean.comentario);
	              if (data[0].textoPalabraEncerradaBean.comentario=="" || data[0].textoPalabraEncerradaBean.comentario==null) {
	            	  //var htmlattri="display: none;";
						//$('#coment').attr('style', htmlattri);
	            	  //$('#coment').hide();
	            	  $("#comtpc1").css("display","none");
	            	  $("#comtpc2").css("display","none");
	            	//console.log('no trajo comentario::: ');
					}else {
						
							 $(".comentariotPC").html(data[0].textoPalabraEncerradaBean.comentario);
							 $("#comtpc1").css("display","none");
			            	  $("#comtpc2").css("display","none");	
						
			            	//console.log('trajo comentario::: ');
					}
		          
			           if (data != null) {
		                $('#cambio').html('<p class="font-text" style="text-align: center;font-weight: bold;">  '+ data[0].textoPalabraEncerradaBean.titulo +' </p><p class="font-text" style="text-align: justify;">  '+ oracorregida + ' </p>');
		                // $('#titulos').html('<h4 class="sub-title-app">' + data[0].oracionCompletarBean.materialTipoEjercicioBean.titulo + '</h4><p class="title-minendu ttpregunta" id="title-preg">'+ data[0].oracionCompletarBean.titulo + '</p>' );
		                $('#titulos').html(icono_titulo
		  						+'<h4 class="sub-title-app" style="opacity: 1;">'+ data[0].textoPalabraEncerradaBean.materialTipoEjercicioBean.titulo + '</h4>' );
	
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
	 var p_evalDt = $('#codEvaluacionDet').val();
//   var p_int1 =  $('#intent1').val();
//   var p_int2 =  $('#intent2').val();
//   var p_int3 =  $('#intent3').val();
//   var p_direccion =  $('#direccion').val();
//
//   var resultado =0;
// for(var i=1;i<10;i++){
// if ($("#esp"+i).val() == 1 ||  $("#esp"+i).val() == null ||  $("#esp"+i).val() == '')
// {
// resultado=resultado+1;
// }else{ resultado=resultado+0;
// }
// }
//
//
//  if(resultado == 9){
//
//   if(n_intento==1){
//     alert("HAS GANADO "+ p_int1+" MONEDAS, FELICIDADES");
//     // msg_exito();
//      // msg_info("HAS GANADO "+ p_int1+" MONEDAS, FELICIDADES");
//   }else if(n_intento==2){
//   //  msg_exito();
//       alert("HAS GANADO "+ p_int2+" MONEDAS, FELICIDADES");
//    // msg_info("HAS GANADO "+ p_int2+" MONEDAS, FELICIDADES");
//   } else if (n_intento==3){
//    // msg_exito();
//      alert("HAS GANADO "+ p_int3+" MONEDAS, FELICIDADES");
//   //  msg_info("HAS GANADO "+ p_int3+" MONEDAS, FELICIDADES");
//   } else {
//   //  msg_exito();
//      alert(" NO GANASTE MONEDAS.. UNA PENA");
//   //  msg_info("NO GANASTE MONEDAS.. UNA PENA");
//   }
//
//       numEjer=numEjer+1;
// if(numEjer==mteCodigos.length){
	  

	  //if(punto == tamanoPReg.length){
	   if (p_evalDt != 0) {
			
	
			//correcto
			actulizarEjercicioEvaluacion(p_evalDt,'1');

			
			
		}else{  
	   grabarSeguimientoAlumnoEjercicio(0); 
//    alert("CONCLUISTE CON ESTE TIPO  DE EJERCICIO");
    //location.href =p_direccion;
    siguiente_ejercicio();
// }else{
//   ListarEjercicio(mteCodigos[numEjer]);
// }
//
// //  ListarEjercicio(mteCodigos[numEjer]);
//       n_intento = 1;
//     } else{  n_intento = n_intento+1;
//        // $('#mascotita').attr('src','/procalidad-aloc-web-aprendizaje/assets/images/mascota/mascota-02.png');
//         alert("VUELVE A INTENTARLO");
//   }

 }
	   }
