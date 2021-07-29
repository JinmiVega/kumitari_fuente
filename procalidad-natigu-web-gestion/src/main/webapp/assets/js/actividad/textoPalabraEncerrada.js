function guardarTextoPalabraEncerrada()
  {
    var p_titulo   = $("#idoraciontitulo").val(); 
    var p_comentario   = $("#TxtComentario1").val();   
   var p_codmatpej   = $("#idEjercicio").val();
   var p_oracion     = $("#bodyParrafo .note-editable").html();
   var p_codOracion  = $("#idoraciondesc").val(); 
   if (p_codmatpej!=null && p_codmatpej!='' && p_codmatpej!='0' ){  
	if (p_oracion!=null && p_oracion!='' ){  //&& p_titulo!=null && p_titulo!=''

    /* alert(p_codleccion + "modalCboLeccion \n"+ "-titulo" +p_tituloejercicio+ "_"); */

     
      let url = contextPath +"/cargaMaterialController/grabarTextoPalabraEncerrada";
 
      $.ajax({
          type :  "POST",
          url  :  url,
          data : {	p_codmatpej:  p_codmatpej,
        	  		p_titulo:  p_titulo,
                p_comentario:  p_comentario,
        	  		p_oracion:    p_oracion,
        	  		idOracionComple : p_codOracion 
        	  	 },
            success : function(data)
              {
              
              msg_exito();
              $("#idoraciondesc").val(data);
              },
              error : function()
              {
                //alert("No se pudo ingresar el registro");
                //console.log("ERROR: ");
              }
      });
      
	   }else{
	       msg_info("Debe completar los campos");
	    }
	  }else{
	      msg_info("Debe seleccionar un ejercicio");
	    }

     
  }









  function enviarAlternativasTextoPalabraEncerrada(tipoaccion){
    //console.log("r: " + tipoaccion);
    let url = tipoaccion == 1 ? contextPath +"/cargaMaterialController/grabarPalabraEncerradaTexto" : contextPath +"/cargaMaterialController/actualizarOracionAlter";

    var cood   = $("#idoraciondesc").val();
    var cood1   = $("#txtPreguntaDescripcionDet").val();
    var cood2   = $("#idespacio").val();
    var esp1    = $("#txtnumeroespacioEn3").val(); 
    var rpta1	= $("#txtPalabraRpta").val();
//    var cood1  = $("#rptaDescripcion0").val();
//    var cood2  = $("#rptaDescripcion1").val();
//    var cood3  = $("#rptaDescripcion2").val(); 
//    var esp    = $("#idespacio").val(); 
//    var inp1    = document.getElementById("0");
//    var inp2    = document.getElementById("1");
//    var inp3    = document.getElementById("2");
//    if($(inp1).is(':checked')){
//    inp1 = "1";
//    } 
//    if($(inp2).is(':checked')){
//    inp2 = "1";
//    } 
//    if($(inp3).is(':checked')){
//    inp3 = "1";
//    }
    if (cood!=null && cood!='' && cood!='0' ){  
    if (cood2!=null && cood2!='' && esp1!=null && esp1!=''  && esp1!='0') {  
    	
    	 $("#txtnumeroespacioEn3").attr("disabled",true);
        $("#idespacio").attr("disabled",true);
        $("#txtPalabraRpta").attr("disabled",true);
        $("#btn-guardar-oracionPed").attr("disabled",true);
        $("#btn_nuevo").attr("disabled",false);
    $.ajax({
        
             type: "POST",
             data: {
            	 	p_codTextoPE:cood,
            	 	p_palabraEncerrada:cood2,
            	 	codTextoAPE:cood1,
            	 	nroOrden:esp1,
            	 	p_palabraRpta:rpta1
            	   },
             url: url,
             success: function(data)
             {  
//                if ( document.getElementById("idalter0").value !=0
//                  && document.getElementById("idalter1").value !=0
//                  && document.getElementById("idalter2").value !=0 ) {
//                
//              //console.log(data);
//              }
//              else { $("#idalter0").val(data-2);
//                     $("#idalter1").val(data-1);
//                     $("#idalter2").val(data); 
//
//
//              }
               msg_exito();
               limpiarAlternativasPalabraEncerrada();
               /*
               $("#rptaDescripcion0").attr("disabled",true);
               $("#rptaDescripcion1").attr("disabled",true);
               $("#rptaDescripcion2").attr("disabled",true);*/
     
              
               
              //console.log(data);
              listadoDePalabraEncerradaxTexto();
             },
         error: function(er) {
           //console.log(" er:" + er.error);//console.log("er: " + er.responseText);

         }
           });
    }else{
        msg_info("Debe completar el campo");
     }
   }else{
       msg_info("Debe agregar una oración");
     }
  }


  var accionPregunta12 = 1;
  function agregarAlternativaPalabraEncerrada(tipoaccion){
    var p_codoracion = $("#idoraciondesc").val();
    //console.log("idoraciondesc: "+ p_codoracion);
    	
//    if (! $("input[name=rpst]").is(":checked") && ) {
//       msg_advertencia("Seleccione una respuesta predeterminada");
//        return false;
//     }

    
    if(p_codoracion != null || p_codoracion == ""){
      var arrayAlternativas   = [];
      var objPregunta = { codigo : p_codoracion};
      $("#tblPregunta tbody tr").each(function (index)
      {
        var objAlernativa = {
            codigo      : 0,  
            respuestaEstado : '0',
            descripcion   : '',
            oracionCompletarBean  : objPregunta,
            espacio : ""
              };
        input    = document.getElementById(index);
        if($(input).is(':checked')){
          objAlernativa.respuestaEstado = "1";
             }
        else
        {
          objAlernativa.respuestaEstado = "0";
        }

          


         tipoaccion == 1 ;
         objAlernativa.codigo= document.getElementById("idalter"+index).value;
        //console.log("rpta: "+objAlernativa.codigo);
         //console.log("index: "+index); 
      //  objAlernativa.descripcion    = document.getElementById("rptaDescripcion"+index).value;
        objAlernativa.espacio = document.getElementById("idespacio").value;
        //console.log("asas" +  document.getElementById("idespacio").value);
        arrayAlternativas.push(objAlernativa);

      });
      enviarAlternativasTextoPalabraEncerrada(tipoaccion,arrayAlternativas);

    }
    else{
      //alert("No se pudo registrar las alternativas");
    }

  }



  function mostrarTextoPalabraEncerredaxTEM(){
  
  var p_id = $("#idEjercicio").val();
  var url =contextPath+"/cargaMaterialController/ListTextoPalabraEncerradaxMaterialTE?p_codmatpej="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
            
            	$("#bodyParrafo .note-editable").html(data.texto);
              if (data.codigo!=null){
              $("#idoraciondesc").val(data.codigo);
            }else{
               $("#idoraciondesc").val("0");
            }
              $("#idoraciontitulo").val(data.titulo);
              $("#TxtComentario1").val(data.comentario);
            
      }else{
        msg_advertencia("No hay registro.");
        $("#idoraciondesc").val("0");
         //alert("no hay registro");
      }     
        },
        error : function(request, status, error) {
          //alert("error");
        }
       });
  
  
}

