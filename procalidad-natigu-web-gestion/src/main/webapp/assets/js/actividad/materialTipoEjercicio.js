var contextPath = $('#contextPathUrl').val();

function nuevoMaterialTipoEjercicio()
{
	$("#ejercicioTxtTitulo").removeAttr("disabled");
	$("#ejercicioTxtComprension").removeAttr("disabled");
	//$("#ejercicioTxtExpGramatic").removeAttr("disabled");
	$("#btn_guardar_ejercicio").removeAttr("disabled");
	limpiarMaterialTipoEjercicio();
}
function listarEjercicioTextoTextoImagen(){	
	var liCodEjer = $("#idEjercicio").val();
	var url = contextPath+"/cargaMaterialController/listarTextoTextoImagen";
	$.ajax({
		type : 'POST',
		encoding:"UTF-8",
	    dataType:"json", 
	    contentType: "text/json; charset=UTF-8",
		data :{liCodEjer:liCodEjer},
		url : url,
		success : function(data) {
			var html = "";
			////console.log("SUCCESS: ", data);
			if (data != null && data.length > 0) {
				for (var i = 0; i < data.length; i++) {
					html = html+"<tr><td>"+(i+1)+"</td><td>"+customScapeHtml(data[i].texto)+"</td><td>"+customScapeHtml(data[i].texto2)+"</td><td>"+data[i].imagen+"</td><td> <button type='button' title='Modificar' data-toggle='tooltip' data-original-title='Modificar' data-placement='top' onclick='editarTextoTextoImagen(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' data-toggle='tooltip' data-original-title='Eliminar' data-placement='top' onclick='confirmar_eliminar(\""+'textoTextoImagen'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("bodyListeTextoTexto").innerHTML=html;
				
			}else{
				html = "<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>"
				//console.log("lista null");
			}
			$("#bodyListeTextoTexto").html(html);
		},
		error : function(data) {
			//console.log("error de listarEjercicioTextoImagen :" + data+ error);
		}
	});
	
}
function grabarMaterialTipoEjercicio()
{	
	var p_idMaterial		= $("#modalCboMaterial").val();
	var p_idTipoEjercicio 	= $("#modalIdTipoEjercicio").val();
	var p_tituloEjercicio 	= $("#ejercicioTxtTitulo").val();
	p_tituloEjercicio = (p_tituloEjercicio && p_tituloEjercicio.length>0) ? p_tituloEjercicio.trim() : p_tituloEjercicio;
	var p_idEjercicio 		= $("#idEjercicio").val();
	var p_comprenEjercicio 	= $("#ejercicioTxtComprension").val();
	p_comprenEjercicio = (p_comprenEjercicio && p_comprenEjercicio.length>0) ? p_comprenEjercicio.trim() : p_comprenEjercicio;
	var p_expgramatical = $("#bodyEjercicioTxtExpGramatic .note-editable").html();//$("#ejercicioTxtExpGramatic").val();
	var p_subTitulo = "";
	if (p_idTipoEjercicio == 37 || p_idTipoEjercicio==26) {
		p_subTitulo		= $("#ejercicioTxtSubTitulo").val();
	}else{
		p_subTitulo 		= "";
	}
	var p_flgpregu 		= 0;
	if (p_idTipoEjercicio == 2) {
		if($("#checkTipoPreg").is(':checked')) {
			p_flgpregu = 0;
		} else {
			p_flgpregu = 1;
		}
	}else{
		p_flgpregu 		= 0;
	}
	var url = contextPath+"/cargaMaterialController/grabarMaterialEjercicio";
	if(p_idMaterial != "0")
	{
		if(p_tituloEjercicio != "")
		{
			//$("#btn_guardar_ejercicio").prop('disabled', true);
			$("#btn_nuevo_ejercicio").prop('disabled', true);
			//$("#ejercicioTxtTitulo").prop('disabled', true);
			iniciarBloqueo();
			$.ajax({
	  			type 	: "POST",
	  			data 	: {	idTipoEjercicio:p_idTipoEjercicio,
	  						tituloEjercicio:p_tituloEjercicio,
	  						idMaterial:p_idMaterial,
	  						idEjercicio:p_idEjercicio,
	  						subTitulo:p_subTitulo,
	  						comprension:p_comprenEjercicio,
	  						expgramatical:p_expgramatical,
	  						flgpregu:p_flgpregu
	  					  },
	  			url 	: url,
	  			success : function(data)
	  			{
	  				finBloqueo();
	  				if (data != "0") {
	  					//console.log("dataidEjercicio:" + data);
	  	  				$("#idEjercicio").val(data);
	  	  				listarMaterialTipoEjercicio();
	  	  				$("#btn_nuevo_ejercicio").attr("disabled",false);
	  	  				//$("#btn_guardar_ejercicio").attr("disabled",true);
	  	  				msg_exito();
	  	  				//$("#ejercicioTxtTitulo").val("");
					}
	  				else
	  				{
					}
	  			},
	  			error : function()
	  			{
	  				$("#btn_nuevo_ejercicio").removeAttr("disabled");
	  				$("#ejercicioTxtTitulo").removeAttr("disabled");
	  				$("#ejercicioTxtComprension").removeAttr("disabled");
	  				//$("#ejercicioTxtExpGramatic").removeAttr("disabled");
	  				$("#btn_guardar_ejercicio").removeAttr("disabled");
	  				//console.log("ERROR: ");
	  			}
	  		});
		}
		else
		{
			$("#ejercicioTxtTitulo").focus();
			msg_advertencia("Debe ingresar una indicación.");
		}
	}
	else
	{
		msg_advertencia("Debe seleccionar un material.");
	}
}

function posicionarEnEjercicio(liTipEjer,codmaterial){
	var topx = $(".vertical-scroll #tr_selecc_"+liTipEjer).position();
	$('.visible-scroll').scrollTop(topx.top);
	$("#modalCboMaterial").val(codmaterial);
	$("#idBodyTablaMenus #tr_selecc_"+liTipEjer).trigger('click');
}
function listarMaterialTipoEjercicio()
{ 
	$("#base-tab41").click();
	habilitarWYSIWYG('ejercicioTxtExpGramatic');
	$('.note-editor').addClass('form-control input-sm');
	//$("#idEjercicio").val("0");
	var p_idTipoEjercicio 	= $("#modalIdTipoEjercicio").val();
	var p_idMaterial 		= $("#modalCboMaterial").val();
	var url = contextPath+"/cargaMaterialController/listarMaterialTipoEjercicio";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idTipoEjercicio : p_idTipoEjercicio ,idMaterial : p_idMaterial},
		url : url,
		success : function(data) 
		{
			//console("SUCCESS: ", data);
			if (data != null && data.length>0) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					let titulo = data[i].titulo.split("'");
					titulo = titulo.join("&#039;");
					
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+customScapeHtml(data[i].titulo)+"</td> <td> " +
							"<button type='button' title='Modificar' data-toggle='tooltip' data-original-title='Modificar' data-placement='top' onclick='editarMaterialTipoEjercicio(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> " +
							"<button type='button' title='Eliminar' data-toggle='tooltip' data-original-title='Eliminar' data-placement='top' onclick='confirmar_eliminar(\""+'materialTipoEjercicio'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> " +
							"<button type='button' title='Seleccionar' data-toggle='tooltip' data-original-title='Seleccionar' data-placement='top' onclick='seleccionarTab(\""+data[i].codigo+ "\",\""+titulo+ "\",\""+data[i].comprension+ "\",\""+$(data[i].expresionGramatical)+ "\",\""+data[i].flgPregu+ "\")' data-showp='0' data-id='1' class='btn btn-outline-success btn-sm btn-show' data-toggle='tooltip' data-original-title='Mostrar'><i class='ft-eye'></i></button></td></tr>";
				}
				
			}else{
				html = "<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>"
 				//console.log("lista null");
			}
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		},
		complete: function(){
			if(document.getElementById("idBodyListadoMaterialTipoEjercicio")){
				document.getElementById("idBodyListadoMaterialTipoEjercicio").innerHTML=html;
			}
		}
	});
	evitarEspacios();
	validarActividadEjercicio();
}

