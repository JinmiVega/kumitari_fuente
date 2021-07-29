function agregarInstitucionDirector() { 
	  $('#codigoInstit_director').val($('#codigoInstitucion').val());
	  var contextPath = $('#contextPathUrl').val();	  
	  $.ajax({
	    type: "GET",
	    url: contextPath+"/institucionController/nuevoInstDirector",
	    success: function(response){
	    	  $('#bootstrap3').modal('show');
	    	  $('#asignar_director_modal_body').empty();
	    	  $('#asignar_director_modal_body').html(response);
	    },error: function(xhr,status,er) {
             //console..log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console..log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console..log(er);
		    	//spire_session_901(er);
     			}

	    }
	  });
}
/*
function modificarInstitucionOperador(id) {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/modificarInstOperador?codigo="+id,
	    success: function(response){
	    	  $('#bootstrap2').modal('show');
	    	  $('#asignar_operador_modal_body').empty();
	    	  $('#asignar_operador_modal_body').html(response);
	    },error: function(xhr,status,er) {
           console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	console.log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	console.log(er);
		    	//spire_session_901(er);
   			}

	    }
	  });
}*/

function buscarPersonaPorDocumento() {
	  
	  var tipoDocumento   = $('#tipoDocumentoPersona_dato1').val();
	  var numeroDocumento = $('#numeroDocumentoPersona_dato1').val();
	  
	  var contextPath = $('#contextPathUrl').val();

	  $.ajax({
	    type: "GET",
	    url: contextPath+"/institucionController/consultarPorDocumentoPersona?tipo="+tipoDocumento+"&numero="+numeroDocumento,
	    success: function(response){ 
	    if(tipoDocumento==0 | tipoDocumento==null || tipoDocumento==undefined || tipoDocumento==""){
	    	msg_advertencia("Debe seleccionar un tipo de documento.");
	    } else if (numeroDocumento.length == 0 ) {
	  		msg_advertencia("No se ingresó el número de documento.");
	  	 }else if (numeroDocumento.length < 7 ) {
	  		msg_advertencia("Número de documento incorrecto.");
	  	 }else{
	    	  if(response.codigo > 0){ 
	    		 // alert(response.nombrePersona)
	    		  $('#codigoPersonaDirector_dato').val(response.codigo);
	    		  $('#nombresPersona_dato').val(response.nombrePersona+" "+response.apellidoPaterno+" "+response.apellidoMaterno);
	    		  $('#telefonoPersona_dato').val(response.telefono);
	    		  $('#correoPersona_dato').val(response.correo);
	    	  }else{
	    		  msg_advertencia("¡No se encontraron registros.!")
	    	  }
	  	 }
	    },error: function(xhr,status,er) {
         //console..log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console..log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console..log(er);
		    	//spire_session_901(er);
 			}

	    }
	  });
}

function asignarDirectorBuscado() {
	 var codigo = document.getElementById("codigoPersonaDirector_dato").value;
	 if(codigo > 0){
			$('#nombreDirectorSelecc').val($('#nombresPersona_dato').val()); 
			$('#codigoPersona_director').val(codigo); 
			$('#bootstrap3').modal('hide');
	 }else{
		 msg_advertencia("No ha seleccionado director");
	 } 

}

/*
function enviar_ajax(){

	var url = $("#frmGuardarInstOperador").attr("action");

 	$.ajax({
           type: "POST",
           url: url,
           data: $("#frmGuardarInstOperador").serialize(),
           success: function(data)
           {
        	   msg_exito();
           },
			error: function(xhr,status,er) {
				msg_error();
		     console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	console.log(er);
			 //   	Error_500(er);
			    }
			    if(xhr.status==901) {
		    	console.log(er);
		    //	spire_session_901(er);
    			}
		    },
		    complete: function(){
		    	$("#closeModalBtnFrm").trigger("click");
		    	refrescarListaInstOperador();
		    }
         });
    return false;
}

function refrescarListaInstOperador() {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  var htmlTabla = "";
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/refrescarListaInstOperador?codigoInst="+codigoInstitucion,
	    success: function(response){
	    	//console..log(response);	
	    	for (var i = 0; i < response.length; i++) {
	    		htmlTabla += 
	    			"<tr>"+
		    			"<td>"+i.personaBean.nombreCompleto+"</td>"+
		    			"<td>"+i.personaBean.codigoInstitucion+"</td>"+
		    			"<td>"+i.personaBean.personaBean.numeroDocumento+"</td>"+
		    			"<td>"+
			    			"<div class='mb-0'>"+
			    				"<i class='icon-envelope media-left media-middle'></i>"+
			    				"<div class='media-body'>"+i.personaBean.correo+"</div>"+
			    			"</div>"+
			    		"</td>"+
			    		"<td>"+i.personaBean.fechaCreacion+"</td>"+
			    		"<td>"+i.personaBean.nombreSituacion+"</td>"+
			    		"<td>"+
			    			"<button type='button' class='btn btn-outline-success btn-sm' data-toggle='tooltip' data-original-title='Editar' onclick='modificarInstitucionOperador("+i.codigo+");><i class='icon-pencil'></i></button>"+
			    		"</td>"+
	    		"</tr>";
			}
	    	//console..log(htmlTabla);
    	    $('#idBodyListaInstOperador').empty();
    	    $('#idBodyListaInstOperador').html(htmlTabla);
	    },error: function(xhr,status,er) {
           //console..log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console..log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    	//console..log(er);
		    	//spire_session_901(er);
   			}

	    }
	  });
}
*/