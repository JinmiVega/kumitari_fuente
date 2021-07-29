var contextPath 	= $('#contextPathUrl').val();
var accion_tab 		= "";
var codigoEliminar	= "";
var validarImagen  	= true;
var validarPalabra 	= true; 

 function mostrarTituloxTEM(){ 
 IniciarActividad(); 
  var p_id = $("#idEjercicio").val();
  var url =contextPath+"/cargaMaterialController/BuscarRelaCabTE?p_codmatpej="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
            
              
              if (data.codigo!=null){
              $("#idtitulocab").val(data.codigo);
              listarRelacionCabecerav();
            }else{
               $("#idtitulocab").val("0");
            }
              $("#relacionTitulov").val(data.titulo);
              listarRelacionCabecerav();
            
      }else{
        msg_advertencia("No hay registro.");
        $("#idtitulocab").val("0");
         //alert("no hay registro");
      }     
        },
        error : function(request, status, error) {
          //alert("error");
        }
       }); 
}  

function mostrarTextoXcodigo(idcodi){ 
	 
  var url =contextPath+"/cargaMaterialController/BuscarResprelavariada?p_codrelaci="+idcodi
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
           if (data != null) { 
           	$("#modalCboTipoEj").val(data.tipoRelacion);
           	obtenerTipoEj();

             if (data.codigo!=null){
              $("#idRelacionDetalle1v").val(data.codigo);
            }else{
               $("#idRelacionDetalle1v").val("0");
            }  
           $("#txtPalabra1v").val(data.texto); 
           $("#txtPalabra2v").val(data.texto2); 
           $("#idNombreImg1v").val(data.imagen);
           //$("#oracionxArrast").val(data.descripcion);
           //flagtab3Arras(false);
           //$("#btn-guardar-respuesta").attr("disabled",false);
           			var imgid = "imgmas1v";
					var file = "file1v";
					//var idDetalle = "idRelacionDetalle"+(i+1); 
					var imgsrc = contextPath+"/material/"+data.imagen;  
					$('#'+imgid).attr('src',imgsrc); 
					$("#file1v").attr("value",data.imagen);
					 

     	 $("#modalCboTipoEj").prop('disabled', true);
      }else{
        msg_advertencia("No hay registro.");
      }     
        },
        error : function(request, status, error) {
          //alert(error);
        }
       }); 
}

 

function listarRelacionCabecerav()
{
	var p_idcab 	= $("#idtitulocab").val();
	var url 			= contextPath+"/cargaMaterialController/listarRelacionVarixCab";
	
	$.ajax({
		type : 'POST',
		data :{idRelCab : p_idcab},
		url : url,
		success : function(data) 
		{
			var html = "";
			//console.log("SUCCESS: ", data);
			//limpiarActividad();
			if (data != null) 
			{
				for (var i = 0; i < data.length; i++) 
				{
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].texto+"</td> <td> <button type='button' title='Modificar' onclick='mostrarTextoXcodigo(\""+data[i].codigo+ "\")'   class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminarvari(\""+data[i].codigo+ "\")' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("idTablaRelacionListado").innerHTML=html;
				$("#idTablaRelacionListado").html(html);
			}
			else
			{
				//console.log("SUCCESS: ", "La lista está vacía");
			}
		},
		error : function(data) {
			//console.log("error de listarMaterialTipoEjercicio :" + data+ error);
		}
	});
}




var codvari =0;
function confirmar_eliminarvari(cod){
codvari   = cod; 
$('#md_confirmacion').modal('show');  
}  

    $("#btnConfirmarGeneric").click(function() {
      if (codvari != null  && codvari != 0  ){
        eliminarvari(codvari);
         }else{
          return false;
    }

  });

function eliminarvari(codv){ 
$.ajax({
url : contextPath +"/cargaMaterialController/eliminarRelacionVariada?codigo="+codv,
 type : 'GET',
  success : function(data) {
  $('#md_confirmacion').modal('hide');
  listarRelacionCabecerav(); 
  },
   error : function(request, status, error) {
    //alert(error);
      }
     });
   };



