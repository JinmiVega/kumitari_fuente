var contextPathUrl = $('#contextPathUrl').val();
var idInstitucionUsu = $('#idInstitucionUsu').val();

function limpiarFiltros(form,idtable){
	$(form+" input[type='text']").val("");
	$(form+" input[type='date']").val("");
	$(form+" .select-del").prop('selectedIndex',0);
	limpiarDataTable(idtable);
}

/** TAB INSCRIPCIONES **/
if(idInstitucionUsu!=null && idInstitucionUsu>0){
	$('#cboInstRptInscr').val(idInstitucionUsu);
}

function reporteInscripciones(){
	var html = '';
	
	var codinst = $('#cboInstRptInscr').val();
	var codsit = $('#cboSitRptInscr').val();
	var codPerfilAct = $('#cboPerfilSesionActual').val();
	iniciarBloqueo();
	$.ajax({
		url: contextPathUrl+'/indicadorController/reporteInscripciones',
		type: 'GET',
		//data: $("#formBusqInscripcion").serialize(),
		data: {codinst : codinst , codsit : codsit,codPerfilAct:codPerfilAct},
 		success: function(data) {
// 			console.log(data);
 			if(data!=null && data.length>0){
 	 			for (var i = 0; i < data.length; i++) {
 	 				html += 
 	 				'<tr>'+ 
 		 				'<td>'+(i+1)+'</td>'+
 						'<td>'+(data[i].institucion.nombreInstitucion)+'</td>'+
 						'<td>'+(data[i].periodo.codigoRegistro)+" - "+(data[i].ciclo.nombreCorto)+'</td>'+
 						'<td>'+(data[i].fechavdRegistro==null ? '----' : data[i].fechavdRegistro)+'</td>'+
 						'<td>'+(data[i].fechavdSincronizacion==null ? '----' : data[i].fechavdSincronizacion)+'</td>'+
 						'<td>'+(data[i].situacion.nombreCorto)+'</td>'+
 					'</tr>';
 				}
 			}
         },
		error: function(xhr,status,er) {
			//console.log("error: " + xhr + " status: " + status + " er:" + er);
		    if(xhr.status==500) {
		    	//console.log(er);
		    }
		    if(xhr.status==901) {
		    	//console.log(er);
 			}
	    },
	    complete: function(){
	    	finBloqueo();
	    	destroyDataTable('#tablaRptInscripcion');
	    	$('#tbodyReportInscr').empty();
            $('#tbodyReportInscr').html(html);
            initDataTable('#tablaRptInscripcion');
        }
	});
}

/** TAB SEGUIMIENTO **/
function selectTabSeg(){
	if(idInstitucionUsu!=null && idInstitucionUsu>0){
		$('#lblInstitu').val(idInstitucionUsu);
		buscarLengua();
	}
}

function buscarLengua(){
	var id = $("#lblInstitu").val();
	//console.log('buscarLengua codinst: '+id);
//	document.getElementById("lblLengua").options[document.getElementById("lblLengua").innerHTML="0"];
	document.getElementById("lblLengua").options[document.getElementById("lblLengua").innerHTML=""];
	document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option("Seleccionar", "0");
	document.getElementById("lblDocente").options[document.getElementById("lblDocente").innerHTML="0"];
	document.getElementById("lblDocente").options[document.getElementById("lblDocente").options.length]=new Option("Todos", "0");
	iniciarBloqueo();
	$.ajax({
		type : "GET",
		url : contextPathUrl+"/seguimientoController/buscarLengua",
		data : {codigoinstitucion : id},
		success : function(data) {
			if(data!=''){
				for(var i=0; i<data.length;i++){
					document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option(data[i].nombre, data[i].codigo);
				}
			}
		},
		error : function() {
			//console.log("ERROR: ");
		},
		complete : function() {
			finBloqueo();
		}
	});
}

