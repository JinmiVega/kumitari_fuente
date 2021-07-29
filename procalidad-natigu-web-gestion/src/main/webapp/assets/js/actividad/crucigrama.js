/**
 * Mantenimeinto  Texto-Texto
 */

function guardarCrucigrama(){ 
	//codigo ejercicio
	var p_idEjercicio = $("#idEjercicio").val();
	//variables Actividad
	var p_palabra	= $("#idPalabraCrucigrama").val();
	var p_definicion= $("#idDefinicionCrucigrama").val();
	var p_idnumero =  $("#idnumero").val();
	var p_x =  $("#x").val();
	var p_y =  $("#y").val();
	var p_orientacion =  $("#idCmbOrientacion").val();
	//codigo tabla relacion
	var p_idCrucigrama = $("#idRelacionCrucigrama").val();
	//codigo tabla relacioncab	
	var p_idRelacionCabecera = $("#idRelacionCabecera").val();
	//codigo actividad modal
	var p_idMaterial	= $("#modalCboMaterial").val();
	

	
 
	var url = contextPath+"/cargaMaterialController/grabarCrucigrama";
	if(p_idMaterial != "0")
	{	 
		var $myForm = $('#frmregistromodal'); 
		iniciarBloqueo();
		$.ajax({
  			type 	: "POST",
  			data 	: { idEjercicio     :p_idEjercicio, 		
  						palabra	        : p_palabra,
  						definicion      :p_definicion,  						
  						orden			: p_idnumero,
  						x				:p_x,
  						y				:p_y,
  						orientacion 	:p_orientacion,  						
  						idCrucigrama	:p_idCrucigrama,
  						idRelacionCabecera:p_idRelacionCabecera,
  						idMaterial		:p_idMaterial},
		   url 	: url,
		  
  			success : function(data)
  			{	
  					finBloqueo();
  					//if (data != "0") { 
	  	  				$("#idRelacionCrucigrama").val(data);  
	  	  				listarEjercicioCrucigrama();
		  	  			
	  	  				
	  	  				
		  	  			//$("#btn_guardar_crucigrama").attr("disabled",true);
 	  	  				$("#idRelacionCabecera").val(data);
			  	  		$("#idRelacionCrucigrama").val("0");
				  	  	$("#idPalabraCrucigrama").val("");
				  	  	$("#x").val("");
				  	  	$("#y").val("");
				  	    $("#idnumero").val("");
				  		$("#idDefinicionCrucigrama").val("");
				  		//$("#idCmbOrden").val("0");
				  		$("#idCmbOrientacion").val("0");
				  		$("#idPalabraSeparada").val("");
	  	  				msg_exito();
					//}
	  			//	else
	  			//	{
	  				//	msg_advertencia("Orden ya esta siendo usado.");
					//}
				 
  			},
  			 complete: function() 
  			{  
  				 ejecutardet();
  				 },
  			error : function()
  			{
  				////console.log("ERROR: ");
  			}
  		});
  }
	

	else
	{
		msg_advertencia("Debe seleccionar un Material.");
	
  }
}

	function ejecutardet()
	{	  
			 if(listsilaba.length>0){
		    for(var m=0;m<listsilaba.length;m++){  
//		    	grabarcrucigramadetalle(listsilaba[m]); 
		    	var codigoCab = $("#idRelacionCabecera").val();   
		    	var url = contextPath+"/cargaMaterialController/grabarCrucigramaDetalle";
		    $.ajax({
		    		type 	: "POST",
		    		data 	: { codigoCab:codigoCab,
		    					palabra : listsilaba[m],
		    					orden : m
		    					},
		    		url 	: url,
		    		success : function(data)
		    		{	 
		    			 
		    		},
		    		complete: function() 
		    			{ 
		    			$("#idRelacionCabecera").val("0");
		    			document.getElementById("idsilaba").disabled = false;
		    			document.getElementById("btn_agregarsilaba").disabled = false; 
		    			
		    			},
		    		error : function()
		    		{
		    			//console.log("ERROR: ");
		    		}
		    	});
		     

		    
		    
		    
		    
		    
		    
	           }
			 }else{
				document.getElementById("idsilaba").disabled = false;
				document.getElementById("btn_agregarsilaba").disabled = false;  
			 }
			 listsilaba=[];
			 textosilaba="";
			 textosilabaSeparada="";
		
		
	}
 



