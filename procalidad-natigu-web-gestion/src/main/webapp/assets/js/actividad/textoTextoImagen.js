
var contextPath 	= $('#contextPathUrl').val();

function nuevoTextoTextoImagen(){
	//$("#idRelacionCabecera").val("0");
	$("#idRelacionTextoTextoImg").val("0");
	$("#textoRelacionado").val("");
	$("#imgRelacionado2").val("");
	$("#imgmas1ti").attr("src","../assets/img/usar_imagen.jpg");
	$("#idNombreImg1ti").val("");
	$("#contentImg img").addClass("img-fluid");
	$("#contentImg img").css({"cursor":"pointer","max-width":"30%"});
	$("#textoTexto").val("");
}

function validarTextoTextoImagen(){

	var lsTextRel = $("#textoRelacionado").val();
	var lsTextTex = $("#textoTexto").val();
	var lfImgRela = $("#hiddenImg").val();
	var nomimg 		= $("#idNombreImg1ti").val(); 
	var inputFileImage 	= document.getElementById("imgRelacionado2");
	var file 			= inputFileImage.files[0];
		
	if (lsTextRel != "" && lsTextTex != "" && (file !=null || nomimg!='' ) ) {
		return true;
	}else{
		return false;//msg_advertencia("Debe completar los campos.");
	}
	
}

function guardarTextoTextoImagen(){
	var dataForms = new FormData();
	var liCodEjer = $("#idEjercicio").val();
	var lsTextTex = $("#textoTexto").val();
	var lsTextRel = $("#textoRelacionado").val();
	var liCodTxtR = $("#idRelacionTextoTextoImg").val()=="" ? 0 : $("#idRelacionTextoTextoImg").val();
	var liMatLecc = $("#modalCboMaterial").val();
	var liRelCabe = $("#idRelacionCabecera").val()=="" ? 0 : $("#idRelacionCabecera").val();
	//var lfImgRela = $("#imgRelacionado2").val();
	
//	if($("#hiddenImg").val()=="0"){
//		console.log("en 0");
		var inputFileImage = document.getElementById("imgRelacionado2");
    	var lfImgRela = inputFileImage.files[0];
//    	dataForms.append('lfImgRela',lfImgRela);
//	} else{
//		console.log("en 1");
//		var lfImgRela = new File([$("#contentImg img").attr("src")],("img--Vacio---"+$("#contentImg img").attr("title")));
//		dataForms.append('lfImgRela',lfImgRela);
//	}
	
	if(validarTextoTextoImagen()){
	 
		var liTipoSQL =  liCodTxtR == 0 ? 1 : 2;
		dataForms.append("liTipoSQL",liTipoSQL);
		dataForms.append("liCodEjer",liCodEjer);
		dataForms.append("lsTextTex",lsTextTex);
		dataForms.append("lsTextRel",lsTextRel);
		dataForms.append("liCodTxtR",liCodTxtR);
		dataForms.append("liRelCabe",liRelCabe);
		
		if (lfImgRela!= '' && lfImgRela!=null){
			dataForms.append("lfImgRela",lfImgRela);
			}
		
		
		
		//console.log("paso");
		var url = contextPath+"/cargaMaterialController/grabarTextoTextoImagen";
		if(liMatLecc != "0"){
			//console.log("paso 2");
			$.ajax({
	  			type 	: "POST",
	  			data 	: dataForms,
	  			contentType:false,
		   		processData:false,
		   		cache:false,
	  			url 	: url,
	  			success : function(data){
	  				if (data != "0") {
	  	  				$("#idRelacionTextoTextoImg").val(data);  
	  	  				listarEjercicioTextoTextoImagen();
	  	  				msg_exito();
	  	  				nuevoTextoTextoImagen();
					}
	  				else{
					}
	  			},
	  			error : function(){
	  				//console.log("ERROR: ");
	  			}
	  		});
		}
		else{  
			msg_advertencia("Debe seleccionar un material.");
		}
	}else{
		//console.log("no entr�");
		msg_advertencia("Debe completar los campos.");
	}
}

