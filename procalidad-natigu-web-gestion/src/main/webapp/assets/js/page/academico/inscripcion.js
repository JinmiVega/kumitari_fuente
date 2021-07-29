/**
 * 
 */

function agregarDetDocumentoInscripcion() {
	var contextPath = $('#contextPathUrl').val();
	var idcodigoinscr = $('#codigo').val();
	var numDoc = $('#numeroDocumentotxt').val();

	// console.log("idcodigoinscr..... "+idcodigoinscr)
	var actionForm = $('#frmRegistroDetDocumentoInstitucion').attr("action");
	var url = contextPath + "/inscripcionController/" + actionForm;
	var $myForm = $('#frmRegistroDetDocumentoInstitucion');
	var inputFileImage = document.getElementById('file');
	var file = inputFileImage.files[0];
	var dataee = new FormData();
	dataee.append('codigo', idcodigoinscr);
	dataee.append('file', file);
	dataee.append('numedocu', numDoc);
	// validar todos los required
	if (!$myForm[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos correctamente");

	} else {
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : url,
			// data: $('#frmRegistroDetDocumentoInstitucion').serialize(),
			data : dataee,
			enctype : 'multipart/form-data',
			processData : false, // tell jQuery not to process the data
			contentType : false, // tell jQuery not to set contentType
			dataType : 'json', // as you want
			success : function(data) {
				recargarListadoDetalleDocumentoInscripcion();
				// console.log("SUCCESS: ", data);

				if (data == "1") {
					//msg_exito();
					// msg_info('Se agrego correctamente el archivo');
					resetfrmRegistroDetDocumentoInstitucion();
					/* $('#grupo-docente-modal').modal('hide'); */
					/*
					 * $("#bootstrap #frmSede").empty();
					 * $('#bootstrap').modal('hide');
					 */
				} else if (data == "0") {
					msg_advertencia('Ocurrió algo improvisto - 1');

					/* $('#grupo-docente-modal').modal('hide'); */
					/*
					 * $("#bootstrap #frmSede").empty();
					 * $('#bootstrap').modal('hide');
					 */
				} else if (data == "2") {
					msg_advertencia('Ya existe Documento!');
					resetfrmRegistroDetDocumentoInstitucion();
				} else if (data == "3") {
					msg_advertencia('El formato ingresado no es permitido');
				} else {
					msg_advertencia('Ocurrió algo improvisto');
				}

			},
			error : function(xhr, status, er) {
				// console.log("error: " + xhr + " status: " + status + " er:" +
				// er);
				msg_error();
				// console.log("errot:" + data);
				resetfrmRegistroDetDocumentoInstitucion();
			},
			complete : function() {
				finBloqueo();

			}
		});
	}
}
$("#btn-save-registro-inscripcion").one("click",function(){
	var contextPath = $('#contextPathUrl').val();
	var actionForm = $('#frmRegistroInstitucion').attr("action");
	var url = contextPath + "/inscripcionController/" + actionForm;
	var $myForm = $('#frmRegistroInstitucion');
	
	var strfechaNacimiento = $('#strfechaNacimiento').val();
	
	if (strfechaNacimiento.length != 10 & strfechaNacimiento.length >=1 ) {
		$('#strfechaNacimiento').val("");
		msg_advertencia("Ingrese fecha correcta");
	}else if (!$myForm[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos correctamente");

	} else {
		if (strfechaNacimiento.length != 10) {
			msg_advertencia("Ingrese fecha correcta");
			return;
		} else {

			iniciarBloqueo();
			
				/*
				$.ajax({
			
				type : "POST",				
				url : url,
				data: $myForm.serialize(),
				success : function(data) {
					console.log("SUCCESS: ", data);
					msg_exito();
				},
				error : function(xhr, status, er) {
					console.log("errot:" + data);
					// console.log("error: " + xhr + " status: " + status + "
					// er:" + er);
					msg_error();

				},
				complete : function() {
					finBloqueo();
					
				}
			});
			*/
		}
	}
});

function check(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 8) {
        return true;
    }
    patron = /[A-Za-z0-9._-]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
}

	function cargarNivelesInsc() {
	var idLengua = $('#lblLenguamodal').val();
	var contextPath = $('#contextPathUrl').val();

	var html = "";

	if (idLengua != '0') {
		iniciarBloqueo();
		$.ajax({
			type : "GET",
			data : "codlengua=" + idLengua,
			url : contextPath + "/inscripcionController/cargarNivelesIns",
			success : function(data) {

				if (data != null) {

					data.sort(function(a, b) {
						return (a.codigoRegistro - b.codigoRegistro);
					});

					html += "<option value=''>Seleccione</option>";
					for (var i = 0; i < data.length; i++) {
						html += "<option value='" + data[i].codigoRegistro
								+ "'>" + data[i].nombreCorto + "</option>";
					}
				} else {
					html += "<option value=''>Seleccione</option>";
				}

			},
			error : function(xhr, status, er) {
				//console.log("error: " + xhr + " status: " + status + " er:"+ er);
				if (xhr.status == 500) {
					//console.log(er);
					// Error_500(er);
				}
				if (xhr.status == 901) {
					//console.log(er);
					// spire_session_901(er);
				}
			},
			complete : function() {
				finBloqueo();
				$('#cmm_nivel').empty();
				$('#cmm_nivel').html(html);
			}
		});
	} else {
		html = "<option value='0'>Seleccione</option>";
		$('#cmm_nivel').empty();
		$('#cmm_nivel').html(html);

	}
}