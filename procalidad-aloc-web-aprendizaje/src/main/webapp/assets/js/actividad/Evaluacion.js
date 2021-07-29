/**
 * Evaluación
 */
var contextPath = $('#contextPathUrl').val();
var context     = $('#contextPathUrl').val();
var codlengua   = $('#codlenguaVal').val();
var codlenest   = $('#codlenestVal').val();
var codunidad   = $('#codunidadVal').val();
var codleccion  = $('#codleccionVal').val();

/******************************************/

var codlenguaEncrypt   = $('#codlenguaValEncrypt').val();
var codlenestEncrypt   = $('#codlenestTreeValEncrypt').val();
var codunidadEncrypt   = $('#codlenuniTreeValEncrypt').val();
var codleccionEncrypt  = $('#codleccionValEncrypt').val();

/************************************/



var arregloIdMatTipoEjer = [];
var arregloTipoEjercicio = [];
var icono_titulo = '<i class="pull-left pencil-styel"><img src="'+context+'/assets/images/icono-ejercicio/EyG.png" height="17" style="margin-bottom: 20px;"></i>';

let leer_pos = 0;
let codmatipej_actual = 0;
var html = "";

var esUltimaPregunta  = 0;
//debugger;
$('#id-lista-ejercicio-material_evaluacion .elementos_ejercicio_material_evaluacion').each(function(){
	arregloTipoEjercicio.push($(this).attr('data-tipo'));
	arregloIdMatTipoEjer.push($(this).attr('id'));

});



//console.log('arregloTipoEjercicio'+arregloTipoEjercicio);
//console.log('arregloIdMatTipoEjer'+arregloIdMatTipoEjer);

var posEjercicio = $('#posEjercicio').val();

if($('#swEsUltimoEj').val()=='true'){
	leer_pos = arregloIdMatTipoEjer.length-1;
}else{
	if(posEjercicio){
		leer_pos = posEjercicio;
	}else{
		leer_pos = 0;
	}
}

codmatipej_actual = arregloIdMatTipoEjer[leer_pos];


cargar_ejercicio_actual(codmatipej_actual);

