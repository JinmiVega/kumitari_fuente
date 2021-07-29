<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title id="title_web">Registro de docente</title>
     <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <!-- END VENDOR CSS-->
    <jsp:include page="../../layout/confirmacion-modal-view.jsp" />
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
    <script src="${pageContext.request.contextPath}/assets/js/page/busqueda-ubigeo.js" type="text/javascript"></script>

    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>

	<style type="text/css">
	.ocul {
		display: none;
	}

	.mostrar {
		display: inherit !important;
	}
	</style>

	<script type="text/javascript">
	
	function validateName(id){

		var value = $(id).val();
	    var listword = value.split(" ");
	    var newWord = "";
		for (var i = 0; i < listword.length; i++) {
			if(listword[i].length>0){
				newWord+=listword[i]+" ";
			}
		}
		newWord = newWord.substring(0,newWord.length-1);
		$(id).val(newWord);
	}
	
	$( document ).ready(function() {
		document.getElementById("btnNivelDominioAgregar").disabled = true;
		ejecutarGuardar = false;
	 
		var msj = $("#mensaje").val();//1
		if(msj=='1'){
			msg_exito();
			
		}else if(msj=='0'){
			msg_error();
		}

		var prmCodigoDocente = "";
		var prmCodigoEspecialidad = "";
		var tabla ='';
		var idDocente = document.getElementById("codigoDocente").value;
		//ALERT(idDocente);
		if (idDocente != '0') {
			//alert(idDocente);
			 document.getElementById("tag2").className ="nav-item mostrar";
			 //$('#limpiar').attr("disabled", true);
			 $('#titulo_docente').html("Modificar docente");
			 $('#title_web').html("Modificar docente");
			 refrescarListaEspecialidad(idDocente);
			 refrescarListaInstitucion(idDocente);

			 transformDNI();
		}

		var codigo = document.getElementById("codigoDocente").value;
		if (codigo != '0') {
			 $('#limpiar').attr("disabled", true);
		}

		$(".optionReset").val("");

		
	});


	function transformDNI(){
  		var iterationCount = 1000;
	  	var keySize = 128;
	  	
	    var txtDocumentoPersona = $("#numeroDocumentoPersona").val();
		console.log("entro; ",txtDocumentoPersona);
	    
	    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    
	    var aesUtil = new AesUtil(keySize, iterationCount);
	    var txtDocPer = aesUtil.decrypt(salt, iv, "numeroDocumentoDocente", txtDocumentoPersona);
	    $("#numeroDocumentoPersona").val(txtDocPer);
	    console.log("txtDocPer; ",txtDocPer);
	}


		/*
		//Ingresamos un mensaje a mostrar
		var mensaje = confirm("¿Seguro que deseas eliminar amiguito?");
		//Detectamos si el usuario acepto el mensaje


		if (mensaje) {
		alert("¡:v bueno ya esta!");
		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/docenteController/eliminarEspecialidad?codigo="+codigoDocente+"&codigoEspecialidad="+codigoEspecialidad,
				success : function(data) {
					if(data=='1'){
						msg_exito();
						refrescarListaEspecialidad(codigoDocente);
					}else if(data=='0'){
						msg_error();
					}
				},
				error : function() {
					//console.log("ERROR: ");
				}
			});
		}
		//Detectamos si el usuario denegó el mensaje
		else {
		alert("¡Haz denegado el mensaje amiguito!");
		}
	}

	function refrescarListaEspecialidad(codigoDocente){
 
		var htmlTabla = "";

		  $.ajax({
		    type: "GET",
		    url : "${pageContext.request.contextPath}/docenteController/refrescarEspecialidad?codigo="+codigoDocente,
			success: function(response){
		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
			    		var objInstLengua = response[i];
			    		htmlTabla +=
			    			"<tr>"+
	    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
	    					"<td>"+objInstLengua.tm2Nivel.nombreCorto+"</td>"+
				    		"<td>"+
								"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick='eliminarConfirmacion("+objInstLengua.docenteBean.codigo+","+objInstLengua.lenguaBean.codigo+");' ><i class='icon-trash'></i></button>"
				    		"</td>"+
			    		"</tr>";
					}
			    	$('#idlistadoEspecialidad').empty();
		  	    	$('#idlistadoEspecialidad').html(htmlTabla);
		    	}
		    },error: function(xhr,status,er) {
	         //console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	//console.log(er);
				    	//Error_500(er);
				    }
				    if(xhr.status==901) {
			    	//console.log(er);
			    	//spire_session_901(er);
				    }
		    }
		  });
	}
	*/

	function validarRequired(idfrom){
		//Obtener el codigo docente
		//debugger;
		var idDocente = document.getElementById("codigoDocente").value;
		//alert("validar"+idDocente);
		var $myForm = $(idfrom);
		// validar todos los required
		if(! $myForm[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos correctamente");
		}else{
			//la ruta
			var actionForm = $(idfrom).attr("action");

			var inputFileImage = document.getElementById("file");
        	var file = inputFileImage.files[0];

        	//alert($(idfrom).serialize());
        	var data = new FormData();
        	//data.append('docenteBean',$(idfrom).serialize());
        	var codlengua = document.getElementById("codigoLengua").value;
        	var codnivel = document.getElementById("codigoNivel").value;
        	var codnumdoc = document.getElementById("numeroDocumento").value;

			//alert(codnumdoc);
			data.append('idDocente', idDocente);
        	data.append('codlengua',codlengua);
        	data.append('codnivel',codnivel);
        	data.append('codnumdoc',codnumdoc);
        	data.append('file',file);

			//var url = "${pageContext.request.contextPath}" + actionForm;
			$.ajax({
		           type: "POST",
		           url:  "${pageContext.request.contextPath}/docenteController/grabarEspecialidad",
		           contentType:false,
			   		data: data,
			   		enctype : 'multipart/form-data',
			   		processData:false,
			   		cache:false,
		           success: function(data)
		           {
		        	   if(data=="1"){
		        		   msg_exito();
		        		   refrescarListaEspecialidad(idDocente);
		        		   //alert(idDocente);
		        		   //volver select a cero
			       	    	$('#codigoLengua').val('');
			    	    	$('#codigoNivel').val('');
			    	    	$('#numeroDocumento').val('');
			    	    	$('#file').val('');


							$("#codigoLengua").css("border", "2px solid rgba(22, 211, 154, 1)");
							$("#codigoNivel").css("border", "2px solid rgba(22, 211, 154, 1)");
							$("#numeroDocumento").css("border", "2px solid rgba(22, 211, 154, 1)");
							$("#file").css("border", "2px solid rgba(22, 211, 154, 1)");

		        	   } else if(data=="0"){
		        		   //msg_error();
		        		   msg_info("Ya existe esa lengua con ese nivel");
		        		   Captcha();
                           EnableCaptcha();
		        		   
		        	   } else {
		        		   msg_info("El formato ingresado no es permitido");
		        		   Captcha();
                           EnableCaptcha();
			        	}
		           },
					 error: function(xhr,status,er) {
					 msg_error();
				     //console.log("error: " + xhr + " status: " + status + " er:" + er);
					    if(xhr.status==500) {
					    	//console.log(er);
					 //   	Error_500(er);
					    }
					    if(xhr.status==901) {
				    	//console.log(er);
				    //	spire_session_901(er);
		    			}
				    }
		         });
		}
	}

	function validarRequiredDocente(idfrom){
		var $myForm = $(idfrom);

		var departamento = document.getElementById("provinciaSelect");
		var provincia = document.getElementById("comboprovincia");
		var distrito = document.getElementById("combodistrito");
		var institucion = document.getElementById("lblInstitu");
		var btnAgregarInstitucionDocente = document.getElementById("btnAgregarInstitucionDocente");
		var apellidoPaterno = document.getElementById("apellidoPaterno");
		var apellidoMaterno = document.getElementById("apellidoMaterno");
		//alert("listadoInstitucion.length " + listadoInstitucion.length);
		// validar todos los required
		validateName('#nombrePersona');
		validateName('#apellidoPaterno');
		validateName('#apellidoMaterno');
		
		if(!$myForm[0].checkValidity()){
		
			}
		if(listadoInstitucion == null){
				}
		if( listadoInstitucion.length <= 0){
				}
		if(departamento.value == "00"){
			departamento.focus();
				}
		if(provincia.value == "00"){
			provincia.focus();
				}
		if(distrito.value == "00"){
			distrito.focus();
				}
		if(!$myForm[0].checkValidity() ||(listadoInstitucion == null || listadoInstitucion.length <= 0)|| departamento.value == "00" ||
				 provincia.value == "00" || distrito.value == "00") {
			ejecutarGuardar = true;

			/*todo de color verde  ok */
// 			alert("asd");
			$("#provinciaSelect").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#comboprovincia").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#combodistrito").css("border", "2px solid rgba(22, 211, 154, .5)");
			$("#provinciaSelect").css("color", "#16D39A");
			$("#comboprovincia").css("color", "#16D39A");
			$("#combodistrito").css("color", "#16D39A");
			// mensaje
			 msg_advertencia("Debe completar los campos requeridos correctamente");
			 if(departamento.value == "00" ){
					$("#provinciaSelect").css("border", "2px solid rgba(210, 60, 60, .5)");
					$("#provinciaSelect").css("color", "#444");
					departamento.focus();
				}
			 if(provincia.value == "00"){
					$("#comboprovincia").css("border", "2px solid rgba(210, 60, 60, .5)");
					$("#comboprovincia").css("color", "#444");
					provincia.focus();
				}
			 if(distrito.value == "00"){
					$("#combodistrito").css("border", "2px solid rgba(210, 60, 60, .5)");
					$("#combodistrito").css("color", "#444");
					distrito.focus();
				}
			 if(listadoInstitucion == null || listadoInstitucion.length <= 0){
					$("#lblInstitu").css("border", "2px solid rgba(210, 60, 60, .5)");
				//	institucion.focus();
					
					$("#btnAgregarInstitucionDocente").css("border", "2px solid rgba(210, 60, 60, .5)");
					btnAgregarInstitucionDocente.focus();
			   }
		}
		else{ 
			if(apellidoPaterno.value != "" || apellidoMaterno.value != "") {
				ejecutarGuardar = true;
				///guardarDatos();
				iniciarBloqueo();
				//$(".optionReset").val("");
				
				var iterationCount = 1000;
			  	var keySize = 128;
				var numerodocumento = $('#numeroDocumentoPersona').val();
			    console.log("numeroDocumentoPersona", numeroDocumentoPersona);
			    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
			    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
			    
			    var aesUtil = new AesUtil(keySize, iterationCount);
			    var txtNumeroDocumento = aesUtil.encrypt(salt, iv, "numeroDocumentoDocente", numerodocumento);
			    var txtNombreDocente = aesUtil.encrypt(salt, iv, "nombreDocente", $('#nombrePersona').val());
			    var txtApePatDocente = aesUtil.encrypt(salt, iv, "apellidoPaternoDocente", $('#apellidoPaterno').val());
			    var txtApeMatDocente = aesUtil.encrypt(salt, iv, "apellidoMaternoDocente", $('#apellidoMaterno').val());
			    var txtFecNacDocente = aesUtil.encrypt(salt, iv, "fechaNacimientoDocente", $('#fechaNacimiento').val());
			    var txtTelDocente = aesUtil.encrypt(salt, iv, "telefonoDocente", $('#telefonoUsuario').val());
			    var txtCorreoDocente = aesUtil.encrypt(salt, iv, "correoDocente", $('#correoElectronico').val());
			    var txtDireccionDocente = aesUtil.encrypt(salt, iv, "direccionDocente", $('#direccion').val());
			    
			    $("#textNumeroDocumentoPersona").val(txtNumeroDocumento);
			    $("#textNombrePersona").val(txtNombreDocente);
			    $("#textApellidoPaterno").val(txtApePatDocente);
			    $("#textApellidoMaterno").val(txtApeMatDocente);
			    $("#textFechaNacimiento").val(txtFecNacDocente);
			    $("#textTelefonoUsuario").val(txtTelDocente);
			    $("#textCorreoElectronico").val(txtCorreoDocente);
			    $("#textDireccion").val(txtDireccionDocente);


			    $('#numeroDocumentoPersona').removeAttr("name");
			    $('#nombrePersona').removeAttr("name");
			    $('#apellidoPaterno').removeAttr("name");
			    $('#apellidoMaterno').removeAttr("name");
			    $('#fechaNacimiento').removeAttr("name");
			    $('#telefonoUsuario').removeAttr("name");
			    $('#correoElectronico').removeAttr("name");
			    $('#direccion').removeAttr("name");

	    
				document.getElementById("frmRegistroDocente").submit()

				
				//$("#frmRegistroDocente").submit();	

				
			} else {
				msg_advertencia("Debe completar al menos uno de los dos apellidos");	
			}	
		}
	}

	function IsNumeric(valor) {
		var log = valor.length;
		var sw = "S";
		for (x = 0; x < log; x++) {
			v1 = valor.substr(x, 1);
			v2 = parseInt(v1);
			//Compruebo si es un valor numérico
			if (isNaN(v2)) {
				sw = "N";
			}
		}
		if (sw == "S") {
			return true;
		} else {
			return false;
		}
	}
	var primerslap = false;
	var segundoslap = false;
	function formateafecha(fecha) {
		var getDate = new Date();
		var fechaActual = new Date(getDate.getFullYear()-17,getDate.getMonth(),getDate.getDate());
		var long = fecha.length;
		var dia;
		var mes;
		var ano;
		if ((long >= 2) && (primerslap == false)) {
			dia = fecha.substr(0, 2);
			if ((IsNumeric(dia) == true) && (dia <= 31)
					&& (dia != "00")) {
				fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
				primerslap = true;
			} else {
				fecha = "";
				primerslap = false;
			}
		} else {
			dia = fecha.substr(0, 1);
			if (IsNumeric(dia) == false) {
				fecha = "";
			}
			if ((long <= 2) && (primerslap = true)) {
				fecha = fecha.substr(0, 1);
				primerslap = false;
			}
		}
		if ((long >= 5) && (segundoslap == false)) {
			mes = fecha.substr(3, 2);
			if ((IsNumeric(mes) == true) && (mes <= 12)
					&& (mes != "00")) {
				fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
				segundoslap = true;
			} else {
				fecha = fecha.substr(0, 3);
				;
				segundoslap = false;
			}
		} else {
			if ((long <= 5) && (segundoslap = true)) {
				fecha = fecha.substr(0, 4);
				segundoslap = false;
			}
		}
		if (long >= 7) {
			ano = fecha.substr(6, 4);
			if (IsNumeric(ano) == false) {
				fecha = fecha.substr(0, 6);
			} else {
				if (long == 10) {
					if ((ano == 0) || (ano < 1900)) {
						fecha = fecha.substr(0, 6);
					}
				}
			}
		}
		if (long >= 10) {
			fecha = fecha.substr(0, 10);
			dia = fecha.substr(0, 2);
			mes = fecha.substr(3, 2);
			ano = fecha.substr(6, 4);
			// Año no viciesto y es febrero y el dia es mayor a 28
			if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
				fecha = fecha.substr(0, 2) + "/";
			}
		}
		if(fecha.length==10){
			if(fechaCorrecta(fecha,convertirFecha(fechaActual))==true){
				fecha = convertirFecha(fechaActual);
				msg_advertencia("El docente debe se mayor de edad");
			}
		}
		return (fecha);
	}

	function fechaCorrecta(fecha1, fecha2){

	    //Split de las fechas recibidas para separarlas
	    var x = fecha1.split("/");
	    var z = fecha2.split("/");

	    //Cambiamos el orden al formato americano, de esto dd/mm/yyyy a esto mm/dd/yyyy
	    fecha1 = x[1] + "/" + x[0] + "/" + x[2];
	    fecha2 = z[1] + "/" + z[0] + "/" + z[2];

	    //Comparamos las fechas
	    if (Date.parse(fecha1) <= Date.parse(fecha2)){
	        return false;
	    }else{
	        return true;
	    }
	}

	/*
	function validaSelect(form) {
		if (form.codigoLenguaMaterna.options[1].selected == true) {
			alert('Esta opción no está disponible');
			form.patata.options[0].selected = true;
		}
	}
	*/
	/*
	function activar(obj){
	  if(obj.value=='0')
		  var selectLengua = document.getElementById("codigoLenguaMaterna").value;
		  alert("ssss");
		  alert(selectLengua);
	  obj.value='';
	         //document.getElementById("dos").disabled=false;
	  //else
	        // document.getElementById("dos").disabled=true;
	}*/