function evitarEspacios(){
	//$(window).load(function(){
		$("input,textarea").on("keypress", function(e) {
    	    if (e.which === 32 && !this.value.length)
    	        e.preventDefault();
    	});
	//});
}

function seleccionarTab(idEjercicio,titulo,comprension,expgram,flgPregu) 
{
	$("#idEjercicio").val(idEjercicio);
	$("#ejercicioTxtTitulo").val(titulo);
	$("#ejercicioTxtComprension").val(comprension);
	//$("#ejercicioTxtExpGramatic").val(expgram);
	$("#bodyEjercicioTxtExpGramatic .note-editable").val(expgram);
	document.getElementById('base-tab42').click();
	$("#btn_guardar_ejercicio").prop('disabled', true);
	$("#ejercicioTxtTitulo").prop('disabled', true);
	$("#ejercicioTxtComprension").prop('disabled', true);
	//$("#ejercicioTxtExpGramatic").prop('disabled', true);
	
	//console.log("tipo mat:" +$("#modalIdTipoEjercicio").val());
	if($("#modalIdTipoEjercicio").val()=="2"){
		limpiarPreguntaRptas();
		busarPreguntasMatTEjer();
		habilitarChecksValidar();
		//console.log("llegué al tipo 2");
		if(flgPregu=="1"){
			$("#checkTipoPreg").prop('checked',false);
		}else{
			$("#checkTipoPreg").prop('checked',true);
		}
	}
}
/*
function validarCheckPreguntas(){
	if($("#tab42 #0").parent().parent().next().val()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
			return false;

	};
	if($("#tab42 #1").parent().parent().next().val()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
			return false;
	}
	if($("#tab42 #2").parent().parent().next().val()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
			return false;
	}
	if($("#tab42 #3").parent().parent().next().val()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
			return false;
	} else{
		return true;
	}
}*/
function habilitarChecksValidar(){
	$("#tab42 #0").click(function(){
		if($(this).parent().parent().next().find("note-editable").html()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
		}
		//console.log("val;:" + $(this).parent().parent().next().val());
		//console.log("id:" + $(this).parent().parent().next().attr("id"));
	});
	$("#tab42 #1").click(function(){
		if($(this).parent().parent().next().find("note-editable").html()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
		}
	});
	$("#tab42 #2").click(function(){
		if($(this).parent().parent().next().find("note-editable").html()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
		}
	});
	$("#tab42 #3").click(function(){
		if($(this).parent().parent().next().find("note-editable").html()==""){
			msg_advertencia("No puede marcar como respuesta correcta una alternativa vacía");
			$(this).prop('checked', false);
		}
	});
}
function busarPreguntasMatTEjer(){
	var data = new FormData();
	var liCodMatT = $("#idEjercicio").val();
	//console.log("tipo:" + $("#idEjercicio").val());
	data.append("liCodMatT",liCodMatT);
	var html = "";
	$.ajax({
		type : "GET",
		url : contextPath+"/cargaMaterialController/buscarPreguntasMatTEjer",
		data : {liCodMatT:liCodMatT},
		success : function(data){
			if(data != null && data.length > 0){
				for(var i=0;i<data.length;i++){
			          html=html+"<tr><td class='text-xs-center'>"+(i+1)+"</td><td>"+data[i].descripcion+" </td><td class='text-xs-center'><button type='button' title='Modificar' data-toggle='tooltip' data-original-title='Modificar' data-placement='top' onclick='editarMatTEjerPreg(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' data-toggle='tooltip' data-original-title='Eliminar' data-placement='top' onclick='confirmar_eliminar(\"pregunta\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
			}else{
				html = "<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>";
			}
			document.getElementById("tbodyMatTEjerPreg").innerHTML=html;
		},
		error : function(){
			//console.log("ERROR: ");
		}
	});
}

function editarMaterialTipoEjercicio(p_id){
	
	$("#btn_guardar_ejercicio").removeAttr("disabled");
	$("#ejercicioTxtTitulo").removeAttr("disabled");
	$("#ejercicioTxtComprension").removeAttr("disabled");
	//$("#ejercicioTxtExpGramatic").removeAttr("disabled");
	
	var url =contextPath+"/cargaMaterialController/objlistarMaterialEjercicio?codEjercicio="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		 
        			$("#ejercicioTxtTitulo").val(data.titulo);
        			$("#ejercicioTxtComprension").val(data.comprension);
        			//$("#ejercicioTxtExpGramatic").val(data.expresionGramatical);
        			$("#bodyEjercicioTxtExpGramatic .note-editable").html(data.expresionGramatical);
        			$("#idEjercicio").val(data.codigo);
        			if (data.subTitulo != "" ||data.subTitulo != null ) {
        				$("#ejercicioTxtSubTitulo").val(data.subTitulo);
					}
        			if(data.tipoEjercicio.codigoRegistro==2){
        				if(data.flgPregu==1){
        					$("#checkTipoPreg").prop('checked',false);
        				}else{
        					$("#checkTipoPreg").prop('checked',true);
        				}
        			}
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
	
	
}



//function grabarOrdenarParrafoCabecera(){
//	var p_idEjercicio = $("#idEjercicio").val();
//	var p_idMaterial	= $("#modalCboMaterial").val();
//	var p_tituloCabecera = $("#tituloActividad").val();
//	var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
//	var url = contextPath+"/cargaMaterialController/grabarOrdenParrafoCabecera";
//	if(p_idMaterial != "0")
//	{
//		$.ajax({
//  			type 	: "POST",
//  			data 	: {idEjercicio:p_idEjercicio,
//  						tituloCabecera : p_tituloCabecera,
//  						idOrdenParrafoCabecera:p_idOrdenParrafoCabecera},
//  			url 	: url,
//  			success : function(data)
//  			{
//  				if (data != "0") {
//  	  				$("#idOrdenParrafoCabecera").val(data);  	  				
//  	  				listarParrafoCabecera();
//  	  				document.getElementById("btnTituloParrafoCabecera").disabled = true;
//  	  				document.getElementById("btnGuardarParrafo").disabled = false;
//  	  				document.getElementById("btn_nuevo_parrafo").disabled = false;
//  	  				msg_exito();
//				}
//  				else
//  				{
//				}
//  			},
//  			error : function()
//  			{
//  				//console.log("ERROR: ");
//  			}
//  		});
//	}
//	else
//	{
//		msg_advertencia("Debe seleccionar un Material.");
//	}
//}

//function grabarOrdenarParrafoCabecera(){
//	var p_idEjercicio = $("#idEjercicio").val();
//	var p_idMaterial	= $("#modalCboMaterial").val();
//	var p_tituloCabecera = $("#tituloActividad").val().trim();
//	var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
//	var url = contextPath+"/cargaMaterialController/grabarOrdenParrafoCabecera";
//	if(p_idMaterial != "0")
//	{
//		$.ajax({
//  			type 	: "POST",
//  			data 	: {idEjercicio:p_idEjercicio,
//  						tituloCabecera : p_tituloCabecera,
//  						idOrdenParrafoCabecera:p_idOrdenParrafoCabecera},
//  			url 	: url,
//  			success : function(data)
//  			{
//  				if (data != "0") {
//  	  				$("#idOrdenParrafoCabecera").val(data);  	  				
//  	  				listarParrafoCabecera();
//  	  				document.getElementById("btnTituloParrafoCabecera").disabled = true;
//  	  				document.getElementById("btnGuardarParrafo").disabled = false;
//  	  				document.getElementById("btn_nuevo_parrafo").disabled = false;
//  	  				msg_exito();
//				}
//  				else
//  				{
//				}
//  			},
//  			error : function()
//  			{
//  				//console.log("ERROR: ");
//  			}
//  		});
//	}
//	else
//	{
//		msg_advertencia("Debe seleccionar un Material.");
//	}
//}


//function grabarOrdenarParrafoCabecera(){
//	var p_idEjercicio = $("#idEjercicio").val();
//	var p_idMaterial	= $("#modalCboMaterial").val();
//	var p_tituloCabecera = $("#tituloActividad").val().trim();
//	var p_idOrdenParrafoCabecera = $("#idOrdenParrafoCabecera").val();
//	var url = contextPath+"/cargaMaterialController/grabarOrdenParrafoCabecera";
//	if(p_idMaterial != "0"){
//		//console.log("titulo:" + p_tituloCabecera);
//		if(p_tituloCabecera!=""){
//			$.ajax({
//	  			type 	: "POST",
//	  			data 	: {idEjercicio:p_idEjercicio,
//	  						tituloCabecera : p_tituloCabecera,
//	  						idOrdenParrafoCabecera:p_idOrdenParrafoCabecera},
//	  			url 	: url,
//	  			success : function(data)
//	  			{
//	  				if (data != "0") {
//	  	  				$("#idOrdenParrafoCabecera").val(data);  	  				
//	  	  				listarParrafoCabecera();
//	  	  				document.getElementById("btnTituloParrafoCabecera").disabled = true;
//	  	  				document.getElementById("btnGuardarParrafo").disabled = false;
//	  	  				document.getElementById("btn_nuevo_parrafo").disabled = false;
//	  	  				msg_exito();
//	  	  				$("#tituloActividad").val("").attr("disabled",true);
//					}
//	  				else
//	  				{
//					}
//	  			},
//	  			error : function()
//	  			{
//	  				//console.log("ERROR: ");
//	  			}
//	  		});
//		}else{
//		      msg_info("Debe completar el título de la actividad");
//		    }
//	}
//	else
//	{
//		msg_advertencia("Debe seleccionar un Material.");
//	}
//}


function cargarComboMaterial2()
{
	var html = "";
	var idLeccion = $("#modalCboLeccion").val();
	$("#modalIdLeccion").val(idLeccion);
//	alert("cargarCombo" + idLeccion);
	
	var url = contextPath+"/cargaMaterialController/cargarComboMaterial"
 
  		$.ajax({
  			type 	: "POST",
  			data 	: {codigoLeccion:idLeccion},
  			url 	: url,
  			success : function(data){
  				$('#modalCboMaterial').empty();
  				/*if(data!=null)
  				{
	   	    		data.sort(function (a, b)
	   	    		{
	   	    		    return (a.codigo - b.codigo);
	   	    		});*/
	   	    		html+="<option value='0'>Seleccione</option>";
	   	    		for(var i=0; i<data.length;i++){
	   	    			html+="<option value='"+data[i].codigo+"'>"+data[i].descripcionMaterial+"</option>";
					}
	   	    		editarLeccionCargarModal3();
	   	    	/*}
  				else
  				{
	   	    		html+="<option value='0'>Todos</option>";
	   	    	}*/
  			},
  			error : function()
  			{
  				//console.log("ERROR: ");
  			},
  			complete: function()
  			{ 
				$('#modalCboMaterial').html(html);
			}
  		});
}


function cargarComboMaterial()
{
	var html = "";
	var idLeccion = $("#modalCboLeccion").val();
	$("#modalIdLeccion").val(idLeccion);
//	alert("cargarCombo" + idLeccion);
	var url = contextPath+"/cargaMaterialController/cargarComboMaterial"
	iniciarBloqueo();
  		$.ajax({
  			type 	: "POST",
  			data 	: {codigoLeccion:idLeccion},
  			url 	: url,
  			success : function(data){
  				$('#modalCboMaterial').empty();
  				/*if(data!=null)
  				{
	   	    		data.sort(function (a, b)
	   	    		{
	   	    		    return (a.codigo - b.codigo);
	   	    		});*/
	   	    		html+="<option value='0'>Seleccione</option>";
	   	    		for(var i=0; i<data.length;i++){
	   	    			var descripcion = (data[i].descripcionMaterial!=null && data[i].descripcionMaterial!='') ? data[i].descripcionMaterial.replace(/<[^>]*>?/g, '')  : '';
	   	    			descripcion = (descripcion!=null && descripcion!='') ? descripcion : ( (data[i].indicacion!=null && data[i].indicacion!='') ? data[i].indicacion : data[i].comprension);
	   	    			var nomTipoMaterial = (descripcion!=null && descripcion!='' && descripcion.length>30) ? (descripcion.substring(0, 30)+'...') : descripcion;
	   	    			html+="<option value='"+data[i].codigo+"'>"+nomTipoMaterial+"</option>";
					}
	   	    	/*}
  				else
  				{
	   	    		html+="<option value='0'>Todos</option>";
	   	    	}*/
  			},
  			error : function()
  			{
  				//console.log("ERROR: ");
  			},
  			complete: function()
  			{
  				finBloqueo();
				$('#modalCboMaterial').html(html);
			}
  		});
}


//function listarParrafoCabecera()
//{	
//	document.getElementById("btnGuardarParrafo").disabled = true;
//	document.getElementById("btn_nuevo_parrafo").disabled = true;
//	var p_idEjercicio = $("#idEjercicio").val();
//	
//	var url = contextPath+"/cargaMaterialController/listarParrafoCabecera";
//	var html = "";
//	$.ajax({
//		type : 'POST',
//		data :{idEjercicio : p_idEjercicio },
//		url : url,
//		success : function(data) 
//		{
//			//console.log("SUCCESS: ", data);
//			if (data != null) 
//			{
//				for (var i = 0; i < data.length; i++) 
//				{
//					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].titulo+"</td> <td> <button type='button' onclick='editarOrdenarParrafoCabecera(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'cabecera'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
//				}
//				document.getElementById("idListadoParrafoCabecera").innerHTML=html;
//			}else{
//				//console.log("lista null");
//			}
//		},
//		error : function(data) {
//			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
//		}
//	});
//	
//}
//function editarOrdenarParrafoCabecera(p_id){
//	document.getElementById("btnTituloParrafoCabecera").disabled = false;
//	document.getElementById("btnGuardarParrafo").disabled = false;
//	document.getElementById("btn_nuevo_parrafo").disabled = false;
//	listarParrafo();
//	var url =contextPath+"/cargaMaterialController/objlistarOrdenarParrafoCabecera?codigo="+p_id
//    $.ajax({
//        url : url,
//        type : 'GET',
//        success : function(data) {        	
//        	  if (data != null) {
//        		 
//        			$("#tituloActividad").val(data.titulo);
//        			$("#idOrdenParrafoCabecera").val(data.codigo);
//			}else{
//				//console.log("No hay registro.");
//			}    	
//        },
//        error : function(request, status, error) {
//          alert(error);
//        }
//       });
//	
//	
//}

//function listarParrafoCabecera()
//{	
//	document.getElementById("btnGuardarParrafo").disabled = true;
//	document.getElementById("btn_nuevo_parrafo").disabled = true;
//	var p_idEjercicio = $("#idEjercicio").val();
//	
//	var url = contextPath+"/cargaMaterialController/listarParrafoCabecera";
//	var html = "";
//	$.ajax({
//		type : 'POST',
//		data :{idEjercicio : p_idEjercicio },
//		url : url,
//		success : function(data) 
//		{
//			//console.log("SUCCESS: ", data);
//			if (data != null) 
//			{
//				for (var i = 0; i < data.length; i++) 
//				{
//					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].titulo+"</td> <td> <button type='button' onclick='editarOrdenarParrafoCabecera(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'cabecera'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
//				}
//				document.getElementById("idListadoParrafoCabecera").innerHTML=html;
//			}else{
//				//console.log("lista null");
//			}
//		},
//		error : function(data) {
//			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
//		}
//	});
//	
//}
//function editarOrdenarParrafoCabecera(p_id){
//	document.getElementById("btnTituloParrafoCabecera").disabled = false;
//	document.getElementById("btnGuardarParrafo").disabled = false;
//	document.getElementById("btn_nuevo_parrafo").disabled = false;
//	listarParrafo();
//	var url =contextPath+"/cargaMaterialController/objlistarOrdenarParrafoCabecera?codigo="+p_id
//    $.ajax({
//        url : url,
//        type : 'GET',
//        success : function(data) {        	
//        	  if (data != null) {
//        		 
//        			$("#tituloActividad").val(data.titulo).attr("disabled",false);
//        			$("#idOrdenParrafoCabecera").val(data.codigo);
//        			$("#btnTituloParrafoCabecera").attr("disabled",false);
//        			$("#parrafo").val("").attr("disabled",false);
//        			$("#numeroOrdenParrafo").val("").attr("disabled",false);
//			}else{
//				//console.log("No hay registro.");
//			}    	
//        },
//        error : function(request, status, error) {
//          alert(error);
//        }
//       });
//	
//	
//}

/*
function eliminarmatej(codigo){
    //  alert("eliminarLengua " + codigo);
        $.ajax({
          url : "/procalidad-natigu-web-gestion/cargaMaterialController/eliminarMaterialTipoEjercicio?p_codmatpej="+codigo,
          type : 'GET',
          success : function(data) {
        	  $('#md_confirmacion').modal('hide');
        	  listarMaterialTipoEjercicio();
        	  msg_exito();
          },
          error : function(request, status, error) {
            alert(error);
          }
         });
  		};
*/
/*
function eliminarMaterialTipoEjercicio(id) {
	$("#idEjercicio").val(id);
	var p_idEjercicio = $("#idEjercicio").val();
	alert(p_idEjercicio);

	var url = contextPath+"/cargaMaterialController/eliminarMaterialEjercicio"
	if(p_idMaterial != "0")
	{
		$.ajax({
  			type 	: "POST",
  			data 	: {idEjercicio:p_idEjercicio},
  			url 	: url,
  			success : function(data)
  			{
  				if (data != 0) {
  	  				$("#idEjercicio").val(data);
  	  				listarMaterialTipoEjercicio();
  	  				msg_exito();
				}
  				else
  				{
  	  				listarMaterialTipoEjercicio();
  	  				msg_exito();
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
		alert("Debe seleccionar un Material.");
	}
	
}*/


//function guardarParrafo(){
//	
//	var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
//	var p_numeroOrden = $("#numeroOrdenParrafo").val();
//	var p_parrafo = $("#parrafo").val();
//	var p_idParrafo = $("#idOrdenarParrafo").val();
//	var url = contextPath+"/cargaMaterialController/grabarParrafo";
//	
//		$.ajax({
//  			type 	: "POST",
//  			data 	: {
//  					   idOrdenarParrafoCabecera:p_idOrdenarParrafoCabecera,
//  					   numeroOrden:p_numeroOrden,
//  					   parrafo:p_parrafo,
//  					   idParrafo:p_idParrafo},
//  			url 	: url,
//
//  			success : function(data)
//  			{
//  				if (data != "0") {
//  	  			$("#idOrdenarParrafo").val(data);
//  	  			listarParrafo();
//  	  			document.getElementById("btnGuardarParrafo").disabled = true;
//  	  			msg_exito();
//				}else{
//					
//				}
//
//  			},
//  			error : function()
//  			{
//  				//console.log("ERROR: ");
//  			}
//  		});
//	
//}

//function guardarParrafo(){
//	
//	var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();
//	var p_numeroOrden = $("#numeroOrdenParrafo").val();
//	var p_parrafo = $("#parrafo").val();
//	var p_idParrafo = $("#idOrdenarParrafo").val();
//	var url = contextPath+"/cargaMaterialController/grabarParrafo";
//	//console.log("paf:" + p_parrafo + "/"+ p_idParrafo);
//	if(p_parrafo!="" && (p_idParrafo!="" || p_idParrafo=="0") ){
//		$.ajax({
//  			type 	: "POST",
//  			data 	: {
//  					   idOrdenarParrafoCabecera:p_idOrdenarParrafoCabecera,
//  					   numeroOrden:p_numeroOrden,
//  					   parrafo:p_parrafo,
//  					   idParrafo:p_idParrafo},
//  			url 	: url,
//
//

//function editarParrafo(p_id){
//	
//	document.getElementById("btnGuardarParrafo").disabled = false;
//	var url =contextPath+"/cargaMaterialController/objlistarParrafo?codParrafo="+p_id
//    $.ajax({
//        url : url,
//        type : 'GET',
//        success : function(data) {        	
//        	  if (data != null) {
//        		 
//        			$("#numeroOrdenParrafo").val(data.numeroOrden);
//        			$("#parrafo").val(data.parrafo);
//        			$("#idOrdenarParrafo").val(data.codigo);
//			}else{
//				//console.log("No hay registro.");
//			}    	
//        },
//        error : function(request, status, error) {
//          alert(error);
//        }
//       });
//	
//	
//}
//
//  			success : function(data)
//  			{
//  				if (data != "0") {
//  	  			$("#idOrdenarParrafo").val(data);
//  	  			listarParrafo();
//  	  			document.getElementById("btnGuardarParrafo").disabled = true;
//  	  			msg_exito();
//  	  			$("#parrafo").val("").attr("disabled",true);
//  	  			$("#numeroOrdenParrafo").val("").attr("disabled",true);
//				}else{
//					
//				}
//
//	},
//  			error : function()
//  			{
//  				//console.log("ERROR: ");
//  			}
//  		});
//	} else{
//		 msg_info("Debe completar los campos del parrafo.");
//	}	
//	
//}

//function listarParrafo()
//{
//	var p_idOrdenarParrafoCabecera = $("#idOrdenParrafoCabecera").val();	
//	var url = contextPath+"/cargaMaterialController/listarParrafo";
//	var html = "";
//	$.ajax({
//		type : 'POST',
//		data :{idOrdenarParrafoCabecera : p_idOrdenarParrafoCabecera},
//		url : url,
//		success : function(data) 
//		{
//			//console.log("SUCCESS: ", data);
//			if (data != null) 
//			{
//				for (var i = 0; i < data.length; i++) 
//				{
//					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].parrafo+"</td> <td> <button type='button' onclick='editarParrafo(\""+data[i].codigo+ "\",\""+data[i].parrafo+"\",\""+data[i].numeroOrden+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_eliminar(\""+'parrafo'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
//				}
//				document.getElementById("idBodyListadoParrafo").innerHTML=html;
//			}else{
//				//console.log("lista null");
//			}
//		},
//		error : function(data) {
//			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
//		}
//	});
//	
//}

//function editarParrafo(p_id){
//	
//	document.getElementById("btnGuardarParrafo").disabled = false;
//	var url =contextPath+"/cargaMaterialController/objlistarParrafo?codParrafo="+p_id
//    $.ajax({
//        url : url,
//        type : 'GET',
//        success : function(data) {        	
//        	  if (data != null) {
//        		 
//        			$("#numeroOrdenParrafo").val(data.numeroOrden);
//        			$("#parrafo").val(data.parrafo).attr("disabled",false);
//        			$("#idOrdenarParrafo").val(data.codigo).attr("disabled",false);
//        			$("#btnGuardarParrafo").attr("disabled",false);
//			}else{
//				//console.log("No hay registro.");
//			}    	
//        },
//        error : function(request, status, error) {
//          alert(error);
//        }
//       });
//	
//	
//}






function limpiarMaterialTipoEjercicio()

{
	$("#ejercicioTxtTitulo").val("");
	$("#ejercicioTxtComprension").val("");
	//$("#ejercicioTxtExpGramatic").val("");
	$("#bodyEjercicioTxtExpGramatic .note-editable").html("");
	$("#idEjercicio").val("0");
	if($("#modalIdTipoEjercicio").val()=="2"){
		$("#checkTipoPreg").prop('checked',true);
	}
}
/*
var codigomatej ="";
    function confirmar_accionmatej(codigo) {
		codigomatej = codigo;
		$('#md_confirmacion').modal('show');

	}

    $("#btnConfirmarGeneric").click(function() {
		eliminarmatej(codigomatej);

	});*/

function eliminarMatTEjerPreg(liCodPreg){
	
	var data = new FormData();
	data.append('liCodPreg',liCodPreg);
	if(liCodPreg=="0" || liCodPreg==""){
		//console.log("Debe seleccionar pregunta.");
	} else{
		let url = contextPath+"/cargaMaterialController/eliminarPregunta";
		$.ajax({
			type:"POST",
			url:url,
			contentType:false,
			data:data,
	   		processData:false,
	   		cache:false,
  			success : function(data){
  				limpiarPreguntaRptas();
  				busarPreguntasMatTEjer();
  				msg_exito();
  				$('#md_confirmacion').modal('hide');
  		  	},
  		  	error : function(){
	  		  	//console.log("No se pudo ingresar el registro");
  		  		msg_error();
  		  	}
		});
	}
	
}

function limpiarPreguntaRptas(){
	$("#idPregunta").val("");
	$("#bodyParrafo .note-editable").html("");
	$("#bodyrpt0 .note-editable").html("");
	$("#bodyrpt1 .note-editable").html("");
	$("#bodyrpt2 .note-editable").html("");
	$("#bodyrpt3 .note-editable").html("");
	limpiarRespuestas();
}
function limpiarMatTEjePreguntaRptas(){
	$("#idEjercicio").val("");
	$("#ejercicioTxtTitulo").val("");
	$("#ejercicioTxtComprension").val("");
	//$("#ejercicioTxtExpGramatic").val("");
	$("#bodyEjercicioTxtExpGramatic .note-editable").html("");
	$("#idPregunta").val("");
	$("#bodyParrafo .note-editable").html("");
	if($("#modalIdTipoEjercicio").val()=="2"){
		$("#checkTipoPreg").prop('checked',true);
	}
	limpiarRespuestas();
}
function limpiarRespuestas(){
	$("#tab42 #0").prop('checked', false);
	$("#tab42 #0").val("");
	$("#tab42 #1").prop('checked', false);
	$("#tab42 #1").val("");
	$("#tab42 #2").prop('checked', false);
	$("#tab42 #2").val("");
	$("#tab42 #3").prop('checked', false);
	$("#tab42 #3").val("");
	$("#bodyrpt0 .note-editable").html("");
	$("#bodyrpt1 .note-editable").html("");
	$("#bodyrpt2 .note-editable").html("");
	$("#bodyrpt3 .note-editable").html("");
	$("#rptaDescripcion0").val("");
	$("#rptaDescripcion1").val("");
	$("#rptaDescripcion2").val("");
	$("#rptaDescripcion3").val("");
}

    function eliminarmatej(codigo){
    	//debugger;
        //  alert("eliminarLengua " + codigo);
	        $.ajax({
	          url : contextPath +"/cargaMaterialController/eliminarMaterialTipoEjercicio?p_codmatpej="+codigo,
	          type : 'GET',
	          success : function(data) 
	          {
	        	  $('#md_confirmacion').modal('hide');
	        	  listarMaterialTipoEjercicio();
	        	  msg_exito();
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
//		alert("accion_tab : "+accion_tab);
//		alert("relacionCabecera : "+ accion_tab.indexOf("relacionCabecera"));
//		alert("parrafo : "+ accion_tab.indexOf("parrafo"));
//		alert("materialTipoEjercicio : "+ accion_tab.indexOf("materialTipoEjercicio"));
//		alert("cabecera : "+ accion_tab.indexOf("cabecera"));
		//console.log("tabpre;" + accion_tab);
		if(accion_tab.indexOf("relacionCabecera") >= 0)
		{
			eliminarRelacion(codigoEliminar);
			accion_tab = "";
			codigoEliminar = "";
		}
//		if (accion_tab.indexOf("parrafo") >= 0) {
//			eliminarParrafo();
//			accion_tab="";
//		}
		if(accion_tab.indexOf("materialTipoEjercicio") >= 0){
			
			if (codigoEliminar == $("#idEjercicio").val()){ 
				$("#idEjercicio").val(0);
				$("#ejercicioTxtTitulo").val("");
				$("#ejercicioTxtComprension").val("");
				//$("#ejercicioTxtExpGramatic").val("");
				$("#bodyEjercicioTxtExpGramatic .note-editable").html("");
				if($("#modalIdTipoEjercicio").val()=="2"){
					$("#checkTipoPreg").prop('checked',true);
				}
			} 
			eliminarmatej(codigoEliminar);
			//listarMaterialTipoEjercicio();
		}
		
		if(accion_tab.indexOf("pregunta") >= 0){
			eliminarMatTEjerPreg(codigoEliminar);
		}
//		if(accion_tab.indexOf("cabecera") >= 0){
//			eliminarParrafoCabecera(codigoEliminar);
//			accion_tab="";
//		}
	});
	function confirmar_eliminar(tabla, codigo){
//		//console.log("entro a coonfirmar eliminar");
		
		//console.log("tabla " +tabla);
		accion_tab = tabla;
		codigoEliminar = codigo;
		$('#md_confirmacion').modal('show');
//		alert(accion_tab);
	}
	


	
//	function eliminarParrafo() {
//		//console.log("codigoEliminar" + codigoEliminar);
//		var url = contextPath+"/cargaMaterialController/eliminarParrafo?codigo="+codigoEliminar
//		$.ajax({
//			url : url,
//			type : 'GET',
//			success : function(data) {
//				//console.log("Se eliminó con éxito");
//				$('#md_confirmacion').modal('hide');
//				codigoEliminar = "";
//				listarParrafo();
//				msg_exito();
//
//			},
//			error : function(msg) {
//				//console.log("errot:" + msg);
//			}
//
//		});
//	}
//	function eliminarParrafoCabecera(id) {
//		//console.log("codigoEliminar" + codigoEliminar);
//		var url = contextPath+"/cargaMaterialController/eliminarParrafoCabecera?codigo="+id
//		$.ajax({
//			url : url,
//			type : 'GET',
//			success : function(data) {
//				//console.log("Se eliminó con éxito");
//				$('#md_confirmacion').modal('hide');
//				codigoEliminar = "";
//				listarParrafoCabecera();
//				msg_exito();
//
//			},
//			error : function(msg) {
//				//console.log("errot:" + msg);
//			}
//
//		});
//	}
	
	function nuevo(){
		
		document.getElementById("btn_guardar_ejercicio").disabled = false;
		 $("#ejercicioTxtTitulo").val("").attr("disabled",false);
		 $("#ejercicioTxtComprension").val("").attr("disabled",false);
		 //$("#ejercicioTxtExpGramatic").val("").attr("disabled",false);
		 $("#bodyEjercicioTxtExpGramatic .note-editable").html("");
		 $("#idEjercicio").val("0");
		 $("#ejercicioTxtSubTitulo").val("");
		 if($("#modalIdTipoEjercicio").val()=="2"){
			$("#checkTipoPreg").prop('checked',true);
		 }
		 
	}

//	function nuevo_TituloCabecera(){
//		document.getElementById("btnTituloParrafoCabecera").disabled = false;
//		$("#tituloActividad").val("");
//		$("#idOrdenParrafoCabecera").val("0");
//	}
//	function nuevo_parrafo(){
//		document.getElementById("btnGuardarParrafo").disabled = false;
//		$("#numeroOrdenParrafo").val("");
//		$("#parrafo").val("");
//		$("#idOrdenarParrafo").val("0");
//	}

//	function nuevo_TituloCabecera(){
//		document.getElementById("btnTituloParrafoCabecera").disabled = false;
//		$("#tituloActividad").val("").attr("disabled",false);
//		$("#idOrdenParrafoCabecera").val("0");
//		$("#btnTituloParrafoCabecera").attr("disabled",false);
//	}
//	function nuevo_parrafo(){
//		document.getElementById("btnGuardarParrafo").disabled = false;
//		$("#numeroOrdenParrafo").val("").attr("disabled",false);
//		$("#parrafo").val("").attr("disabled",false);
//		$("#idOrdenarParrafo").val("0");
//		$("#btnGuardarParrafo").attr("disabled",false);
//	}

	
	function validarActividadEjercicio(){
		$("#base-tab42,#base-tab43").click(function(){
			var liCodEjer = $("#idEjercicio").val();
			if((liCodEjer=="0" || liCodEjer=="" )){
				msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
				$("#base-tab41").click();
				return false;
			}
			
		});
	}
	
	function buscarEjercicioXNombre(){
		//console.log(listaTipoEjercicios);
		var htmlList = "";
		var nombre = $('#inputSearchExerciseByName').val();
		
		//var expr = new RegExp("^" + nombre,"i");
		var expr = new RegExp(nombre,"i");
		
	    for (var x=0; x < listaTipoEjercicios.length; x++) {
	    	 var objMaestroEj = listaTipoEjercicios[x];
		     if (expr.test(objMaestroEj.nombreLargo)) {
		    	 var topx = $(".vertical-scroll").position();
		    	 $('.visible-scroll').scrollTop(topx.top);
		    	 htmlList+= '<div class="media fila_seleccionada" id="tr_selecc_'+objMaestroEj.codigoRegistro+'" actividad-data="'+objMaestroEj.codigoRegistro+'" onclick="cargarContenido('+objMaestroEj.codigoRegistro+');seleccionarFilaTabla('+objMaestroEj.codigoRegistro+');listarMaterialTipoEjercicio();">'+
		    	 				'<a class="media-left" href="#">'+
				    				'<img class="media-object" src="'+contextPath+'/app-assets/images/portrait/small/avatar-tipo-ejercicio.png" alt="Generic placeholder image" style="width: 44px;height: 44px;">'+  
				    			'</a>'+
				    			'<div class="media-body">'+
				      				'<h4 class="media-heading"><small>'+objMaestroEj.nombreLargo+'</small></h4>'+
				      				'<p id="tr_selecc_text_'+objMaestroEj.codigoRegistro+'" class="fila_seleccionada_text">'+objMaestroEj.valor1+'</p>'+
				    			'</div>'+
				  			'</div>';
		     }
	    }
	    
	    $('#idBodyTablaMenus').empty();
	    $('#idBodyTablaMenus').html(htmlList);
	    if(tipoEjerActualSel>0){
	    	$("#idBodyTablaMenus .fila_seleccionada_text").css("color", "");
			$("#idBodyTablaMenus .fila_seleccionada").css("background-color", "");
			$("#idBodyTablaMenus #tr_selecc_"+tipoEjerActualSel).css("background-color", "#fd8469");
			$("#idBodyTablaMenus #tr_selecc_text_"+tipoEjerActualSel).css("color", "#ffffff");
	    }
	}
	
	function obtenerListaInicialEjer(){
		
	  	$("#idBodyTablaMenus .fila_seleccionada").each(function (index) 
	    {
	    	var objMaestro = {
	    		codigoRegistro : 0,
	    		nombreLargo : '',
	    		valor1 : null
		  	};
	    	
	    	var idDiv = '#'+$(this).attr('id');
	    	var elemNomLargo, elemVal1;
	    	
	    	objMaestro.codigoRegistro = $(this).attr('actividad-data');
	    	elemNomLargo = idDiv+' .media-body #tr_selecc_nameExc_'+objMaestro.codigoRegistro;
	    	//objMaestro.nombreLargo  = $(idDiv+' .media-body h4 small').html();
	    	objMaestro.nombreLargo  = $(elemNomLargo).html();
	    	elemVal1 = idDiv+' .media-body #tr_selecc_text_'+objMaestro.codigoRegistro;
	    	objMaestro.valor1    	= $(elemVal1).html();
	    	listaTipoEjercicios.push(objMaestro);
	    })
		
	    //console.log(listaTipoEjercicios);
	}
	
	let listaTipoEjercicios = [];
	tipoEjerActualSel   = 0;
	
	$(document).ready(function(){
		$("#base-tab42").click(function(){
			var liCodEjer = $("#idEjercicio").val();
			if((liCodEjer=="0" || liCodEjer=="" )){
				msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
				$("#base-tab41").click();
				return false;
			}
			
		});
		
		obtenerListaInicialEjer();
	});
	
	
	var codiMate =0;
	function confirmar_eliminarMaterial(cod) { 
		codiMate   = cod;
	    $('#md_confirmacion').modal('show'); 
	  }

    $("#btnConfirmarGeneric").click(function() {
      if (codiMate != null  && codiMate != 0  ){
    	  eliminarLeccionMaterial(codiMate);
    	  $('#md_confirmacion').modal('hide');
         }
  });
// 28-09-2020 jinmi
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








