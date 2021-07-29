   <%@ page contentType="text/html; charset=UTF-8" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
	 <script src="${pageContext.request.contextPath}/assets/js/page/busqueda-ubigeo.js" type="text/javascript"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/aes.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lib/pbkdf2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/AesUtil.js"></script>
	
    <!-- Modal -->

     <script type="text/javascript">
 	 var listadoLenguas = [];
 	 var contLenguas = 0;
 	 
     function limpiarForm(){
    	 document.getElementById('frmregistromodal').reset();
     	 $('#tablalistadoEspecialidad').empty();
 	  	$('#tablalistadoEspecialidad').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>"); 
   	 	$('#idlistadoInstitucion').empty();
	  	$('#idlistadoInstitucion').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");    		
   	 	listadoInstitucion = [];
   	 listadoLenguas = [];
    	 
     }

     function agregar_Tabla_especialidad(){
    	
		 //$('#tablalistadoEspecialidad').html('<tr><td></td></tr>');
    	 var numFilas=$('#tablalistadoEspecialidad >tr').length;
    	
			lengua=document.getElementById("codigoLengua");
			nivel=document.getElementById("codigoNivel");

			var codigoDocente = $('#codigoDocente').val();	
			if(codigoDocente!=0 && codigoDocente!=null){
			
				var codigoLengua = lengua.value;
				var codigoNivel = nivel.value;
// 				alert("por entrar")
				registrarEspecialidadDocente(codigoDocente,codigoLengua,codigoNivel);
				obtenerEspecialidadDocenteXCodigoDocente();
				}
			else{
				
				var a=0;
				for(var i=0;i<numFilas;i++){
					var codigoLengua = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
					if(codigoLengua==lengua.value){

					a=a+1;
					}
	 	
				}
				
	    	 if(lengua.value!=0 && lengua.value!=null && lengua.value!="" && nivel.value!=0 && nivel.value!=null && nivel.value!="" && a==0) {
	        	

	        	var table = document.getElementById("tablalistadoEspecialidad");
	    	 
	    	 var row = table.insertRow(numFilas);
	         var cell1 = row.insertCell(0);
	       
	         var cell2 = row.insertCell(1);
	         var cell3 = row.insertCell(2);
	         var cell4 = row.insertCell(3);
	         var cell5 = row.insertCell(4);
	         cell1.style['display'] = "none";
	         cell3.style['display'] = "none";
	 		var codLengua=lengua.value;
	 		var nombreLengua=$("#codigoLengua option:selected").text();
	 		var codNivel=nivel.value;
	 		var nombreNivel=$("#codigoNivel option:selected").text();
	 		
			if(listadoLenguas!=null && listadoLenguas.length>0){
				var repete = true;
				for(var i = 0; i < listadoLenguas.length; i++){ 
					if(listadoLenguas[i][0]==codLengua || codLengua==""){
						repete = false;
					}
				}
				if(repete){
						listadoLenguas.push([codLengua,nombreLengua,codNivel,nombreNivel]);
					}
			}else{
				if(codLengua!=""){					
					listadoLenguas.push([codLengua,nombreLengua,codNivel,nombreNivel]);
				}
	
			}
 
//  		alert(listadoLenguas);
		
    	
 	    document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[0].innerHTML=codLengua;
 	  	document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[1].innerHTML=nombreLengua;
 	  	document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[2].innerHTML=codNivel;
 		document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[3].innerHTML=nombreNivel;
 		document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[numFilas].getElementsByTagName('td')[4].innerHTML=
 			"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarFilaTablaEspecialidad('"+codLengua+"');\"><i class='icon-trash'></i></button>";
		contLenguas++;
 		if(contLenguas==1){
			var element = document.getElementById("tablalistadoEspecialidad");
			element.removeChild(element.firstChild);
		}
		
    	 }
	
	}
    	 
}


     function eliminarFilaTablaEspecialidad(codLengua){

    	  
			//listadoLenguas
    	 var numFilas =$('#tablalistadoEspecialidad >tr').length;
			for(var i=0;i<numFilas;i++){
					var codigoLengua = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
					//   listadoLenguas.removeItem(listadoLenguas[i]);
					if(codigoLengua==codLengua){
					   listadoLenguas.removeItem(listadoLenguas[i]);
					 $("#tablalistadoEspecialidad tr:eq('"+i+"')").remove();
					 break;
					}
		 	
				}
			
			console.log('listadoLenguas.length b: ',listadoLenguas);
			if(listadoLenguas.length==0){
				contLenguas = 0;
				$('#tablalistadoEspecialidad').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>"); 
			}

         }
     function obtenerDatosEspecialdadDocente(idDocente){

    		for(var i=0;i<$('#tablalistadoEspecialidad >tr').length;i++){
    		var codigoLengua     = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
//     		alert(codigoLengua);
    		var codigoNivel     = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[2].innerHTML;
//     		alert(codigoNivel);
    		registrarEspecialidadDocente(idDocente,codigoLengua,codigoNivel);

           	 }
			

         }
     
     function obtenerDatosEspecialdadDocenteV2(idDocente){ 

 	//	for(var i=0;i<$('#tablalistadoEspecialidad >tr').length;i++){
//  		var codigoLengua     = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
//  		var codigoNivel     = document.getElementById("tablalistadoEspecialidad").getElementsByTagName('tr')[i].getElementsByTagName('td')[2].innerHTML;
 		
//  		for(int j=0 ; j<listadoLenguas.size ; j++x){
//  			listadoLenguas[j];
//  		}
//  		registrarEspecialidadDocente(idDocente,codigoLengua,codigoNivel);

      // }
			

      }


     function registrarEspecialidadDocente(codigoDocente,codigoLengua,codigoNivel){
// 			alert(codigoDocente);
// 			alert(codigoLengua);
// 			alert(codigoNivel);
			var numeroDocumento = $("#numeroDocumento").val();
			var inputFileImage = document.getElementById('fileDoc');
			var file = inputFileImage.files[0];
			var data = new FormData();
			
			data.append('idDocente', codigoDocente);
			data.append('codlengua', codigoLengua);
			data.append('codnivel', codigoNivel);
			data.append('codnumdoc', numeroDocumento);
			data.append('file', file);

			
    		//var pathUrl = "${pageContext.request.contextPath}/docenteController/grabarEspecialidadDocente?codigodocente="+codigoDocente+"&codigolengua="+codigoLengua+"&codigonivel="+codigoNivel;
    		var pathUrl = "${pageContext.request.contextPath}/docenteController/grabarEspecialidad";
    		var html = "";

    		$.ajax({
				type: "POST",
				url:  pathUrl,
				contentType:false,
				data: data,
				enctype : 'multipart/form-data',
				processData:false,
				cache:false,
				success: function(data){

    		//$.ajax({
      			//type : "POST",
      			//url : pathUrl,
      			//success : function(data) {
//       				alert(codigoLengua);
      				//console.log("Exito: "+ data );
      			
      			
      			},
      			error : function() {
      				//console.log("ERROR: ");
      				msg_advertencia("Ocurrio un error");
      			}
      		});

      		

         }
     $( document ).ready(function() {
    	//Phone with extra
    	   
    		$('#telefonoUsuario').inputmask("(999) 999-9999 / 999-999-999");
    		// Email mask
    		$('#correoElectronico').inputmask({
    			mask: "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@*{1,20}[*{2,6}][*{1,2}].*{1,}[.*{2,6}][.*{1,2}]",
    			greedy: false,
    			onBeforePaste: function (pastedValue, opts) {
    				pastedValue = pastedValue.toLowerCase();
    				return pastedValue.replace("mailto:", "");
    			},
    			definitions: {
    				'*': {
    					validator: "[0-9A-Za-z!#$%&'*+/=?^_`{|}~/-]",
    					cardinality: 1,
    					casing: "lower"
    				}
    			}
    		});
    	 buscarUbigeo();
    		var idDocente = document.getElementById("codigoDocente").value;
    	 if (idDocente != '0') {
 			 
 			 refrescarListaEspecialidad(idDocente);
 			 refrescarListaInstitucion(idDocente);
 		}
    	
    	   
    	});
     
     function validarTef(){
    	 $('#telefonoUsuario').inputmask("(999) 999-9999 / 999-999-999");
     }
     
