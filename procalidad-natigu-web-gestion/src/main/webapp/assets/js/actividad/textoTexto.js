/**
 * Mantenimeinto  Texto-Texto
 */
function guardarTextoTexto(){
	
	var p_idEjercicio = $("#idEjercicio").val();
	var p_texto	= $("#textoTexto").val();
	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#idRelacionTextoTexto").val();
	var p_idMaterial	= $("#modalCboMaterial").val();
	var p_idRelacionCabecera = $("#idRelacionCabecera").val();
	var p_textoRelacion2 = $("#textoRelacionado2").val();

	var url = contextPath+"/cargaMaterialController/grabarTextoTexto";
	if(p_idMaterial != "0")
	{
		iniciarBloqueo();
		$.ajax({
  			type 	: "POST",
  			data 	: {idEjercicio     :p_idEjercicio,
  					   texto	       : p_texto,
  					   textoRelacionado:p_textoRelacionado,
  					   idTextoTexto:p_idTextoTexto,
  					   idRelacionCabecera:p_idRelacionCabecera,
  					   textoRelacion2:p_textoRelacion2},
  			url 	: url,
  			success : function(data)
  			{
  				finBloqueo();
  				if (data != "0") {
  	  				$("#idRelacionTextoTexto").val(data);  
					listarEjercicioTextoTexto();
  	  				msg_exito();
  	  				$("#btn_guardar_texto").attr("disabled",false);
  	  				$("#idRelacionCabecera").val("0");
		  	  		$("#idRelacionTextoTexto").val("0");
		  	  		$("#textoRelacionado").val("").attr("disabled",false);
		  	  		$("#textoTexto").val("").attr("disabled",false);
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
function guardarTextoTextoTexto(){	
	var p_idEjercicio = $("#idEjercicio").val();
	var p_texto	= $("#textoTexto").val();
	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#idRelacionTextoTexto").val();
	var p_idMaterial	= $("#modalCboMaterial").val();
	var p_idRelacionCabecera = $("#idRelacionCabecera").val();
	var p_textoRelacion2 = $("#textoRelacionado2").val();
	
	var url = contextPath+"/cargaMaterialController/grabarTextoTexto";
	if(p_idMaterial != "0")
	{
		iniciarBloqueo();
		$.ajax({
  			type 	: "POST",
  			data 	: {idEjercicio     :p_idEjercicio,
  					   texto	       : p_texto,
  					   textoRelacionado:p_textoRelacionado,
  					   idTextoTexto:p_idTextoTexto,
  					   idRelacionCabecera:p_idRelacionCabecera,
  					   textoRelacion2:p_textoRelacion2},
  			url 	: url,
  			success : function(data)
  			{
  				finBloqueo();
  				if (data != "0") {
  	  				$("#idRelacionTextoTexto").val(data);  
  	  				listarEjercicioTextoTextoTexto();
  	  				msg_exito();
  	  				nuevoTextoTextoTexto();
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
function listarEjercicioTextoTexto()
{	

	var p_idEjercicio = $("#idEjercicio").val();
	
	var url = contextPath+"/cargaMaterialController/listarTextoTexto";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio },
		url : url,
		success : function(data) 
		{
			//console.log("SUCCESS: ", data);
			if (data != null && data.length > 0) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+customScapeHtml(data[i].texto)+"</td><td>"+customScapeHtml(data[i].texto2)+"</td> <td> <button type='button' title='Modificar' onclick='editarTextoTexto(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar(\""+'textoTexto'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("bodyListeTextoTexto").innerHTML=html;
			}else{
				//console.log("lista null");
				//document.getElementById("bodyListeTextoTexto").innerHTML="<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>";
				html="<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>";
			}
			$("#bodyListeTextoTexto").html(html);
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function editarTextoTexto(p_id){
	
	var url =contextPath+"/cargaMaterialController/objrelaciontexto?codigo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		    $("#idRelacionCabecera").val(data.relacionCabeceraBean.codigo);
        			$("#textoTexto").val(data.texto).attr("disabled",false);
        			$("#textoRelacionado").val(data.texto2).attr("disabled",false);
        			$("#idRelacionTextoTexto").val(data.codigo);
        			$("#textoRelacionado2").val(data.texto3);
        			$("#btn_guardar_texto").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
	
	
}

var accion_tab = "";
var codigoEliminar="";
function confirmar_accion() {
	
	$('#md_confirmacion').modal('show');
}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}
$("#btnConfirmarGeneric").click(function() {
	//console.log("acción: "+ accion_tab);
	if (accion_tab.indexOf("textoTextoImagen") >= 0) {
		eliminarTextoTextoImagen();
		accion_tab="";
	}
	if (accion_tab.indexOf("identificarTexto") >= 0) {
		eliminarIdentificarTexto();
		accion_tab="";
	}
	if (accion_tab.indexOf("armarDocumentoCab") >= 0) {
		eliminarArmarDocumentoCab();
		accion_tab="";
	}
	if (accion_tab.indexOf("armarDetDocumento") >= 0) {
		eliminarArmarDocumento();
		accion_tab="";
	}
	if (accion_tab.indexOf("textoTexto") >= 0) {
		eliminarTextoTexto();
		accion_tab="";
	}
	if (accion_tab.indexOf("relacion") >= 0) {
		eliminarTextoTextoTexto();
		accion_tab="";
	}
	

});
function confirmar_eliminar(tabla, codigo){
	//console.log("entro a coonfirmar eliminar");
	
	//console.log("tabla " +tabla);
	accion_tab = tabla;
	codigoEliminar = codigo;
	$('#md_confirmacion').modal('show');

}
function eliminarTextoTexto() {
	//console.log("codigoEliminars" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarTextoTexto?codigo="+codigoEliminar
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data) {
			//console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			codigoEliminar = "";
			listarEjercicioTextoTexto();
			msg_exito();

		},
		error : function(msg) {
			//console.log("errot:" + msg);
		}

	});
}
function eliminarTextoTextoTexto() {
	//console.log("codigoEliminara" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarTextoTexto?codigo="+codigoEliminar
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data) {
			//console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			codigoEliminar = "";
			listarEjercicioTextoTextoTexto();
			msg_exito();

		},
		error : function(msg) {
			//console.log("errot:" + msg);
		}

	});
}

function eliminarTextoTextoImagen() {
	//console.log("codigoEliminarx" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarTextoTexto?codigo="+codigoEliminar
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data) {
			//console.log("Se eliminó tti con éxito");
			$('#md_confirmacion').modal('hide');
			codigoEliminar = "";
			nuevoTextoTextoImagen();
			listarEjercicioTextoTextoImagen();
			msg_exito();

		},
		error : function(msg) {
			//console.log("errot:" + msg);
		}

	});
}

function listarEjercicioTextoTextoTexto()
{	

	var p_idEjercicio = $("#idEjercicio").val();
	
	var url = contextPath+"/cargaMaterialController/listarTextoTexto";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio },
		url : url,
		success : function(data) 
		{
			var html = "";
			//console.log("SUCCESS: ", data);
			if (data != null && data.length > 0) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+customScapeHtml(data[i].texto)+"</td><td>"+customScapeHtml(data[i].texto2)+"</td> <td>"+customScapeHtml(data[i].texto3)+"</td> <td> <button type='button' title='Modificar' onclick='editarTextoTexto(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar(\""+'relacion'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("bodyListeTextoTextoTexto").innerHTML=html;
			}else{
				html = "<tr><td colspan='5'><center>Sin registros para mostrar</center></td></tr>";
				//console.log("lista null");
			}
			$("#bodyListeTextoTextoTexto").html(html);
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function validarTextoTexto(){
	
	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#textoTexto").val();
	
	if (p_textoRelacionado != "" && p_idTextoTexto != "") {
		guardarTextoTexto();
	}else{
		msg_advertencia("Debe ingresar un texto.");
	}
	
}

function validarTextoTextoTexto(){

	var p_textoRelacionado = $("#textoRelacionado").val();
	var p_idTextoTexto = $("#textoTexto").val();
	var p_textoTexto = $("#textoRelacionado2").val();
	
	if (p_textoRelacionado != "" && p_idTextoTexto != "" && p_textoTexto != "") {
		guardarTextoTextoTexto();
	}else{
		msg_advertencia("Debe ingresar un texto.");
	}
	
}
function nuevoTexto(){
	$("#idRelacionCabecera").val("0");
	$("#idRelacionTextoTexto").val("0");
	$("#textoRelacionado").val("").attr("disabled",false);
	$("#textoTexto").val("").attr("disabled",false);
	$("#btn_guardar_texto").attr("disabled",false);

}

$(document).ready(function(){
	$("#base-tab42").click(function(){
		var liCodEjer = $("#idEjercicio").val();
		if((liCodEjer=="0" || liCodEjer=="" )){
			msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
			$("#base-tab41").click();
			return false;
		}
		
	});
});

function nuevoTextoParrafo(){
	$("#idRelacionCabecera").val("0");
	$("#idRelacionTextoTexto").val("0");
	$("#bodyParrafo .note-editable").html("").attr("disabled",false);
	$("#textoTexto").val("").attr("disabled",false);
	$("#btn_guardar_texto").attr("disabled",false);
}


function validarTextoParrafo(){
	
	var p_textoRelacionado = $("#bodyParrafo .note-editable").text();
	var p_idTextoTexto = $("#textoTexto").val();
	
	if (p_textoRelacionado != "" && p_idTextoTexto != "") {
		guardarTextoParrafo();
	}else{
		msg_advertencia("Debe ingresar un texto.");
	}
	
}

function guardarTextoParrafo(){
	
	var p_idEjercicio = $("#idEjercicio").val();
	var p_texto	= $("#textoTexto").val();
	var p_textoRelacionado = $("#bodyParrafo .note-editable").html();
	var p_idTextoTexto = $("#idRelacionTextoTexto").val();
	var p_idMaterial	= $("#modalCboMaterial").val();
	var p_idRelacionCabecera = $("#idRelacionCabecera").val();
	var p_textoRelacion2 = $("#textoRelacionado2").val();

	var url = contextPath+"/cargaMaterialController/grabarTextoParrafo";
	if(p_idMaterial != "0")
	{
		$.ajax({
  			type 	: "POST",
  			data 	: {idEjercicio     :p_idEjercicio,
  					   texto	       : p_texto,
  					   textoRelacionado:p_textoRelacionado,
  					   idTextoTexto:p_idTextoTexto,
  					   idRelacionCabecera:p_idRelacionCabecera,
  					   textoRelacion2:p_textoRelacion2},
  			url 	: url,
  			success : function(data)
  			{
  				if (data != "0") {
  	  				$("#idRelacionTextoTexto").val(data);  
  	  				listarEjercicioTextoParrafo();
  	  				msg_exito();
  	  				$("#btn_guardar_texto").attr("disabled",false);
  	  				$("#idRelacionCabecera").val("0");
		  	  		$("#idRelacionTextoTexto").val("0");
		  	  		$("#bodyParrafo .note-editable").html("").attr("disabled",false);
		  	  		$("#textoTexto").val("").attr("disabled",false);
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

function nuevoTextoTextoTexto(){
	$("#idRelacionCabecera").val("0");
	$("#idRelacionTextoTexto").val("0");
	$("#textoRelacionado").val("");
	$("#textoRelacionado2").val("");
	$("#textoTexto").val("");
}

function nuevoArmarDocsCabecera(){
	$("#idRelacionCabecera").val("0");
	$("#idRelacionRelacionarTexto").val("0");
	$("#cbTipoDoc").val("0");
	$("#txtTitulo").val("");
	nuevoArmarDocumento();
	//$("#bodyListArmarTextoDet").empty();
	$("#bodyListArmarTextoDet").html("<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>");
}

function nuevoArmarDocumento(){
	$("#idRelacionRelacionarTexto").val("0");
	if($("#idRelacionCabecera").val()=="0"){
		$("#txtTraduccion").val("").attr("disabled",true);
		$("#cbParteDoc").val("0").attr("disabled",true);
		$("#bodyParrafo .note-editable").html("").attr("disabled",true);
		$("#btn_nuevo_texto").attr("disabled",true);
		$("#btnGuardarArmarDoc").attr("disabled",true);
	} else{
		$("#txtTraduccion").val("").attr("disabled",false);
		$("#cbParteDoc").val("0").attr("disabled",false);
		$("#bodyParrafo .note-editable").html("").attr("disabled",false);
		$("#btn_nuevo_texto").attr("disabled",false);
		$("#btnGuardarArmarDoc").attr("disabled",false);
	}
}

function validarArmarDocsCabecera(){

	var liTipDocu = $("#cbTipoDoc").val();
	var lsCabTitu = $("#txtTitulo").val();
	if (liTipDocu != "0" && lsCabTitu!="") {
		return true;
	}else{
		return false;//msg_advertencia("Debe completar los campos.");
	}
	
}

function validarArmarDocumento(){

	var lsPartDoc = $("#cbParteDoc").val();
	var lsTraducc = $("#txtTraduccion").val();
	var lsCuerpos = $("#bodyParrafo .note-editable").text();
	if (lsPartDoc != "0" && lsTraducc!="" && lsCuerpos!="" ) {
		//console.log("true");
		return true;
	}else{
		//console.log("false");
		return false;//msg_advertencia("Debe completar los campos.");
	}
	
}

function validarIdentificarTexto(){

	var liTipDocu = $("#cbTipoDoc").val();
	var liParDocu = $("#cbParteDoc").val();
	var lsDesDocu = $("#txtCuerpo").val();
	if (liTipDocu != "" && liParDocu != "" && lsDesDocu!="") {
		return true;
	}else{
		return false;//msg_advertencia("Debe completar los campos.");
	}
	
}

function guardarIdentificarTexto(){	
	var liCodEjer = $("#idEjercicio").val();
	var liCodCabe = $("#idRelacionCabecera").val();
	var liDetArma = $("#idRelacionRelacionarTexto").val();
	var liTipDocu = $("#cbTipoDoc").val();
	var liParDocu = $("#cbParteDoc").val();
	var lsDesDocu = $("#txtCuerpo").val();
	var liTipoMat = $("#modalCboMaterial").val();
	var url = contextPath+"/cargaMaterialController/grabarArmarDocumento";
	var liTipoSQL =  liDetArma == 0 ? 1 : 2;
	if(liTipoMat != "0"){
		//console.log("s:" + validarIdentificarTexto());
		if(validarIdentificarTexto()){
			$.ajax({
	  			type 	: "POST",
	  			data 	: {liTipoSQL:liTipoSQL,
	  					   liCodEjer:liCodEjer,
	  					   liDetArma:liDetArma,
	  					   liCodCabe:liCodCabe,
	  					   liTipDocu:liTipDocu,
	  					   liParDocu:liParDocu,
	  					   lsDesDocu:lsDesDocu},
	  			url 	: url,
	  			success : function(data){
	  				if (data != "0") {
	  	  				$("#idRelacionRelacionarTexto").val(data);  
	  	  				listarArmarDocs();
	  	  				msg_exito();
	  	  				nuevoIdentificarTexto();
					}
	  				else{
					}
	  			},
	  			error : function(){
	  				//console.log("ERROR: ");
	  			}
	  		});
		}else{
			//console.log("no entró");
			msg_advertencia("Debe completar los campos.");
		}
	}else{
		msg_advertencia("Debe seleccionar un Material.");
	}
}

function guardarArmarDocsCabecera(){	
	var liCodEjer = $("#idEjercicio").val();
	var liCodCabe = $("#idRelacionCabecera").val();
	var liTipDocu = $("#cbTipoDoc").val();
	var lsCabTitu = $("#txtTitulo").val();
	var liTipoMat = $("#modalCboMaterial").val();
	var url = contextPath+"/cargaMaterialController/grabarArmarDocumentoCab";
	var liTipoSQL =  liCodCabe == 0 ? 1 : 2;
	if(liTipoMat != "0"){
		if(validarArmarDocsCabecera()){
			$.ajax({
	  			type 	: "POST",
	  			data 	: {liTipoSQL:liTipoSQL,
	  					   liCodEjer:liCodEjer,
	  					   liCodCabe:liCodCabe,
	  					   lsCabTitu:lsCabTitu,
	  					   liTipDocu:liTipDocu},
	  			url 	: url,
	  			success : function(data){
	  				if (data != "0") {
	  	  				$("#idRelacionCabecera").val(data);  
	  	  				listarArmarDocsCabecera();
	  	  				msg_exito();
	  	  				//nuevoArmarDocsCabecera();
					}
	  				else{
					}
	  			},
	  			error : function(){
	  				//console.log("ERROR: ");
	  			}
	  		});
		}else{
			//console.log("no entró");
			msg_advertencia("Debe completar los campos.");
		}
	}else{
		msg_advertencia("Debe seleccionar un Material.");
	}
}

function guardarArmarDocumento(){	
	var liCodEjer = $("#idEjercicio").val();
	var liCodCabe = $("#idRelacionCabecera").val();
	var liCodDeta = $("#idRelacionRelacionarTexto").val();
	var liParDocu = $("#cbParteDoc").val();
	var lsTraducc = $("#txtTraduccion").val();
	var lsCuerpos = $("#bodyParrafo .note-editable").html();
	var liTipoMat = $("#modalCboMaterial").val();
	var url = contextPath+"/cargaMaterialController/grabarArmarDocumento";
	var liTipoSQL =  liCodDeta == 0 ? 1 : 2;
	if(liTipoMat != "0"){
		if(liCodCabe!="0"){
			if(validarArmarDocumento()){
				$.ajax({
		  			type 	: "POST",
		  			data 	: { liTipoSQL:liTipoSQL,
		  						liCodCabe:liCodCabe,
		  						liCodDeta:liCodDeta,
		  						liParDocu:liParDocu,
		  						lsTraducc:lsTraducc,
		  						lsCuerpos:lsCuerpos},
		  			url 	: url,
		  			success : function(data){
		  				if (data != "0") {
		  	  				$("#idRelacionRelacionarTexto").val(data);  
		  	  				listarArmarDocs();
		  	  				msg_exito();
		  	  				nuevoArmarDocumento();
						}
		  				else{
						}
		  			},
		  			error : function(){
		  				//console.log("ERROR: ");
		  			}
		  		});
			}else{
				//console.log("no entró");
				msg_advertencia("Debe completar los campos.");
			}
		}else{
			msg_advertencia("Debe seleccionar una cabecera.");
		}
	}else{
		msg_advertencia("Debe seleccionar un Material.");
	}
}

function listarArmarDocsCabecera(){	
	var liCodEjer = $("#idEjercicio").val();
	var url = contextPath+"/cargaMaterialController/listarArmarDocsCabecera";
	$.ajax({
		type : 'get',
		data :{p_codmatpej : liCodEjer },
		url : url,
		success : function(data) {
			var html = "";
			if (data != null && data.length > 0) {
				for (var i = 0; i < data.length; i++) {
					//console.log("SUCCESS: ", data[i].maestraTipoDoc.nombreLargo);
					//console.log("SUCCESS: ", data[i].titulo);
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].titulo+"</td><td>"+data[i].maestraTipoDoc.nombreLargo+"</td><td> <button type='button' title='Modificar' onclick='editarArmarDocCabecera(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar(\""+'armarDocumentoCab'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("bodyListArmarTextoCab").innerHTML=html;
			}else{
				html = "<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>";
				//$("#bodyListArmarTextoCab").empty();
			}
			$("#bodyListArmarTextoCab").html(html);
		},
		error : function(data) {
			//console.log("error de listarArmarDocsCabecera :" +data);
		}
	});
}
function listarArmarDocs(){	
	var liCodCabe = $("#idRelacionCabecera").val();
	var url = contextPath+"/cargaMaterialController/listarArmarDocs";
	$.ajax({
		type : 'get',
		data :{liCodCabe : liCodCabe },
		url : url,
		success : function(data) {
			var html = "";
			//console.log("SUCCESS: ", data);
			if (data != null && data.length > 0) {
				for (var i = 0; i < data.length; i++) {
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].armarDocumentoCabBean.maestraTipoDoc.nombreCorto+"</td><td>"+data[i].traduccionParteDoc+"</td><td> <button type='button' title='Modificar' onclick='editarArmarDocumento(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar(\""+'armarDetDocumento'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("bodyListArmarTextoDet").innerHTML=html;
			}else{
				html = "<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>";
				//$("#bodyListArmarTextoDet").empty();
			}
			//console.log("html");
			//console.log(html);
			$("#bodyListArmarTextoDet").html(html);
		},
		error : function(data) {
			//console.log("error de listarArmarDocs :" + data);
		}
	});
}


function editarArmarDocCabecera(liCodCabe){
	var url =contextPath+"/cargaMaterialController/editarArmarDocCabecera?liCodCabe="+liCodCabe
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		  	$("#idRelacionCabecera").val(data.codigo);
        			$("#cbTipoDoc").val(data.tipoDocumento);
        			$("#txtTitulo").val(data.titulo);
        			$("#btn_guardar_texto").attr("disabled",false);
        			nuevoArmarDocumento();
        			listarArmarDocs();
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          msg_advertencia(error);
        }
       });
}

function editarArmarDocumento(liCodDeta){
	var url =contextPath+"/cargaMaterialController/editarArmarDocumento?liCodDeta="+liCodDeta
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		  	//console.log("tdoc:" + data.parteDocumento);
        		  	$("#idRelacionRelacionarTexto").val(data.codigo);
        			$("#cbParteDoc").val(data.parteDocumento);
        			$("#txtTraduccion").val(data.traduccionParteDoc);
        			$("#bodyParrafo .note-editable").html(data.descripcion);
        			$("#btn_guardar_texto").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          msg_advertencia(error);
        }
       });
}


function editarIdentificarTexto(liCodTxtR){
	var url =contextPath+"/cargaMaterialController/objrelaciontexto?codigo="+liCodTxtR
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		    $("#idRelacionCabecera").val(data.relacionCabeceraBean.codigo);
        			$("#txtTitulo").val(data.palabra).attr("disabled",false);
        			$("#txtSubTitulo").val(data.texto).attr("disabled",false);
        			$("#txtCuerpo").val(data.texto2).attr("disabled",false);
        			$("#txtPie").val(data.texto3).attr("disabled",false);
        			$("#idRelacionRelacionarTexto").val(data.codigo);
        			$("#btn_guardar_texto").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          msg_advertencia(error);
        }
       });
}

