var p_int1 =  $('#intent1').val();
var p_int2 =  $('#intent2').val();
var p_int3 =  $('#intent3').val();
var context  = $('#contextPathUrl').val();
var arreglo = [];
var codigoMaterial = $('#codigoMaterialActual').val();
$('#btnevaluar').addClass('disabled');

$('.tabs_elements').each(function(){
    arreglo.push($(this).attr('id'));
});

//console.log(arreglo);
const array=arreglo;

let leer_tab= esUltimaPregunta==1 ? (arreglo.length-1) : 0;
let tab_m=0;
let tabs = arreglo[leer_tab];

$('.tabs_elements').css('display','none');
$('#'+tabs).css('display','');

function nextBtn(){

	$('#pagination-leccion ul li .opt-before-exercise').attr('href','#');
	$('#btnevaluar').addClass('disabled');
	hide_msj_mascota();
	resetImgMascota(1);// Regresar la mascota inicial
	leer_tab++;
	tab_m--;
	tabs = arreglo[leer_tab];
	if (arreglo[leer_tab]) {
		$('.tabs_elements').css('display','none');
		$('#'+tabs).css('display','');


	}else{
		$('#btnevaluar').removeClass('disabled');
		grabarSeguimientoAlumnoEjercicio(0);
		//$('#btnevaluar').attr('href',codigoMaterial);
		siguiente_ejercicio();
	}
}

function beforeBtn(){
	$('#pagination-leccion ul li .opt-before-exercise').attr('href','#');
	$('#btnevaluar').addClass('disabled');
	hide_msj_mascota();
	resetImgMascota(1);// Regresar la mascota inicial
	leer_tab--;
	tabs = arreglo[leer_tab];
	if (arreglo[leer_tab]) {
		$('.tabs_elements').css('display','none');
		$('#'+tabs).css('display','');
	}else{
		if(leer_pos == 0){
			$('#pagination-leccion ul li .opt-before-exercise').attr('href',context+'/lengua/deprimerejercicioamaterial/'+codlengua+'/'+codlenest+'/'+codunidad+'/'+codleccion);
		}else{
			anterior_ejercicio();
		}
	}
}

/** VERIFICAR RESPUESTA DE EJERCICIO MODO PREGUNTAS - RESPUESTAS **/
$('.lstRadioSelect .rsp-link label').click(function() {
//	debugger;
	$('.lstRadioSelect .rsp-link label').removeClass('activelink-corecto');
	$('.lstRadioSelect .rsp-link label').removeClass('activelink-incorrecto');
 	var labelSel = this;
 	var valido = false;
 	var valor = null;
 	var idPregunta = $('#'+tabs).attr('data-id');
 	var idLabel = $(this).attr('for');
 	
 	//////////////////////////////////////////////////////
 	$('#lstRadioSelect-'+idPregunta).addClass('bloquear');
	/////////////////////////////////////////////////////
 	
 	//console.log(idLabel);
 	$('#'+tabs+' .rsp-link input').each(function (i){
 		if($(this).attr('id') == idLabel){
 			valor = $(this).val();
 		}
 	});
 	//console.log('valor: '+valor);
//bloquear
 	$('#lstRadioSelect-'+idPregunta)
	$.ajax({
		 async: true,
		type : 'GET',
		data : {codalter : valor},
		url  : context+'/ejercicio/verificarAlternativa',
		success : function(data){
			if(data){
				valido = true;
			if(numerodeintento == 1){
			 	guardarMonedas(p_int1,0);
			 	grabarSeguimientoAlumnoEjerPreg(p_int1);
			 }else if(numerodeintento==2){
			 	guardarMonedas(p_int2,0);
			 	grabarSeguimientoAlumnoEjerPreg(p_int2);
			 } else if (numerodeintento==3){
			 	guardarMonedas(p_int3,0);
			 	grabarSeguimientoAlumnoEjerPreg(p_int3);
			 } else{
				 grabarSeguimientoAlumnoEjerPreg(0);
			 }

//				codigoSegIntento = 0;
				BuscarIntentosRealizados();
				$(labelSel).addClass('activelink-corecto');
				show_msj_masc_exito($('#msj_1').val());
		 		$('#btnevaluar').removeClass('disabled');

			}else{

				insertarIntento();
				$(labelSel).addClass('activelink-incorrecto');
				show_msj_masc_fallo($('#msj_2').val());
			}
		},
		error: function(xhr,status,er) {
			//console.log('error: ' + xhr + ' status: ' + status + ' er:' + er);
		    if(xhr.status==500) {
		    	//console.log(er);
		    }
		    if(xhr.status==901) {
		    	//console.log(er);
		    }
	   },
	   complete : function(){

		   //////////////////////////////////////////////////////
		   $('#lstRadioSelect-'+idPregunta).removeClass('bloquear');
		   /////////////////////////////////////////////////////
		   if(valido){
			   tabid++;
			   $('#lstRadioSelect-'+idPregunta).fadeTo('fast',1);
			   $('#lstRadioSelect-'+idPregunta).append('<div style=\'position: absolute;top:0;left:0;width: 100%;height:100%;z-index:2;opacity:0.4;filter: alpha(opacity = 50)\'></div>');
			   BuscarIntentosRealizados();
		   }
	   }
	});

});