//mostrarAlternativasxidTextoPalabraEncerrada

function mostrarAlternativasxidTextoPalabraEncerrada(id_ora){
  
 
  var url =contextPath+"/cargaMaterialController/BuscarAlternativasxPalabraEncerradaTexto?p_codaltern="+id_ora
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
              //console.log('id_oraid_ora '+id_ora)
               
              //alert(data.palabraEncerrada);
//              $("#idespacio").val(nespacio).attr("disabled",false);  
//                for(var i=0;i<data.length;i++){
                	//console.log("data" +  data); 
              
              		$("#txtnumeroespacioEn3").val(data.nroOrden).attr("disabled",false); 
                	if (data.nroOrden==0) {
                
                		$("#txtnumeroespacioEn3").val("");
                	}else {
                		//console.log('----');
                	}
                    $("#idespacio").val(data.palabraEncerrada).attr("disabled",false);  
                    $("#txtPalabraRpta").val(data.palabraRpta).attr("disabled",false);
                    $("#txtPreguntaDescripcionDet").val(data.codigo).attr("disabled",false);  ;
//                }
//           $("#rptaDescripcion"+i).val(data[i].descripcion).attr("disabled",false);
//           $("#idalter"+i).val(data[i].codigo);
//
//          var idrpta = i;
//          var valrpta = data[i].respuestaEstado == 1 ? true : false;
//          $("#"+ idrpta).prop('checked', valrpta);
//         // $("#"+ idrpta).val(data[i].codigo);
//            //console.log("Dato: "+ data[i].descripcion);
//              //html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo + "\",\"" + data[i].descripcion +"\");' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
          
 
              
                $("#btn-guardar-oracionPed").attr("disabled",false);


      }else{
        msg_advertencia("No hay registro.");
      }     
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
  
  
}







 function listadoDePalabraEncerradaxTexto()
{
  
 
  var p_oracion    = $("#idoraciondesc").val();
  var p_tipoejer   = $("#modalIdTipoEjercicio").val();
  var url =  contextPath +"/cargaMaterialController/ListEspacioxTextoPalabraEncerrada";
  var html = "";
  $.ajax({
    type : 'POST',
    data :{p_codtextopalabracorrec : p_oracion },
    url : url,
    success : function(data) 
    {
      //console.log("SUCCESS: ", data);
      if (data != null && data.length > 0) 
      {
        for (var i = 0; i < data.length; i++) 
        {
          html += 
        	  "<tr> " +
        	  	"<td>"+(i+1)+"</td>" +
        	  	"<td> "+data[i].palabraEncerrada+"</td> ";
        	  	if(p_tipoejer=="38"){
        	  		html+="<td> "+data[i].palabraRpta+"</td> ";
        	  	}
        	  	html +=
        	  	"<td> " +
        	  		"<button type='button' title='Modificar' onclick='mostrarAlternativasxidTextoPalabraEncerrada("+data[i].codigo+")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> " +
        	  		"<button type='button' title='Eliminar' onclick='confirmar_accionTextoPalabraEncerradaAlter("+data[i].codigo+")' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> " +
        	  	"</td>" +
        	  "</tr>";
        }
        limpiarAlternativasPalabraEncerrada();
        document.getElementById("idTablaEspaciosListado27APE").innerHTML=html;
      }else{
          $("#idTablaEspaciosListado27APE").html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");
      }
    },
    error : function(data) {
      //console.log("error de idTablaEspaciosListado27APE :" + data+ error);
    }
  });
  
}


