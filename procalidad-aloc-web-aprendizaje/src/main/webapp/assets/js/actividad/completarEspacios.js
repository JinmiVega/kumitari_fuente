  var contextPath = $('#contextPathUrl').val();
  var p_int1 =  $('#intent1').val();
  var p_int2 =  $('#intent2').val();
  var p_int3 =  $('#intent3').val();

 function ListarEjercicio(){
    //var codmte =  $('#codigoMTE').val();
    var codmte =  $('#codigoMTE').val();
    var url =  contextPath+"/lengua/ListTodoxTE";
    var html = "";
     $.ajax({
      async: true,
      type : 'GET',
      data :{p_codmatpej : codmte },
      url  : url,
       success : function(data) {
    	 //console.log("data length " +data.length );
    	 //console.log(data);
      var oracorregida = '';
      var v_cambiotitu = '';
      
      if(data != null && data.length > 0){

          oracorregida = data[0].oracionCompletarBean.oracion;
					v_cambiotitu = data[0].oracionCompletarBean.titulo;
					//alert('data: '+String(data));
						for(var e=0;e<19;e++)
						{
							var hora='<option selected="true" value="0">----</option>';
							//var arr_aux = [];
              for(var i=0;i<data.length ;i++)
							{
			
								//alert('e: '+e);
							//	alert('espacio: '+data[i].espacio);
									if(data[i].espacio==e && data[i].descripcion!='')
									{
										//alert('respuestaEstado:'+data[i].respuestaEstado);
										//alert('descripcion: '+data[i].descripcion);
										hora = hora + "<option value='"+data[i].respuestaEstado+"'>"+data[i].descripcion+"</option>" +""
										/* obj = {
											respuestaEstado:data[i].respuestaEstado,
											descripcion:data[i].descripcion
										}
										arr_aux[0] = obj;
										for (let a = 0; a < arr_aux.length; a++) {
											if(arr_aux[a].respuestaEstado != data[i].respuestaEstado && arr_aux[a].descripcion != data[i].descripcion){
												arr_aux.push(obj);
											}
										}
										console.log(arr_aux);
										alert(arr_aux);*/
									}
							}
							 hora = '<select id="esp'+ e+'" class="select-app" onchange="validarRpta(this)">'+ hora + '</select>';
							 oracorregida = oracorregida.replace("%"+e+"%" , hora );
							 	//alert('hora: '+oracorregida);
								//$('#itdPrueba').html(oracorregida);
            }
              if (data != null) {
            	  $('#cambiotitu').html(v_cambiotitu);
                $('#cambio').html('<p class="font-text" style="text-align: justify;">  '+ oracorregida + ' </p>');
                // $('#titulos').html('<h4 class="sub-title-app">' + data[0].oracionCompletarBean.materialTipoEjercicioBean.titulo + '</h4><p class="title-minendu ttpregunta" id="title-preg">'+ data[0].oracionCompletarBean.titulo + '</p>' );
               // $('#titulos').html('<p class="title-minendu ttpregunta" id="title-preg" style="margin-top:50px">'+ data[0].oracionCompletarBean.materialTipoEjercicioBean.titulo + '</p>' );
                $('#titulos').html(icono_titulo+'<h4 class="sub-title-app">' + data[0].oracionCompletarBean.materialTipoEjercicioBean.titulo + '</h4>' );
								//$("#btnevaluar").removeClass("disabled");
                $("#cambio select").each(function () 
        		 {
        			totalOpt++;
        		 });
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
 
 var aciertos = 0;
 var totalOpt = 0;
 
function validarRpta(e){
	
	//console.log('totalOpt: '+totalOpt);
	var id = $(e).attr('id');
	//var esp = id.substring(3,id.length);
	//console.log('espacio: '+esp);
	
	if($(e).val() == "1"){
		$(e).removeClass('selec-invalid-opt');
		$(e).addClass('selec-valid-opt');
		aciertos++;
		$(e).prop('disabled',true);
		resetImgMascota(1); // Regresar la mascota inicial
		hide_msj_mascota();
		if(aciertos == totalOpt){
			show_msj_masc_exito($("#msj_1").val());
//			show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
			$("#btnevaluar").removeClass("disabled");
		}
		
	}else{
		$(e).removeClass('selec-valid-opt');
		$(e).addClass('selec-invalid-opt');
		show_msj_masc_fallo($("#msj_2").val());
//		show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
		//ListarEjercicio();
		insertarIntento();
	}
} 

function valor(){
	if(aciertos == totalOpt){
		if(numerodeintento == 1){ 
		   guardarMonedas(p_int1,0);
		   grabarSeguimientoAlumnoEjercicio(p_int1); 
		   }else if(numerodeintento==2){
		   guardarMonedas(p_int2,0); 
		   grabarSeguimientoAlumnoEjercicio(p_int2); 
		   }else if (numerodeintento==3){
		   guardarMonedas(p_int3,0);
		   grabarSeguimientoAlumnoEjercicio(p_int3); 
		   } else { 
		   grabarSeguimientoAlumnoEjercicio(0);  
		   }siguiente_ejercicio(); 
	}else{
//		show_msj_masc_info('No has completado el ejercicio.');
		return;
	}
}

/*function valor(){

  var p_int1 =  $('#intent1').val();
  var p_int2 =  $('#intent2').val();
  var p_int3 =  $('#intent3').val();
  var p_direccion =  $('#direccion').val(); 
  
  var resultado =0;
for(var i=1;i<19;i++){
if ($("#esp"+i).val() == 1 ||  $("#esp"+i).val() == null ||  $("#esp"+i).val() == '')
{
resultado=resultado+1;
}else{ resultado=resultado+0;
}
}


		 if(resultado == 18){ 
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
	 show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');

   siguiente_ejercicio();

      
    } else{
      ListarEjercicio();
      show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
      insertarIntento();
  }

}*/