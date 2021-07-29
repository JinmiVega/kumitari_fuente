$.fn.extend({
    treed: function (o) {

      var openedClass = 'glyphicon-minus-sign';
      var closedClass = 'glyphicon-plus-sign';

      if (typeof o != 'undefined'){
        if (typeof o.openedClass != 'undefined'){
        openedClass = o.openedClass;
        }
        if (typeof o.closedClass != 'undefined'){
        closedClass = o.closedClass;
        }
      };

        //initialize each of the top levels
        var tree = $(this);
        tree.addClass("tree");
        tree.find('li').has("ul").each(function () {
            var branch = $(this); //li with children ul
            branch.prepend("<i class='indicator glyphicon " + closedClass + "'></i>");
            branch.addClass('branch');
            branch.on('click', function (e) {
                if (this == e.target) {
                    var icon = $(this).children('i:first');
                    icon.toggleClass(openedClass + " " + closedClass);
                    $(this).children().children().toggle();
                }
            })
            branch.children().children().toggle();
        });
        //fire event from the dynamically added icon
      tree.find('.branch .indicator').each(function(){
        $(this).on('click', function () {
            $(this).closest('li').click();
        });
      });
        //fire event to open branch if the li contains an anchor instead of text
        tree.find('.branch>a').each(function () {
            $(this).on('click', function (e) {
                $(this).closest('li').click();
                e.preventDefault();
            });
        });
        //fire event to open branch if the li contains a button instead of text
        tree.find('.branch>button').each(function () {
            $(this).on('click', function (e) {
                $(this).closest('li').click();
                e.preventDefault();
            });
        });
    }
});

var contextPathUrl = $('#contextPathUrl').val();
var codlenguaInit = $('#codlenguaTreeVal').val();
var codlenguaValEncrypt = $('#codlenguaValEncrypt').val();
$('#main-tree-view h3').empty();
$('#main-tree-view h3').html($('#nomlenguaTreeVal').val());
var treeSelectedVal = $('#pageActualTreeVal').val();
//console.log(codlenguaInit);
//console.log(treeSelectedVal);

cargaInicial();

/** TREE VIEW DESPLEGADO **/
var nivelSelecVal = $('#nivelActualTreeVal').val();

var swcargaunid = false;
var swcargalecc = false;
var swcargamate = false;
var swcargaejer = false;


var codlenestTreeValEncrypt = "";
var codlenuniTreeValEncrypt = "";
var codleccionValEncrypt = "";
var codmaterialValEncrypt = "";

var codlenestvalid = 0;
var codunidadvalid = 0;
var codleccionvalid = 0;
var codmaterialvalid = 0;
var codejerciciovalid = 0;
var posMaterialValid = 0;

function verifyTreeSelected(){
	
	if(treeSelectedVal == contextPathUrl+'/page/lengua/basico.jsp'){
		codlenestvalid = $('#codlenestTreeVal').val();
		codlenestTreeValEncrypt = $('#codlenestTreeValEncrypt').val();
		swcargaunid = true;
	}else if(treeSelectedVal == contextPathUrl+'/page/lengua/unidad.jsp'){
		codlenestvalid = $('#codlenestTreeVal').val();
		codlenestTreeValEncrypt = $('#codlenestTreeValEncrypt').val();
		codunidadvalid = $('#codlenuniTreeVal').val();
		codlenuniTreeValEncrypt = $('#codlenuniTreeValEncrypt').val();
		swcargaunid = true;
		swcargalecc = true;
	}else if(treeSelectedVal == contextPathUrl+'/page/material/material-contenedor.jsp'){
		codlenestvalid = $('#codlenestVal').val();
		codlenestTreeValEncrypt = $('#codlenestTreeValEncrypt').val();
		
		codunidadvalid = $('#codunidadVal').val();
		codlenuniTreeValEncrypt = $('#codlenuniTreeValEncrypt').val();
		
		codleccionvalid = $('#codleccionVal').val();
		codleccionValEncrypt = $('#codleccionValEncrypt').val();
		
		swcargaunid = true;
		swcargalecc = true;
		swcargamate = true;
	}else if(treeSelectedVal == contextPathUrl+'/page/ejercicios/ejercicio-contenedor.jsp'){
		codlenestvalid = $('#codlenestVal').val();
		codlenestTreeValEncrypt = $('#codlenestTreeValEncrypt').val();
		codunidadvalid = $('#codunidadVal').val();
		codlenuniTreeValEncrypt = $('#codlenuniTreeValEncrypt').val();
		codleccionvalid = $('#codleccionVal').val();
		codleccionValEncrypt = $('#codleccionValEncrypt').val();
		codmaterialvalid = $('#codmaterialVal').val();
		codmaterialValEncrypt = $('#codmaterialValEncrypt').val();
		posMaterialValid = $('#posMaterialActual').val();
		swcargaunid = true;
		swcargalecc = true;
		swcargamate = true;
		swcargaejer = true;
	}else{
		
	}
	
}

