$("#idBtnBusqMenu").click(function (){
	var mensaje = "";
	var cboPerfil = $('#cboPerfil').val();
	
	if(cboPerfil == 0){
		$('#cboPerfil').focus();
		mensaje = "Debe seleccionar un perfil";
		msg_info(mensaje);
		return false;
	}
	
});

function seleccionarFilaTabla(valor){
	$("#idBodyTablaMenus .fila_seleccionada").css("background-color", "");
	$("#idBodyTablaMenus #tr_selecc_"+valor).css("background-color", "#ECF8E0");
}

function verSubMenu(codCompoPadre,itemTr) {	
    	
	  seleccionarFilaTabla(itemTr);
	
	  var codperfil   = $('#cboPerfil').val();
	  var contextPath = $('#contextPathUrl').val();
	  
	  iniciarBloqueo();
	  $.ajax({
	    type: "GET",
	    data: "codperfil="+codperfil+"&codcompa="+codCompoPadre,
	    url: contextPath+"/accesoController/verSubMenu",
	    success: function(data){
	    	$('#contentSubMenuTabla').empty();
			$('#contentSubMenuTabla').html(data);
	    },error: function(xhr,status,er) {
            //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console.log(er);
		    	//spire_session_901(er);
     			}
	    },
	    complete: function(){
	        var totalSubMenus = $('#idTotalSubMenus').val();
	        if(totalSubMenus>0){
	        	$('#idRowButtonSaveOnlyMenu').css('display','none');
	        }else{
	        	$('#idRowButtonSaveOnlyMenu').css('display','block');
	        }
		    finBloqueo();
	    }
	  });
}

function limpiarFormAcceso(){
   var tablaMenus = $("#idTablaMenus").dataTable();
   tablaMenus.fnClearTable();
   $('#cboPerfil').val('0');
   $('#contentSubMenuTabla').empty();
   $('#idRowButtonSaveOnlyMenu').css('display','none');
}

function guardarCambiosAcceso(tipo){

	var codperfil   = $('#cboPerfil').val();
	
	var objPerfil = {
  		codigo : codperfil
  	};
	
	var arrayMenus = [];
	
	/** RECORRER MENU **/
    $("#idTablaMenus tbody tr").each(function (index) 
    {
    	var asignado,input,idAcceso,idCompo;
    	
    	var objComponente = {
	  		codigo : 0	
	  	};
	    	
		var objAcceso = {
			item 		: 0,
			codigo		: 0,
			flgAsignado : '0',
			flgRead 	: false,
			flgWrite 	: false,
			flgDelete 	: false,
			flgExport 	: false,
			perfil		: objPerfil,
			componente	: objComponente
	  	};
    	
        $(this).children("td").each(function (index2) 
        {
        	if(index2 == 2 ){ // Columna Asignado
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objComponente.codigo 	= idCompo;
  	   			
      	   		if($(input).is(':checked')) {
      	   			asignado = '1';
           	    }else {
           	    	asignado = '0';
           	    }
      	   		
          	  	objAcceso.item 			= index+1;
          	  	objAcceso.codigo 		= idAcceso;
          	  	objAcceso.flgAsignado	= asignado;
          	  	objAcceso.componente	= objComponente;
        	}
        })
        arrayMenus.push(objAcceso);
    })
    
    if(tipo == 2){
    	
        var totalMenus = arrayMenus.length;
        
        /** RECORRER SUBMENU **/
        $("#idTablaSubMenusOpt tbody tr").each(function (index) 
        {
        	var input,idAcceso,idCompo;
        	
        	var objComponente = {
    	  		codigo : 0	
    	  	};
    	    	
    		var objAcceso = {
    			item 		: 0,
    			codigo		: 0,
    			flgAsignado : '0',
    			flgRead 	: false,
    			flgWrite 	: false,
    			flgDelete 	: false,
    			flgExport 	: false,
    			perfil		: objPerfil,
    			componente	: objComponente
    	  	};
        	
            $(this).children("td").each(function (index2) 
            {	
            	switch (index2) 
                {   
                    case 2: input    = $(this).children("input"); // Columna Lectura
                    		idAcceso = $(input).val();
              	   			idCompo  = $(input).attr("id");
              	   			idCompo  = idCompo.substring(6, idCompo.length);
              	   			var flgread = false;
              	   			
    	          	   		if($(input).is(':checked')) {
    	          	   			flgread = true;
    	               	    }else {
    	               	    	flgread = false;
    	               	    }
    	          	   		
    	          	   		objComponente.codigo 	= idCompo;
    		          	  	objAcceso.item 			= totalMenus+index+1;
    		          	  	objAcceso.codigo 		= idAcceso;
    		          	  	objAcceso.flgRead 		= flgread;
    		          	  	objAcceso.componente	= objComponente;
                            break;
                    case 3: input    = $(this).children("input"); // Columna Escritura
    		        		idAcceso = $(input).val();
    		  	   			idCompo  = $(input).attr("id");
    		  	   		    idCompo  = idCompo.substring(6, idCompo.length);
    		  	   			var flgwrite = false;
    		  	   			
    		      	   		if($(input).is(':checked')) {
    		      	   			flgwrite = true;
    		           	    }else {
    		           	    	flgwrite = false;
    		           	    }
    		      	   		
    		      	   		objComponente.codigo 	= idCompo;
    		          	  	objAcceso.item 			= totalMenus+index+1;
    		          	  	objAcceso.codigo 		= idAcceso;
    		          	  	objAcceso.flgWrite 		= flgwrite;
    		          	  	objAcceso.componente	= objComponente;
    		                break;
                    case 4: input    = $(this).children("input"); // Columna Eliminacion
    		        		idAcceso = $(input).val();
    		  	   			idCompo  = $(input).attr("id");
    		  	   		    idCompo  = idCompo.substring(6, idCompo.length);
    		  	   			var flgdelete = false;
    		  	   			
    		      	   		if($(input).is(':checked')) {
    		      	   			flgdelete = true;
    		           	    }else {
    		           	    	flgdelete = false;
    		           	    }
    		      	   		
    		      	   		objComponente.codigo 	= idCompo;
    		          	  	objAcceso.item 			= totalMenus+index+1;
    		          	  	objAcceso.codigo 		= idAcceso;
    		          	  	objAcceso.flgDelete 	= flgdelete;
    		          	  	objAcceso.componente	= objComponente;
    		                break;
                    case 5: input    = $(this).children("input"); // Columna Exportacion
    		        		idAcceso = $(input).val();
    		  	   			idCompo  = $(input).attr("id");
    		  	   		    idCompo  = idCompo.substring(6, idCompo.length);
    		  	   			var flgexport = false;
    		  	   			
    		      	   		if($(input).is(':checked')) {
    		      	   			flgexport = true;
    		           	    }else {
    		           	    	flgexport = false;
    		           	    }
    		      	   		
    		      	   		objComponente.codigo 	= idCompo;
    		          	  	objAcceso.item 			= totalMenus+index+1;
    		          	  	objAcceso.codigo 		= idAcceso;
    		          	  	objAcceso.flgExport 	= flgexport;
    		          	  	objAcceso.componente	= objComponente;
    		                break;
                }
            })
            arrayMenus.push(objAcceso);
        })
    }
    
    //console.log("total menus array",arrayMenus);

    enviarDatosAccesoAjax(arrayMenus);
}

