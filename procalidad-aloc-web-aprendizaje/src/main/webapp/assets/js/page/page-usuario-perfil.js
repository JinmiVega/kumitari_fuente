var contextPath = $('#contextPath').val();

function grabarfotouser(){
	showLoad();
	var actionForm = $('#frmsubirfotouser').attr("action");
	var idpersona = $('#codigoPersona').val();
	var idcodusu = $('#codigousarioBean').val();
	
	var inputFileImage 	= document.getElementById('fileSubNivel');
	var file 			= inputFileImage.files[0];
	var data 			= new FormData();
	 
	
	data.append('codigo',	idpersona);
	data.append('files',		file);  
	data.append('codusu',		idcodusu);  
	
	let url = contextPath + "/perfil/actualizarDatosFotoUser2";

	  var $myForm = $('#frmsubirfotouser');
		// validar todos los required
//		if(!validarTextoTextoImagen()) {
	  
			if(file=='' || file==null ||file=='undefined' || file ==undefined)  {
				msg_info("Debe completar los campos requeridos correctamente");
			
		}else{
	$.ajax({
		 async: true,
		type : "POST",
		url : url,
		contentType:false,
		data : data,
   		processData:false,
   		cache:false,
		success : function(data) {
			
//		console.log('data.validasw' + data.validasw);
//			if (data.validasw == "1") {
				msg_exito();
				location.reload();
//			}
		},
		error : function(xhr, status, er) {
		
			//console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				//console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				//console.log(er);
				// spire_session_901(er);
			}
		},
		   complete: function(){
			   	hideLoad();
					
			   }
	});
		}
}

function grabardatosUser() {
	//console.log("$('#codigoPersona').val()"+$('#codigoPersona').val());
	showLoad();
	var idpersona = $('#codigoPersona').val();
	var varcorreo = $('#mail_user').val();
	var vartelf = $('#telefonoUser').val();
	
	var url = contextPath + "/perfil/actualizarDatosuser"; 
	
	if( vartelf == "(000) 000-0000 / 000-000-000"){
		$("#telefonoUser").focus();
		msg_advertencia("Debe completar correctamente todos los campos requeridos");
	} else if(ValidarCorreo()==false){
		msg_advertencia("Debe completar correctamente todos los campos requeridos");
	}else if(ValidarTelefono()==false){
		msg_advertencia("Debe completar correctamente todos los campos requeridos");
	} 
	
	else {
		 msg_validar("msg-info-d",null);
	  	var $myForm = $('#frm-info');
 		// validar todos los required
 		if(! $myForm[0].checkValidity()) {
 			//alert("Debe completar los campos requeridos correctamente");
 			
 		}else{

 			$("#frm-info").addClass("bloqueoTotal");
 			
			$.ajax({
				 async: true,
				type : "POST",
				url : url,
		
				data : {codigo:idpersona,correo:varcorreo,telefono:vartelf},
				success : function(data) {
				
					if (data == "1") {
						msg_exito();
						btnGuardar('1');
						//msg_exito(); 
						
					}
					
				},
				error : function(xhr, status, er) {
					//msg_error();
					msg_error();
					//console.log("error: " + xhr + " status: " + status + " er:" + er);
					if (xhr.status == 500) {
						//console.log(er);
						// Error_500(er);
					}
					if (xhr.status == 901) {
						//console.log(er);
						// spire_session_901(er);
					}
				},
				   complete: function(){
					   	hideLoad();
			 			$("#frm-info").removeClass("bloqueoTotal");
							
					   }
			});
 		}
	}
	
}


function cambiarpassnewold() {
	//console.log("$('#codigoPersona').val()2222"+$('#codigousarioBean').val());
	showLoad();
	var idcodusu = $('#codigousarioBean').val();
	var varcorreo = $('#passwaocul').val();
	var vartelf = $('#passwn').val();
	
	var url = contextPath + "/perfil/cambiarPass"; 

	  var $myForm = $('#frm-passw');
 		// validar todos los required
 		
	$.ajax({
		 async: true,
		type : "POST",
		url : url,
		data:{codigo:idcodusu,oldpass:varcorreo,newpass:vartelf},
		
		success : function(data) {
		
			if (data == 1) {
				alert('SE CAMBIO LA CONTRASEÑA')
				msg_exito();
				//location.reload();
				/*var URLactual= window.location.toString();
				fragmentoTexto = URLactual.split('/');
				var url_home=fragmentoTexto[0]+'/'+fragmentoTexto[1]+'/'+fragmentoTexto[2]+'/'+fragmentoTexto[3]+'/';
				
				console.log(url_home);
				window.locationf=url_home;*/
				//msg_exito(); 
				
			}
			
		},
		error : function(xhr, status, er) {
			//msg_error();
			msg_error();
			//console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				//console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				//console.log(er);
				// spire_session_901(er);
			}
		},
		   complete: function(){
			   	hideLoad();
					
			   }
	});
 		
}