function cargaInicial(){
	//console.log(codlenguaInit);
	//console.log(codlenguaValEncrypt)
	var url = contextPathUrl + '/navegacion/cargarNiveles';
	var html = '';
	$.ajax({
        async: true,
		type : "GET",
		data : {codlengua : codlenguaValEncrypt },
		url  : url,
		success : function(data){
			if(data!=null && data!=''){
				for (var i = 0; i < data.length; i++) {
					var nombNivel = (data[i].nivel.valor4) ? (data[i].nivel.valor4) : ( data[i].nivel.nombreCorto ? data[i].nivel.nombreCorto : 'No data' );
					html+= '<li id="nivel-tree-'+data[i].nivel.codigoRegistro+'">'+
								nombNivel
								if(data[i].listaSubNivel!=null && data[i].listaSubNivel.length>0){
									html+='<ul>';                      
					                	for (var j = 0; j < data[i].listaSubNivel.length; j++) {
					                		var ininombre = data[i].listaSubNivel[j].lenguaNivelBean.inicialNombre;
					                		var valor2 = data[i].listaSubNivel[j].subNivel.valor2;
					                		var nombreSubNivel = (ininombre && valor2) ? (ininombre+valor2)  : ( (data[i].listaSubNivel[j].subNivel.nombreCorto) ? data[i].listaSubNivel[j].subNivel.nombreCorto : 'No data' );
											html+= '<li id="a-len-est-'+data[i].listaSubNivel[j].codigo+'">'+
														'<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarUnidades('+data[i].listaSubNivel[j].codigo+',\''+data[i].listaSubNivel[j].codigoEncrypt+'\')"></i>'+
														'<a class="link-item-subnivel" href="'+contextPathUrl+'/lengua/detalle/'+codlenguaValEncrypt+'/nivel/'+data[i].listaSubNivel[j].codigoEncrypt+'">'+nombreSubNivel+'</a>'+
												   '</li>';
										}
					                	html+='</ul>';
								}
								html+='</li>';
				}
			}
		},
		error: function(xhr,status,er) {
		    if(xhr.status==500) {
		    	
		    }
		    if(xhr.status==901) {
		    	
		    }
	   },
	   complete : function(){
		   $('#main-tree-view #tree-list').empty();
		   $('#main-tree-view #tree-list').html(html);
		   $('#main-tree-view #tree-list').treed();
		   verifyTreeSelected();
		   if(swcargaunid){
			   $('#nivel-tree-'+nivelSelecVal).trigger('click');
			   cargarUnidades(codlenestvalid,codlenestTreeValEncrypt); 
		   }
	   }
	});
}