//      function validarCorreo(){
//     	 $('#correoElectronico').inputmask({
//  			mask: "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@*{1,20}[*{2,6}][*{1,2}].*{1,}[.*{2,6}][.*{1,2}]",
//  			greedy: false,
//  			onBeforePaste: function (pastedValue, opts) {
//  				pastedValue = pastedValue.toLowerCase();
//  				return pastedValue.replace("mailto:", "");
//  			},
//  			definitions: {
//  				'*': {
//  					validator: "[0-9A-Za-z!#$%&'*+/=?^_`{|}~/-]",
//  					cardinality: 1,
//  					casing: "lower"
//  				}
//  			}
//  		});
//      }
 	
     function buscarDocentexFiltros(){
  		
    	console.log('----- desencriptado ------'); 
    	var codigoinst = $('#idCodigoInstitucionInscLengua').val();
  		var codigoInscLen =$('#idCodigoInscripcionLengua').val();
  		var nombredoc = $('#nombredocente').val();
  		var numerodoc = $('#numdocumento').val();
		var pathUrl = "${pageContext.request.contextPath}/docenteController/buscardocente";
		var dataParams = "codigoInst="+codigoinst+"&nombreDocente="+nombredoc+"&numeroDocumento="+numerodoc+"&codigoinsclengua="+codigoInscLen;
		var html = "";
		$.ajax({
  			type : "GET",
  			data: dataParams,
  			url : pathUrl,
  			
  			success : function(data) {
  				if(data!=null && data.length!=0){
  					for(var i=0;i<data.length;i++){
  	  					html=html+"<tr><td>"+transformAtr('nombrePersona',data[i].personaBean.nombrePersona) +" "+ transformAtr('apellidoPaterno',data[i].personaBean.apellidoPaterno)+" "+transformAtr('apellidoMaterno',data[i].personaBean.apellidoMaterno) +"</td><td>"+transformDNI(data[i].personaBean.numeroDocumento)+"</td><td><button type='button' title='Asignar' data-toggle='tooltip' data-original-title='Asignar' data-placement='top' onclick='registrarAsignarDocente("+data[i].codigo+");' class='btn btn-outline-success btn-sm'><i class='icon-arrow-right'></i> </button></td></tr>";
 	  				}
  	  				document.getElementById("listaDocentes").innerHTML=html;
  				}else{
 	  					document.getElementById("listaDocentes").innerHTML="<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>"
  				}  				
  			},
  			error : function() {
  				//console.log("ERROR: ");
  			}
  		});
  	
   };

   function transformDNI(dni){
 		var iterationCount = 1000;
	  	var keySize = 128;
	    
	    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    
	    var aesUtil = new AesUtil(keySize, iterationCount);
	    var txtDocPer = aesUtil.decrypt(salt, iv, "numeroDocumento", dni);
	    txtDocPer = txtDocPer.substring(0,4);
	    return txtDocPer+"****";
	}
   function transformAtr(key,valencript){
		var iterationCount = 1000;
	  	var keySize = 128;
	    
	    var iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	    var salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
	    
	    var aesUtil = new AesUtil(keySize, iterationCount);
	    var txtDecript = aesUtil.decrypt(salt, iv, key, valencript);
	 
	    return txtDecript;
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

	function validarPersona() {

		var tipoDocumento = $('#codigoTipoDocumento').val();
		var numeroDocumento = $('#numeroDocumentoPersona').val();
		if (numeroDocumento == null && numeroDocumento == "") {
			numeroDocumento = 0;
		}
		$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/personaController/validapersona?tipodocumento="
							+ tipoDocumento
							+ "&numerodocumento="
							+ numeroDocumento,
					success : function(data) {
						if (data.codigo != 0) {
							$('#codigoTipoDocumento').val(
									data.tipoDocumento.codigoRegistro);
							$('#numeroDocumentoPersona').val(
									data.numeroDocumento);
							$('#codigoPersona').val(data.codigo);
							/*$('#codigoPersonal').val();*/
							/*$('#situacionPersonal').val(data);*/
							$('#nacionalidadPersona').val(
									data.nacionalidad.codigoRegistro);
							$('#nombrePersona')
									.val(data.nombrePersona);
							$('#apellidoPaternoPersona').val(
									data.apellidoPaterno);
							$('#apellidoMaternoPersona').val(
									data.apellidoMaterno);
							var strFecha = convertirFecha(data.fechaNac);
							$('#fechaNacimiento').val(strFecha);
							$('#lenguaMaterna').val(
									data.lenguaBean.codigo);

							/*$('#gradoPersonal').val(data.);*/
							/*$('#cargoPersonal').val();*/
							$('#sexoPersona').val(
									data.sexo.codigoRegistro);
							$('#telefonoUsuario').val(data.telefono);
							$('#correoElectronico').val(data.correo);
							$('#ubigeoNombre').val(data.ubigeoBean.nombreUbigeo);
							$('#ubigeoCodigo').val(data.ubigeoBean.codigo);

							var codDep = data.ubigeoBean.codigoRegion;
							//alert(codDep);
								var codPro = data.ubigeoBean.codigoProvincia;
								//alert(codPro);
								var codDis = data.ubigeoBean.codigoDistrito;
						//		alert(codDis);
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

							$('#direccionPersona').val(
									data.direccionPersona);

						}

					},
					error : function() {
						//console.log("ERROR: ");
					}
				});
	}




	function obtenerEspecialidadDocenteXCodigoDocente(){
  		var codigoDocente = $('#codigoDocente').val();
//   		alert("agregar");
		var pathUrl = "${pageContext.request.contextPath}/docenteController/refrescarEspecialidad?codigo="+codigoDocente;
		var html = "";
		$.ajax({
  			type : "GET",
  			url : pathUrl,
  			
  			success : function(data) {

				if(data.length!=0 && data.length!=null){
					
					///
					
// 					if(listadoLenguas!=null && listadoLenguas.length>0){
// 						var repete = true;
// 						for(var i = 0; i < listadoLenguas.length; i++){ 
// 							if(listadoLenguas[i][0]==codigoLengua || codigoLengua==""){
// 								repete = false;
// 							}
// 						}
// 						if(repete){
// 							listadoLenguas.push([codigoLengua,nombreLengua]);
// 						}
// 					}else{
// 						if(codigoInstitucion!=""){
// 							listadoLenguas.push([codigoLengua,nombreLengua]);
// 						}

// 					}
					///


  				$('#codigoLengua').val(data[0].lenguaBean.codigo);

  				$('#codigoNivel').val(data[0].tm2Nivel.codigo);
  				
  				for(var i=0;i<data.length;i++){

  					html=html+"<tr><td style='display:none;'>"+data[i].lenguaBean.codigo +"</td><td>"+data[i].lenguaBean.nombre+"</td><td style='display:none;'>"+data[i].tm2Nivel.codigo+"</td><td>"+data[i].tm2Nivel.nombreCorto+"</td><td><button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarEspecialidad('"+data[i].docenteBean.codigo+"','"+data[i].lenguaBean.codigo+"');\"><i class='icon-trash'></i></button></td></tr>";
  					

  					}
  				
  				document.getElementById("tablalistadoEspecialidad").innerHTML=html;

				}else{

	  				document.getElementById("tablalistadoEspecialidad").innerHTML="<tr><td></td></tr>";
				}
  			},
  			error : function() {
  				//console.log("ERROR: ");
  			}
  		});
  	
   };


   function eliminarEspecialidad(codigoDocente,codigoEspecialidad){

		 $.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/docenteController/eliminarEspecialidad?codigo="+codigoDocente+"&codigoEspecialidad="+codigoEspecialidad,
				success : function(data) {
					if(data=='1'){
						msg_exito();
						obtenerEspecialidadDocenteXCodigoDocente();
					}else if(data=='0'){
						msg_error();
					}
				},
				error : function() {
					//console.log("ERROR: ");
				}
			});
		
	}


   function buscarPersona(e) {
		if (//(e.which == 13) || 
				!(e.keyCode == 13) ){
		// alert(e.keyCode);
		//	 if($('#numeroDocumentoPersona').val() != null){
				 var numerodocumento = $('#numeroDocumentoPersona').val();
		//		 alert(numerodocumento);
					if (numerodocumento.length > 7
							&& numerodocumento.length < 13) {
					//	alert("Entro");
						validarDocente2();
					}
			// }
			
		}
	}


