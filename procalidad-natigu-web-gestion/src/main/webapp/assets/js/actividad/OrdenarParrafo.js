/**
 * Mantenimiento de ejercicio Ordenar  parrafo.
 */

var contextPath = $('#contextPathUrl').val();
function grabarOrdenarParrafoCabecera(){
	var p_idEjercicio = $("#idEjercicio").val();
	var p_idMaterial	= $("#modalCboMaterial").val();
	var p_tituloCabecera = $("#tituloActividad").val();
	var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
	var p_comentarioParrafo = $("#comentarioParrafo").val();
	var url = contextPath+"/cargaMaterialController/grabarOrdenParrafoCabecera";
	
	if(p_idMaterial != "0")
	{
		iniciarBloqueo();
		$.ajax({
  			type 	: "POST",
  			data 	: { idEjercicio:p_idEjercicio,
  						tituloCabecera : p_tituloCabecera,
  						idOrdenParrafoCabecera:p_idOrdenParrafoCabecera,
  						comentario : p_comentarioParrafo},
  			url 	: url,
  			success : function(data)
  			{
  				finBloqueo();
  				if (data != "0") {
  	  				$("#idOrdenParrafoCabecera").val(data);
  	  				 	  				 	  				  	  				  	  			
  	  				msg_exito();
				}
  				else
  				{
				}
  			},
  			error : function()
  			{
  				//console.log("ERROR: ");
  			}
  		});
	}
	else
	{
		msg_advertencia("Debe seleccionar un Material.");
	}
}

