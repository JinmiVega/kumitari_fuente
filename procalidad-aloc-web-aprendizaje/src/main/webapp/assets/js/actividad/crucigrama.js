      var contextPath = $('#contextPathUrl').val();
      var n_intento = 1;
      var tamanoPReg=[];
      var datos=[];
      var listado=[];
      
      function ListarEjercicio(){
        var codmte =  $('#codigoMTE').val();
        
        var url =  contextPath+"/lengua/listarCrucigrama";
        var html = "";
        $.ajax({
          async: true,
          type : 'GET',
          data :{idEjercicio : codmte },
          url  : url,
          success : function(data) {
            tamanoPReg=[];
            for(var m=0;m<data.length;m++)
            {
                tamanoPReg.push(data[m].codigo);
            }
            datos=data;
            
            if(data != null) {
	        	var ayudas='';
	            for(var m=0;m<tamanoPReg.length;m++){
	            	if (datos[m].orden==0){
	            		ayudas=ayudas + '<li style="cursor:auto"><span>'+(m+1)+'.-'+' '+ data[m].texto+'</span></li>'
	            	}else{
	            		ayudas=ayudas + '<li style="cursor:auto"><span style="font-size: 12px;">'+(data[m].orden)+'.-'+' '+ data[m].texto+'</span></li>'
	                }
	            }
	
	            init_puzzle();
	
		        $('#lst-rsp-oracion').html(ayudas);
			    $('#titulos').html(icono_titulo+' <h4 class="sub-title-app">' + [0].relacionCabeceraBean.materialTipoEjercicioBean.titulo + '</h4>' );
		      
		   }else{
			   return false;
           }
           $("#btnevaluar").removeClass("disabled");
          },
          error : function(data) {
        	  //console.log("error ");
	        }
	      });
      }

              function init_puzzle(){
                var container='jpit_activity_crossword'; //id del contenedor ppal
                var properties={'caseSensitive':false}; // propiedades: caseSensitive para que el cross sea sensible a letras mayusclas

                //Array de palabras y la instancia de cada palabra con sus propiedades y direccion en el tablero
                var words=new Array();

                var cruci = '' ;
                for(var m=0;m<tamanoPReg.length;m++){
                  if (datos[m].orientacion==1){
                	  //ayudas=ayudas + '<li style="cursor:auto"><span>'+(datos[m].orden)+'.-'+' '+ data[m].texto+'</span></li>'
                 //   cruci=cruci+"words["+m+"]=new jpit.activities.crossword.word('"+datos[m].palabra+"',"+datos[m].texto2+","+datos[m].texto2+",'"+m+"',jpit.activities.crossword.directions.lr);  "
                   if(datos[m].orden==0){
                	   
                	  words[m]=new jpit.activities.crossword.word(datos[m].palabra,parseInt(datos[m].texto2),parseInt(datos[m].texto3),(m+1).toString(),jpit.activities.crossword.directions.lr,datos[m].codigo,datos[m].cantletras);
                  
                   }else {
                	   words[m]=new jpit.activities.crossword.word(datos[m].palabra,parseInt(datos[m].texto2),parseInt(datos[m].texto3),(datos[m].orden).toString(),jpit.activities.crossword.directions.lr,datos[m].codigo,datos[m].cantletras);
                      }
                  }else if(datos[m].orientacion==2){
                   // cruci=cruci+"words["+m+"]=new jpit.activities.crossword.word('"+datos[m].palabra+"',"+datos[m].texto2+","+datos[m].texto3+",'"+m+"',jpit.activities.crossword.directions.tb);  "
                  if(datos[m].orden==0){
                	  words[m]=new jpit.activities.crossword.word(datos[m].palabra,parseInt(datos[m].texto2),parseInt(datos[m].texto3),(m+1).toString(),jpit.activities.crossword.directions.tb,datos[m].codigo,datos[m].cantletras);
                  }else{
                	  words[m]=new jpit.activities.crossword.word(datos[m].palabra,parseInt(datos[m].texto2),parseInt(datos[m].texto3),(datos[m].orden).toString(),jpit.activities.crossword.directions.tb,datos[m].codigo,datos[m].cantletras);
                      }
                  }
                }
                //instancia del tablero con el contenedor, las palabras y las propiedades
                puzzle=new jpit.activities.crossword.game(container,words,properties);
                $('.jpit_activities_crossword_cell input:first').focus();//foco en el primer cajon del crossword
            }
   
      var puzzle;
            //Metodo que inicializa todo el escenario
            //Metodo para verificar el crossword
            function verify_(){
              var p_evalDt = $('#codEvaluacionDet').val();
              var p_int1 =  $('#intent1').val();
              var p_int2 =  $('#intent2').val();
              var p_int3 =  $('#intent3').val();
              $('.jpit_activity_crossword_help_btn').hide();

                $('.jpit_activity_crossword_verify_btn').hide(); //se oculta el boton de verificar
                puzzle.stop(); // se detiene el crossword para que no se manipulado
                puzzle.highlight('jpit_activity_crossword_correct','jpit_activity_crossword_mistake');// se "ilumnan" las letras correctas y las malas

                //se verifica que todas y cada una de las palabras y letras esten correctamente resueltas
                if(puzzle.getTotalResult()==puzzle.words.length){
                    // La mascota manda un mensaje
                	show_msj_masc_exito($("#msj_1").val());
//                	show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
                    //si esta completamente bien resuelto se muestra una buena retroalimentación
                    $(".jpit_activity_crossword_feedback").animate({height:"show",width:"show"},1000,"linear")
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
//                	show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
                    //si NO esta completamente bien resuelto se muestra una mala retroalimentación
                    $(".jpit_activity_crossword_bad_feedback").animate({height:"show",width:"show"},1000,"linear");
                    //se habilita el boton para reiniciar el escenario y obtener  a un nuevo intento
                    $('.jpit_activity_crossword_modify_btn').show();
                    insertarIntento();
                }
            }

            //  Metodo para reiniciar el crossword
            function continue_(){
                $('.jpit_activity_crossword_verify_btn').show();//se oculta el boton de verificar
                $('.jpit_activity_crossword_modify_btn').hide();//se oculta el boton de modificar
                //se oculta la retroalimentación mala
                    $(".jpit_activity_crossword_bad_feedback").animate({height:"hide",width:"hide"},1000,"linear",function(){
                    $(".jpit_activity_crossword_verify_btn").show()
    });
                puzzle.run();// se desbloquea el crossword
                puzzle.cleanMistakes();// se limpian las letras erroneas
                puzzle.unHighlight('jpit_activity_crossword_mistake');
                puzzle.unHighlight('jpit_activity_crossword_correct');
//                $('.jpit_activity_crossword_help_btn').show();
                
            }
            
            function help_(){   
                puzzle.letrasDeAyuda();// se muestran letras correctas al azar
                $('.jpit_activity_crossword_help_btn').hide();
                puzzle.highlight('jpit_activity_crossword_correct');
            }


            $(document).ready(function(){
                //se asignan los metodos a los botones de verificar y modificar
                $('.jpit_activity_crossword_verify_btn').click(function(){verify_()});
                $('.jpit_activity_crossword_modify_btn').click(function(){continue_()});
//                $('.jpit_activity_crossword_modify_btn').click(function(){help_()});
                $('.jpit_activity_crossword_help_btn').click(function(){help_()});
                //se invoca el inicio del crossword

            });