//    function justNumbers(e) {
// 		var numeroDocumento = $('#numeroDocumentoPersona').val();
// 		var tipoDocumento = $('#codigoTipoDocumento').val();
// 		if (tipoDocumento != 0) {
// 			/*DNI*/
// 			if (tipoDocumento == 1) {
// 				if (numeroDocumento.length < 8) {
// 					var keynum = window.event ? window.event.keyCode
// 							: e.which;
// 					if ((keynum == 8) || (keynum == 46))
// 						return true;
// 					return /\d/.test(String.fromCharCode(keynum));
// 				} else {
// 					var keynum = window.event ? window.event.keyCode
// 							: e.which;
// 					if ((keynum == 8))
// 						return true;
// 					e.preventDefault();
// 				}
// 			}
// 			/*PASAPORTE*/
// 			if (tipoDocumento == 2) {
// 				if (numeroDocumento.length < 12) {
// 					 key = e.keyCode || e.which;
// 					    tecla = String.fromCharCode(key).toString();
// 					    letras = " 1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
// 					    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

// 					    tecla_especial = false
// 					    for(var i in especiales) {
// 					        if(key == especiales[i]) {
// 					            tecla_especial = true;
// 					            break;
// 					        }
// 					    }

// 					    if(letras.indexOf(tecla) == -1 && !tecla_especial){
// 					/* alert('Tecla no aceptada');*/
// 					        return false;
// 					      }
// 				} else {
// 					e.preventDefault();
// 				}
// 			}

