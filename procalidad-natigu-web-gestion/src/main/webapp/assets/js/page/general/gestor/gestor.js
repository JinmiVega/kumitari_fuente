/**
 * 
 */
let activateGuardar = true;

function buscarProvincia() {

	var codDep = $("#provinciaSelect").val();
	var codPro = "";
	buscarProvinciaXCodigos(codDep, codPro);

}

function buscarDistrito() {

	var codDep = $("#provinciaSelect").val();
	var codPro = $("#comboprovincia").val();
	var codDis = $("#combodistrito").val();
	buscarDistritoXCodigos(codDep, codPro, codDis);
}

function buscarProvinciaXCodigos_1(codDep, codPro) {
	var prmRegion ; 
	if (prmRegion != $("#provinciaSelect").val()) {
 
		// var numero =document.getElementById("lblInstitu").value;
		var id = codDep;
		var urlubigeo = $("#urlubigeo").val();
		//console.log(urlubigeo);
		// for(var f=0;f<document.getElementById("comboprovincia").length;f++){
		// if (document.getElementById("comboprovincia").length > 0) {

		// document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
		// }

		// }
		document.getElementById("comboprovincia").options[document
				.getElementById("comboprovincia").innerHTML = ""];
		document.getElementById("combodistrito").options[document
				.getElementById("combodistrito").innerHTML = ""];
		document.getElementById("comboprovincia").options[document
				.getElementById("comboprovincia").options.length] = new Option(
				"Seleccionar", "00");
		document.getElementById("combodistrito").options[document
				.getElementById("combodistrito").options.length] = new Option(
				"Seleccionar", "00");
		$.ajax({
					type : "GET",

					url : "../baseController/buscarProvincia?codigodepartamento="+ id,
					// data : {codigoinst:numero},

					success : function(data) {
						//console.log("SUCCESS: ", data);

						for (var i = 0; i < data.length; i++) {
							document.getElementById("comboprovincia").options[document
									.getElementById("comboprovincia").options.length] = new Option(
									data[i].nombreUbigeo,
									data[i].codigoProvincia);

						}

						//
					},
					error : function() {
						//console.log("ERROR: ");
					},
					complete : function() {

						if (codPro != null && codPro != "") {
							$("#comboprovincia").val(codPro);
						} else {

							$("#comboprovincia").val("00");
						}

					}

				});

	}

}

function buscarDistritoXCodigos_1(codDep, codPro, codDis) {
	var prmRegion ; 
	if (prmRegion != $("#comboprovincia").val()) {

		// var numero =document.getElementById("lblInstitu").value;
		var id = codDep;
		var id2 = codPro;
		document.getElementById("combodistrito").options[document
				.getElementById("combodistrito").innerHTML = ""];
		document.getElementById("combodistrito").options[document
				.getElementById("combodistrito").options.length] = new Option(
				"Seleccionar", "00");
		$
				.ajax({
					type : "GET",
					// /baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
					url : "../baseController/buscarDistrito?codigodepartamento="
							+ id + "&" + "codigoprovincia=" + id2,
					// data : {codigoinst:numero},

					success : function(data) {
						//console.log("SUCCESS: ", data);
						// $('#provincia').html(data);
						// alert(data[1].codigo);
						// document.getElementById("provincia").innerHTML =
						// "<select path='ubigeoBean.codigoProvincia'
						// class='form-control'> <options itemValue='00'
						// itemLabel='dsdsadasdsa'/> </select>";

						// for(var
						// f=0;f<document.getElementById("combodistrito").length;f++){
						// if (document.getElementById("combodistrito").length >
						// 0) {
						// document.getElementById("combodistrito").remove(document.getElementById("combodistrito").length-1);
						// }

						// }

						for (var i = 0; i < data.length; i++) {

							document.getElementById("combodistrito").options[document
									.getElementById("combodistrito").options.length] = new Option(
									data[i].nombreUbigeo,
									data[i].codigoDistrito);

						}

					},
					error : function() {
						//console.log("ERROR: ");
					},
					complete : function() {
						if (codDis != null && codDis != "") {
							$("#combodistrito").val(codDis);
						}

					}
				});
	}
}

/** ****************************** */
function buscarPersona(e) {
	var numerodocumento = $('#numeroDocumentoPersona').val();
	if (numerodocumento.length > 6 && numerodocumento.length < 13) {
		validarPersonal();
	}

} 

