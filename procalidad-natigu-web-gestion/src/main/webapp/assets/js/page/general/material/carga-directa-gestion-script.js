var contextPathUrl = $('#contextPathUrl').val();
var leccionSeleccionada = false;
var tipoAccionEjer = 0;
var accionPregunta = 1;

function seleccionarFilaTabla(valor){
	tipoEjerActualSel = valor;
	$("#idBodyTablaMenus .fila_seleccionada_text").css("color", "");
	$("#idBodyTablaMenus .fila_seleccionada").css("background-color", "");
	$("#idBodyTablaMenus #tr_selecc_"+valor).css("background-color", "#fd8469");
	$("#idBodyTablaMenus #tr_selecc_text_"+valor).css("color", "#ffffff");
}

function cargarContenido(val)
{
	var valor 		= val;
  	var idLengua 	= document.getElementById("modalTxtIdLengua").value;
  	var idNivel 	= document.getElementById("modalCboNivel").value;
  	var idSubNivel 	= document.getElementById("modalCboSubNivel").value;
  	var idLeccion 	= document.getElementById("modalCboLeccion").value;
  	var liCodUnid = $("#modalCboUnidad").val();
  	var liMatLecc = $("#modalCboMaterial").val() == "" ? 0 : $("#modalCboMaterial").val() ;
	
  	var url = contextPathUrl+"/cargaMaterialController/cargarContenido";
  	$("#modalIdTipoEjercicio").val(valor);

  	if(valor == "999")
    {
  		url = contextPathUrl+"/cargaMaterialController/cargarContenidoPrincipal"
  		iniciarBloqueo();
      	$.ajax({
  			type 	: "POST",
  			data 	: {valor:valor, codigolengua:idLengua, codigonivel:idNivel, codigosubnivel:idSubNivel, liCodUnid:liCodUnid},
  			url 	: url,

  			success : function(data)
  			{
  				document.getElementById("content-md-frm").innerHTML = data;
  			/*	document.getElementById("modalIdLengua").value = data1.nombre;
  				document.getElementById("modalNombreLengua").innerHTML = data1.nombre;*/
  			},
  			error : function()
  			{
  				//console.log("ERROR: ");
  			},
  			complete: function(){
  				finBloqueo();
  				cargarComboLeccionesXUnidad();
  	        }
  		});
    }
	else
    {
		if(idLeccion == "0"){
			//alert("Seleccione alguna leccion para poder registrar");
			leccionSeleccionada = false;
		}else{
			//alert("existe leccion");
			leccionSeleccionada = true;
		}
		iniciarBloqueo();
  		$.ajax({
  			type 	: "POST",
  			data 	: {valor:valor, codigoleccion:idLeccion, liMatLecc:liMatLecc},
  			url 	: url,

  			success : function(data)
  			{
  				document.getElementById("content-md-frm").innerHTML = data;
				
				/** msb **/
  				/*if(valor == "26"){
  					estadoRelacion(!leccionSeleccionada);
  					listadoRelacionActividad();
    			}*/
  				/* if(valor == "22"){ */
  					listarMaterialTipoEjercicio();
    			/* } */

  			/*	document.getElementById("modalIdLengua").value = data1.nombre;
  				document.getElementById("modalNombreLengua").innerHTML = data1.nombre;*/
          		//listadoPreguntaActividad27();
  				//listadoPreguntaActividad();

  			},
  			error : function()
  			{
  				//console.log("ERROR: ");
  			},
  			complete: function(){
  				finBloqueo();
  	        }
  		});
	}
  	 	
}

