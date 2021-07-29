function time_contador() {
    
	setTimeout(function(){
        for (var i = 0; i < 30; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
        $("#pf_01").show();
     }, 1500);

    setTimeout(function(){
        for (var i = 0; i < 60; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
        $("#pf_02").show();
     }, 3000);


    setTimeout(function(){
        for (var i = 0; i < 90; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
        $("#pf_03").show();
     }, 4500);

    setTimeout(function(){
        for (var i = 0; i < 101; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
     }, 5500);

}

/*$( "#generar-archivo" ).click(function() {
     var cmm_lengua    = $('#cmm_lengua').val();
     var cmm_nivel     = $('#cmm_nivel').val();
     var cmm_sub_nivel = $('#cmm_sub_nivel').val();
     var cmm_unidades  = $('#cmm_unidades').val();

    $('#cmm_info_leng').text(cmm_lengua);
    $('#cmm_info_nivel').text(cmm_nivel);
    $('#cmm_info_s_nivel').text(cmm_sub_nivel);
    $('#cmm_info_unidades').text(cmm_unidades);

    $('#cmm_descarga').removeClass("hidden").show(300);
});*/

function mmr_limpiar(){
	$('#cmm_descarga').addClass("hidden").hide(300);
	
	var html = "<option value='0'>Seleccione</option>";
	$('#cmm_lengua').val('0');
	$('#cmm_nivel').empty();
	$('#cmm_nivel').html(html);
	$('#cmm_sub_nivel').empty();
	$('#cmm_sub_nivel').html(html);
	$('#cmm_unidades').empty();
	$('#cmm_unidades').html(html);
	$('#generar-archivo').prop('disabled',false);
}


/** IMPLEMENTACION **/
function cargarNiveles(){
	var idLengua = $('#cmm_lengua').val();
	var contextPath = $('#contextPathUrl').val();
	var html = "";
	
	if(idLengua!='0'){
		iniciarBloqueo();
		$.ajax({
			type: "GET",
			data: "codlengua="+idLengua,
		    url: contextPath+"/cargaMasivaController/cargarNiveles",
	        success: function(data)
	        {	
	   	    	if(data!=null){
	   	    		
	   	    		data.sort(function (a, b){
	   	    		    return (a.codigoRegistro - b.codigoRegistro);
	   	    		});
	   	    		
	   	    		html+="<option value='0'>Seleccione</option>";
	   	    		for(var i=0; i<data.length;i++){
	   	    			html+="<option value='"+data[i].codigoRegistro+"'>"+data[i].nombreCorto+"</option>";
					}
	   	    	}else{
	   	    		html+="<option value='0'>Seleccione</option>";
	   	    	}
	   	    	
	        },
			   error: function(xhr,status,er) {
				   ////console.log("error: " + xhr + " status: " + status + " er:" + er);
				   if(xhr.status==500) {
					   //console.log(er);
				 //    Error_500(er);
				   }
				   if(xhr.status==901) {
					   //console.log(er);
			    //	   spire_session_901(er);
	 		   }
			   },
			   complete: function(){
				   finBloqueo();
				   $('#cmm_nivel').empty();
				   $('#cmm_nivel').html(html);
			   }
	      });
	}else{
		html = "<option value='0'>Seleccione</option>";
		$('#cmm_nivel').empty();
		$('#cmm_nivel').html(html);
		$('#cmm_sub_nivel').empty();
		$('#cmm_sub_nivel').html(html);
		$('#cmm_unidades').empty();
		$('#cmm_unidades').html(html);
	}
	
}

function cargarSubNiveles(){
	var idLengua = $('#cmm_lengua').val();
	var idNivel	 = $('#cmm_nivel').val();
	var contextPath = $('#contextPathUrl').val();
	var html = "";
	
	if(idNivel!='0'){
		iniciarBloqueo();
		$.ajax({
			type: "GET",
			data: "codlengua="+idLengua+"&codnivel="+idNivel,
		    url: contextPath+"/cargaMasivaController/cargarSubNiveles",
	        success: function(data)
	        {	
	        	if(data!=null && data.length>0){
	        		
	        		data.sort(function (a, b){
	   	    		    return (a.subNivel.codigoRegistro - b.subNivel.codigoRegistro);
	   	    		});
	        		
	   	    		html+="<option value='0'>Seleccione</option>";
	   	    		for (var i = 0; i < data.length; i++) {
						html += "<option value='" + data[i].codigo + "'>"+ data[i].subNivel.nombreCorto + "</option>";
					}
	   	    	}else{
	   	    		html+="<option value='0'>Seleccione</option>";
	   	    	}
	        	
	        },
			   error: function(xhr,status,er) {
				   //console.log("error: " + xhr + " status: " + status + " er:" + er);
				   if(xhr.status==500) {
					   //console.log(er);
				 //    Error_500(er);
				   }
				   if(xhr.status==901) {
					   //console.log(er);
			    //	   spire_session_901(er);
	 		   }
			   },
			   complete: function(){
				   finBloqueo();
				   $('#cmm_sub_nivel').empty();
				   $('#cmm_sub_nivel').html(html);
			   }
	    });
	}else{
		html = "<option value='0'>Seleccione</option>";
		$('#cmm_sub_nivel').empty();
		$('#cmm_sub_nivel').html(html);
		$('#cmm_unidades').empty();
		$('#cmm_unidades').html(html);
	}
	
}

function cargarUnidades(){ 
	var idLenEstSubNivel  = $('#cmm_sub_nivel').val();
	var contextPath = $('#contextPathUrl').val();
	var html = "";
	
	iniciarBloqueo();
	$.ajax({
		type: "GET",
		data: "codlenest="+idLenEstSubNivel,
	    url: contextPath+"/cargaMasivaController/cargarUnidades",
        success: function(data)
        {	
        	if(data!=null && data.length>0){
        		data.sort(function (a, b){
   	    		    return (a.unidad.codigoRegistro - b.unidad.codigoRegistro);
   	    		});
        		
        		html += "<option value='0'>Seleccione</option>";
				for (var i = 0; i < data.length; i++) {
					html += "<option value='" + data[i].codigo + "'>"+ data[i].unidad.nombreCorto + "</option>";
				}
   	    	}else{
   	    		html+="<option value='0'>Seleccione</option>";
   	    	}
        	
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
			   finBloqueo();
			   $('#cmm_unidades').empty();
			   $('#cmm_unidades').html(html);
		   }
    });
}

/** GENERACION DE ARCHIVO **/
function generarArchivo(){
    var cmm_lengua    = $('#cmm_lengua').val();
    var cmm_nivel     = $('#cmm_nivel').val();
    var cmm_sub_nivel = $('#cmm_sub_nivel').val();
    var cmm_unidades  = $('#cmm_unidades').val();
    var contextPath   = $('#contextPathUrl').val();
	var html = "";
	
	if(cmm_lengua=='0'){
		msg_advertencia("Debe seleccionar una lengua");
		return false;
	}
	
	if(cmm_nivel=='0'){
		msg_advertencia("Debe seleccionar un nivel");
		return false;
	}
	
	if(cmm_sub_nivel=='0'){
		msg_advertencia("Debe seleccionar un subnivel");
		return false;
	}
	
	if(cmm_unidades=='0'){
		msg_advertencia("Debe seleccionar una unidad");
		return false;
	}
	
	var cnmsubnivelnom =$('select[id="cmm_sub_nivel"] option:selected').text();
	var cnmunidadnom =$('select[id="cmm_unidades"] option:selected').text();
	
	iniciarBloqueo();
	$.ajax({
		type: "GET",
		data: "codlengua="+cmm_lengua+"&codnivel="+cmm_nivel+"&codsubnivel="+cmm_sub_nivel+"&codunidad="+cmm_unidades+"&cmmsubnivelnom="+cnmsubnivelnom+"&cmmunidadesnom="+cnmunidadnom,
	    url: contextPath+"/cargaMasivaController/generarArchivo",
        success: function(data)
        {	
        	msg_exito();
        	$('#generar-archivo').prop('disabled',true);
        	
        	$('#detalle-archivo-generado').empty();
	    	$('#detalle-archivo-generado').html(data);
        	
        },
	    error: function(xhr,status,er) {
		    //console.log("error: " + xhr + " status: " + status + " er:" + er);
		    if(xhr.status==500) {
			   //console.log(er);
		       //Error_500(er);
		    }
		    if(xhr.status==901) {
			   //console.log(er);
	    	   //spire_session_901(er);
	        }
	    },
	    complete: function(){
	    	finBloqueo();
	    	
		    $('#cmm_info_leng').text($("#cmm_lengua option:selected").text());
		    $('#cmm_info_nivel').text($("#cmm_nivel option:selected").text());
		    $('#cmm_info_s_nivel').text($("#cmm_sub_nivel option:selected").text());
		    $('#cmm_info_unidades').text($("#cmm_unidades option:selected").text());

		    $('#cmm_descarga').removeClass("hidden").show(300);
	    }
    });
}

function subirArchivoCarga(){
	console.log('------------');
	
	var file = $('#basicInputFile').val();
	//console.log(file);
	if (!file) { 
		msg_info('No se ha seleccionado ningún archivo');
	}else{ 
		var extension = (file.substring(file.lastIndexOf("."))).toLowerCase();
		console.log(extension);
		
		if(extension!='.xls' && extension!='.xlsx'){
			msg_advertencia('Comprueba la extensión del archivo a subir. Sólo se pueden subir archivos excel');
		}else{
			//$('#idFormSubirCargaMasiva').submit();
			ejecutar_post_subir();
		}	
	}
}

function ejecutar_post_subir(){
	
	var form = $('#idFormSubirCargaMasiva');
	var formData = new FormData(form[0]);
	
	iniciarBloqueo();
	console.log(form.attr('action'));
	$.ajax({
           type: 'POST',
           url : form.attr('action'),
           data: formData,
           contentType: false,
           processData: false,
           success: function(data)
           { 
				console.log(data);
				if(data == 3){
					msg_advertencia('Tipo de archivo no valido');
					
				}else{
					msg_exito();
				}
        	    
           },
			error: function(xhr,status,er) {
				msg_error();
		     	//console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			 //   	Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console.log(er);
		    //	spire_session_901(er);
    			}
		    },
		    complete: function(){
		    	finBloqueo();
		    	$('#basicInputFile').val('');
		    	$('#basicInputFileRar').val('');
		    }
         });
    return false;
}