function formatoDocumento() {
	if(activateGuardar==true){
		$("#numeroDocumentoPersona").val("");
	} 
}

function limpiarformpersonal() {
	document.getElementById("frmRegistroPersonal").reset();

}
function registrarPersonal() {
	var url = $("#frmRegistroPersonal").attr("action"); //Capturar el action del form
	var $myForm = $("#frmRegistroPersonal");
	var numeroDocumento = $('#numeroDocumentoPersona').val();
	var tipoDocumento = $('#codigoTipoDocumento').val();	
	letras = " fghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	var contextPath = $('#contextPath').val(); 
	if (tipoDocumento == 1 & numeroDocumento.length !=8 ) {
		msg_advertencia("Ingrese nro de dni correcto");
		return;
	}else  if(tipoDocumento == 1 & (numeroDocumento.indexOf("A")!= -1||numeroDocumento.indexOf("B") != -1 ||numeroDocumento.indexOf("C")!= -1 
			|| numeroDocumento.indexOf("D")!= -1 ||numeroDocumento.indexOf("E")!= -1 ||numeroDocumento.indexOf("F")!= -1
			|| numeroDocumento.indexOf("G")!= -1 ||numeroDocumento.indexOf("H")!= -1 ||numeroDocumento.indexOf("I")!= -1
			|| numeroDocumento.indexOf("M")!= -1 ||numeroDocumento.indexOf("N")!= -1 ||numeroDocumento.indexOf("Ñ")!= -1
			|| numeroDocumento.indexOf("O")!= -1 ||numeroDocumento.indexOf("P")!= -1 ||numeroDocumento.indexOf("Q")!= -1
			|| numeroDocumento.indexOf("R")!= -1 ||numeroDocumento.indexOf("S")!= -1 ||numeroDocumento.indexOf("T")!= -1
			|| numeroDocumento.indexOf("U")!= -1 ||numeroDocumento.indexOf("V")!= -1 ||numeroDocumento.indexOf("W")!= -1
			|| numeroDocumento.indexOf("X")!= -1 ||numeroDocumento.indexOf("Y")!= -1 ||numeroDocumento.indexOf("Z")!= -1)){
			 
			msg_advertencia("DNI no debe contener letras");
			return;
			 
	}else{
		var iterationCount = 1000;
	  	var keySize = 128;
		var numerodocumento = $('#numeroDocumentoPersona').val();
		var nombrePersona = $('#nombrePersonal').val();
		var apellidoPaterno = $('#apellidoPaternoPersonal').val();
		var apellidoMaterno = $('#apellidoMaternoPersonal').val();
		var fechaNacimiento = $('#strfechaNacimiento').val();
		var provinciaSelect = $('#provinciaSelect').val();
		var comboprovincia = $('#comboprovincia').val();
		var combodistrito = $('#combodistrito').val();
		var telefonoUsuario = $('#telefonoUsuario').val();
		var correoElectronico = $('#correoElectronico').val();
		var direccion = $('#direccionPersona').val();
		
	    console.log("numeroDocumentoPersona", numeroDocumentoPersona);
	    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    
	    var aesUtil = new AesUtil(keySize, iterationCount);
	    var txtNumeroDocumento = aesUtil.encrypt(salt, iv, "numeroDocumentoGestor", numerodocumento);
		var txtNombrePersona = aesUtil.encrypt(salt, iv, "nombrePersonaPersonal", nombrePersona);
	    var txtApellidoPaternoEncript = aesUtil.encrypt(salt, iv, "apellidoPaternoPersonal", apellidoPaterno);
	    var txtApellidoMaternoEncript = aesUtil.encrypt(salt, iv, "apellidoMaternoPersonal", apellidoMaterno);
	    var txtFechaNacimiento = aesUtil.encrypt(salt, iv, "fechaNacimientoPersonal", fechaNacimiento);
	    var txtProvinciaSelect = aesUtil.encrypt(salt, iv, "provinciaSelectPersonal", provinciaSelect);
	    var txtComboProvincia = aesUtil.encrypt(salt, iv, "comboProvinciaPersonal", comboprovincia);
	    var txtCombodistrito = aesUtil.encrypt(salt, iv, "comboDistritoPersonal", combodistrito);
	    var txtTelefonoUsuario = aesUtil.encrypt(salt, iv, "telefonoUsuarioPersonal", telefonoUsuario);
	    var txtCorreoElectronico = aesUtil.encrypt(salt, iv, "correoElectronicoPersonal", correoElectronico);
	    var txtDireccion = aesUtil.encrypt(salt, iv, "direccionPersonal", direccion);
	    
	    $("#textNumeroDocumentoPersona").val(txtNumeroDocumento);
		$("#textNombrePersona").val(txtNombrePersona);
	    $("#textApellidoPaterno").val(txtApellidoPaternoEncript);
	    $("#textApellidoMaterno").val(txtApellidoMaternoEncript);
	    $("#textStrFechaNac").val(txtFechaNacimiento);
	    $("#textCodigoRegion").val(txtProvinciaSelect);
	    $("#textCodigoProvincia").val(txtComboProvincia);
	    $("#textCodigoDistrito").val(txtCombodistrito);
	    $("#textTelefono").val(txtTelefonoUsuario);
	    $("#textCorreo").val(txtCorreoElectronico);
	    $("#textDireccionPersona").val(txtDireccion);

	    $('#numeroDocumentoPersona').removeAttr("name");
		$('#nombrePersonal').removeAttr("name");
	    $('#apellidoPaternoPersonal').removeAttr("name");
	    $('#apellidoMaternoPersonal').removeAttr("name");
	    $('#strfechaNacimiento').removeAttr("name");
	    $('#provinciaSelect').removeAttr("name");
	    $('#comboprovincia').removeAttr("name");
	    $('#combodistrito').removeAttr("name");
	    $('#telefonoUsuario').removeAttr("name");
	    $('#correoElectronico').removeAttr("name");
	    $('#direccionPersona').removeAttr("name");
		    
		var apellidoPaterno = $("#apellidoPaternoPersonal").val();
		var apellidoMaterno = $("#apellidoMaternoPersonal").val();
		if(apellidoPaterno != "" || apellidoMaterno != "") {
			
			if ($myForm[0].checkValidity()){ 
			$.ajax({
				type : "POST",
				url : url,
				data : $("#frmRegistroPersonal").serialize(), // Serializar la data del form
				success : function(data) {
					//console.log('data', data); 
					
					msg_exito(); 
					$("#btnListadoAdministrativo").trigger("click");
					//document.getElementById("btnListadoAdministrativo").click();
					//document.write = data;
					
					//renderizar vista
					document.write(data);
					//document.location.href = contextPath+"/personalController/buscar";
					//document.location.href = contextPath;
					//document.location.href = data;
					
					//alert("msg_exito");
					
				},
				error : function(xhr, status, er) {//msg_error();
					////console.log("error: " + xhr + " status: " + status + " er:"+ er);
					alert("error");
					if (xhr.status == 500) {
						//console.log(er);
					}
					if (xhr.status == 901) {
						//console.log(er);
					}
				},
				complete : function() {
				}
			});
		  }else{
			  //console.log("error: ");
		  }
		} else {
			msg_advertencia("Debe completar al menos uno de los dos apellidos");
		}
	}	
	
}
function registrarPersonal_1() {
	var departamento = $('#provinciaSelect').val(); 
	var provincia = $('#comboprovincia').val(); 
	var distrito = $('#combodistrito').val(); 
	var lengua = $('#lenguaMaterna').val(); 
	var actionForm = $('#frmRegistroPersonal').attr("action");
	var contextPath = $('#contextPath').val(); 
	var url = contextPath + "/personalController/grabar"; 
	//alert(lengua);
	if(departamento != "00" & provincia != "00" & distrito != "00" & lengua != "0"){
		$.ajax({
			type : "POST",
			url : url,
			data : $("#frmRegistroPersonal").serialize(), // Serializar la data
															// del form
			success : function(data) {
				msg_exito();
				document.location.href = 'listado';
			},
			error : function(xhr, status, er) {// msg_error();
				//console.log("error: " + xhr + " status: " + status + " er:" + er);
				if (xhr.status == 500) {
					//console.log(er);
				}
				if (xhr.status == 901) {
					//console.log(er);
				}
			},
			complete : function() {
				
			}
		});
	}else{
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");
	}
}

