var contextPathUrl = $('#contextPathUrl').val();
var tabSelecc = 1;

function validarFechaInFin(dateInicio,dateFin){
	var inicio = $(dateInicio).val();
	var final  = $(dateFin).val();

	var fechaInicio = inicio.split('/');
	var fechaFin    = final.split('/');

	 fechaInicio = new Date(fechaInicio[2], fechaInicio[1] - 1, fechaInicio[0]);
	 fechaFin    = new Date(fechaFin[2], fechaFin[1] - 1, fechaFin[0]);

	if(fechaInicio > fechaFin){
		msg_advertencia("La fecha final debe ser mayor que la fecha inicial");
		$(dateFin).focus();
		return false;
	}else{
		return true;
	}
}

function changeFormat(fecha){
	if(fecha){
		var x = fecha.split('-');
		var formatFecha = fecha1 = x[2] + "/" + x[1] + "/" + x[0]; // DD/MM/YYYY
		return formatFecha;
	}else{
		return '';
	}
}

function limpiarCampos(form){
	$(form+" input[type='text']").val("");
	$(form+" input[type='date']").val("");
	$(form+" .select-del").prop('selectedIndex',0);
}


function buscarAudInit(tab,form,method){
	var html = '';
	var idTabla = '';
	var idBodyTabla = '';
	var url = '';
	//debugger;
	if(tab == 1){
		
		$('#contentDetalleAud').hide();
    	$('#contentDetalleAud h4').html('');
    	$('#idBodyTablaAuditoriaDetalle').empty();
		
		url = contextPathUrl+'/auditoriaController/listarAuditoria';
		idTabla = '#idTablaAuditoria';
		idBodyTabla = '#idBodyTablaAuditoria';
		/** convert date to string **/
		$('#textFecIniAud').val(changeFormat($('#calendarFecIniAud').val()));
		$('#textFecFinAud').val(changeFormat($('#calendarFecFinAud').val()));
		if(!validarFechaInFin('#textFecIniAud','#textFecFinAud')){
			return false;
		}
	}else if(tab == 2){
		url = contextPathUrl+'/auditoriaController/listarAuditoriaAcceso';
		idTabla = '#idTablaAuditoriaAcceso';
		idBodyTabla = '#idBodyTablaAuditoriaAcceso';	
		/** convert date to string **/
		$('#textFecIniAudAcc').val(changeFormat($('#calendarFecIniAudAcc').val()));
		$('#textFecFinAudAcc').val(changeFormat($('#calendarFecFinAudAcc').val()));
		if(!validarFechaInFin('#textFecIniAudAcc','#textFecFinAudAcc')){
			return false;
		}
	}
	
	iniciarBloqueo();
	$.ajax({
		url: url,
		type: method,
		data: $(form).serialize(),
 		success: function(data) {
 			html = cargarListaAuditoriaHtml(tab,data);
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
			destroyDataTable(idTabla);
	    	$(idBodyTabla).empty();
	        $(idBodyTabla).html(html);
	        if(tab == 1){
	        	configDataTable(idTabla);
	        }else if(tab == 2){
	        	initDataTable(idTabla);
	        }
        }
	});
}

