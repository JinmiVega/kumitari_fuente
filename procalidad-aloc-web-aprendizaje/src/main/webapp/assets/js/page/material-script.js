function linkSalir(){
	var context  = $('#contextPathUrl').val();
	window.location = context;
}
function show_detalle_moneda(){
	$(".tab-medalla").hide();
	$("#md-detalle-medalla").show();
}

function active_options_texto(){
	var btn_ojo_show = document.getElementById('btn_ojo_show'); // id for audio element
	
	if(btn_ojo_show){
		btn_ojo_show.addEventListener("click", showText);
	}	
}

function showText(){
	var data_show = $("#btn_ojo_show").attr('data-show');
	if(data_show == 1){
       		$("#btn_ojo_show").css("color","#ccc");
			$("#btn_ojo_show").attr('data-show','0');
			$("#content-text-audio").hide();
	}else{
       		$("#btn_ojo_show").css("color","#FF4D4C");
			$("#btn_ojo_show").attr('data-show','1');
			$("#content-text-audio").show();
	}
}

function active_options_audio(){

	var music = document.getElementById('music'); // id for audio element
	
	var duration = music.duration; // Duration of audio clip, calculated here for embedding purposes
	var pButton = document.getElementById('pButton'); // play button
	var pVolumen = document.getElementById('pVolumen'); // volumen button
	var pSpeed = document.getElementById('pSpeed'); // velocidad button

	var playhead = document.getElementById('playhead'); // playhead
	var timeline = document.getElementById('timeline'); // timeline

	// timeline width adjusted for playhead
	var timelineWidth = timeline.offsetWidth - playhead.offsetWidth;

	// play button event listenter
	pButton.addEventListener("click", play);
	pVolumen.addEventListener("click", volume);
	pSpeed.addEventListener("click", speedAudio);
	
	// timeupdate event listener
	music.addEventListener("timeupdate", timeUpdate, false);

	// makes timeline clickable
	timeline.addEventListener("click", function(event) {
	    moveplayhead(event);
	    music.currentTime = duration * clickPercent(event);
	}, false);

	// returns click as decimal (.77) of the total timelineWidth
	function clickPercent(event) {
	    return (event.clientX - getPosition(timeline)) / timelineWidth;
	}

	// makes playhead draggable
	playhead.addEventListener('mousedown', mouseDown, false);
	window.addEventListener('mouseup', mouseUp, false);

	// Boolean value so that audio position is updated only when the playhead is released
	var onplayhead = false;

	// mouseDown EventListener
	function mouseDown() {
	    onplayhead = true;
	    window.addEventListener('mousemove', moveplayhead, true);
	    music.removeEventListener('timeupdate', timeUpdate, false);
	}

	// mouseUp EventListener
	// getting input from all mouse clicks
	function mouseUp(event) {
	    if (onplayhead == true) {
	        moveplayhead(event);
	        window.removeEventListener('mousemove', moveplayhead, true);
	        // change current time
	        music.currentTime = duration * clickPercent(event);
	        music.addEventListener('timeupdate', timeUpdate, false);
	    }
	    onplayhead = false;
	}
	// mousemove EventListener
	// Moves playhead as user drags
	function moveplayhead(event) {
	    var newMargLeft = event.clientX - getPosition(timeline);

	    if (newMargLeft >= 0 && newMargLeft <= timelineWidth) {
	        playhead.style.marginLeft = newMargLeft + "px";
	    }
	    if (newMargLeft < 0) {
	        playhead.style.marginLeft = "0px";
	    }
	    if (newMargLeft > timelineWidth) {
	        playhead.style.marginLeft = timelineWidth + "px";
	    }
	}

	// timeUpdate
	// Synchronizes playhead position with current point in audio
	function timeUpdate() {
		var pButton = $("#pButton");
	    var playPercent = timelineWidth * (music.currentTime / duration);
	    playhead.style.marginLeft = playPercent + "px";
	    if (music.currentTime == duration) {
	        pButton.removeClass('icon-minedu-stop');
	        pButton.addClass('icon-minedu-play');
	    }
	}

	//Play and Pause
	function play() {
	    // start music
	    var pButton = $("#pButton");
	    if (music.paused) {
	        music.play();
	        // remove play, add pause
	        pButton.removeClass('icon-minedu-play');
	        pButton.addClass('icon-minedu-stop');
	    } else { // pause music
	        music.pause();
	        // remove pause, add play
	        pButton.removeClass('icon-minedu-stop');
	        pButton.addClass('icon-minedu-play');
	    }
	}

	function volume() {
	    var pVolumen = $("#pVolumen");
	    if (music.volume) {
	        music.volume= 0;
	        pVolumen.removeClass('icon-minedu-volumen');
	        pVolumen.addClass('icon-minedu-volumen-mute');
	        // remove play, add pause
	    } else { // pause music
	        music.volume= 1;
	        pVolumen.removeClass('icon-minedu-volumen-mute');
	        pVolumen.addClass('icon-minedu-volumen');
	        // remove pause, add play
	    }
	}

	function speedAudio() {
	    var pSpeed = $("#pSpeed");
	     if (music.playbackRate == 1) {
	       music.playbackRate = 0.5;
	       pSpeed.css("color","red");
	     } else {
	       music.playbackRate = 1.0;
	       pSpeed.css("color","#000");

	     }
	}
	function skip() {
	    music.currentTime += 2;
	}
	
	function skip1() {
	    music.currentTime += -2;
	}

	// Gets audio file duration
	music.addEventListener("canplaythrough", function() {
	    duration = music.duration;
	}, false);

	// getPosition
	// Returns elements left position relative to top-left of viewport
	function getPosition(el) {
	    return el.getBoundingClientRect().left;
	}
}


