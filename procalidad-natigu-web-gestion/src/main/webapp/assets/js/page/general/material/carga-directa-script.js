/*function time_contador() {
    
  setTimeout(function(){
        for (var i = 0; i < 30; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
        $("#pf_01").show();
     }, 1500);

    setTimeout(function(){
        for (var i = 0; i < 60; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
        $("#pf_02").show();
     }, 3000);


    setTimeout(function(){
        for (var i = 0; i < 90; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
        $("#pf_03").show();
     }, 4500);

    setTimeout(function(){
        for (var i = 0; i < 101; i++) {
             $("#barra_carga").attr("value",[i]);
            //Do something
        }
     }, 5500);

}*/

/*$( "#generar-archivo" ).click(function() {
     var cmm_lengua    = $('#cmm_lengua').val();
     var cmm_nivel     = $('#cmm_nivel').val();
     var cmm_sub_nivel = $('#cmm_sub_nivel').val();
     var cmm_unidades  = $('#cmm_unidades').val();

    $('#cmm_info_leng').text(cmm_lengua);
    $('#cmm_info_nivel').text(cmm_nivel);
    $('#cmm_info_s_nivel').text(cmm_sub_nivel);
    $('#cmm_info_unidades').text(cmm_unidades);

    $('#cmm_descarga').removeClass("hidden").show(300);
});*/
/*
function mmr_limpiar(){
  $('#cmm_descarga').addClass("hidden").hide(300);
  
  var html = "<option value='0'>Todos</option>";
  $('#cmm_lengua').val('0');
  $('#cmm_nivel').empty();
  $('#cmm_nivel').html(html);
  $('#cmm_sub_nivel').empty();
  $('#cmm_sub_nivel').html(html);
  $('#idDivContSelecUnidad').css('display', 'none');
  $('#cmm_unidades').val('0');
  $('#generar-archivo').prop('disabled',false);
}
*/