function eliminarArmarDocumentoCab() {
	//console.log("codigoEliminarx" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarArmarDocumentoCab";
	$.ajax({
		url : url,
		type : 'POST',
		data: {liCodCabe:codigoEliminar},
		success : function(data) {
			//console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			if(codigoEliminar ==$("#idRelacionCabecera").val()){
				nuevoArmarDocsCabecera();
				//$("#bodyListArmarTextoDet").empty();
				$("#bodyListArmarTextoDet").html("<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>");
			}
			codigoEliminar = "";
			listarArmarDocsCabecera();
			msg_exito();

		},error : function(msg) {
			//console.log("errot:" + msg);
		}
	});
}

function eliminarArmarDocumento() {
	//console.log("codigoEliminarx" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarArmarDocumento";
	$.ajax({
		url : url,
		type : 'POST',
		data: {liCodDeta:codigoEliminar},
		success : function(data) {
			//console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			if(codigoEliminar ==$("#idRelacionRelacionarTexto").val()){
				nuevoArmarDocumento();
				//$("#bodyListArmarTextoDet").empty();
				$("#bodyListArmarTextoDet").html("<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>");
			}
			codigoEliminar = "";
			listarArmarDocs();
			msg_exito();

		},error : function(msg) {
			//console.log("errot:" + msg);
		}
	});
}