function limpiarActividad()
{
	 
	$("#imgmas1v").attr("src","../assets/img/usar_imagen.jpg"); 
	$("#file1v").val(""); 
	$("#idNombreImg1v").val("");
	$("#txtPalabra1v").val("");
	$("#txtPalabra2v").val(""); 
	$("#idRelacionDetalle1v").val("0");
	$("#modalCboTipoEj").val("0");  
	$("#modalCboTipoEj").attr("disabled",false);

	 listarRelacionCabecerav();
}




function guardarTituloRelaVari()
  {
     
   var p_titulo   = $("#relacionTitulov").val().trim();   
   var p_codmatpej   = $("#idEjercicio").val();  
   var p_idTitulo  = $("#idtitulocab").val();  
   let url = contextPath + "/cargaMaterialController/grabarTituloRelaVariada";
 
    

      $.ajax({
          type :  "POST",
          url  :  url,
          data : { p_codmatpej     :  p_codmatpej,
                   p_titulo        :  p_titulo, 
                   id_RelaVariTitulo : p_idTitulo },
            success : function(data)
              { 
             // msg_exito();
              $("#idtitulocab").val(data);  
              insertarDetalleRelacionImagenv();
              //listarRelacionCabecerav();
              
              },
              error : function()
              {
                //alert("No se pudo ingresar el registro");
                //console.log("ERROR: ");
              }
      }); 

      
  } 

