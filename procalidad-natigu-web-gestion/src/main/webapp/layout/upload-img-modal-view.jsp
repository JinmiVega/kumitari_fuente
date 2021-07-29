<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es" data-textdirection="ltr" class="loading">
<body>
<div class="modal fade text-xs-left" id="md_upload-img" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel19" aria-hidden="true">
  <div class="modal-dialog modal-sm" role="document">
  <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    
    <h4 class="modal-title" id="myModalLabel19">Subir imagen</h4>
    </div>
    <f:form id="frmguardarImagen"  method="post"  enctype="multipart/form-data" action="agregarSlider">
    <div class="modal-body"> 
        <div class="row setup-content" id="step-1">
            <div class="col-xs-12">
              <div class="well text-center">
                <label for="fileToUpload">Seleccionar imagen* <i title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado png, .jpeg, .jpg, image/gif - Tamaño máximo permitido hasta 5 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label><br />
     
     
<%--      <f:input type="file" class="filestyle" path="sliderDetalleBean.file"  --%>
<%--      id="file1"  data-validation-required-message="Este campo es requerido"   --%>
<%--      required="required" /> --%>
 <%--  ------------------------------------------- --%>        
<!--  onclick="abrir_input('fileprem')" src="../assets/img/usar_imagen.jpg"   -->
<!--  alt="Premio 01" class="img-fluid thumb"  data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"/>  -->
<%--  ------------------------------------------- --%>       
<!--      <label for=""> -->
<!--      <img id="imgprem" onclick="abrir_input('fileprem')"  -->
<%--      src="${pageContext.request.contextPath}/slider/${sliderDetalleBean.imagen}"  --%>
<%--      alt="${pageContext.request.contextPath}/slider/${sliderDetalleBean.imagen}"   --%>
<!--      class="img-fluid thumb" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"> -->
<!--      </label> -->
<%--  ------------------------------------------- --%>                                        
 
	       <label for=""><img id="imgprem"  onclick="abrir_input('file')" 
	       src="../assets/img/usar_imagen.jpg"  alt="Slider 01" 
	       class="img-fluid thumb"  data-toggle="modal" data-target="#xlarge" style="cursor: pointer;"></label> 
	
  
              </div>
              <f:input type="hidden" path="sliderBean.codigo"  id="codigo"/>
              <br>
              <div id="fileName"></div>
              <div id="fileSize"></div>
              <div id="fileType"></div>
<!--               <div class="row">
                <input type="button" onclick="uploadFile()" value="Upload" />
              </div> -->


                </div>
            </div>
     
    </div>
    <div class="modal-footer">
    <button type="button" class="btn grey btn-outline-secondary" data-dismiss="modal">Cerrar</button>
    
   	<button onclick="crudSlider()" id="btn-save" type="submit"	class="btn btn-flat btn-primary">
				<i class="fa fa-floppy-o"></i> Guardar
	</button> 
     
     <button type="reset"  id="limpiar"   
      onclick="limpiar_img2('imgprem','../assets/img/usar_imagen.jpg','codigoPremio');"   
     class="btn btn-flat btn-secondary">
        <i class="fa fa-eraser"></i> Limpiar 
     </button>
     </div>
     
<%--  ------------------------------------------- --%>     
      <div class="form-group col-md-10 " >
        
          <div class="controls">
           	<f:input  type="file"   style="display:none"  path="sliderDetalleBean.file"   accept="image/png, .jpeg, .jpg, image/gif" required="required"  onchange="return validar_file('file','imgprem','','codigo')" name="files[]" id="file" data-validation-required-message="Se requiere Imagen"/> 
          </div>  
        
     	
      </div> 
<%--  ------------------------------------------- --%>    
      </f:form>
  </div>
  
  </div>
</div>