/** ******************************* 
 *  IMPLEMENTACION AJAX - MATERIAL 
 *  ******************************* **/
var context  	= $('#contextPathUrl').val();
var codlengua   = $('#codlenguaVal').val();
var codlenest   = $('#codlenestVal').val();
var codunidad   = $('#codunidadVal').val();
var codleccion  = $('#codleccionVal').val();
var pos 		= $('#posMaterialActual').val();
var tamanio=0;

/******************************************/

var codlenguaEncrypt   = $('#codlenguaValEncrypt').val();
var codlenestEncrypt   = $('#codlenestTreeValEncrypt').val();
var codunidadEncrypt   = $('#codlenuniTreeValEncrypt').val();
var codleccionEncrypt  = $('#codleccionValEncrypt').val();

/************************************/


verificarMaterialActual();

function verificarMaterialActual(){ 
	var arreglo = [];
	var arregloencrypt = [];

	$('#id-lista-material .elementos_material').each(function(){
	    arreglo.push($(this).attr('id'));
	});
	
	$('#id-lista-material .elementos_material_encryt').each(function(){
		arregloencrypt.push($(this).attr('id'));
	});

	console.log(arregloencrypt);

	var id_material = 0;
	var id_material_encryt = "";
	
	if(arreglo.length>0){
		tamanio=arreglo.length;
		 
		for(var i=0; i<arreglo.length; i++){
			if(pos == i){
				id_material = arreglo[i];
				break;
			}
		}
	}
	if(arregloencrypt.length>0){
		tamanio=arregloencrypt.length;
		 
		for(var i=0; i<arregloencrypt.length; i++){
			if(pos == i){
				id_material_encryt = arregloencrypt[i];
				console.log(id_material_encryt);
				break;
			}
		}
	}
	
	if(id_material > 0 ){
		cargar_material_actual(id_material,id_material_encryt);
	}
}

function cargar_material_actual(id,idencryt){
	console.log(idencryt);
	var valido   = false;
	var url      = context+'/lengua/cargarMaterialActual';
	
	showLoad();
	$.ajax({
		async: true,
		type : "GET",
		data : {codmaterial : id },
		url  : url,
		success : function(data){
			if(data!=null && data!=''){
				valido = true;
				$('#content-app').empty();
				$('#content-app').html(data);
			}else{
				$('#content-app').empty();
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
		   hideLoad();
		   if(valido){
			   var tipoMaterial = $('#tipoMaterialVal').val();
			   active_options_texto();
			   if(tipoMaterial==1 || tipoMaterial==2 ){
				   active_options_audio();
			   }
			   $('#pagination-leccion ul li .opt-before-exercise').attr('href',context+'/lengua/dematerialaultimoejercicio/'+codlenguaEncrypt+'/'+codlenestEncrypt+'/'+codunidadEncrypt+'/'+codleccionEncrypt);
		   }else{ // SIN MATERIAL - REDIRIGIR A EJERCICIOS
				location.href = context+'/lengua/detalle/'+codlenguaEncrypt+'/nivel/'+codlenestEncrypt+'/unidad/'+codunidadEncrypt+'/leccion/'+codleccionEncrypt+'/material/'+idencryt;
		   }
	   }
	});
}

function irHaciaEjercicios(){
//	if(pos >= (tamaño-1)){
//		listarLeccionesXlengest();
//	}else{
//		console.log("no es el ultimo material");
//	}
	var codmaterial = $('#codmaterialVal').val();
	var codmaterialEncrypt = $('#codmaterialValEncrypt').val();
	var url = context+'/lengua/detalle/'+codlenguaEncrypt+'/nivel/'+codlenestEncrypt+'/unidad/'+codunidadEncrypt+'/leccion/'+codleccionEncrypt+'/material/'+codmaterialEncrypt;
	//$("#btnNextMaterial").attr("href",url);
	location.href = url;
}