function convertirFecha(fecha) {
	var strFecha = "";
	var fecha = new Date(fecha);
	var dia = "";
	var mes = "";
	if (fecha.getDate().toString().length == 1) {
		dia = "0" + fecha.getDate().toString();
	} else {
		dia = fecha.getDate().toString();
	}
	if ((fecha.getMonth() + 1).toString().length == 1) {
		mes = "0" + (fecha.getMonth() + 1);
	} else {
		mes = (fecha.getMonth() + 1).toString();
	}
	return strFecha = dia + "/" + mes + "/" + fecha.getFullYear();
}

// function justNumbers(e) {
// var numeroDocumento = $('#numeroDocumentoPersona').val();
// var tipoDocumento = $('#codigoTipoDocumento').val();
// if (tipoDocumento != 0) {
// if (tipoDocumento == 1) {
// if (numeroDocumento.length < 8) {
// var keynum = window.event ? window.event.keyCode
// : e.which;
// if ((keynum == 8) || (keynum == 46))
// return true;
// return /\d/.test(String.fromCharCode(keynum));
// } else {
// e.preventDefault();
// }
// }
// }
// }

function justNumbers(e) {
	var numeroDocumento = $('#numeroDocumentoPersona').val();
	var tipoDocumento = $('#codigoTipoDocumento').val();
	if (tipoDocumento != 0) {
		/* DNI */
		if (tipoDocumento == 1) {
			if (numeroDocumento.length < 8) {
				var keynum = window.event ? window.event.keyCode : e.which;
				if ((keynum == 8) || (keynum == 46))
					return true;
				return /\d/.test(String.fromCharCode(keynum));
			} else {
				var keynum = window.event ? window.event.keyCode : e.which;
				if ((keynum == 8))
					return true;
				e.preventDefault();
			}
		}
		/* PASAPORTE */
		if (tipoDocumento == 2) {
			if (numeroDocumento.length < 12) {
				key = e.keyCode || e.which;
				tecla = String.fromCharCode(key).toString();
				letras = " 1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";// Se
																								// define
																								// todo
																								// el
																								// abecedario
																								// que
																								// se
																								// quiere
																								// que
																								// se
																								// muestre.
				especiales = [ 8, 37, 39, 46, 6 ]; // Es la validación del
													// KeyCodes, que teclas
													// recibe el campo de texto.

				tecla_especial = false
				for ( var i in especiales) {
					if (key == especiales[i]) {
						tecla_especial = true;
						break;
					}
				}

				if (letras.indexOf(tecla) == -1 && !tecla_especial) {
					/* alert('Tecla no aceptada'); */
					return false;
				}
			} else {
				e.preventDefault();
			}
		}

	}
}

