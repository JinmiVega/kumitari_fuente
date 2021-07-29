function btnModicar(tipo){
	//debugger;
	if(tipo=='1'){
		$(".mdf-btn-info").hide();
		$("#mGuardar-btn-info").show();
		camposInputsInfo(false);
	}if(tipo=='2'){
		$("#mGuardar-contrasenia").show();
		$(".mdf-btn-contrasenia").hide();
		 var html='<div class="alert alert-info alert-dismissible fade in" role="alert"> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button> Si cambia la contraseña, se cerrará la sesión. Por favor, asegúrese de que todo está cerrado y guardado</div>';
		 	$("#msg-passw").html(html);
		camposInputsPassw(false);
	}
}

function btnGuardar(tipo){

	if(tipo=='1'){
		if(ValidarCorreo()==false){
			return false;
		}
		$(".mdf-btn-info").show();
		$("#mGuardar-btn-info").hide();
		camposInputsInfo(true);
	}if(tipo=='2'){
		if (validarPaginaClave()==false)
		{
			return false;
		}
		
		$(".mdf-btn-contrasenia").show();
		$("#mGuardar-contrasenia").hide();
		camposInputsPassw(true);
	}
}

function camposInputsInfo(valor){
	$("#frm-info input").prop('disabled', valor);
}

function camposInputsPassw(valor){
	$("#frm-passw input").prop('disabled', valor);
}

function validarPaginaClave()

	{
		if($("#frm-passw #passwa").val() == "")
		{
			$("#frm-passw #passwa").focus();
			msg_validar("msg-passw","Ingrese la contraseña del acceso actual");
         	return false;
     	}

		if($("#frm-passw #passwn").val() == "" || $("#frm-passw #passwn").val().length < 4)
		{
				$("#frm-passw #passwn").focus();
				if($("#frm-passw #passwn").val() == ""){
					msg_validar("msg-passw","Ingresar la nueva contraseña");				
				} else {
					msg_validar("msg-passw","La nueva contraseña debe tener más de 4 caracteres");	
				}
	         	return false;
     	}

		if($("#frm-passw #passwr").val() == "" || $("#frm-passw #passwr").val().length < 4)
		{
				$("#frm-passw #passwr").focus();
				if($("#frm-passw #passwr").val() == ""){
					msg_validar("msg-passw","Confirme la nueva contraseña");			
				} else {
					msg_validar("msg-passw","La confirmación de la nueva contraseña debe tener más de 4 caracteres");	
				}
	         	return false;
     	}

		if($("#frm-passw #passwn").val() != $("#frm-passw #passwr").val())
		{
			$("#frm-passw #passwr").focus();
			msg_validar("msg-passw","La nueva contraseña a confirmar ingresado no concuerda con la nueva contraseña");
         	return false;
     	}
	
		newclaveperfil();
	}
	
	function quitarEspacios(){
		var passwa = $("#frm-passw #passwa").val().trim();
		var passwn = $("#frm-passw #passwn").val().trim();
		var passwr = $("#frm-passw #passwr").val().trim();
		
		$("#frm-passw #passwa").val(passwa);
		$("#frm-passw #passwn").val(passwn);
		$("#frm-passw #passwr").val(passwr);
	}

	function ValidarCorreo()
	{
		var cadena = $("#mail_user").val();
		var re=/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
		if(cadena ==""){
			$("#mail_user").focus();
	        msg_validar("msg-info-d","Ingrese un correo electrónico valido. Ej. example@gmail.com");
	        return false;
		}
	    if(!re.exec(cadena))    {
			$("#mail_user").focus();
	        //alert("El correo electr�nico, no es v�lido");
	        msg_validar("msg-info-d","El Correo electrónico ingresado, no es valido. Ej. example@gmail.com");
	        return false;
	    }
	}
	function ValidarTelefono()
	{
		var cadena = $("#telefonoUser").val();
		var re=/^(\()([0-9]{0,3})(\)) ([0-9]{0,3})-([0-9]{0,4}) (\/) (([0-9]{0,3})-([0-9]{0,3})-([0-9]{0,3}))$/i;
		if(cadena ==""){
			$("#telefonoUser").focus();
	        msg_validar("msg-info-d","Ingrese telefonos con el formato valido. Ej. (001) 245-2998 / 953-266-874");
	        return false;
		}
	    if(!re.exec(cadena))    {
			$("#telefonoUser").focus();
	        //alert("El correo electr�nico, no es v�lido");
	        msg_validar("msg-info-d","Ingrese telefonos con el formato valido. Ej. (001) 245-2998 / 953-266-874");
	        return false;
	    }
	}
	function msg_validar(id,msg){
		if(msg!=null){
			var html='<div class="alert alert-warning alert-dismissible fade in" role="alert"> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button> '+ msg +'</div>';
			$("#"+id).html(html);
		} else {
			$("#"+id).html(msg);
		}
	}
	
	function encryptedValue(key,value){
		var iterationCount = 1000;
	  	var keySize = 128;
	    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    var aesUtil = new AesUtil(keySize, iterationCount);
	    return aesUtil.encrypt(salt, iv, key, value);
	}
	
	function newclaveperfil() {
		
		//console.log("$('#codigoPersona').val()2222"+$('#codigousarioBean').val());
		
		showLoad();
		var idcodusu = $('#codigousarioBean').val();
		var oldPass = $("#claveActual input:password").val();//$('#passwaocul').val();
		var newPass = $('#passwn').val();
		
		var url = contextPath + "/perfil/cambiarPass"; 

		var $myForm = $('#frm-passw');
		
		var oldPassEncrypted = encryptedValue("oldPass", oldPass);
		var newPassEncrypted = encryptedValue("newPass", newPass);
	 	// validar todos los required
		//iniciarBloqueo();
		$("#frm-passw").addClass("bloqueoTotal");
		$.ajax({
			 async: true,
			type : "POST",
			url : url,
			data:{codigo:idcodusu,oldpass:oldPassEncrypted,newpass:newPassEncrypted},
			
			success : function(data) {
				if (data == 1) {
					
					msg_exito();
					$("#claveActual input:password").val("");
					$("#claveActual input:text").val("");
					$("#passwn").val("");
					$("#passwr").val("");
					
					var URLactual= window.location.toString();
					fragmentoTexto = URLactual.split('/');
					var url_home=fragmentoTexto[0]+'/'+fragmentoTexto[1]+'/'+fragmentoTexto[2]+'/'+fragmentoTexto[3]+'/';
					console.log(url_home);
					
					window.location.replace(url_home);
						
					//location.reload();
					//msg_exito(); 
				}
				else if (data == 2){
					$("#frm-passw #passwr").focus();
					msg_validar("msg-passw","Contraseña débil: La contraseña debe contener tener mínimo 8 dígitos, contener al menos una minúscula, contener al menos una mayúscula y contener al menos un número.");
				}
				else{
					$("#frm-passw #passwr").focus();
					msg_validar("msg-passw","La contraseña no coincide con la actual");
		         	//msg_advertencia("La contraseña no coincide con la actual");
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
				   	//hideLoad();
				   	//finBloqueo();
					$("#frm-passw").removeClass("bloqueoTotal");
				   }
		});
	 		
	}