var validate = false;
function guardarGenericoTabsInstitucion(contextController, idForm){
    
	
	var actionForm = $(idForm).attr("action");
	var url = contextController + actionForm;
	var tipo = 0;
	//console.log(idForm);
	
	if(idForm == '#frmActulizarDirector'){
		tipo = 1;
	}
	
	if(idForm == '#frmInsertarLengua'){
		
		tipo = 2;
	} 
	
	if (idForm == '#frmRegistroUbicacion') {
		
		tipo = 3;
	}
	console.log("tipo");
	console.log(tipo);
	iniciarBloqueo();
 	$.ajax({
           type: "POST",
           url:  url,
           
           data: $(idForm).serialize(),
           success: function(data)
           {
          	 console.log("data");
        	 console.log(data);
        	 //alert(data);
        	 finBloqueo();
        	 if (data == "3") {
				msg_advertencia("Seleccione un Director.")
			}if (data == "1") {
				msg_exito();
			}if (data == "0") {
				msg_advertencia("Registro ya existe.");
			}if(data == "4"){
				msg_advertencia("Seleccione una lengua.");
			}if (data == "5") {
				msg_advertencia("Existe lengua.");
			}

           },
			 error: function(xhr,status,er) {
			msg_error();
		     //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			 //   	Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console.log(er);
		    //	spire_session_901(er);
    			}
		    },
		    complete: function(){
		    	if(tipo==1){
		    		limpiarDatosDirector();
		    		listarDirectorInstitucion();
		    	}
		    	if(tipo==2){
		    		
		    		listarLenguaInstitucion();
		    		$("#codigoLengua").val('0');
		    	}
		    	if(tipo == 3){
		    		
		    	}
		    }
         });
    return false;
}

function limpiarDatoFormTabInst(idForm){
    $(idForm).find('input').each(function() {
      switch(this.type) {
         //case 'password':
         case 'text':
        	 $(this).val('');
             break;
         case 'hidden':
              $(this).val(0);
              break;
         case 'email':
             $(this).val('');
             break;
         
         //case 'checkbox':
         //case 'radio':
           //   this.checked = false;
      }
      
    });
    if(document.getElementById("situacionDirector") != undefined){
    	 
  	//  $('#situacionDirector').val(0); 
	  $('#situacionDirector').val("0");
    }
    $(idForm).find('textarea').each(function(){
        $(this).val('');
    });
//    
//    $(idForm).find('situacionDirector').each(function(){
//        $(this).val(0);
//    });
}
function limpiarDatosDirector() { 
	  $('#nombreDirectorSelecc').val("");
	  $('#codigo_director').val("0");
	  $('#codigoInstit_director').val("0");
	  $('#codigoPersona_director').val("0");
	  $('#urlDirector').val("");
	  $('#telefonoDirector').val("");
	  $('#correoDirector').val("");
	  $('#descripcionDirector').val("");
	  $('#situacionDirector').val("");		   
}

function refrescarListaInstDirector(){
	var codinstitucion = $('#codigoInstit_director').val();
	var contextPath = $('#contextPathUrl').val();
	var htmlTabla = "";
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/refrescarListaInstDirector?codigoInst="+codinstitucion,
	    success: function(response){
	    	//console.log(response);	
	    	if(response!=null && response.length>0){
	    		for (var i = 0; i < response.length; i++) { 

		    		var objInstDirector = response[i];
		    		htmlTabla += 
		    			"<tr>"+
			    			"<td>"+objInstDirector.fechaCreacion+"</td>"+
			    			"<td>"+objInstDirector.personaBean.nombreCompleto+"</td>"+
			    			"<td>"+
			    				"<i class='ft-map-pin media-left media-middle'></i>"+
			    				"<div class='media-body'>"+objInstDirector.urlWeb+"</div>"+
				    		"</td>"+
				    		"<td>"+objInstDirector.telefono+"</td>"+
				    		"<td>"+
				    			"<div class='mb-0'>"+
				    				"<i class='icon-envelope media-left media-middle'></i>"+
				    				"<div class='media-body'>"+objInstDirector.correo+"</div>"+
				    			"</div>"+
				    		"</td>"+
				    		"<td>"+objInstDirector.descripcion+"</td>"+
				    		"<td>"+
					    		" <button id='idBtnEditarLengua' type='button' onclick='cargarDatosDirector("+objInstDirector.codigo+")'  class='btn btn-outline-success btn-sm' > <i class='icon-pencil'></i></button> "+
					    		"<a title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' href='eliminarDirector?codigo="+objInstDirector.codigo+"'><i class='icon-trash'></i></a>"+
				    			//"<button type='button' class='btn btn-outline-success btn-sm' data-toggle='tooltip' data-original-title='Editar' onclick='modificarInstitucionOperador("+objInstDirector.codigo+");'><i class='icon-pencil'></i></button>"+
				    		"</td>"+
		    		"</tr>";
				}
		    	//console.log(htmlTabla);
		    	$('#idBodyListaInstDirector').empty();
	  	    	$('#idBodyListaInstDirector').html(htmlTabla);
	    	}
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
	    	limpiarDatoFormTabInst('#frmActulizarDirector');
	    }
	  });
}

function refrescarListaInstLengua(){
	var codinstitucion = $('#codigoInstitucion').val();
	var contextPath = $('#contextPathUrl').val();
	var htmlTabla = "";
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/refrescarListaInstLengua?codigoInst="+codinstitucion,
	    success: function(response){
	    	//console.log(response);	
	    	if(response!=null && response.length>0){
	    		for (var i = 0; i < response.length; i++) {
		    		var objInstLengua = response[i];
		    		htmlTabla += 
		    			"<tr>"+
		    				"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
		    				"<td>"+objInstLengua.fechaCreacion+"</td>"+
				    		"<td>"+
					    		"<a title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' href='eliminarLengua?codigo="+objInstLengua.codigo+"'><i class='icon-trash'></i></a>"+
				    			//"<button type='button' class='btn btn-outline-success btn-sm' data-toggle='tooltip' data-original-title='Editar' onclick='modificarInstitucionOperador("+objInstDirector.codigo+");'><i class='icon-pencil'></i></button>"+
				    		"</td>"+
		    		"</tr>";
				}
		    	//console.log(htmlTabla);
		    	$('#idBodyListaInstLengua').empty();
	  	    	$('#idBodyListaInstLengua').html(htmlTabla);
	    	}
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
	    	$('#cboLenguaSelecInst').val(0);
	    }
	  });
}