function listarParrafoCabecera()
{	
	document.getElementById("btnGuardarParrafo").disabled = false;
	document.getElementById("btn_nuevo_parrafo").disabled = false;
	var p_idEjercicio = $("#idEjercicio").val();
	
	var url = contextPath+"/cargaMaterialController/listarParrafoCabecera";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio},
		url : url,
		success : function(data) 
		{		//console.log("data : " + data);
			if (data == null || data == "") {  
				
				$("#tituloActividad").val("");
				$("#idOrdenParrafoCabecera").val("0");
				$("#comentarioParrafo").val("");
			}else{
				
				$("#tituloActividad").val(data.titulo);
				$("#idOrdenParrafoCabecera").val(data.codigo);
				$("#comentarioParrafo").val(data.comentario);
				listarParrafo();
			}
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function editarOrdenarParrafoCabecera(p_id){
	document.getElementById("btnTituloParrafoCabecera").disabled = false;
	document.getElementById("btnGuardarParrafo").disabled = false;
	document.getElementById("btn_nuevo_parrafo").disabled = false;
	listarParrafo();
	var url =contextPath+"/cargaMaterialController/objlistarOrdenarParrafoCabecera?codigo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		 
        		$("#tituloActividad").val(data.titulo).attr("disabled",false);
      			$("#idOrdenParrafoCabecera").val(data.codigo);
      			$("#btnTituloParrafoCabecera").attr("disabled",false);
      			$("#bodyParrafo .note-editable").html("").attr("disabled",false);
      			$("#numeroOrdenParrafo").val("").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
	
	
}

function guardarParrafo(){
	
	var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
	var p_numeroOrden = $("#numeroOrdenParrafo").val();
	var p_parrafo = $("#bodyParrafo .note-editable").html();
	var p_idParrafo = $("#idOrdenarParrafo").val();
	var url = contextPath+"/cargaMaterialController/grabarParrafo";
	iniciarBloqueo();
		$.ajax({
  			type 	: "POST",
  			data 	: {
  					   idOrdenarParrafoCabecera:p_idOrdenarParrafoCabecera,
  					   numeroOrden:p_numeroOrden,
  					   parrafo:p_parrafo,
  					   idParrafo:p_idParrafo},
  			url 	: url,

  			success : function(data)
  			{
  				finBloqueo();
  				if (data != "0") {
	  	  			$("#idOrdenarParrafo").val(data);
	  	  			listarParrafo();
	  	  			msg_exito();
	  	  		    nuevo_parrafo();
				}else{
					msg_advertencia("Ya existe número de orden.")
				}

  			},
  			error : function()
  			{
  				//console.log("ERROR: ");
  			}
  		});
	
}

function editarParrafo(p_id){
	
	document.getElementById("btnGuardarParrafo").disabled = false;
	var url =contextPath+"/cargaMaterialController/objlistarParrafo?codParrafo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		 
        		$("#numeroOrdenParrafo").val(data.numeroOrden).attr("disabled",false);
        		$("#bodyParrafo .note-editable").html(data.parrafo).attr("disabled",false);
      			$("#idOrdenarParrafo").val(data.codigo).attr("disabled",false);
      			$("#btnGuardarParrafo").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
}
function editarParrafoDoc(p_id){
	
	document.getElementById("btnGuardarParrafo").disabled = false;
	var url =contextPath+"/cargaMaterialController/objlistarParrafoDoc?codParrafo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		 
        		$("#ordennarParrafo").prop("checked",data.ordenar).attr("disabled",false);
      			$("#bodyParrafo .note-editable").html(data.parrafo).attr("disabled",false);
      			$("#idOrdenarParrafo").val(data.codigo).attr("disabled",false);
      			$("#btnGuardarParrafo").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
}

function editarParrafoArras(p_id){
	
	document.getElementById("btnGuardarParrafo").disabled = false;
	var url =contextPath+"/cargaMaterialController/objlistarParrafoDoc?codParrafo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
      			$("#parrafo").val(data.parrafo).attr("disabled",false);
      			$("#idOrdenarParrafo").val(data.codigo).attr("disabled",false);
      			$("#btnGuardarParrafo").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
}

function listarParrafo()
{
	var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();	
	var url = contextPath+"/cargaMaterialController/listarParrafo";
	
	$.ajax({
		type : 'POST',
		data :{idOrdenarParrafoCabecera : p_idOrdenarParrafoCabecera},
		url : url,
		success : function(data) 
		{
			var html = "";
			//console.log("SUCCESS: ", data);
			if (data != null && data.length > 0) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr id='trParrafDoc"+data[i].codigo+"'> <td>"+(i+1)+"</td><td>"+data[i].parrafo+"</td> <td> <button type='button' title='Modificar' onclick='editarParrafo(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar_Parrafo(\""+'parrafo'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
			}else{
				//console.log("lista null");
				html="<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</centrer></td></tr>";
			
			}
			$("#idBodyListadoParrafo").html(html);
			sortableParrafoDoc();
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}

 function eliminarmatej(codigo){
        //  alert("eliminarLengua " + codigo);
	        $.ajax({
	          url : contextPath +"/cargaMaterialController/eliminarMaterialTipoEjercicio?p_codmatpej="+codigo,
	          type : 'GET',
	          success : function(data) {
	        	  $('#md_confirmacion').modal('hide');
	        	  listarMaterialTipoEjercicio();
	        	  msg_exito();
	          },
	          error : function(request, status, error) {
	            //alert(error);
	          }
	         });
  };
    var accion_tab = "";
    var codigoEliminar="";
	function confirmar_accion() {
		
		$('#md_confirmacion').modal('show');
	}
	function agregar_accion() {
		$('#md_reg_confirmacion').modal('show');
	}
	$("#btnConfirmarGeneric").click(function() {
		//console.log("tab:" + accion_tab);
		if (accion_tab.indexOf("Arrasparrafo") >= 0) {
			eliminarParrafoArras();
			accion_tab="";
		}
		if (accion_tab.indexOf("Docparrafo") >= 0) {
			eliminarParrafoDoc();
			accion_tab="";
		}
		if (accion_tab.indexOf("parrafo") >= 0) {
			eliminarParrafo();
			accion_tab="";
		}
		if(accion_tab.indexOf("cabecera") >= 0){
			eliminarParrafoCabecera(codigoEliminar);
			accion_tab="";
		}
	});
	function confirmar_eliminar_Parrafo(tabla, codigo){
//		//console.log("entro a coonfirmar eliminar");
		
		//console.log("tabla " +tabla);
		accion_tab = tabla;
		codigoEliminar = codigo;
		$('#md_confirmacion').modal('show');
//		alert(accion_tab);
	}
	function eliminarParrafo() {
		//console.log("codigoEliminar" + codigoEliminar);
		var url = contextPath+"/cargaMaterialController/eliminarParrafo?codigo="+codigoEliminar
		$.ajax({
			url : url,
			type : 'GET',
			success : function(data) {
				//console.log("Se eliminó con éxito");
				$('#md_confirmacion').modal('hide');
				codigoEliminar = "";
				msg_exito();
				listarParrafo();
				

			},
			error : function(msg) {
				//console.log("errot:" + msg);
			}

		});
	}
	function eliminarParrafoCabecera(id) {
		//console.log("codigoEliminar" + codigoEliminar);
		var url = contextPath+"/cargaMaterialController/eliminarParrafoCabecera?codigo="+id
		$.ajax({
			url : url,
			type : 'GET',
			success : function(data) {
				//console.log("Se eliminó con éxito");
				$('#md_confirmacion').modal('hide');
				codigoEliminar = "";
				listarParrafoCabecera();
				msg_exito();

			},
			error : function(msg) {
				//console.log("errot:" + msg);
			}

		});
	}
	
	function nuevo_TituloCabecera(){
		document.getElementById("btnTituloParrafoCabecera").disabled = false;
		$("#tituloActividad").val("").attr("disabled",false);
		$("#idOrdenParrafoCabecera").val("0");
		$("#btnTituloParrafoCabecera").attr("disabled",false);
	}
	function nuevo_parrafo(){
		document.getElementById("btnGuardarParrafo").disabled = false;
		$("#numeroOrdenParrafo").val("").attr("disabled",false);
		$("#bodyParrafo .note-editable").html("").attr("disabled",false);
		$("#idOrdenarParrafo").val("0");
		$("#btnGuardarParrafo").attr("disabled",false);
	}
	
	function validarParrafoCabecera(){
		var p_tituloCabecera = $("#tituloActividad").val();
		var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
//		if (p_tituloCabecera != "") {
			grabarOrdenarParrafoCabecera();
//		}else{
//			msg_advertencia("Ingrese un titulo de actividad.");
//		}
	}
	function validarParrafo(){
		var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
		var p_numeroOrden = $("#numeroOrdenParrafo").val();
		var p_parrafo = $("#bodyParrafo .note-editable").text();
		if (p_idOrdenarParrafoCabecera != "0") {
			if (p_numeroOrden != "" && p_parrafo != "") {
				guardarParrafo();
			}else{
				msg_advertencia("Complete datos requeridos.");
			}
		}else{
			msg_advertencia("Ingrese un titulo de actividad.");
		}
	}
	function eliminarParrafoDoc() {
		//console.log("codigoEliminar" + codigoEliminar);
		var url = contextPath+"/cargaMaterialController/eliminarParrafo?codigo="+codigoEliminar
		$.ajax({
			url : url,
			type : 'GET',
			success : function(data) {
				//console.log("Se eliminó con éxito");
				$('#md_confirmacion').modal('hide');
				codigoEliminar = "";
				msg_exito();
  	  			listarParrafoDoc();
				

			},
			error : function(msg) {
				//console.log("errot:" + msg);
			}

		});
	}
	function eliminarParrafoArras() {
		//console.log("codigoEliminar" + codigoEliminar);
		var url = contextPath+"/cargaMaterialController/eliminarParrafo?codigo="+codigoEliminar
		$.ajax({
			url : url,
			type : 'GET',
			success : function(data) {
				//console.log("Se eliminó con éxito");
				$('#md_confirmacion').modal('hide');
				codigoEliminar = "";
				msg_exito();
				listarParrafoArras();
				

			},
			error : function(msg) {
				//console.log("errot:" + msg);
			}

		});
	}
	function limpiar(){
		$("#idOrdenParrafoCabecera").val("0");
		$("#tituloActividad").val("");
		$("#comentarioParrafo").val("");
		listarParrafo();
	}
	
	function limpiarDocCab(){
		$("#idOrdenParrafoCabecera").val("0");
		$("#tituloActividad").val("");
		$("#comentarioParrafo").val("");
		limpiarParrafoDoc();
	}
	
	function limpiarArrasCab(){
		$("#idOrdenParrafoCabecera").val("0");
		$("#tituloActividad").val("");
		$("#comentarioParrafo").val("");
		limpiarParrafoArras();
	}
	function limpiarParrafoDoc(){
		$("#ordennarParrafo").prop("checked",false);
		$("#bodyParrafo .note-editable").html("");
		$("#idOrdenarParrafo").val("0");
		//$("#idBodyListadoParrafo").empty();		
		//document.getElementById("idBodyListadoParrafo").innerHTML="<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</centrer></td></tr>";
		$("#idBodyListadoParrafo").html("<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</centrer></td></tr>");
	}
	
	function limpiarParrafoArras(){
		$("#parrafo").val("");
		$("#idOrdenarParrafo").val("0");
		//$("#idBodyListadoParrafo").empty();
		//document.getElementById("idBodyListadoParrafo").innerHTML="<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</centrer></td></tr>";
		$("#idBodyListadoParrafo").html("<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</centrer></td></tr>");
	}
	
	function actualizarOrdenParrafoDoc(liParrCab,liNewOrde,liParrafo){
		$.ajax({
			type : "POST",
			url : $('#contextPathUrl').val() +"/cargaMaterialController/actualizarOrdenParrafoDoc",
			data : {liParrCab:liParrCab,liNewOrde:liNewOrde,liParrafo:liParrafo},
			success : function(data){
				//console.log("rpta:" + data);
			},
			error : function(){
				//console.log("ERROR: ");
			}
		});

	}
	
	function sortableParrafoDoc(){
		$('.tBodyParrafoDoc').sortable({
			start: function(event, ui) {
				ui.item.startPos = ui.item.index();
			},
			update: function(event, ui) {
				$('.tBodyParrafoDoc  > tr').each(function(index) {
					//console.log($(this).attr("id").substr(11)+"-"+index);
					actualizarOrdenParrafoDoc($("#idOrdenParrafoCabecera").val(),index,$(this).attr("id").substr(11));
					$(this).find("td.td").text(index+1);
				});
				//console.log("terminó")
				//buscarLeccionMaterial();
				//return false;
			 }
		});
	}
	
	function guardarParrafoDoc(){
		
		var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
		var p_ordenar = $("#ordennarParrafo").prop("checked");
		//console.log("orde: " + p_ordenar);
		var p_parrafo =$("#bodyParrafo .note-editable").html();
		var p_idParrafo = $("#idOrdenarParrafo").val();
		var url = contextPath+"/cargaMaterialController/grabarParrafoDoc";
		
			$.ajax({
	  			type 	: "POST",
	  			data 	: {
	  					   idOrdenarParrafoCabecera:p_idOrdenarParrafoCabecera,
	  					   ordenar:p_ordenar,
	  					   parrafo:p_parrafo,
	  					   idParrafo:p_idParrafo},
	  			url 	: url,

	  			success : function(data)
	  			{
	  				if (data != "0") {
		  	  			$("#idOrdenarParrafo").val(data);
		  	  			limpiarParrafoDoc();
		  	  			listarParrafoDoc();
		  	  			msg_exito();

					}else{
						msg_advertencia("Ya existe número de orden.")
					}

	  			},
	  			error : function()
	  			{
	  				//console.log("ERROR: ");
	  			}
	  		});
		
	}
	
	function validarParrafoDoc(){
		var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
		var p_parrafo = $("#bodyParrafo .note-editable").text();
		if (p_idOrdenarParrafoCabecera != "0") {
			if (p_parrafo != "") {
				guardarParrafoDoc();
			}else{
				msg_advertencia("Complete datos requeridos.");
			}
		}else{
			msg_advertencia("Ingrese un titulo de actividad.");
		}
	}
	
	function listarParrafoDoc()
	{
		var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();	
		var url = contextPath+"/cargaMaterialController/listarParrafo";
		var html = "";
		$.ajax({
			type : 'POST',
			data :{idOrdenarParrafoCabecera : p_idOrdenarParrafoCabecera},
			url : url,
			success : function(data) 
			{
				//console.log("SUCCESS: ", data);
				if (data != null && data.length > 0) 
				{
					for (var i = 0; i < data.length; i++) 
					{
						html = html+"<tr id='trParrafDoc"+data[i].codigo+"'> <td>"+(i+1)+"</td><td>"+data[i].parrafo+"</td><td class='text-xs-center'>"+(data[i].ordenar== true ? 'Sí' : 'No') +"</td> <td> <button type='button' title='Modificar' onclick='editarParrafoDoc(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar_Parrafo(\""+'Docparrafo'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
					}
				}else{
					//$("#idBodyListadoParrafo").empty();
					html="<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</centrer></td></tr>";
					
				}
				//document.getElementById("idBodyListadoParrafo").innerHTML=html;
				$("#idBodyListadoParrafo").html(html);
				sortableParrafoDoc();
			},
			error : function(data) {
				//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
			}
		});
		
	}
	
	function listarParrafoArras(){
		var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();	
		var url = contextPath+"/cargaMaterialController/listarParrafo";
		var html = "";
		$.ajax({
			type : 'POST',
			data :{idOrdenarParrafoCabecera : p_idOrdenarParrafoCabecera},
			url : url,
			success : function(data) 
			{
				//console.log("SUCCESS: ", data);
				if (data != null) 
				{
					for (var i = 0; i < data.length; i++) {
						//<td>"+data[i].posini+"</td><td>"+data[i].posfin+"</td>
						html = html+"<tr id='trParrafDoc"+data[i].codigo+"'> <td>"+(i+1)+"</td><td>"+data[i].parrafo+"</td> <td> <button type='button' title='Modificar' onclick='editarParrafoArras(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar_Parrafo(\""+'Arrasparrafo'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
					}
				}else{
					//$("#idBodyListadoParrafo").empty();
					html="<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</centrer></td></tr>";
					
				}
				$("#idBodyListadoParrafo").html(html);
				//document.getElementById("idBodyListadoParrafo").innerHTML=html;
				sortableParrafoDoc();
			},
			error : function(data) {
				//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
			}
		});
		
	}
	
	function listarParrafoCabeceraDoc(tipo)
	{	
		document.getElementById("btnGuardarParrafo").disabled = false;
		document.getElementById("btn_nuevo_parrafo").disabled = false;
		var p_idEjercicio = $("#idEjercicio").val();
		
		var url = contextPath+"/cargaMaterialController/listarParrafoCabecera";
		var html = "";
		$.ajax({
			type : 'POST',
			data :{idEjercicio : p_idEjercicio},
			url : url,
			success : function(data) 
			{		//console.log("data : " + data);
				if (data == null || data == "") {  
					
					$("#tituloActividad").val("");
					$("#idOrdenParrafoCabecera").val("0");
					$("#comentarioParrafo").val("");
				}else{
					
					$("#tituloActividad").val(data.titulo);
					$("#idOrdenParrafoCabecera").val(data.codigo);
					if(tipo == 1){
						$("#comentarioParrafo").val(data.comentario);
						listarParrafoDoc();
					} else {
						$("#bodyParrafo .note-editable").html(data.comentario);
						listarParrafoArras();
					}
					
				}
			},
			error : function(data) {
				//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
			}
		});
		
	}
	
	function nuevo_parrafoDoc(){
		document.getElementById("btnGuardarParrafo").disabled = false;
		$("#ordennarParrafo").prop("checked",false);
		$("#bodyParrafo .note-editable").html("").attr("disabled",false);
		$("#idOrdenarParrafo").val("0");
		$("#btnGuardarParrafo").attr("disabled",false);
	}
	
	function nuevo_parrafoArras(){
		document.getElementById("btnGuardarParrafo").disabled = false;
		$("#parrafo").val("").attr("disabled",false);
		$("#idOrdenarParrafo").val("0");
		$("#btnGuardarParrafo").attr("disabled",false);
	}
	
	function validarPalabrasParrafo(){
		var str = $("#bodyParrafo .note-editable").text();
		var lengthPar= parseInt($("#parrafo").val().length);
		var rpta = str.indexOf($("#parrafo").val());
		if(rpta>-1){
			var sumPosIn = parseInt(rpta);
			var sumPosFin = sumPosIn + lengthPar;
		 	//alert("Existe coíncidencia. Posini: " + sumPosIn + "- posfin: " + sumPosFin);
			guardarArrastrarParrafo(sumPosIn,sumPosFin);
		 	//console.log("posfin: " + sumPosFin);
		 	//msg_exito("Las palabras sí coínciden con parte del parrafo.")
		}else{
			msg_advertencia("Las palabras no coínciden con parte del parrafo.");
		}
	}
	
	function validarPalabrasParrafoCabecera(){
		var p_tituloCabecera = $("#tituloActividad").val();
		var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
		if (p_tituloCabecera != "") {
			grabarPalabrasParrafoCabecera();
		}else{
			msg_advertencia("Ingrese un titulo de actividad.");
		}
	}
	
	function grabarPalabrasParrafoCabecera(){
		var p_idEjercicio = $("#idEjercicio").val();
		var p_idMaterial	= $("#modalCboMaterial").val();
		var p_tituloCabecera = $("#tituloActividad").val();
		var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
		var p_comentarioParrafo = $("#bodyParrafo .note-editable").html();
		var url = contextPath+"/cargaMaterialController/grabarOrdenParrafoCabecera";
		
		if(p_idMaterial != "0")
		{
			$.ajax({
	  			type 	: "POST",
	  			data 	: { idEjercicio:p_idEjercicio,
	  						tituloCabecera : p_tituloCabecera,
	  						idOrdenParrafoCabecera:p_idOrdenParrafoCabecera,
	  						comentario : p_comentarioParrafo},
	  			url 	: url,
	  			success : function(data)
	  			{
	  				if (data != "0") {
	  	  				$("#idOrdenParrafoCabecera").val(data);
	  	  				 	  				 	  				  	  				  	  			
	  	  				msg_exito();
					}
	  				else
	  				{
					}
	  			},
	  			error : function()
	  			{
	  				//console.log("ERROR: ");
	  			}
	  		});
		}
		else
		{
			msg_advertencia("Debe seleccionar un Material.");
		}
	}
	
	function guardarPalabrasParrafo(){
		
		var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
		var p_ordenar = $("#ordennarParrafo").prop("checked");
		//console.log("orde: " + p_ordenar);
		var p_parrafo = $("#parrafo").val();
		var p_idParrafo = $("#idOrdenarParrafo").val();
		var url = contextPath+"/cargaMaterialController/grabarParrafoDoc";
		
			$.ajax({
	  			type 	: "POST",
	  			data 	: {
	  					   idOrdenarParrafoCabecera:p_idOrdenarParrafoCabecera,
	  					   ordenar:p_ordenar,
	  					   parrafo:p_parrafo,
	  					   idParrafo:p_idParrafo},
	  			url 	: url,

	  			success : function(data)
	  			{
	  				if (data != "0") {
		  	  			$("#idOrdenarParrafo").val(data);
		  	  			limpiarParrafoDoc();
		  	  			listarParrafoDoc();
		  	  			msg_exito();

					}else{
						msg_advertencia("Ya existe número de orden.")
					}

	  			},
	  			error : function()
	  			{
	  				//console.log("ERROR: ");
	  			}
	  		});
		
	}
	
function guardarArrastrarParrafo(liPosini, liPosFin){
		
		var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
		var p_parrafo = $("#parrafo").val();
		var p_idParrafo = $("#idOrdenarParrafo").val();
		var url = contextPath+"/cargaMaterialController/grabarParrafoArras";
		
			$.ajax({
	  			type 	: "POST",
	  			data 	: {
	  					   idOrdenarParrafoCabecera:p_idOrdenarParrafoCabecera,
	  					   posini:liPosini,
	  					   posfin:liPosFin,
	  					   parrafo:p_parrafo,
	  					   idParrafo:p_idParrafo},
	  			url 	: url,

	  			success : function(data)
	  			{
	  				if (data != "0") {
		  	  			$("#idOrdenarParrafo").val(data);
		  	  			limpiarParrafoArras();
		  	  			listarParrafoArras();
		  	  			msg_exito();

					}else{
						msg_advertencia("Ya existe número de orden.")
					}

	  			},
	  			error : function()
	  			{
	  				//console.log("ERROR: ");
	  			}
	  		});
		
	}
