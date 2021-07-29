var context  = $('#contextPathUrl').val();
var arreglo = [];
var  punto = 0;
var codigoMaterial = $("#codigoMaterialActual").val();


//$('#btnevaluar').addClass('disabled');

$('#btn_validar_ejercicio').attr("disabled", true);
// $('#btn_validar_ejercicio').addClass('disabled'); 
 //$('#btn_validar_ejercicio').attr("disabled", true);


$(".tabs_elements").each(function(){
    arreglo.push($(this).attr('id'));
});

//console.log(arreglo);
const array=arreglo;

let leer_tab= esUltimaPregunta==1 ? (arreglo.length-1) : 0;
let tab_m=0;
let tabs = arreglo[leer_tab];

$(".tabs_elements").css("display","none");
$("#"+tabs).css("display","");

function nextBtn(){ 
	$('#pagination-leccion ul li .opt-before-exercise').attr('href','#');

	$('#btn_validar_ejercicio').attr("disabled", true);

//	 $('#btn_validar_ejercicio').addClass('disabled'); 
//	 $('#btn_validar_ejercicio').attr("disabled", true);


	leer_tab++;
	tab_m--;
	tabs = arreglo[leer_tab];
	//console.log(tabs);
	if (arreglo[leer_tab]) {		
		$(".tabs_elements").css("display","none");
		$("#"+tabs).css("display","");
	}else{
		$('#btn_validar_ejercicio').attr("disabled", false);
		valorEvaluacion();
		
//		siguiente_ejercicio();
	}
}

function beforeBtn(){
	$('#pagination-leccion ul li .opt-before-exercise').attr('href','#');
	
	$('#btn_validar_ejercicio').attr("disabled", true);
//	$('#btnevaluar').addClass('disabled');
	
//	hide_msj_mascota();
//	resetImgMascota(1);// Regresar la mascota inicial
	leer_tab--;
	tabs = arreglo[leer_tab];
	if (arreglo[leer_tab]) {
		$(".tabs_elements").css("display","none");
		$("#"+tabs).css("display","");
	}else{
		if(leer_pos == 0){
			$('#pagination-leccion ul li .opt-before-exercise').attr('href',context+'/lengua/deprimerejercicioamaterial/'+codlengua+'/'+codlenest+'/'+codunidad+'/'+codleccion);
		}else{
			anterior_ejercicio();
		}
	}
}

 function validarPregunta(){
 	var valItem = $('.tabs_elements input:radio[name=Oneradio]:checked').val();
 	var valID = $('.tabs_elements input:radio[name=Oneradio]:checked').attr(id);

	if( $(valID+ "input:radio[name=Oneradio]:checked").is(':checked')) {
//		 $('#btn_validar_ejercicio').removeClass('disabled'); 
//		 $('#btn_validar_ejercicio').attr("disabled", false);
			nextBtn();

		} else{
			//console.log("Selecciona la edad por favor!!!");
		}
 }

 function verificarRspta(valItem){
 	var IdPregunta = $("").val();

 }

// $("#btnevaluar").attr("disabled","true");

function sgtePregunta(){
	// traer la siguiente pregunta
}