var numesp ="";
var codi =0;
    function confirmar_accionTextoPalabraEncerradaAlter(codora) {
  
    codi   = codora;
    $('#md_confirmacion').modal('show'); 
  }

    $("#btnConfirmarGeneric").click(function() {
      if (codi != null && codi != 0 ){
        eliminarAlternatTextoPalabraEncerrada(codi);
      }else{
        return false;
        //console.log("entro al else, palabra encerrada"  );
      }
    

  });

    function eliminarAlternatTextoPalabraEncerrada(codora){
        //  alert("eliminarLengua " + codigo);
          $.ajax({
            url : contextPath +"/cargaMaterialController/eliminarAlternativasTextoPalabraEncerrada?p_codaltern="+codora,
            type : 'GET',
            success : function(data) {
              $('#md_confirmacion').modal('hide');
              listadoDePalabraEncerradaxTexto();
            },
            error : function(request, status, error) {
              //alert(error);
            }
           });
          };




function nuevoAlternativasPalabraEncerrada(){
	 $("#idespacio").val("").attr("disabled",false);
	 $("#txtPalabraRpta").val("").attr("disabled",false);
	 $("#txtnumeroespacioEn3").val("").attr("disabled",false);
	 
	  $("#txtPreguntaDescripcionDet").val("0");
//     $("#idalter0").val("0");
//     $("#idalter1").val("0");
//     $("#idalter2").val("0");
//     $("#rptaDescripcion0").val("").attr("disabled",false);
//     $("#rptaDescripcion1").val("").attr("disabled",false);
//     $("#rptaDescripcion2").val("").attr("disabled",false);
     $("#btn-guardar-oracionPed").attr("disabled",false);
}


function limpiarAlternativasPalabraEncerrada()

{
	$("#txtnumeroespacioEn3").val("")
  $("#idespacio").val("");
	$("#txtPalabraRpta").val("");
  $("#txtPreguntaDescripcionDet").val("0");
  
//  $("#idalter0").val("0");
//  $("#idalter1").val("0");
//  $("#idalter2").val("0");
//  $("#rptaDescripcion0").val("");
//  $("#rptaDescripcion1").val("");
//  $("#rptaDescripcion2").val("");
//
//  $("#0").attr('checked', false);
//  $("#1").attr('checked', false);
//  $("#2").attr('checked', false);
}

//$(document).ready(function(){
//	$("#base-tab42,#base-tab43").click(function(){
//		var liCodEjer = $("#idEjercicio").val();
//		if((liCodEjer=="0" || liCodEjer=="" )){
//			msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
//			$("#base-tab41").click();
//			return false;
//		}
//		
//	});
//});