/** IMPLEMENTACION **/
function cargarNiveles(){
  var idLengua = $('#cboLengua').val();
  var contextPath = $('#contextPathUrl').val();
  var html = "";

  if(idLengua!='0'){
    $.ajax({
      type: "GET",
      data: "codlengua="+idLengua,
        url: contextPath+"/cargaMaterialController/cargarNiveles",
          success: function(data)
          { 
            if(data!=null && data.length>0){
              
              data.sort(function (a, b){
                  return (a.codigoRegistro - b.codigoRegistro);
              });
              
              html+="<option value='0'>Todos</option>";
              for(var i=0; i<data.length;i++){
                html+="<option value='"+data[i].codigoRegistro+"'>"+data[i].nombreCorto+"</option>";
          }
            }else{
              html+="<option value='0'>Seleccione</option>";
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
           $('#cboNivel').empty();
           $('#cboNivel').html(html);
           $('#cboSubNivel').empty();
           $('#cboSubNivel').html("<option value='0'>Seleccione</option>");
           $('#cboUnidad').empty();
           $('#cboUnidad').html("<option value='0'>Seleccione</option>");
         }
        });
  }else{
    html = "<option value='0'>Todos</option>";
    $('#cboNivel').empty();
    $('#cboNivel').html(html);
    $('#cboSubNivel').empty();
    $('#cboSubNivel').html(html);
    $('#idDivContenidoSeleccionarUnidades').css('display', 'none');
    $('#cboUnidad').val('0');
  }
  
}

function cargarSubNiveles(){
  var idLengua = $('#cboLengua').val();
  var idNivel  = $('#cboNivel').val();
  var contextPath = $('#contextPathUrl').val();
  var html = "";
  
  $.ajax({
    type: "GET",
    data: "codlengua="+idLengua+"&codnivel="+idNivel,
      url: contextPath+"/cargaMaterialController/cargarSubNiveles",
        success: function(data)
        { 
          if(data!=null && data.length>0){
             //console.log("data cargarSubNiveles" +data);
            data.sort(function (a, b){
                return (a.codigoRegistro - b.codigoRegistro);
            });
            
            html += "<option value='0'>Seleccione</option>";
        for (var i = 0; i < data.length; i++) {
          html += "<option value='" + data[i].codigo + "'>"
              + data[i].subNivel.nombreCorto + "</option>";
        }
          }else{
            //console.log("data null"  );
            html+="<option value='0'>Todos</option>";
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
         $('#cboSubNivel').empty();
         $('#cboSubNivel').html(html);
         $('#cboUnidad').empty();
         $('#cboUnidad').html("<option value='0'>Seleccione</option>");
       }
    });
}


function cargarUnidades(){ 
  var idSubNivel   = $('#cboSubNivel').val();
  var contextPath = $('#contextPathUrl').val();
  var html = "";
 
  $.ajax({
    type: "GET",
    data: "codlenest="+idSubNivel ,
      url: contextPath+"/cargaMaterialController/cargarUnidades",
        success: function(data)
        { 
          
          if(data!=null && data.length>0){
             //console.log("data cargarUnidades" +data);
            data.sort(function (a, b){
                return (a.codigoRegistro - b.codigoRegistro);
            });
            
            html += "<option value='0'>Seleccione</option>";
        for (var i = 0; i < data.length; i++) {
          html += "<option value='" + data[i].codigo + "'>"
              + data[i].unidad.nombreCorto + "</option>";
        }
          }else{
            //console.log("data null"  );
            html+="<option value='0'>Seleccione</option>";
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
         $('#cboUnidad').empty();
         $('#cboUnidad').html(html);
       }
    });
}

/** IMPLEMENTACION MODAL**/
function cargarModalNiveles(){
  limpiarContenidoModalInit();	
  var idLengua = $('#cboLenguazzz').val();
  var contextPath = $('#contextPathUrl').val();
  var idNivel  = $('#cboNivel').val();
  var html = "";

  if(idLengua!='0'){
	  $('modalTxtIdLengua').val(idLengua);
	iniciarBloqueo();
	$.ajax({
      type: "GET",
      data: "codlengua="+idLengua,
        url: contextPath+"/cargaMaterialController/cargarNiveles",
          success: function(data)
          { 
            if(data!=null && data.length>0){
              
              data.sort(function (a, b){
                  return (a.codigoRegistro - b.codigoRegistro);
              });
              
              html+="<option value='0'>Seleccione</option>";
              for(var i=0; i<data.length;i++){
                html+="<option value='"+data[i].codigoRegistro+"'>"+data[i].nombreCorto+"</option>";
          }
            }else{
              html+="<option value='0'>Seleccione</option>";
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
           $('#modalCboNivel').empty();
           $('#modalCboNivel').html(html);
           $('#modalCboSubNivel').empty();
           $('#modalCboSubNivel').html("<option value='0'>Seleccione</option>");
           $('#modalCboUnidad').empty();
           $('#modalCboUnidad').html("<option value='0'>Seleccione</option>");
           //$('#modalCboNivel').val(idNivel);
         }
        });
  }else{
    html = "<option value='0'>Seleccione</option>";
    $('#modalCboNivel').empty();
    $('#modalCboNivel').html(html);
    $('#modalCboSubNivel').empty();
    $('#modalCboSubNivel').html(html);
    $('#modalCboUnidad').empty();
	$('#modalCboUnidad').html(html);
//    $('#idDivContenidoSeleccionarUnidades').css('display', 'none');
//    $('#modalCboSubNivel').val(idNivel);
  }
  
}

function cargarModalSubNiveles(){ 
  limpiarContenidoModalInit();
  var idLengua = $('#cboLenguazzz').val();
  var idNivel  = $('#modalCboNivel').val();
  var idSubNivel   = $('#cboSubNivel').val();
  var contextPath = $('#contextPathUrl').val();
  var html = "";
  
  if(idNivel!='0'){
	  iniciarBloqueo();
	  $.ajax({
	    type: "GET",
	    data: "codlengua="+idLengua+"&codnivel="+idNivel,
	      url: contextPath+"/cargaMaterialController/cargarSubNiveles",
	        success: function(data)
	        { 
	          if(data!=null && data.length>0){
	             //console.log("data cargarSubNiveles" +data);
	            data.sort(function (a, b){
	                return (a.codigoRegistro - b.codigoRegistro);
	            });
	            
	            html += "<option value='0'>Seleccione</option>";
	        for (var i = 0; i < data.length; i++) {
	          html += "<option value='" + data[i].codigo + "'>"
	              + data[i].subNivel.nombreCorto + "</option>";
	        }
	          }else{
	            //console.log("data null"  );
	            html+="<option value='0'>Seleccione</option>";
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
	         $('#modalCboSubNivel').empty();
	         $('#modalCboSubNivel').html(html);
	         $('#modalCboUnidad').empty();
	         $('#modalCboUnidad').html("<option value='0'>Seleccione</option>");
	        // $('#modalCboSubNivel').val(idSubNivel);
	       }
	    });
  }else{
	  html = "<option value='0'>Seleccione</option>";
	    $('#modalCboSubNivel').empty();
	    $('#modalCboSubNivel').html(html);
	    $('#modalCboUnidad').empty();
		$('#modalCboUnidad').html(html);
  }

}
function cargarModalUnidades(){
	$('#modalCboUnidad').empty();
    $('#modalCboUnidad').html("<option value='0'>Seleccione</option>");	
  limpiarContenidoModalInit();
  var idSubNivel   = $('#modalCboSubNivel').val();
  var idUnidad  = $('#cboUnidad').val();
  var contextPath = $('#contextPathUrl').val();
  var html = "";
  iniciarBloqueo();
  $.ajax({
    type: "GET",
    data: "codlenest="+idSubNivel ,
      url: contextPath+"/cargaMaterialController/cargarUnidades",
        success: function(data)
        { 
          
          if(data!=null && data.length>0){
             //console.log("data cargarUnidades" +data);
            data.sort(function (a, b){
                return (a.codigoRegistro - b.codigoRegistro);
            });
            
            html += "<option value='0'>Seleccione</option>";
        for (var i = 0; i < data.length; i++) {
          html += "<option value='" + data[i].codigo + "'>"
              + data[i].unidad.nombreCorto + "</option>";
        }
          }else{
            //console.log("data null"  );
            html+="<option value='0'>Seleccione</option>";
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
         $('#modalCboUnidad').empty();
         $('#modalCboUnidad').html(html);
         //$('#modalCboUnidad').val(idUnidad);
       }
    });
}

function limpiarContenidoModalInit(){
	tipoEjerActualSel = 0;
	$("#idBodyTablaMenus .fila_seleccionada_text").css("color", "");
	$("#idBodyTablaMenus .fila_seleccionada").css("background-color", "");
	$('#modalCboLeccion').empty();
    $('#modalCboLeccion').html('<option value="0">Seleccione</option>');
    $('#modalCboMaterial').empty();
    $('#modalCboMaterial').html('<option value="0">Seleccione</option>');
    $('#content-md-frm').empty();
}

function cargarComboLeccionesXUnidad(){
	//debugger;
	var arrayLeccion = [];
	
    $("#md_table-lecccion tbody tr").each(function (index) 
    {
    	var objLeccion = {
	  		codigo : 0,
	  		nombre : ''
	  	};	
    	
    	objLeccion.codigo = $(this).attr('id');
    	
        $(this).children("td").each(function (index2) 
        {
        	if(index2 == 1 ){ // Columna Nombre
        		objLeccion.nombre    = $(this).text();
        	}
        })
        arrayLeccion.push(objLeccion);
    })
	//console.log(arrayLeccion);
    var html = "";
    if(arrayLeccion!=null && arrayLeccion.length>0){
    	html += "<option value='0'>Seleccione</option>";
        for (var i = 0; i < arrayLeccion.length; i++) {
          html += "<option value='" + arrayLeccion[i].codigo + "'>"
              + arrayLeccion[i].nombre + "</option>";
        }
    }else{
    	html = "<option value='0'>Seleccione</option>";
    }
    $('#modalCboLeccion').empty();
    $('#modalCboLeccion').html(html);
    $('#modalCboMaterial').empty();
    $('#modalCboMaterial').html('<option value="0">Seleccione</option>');
}

/**
function cargarUnidades(){
  var idLengua = $('#cboLengua').val();
  var idNivel  = $('#cboNivel').val();
  var idSubNivel  = $('#cboSubNivel').val();

  if(idSubNivel!='0'){
    $('#cboUnidad').val('0');
    $('#idDivContenidoSeleccionarUnidades').css('display', 'block');
  }else{
    $('#idDivContenidoSeleccionarUnidades').css('display', 'none');
    $('#cboUnidad').val('0');
  }
}
*/
/** GENERACION DE ARCHIVO **/
/*
function generarArchivo(){
    var cmm_lengua    = $('#cmm_lengua').val();
    var cmm_nivel     = $('#cmm_nivel').val();
    var cmm_sub_nivel = $('#cmm_sub_nivel').val();
    var cmm_unidades  = $('#cmm_unidades').val();
    var contextPath   = $('#contextPathUrl').val();
  var html = "";
  
  if(cmm_lengua=='0'){
    msg_advertencia("Debe seleccionar una lengua");
    return false;
  }
  
  if(cmm_nivel=='0'){
    msg_advertencia("Debe seleccionar un nivel");
    return false;
  }
  
  if(cmm_sub_nivel=='0'){
    msg_advertencia("Debe seleccionar un subnivel");
    return false;
  }
  
  if(cmm_unidades=='0'){
    msg_advertencia("Debe seleccionar una unidad");
    return false;
  }
  
  iniciarBloqueo();
  $.ajax({
    type: "GET",
    data: "codlengua="+cmm_lengua+"&codnivel="+cmm_nivel+"&codsubnivel="+cmm_sub_nivel+"&codunidad="+cmm_unidades,
      url: contextPath+"/cargaMasivaController/generarArchivo",
        success: function(data)
        { 
          msg_exito();
          $('#generar-archivo').prop('disabled',true);
          
          $('#detalle-archivo-generado').empty();
        $('#detalle-archivo-generado').html(data);
          
        },
      error: function(xhr,status,er) {
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
        finBloqueo();
        
        $('#cmm_info_leng').text($("#cmm_lengua option:selected").text());
        $('#cmm_info_nivel').text($("#cmm_nivel option:selected").text());
        $('#cmm_info_s_nivel').text($("#cmm_sub_nivel option:selected").text());
        $('#cmm_info_unidades').text($("#cmm_unidades option:selected").text());

        $('#cmm_descarga').removeClass("hidden").show(300);
      }
    });
}

function subirArchivoCarga(){
  
  var file = $('#basicInputFile').val();
  //console.log(file);
  if (!file) { 
    msg_info('No se ha seleccionado ningún archivo');
  }else{ 
    var extension = (file.substring(file.lastIndexOf("."))).toLowerCase(); 
    
    if(extension!='.xls'){
      msg_advertencia('Comprueba la extensión del archivo a subir. Sólo se pueden subir archivos excel');
    }else{
      $('#idFormSubirCargaMasiva').submit();
      //ejecutar_post_subir();
    } 
  }
}

function ejecutar_post_subir(){
  
  $.ajax({
           type: 'POST',
           url : $('#idFormSubirCargaMasiva').attr('action'),
           data: $('#idFormSubirCargaMasiva').serialize(),
           success: function(data)
           { 
              msg_exito();
           },
      error: function(xhr,status,er) {
        msg_error();
         //console.log("error: " + xhr + " status: " + status + " er:" + er);
          if(xhr.status==500) {
            //console.log(er);
       //     Error_500(er);
          }
          if(xhr.status==901) {
          //console.log(er);
        //  spire_session_901(er);
          }
        },
        complete: function(){
          
        }
         });
    return false;
}
*/