/*	function guardarEspecialidad(contextController, idForm){
	function guardarEspecialidad(docenteBean){

//		var actionForm = $("#frmInsertarLengua").attr("action");
//		var url = contextController + actionForm;
//		var url = contextController + actionForm;

	 	$.ajax({
	           type: "GET",
	           url:  "${pageContext.request.contextPath}/docenteController/insertarEspecialidad?docenteBean="+docenteBean,
	           //data: $("#frmInsertarLengua").serialize(),
	           success: function(data)
	           {
	        	   msg_exito();
	           },
				error: function(xhr,status,er) {
					msg_error();
			     //console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	//console.log(er);
				 //   	Error_500(er);
				    }
				    if(xhr.status==901) {
			    	//console.log(er);
			    //	spire_session_901(er);
	    			}
			    },
			    complete: function(){

			    	refrescarListaEspecialidad();

			    }
	         });
	    return false;
	}


	function refrescarListaEspecialidad(){

		var codinstitucion = $('#codigoInstitucion').val();
		var contextPath = $('#contextPathUrl').val();
		var htmlTabla = "";

		  $.ajax({
		    type: "GET",
		    //data: "entidad=" + entidad,
		    url: contextPath+"/institucionController/refrescarListaInstLengua?codigoInst="+codinstitucion,
		    success: function(response){
		    	//console.log(response);
		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
			    		var objInstLengua = response[i];
			    		htmlTabla +=
			    			"<tr>"+
			    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
					    		"<td>"+
						    		"<a title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' href='eliminarLengua?codigo="+objInstLengua.codigo+"'><i class='icon-trash'></i></a>"+
					    			//"<button type='button' class='btn btn-outline-success btn-sm' data-toggle='tooltip' data-original-title='Editar' onclick='modificarInstitucionOperador("+objInstDirector.codigo+");'><i class='icon-pencil'></i></button>"+
					    		"</td>"+
			    		"</tr>";
					}
			    	//console.log(htmlTabla);
			    	$('#idBodyListaInstLengua').empty();
		  	    	$('#idBodyListaInstLengua').html(htmlTabla);
		    	}
		    },error: function(xhr,status,er) {
	         //console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	//console.log(er);
				    	//Error_500(er);
				    }
				    if(xhr.status==901) {
			    	//console.log(er);
			    	//spire_session_901(er);
				    }
		    },
		    complete: function(){
		    	$('#cboLenguaSelecInst').val(0);
		    }
		  });
	}
		*/

	function validarPersona(){

		var tipoDocumento= $('#codigoTipoDocumento').val();

		var numeroDocumento=$('#numeroDocumentoPersona').val();
		if(numeroDocumento==null && numeroDocumento==""){
			numeroDocumento=0;

			}
	  	$.ajax({
	  		type : "POST",
	  		url : "${pageContext.request.contextPath}/personaController/validapersona?tipodocumento="+tipoDocumento+"&numerodocumento="+numeroDocumento,
	  		success : function(data) {
		if(data.codigo!=0){
			$('#codigoTipoDocumento').val(data.tipoDocumento.codigoRegistro);
			$('#numeroDocumentoPersona').val(data.numeroDocumento);
			$('#codigoPersona').val(data.codigo);
			/*$('#codigoPersonal').val();*/
			/*$('#tm1Situacion').val(data);*/
			$('#nacionalidad').val(data.nacionalidad.codigoRegistro);
			$('#nombrePersona').val(data.nombrePersona);
			$('#apellidoPaterno').val(data.apellidoPaterno);
			$('#apellidoMaterno').val(data.apellidoMaterno);
			/* $('#fechaNacimiento').val(data.fechaNac); */
			var strFecha = convertirFecha(data.fechaNac);
			$('#fechaNacimiento').val(strFecha);
			//var strFecha = convertirFecha(data.personaBean.fechaNac);
			//$('#fechaNacimiento').val(strFecha);
			/*$('#gradoPersonal').val(data.);*/
			/*$('#cargoPersonal').val();*/


			$('#cboSexo').val(data.sexo.codigoRegistro);
			$('#telefonoUsuario').val(data.telefono);
			$('#correoElectronico').val(data.correo);
			$('#provinciaSelect').val(data.ubigeoBean.codigoRegion);
			/*ubigeo persona */
			var codDep = data.ubigeoBean.codigoRegion;
			var codPro = data.ubigeoBean.codigoProvincia;
			var codDis = data.ubigeoBean.codigoDistrito;
			$('#provinciaSelect').val(data.ubigeoBean.codigoRegion);
			if (codDep != null && codDep != "") {
				buscarProvinciaXCodigos(codDep, codPro);
				$('#comboprovincia').val(codPro);
				if (codPro != null && codPro != "") {
					buscarDistritoXCodigos(codDep,
							codPro, codDis);
					$('#combodistrito').val(codDis);
				}
			}
			$('#direccion').val(data.direccionPersona);
			$('#lblLengua').val(data.lenguaBean.codigo);
		/*
			$('#lblInstitu').val(data.direccionPersona);
			$('#nivelSelect').val(data.direccionPersona);
			$('#gradoSelect').val(data.direccionPersona);
			$('#selectCarrera').val(data.direccionPersona);
			$('#provinciaSelectinstitucion').val(data.direccionPersona);
			$('#comboprovinciainstitucion').val(data.direccionPersona);
			$('#combodistritoinstitucion').val(data.direccionPersona);
			*/

			}


	  		},
	  		error : function() {
	  			//console.log("ERROR: ");
	  		}
	  	});
	  }



	function validarDocente(){

		var numeroDocumento=$('#numeroDocumentoPersona').val();
		if(numeroDocumento==null && numeroDocumento==""){
			numeroDocumento=0;
		}
	  	$.ajax({
	  		type : "POST",
	  		url : "${pageContext.request.contextPath}/docenteController/validarDocente?numerodocumento="+numeroDocumento,
	  		success : function(data) {
		if(data.codigo!=0){
			//alert(data);
			////console.log(data);
			$('#codigoTipoDocumento').val(data.personaBean.tipoDocumento.codigoRegistro);
			$('#numeroDocumentoPersona').val(data.personaBean.numeroDocumento);
			$('#codigoPersona').val(data.personaBean.codigo);
			$('#codigoDocente').val(data.codigo);
			$('#tm1Situacion').val(data.situacion.codigoRegistro);
			$('#nacionalidad').val(data.personaBean.nacionalidad.codigoRegistro);
			$('#nombrePersona').val(data.personaBean.nombrePersona);
			$('#apellidoPaterno').val(data.personaBean.apellidoPaterno);
			$('#apellidoMaterno').val(data.personaBean.apellidoMaterno);
			var strFecha = convertirFecha(data.personaBean.fechaNac);
			$('#fechaNacimiento').val(strFecha);
			//$('#fechaNacimiento').val(data.personaBean.fechaNac);

			$('#cboSexo').val(data.personaBean.sexo.codigoRegistro);
			$('#telefonoUsuario').val(data.personaBean.telefono);
			$('#correoElectronico').val(data.personaBean.correo);

			$('#lblLengua').val(data.personaBean.lenguaBean.codigo);

			$('#lblInstitu').val(data.institucionBean.codigo);

			$('#gradoSelect').val(data.gradoDocente.codigoRegistro);
			$('#nivelSelect').val(data.carreraDocente.codigoRegistro);
			//$('#selectCarrera').val(data.tm2Programa.codigoRegistro);

			/*ubigeo persona */
			var codDep = data.ubigeoBean.codigoRegion;
			var codPro = data.ubigeoBean.codigoProvincia;
			var codDis = data.ubigeoBean.codigoDistrito;
			$('#provinciaSelect').val(data.ubigeoBean.codigoRegion);
			if (codDep != null && codDep != "") {
				buscarProvinciaXCodigos(codDep, codPro);
				$('#comboprovincia').val(codPro);
				if (codPro != null && codPro != "") {
					buscarDistritoXCodigos(codDep,
							codPro, codDis);
					$('#combodistrito').val(codDis);
				}
			}

			$('#direccion').val(data.personaBean.direccionPersona);
			refrescarListaEspecialidad(data.codigo);
			 document.getElementById("tag2").className ="nav-item mostrar";
			 refrescarListaEspecialidad(data.codigo);
				refrescarListaInstitucion(data.codigo);
			 /*aqui las especialidades*/
			////console.log(data);
			}else{
				
				document.getElementById("tag2").className ="nav-item ocul";
				validarPersona();
			}


	  		},
	  		error : function() {
	  			//console.log("ERROR: ");
	  		}
	  	});

	  }


		function buscarPersona(e) {
			if (e.which == 13 || e.keyCode == 13) {
				var numerodocumento = $('#numeroDocumentoPersona').val();
				if (numerodocumento.length > 7
						&& numerodocumento.length < 13) {
					validarDocente();

				}
			}
		}

	function formatoNumeroDocumento(){

		if(!ejecutarGuardar){
			var tipoDocumento = $('#codigoTipoDocumento').val();
			if(tipoDocumento==1){
				$("#numeroDocumentoPersona").val('');
				$("#numeroDocumentoPersona").attr("pattern","[0-9]{8}");
			}
			if(tipoDocumento==2){
				$("#numeroDocumentoPersona").val('');
				$("#numeroDocumentoPersona").attr("pattern","[a-zA-Z]{5,12}");
			}
			if(tipoDocumento==3){
				$("#numeroDocumentoPersona").val('');
				$("#numeroDocumentoPersona").removeAttr("pattern");
			}
		}else{
			ejecutarGuardar = false;
		}
		
	}

	 function convertirFecha(fecha) {
			var strFecha = "";
			var fecha = new Date(fecha);
			var dia = "";
			var mes = "";
			if (fecha.getDate().toString().length == 1) {
				dia = "0" + fecha.getDate().toString();
			} else {
				dia = fecha.getDate().toString();
			}
			if ((fecha.getMonth() + 1).toString().length == 1) {
				mes = "0" + (fecha.getMonth() + 1);
			} else {
				mes = (fecha.getMonth() + 1).toString();
			}
			return strFecha = dia + "/" + mes + "/" + fecha.getFullYear();
		}

	 function soloNumeros(e)
		{
		   var keynum = window.event ? window.event.keyCode : e.which;
		   if ((keynum == 8) || (keynum == 46))
		        return true;
		    return /\d/.test(String.fromCharCode(keynum));
		}


   function justNumbers(e) {
	 

		var numeroDocumento = $('#numeroDocumentoPersona').val();
		var tipoDocumento = $('#codigoTipoDocumento').val();
		if (tipoDocumento != 0) {
			/*DNI*/
			if (tipoDocumento == 1) {
				if (numeroDocumento.length < 8) {
					var keynum = window.event ? window.event.keyCode
							: e.which;
					//alert(keynum);
					if ((keynum == 8) || (keynum == 46) )
						return false;
					return /\d/.test(String.fromCharCode(keynum));
				} else {
					var keynum = window.event ? window.event.keyCode
							: e.which;
					if ((keynum == 8))
						return true;
					e.preventDefault();
				}
			}
			/*PASAPORTE*/
			if (tipoDocumento == 2) {
			 
				if (numeroDocumento.length < 12) {
					 key = e.keyCode || e.which;
					    tecla = String.fromCharCode(key).toString();
					    letras = "1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
					    especiales = [8, 37, 39, 46, 6];
					    tecla_especial = false
					    for(var i in especiales) {
					        if(key == especiales[i]  ) {
	 
					        	tecla_especial = true;
					            break;
					        }
					        
					    }
						 if((e.keyCode == 32) || (e.keyCode == 46)){
	 
					         return false;
					        }
	 
					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
	 
					        return false;
					      }
				} else {
					e.preventDefault();
				}
			}
			
			/*OTRO*/
					if (tipoDocumento == 3) {
	 
					 key = e.keyCode || e.which;
					    tecla = String.fromCharCode(key).toString();
					    letras = "1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

					    tecla_especial = false
					    for(var i in especiales) {
					        if(key == especiales[i]  ) {
	 
					        	tecla_especial = true;
					            break;
					        }
					        
					    }
						 if((e.keyCode == 32) || (e.keyCode == 46)){
	 
					         return false;
					        }
	 

					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
			 
					        return false;
					      }
	 
			}
		}
	}

   /* function buscarPersona(e) {
	   /*
		if (e.which == 13 || e.keyCode == 13) {
			var numerodocumento = $('#numeroDocumentoPersona').val();
			if (numerodocumento.length > 7
					&& numerodocumento.length < 13) {
				validarPersonal();
			}
		}
	}
	*/
	</script>


  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar" onload="Captcha();">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="#" class="navbar-brand"><img id="logo-k" alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text" style="font-size: 1.54rem;"><img alt="stack admin logo" src="${pageContext.request.contextPath}/assets/img/Logo-Kumitsari-white.png" class="brand-logo"></h2></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="fa fa-ellipsis-v"></i></a></li>
          </ul>
        </div>
        <div class="navbar-container content container-fluid">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
              <jsp:include page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
          <jsp:include page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
      </div>
    </div>
	<input type="hidden" value="${swMensaje}"  id="mensaje"  />
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#" style="cursor: default;">Acad&eacute;mico</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="#" style="cursor: default;">Docente</a>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
              <section id="configuration">
                  <div class="row">
                      <div class="col-xs-12">
                          <div class="card">
                              <div class="card-header">
                                  <h4 class="card-title" id="titulo_docente">Registro de docente </h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements">
                                      <!-- 
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                      -->
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">

                                    <div class="col-md-12">
                                      <ul class="nav nav-tabs nav-top-border no-hover-bg">
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">General</a>
                                        </li>
                                        <li id="tag2" class="nav-item ocul">
