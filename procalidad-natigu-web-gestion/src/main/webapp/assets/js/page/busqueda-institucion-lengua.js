function buscarLenguaxInstitucion(){

		var id = $("#lblInstitu").val();
	

		document.getElementById("lblLengua").options[document.getElementById("lblLengua").innerHTML=""];
		document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option("Seleccionar", "");
		iniciarBloqueo();
	$.ajax({
		type : "GET",

		url : "../matriculaController/LenguaxInstitucion?codigoinst="+id,

		success : function(data) {
			//console.log("SUCCESS: ", data);


			for(var i=0; i<data.length;i++){

				document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option(data[i].lenguaBean.nombre, data[i].lenguaBean.codigo);

				}
		},
		error : function() {
			//console.log("ERROR: ");
		},
	    complete: function(){
	    	finBloqueo();
        }
	});


}
//////////TIPO 2/////////
function buscarLenguaxInstituciontipo2(){

	var id = $("#lblInstitu").val();


	document.getElementById("lblLengua").options[document.getElementById("lblLengua").innerHTML=""];
	document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option("Seleccionar", "0");
	iniciarBloqueo();
	$.ajax({
	type : "GET",

	url : "../matriculaController/LenguaxInstitucion?codigoinst="+id,

	success : function(data) {
		//console.log("SUCCESS: ", data);


		for(var i=0; i<data.length;i++){

			document.getElementById("lblLengua").options[document.getElementById("lblLengua").options.length]=new Option(data[i].lenguaBean.nombre, data[i].lenguaBean.codigo);

			}
	},
	error : function() {
		//console.log("ERROR: ");
	},
    complete: function(){
    	finBloqueo();
    }
});


}

/**
 * 
 */
function limpiarFiltros(form){
	$(form+" input[type='text']").val("");
	$(form+" input[type='date']").val("");
	$(form+" .select-del").prop('selectedIndex',0);
	  
}

function cargarNivelesInscMatri(){
	var idLengua = $('#lblLengua').val();
	//var contextPath = $('#contextPathUrl').val();

	var html = "";
	
	if(idLengua!='0'){
		iniciarBloqueo();
		$.ajax({
			type: "GET",
			data: "codigolengua="+idLengua,
		 	url: "../matriculaController/nivelXLengua",
		 success: function(data)
      {		
			
 	    	if(data!=null){
 	    		
 	    		data.sort(function (a, b){
 	    		    return (a.codigoRegistro - b.codigoRegistro);
 	    		});
 	    		
 	    		html+="<option value=''>Todos</option>";
 	    		for(var i=0; i<data.length;i++){
 	    			html+="<option value='"+data[i].nivel.codigoRegistro+"'>"+data[i].nivel.nombreCorto+"</option>";
				}
 	    	}else{
 	    		html+="<option value=''>Todos</option>";
 	    	}
 	    	
      },
		   error: function(xhr,status,er) {
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
			   finBloqueo();
			   $('#lblNivel').empty();
			   $('#lblNivel').html(html);
		   }
    });
}else{
	html = "<option value='0'>Todos</option>";
	$('#lblNivel').empty();
	$('#lblNivel').html(html);
	
}

}

 
