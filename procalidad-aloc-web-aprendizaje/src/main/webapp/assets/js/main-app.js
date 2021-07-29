;(function () {

	'use strict';



	// iPad and iPod detection
	var isiPad = function(){
		return (navigator.platform.indexOf("iPad") != -1);
	};

	var isiPhone = function(){
	    return (
			(navigator.platform.indexOf("iPhone") != -1) ||
			(navigator.platform.indexOf("iPod") != -1)
	    );
	};

	// // Parallax
	// var parallax = function() {
	// 	$(window).stellar();
	// };



	// Burger Menu
	var burgerMenu = function() {

		$('body').on('click', '.js-fh5co-nav-toggle', function(event){

			event.preventDefault();

			if ( $('#navbar').is(':visible') ) {
				$(this).removeClass('active');
			} else {
				$(this).addClass('active');
			}



		});

	};


	var goToTop = function() {

		$('.js-gotop').on('click', function(event){

			event.preventDefault();

			$('html, body').animate({
				scrollTop: $('html').offset().top
			}, 500);

			return false;
		});

	};


	// Page Nav
	var clickMenu = function() {

		$('#navbar a:not([class="external"])').click(function(event){
			var section = $(this).data('nav-section'),
				navbar = $('#navbar');

				if ( $('[data-section="' + section + '"]').length ) {
			    	$('html, body').animate({
			        	scrollTop: $('[data-section="' + section + '"]').offset().top
			    	}, 500);
			   }

		    if ( navbar.is(':visible')) {
		    	navbar.removeClass('in');
		    	navbar.attr('aria-expanded', 'false');
		    	$('.js-fh5co-nav-toggle').removeClass('active');
		    }

		    event.preventDefault();
		    return false;
		});


	};

	// Reflect scrolling in navigation
	var navActive = function(section) {

		var $el = $('#navbar > ul');
		$el.find('li').removeClass('active');
		$el.each(function(){
			$(this).find('a[data-nav-section="'+section+'"]').closest('li').addClass('active');
		});

	};

	// var navigationSection = function() {

	// 	var $section = $('section[data-section]');

	// 	$section.waypoint(function(direction) {

	// 	  	if (direction === 'down') {
	// 	    	navActive($(this.element).data('section'));
	// 	  	}
	// 	}, {
	//   		offset: '150px'
	// 	});

	// 	$section.waypoint(function(direction) {
	// 	  	if (direction === 'up') {
	// 	    	navActive($(this.element).data('section'));
	// 	  	}
	// 	}, {
	// 	  	offset: function() { return -$(this.element).height() + 155; }
	// 	});

	// };





	// Window Scroll
	var windowScroll = function() {
		var lastScrollTop = 0;

		$(window).scroll(function(event){

		   	var header = $('#fh5co-header'),
				scrlTop = $(this).scrollTop();

			if ( scrlTop > 500 && scrlTop <= 2000 ) {
				header.addClass('navbar-fixed-top fh5co-animated slideInDown');
			} else if ( scrlTop <= 500) {
				if ( header.hasClass('navbar-fixed-top') ) {
					header.addClass('navbar-fixed-top fh5co-animated slideOutUp');
					setTimeout(function(){
						header.removeClass('navbar-fixed-top fh5co-animated slideInDown slideOutUp');
					}, 100 );
				}
			}

		});
	};



	// Animations
	// Home


	// var workAnimate = function() {
	// 	if ( $('#lst-lengua').length > 0 ) {

	// 		$('#lst-lengua').waypoint( function( direction ) {

	// 			if( direction === 'down' && !$(this.element).hasClass('animated') ) {


	// 				setTimeout(function() {
	// 					$('#lst-lengua .to-animate').each(function( k ) {
	// 						var el = $(this);

	// 						setTimeout ( function () {
	// 							el.addClass('fadeInUp animated');
	// 						},  k * 200, 'easeInOutExpo' );

	// 					});
	// 				}, 200);


	// 				$(this.element).addClass('animated');

	// 			}
	// 		} , { offset: '80%' } );

	// 	}
	// };



	var lenguaTraductor = function() {
		$(".dropdown").hover(
		function() {
		    $('.dropdown-menu', this).stop( true, true ).fadeIn("fast");
		    $(this).toggleClass('open');
		    $('b', this).toggleClass("caret caret-up");
		},
		function() {
		    $('.dropdown-menu', this).stop( true, true ).fadeOut("fast");
		    $(this).toggleClass('open');
		    $('b', this).toggleClass("caret caret-up");
		});

	};

	var loginAnimate = function() {
		var about = $('#panel-login');
		if ( about.length > 0 ) {

			about.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {


					setTimeout(function() {
						about.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInLeftBig animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);



					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

///add marcelo

	// Document on load.


	$(function(){
		// CloseBottom();

		// parallax();

		// burgerMenu();

		clickMenu();

		windowScroll();

		// navigationSection();

		goToTop();


		// Animations


		// workAnimate();

		//lenguaTraductor();
		ocultarGlosario();
		// loginAnimate();
		//listarFondoBeanSwPredet();

	});


}());

	 function CloseBottom() {
		$("#panel-login").animate({right: "-500px"});

		/** RESET LOGIN **/
		$('#txtUsernameLogin').val('');
		$('#txtPasswordLogin').val('');
		$('#boxMsgValid').empty();

	};
	 function OpenLogin() {
		$("#panel-login").animate({right: "130px"});
		var about = $('#panel-login');
		if ( about.length > 0 ) {

			about.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {


					setTimeout(function() {
						about.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInRightBig animated');
							},  k * 100, 'easeInOutExpo' );

						});
					}, 200);



					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
		/** FOCUS NOMBRE USUARIO **/
		$('#txtUsernameLogin').focus();
	};

	function showTIenda(){
		$('#modal-tienda-app').modal("show");
		$('#nav-modal-minendu .nav-item #base-pill1').trigger('click');
	}
	function showTIendaDetalle(){
		$('#item_detalle_modal').modal("show");
	}

	function mostrarGlosario(){
		var glosa= $("#glosarioArchivo").val();
		if(glosa!=null && glosa != ""){
			verDocumentoGlosario();
		}

	}

	function verDocumentoGlosario() {


		$("#txt_confir_Vd").html($("#trad_12").val());
		$("#btnCerrarModal").html($("#trad_14").val());
		$("#dataInfoModal").empty();

		$('#Glosario').modal('show');


		var object = "<object data='"+$("#glosarioArchivo").val()+"' type='application/pdf' width='100%' height='450px'>"+ "<embed src='"+$("#glosarioArchivo").val()+"' type='application/pdf' />" +"</object>";

		$( "#Glosario #dataInfoModal" ).empty();
		$( "#Glosario #dataInfoModal" ).append( object );
	}

	function ocultarGlosario(){
		$('#content-text-glosario').hide("linear");
	}

	function showTIendaDetalle2(adquisicion,numMonedas,imagen,tipo){

		//console.log("Tipo:" + tipo);

		var context  = $('#contextPathUrl').val();
		var urlCarp = (tipo == 1 ? context+'/mascota/' : (tipo == 2 ? context+'/fondo/' : '../assets/images/items/combos.png' ));
		//console.log("url: "+urlCarp);
		//console.log(context);
		document.getElementById('tiendaImagenDetalle').src = urlCarp+imagen;//context+'/mascota/'+imagen;
		document.getElementById('tiendaImagenDetalle').alt = imagen;
		$('#item_detalle_modal #codigoArticulo').val(adquisicion);
		$('#item_detalle_modal #tipoArticulo').val(tipo);
		$('#item_detalle_modal #precio').html("<i class='icon-minedu-precio'></i> "+numMonedas);
		$('#item_detalle_modal #cantidadMonedas').val(numMonedas);
		$('#item_detalle_modal').modal("show");
	}
	function showTPremio(){
		$('#modal-premio-app').modal("show");
		$('#nav-premio-minendu .nav-item #base-mvict').trigger('click');
	}
	function hide_detalle_moneda(){
		$(".tab-medalla").show();
		$("#md-detalle-medalla").hide();
	}

	function traducir(){
		$("#tituloComprar").html($("#trad_1").val());
		//$("#btnNextMaterial").html($("#trad_2").val());
		$("#tituloMascota").html($("#trad_3").val());
		$("#tituloFondo").html($("#trad_4").val());
		$("#tituloCombo").html($("#trad_5").val());
		$("#tituloBonus").html($("#trad_6").val());

		$("#tituloPerfil").html($("#trad_8").val());
		$("#tituloConfiguracion").html($("#trad_32").val());
		$("#tituloMisReportes").html($("#trad_9").val());
		$("#tituloCerrarSesion").html($("#trad_10").val());
		$("#tituloTienda").html($("#trad_11").val());

		$("#tituloMascotaPremio").html($("#trad_3").val());
		$("#tituloMedalla").html($("#trad_15").val());
		$("#tituloFondoPantalla").html($("#trad_16").val());
		$("#tituloMiBonus").html($("#trad_17").val());
		$("#tituloMedallaBasica").html($("#trad_18").val());
		$("#tituloMedallaHonorifica").html($("#trad_19").val());
		$("#tituloMedallaPremium").html($("#trad_20").val());

	}

	/*function traducirPremios(){

		$("#tituloMascotaPremio").html($("#trad_3").val());
		$("#tituloFondoPantalla").html($("#trad_16").val());

		$("#tituloMedalla").html($("#trad_15").val());
		$("#tituloFondoPantalla").html($("#trad_16").val());
		$("#tituloMiBonus").html($("#trad_17").val());

		$("#tituloMedallaBasica").html($("#trad_18").val());
		$("#tituloMedallaHonorifica").html($("#trad_19").val());
		$("#tituloMedallaPremium").html($("#trad_20").val());
	}*/


	function traducirModalEvaluacion(){

		$("#tituloEvaluacionCon").html($("#trad_21").val() + " " + $("#trad_28").val());
		$("#tituloPuntuacion").html($("#trad_22").val());

		$("#tituloHoraIni").html($("#trad_23").val());
		$("#tituloHoraFin").html($("#trad_24").val());
		$("#tituloResultadoFin").html($("#trad_25").val());

		$("#tituloNotaFin").html($("#trad_26").val());
		$("#tituloFinalizar").html($("#trad_27").val());
	}

	function traducirModalEvaluacionInicio(){

		$("#tituloEvalIni").html($("#trad_21").val());
		$("#tituloHoraIniEva").html($("#trad_23").val());

		$("#tituloTotalEje").html($("#trad_30").val());
		$("#emEval1").html($("#trad_29").val());

	}

	function traducirModalEvaluacionCaducado(){

		$("#tituloTiempoCaducadoEva").html($("#trad_31").val());
		$("#tituloPuntuacionFin").html($("#trad_22").val());

		$("#tituloHoraIniCad").html($("#trad_23").val());
		$("#tituloHoraFinCad").html($("#trad_24").val());
		$("#tituloResultFinCad").html($("#trad_25").val());

		$("#tituloNotaCad").html($("#trad_26").val());
		//$("#tituloContinuarCad").html($("#trad_2").val());
	}

	function traducirSub(){
		//$("#btnevaluar").html($("#trad_2").val());
		//$("#btn_validar_ejercicio").html("<i class='fa fa-floppy-o'></i>" + $("#trad_2").val());
		//var icono = '<i class="pull right"><img src="'+contextConfigRuta+'/assets/images/icono-ejercicio/glosario-icono.png" height="14" style="margin-bottom: 4px;opacity: 0.3;"></i>';
		var icono = '<i class="pull-right fa fa-book" style="margin-top: 4px;"></i>';
		//$("#glosario-link").html($("#trad_12").val() + '<i class="fa fa-leanpub"></i>');
		$("#glosario-link").html($("#trad_12").val() + icono);
	}

	function traducirModalMed(){
		$("#msjFelicidadesGP").html($("#msj_23").val());

		$("#msjObtMedGP").html($("#msj_4").val());
		$("#tituloContinuarGP").html($("#trad_2").val());
	}

	function traducirModalMedEva(){
		$("#msjFelicidadesGPEva").html($("#msj_23").val());

		$("#msjObtMedGPEva").html($("#msj_4").val());
		$("#tituloContinuarGPEva").html($("#trad_2").val());
	}
	// funciones para audio

function playAudio() {
	var music = $("#music");
	var pButton = $("#pVolumen");

    // start music
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

function volAudio() {
	var music = $("#music");
	var pVolumen = $("#pVolumen");

    // start music
    if (music.volume) {
        music.volume =1;
        // remove play, add pause
        pVolumen.removeClass('icon-minedu-volumen-mute');
        pVolumen.addClass('icon-minedu-volumen');
    } else { // pause music
         music.volume =0;
        // remove pause, add play
        pVolumen.removeClass('icon-minedu-volumen');
        pVolumen.addClass('icon-minedu-volumen-mute');
    }
}

/** ACTIVACION DE ANIMACION MASCOTA NORMAL **/
var contextConfigRuta = $('#contextPathUrl').val();

$('#idCheckActiveAnimMasc').change(function() {
	   var check = this;
	   var valor = 0;

	   if($(this).is(':checked')) {
		    valor = 1;
	   } else {
		  	valor = 0;
	   }

	  $.ajax({
			type: "GET",
		    url : contextConfigRuta+'/lengua/activarAnimacionMascota',
		    data: {valor : valor},
	        success: function(data)
	        {
	        	valor = data;
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
		    	if(valor==1){
		    		$(check).val(1);
		    		$('#box-masct img').attr('src',contextConfigRuta+'/mascota/'+$('#idValImgNormalAnim').val());
	          		$('#box-masct img').attr('alt',$('#idValImgNormalAnim').val());
	     		}else{
	     			$(check).val(0);
	     			$("check").removeAttr('checked');
	     			$('#box-masct img').attr('src',contextConfigRuta+'/mascota/'+$('#idValImgNormal').val());
	        	  	$('#box-masct img').attr('alt',$('#idValImgNormal').val());
	         	}
		    }
	    });

	});

/** FIN DE METODO **/

	///load ajax
	let showLoad=()=> $('.main-ajax').css('display','flex')
	let hideLoad=()=> $('.main-ajax').css('display','none')

	let generateHeight =()=>{
		$('body').addClass('bodyClas')
		let windo   = $( window ).height()
		let divCont = $('#lst-lengua').css('min-height', windo)
	}

	generateHeight();



  var trigger = $('.hamburger'),
      overlay = $('.overlay'),
     isClosed = false;

    trigger.click(function () {
      hamburger_cross();
    });

    function hamburger_cross() {
      if (isClosed == true) {
        overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
        isClosed = false;
        menu_tree_view(isClosed);
      } else {
        overlay.show();
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
        isClosed = true;
        menu_tree_view(isClosed);
      }
  }


  function menu_tree_view (isClosed){
   var height_treeview = $("#main-tree-view").height();
   	height_treeview = height_treeview -75;
   	$("#main-tree-view #tree-list").css('height', height_treeview+'px');
  	if (isClosed) {
  		$("#main-tree-view").css("left","0");
  		$("#main-tree-view h3").removeClass("efect-show");
  		$("#main-tree-view .hamburger").css("right","0");

  	} else {
  		var mi_ancho = $("#main-tree-view").width();
  		 mi_ancho = mi_ancho + 40;
  		$("#main-tree-view .hamburger").css({
  			'right': '-80px',
  			'transition': 'all .3s'
  		});
  		$("#main-tree-view").css("left","-"+mi_ancho+"px");
  		$("#main-tree-view h3").addClass("efect-show");
  	}
  }

 function calcularAnchoTree(){
  	var mi_ancho = $("#main-tree-view").width();
 }

   function ocultarDiv(){$('#content-text-info').hide("linear")}

   function mostrarDiv(){$('#content-text-info').show()}

   function ocultarDivGlosario(){$('#content-text-glosario').hide("linear")}

   function mostrarDivGlosario(){$('#content-text-glosario').show()}

   function ocultarDivNew(){
	  $('#content-text-info').hide(),
	  $('#idShowIndGram').show()
  }

  function mostrarDivNew(){
	  $('#content-text-info').show(),
	  $('#idShowIndGram').hide()
  }