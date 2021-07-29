

function buscarProvincia(){

	var codDep = $("#provinciaSelect").val();
	var codPro = "";
	buscarProvinciaXCodigos(codDep,codPro);
	
}






	function buscarDistrito(){
		
		var codDep = $("#provinciaSelect").val();
		var codPro=$("#comboprovincia").val();
		var codDis=$("#combodistrito").val();
		buscarDistritoXCodigos(codDep,codPro,codDis);
	}
	
	
	
	
	
	
	
	
	


	function buscarProvinciaXCodigos(codDep,codPro){
//		 alert("hoa");
//			  var numero =document.getElementById("lblInstitu").value;
			var id = codDep;
			var urlubigeo = $("#urlubigeo").val();
			//console.log(urlubigeo);
//			for(var f=0;f<document.getElementById("comboprovincia").length;f++){
//				if (document.getElementById("comboprovincia").length > 0) {

//					document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
//			    }

//				}
			document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").innerHTML=""];
			document.getElementById("combodistrito").options[document.getElementById("combodistrito").innerHTML=""];
			document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").options.length]=new Option("Seleccionar", "00");
			document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option("Seleccionar", "00");
		$.ajax({
			type : "GET",

			url : "../baseController/buscarProvincia?codigodepartamento="+id,
//				data : {codigoinst:numero},

			success : function(data) {
				//console.log("SUCCESS: ", data);


				for(var i=0; i<data.length;i++){
					document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);

					}
				
				
	//
			},
			error : function() {
				//console.log("ERROR: ");
			},
			complete : function(){
				
				if(codPro!=null && codPro!=""){
					$("#comboprovincia").val(codPro);
				}else{
				
					$("#comboprovincia").val("00");
				}
			
			}
			
		});

	}




	function buscarDistritoXCodigos(codDep,codPro,codDis){
//		 alert("hoa");
//			  var numero =document.getElementById("lblInstitu").value;
			var id = codDep;
			var id2=codPro;
			document.getElementById("combodistrito").options[document.getElementById("combodistrito").innerHTML=""];
			document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option("Seleccionar", "00");
		$.ajax({
			type : "GET",
	///baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
			url : "../baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
//				data : {codigoinst:numero},

			success : function(data) {
				//console.log("SUCCESS: ", data);
//				$('#provincia').html(data);
//				alert(data[1].codigo);
//				document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";

//				for(var f=0;f<document.getElementById("combodistrito").length;f++){
//					if (document.getElementById("combodistrito").length > 0) {
//						document.getElementById("combodistrito").remove(document.getElementById("combodistrito").length-1);
//				    }

//					}


				for(var i=0; i<data.length;i++){

					document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);

					}

			},
			error : function() {
				//console.log("ERROR: ");
			},
			complete : function() {
				
				if(codDis!=null && codDis!=""){
					$("#combodistrito").val(codDis);
				}
			
			}
		});

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//
//function buscarProvinciaXCodigos(codDep,codPro){
////	 alert("hoa");
////		  var numero =document.getElementById("lblInstitu").value;
//		var id = $("#provinciaSelect").val();
//		var urlubigeo = $("#urlubigeo").val();
//		console.log(urlubigeo);
////		for(var f=0;f<document.getElementById("comboprovincia").length;f++){
////			if (document.getElementById("comboprovincia").length > 0) {
//
////				document.getElementById("comboprovincia").remove(document.getElementById("comboprovincia").length-1);
////		    }
//
////			}
//		document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").innerHTML=""];
//		document.getElementById("combodistrito").options[document.getElementById("combodistrito").innerHTML=""];
//		document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").options.length]=new Option("Seleccionar", "00");
//		document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option("Seleccionar", "00");
//	$.ajax({
//		type : "GET",
//
//		url : "../baseController/buscarProvincia?codigodepartamento="+id,
////			data : {codigoinst:numero},
//
//		success : function(data) {
//			console.log("SUCCESS: ", data);
////			$('#provincia').html(data);
////			alert(data[1].codigo);
////			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";
//
//
//
//			for(var i=0; i<data.length;i++){
//				document.getElementById("comboprovincia").options[document.getElementById("comboprovincia").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoProvincia);
//
//				}
//
//			
////
//		},
//		error : function() {
//			console.log("ERROR: ");
//		}
//	});
//
//}
//
//
//
//
//function buscarDistritoXCodigos(codDep,codPro,codDis){
////	 alert("hoa");
////		  var numero =document.getElementById("lblInstitu").value;
//		var id = $("#provinciaSelect").val();
//		var id2=$("#comboprovincia").val();
//		document.getElementById("combodistrito").options[document.getElementById("combodistrito").innerHTML=""];
//		document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option("Seleccionar", "00");
//	$.ajax({
//		type : "GET",
/////baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
//		url : "../baseController/buscarDistrito?codigodepartamento="+id+"&"+"codigoprovincia="+id2,
////			data : {codigoinst:numero},
//
//		success : function(data) {
//			console.log("SUCCESS: ", data);
////			$('#provincia').html(data);
////			alert(data[1].codigo);
////			document.getElementById("provincia").innerHTML = "<select path='ubigeoBean.codigoProvincia' class='form-control'> <options itemValue='00' itemLabel='dsdsadasdsa'/> </select>";
//
////			for(var f=0;f<document.getElementById("combodistrito").length;f++){
////				if (document.getElementById("combodistrito").length > 0) {
////					document.getElementById("combodistrito").remove(document.getElementById("combodistrito").length-1);
////			    }
//
////				}
//
//
//			for(var i=0; i<data.length;i++){
//
//				document.getElementById("combodistrito").options[document.getElementById("combodistrito").options.length]=new Option(data[i].nombreUbigeo, data[i].codigoDistrito);
//
//				}
//
//		},
//		error : function() {
//			console.log("ERROR: ");
//		}
//	});
//
//}
//
// 
