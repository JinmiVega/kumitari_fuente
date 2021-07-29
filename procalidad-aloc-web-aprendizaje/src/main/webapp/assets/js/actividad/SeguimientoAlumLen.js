var codlenguaEncrypt   = $('#codlenguaValEncrypt').val();
var codlenestEncrypt   = $('#codlenestTreeValEncrypt').val();
var codunidadEncrypt   = $('#codlenuniTreeValEncrypt').val();
var codleccionEncrypt  = $('#codleccionValEncrypt').val();

var contextPath = $('#contextPathUrl').val();
 var lecciones=[]; 
 var p_codundlec   = 0;
 var	dir=0;
// var urlcont = context+'/lengua/detalle/'+codlengua+'/nivel/'+codlenest+'/unidad/'+codunidad+'/leccion/'+codleccion;
// var urleval = context+'/lengua/detalle/'+codlengua+'/nivel/'+codlenest;
 var urlcont = context+'/lengua/detalle/'+codlenguaEncrypt+'/nivel/'+codlenestEncrypt+'/unidad/'+codunidadEncrypt+'/leccion/'+codleccionEncrypt;
 var urleval = context+'/lengua/detalle/'+codlenguaEncrypt+'/nivel/'+codlenestEncrypt;
	
 
  function InsertarSiguienteLeccion()
  {   
	  var leccion = $("#codleccionVal").val(); 
	  var p_codusumat      = $("#codusuariomat").val(); 
	  if(p_codusumat!='' && p_codusumat!=0 && p_codusumat!=null && p_codusumat!=undefined){
		  
		  
		  if (leccion ==  lecciones[lecciones.length - 1] ) {
			  insertarMedallaAlumno(4); 
		}else if(leccion==$("#ultimaleccionxlenest").val()){
			insertarMedallaAlumno(3); 
		}else if(leccion==$("#ultimaleccionxunidad").val()){
			insertarBonoAlumno();	
			insertarMedallaAlumno(2); 
		}else if($("#codEvaluacion").val()>0){
			//if($("#codEvaluacion").val()!='' || $("#codEvaluacion").val()!='undefined' || $("#codEvaluacion").val()!=0){
			return;
		} else  {
			insertarMedallaAlumno(1); 
		}
		  
		    
	  for (var i = 0; i < lecciones.length; i++) { 
	  if(leccion == lecciones[i]){
		  dato=i+1;
		  p_codundlec=lecciones[dato]; 
	  	} 
	   } 
	  
	  if (leccion ==  lecciones[lecciones.length - 1] ) { 
		  	  
		  insertarEvaluacion(); 
		  
	}else{ let url = contextPath + "/lengua/agregarSiguienteLeccion";   
    $.ajax({
   	 	async: true,
        type :  "POST",
        url  :  url,
        data : { 
      	  		p_codundlec        :  p_codundlec,
      	  		p_codusumat        :  p_codusumat ,
      	  		p_codundlecAct     :  leccion},
          success : function(data)
            {    
             		location.href = urlcont;
            },
            error : function()
            { location.href = urlcont; 
          //console.log("ERROR: ");
            }
    });
    } 
      
	  }else{
		  location.href = urlcont;
//		  console.log("no es alumno");
	  }
  } //codlenestTreeVal            codleccionVal
  
   
  function listarleccionesxnivel(){ 
		 
		 var p_codlen =  $('#codlenguaVal').val();  
		// var p_tm2niv =  $('#lenguanivel').val(); 
		 var p_tm2SubNivel = $('#codSubNivel').val();
		 
		 var p_codusumat      = $("#codusuariomat").val(); 
		 var url =  contextPath+"/lengua/listarLeccionesXlengNiv"; 
		 
		 
		 if(p_codusumat!='' && p_codusumat!=0 && p_codusumat!=null && p_codusumat!=undefined){
		    $.ajax({
		    	async: true,
		        type : 'POST',
		        data :{p_codlengua:p_codlen,p_tm2SubNivel:p_tm2SubNivel},
		        url : url,
		      success : function(data)
		      {     lecciones=[];
		    	  if(data) { 
		    		  for(var i=0; i<data.length; i++) {
		    			  lecciones.push(data[i].codigo); 
		    		  } 
		    	  } 
		    	  
		    	  if(lecciones.length>0){ 
		    		  InsertarSiguienteLeccion();
		    	  } 
			      },
			      error: function(data) {
			    	  location.href = urlcont;
			    	//console.log("error ");
					      }
			    });
		 }
		 else{
			  location.href = urlcont;
//			  console.log("no es alumno");
		  }  
		 }  
  
     function insertarEvaluacion(){
    	 var p_codlengua =  $('#codlenguaVal').val();  
    	 var leccion = $("#codleccionVal").val(); 
//    	 var p_tm2nivel =  $('#lenguanivel').val();
    	 var p_codusumat      = $("#codusuariomat").val(); 
    	 var p_tm2SubNivel = $('#codSubNivel').val();
    	 var p_codnivel = $('#lenguanivel').val();
    	 
    	 let url = contextPath + "/lengua/insertarEvaluacion";  
         $.ajax({
        	 async: true,
             type :  "POST",
             url  :  url,
             data : { 
            	 p_codlengua        :  p_codlengua,
            	 p_tm2SubNivel        	:  p_tm2SubNivel ,
            	 p_codundlec        :  leccion,
            	 p_codusumat     	:  p_codusumat,
            	 p_codnivel 	    : p_codnivel},
               success : function(data){   
            	 
            		   location.href = urlcont;
            	    
                 },
                 error : function()
                 {
                  location.href = urlcont;
                //console.log("ERROR: ");
                 }
         }); 
     }