/** GESTION DE MATERIAL **/

	function validarLeccionMaterial(){ 
		$("#base-tab44").click(function(){
			//var liCodLecc = $("#modalCboLeccion").val(); 
			var liCodLec2 = $("#idLeccion").val();
			//alert(liCodLec2);
			if(/*liCodLecc == "0" ||*/ (liCodLec2=="0" || liCodLec2=="" )){
				msg_advertencia("Debe existir una lección para poder agregar material.");
				$("#base-tab41").click();
				return false;
			}
			
		});
	}
	
	/** MATERIAL SELECCIONADO DE LISTA **/
	function seleccionarFilaMaterialLista(valor){
		$("#tbodyTipoMaterial .fila_mat_list").css("background-color", "");
		$("#tbodyTipoMaterial #tr"+valor).css("background-color", "#ECF8E0");
	}

	/** HABILITAR DATA EDITOR **/
	function habilitarWYSIWYG(idTextArea){
		/*CKEDITOR.inline( idTextArea, {
			// Define the toolbar groups as it is a more accessible solution.
			toolbarGroups: [
				{"name":"basicstyles","groups":["basicstyles"]},
				{"name":"links","groups":["links"]},
				{"name":"paragraph","groups":["list","blocks"]},
				{"name":"document","groups":["mode"]},
				{"name":"insert","groups":["insert"]},
				{"name":"styles","groups":["styles"]},
				{"name":"about","groups":["about"]}
			],
			// Remove the redundant buttons from toolbar groups defined above.
			removeButtons: 'Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
		} );*/
		 $('#'+idTextArea).summernote({
			 lang: 'es-ES',
			 font: {
			        bold: 'Negrita',
			        italic: 'Cursiva',
			        underline: 'Subrayado'
			 }
		 });
	}

	/** CARGAR REGISTRO DE MATERIAL **/
	function editarLeccionCargarModal(){
		var liCodLecc = $("#modalCboLeccion").val(); 
		if(liCodLecc == "0"){
			msg_advertencia("Debe seleccionar lección para poder visualizar.");
			$("#base-tab41").click();
			return false;
		}
		var data = new FormData();
		data.append('liCodLecc',liCodLecc);
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : contextPathUrl+"/cargaMaterialController/editarLeccionCargarModal",
			contentType:false,
	   		processData:false,
	   		cache:false,
			data : data,
			success : function(data){
				$("#content-md-frm").html(data);
				$("#idLeccion").val(liCodLecc);
				$("#cboLeccionSituacion").val($("#txtLeccionSituacion").val());
				//$('#create_actividad').modal('show');
				$("#contentAllImagen").hide();
				$("#contentAllAudio").hide();
				
				$("#base-tab41").trigger("click");
				
				listarTipoDocumentos();
				habilitarWYSIWYG('ejercicioTxtDescripcion');
				habilitarWYSIWYG('descripcionMaterial');
				habilitarWYSIWYG('ejercicioTxtComentario');
				$('.note-editor').addClass('form-control input-sm');
			},
			error : function(){
				//console.log("ERROR: ");
			},
	        complete: function(){
	    	   finBloqueo();
	    	   buscarLeccionMaterial();
	        }
		});
	}
	
	/** CARGAR COMBO TIPO DOCUMENTO EN MATERIAL REGISTRO **/
	function listarTipoDocumentos(){	
		var liCodEjer = 0;
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
						        value: data[i].codigoRegistro,
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
	
	/** CARGAR TABLA MATERIALES X LECCION **/
	function buscarLeccionMaterial(){
		var tieneData = false;
		var data = new FormData();
		var liCodLecc = $("#modalCboLeccion").val();
		var liSitLeMa = 1;
		data.append("liCodLecc",$("#modalCboLeccion").val());
		data.append("liSitLeMa",1);
		var html = "";
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			data : {liCodLecc:liCodLecc,liSitLeMa:liSitLeMa},
			url  : contextPathUrl+"/cargaMaterialController/listarLeccionMaterial",
			success : function(data){
				if(data!=null && data.length>0){
					tieneData = true;
					for(var i=0;i<data.length;i++){
				          html+= "<tr id='tr"+data[i].codigo+"' class='fila_mat_list'>" +
				          			"<td style='display:none' id='trTipoMaterial"+data[i].codigo+"'>"+data[i].codigo+"</td>" +
				          			"<td class='text-xs-center td'>"+(i+1)+"</td>" +
				          			"<td>"+(data[i].situacionLeccionMaterial.codigoRegistro == 1 ? 'Texto, Audio, Imagen' : (data[i].situacionLeccionMaterial.codigoRegistro == 2 ? 'Texto, Audio' : (data[i].situacionLeccionMaterial.codigoRegistro == 3 ? 'Texto' : (data[i].situacionLeccionMaterial.codigoRegistro == 5 ? 'Tarea' : (data[i].situacionLeccionMaterial.codigoRegistro == 6 ? 'Texto, Imagen' : 'Sin Material')))))+"</td>" +
				          			"<td>"+data[i].descripcionMaterial+" </td>" +
				          			"<td>" +
				          				"<button type='button' title='Modificar' onclick='buscarMaterialLeccion(\""+data[i].codigo+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> " +
				          				"<button type='button' title='Eliminar' onclick='confirmar_eliminarMaterial(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> " +
				          				"<button type='button' title='Seleccionar' onclick='mostrarEjercicios(\""+data[i].codigo+"\");' class='btn btn-outline-success btn-sm btn-show'><i class='ft-eye'></i> </button> </td>" +
				          		"</tr>";
					}
				}else{
					html+= "<tr style='pointer-events: none;'><td><center>Sin registros para mostrar</center></td></tr>";
				}
				document.getElementById("tbodyTipoMaterial").innerHTML=html;
			},
			error : function(){
				//console.log("ERROR: ");
			},
	        complete: function(){
	    	   finBloqueo();
	    	   if(tieneData){
	    		   $("#tbodyTipoMaterial").sortable();
	    	   }
	        }
		});
		
	}
	
	/** ACTUALIZAR EL ORDEN EN TABLA MATERIAL X LECCION **/
	function actualizarOrdenMaterialLeccion(liCodMate,liNewOrde){
		$.ajax({
			type : "POST",
			url : contextPathUrl+"/cargaMaterialController/actualizarOrdenMaterialLeccion",
			data : {liCodMate:liCodMate,liNewOrde:liNewOrde},
			success : function(data){
				//console.log("rpta:" + data);
			},
			error : function(){
				//console.log("ERROR: ");
			}
		});
	
	}
	
	/** CAMBIAR DATOS DE ACUERDO AL TIPO MATERIAL - COMBO **/
	function obtenerTipoMaterial(){
		if($("#modalCboTipoMaterial").val()=="1"){
			$("#contentAllImagen").show();
			$("#contentAllAudio").show();
			$("#contentAllTitulo").show();
			$("#contentAllContexto").show();
			$("#idDivIndicExtra").show();
			
		} else if($("#modalCboTipoMaterial").val()=="2"){
			$("#contentAllImagen").hide();
			$("#contentAllAudio").show();
			$("#contentAllTitulo").show();
			$("#contentAllContexto").show();
			$("#hiddenImg").val("0");
			$("#tieneImagen").val("0");
			$("#idDivIndicExtra").show();
		} else if($("#modalCboTipoMaterial").val()=="3"){
			$("#contentAllImagen").hide();
			$("#contentAllAudio").hide();
			$("#contentAllTitulo").show();
			$("#contentAllContexto").show();
			$("#hiddenAud").val("0");
			$("#hiddenImg").val("0");
			$("#tieneAudio").val("0");
			$("#tieneImagen").val("0");
			$("#idDivIndicExtra").hide();
		}else if($("#modalCboTipoMaterial").val()=="4"){ 
			$("#contentAllImagen").hide();
			$("#contentAllAudio").hide();
			$("#contentAllTitulo").hide();
			$("#contentAllContexto").hide();
			$("#hiddenAud").val("0");
			$("#hiddenImg").val("0");
			$("#tieneAudio").val("0");
			$("#tieneImagen").val("0");
			$("#idDivIndicExtra").hide();
		} else if($("#modalCboTipoMaterial").val()=="5"){
			$("#contentAllImagen").hide();
			$("#contentAllAudio").hide();
			$("#contentAllTitulo").show();
			$("#contentAllContexto").show();
			$("#hiddenAud").val("0");
			$("#hiddenImg").val("0");
			$("#tieneAudio").val("0");
			$("#tieneImagen").val("0");
			$("#idDivIndicExtra").hide();
		}  else if($("#modalCboTipoMaterial").val()=="6"){
			$("#contentAllImagen").show();
			$("#contentAllAudio").hide();
			$("#contentAllTitulo").show();
			$("#contentAllContexto").show();
			$("#hiddenAud").val("0");
			$("#tieneAudio").val("0");
			$("#idDivIndicExtra").hide();
		}else{
			$("#contentAllImagen").hide();
			$("#contentAllAudio").hide();
			$("#hiddenAud").val("0");
			$("#hiddenImg").val("0");
			$("#tieneAudio").val("0");
			$("#tieneImagen").val("0");
			$("#idDivIndicExtra").hide();
		}
		$("#hiddenAud").val("0");
		$("#hiddenImg").val("0");
		$("#tieneAudio").val("0");
		$("#tieneImagen").val("0");
		$("#contentImg img").attr("src","../assets/img/usar_imagen.jpg");
		$("#contentImg img").addClass("thumb2");
		$("#contentImg img").attr("title","");
		$("#contentImg img").attr("alt","");
		$("#audioSourceAct02").attr("src","");
		$("#audioSourceAct02").attr("title","");
		$("#spanNombreMp3").text("");
		$("#bodyDescripcionMaterial .note-editable").html("");
		$("#bodyParrafo .note-editable").html("");
		$("#bodyEjercicioTxtComentario .note-editable").html("");
		$("#txtIndicacion").val("");
		$("#txtComprensionMat").val("");
		$("#cbTipoDoc").val("0");
		$("#txtIndExtraMat").val("");
	}
	
	/** NUEVO REGISTRO MATERIAL **/
	function nuevoMaterial(){
		$("#idMaterial").val("");
		$("#modalCboTipoMaterial").val("0");
		$("#contentImg img").attr("src","../assets/img/usar_imagen.jpg");
		$("#contentImg img").addClass("thumb2");
		//$("#contentImg img").css({"cursor":"pointer","max-width":"30%"});
		var contentAudio = $("#contentAudio");
		$("#bodyDescripcionMaterial .note-editable").html("");
		$("#basicInputAudio").val("");
		$("#basicInputFile").val("");
		contentAudio.empty();
		$("#spanNombreMp3").text("");
		$("#bodyParrafo .note-editable").html("");
		$("#bodyEjercicioTxtComentario .note-editable").html("");
		$("#txtIndicacion").val("");
		$("#txtComprensionMat").val("");
		$("#cbTipoDoc").val("0");
		$("#txtIndExtraMat").val("");
		obtenerTipoMaterial();
		$("#tbodyTipoMaterial .fila_mat_list").css("background-color", "");
	}
	
	/** GUARDAR REGISTRO MATERIAL **/
	function grabarMaterial(){
		var lsAccLecc = "";
		var data = new FormData();
		var liTipMate = $("#modalCboTipoMaterial").val();
		if(liTipMate=="0"){
    		msg_advertencia("Debe seleccionar Tipo Material.");
    		return false;
    	} else if(liTipMate=="1"){
    		if($("#bodyParrafo .note-editable").text()==""  || $("#tieneImagen").val()=="0" || $("#tieneAudio").val()=="0"){ //
    			msg_advertencia("Debe completar los campos.");
        		return false;
    		}
    	}  else if(liTipMate=="2"){
    		if($("#bodyParrafo .note-editable").text()==""  || $("#tieneAudio").val()=="0" ){ // 
    			msg_advertencia("Debe completar los campos.");
        		return false;
    		}
    	} else if(liTipMate=="3"){
    		if($("#bodyParrafo .note-editable").text()==""){
    			msg_advertencia("Debe completar los campos.");
        		return false;
    		}
    	} else if(liTipMate=="5"){
    		if($("#bodyParrafo .note-editable").text()==""){
    			msg_advertencia("Debe completar los campos.");
        		return false; 
    		}
    	} else if(liTipMate=="6"){
    		if($("#bodyParrafo .note-editable").text()=="" || $("#tieneImagen").val()=="0" ){ // 
    			msg_advertencia("Debe completar los campos.");
        		return false;
    		}
    	} 
			var liLeccion = $("#idLeccion").val();
			var liLecMate = $("#idMaterial").val() == "" ? 0 : $("#idMaterial").val();
			var lsCtxMate = $("#bodyParrafo .note-editable").html();
			var lsTitMate = $("#bodyDescripcionMaterial .note-editable").html();
			var txtTitMat = $("#bodyDescripcionMaterial .note-editable").text();
			//console.log("txtTit:" + txtTitMat);
			var lsComenta = $("#bodyEjercicioTxtComentario .note-editable").html(); //$("#ejercicioTxtComentario").val();
			var lsIndicac = $("#txtIndicacion").val();
			var lsTiTramD = $("#cbTipoDoc").val();
			var lsCompren = $("#txtComprensionMat").val();
			var lsIndicacionPreg = $("#txtIndExtraMat").val();
			if($("#hiddenAud").val()=="0"){
				var inputFileAudio = document.getElementById("basicInputAudio");
		    	var lfAudMate = inputFileAudio.files[0];
		    	data.append('lfAudMate',lfAudMate);
			} else{
				//var lfAudMate = new File([$("#audioSourceAct02").attr("src")], $("#audioSourceAct02").attr("title") , {type:"audio/mp3"}); //add filename here
				//data.append('fileAudio',fileAudio);
				//console.log("aud:" + lfAudMate);
				var lfAudMate = new File([$("#audioSourceAct02").attr("src")], ("audio--Vacio---"+$("#audioSourceAct02").attr("title")), {type:"audio/mp3"});
				data.append('lfAudMate',lfAudMate);
			}
			if($("#hiddenImg").val()=="0"){
				var inputFileImage = document.getElementById("basicInputFile");
		    	var lfImgMate = inputFileImage.files[0];
		    	data.append('lfImgMate',lfImgMate);
			} else{
				//var lsExtImg = $("#basicInputFile").val().slice((Math.max(0, $("#basicInputFile").val().lastIndexOf(".")) || Infinity) + 1);
				//console.log("img ext:"+ lsExtImg);
				//var lfImgMate = new File([$("#contentImg img").attr("src")], $("#contentImg img").attr("title"), {type:"image/"+lsExtImg}); //add filename here
				//console.log("img"+ lfImgMate.name);
				var lfImgMate = new File([$("#contentImg img").attr("src")],("img--Vacio---"+$("#contentImg img").attr("title")));
				data.append('lfImgMate',lfImgMate);
			}
			if($("#modalCboTipoMaterial").val()=="2"){
				var lfImgMate = new File([$("#contentImg img").attr("src")],"null");
				data.append('lfImgMate',lfImgMate);
			} else if($("#modalCboTipoMaterial").val()=="6"){
				var lfAudMate = new File([$("#audioSourceAct02").attr("src")], "null", {type:"audio/mp3"});
				data.append('lfAudMate',lfAudMate);
			}else if($("#modalCboTipoMaterial").val()=="3" || $("#modalCboTipoMaterial").val()=="4" || $("#modalCboTipoMaterial").val()=="5"){
				var lfImgMate = new File([$("#contentImg img").attr("src")],"null");
				data.append('lfImgMate',lfImgMate);
				var lfAudMate = new File([$("#audioSourceAct02").attr("src")], "null", {type:"audio/mp3"});
				data.append('lfAudMate',lfAudMate);
			}
			lsAccLecc = liLecMate=="" ? 1 : 2;
			data.append('liTipoSQL',lsAccLecc);
			data.append('liCodMate',liLecMate);
			data.append('lsDesMate',"x");
			data.append('lsCtxMate',lsCtxMate);
			data.append('liCodLecc',liLeccion);
			data.append('liTipMate',liTipMate);
			data.append('lsTitMate',lsTitMate);
			data.append('lsComenta',lsComenta);
			data.append('lsIndicac',lsIndicac);
			data.append('lsTiTramD',lsTiTramD);
			data.append('lsCompren',lsCompren);
			data.append('lsIndicacionPreg',lsIndicacionPreg);
			//console.log("data;"+ data);
	    	var url = contextPathUrl+"/cargaMaterialController/grabarMaterial";
	    	var datax = {'liTipoSQL':lsAccLecc,'liCodMate':liLecMate,'lsDesMate':'a','lsCtxMate':lsCtxMate,'liCodLecc':liLeccion,'liTipMate':liTipMate,'lfImgMate':lfImgMate,'lfAudMate':lfAudMate,'lsTitMate':lsTitMate};
	    	
	    	iniciarBloqueo();
	    	$.ajax({
		    	type:"POST",
		    	url:contextPathUrl+"/cargaMaterialController/grabarMaterial",
		    	contentType:false,
		    	//contentType: "application/json; charset=utf-8",
		        //dataType: "json",
		   		//data:{'liTipoSQL':lsAccLecc,'liCodMate':liLecMate,'lsDesMate':'a','lsCtxMate':lsCtxMate,'liCodLecc':liLeccion,'liTipMate':liTipMate,'lfImgMate':lfImgMate,'lfAudMate':lfAudMate,'lsTitMate':lsTitMate},
		   		//data:"{liTipoSQL: '" + lsAccLecc + "',liCodMate: '" + liLecMate + "',lsDesMate: 'a',lsCtxMate: '" + lsCtxMate + "',liCodLecc: '" + liLeccion + "',liTipMate: '" + liTipMate + "',lfImgMate: " + lfImgMate + ",lfAudMate: " + lfAudMate + ",lsTitMate: '" + lsTitMate + "'}",
		   		data:data,
		   		processData:false,
		   		cache:false,
		   		
		   		success: function(data){
		 	       	msg_exito();
		  			$("#idMaterial").val(data);
		  			buscarLeccionMaterial();
		  			/*$("#idMaterial").val("");
		  			$("#modalCboTipoMaterial").val("0");
		  			$("#contentImg img").attr("src","../assets/img/usar_imagen.jpg");
		  			$("#contentImg img").addClass("img-fluid");
		  			$("#contentImg img").css({"cursor":"pointer","max-width":"30%"});
		  			var contentAudio = $("#contentAudio");
		  			$("#descripcionMaterial").val("");
		  			$("#basicInputAudio").val("");
		  			$("#basicInputFile").val("");
		  			contentAudio.empty();
		  			$("#spanNombreMp3").text("");
		  			$("#ejercicioTxtDescripcion").val("");*/
		  			nuevoMaterial();
		  			//console.log("Se insertó el registro con éxito!!!");
		  			//cargarComboMaterial();
		  			
		  			if(lsAccLecc==1){
		  				$('#modalCboMaterial').append($('<option>', {
		  				    value: data,
		  				    text:  liTipMate == 4 ? 'Sin Material' : txtTitMat
		  				}));
	  				} else {
	  					$("#modalCboMaterial  option[value=" + data +"]").text(liTipMate == 4 ? 'Sin Material' : txtTitMat);
	  				}
		  			//$('#modalCboMaterial').val(data);
		  			/*$('#modalCboMaterial').append($('<option>', {
	  				    value: data,
	  				    text: liTipMate == 4 ? 'Sin Material' : lsTitMate
	  				}));*/
		  			$('#modalCboMaterial').val(data);
		  			
		        },
		 		error: function(er){
		 			//console.log("ERROR: " + er);
		 			//console.log("No se pudo ingresar el registro");
		 			msg_error();
		 		},
		        complete: function(){
		    	   finBloqueo();
		    	   $("#base-tab41").click();
		        }
			});
	}
	
	/** OBTENER DATOS - EDITAR REGISTRO MATERIAL **/
	function buscarMaterialLeccion(liCodMate){
		seleccionarFilaMaterialLista(liCodMate);
		buscarListaEjerciciosMaterial(liCodMate);
		var data = new FormData();
		data.append("liCodMate",liCodMate);
		$("#modalCboMaterial").val(liCodMate);
		var html = "";
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : contextPathUrl+"/cargaMaterialController/buscarMaterialLeccion",
			contentType:false,
	   		processData:false,
	   		cache:false,
			data : data,
			success : function(data){
				var idLecMate = data.codigo;
				var liTipMate = data.situacionLeccionMaterial.codigoRegistro;
				var lsCtxMate = data.contexto;
				var lsTitMate = data.descripcionMaterial;
				var lfImgMate = data.nombreImagen;
				var lfAudMate = data.rutaAudio;
				var lsComenta = data.comentario;
				var lsIndicac = data.indicacion;
				var lsTiTramD = data.tipoTramDoc;
				var lsCompren = data.comprension;
				var lsIndicExtra = data.indicacionExtra;
				$("#modalCboTipoMaterial").val(liTipMate);
				obtenerTipoMaterial();
				$("#idMaterial").val(idLecMate);
				$("#bodyParrafo .note-editable").html(lsCtxMate);
				$("#bodyEjercicioTxtComentario .note-editable").html(lsComenta);
				$("#bodyDescripcionMaterial .note-editable").html(lsTitMate);
				$("#txtIndicacion").val(lsIndicac);
				$("#txtComprensionMat").val(lsCompren);
				$("#txtIndExtraMat").val(lsIndicExtra);
				$("#cbTipoDoc").val(lsTiTramD);
				//console.log(lfImgMate +"-"+ lfAudMate);
				if(liTipMate==1 || liTipMate==6){
					$("#contentImg img").attr("src",contextPath +"/material/"+lfImgMate);
					$("#contentImg img").attr("title",lfImgMate);
					$("#contentImg img").attr("alt",lfImgMate);
				}
				//$("#audioSourceAct02").attr("src","${pageContext.request.contextPath}/material/"+lfAudMate);
				if(liTipMate==1 || liTipMate == 2){
					var contentAudioDiv = $("#contentAudio");
					contentAudioDiv.empty();
					//console.log("contentAudioDiv");
					contentAudioDiv.html('<audio id="audioAct02"  preload="auto" controls><source src="" id="audioSourceAct02" type="audio/mp3" /><p>Tu navegador no implementa el elemento audio</p></audio>');
					$("#audioSourceAct02").attr("src","");
					$("#audioSourceAct02").attr("src",contextPath +"/material/" + lfAudMate);
					$("#audioSourceAct02").attr("title",lfAudMate);
				}
				$("#hiddenAud").val(lfAudMate == "" ? 0 : 1);
				$("#hiddenImg").val(lfImgMate == "" ? 0 : 1);
				$("#tieneAudio").val(lfAudMate == "" ? 0 : 1);
				$("#tieneImagen").val(lfImgMate == "" ? 0 : 1);
				$("#spanNombreMp3").text(lfAudMate);
				
			},
			error : function(){
				//console.log("ERROR: ");
			},
	        complete: function(){
	    	   finBloqueo();
	    	   $('#base-tab44').trigger('click');
	        }
		});
	}
	
	/** ELIMINAR MATERIAL **/
	function eliminarLeccionMaterial(liCodMate){
		let url = contextPathUrl+"/cargaMaterialController/eliminarLeccionMaterial";
		iniciarBloqueo();
		$.ajax({
			type : 	"POST",
			url	 :	url,
			data : {liCodMate: liCodMate},
  			success : function(data){
  				if(data==1){
  					//console.log("Se eliminó con éxito");
  					msg_exito();
  				} else{
  					//console.log("No se pudo eliminar.");
  					msg_error();
  				}
  				$("#modalCboMaterial  option[value=" + liCodMate +"]").remove();
  				$("#tbodyTipoMaterial").find("tr#tr" + liCodMate).remove();
  				
  				$('#tbodyTipoMaterial  > tr').each(function(index) {
 					 actualizarOrdenMaterialLeccion($(this).children().attr("id").substr(14),index);
 				});
  				//$("#modalCboMaterial").val("0");
  					
  		  	},
  		  	error : function(){
	  		  	//console.log("No se pudo ingresar el registro");
  		  		//console.log("ERROR: ");
  		  		msg_error();
  		  	},
	        complete: function(){
	    	   finBloqueo();
	    	   buscarLeccionMaterial();
	        }
		});
		
	}
	
	