// 		}
// 	}
function validarDocente2() {
		//alert("orden");
	
		var numeroDocumento = $('#numeroDocumentoPersona').val();
		if (numeroDocumento == null && numeroDocumento == "") {
			numeroDocumento = 0;
		}
// 		alert(numeroDocumento);
		$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/docenteController/validarDocente?numerodocumento="+numeroDocumento,
					success : function(data) {
// 						alert(data.codigo);
						if (data.codigo != 0) {
// 							alert("orden");
							$('#codigoTipoDocumento').val(
									data.personaBean.tipoDocumento.codigoRegistro);
							$('#numeroDocumentoPersona').val(
									data.personaBean.numeroDocumento);
							$('#codigoPersona').val(data.personaBean.codigo);
							
							$('#codigoDocente').val(data.codigo);
							$('#situacionDocente').val(data.situacion.codigoRegistro);

							
							$('#nacionalidadPersona').val(
									data.personaBean.nacionalidad.codigoRegistro);
							$('#nombrePersona')
									.val(data.personaBean.nombrePersona);
							$('#apellidoPaternoPersona').val(
									data.personaBean.apellidoPaterno);
							$('#apellidoMaternoPersona').val(
									data.personaBean.apellidoMaterno);
							var strFecha = convertirFecha(data.personaBean.fechaNac);
							$('#fechaNacimiento').val(strFecha);
							$('#lenguaMaterna').val(
									data.personaBean.lenguaBean.codigo);
							$('#sexoPersona').val(
									data.personaBean.sexo.codigoRegistro);
							$('#telefonoUsuario').val(data.personaBean.telefono);
							$('#correoElectronico').val(data.personaBean.correo);

							$('#ubigeoNombre').val(data.personaBean.ubigeoBean.nombreUbigeo);
							$('#ubigeoCodigo').val(data.personaBean.ubigeoBean.codigo);
							//
							/*ubigeo persona */
								var codDep = data.ubigeoBean.codigoRegion;
							//alert(codDep);
								var codPro = data.ubigeoBean.codigoProvincia;
							//	alert(codPro);
								var codDis = data.ubigeoBean.codigoDistrito;
							//	alert(codDis);
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
							//
							$('#direccionPersona').val(
									data.personaBean.direccionPersona);

							
							
							$('#lblInstitucion').val(
									data.institucionBean.codigo);

							$('#carreraDocente').val(
									data.carreraDocente.codigoRegistro);

							$('#gradoDocente').val(
									data.gradoDocente.codigoRegistro);

// 							obtenerEspecialidadDocenteXCodigoDocente();

							refrescarListaEspecialidad(data.codigo );
			 				refrescarListaInstitucion(data.codigo );
							


						}else{
// 							data.codigo 
							validarPersona();
							}

					},
					error : function() {
						//console.log("ERROR: ");
					},complete : function(){

						
						}
				});
	}
 	
	
	function validarDocente() {
		//alert("orden");
	
		var numeroDocumento = $('#numeroDocumentoPersona').val();
		if (numeroDocumento == null && numeroDocumento == "") {
			numeroDocumento = 0;
		}
// 		alert(numeroDocumento);
		$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/docenteController/validarDocenteinscr?numerodocumento="+numeroDocumento,
					success : function(data) {
// 						alert(data.codigo);
						if (data.codigo != 0) {
// 							alert("orden");
							$('#codigoTipoDocumento').val(
									data.personaBean.tipoDocumento.codigoRegistro);
							$('#numeroDocumentoPersona').val(
									data.personaBean.numeroDocumento);
							$('#codigoPersona').val(data.personaBean.codigo);
							
							$('#codigoDocente').val(data.codigo);
							$('#situacionDocente').val(data.situacion.codigoRegistro);

							
							$('#nacionalidadPersona').val(
									data.personaBean.nacionalidad.codigoRegistro);
							$('#nombrePersona')
									.val(data.personaBean.nombrePersona);
							$('#apellidoPaternoPersona').val(
									data.personaBean.apellidoPaterno);
							$('#apellidoMaternoPersona').val(
									data.personaBean.apellidoMaterno);
							var strFecha = convertirFecha(data.personaBean.fechaNac);
							$('#fechaNacimiento').val(strFecha);
							$('#lenguaMaterna').val(
									data.personaBean.lenguaBean.codigo);
							$('#sexoPersona').val(
									data.personaBean.sexo.codigoRegistro);
							$('#telefonoUsuario').val(data.personaBean.telefono);
							$('#correoElectronico').val(data.personaBean.correo);

							$('#ubigeoNombre').val(data.personaBean.ubigeoBean.nombreUbigeo);
							$('#ubigeoCodigo').val(data.personaBean.ubigeoBean.codigo);
							//
							/*ubigeo persona */
								var codDep = data.ubigeoBean.codigoRegion;
							//alert(codDep);
								var codPro = data.ubigeoBean.codigoProvincia;
							//	alert(codPro);
								var codDis = data.ubigeoBean.codigoDistrito;
							//	alert(codDis);
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
							//
							$('#direccionPersona').val(
									data.personaBean.direccionPersona);

							
							
							$('#lblInstitucion').val(
									data.institucionBean.codigo);

							$('#carreraDocente').val(
									data.carreraDocente.codigoRegistro);

							$('#gradoDocente').val(
									data.gradoDocente.codigoRegistro);

// 							obtenerEspecialidadDocenteXCodigoDocente();

							refrescarListaEspecialidad(data.codigo );
			 				refrescarListaInstitucion(data.codigo );
							


						}else{
// 							data.codigo 
							validarPersona();
							}

					},
					error : function() {
						//console.log("ERROR: ");
					},complete : function(){

						
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
		    		listadoInstitucion = [];
		    		for (var i = 0; i < response.length; i++) {
				    		var objInst = [response[i].codigo,response[i].nombreInstitucion];//response[i];
				    		listadoInstitucion.push([response[i].codigo,response[i].nombreInstitucion]);
//				    		htmlTabla +=
//				    			"<tr>"+
//				    			"<td>"+(i+1)+"</td>"+
//		    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
//		    					"<td>"+objInstLengua.tm2Nivel.nombreCorto+"</td>"+
//					    		"<td>"+
//									"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarConfirmacion('especialidad','"+objInstLengua.docenteBean.codigo+"','"+objInstLengua.lenguaBean.codigo+"');\"><i class='icon-trash'></i></button>"+
//					    		"</td>"+
//				    		"</tr>";
		    		 	 
		    		 	htmlTablaIntitucion +=
		    			"<tr>"+
		    			"<td>"+(i+1)+"</td>"+
		    			"<td>"+response[i].nombreInstitucion+"</td>"+
		        		"<td>"+
		    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarInstitucionV2('"+objInst+"');\"><i class='icon-trash'></i></button>"+
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

		  $.ajax({
		    type: "GET",
		    url : "${pageContext.request.contextPath}/docenteController/refrescarEspecialidad?codigo="+codigoDocente,
			success: function(response){
				$('#tablalistadoEspecialidad').empty();
		     
		    	//console.log(response);
		    	//console.log(response.length);
		    	if(response!=null && response.length>0){
		    		for (var i = 0; i < response.length; i++) {
			    		var objInstLengua = response[i];
// 			    		htmlTabla +=
// 			    			"<tr>"+
// 			    			"<td>"+(i+1)+"</td>"+
// 	    					"<td>"+objInstLengua.lenguaBean.nombre+"</td>"+
// 	    					"<td>"+objInstLengua.tm2Nivel.nombreCorto+"</td>"+
// 				    		"<td>"+
// 								"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarConfirmacion('especialidad','"+objInstLengua.docenteBean.codigo+"','"+objInstLengua.lenguaBean.codigo+"');\"><i class='icon-trash'></i></button>"+
// 				    		"</td>"+
// 			    		"</tr>";
			    		htmlTabla=htmlTabla+"<tr><td style='display:none;'>"+response[i].lenguaBean.codigo +"</td><td>"+response[i].lenguaBean.nombre+"</td><td style='display:none;'>"+response[i].tm2Nivel.codigo+"</td><td>"+response[i].tm2Nivel.nombreCorto+"</td><td><button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarEspecialidad('"+response[i].docenteBean.codigo+"','"+response[i].lenguaBean.codigo+"');\"><i class='icon-trash'></i></button></td></tr>";
					}
		  	    	$('#tablalistadoEspecialidad').html(htmlTabla);
		    	}else{
		  	    	$('#tablalistadoEspecialidad').html("<tr><td colspan='4'><center>Sin registros para mostrar</center></td></tr>");
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
	
function capturarDatosUbigeo(nombre,codigo){
	
	$('#ubigeoCodigo').val(codigo);
	$('#ubigeoNombre').val(nombre);
	cerrar_ubigeo();
}

   function buscarUbigeo(){
 		var nombreDepartamento = $('#nombreDepartamento').val();
 		var nombreProvincia =$('#nombreProvincia').val();
 		var nombreDistrito = $('#nombreDistrito').val();
 	
		var pathUrl = "${pageContext.request.contextPath}/baseController/buscarubigeo?nombredepartamento="+nombreDepartamento+"&nombreprovincia="+nombreProvincia+"&nombredistrito="+nombreDistrito;
		var html = "";
		var aux = "";
		var codigoUbigeo="";
		$.ajax({
 			type : "GET",
 			url : pathUrl,
 			
 			success : function(data) {

 				for(var i=0;i<data.length;i++){
					aux="'"+data[i].nombreUbigeo+"'";
					codigoUbigeo="'"+data[i].codigoUbigeo+"'";
 					html=html+"<tr><td>"+data[i].codigoUbigeo +"</td><td>"+data[i].nombreUbigeo+"</td><td><button type='button' " + "onclick="+ '"' +"capturarDatosUbigeo("+String(aux)+","+String(codigoUbigeo)+");"+'"'+" class='btn btn-outline-success btn-sm'><i class='icon-arrow-right'></i> </button></td></tr>";
 					

 					}
 				
 				document.getElementById("tablaListaUbigeo").innerHTML=html;

 				
 			},
 			error : function() {
 				//console.log("ERROR: ");
 			}
 		});
 	
  };






   

   function enviar_ajax(){
	   iniciarBloqueo();
	   
         var url = $("#frmregistromodal").attr("action"); //Capturar el action del form
		 console.log("inicio");
		 console.log($("#frmregistromodal").serialize());
		 console.log(listadoInstitucion);
        $.ajax({
              type: "POST",
              url: url,
              data: $("#frmregistromodal").serialize(), // Serializar la data del form
              success: function(data)
              {
                  console.log(data);
                  if(data!=0){

  					  /*************************************/
  					  var listTemporalInstitucion = [];
  					  if(listadoInstitucion.length > 0){
						for(var i=0;i<listadoInstitucion.length;i++){
							listTemporalInstitucion.push({identificador:listadoInstitucion[i][0],nombreInstitucion:listadoInstitucion[i][1]});
						}
						console.log(listTemporalInstitucion);
						  enviar_ajax_institucion(JSON.stringify(listTemporalInstitucion));
					  }
  					  /************************************/	
                      obtenerDatosEspecialdadDocente(data);
                	  listado_docente_modal();
                  }
            	  
            	 //regresar---
            	 
            	  msg_exito();
                  //msg_exito(); //acciones luego de realizar la accion

              },
              error: function(xhr,status,er) {//msg_error();
				//console.log("error: " + xhr + " status: " + status + " er:"+ er);

                         if(xhr.status==500) {

                           //console.log(er);

                     //         Error_500(er);

                         }

                         if(xhr.status==901) {

                     //console.log(er);

                   //      spire_session_901(er);

                     }

                   },

                   complete: function(){
				
//                 	   $("#btn_regresar_doc_modal")
// 						.trigger(
// 								"click");
                	    validarDocente();
//                 	   document.getElementById("frmregistromodal").reset();
                	   buscarDocentexFiltros();
                	   finBloqueo();
//                      $("#closeModalBtnFrm").trigger("click"); // cerrar modal

                     //refrescarListaInstOperador();    // métodos luego delpost

                   }

            });

       return false;

   }

   	function enviar_ajax_institucion(listadaJSON){
   		$.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/docenteController/registrarInstitucion",
            data: {listado:listadaJSON}, // Serializar la data del form
            success: function(data)
            {

            },
            error: function(xhr,status,er) {
            
                   if(xhr.status==500) {
                       
                   }
                   if(xhr.status==901) {
                       
                }

             },

                 complete: function(){

                 }

          });
		
    }

	function registrarAsignarDocente(idcodigodocente){
		

		var idcodigoinsclengua= $('#idCodigoInscripcionLengua').val();
		
  	
		var pathUrl = "${pageContext.request.contextPath}/docenteController/asignardocente?codigoinsclen="+idcodigoinsclengua+"&coddocente="+idcodigodocente;
		var html = "";
		iniciarBloqueo();
		$.ajax({
  			type : "POST",
  			url : pathUrl,
  			success : function(data) {
  				msg_exito();
  				
  				buscarDocentexFiltros();
  				listadoDocentesXInscripcionLengua();
  		
  			},
  			error : function() {
  				//console.log("ERROR: ");
  				msg_advertencia("Ocurrio un error");
  				
  			}
  			, complete: function(){
  				 finBloqueo();
  			}
  		});

		}


	//  ----------------------------------- //
	
	
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
							if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
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
				return (fecha);
			}


			///------------------------------------///
   
     </script>
     
<!--     <div class="modal fade text-xs-left" id="docente-modal-registro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true"> -->
      <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>DOCENTE</b></label>
        </div>
        <f:form>
        <div class="modal-body" id="listado_docente_modal">
          <div class="row">
            <div class="col-md-5 mb-2">
                <label>Nombre de docente</label>
<!--                 <input type="text" class="form-control" name="fname"> -->
 		  <f:input type="text" id="nombredocente" class="form-control" path="personaBean.nombrePersona" maxlength="30"/>
            </div>
            <div class="col-md-3 mb-2">
                <label>N&uacute;mero de documento</label>
                  <f:input type="text" id="numdocumento"  class="form-control" path="personaBean.numeroDocumento" maxlength="15"   onpaste="return false;"/>
<!--                 <input type="text" class="form-control" name="fname"> -->
            </div>
              <div class="form-group col-md-4 text-right">
                <button type="button" class="btn btn-primary mt-2" onclick="nuevo_docente_modal()"><i class="icon-plus"></i> Nuevo</button>
                  <button type="button" onclick="buscarDocentexFiltros()"  class="btn btn-default mt-2">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <table class="table table-striped table-bordered zero-configuration">
                  <thead>
                      <tr>
                          <th>Docente</th>
                          <th>N&uacute;mero de documento</th>
                          <th width="50">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody id="listaDocentes">
                 
<%--                   <c:forEach var="docenteBean" items="${lstDocenteBean}"> --%>
<!--                       <tr> -->
<%--                           <td>${docenteBean.personaBean.nombrePersona} ${docenteBean.personaBean.apellidoPaterno} ${docenteBean.personaBean.apellidoMaterno}</td> --%>
<%--                           <td>${docenteBean.personaBean.numeroDocumento}</td> --%>
<!--                           <td> -->
<!--                             <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
<!--                           </td> -->
<!--                       </tr> -->
<%--                       </c:forEach> --%>
                     
                    
				
                  </tbody>
              </table>
            </div>
          </div>

        </div>
        
         </f:form>
<!-- ///registro -->
        <div class="modal-body" id="regisro_docente_modal" style="display: none;">
          <f:form class="form mt-1" id="frmregistromodal" onsubmit="return false" name="frmregistromodal" method="post" action="${pageContext.request.contextPath}/docenteController/grabardocenteV2">
            <div class="form-body">
             <div class="row">
                <div class="col-xs-12">
                  <h5>DATOS GENERALES</h5>
                </div>
              </div>
                <c:if test="${docenteBean.codigo!=0}">
					<input type="hidden" value="${listadoInstitutoVo}"  id="listadoInstitutoVo"  /> 
				</c:if>
											
              <div class="row">
               <f:input type="hidden" id="codigoPersona" path="personaBean.codigo"/>
              <f:input type="hidden" id="codigoDocente" path="codigo"/>
            
                 <div class="form-group col-md-3 mb-2">
                    <label for="situacionUsuario">Situaci&oacute;n*</label>
                     <div class="controls">
                     <f:select  id="situacionDocente" path="situacion.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstSituacion}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                  </div>
                  <div class="form-group col-md-3 mb-2">
                    <label for="situacionUsuario">Tipo de documento*</label>
                     <div class="controls">
                     <f:select id="codigoTipoDocumento" path="personaBean.tipoDocumento.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required" onchange="formatoNumeroDocumento()">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstTipoDocumento}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                  </div>

                  <div class="form-group col-md-3 mb-2">
                      <label for="projectinput2">N&uacute;mero de documento*</label>
                       <div class="controls">
                       <f:input type="text" id="numeroDocumentoPersona" maxlength="15" onkeyup="buscarPersona(event);return justNumbers(event);"  class="form-control" path="personaBean.numeroDocumento" data-validation-required-message="Este campo es requerido" required="required" onpaste="return false;" />
					</div>
<!--                       <input type="text" id="projectinput2" class="form-control" name="lname"> -->
                  </div>

                  <div class="form-group col-md-3">
                    <label for="situacionUsuario">Nacionalidad*</label>
                     <div class="controls">
                   <f:select  id="nacionalidadPersona" path="personaBean.nacionalidad.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
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
                      <label for="projectinput1">Nombres*</label>
                       <div class="controls">
                      <f:input id="nombrePersona" type="text" class="form-control" path="personaBean.nombrePersona" data-validation-required-message="Este campo es requerido" required="required" maxlength="30"/>
	</div>
<!--                       <input type="text" id="projectinput1" class="form-control" name="fname"> -->
                  </div>

                  <div class="form-group col-md-3 mb-2">
                      <label for="apellidopaterno">Apellido paterno*</label>
                       <div class="controls">
                      <f:input id="apellidoPaternoPersona" type="text" class="form-control" path="personaBean.apellidoPaterno" maxlength="30"/>
                      </div>
<!--                       <input type="text" id="apellidopaterno" class="form-control" name="apellidopaterno"> -->
                  </div>
                  <div class="form-group col-md-3 mb-2">
                      <label for="projectinput2">Apellido materno*</label>
                       <div class="controls">
                       <f:input id="apellidoMaternoPersona" type="text" class="form-control" path="personaBean.apellidoMaterno" maxlength="30"/>
				</div>
<!--                       <input type="text" id="projectinput2" class="form-control" name="lname"> -->
                  </div>
                  <div class="form-group col-md-3 mb-2">
                      <label for="fechanacimiento">Fecha de nacimiento*</label>
                       <div class="controls">
                      <f:input id="fechaNacimiento" type="text" class="form-control" path="personaBean.fechaNac" onKeyUp = "this.value=formateafecha(this.value);" data-validation-required-message="Este campo es requerido" required="required"/>
				</div>

<!--                       <input type="date" id="fechanacimiento" class="form-control" name="fechanacimiento"> -->
                  </div>
              </div>

              <div class="row">
               
                <div class="form-group col-md-3">
                    <label for="projectinput2">G&eacute;nero*</label>
                     <div class="controls">
                     <f:select id="sexoPersona" path="personaBean.sexo.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstSexo}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                </div>

                 <div class="form-group col-md-3">
                    <label for="telefonoUsuario">Tel&eacute;fono / Celular*</label>
                     <div class="controls">
                     <f:input id="telefonoUsuario" type="text" class="form-control" name="telefono" path="personaBean.telefono" 
                     data-validation-required-message="Este campo es requerido" 
                     required="required" onkeypress="return validarTef()"/>
<%-- 	               	<f:input type="text" id="telefonoUsuario" class="form-control" name="telefono"  path="personaBean.telefono" data-validation-required-message="Este campo es requerido" required="required" /> --%>
                                         		
				</div>
<!--                     <input type="text" id="telefonoUsuario" class="form-control" name="lname"> -->
                </div>

                <div class="form-group col-md-3">
                  <label for="telefonoUsuario">Correo electr&oacute;nico*</label>
                   <div class="controls">
                  <f:input id="correoElectronico" type="text" class="form-control" 
                  path="personaBean.correo" 
                  data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})" 
                  data-validation-regex-message="Ingresa un correo valido" 
                  data-validation-required-message="Este campo es requerido" required="required" />
			</div>
	<!--                   <input type="text" id="telefonoUsuario" class="form-control" name="lname"> -->
                </div>

			 <div class="form-group col-md-3 mb-2">
                  <label for="situacionUsuario">Lengua materna*</label>
                   <div class="controls">
                  <f:select id="lenguaMaterna" path="personaBean.lenguaBean.codigo" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="0" label="Seleccionar"/>
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

              <div class="row">
<!-- 
                <div class="form-group col-md-3 mb-2">
                  <label for="situacionUsuario">Carrera</label>
                   <div class="controls">
                   <f:select id="carreraDocente"  path="carreraDocente.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstCarrera}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                        </f:select>
                                                        </div>
                </div>
 -->              
               
                <div class="form-group col-md-6 mb-2">
                  <div class="form-group">
                    <label for="situacionUsuario">Nombre de la instituci&oacute;n*</label>
                     <div class="controls">
                    <f:select id="lblInstitucion" path="institucionBean.codigo" class="select2 form-control" data-validation-required-message="Este campo es requerido" required="required">
							<f:option value="0" label="Seleccionar" />
							<f:options items="${lstInstitucion}" itemValue="codigo" itemLabel="nombreInstitucion" />
						</f:select> 
						</div>
                  </div>
                </div>
               
                  <div class="form-group col-md-1 " >
                                                  <%--<button type="submit" class="btn btn-outline-info btn-min" style="margin-top: 20px">--%>
                                                    <button type='button' id="btnAgregarInstitucionDocente" class="btn btn-outline-info btn-min"  onclick="agregarInstitucionV2();" style="margin-top: 20px"  >
                                                 <i class="ft-plus"></i></button>
                 </div>
               
               
               

              	   
               
                   							<div class="row">
                                              <div class="form-group col-md-2 mb-2">
                                                  <label for="situacionUsuario">Grado o t&iacute;tulo*</label>
                     <div class="controls">
                      <f:select id="gradoDocente"  path="gradoDocente.codigoRegistro" class="form-control" data-validation-required-message="Este campo es requerido" required="required">
                                                            <f:option value="" label="Seleccionar"/>
                                                            <f:options  items="${lstGrado}"
                                                                       itemValue="codigoRegistro" 
                                                                         itemLabel="nombreCorto"/>  
                                                         </f:select>  
                                                        </div>
                                               </div>
                                              </div>
                                              
                                                                 <div class="form-group col-md-3 mb-2">  
                                                                   <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                        	<th>N°</th>
                                                            <th>Nombre de instituci&oacute;n</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="idlistadoInstitucion">
                                                    	<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                        	<th>N°</th>
                                                            <th>Nombre de institución</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                
                  </div>
               

              </div>
<div class="row">
                <div class="col-xs-12">
                  <h5>LENGUA ORIGINARIA DE DOMINIO</h5>
                </div>
              </div>

              <div class="row">
              
               <div class="form-group col-md-3 mb-1">
                  <label for="situacionUsuario">Lengua* </label>
                 <f:select  path="especialidadBean.lenguaBean.codigo" id="codigoLengua" class="form-control selectReset"   data-validation-required-message="Este campo es requerido" required="required">
                                                            
                                                            <f:option value="0" class="optionReset" label="Seleccionar"/>
                                                            <f:options  items="${lstLengua}"
                                                                        itemValue="codigo"
                                                                        itemLabel="nombre"/>
                  </f:select>
                </div>
                
                
                  <div class="form-group col-md-3 mb-2">
                                                  <label for="situacionUsuario">Nivel de dominio*</label>
                                                   <div class="controls">
                                                   <f:select  path="especialidadBean.tm2Nivel.codigoRegistro" id="codigoNivel"  class="form-control"   data-validation-required-message="Este campo es requerido" >
                                                            <f:option value="" selected="" label="Seleccionar"/>
                                                            <f:options  items="${lstNivel}"
                                                                        itemValue="codigoRegistro"
                                                                        itemLabel="nombreCorto"/>
                                                  </f:select>
                                                  </div>
                                               
                </div>
                <div class="form-group col-md-1 " >
		  			 <button type="button" onclick="agregar_Tabla_especialidad();" class="btn btn-outline-info btn-min" style="margin-top: 20px">
                 <i class="ft-plus"></i></button>
                                                </div>
                
                
                <div class="form-group col-md-5 mb-2" style="overflow: auto;max-height: 200px;"> 
               
                 <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                        	<th style="display:none">Codigo de especialidad</th>
                                                            <th>Lengua</th>
                                                             <th style="display:none">Codigo de nivel</th>
                                                            <th width="70">Nivel</th>
                                                            <th width="60">Acci&oacute;n</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="tablalistadoEspecialidad">
														<c:choose>
														    <c:when test="${lstEspecialidad == null}">
														         <tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>
														    </c:when>
														    <c:otherwise>  
															    <c:forEach var="especialidadBean" items="${lstEspecialidad}">
		                                                 		</c:forEach>
														    </c:otherwise>
														</c:choose>
                                                      
                                                    </tbody>
                                                </table>
							                </div>
							              </div>
							              <div class="row">
												  <div class="form-group col-md-3">
                                                      <label for="projectinput1">N&uacute;mero de registro</label>
                                                      <div class="controls">
                                                      <input type="text" id="numeroDocumento" class="form-control"  data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}" onkeypress="return valida(event)" maxlength="10" />

                                                	 </div>
                                                  </div>
                                                 <div class="form-group col-md-4">
                                                  <label for="">Subir documento  </label>
                                                  <i title="Formato aceptado .pdf, .doc, .docx, odt - Tamaño máximo permitido hasta 20 MB, el nombre no debe contener espacios" data-original-title="Formato aceptado .pdf, .doc, .txt - Tamaño máximo permitido hasta 20 MB" data-placement="top" data-toggle="tooltip" class="fa fa-info-circle"></i>
                                               
                                                  <input type="file" id="fileDoc" class="form-control form-control-sm" name="fileDoc" data-validation-required-message="Este campo es requerido" 
                                                  accept="application/pdf, .doc, .docx, .odt">
                                                 </div>
                                               

												<div class="form-group col-md-9">
												 <div class="controls">

												   <!-- onclick="descargarArchivo()" <a  download="Archivo">Descargar Archivo</a>-->
                                                 </div>
                                                 </div>
                                                
                                              </div>
              
              
              

              <div class="row">
                <div class="col-xs-12">
                  <h5> DATOS DE RESIDENCIA </h5>
                  <br>
                </div>
              </div>

	 <div class="row">
                                                <div class="form-group col-md-3">
												        <label for="projectinput2">Regi&oacute;n*</label>
												          <f:select path="ubigeoBean.codigoRegion" onchange="buscarProvincia();" id="provinciaSelect" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstRegion}"
                                                                        itemValue="codigoRegion"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Provincia*</label>

												        <f:select path="ubigeoBean.codigoProvincia" onchange="buscarDistrito();" id="comboprovincia" name="comboprovincia" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstProvincia}"
                                                                        itemValue="codigoProvincia"
                                                                        itemLabel="nombreUbigeo"/>
                                                       	</f:select>


												</div>
												<div class="form-group col-md-3">
												        <label for="projectinput2">Distrito*</label>
												         <f:select path="ubigeoBean.codigoDistrito" id="combodistrito" name="combodistrito" class="form-control" required="required">
                                                            <f:option value="00" label="Seleccionar"/>
                                                            <f:options  items="${lstDistrito}"
                                                                        itemValue="codigoDistrito"
                                                                        itemLabel="nombreUbigeo"/>
                                                     	  </f:select>
												</div>

                                              </div>

              <div class="row">
