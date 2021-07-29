 var contextPath = $('#contextPathUrl').val();
 var numerodeintento  = 1;
 var codigoSegIntento = 0;
 var tabid =0;
 
 
  
 function BuscarIntentosRealizados(){  
	  	 var usumat 	= $("#codusuariomat").val(); 
	  	 var tipoejerc  = 0;  
	  	if(usumat!='' && usumat!=0 && usumat!=null){ 
	  		
	  		if($("#codTipoEjer").val()!=2)
	  		 {  
	  			var url =  contextPath+"/lengua/BuscarintentosRealizadosPorejercicio"; 
		    $.ajax({
		    	async: true,
		        type : 'POST',
		        data :{matejercicio : codmatipej_actual , usuariomatricula : usumat },
		        url : url,
		      success : function(data) 
		      {    
 
		    	  if (data.codigo > 0 ) {
		    		  numerodeintento=data.numeroIntento ;
		    		  codigoSegIntento=data.codigo;
//		    		  console.log("Intentos = "+ numerodeintento);
		    			 
		    	  }else{
		    		  codigoSegIntento = 0;
		    		  insertarIntento();
//		    		  console.log("Se insertó primer intento");
					}
		    	  
			      },
			      error : function(data) {
			    	//console.log("error ");
			      } 
			    });
	  		 }else
	  			 {   
	  			codpregun  = $('#tab_'+tabid).attr('data-id'); 
	  			if(codpregun!=null && codpregun!=0 && codpregun!=undefined && codpregun!=''){ 
	  				codpregun=codpregun;
	  				 
	  			}else{ 
	  				codpregun  = $('#tab_0').attr('data-id'); 
	  			}
	  	 
	  			 var url =  contextPath+"/lengua/BuscarintentosRealizadosPorejerDet"; 
	  			    $.ajax({
	  			    	async: true,
	  			        type : 'POST',
	  			        data :{matejercicio : codmatipej_actual , usuariomatricula : usumat , codpregun:codpregun},
	  			        url : url,
	  			      success : function(data) 
	  			      {    
	  	 
	  			    	  if (data.codigo > 0 ) {
	  			    		 
	  			    		  numerodeintento=data.numeroIntento ;
	  			    		  codigoSegIntento=data.codigo;
//	  			    		  console.log("Intentos = "+ numerodeintento);
	  			    			 
	  			    	  }else{ 
	  			    		  codigoSegIntento = 0;
	  			    		  insertarIntento();
//	  			    		  console.log("Se insertó primer intento");
	  						}
	  			    	  
	  				      },
	  				      error : function(data) {
	  				    	//console.log("error ");
	  				      } 
	  				    });
	  		  		 }  
	  	}else{
	  		 
//	    	console.log("No es alumno");
	    }
		 
 }
 
	 function insertarIntento()
	 {      
	 
   var p_codusumat      = $("#codusuariomat").val();  
   if(p_codusumat!='' && p_codusumat!=0 && p_codusumat!=null){
 
	   if($("#codTipoEjer").val()!=2)
		 { 
		   var p_codmatpej  = $("#codigoMTE").val();
   let url = contextPath + "/lengua/InsertarIntentoAlumnoEjercicio";  

     $.ajax({
    	 async: true,
         type :  "POST",
         url  :  url,
         data : {   p_codmatpej    	   :  p_codmatpej ,
        			p_codsegaluinten   :  codigoSegIntento,
        			p_codusumat        :  p_codusumat 
                   },
           success : function(data)
             { 
           	if(codigoSegIntento>0 ){ 
           		BuscarIntentosRealizados();
//             	console.log("Se actualizó intento");
            
               
           	}else{
           		BuscarIntentosRealizados();
//           		console.log("se insertó intento");
           	}
               
               
             },
             error : function()
             {
//               alert("No se pudo ingresar el registro");
            	//console.log("ERROR: ");
             }
     }); 
		 }else{ 
			 var p_codmatpej  = $("#codigoMTE").val();
			 var p_codpregun      = 0;  
			 p_codpregun  = $('#tab_'+tabid).attr('data-id');  

			   let url = contextPath + "/lengua/InsertarIntentoAlumnoEjercicioDet";  
			   /*console.log({   p_codmatpej    	   :  p_codmatpej ,
       			p_codsegaluinten   :  codigoSegIntento,
    			p_codusumat        :  p_codusumat ,
    			p_codpregun:p_codpregun
               });*/
			   
			     $.ajax({
			    	 async: true,
			         type :  "POST",
			         url  :  url,
			         data : {   p_codmatpej    	   :  p_codmatpej ,
			        			p_codsegaluinten   :  codigoSegIntento,
			        			p_codusumat        :  p_codusumat ,
			        			p_codpregun:p_codpregun
			                   },
			           success : function(data)
			             {  
			           	if(codigoSegIntento>0 ){ 
			           		BuscarIntentosRealizados();
//			             	console.log("Se actualizó intento");
			            
			               
			           	}else{
			           		 
			           		BuscarIntentosRealizados();
//			           		console.log("se insertó intento");
			           	}
			               
			               
			             },
			             error : function()
			             {
//			               alert("No se pudo ingresar el registro");
			            	//console.log("ERROR: ");
			             }
			     }); 
					 }
     
      
     
   }else{
	 //console.log("no es alumno");
   }
 }
 
 
 
  function monedaGemaObtenidas(){  
	  var p_id = $("#codusuariomat").val();
	  if(p_id!=null && p_id>0){
		  	var url  =  contextPath+"/lengua/MonedasYGemasObtenidas?usuariomatricula="+p_id
		    $.ajax({
		    	 async: true,
		        url : url,
		        type : 'GET',
		        success : function(data) {          
		            if (data != null) { 
		            $("#codAluMoneG").val(data.codigo);
		              if(data.numeroMonedas!=null){
		                $('#monedasDisponibles').html(data.numeroMonedas);
		                $('#monedasUsuario').val(data.numeroMonedas);
		              }else{
		                $('#monedasDisponibles').html(0);
		                $('#monedasUsuario').val(0);
		              }
		              
		              

		              if(data.numeroGemas!=null){
		                $('#gemasDisponibles').html(data.numeroGemas);
		                $('#gemasUsuario').val(data.numeroGemas);
		              }else{
		                $('#gemasDisponibles').html(0);
		                $('#gemasUsuario').val(0);
		              }
		            }else{
//		            	console.log("no hay registro");
		            }     
		        },
		        error : function(request, status, error) {
//		          alert("error");
		        }
		    }); 
	  }else{
//		  console.log("No es alumno");
	  }
  }
  
  
  function guardarMonedas(monedas,gemas)
  {  
    var p_codalumxmoge   = $("#codAluMoneG").val();  
    var p_codusumat      = $("#codusuariomat").val(); 
    var p_codmatpej      = $("#codigoMTE").val(); 
    if(p_codusumat!='' && p_codusumat!=0){
    if(p_codalumxmoge==null || p_codalumxmoge=='' ){
      p_codalumxmoge=0;
    } 
    

    let url = contextPath + "/lengua/agregarrMonedasGemas";  

      $.ajax({
     	 async: true,
          type :  "POST",
          url  :  url,
          data : { p_codaluxmongem    :  p_codalumxmoge,
                   p_cantgemas        :  gemas,
                   p_codmatpej        :  p_codmatpej,
                   p_codusumat        :  p_codusumat, 
                   p_cantmonedas      :  monedas },
            success : function(data)
              { 
            	if(p_codusumat!=0 && p_codusumat!=null && p_codusumat!=''){
            	
            	if(data==1){
//               	alert("Se insertó moneda");
              }else{
//             	  alert("Ya se registro moneda anteriormente");
              }
                monedaGemaObtenidas(); 
                
                
            	}else{
//            		console.log("no es alumno");
            	}
                
                
              },
              error : function()
              {
 
            	//console.log("ERROR: ");
              }
      }); 
    }else{
//    	console.log("no es alumno");
    }
  }
  
  
  
  function guardarMonedasYgemasXcategoria(monedas,gemas)
  {  
    var p_codalumxmoge   = $("#codAluMoneG").val();  
    var p_codusumat      = $("#codusuariomat").val(); 
    
    if(p_codusumat!='' && p_codusumat!=0){
    if(p_codalumxmoge==null || p_codalumxmoge=='' ){
      p_codalumxmoge=0;
    } 
    

    let url = contextPath + "/lengua/agregarrMonedasGemas";  

      $.ajax({
     	 async: true,
          type :  "POST",
          url  :  url,
          data : { p_codaluxmongem    :  p_codalumxmoge,
                   p_cantgemas        :  gemas,
                   p_codmatpej        :  1,
                   p_codusumat        :  p_codusumat, 
                   p_cantmonedas      :  monedas },
            success : function(data)
              { 
            	if(p_codusumat!=0 && p_codusumat!=null && p_codusumat!=''){
            	
            	if(data==1){ 
              }else{
             	  
              }
                monedaGemaObtenidas(); 
                
                
            	}else{
//            		console.log("no es alumno");
            	}
                
                
              },
              error : function()
              {
//                alert("No se pudo ingresar el registro");
            	//console.log("ERROR: ");
              }
      }); 
    }else{
//    	console.log("no es alumno");
    }
  }
  
 
  
  
  function grabarSeguimientoAlumnoEjercicio(nroModena){
	 
 
		var p_tipoEjercicio = $('#codigoMTE').val();
		var p_codLengua = $('#codlenguaVal').val();
		var p_codUsuario = $('#codusuariomat').val();
		if(p_codUsuario!=0 && p_codUsuario!=''){
		var url = contextPath+"/lengua/grabarSeguimientoAlumnoEjercicio";
	$.ajax({
   	 		async: true,
			type 	: "POST",
			data 	: { idEjercicio:p_tipoEjercicio,
						numeroMonedas : nroModena,
						idLengua:p_codLengua,
						idUsuario : p_codUsuario},
			url 	: url,
			success : function(data)
			{
				if (data != 0) {
//					 console.log("Se inserto seguimiento");
				}
				else
				{
//					console.log("No se inserto seguimiento");
			}
			},
			error : function()
			{
				//console.log("ERROR: ");
			}
		});
		}else
			{
//			console.log("No es alumno");
			}
	}
  
  
  
  function grabarSeguimientoAlumnoEjerPreg(nroModena){
	 
	  		var p_tipoEjercicio = $('#codigoMTE').val();
	  		var p_codLengua = $('#codlenguaVal').val();
	  		var p_codUsuario = $('#codusuariomat').val();
	  		var codpregunta= $('#tab_'+tabid).attr('data-id');
	  	  
	  		if(p_codUsuario!=0 && p_codUsuario!=''){
	  		var url = contextPath+"/lengua/grabarSeguimientoAlumnoEjerDet";
	  
	  	
	  		
	  		$.ajax({
	  			async: true,
	  			type 	: "POST",
	  			data 	: { idEjercicio:p_tipoEjercicio,
	  						codpregunta:codpregunta,
	  						numeroMonedas : nroModena,
	  						idLengua:p_codLengua,
	  						idUsuario : p_codUsuario},
	  			url 	: url,
	  			success : function(data)
	  			{
	  				if (data != 0) {
//	  					 console.log("Se inserto seguimiento");
	  				}
	  				else
	  				{
//	  					console.log("No se inserto seguimiento");
	  			}
	  			},
	  			error : function()
	  			{
	  			//console.log("ERROR: ");
	  			}
	  		});
	  		}else
	  			{
//	  			console.log("No es alumno");
	  			}
	  	}
  
  
  
  