/* $(".lstRadioSelect .rsp-link label").click(function() {
 	$(".lstRadioSelect .rsp-link label").removeClass();
   	$(this).addClass("activelink");

});*/
/** VERIFICAR RESPUESTA DE EJERCICIO MODO PREGUNTAS - RESPUESTAS **/
$('.lstRadioSelect .rsp-link label').click(function() {

//	$('.lstRadioSelect .rsp-link label').removeClass('activelink-corecto');
//	$('.lstRadioSelect .rsp-link label').removeClass('activelink-incorrecto');
 	var labelSel = this;
 	var valido = false;
 	var valor = null;
 	var idPregunta = $('#'+tabs).attr('data-id');
 	var idLabel = $(this).attr('for');
 	//console.log(idLabel);
 	$('#'+tabs+' .rsp-link input').each(function (i){
 		if($(this).attr('id') == idLabel){
 			valor = $(this).val();
 		}
 	});

 	//console.log('valor: '+valor);

	$.ajax({
		 async: true,
		type : "GET",
		data : {codalter : valor},
		url  : context+'/ejercicio/verificarAlternativa',
		success : function(data){
			if(data){ 
				valido = true;
//				$(labelSel).addClass('activelink-corecto');
				// $('#btn_validar_ejercicio').removeClass('disabled'); 
			//	 $('#btn_validar_ejercicio').attr("disabled", false);
				$('#btn_validar_ejercicio').attr("disabled", false);
				punto++;

			}else{
//				$(labelSel).addClass('activelink-corecto');
		//		 $('#btn_validar_ejercicio').removeClass('disabled'); 
			//	 $('#btn_validar_ejercicio').attr("disabled", false);
				$('#btn_validar_ejercicio').attr("disabled", false);
				 punto = 0;
				
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
		   if(valido){
//			   $('#lstRadioSelect-'+idPregunta).fadeTo('slow',.6);
//			   $('#lstRadioSelect-'+idPregunta).append('<div style="position: absolute;top:0;left:0;width: 100%;height:100%;z-index:2;opacity:0.4;filter: alpha(opacity = 50)"></div>');
		   }
	   }
	});

});

/** VERIFICAR RESPUESTA DE EJERCICIO MODO ALTERNATIVAS **/
$('.frb-group .content-alter label').click(function() {

//	$('.frb-group .content-alter').removeClass('frb-success').addClass('frb-default');
//	$('.frb-group .content-alter').removeClass('frb-danger').addClass('frb-default');
 	var labelSel = this;
 	var valido = false;
 	var valor = null;
 	var idPregunta = $('#'+tabs).attr('data-id');
 	var idLabel = $(this).attr('for');
 	//console.log(idLabel);
 	$('#'+tabs+' .content-alter input').each(function (i){
 		if($(this).attr('id') == idLabel){
 			valor = $(this).val();
 		}
 	});

 	//console.log('valor: '+valor);

	$.ajax({
		 async: true,
		type : "GET",
		data : {codalter : valor},
		url  : context+'/ejercicio/verificarAlternativa',
		success : function(data){
			if(data){ 
				valido = true;
				punto++;
		//		$('#divAlter-'+valor).removeClass('frb-default').addClass('frb-success');
				$('#btn_validar_ejercicio').attr("disabled", false);
		//		$('#btn_validar_ejercicio').attr("disabled", false);
				

			}else{
			//	$('#divAlter-'+valor).removeClass('frb-default').addClass('frb-success');
				$('#btn_validar_ejercicio').attr("disabled", false);
				punto = 0;
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
		   if(valido){
			   $('#lstRadioSelect-'+idPregunta).fadeTo('slow',.6);
			   $('#lstRadioSelect-'+idPregunta).append('<div style="position: absolute;top:0;left:0;width: 100%;height:100%;z-index:2;opacity:0.4;filter: alpha(opacity = 50)"></div>');
		   }
	   }
	});

});
function valorEvaluacion(){
	var codEvaDe =$('#codEvaluacionDet').val();
	console.log('codEvaDe',codEvaDe);
	console.log('punto',punto);
	console.log('array',arreglo);
	if(arreglo.length == 1){
		if(punto > 0){
			actulizarEjercicioEvaluacion(codEvaDe,'1');
			$('#codEvaluacionDet').val('0');
		}else {
			actulizarEjercicioEvaluacion(codEvaDe,'0');
			$('#codEvaluacionDet').val('0');
		}
	}else {
		if (punto == arreglo.length) {
			actulizarEjercicioEvaluacion(codEvaDe,'1');
			$('#codEvaluacionDet').val('0');
		}else{
			actulizarEjercicioEvaluacion(codEvaDe,'0');
			$('#codEvaluacionDet').val('0');
		}
	}
}