<!--                   <div class="form-group col-md-4"> -->
<!--                     <label for="situacionUsuario">Ubigeo</label> -->
<%--                      <f:input id="ubigeoNombre" type="text" class="form-control" path="personaBean.ubigeoBean.nombreUbigeo" disabled="true" /> --%>
<%--                      <f:input id="ubigeoCodigo" type="hidden" class="form-control" path="personaBean.codigoUbigeo"  /> --%>
<!--                   </div> -->
                  
<!--                   <div class="form-group col-md-2"> -->
<!--                     <label for="situacionUsuario">Buscar Ubigeo</label> -->
<!--                    <button id="agregar_ubi" type="button" onclick="agregar_ubigeo();" class="btn btn-default mr-1"> -->
<!--                         <i class="ft-search"></i> Agregar -->
<!--                       </button> -->
<!--                   </div> -->

						<div class="form-group col-md-9">
                      <label for="direccion">Dirección*</label>
                       <div class="controls">
                       <f:input id="direccionPersona" type="text" class="form-control" path="personaBean.direccionPersona" data-validation-required-message="Este campo es requerido" required="required" maxlength="50"/>
				</div>
<!--                       <input type="text" id="direccion" class="form-control" name="direccion"> -->
                  </div>
              </div>



              <div class="row">
                  <div class="form-group col-md-12 text-right">
                      <button type="button" onclick="limpiarForm();" class="btn btn-default mr-1">
                       <i class="fa fa-eraser"></i>Limpiar
                      </button>