function buscarDocente(iddocente) {
	var idInstitucion = $("#lblInstitu").val();
	var idLengua = $("#lblLengua").val();
	document.getElementById("lblDocente").options[document.getElementById("lblDocente").innerHTML="0"];
	document.getElementById("lblDocente").options[document.getElementById("lblDocente").options.length]=new Option("Todos", "0");
	iniciarBloqueo();
	$.ajax({
		type : "GET",

		url : contextPathUrl+"/seguimientoController/buscarDocente",
		data : {codigoinstitucion:idInstitucion,codigolengua:idLengua},
		success : function(data) {
//			console.log("SUCCESS: ", data);
			if(data!=''){
				for(var i=0; i<data.length;i++){
					document.getElementById("lblDocente").options[document.getElementById("lblDocente").options.length]=new Option(data[i].personaBean.nombreCompleto, data[i].codigo);
				}
			}
    	    $("#lblDocente").val(iddocente);
		},
		error : function() {
			//console.log("ERROR: ");
		},
		complete : function() {
			finBloqueo();
		}
	});
}

function limpiarDataTable(form){
	   var tablaMenus = $(form).dataTable();
	   tablaMenus.fnClearTable();
	}

function reporteSeguimiento(){
	
	var codinstitucion 	= $('#frmBuscarSeguimientoAlumno #lblInstitu').val();
	var codlengua 		= $('#frmBuscarSeguimientoAlumno #lblLengua').val();
	var coddocente 		= $('#frmBuscarSeguimientoAlumno #lblDocente').val();
	var codnivel 		= $('#frmBuscarSeguimientoAlumno #lblNivel').val();
	var codperiodo 		= $('#frmBuscarSeguimientoAlumno #lblPeriodo').val();
	var codsituacion 	= $('#frmBuscarSeguimientoAlumno #lblSituacion').val();
	
	if(codinstitucion==null || codinstitucion=='' || codinstitucion=='0'){
		msg_advertencia('Debe seleccionar una institución');
		$('#frmBuscarSeguimientoAlumno #lblInstitu').focus();
		return false;
	}
	if(codlengua==null || codlengua=='' || codlengua=='0'){
		msg_advertencia('Debe seleccionar una lengua');
		$('#frmBuscarSeguimientoAlumno #lblLengua').focus();
		return false;
	}
	
	var htmlTabla = "";
	iniciarBloqueo();
	$.ajax({
        type: "POST",
        url:  contextPathUrl+"/indicadorController/reporteSeguimiento",
        data: 
        {
        	codinstitucion 	: codinstitucion,
			codlengua 		: codlengua,
			coddocente 		: coddocente,
			codnivel 		: codnivel,
			codperiodo 		: codperiodo,
			codsituacion 	: codsituacion
        },
        success: function(data){
//        	console.log("SUCCESS: ", data);
	    	if(data!=null && data.length>0){
	    		
	    		for (var i = 0; i < data.length; i++) {
		    		var objMatricula = data[i];
		    		var options = { year: 'numeric', month: 'long', day: 'numeric' };
					var fechaRegistro = new Date(objMatricula.inscripcion.fechaRegistro);
					var fechaModificacion = new Date(objMatricula.inscripcion.fechaModificacion);

		    		htmlTabla +=
		    		"<tr>"+
		    			"<td>"+(i+1)+"</td>"+
    					"<td>"+objMatricula.insti.nombreInstitucion+"</td>"+
    					"<td>"+objMatricula.docenteBean.personaBean.nombreCompleto+"</td>"+
    					"<td>"+objMatricula.alumnoBean.personaBean.nombreCompleto+"</td>"+
    					"<td>"+objMatricula.alumnoBean.usuario+"</td>"+
    					"<td>"+objMatricula.lengua.nombre+" - "+objMatricula.nivel.nombreCorto+" - "+objMatricula.periodo.codigoRegistro+" - "+objMatricula.ciclo.nombreCorto+"</td>"+
    					"<td>"+objMatricula.situacion.nombreLargo+"</td>"+
		    		"</tr>";
				}
	    	}
        },
		error: function(xhr,status,er) {
			msg_error();
		    //console.log("error: " + xhr + " status: " + status + " er:" + er);
			if(xhr.status==500) {
				//console.log(er);
			}
			if(xhr.status==901) {
		    	//console.log(er);
 			}
		},
		complete: function(){
			finBloqueo();
	    	destroyDataTable('#tablaRptSeguimiento');
	    	$('#listadoSeguimiento').empty();
			$('#listadoSeguimiento').html(htmlTabla);
            initDataTable('#tablaRptSeguimiento');
		}
    });	
}