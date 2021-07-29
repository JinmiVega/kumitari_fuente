function agregarInstitucionOperador() {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/nuevoInstOperador",
	    success: function(response){
	    	  $('#bootstrap2').modal('show');
	    	  $('#asignar_operador_modal_body').empty();
	    	  $('#asignar_operador_modal_body').html(response);
	    	  $('#codigoInstitucion_instope').val(codigoInstitucion);
	    	  
	    	  $(".optionReset").val("");
	    	  
	    },error: function(xhr,status,er) {
             //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console.log(er);
		    	//spire_session_901(er);
     			}

	    }
	  });
}

function modificarInstitucionOperador(id) {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/modificarInstOperador?codigo="+id,
	    success: function(response){
	    	  $('#bootstrap2').modal('show');
	    	  $('#asignar_operador_modal_body').empty();
	    	  $('#asignar_operador_modal_body').html(response);
	    	  
	    	  $(".optionReset").val("");
	    	  
	    },error: function(xhr,status,er) {
           //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console.log(er);
		    	//spire_session_901(er);
   			}

	    }
	  });
}



function buscarPersonaPorDocumentoOperador() {
	
	  var tipoDocumento   = $('#tipoDocPersona_busqdato').val();
	  var numeroDocumento = $('#numDocPersona_busqdato').val();
	
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  if(tipoDocumento != 0){
		  if(!(numeroDocumento.length > 0)){
			  msg_advertencia("Digite un número de documento.");
		  }else{
			  if(tipoDocumento == 1){
				  if((numeroDocumento.length < 8)){
					  msg_advertencia("Digite un número de documento de 8 caracteres.");
				  }else{
					  $.ajax({
						    type: "GET",
						    //data: "entidad=" + entidad,
						    url: contextPath+"/institucionController/consultarPorDocumentoPersona?tipo="+tipoDocumento+"&numero="+numeroDocumento,
						    success: function(response){
						    	
						    	if (numeroDocumento.length < 7) {
						    		msg_advertencia("Número de documento incorrecto.");
								}else{
						    	
						    	if(response.codigo > 0){ 
						    		  $('#codigoPersona_instope').val(response.codigo);
						    		  $('#nombresPersona_dato').val(response.nombrePersona+" "+response.apellidoPaterno+" "+response.apellidoMaterno);
						    		  $('#telefonoPersona_dato').val(response.telefono);
						    		  $('#correoPersona_dato').val(response.correo);
						    	  }else{
						    		  msg_advertencia("¡No se encontraron registros.!")
						    	  }
								}
						    },error: function(xhr,status,er) {
					         //console.log("error: " + xhr + " status: " + status + " er:" + er);
								    if(xhr.status==500) {
								    	//console.log(er);
								    	//Error_500(er);
								    }
								    if(xhr.status==901) {
							    	//console.log(er);
							    	//spire_session_901(er);
					 			}

						    }
						  });
				  }
			  }else  if(tipoDocumento == 2){
				  if(!(numeroDocumento.length < 12)){
					  msg_advertencia("Digite un número de documento de 8 caracteres.");
				  }else{
					  $.ajax({
						    type: "GET",
						    //data: "entidad=" + entidad,
						    url: contextPath+"/institucionController/consultarPorDocumentoPersona?tipo="+tipoDocumento+"&numero="+numeroDocumento,
						    success: function(response){
						    	
						    	if (numeroDocumento.length < 7) {
						    		msg_advertencia("Número de documento incorrecto.");
								}else{
						    	
						    	if(response.codigo > 0){ 
						    		  $('#codigoPersona_instope').val(response.codigo);
						    		  $('#nombresPersona_dato').val(response.nombrePersona+" "+response.apellidoPaterno+" "+response.apellidoMaterno);
						    		  $('#telefonoPersona_dato').val(response.telefono);
						    		  $('#correoPersona_dato').val(response.correo);
						    	  }else{
						    		  msg_advertencia("¡No se encontraron registros.!")
						    	  }
								}
						    },error: function(xhr,status,er) {
					         //console.log("error: " + xhr + " status: " + status + " er:" + er);
								    if(xhr.status==500) {
								    	//console.log(er);
								    	//Error_500(er);
								    }
								    if(xhr.status==901) {
							    	//console.log(er);
							    	//spire_session_901(er);
					 			}

						    }
						  });
				  }
			  }else  if(tipoDocumento == 3){
				  $.ajax({
					    type: "GET",
					    //data: "entidad=" + entidad,
					    url: contextPath+"/institucionController/consultarPorDocumentoPersona?tipo="+tipoDocumento+"&numero="+numeroDocumento,
					    success: function(response){
					    	
					    	if (numeroDocumento.length < 7) {
					    		msg_advertencia("Número de documento incorrecto.");
							}else{
					    	
					    	if(response.codigo > 0){ 
					    		  $('#codigoPersona_instope').val(response.codigo);
					    		  $('#nombresPersona_dato').val(response.nombrePersona+" "+response.apellidoPaterno+" "+response.apellidoMaterno);
					    		  $('#telefonoPersona_dato').val(response.telefono);
					    		  $('#correoPersona_dato').val(response.correo);
					    	  }else{
					    		  msg_advertencia("¡No se encontraron registros.!")
					    	  }
							}
					    },error: function(xhr,status,er) {
				         //console.log("error: " + xhr + " status: " + status + " er:" + er);
							    if(xhr.status==500) {
							    	//console.log(er);
							    	//Error_500(er);
							    }
							    if(xhr.status==901) {
						    	//console.log(er);
						    	//spire_session_901(er);
				 			}

					    }
					  });
			  } 
		  } 
	  }else{
		  msg_advertencia("Seleccione tipo del documento.");
	  }
		  
	  //
	 
	  //
}