<!--                       <a class="btn btn-primary" href="javascript:enviar_formulario()">Guardar</a>  -->
                      
                      <button type="submit"  onclick="validarRequired('#frmregistromodal');" class="btn btn-primary">
                                                    <i class="ft-search" ></i> Guardar
                                                  </button>

<!--  <button type="button" onclick="abrirModal();" class="btn btn-primary"><i class="icon-plus"></i> Agregar Docente</button> -->
<!--                       <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a> -->

                  </div>
              </div>
            </div>
          </f:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" style="display: none" id="btn_regresar_doc_modal" onclick="listado_docente_modal()">Regresar Listado</button>
          <button type="button" class="btn btn-outline-secondary" id="closeBtnmodalRegistroDocente" data-dismiss="modal">Salir</button>
        </div>
       
      </div>
      </div>
<!--     </div> -->





<script type="text/javascript" charset="utf-8">

$(document).on('click', '#agregar_ubi', function() {
    $('#ubigeo-modal').modal('show');
});

function validarRequired(idfrom){

	var $myForm = $(idfrom);

	var departamento = document.getElementById("provinciaSelect");
	var provincia = document.getElementById("comboprovincia");
	var distrito = document.getElementById("combodistrito");
	var apellidoPaterno = document.getElementById("apellidoPaternoPersona");
	var apellidoMaterno = document.getElementById("apellidoMaternoPersona");
	var lenguaMaterna = document.getElementById("lenguaMaterna");
	var institucion = document.getElementById("lblInstitucion");
	
	if(! $myForm[0].checkValidity() || departamento.value == "00" ||
			 provincia.value == "00" || distrito.value == "00" ||
			 lenguaMaterna.value == "0"  || institucion.value == "0"){


		$("#provinciaSelect").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#comboprovincia").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#combodistrito").css("border", "2px solid rgba(22, 211, 154, .5)");

		$("#lenguaMaterna").css("border", "2px solid rgba(22, 211, 154, .5)");
		$("#lblInstitucion").css("border", "2px solid rgba(22, 211, 154, .5)");
		
		$("#provinciaSelect").css("color", "#16D39A");
		$("#comboprovincia").css("color", "#16D39A");
		$("#combodistrito").css("color", "#16D39A");

		$("#lenguaMaterna").css("color", "#16D39A");
		$("#lblInstitucion").css("color", "#16D39A");

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

		 if(lenguaMaterna.value == "0"){
				$("#lenguaMaterna").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#lenguaMaterna").css("color", "#444");
				lenguaMaterna.focus();
			}

		 if(institucion.value == "0"){
				$("#lblInstitucion").css("border", "2px solid rgba(210, 60, 60, .5)");
				$("#lblInstitucion").css("color", "#444");
				institucion.focus();
			}
		 
		 msg_advertencia("Debe completar los campos requeridos correctamente");
	}
	else{
		if(apellidoPaterno.value != "" || apellidoMaterno.value != "") {
			enviar_ajax();
		}else {
			msg_advertencia("Debe completar al menos uno de los dos apellidos");	
		}
		
	}
	
}

 function nuevo_docente_modal(){
	 limpiarForm();
    $("#regisro_docente_modal").show();
    $("#btn_regresar_doc_modal").show();
    $("#listado_docente_modal").hide();
//     $('#idBodyListaInstLengua').empty();
// 	$('#idlistadoInstitucion').empty();
	
// 	listadoInstitucion = [];
// 	lstEspecialidad = [];
	
 }
 /*
  function listado_docente_modal(){
    $("#listado_docente_modal").show();
    $("#regisro_docente_modal").hide();
    $("#btn_regresar_doc_modal").hide();
 } 
 */

 function agregar_ubigeo(){
	
// 	 $('#ubigeo-modal').modal('show');
}