/** VERIFICAR RESPUESTA DE EJERCICIO MODO ALTERNATIVAS **/
$('.frb-group .content-alter label').click(function() {
//	debugger;
	$('.frb-group .content-alter').removeClass('frb-success').addClass('frb-default');
	$('.frb-group .content-alter').removeClass('frb-danger').addClass('frb-default');
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

	$('#lstRadioSelect-'+idPregunta).addClass('bloquear');
 	
	$.ajax({
		 async: true,
		type : 'GET',
		data : {codalter : valor},
		url  : context+'/ejercicio/verificarAlternativa',
		success : function(data){
			if(data){
				valido = true;
			if(numerodeintento == 1){
				tabid=leer_tab;
			 	guardarMonedas(p_int1,0);
			 	grabarSeguimientoAlumnoEjerPreg(p_int1);
			 }else if(numerodeintento==2){
				 tabid=leer_tab;
			 	guardarMonedas(p_int2,0);
			 	grabarSeguimientoAlumnoEjerPreg(p_int2);
			 } else if (numerodeintento==3){
				 tabid=leer_tab;
			 	guardarMonedas(p_int3,0);
			 	grabarSeguimientoAlumnoEjerPreg(p_int3);
			 } else{
				 tabid=leer_tab;
				 grabarSeguimientoAlumnoEjerPreg(0);
			 }


				BuscarIntentosRealizados();
				$('#divAlter-'+valor).removeClass('frb-default').addClass('frb-success');
				show_msj_masc_exito($('#msj_1').val());
		 		$('#btnevaluar').removeClass('disabled');

			}else{

				insertarIntento();
				$('#divAlter-'+valor).removeClass('frb-default').addClass('frb-danger');
				show_msj_masc_fallo($('#msj_2').val());
			}
		},
		error: function(xhr,status,er) {
			//console.log('error: ' + xhr + ' status: ' + status + ' er:' + er);
		    if(xhr.status==500) {
		    	//console.log(er);
		    }
		    if(xhr.status==901) {
		    	//console.log(er);
		    }
	   },
	   complete : function(){

		   $('#lstRadioSelect-'+idPregunta).removeClass('bloquear');
		   
		   if(valido){
			   tabid++;
			   $('#lstRadioSelect-'+idPregunta).fadeTo('fast',1);
			   $('#lstRadioSelect-'+idPregunta).append('<div style=\'position: absolute;top:0;left:0;width: 100%;height:100%;z-index:2;opacity:0.4;filter: alpha(opacity = 50)\'></div>');
			   BuscarIntentosRealizados();
		   }
	   }
	});

});