<script type="text/javascript" charset="utf-8">
      function resetFileInput(){
        var input = $("#fileToUpload");
        input.replaceWith(input.val('').clone(true));
        $("#fileName,#fileSize,#fileType").html("");
      }
      
      function crudSlider(){ 
      var actionForm = $('#frmguardarImagen').attr("action");
      var url = "${pageContext.request.contextPath}/sliderController/" + actionForm;
    
      /** // var formData = new FormData(document.getElementById("frmguardarImagen"));  
	   		var codigo =  $('#codigoSlider').val();//document.getElementById("codigoSlider");  
		
			var inputFileImage = document.getElementById("files");
        	var file = inputFileImage.files[0]; 
      */  	 console.log('formguardar',$('#frmguardarImagen').serialize());
  	
  	   			$.ajax({
  	   				type : "POST",
  	   				contentType:false,  
  	   				url : url,
  	   				data: $('#frmguardarImagen').serialize(),		
  	   				success : function(data) {
					console.log('data agregar imagen',data);
//  	   				refrescarTablaDetalleInscripcion();
//   					console.log("SUCCESS: ", data);

  					alert("Se insertó el registro con éxito!!!");
  					alert('hola');
  	   					if (data =="1") {
  	   						msg_info("Se agrego el slider");
 
  	   						  $('#md_upload-img').modal('hide');
  	   					}
  	    					else if(data=="2"){
  	    						msg_info("Se actualizo la Lengua");
 
  	    						$('#md_upload-img').modal('hide');
  	    					}
//  	    					else if(data=="3"){
//  	    						msg_info("No se Puede Actualizar Ya que tiene Alumnos Matriculados");
//  	    						$("#bootstrap #frmSede").empty();
//  	    						$('#bootstrap').modal('hide');
//  	    					}else if(data=="4"){
//  	    						msg_info("Los numeros de Cupos Son Iguales");
//  	    						$("#bootstrap #frmSede").empty();
//  	    						$('#bootstrap').modal('hide');
//  	    					}
  	   					else {
  	   						msg_advertencia("Ocurrio un error");
  	   					}

  	   					//msg_exito();

  	   				},
  	   			error : function(xhr, status, er) {
  	  			        console.log("error: " + xhr + " status: " + status + " er:" + er);
  	   					msg_error();
  	   					console.log("errot:" + data);
  	   				}

  	   			});
//   	 	}
  	}
      
      function fileSelected() {
        var file = document.getElementById('fileToUpload').files[0];
        if (file) {
          var fileSize = 0;
          if (file.size > 1024 * 1024)
            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
          else
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

          document.getElementById('fileName').innerHTML = '<b>Nombre: </b>' + file.name;
          document.getElementById('fileSize').innerHTML = '<b>Tamaño: </b>' + fileSize;
          document.getElementById('fileType').innerHTML = '<b>Tipo: </b>' + file.type;
        }
      }

//       function uploadFile() {
//           var fd = new FormData();
//      	 fd.append("fileToUpload", document.getElementById('fileToUpload').files[0]);
//           var xhr = new XMLHttpRequest();
//           xhr.upload.addEventListener("progress", uploadProgress, false);
//           xhr.addEventListener("load", uploadComplete, false);
//           xhr.addEventListener("error", uploadFailed, false);
//           xhr.addEventListener("abort", uploadCanceled, false);
//           xhr.open("POST", "UploadMinimal.aspx");
//           xhr.send(fd);
//			}
	  
        

      // function uploadProgress(evt) {
      //   if (evt.lengthComputable) {
      //     var percentComplete = Math.round(evt.loaded * 100 / evt.total);
      //     document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
      //   }
      //   else {
      //     document.getElementById('progressNumber').innerHTML = 'unable to compute';
      //   }
      // }

      // function uploadComplete(evt) {
      //   /* This event is raised when the server send back a response */
      //   alert(evt.target.responseText);
      // }

      // function uploadFailed(evt) {
      //   alert("There was an error attempting to upload the file.");
      // }

      // function uploadCanceled(evt) {
      //   alert("The upload has been canceled by the user or the browser dropped the connection.");
      // }
</script>
</body>
</html>