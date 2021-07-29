var contextPath 	= $('#contextPathUrl').val();
var accion_tab 		= "";
var codigoEliminar	= "";
var validarImagen  	= true;
var validarPalabra 	= true; 

 function mostrarTituloxTEMti(){ 
 
  var p_id = $("#idEjercicio").val();
  var url =contextPath+"/cargaMaterialController/BuscarRelaCabTE?p_codmatpej="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
            
              
              if (data.codigo!=null){
              $("#idtitulocabti").val(data.codigo);
              listarRelacionCabecerati();
            }else{
               $("#idtitulocabti").val("0");
            }
              $("#relacionTituloti").val(data.titulo);
              listarRelacionCabecerati();

            
      }else{
        msg_advertencia("No hay registro.");
        $("#idtitulocabti").val("0");
         //alert("no hay registro");
      }     
        },
        error : function(request, status, error) {
          //alert("error");
        }
       }); 
}  

function mostrarTextoXcodigoti(idcodi){ 
	 
  var url =contextPath+"/cargaMaterialController/BuscarResprelacion?p_codrelaci="+idcodi
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
           if (data != null) {   
             if (data.codigo!=null){
              $("#idRelacionDetalle1ti").val(data.codigo);
            }else{
               $("#idRelacionDetalle1ti").val("0");
            }  
           $("#txtPalabra1ti").val(data.texto); 
           
           $("#idNombreImg1ti").val(data.imagen);
           //$("#oracionxArrast").val(data.descripcion);
           //flagtab3Arras(false);
           //$("#btn-guardar-respuesta").attr("disabled",false);
           			var imgid = "imgmas1ti";
					var file = "file1ti";
					//var idDetalle = "idRelacionDetalle"+(i+1); 
					var imgsrc = contextPath+"/material/"+data.imagen;  
					$('#'+imgid).attr('src',imgsrc); 
					$("#file1ti").attr("value",data.imagen);
					 
 
      }else{
        msg_advertencia("No hay registro.");
      }     
        },
        error : function(request, status, error) {
          //alert(error);
        }
       }); 
}

 

