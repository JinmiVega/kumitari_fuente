function agregarInstitucionSede() {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  
	  $.ajax({
	    type: "GET",
	    url: contextPath+"/institucionController/nuevoInstSede",
	    success: function(response){
	    	  $('#bootstrap').modal('show');
	    	  $('#asignar_sede_modal_body').empty();//vacia todo
	    	  $('#asignar_sede_modal_body').html(response);//carga todo
	    	  $('#codigoInstitucion_instsede').val(codigoInstitucion);
	    },error: function(xhr,status,er) {
             //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);
			    }
			    if(xhr.status==901) {
		    	//console.log(er);

     			}

	    }
	  });
}

function modificarInstitucionSede(id) {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  iniciarBloqueo();
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/modificarInstSede?codigo="+id,
	    success: function(response){
	    	  $('#bootstrap').modal('show');
	    	  $('#asignar_sede_modal_body').empty();
	    	  $('#asignar_sede_modal_body').html(response);
	    },error: function(xhr,status,er) {
           //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);

			    }
			    if(xhr.status==901) {
		    	//console.log(er);

   			}

	    },
        complete: function(data) {
        	finBloqueo();
        }
	  });
}
function eliminarInstitucionSede(id) {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/eliminarSede?codigo="+id,
	    success: function(response){
			//console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
	    	msg_exito();

	    	
	    	
	    },error: function(xhr,status,er) {
         //console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	//console.log(er);

			    }
			    if(xhr.status==901) {
		    	//console.log(er);

 			}

	    },
	    complete: function(){
	    	$("#closeModalBtnFrmInstSede").trigger("click");
	    	listarInstSede();
	    }
	  });
}


//function buscarPersonaPorDocumentoOperador() {
//	
//	  var tipoDocumento   = $('#tipoDocPersona_busqdato').val();
//	  var numeroDocumento = $('#numDocPersona_busqdato').val();
//	
//	  var codigoInstitucion = $('#codigoInstitucion').val();
//	  var contextPath = $('#contextPathUrl').val();
//	  
//	  $.ajax({
//	    type: "GET",
//	    //data: "entidad=" + entidad,
//	    url: contextPath+"/institucionController/consultarPorDocumentoPersona?tipo="+tipoDocumento+"&numero="+numeroDocumento,
//	    success: function(response){
//	    	  if(response!=null){
//	    		  $('#codigoPersona_instope').val(response.codigo);
//	    		  $('#nombresPersona_dato').val(response.nombrePersona+" "+response.apellidoPaterno+" "+response.apellidoMaterno);
//	    		  $('#telefonoPersona_dato').val(response.telefono);
//	    		  $('#correoPersona_dato').val(response.correo);
//	    	  }else{
//	    		  alert("No se encontró")
//	    	  }
//	    },error: function(xhr,status,er) {
//         console.log("error: " + xhr + " status: " + status + " er:" + er);
//			    if(xhr.status==500) {
//			    	console.log(er);
//			    	//Error_500(er);
//			    }
//			    if(xhr.status==901) {
//		    	console.log(er);
//		    	//spire_session_901(er);
// 			}
//
//	    }
//	  });
//}

function enviar_ajax_sede(){

	var url = $("#frmGuardarInstSede").attr("action");

 	$.ajax({
           type: "POST",
           url: url,
           data: $("#frmGuardarInstSede").serialize(),
           success: function(data)
           {   
        	  
        	  if (data == "1"){
        		msg_exito();
			} if(data == "0") {
				msg_advertencia("Registro ya existe.");
			} if(data == "3"){
				msg_advertencia("Seleccione una ubicación valida.")
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
		    	$("#closeModalBtnFrmInstSede").trigger("click");
		    	listarInstSede();
		    }
         });
    return false;
}

function refrescarListaInstSede() {
	  
	  var codigoInstitucion = $('#codigoInstitucion').val();
	  var contextPath = $('#contextPathUrl').val();
	  var htmlTabla = "";
	  
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	    url: contextPath+"/institucionController/refrescarListaInstSede?codigoInst="+codigoInstitucion,
	    success: function(response){
	    	//console.log(response);	
	    	for (var i = 0; i < response.length; i++) {
	    		var objInstSede = response[i];
	    		htmlTabla += 
	    			"<tr>"+
		    			"<td>"+objInstSede.nombreSede+"</td>"+
		    			"<td>"+
		    			      "<div class='mb-0'>"+
		    			      "<i class='ft-map-pin media-left media-middle'></i>"+
		    			      "<div class='media-body'>"+objInstSede.ubigeoRegionBean.nombreUbigeo+"/"+
		    			      objInstSede.ubigeoProvinBean.nombreUbigeo+"/"+objInstSede.ubigeoDistriBean.nombreUbigeo+"<br>"+
		    			      objInstSede.direccionInstitucion+
		    			      "</div>"+
		    			      "</td>"+
		   
		    			"<td>"+
		    				 "<div class='mb-0'>"+
		    				 "<i class='ft-map-pin media-left media-middle'></i>"+
		    				 "<div class='media-body'>"+objInstSede.telefono+
		    				 "</div>"+
		    				 "<div class='mb-0'>"+
		    				 "<i class='icon-envelope media-left media-middle'></i>"+
		    				 "<div class='media-body'>"+objInstSede.correo+
		    				 "</div>"+
		    				 "<div class='mb-0'>"+
		    				 "<i class='ft-info media-left media-middle'></i>"+
		    				 "<div class='media-body'>"+objInstSede.contacto+
		    				 "</div>"+	    				 
		    				 "</td>"+
		    				 
				    	"<td>"+
				    			"<button type='button' class='btn btn-outline-success btn-sm' data-toggle='tooltip' data-original-title='Editar' onclick='modificarInstitucionSede("+objInstSede.codigo+");'><i class='icon-pencil'></i></button>"+
				    			"<button type='button' class='btn btn-outline-danger btn-sm' data-toggle='tooltip' data-original-title='Eliminar' onclick='confirmar_eliminar("+objInstSede.codigo+");'><i class='icon-trash'></i></button>"+
				    	"</td>"+
	    		"</tr>";
			}
	    	//console.log(htmlTabla);
    	    $('#idBodyListaInstSede').empty();
    	    $('#idBodyListaInstSede').html(htmlTabla);
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

	    }
	  });
}