function insertarDetalleRelacionImagenv()
{
	var p_codprelcab 	= $("#idtitulocab").val();
	var id_detalle 		= $("#idRelacionDetalle1v").val();
	var id_combo 		= $("#modalCboTipoEj").val();

	var Image11 		= $("#file1v").val(); 
	var nomimg 		= $("#idNombreImg1v").val();

	if (id_combo==1){


		if(Image11 != undefined && Image11!=null && Image11!='' ){
			 
	var url 			= contextPath+"/cargaMaterialController/grabarRelacionDetalleImagenv";
	var exito			= "1";
	$("#tblRelacionv tbody tr").each(function (index)
	{
		var i = (index+1);
		var p_palabra1		= $("#txtPalabra1v").val().trim();
		var p_palabra2		= $("#txtPalabra2v").val().trim();
		var inputFileImage 	= document.getElementById("file1v");
		var file 			= inputFileImage.files[0];
		var data 			= new FormData();

		data.append('codprelcab',	p_codprelcab);
		data.append('p_texto1',		p_palabra1);
		data.append('p_texto2',		p_palabra2);
		data.append('p_tiporelaci',		id_combo);
		data.append('id_detalle',		id_detalle); 
		data.append('file',			file); 

		if (p_codprelcab != "0" && exito == "1" && p_palabra1!=""  ) 
		{
			$.ajax({
				type : 	"POST",
				url	 :	url,
				contentType:false,
				data:data,
		   		//data:{codprelcab:p_codprelcab,palabra:p_palabra,file:file},
		   		processData:false,
		   		cache:false,
		   		success: function(data)
		  	  	{   $("#idRelacionDetalle1v").val(data);
		   			if(data != "0")
		   			{
		   				exito = "1";
		   			}
		   			else
		   			{
		   				exito = "0";
		   			}
		   			//listarRelacionCabecerav();
		   			limpiarActividad();
		   			listarRelacionCabecerav();
		   			IniciarActividad();
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
}else if (nomimg!='' && nomimg!=null)
{


	var url 			= contextPath+"/cargaMaterialController/grabarRelacionDetalleImagenv3";
	var exito			= "1";
	$("#tblRelacionv tbody tr").each(function (index)
	{
		var i = (index+1);
		var p_palabra1		= $("#txtPalabra1v").val().trim();
		var p_palabra2		= $("#txtPalabra2v").val().trim(); 
		var data 			= new FormData();

		data.append('codprelcab',	p_codprelcab);
		data.append('p_texto1',		p_palabra1);
		data.append('p_texto2',		p_palabra2);
		data.append('p_tiporelaci',		id_combo);
		data.append('id_detalle',		id_detalle); 
		data.append('p_imagen',			nomimg); 

		if (p_codprelcab != "0" && exito == "1" && p_palabra1!="") 
		{
			$.ajax({
				type : 	"POST",
				url	 :	url,
				contentType:false,
				data:data,
		   		//data:{codprelcab:p_codprelcab,palabra:p_palabra,file:file},
		   		processData:false,
		   		cache:false,
		   		success: function(data)
		  	  	{   $("#idRelacionDetalle1v").val(data);
		   			if(data != "0")
		   			{
		   				exito = "1";
		   			}
		   			else
		   			{
		   				exito = "0";
		   			}
		   			//listarRelacionCabecerav();
		   			limpiarActividad();
		   			listarRelacionCabecerav();
		   			IniciarActividad();
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
}else{
	msg_info("Debe completar los campos");
} 

}else if(id_combo==2) {

	var url 			= contextPath+"/cargaMaterialController/grabarRelacionDetalleImagenv2";
	var exito			= "1";
	$("#tblRelacionv tbody tr").each(function (index)
	{
		var i = (index+1);
		var p_palabra1		= $("#txtPalabra1v").val().trim();
		var p_palabra2		= $("#txtPalabra2v").val().trim(); 
		var data 			= new FormData(); 
		data.append('codprelcab',	p_codprelcab);
		data.append('p_texto1',		p_palabra1);
		data.append('p_texto2',		p_palabra2);
		data.append('p_tiporelaci',		id_combo);
		data.append('id_detalle',		id_detalle);  
		if (p_codprelcab != "0" && exito == "1" && p_palabra1!="" && p_palabra2!="") 
		{
			$.ajax({
				type : 	"POST",
				url	 :	url,
				contentType:false,
				data:data,
		   		//data:{codprelcab:p_codprelcab,palabra:p_palabra,file:file},
		   		processData:false,
		   		cache:false,
		   		success: function(data)
		  	  	{   $("#idRelacionDetalle1v").val(data);
		   			if(data != "0")
		   			{
		   				exito = "1";
		   			}
		   			else
		   			{
		   				exito = "0";
		   			}
		   			//listarRelacionCabecerav();
		   			limpiarActividad();
		   			listarRelacionCabecerav();
		   			IniciarActividad();
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


}else{

	msg_info("Debe completar los campos");
}

 



	if(exito == "0")
	{
		msg_error();
	}
	  
	//listarRelacionCabecerav();
} 


function obtenerTipoEj(){
		if($("#modalCboTipoEj").val()=="1"){
			$("#td1").show();
			$("#td2").show();
			$("#td3").hide();
			$("#td4").hide();
			$("#list1").show();
			$("#txtPalabra1v").show();
			$("#txtPalabra2v").hide();
			
		} else if($("#modalCboTipoEj").val()=="2"){
			$("#td1").hide();
			$("#td2").hide();
			$("#td3").show();
			$("#td4").show();
			$("#list1").hide();
			$("#txtPalabra1v").show();
			$("#txtPalabra2v").show();
		}else{
			$("#td1").hide();
			$("#td2").hide();
			$("#td3").hide();
			$("#td4").hide();
			$("#list1").hide();
			$("#txtPalabra1v").hide();
			$("#txtPalabra2v").hide();
			
		}
		 
	}

	function IniciarActividad(){
		$("#td1").hide();
		$("#td2").hide();
		$("#td3").hide();
		$("#td4").hide();
		$("#list1").hide();
		$("#txtPalabra1v").hide();
		$("#txtPalabra2v").hide();

	}