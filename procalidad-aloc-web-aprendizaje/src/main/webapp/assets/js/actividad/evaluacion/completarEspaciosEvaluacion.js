  var contextPath = $('#contextPathUrl').val();


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
	          oracorregida = data[0].oracionCompletarBean.oracion;
	          for(var e=0;e<19;e++)
	          {
	              var hora='<option selected="true" value="0">----</option>';

	              for(var i=0;i<data.length ;i++)
	          {
	              if(data[i].espacio==e && data[i].descripcion!='')
	              {
	            	  
	                hora = hora + "<option value='"+data[i].respuestaEstado+"'>"+data[i].descripcion+"</option>" +""
	               }
	          }
	               hora = '<select id="esp'+ e+'" class="select-app" onchange="validarRpta(this)">'+ hora + '</select>';
	               oracorregida = oracorregida.replace("%"+e+"%" , hora );
	            }
	              if (data != null) {
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
	          },
	        error : function(data) {
	                //console.log("error ");
	    }
	  });
}

 var aciertos = 0;
 var totalOpt = 0;
 
function validarRpta(e){
//	debugger;
	//console.log('totalOpt: '+totalOpt);
	var id = $(e).attr('id');
	//var esp = id.substring(3,id.length);
	//console.log('espacio: '+esp);
	
	if($(e).val() == "1"){
//		$(e).removeClass('selec-invalid-opt');
//		$(e).addClass('selec-valid-opt');
		aciertos++;
//		$(e).prop('disabled',true);
//		if(aciertos == totalOpt){
//			show_msj_masc_exito($("#msj_1").val());
//			show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
//			$("#btnevaluar").removeClass("disabled");
//		}
		
	}else{
//		$(e).removeClass('selec-valid-opt');
//		$(e).addClass('selec-invalid-opt');
//		show_msj_masc_fallo($("#msj_2").val());
//		show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
		//ListarEjercicio();
		//insertarIntento();
	}
} 
 
 
function valor(){
  
  var p_evalDt = $('#codEvaluacionDet').val();

 if(aciertos == totalOpt){	 
	 actulizarEjercicioEvaluacion(p_evalDt,'1');
	 $('#codEvaluacionDet').val('0');
    } else{
     actulizarEjercicioEvaluacion(p_evalDt,'0');
     $('#codEvaluacionDet').val('0');
  }


}

