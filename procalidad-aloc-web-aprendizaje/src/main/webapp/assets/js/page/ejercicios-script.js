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
	
	var icono_titulo = '<i class="pull-left pencil-styel"><img src="'+context+'/assets/images/icono-ejercicio/EyG.png" height="17" style="margin-bottom: 20px;"></i>';

	var arregloTipoEjercicio = [];
	var arregloIdMatTipoEjer = [];
	let leer_pos = 0;
	let codmatipej_actual = 0;

	var esUltimaPregunta  = 0;

	$('#id-lista-ejercicio-material .elementos_ejercicio_material').each(function(){
		arregloTipoEjercicio.push($(this).attr('data-tipo'));
		arregloIdMatTipoEjer.push($(this).attr('id'));
	});

	$.browser = {}; 
   	/*(function () {
		console.log('BROWSER 2');
		$.browser.msie = false;
		$.browser.version = 0;
		if(navigator.userAgent.match(/MSIE ([0-9]+)\./)){
			$.browser.msie = true;
			$.browser.version = RegExp.$1;
		}
   	})();*/
   	
	//console.log('arregloTipoEjercicio'+arregloTipoEjercicio);
	//console.log('arregloIdMatTipoEjer'+arregloIdMatTipoEjer);

	//leer_pos = ($('#swEsUltimoEj').val()=='true') ? (arregloIdMatTipoEjer.length-1) : 0;

	var posEjercicio = $('#posEjercicio').val();

	if($('#swEsUltimoEj').val()=='true'){
		leer_pos = arregloIdMatTipoEjer.length-1;
		esUltimaPregunta = 1;
	}else{
		if(posEjercicio){
			leer_pos = posEjercicio;
		}else{
			leer_pos = 0;
		}
	}

	codmatipej_actual = arregloIdMatTipoEjer[leer_pos];
	cargar_ejercicio_actual(codmatipej_actual); // Por defecto cargar el primer ejercicio arregloIdMatTipoEjer[0]
 
	function cargar_ejercicio_actual(idmatipej){
		//debugger;
		var valido   = false;
		var url      = context+'/lengua/cargarEjercicioActual';

		$('#content-ejercicio-actual-ajax #content-app').empty();
		$('#idDivLoadAjax').css({'margin-top':'120px'});
		showLoad();
		//console.log({codmatipej : idmatipej});
		debugger;
		console.log("idmatipej1 "+idmatipej);
		$.ajax({
			async: true,
			type : "GET",
			data : {codmatipej : idmatipej},
			url  : url,
			success : function(data){
				//var dataFormato = "";
				/*for (var i = 0; i < data.length; i++) {
					  //alert(str.charAt(i));
					  var tmp = data.charAt(i)+"";
					  dataFormato = dataFormato + tmp.replace("\"", "\\\"");
				}
				*/
				//var dataFormato = data.replace("'", "\\\\'");
				//dataFormato = dataFormato.replace("'", "\\\\'");
				//$("<h2>Hello world!</h2>").replaceAll("p");
				//var dataFormato = data.replaceAll("'", "");
				console.log('data: ',data);
				if(data!=null && data!=''){
					valido = true;
					$('#content-ejercicio-actual-ajax #content-app').empty();
					$('#content-ejercicio-actual-ajax #content-app').html(data);
				}else{
					$('#content-ejercicio-actual-ajax #content-app').empty();
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
			   $('#idDivLoadAjax').css({'margin-top':''});
			   hideLoad();
			   //console.log('valido'+valido);
			   if(valido){
				   verificar_opt();
			   }else{
				   siguiente_ejercicio();
			   }
		   }
		});
	}

	function cargarHTML(data){
		$( "#content-ejercicio-actual-ajax #content-app" ).html(function() {
			  return data;
		});
	}
	
	function siguiente_ejercicio(){
		//debugger;
		esUltimaPregunta = 0;
		if(!verificarTipoEjercicio()){
			leer_pos++;
			codmatipej_actual = arregloIdMatTipoEjer[leer_pos];

			if (arregloIdMatTipoEjer[leer_pos]) {

				cargar_ejercicio_actual(codmatipej_actual);
			}else{

				listarleccionesxnivel();
//				var urlcont = context+'/lengua/detalle/'+codlengua+'/nivel/'+codlenest+'/unidad/'+codunidad+'/leccion/'+codleccion;
				//$("#btnevaluar").attr("href",url);
//  				location.href = url;
			}
		}else{
			/** CARGAR MATERIAL TEXTO-AUDIO-IMAGEN **/
			codmatipej_actual = 0;
			cargar_material_preg_rpt();
		}
	}

	function anterior_ejercicio(){
		leer_pos--;
		codmatipej_actual = arregloIdMatTipoEjer[leer_pos];

		if(arregloIdMatTipoEjer[leer_pos]){
			if(!verificarTipoEjercicio()){
				cargar_ejercicio_actual(codmatipej_actual);
			}else{
				/** CARGAR MATERIAL TEXTO-AUDIO-IMAGEN EJERCICIO ANTERIOR **/
				codmatipej_actual = 0;
				cargar_material_preg_rpt();
			}
		}
	}

	function verificar_opt(){
		if( leer_pos == 0 ){
			$('#pagination-leccion ul li .opt-before-exercise').attr('href',context+'/lengua/deprimerejercicioamaterial/'+codlenguaEncrypt+'/'+codlenestEncrypt+'/'+codunidadEncrypt+'/'+codleccionEncrypt);
		}else{
			$('#pagination-leccion ul li .opt-before-exercise').attr('href','#');
		}

		if($('#main-tree-view #tree-list')){
		   $('#main-tree-view #tree-list span').removeClass('opt-active-tree');
		   $('#main-tree-view #tree-list a').removeClass('opt-active-tree');
		   var codEjeAct = arregloIdMatTipoEjer[leer_pos];
		   /*for (var i = 0; i < arregloIdMatTipoEjer.length; i++) {
			   if(i == leer_pos){
				   codEjeAct = arregloIdMatTipoEjer[i];
				   break;
			   }
		   }*/
		   $('#main-tree-view #tree-list #a-len-eje-'+codEjeAct+' .link-item-ejercicio').addClass('opt-active-tree');
		}

	}

	var consultao = window.matchMedia('(max-width: 480px)');
	consultao.addListener(mediaQuerym);

	function mediaQuerym() {
	if (consultao.matches) {
		  // si se cumple hagamos esto
		//console.log('se cumplió la condicion');
		  $('#bg_fondo_mv').attr('data-movil', 'true');
		} else {
		  $('#bg_fondo_mv').attr('data-movil', 'false');
		//console.log('no se cumplió la condicion');
		}
	}
    mediaQuerym();
	function show_msj_masc_exito(texto){
		hide_msj_mascota();
		resetImgMascota(2);
		if ($('#bg_fondo_mv').attr('data-movil')) {
			$('#bg_fondo_mv').show();
		}
		$('#show-msg').show().css("display","table");
		$('#show-msg').html(texto);
		setTimeout(function(){
			resetImgMascota(1); // Regresar la mascota inicial
			hide_msj_mascota();
		}, 6000);
	}

	function show_msj_masc_fallo(texto){
		hide_msj_mascota();
		resetImgMascota(3);
		if ($('#bg_fondo_mv').attr('data-movil')) {
			$('#bg_fondo_mv').show();
		}
		$('#show-msg').show().css("display","table");
		$('#show-msg').html(texto);

		setTimeout(function(){
			resetImgMascota(1); // Regresar la mascota inicial
			hide_msj_mascota();
		}, 6000);
	}

	function show_msj_masc_info(texto){
		hide_msj_mascota();
		resetImgMascota(4);
		if ($('#bg_fondo_mv').attr('data-movil')) {
			$('#bg_fondo_mv').show();
		}
		$('#show-msg').show().css("display","table");
		$('#show-msg').html(texto);
		setTimeout(function(){
			resetImgMascota(1); // Regresar la mascota inicial
			hide_msj_mascota();
		}, 6000);
	}

	function hide_msj_mascota(){
		$('#bg_fondo_mv').hide();
		$('#show-msg').hide();
		$('#show-msg').empty();
	}

	$('#bg_fondo_mv').click(function() {
		hide_msj_mascota();
	});

	function resetImgMascota(tipo){
		/** 1:Normal - 2:Alegre - 3:Triste - 4:Sorpresa **/
		var name = '';
		var srcDef  = context+'/assets/images/plumillaNeutro.png';
		var altDef  = 'No disponible';
		var src  = '';
		var alt  = '';

		if(tipo==1){
			var swActivoAnim = ($('#idCheckActiveAnimMasc')) ? $('#idCheckActiveAnimMasc').val() : 0;
			if(swActivoAnim == 1){
				name = $('#idValImgNormalAnim').val();
			}else{
				name = $('#idValImgNormal').val();
			}
		}else if(tipo==2){
			name = $('#idValImgAlegre').val();
		}else if(tipo==3){
			name = $('#idValImgTriste').val();
		}else if(tipo==4){
			name = $('#idValImgExclam').val();
		}
		//console.log('imgnorm name '+ name);
		src  = (name!=null && name!='') ? (context+'/mascota/'+name) : srcDef;
		alt  = (name!=null && name!='') ? name : altDef;

		$('#box-masct img').attr('src', src);
		$('#box-masct img').attr('alt', alt);
	}

	/** VERIFICAR SI EL MATERIAL ES PREGUNTA Y RESPUESTA **/
	function verificarTipoEjercicio(){
		var tipoEj = 0;
		var flgPregu = 0;
		var esPreguntas = false;
		var tipoMaterial = $('#codtipomaterialVal').val();

		if(tipoMaterial==1 || tipoMaterial==2){//!=4){
			$('#id-lista-ejercicio-material .elementos_ejercicio_material').each(function(){
				if($(this).attr('id') == codmatipej_actual){
					tipoEj = $(this).attr('data-tipo');
					flgPregu = $(this).attr('data-flg');
				}
			});
			if(tipoEj == 2 && flgPregu == 0){
				esPreguntas = true;
			}
		}

		return esPreguntas;
	}

	function volverAPregRptDesdeMaterial(){
		esUltimaPregunta = 1;
		codmatipej_actual = arregloIdMatTipoEjer[leer_pos];
		if(arregloIdMatTipoEjer[leer_pos]){
			cargar_ejercicio_actual(codmatipej_actual);
		}
	}

	function cargar_material_preg_rpt(){

		var valido   = false;
		var url      = context+'/ejercicio/cargarMaterialActual';

		$('#content-ejercicio-actual-ajax #content-app').empty();
		$('#idDivLoadAjax').css({'margin-top':'120px'});
		showLoad();
		$.ajax({
			 async: true,
			type : "GET",
			data : {codmaterial : $('#codmaterialVal').val() },
			url  : url,
			success : function(data){
				if(data!=null && data!=''){
					//console.log('entro por aca');
					valido = true;
					$('#content-ejercicio-actual-ajax #content-app').empty();
					$('#content-ejercicio-actual-ajax #content-app').html(data);
				}else{
					$('#content-ejercicio-actual-ajax #content-app').empty();
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
			   $('#idDivLoadAjax').css({'margin-top':''});
			   hideLoad();
			   if(!valido){
				   siguiente_ejercicio();
			   }
		   }
		});
	}

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
			   $('#modal-app-material').modal("show");
			   calccularTamaño();
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



	 $(document).ready(function(){
		 $('#cbComboPalabra').empty();
		 $(document).on('click', '.contentPalabra', function (e) {
			 	//debugger;
			    // Avoid the real one
			    e.preventDefault();

			  //console.log("idpalabra: " + $(this).attr("id"));
			    var idpal= $(this).attr("id");
			    $("#box-shadow-div").empty();
			    $("#box-shadow-div").show(100).css({
			        top: e.pageY + "px",
			        left: e.pageX + "px"
			    }).html('<select id="cbComboPalabra" class="select-app"  onchange="changeComboPalabra();changeComboPalabra1('+idpal+');"><option value="0" >-----------</option> </select>');//title="'+$(this).attr("id")+'"

			    //$('#cbComboPalabra').empty();
			    //

			    var url = contextPath+"/lengua/ListAlternTextoPalabraCorrectaXNombrePCYcodigoCab?p_palabracorrecta="+$(this).attr("id").trim()+"&p_codtextopalabracorrec="+$("#codCabPC").val();
				 var html = "";
			     $.ajax({
			    	 async: true,
			         type : 'GET',
			          url  : url,
			          success : function(data) {
			        	//console.log("data: " + data);
				         if (data != null) {
				              for(var i=0;i<data.length;i++){
				            	  $('#cbComboPalabra').append($('<option>', {
					  				    value: data[i].respuestaEstado,
					  				    text:  data[i].descripcion
					  				}));
				                }

						}else{}
			          },
			          error : function(data) {
			        	//console.log("error ");
			           }
			     });
			    //$("#box-shadow-div").html("Alternativa" +  $(this).attr("id"));
			    // In the right position (the mouse)
			     return false;
			});


			// If the document is clicked somewhere
			$(document).bind("mousedown", function (e) {


			    // If the clicked element is not the menu
			    if (!$(e.target).parents("#box-shadow-div").length > 0) {

			        // Hide it
			        $("#box-shadow-div").hide(100);
			    }
			});

	 });

	 function changeComboPalabra(){
		//console.log("title:" + $("#cbComboPalabra").attr("id"));
		 //$("#esp"+ $("#cbComboPalabra").attr("title")).val($("#cbComboPalabra").val());
		 $("#esp"+ $("#cbComboPalabra").attr("id")+" option").each(function(){
			//console.log($(this).text());
			   if( $(this).text() == $("#cbComboPalabra option:selected").text() ) {
				 //console.log("entro");
			     $(this).prop("selected","selected");
			   } else{
				 //console.log("no entrpo");
			 }
			 });
	 }

	 /*
	  *
	  * R
	  * */