function listarTipoDocs(){	
	var liCodEjer = $("#idEjercicio").val();
	var url = contextPath+"/cargaMaterialController/listarTipoDocs";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : liCodEjer },
		url : url,
		success : function(data) {
			//console.log("SUCCESS: ", data);
			if (data != null) {
				for (var i = 0; i < data.length; i++) {
					 $('#cbTipoDoc').append($('<option>', { 
					        value: data[i].id,
					        text : data[i].nombreLargo
					    }));
				}
			}else{
				 $('#cbTipoDoc').append($('<option>', { 
				        value: '0',
				        text : 'Seleccione'
				    }));
			}
		},
		error : function(data) {
			//console.log("error de listarTipoDocs :" + data.error);
		}
	});
}

function listarParteDocs(){	
	var liCodEjer = $("#idEjercicio").val();
	var url = contextPath+"/cargaMaterialController/listarParteDocs";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : liCodEjer },
		url : url,
		success : function(data) {
			//console.log("SUCCESS: ", data);
			if (data != null) {
				for (var i = 0; i < data.length; i++) {
					 $('#cbParteDoc').append($('<option>', { 
					        value: data[i].id,
					        text : data[i].nombreCorto
					    }));
				}
			}else{
				 $('#cbParteDoc').append($('<option>', { 
				        value: '0',
				        text : 'Seleccione'
				    }));
			}
		},
		error : function(data) {
			//console.log("error de listarParteDocs :" + data+ error);
		}
	});
}

