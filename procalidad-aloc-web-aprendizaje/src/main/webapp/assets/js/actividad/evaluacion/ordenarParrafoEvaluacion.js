/** Ordenar Parrafo **/
 var contextPath = $('#contextPathUrl').val();
 var  numEjercicio = 0;

 /*Codigos  */
 var mteCodigos = [];
 var parrafcab = [];
 var tamanoPReg= [];

 /** Número de  intentos **/ 
 
 function listarParrafos(){
	 var codmte =  $('#codigoMTE').val();
	 var url =  contextPath+"/lengua/listarParrafos";
	 var htmlTitulo = "";
	 var htmlParrafo = "";
	    $.ajax({
	          async: true,
	        type : 'GET',
	        data :{p_codmatpej : codmte },
	        url : url,
	      success : function(data)
	      {
	    	  if (data != null) {

	    		  htmlTitulo = htmlTitulo + "<i class='icon-pencil pull-left pencil-styel'></i>"
						  +"<h4 class='sub-title-app'>"+data[0].materialTipoEjercicioBean.titulo+"</h4>" +
			  		"<p class='title-minendu ttpregunta' id='title-preg'>"+data[0].ordenarParrafoCabeceraBean.titulo+"</p>";
	    		  document.getElementById("tituloOrdenarParrafo").innerHTML=htmlTitulo;
	    		  htmlParrafo = "<ul id='sortable'>";
	    		  for (var int = 0; int < data.length; int++) {
	    			  htmlParrafo  = htmlParrafo +"<li class='ui-state-default' id='"+data[int].numeroOrden+"'>"+data[int].parrafo+"</li>";
				}
	    		  htmlParrafo=htmlParrafo+"</ul>";
	    		  document.getElementById("parrafos").innerHTML=htmlParrafo;

	    			    $( "#sortable" ).sortable({
	    			      revert: true
	    			    });
	    			    $( "#draggable" ).draggable({
	    			      connectToSortable: "#sortable",
	    			      helper: "clone",
	    			      revert: "invalid"
	    			    });
	    			    $( "ul, li" ).disableSelection();

			}else{

			}

	      },
	      error : function(data) {
	    	//console.log("error ");
	      }
	    });
 }

/**
 * Validacion de ordenar  parrafo.
 */
 
 var resultado = 0;
function validarOrdenParrafo(){
	var i = 0;
	var orden = new Array();
	var num = 0;
	var j = 1;
	$("#sortable li").each(function(){

		orden[i] = $(this).attr('id');

		num = num +""+j++;
		i++;
   	});
	var cadena = "0";
	var z = 1;
	for (var int = 0; int < orden.length; int++) {
		cadena = cadena+""+orden[int];

	}
	var codEvaDe =$('#codEvaluacionDet').val();

	if (cadena == num.toString()) {		 
		actulizarEjercicioEvaluacion(codEvaDe,'1');
		$('#codEvaluacionDet').val('0');
	}else{
		actulizarEjercicioEvaluacion(codEvaDe,'0');
		$('#codEvaluacionDet').val('0');
		//alert("Vuelve a intentarlo");
	}

}