<!--                                            <li id="tag2" class="nav-item ocul"> -->
                                          <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Lengua originaria de dominio</a>
                                        </li>
                                      </ul>
                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane active" id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <f:form  id="frmRegistroDocente" class="form mt-1" role="form" method="post" action="grabar" >
                                            <div class="form-body">
                                             <div class="row">
                                                <div class="col-xs-12">
                                                  <h5>DATOS GENERALES</h5>
                                                </div>
                                              </div>
                                               <c:if test="${docenteBean.codigo!=0}">
											<input type="hidden" value="${listadoInstitutoVo}"  id="listadoInstitutoVo"  /> 
											</c:if>
											
                                                <f:input type="hidden" path="codigo"  id="codigoDocente"  />
                                          			<f:input type="hidden" path="personaBean.codigo"  id="codigoPersona"/>

                                              <div class="row">
                                                 <div class="form-group col-md-3 mb-2">
                                                     <label for="situacionUsuario">Situaci&oacute;n <span class="required">*</span></label>
                                                   <div class="controls">
	                                                   <f:select id="tm1Situacion"  path="situacion.codigoRegistro" class="form-control"   data-validation-required-message="Este campo es requerido" required="required">
	                                                            <f:option value="" label="Seleccionar"/>
	                                                            <f:options  items="${lstSituacion}"
	                                                                        itemValue="codigoRegistro"
	                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
													</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Tipo de documento <span class="required">*</span></label>
                                                     <div class="controls">
                                                     <f:select id="codigoTipoDocumento"  path="personaBean.tipoDocumento.codigoRegistro" onchange="formatoNumeroDocumento();" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstTipoDocumento}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                                                  </div>

                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput2">N&uacute;mero de documento <span class="required">*</span></label>
                                                 		<div class="controls" id="numdoc">
                                                 		<f:input type="text" id="numeroDocumentoPersona" maxlength="15" onkeypress="buscarPersona(event);return justNumbers(event);" class="form-control" path="personaBean.numeroDocumento" data-validation-required-message="Este campo es requerido"  required="required" onpaste="return false;"/>
                                                 		<f:input type="hidden" id="textNumeroDocumentoPersona" path="personaBean.numeroDocumento"/>
                                                  		</div>
                                                  </div>

                                                  <div class="form-group col-md-3">
                                                    <label for="situacionUsuario">Nacionalidad <span class="required">*</span></label>
                                                    <div class="controls">
                                                    <f:select id="nacionalidad" path="personaBean.nacionalidad.codigoRegistro" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstNacionalidad}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                    </f:select>
                                                    </div>
                                                  </div>

                                              </div>

                                              <div class="row">
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput1">Nombres <span class="required">*</span></label>
                                                 		<div class="controls">
                                                 		<f:input id="nombrePersona" type="text" maxlength="30" class="form-control" path="personaBean.nombrePersona"  data-validation-required-message="Este campo es requerido" required="required" onKeyUp="this.value = this.value.toUpperCase();"/>
                                                  		<f:input type="hidden" id="textNombrePersona" path="personaBean.nombrePersona"/>                                      		<f:input type="hidden" id="textNumeroDocumentoPersona" path="personaBean.numeroDocumento"/>
                                                  		</div>
                                                  </div>

                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="apellidopaterno">Apellido paterno <span class="required">*</span></label>
                                                       <div class="controls">
                                                       <f:input type="text" id="apellidoPaterno" maxlength="30" class="form-control" path="personaBean.apellidoPaterno" onKeyUp="this.value = this.value.toUpperCase();"/>
                                                  		<f:input type="hidden" id="textApellidoPaterno" path="personaBean.apellidoPaterno"/>    
                                                  		</div>
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="projectinput2">Apellido materno <span class="required">*</span></label>
                                                    <f:input type="text" id="apellidoMaterno" maxlength="30" class="form-control" path="personaBean.apellidoMaterno" onKeyUp="this.value = this.value.toUpperCase();"/>
                                                  	<f:input type="hidden" id="textApellidoMaterno" path="personaBean.apellidoMaterno"/>    
                                                  </div>
                                                  <div class="form-group col-md-3 mb-2">
                                                      <label for="fechanacimiento">Fecha de nacimiento <span class="required">*</span></label>
                                                  	  <div class="controls">
                                                  		<f:input type="text" id="fechaNacimiento" name="fecha"   class="form-control"    path="personaBean.strFechaNac" size="10" maxlength="10"   onKeyUp = "this.value=formateafecha(this.value);" required="required"/>
                                                      	<f:input type="hidden" id="textFechaNacimiento" path="personaBean.strFechaNac"/>   
                                                      </div>
                                                  </div>
                                              </div>

                                              <div class="row">
                                                <div class="form-group col-md-3">
                                                    <label for="projectinput2">G&eacute;nero <span class="required">*</span></label>
                                                     <div class="controls">
                                                     <f:select id="cboSexo"  path="personaBean.sexo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstSexo}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                                                </div>

                                               <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Tel&eacute;fono / Celular <span class="required">*</span></label>
                                                  <div class="controls">
                                                  	<f:input type="text" id="telefonoUsuario" class="form-control" name="telefono"  path="personaBean.telefono" data-validation-required-message="Este campo es requerido" required="required"/>
                                              	  	<f:input type="hidden" id="textTelefonoUsuario" path="personaBean.telefono"/>
                                              	  </div>
                                              </div>
                                                <div class="form-group col-md-3">
                                                  <label for="telefonoUsuario">Correo electr&oacute;nico <span class="required">*</span></label>
                                                   <div class="controls">
                                                   <f:input type="text" id="correoElectronico" maxlength="50" 
                                                   class="form-control" path="personaBean.correo"
                                                     data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})"
                                                      onKeyUp="this.value = this.value.toLowerCase();" 
                                                      data-validation-regex-message="Ingresa un correo valido"
                                                       data-validation-required-message="Este campo es requerido" required="required"/>
                                                       <f:input type="hidden" id="textCorreoElectronico" path="personaBean.correo"/>
                                                	</div>
                                                </div>
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Lengua materna <span class="required">*</span></label>
                                                 	<div class="controls">
                                                 		<f:select  path="personaBean.lenguaBean.codigo" id="lblLengua" class="form-control selectReset" name="codigoLenguaMaterna"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="0" label="Seleccionar"  class="optionReset" />
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                                                        </f:select>
                                                    </div>
                                                </div>
                                              </div>

                                              <div class="row">
                                                <div class="col-xs-12">
                                                  <h5>DATOS PROFESIONALES</h5>
                                                </div>
                                              </div>
															<input id="contextPath" type="hidden"
																		value="${pageContext.request.contextPath}">
                                              <div class="row">
                                                <div class="form-group col-md-5 mb-1">
                                                  <div class="form-group">
                                                    <label for="situacionUsuario">Nombre de la instituci&oacute;n <span class="required">*</span></label>
														<!-- <div class="controls"> data-validation-required-message="Este campo es requerido" required="required" -->
														<f:select id="lblInstitu" name="lblInstitu" path="institucionBean.codigo"  
														class="form-control"  
															>
															<f:option value="0" label="Seleccionar" />
															<f:options items="${lstInstitucion}" itemValue="codigo" itemLabel="nombreInstitucion" />
														</f:select>
														<!--</div> -->
                                                  </div>
                                                  </div>
                                                  <div class="form-group col-md-1 " >
                                                  <%--<button type="submit" class="btn btn-outline-info btn-min" style="margin-top: 20px">--%>
                                                    <button type='button' id="btnAgregarInstitucionDocente" class="btn btn-outline-info btn-min"  onclick="agregarInstitucion();" style="margin-top: 20px"  >
                                                 <i class="ft-plus"></i></button>
                                              </div>
                                                
												  <div class="form-group col-md-3 mb-2">
                                                    <label for="situacionUsuario">Grado o t&iacute;tulo <span class="required">*</span></label>
                                                     <div class="controls">
                                                     <f:select  path="gradoDocente.codigoRegistro" 
                                                     id="gradoSelect" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstGrado}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                                                  </div>
                                              </div>
                                              <div class="row">
                                              <div class="form-group col-md-6 mb-1">
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                        	<th>N°</th>
                                                            <th>Nombre de la instituci&oacute;n</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="idlistadoInstitucion"> 
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                        	<th>N°</th>
                                                            <th>Nombre de la institución</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                              </div>
                                              </div>
                                              <%--
                                              <div class="row">
                                             --%>
												<%--
                                                <div class="form-group col-md-3 mb-2">
                                                  <%--<label for="situacionUsuario">Carrera <span class="required">*</span></label> --%>
                                                  <%--
                                                  <label for="situacionUsuario">Nivel de instrucción <span class="required">*</span></label>

                                                   <div class="controls">
                                                   <f:select  path="carreraDocente.codigoRegistro" id="nivelSelect" class="form-control"  data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstCarrera}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                     </div>

                                                </div>
                                              </div>
												--%>
                                              <div class="row">
                                                <div class="col-xs-12">
                                               	 <h5> DATOS DE RESIDENCIA  </h5>
                                                  <br>
                                                </div>
                                              </div>

                                              <div class="row">
                                                <div class="form-group col-md-3">
												        <label for="projectinput2">Regi&oacute;n <span class="required">*</span></label>
												          <f:select path="ubigeoBean.codigoRegion" onchange="buscarProvincia();" id="provinciaSelect" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstRegion}"
                                                                        itemValue="codigoRegion"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Provincia <span class="required">*</span></label>

												        <f:select path="ubigeoBean.codigoProvincia" onchange="buscarDistrito();" id="comboprovincia" name="comboprovincia" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstProvincia}"
                                                                        itemValue="codigoProvincia"
                                                                        itemLabel="nombreUbigeo"/>
                                                       	</f:select>


												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Distrito <span class="required">*</span></label>
												         <f:select path="ubigeoBean.codigoDistrito" id="combodistrito" name="combodistrito" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstDistrito}"
                                                                        itemValue="codigoDistrito"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>

                                              </div>

											  <div class="row">
											    <div class="form-group col-md-9">
                                                 	<div class="controls">
                                                    <label for="direccion">Dirección <span class="required">*</span></label>
                                                     <f:input type="text" id="direccion" class="form-control" maxlength="50" path="personaBean.direccionPersona" data-validation-required-message="Este campo es requerido" required="required"/>
                                                	 <f:input type="hidden" id="textDireccion" path="personaBean.direccionPersona"/>
                                                	</div>
                                                </div>
											  </div>

                                              <div class="row">
                                                  <div class="form-group col-md-12 text-right">
                                                    <a class="btn btn-secondary mr-1" href="${pageContext.request.contextPath}/docenteController/listado"><i class="fa fa-close"></i> Cancelar</a>
                                                      <button type="reset" class="btn btn-secondary mr-1" onclick="limpiarCodigo();" id="limpiar">
                                                        <i class="fa fa-eraser"></i> Limpiar
                                                      </button>
                                                      <button type="submit" onclick="validarRequiredDocente('#frmRegistroDocente');" class="btn btn-primary">
                                                    <i class="fa fa fa-floppy-o" ></i> Guardar
                                                  </button>