function cerrar_ubigeo(){
	 $("#ubigeo-modal").modal('hide');
	 
	 
}

function agregarInstitucionV2(){ 
	// alert(listadoInstitucion);
	var codigoInstitucion = $('#lblInstitucion').val();
	$('#lblInstitucion').val();
	if(codigoInstitucion != "0"){
		var comboInstitucion = document.getElementById("lblInstitucion"); 
		var nombreInstitucion = comboInstitucion.options[comboInstitucion.selectedIndex].text;
		//alert(codigoInstitucion);
		if(listadoInstitucion!=null && listadoInstitucion.length>0){
			var repete = true;
			for(var i = 0; i < listadoInstitucion.length; i++){ 
				if(listadoInstitucion[i][0]==codigoInstitucion || codigoInstitucion==""){
					repete = false;
				}
			}
			if(repete){
				listadoInstitucion.push([codigoInstitucion,nombreInstitucion]);
			}
		}else{
			if(codigoInstitucion!=""){
				listadoInstitucion.push([codigoInstitucion,nombreInstitucion]);
			}

		}
		refrescarInstitucionV2();
		htmlTablaIntitucion = "";
		$('#idlistadoInstitucion').empty();
		if(listadoInstitucion!=null && listadoInstitucion.length>0){
    		for (var i = 0; i < listadoInstitucion.length; i++) {
	    		var prmInstitucion = listadoInstitucion[i];
	    		htmlTablaIntitucion +=
	    			"<tr>"+
	    			"<td>"+(i+1)+"</td>"+
	    			"<td>"+prmInstitucion[1]+"</td>"+
	        		"<td>"+
	    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarInstitucionV2('"+prmInstitucion+"');\"><i class='icon-trash'></i></button>"+
	        		"</td>"+
	    		"</tr>";
	    		//$('#idlistadoInstitucion').html(htmlTablaIntitucion);
			}
  	    	$('#idlistadoInstitucion').html(htmlTablaIntitucion);
    	}else{
    	  	$('#idlistadoInstitucion').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");
    		
    	}
	 
		
	}else{
		 msg_advertencia("Debe seleccionar una institución");
		 
	}
	

}