function listarRelacionCabecerati()
{
	var p_idcab 	= $("#idtitulocabti").val();
	var url 			= contextPath+"/cargaMaterialController/listarRelacionDetalleImagen";
	var html 			= "";
	$.ajax({
		type : 'POST',
		data :{idRelCab : p_idcab},
		url : url,
		success : function(data) 
		{
			//console.log("SUCCESS: ", data);
			//limpiarActividadti();
			if (data != null &&  p_idcab!=0 && p_idcab!=null) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].texto+"</td> <td> <button type='button' title='Modificar' onclick='mostrarTextoXcodigoti(\""+data[i].codigo+ "\")'   class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminarti(\""+data[i].codigo+ "\")' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				document.getElementById("idTablaRelacionListadoti").innerHTML=html;
			}
			else
			{   limpiartable();
				//console.log("SUCCESS: ", "La lista está vacía");
			}
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
}




var codvarti =0;
function confirmar_eliminarti(cod){
codvarti   = cod; 
$('#md_confirmacion').modal('show');  
}  

    $("#btnConfirmarGeneric").click(function() {
      if (codvarti != null  && codvarti != 0  ){
        eliminarti(codvarti);
         }else{
          return false;
    }

  });

function eliminarti(codv){ 
$.ajax({
url : contextPath +"/cargaMaterialController/eliminarRelacionTI?codigo="+codv,
 type : 'GET',
  success : function(data) {
  $('#md_confirmacion').modal('hide');
  listarRelacionCabecerati(); 
  },
   error : function(request, status, error) {
    //alert(error);
      }
     });
   };
function limpiartable(){ 
	//document.getElementById("idTablaRelacionListadoti").innerHTML="";
	$('#idTablaRelacionListadoti').html('<tr><td colspan="3"><center>Sin registros para mostrar</center></td></tr>');
           
}


function limpiarActividadti()
{ 
	$("#imgmas1ti").attr("src","../assets/img/usar_imagen.jpg"); 
	$("#file1ti").val(""); 
	$("#idNombreImg1ti").val("");
	$("#txtPalabra1ti").val(""); 
	$("#idRelacionDetalle1ti").val("0");  
	 listarRelacionCabecerati();
}


function limpiarCabece(){
	 
	$("#relacionTituloti").val(""); 
	$("#idtitulocabti").val("0"); 
	limpiarActividadti();
	limpiartable(); 
}




function guardarTituloRelati()
  {
     
   var p_titulo   = $("#relacionTituloti").val().trim();   
   var p_codmatpej   = $("#idEjercicio").val();  
   var p_idTitulo  = $("#idtitulocabti").val();  
   let url = contextPath + "/cargaMaterialController/grabarTituloRelaVariada";
 
    
   	iniciarBloqueo();
      $.ajax({
          type :  "POST",
          url  :  url,
          data : { p_codmatpej     :  p_codmatpej,
                   p_titulo        :  p_titulo, 
                   id_RelaVariTitulo : p_idTitulo },
            success : function(data)
              { 
            	finBloqueo();
             // msg_exito();
              $("#idtitulocabti").val(data);  
             
              insertarDetalleRelacionImagenti();
              //listarRelacionCabecerav();
              
              },
              error : function()
              {
                //alert("No se pudo ingresar el registro");
                //console.log("ERROR: ");
              }
      }); 

      
  } 

function insertarDetalleRelacionImagenti()   
{  
	var p_codprelcab 	= $("#idtitulocabti").val();
	var id_detalle 		= $("#idRelacionDetalle1ti").val(); 

	var Image11 		= $("#file1ti").val(); 
	 var nomimg 		= $("#idNombreImg1ti").val(); 
		 
	//	if(Image11 != undefined && Image11!=null && Image11!='' ){
			 
	var url 			= contextPath+"/cargaMaterialController/grabarRelacionDetalleImagenTI"; 
	var exito			= "1";
	$("#tblRelacionti tbody tr").each(function (index)
	{
		var i = (index+1);
		var p_palabra1		= $("#txtPalabra1ti").val().trim(); 
		var inputFileImage 	= document.getElementById("file1ti");
		var file 			= inputFileImage.files[0];
		var data 			= new FormData();

		data.append('codprelcab',	p_codprelcab);
		data.append('p_texto1',		p_palabra1); 
		data.append('id_detalle',		id_detalle);  
		if (file!= '' && file!=null){
		data.append('file',			file); 
		}
		if (p_codprelcab != "0"   && p_palabra1!="" && (file !=null || nomimg!='' )  ) 
		{  
			iniciarBloqueo();
			$.ajax({
				type : 	"POST",
				url	 :	url,
				contentType:false,
				data:data,
		   		//data:{codprelcab:p_codprelcab,palabra:p_palabra,file:file},
		   		processData:false,
		   		cache:false,
		   		success: function(data)
		  	  	{   
		   			finBloqueo();
		   			$("#idRelacionDetalle1ti").val(data);
		   			if(data != "0")
		   			{
		   				exito = "1";
		   			}
		   			else
		   			{
		   				exito = "0";
		   			}
		   			//listarRelacionCabecerav();
		   			limpiarActividadti();
		   			listarRelacionCabecerati(); 
		   			msg_exito();
		   			
		  	  	},
		  	  	error : function()
		  	  	{
		  	  		exito = "0";
		 	 		//console.log("ERROR: "+ "No se pudo ingresar el registro");
		  	  	}
			});
		}else{
			msg_info("Debe completar los campos");
		}
		
	 });
//}else if (nomimg!='' && nomimg!=null)
//{
//
//
//	var url 			= contextPath+"/cargaMaterialController/grabarRelacionDetalleImagenTI3";
//	var exito			= "1";
//	$("#tblRelacionti tbody tr").each(function (index)
//	{
//		var i = (index+1);
//		var p_palabra1		= $("#txtPalabra1ti").val().trim(); 
//		var data 			= new FormData();
//
//		data.append('codprelcab',	p_codprelcab);
//		data.append('p_texto1',		p_palabra1); 
//		data.append('id_detalle',		id_detalle); 
//		data.append('p_imagen',			nomimg); 
//
//		if (p_codprelcab != "0" && exito == "1" && p_palabra1!="") 
//		{
//			$.ajax({
//				type : 	"POST",
//				url	 :	url,
//				contentType:false,
//				data:data,
//		   		//data:{codprelcab:p_codprelcab,palabra:p_palabra,file:file},
//		   		processData:false,
//		   		cache:false,
//		   		success: function(data)
//		  	  	{   $("#idRelacionDetalle1ti").val(data);
//		   			if(data != "0")
//		   			{
//		   				exito = "1";
//		   			}
//		   			else
//		   			{
//		   				exito = "0";
//		   			}
//		   			//listarRelacionCabecerav();
//		   			limpiarActividadti();
//		   			listarRelacionCabecerati(); 
//		   			msg_exito();
//		   			
//		  	  	},
//		  	  	error : function()
//		  	  	{
//		  	  		exito = "0";
//		 	 		//console.log("ERROR: "+ "No se pudo ingresar el registro");
//		  	  	}
//			});
//		}else{
//			msg_info("Debe completar los campos");
//		}
//		
//	 }); 
//}else{
//	msg_info("Debe completar los campos");
//} 

 

	if(exito == "0")
	{
		msg_error();
	}
	  
	//listarRelacionCabecerav();
} 


 