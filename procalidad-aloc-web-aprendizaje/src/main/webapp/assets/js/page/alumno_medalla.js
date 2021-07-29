/**
 * Listado de alumno por medalla.
 */
function enviar_ajax_alumno_medalla(){
	var swListaVacia = true;
	var listado = [];
	
	var context  = $('#contextPathUrl').val();
	//alert(context);
	var url = context+'/cargaMaterialController/ListarAlumnoMedalla';
	
	$.ajax({
		 async: true,
		type : "GET",
		data : {codLengua : 0 },
		url  : url,
		success : function(data){
			
			if (data != null && data.length > 0) {
				swListaVacia = false;
				listado      = data;
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
	   complete : function(){
		   if (swListaVacia) {
			 //alert("lista vacia");
		}else{
			listarAlumnoMedalla(listado);
		}
	   }
	});
}

function listarAlumnoMedalla(lista){
	var html = '';
	var context  = $('#contextPathUrl').val();
	
	for (var i = 0; i < lista.length; i++) {
		var medallas = lista[i];
		
	}
}