function buscarPersona_1(e) {

	var numerodocumento = $('#numeroDocumentoPersona').val();
	if (numerodocumento.length > 6 && numerodocumento.length < 13) {
		validarPersonal();
	}

}

function validarPersona() {
	var contextPath = $('#contextPath').val();
	var tipoDocumento = $('#codigoTipoDocumento').val();
	var numeroDocumento = $('#numeroDocumentoPersona').val();
	if (numeroDocumento == null && numeroDocumento == "") {
		numeroDocumento = 0;
	}
	$
			.ajax({
				type : "POST",
				url :contextPath + "/personaController/validapersona?tipodocumento="
						+ tipoDocumento + "&numerodocumento=" + numeroDocumento,
				success : function(data) {
					if (data.codigo != 0) {
						$('#codigoTipoDocumento').val(
								data.tipoDocumento.codigoRegistro);
						$('#numeroDocumentoPersona').val(data.numeroDocumento);
						$('#codigoPersona').val(data.codigo);
						/* $('#codigoPersonal').val(); */
						/* $('#situacionPersonal').val(data); */
						$('#nacionalidadPersonal').val(
								data.nacionalidad.codigoRegistro);
						$('#nombrePersonal').val(data.nombrePersona);
						$('#apellidoPaternoPersonal').val(data.apellidoPaterno);
						$('#apellidoMaternoPersonal').val(data.apellidoMaterno);
						var strFecha = convertirFecha(data.fechaNac);
						$('#strfechaNacimiento').val(strFecha);
						$('#lenguaMaterna').val(data.lenguaBean.codigo);

						/* $('#gradoPersonal').val(data.); */
						/* $('#cargoPersonal').val(); */
						$('#sexoPersonal').val(data.sexo.codigoRegistro);
						$('#telefonoUsuario').val(data.telefono);
						$('#correoElectronico').val(data.correo);
						$('#provinciaSelect').val(data.ubigeoBean.codigoRegion);
						var codDep = data.ubigeoBean.codigoRegion;
						var codPro = data.ubigeoBean.codigoProvincia;
						var codDis = data.ubigeoBean.codigoDistrito;

						if (codDep != null && codDep != "") {
							buscarProvinciaXCodigos(codDep, codPro);
							$('#comboprovincia').val(codPro);
							if (codPro != null && codPro != "") {
								buscarDistritoXCodigos(codDep, codPro, codDis);
								$('#combodistrito').val(codDis);
							}
						}

						$('#direccionPersona').val(data.direccionPersona);

					}

				},
				error : function() {
					//console.log("ERROR: ");
				}
			});
}

