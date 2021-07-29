function guardarOracionComp()
  {
     
   var p_titulo   = $("#idoraciontitulo").val().trim();   
   var p_codmatpej   = $("#idEjercicio").val(); 
   var p_oracion     = $("#bodyParrafo .note-editable").html(); 
   var p_codOracion  = $("#idoraciondesc").val();  
   let url = contextPath + "/cargaMaterialController/grabaroracioncompletar";
    if (p_codmatpej!=null && p_codmatpej!='' && p_codmatpej!='0' ){  
    if (p_oracion!=null && p_oracion!='' ){  

      $.ajax({
          type :  "POST",
          url  :  url,
          data : { p_codmatpej     :  p_codmatpej,
                   p_titulo        :  p_titulo,
                   p_oracion       :  p_oracion, 
                   idOracionComple : p_codOracion },
            success : function(data)
              {
             
              msg_exito();
            
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


  function enviarOracionAlternativasComp(tipoaccion, arrayAlternativas){
    //console.log("r: " + tipoaccion);
    let url = tipoaccion == 1 ? contextPath +"/cargaMaterialController/grabarOracionAlter" : contextPath +"/cargaMaterialController/actualizarOracionAlter";
    var cood   = $("#idoraciondesc").val();
    var cood1  = $("#rptaDescripcion0").val();
    var cood2  = $("#rptaDescripcion1").val();
    var cood3  = $("#rptaDescripcion2").val(); 
    var esp    = $("#idespacio").val(); 
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
    if ((esp!=null && esp!='' && cood1!=null && cood1!='' && cood2!=null && cood2!=''
     ) && (inp1=='1' || inp2=='1' || inp3=='1') ) {  


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
               limpiar3tab();
              //console.log(data);
              listadoDeEspaciosxOracionComp();
             },
         error: function(er) {
           //console.log(" er:" + er.error);console.log("er: " + er.responseText);

         }
           });
          }else{
       msg_info("Debe completar los campos");
    }
  }else{
      msg_info("Debe agregar una oración");
    }
  }


  var accionPregunta12 = 1;
  function agregarOracionAlternativaComp(tipoaccion){
    var p_codoracion = $("#idoraciondesc").val();
    //console.log("idoraciondesc: "+ p_codoracion);
    if(p_codoracion != null || p_codoracion == ""){
      var arrayAlternativas   = [];
      var objPregunta = { codigo : p_codoracion};
      $("#tblPregunta tbody tr").each(function (index)
      {
        var objAlernativa = {
            codigo          : 0,  
            respuestaEstado : '0',
            descripcion     : '',
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
        objAlernativa.descripcion    = document.getElementById("rptaDescripcion"+index).value;
        objAlernativa.espacio = document.getElementById("idespacio").value; 
        arrayAlternativas.push(objAlernativa);

      });
      enviarOracionAlternativasComp(tipoaccion,arrayAlternativas); 
    }
    else{
      //alert("No se pudo registrar las alternativas");
    }

  }



  function mostrarOracionxTEMComp(){
  //habModif();
  var p_id = $("#idEjercicio").val();
  var url =contextPath+"/cargaMaterialController/ListOracionxMaterialTE?p_codmatpej="+p_id
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
            
            	$("#bodyParrafo .note-editable").html(data.oracion);
              if (data.codigo!=null){
              $("#idoraciondesc").val(data.codigo);
            }else{
               $("#idoraciondesc").val("0");
            }
              $("#idoraciontitulo").val(data.titulo);
            
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



function mostrarAlternativasxidOraEspacioComp(id_ora,nespacio){
  
 
  var url =contextPath+"/cargaMaterialController/BuscarAlternativasxEspacioOracion?p_codcomporacion="+id_ora+"&p_numespacio="+nespacio
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {          
            if (data != null) {
              
               //console.log("data" +  data); 
              $("#idespacio").val(nespacio).attr("disabled",false);  
                for(var i=0;i<data.length;i++){
           $("#rptaDescripcion"+i).val(data[i].descripcion).attr("disabled",false);
           $("#idalter"+i).val(data[i].codigo);

          var idrpta = i;
          var valrpta = data[i].respuestaEstado == 1 ? true : false;
          $("#"+ idrpta).prop('checked', valrpta);
         // $("#"+ idrpta).val(data[i].codigo);
            //console.log("Dato: "+ data[i].descripcion);
              //html=html+"<tr>  <td>"+(i+1)+"</td><td>"+data[i].descripcion+"</td> <td> <button type='button' onclick='editarPregunta(\""+data[i].codigo + "\",\"" + data[i].descripcion +"\");' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' onclick='confirmar_accion(\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
            }
 
              



      }else{
        msg_advertencia("No hay registro.");
      }     
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
  
  
}







 function listadoDeEspaciosxOracionComp()
{
  
 
  var p_oracion    = $("#idoraciondesc").val();
  var url =  contextPath +"/cargaMaterialController/ListEspacioxOracion";

  $.ajax({
    type : 'POST',
    data :{p_codcomporacion : p_oracion },
    url : url,
    success : function(data) 
    { 
      var html = "";
      //console.log("SUCCESS: ", data);
      if (data != null && data.length > 0) 
      {
        for (var i = 0; i < data.length; i++) 
        {
          html = html+"<tr> <td>"+(i+1)+"</td><td> Espacio "+data[i].espacio+"</td> <td> <button type='button' title='Modificar'  onclick='mostrarAlternativasxidOraEspacioComp(\""+data[i].oracionCompletarBean.codigo+ "\",\""+data[i].espacio+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar'  onclick='confirmar_accionOraAlterComp(\""+data[i].oracionCompletarBean.codigo+ "\",\""+data[i].espacio+ "\")' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
        }
        limpiar3tab();
        //document.getElementById("idTablaEspaciosListado27").innerHTML=html;
        $("#idTablaEspaciosListado27").html(html);
      }else{
    	$("#idTablaEspaciosListado27").html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");
        return false;
      }
    },
    error : function(data) {
      //console.log("error de idTablaEspaciosListado27 :" + data+ error);
    }
  });
  
}


var numesp ="";
var codi =0;
    function confirmar_accionOraAlterComp(codora,espacio) {
    numesp = espacio;
    codi   = codora;
    $('#md_confirmacion').modal('show'); 
  }

    $("#btnConfirmarGeneric").click(function() {
      if (codi != null && numesp!=null && codi != 0 && numesp != 0){
        eliminarAlternatOraComp(codi,numesp);
      }else{
        return false;
       
      }
    

  });

    function eliminarAlternatOraComp(codora,numesp){ 
          $.ajax({
            url : contextPath +"/cargaMaterialController/eliminarAlternativasOracion?p_codcomporacion="+codora+"&p_numespacio="+numesp,
            type : 'GET',
            success : function(data) {
              $('#md_confirmacion').modal('hide');
              listadoDeEspaciosxOracionComp();
            },
            error : function(request, status, error) {
              //alert(error);
            }
           });
          }; 
 

    function limpiar2tab()

    {
      $("#idoraciontitulo").val("");
      $("#idoraciondesc").val("0"); 
      $("#bodyParrafo .note-editable").html("");
 
    }

    function nuevo3Tab(){
    	$("#idespacio").val("").attr("disabled",false);
        $("#idalter0").val("0");
        $("#idalter1").val("0");
        $("#idalter2").val("0");
        $("#rptaDescripcion0").val("").attr("disabled",false);
        $("#rptaDescripcion1").val("").attr("disabled",false);
        $("#rptaDescripcion2").val("").attr("disabled",false);

        $("#0").attr('checked', false);
        $("#1").attr('checked', false);
        $("#2").attr('checked', false);
    }
    function limpiar3tab()

    {
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