/** GESTION DE EJERCICIOS **/
	
	/** MOSTRAR EJERCICIOS TAB 3 **/
	function mostrarEjercicios(liCodMate){
		$("#base-tab43").click();
		buscarListaEjerciciosMaterial(liCodMate);
	}
	
	/** CARGAR TABLA DE EJERCICIOS X MATERIAL **/
	function buscarListaEjerciciosMaterial(liCodMate){
		seleccionarFilaMaterialLista(liCodMate);
		var html = "";
		var tieneData = false;
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			data : {liCodMate:liCodMate},
			url  : contextPathUrl+"/cargaMaterialController/buscarListaEjerciciosMaterial",
			success : function(data){
				//console.log("data:: MSB");
				//console.log(data);
				if(data!=null && data.length>0){
					tieneData = true;
					for(var i=0;i<data.length;i++){
				          html +=
				            "<tr id='tr"+data[i].codigo+"'>" +
				          		"<td style='display:none' id='trEjercicioMaterial"+data[i].codigo+"'>"+data[i].codigo+"</td>" +
				          		"<td class='text-xs-center td'>"+(i+1)+"</td>" +
				          		"<td>"+data[i].titulo+" </td>" +
				          		"<td>"+data[i].tipoEjercicio.nombreLargo+" </td>" +
				          		"<td>" +
				          			"<button type='button' onclick='posicionarEnEjercicio(\""+data[i].tipoEjercicio.codigoRegistro + "\",\"" + data[i].leccionMaterialBean.codigo + "\");' class='btn btn-outline-success btn-sm'><i class='ft-eye'></i></button> " +
				          		"</td>" +
				          	"</tr>";
					}
				}else{
					html += "<tr style='pointer-events: none;'><td colspan='4'><center>Sin registros para mostrar</center></td></tr>";
				}
				document.getElementById("tbodyListaEjercicios").innerHTML=html;
			},
			error : function(){
				//console.log("ERROR: ");
			},
	        complete: function(){
	    	   finBloqueo();
	    	   if(tieneData){
	    		   $("#tbodyListaEjercicios").sortable();
	    	   }
	        }
		});
	}
	