function validarPersonal() {
	var contextPath = $('#contextPath').val();
	var numeroDocumento = $('#numeroDocumentoPersona').val();
	if (numeroDocumento == null && numeroDocumento == "") {
		numeroDocumento = 0;

	}
	$
			.ajax({
				type : "POST",
				url : contextPath + "/personalController/validaPersonal?numerodocumento="
						+ numeroDocumento,
				success : function(data) {
					if (data.codigo != 0) {
						$('#provinciaSelect').val(
								data.personaBean.ubigeoBean.codigoRegion);
						$('#codigoTipoDocumento').val(
								data.personaBean.tipoDocumento.codigoRegistro);
						$('#numeroDocumentoPersona').val(
								data.personaBean.numeroDocumento);
						$('#codigoPersona').val(data.personaBean.codigo);
						$('#codigoPersonal').val(data.codigo);
						$('#situacionPersonal').val(
								data.situacionPersonal.codigoRegistro);
						$('#nacionalidadPersonal').val(
								data.personaBean.nacionalidad.codigoRegistro);
						$('#nombrePersonal')
								.val(data.personaBean.nombrePersona);
						$('#apellidoPaternoPersonal').val(
								data.personaBean.apellidoPaterno);
						$('#apellidoMaternoPersonal').val(
								data.personaBean.apellidoMaterno);
						var strFecha = convertirFecha(data.personaBean.fechaNac);

						$('#strfechaNacimiento').val(strFecha);
						$('#lenguaMaterna').val(
								data.personaBean.lenguaBean.codigo);
						$('#gradoPersonal').val(
								data.gradoPersonal.codigoRegistro);
						$('#cargoPersonal').val(
								data.cargoPersonal.codigoRegistro);
						$('#sexoPersonal').val(
								data.personaBean.sexo.codigoRegistro);
						$('#telefonoUsuario').val(data.personaBean.telefono);
						$('#correoElectronico').val(data.personaBean.correo);
						var codDep = data.personaBean.ubigeoBean.codigoRegion;
						var codPro = data.personaBean.ubigeoBean.codigoProvincia;
						var codDis = data.personaBean.ubigeoBean.codigoDistrito;
						//console.log("departamento: ", codDep);
						//console.log("provincia: ", codPro);
						//console.log("distrito: ", codDis);
						if (codDep != null && codDep != "") {
							buscarProvinciaXCodigos(codDep, codPro);
							$('#comboprovincia').val(codPro);
							if (codPro != null && codPro != "") {
								buscarDistritoXCodigos(codDep, codPro, codDis);
								$('#combodistrito').val(codDis);
							}
						}

						$('#direccionPersona').val(
								data.personaBean.direccionPersona);

					} else {

						validarPersona();

					}

				},
				error : function() {
					//console.log("ERROR: ");
				}
			});
}

function fechaCorrecta(fecha1, fecha2) {

	// Split de las fechas recibidas para separarlas
	var x = fecha1.split("/");
	var z = fecha2.split("/");

	// Cambiamos el orden al formato americano, de esto dd/mm/yyyy a esto
	// mm/dd/yyyy
	fecha1 = x[1] + "/" + x[0] + "/" + x[2];
	fecha2 = z[1] + "/" + z[0] + "/" + z[2];

	// Comparamos las fechas
	if (Date.parse(fecha1) < Date.parse(fecha2)) {
		return false;
	} else {
		return true;
	}
}

function IsNumeric(valor) {
	var log = valor.length;
	var sw = "S";
	for (x = 0; x < log; x++) {
		v1 = valor.substr(x, 1);
		v2 = parseInt(v1);
		// Compruebo si es un valor numérico
		if (isNaN(v2)) {
			sw = "N";
		}
	}
	if (sw == "S") {
		return true;
	} else {
		return false;
	}
}
var primerslap = false;
var segundoslap = false;

