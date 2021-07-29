

function cargarContenidoPremio(valor,id){

	$('#nav-premio-minendu ul li').removeClass('active');
	$('#nav-premio-minendu .nav-item #'+id).addClass('active');

	enviar_ajaxPremio(valor);
}
 
function enviar_ajaxPremio(valor){
//	debugger;
	showLoadx();
	var swListaVacia = true;
	var listado = [];
	var lengua= $('#codlenguaTreeVal').val();
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/listarTienda';
//	var data = 'valor='+valor+'';

	if(!lengua){
		return;
	}

	$.ajax({
		 async: true,
		type: "GET",
		data: {usuarioMatricula:null,tipo:0,valor:valor,lengua:lengua},
	    url : url,
        success: function(data)
        {
        	if(data!=null && data.length>0){
        		 
        		swListaVacia = false;
        		listado = data;
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
	   		hideLoadx();
		   if(swListaVacia){
			    html = '<span style="font-size:15px;"><b>No se encontraron resultados</b></span>';
			   	if(valor == 1){
			   		$('#idRowContentMascota').html(html);
			   	}else if(valor == 2){
			   		$('#idRowContentFondo').html(html);
				}else if(valor == 3){
					$('#idRowContentCombos').html(html);
				}else if(valor == 4){
					$('#miBonus').html(html);
				}else if(valor == 5){
					$('#medallasVictoriosas').html(html);
					$('#medallasHonorificas').html(html);
					$('#medallasPremium').html(html);
				}

		   }else{
			   	if(valor == 1){
			   		listarMascotasPremios(listado);
				}else if(valor == 2){
					listarFondosPremios(listado);
				}else if(valor == 5){
					var listaH = [];
					var listaB = [];
					var listaP = [];
					for (var i = 0; i < listado.length; i++) {
						var item = listado[i];
						if(item.premioBean.tipo.codigoRegistro==1){
							listaB.push(item);
						}else if(item.premioBean.tipo.codigoRegistro==2){
							listaH.push(item);
						}
						else if(item.premioBean.tipo.codigoRegistro==3){
							listaP.push(item);
						}
					}

						listarMedallas(listaB,'medallasVictoriosas');
						listarMedallas(listaH,'medallasHonorificas');
						listarMedallas(listaP,'medallasPremium');

					// if(listaB!=null && listaB.length>0){
					// 	listarMedallas(listaB,'medallasVictoriosas');
					// }
					// if(listaH!=null && listaH.length>0){
					// 	listarMedallas(listaH,'medallasHonorificas');
					// }
					// if(listaP!=null && listaP.length>0){
					// 	listarMedallas(listaP,'medallasPremium');
					// }

				}else if(valor == 4){
					$('#mvict').removeClass('active');
					$('#miBonus').addClass('active');
					 listarBonosPremios(listado);
				}
			   	$('[data-toggle="popover"]').popover();
		   }

	   }
    });

}




function listarMascotasPremios(lista){
	var html = '';
	var context  = $('#contextPathUrl').val();

	for (var i = 0; i < lista.length; i++) {
		var mascota = lista[i];
		if(mascota.cantidadComprado>0){
			html += '<div class="col-md-4" style="margin-bottom:15px">'+
						'<a href="#" onclick="actualizarSwPredeterminadoMasc('+mascota.codigo+')">'+
						'<div class="item-tienda">'+
							'<div class="item-img-tienda">';
								if(mascota.imagenTienda!=null){
									html += '<img src="'+context+'/mascota/'+mascota.imagenTienda+'" class="img-responsive" alt="'+mascota.imagenTienda+'">';
								}else{
									html += '<img src="'+context+'/assets/images/items/no-disponible.jpg" class="img-responsive" alt="No Disponible">';
								}

						html += '</div>'+
								'<span class="item-checkmain" id="btn_'+mascota.codigo+'">';
								if(mascota.nSwpredeterminado==1){
									html += '<span class="ichek-active" ><i class="fa fa-check" aria-hidden="true"></i></span>';
								}
						html +=	'</span>'+
					'</div>'+
					'</a>'+
				'</div>';
		}

	}

	$('#masc').html(html);
}


function listarBonosPremios(lista){
	var html = '';
	var context  = $('#contextPathUrl').val();
	var cont=0;
	for (var i = 0; i < lista.length; i++) {
		var bono = lista[i]; 
			html += '<div class="col-md-4">'+						
						'<a href="#" style="text-decoration: none;"  onclick="usarBono('+bono.bonoBean.codigo+','+bono.bonoBean.tipo.codigoRegistro+','+bono.codigo+')" >'+
						'<div class="item-tienda">'+
							'<div class="item-img-tienda">';						

								 	html += '<img src="'+context+'/assets/images/items/combos.jpg" class="img-responsive" alt=""><div style="color: #e7e7e8;text-align: center;">'+bono.bonoBean.nombre+'</div>';																				

						html +=	'</div>'+
					'</div>'+
					'</a>'+
				'</div>';
		 
	}

	$('#miBonus').html(html);
}

function usarBono(codBono,tipo,codAlumnoBono){

//	debugger;
		if ($('#codEvaluacion').val() == undefined) {
			//console.log("Solo se  usa en  una  evaluacion.");
		}else{
			if ($('#codEvaluacion').val() > 0) {
				switch (tipo) {
				case 1:
					//console.log("Tipo tiempo");
					obtenerBono(codBono,codAlumnoBono);
			    	$('#modal-premio-app').modal("hide");
					break;
				case 2:
					//console.log("Tipo ejercicio");
					insertarEjercicioAdicional(codBono,codAlumnoBono);
					$('#modal-premio-app').modal("hide");
					break;

				default:
					//console.log("Error.");
					break;
				}
			}else{
				//console.log("Solo Evaluacion");
			}

		}


}


var tiempoSegundo = "";
function obtenerBono(codBono,p_codaluxbono){
//	alert(codBono);
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/obtenerBono';
	

	$.ajax({
		 async: true,
		type: "GET",
		data: {codBono : codBono},
	    url : url,
        success: function(data)
        {
//        	debugger;
        	if (data != null) {
//        		alert("Tiempo :: " + data.tiempo);
//        		debugger;
        		
				var tiempo = data.tiempo; // tomo el valor introducido del campo
//				var array_tiempo = tiempo.split(":"); // 
//				var h = array_tiempo[0];
//				var m = array_tiempo[1];
//				var s = array_tiempo[2];        		
//        		
//				if (h == '00') {
//					h = 0;
//				}
//				if (m == '00') {
//					m = 0;
//				}
//				if (s == '00') {
//					s = 0;
//				}
//				var hora = Math.floor(h * 3600);
//				var min = Math.floor(m * 60);
//				var seg = s;
				tiempoSegundo = (parseInt(tiempo)*60);
//        		alert('tiempoBono :: '+ tiempoSegundo);
        		$('#tiempoBono').val(tiempoSegundo);
				
			}else{
				//console.log("Null");
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
	    complete: function(){
	    	bonoAlumnoEliminar(p_codaluxbono);
	    	adicionarTiempoBono();
	    	
	    }
    });
	
}
function bonoAlumnoEliminar(p_codaluxbono){
//	alert("eliminar");
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/alumnobonoEliminar';
//	debugger;
	$.ajax({
		 async: true,
		type: "GET",
		data: {p_codaluxbono : p_codaluxbono},
	    url : url,
        success: function(data)
        {
        	if (data == "1") {
        		
        		//console.log("Exito al eliminar AlumnoBono");
        		
			}else{
				
				//console.log("Error al eliminar AlumnoBono");
				
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
	    complete: function(){	
	    
	    }
    });
	
}
function insertarEjercicioAdicional(p_codBono,p_codaluxbono){
//	debugger;
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/insertarEjercicioAdicional';
	var p_codlengua =  $('#codigoLengua').val(); 
	var p_tm2SubNivel = $('#codSubNivel').val();
	var p_codEva = $('#codEvaluacion').val();

	$.ajax({
		 async: true,
		type: "GET",
		data: {p_codBono : p_codBono,
			   p_codlengua : p_codlengua,
			   p_tm2SubNivel : p_tm2SubNivel,
			   p_codEva : p_codEva},
	    url : url,
        success: function(data)
        {
//        	debugger;
        	if (data != 0) {
        		//console.log("Exito al insertar.");
//				$('#codEvaDetBono').val(data);
//				$('#codMatTipoEjerBono').val('6039');
				buscarEjercicio(data);
			}else{
				//console.log("Error al insertar.");
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
	    complete: function(){
	    	
		    bonoAlumnoEliminar(p_codaluxbono);
//		    $(location).attr('href',context+'/lengua/'+$('#codigoLengua').val()+'/evaluacion/'+$('#codEvaluacion').val()); 
		    
	    }
    });
	
}
function buscarEjercicio(p_codEvaDet){
//	alert("eliminar");
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/buscarEjercicio';
//	debugger;
	$.ajax({
		 async: true,
		type: "GET",
		data: {p_codEvaDet : p_codEvaDet},
	    url : url,
        success: function(data)
        {
        	if (data != null) {
        		$('#codMatTipoEjerBono').val(data.materialTipoEjercicioBean.codigo);
        		
			}else{
				
				//console.log("Error al eliminar AlumnoBono");
				
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
	    complete: function(){	
	    
	    }
    });
	
}

function listarFondosPremios(lista){
	var html = '';
	var context  = $('#contextPathUrl').val();
	var cont=0;
	for (var i = 0; i < lista.length; i++) {
		var fondo = lista[i];
		if(fondo.cantidadComprado>0){
			html += '<div class="col-md-4">'+
						'<a href="#" onclick="actualizarSwPredeterminadoFond('+fondo.codigo+')">'+
						'<div class="item-tienda">'+
							'<div class="item-img-tienda">';
								if(fondo.imagenNombreTienda!=null){
															//'+context+'
									html += '<img src="'+context+'/fondo/'+fondo.imagenNombreTienda+'" class="img-responsive" alt="'+fondo.imagenNombreTienda+'">';
								}else{
									html += '<img src="'+context+'/assets/images/items/no-disponible.jpg" class="img-responsive" alt="">';
								}
						html += '</div>'+
								'<span class="item-checkmain" id="btn_'+fondo.codigo+'">';
								if(fondo.nSwpredeterminado==1){
									html += '<span class="ichek-active" ><i class="fa fa-check" aria-hidden="true"></i></span>';
								}
						html +=	'</span>'+
					'</div>'+
					'</a>'+
				'</div>';
		}
	}

	$('#fdpanta').html(html);
}

function listarMedallas(lista,tipo){

	$('#content-premio-minendu .carousel').carousel({
  	interval: 2000
	})
	//console.log(lista);
	//console.log(lista.length);
	var html = '';
	var htmlHonor = '';
	var context  = $('#contextPathUrl').val();
	var cont=0;
	if(lista != null && lista.length>0){
		for (var i = 0; i < lista.length; i++) {
			var medalla = lista[i];
			//console.log(medalla);
			if(i==0){
				html += '<div class="item active">'+
							'<div class="col-xs-12 col-sm-4 col-md-4 gp_products_item">'+
								'<div class="gp_medallas_inner">'+
									'<div class="gp_medallas_item_image">'+
										'<a href="#" >'+
											'<img src="'+context+'/premio/'+medalla.premioBean.imagenNombre+'" alt="'+medalla.premioBean.imagenNombre+'" class="img-responsive img-circle"/>'+

										'</a>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>';
			}else{
				html += '<div class="item">'+
							'<div class="col-xs-12 col-sm-4 col-md-4 gp_products_item">'+
								'<div class="gp_medallas_inner">'+
									'<div class="gp_medallas_item_image">'+
										'<a href="#">'+
											'<img src="'+context+'/premio/'+medalla.premioBean.imagenNombre+'" alt="'+medalla.premioBean.imagenNombre+'" class="img-responsive img-circle"/>'+
										'</a>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>';
			}

		}

		$('#'+tipo).parent('.carousel').removeClass('hiden-cr');
		$('#'+tipo).html(html);
		carga(tipo);
	}else{
		$('#'+tipo).parent('.carousel').addClass('hiden-cr');
	}




}

function carga(tipo){
	$('#'+tipo).carousel({
		interval: 2000
	});
    $('#'+tipo+'.item').each(function(){
        var itemToClone = $(this);
        for (var i=1;i<3;i++) {
            itemToClone = itemToClone.next();
            // wrap around if at end of item collection
            if (!itemToClone.length) {
                itemToClone = $(this).siblings(':first');
            }
            // grab item, clone, add marker class, add to collection
            itemToClone.children(':first-child').clone()
            .addClass("cloneditem-"+(i))
            .appendTo($(this));
        }
    });
}

function actualizarSwPredeterminadoMasc(valor){
	
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/actualizarAdquisicionSwPredeterMasc';
	var data = 'codMasc='+valor;

	$.ajax({
		 async: true,
		type: "POST",
		data: data,
	    url : url,
        success: function(data)
        {
        	if (data==1) {
        		// alert('se agrego correctamente');
        		$('#base-masc').trigger('click');
        		listarMascotaBeanSwPredet();
        		//cargarContenidoPremio(1,'base-masc');
			}else if(data==2){
				alert('Error');
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
	   }
    });

}

function showLoadx(){$('.ajaxEfect .main-ajax').css('display','flex');}
function hideLoadx(){$('.ajaxEfect .main-ajax').css('display','none');}

function actualizarSwPredeterminadoFond(valor){

	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/actualizarAdquisicionSwPredeterFond';
	var data = 'codFond='+valor;

	$.ajax({
		 async: true,
		type: "POST",
		data: data,
	    url : url,
        success: function(data)
        {
        	if (data==1) {
        		// alert('se agrego correctamente');
        		$('#base-fdpanta').trigger('click');
        		listarFondoBeanSwPredet();

        		//cargarContenidoPremio(1,'base-masc');
			}else if(data==2){
				alert('Error');
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
	   }
    });

}

function listarMascotaBeanSwPredet(){
	var html = '';
	var context  = $('#contextPathUrl').val();
	var url = context+'/lengua/listarMascotaBeanSwPredet';
	var img = context+'/assets/images/plumillaNeutro.png';
	var alt = 'No Disponible';
	var bean = null;

	$.ajax({
		 async: true,
		type: "GET",
	    url : url,
        success: function(data)
        {
        	if(data!=null && data.imagenNormal!=null){
        		bean = data;
        		//console.log('trajo mascota predeterminada');
    			img = context+'/mascota/'+data.imagenNormal;
    			alt = data.imagenNormal;
			}

        	$('#box-masct img').attr('src',img);
        	$('#box-masct img').attr('alt',alt);
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
	    	actualizarValoresImgPredUsu(bean);
	    }
    });

}

function actualizarValoresImgPredUsu(data){
	if($('#idValImgNormal')){
		$('#idValImgNormal').val( (data && data.imagenNormal) ? data.imagenNormal : '' );
	}
	if($('#idValImgAlegre')){
		$('#idValImgAlegre').val( (data && data.imagenAlegre) ? data.imagenAlegre : '' );
	}
	if($('#idValImgTriste')){
		$('#idValImgTriste').val( (data && data.imagenTriste) ? data.imagenTriste : '' );
	}
	if($('#idValImgExclam')){
		$('#idValImgExclam').val( (data && data.imagenExclamativa) ? data.imagenExclamativa : '' );
	}
	if($('#idValImgNormalAnim')){
		$('#idValImgNormalAnim').val( (data && data.imagenNormalAlter) ? data.imagenNormalAlter : '' );
	}
}

function listarFondoBeanSwPredet(){


	var html = '';
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/listarFondoBeanSwPredet';


	$.ajax({
		 async: true,
		type: "GET",
	    url : url,
        success: function(data)
        {


        		if(data.imagenNombre!=null){
        			//console.log('trajo fondo predeterminada');
        			fondoPrincipal(data.imagenNombre);
					//html += '<img src="'+context+'/mascota/'+data.imagenNombre+'" class="img-responsive" alt="'+data.imagenNombre+'">';
				}else{
					//console.log('no lo trajo fondo');
					$("#oterPageHeader #div-fondo-ajax").html('<style type="text/css">.bg-fondo-app::after{background-image:url("");} </style>');

					//alert('no lo trajo fondo');
					//html += '<img src="'+context+'/assets/images/items/no-disponible.jpg" class="img-responsive" alt="No Disponible">';
				}

        		//document.getElementById("box-masct").innerHTML=html;
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
	   }
    });
}

function BuscarMedallaObtenida(codigo){
	 var context  = $('#contextPathUrl').val();
	 var tipo="";
	 var url =  contextPath+"/lengua/BuscarMedallaObtenida";

	    $.ajax({
	    	 async: true,
	        type : 'POST',
	        data :{p_codaluxmeda:codigo},
	        url : url,
	      success : function(data)
	      {
	    	  if(data) {
	    		  if(data.tipo.codigoRegistro==1){
	    			  tipo="BÁSICA";
	    		  }else if(data.tipo.codigoRegistro==2){
	    			  tipo="HONORIFICA";
	    		  }else{
	    			  tipo="PREMIUM";
	    		  }
	    			location.href = '#';

	    		  $('#text-premio').html("<h4>¡Felicidades!</h4>" +
	    		  		"<p style='color:white;'>Obtuviste una medalla de colección <br> "+tipo+" : <b>"+data.nombre+"</b>" +
	    		  		"</p>");

	    		  $('#cont-premio').html('<img src="'+contextPath+'/premio/'+data.imagenNombre+'" class="img-responsive" alt="">');
	    		  $('#premio-ganar-modal').modal('show');
	    		  $('#text-premio').html("<h4></h4>" +
		    		  		"<p style='color:white;'> <br> "+tipo+" : <b>"+data.nombre+"</b>" +
		    		  		"</p>");

		    		  $('#cont-premio').html('<img src="'+contextPath+'/premio/'+data.imagenNombre+'" class="img-responsive" alt="">');
		    		  $('#premio-ganar-modal').modal('show');
	    	  }


		      },
		      error: function(data) {
//		    	  location.href = urlcont;
		    	//console.log("error ");
				      }
		    });
}


function insertarMedallaAlumno(categoria){
	//debugger;
			var leccion = $("#codleccionVal").val();
			var usumat = $('#codusuariomat').val();
			if(usumat!=0 && usumat!='' && usumat!=null && usumat!=undefined){
			var url = contextPath+"/lengua/grabarMedallaAlumno";
		$.ajax({
			 	async: true,
				type 	: "POST",
				data 	: { p_codusumat:usumat,
							p_codcateg : categoria,
							p_codundlec: leccion },
				url 	: url,
				success : function(data)
				{	
					if (data != 0) {
						urlcont='#';
						BuscarMonedasygemasXcategoria(categoria);
						BuscarMedallaObtenida(data);
					 
					}
					else
					{   
//						urlcont = context+'/lengua/detalle/'+codlengua+'/nivel/'+codlenest+'/unidad/'+codunidad+'/leccion/'+codleccion;
						urlcont = context+'/lengua/detalle/'+codlenguaEncrypt+'/nivel/'+codlenestEncrypt+'/unidad/'+codunidadEncrypt+'/leccion/'+codleccionEncrypt;
					//console.log("No se inserto medalla");
				}
				},
				error : function()
				{
					console.log("ERROR: ");
				}
			});
			}else
				{
//				//console.log("No es alumno");
				}
}




function BuscarMonedasygemasXcategoria(codigo){
	 var context  = $('#contextPathUrl').val();
	 var tipo="";
	 var url =  contextPath+"/lengua/BuscarGemasMonedasXcategoria";

	    $.ajax({
	    	 async: true,
	        type : 'POST',
	        data :{p_tm2categ:codigo},
	        url : url,
	      success : function(data)
	      {
	    	  if(data) {
	    		 
	    		  guardarMonedasYgemasXcategoria(data.monedas,data.gemas);
	    	  }
		      },
		      error: function(data) {
//		    	  location.href = urlcont;
		    	//console.log("error ");
				      }
		    });
}

$( "#link-salir" ).click(function() {
    //location.href =context+'/lengua/detalle/'+codlengua+'/nivel/'+codlenest+'/unidad/'+codunidad+'/leccion/'+codleccion;
    location.href =context+'/lengua/detalle/'+codlenguaEncrypt+'/nivel/'+codlenestEncrypt+'/unidad/'+codunidadEncrypt+'/leccion/'+codleccionEncrypt;
  });




function insertarBonoAlumno(){  
	 
			var leccion = $("#codleccionVal").val(); 
			var usumat = $('#codusuariomat').val();
			if(usumat!=0 && usumat!='' && usumat!=null && usumat!=undefined){
			var url = contextPath+"/lengua/grabarBonoAlumno";
		$.ajax({
			 	async: true,
				type 	: "POST",
				data 	: { p_codusumat:usumat,  
							p_codundlec: leccion },
				url 	: url,
				success : function(data)
				{
					if (data != 0) { 
						 
					}
					else{
//					{    //console.log("No se inserto bono");
				}
				},
				error : function()
				{
					//console.log("ERROR: ");
				}
			});
			}else
				{
//				console.log("No es alumno");
				} 
}
  

 

