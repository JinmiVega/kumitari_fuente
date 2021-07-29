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

	    		  htmlTitulo = htmlTitulo + icono_titulo
						  +"<h4 class='sub-title-app'>"+data[0].materialTipoEjercicioBean.titulo+"</h4>" +
			  		"<p class='title-minendu ttpregunta' id='title-preg'>"+data[0].ordenarParrafoCabeceraBean.titulo+"</p>";
	    		//console.log(htmlTitulo);
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
		if (orden[int] == z) {
			document.getElementById(orden[int]).style.border="2px dashed green";
		}else{
			document.getElementById(orden[int]).style.border="2px dashed red";
		}z++;
	}
    var p_int1 = $("#intento1").val();
    var p_int2 = $("#intento2").val();
    var p_int3 = $("#intento3").val();
    var p_evalDt = $('#codEvaluacionDet').val();
	if (cadena == num.toString()) {

		resultado = resultado + 1;
		show_msj_masc_exito($("#msj_1").val());
//			show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
			//alert("Reto cumplido.");
			if(numerodeintento == 1){ 
				guardarMonedas(p_int1,0); 
			   	   grabarSeguimientoAlumnoEjercicio(p_int1); 
			   	 }else if(numerodeintento==2){
			   		guardarMonedas(p_int2,0); 
			   	     grabarSeguimientoAlumnoEjercicio(p_int2); 
			   	 } else if (numerodeintento==3){
			   		 guardarMonedas(p_int3,0);
			   	    grabarSeguimientoAlumnoEjercicio(p_int3); 
			   	 } else { 
			   	    grabarSeguimientoAlumnoEjercicio(0);  
			   	 }
		 
			//location.href =$("#urlSiguiente").val();
			siguiente_ejercicio();
		 

	}else{
		insertarIntento();
		 show_msj_masc_fallo($("#msj_2").val());
//		 show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
		//alert("Vuelve a intentarlo");
	}

}