/** ********************************* **/
	function guardarActividad1()
	{
		var p_codejercicio 	= document.getElementById("idEjercicio").value;
		var p_descripcion 	= $("#txtPreguntaDescripcion").val();
		if(p_codejercicio == null || p_codejercicio == 0)
		{
			guardarEjercicio();
		}
		else if(p_codejercicio != null && p_codejercicio != 0)
		{
			if(p_descripcion != "")
			{
				guardarPregunta();
				listadoPreguntaActividad27();
				listadoPreguntaActividad();

			}
			else
			{
				msg_advertencia("Debe ingresar una palabra para agregarla.");
			}
		}
	}


 	function guardarEjercicio()
	{
 		var p_tituloejercicio 	= $("#ejercicioTxtTitulo").val();
		var p_descripcion 		= $("#ejercicioTxtDescripcion").val();
		var p_codleccion 		= $("#modalCboLeccion").val();
	 	var p_tm2tipoejercicio	= $("#modalIdTipoEjercicio").val();

		if(validarCombos(p_codleccion,p_tituloejercicio))
		{
			let url = contextPathUrl+"/cargaMaterialController/grabarejercicio";
			iniciarBloqueo();
			$.ajax({
					type : 	"POST",
					url	 :	url,
					data : {tituloejercicio:	p_tituloejercicio,
							descripcion:		p_descripcion,
		  					codleccion:			p_codleccion,
		  					tm2tipoejercicio:	p_tm2tipoejercicio
		  				   },
		  			success : function(data)
		  		  	{
		  				msg_exito();
		  				$("#idEjercicio").val(data);
		  		  	},
		  		  	error : function()
		  		  	{
		  		  		msg_error();
		  		  		//console.log("ERROR: ");
		  		  	},
			        complete: function(){
			    	   finBloqueo();
			        }
			});
		}
	}

	function listadoPreguntaActividad()
	{
		var numero =document.getElementById("idEjercicio").value;
		
	    var html = "";
	    $.ajax({
	    	type : "POST",
	      	url : contextPathUrl+"/cargaMaterialController/buscarpregunta?p_codejercicio="+numero,
	//      data : {codigoinst:numero},
	      	success : function(data)
	      	{
	          if(data!=null && data.length>0){
	        	  for(var i=0;i<data.length;i++)
			      {
		            html=html+"<tr>"+
			            "<td>"+(i+1)+"</td>"+
			            "<td>"+data[i].descripcion+"</td>"+
			            "<td> <button type='button' onclick='editarPregunta(\""+data[i].codigo+ "\",\"" +data[i].descripcion+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td>"+
		            "</tr>";
		          }
	          }else{
	        	  html=html+"<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</center></td></tr>";
	          }
	          document.getElementById("idTablaPreguntaListado").innerHTML=html;
	      	},
	      	error : function()
	      	{
	        	//console.log("ERROR: ");
	      	}
	    });
	}

  function listadoPreguntaActividad27()
  {
    var numero =document.getElementById("idEjercicio").value;
    
      var html = "";
      $.ajax({
        type : "POST",
          url : contextPathUrl+"/cargaMaterialController/buscarpregunta?p_codejercicio="+numero,
  //      data : {codigoinst:numero},
          success : function(data)
          {
            if(data!=null && data.length>0){
            	for(var i=0;i<data.length;i++)
                {
                  html=html+"<tr>"+
                  	"<td>"+'Espacio' +(i+1)+"</td>"+
                  	"<td> <button type='button' onclick='editarPregunta(\""+data[i].codigo+ "\",\"" +data[i].descripcion+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td>"+
              	  "</tr>";
                }
            }else{
            	html=html+"<tr style='pointer-events: none;'><td colspan='2'><center>Sin registros para mostrar</center></td></tr>";
            }
            document.getElementById("idTablaPreguntaListado27").innerHTML=html;
          },
          error : function()
          {
            //console.log("ERROR: ");
          }
      });
  }
  
	function validarCombos(p_codleccion,p_tituloejercicio)
	{
		let val = true;
		let cadena = 'Para agregar un nuevo ejercicio ';
		if(p_codleccion == 0)
		{
			msg_info(cadena + 'debe seleccionar o agregar una lección.');
			val = false;
		}
		else if(p_tituloejercicio == "")
		{
			msg_info(cadena + 'debe ingresar un título.');
			val = false;
		}
		return val;
	}
  
	function guardarPregunta()
	{
 		var p_codejercicio 	= document.getElementById("idEjercicio").value;
		var p_descripcion 	= $("#bodyParrafo .note-editable").html();

		if(validarCombos(p_codejercicio))
		{
			let url = contextPathUrl+"/cargaMaterialController/grabarPregunta";
			iniciarBloqueo();
			$.ajax({
					type : 	"POST",
					url	 :	url,
					data : {codejercicio:p_codejercicio,
							descripcion	:p_descripcion},
		  			success : function(data)
		  		  	{
		  				$("#idPregunta").val(data);
		  				agregarAlternativa()
		  		  	},
		  		  	error : function()
		  		  	{
		  		  		msg_error();
		  		  		//console.log("ERROR: ");
		  		  	},
			        complete: function(){
			    	   finBloqueo();
			        }
			});
		}
		else {
			msg_advertencia("Debe agregar un ejercicio.");
		}
	}
	
	function agregarAlternativa()
	{
		var p_codpregunta = document.getElementById("idPregunta").value;
	
		if(p_codpregunta != null || p_codpregunta == "")
		{
			var arrayAlternativas 	= [];
			var objPregunta = { codigo : p_codpregunta};
			$("#tblPregunta tbody tr").each(function (index)
			{
				var objAlernativa =
					{
						respuestaEstado : '0',
						descripcion 	: '',
						preguntaBean	: objPregunta
					};
				input    = document.getElementById(index);
				if($(input).is(':checked'))
				{
					objAlernativa.respuestaEstado = "1";
			    }
				else
		 		{
					objAlernativa.respuestaEstado = "0";
		 	 	}
				objAlernativa.descripcion    = document.getElementById("rptaDescripcion"+index).value;
				arrayAlternativas.push(objAlernativa);
		 	});
			enviarAlternativasAjax(arrayAlternativas);
		}
		else
		{
			msg_advertencia("No se pudo registrar las alternativas");
		}
	}
	
 	function enviarAlternativasAjax(arrayAlternativas){

 		let url = contextPathUrl+"/cargaMaterialController/grabarrespuesta";
 		iniciarBloqueo();
 	 	$.ajax({
 	 		   contentType: "application/json",
 	           type: "POST",
 	           data: JSON.stringify(arrayAlternativas),
 	           url: url,
 	           success: function(data)
 	           {
 	        	  msg_exito();
 	           },
 			   error: function(er)
 			   {
 				  //console.log(" ERROR:" + er);
 				  msg_error();
 			   },
		       complete: function(){
		    	  finBloqueo();
		       }
 	         });
 	}
 	
	function uploadAjax()
    {
		var data = new FormData();
		var p_codejercicio 	= $("#idEjercicio").val() == "" ? 0 : $("#idEjercicio").val();
    	var p_tituloejercicio 	= $("#ejercicioTxtTitulo").val();
    	var p_descripcion 		= $("#ejercicioTxtDescripcion").val();
    	var p_codleccion 		= $("#modalCboLeccion").val();
    	var p_tm2tipoejercicio	= $("#modalIdTipoEjercicio").val();

		//console.log("cod_ejercicio: "+p_codejercicio);
		if(p_codejercicio == "0"){
			tipoAccionEjer = 1;
		} else{
			tipoAccionEjer = 2;
			
		}
		//console.log("tipo:" + tipoAccionEjer);
		
    	let url = contextPathUrl+"/cargaMaterialController/grabarImagen";
		var audioName ="";
    	if(tipoAccionEjer == 1){
    		var inputFileImage = document.getElementById("files");
        	var file = inputFileImage.files[0];
        	var inputFileAudio = document.getElementById("fileAudio");
        	var fileAudio = inputFileAudio.files[0];
        	data.append('file',file);
        	data.append('fileAudio',fileAudio);
        	audioName = fileAudio.name;
		} else{
			
			//console.log("img:" + $("#files").val());
			if($("#hiddenAud").val()==0){
				var inputFileAudio = document.getElementById("fileAudio");
	        	var fileAudio = inputFileAudio.files[0];
	        	data.append('fileAudio',fileAudio);
	        	//console.log("audi0");
			} else {
				var fileAudio = new File([$("#audioSourceAct02").attr("src")], ($("#fileAudio").val() =="" ? $("#audioSourceAct02").attr("title") :  $("#fileAudio").val()) , {type:"audio/mp3"}); //add filename here
				data.append('fileAudio',fileAudio);
				//console.log("audi1");
			}

			if($("#hiddenImg").val()==0){
				var inputFileImage = document.getElementById("files");
	        	var file = inputFileImage.files[0];
	        	data.append('file',file);
	        	//console.log("imag0");
			} else {
				var file = new File([$("#tab41 img").attr("src")], ($("#files").val() == "" ? $("#tab41 img").attr("alt") : $("#files").val()), {type:"image/jpg"}); //add filename here
				data.append('file',file);
				//console.log("imag1");
			}
			//var file = new File([$("#tab41 img").attr("src")], "img01.jpg", {type:"image/jpg"}); //add filename here
			//var fileAudio = new File([$("#audioSourceAct02").attr("src")], "audio.mp3", {type:"audio/mpeg"}); //add filename here
			//console.log("archivo img2"+ file);
			//console.log("audio2 "+ fileAudio);
			/*data.append('file',file);
        	data.append('fileAudio',fileAudio);*/
        	if($("#fileAudio").val() ==""){
            	audioName =  $("#audioSourceAct02").attr("title");
            } else{
            	var inputFileAudio2 = document.getElementById("fileAudio");
               	var fileAudio2 = inputFileAudio2.files[0];
                audioName = fileAudio2.name;
            }
		}
    	
    	
    	data.append('codigoejercicio',p_codejercicio);
    	data.append('tituloejercicio',p_tituloejercicio);
    	data.append('descripcion',p_descripcion);
    	data.append('codleccion',p_codleccion);
    	data.append('tm2tipoejercicio',p_tm2tipoejercicio);
    	
    	if(validarCombos(p_codleccion,p_tituloejercicio))
    	{
	    	$.ajax({
			   		url:url,
			    	type:"POST",
			   		contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data)
			        {
			 	       	tipoAccionEjer = 2;
			  			$("#idEjercicio").val(data);
			  			if($("#fileAudio").val() ==""){
			  				//console.log("contentAudio");
				  			var contentAudio = $("#contentAudio");
				  			contentAudio.empty();
				  			//console.log(audioName);
				  			contentAudio.html('<audio id="audioAct02n"  preload="auto" controls><source src="" id="audioSourceAct02n" type="audio/mp3" /><p>Tu navegador no implementa el elemento audio</p></audio>');
				  			$("#audioSourceAct02n").attr("src","");
				  			$("#audioSourceAct02n").attr("src",contextPath +"/material/" + audioName);
			  			} else{
			  				var contentAudioDiv = $("#contentAudio");
			  				contentAudioDiv.empty();
				  			//console.log("contentAudioDiv");
				  			contentAudioDiv.html('<audio id="audioAct02"  preload="auto" controls><source src="" id="audioSourceAct02" type="audio/mp3" /><p>Tu navegador no implementa el elemento audio</p></audio>');
				  			$("#audioSourceAct02").attr("src","");
				  			$("#audioSourceAct02").attr("src",contextPath +"/material/" + audioName);
				  		}
			  			msg_exito();
			        },
			 		error: function(er)
			 		{
			 			//console.log("ERROR: " + er);
			 			msg_error();
			 		}
				});
    	}

	}
	
	function nuevoMaterialTipoEjercicio2(){
		limpiarPreguntaRptas();
	}

	function editarLeccionCargarModal3(){
		var liCodLecc = $("#modalCboLeccion").val(); 
	 
		if(liCodLecc == "0"){
			msg_advertencia("Debe seleccionar lección para poder visualizar.");
			$("#base-tab41").click();
			return false;
		}
		var data = new FormData();
		data.append('liCodLecc',liCodLecc);
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : contextPathUrl+"/cargaMaterialController/editarLeccionCargarModal",
			contentType:false,
	   		processData:false,
	   		cache:false,
			data : data,
			success : function(data){
				$("#content-md-frm").html(data);
				$("#idLeccion").val(liCodLecc);
				$("#cboLeccionSituacion").val($("#txtLeccionSituacion").val());
				//$('#create_actividad').modal('show');
				$("#contentAllImagen").hide();
				$("#contentAllAudio").hide();
				
				$("#base-tab41").trigger("click");
				
				listarTipoDocumentos();
				habilitarWYSIWYG('ejercicioTxtDescripcion');
				habilitarWYSIWYG('descripcionMaterial');
				habilitarWYSIWYG('ejercicioTxtComentario');
				$('.note-editor').addClass('form-control input-sm');
			},
			error : function(){
				//console.log("ERROR: ");
			},
	        complete: function(){
	    	   finBloqueo();
	    	   buscarLeccionMaterial();
	        }
		});
	}
	
	function editarLeccionCargarModal2(liCodLecc){
		$("#modalCboLeccion").val(liCodLecc); 
		cargarComboMaterial();
		if(liCodLecc == "0"){
			msg_advertencia("Debe seleccionar lección para poder editar.");
			$("#base-tab41").click();
			return false;
		}
		var data = new FormData();
		data.append('liCodLecc',liCodLecc);
		$.ajax({
			type : "POST",
			url : contextPathUrl+"/cargaMaterialController/editarLeccionCargarModal",
			contentType:false,
	   		processData:false,
	   		cache:false,
			data : data,
			success : function(data){
				//finBloqueo();
				$("#content-md-frm").html(data);
				$("#idLeccion").val(liCodLecc);
				buscarLeccionMaterial();
				$("#cboLeccionSituacion").val($("#txtLeccionSituacion").val());
				//$('#create_actividad').modal('show');
				$("#contentAllImagen").hide();
				$("#contentAllAudio").hide();
				
				listarTipoDocumentos();
				habilitarWYSIWYG('ejercicioTxtDescripcion');
				habilitarWYSIWYG('descripcionMaterial');
				habilitarWYSIWYG('ejercicioTxtComentario');
				$('.note-editor').addClass('form-control input-sm');
			},
			error : function(){
				//finBloqueo();	
				//console.log("ERROR: ");
			}
		});
	}
	
	function editarMatTEjerPreg(liCodPreg){
		$("#idPregunta").val(liCodPreg);
		//$("#txtPreguntaDescripcion").val(lsDesPreg);
		   $.ajax({
				type: "GET",
				url: contextPathUrl+"/cargaMaterialController/buscarPreguntaMatTEjer",
				data:{liCodPreg:liCodPreg},
				success : function(data){
			    	//for(var i=0;i<data.length;i++){
					$("#bodyParrafo .note-editable").html(data.descripcion);
						$("#idPregunta").val(data.codigo);

		//	      		}
		      		//console.log(data);
				},error : function(){
				    //console.log("ERROR: ");
				}
		    });
		buscarRespuestasPregunta();
	
	}
	
	
	function buscarRespuestasPregunta(){
		limpiarRespuestas();
	    var liCodPreg =$("#idPregunta").val();
	    var data = new FormData();
		data.append('liCodPreg',liCodPreg);
	    $.ajax({
			type: "POST",
			url: contextPathUrl+"/cargaMaterialController/buscarRespuestasPregMaTEjer",
			contentType:false,
			processData:false,
			cache:false,
			data:data,
			success : function(data){
		    	for(var i=0;i<data.length;i++){
					$("#bodyrpt"+i + " .note-editable").html(data[i].descripcion);
					var idrpta = i;
					var valrpta = data[i].respuestaEstado == 1 ? true : false;
					$("#tab42 #"+ idrpta).prop('checked', valrpta);
					$("#tab42 #"+ idrpta).val(data[i].codigo);
	      		}
	      		//console.log(data);
			},error : function(){
			    //console.log("ERROR: ");
			}
	    });
	}
	
	function editarLeccionMaterial(idLecMate, liTipMate, lsCtxMate,lsTitMate,lfImgMate, lfAudMate){
		$("#idMaterial").val(idLecMate);
		$("#bodyParrafo .note-editable").html(lsCtxMate);
		
		$("#bodyDescripcionMaterial .note-editable").html(lsTitMate);
		$("#modalCboTipoMaterial").val(liTipMate);
		//console.log(lfImgMate +"-"+ lfAudMate);
		if(liTipMate==1){
			$("#contentImg img").attr("src",contextPath +"/material/"+lfImgMate);
			$("#contentImg img").attr("title",lfImgMate);
			$("#contentImg img").attr("alt",lfImgMate);
		}
		//$("#audioSourceAct02").attr("src","${pageContext.request.contextPath}/material/"+lfAudMate);
		if(liTipMate==1 || liTipMate == 2){
			var contentAudioDiv = $("#contentAudio");
			contentAudioDiv.empty();
			//console.log("contentAudioDiv");
			contentAudioDiv.html('<audio id="audioAct02"  preload="auto" controls><source src="" id="audioSourceAct02" type="audio/mp3" /><p>Tu navegador no implementa el elemento audio</p></audio>');
			$("#audioSourceAct02").attr("src","");
			$("#audioSourceAct02").attr("src",contextPath +"/material/" + lfAudMate);
			$("#audioSourceAct02").attr("title",lfAudMate);
		}
		$("#hiddenAud").val(lfAudMate == "" ? 0 : 1);
		$("#hiddenImg").val(lfImgMate == "" ? 0 : 1);
		$("#tieneAudio").val(lfAudMate == "" ? 0 : 1);
		$("#tieneImagen").val(lfImgMate == "" ? 0 : 1);
		$("#spanNombreMp3").text(lfAudMate);
		obtenerTipoMaterial();
	}
	
	function grabarPreguntasMaterialTEjer2(){
		var contWord = 0;
		var liAlterAcc = 0;
		$("#tblPregunta tbody tr").each(function (index){
			if($("#bodyrpt"+index + " .note-editable").html()=="" && index <2){
				//msg_advertencia("Debe ingresar alternativa.");
				liAlterAcc = liAlterAcc + 1;
			} 
		});
		var data = new FormData();
		var liMatTEje = $("#idEjercicio").val();
		//console.log("tmat:" + liMatTEje);
		var liCodPreg = $("#idPregunta").val() == "" ? 0 : $("#idPregunta").val();
		var lsDesPreg = $("#bodyParrafo .note-editable").html();
		var lsAccLecc = liCodPreg ==0 ? 1 : 2;
		
		if(lsDesPreg.length>800){
			lsDesPreg = lsDesPreg.substr(0,800);
			contWord++;
		}
		
		data.append("liMatTEje",liMatTEje);
		data.append("liCodPreg",liCodPreg);
		data.append("lsDesPreg",lsDesPreg);
		data.append("liTipoSQL",lsAccLecc);
		
		var $myForm = $('#frmregistromodal');
		//if(validarCheckPreguntas()==true){
		
		if(!$myForm[0].checkValidity()) {
			msg_advertencia("Debe completar los campos requeridos correctamente y/o seleccionar una alternativa");
	   	} else if(liAlterAcc>0){
	   		msg_advertencia("Debe completar los campos requeridos correctamente");
	   	}else{
	   		if(contWord!=0){
	   			msg_advertencia("La descripción de la pregunta ha superado los 800 caracteres, está se ha recortado para su guardado, por favor revisarlo.");
	   		}
	   		
			var url = contextPathUrl+"/cargaMaterialController/grabarPregunta";
			$.ajax({
					type : "POST",
					data:{liTipoSQL:lsAccLecc,liMatTEje:liMatTEje,liCodPreg:liCodPreg,lsDesPreg:lsDesPreg},
					url	:url,
		  			success : function(data){
		  				//console.log("dataxpreg" + data);
		  				if(data>0){
		  					$("#idPregunta").val(data);
		  					//console.log("alternativa tiposql:" + lsAccLecc);
		  					if(data>0){
		  						agregarPreguntaAlternativas(lsAccLecc);
		  						//msg_exito();
		  						limpiarPreguntaRptas();
		  						busarPreguntasMatTEjer();
		  						//cargarContenido(2);seleccionarFilaTabla('2');
		  					}
		  				} else{
		  					//console.log("No se pudo grabar grabarPregunta");
		  					msg_error();
		  				}
		  				
		  		  	},
		  		  	error : function(){
		  		  		msg_error();
		  		  		//console.log("ERROR: ");
		  		  	}
			});
	   	}
		//}
	}
	
	function agregarPreguntaAlternativas(tipoaccion){
		var contWords = "";
		var liCodPreg = $("#idPregunta").val();
		//console.log("idpregunta: "+ liCodPreg);
		if(liCodPreg != null || liCodPreg == ""){
			var arrayAlternativas 	= [];
			var objPregunta = { codigo : liCodPreg};
			$("#tblPregunta tbody tr").each(function (index){
				var objAlernativa = {
						codigo			: 0,
						respuestaEstado : '0',
						descripcion 	: '',
						preguntaBean	: objPregunta
							};
				input    = document.getElementById(index);
				if($(input).is(':checked')){
					objAlernativa.respuestaEstado = "1";
			       }
				else{
					objAlernativa.respuestaEstado = "0";
		 	 	}
				objAlernativa.codigo		 = tipoaccion == 1 ? 0 : $("#tab42 #"+ index).val();
				//console.log("rpta: "+objAlernativa.codigo);
				
				objAlernativa.descripcion    = $("#bodyrpt"+index + " .note-editable").html();
				
				if(objAlernativa.descripcion.length>800){
					objAlernativa.descripcion = objAlernativa.descripcion.substr(0,800);
					contWords+=(index+1)+", ";
				}
				
				arrayAlternativas.push(objAlernativa);

		 	});
			
			if(contWords!=""){
				msg_advertencia("La(s) respuestas(s) "+contWords+"han superado los 800 caracteres, estás se han recortado para su guardado, por favor revisarlas.");
			}
			
			enviarAlternativasArray(tipoaccion,arrayAlternativas);

		}
		else{
			//console.log("No se pudo registrar las alternativas");
			msg_error();
		}

	}
	function enviarAlternativasArray(tipoaccion, arrayAlternativas){
 		//console.log("r: " + tipoaccion);
 		let url = contextPathUrl+"/cargaMaterialController/grabarRespuestasPregunta";
 	 	$.ajax({
 	 		   contentType: "application/json",
 	           type: "POST",
 	           data: JSON.stringify(arrayAlternativas),
 	           url: url,
 	           success: function(data)
 	           {
 	        	   msg_exito();
 	           },
 			   error: function(er) {
 				   //console.log(" er:" + er.error);console.log("er: " + er.responseText);
 				  	msg_error();
 			   }
 	         });
 	}
	
	
	

	function grabarMaterialTipoEjercicio2(){
		
		var $myForm = $('#frmregistromodal');
		var liCodMate = $("#modalCboMaterial").val();
		if (liCodMate==0 || liCodMate==""){
			msg_advertencia("Debe seleccionar un material.");
			return false;
		}
		
		if($("#rptaDescripcion0").val()=="" || $("#rptaDescripcion1").val()==""){
			msg_advertencia("Debe de registrar al menos dos respuestas.");
			return false;
		}
		
   		// validar todos los required
	   	if(!$myForm[0].checkValidity()) {
			msg_advertencia("Debe completar los campos requeridos correctamente.");
	   	}else{
			
	 		var liTipEjer = $("#modalIdTipoEjercicio").val();
			var lsTitTEje = $("#ejercicioTxtTitulo").val();
			var liSituaci = 1;
			var liMatTEje = $("#idEjercicio").val() == "" ? 0 : $("#idEjercicio").val();
			var lsAccLecc = liMatTEje==0 ? 1 : 2;
			var liCodLecc = $("#modalCboLeccion").val();
			var data = new FormData();
			//console.log("params: "+ lsAccLecc +"-"+ liMatTEje+"-"+ liCodMate+"-"+ liTipEjer+"-"+ lsTitTEje+"-"+liSituaci);
			data.append("liTipoSQL",lsAccLecc);
			data.append("liMatTEje",liMatTEje);
			data.append("liCodMate",liCodMate);
			data.append("liTipEjer",liTipEjer);
			data.append("lsTitTEje",lsTitTEje);
			data.append("liSituaci",liSituaci);
			data.append("liCodLecc",liCodLecc);
			let url = contextPathUrl+"/cargaMaterialController/grabarMaterialTipoEjercicio";
			$.ajax({
				type: "POST",
				url	:url,
				contentType:false,
		   		data:data,
		   		processData:false,
		   		cache:false,
	  			success:function(data){
	  				//console.log("rst:" + data);
	  				if(data>0){
	  					$("#idEjercicio").val(data);
	  					grabarPreguntasMaterialTEjer2();
	  				} else{
	  					//console.log("No se pudo grabar MaterialTipoEjercicio");
	  				}
			  	},
			  	error:function(){
				  	msg_error();
			  		 //console.log("ERROR: ");
			  	}
			});
	   	}
	}
	
	function uploadAjax2()
    {
    	var p_tituloejercicio 	= $("#ejercicioTxtTitulo").val();
    	var p_descripcion 		= $("#ejercicioTxtDescripcion").html();
    	var p_codleccion 		= $("#modalCboLeccion").val();
    	var p_tm2tipoejercicio	= $("#modalIdTipoEjercicio").val();

    	let url = contextPathUrl+"/cargaMaterialController/grabarImagen";

    	var inputFileImage = document.getElementById("files");
    	var file = inputFileImage.files[0];
    	var inputFileAudio = document.getElementById("fileAudio");
    	var fileAudio = inputFileAudio.files[0];
    	var data = new FormData();

    	data.append('tituloejercicio',p_tituloejercicio);
    	data.append('descripcion',p_descripcion);
    	data.append('codleccion',p_codleccion);
    	data.append('tm2tipoejercicio',p_tm2tipoejercicio);
    	data.append('file',file);
    	data.append('fileAudio',fileAudio);
    	if(validarCombos(p_codleccion,p_tituloejercicio))
    	{
	    	$.ajax({
			   		url:url,
			    	type:"POST",
			   		contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data)
			        {
			 	       	msg_exito();
			  			$("#idEjercicio").val(data);
			  			//console.log("ERROR: Se insertó el registro con éxito!!!");
			        },
			 		error: function(er)
			 		{
			 			//console.log("ERROR: " + er);
			 			msg_error();
			 		}
				});
    	}

	}
	
	function enviarAlternativasAjax2(tipoaccion, arrayAlternativas){
 		//console.log("r: " + tipoaccion);
 		let url = tipoaccion == 1 ? contextPathUrl+"/cargaMaterialController/grabarrespuesta" : contextPathUrl+"/cargaMaterialController/actualizarrespuesta";
 	 	$.ajax({
 	 		   contentType: "application/json",
 	           type: "POST",
 	           data: JSON.stringify(arrayAlternativas),
 	           url: url,
 	           success: function(data)
 	           {

 	           },
 			   error: function(er) {
 				   //console.log(" er:" + er.error);
 				   //console.log("er: " + er.responseText);
 			   }
 	         });
 	}

 	function editarPregunta(codigo,descripcion){
 		$("#idPregunta").val(codigo);
 		$("#bodyParrafo .note-editable").html(descripcion);
 		listadoRespuestasPregunta();
 		accionPregunta = 2;
 	}

 	function listadoRespuestasPregunta(){
 		$("#rptaDescripcion0").val("");
		$("#rptaDescripcion1").val("");
		$("#rptaDescripcion2").val("");
		$("#rptaDescripcion3").val("");
	    var idPregunta =$("#idPregunta").val();
	     //console.log("pregunta:" + idPregunta);
	    var html = "";
	    $.ajax({
	      type : "POST",
	      url : contextPathUrl+"/cargaMaterialController/buscarrespuestas?p_codpregunta="+idPregunta,
	//      data : {codigoinst:numero},
	      success : function(data){
	          for(var i=0;i<data.length;i++){
					$("#rptaDescripcion"+i).val(data[i].descripcion);

					var idrpta = i;
					var valrpta = data[i].respuestaEstado == 1 ? true : false;
					$("#tab42 #"+ idrpta).prop('checked', valrpta);
					$("#tab42 #"+ idrpta).val(data[i].codigo);
	        	////console.log("Dato: "+ data[i].descripcion);
	            //html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo + "\",\"" + data[i].descripcion +"\");' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
	          }
	          //console.log(data);
	          //document.getElementById("idTablaPreguntaListado").innerHTML=html;
	      },
	      error : function()
	      {
	        //console.log("ERROR: ");
	      }
	    });

	 }
 	
	/***********************MSB *********************************/
	var accionRelacion = '1'; //1:guarda,2:modificar


    function estadoRelacion(estado){
    	
		/* cabecera */
		document.getElementById("ejercicioTxtTitulo").disabled = estado;
		document.getElementById("btn_guardar_ejercicio").disabled = estado;
		/* detalle */

		//obtener si el valor de de ejercicioTxt hay texto
		var existeDatos = $('#idEjercicio').val() == "" ;
		//var existeDatos = false;
		//document.getElementById("txtPalabra").disabled = existeDatos;
		//document.getElementById("txtTexto").disabled = existeDatos;
		//document.getElementById("btnGuardarRelacion").disabled = existeDatos;
		if(!existeDatos){
			$('#table_btn').empty();
			html="<button type='button' id='btn_guardar_ejercicio' onclick='guardarEjercicio()' class='btn btn-primary btn-min-width'><i class='icon-pencil'></i> Editar</button>";
	    	$('#table_btn').html(html);
		}
		//document.getElementById("idOrientacion").disabled = existeDatos;
	}

	/*********************** MSB ******************************/

	function guardarRelacion(){
		var p_codejercicio 	= $("#idEjercicio").val();
    	var p_palabra 		= $("#txtPalabra").val();
    	var p_texto 		= $("#txtTexto").val();
    	var p_tiporelacion	= $("#idTipoRelacion").val();
    	var p_orden 		= $("#idOrden").val();
    	var p_orientacion 	= $("#idOrientacion").val();
    	
		var tipoEjercicio = $("#tipoEjercicio").val();

		let url = "";
   		var data = new FormData();

		//:: Grabar ::
		if(accionRelacion == '1'){
			
			limpiarRelacion();

			if(tipoEjercicio == "crucigrama"){

			   	 if($("#formulario input[name='radio']:radio").is(':checked')){
			   		p_orientacion = '1';
				 }else{
					p_orientacion = '2';
			     }
		    	
			   	url = contextPathUrl+"/cargaMaterialController/grabarRelacion2";

		     	data.append('codejercicio',p_codejercicio);
		     	data.append('palabra',p_palabra);
		     	data.append('texto',p_texto);
		     	data.append('tiporelacion',p_tiporelacion);
		     	data.append('orden',p_orden);
		     	data.append('orientacion',p_orientacion);

		     }else  if(tipoEjercicio == "relacion"){
	            
	        	url = contextPathUrl+"/cargaMaterialController/grabarRelacion";

	        	var inputFileImage = document.getElementById("files");
	        	var file = inputFileImage.files[0];

	        	data.append('codejercicio',p_codejercicio);
	        	data.append('palabra',p_palabra);
	        	data.append('texto',p_texto);
	        	data.append('tiporelacion',p_tiporelacion);
	        	data.append('orden',p_orden);
	        	data.append('orientacion',p_orientacion);
	        	data.append('file',file);

		     }
		}else{
			/*************************/
			if(tipoEjercicio == "crucigrama"){

				if($("#formulario input[name='radio']:radio").is(':checked')){
			   		p_orientacion = '1';
				 }else{
					p_orientacion = '2';
			     }

		   		url = contextPathUrl+"/cargaMaterialController/modificarRelacion2";

		   		var codigo = $("#idRelacion").val();

				limpiarRelacion();

		     	data.append('codigo',codigo);
		     	data.append('palabra',p_palabra);
		     	data.append('texto',p_texto);
		     	data.append('tiporelacion',p_tiporelacion);
		     	data.append('orden',p_orden);
		     	data.append('orientacion',p_orientacion);

		     }/*else  if(tipoEjercicio == "relacion"){

	        	url = contextPathUrl+"/cargaMaterialController/grabarRelacion";

	        	var inputFileImage = document.getElementById("files");
	        	var file = inputFileImage.files[0];

	        	data.append('codejercicio',p_codejercicio);
	        	data.append('palabra',p_palabra);
	        	data.append('texto',p_texto);
	        	data.append('tiporelacion',p_tiporelacion);
	        	data.append('orden',p_orden);
	        	data.append('orientacion',p_orientacion);
	        	data.append('file',file);

		     }*/
		     /*********************/
		}

    	if(validarCombos(p_codejercicio != null)){
    		
	    	$.ajax({
			   		url:url,
			    	type:"POST",
			   		contentType:false,
			   		data:data,
			   		processData:false,
			   		cache:false,
			   		success: function(data)
			        {
			  			msg_exito();
		  				listadoRelacionActividad();
			        },
			 		error: function(er)
			 		{
			 			msg_error();
			 			//console.log("ERROR: " + er);
			 		}
				});
    	}
    	else
        {
    		msg_advertencia("Debe registrar un ejercicio.");
        }
	}

	/***********************  MSB *********************************/
	function limpiarRelacion(){
		accionRelacion = "1";
		$("#txtPalabra").val("");
    	$("#txtTexto").val("");
    	$("#idTipoRelacion").val("");
    	$("#idOrden").val("");
    	html="<div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionHorizontal' name='radio' value='1' type='radio' class='custom-control-input' checked='checked'> <span class='custom-control-indicator'></span><span class='custom-control-description'>Horizontal</span></label></div><div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionVertical' name='radio' value='2' type='radio' class='custom-control-input'><span class='custom-control-indicator'></span><span class='custom-control-description'>Vertical</span></label></div>";
    	document.getElementById("tablaRadio").innerHTML=html;
    	html="<button type='button' id='btnGuardarRelacion' class='btn btn-outline-info btn-min-width' onclick='guardarRelacion();'> <i class='ft-plus'></i> Guardar </button>";
    	document.getElementById("table_btn_relacion").innerHTML=html;

	}
	/*********** MSB *****************/

 	function editarRelacionMSB(codigo,palabra,texto,orientacion){
		accionRelacion = '2';
		
 		$("#txtPalabra").val(palabra);
    	$("#txtTexto").val(texto);
    	//$("#idOrden").val();
    	
    	if(orientacion == '1'){
    		html="<div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionHorizontal' name='radio' value='1' type='radio' class='custom-control-input' checked='checked'> <span class='custom-control-indicator'></span><span class='custom-control-description'>Horizontal</span></label></div><div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionVertical' name='radio' value='2' type='radio' class='custom-control-input'><span class='custom-control-indicator'></span><span class='custom-control-description'>Vertical</span></label></div>";
	        document.getElementById("tablaRadio").innerHTML=html;
        }else{
            html="<div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionHorizontal' name='radio' value='1' type='radio' class='custom-control-input'> <span class='custom-control-indicator'></span><span class='custom-control-description'>Horizontal</span></label></div><div class='form-group col-md-5 mb-0'><label class='custom-control custom-radio'><input id='idOrientacion oritentacionVertical' name='radio' value='2' type='radio' class='custom-control-input' checked='checked'><span class='custom-control-indicator'></span><span class='custom-control-description'>Vertical</span></label></div>";
	        document.getElementById("tablaRadio").innerHTML=html;
        }
    	html="<button type='button' id='btnGuardarRelacion' class='btn btn-outline-info btn-min-width' onclick='limpiarRelacion();'>Cancelar</button>	<button type='button' id='btnGuardarRelacion' class='btn btn-outline-info btn-min-width' onclick='guardarRelacion();'> <i class='ft-plus'></i> Guardar </button>";
    	document.getElementById("table_btn_relacion").innerHTML=html;

    	$("#idRelacion").val(codigo);
    	//$('input:radio[name=radio]:checked').val(orientacion);
 		/*
 		$("#idPregunta").val(codigo);
 		$("#txtPreguntaDescripcion").val(descripcion);
		*/
 		//listadoRespuestasPregunta();
 		//accionPregunta = 2;
 	}


	/********************* MSB *******************/
	function listadoRelacionActividad()
	{
		var numero =document.getElementById("idEjercicio").value;
		var tipoEjercicio = $("#tipoEjercicio").val();
	    var html = "";
	    $.ajax({
	    	type : "POST",
	      	url : contextPathUrl+"/cargaMaterialController/buscarrelacion?p_codejercicio="+numero,
	//      data : {codigoinst:numero},
	      	success : function(data)
	      	{
		      	if(tipoEjercicio = "relacion"){
					 if(data!=null && data.length>0){
		      			 for(var i=0;i<data.length;i++)
					      {
				            html=html+"<tr>"+
				            	"<td>"+(i+1)+"</td>"+
				            	"<td>"+data[i].palabra+"</td>"+
				            	"<td> <button type='button' onclick='editarRelacion(\""+data[i].codigo+ "\",\""+data[i].palabra+"\",\""+data[i].texto+"\",\""+data[i].orientacion+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='eliminarRelacion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				          }
		      		  }else{
		      			html="<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</center></td></tr>";
		      		  }
			          document.getElementById("idTablaRelacionListado").innerHTML=html;

			         //console.log(data);

		       	}else if(tipoEjercicio = "crucigrama"){

		       		  if(data!=null && data.length>0){
		       			 for(var i=0;i<data.length;i++)
					      {
				            html=html+"<tr>"+
				            	"<td>"+(i+1)+"</td>"+
				            	"<td>"+data[i].palabra+"</td>"+
				            	"<td> <button type='button' onclick='editarRelacion(\""+data[i].codigo+ "\",\""+data[i].palabra+"\",\""+data[i].texto+"\",\""+data[i].orientacion+"\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='eliminarRelacion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td>"+
				            	"</tr>";
				          }
		       		  }else{
		       			html="<tr style='pointer-events: none;'><td colspan='3'><center>Sin registros para mostrar</center></td></tr>";
					  }
			         
			          document.getElementById("idBodyListadoMaterialTipoEjercicio").innerHTML=html;//DUDA DUDA DUDA
			          
			         //console.log(data);
		        }
		      /*
	          for(var i=0;i<data.length;i++)
		      {
	            html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo+ "\",\"" +data[i].descripcion+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
	          }
	          document.getElementById("idTablaPreguntaListado").innerHTML=html;
	          */
	      	},
	      	error : function()
	      	{
	        	//console.log("ERROR: ");
	      	}
	    });
	}

	/******************** MSB *************************/
	function eliminarRelacionMSB(valor)
	{
		prmCodigo=valor;
		//$("#idPregunta").val(valor);
		//var tipoaccion = accionPregunta;
 		//console.log("acc:" + tipoaccion);
 		var p_codejercicio 	= $("#idEjercicio").val();
		//var p_descripcion 	= $("#txtPreguntaDescripcion").val();
		//var p_codpregunta =$("#idPregunta").val() == "" ?  0 : $("#idPregunta").val();
		//console.log("cp:" + p_codpregunta);
		if(validarCombos(p_codejercicio)){
			let url = contextPathUrl+"/cargaMaterialController/eliminarRelacion?codigo="+prmCodigo;
			$.ajax({
					type : 	"POST",
					url	 :	url,
					/*data : {codejercicio: p_codejercicio,
							descripcion	:p_descripcion,
							pregunta: p_codpregunta},*/
		  			success : function(data){
			  			//alert("es "+data);
			  			/*
              			listadoPreguntaActividad27();
		  				listadoPreguntaActividad();

		  				accionPregunta = 1;
		  				limpiarPreguntaRptas();*/
						//if(true){
						//	limpiarRelacion();
			  			//}
		  				listadoRelacionActividad();
		  		  	},
		  		  	error : function(){
			  		  	msg_error();
		  		  		//console.log("ERROR: ");
		  		  	}
			});
		}
		else {
			msg_advertencia("Debe agregar un ejercicio.");
		}
	}