function cargarUnidades(codlenest,codlenestEncriptado){
	//console.log(codlenest);
	var url = contextPathUrl + '/navegacion/cargarUnidades';
	var html = '';
	var text = $('#main-tree-view #tree-list #a-len-est-'+codlenest+' a').html();
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarUnidades('+codlenest+',\''+codlenestEncriptado+'\')"></i>';
	var minus = '<i class="indicator glyphicon glyphicon-minus-sign" onclick="cerrarUnidades('+codlenest+',\''+codlenestEncriptado+'\')"></i>';
	var ruta  = '<a class="link-item-subnivel" href="'+contextPathUrl+'/lengua/detalle/'+codlenguaValEncrypt+'/nivel/'+codlenestEncriptado+'">'+text+'</a>';

	loadAjaxTree('#main-tree-view #tree-list #a-len-est-'+codlenest);

	$.ajax({
        async: true,
		type : "GET",
		data : {codlenest : codlenest },
		url  : url,
		success : function(data){
			if(data!=null && data!=''){
				html+= minus + ruta;
				html+='<ul>';
				for (var i = 0; i < data.length; i++) {
					var nombreUnidadTitle = (data[i].descripcion) ? (data[i].descripcion) : '';
					var nombreUnidad = (data[i].nombre && data[i].nombre.length>20) ? (data[i].nombre.substring(0, 18)+'...') : data[i].nombre;
					html+= '<li id="a-len-uni-'+data[i].codigo+'" title="'+nombreUnidadTitle+'">'+
								'<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarLecciones('+data[i].codigo+',\''+data[i].codigoEncrypt+'\','+codlenest+',\''+codlenestEncriptado+'\')"></i>'+
								'<a class="link-item-unidad" href="'+contextPathUrl+'/lengua/detalle/'+codlenguaValEncrypt+'/nivel/'+codlenestEncriptado+'/unidad/'+data[i].codigoEncrypt+'">'+nombreUnidad+'</a>'+
							'</li>';
				}
				html+='</ul>';
			}else{
				html+= plus + ruta;
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
		   $('#main-tree-view #tree-list #a-len-est-'+codlenest).empty();
		   $('#main-tree-view #tree-list #a-len-est-'+codlenest).html(html);
		   
		   if(codlenestvalid>0){
			 $('#main-tree-view #tree-list span').removeClass('opt-active-tree');
			 $('#main-tree-view #tree-list a').removeClass('opt-active-tree');
			 $('#main-tree-view #tree-list #a-len-est-'+codlenestvalid+' .link-item-subnivel').addClass('opt-active-tree');	   
		   }
		   
		   if(swcargaunid){
			   verifyWidthTree();
		   }
		   if(swcargalecc){
			   cargarLecciones(codunidadvalid,codlenuniTreeValEncrypt,codlenestvalid,codlenestTreeValEncrypt);
		   }
	   }
	});
}

function cerrarUnidades(codlenest,codlenestEncriptado){
	var html = '';
	var text = $('#main-tree-view #tree-list #a-len-est-'+codlenest+' a').html();
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarUnidades('+codlenest+',\''+codlenestEncriptado+'\')"></i>';
	var ruta  = '<a class="link-item-subnivel" href="'+contextPathUrl+'/lengua/detalle/'+codlenguaValEncrypt+'/nivel/'+codlenestEncriptado+'">'+text+'</a>';
	html = plus + ruta;
	$('#main-tree-view #tree-list #a-len-est-'+codlenest).empty();
	$('#main-tree-view #tree-list #a-len-est-'+codlenest).html(html);
	swcargaunid = false;
	swcargalecc = false;
	swcargamate = false;
	swcargaejer = false;
}

function cargarLecciones(codunidad,codunidadEncriptado,codlenest,codlenestEncriptado){
	var url = contextPathUrl + '/navegacion/cargarLecciones';
	var html = '';
	var text = $('#main-tree-view #tree-list #a-len-uni-'+codunidad+' a').html();
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarLecciones('+codunidad+','+codunidadEncriptado+','+codlenest+','+codlenestEncriptado+')"></i>';
	var minus = '<i class="indicator glyphicon glyphicon-minus-sign" onclick="cerrarLecciones('+codunidad+','+codunidadEncriptado+','+codlenest+','+codlenestEncriptado+')"></i>';
	var ruta  = '<a class="link-item-unidad" href="'+contextPathUrl+'/lengua/detalle/'+codlenguaValEncrypt+'/nivel/'+codlenestEncriptado+'/unidad/'+codunidadEncriptado+'">'+text+'</a>';

	loadAjaxTree('#main-tree-view #tree-list #a-len-uni-'+codunidad);

	$.ajax({
        async: true,
		type : "GET",
		data : {codunidad : codunidad },
		url  : url,
		success : function(data){
			if(data!=null && data!=''){
				html+= minus + ruta;
				html+='<ul>';
				for (var i = 0; i < data.length; i++) {
					var nombreLeccionTitle = (data[i].nombre) ? (data[i].nombre) : '';
					var nombreLeccion = (data[i].nombre && data[i].nombre.length>20) ? (data[i].nombre.substring(0, 18)+'...') : data[i].nombre;
					html+= '<li id="a-len-lec-'+data[i].codigo+'" title="'+nombreLeccionTitle+'">';
					html+= '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarMateriales('+data[i].codigo+',\''+data[i].codigoEncrypt+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\')"></i>';
					html+= '<span class="link-item-leccion">'+nombreLeccion+'</span>';
					html+= '</li>';
				}
				html+='</ul>';
			}else{
				html+= plus + ruta;
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
		   $('#main-tree-view #tree-list #a-len-uni-'+codunidad).empty();
		   $('#main-tree-view #tree-list #a-len-uni-'+codunidad).html(html);
		   
		   if(codunidadvalid>0){
			   $('#main-tree-view #tree-list span').removeClass('opt-active-tree');
			   $('#main-tree-view #tree-list a').removeClass('opt-active-tree');
			   $('#main-tree-view #tree-list #a-len-uni-'+codunidadvalid+' .link-item-unidad').addClass('opt-active-tree');  
		   }
		   
		   if(swcargalecc){
			   verifyWidthTree();
		   }
		   if(swcargamate){
			   //console.log({codleccionvalid,codleccionValEncrypt,codunidadvalid,codlenuniTreeValEncrypt,codlenestvalid,codlenestTreeValEncrypt});
			   cargarMateriales(codleccionvalid,codleccionValEncrypt,codunidadvalid,codlenuniTreeValEncrypt,codlenestvalid,codlenestTreeValEncrypt);
			   //cargarMateriales(codleccionvalid,codunidadvalid,codlenestvalid);
			   //codmaterialvalid,codleccionvalid,codunidadvalid,codlenestvalid,posMaterialValid
		   }
	   }
	});
}

function cerrarLecciones(codunidad,codunidadEncriptado,codlenest,codlenestEncriptado){
	var html = '';
	var text = $('#main-tree-view #tree-list #a-len-uni-'+codunidad+' a').html();
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarLecciones('+codunidad+','+codunidadEncriptado+','+codlenest+','+codlenestEncriptado+')"></i>';
	var ruta  = '<a class="link-item-unidad" href="'+contextPathUrl+'/lengua/detalle/'+codlenguaValEncrypt+'/nivel/'+codlenest+'/unidad/'+codunidad+'">'+text+'</a>';
	html = plus + ruta;
	$('#main-tree-view #tree-list #a-len-uni-'+codunidad).empty();
	$('#main-tree-view #tree-list #a-len-uni-'+codunidad).html(html);
	swcargalecc = false;
	swcargamate = false;
	swcargaejer = false;
}

var listaMatTree = [];

function cargarMateriales(codleccion,codleccionEncriptado,codunidad,codunidadEncriptado,codlenest,codlenestEncriptado){
	var url = contextPathUrl + '/navegacion/cargarMateriales';
	var html = '';
	var text = $('#main-tree-view #tree-list #a-len-lec-'+codleccion+' span').html();
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarMateriales('+codleccion+',\''+codleccionEncriptado+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\')"></i>';
	var minus = '<i class="indicator glyphicon glyphicon-minus-sign" onclick="cerrarMateriales('+codleccion+',\''+codleccionEncriptado+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\')"></i>';
	var ruta  = '<span class="link-item-leccion">'+text+'</span>';

	loadAjaxTree('#main-tree-view #tree-list #a-len-lec-'+codleccion);

	$.ajax({
        async: true,
		type : "GET",
		data : {codleccion : codleccion },
		url  : url,
		success : function(data){
			if(data!=null && data!=''){
				listaMatTree = data;
				html+= minus + ruta;
				html+='<ul>';
				for (var i = 0; i < data.length; i++) {
					var codtipmat = data[i].situacionLeccionMaterial.codigoRegistro;
					var descripcion = (data[i].descripcionMaterial!=null && data[i].descripcionMaterial!='') ? data[i].descripcionMaterial.replace(/<[^>]*>?/g, '')  : '';
					descripcion = (descripcion!=null && descripcion!='') ? descripcion : ( (data[i].indicacion!=null && data[i].indicacion!='') ? data[i].indicacion : data[i].comprension);
					var nombreMaterialTitle = (descripcion!=null && descripcion!='') ? descripcion : '';
					var nomTipoMaterial = (descripcion!=null && descripcion!='' && descripcion.length>20) ? (descripcion.substring(0, 18)+'...') : descripcion;
					html+= '<li id="a-len-mat-'+data[i].codigo+'" title="'+nombreMaterialTitle+'">';
							if(data[i].situacionLeccionMaterial.codigoRegistro!=5){
								html+= '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarEjercicios('+data[i].codigo+',\''+data[i].codigoEncrypt+'\','+codleccion+',\''+codleccionEncriptado+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\','+i+')"></i>';
							}
							if(data[i].situacionLeccionMaterial.codigoRegistro==4){
								html+= '<span class="link-item-material">'+nomTipoMaterial+'</span>';
							}else{
								html+= '<a class="link-item-material" href="'+contextPathUrl+'/lengua/haciaMaterial/'+codlenguaValEncrypt+'/'+codlenestEncriptado+'/'+codunidadEncriptado+'/'+codleccionEncriptado+'/'+i+'">'+nomTipoMaterial+'</a>';
							}
					html+= '</li>';
			html+= '</li>';
				}
				html+='</ul>';
			}else{
				html+= plus + ruta;
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
		   $('#main-tree-view #tree-list #a-len-lec-'+codleccion).empty();
		   $('#main-tree-view #tree-list #a-len-lec-'+codleccion).html(html);
		   
		   selectedMaterialTree(codleccion);
		   
		   if(swcargamate){
			   verifyWidthTree();
		   }
		   if(swcargaejer){
			   //cargarEjercicios(codmaterialvalid,codleccionvalid,codunidadvalid,codlenestvalid,posMaterialValid);
			   cargarEjercicios(codmaterialvalid,codmaterialValEncrypt,codleccionvalid,codleccionValEncrypt,codunidadvalid,codlenuniTreeValEncrypt,codlenestvalid,codlenestTreeValEncrypt,posMaterialValid);
		   }
	   }
	});
}

function cerrarMateriales(codleccion,codleccionEncriptado,codunidad,codunidadEncriptado,codlenest,codlenestEncriptado){
	var html = '';
	var text = $('#main-tree-view #tree-list #a-len-lec-'+codleccion+' span').html();
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarMateriales('+codleccion+',\''+codleccionEncriptado+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\')"></i>';
	var ruta  = '<span class="link-item-leccion">'+text+'</span>';
	html = plus + ruta;
	$('#main-tree-view #tree-list #a-len-lec-'+codleccion).empty();
	$('#main-tree-view #tree-list #a-len-lec-'+codleccion).html(html);
	swcargamate = false;
	swcargaejer = false;
}

function cargarEjercicios(codmaterial,codmaterialEncriptado,codleccion,codleccionEncriptado,codunidad,codunidadEncriptado,codlenest,codlenestEncriptado,posMaterial){
	var listaEje = [];
	var url = contextPathUrl + '/navegacion/cargarEjercicios';
	var html = '';
	var text = '';
	var ruta = '';
	if($('#main-tree-view #tree-list #a-len-mat-'+codmaterial+' span').html()){
		text = $('#main-tree-view #tree-list #a-len-mat-'+codmaterial+' span').html();
		ruta  = '<span class="link-item-material">'+text+'</span>';
	}else{
		text = $('#main-tree-view #tree-list #a-len-mat-'+codmaterial+' a').html();
		ruta  = '<a class="link-item-material" href="'+contextPathUrl+'/lengua/haciaMaterial/'+codlenguaValEncrypt+'/'+codlenestEncriptado+'/'+codunidadEncriptado+'/'+codleccionEncriptado+'/'+posMaterial+'">'+text+'</a>'
	}
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarEjercicios('+codmaterial+',\''+codmaterialEncriptado+'\','+codleccion+',\''+codleccionEncriptado+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\','+posMaterial+')"></i>';
	var minus = '<i class="indicator glyphicon glyphicon-minus-sign" onclick="cerrarEjercicios('+codmaterial+',\''+codmaterialEncriptado+'\','+codleccion+',\''+codleccionEncriptado+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\','+posMaterial+')"></i>';

	loadAjaxTree('#main-tree-view #tree-list #a-len-mat-'+codmaterial);

	$.ajax({
        async: true,
		type : "GET",
		data : {codmaterial : codmaterial },
		url  : url,
		success : function(data){
			if(data!=null && data!=''){
				listaEje = data;
				html+= minus + ruta;
				html+='<ul>';
				for (var i = 0; i < data.length; i++) {
					var nombreEjercicioTitle = (data[i].titulo) ? (data[i].titulo) : '';
					var descripcionEjercicio = (data[i].titulo && data[i].titulo.length>20) ? (data[i].titulo.substring(0, 18)+'...') : data[i].titulo; 
					html+= '<li id="a-len-eje-'+data[i].codigo+'" title="'+nombreEjercicioTitle+'">'+
								'<a class="link-item-ejercicio" href="'+contextPathUrl+'/lengua/haciaEjercicio/'+codlenguaValEncrypt+'/'+codlenestEncriptado+'/'+codunidadEncriptado+'/'+codleccionEncriptado+'/'+codmaterialEncriptado+'/'+i+'">'+descripcionEjercicio+'</a>'+
						   '</li>';
				}
				html+='</ul>';
			}else{
				html+= plus + ruta;
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
		   $('#main-tree-view #tree-list #a-len-mat-'+codmaterial).empty();
		   $('#main-tree-view #tree-list #a-len-mat-'+codmaterial).html(html);
		   
		   selectedMaterialTree(codleccion);
		   
		   if(swcargaejer){
			   verifyWidthTree();
		   }
	   }
	});
}

function cerrarEjercicios(codmaterial,codmaterialEncriptado,codleccion,codleccionEncriptado,codunidad,codunidadEncriptado,codlenest,codlenestEncriptado,posMaterial){
	var html = '';
	var text = '';
	var ruta = '';
	if($('#main-tree-view #tree-list #a-len-mat-'+codmaterial+' span').html()){
		text = $('#main-tree-view #tree-list #a-len-mat-'+codmaterial+' span').html();
		ruta  = '<span class="link-item-material">'+text+'</span>';
	}else{
		text = $('#main-tree-view #tree-list #a-len-mat-'+codmaterial+' a').html();
		ruta  = '<a class="link-item-material" href="'+contextPathUrl+'/lengua/haciaMaterial/'+codlenguaValEncrypt+'/'+codlenestEncriptado+'/'+codunidadEncriptado+'/'+codleccionEncriptado+'/'+posMaterial+'">'+text+'</a>'
	}
	var plus  = '<i class="indicator glyphicon glyphicon-plus-sign" onclick="cargarEjercicios('+codmaterial+',\''+codmaterialEncriptado+'\','+codleccion+',\''+codleccionEncriptado+'\','+codunidad+',\''+codunidadEncriptado+'\','+codlenest+',\''+codlenestEncriptado+'\','+posMaterial+')"></i>';
	html = plus + ruta;

	$('#main-tree-view #tree-list #a-len-mat-'+codmaterial).empty();
	$('#main-tree-view #tree-list #a-len-mat-'+codmaterial).html(html);
	swcargaejer = false;
	selectedMaterialTree(codleccion);
}

function verifyWidthTree(){
	isClosed = false;
	hamburger_cross();
	$('.hamburger').trigger('click');
}

function selectedMaterialTree(codleccion){
   
   if(codleccionvalid>0 && codleccionvalid == codleccion){
	   $('#main-tree-view #tree-list span').removeClass('opt-active-tree');
	   $('#main-tree-view #tree-list a').removeClass('opt-active-tree');
	   var posMatAct = $('#posMaterialActual').val();
	   var codMatAct = 0;
	   if(posMatAct){
		   for (var i = 0; i < listaMatTree.length; i++) {
			   if(i == posMatAct){
				   codMatAct = listaMatTree[i].codigo;
				   break;
			   }
		   }
		   $('#main-tree-view #tree-list #a-len-mat-'+codMatAct+' .link-item-material').addClass('opt-active-tree');
	   }
   }
}

var loadAjaxTree=(id)=>{
	$(id).html('<img src="'+contextPathUrl+'/assets/images/ajax-loader.gif" class="ajax-tree-view">')
}