function cargar_ejercicio_actual(idmatipej){

	var valido   = false;
	var url      = context+'/lengua/cargarEjercicioActual';

	$('#content-ejercicio-actual-evaluacion-ajax #content-app').empty();
	$('#idDivLoadAjaxEvaluacion').css({'margin-top':'120px'});
//	showLoad();
	debugger;
	console.log("idmatipej1 "+idmatipej);
	$.ajax({
		async: true,
		type : "GET",
		data : {codmatipej : idmatipej},
		url  : url,
		success : function(data){
			
			if(data!=null && data!=''){
				
				valido = true;
				$('#content-ejercicio-actual-evaluacion-ajax #content-app').empty();
				$('#content-ejercicio-actual-evaluacion-ajax #content-app').html(data);
			}else{
				$('#content-ejercicio-actual-evaluacion-ajax #content-app').empty();
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
//		   $('#idDivLoadAjaxEvaluacion').css({'margin-top':''});
//		   hideLoad();


//		   $('#divEvaluarEjercicio').html("<button type='button' id='btn_validar_ejercicio' onclick='valor(); siguiente_ejercicio()'  class='btn btn-primary btn-lg btn-min-width'>" +
//		   		"<i class='fa fa-floppy-o'></i> Continuar</button>");

	   }
	});
}
//function verificar_opt(){
//	debugger;
//	if(leer_pos == 0){
//
//		$('#pagination-leccion ul li .opt-before-exercise').attr('href',context+'/lengua/deprimerejercicioamaterial/'+codlengua+'/'+codlenest+'/'+codunidad+'/'+codleccion);
//	}else{
//		$('#pagination-leccion ul li .opt-before-exercise').attr('href','#');
//	}
//}
function siguiente_ejercicio(){
//	debugger;
	if ($('#codMatTipoEjerBono').val() != 0 || $('#codMatTipoEjerBono').val() != '0') {
//		alert($('#codMatTipoEjerBono').val());
		arregloIdMatTipoEjer.push($('#codMatTipoEjerBono').val());
		$('#codMatTipoEjerBono').val('0')
	}
	esUltimaPregunta = 0;
	if(!verificarTipoEjercicio()){
		leer_pos++;
		codmatipej_actual = arregloIdMatTipoEjer[leer_pos];

		if (arregloIdMatTipoEjer[leer_pos]) {
			cargar_ejercicio_actual(codmatipej_actual);
		}else{

			//console.log("ultimo");
			cargarmodal_termino_evalua();



		}
	}else{
		/** CARGAR MATERIAL TEXTO-AUDIO-IMAGEN **/
		codmatipej_actual = 0;
//		cargar_material_preg_rpt();
	}
}
function verificarTipoEjercicio(){

	var tipoEj = 0;
	var esPreguntas = false;
	var tipoMaterial = $('#codtipomaterialVal').val();

//	if(tipoMaterial==1){//!=4){
		$('#id-lista-ejercicio-material_evaluacion .elementos_ejercicio_material_evaluacion').each(function(){
			if($(this).attr('id') == codmatipej_actual){
				tipoEj = $(this).attr('data-tipo');
			}
		});
		if(tipoEj == 2){
//			html = "";
//			 $('#divEvaluarEjercicio').html("<button type='button' id='btn_validar_ejercicio' onclick='nextBtn();' class='btn btn-primary btn-lg btn-min-width'>" +
//		   		"<i class='fa fa-floppy-o'></i> Continuar</button>");
//			 $('#btn_validar_ejercicio').click();
//			esPreguntas = true;
		}
//	}

	return esPreguntas;
}
//function hide_msj_mascota(){
//	$('#show-msg').css({'display':'none'});
//	$('#show-msg').empty();
//}
//function resetImgMascota(tipo){
//	/** 1:Normal - 2:Alegre - 3:Triste - 4:Sorpresa **/
//	var name = '';
//	var srcDef  = context+'/assets/images/plumillaNeutro.png';
//	var altDef  = 'No disponible';
//	var src  = '';
//	var alt  = '';
//
//	if(tipo==1){
//		var swActivoAnim = ($('#idCheckActiveAnimMasc')) ? $('#idCheckActiveAnimMasc').val() : 0;
//		if(swActivoAnim == 1){
//			name = $('#idValImgNormalAnim').val();
//		}else{
//			name = $('#idValImgNormal').val();
//		}
//	}else if(tipo==2){
//		name = $('#idValImgAlegre').val();
//	}else if(tipo==3){
//		name = $('#idValImgTriste').val();
//	}else if(tipo==4){
//		name = $('#idValImgExclam').val();
//	}
//	console.log('imgnorm name '+ name);
//	src  = (name!=null && name!='') ? (context+'/mascota/'+name) : srcDef;
//	alt  = (name!=null && name!='') ? name : altDef;
//
//	$('#box-masct img').attr('src', src);
//	$('#box-masct img').attr('alt', alt);
//}
function actulizarEjercicioEvaluacion(idEva,correccionEva){ 
	console.log('IDEVA', idEva);
	console.log('CORRECPCION', correccionEva);
	var url      = context+'/lengua/actulizarEjercicioEvaluacion';
	//showLoad();
	$.ajax({
		async: true,
		type : "POST",
		data : {idEva : idEva,
				correccionEva:correccionEva},
		url  : url,
		success : function(data){
			 if (data != 0) {
				//console.log("exito");
			}else{

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
		   siguiente_ejercicio();
	   }
	});
}
//function show_msj_masc_exito(texto){
//	hide_msj_mascota();
//	resetImgMascota(2);
//	$('#show-msg').css({'display':'table'});
//	$('#show-msg').html(texto);
//	setTimeout(function(){
//		resetImgMascota(1); // Regresar la mascota inicial
//		hide_msj_mascota();
//	}, 6000);
//}

//function show_msj_masc_fallo(texto){
//	hide_msj_mascota();
//	resetImgMascota(3);
//	$('#show-msg').css({'display':'table'});
//	$('#show-msg').html(texto);
//	setTimeout(function(){
//		resetImgMascota(1); // Regresar la mascota inicial
//		hide_msj_mascota();
//	}, 6000);
//}

//$(document).ready(function(){
//	 $('#cbComboPalabra').empty();
//	 $(document).on('click', '.contentPalabra', function (e) {
//		 	//debugger;
//		    // Avoid the real one
//		    e.preventDefault();
//
//		    console.log("idpalabra: " + $(this).attr("id"));
//		    var idpal= $(this).attr("id");
//		    $("#box-shadow-div").empty();
//		    $("#box-shadow-div").show(100).css({
//		        top: e.pageY + "px",
//		        left: e.pageX + "px"
//		    }).html('<select id="cbComboPalabra" class="select-app" title="'+$(this).attr("id")+'" onchange="changeComboPalabra();changeComboPalabra1('+idpal+');"><option value="0" >Seleccionar</option> </select>');
//
//		    //$('#cbComboPalabra').empty();
//		    //
//
//		    var url = contextPath+"/lengua/ListAlternTextoPalabraCorrectaXNombrePCYcodigoCab?p_palabracorrecta="+$(this).attr("id").trim()+"&p_codtextopalabracorrec="+$("#codCabPC").val();
//			 var html = "";
//		     $.ajax({
//		         type : 'GET',
//		          url  : url,
//		          success : function(data) {
//		        	  console.log("data: " + data);
//			         if (data != null) {
//			              for(var i=0;i<data.length;i++){
//			            	  $('#cbComboPalabra').append($('<option>', {
//				  				    value: data[i].respuestaEstado,
//				  				    text:  data[i].descripcion
//				  				}));
//			                }
//
//					}else{}
//		          },
//		          error : function(data) {
//		                  console.log("error ");
//		           }
//		     });
//		    //$("#box-shadow-div").html("Alternativa" +  $(this).attr("id"));
//		    // In the right position (the mouse)
//		     return false;
//		});
//
//
//		// If the document is clicked somewhere
//		$(document).bind("mousedown", function (e) {
//
//
//		    // If the clicked element is not the menu
//		    if (!$(e.target).parents("#box-shadow-div").length > 0) {
//
//		        // Hide it
//		        $("#box-shadow-div").hide(100);
//		    }
//		});
//
//});

//function changeComboPalabra(){
//	 console.log("title:" + $("#cbComboPalabra").attr("id"));
//	 //$("#esp"+ $("#cbComboPalabra").attr("title")).val($("#cbComboPalabra").val());
//	 $("#esp"+ $("#cbComboPalabra").attr("id")+" option").each(function(){
//		 console.log($(this).text());
//		   if( $(this).text() == $("#cbComboPalabra option:selected").text() ) {
//		 	console.log("entro");
//		     $(this).prop("selected","selected");
//		   } else{
//		  console.log("no entrpo");
//		 }
//		 });
//}
function show_material_preg_rpt(){

	/*var valido   = false;
	var url      = context+'/ejercicio/cargarMaterialActual';

	$.ajax({
		type : "GET",
		data : {codmaterial : $('#codmaterialVal').val() },
		url  : url,
		success : function(data){
			$('#divModalMaterialPregRpt').empty();
			$('#divModalMaterialPregRpt').html(data);
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
		   $('#modal-tienda-app-material').modal("show");
	   }
	});*/
	$('#modal-app-material').modal("show");
	calccularTamaño();
}

function calccularTamaño(){
		var alturaPantalla = $(window).height();
		var alt_headerModal = $("#modal-app-material .modal-header").height();
		var altBody = $("#modal-app-material .modal-body").height();
		var tipoMaterial = $("#tipoMaterialVal").val();
		var resp = alturaPantalla - (alt_headerModal + 160);

		if(tipoMaterial=="1"){
			$("#modal-app-material .modal-dialog").css({
				'margin': '14% auto'
			});

		}else{
			$("#modal-app-material .modal-body").css({
				'max-height': resp+'px',
				'overflow-y': 'auto'
			});
		}

}

function obtenerNota(){

	var url      = context+'/lengua/obtenerNota';
    var p_codeva	 =  $('#codEvaluacion').val();
	$.ajax({
		async: true,
		type : "GET",
		data : {p_codeva : p_codeva},
		url  : url,
		success : function(data){

			 if (data != 0) {
				//console.log("exito");

			}else{

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
		   if ($('#clock').text() == "00:00:00") {
		    	modal_info();
		    	cargar_notaxEvaluacion_conTiempo();
		}else{
			modal_info_correcta_evaluacion();
		}
	   }
	});
}
function pasarHistorico(){
//	debugger;
	var url      = context+'/lengua/pasarHistorico';
    var p_codeva	 =  $('#codEvaluacion').val();
	var p_codusumat      = $("#codusuariomat").val();
	var p_tm2SubNivel = $('#codSubNivel').val();
	$.ajax({
		async: true,
		type : "POST",
		data : {p_codeva : p_codeva,
			    p_codusumat:p_codusumat,
			    p_tm2SubNivel:p_tm2SubNivel},
		url  : url,
		success : function(data){
			 if (data == 1) {
				//console.log("Inserta Nueva evaluacion");
				 insertarNuvEvaluacion();
			}
			 if(data == 0){
				//console.log("vuelve al inicio.");
				 $(location).attr('href',context+'/lengua/detalle/'+$('#codlenguaEncrypt').val());
			 }
			 if(data == 2){
				 insertarEvaluacionFinal();
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

	   }
	});
}
function insertarNuvEvaluacion(){
	//debugger;
	 var p_codlengua =  $('#codigoLengua').val();
	 var leccion = 0;
	 var p_codnivel =  $('#lenguanivel').val();
	 var p_codusumat      = $("#codusuariomat").val();
	 var p_tm2SubNivel = $('#codSubNivel').val();
	 var url = contextPath + "/lengua/insertarEvaluacion";
    $.ajax({
    	async: true,
        type :  "POST",
        url  :  url,
        data : {
       	 p_codlengua        :  p_codlengua,
       	 p_tm2SubNivel        	:  p_tm2SubNivel ,
       	 p_codundlec        :  leccion,
       	 p_codusumat     	:  p_codusumat,
       	 p_codnivel         :  p_codnivel},
          success : function(data){
       	        if (data != 0) {
       	       //console.log("inserto eva");
				}else{
					//console.log("else");
				}
            },
            error : function()
            {

            	//console.log("ERROR: ");
            },
     	   complete : function(){
     		  $(location).attr('href',context+'/lengua/detalle/'+$('#codlenguaEncrypt').val());
     	   }
    });
}
function calcularPromedio(){
//	debugger;
	var p_codusumat      = $("#codusuariomat").val();
	var p_codnivel       = $("#lenguanivel").val();
	var url      = context+'/lengua/calcularPromedioEva';
	//showLoad();
	$.ajax({
		async: true,
		type : "GET",
		data : {p_codusumat : p_codusumat,
				p_codnivel:p_codnivel},
		url  : url,
		success : function(data){
			//debugger;
			 if (data == 2) {
				//console.log("exito tiene  todas las evaluaciones");
				 insertarEvaluacionFinal();
			}else{
				//console.log("error");
				$(location).attr('href',context+'/lengua/detalle/'+$('#codlenguaEncrypt').val());
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

	   }
	});
}

function insertarEvaluacionFinal(){
//	debugger;
	 var p_codlengua =  $('#codigoLengua').val();
	 var leccion = 0;
//	 var p_tm2nivel =  $('#lenguanivel').val();
	 var p_codusumat      = $("#codusuariomat").val();
	 var p_codnivel = $('#lenguanivel').val();


	 let url = contextPath + "/lengua/insertarEvaluacionFinal";
    $.ajax({
    	async: true,
        type :  "GET",
        url  :  url,
        data : {
       	 p_codlengua        :  p_codlengua,
       	 p_codundlec        :  leccion,
       	 p_codusumat     	:  p_codusumat,
       	 p_codnivel 	    : p_codnivel},
          success : function(data){
        	  if (data > 0 ) {
        		//console.log("Exito");
			}else{
				//console.log("Error");
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
    		$(location).attr('href',context+'/lengua/detalle/'+$('#codlenguaEncrypt').val());
    	   }
    });
}