function listarEjercicioCrucigrama()
{	
	
	$("#idPalabraCrucigrama").addClass('disabled');
	$("idPalabraCrucigrama").prop('disabled', true); 
	
	var p_idEjercicio = $("#idEjercicio").val();
	/*
	console.log("p_idEjercicio");
	console.log(p_idEjercicio);
	*/
	var url = contextPath+"/cargaMaterialController/listarCrucigrama";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{idEjercicio : p_idEjercicio },
		url : url,
		success : function(data) 
		{
			//console.log("SUCCESS: ", data);
			if (data!=null && data.length>0) 
			{
				for (var i = 0; i < data.length; i++) 
				{	
					var crucigrama = data[i];
					var orientacionPalabra ='';
					if (crucigrama.orientacion==1){
						orientacionPalabra = 'Horizontal';
					}else if(crucigrama.orientacion==2){
						orientacionPalabra = 'Vertical';
					}else{
						orientacionPalabra ='';
					}
					
					
					html = html+"<tr> <td>"+(i+1)+"</td><td>"
							+crucigrama.palabra+"</td><td>"+
							crucigrama.texto+"</td> <td>"+
							orientacionPalabra+"</td> <td>"+
							" <button type='button' title='Modificar' onclick='editarCrucigrama(\""+
							crucigrama.codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'>"+
							"</i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar(\""+'crucigrama'+"\",\""+
							crucigrama.codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("bodyListeCrucigrama").innerHTML=html;
			}else{
				//$("#bodyListeCrucigrama").empty();
				$("#bodyListeCrucigrama").html("<tr><td colspan='5'><center>Sin registros para mostrar</center></td></tr>");
			}
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
	
}

function editarCrucigrama(p_id){
	listsilaba=[]; 
	var url =contextPath+"/cargaMaterialController/objrelacionCrucigrama?codigo="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		    $("#idRelacionCabecera").val(data.relacionCabeceraBean.codigo);
        			$("#idPalabraCrucigrama").val(data.palabra).attr("disabled",false);
        			$("#idDefinicionCrucigrama").val(data.texto).attr("disabled",false);
        			$("#idPalabraSeparada").val(data.palabraSeparada).attr("disabled",false);

        			//$("#idCmbOrden").val(data.orden).attr("disabled",false);
        			$("#idCmbOrientacion").val(data.orientacion).attr("disabled",false);
        			$("#idRelacionCrucigrama").val(data.codigo);

        			$("#x").val(data.texto2);
        			$("#y").val(data.texto3);
        			$("#idnumero").val(data.orden); 
        			$("#btn_guardar_crucigrama").attr("disabled",false);
        			document.getElementById("idPalabraCrucigrama").disabled = true;
        			document.getElementById("idPalabraSeparada").disabled = true;
        			document.getElementById("idsilaba").disabled = true;
        			document.getElementById("btn_agregarsilaba").disabled = true;
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //console.log(error);
        }
       });
	
	
}
var accion_tab = "";
var codigoEliminar="";
function confirmar_accion() {
	
	$('#md_confirmacion').modal('show');
}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}
$("#btnConfirmarGeneric").click(function() {
	
	if (accion_tab.indexOf("crucigrama") >= 0) {
		eliminarCrucigrama();
		accion_tab="";
	}

});
function confirmar_eliminar(tabla, codigo){
	//console.log("entro a coonfirmar eliminar");
	
	//console.log("tabla " +tabla);
	accion_tab = tabla;
	codigoEliminar = codigo;
	$('#md_confirmacion').modal('show');

}
function eliminarCrucigrama() {
	//console.log("codigoEliminar" + codigoEliminar);
	var url = contextPath+"/cargaMaterialController/eliminarCrucigrama?codigo="+codigoEliminar
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data) {
			//console.log("Se eliminó con éxito");
			$('#md_confirmacion').modal('hide');
			codigoEliminar = "";
			listarEjercicioCrucigrama();
			msg_exito();
			nuevoCrucigrama();
		},
		error : function(msg) {
			//console.log("errot:" + msg);
		}

	});
}
$(document).ready(function(){
	$("#base-tab42").click(function(){
		var liCodEjer = $("#idEjercicio").val();
		if((liCodEjer=="0" || liCodEjer=="" )){
			msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
			$("#base-tab41").click();
			return false;
		}
		
	});
});

