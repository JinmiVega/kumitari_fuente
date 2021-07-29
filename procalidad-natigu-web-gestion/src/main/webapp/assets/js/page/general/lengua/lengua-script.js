/** IMPLEMENTACION * */

function confirmar_accion(codigo, tabla) {
	// alert("tabla " + tabla)
	$('#md_confirmacion').modal('show');
	$("#btnConfirmarGeneric").click(function() {
		if (tabla == 'unidad') {
			eliminarUnidad(codigo);
		} else if (tabla == 'leccion') {
			eliminarLeccion(codigo);
		} else if (tabla == 'lenguaEstructura') {
			eliminarLenguaEstructura(codigo);
		}
	});

}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}

function consultaEliminarLenguaEstructura(idButton, codigoSede) {
	var accion_tab = idButton;
	codSede = codigoSede;
	$('#md_confirmacion').modal('show');
}

function cargarLenguaEstructura() {
	var contextPath = $('#contextPath').val();
	var codigo = $('#codigoLengua').val();

	$.ajax({
		url : contextPath + "/lenguaController/listaEstructura?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {
			$("#modalLenguaEstructura").modal('show');
			$("#modalLenguaEstructuraContent").html(data);
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function grabarLenguaEstructura() {

	var contextPath = $('#contextPath').val();
	var codigo = $('#codigoLengua').val();
	if (codigo == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else {
	var subNiveles = [];
	var nombreNivel = [];
	var status = '';
	$(".get_value").each(function() {
		if ($(this).is(":checked")) {
			subNiveles.push($(this).val());
		}
	});

	$(".get_valueNombre").each(function() {
		// alert("$(this).val()" + $(this).val())
		// alert("$(this).val()" + )
		nombreNivel.push($(this).attr("id") + "" + $(this).val());

	});
	dirURL = contextPath + "/lenguaController/grabarEstructura?codigo="
			+ codigo + "&subNiveles=" + subNiveles + "&nombreNivel="
			+ nombreNivel;
	$.ajax({

		url : dirURL,
		type : 'POST',
		success : function(data) {
			refrescarTablaDetalleEstructura();
			//console.log("SUCCESS: ", data);
			status = data;
			if (data == "1") {
				msg_exito();
				$('#bootstrap2').modal('show');
				$('#modalLenguaEstructura').modal('hide');
			} else {
				msg_error();
			}
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
   }
}

function refrescarTablaDetalleEstructura() {
	
	var contextPath = $('#contextPath').val();
	var id = $('#codigoLengua').val();
	console.log(id);
	$.ajax({
		type : "GET",

		url : contextPath + "/lenguaController/recargarListadoxLengua",
		data : {
			codigo : id
		},

		success : function(data) {
			//console.log("SUCCESS: ", data);
			$('#listadoDetalleLengua').html(data);
		},
		error : function() {
			//console.log("ERROR: ");
		}
	});

}

function lenguaCargarModal() {
	var contextPath = $('#contextPath').val();
	var codigoLengua = $('#codigoLengua').val(); // document.getElementById("codigoLengua").value;

	path = contextPath + "/lenguaController/lenguaCargarModal?codigo="
			+ codigoLengua;
	// alert("path " + path)
	if (codigoLengua == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else {
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				//console.log("SUCCESS: ", data);
				$("#modalLenguaEstructura").modal('show');
				$("#modalLenguaEstructuraContent").html(data);

			},
			error : function(request, status, error) {
				//console.log("ERROR: " + error);
			}
		});
	}
}

function validarInputs() {
	var flag = true;
	return false;
}

function grabarUnidad() {
	var actionForm = $('#frmInsertarUnidad').attr("action");

	var contextPath = $('#contextPath').val();
	var idLengua = $('#codigoLengua').val();
	var idSubNivel = $('#cmm_sub_nivel').val();
	var idNivel = $('#cmm_nivel').val();
	var nombreUnidad = $('#nombreUnidad').val();
	var unidad = $('#unidad').val();
	if (idLengua == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else if(idNivel == 0 || (idNivel == 0 && idSubNivel == 0)){
		console.log('nivel -a',idNivel);
		console.log('idSubNivel -a',idSubNivel);
		$('#select-invalidate-nivel').addClass('form-invalid');
		$('#select-invalidate-subnivel').addClass('form-invalid');
	} 
	else {
	var idNivel = $('#cmm_nivel').val();
	var idSubNivel = $('#cmm_sub_nivel').val();
	var idUnidad = $('#codigoUnidadBean').val();
	var unidad = $('#unidad').val();
	var nombre = $('#nombreUnidad').val();
	var descrip = $('#descripcionUnidad').val();
	var inputFileImage = document.getElementById('file1v');
	var file = inputFileImage.files[0];
	var data = new FormData();
	//$('#select-invalidate-nivel').removeClass('form-invalid');
	/*
	 * data.append('codLengua', idLengua); data.append('codSubNivel',
	 * idSubNivel); data.append('unidad', unidad); data.append('nombreUnidad',
	 * nombre); data.append('files', file); data.append('descripcion', descrip);
	 * data.append('codUnidadBean', idUnidad );
	 */

	let url = contextPath + "/lenguaController/grabarUnidad";
	if (idNivel==0 ||  idSubNivel == 0 || unidad == 0 || nombre == "") {
		$('#select-invalidate-nivel').removeClass('form-invalid');
		if(idSubNivel==0){
			console.log('nivel -b',idNivel);
			console.log('idSubNivel -b',idSubNivel);
			$('#select-invalidate-subnivel').addClass('form-invalid');
		} else{
			$('#select-invalidate-subnivel').removeClass('form-invalid');
		}
		console.log('idSubNivel',idSubNivel);
		msg_advertencia("Complete los campos requeridos(*).");
	} else {
		// alert("contextPath " + url)
		$.ajax({
			type : "POST",
			url : url,
			// contentType:false,
			data : $('#frmInsertarUnidad').serialize(),
			// processData:false,
			// cache:false,
			success : function(data) {
				if (data == "0") {
					msg_advertencia("Registro ya existe.");
				}
				if (data == "1") {
					msg_exito();

					refrescarTablaListadoUnidad();
				}
				if (data == "2") {
					msg_advertencia("Complete los campos requeridos(*).")
				}
				if (data == "3") {
					msg_advertencia("La unidad ya fue registrada")
				}
				if (data == "4") {
					// msg_advertencia("Seleccione una lengua.");
				}
				if (data == "5") {
					// msg_advertencia("Existe lengua.");
				}
			},
			error : function(xhr, status, er) {
				msg_error();
				//console.log("error: " + xhr + " status: " + status + " er:"
						//+ er);
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
				limpiarDatosUnidad();
				// listarDirectorInstitucion();
			}
		});
	}
  } 
}

function grabarNivel() {
	var actionForm = $('#frmRegistroLenguaNivel').attr("action");
	var contextPath = $('#contextPath').val();
	var idLengua = $('#codigoLengua').val();
	if (idLengua == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else {
	var idNivel = $('#cboNivel').val();
	var url = contextPath + "/lenguaController/" + actionForm;

	if (idNivel == 0) {
		msg_advertencia("Complete los campos requeridos(*).")
	} else {
		// alert("contextPath " + url)
		$.ajax({
			type : "POST",
			url : url,

			data : $('#frmRegistroLenguaNivel').serialize(),
			success : function(data) {
				if (data == "0") {
					msg_advertencia("Registro ya existe.");
				}
				if (data == "1") {
					msg_exito();
					refrescarTablaDetalleEstructura();
				}
				if (data == "2") {
					msg_advertencia("Complete los campos requeridos(*).")
				}
				if (data == "3") {
					msg_advertencia("El Nivel ya fue registrado")
				}
				if (data == "4") {
					// msg_advertencia("Seleccione una lengua.");
				}
				if (data == "5") {
					// msg_advertencia("Existe lengua.");
				}
			},
			error : function(xhr, status, er) {
				msg_error();
				//console.log("error: " + xhr + " status: " + status + " er:"
					//	+ er);
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
				limpiarNivel();
				// listarDirectorInstitucion();
			}
		});
	  }
	}
}

function modificarNivel(codigo) {

	var contextPath = $('#contextPath').val();
	;

	$
			.ajax({
				url : contextPath + "/lenguaController/modificarNivel?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) {
					if (data != null || data.length > 0) {
						//console.log("data " + data.codigo);
						$('#cboNivel').val(data.nivel.codigoRegistro);
						$('#nombreNivel').val(data.nombreNivel);
						$('#codigoNivelBean').val(data.codigo);
					}
				},
				error : function(request, status, error) {

				}
			});
}

function limpiarUnidad() {
	$('#cmm_nivel').val("0");
	$('#cmm_sub_nivel').empty();
	$('#cmm_sub_nivel').html("<option value='0'>Seleccione</option>");
	$('#unidad').val("");
	$('#descripcionUnidad').val("");
	$('#traduccion').val("");
	$('#nombreUnidad').val("");
	$('#codigoUnidadBean').val("0");
}
function limpiarLeccion() {
	$('#codigoLeccion').val("0");
	// $('#situacionLeccion').empty();
	$('#situacionLeccion').val("");
	// $('#cmm_leccion').empty();
	$('#cmm_leccion').val("");
	$('#nombreLeccion').val("")
}

function limpiarNivel() {
	$('#cboNivel').val("");
	// $('#cboNivel').empty();
	// $('#cboNivel').html("<option value='0'>Seleccione</option>");
	$('#nombreNivel').val("");
	$('#codigoNivelBean').val("0");
}

function modificarUnidad(codigo) {

	var contextPath = $('#contextPath').val();
	;

	$.ajax({
		url : contextPath + "/lenguaController/modificarUnidad?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {
			if (data != null || data.length > 0) {
				//console.log("data " + data.lenguaEstructuraBean.codigo);
				$('#cmm_nivel').val(
						data.lenguaEstructuraBean.nivel.codigoRegistro);
				cargarSubNiveles(data.lenguaEstructuraBean.codigo);

				$('#unidad').val(data.unidad.codigoRegistro);
				$('#descripcionUnidad').val(data.descripcion);
				$('#traduccion').val("");
				// $('#cmm_sub_nivel').val(data.lenguaEstructuraBean.codigo);
				$('#nombreUnidad').val(data.nombre);
				$('#codigoUnidadBean').val(data.codigo);

				var imgid = "imgmas1v";
				var file = "file1v";
				// var idDetalle = "idRelacionDetalle"+(i+1);
				var imgsrc = contextPath + "/unidad/" + data.nombreImagen;
				$('#' + imgid).attr('src', imgsrc);
				$("#file1v").attr("value", data.nombreImagen);
			}
		},
		error : function(request, status, error) {

		}
	});
}

function eliminarUnidad(codigo) {
	// alert("eliminarUnidad " + codigo);

	var contextPath = $('#contextPath').val();

	$
			.ajax({
				url : contextPath + "/lenguaController/eliminarUnidad?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) {
					msg_exito();
					$('#md_confirmacion').modal('hide');
					refrescarTablaListadoUnidad();

				},
				error : function(request, status, error) {
//					alert(error);
				}
			});
}


function refrescarTablaListadoLengua() {
	var contextPath = $('#contextPath').val();
	$.ajax({
		url : contextPath + "/lenguaController/listarLenguas?codigo=0",
		type : 'GET',

		success : function(data) {
			//console.log("SUCCESS: ", data);
			$('#listadoDetalleLengua').html(data);
		},
		error : function() {
			//console.log("ERROR: ");
		}
	});

}

function refrescarTablaListadoUnidad() {
	//debugger;
	var contextPath = $('#contextPath').val();
	var idLengua = $('#codigoLengua').val();
	var html = "";
	var nombreLecciones ="";
	$.ajax({
		url : contextPath + "/lenguaController/listarUnidades?codigo="
				+ idLengua,
		type : 'POST',

		success : function(data) {
			console.log(data);
			if (data != null) {
				for (var i = 0; i < data.length; i++) {
					//alert("data[i].nombreLecciones " + data[i].nombreLecciones);
					if(data[i].nombreLecciones == null || data[i].nombreLecciones =="null"  ){
						nombreLecciones ="";
					}else{
						nombreLecciones = data[i].nombreLecciones; 
					}
					html = html
							+ "<tr>"
							+ "<td>"+(i + 1)+"</td>"
							+ "<td>" + data[i].lenguaEstructuraBean.nivel.nombreCorto + "</td>"
							+ "<td>" + data[i].lenguaEstructuraBean.subNivel.nombreCorto + "</td>"
							+ "<td>" + data[i].unidad.nombreCorto + "</td>"
							+ "<td>" + nombreLecciones + "</td>" 
							+ "<td> <button id='idBtnBuscarLeccion' type='button' onclick='lenguaCargarModalUnidadLeccion(\""
							+ data[i].codigo
							+ "\")' class='btn btn-outline-success btn-sm' title='Asignar Lecci&oacute;n'><i class='icon-plus'></i>Lección</button>"
							
							+ "<button id='idBtnEditarUnidad' type='button' onclick='modificarUnidad(\""
							+ data[i].codigo
							+ "\")' class='btn btn-outline-success btn-sm' title='Editar'><i class='icon-pencil'></i></button>"
							
							+" <button id='idBtnEliminarUnidad' type='button' onclick='confirmar_accion(\""
							+ data[i].codigo
							+ "\",\""
							+ 'unidad'
							+ "\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>"; 
				}
				//console.log("SUCCESS: ", html);
				$('#bodylstUnidadBean').empty()
				$('#bodylstUnidadBean').html(html);
			} else {
			//	console.log("lista null");
			}
			
	
		},
		error : function(xhr, status, er) {
			// msg_error();
			//console.log("error: " + xhr + " status: " + status + " er:" + er);
		}
	});

}
 
function grabarLeccion() {
	var actionForm = $('#frmInsertarLeccion').attr("action");
	var contextPath = $('#contextPath').val();
	var url = contextPath + "/lenguaController/" + actionForm;
	// alert("contextPath:: " + url)
	// variables
	var idUnidad = $('#codigoUnidad').val();
	var nombreLeccion = $('#nombreLeccion').val();
	var sitLeccion = $('#situacionLeccion').val();
	var leccion = $('#cmm_leccion').val();
	var idLeccion = $('#codigoLeccion').val();

	var inputFileImage = document.getElementById('file2v');
	var file = inputFileImage.files[0];
	var data = new FormData();

	data.append('idUnidad', idUnidad);
	data.append('nombreLeccion', nombreLeccion);
	data.append('sitLeccion', sitLeccion);
	data.append('leccion', leccion);
	data.append('files', file);
	data.append('idLeccion', idLeccion);

	//console.log("nombreLeccion" + nombreLeccion);
	//console.log("sitLeccion" + sitLeccion);
	//console.log("idLeccion" + idLeccion);

	if (leccion == "" || nombreLeccion == "" || sitLeccion == "") {
		msg_advertencia("Complete los campos requeridos(*).");
	} else {
		$.ajax({
			type : "POST",
			url : url,
			// contentType:false,
			data : $('#frmInsertarLeccion').serialize(),
			// processData:false,
			// cache:false,
			success : function(data) {
				if (data == "0") {
					msg_advertencia("Registro ya existe.");
				}
				if (data == "1") {
					msg_exito();
					$('#modalLenguaEstructuraUnidad').modal('hide');
					refrescarTablaListadoUnidad();
				}
				if (data == "2") {
					msg_advertencia("Complete los campos requeridos(*).");
				}
				if (data == "3") {
					msg_advertencia("La lecci&oacute;n ya fue registrada");
				}
				if (data == "4") {
					// msg_advertencia("Seleccione una lengua.");
				}
				if (data == "5") {
					// msg_advertencia("Existe lengua.");
				}
			},
			error : function(xhr, status, er) {
				msg_error();
			//	console.log("error: " + xhr + " status: " + status + " er:"
					//	+ er);
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
				limpiarDatosUnidad();
				// listarDirectorInstitucion();
			}
		});
	}
}
function modificarLeccion(codigo) {
	// alert("modificarLeccion " +codigo )
	var contextPath = $('#contextPath').val();
	;

	$.ajax({
		url : contextPath + "/lenguaController/modificarLeccion?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {
			if (data != null || data.length > 0) {
				//console.log("data.leccion.codigoRegistro "
				//		+ data.leccion.codigoRegistro);
				$('#situacionLeccion').val(data.situacion.codigoRegistro);
				$('#nombreLeccion').val(data.nombre);
				$('#codigoLeccion').val(data.codigo);
				$('#codigoUnidad').val(data.unidadBean.codigo);
				if (data.leccion.codigoRegistro == 0) {
					$('#cmm_leccion').val("");
				} else {
					$('#cmm_leccion').val(data.leccion.codigoRegistro);
				}

			}
		},
		error : function(request, status, error) {

		}
	});
}

function eliminarLeccion(codigo) {
	// alert("eliminarUnidad " + codigo);

	var contextPath = $('#contextPath').val();

	$.ajax({
		url : contextPath + "/lenguaController/eliminarLeccion?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {
			msg_exito();
			$('#md_confirmacion').modal('hide');
			$('#modalLenguaEstructuraUnidad').modal('hide');
			refrescarTablaListadoUnidad();
		},
		error : function(request, status, error) {
//			alert(error);
		}
	});
}

function limpiarDatosUnidad() {
	//$('#cmm_sub_nivel').val("0");
	$('#unidad').val("");
	$('#descripcionUnidad').val("");
	$('#traduccion').val("");
	$('#nombreUnidad').val("");
	$('#codigoUnidadBean').val("0");
	$("#imgmas1v").attr("src", "../assets/img/usar_imagen.jpg");
	$("#file1v").val("");

}

function cargarNiveles() {
	var codigoLengua = $('#codigoLengua').val();
	$
			.ajax({
				type : "GET",
				data : "codigo=" + codigoLengua,
				url : "${pageContext.request.contextPath}/lenguaController/cargarNiveles",
				success : function(data) {
					if (data != null) {

					/**	data.sort(function(a, b) {
							return (a.codigoRegistro - b.codigoRegistro);
						});*/

						html += "<option value='0'>Seleccione</option>";
						for (var i = 0; i < data.length; i++) {
							html += "<option value='" + data[i].codigoRegistro
									+ "'>" + data[i].nombreCorto + "</option>";
						}
					} else {
						html += "<option value='0'>Seleccione</option>";
					}

				},
				error : function(xhr, status, er) {
					//console.log("error: " + xhr + " status: " + status + " er:"
						//	+ er);
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
					$('#cmm_nivel').empty();
					$('#cmm_nivel').html(html);
				}
			});

}

function cargarSubNiveles(codLengEstructura) {
	var idLengua = $('#codigoLengua').val();
	var idNivel = $('#cmm_nivel').val();
	var idSubNivel = $('#cmm_sub_nivel').val();
	var contextPath = $('#contextPath').val();
	var empty=true;
	var html = "";
	
	console.log('entro cargarSubNiveles');
	// alert(idLengua + ": " + idNivel+ ": " + contextPath)
	$.ajax({
		type : "GET",
		data : "codigo=" + idLengua + "&codnivel=" + idNivel,

		url : contextPath + "/lenguaController/cargarSubNiveles",

		success : function(data) {
			if (data != null && idNivel!=0) {

				/*data.sort(function(a, b) {
					return (a.codigoRegistro - b.codigoRegistro);
				});*/

				html += "<option value='0'>Seleccione</option>";
				for (var i = 0; i < data.length; i++) {
					if (data[i].codigo == codLengEstructura) {
						html += "<option value='" + data[i].codigo
								+ "' selected='true'>"
								+ data[i].subNivel.nombreCorto + "</option>";
					} else {
						html += "<option value='" + data[i].codigo + "'>"
								+ data[i].subNivel.nombreCorto + "</option>";
					}
					if(data[i].codigo==idSubNivel){
						empty = false;
						console.log('entro cargarSubNiveles empty');
					}
				}
				
				
			} else {
				html += "<option value='0'>Seleccione</option>";
			}

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
		complete : function() {
			if(empty){
				//idSubNivel = 0 por tanto se borra la data
				$('#cmm_sub_nivel').empty();
				$('#cmm_sub_nivel').html(html);
				/*
				if(idNivel!=0){
					console.log('empty idNivel');
					$('#select-invalidate-subnivel').addClass('form-invalid');
				} else {
					$('#select-invalidate-subnivel').removeClass('form-invalid');
				}
				*/
			} 
		}
	});
}

function lenguaCargarModalUnidadLeccion(codigo) {
	var contextPath = $('#contextPath').val();
	$('#codigoUnidad').val(codigo);
	// alert("codigoUnidad"+ codigo);
	if (codigoLengua == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else {
		$.ajax({
			type : "POST",

			url : contextPath
					+ "/lenguaController/lenguaCargarModalUnidadLeccion",
			data : {
				codigo : codigo
			},

			success : function(data) {
				//console.log("SUCCESS: ", data);
				$("#modalLenguaEstructuraUnidad").modal('show');
				$("#modalLenguaEstructuraUnidadContent").html(data);

			},
			error : function(xhr, status, er) {
				//console.log("error: " + xhr + " status: " + status + " er:"
				//		+ er);
				//console.log("ERROR: ");
			}
		});
	}
}

function lenguaCargarModalNivel(codigo, codigoNivel) {
	var contextPath = $('#contextPath').val();
	$('#codigoNivelBean').val(codigo);
	$('#codigoNivel').val(codigoNivel);
	if (codigoLengua == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else {

		$.ajax({
			type : "POST",

			url : contextPath + "/lenguaController/lenguaCargarModalSubNivel",
			data : {
				codigo : codigo,
				codigoNivel : codigoNivel
			},

			success : function(data) { 
				$("#modalLenguaEstructuraUnidad").modal('show');
				$("#modalLenguaEstructuraUnidadContent").html(data);

			},
			error : function(xhr, status, er) {
				//console.log("error: " + xhr + " status: " + status + " er:"
				//		+ er);
				//console.log("ERROR: ");
			}
		});
	}
}

function cargarUnidades() {
	var idLengua = $('#cmm_lengua').val();
	var idNivel = $('#cmm_nivel').val();
	var idSubNivel = $('#cmm_sub_nivel').val();
	// var contextPath = $('#contextPathUrl').val();
	// var html = "";
//	alert(idSubNivel);
	//console.log(idSubNivel);
	if (idSubNivel != '0') {
		$('#cmm_unidades').val('0');
		$('#idDivContSelecUnidad').css('display', 'block');
		$('#select-invalidate').removeClass('form-invalid');
	} else {
//		$('#idDivContSelecUnidad').css('display', 'none');
		$('#select-invalidate').addClass('form-invalid');
		$('#cmm_unidades').val('0');
	}
}

function modificarLenguaEstructura(codigo) {

	var contextPath = $('#contextPath').val();
	;

	$.ajax({
		url : contextPath
				+ "/lenguaController/modificarLenguaEstructura?codigo="
				+ codigo,
		type : 'GET',
		success : function(data) {
			if (data != null || data.length > 0) {
				//console.log("data nombreImagen " + data.nombreImagen);
				$('#cboLenguasubNivel').val(data.subNivel.codigoRegistro);
				$('#codigoNivel').val(data.nivel.codigoRegistro);
				$('#codigoEstructura').val(data.codigo);

				var imgid = "imgNivel";
				var file = "fileSubNivel";
				// var idDetalle = "idRelacionDetalle"+(i+1);
				var imgsrc = contextPath + "/subNivel/" + data.nombreImagen;
				$('#' + imgid).attr('src', imgsrc);
				$("#fileSubNivel").attr("value", data.nombreImagen);
			}
		},
		error : function(request, status, error) {

		}
	});
}

function eliminarLenguaEstructura(codigo) {
	//alert("eliminarLenguaEstructura " + codigo);

	var contextPath = $('#contextPath').val();

	$
			.ajax({
				url : contextPath
						+ "/lenguaController/eliminarLenguaEstructura?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) {
					msg_exito();
					$('#md_confirmacion').modal('hide');
					$('#modalLenguaEstructuraUnidad').modal('hide');
					//refrescarTablaListadoUnidad();
					refrescarTablaDetalleEstructura();
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
}

function grabarEstructura() {

	var actionForm = $('#frmInsertarSubNivel').attr("action");

	var contextPath = $('#contextPath').val();
	var codigo = $('#codigoEstructura').val();
	var idLengua = $('#codigoLengua').val();
	if (idLengua == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else {
	var idSubNivel = $('#cboLenguasubNivel').val();
	var idNivelBean = $('#codigoNivelBean').val();
	var codRegNivel = $('#codigoNivel').val();
	var inputFileImage = document.getElementById('fileSubNivel');
	var file = inputFileImage.files[0];
	var data = new FormData();

	data.append('codigo', codigo);
	data.append('codNivelBean', idNivelBean);
	data.append('codLengua', idLengua);
	data.append('codRegNivel', codRegNivel);
	data.append('codRegSubNivel', idSubNivel);

	let
	url = "";
	if (idSubNivel == 0) {
		msg_advertencia("Complete los campos requeridos(*).")
	} else {
		// alert("contextPath " + url)
		if (file != undefined) {
			data.append('files', file); 
			url = contextPath + "/lenguaController/grabarEstructura";
		} else { 
			url = contextPath + "/lenguaController/grabarEstructuraSinImg";
		}
		$.ajax({
			type : "POST",
			url : url,
			contentType : false,
			data : data,
			processData : false,
			cache : false,
			success : function(data) {

				if (data == "0") {
					msg_advertencia("Registro ya existe.");
				}
				if (data == "1") {
					msg_exito();
					// $('#modalLenguaEstructura').modal('hide');
					$("#btnCerrarSubNivel").trigger("click");
					refrescarTablaDetalleEstructura();
				}
				if (data == "2") {
					msg_advertencia("Complete los campos requeridos(*).")
				}
				if (data == "3") {
					msg_advertencia("La unidad ya fue registrada")
				}
				if (data == "4") {
					// msg_advertencia("Seleccione una lengua.");
				}
				if (data == "5") {
					// msg_advertencia("Existe lengua.");
				}
			},
			error : function(xhr, status, er) {
				msg_error();
				//console.log("error: " + xhr + " status: " + status + " er:"
				//		+ er);
				if (xhr.status == 500) {
				//	console.log(er);
					// Error_500(er);
				}
				if (xhr.status == 901) {
				//	console.log(er);
					// spire_session_901(er);
				}
			},
			complete : function() {
				// listarDirectorInstitucion();
			}
		});
	   }
	}
}

var buttonValidate = true;
/** Mantenimiento LenguaUnidad * */
function grabarLenguaUnidad() {
	if(buttonValidate){
		buttonValidate = false;
		var contextPath = $('#contextPath').val();
		var idLengua = $('#codigoLengua').val();
		if (idLengua == 0) {
			msg_advertencia("¡Debe registrar lengua.!");
			buttonValidate = true;
		} else {
		var nombreLenguaUnidad = $('#nombreLenguaUnidad').val();
		var lenguaUnidad = $('#lenguaUnidad').val();
		var idLenguaUnidad = $('#codLenguaUnidad').val();
		var inputFileImage = document.getElementById('fileLenguaUnidad');
		var files = inputFileImage.files[0];
		var inputFileImage2 = document.getElementById('fileLenguaUnidadBloq');
		var fileBloq = inputFileImage2.files[0];
		var data = new FormData();
	
		data.append('codLengua', idLengua);
		data.append('nombreLenguaUnidad', nombreLenguaUnidad);
		data.append('nomlenun', nomlenun);
		data.append('nomlenunb', nomlenunb);
		data.append('lenguaUnidad', lenguaUnidad);
		if (files != undefined) {
			;
		}
		if (fileBloq != undefined) {
			
		}
		// }
		data.append('files', files);
		data.append('fileBloq', fileBloq);
		data.append('idLenguaUnidad', idLenguaUnidad);
		
		let
		url = contextPath + "/lenguaController/grabarLenguaUnidad";
		
		if(idLenguaUnidad=="" || idLenguaUnidad == null ||  idLenguaUnidad == 0 || idLenguaUnidad== undefined){
			if (nombreLenguaUnidad == "" || lenguaUnidad == 0) {
				msg_advertencia("Complete los campos requeridos.")
				buttonValidate = true;
			} else if(files == undefined){
				msg_advertencia("Ingrese imagen de la unidad.")
				buttonValidate = true;
			}else if(fileBloq == undefined){
				msg_advertencia("Ingrese imagen bloqueada de la unidad.")
				buttonValidate = true;
			}else{
				$.ajax({
					type : "POST",
					url : url,
					contentType : false,
					data : data,
					processData : false,
					cache : false,
					success : function(data) {
						buttonValidate = true;
						if (data != null) {
							if(data == -1){
								msg_advertencia("Formato imagen incorrecto.");
							}else if (data == 0) {
								msg_advertencia("La unidad ya fue registrada.");
							} else {
								msg_exito();
								$('#codLenguaUnidad').val(data);
								listarLenguaUnidad();
								nuevoLenguaUnidad();
							}
						}
					},
					error : function(xhr, status, er) {
						buttonValidate = true;
						msg_error();
						//console.log("error: " + xhr + " status: " + status + " er:"
						//		+ er);
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
						// listarDirectorInstitucion();
					}
				});
			}		
		}else{
			
			if(files == undefined && fileBloq == undefined ){
				url = contextPath + "/lenguaController/grabarLenguaUnidadSinImg";
			}else if(files == undefined){
				url = contextPath + "/lenguaController/grabarLenguaUnidadImgb";
			}else if(fileBloq == undefined){
				url = contextPath + "/lenguaController/grabarLenguaUnidadImg";
			}else{
				url = contextPath + "/lenguaController/grabarLenguaUnidad";
			}
			
			
			if (nombreLenguaUnidad == "" || lenguaUnidad == 0) {
				msg_advertencia("Complete los campos requeridos.")
				buttonValidate = true;
			}/* else if(files == undefined){
				msg_advertencia("Ingrese imagen de la unidad.")
			}else if(fileBloq == undefined){
				msg_advertencia("Ingrese imagen bloqueada de la unidad.")
			}*/else{
				$.ajax({
					type : "POST",
					url : url,
					contentType : false,
					data : data,
					processData : false,
					cache : false,
					success : function(data) {
						buttonValidate = true;
						if (data != null) {
							if(data == -1){
								msg_advertencia("Formato imagen incorrecto.");
							}else if (data == 0) {
								msg_advertencia("La unidad ya fue registrada.");
							} else {
								msg_exito();
								$('#codLenguaUnidad').val(data);
								listarLenguaUnidad();
								nuevoLenguaUnidad();
							}
						}
					},
					error : function(xhr, status, er) {
						buttonValidate = true;
						msg_error();
						//console.log("error: " + xhr + " status: " + status + " er:"
						//		+ er);
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
						// listarDirectorInstitucion();
					}
				});
			}	 
			
		}
		
		
	
	}
	
	
	
}
}

function listarLenguaUnidad() {
	var idLengua = $('#codigoLengua').val();
	var contextPath = $('#contextPath').val();
	let
	url = contextPath + "/lenguaController/listarLenguaUnidad";
	var html = "";
	$
			.ajax({
				type : 'POST',
				data : {
					codLengua : idLengua
				},
				url : url,
				success : function(data) {
					//console.log("SUCCESS: ", data);
					if (data != null) {
						for (var i = 0; i < data.length; i++) {
							html = html
									+ "<tr id='codLenguaUnidad"
									+ data[i].codigo
									+ "'> <td>"
									+ (i + 1)
									+ "</td><td>"
									+ data[i].unidad.nombreCorto
									+ "</td> <td> <button type='button' id='file-upload' onclick='editarLenguaUnidad(\""
									+ data[i].codigo
									+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""
									+ 'lenguaUnidad'
									+ "\",\""
									+ data[i].codigo
									+ "\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
						}
						$('#idBodyLenguaUnidad').html(html);
					} else {
						//console.log("lista null");
					}

				},
				error : function(data) {
				//	console.log("error de listarMaterialTipoEjercicio :" + data
				//			+ error);
				}
			});
}

var nomlenun = "";
var nomlenunb = "";

function editarLenguaUnidad(id) {
	var contextPath = $('#contextPath').val();
	let
	url = contextPath + "/lenguaController/editarLenguaUnidad";
	$.ajax({
		type : 'POST',
		data : {
			codLenguaUnidad : id
		},
		url : url,
		success : function(data) {
			//console.log("SUCCESS: ", data);
			if (data != null) {
				nomlenun  = data.nombreImagen;
				nomlenunb = data.nombreImagenBloqueado;
				
				$('#codLenguaUnidad').val(data.codigo);
				$('#nombreLenguaUnidad').val(data.nombreUnidad);
				$('#lenguaUnidad').val(data.unidad.codigoRegistro);

				var imgsrc = contextPath + "/unidad/" + data.nombreImagen;
				$('#imagenLenguaUnidad').attr('src', imgsrc);
				$('#fileLenguaUnidad').attr('value', data.nombreImagen);

				var imgsrc2 = contextPath + "/unidad/"
						+ data.nombreImagenBloqueado;
				$('#imagenLenguaUnidadBloq').attr('src', imgsrc2);
				$('#fileLenguaUnidadBloq').attr('value',
						data.nombreImagenBloqueado);
				
				document.getElementById("file-upload").onchange = function() {
					  document.getElementById("imagenLenguaUnidad").value = data.nombreImagen;
					};
			} else {
				//console.log("lista null");
			}
		},
		error : function(data) {
		//	console
			//		.log("error de listarMaterialTipoEjercicio :" + data
				//			+ error);
		}
	});
}
function eliminarLenguaUnidad(id) {
	var contextPath = $('#contextPath').val();
	let
	url = contextPath + "/lenguaController/eliminarLenguaUnidad";
	$.ajax({
		type : 'POST',
		data : {
			codLenguaUnidad : id
		},
		url : url,
		success : function(data) {
			//console.log("SUCCESS: ", data);
			if (data != null) {
				if (data == "1") {
					$('#md_confirmacion').modal('hide');
					listarLenguaUnidad();
					msg_exito();
				}
			} else {
				//console.log("lista null");
			}

		},
		error : function(data) {
			console
					.log("error de listarMaterialTipoEjercicio :" + data
							+ error);
		}
	});
}
var accion_tab = "";
var codigoEliminar = "";
/*
 * function confirmar_accion() {
 * 
 * $('#md_confirmacion').modal('show'); }
 */
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}

$("#btnConfirmarGeneric").click(function() {

	if (accion_tab.indexOf("lenguaUnidad") >= 0) {
		eliminarLenguaUnidad(codigoEliminar);
		accion_tab = "";

		if (codigoEliminar == $("#codLenguaUnidad").val()) {
			nuevoLenguaUnidad();
		}
		codigoEliminar = "";

	}
	if (accion_tab.indexOf("leccion") >= 0) {
		eliminarLenguaLeccion(codigoEliminar);
		if (codigoEliminar == $("#codLenguaLeccion").val()) {
			nuevoLenguaLeccion();
		}
		accion_tab = "";
		codigoEliminar = "";
	}

});

function confirmar_eliminar(tabla, codigo) {
	//console.log("tabla " + tabla);
	accion_tab = tabla;
	codigoEliminar = codigo;
	$('#md_confirmacion').modal('show');
}
function nuevoLenguaUnidad() {
	$("#imagenLenguaUnidad").attr("src", "../assets/img/usar_imagen.jpg");
	$("#fileLenguaUnidad").val("");
	$("#imagenLenguaUnidadBloq").attr("src", "../assets/img/usar_imagen.jpg");
	$("#fileLenguaUnidadBloq").val("");
	$('#codLenguaUnidad').val("0");
	$('#nombreLenguaUnidad').val("");
	$('#lenguaUnidad').val(0);

}
/** Mantenimiento LenguaLeccion * */
function grabarLenguaLeccion() {

	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmInsertarLenguaLeccion').attr("action");
	var idLengua = $('#codigoLengua').val();
	if (idLengua == 0) {
		msg_advertencia("¡Debe registrar lengua.!");
	} else {
	var nombreLenguaLeccion = $('#nombreLenguaLeccion').val();
	var lenguaLeccion = $('#lenguaLeccion').val();
	var idLenguaLeccion = $('#codLenguaLeccion').val();
	var inputFileImage = document.getElementById('fileLenguaLeccion');
	var file = inputFileImage.files[0]; 
	var inputFileImage2 = document.getElementById('fileLenguaLeccionBloq'); 
	var files = inputFileImage2.files[0];
	var dataee = new FormData();

	dataee.append('codLengua', idLengua);
	dataee.append('nombreLenguaLeccion', nombreLenguaLeccion);
	dataee.append('lenguaLeccion', lenguaLeccion);
	if (file != undefined) {
		dataee.append('file', file);// file
	}
	if (files != undefined) {
		dataee.append('files', files);// files
	}
	dataee.append('idLenguaLeccion', idLenguaLeccion);
	let
	url = contextPath + "/lenguaController/" + actionForm;
	
	
	
	
	
	if(idLenguaLeccion== 0 || idLenguaLeccion == null || idLenguaLeccion == "" || idLenguaLeccion == undefined){
	
		if (nombreLenguaLeccion == "") {
			msg_advertencia("Completar los campos requeridos.")
		} else if(file == undefined){
			msg_advertencia("Ingrese imagen de la lección.")
		}else if (files == undefined){
			msg_advertencia("Ingrese imagen bloqueada de la lección.")
		}else{
			$.ajax({
				type : "POST",
				url : url,
				dataType : 'json',
				enctype : 'multipart/form-data',
				data : dataee,
				processData : false,
				contentType : false,
				cache : false,
				success : function(data) {
					if (data != null) {
						if(data == -1){
							msg_advertencia("Formato imagen incorrecto.");
						}else if (data == 0) {
							msg_advertencia("La lección ya fue registrada.");
						}else {
							msg_exito();
							$('#codLenguaLeccion').val(data);
	
						}
					}
				},
				error : function(xhr, status, er) {
					msg_error();
					//console.log("error: " + xhr + " status: " + status + " er:"
				//			+ er);
					if (xhr.status == 500) {
					//	console.log(er);
					}
					if (xhr.status == 901) {
					//	console.log(er);
					}
				},
				complete : function() {
					listarLenguaLeccion();
					nuevoLenguaLeccion();
				}
			});
		}
	}else{
		
		
		if(files == undefined && file == undefined ){
			url = contextPath + "/lenguaController/grabarLenguaLeccionSinImg";
		}else if(files == undefined){
			url = contextPath + "/lenguaController/grabarLenguaLeccionImg";
		}else if(file == undefined){
			url = contextPath + "/lenguaController/grabarLenguaLeccionImgb";
		}else{
			url = contextPath + "/lenguaController/grabarLenguaLeccion";
		}
		
		
		if (nombreLenguaLeccion == "") {
			msg_advertencia("Completar los campos requeridos.")
		} else{
			$.ajax({
				type : "POST",
				url : url,
				dataType : 'json',
				enctype : 'multipart/form-data',
				data : dataee,
				processData : false,
				contentType : false,
				cache : false,
				success : function(data) {
					if (data != null) {
						if(data == -1){
							msg_advertencia("Formato imagen incorrecto.");
						}
						else if (data == 0) {
							msg_advertencia("La lección ya fue registrada.");
						} else {
							msg_exito();
							$('#codLenguaLeccion').val(data);
	
						}
					}
				},
				error : function(xhr, status, er) {
					msg_error();
					//console.log("error: " + xhr + " status: " + status + " er:"
				//			+ er);
					if (xhr.status == 500) {
					//	console.log(er);
					}
					if (xhr.status == 901) {
					//	console.log(er);
					}
				},
				complete : function() {
					listarLenguaLeccion();
					nuevoLenguaLeccion();
				}
			});
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  }
}

function listarLenguaLeccion() {
	var idLengua = $('#codigoLengua').val();
	var contextPath = $('#contextPath').val();
	let
	url = contextPath + "/lenguaController/listarLenguaLeccion";
	var html = "";
	$
			.ajax({
				type : 'POST',
				data : {
					codLengua : idLengua
				},
				url : url,
				success : function(data) {
				//	console.log("SUCCESS: ", data);
					if (data != null) {
						for (var i = 0; i < data.length; i++) {
							html = html
									+ "<tr id='codLenguaLeccion"
									+ data[i].codigo
									+ "'> <td>"
									+ (i + 1)
									+ "</td><td>"
									+ data[i].leccion.nombreCorto
									+ "</td> <td> <button type='button' onclick='editarLenguaLeccion(\""
									+ data[i].codigo
									+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""
									+ 'leccion'
									+ "\",\""
									+ data[i].codigo
									+ "\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
						}
						$('#idBodyLenguaLeccion').html(html);
					} else {
					//	console.log("lista null");
					}

				},
				error : function(data) {
				//	console.log("error de listarMaterialTipoEjercicio :" + data
					//		+ error);
				}
			});
}
function eliminarLenguaLeccion(id) {
	var contextPath = $('#contextPath').val();
	let
	url = contextPath + "/lenguaController/eliminarLenguaLeccion";
	$.ajax({
		type : 'POST',
		data : {
			codLenguaLeccion : id
		},
		url : url,
		success : function(data) {
			//console.log("SUCCESS: ", data);
			if (data != null) {
				if (data == "1") {
					$('#md_confirmacion').modal('hide');
					listarLenguaLeccion();
					msg_exito();
				}
			} else {
				//console.log("lista null");
			}

		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
}
function editarLenguaLeccion(id) {
	var contextPath = $('#contextPath').val();
	let
	url = contextPath + "/lenguaController/editarLenguaLeccion";
	$.ajax({
		type : 'POST',
		data : {
			codLenguaLeccion : id
		},
		url : url,
		success : function(data) {
			//console.log("SUCCESS: ", data);
			if (data != null) {
				$('#codLenguaLeccion').val(data.codigo);
				$('#nombreLenguaLeccion').val(data.nombreLeccion);
				$('#lenguaLeccion').val(data.leccion.codigoRegistro);

				var imgsrc = contextPath + "/leccion/" + data.nombreImagen;
				var file = "file" + 1;
				$('#nombreImagenLeccion').val(data.nombreImagen);
				$('#imagenLenguaLeccion').attr('src', imgsrc);

				// $('#nombreImagenLeccion').attr("value",data.nombreImagen);

				$('#fileLenguaLeccion').attr("value",
						contextPath + "/leccion/" + data.nombreImagen);

				var imgsrcBloc = contextPath + "/leccion/"
						+ data.nombreImagenBloq;
				var file = "file" + 2;
				$('#nombreImagenLeccionBloq').val(data.nombreImagenBloq);
				$('#imagenLenguaLeccionBloq').attr('src', imgsrcBloc);

				// $('#nombreImagenLeccionBloq').attr("value",data.nombreImagenBloq);

				$('#fileLenguaLeccionBloq').attr("value",
						contextPath + "/leccion/" + data.nombreImagenBloq);

			} else {
				//console.log("lista null");
			}

		},
		error : function(data) {
		//	console
		//			.log("error de listarMaterialTipoEjercicio :" + data
		//					+ error);
		}
	});
}
function nuevoLenguaLeccion() {
	$("#imagenLenguaLeccion").attr("src", "../assets/img/usar_imagen.jpg");
	$("#fileLenguaLeccion").val("");
	$("#imagenLenguaLeccionBloq").attr("src", "../assets/img/usar_imagen.jpg");
	$("#fileLenguaLeccionBloq").val("");
	$('#codLenguaLeccion').val("0");
	$('#nombreLenguaLeccion').val("");
	$('#lenguaLeccion').val(0);
} 

function limpiar_imagenes(){
    $('#imgmas1').attr('src','../assets/img/usar_imagen.jpg');
    $('#imgmas2').attr('src','../assets/img/usar_imagen.jpg');
    $('#imgmas3').attr('src','../assets/img/usar_imagen.jpg');
    $('#imgmas4').attr('src','../assets/img/usar_imagen.jpg');
    $('#imgmas5').attr('src','../assets/img/usar_imagen.jpg');
    $('#imgmas6').attr('src','../assets/img/usar_imagen.jpg');
  }
   