function formateafecha_1(fecha) {
	var fechaActual = new Date();
	var long = fecha.length;
	var dia;
	var mes;
	var ano;
	if ((long >= 2) && (primerslap == false)) {
		dia = fecha.substr(0, 2);
		if ((IsNumeric(dia) == true) && (dia <= 31) && (dia != "00")) {
			fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
			primerslap = true;
		} else {
			fecha = "";
			primerslap = false;
		}
	} else {
		dia = fecha.substr(0, 1);
		if (IsNumeric(dia) == false) {
			fecha = "";
		}
		if ((long <= 2) && (primerslap = true)) {
			fecha = fecha.substr(0, 1);
			primerslap = false;
		}
	}
	if ((long >= 5) && (segundoslap == false)) {
		mes = fecha.substr(3, 2);
		if ((IsNumeric(mes) == true) && (mes <= 12) && (mes != "00")) {
			fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
			segundoslap = true;
		} else {
			fecha = fecha.substr(0, 3);
			;
			segundoslap = false;
		}
	} else {
		if ((long <= 5) && (segundoslap = true)) {
			fecha = fecha.substr(0, 4);
			segundoslap = false;
		}
	}
	if (long >= 7) {
		ano = fecha.substr(6, 4);
		if (IsNumeric(ano) == false) {
			fecha = fecha.substr(0, 6);
		} else {
			if (long == 10) {
				if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
					fecha = fecha.substr(0, 6);
				}
			}
		}
	}
	if (long >= 10) {
		fecha = fecha.substr(0, 10);
		dia = fecha.substr(0, 2);
		mes = fecha.substr(3, 2);
		ano = fecha.substr(6, 4);
		// Año no viciesto y es febrero y el dia es mayor a 28
		if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
			fecha = fecha.substr(0, 2) + "/";
		}
	}

	if (fecha.length == 10) {

		//console.log(fecha.length);

		if (fechaCorrecta(fecha, convertirFecha(fechaActual)) == true) {
			fecha = convertirFecha(fechaActual);
			msg_advertencia("Por Favor ingrese una Fecha menor a la Actual");

		}

	}
	return (fecha);
}

 
function validaNumero(e){
	var codigoTipoDocumento =  $("#codigoTipoDocumento").val();
	var numeroDocumentoPersona =  $("#numeroDocumentoPersona").val();
//	console.log("codigoTipoDocumento " + codigoTipoDocumento)
	if (codigoTipoDocumento == null || codigoTipoDocumento == ""){
		msg_advertencia("Selecciones tipo de documento")
	//	$("#numeroDocumentoPersona").val("");
		tecla = (document.all) ? e.keyCode : e.which;

	    //Tecla de retroceso para borrar, siempre la permite
	    if (tecla==8){
	        return true;
	    }
	        
	    // Patron de entrada, en este caso solo acepta numeros
	    patron =/[0-9]/;
	    tecla_final = String.fromCharCode(tecla);
	    return patron.test(tecla_final);	
	}else{
		if (codigoTipoDocumento == 1) {
			if (numeroDocumentoPersona.length >= 8) {
				   $("#card_error").toggle();
				   $("input#numeroDocumentoPersona").focus();
				   return false;
				}
			
			//console.log("es dni");
			$("#numeroDocumentoPersona").attr("pattern", "{8}");
			 tecla = (document.all) ? e.keyCode : e.which;

			    //Tecla de retroceso para borrar, siempre la permite
			    if (tecla==8){
			        return true;
			    }
			        
			    // Patron de entrada, en este caso solo acepta numeros
			    patron =/[0-9]/;
			    tecla_final = String.fromCharCode(tecla);
			    return patron.test(tecla_final);	
		}

		if (codigoTipoDocumento == 2) {
			$("#numeroDocumentoPersona").attr("pattern", "{12}");
			if (numeroDocumentoPersona.length >= 12) {
				   $("#card_error").toggle();
				   $("input#numeroDocumentoPersona").focus();
				   return false;
				}
			//console.log("es pasaporte"); 
				key = e.keyCode || e.which;
				tecla = String.fromCharCode(key).toString();
				letras = " 1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
				especiales = [ 8, 37, 39, 46, 6 ]; 

				tecla_especial = false
				for ( var i in especiales) {
					if (key == especiales[i]) {
						tecla_especial = true;
						break;
					}
				}

				if (letras.indexOf(tecla) == -1 && !tecla_especial) {
					/* alert('Tecla no aceptada'); */
					return false;
				}
			}  

		if (codigoTipoDocumento == 3) {
			$("numeroDocumentoPersona").removeAttr("pattern");
		}
		 
	}
  
} 