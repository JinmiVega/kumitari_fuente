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

	// Parallax
	var parallax = function() {
		$(window).stellar();
	};



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

	var navigationSection = function() {

		var $section = $('section[data-section]');

		$section.waypoint(function(direction) {

		  	if (direction === 'down') {
		    	navActive($(this.element).data('section'));
		  	}
		}, {
	  		offset: '150px'
		});

		$section.waypoint(function(direction) {
		  	if (direction === 'up') {
		    	navActive($(this.element).data('section'));
		  	}
		}, {
		  	offset: function() { return -$(this.element).height() + 155; }
		});

	};





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

	var homeAnimate = function() {
		if ( $('#fh5co-home').length > 0 ) {

			$('#fh5co-home').waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {


					setTimeout(function() {
						$('#fh5co-home .to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);


					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};


	var introAnimate = function() {
		if ( $('#fh5co-intro').length > 0 ) {

			$('#fh5co-intro').waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {


					setTimeout(function() {
						$('#fh5co-intro .to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInRight animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 1000);


					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

	var workAnimate = function() {
		if ( $('#fh5co-work').length > 0 ) {

			$('#fh5co-work').waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {


					setTimeout(function() {
						$('#fh5co-work .to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);


					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

	var workAnimate = function() {
		if ( $('#lst-lengua').length > 0 ) {

			$('#lst-lengua').waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {


					setTimeout(function() {
						$('#lst-lengua .to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);


					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

	var testimonialAnimate = function() {
		var testimonial = $('#quienes-somos');
		if ( testimonial.length > 0 ) {

			testimonial.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {

					var sec = testimonial.find('.to-animate').length,
						sec = parseInt((sec * 200) - 400);

					setTimeout(function() {
						testimonial.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);

					setTimeout(function() {
						testimonial.find('.to-animate-2').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInDown animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, sec);


					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

	var servicesAnimate = function() {
		var services = $('#fh5co-services');
		if ( services.length > 0 ) {

			services.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {

					var sec = services.find('.to-animate').length,
						sec = parseInt((sec * 200) + 400);

					setTimeout(function() {
						services.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);

					setTimeout(function() {
						services.find('.to-animate-2').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('bounceIn animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, sec);



					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

	var aboutAnimate = function() {
		var about = $('#fh5co-about');
		if ( about.length > 0 ) {

			about.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {


					setTimeout(function() {
						about.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);



					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

	var countersAnimate = function() {
		var counters = $('#fh5co-counters');
		if ( counters.length > 0 ) {

			counters.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {

					var sec = counters.find('.to-animate').length,
						sec = parseInt((sec * 200) + 400);

					setTimeout(function() {
						counters.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);

					setTimeout(function() {
						counters.find('.js-counter').countTo({
						 	formatter: function (value, options) {
				      		return value.toFixed(options.decimals);
				   		},
						});
					}, 400);

					setTimeout(function() {
						counters.find('.to-animate-2').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('bounceIn animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, sec);





					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};


	var contactAnimate = function() {
		var contact = $('#fh5co-contact');
		if ( contact.length > 0 ) {

			contact.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {

					setTimeout(function() {
						contact.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);

					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};

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
	var seccionQuinesSomos = function() {
		var testimonial = $('#quienes-somos');
		if ( testimonial.length > 0 ) {

			testimonial.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {

					var sec = testimonial.find('.to-animate').length,
						sec = parseInt((sec * 200) - 400);

					setTimeout(function() {
						testimonial.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);

					setTimeout(function() {
						testimonial.find('.to-animate-2').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInDown animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, sec);


					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};


	var seccionDescarga = function() {
		var testimonial = $('#secction-descarga');
		if ( testimonial.length > 0 ) {

			testimonial.waypoint( function( direction ) {

				if( direction === 'down' && !$(this.element).hasClass('animated') ) {

					var sec = testimonial.find('.to-animate').length,
						sec = parseInt((sec * 200) - 400);

					setTimeout(function() {
						testimonial.find('.to-animate').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInUp animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, 200);

					setTimeout(function() {
						testimonial.find('.to-animate-2').each(function( k ) {
							var el = $(this);

							setTimeout ( function () {
								el.addClass('fadeInDown animated');
							},  k * 200, 'easeInOutExpo' );

						});
					}, sec);


					$(this.element).addClass('animated');

				}
			} , { offset: '80%' } );

		}
	};
	// Document on load.


	$(function(){
		// CloseBottom();

		parallax();

		// burgerMenu();

		clickMenu();

		windowScroll();

		navigationSection();

		goToTop();


		// Animations
		homeAnimate();
		introAnimate();
		workAnimate();
		testimonialAnimate();
		seccionQuinesSomos();
		seccionDescarga();
		servicesAnimate();
		aboutAnimate();
		countersAnimate();
		contactAnimate();
		//lenguaTraductor();
		ocultarGlosario();
		// loginAnimate();
		//listarFondoBeanSwPredet();

	});


}());

	 function CloseBottom() {
		$("#panel-login").animate({right: "-300px"});

		/** RESET LOGIN **/
		$('#txtUsernameLogin').val('');
		$('#txtPasswordLogin').val('');
		$('#boxMsgValid').empty();

	};
	 function OpenLogin() {
		$("#panel-login").animate({right: "10%"});
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
	function showTIendaDetalle2(adquisicion,numMonedas,imagen,tipo){
		//console.log("Tipo:" + tipo);

		var context  = $('#contextPathUrl').val();
		var urlCarp = (tipo == 1 ? context+'/mascota/' : (tipo == 2 ? '/procalidad/fondo/' : '../assets/images/items/combos.png' ));
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

	function traducir(){
		$("#tituloComprar").html($("#trad_1").val());
		$("#btnNextMaterial").html($("#trad_2").val());
		$("#tituloMascota").html($("#trad_3").val());
		$("#tituloFondo").html($("#trad_4").val());
		$("#tituloCombo").html($("#trad_5").val());
		$("#tituloBonus").html($("#trad_6").val());

		$("#tituloPerfil").html($("#trad_8").val());
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
	function traducirPremios(){

		$("#tituloMascotaPremio").html($("#trad_3").val());
		$("#tituloFondoPantalla").html($("#trad_16").val());

		$("#tituloMedalla").html($("#trad_15").val());
		$("#tituloFondoPantalla").html($("#trad_16").val());
		$("#tituloMiBonus").html($("#trad_17").val());

		$("#tituloMedallaBasica").html($("#trad_18").val());
		$("#tituloMedallaHonorifica").html($("#trad_19").val());
		$("#tituloMedallaPremium").html($("#trad_20").val());
	}
	function traducirSub(){
		$("#btnevaluar").html($("#trad_2").val());
		$("#btn_validar_ejercicio").html("<i class='fa fa-floppy-o'></i>" + $("#trad_2").val());
		$("#glosario-link").html($("#trad_12").val() + '<i class="fa fa-sort-alpha-desc"></i>');

	}

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
		$("#tituloContinuarCad").html($("#trad_2").val());
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

	///load ajax
	let showLoad=()=> $('.main-ajax').css('display','flex')
	let hideLoad=()=> $('.main-ajax').css('display','none')

	let generateHeight =()=>{
		$('body').addClass('bodyClas')
		let windo   = $( window ).height()
		let divCont = $('#lst-lengua').css('min-height', windo)
	}

	generateHeight();

	let ocultarDiv=()=> $('#content-text-info').hide("linear")

	let mostrarDiv=()=> $('#content-text-info').show()

	let ocultarDivGlosario=()=> $('#content-text-glosario').hide("linear")