function listarEjercicioDocs(){
	listarTipoDocs();
	listarParteDocs();
	listarArmarDocsCabecera();
	nuevoArmarDocsCabecera();
}

function listarEjercicioTextoParrafo(){	

	var p_idEjercicio = $("#idEjercicio").val();
	var url = contextPath+"/cargaMaterialController/listarTextoParrafo";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio },
		url : url,
		success : function(data) 
		{
			//console.log("SUCCESS: ", data);
			if (data != null && data.length > 0) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+customScapeHtml(data[i].texto)+"</td><td>"+data[i].parrafo+"</td> <td> <button type='button' title='Modificar' onclick='editarTextoParrafo(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar(\""+'textoTexto'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("bodyListeTextoTexto").innerHTML=html;
			}else{
				html = "<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>";
				//$("#bodyListeTextoTexto").empty();
			}
			$("#bodyListeTextoTexto").html(html);
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}
function editarTextoParrafo(p_id){
	
	var url =contextPath+"/cargaMaterialController/objrelaciontexto?codigo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		    $("#idRelacionCabecera").val(data.relacionCabeceraBean.codigo);
        			$("#textoTexto").val(data.texto).attr("disabled",false);
        			$("#bodyParrafo .note-editable").html(data.parrafo).attr("disabled",false);
        			$("#idRelacionTextoTexto").val(data.codigo);
        			$("#textoRelacionado2").val(data.texto3);
        			$("#btn_guardar_texto").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
}

function customScapeHtml(str) {
     return str.replace(/[&<>"']/g, function(m) {
		    
		    switch (m) {
		      case '&':
		        return '%;';
		      case '<':
		        return '%;';
		      case '>':
		        return '%;';
		      case '"':
		        return '%;';
		      default:
		        return '%;';
		    }
		  }).replace(/prompt/gi, "&#js;")
		    .replace(/href/gi, "&#ht;")
		    .replace(/javascript/gi, "&#js;")
			.replace(/inser into/gi, "&#js;")
		    .replace(/onerror/gi, "&#js;");
}