function enviar_ajax(){
	
	var url = $("#frmGuardarInstOperador").attr("action");

 	$.ajax({
           type: "POST",
           url: url,
           data: $("#frmGuardarInstOperador").serialize(),
           success: function(data)
           { 
        	   if(data == "3"){
        		   msg_advertencia("¡No ha seleccionado operador.!");
        	   }if(data == "1"){
        		  
        		   msg_exito();
        	   }if(data == "0"){
        		   
        		   msg_advertencia("¡Ya existe operador!");
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
		    	$("#closeModalBtnFrm").trigger("click");
		    	listarInstOperador();
		    }
         });
    return false;
}

function refrescarListaInstOperador() {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  var htmlTabla = "";
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/refrescarListaInstOperador?codigoInst="+codigoInstitucion,
	    success: function(response){
	    	//console.log(response);	
	    	for (var i = 0; i < response.length; i++) {
	    		var objInstOperador = response[i];
	    		htmlTabla += 
	    			"<tr>"+
		    			"<td>"+objInstOperador.personaBean.nombreCompleto+"</td>"+
		    			"<td>"+objInstOperador.codigoInstitucion+"</td>"+
		    			"<td>"+objInstOperador.personaBean.numeroDocumento+"</td>"+
		    			"<td>"+
			    			"<div class='mb-0'>"+
			    				"<i class='icon-envelope media-left media-middle'></i>"+
			    				"<div class='media-body'>"+objInstOperador.personaBean.correo+"</div>"+
			    			"</div>"+
			    		"</td>"+
			    		"<td>"+objInstOperador.fechaCreacion+"</td>"+
			    		"<td>"+objInstOperador.nombreSituacion+"</td>"+
			    		"<td>"+
			    			"<button type='button' class='btn btn-outline-success btn-sm' data-toggle='tooltip' data-original-title='Editar' onclick='modificarInstitucionOperador("+objInstOperador.codigo+");'><i class='icon-pencil'></i></button>"+
			    			"<button type='button' class='btn btn-outline-danger btn-sm'  data-toggle='tooltip' data-placement='top' title='' data-original-title='Eliminar' onclick='confirmar_eliminar('operador',"+objInstOperador.codigo+");><i class='icon-trash'></i></button>"+
			    		"</td>"+
	    		"</tr>";
			}
	    	//console.log(htmlTabla);
    	    $('#idBodyListaInstOperador').empty();
    	    $('#idBodyListaInstOperador').html(htmlTabla);
	    },error: function(xhr,status,er) {
           //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console.log(er);
		    	//spire_session_901(er);
   			}

	    }
	  });
}