<!--                                                       <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a> -->

                                                  </div>
                                              </div>
                                            </div>
                                          </f:form>
                                        </div>
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12" aria-expanded="true" aria-labelledby="base-tab12">
                                         <f:form class="form mt-1"  id="frmInsertarLengua" role="form" method="post" action="${pageContext.request.contextPath}/docenteController/grabarEspecialidad" onsubmit="return false">
                                            <div class="form-body">

                                              <div class="row">
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Lengua <span class="required">*</span></label>
                                                   <f:input type="hidden" path="codigo"  id="codigoDocente"/>
													<div class="controls">
													<f:select  path="especialidadBean.lenguaBean.codigo" id="codigoLengua" class="form-control selectReset"   data-validation-required-message="Este campo es requerido" required="required">

                                                            <f:option value="0" class="optionReset" label="Seleccionar"/>
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                                               		</f:select>
                                               		</div>
                                                </div>
                                                <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Nivel de dominio <span class="required">*</span></label>
                                                   <div class="controls">
                                                   <f:select  path="especialidadBean.tm2Nivel.codigoRegistro" id="codigoNivel"  class="form-control"   data-validation-required-message="Este campo es requerido"	required="required">
                                                            <f:option value="" selected="" label="Seleccionar"/>
                                                            <f:options  items="${lstNivel}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                  </f:select>
                                                  </div>
                                                </div>
                                              
                                              </div>

												<%--
												<div class="row">
												<f:input type="hidden" id="idRutaDoc" class="form-control" path="inscripcionBean.rutaDocumento"/>
											  	  <div class="form-group col-md-3">
                                                      <label for="projectinput1">N&uacute;mero del Documento <span class="required">*</span></label>
                                                      <div class="controls">
                                                      <f:input type="text" class="form-control" path="inscripcionBean.numeroDocumento" onkeypress="return justNumbers(event);" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" required="required"/>

                                                	 </div>
                                                  </div>
                                                 <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento==null}">
                                                 <div class="form-group col-md-9">
                                                  <label for="">Subir Documento <span class="required">*</span><i title="Formato aceptado .pdf, .doc, .docx, odt - Tamaño máximo permitido hasta 20 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado .pdf, .doc, .txt - Tamaño máximo permitido hasta 20 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label>
                                                  <input type="file" id="file" class="form-control" name="file" data-validation-required-message="Este campo es requerido" required="required">
                                                 </div>
                                                </c:if>
                                                <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento!=null}">
                                                 <div class="form-group col-md-9">
                                                  <label for="">Subir Documento<i title="Formato aceptado .pdf, .doc, .docx, odt - Tamaño máximo permitido hasta 20 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado .pdf, .doc, .txt - Tamaño máximo permitido hasta 20 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i></label>
                                                  <input type="file" id="file" class="form-control" name="file" >
                                                 </div>
                                                </c:if>

												<div class="form-group col-md-9">
												 <div class="controls">

												   <!-- onclick="descargarArchivo()" <a  download="Archivo">Descargar Archivo</a>-->
                                                 </div>
                                                 </div>
                                                 <div class="form-group col-md-9">
                                                  <c:if test="${inscripcionForm.inscripcionBean.rutaDocumento!=null && swMensaje!=0}">

                                                  <a id="idlink" target="_Blank" onclick="descargarArchivo();">
                                                    <div class="link link_derecho">
                                                   <img class="media-object" border="0" align="middle" name="contenedorRuta" src="${pageContext.request.contextPath}/assets/img/archivoDescarga.png"
                                                  style="width: 50px;height: 50px;" id="contenedorRuta"/>
                                                  <div style="margin-top: -35px;margin-left: 59px;">Descargar Archivo </div>
                                                  </div>
                                                  </a>
												 </c:if>
												 </div>
                                              </div>
												--%>
												<div class="row">
												<%--  --%>
												 <f:input type="hidden" id="idRutaDoc" class="form-control" path="especialidadBean.rutaDocumento"/>
											  	  <div class="form-group col-md-3">
                                                      <label for="projectinput1">N&uacute;mero del documento</label>
                                                      <div class="controls">
                                                      <f:input type="text" id="numeroDocumento" class="form-control" maxlength="30" path="especialidadBean.numeroDocumento" onkeypress="return soloNumeros(event);"  pattern="[0-9]{1,}"   />
                                                	 </div>
                                                  </div>
                                                 <c:if test="${especialidadBean.rutaDocumento==null}">
                                                 <div class="form-group col-md-9">
                                                  <label for="">Subir-documento</label>
                                                  <i title="Formato aceptado .pdf, .doc, .docx, odt - Tamaño máximo permitido hasta 20 MB el nombre no debe contener espacios" 
                                                  	data-original-title="Formato aceptado .pdf, .doc, .txt - Tamaño máximo permitido hasta 20 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i>
                                                  <input type="file" id="file" class="form-control" name="file"
                                                  accept="application/pdf, .doc, .docx, .odt">
                                                 </div>
                                                </c:if>
                                                <c:if test="${especialidadBean.rutaDocumento!=null}">
                                                 <div class="form-group col-md-9">
                                                  <label  title="Formato aceptado .pdf, .doc, .docx, odt - Tamaño máximo permitido hasta 20 MB el nombre no debe contener espacios" 
                                                  data-placement="top" data-toggle="tooltip" for="">Subir_documento </label>
                                                  <input type="file" id="file" class="form-control" name="file" 
                                                  accept="application/pdf, .doc, .docx, .odt">
                                                 </div>
                                                </c:if>

												
                                                 <div class="form-group col-md-9">
                                                  <c:if test="${especialidadBean.rutaDocumento!=null && swMensaje!=0}">
                                                  <a id="idlink" target="_Blank" onclick="descargarArchivo();">
                                                    <div class="link link_derecho">
                                                   <img class="media-object" border="0" align="middle" name="contenedorRuta" src="${pageContext.request.contextPath}/assets/img/archivoDescarga.png"
                                                  style="width: 50px;height: 50px;" id="contenedorRuta"/>
                                                  <div style="margin-top: -35px;margin-left: 59px;">Descargar archivo </div>
                                                  </div>
                                                  </a>
												 </c:if>
												 </div>
                                                <%--  --%>
                                              </div>
                                              <div class="row">
                                                   <div class="col-md-1" style="text-align:center;margin-bottom:20px">
                                                        <button id="btnNivelDominioAgregar" type='submit' class="btn btn-outline-info btn-min"  onclick="validarRequired('#frmInsertarLengua');" style="margin-top: 20px"  >
                                                     <i class="ft-plus"></i></button>
                                                    </div>
                                                    <div class="col-md-4" style="margin-bottom:20px">
                                                        <table style="margin: 0px 13px 0px 10px;text-align: center;">
                                                            <tr>
                                                                <td class="text-center">
                                                                <div style="display: flex;">
                                                                	<table style="width:100%">
																	    <tr>
																	                                                    	
																		    <td style="padding-top: 5px;">
																		       <canvas id="captcha"></canvas>
																		    </td>
																		    <td>
																		       <input type="button" id="refresh" value="&#x21bb;" onclick="Captcha();EnableCaptcha();" class="btn btn-primary btn-lg" style="color:#fff !important"/>
																		    </td>
																	                                                    	
																	    </tr>
																	    
																	    <tr>
																	    <td>
																	    <input onkeyup="ValidCaptcha()" type="text" id="txtInput"  class="form-control" style="margin-top:5px" placeholder="Ingrese el texto de la imagen"/>
																	    </td>
																	    </tr>
																	                                                    	
																	</table>
                                                                
                                                                    
                                                                    
                                                                        
                                                                        
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            <div class="row">
                                              <div class="col-xs-12">
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                        	<th width="20">N°</th>
                                                            <th width="70">Lengua</th>
                                                            <th width="50">Nivel de dominio</th>
                                                           <th width="120">Nombre de documento</th>
                                                            <th width="50">Descargar</th>
                                                             <th width="30">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="idlistadoEspecialidad">
                                                        <c:forEach var="especialidadBean" items="${lstEspecialidad}" varStatus="theCount">
		                                                  <tr>
		                                                  	<td>${theCount.count}</td>
		                                                    <td>${especialidadBean.lenguaBean.nombre}</td>
		                                                   	<td>${especialidadBean.tm2Nivel.nombreCorto} </td>
		                                                    <td>
		                                                    <%-- <a title="Modificar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm" href="modificar?codigo=${especialidadBean.codigo}"><i class="icon-pencil"></i></a> --%>
		                                                    <button type='button' title="Eliminar" data-placement="top" data-toggle="tooltip" class="btn btn-outline-danger btn-sm" onclick="eliminarConfirmacion('especialidad','${especialidadBean.docenteBean.codigo}','${especialidadBean.lenguaBean.codigo}');" >
                                                 			<i class="icon-trash"></i></button>

		                                                    </td>
		                                                  </tr>
                                                 		</c:forEach>
                                                    </tbody>
                                                     <tfoot>
                                                        <tr>
                                                  <th width="20">N°</th>
                                                            <th width="70">Lengua</th>
                                                            <th width="50">Nivel de dominio</th>
                                                           <th width="120">Nombre de documento</th>
                                                            <th width="50">Descargar</th>
                                                             <th width="30">Acci&oacute;n</th>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                              </div>
                                            </div>

                                            </div>
                                          </f:form>
                                        </div>

                                      </div>
                                    </div>

                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </section>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/assets/js/md5.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>

