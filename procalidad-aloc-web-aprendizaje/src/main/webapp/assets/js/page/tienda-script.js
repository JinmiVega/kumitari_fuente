function cargarContenidoTienda(valor){
	
	$('#nav-modal-minendu ul li').removeClass('active');
	$('#nav-modal-minendu .nav-item #base-pill'+valor).addClass('active');
	
	enviar_ajax(valor);
}

function enviar_ajax(valor){
//	monedaGemaObtenidas();
	var swListaVacia = true;
	var listado = [];
	
	var context  = $('#contextPathUrl').val();
	var url = context+'/inicio/listarTienda';
	var codlengua = $('#codlenguaTreeVal').val();
	var usuarioMatricula = $('#codusumatriBean').val();
	if(!codlengua){
		return;
	} 
	 
	$.ajax({
		 async: true,
		type: "GET",
		data: { usuarioMatricula:usuarioMatricula,tipo:1,valor:valor,lengua:codlengua}, 
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
		 //console.log("tipo2 " + valor);
		   if(swListaVacia){
			    html = '<span style="font-size:15px;"><b>No se encontraron resultados</b></span>';
			   	if(valor == 1){
			   		$('#idRowContentMascota').html(html);
			   	}else if(valor == 2){
			   		$('#idRowContentFondo').html(html);
				}else if(valor == 3){
					$('#idRowContentCombos').html(html);
				}else if(valor == 4){
					$('#idRowContentBonus').html(html);
				}
		   }else{
			   	if(valor == 1){
					listarMascotas(listado);
				}else if(valor == 2){
					listarFondos(listado);
				}else if(valor == 3){
					//console.log("tipo " + valor);
					listarCombos(listado);
				}else if(valor == 4){
					listarBonus(listado);
				}
			   	$('[data-toggle="popover"]').popover();
		   }
			
	   }
    });
	
}

