/**
 * 
 */
 
	 mostrarTablaInstituto();
 
	var listadoInstitucion = [];
	var contextPath = $('#contextPath').val();
	var tipoItem = "";
	var itemNacionalidad = '';
	 
	 $( document ).ready(function() {
		
	 
			$(".optionReset").val("");
			
			if(document.getElementById("listadoInstitutoVo") != undefined){
			  
			  
				listadoInstitutoBeanVo = document.getElementById("listadoInstitutoVo").value; 
				var cadenaNacionalidadBean = listadoInstitutoBeanVo.substring(1, listadoInstitutoBeanVo.length-1);
				var listadoNacionalidadTemp = cadenaNacionalidadBean.split(",");
			    if(listadoNacionalidadTemp != null && listadoNacionalidadTemp.length > 0){
				  for(var i = 0; i < listadoNacionalidadTemp.length; i=i+2){
					  if(listadoNacionalidadTemp[i] != undefined && listadoNacionalidadTemp[i+1] != undefined ){
						  listadoInstitucion.push([listadoNacionalidadTemp[i].trim(),listadoNacionalidadTemp[i+1].trim()]);
					  }
				  }
			    }
			    
			}
		    mostrarTablaInstituto();  
 
		  	$("#frmRegistroDocente").submit(function( event ) {
			  event.preventDefault();
			});

		  	if(document.getElementById("codigoDocente") != undefined){
		  		var codigo = document.getElementById("codigoDocente").value;
				if (codigo != '0') {
					 $('#limpiar').attr("disabled", true);
				} 
		  	}
			

		});
	 
	 
	function mostrarTablaInstituto(){
		 
		$('#idlistadoInstitucion').empty();
		htmlTablaIntitucion = "";
		if(listadoInstitucion!=null && listadoInstitucion.length>0){
    		for (var i = 0; i < listadoInstitucion.length; i++) {
	    		var prmNacionalidad = listadoInstitucion[i];
	    		htmlTablaIntitucion +=
	    			"<tr>"+
	    			"<td>"+(i+1)+"</td>"+
	    			"<td>"+prmNacionalidad[1]+"</td>"+
	        		"<td>"+
	    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarInstitucion('"+prmNacionalidad+"');\"><i class='icon-trash'></i></button>"+
	        		"</td>"+
	    		"</tr>";
	    		//$('#idlistadoInstitucion').html(htmlTablaIntitucion);
			}
	    	$('#idlistadoInstitucion').html(htmlTablaIntitucion);
		}else{
	    	$('#idlistadoInstitucion').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");
		}
	}
	
function agregarInstitucion(){ 
	 
		var codigoInstitucion = $('#lblInstitu').val(); 
		if(codigoInstitucion != "0"){
			var comboInstitucion = document.getElementById("lblInstitu"); 
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
			refrescarInstitucion();
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
		    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarInstitucion('"+prmInstitucion+"');\"><i class='icon-trash'></i></button>"+
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
	//codigo para remorver el item
	Array.prototype.removeItem = function (a) {
	 
		 for (var i = 0; i < this.length; i++) {
		  if (this[i] == a) {
		   for (var i2 = i; i2 < this.length - 1; i2++) {
		    this[i2] = this[i2 + 1];
		   }
		   this.length = this.length - 1;
		   return;
		  }
		 }
		};

		function eliminarInstitucion(item){
		 
			itemInstitucion = item;
			tipoItem = "nacionalidad";
		//	alert("tipoItem " + tipoItem);
	        $('#md_confirmacion').modal('show');
		}

	     $( "#btnConfirmarGeneric" ).click(function() {
			 if(tipoItem == 'nacionalidad'){
				 eliminarModalInstitucion();
				  $('#md_confirmacion').modal('hide');
			 } 
		}); 
	    
		function eliminarModalInstitucion(){ 
		 
			listadoInstitucion.removeItem(itemInstitucion); 
			refrescarInstitucion();
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
		    				"<button type='button' title='Eliminar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-danger btn-sm' onclick=\"eliminarInstitucion('"+prmInstitucion+"');\"><i class='icon-trash'></i></button>"+
		        		"</td>"+
		    		"</tr>";
				}
				$('#idlistadoInstitucion').html(htmlTablaIntitucion);
			}else{
			  	$('#idlistadoInstitucion').html("<tr><td colspan='3'><center>Sin registros para mostrar</center></td></tr>");
		    	
			}
		
		}
		
		function refrescarInstitucion(){
			 
			$.ajax({
				type : "GET",

				url : contextPath+"/docenteController/refrescarInstitucion?listadoInstitucion="+listadoInstitucion,
 

				success : function(data) {
					//console.log("SUCCESS: ", data); 
				},
				error : function() {
					//console.log("ERROR: ");
				}
			});
		}