function cargarListaAuditoriaHtml(tab,data){
	//console.log(data);
	var html = '';
	if(data!=null && data.length>0){
		if(tab == 1){
			for (var i = 0; i < data.length; i++) {
				html += 
				'<tr>'+ 
	 				'<td>'+(i+1)+'</td>'+
					'<td>'+(data[i].nomTabla ? data[i].nomTabla : '---')+'</td>'+
					'<td>'+(data[i].codRegistroAud ? data[i].codRegistroAud : '---')+'</td>'+
					'<td>'+(data[i].tipoAccion.nombreCorto ? data[i].tipoAccion.nombreCorto : '---')+'</td>'+
					'<td>'+(data[i].strFechaHoraAud ? data[i].strFechaHoraAud : '---')+'</td>'+
					'<td>'+(data[i].nomUsuario ? data[i].nomUsuario : '---')+'</td>'+
					'<td>'+(data[i].nomPersonaUsu ? data[i].nomPersonaUsu : '---')+'</td>'+
					'<td>'+(data[i].ipCreacion ? data[i].ipCreacion : '---')+'</td>'+
					'<td class="btn-bqd-submenu">'+
		                '<button type="button"'+ 
		                		'class="btn btn-outline-success btn-sm"'+ 
		                		'data-toggle="tooltip"'+   
		                		'data-original-title="Detalle"'+
		                		'onclick="verDetalle('+data[i].codigo+')">'+ 
		                		'<i class="ft-search"></i>'+ 
		                '</button>'+
		            '</td>'+
		            '<td></td>'+
				'</tr>';
			}
		}else{
			for (var i = 0; i < data.length; i++) {
				html += 
				'<tr>'+ 
	 				'<td>'+(i+1)+'</td>'+
					'<td>'+(data[i].tipoSistema.nombreCorto ? data[i].tipoSistema.nombreCorto : '---')+'</td>'+
					'<td>'+(data[i].tipoAccion.nombreCorto ? data[i].tipoAccion.nombreCorto : '---')+'</td>'+
					'<td>'+(data[i].strFechaHoraAcc ? data[i].strFechaHoraAcc : '---')+'</td>'+
					'<td>'+(data[i].nomUsuario ? data[i].nomUsuario : '---')+'</td>'+
					'<td>'+(data[i].nomPersonaUsu ? data[i].nomPersonaUsu : '---')+'</td>'+
					'<td>'+(data[i].ipCreacion ? data[i].ipCreacion : '---')+'</td>'+
				'</tr>';
			}
		}
	}
	return html;
}

function verDetalle(codaud){
	var html = '';
	var nomTabla = '';
	
	iniciarBloqueo();
	$.ajax({
		url: contextPathUrl+'/auditoriaController/listarAuditoriaDetalle',
		data: {codauditoria : codaud},
		type: 'GET',
 		success: function(data) {
 			//console.log(data);
 			if(data!=null && data.length>0){
 				nomTabla = data[0].nomTabla;
 	 			for (var i = 0; i < data.length; i++) { 
 	 				html += 
 	 				'<tr>'+ 
 		 				'<td>'+(i+1)+'</td>'+
 						'<td>'+(data[i].nomCampo ? data[i].nomCampo : '---')+'</td>'+
 						'<td>'+(data[i].valorAnterior ? data[i].valorAnterior : '---')+'</td>'+
 						'<td>'+(data[i].valorNuevo ? data[i].valorNuevo : '---')+'</td>'+
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
	    	$('#contentDetalleAud').show();
	    	$('#contentDetalleAud h4').html(nomTabla);
	    	$('#idBodyTablaAuditoriaDetalle').empty();
            $('#idBodyTablaAuditoriaDetalle').html(html);
            goToId('contentDetalleAud');
        }
	});
}

function goToId(idName)
{
	if($("#"+idName).length)
	{
		var target_offset = $("#"+idName).offset();
		var target_top = target_offset.top;
		$('html,body').animate({scrollTop:target_top},{duration:"slow"});
	}
}

function configDataTable(valor){
	$(valor).DataTable({
        language:{
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Sin registros para mostrar",
//          "sInfo":           "Página _START_ de _END_ de (_TOTAL_ registros)",
            "sInfo":           "Página _PAGE_ de _PAGES_ de (_TOTAL_ registros)",
            "sInfoEmpty":      "Página 0 de 0  (0 registros)",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     ">",
                "sPrevious": "<"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        },
		responsive: {
	        details: {
	            type: 'column',
	            target: -1
	        }
	    },
	    columnDefs: [{
	        className: 'control',
	        orderable: false,
	        targets: -1
	    }]
    });
}