function nuevoCrucigrama(){
	textosilaba = "";
	textosilabaSeparada = "";
	listsilaba=[]; 
	document.getElementById("idsilaba").disabled = false;
	document.getElementById("btn_agregarsilaba").disabled = false;
	$("#idPalabraCrucigrama").val("");
	$("#idsilaba").val("");
	$("#idPalabraSeparada").val("");
	$("#idRelacionCrucigrama").val("0");
	$("#idRelacionCabecera").val("0");
	$("#idRelacionCrucigrama").val("0");
	$("#x").val("");
	$("#y").val("");
	$("#idnumero").val("");
//	$("#idPalabraCrucigrama").val("").attr("disabled",false);
	$("#idDefinicionCrucigrama").val("").attr("disabled",false);
	//$("#idCmbOrden").val("0").attr("disabled",false);
	$("#idCmbOrientacion").val("0").attr("disabled",false);
	
	$("#btn_guardar_crucigrama").attr("disabled",false);

}


var textosilaba = "";
var textosilabaSeparada = "";
var listsilaba=[];
function agregarsilaba(){  
	if($("#idsilaba").val() != '' && $("#idsilaba").val() !=' '){
		console.log($("#idPalabraCrucigrama").val().length)
		if($("#idPalabraCrucigrama").val().length < 255){
			listsilaba.push($("#idsilaba").val()); 
			textosilaba=textosilaba+$("#idsilaba").val(); 
			textosilabaSeparada=textosilabaSeparada+$("#idsilaba").val()+"-"; 
			$("#idPalabraCrucigrama").val(textosilaba);
			$("#idPalabraSeparada").val(textosilabaSeparada);
			$("#idsilaba").val("");
		}else{
			msg_advertencia("El máximo de caracteres para la palabra es 255 caracteres.");
		}
	}

}



function grabarcrucigramadetalle(letra){  
	var codigoCab = $("#idRelacionCabecera").val();   
	var url = contextPath+"/cargaMaterialController/grabarCrucigramaDetalle";
	
	
	if(letra!= '' && letra!=' '){
$.ajax({
		type 	: "POST",
		data 	: { codigoCab:codigoCab,
					palabra : letra
					},
		url 	: url,
		success : function(data)
		{	 
			 
		},
		complete: function() 
			{ 
			$("#idRelacionCabecera").val("0");
			document.getElementById("idsilaba").disabled = false;
			document.getElementById("btn_agregarsilaba").disabled = false; 
			   listsilaba=[];
			},
		error : function()
		{
			//console.log("ERROR: ");
		}
	}); 
	}  
}




function validarCrucigrama(){
	
	var p_definicion= $("#idDefinicionCrucigrama").val();
	var p_palabra = $("#idPalabraCrucigrama").val();
	 var p_numero = $("#idnumero").val();
	var p_orientacion = $("#idCmbOrientacion").val();
	
	
	var $myForm = $('#frmregistromodal');
	
//	  if(!$myForm[0].checkValidity() || $("#idCmbOrden").val()=="0" || $("#idCmbOrientacion").val()=="0") {
//	msg_advertencia("Debe completar los campos requeridos correctamente.");
//	  }else{}
	
	if (p_palabra == "" || p_definicion == ""  ||  p_orientacion == "0" ||  p_numero == "") {
		 
		msg_advertencia("Debe ingresar todos los campos requeridos.");
	}else{
		guardarCrucigrama();
	} 
} 

function pulsar(e) {
    if (e.keyCode === 13 && !e.shiftKey) {
    	$( "#btn_agregarsilaba" ).click();
        e.preventDefault(); 
    }
}