function refrescarInstitucionV2(){
	//console.log(contextPath);
	$.ajax({
		type : "GET",

		url : "${pageContext.request.contextPath}/docenteController/refrescarInstitucion?listadoInstitucion="+listadoInstitucion,


		success : function(data) {
			//console.log("SUCCESS: ", data); 
		},
		error : function() {
			//console.log("ERROR: ");
		}
	});
}

function eliminarInstitucionV2(item){
	itemInstitucion = item;
	tipoItem = "nacionalidad";
//	alert("tipoItem " + tipoItem);
	 if(tipoItem == 'nacionalidad'){
		 eliminarModalInstitucionV2();
		 
	 } 
}

function eliminarModalInstitucionV2(){ 
	//console.log(itemInstitucion);
	listadoInstitucion.removeItem(itemInstitucion); 
	refrescarInstitucionV2();
	htmlTablaIntitucion = "";
	$('#idlistadoInstitucion').empty();
	//console.log("eliminar");
	//console.log(listadoInstitucion);
	if(listadoInstitucion!=null && listadoInstitucion.length>0){
		for (var i = 0; i < listadoInstitucion.length; i++) {
    		var prmInstitucion = listadoInstitucion[i];
    		htmlTablaIntitucion +=
    			"<tr>"+
    			"<td>"+(i+1)+"</td>"+
    			"<td>"+prmInstitucion[1]+"</td>"+
        		"<td>"+
    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarInstitucionV2('"+prmInstitucion+"');\"><i class='icon-trash'></i></button>"+
        		"</td>"+
    		"</tr>";
		}
		$('#idlistadoInstitucion').html(htmlTablaIntitucion);
	}else{
	  	$('#idlistadoInstitucion').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");
    	
	}

}

function valida(e){
    tecla = (document.all) ? e.keyCode : e.which;

    //Tecla de retroceso para borrar, siempre la permite
    if (tecla==8){
        return true;
    }
        
    // Patron de entrada, en este caso solo acepta numeros
    patron =/[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
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
				if ((keynum == 8) || (keynum == 46))
					return true;
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
					 if(e.keyCode == 32){
 
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
					 if(e.keyCode == 32){
 
				         return false;
				        }
 

				    if(letras.indexOf(tecla) == -1 && !tecla_especial){
		 
				        return false;
				      }
 
		}
	}
}

function formatoNumeroDocumento(){
		var tipoDocumento = $('#codigoTipoDocumento').val();
//		alert(tipoDocumento)
		if(tipoDocumento==1){
//	   		alert(tipoDocumento)
			$("#numeroDocumentoPersona").val('');
			$("#numeroDocumentoPersona").attr("pattern","[0-9]{8}");
			//$("#numeroDocumentoPersona").val("");
		}
		if(tipoDocumento==2){
			$("#numeroDocumentoPersona").val('');
			$("#numeroDocumentoPersona").attr("pattern","[a-zA-Z]{5,12}");
			//$("#numeroDocumentoPersona").val("");
		}
		if(tipoDocumento==3){
			$("#numeroDocumentoPersona").val('');
			 $("#numeroDocumentoPersona").removeAttr("pattern");
			 //$("#numeroDocumentoPersona").val("");
		}

	}
</script>