<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/page/registro-administrativo-script.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/aes.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/pbkdf2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/AesUtil.js"></script>
	
	<script src="${pageContext.request.contextPath}/assets/js/page/academico/docente.js" type="text/javascript"></script>
    <script type="text/javascript">
    
    
	var key = "HD63HF73B6VD52BFJ9GNEHN38DNF94BW6N49WNDRNDVNOENIVEEN894N8V30MV03MVNM5N3C3C3"

		function CreaIMG(texto) {
		    var ctxCanvas = document.getElementById('captcha').getContext('2d');
		    var fontSize = "30px";
		    var fontFamily = "Arial";
		    var width = 200;
		    var height = 40;
		    ctxCanvas.canvas.width = width;
		    ctxCanvas.canvas.height = height;
		    ctxCanvas.fillStyle = "whitesmoke";
		    ctxCanvas.fillRect(0, 0, width, height);
		    ctxCanvas.setLineDash([10, 10]);
		    ctxCanvas.lineDashOffset = 5;
		    ctxCanvas.beginPath();
		    var line;
		    for (var i = 0; i < (width); i++) {
		        line = i * 10;
		        ctxCanvas.moveTo(line, 0);
		        ctxCanvas.lineTo(0, line);
		    }
		    ctxCanvas.stroke();
		    ctxCanvas.direction = 'ltr';
		    ctxCanvas.font = fontSize + " " + fontFamily;
		    var x = (width / 3.5);
		    var y = (height / 3) * 2;
		    ctxCanvas.strokeStyle = "yellow";
		    ctxCanvas.strokeText(texto, x, y);
		    ctxCanvas.fillStyle = "red";
		    ctxCanvas.fillText(texto, x, y);
		}

		function Captcha() {
		    var alpha = new Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
		    var i;
		    for (i = 0; i < 6; i++) {
		        var a = alpha[Math.floor(Math.random() * alpha.length)];
		        var b = alpha[Math.floor(Math.random() * alpha.length)];
		        var c = alpha[Math.floor(Math.random() * alpha.length)];
		        var d = alpha[Math.floor(Math.random() * alpha.length)];
		    }
		    var code = a + b + c + d;
		    localStorage.setItem('KEY_VALID', md5(code, key));
		    CreaIMG(code);
		}

		function ValidCaptcha() {
		    var string1 = localStorage.getItem('KEY_VALID');
		    var string2 = document.getElementById("txtInput").value;
		    if (string1 == md5(string2, key)) {
		        localStorage.removeItem('KEY_VALID');
		        document.getElementById('btnNivelDominioAgregar').disabled = false;
		        document.getElementById("txtInput").disabled = true;
		    }
		}
		
		function EnableCaptcha(){
			document.getElementById("txtInput").value = "";
	        document.getElementById("btnNivelDominioAgregar").disabled = true;
	        document.getElementById("txtInput").disabled = false;
		}
    
    


    function descargarArchivo() {
 	   var url= $('#idRutaDoc').val();

 		/* var nuevaurl="<a id='iddes' href="+url+" download="+url+">Descargar Archivo</a>"; */
 		var nuevaurl=" href="+url+" download="+url+" ";
		
 	  //document.getElementById("iddes").click();


 			/* $('#contenedorRuta').html(nuevaurl); */
 		/* 	$('#idlink').html(nuevaurl); */
 			$('#idlink').attr('href',"file:///"+url);
 			$('#idlink').attr('download',url);

 			$('#idlink').click(function(e) {
 				e.stopPropagation();
 				return;

 		    });
 			$('#idlink').click(function(e) {
 				 e.stopPropagation();
 				 return;

 			});


 	}

    function onColorVerde(id){
		var idvalor =$(id).val();
		if(idvalor == "00"){
			$(id).css("color", "#444");
		}else{
			$(id).css("color", "#16D39A");
		}
	}

    function limpiarCodigo(){
    	//$("#tag2").removeClass("mostrar");
        document.getElementById("tag2").className ="nav-item ocul";
		$('#codigoDocente').val("0");
		$('#codigoPersona').val("0");

	}


    function validarGrabar(){    	       
		return ejecutarGuardar;
	}

    function eliminarConfirmacion(nombretabla,codigoDocente,codigoEspecialidad) {
   		tabla = nombretabla;
   		//alert("tabla " + tabla);
    	prmCodigoDocente = codigoDocente;
    	prmCodigoEspecialidad = codigoEspecialidad;
		$('#md_confirmacion').modal('show');
	}
    
    $( "#btnConfirmarGeneric" ).click(function() {
		 if(tabla == 'especialidad'){
			 eliminarEspecialidad(prmCodigoDocente,prmCodigoEspecialidad);
			  $('#md_confirmacion').modal('hide');
		 } 
	});


	function eliminarEspecialidad(codigoDocente,codigoEspecialidad){

		 $.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/docenteController/eliminarEspecialidad?codigo="+codigoDocente+"&codigoEspecialidad="+codigoEspecialidad,
				success : function(data) {
					if(data=='1'){
						msg_exito();
						refrescarListaEspecialidad(codigoDocente);
					}else if(data=='0'){
						msg_error();
					}
				},
				error : function() {
					////console.log("ERROR: ");
				}
			});

	}
	
			function refrescarListaInstitucion(codigoDocente){
				var htmlTablaIntitucion = "";

				  $.ajax({
				    type: "GET",
				    url : "${pageContext.request.contextPath}/docenteController/refrescarInstituciones?codigo="+codigoDocente,
					success: function(response){
						$('#idlistadoInstitucion').empty();
				     
				    	//console.log(response);
				    	//console.log(response.length);
				    	if(response!=null && response.length>0){
				    		
				    		for (var i = 0; i < response.length; i++) {
  					    		var objInst = response[i];
// 					    		htmlTabla +=
// 					    			"<tr>"+
// 					    			"<td>"+(i+1)+"</td>"+
// 			    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
// 			    					"<td>"+objInstLengua.tm2Nivel.nombreCorto+"</td>"+
// 						    		"<td>"+
// 										"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarConfirmacion('especialidad','"+objInstLengua.docenteBean.codigo+"','"+objInstLengua.lenguaBean.codigo+"');\"><i class='icon-trash'></i></button>"+
// 						    		"</td>"+
// 					    		"</tr>";
				    		 	 
				    		 	htmlTablaIntitucion +=
				    			"<tr>"+
				    			"<td>"+(i+1)+"</td>"+
				    			"<td>"+objInst.nombreInstitucion+"</td>"+
				        		"<td>"+
				    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarInstitucion('"+objInst+"');\"><i class='icon-trash'></i></button>"+
				        		"</td>"+
				    		"</tr>";
								
							}
				  	    	$('#idlistadoInstitucion').html(htmlTablaIntitucion);
				    	}else{
				    		$('#idlistadoInstitucion').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");
				    		
				    	}
				    },error: function(xhr,status,er) {
			         ////console.log("error: " + xhr + " status: " + status + " er:" + er);
						    if(xhr.status==500) {
						    	////console.log(er);
						    	//Error_500(er);
						    }
						    if(xhr.status==901) {
					    	////console.log(er);
					    	//spire_session_901(er);
						    }
				    }
				  });
			}

	function refrescarListaEspecialidad(codigoDocente){
		var htmlTabla = "";
		var htmlTablaURL = "";
		var htmlTablaFILE = "";
		var contextPath = $('#contextPath').val();
		  $.ajax({
		    type: "GET",
		    url : "${pageContext.request.contextPath}/docenteController/refrescarEspecialidad?codigo="+codigoDocente,
			success: function(response){
				$('#idlistadoEspecialidad').empty();
		     
		    	//console.log(response);
		    	//console.log(response.length);
		    	
		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
			    		var objInstLengua = response[i];
// 			    		alert(objInstLengua.rutaDocumento );
			    		htmlTablaURL = "";
			    		if(objInstLengua.rutaDocumento == null || objInstLengua.rutaDocumento == '' ){
			    			htmlTablaURL = "<td></td>" ;
			    			htmlTablaFILE = "<td></td>" ;
			    		}else{
			    			htmlTablaURL = 
			    		"<td><a title='Descargar' data-placement='top' data-toggle='tooltip' target='_Blank' href="+contextPath+"/docente/"+String(objInstLengua.rutaDocumento)+"  download><i class='fa fa-download'></i>Descargar</a></td>";
			    			htmlTablaFILE =
			    				"<td>"+objInstLengua.rutaDocumento+"</td>";
			    		}
// 			    		alert(htmlTablaURL);
			    			//htmlTablaURL = objInstLengua.rutaDocumento;
			    		htmlTabla +=
			    			"<tr>"+
			    			"<td>"+(i+1)+"</td>"+
	    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
	    					"<td>"+objInstLengua.tm2Nivel.nombreCorto+"</td>"+
	    					htmlTablaFILE +
				    		htmlTablaURL + 
				    		
				    		"<td>"+
							"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarConfirmacion('especialidad','"+objInstLengua.docenteBean.codigo+"','"+objInstLengua.lenguaBean.codigo+"');\"><i class='icon-trash'></i></button>"+
			    			"</td>"+
			    		
			    		"</tr>";
					}
		  	    	$('#idlistadoEspecialidad').html(htmlTabla);
		    	}else{
		  	    	$('#idlistadoEspecialidad').html("<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>");
			    }
		    },error: function(xhr,status,er) {
	         ////console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	////console.log(er);
				    	//Error_500(er);
				    }
				    if(xhr.status==901) {
			    	////console.log(er);
			    	//spire_session_901(er);
				    }
		    }
		  });
	}
//  	function cambiarfecha() {

// 		 return ejecutarGuardar;

//  	}

	$("#numeroDocumentoPersona").keyup(function(e){
	   	   e.preventDefault();

		   var tipodocumento = $('#codigoTipoDocumento').val();
		   var numerodocumento = $('#numeroDocumentoPersona').val();

		   //alert(tipodocumento);
	       if(tipodocumento == "1" || tipodocumento == ""){
	    	   if (numerodocumento.length > 7) {
	    		   validarDocente();
	      			}
	       } else if(tipodocumento == "2"){
	    	   if (numerodocumento.length > 5) {
	    		   validarDocente();
	      		}
	       }

	  });

    </script>
  </body>
</html>