function realizarCompra(){
	monedaGemaObtenidas();
	var context  = $('#contextPathUrl').val();
	var monedaUsuario = $("#monedasUsuario").val();
	var gemaUsuario = $("#gemasUsuario").val();
	var costo = $("#item_detalle_modal #cantidadMonedas").val();
	var codigoAdqui = $('#item_detalle_modal #codigoArticulo').val();
	var tipo = $('#item_detalle_modal #tipoArticulo').val();
	var codUsuMat = $('#codusumatriBean').val();
	if (codUsuMat==0 || codUsuMat=='' || codUsuMat==null) {
		codUsuMat=0;
	}
	//console.log('codUsuMat...' + codUsuMat);
	var url = context+'/adquisicion/comprar';
	var valido = false;
	if(parseInt(monedaUsuario)< parseInt(costo)){ 
	}else{
		$.ajax({
			 async: true,
			type: "POST",
			data: {
				codigoAdquisicion : codigoAdqui,
				tipoAdquisicion : tipo,
				codUsuaMat		:codUsuMat
			},
		    url : url,
	        success: function(data)
	        {	
	        	//console.log(data);
	        	if(data!=null && data.result==1){
	        		valido = true;
	        		
	        	} else{
	        		//console.log(data.msj);  
	        		
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
			   var resto = parseInt(monedaUsuario) - parseInt(costo);
			   var codigoUsuMat = $('#codusumatriBean').val();
			 //console.log('codigoUsuMat :: '+codigoUsuMat);
			   if(valido){
				  
				    $("#monedasDisponibles").html(resto);
				    if(parseInt(tipo) == 1){
				    	//document.getElementById("#mascota #"+codigoAdqui).className = "";
				    	$("#mascota #"+codigoAdqui).removeClass("item-candado icon-minedu-candado");
				    	actualizarmonedaxcompra(resto);
				    }
				    if(parseInt(tipo) == 2){
				    	//document.getElementById("#mascota #"+codigoAdqui).className = "";
				    	$("#fondo #"+codigoAdqui).removeClass("item-candado icon-minedu-candado");
				    	actualizarmonedaxcompra(resto);
				    }
				    $("#btn_"+codigoAdqui).html("");
				    monedaGemaObtenidas();
			   }else{
				   	
			   }
				
		   }
	    });
	}
	
}


function actualizarmonedaxcompra(cantmon){
	var context  = $('#contextPathUrl').val();
//	var monedaUsuario = $("#monedasUsuario").val();
	//console.log('cantmon'+ cantmon);
	var monedaUsuario =cantmon;
	var codUsuMat = $("#codusumatriBean").val();
	
	var url = context+'/adquisicion/actualizarmonedaxcompra';
	var valido = false;
	if(codUsuMat=='' || codUsuMat==0 || codUsuMat==null){
		//console.log('codUsuMat esta vacio --- intente otra vez!');
	}else{
		$.ajax({
			 async: true,
			type: "POST",
			data: {
				p_codusumat : codUsuMat,
				p_cantmonedas : monedaUsuario
			},
		    url : url,
	        success: function(data)
	        {	
	        	//console.log(data);
	        	if(data=='1'){
	        		//console.log('actualizo actualizarmonedaxcompra');  
	        		valido = true;
	        		
	        	} else{
	        		//console.log('errror');  
	        		
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
	
}


function listarMascotas(lista){
//	monedaGemaObtenidas();
	var html = '';
	var context  = $('#contextPathUrl').val();
	
	for (var i = 0; i < lista.length; i++) {
		var mascota = lista[i];
		
		html += '<div class="col-md-4" id="mascota">'+
					'<div class="item-tienda">'+
						'<div class="item-img-tienda">';
							if(mascota.imagenTienda!=null){
								html += '<img src="'+context+'/mascota/'+mascota.imagenTienda+'" class="img-responsive" alt="'+mascota.imagenTienda+'">';
							}else{
								html += '<img src="'+context+'/assets/images/items/no-disponible.jpg" class="img-responsive" alt="No Disponible">';
							}
							if($("#monedasUsuario").val()<mascota.valormoneda){
								html += '<span id="'+mascota.codigo+'" class="item-candado icon-minedu-candado"></span>';
							}
							if(mascota.nivel.codigoRegistro==mascota.nivelAlumno){
								html += '</div>'+
									'<div class="item-info-tienda">'+	
									'<ul>'+
										'<li>'+
											'<button type="button" class="item-info-icon" data-toggle="popover" data-placement="top" data-content="'+mascota.descripcion+'" data-original-title="'+mascota.nombre+'" data-trigger="focus">?</button>'+
										'</li>'+
										'<li><span class="item-precio-icon"><i class="icon-minedu-precio"></i> '+mascota.valormoneda+'</span></li>'+
										'<li class="pull-right" id="btn_'+mascota.codigo+'">';
							}else{
								html += '</div>'+
								'<div class="item-info-tienda">'+	
								'<ul>'+
									'<li>'+
										'<button type="button" class="item-info-icon" data-toggle="popover" data-placement="top" data-content="'+mascota.descripcion+'" data-original-title="'+mascota.nombre+'" data-trigger="focus">?</button>'+
									'</li>'+
									'<li class="pull-right" id="btn_'+mascota.codigo+'">';
									}
				
				if(mascota.cantidadComprado!=0){
					html += '<button type="button" class="btn btn-sm btn-gris" data-toggle="popover" data-placement="top" data-content=""  data-trigger="focus">'+$("#trad_7").val()+'</button>';
					}else{

						//alert("NIVEL=" +mascota.nivel.codigoRegistro);
						if($("#monedasUsuario").val()<mascota.valormoneda && mascota.nivel.codigoRegistro==mascota.nivelAlumno){
							html += '<button type="button" class="btn btn-sm btn-item-comprar" data-toggle="popover" data-placement="top" data-content=""  data-trigger="focus">'+$("#trad_1").val()+'</button>';
						} else if(mascota.nivel.codigoRegistro!=mascota.nivelAlumno){
 
							html += '<span id="'+mascota.codigo+'" class="item-candado icon-minedu-candado"></span>';
							
						}
						else{
							html += '<button type="button"  class="btn btn-sm btn-item-comprar" onclick="showTIendaDetalle2('+mascota.codigo+','+mascota.valormoneda+",'"+mascota.imagenTienda+"'"+',1)">'+$("#trad_1").val()+'</button>';
						}
					
					}
				
				
				
//				
//							if(mascota.nivel.codigoRegistro!=mascota.nivelAlumno){
//								html += '<button type="button" class="btn btn-sm btn-item-comprar" data-toggle="popover" data-placement="top" data-content="" data-original-title="No puede comprar en este Nivel" data-trigger="focus">'+$("#trad_1").val()+'</button>';
//								
//								html += '<span id="'+mascota.codigo+'" class="item-candado icon-minedu-candado"></span>';
//								}
//								else{
//									if(mascota.cantidadComprado==0){
//								//alert("NIVEL=" +mascota.nivel.codigoRegistro);
//								if($("#monedasUsuario").val()<mascota.valormoneda){
//									html += '<button type="button" class="btn btn-sm btn-item-comprar" data-toggle="popover" data-placement="top" data-content="" data-original-title="No tiene suficientes monedas para realizar la compra." data-trigger="focus">'+$("#trad_1").val()+'</button>';
//								} else{
//									html += '<button type="button"  class="btn btn-sm btn-item-comprar" onclick="showTIendaDetalle2('+mascota.codigo+','+mascota.valormoneda+",'"+mascota.imagenTienda+"'"+',1)">'+$("#trad_1").val()+'</button>';
//								}
//							} else{
//								html += '<button type="button" class="btn btn-sm btn-gris" data-toggle="popover" data-placement="top" data-content="" data-original-title="Ya se ha realizado la compra de este item." data-trigger="focus">'+$("#trad_7").val()+'</button>';
//							}
//							}
								
							
							
							
							
							
							
							 
					html +=	'</li>'+
						'</ul>'+
					'</div>'+	
				'</div>'+
			'</div>';
	}
	$('#idRowContentMascota').html(html);
}

function listarFondos(lista){
//	monedaGemaObtenidas();
	var html = '';
	var context  = $('#contextPathUrl').val();
	
	for (var i = 0; i < lista.length; i++) {
		var fondo = lista[i];
		
		html += '<div class="col-md-4" id="fondo">'+
					'<div class="item-tienda">'+
						'<div class="item-img-tienda">';
							if(fondo.imagenNombreTienda!=null){
													//'+context+'
								html += '<img src="'+context+'/fondo/'+fondo.imagenNombreTienda+'" class="img-responsive" alt="'+fondo.imagenNombreTienda+'">';
							}else{
								html += '<img src="'+context+'/assets/images/items/no-disponible.jpg" class="img-responsive" alt="">';
							}
							if($("#monedasUsuario").val()<fondo.monedas || $("#gemasUsuario").val()<fondo.gemas){
								html += '<span id="'+fondo.codigo+'" class="item-candado icon-minedu-candado"></span>';
							}
				html += '</div>'+
						'<div class="item-info-tienda">'+
							'<ul>'+
								'<li>'+
									'<button type="button" class="item-info-icon" data-toggle="popover" data-placement="top" data-content="'+fondo.descripcion+'" data-original-title="'+fondo.nombre+'" data-trigger="focus">?</button>'+
								'</li>'+
								'<li><span class="item-precio-icon"><i class="icon-minedu-precio"></i> '+fondo.monedas +' <i class="icon-minedu-gema"></i> '+fondo.gemas+'</span></li>'+
								'<li class="pull-right" id="btn_'+fondo.codigo+'">'; 
									if(fondo.cantidadComprado==0){
										if($("#monedasUsuario").val()<fondo.monedas || $("#gemasUsuario").val()<fondo.gemas){
											html += '<button type="button" class="btn btn-sm btn-item-comprar" data-toggle="popover" data-placement="top" data-content=""  data-trigger="focus">'+$("#trad_1").val()+'</button>';
										} else{
										html += '<button type="button" class="btn btn-sm btn-item-comprar" onclick="showTIendaDetalle2('+fondo.codigo+','+fondo.monedas+",'"+fondo.imagenNombreTienda+"'"+',2)">'+$("#trad_1").val()+'</button>';
										}
									}else{
										html += '<button type="button" class="btn btn-sm btn-gris" data-toggle="popover" data-placement="top" data-content=""  data-trigger="focus">'+$("#trad_7").val()+'</button>';
									} 
						html += '</li>'+	
							'</ul>'+
						'</div>'+
					'</div>'+
				'</div>';
	}
	$('#idRowContentFondo').html(html);
}

function listarCombos(lista){
//	monedaGemaObtenidas();
	var html = '';
	var context  = $('#contextPathUrl').val();
	
	for (var i = 0; i < lista.length; i++) {
		var combo = lista[i];
		html += '<div class="col-md-4" id="combo">'+
		'<div class="item-tienda">'+
			'<div class="item-img-tienda">';
				
					html += '<img src="'+context+'/assets/images/items/combos.png" class="img-responsive" alt="">';
				
					if($("#monedasUsuario").val()<combo.monto){
					html += '<span id="'+combo.codigo+'" class="item-candado icon-minedu-candado"></span>';
				}
	html += '</div>'+
			'<div class="item-info-tienda">'+
				'<ul>'+
					'<li>'+
						'<button type="button" class="item-info-icon" data-toggle="popover" data-placement="top" data-content="'+combo.titulo+'" data-original-title="'+combo.descripcion+'" data-trigger="focus">?</button>'+
					'</li>'+
					'<li><span class="item-precio-icon"><i class="icon-minedu-precio"></i> '+combo.monto+'</span></li>'+
					'<li class="pull-right" id="btn_'+combo.codigo+'">'; 
						if(combo.cantidadComprado==0){
							if($("#monedasUsuario").val()<combo.monto){
								html += '<button type="button" class="btn btn-sm btn-item-comprar" data-toggle="popover" data-placement="top" data-content=""   data-trigger="focus">'+$("#trad_1").val()+'</button>';
							} else{
							html += '<button type="button" class="btn btn-sm btn-item-comprar df" onclick="showTIendaDetalle2('+combo.codigo+','+combo.monto+",'"+combo.nombreImagen+"'"+',3)">'+$("#trad_1").val()+'</button>';
							}
						}else{
							html += '<button type="button" class="btn btn-sm btn-gris" data-toggle="popover" data-placement="top" data-content=""   data-trigger="focus">'+$("#trad_7").val()+'</button>';
						} 
			html += '</li>'+	
				'</ul>'+
			'</div>'+
		'</div>'+
	'</div>';
}
$('#idRowContentCombos').html(html);
}

function listarBonus(lista){
//	monedaGemaObtenidas();
	var html = '';
	var context  = $('#contextPathUrl').val();
	
	for (var i = 0; i < lista.length; i++) {
		var bonus = lista[i];
	}
}