function enviarDatosAccesoAjax(arrayMenus){
	
	var contextPath = $('#contextPathUrl').val();
    var htmlTabla="";
    
    iniciarBloqueo();
    // for (var i = 0; i < data.length; i++) {
 	$.ajax({
 		   contentType: "application/json",
           type: "POST",
           data: JSON.stringify(arrayMenus),
           url: contextPath+"/accesoController/asignarAcceso",
           success: function(data)
           {	
        	    msg_exito();
        	    
	   	    	if(data!=null){
	   	    		for (var i = 0; i < 10; i++) {
		   	    		var acceso = data[i];
		   	    		htmlTabla += 
		   	    			"<tr class='fila_seleccionada' id='tr_selecc_"+acceso.item+"'>"+
		   		    			"<td>"+acceso.item+"</td>"+
		   		    			"<td>"+acceso.componente.descripcion+"</td>"+
		   		    			"<td>";
								    if(acceso.flgAsignado=='1'){
								    	htmlTabla +="<input type='checkbox' value='"+acceso.codigo+"' id='"+acceso.componente.codigo+"' checked='checked' />";
								    }else{
								    	htmlTabla +="<input type='checkbox' value='"+acceso.codigo+"' id='"+acceso.componente.codigo+"' />";
								    }
						htmlTabla +=
								"</td>"+
								"<td class='btn-bqd-submenu'>"+
		                            "<button type='button'"+ 
		                            		"class='btn btn-outline-success btn-sm'"+ 
		                            		"data-toggle='tooltip'"+   
		                            		"data-original-title='Buscar'"+
		                            		"onclick='verSubMenu("+acceso.componente.codigo+","+acceso.item+")'>"+ 
		                            		"<i class='ft-search'></i>"+ 
		                            "</button>"+
	                            "</td>"+
		   			    	"</tr>";
		   			}
	   	    		
	   	    		$('#idBodyTablaMenus').empty();
		   	    	$('#idBodyTablaMenus').html(htmlTabla);
		   	    	$('#idRowButtonSaveOnlyMenu').css('display','block');
	   	    	}
	   	    	
           },
		   error: function(xhr,status,er) {
			   msg_error();
			   //console.log("error: " + xhr + " status: " + status + " er:" + er);
			   if(xhr.status==500) {
				   //console.log(er);
			 //    Error_500(er);
			   }
			   if(xhr.status==901) {
				   //console.log(er);
		    //	   spire_session_901(er);
    		   }
		   },
		   complete: function(){
			   $('#contentSubMenuTabla').empty();
			   finBloqueo();
		   }
         });
    return false;
}