function listarEjercicioTextoTextoImagen(){	
	var liCodEjer = $("#idEjercicio").val();
	var url = contextPath+"/cargaMaterialController/listarTextoTextoImagen";
	var html = "";
	$.ajax({
		type : 'POST',
		data :{liCodEjer : liCodEjer },
		url : url,
		success : function(data) {
			//console.log("SUCCESS: ", data);
			if (data != null && data.length > 0) {
				var codCabe = "0";
				for (var i = 0; i < data.length; i++) {
					codCabe = data[i].relacionCabeceraBean.codigo;
					html = html+"<tr> <td>"+(i+1)+"</td><td>"+data[i].texto+"</td><td>"+data[i].texto2+"</td><td> <button type='button' title='Modificar' onclick='editarTextoTextoImagen(\""+data[i].codigo+ "\")' class='btn btn-outline-success btn-sm'><i class='icon-pencil'></i></button> <button type='button' title='Eliminar' onclick='confirmar_eliminar(\""+'textoTextoImagen'+"\",\""+data[i].codigo+"\");' class='btn btn-outline-danger btn-sm'><i class='icon-trash'></i> </button> </td></tr>";
				}
				//document.getElementById("bodyListeTextoTexto").innerHTML=html;
				 $("#idRelacionCabecera").val(codCabe);
			}else{
				html = "<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>";
				//$("#bodyListeTextoTexto").empty();
			}
			$("#bodyListeTextoTexto").html(html);
		},
		error : function(data) {
			//console.log("error de listarEjercicioTextoImagen :" + data+ error);
		}
	});
	
}


function editarTextoTextoImagen(liCodTxtR){
	
	var url =contextPath+"/cargaMaterialController/objrelaciontexto?codigo="+liCodTxtR
    $.ajax({
        url : url,
        type : 'GET',
        success : function(data) {        	
        	  if (data != null) {
        		    $("#idRelacionCabecera").val(data.relacionCabeceraBean.codigo);
        			$("#textoTexto").val(data.texto).attr("disabled",false);
        			$("#textoRelacionado").val(data.texto2).attr("disabled",false);
        			$("#idRelacionTextoTextoImg").val(data.codigo);
        			$("#contentImg img").attr("src",contextPath+"/material/"+data.imagen);
        			$("#contentImg img").attr("title",data.imagen).attr("alt",data.imagen);
        			$("#hiddenImg").val(data.imagen == "" ? 0 : 1);
        			$("#idNombreImg1ti").val(data.imagen);
        			var imgsrc = contextPath+"/material/"+data.imagen;  
					$('#imgmas1ti').attr('src',imgsrc); 
					
					
        			
        			$("#btn_guardar_texto").attr("disabled",false);
			}else{
				//console.log("No hay registro.");
			}    	
        },
        error : function(request, status, error) {
          //alert(error);
        }
       });
	
	
}
function obtenerImagen(){
	document.getElementById('imgRelacionado2').click();
}

function handleFileSelectTTI(evt){
	
	var files = evt.target.files; // FileList object
	    for (var i = 0, f; f = files[i]; i++){
 	    if (!f.type.match('image.*')){
 	        continue;
 	    }
 	    var reader = new FileReader();
 	    reader.onload = (function(theFile){
 	    	return function(e){
 	        	document.getElementById("contentImg").innerHTML = ['<img class="thumb2" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
 	        };
		})(f);
 	   	reader.readAsDataURL(f);
	    }
	    $("#hiddenImg").val("1");
}
function confirmar_eliminarTTI(tabla, codigo){
	//console.log("entro a coonfirmar eliminar");
	
	//console.log("tabla " +tabla);
	accion_tab = tabla;
	codigoEliminar = codigo;
	$('#md_confirmacion').modal('show');

}
