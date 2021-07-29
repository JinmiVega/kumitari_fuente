


function guardarTextoPalabraCorrecta()
  {
   var p_titulo       = $("#idoraciontitulo").val();  
   var p_comentario   = $("#TxtComentario").val();  
   var p_codmatpej    = $("#idEjercicio").val();
//   console.log("txt;" + $("#bodyParrafo .note-editable").html());
   var p_oracion     = $("#bodyParrafo .note-editable").html();
   var p_codOracion  = $("#idoraciondesc").val(); 
   if (p_codmatpej!=null && p_codmatpej!='' && p_codmatpej!='0' ){  
	if (p_oracion!=null && p_oracion!=''){  // && p_titulo!=null && p_titulo!=''

    /* alert(p_codleccion + "modalCboLeccion \n"+ "-titulo" +p_tituloejercicio+ "_"); */

     
      let url = contextPath +"/cargaMaterialController/grabarTextoPalabraCorrecta";
 
      $.ajax({
          type :  "POST",
          url  :  url,
          data : {	p_codmatpej:  p_codmatpej,
        	  		p_titulo:  p_titulo,
                p_comentario:  p_comentario,
        	  		p_oracion:    p_oracion,
        	  		idOracionComple : p_codOracion 
        	  	 },
        	 beforeSend: function(){
        		 //co//consoleog('cargando....');
//        	  	     $("#loading").show();
        	   },
        	 complete: function(){
        		 //console.log('cargando....');
//        	  	     $("#loading").hide();
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









  function enviarAlternativasTextoPalabraCorrecta(tipoaccion, arrayAlternativas){
    //console.log("r: " + tipoaccion);
    let url = tipoaccion == 1 ? contextPath + "/cargaMaterialController/grabarPalabraCorrectaTexto" : contextPath +"/cargaMaterialController/actualizarOracionAlter";
    
    var cood   = $("#idoraciondesc").val();
    var cood1  = $("#rptaDescripcion0").val();
    var cood2  = $("#rptaDescripcion1").val();
    var cood3  = $("#rptaDescripcion2").val(); 
    var esp    = $("#idespacio").val(); 
    var esp1    = $("#txtnumeroespacio3").val(); 
    var inp1    = document.getElementById("0");
    var inp2    = document.getElementById("1");
    var inp3    = document.getElementById("2");
    if($(inp1).is(':checked')){
    inp1 = "1";
    } 
    if($(inp2).is(':checked')){
    inp2 = "1";
    } 
    if($(inp3).is(':checked')){
    inp3 = "1";
    }
    if (cood!=null && cood!='' && cood!='0' ){  
    if ((esp1!=null && esp1!='' && esp1!='0' && esp!=null && esp!='' && cood1!=null && cood1!='' && cood2!=null && cood2!=''
     && cood3!=null && cood3!='') && (inp1=='1' || inp2=='1' || inp3=='1') ) {  
    	
    	/******/
    	$("#idespacio").attr("disabled",true);
    	$("#txtnumeroespacio3").attr("disabled",true);
        $("#rptaDescripcion0").attr("disabled",true);
        $("#rptaDescripcion1").attr("disabled",true);
        $("#rptaDescripcion2").attr("disabled",true);
        $("#btn-guardar-oracionCd").attr("disabled",true);
        $("#btn_nuevo").attr("disabled",false);
    
    $.ajax({
         contentType: "application/json",
             type: "POST",
             data: JSON.stringify(arrayAlternativas),
             url: url,
             success: function(data)
             {
                 
            
                if ( document.getElementById("idalter0").value !=0
                  && document.getElementById("idalter1").value !=0
                  && document.getElementById("idalter2").value !=0 ) {
                
              //console.log(data);
              }
              else { $("#idalter0").val(data-2);
                     $("#idalter1").val(data-1);
                     $("#idalter2").val(data); 


              }
               msg_exito();
               limpiarAlternativasPalabraCorrecta();
      
              
              
              //console.log(data);
              listadoDePalabraCorrectaxTexto();
             },
         error: function(er) {
           //console.log(" er:" + er.error);//console.log("er: " + er.responseText);

         }
           });
    }else{
        msg_info("Debe completar los campos y/o seleccione una pregunta correcta.");
     }
   }else{
       msg_info("Debe agregar una oración");
     }
  }


  var accionPregunta12 = 1;
  function agregarAlternativaPalabraCorrecta(tipoaccion){
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
            textoPalabraCorrectaBean  : objPregunta,
            palabraCorrecta : "",
            nroOrden : 0
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
        objAlernativa.descripcion    = document.getElementById("rptaDescripcion"+index).value;
        objAlernativa.palabraCorrecta = document.getElementById("idespacio").value.trim();
        //console.log("idespacio " +  document.getElementById("idespacio").value.trim());
        
        objAlernativa.nroOrden = document.getElementById("txtnumeroespacio3").value.trim();
        //console.log("txtnumeroespacio3 " +  document.getElementById("txtnumeroespacio3").value.trim());
        
        arrayAlternativas.push(objAlernativa);

      });
      enviarAlternativasTextoPalabraCorrecta(tipoaccion,arrayAlternativas);

    }
    else{
      //alert("No se pudo registrar las alternativas");
    }

  }



  function mostrarTextoPalabraCorrectaxTEM(){
  
  var p_id = $("#idEjercicio").val();
  var url =contextPath+"/cargaMaterialController/ListTextoPalabraCorrectaxMaterialTE?p_codmatpej="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
            
            	$("#bodyParrafo .note-editable").html(data.texto);
              if (data.codigo!=null){
              $("#idoraciondesc").val(data.codigo);
            }else{
            	//console.log('entro 0')
               $("#idoraciondesc").val("0");
               $("#idoraciontitulo").val('');
               $("#TxtComentario").val('');
            }
              $("#idoraciontitulo").val(data.titulo);
              $("#TxtComentario").val(data.comentario);
            
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

//mostrarAlternativasxidTextoPalabraCorrecta

function mostrarAlternativasxidTextoPalabraCorrecta(id_ora,nespacio){
 
 
  var url =contextPath+"/cargaMaterialController/BuscarAlternativasxPalabraCorrectaTexto?p_codcomporacion="+id_ora+"&p_numespacio="+nespacio
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {     
        
        	
            if (data != null) {
              
               //console.log("data" +  data); 
            
              //console.log("data.nroOrden " +  data.nroOrden); 
//              $("#txtnumeroespacio3").val(data.nroOrden).attr("disabled",false);  
                for(var i=0;i<data.length;i++){
                	  $("#idespacio").val(data[i].palabraCorrecta).attr("disabled",false);  
                	$("#txtnumeroespacio3").val(data[i].nroOrden).attr("disabled",false);  
                	if (data[i].nroOrden==0) {
                
                		$("#txtnumeroespacio3").val("");
                	}else {
                		//console.log('----');
                	}
                	 //console.log("data[i].nroOrden " +  data[i].nroOrden); 
                	
           $("#rptaDescripcion"+i).val(data[i].descripcion).attr("disabled",false);
           $("#idalter"+i).val(data[i].codigo);
//           alert("sdfs "+data[i].codigo);
//           alert("sdfs 2"+data[i].descripcion);
           
          var idrpta = i;
          var valrpta = data[i].respuestaEstado == 1 ? true : false;
          $("#"+ idrpta).prop('checked', valrpta);
         // $("#"+ idrpta).val(data[i].codigo);
            ////console.log("Dato: "+ data[i].descripcion);
              //html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo + "\",\"" + data[i].descripcion +"\");' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
            }
 
              
                $("#btn-guardar-oracionCd").attr("disabled",false);


      }else{
        msg_advertencia("No hay registro.");
      }     
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
  
  
}







 function listadoDePalabraCorrectaxTexto()
{
  
 
  var p_oracion    = $("#idoraciondesc").val();
  var url =  contextPath +"/cargaMaterialController/ListEspacioxTextoPalabraCorrecta";
 
  $.ajax({
    type : 'POST',
    data :{p_codtextopalabracorrec : p_oracion },
    url : url,
    success : function(data) 
    {
	  var html = "";
      //console.log("SUCCESS listadoDePalabraCorrectaxTexto: ", data);
      if (data != null && data.length > 0) 
      {
        for (var i = 0; i < data.length; i++) 
        {
          html = html+"<tr> <td>"+(i+1)+"</td><td> "+data[i].palabraCorrecta+"</td> <td> <button type='button' title='Modificar'  onclick='mostrarAlternativasxidTextoPalabraCorrecta(\""+data[i].textoPalabraCorrectaBean.codigo+ "\",\""+data[i].nroOrden+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar'  onclick='confirmar_accionTextoPalabraAlter(\""+data[i].textoPalabraCorrectaBean.codigo+ "\",\""+data[i].palabraCorrecta+ "\")' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
        }
        limpiarAlternativasPalabraCorrecta();
      }else{
    	  html = "<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>";
        //alert("lista null");
      }
      //document.getElementById("idTablaEspaciosListado271").innerHTML=html;
      $("#idTablaEspaciosListado271").html(html);
    },
    error : function(data) {
      //console.log("error de idTablaEspaciosListado271 :" + data+ error);
    }
  });
  
}


var numesp ="";
var codi =0;
    function confirmar_accionTextoPalabraAlter(codora,espacio) {
    numesp = espacio;
    codi   = codora;
    	$('#md_confirmacion').modal('show'); 
    }

    $("#btnConfirmarGeneric").click(function() {
      if (codi != null && numesp!=null && codi != 0 && numesp != 0){
        eliminarAlternatTextoPalabraCorrecta(codi,numesp);
      }else{
    	  //console.log("entro al else palabra correcta");
        return false;
       
      }
    

  });

    function eliminarAlternatTextoPalabraCorrecta(codora,numesp){
        //  alert("eliminarLengua " + codigo);
          $.ajax({
            url : contextPath +"/cargaMaterialController/eliminarAlternativasTextoPalabraCorrecta?p_codcomporacion="+codora+"&p_numespacio="+numesp,
            type : 'GET',
            success : function(data) {
              $('#md_confirmacion').modal('hide');
              listadoDePalabraCorrectaxTexto();
            },
            error : function(request, status, error) {
              //alert(error);
            }
           });
          };




function nuevoAlternativasPalabraCorrecta(){
	$("#txtnumeroespacio3").val("").attr("disabled",false);
	 $("#idespacio").val("").attr("disabled",false);
     $("#idalter0").val("0");
     $("#idalter1").val("0");
     $("#idalter2").val("0");
     $("#rptaDescripcion0").val("").attr("disabled",false);
     $("#rptaDescripcion1").val("").attr("disabled",false);
     $("#rptaDescripcion2").val("").attr("disabled",false);
     $("#btn-guardar-oracionCd").attr("disabled",false);
}


function limpiarAlternativasPalabraCorrecta()

{

	$("#txtnumeroespacio3").val("");		
  $("#idespacio").val("");
  $("#idalter0").val("0");
  $("#idalter1").val("0");
  $("#idalter2").val("0");
  $("#rptaDescripcion0").val("");
  $("#rptaDescripcion1").val("");
  $("#rptaDescripcion2").val("");

  $("#0").attr('checked', false);
  $("#1").attr('checked', false);
  $("#2").attr('checked', false);
}

$(document).ready(function(){
	
	

	
	$("#base-tab42,#base-tab43").click(function(){
		var liCodEjer = $("#idEjercicio").val();
		if((liCodEjer=="0" || liCodEjer=="" )){
			msg_advertencia("Debe existir un ejercicio para poder acceder a esta opción.");
			$("#base-tab41").click();
			return false;
		}
		
	});

	
});
