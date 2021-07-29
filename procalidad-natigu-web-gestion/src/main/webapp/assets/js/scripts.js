  function msg_exito(){
  	toastr.success('&Eacute;xito al ejecutar proceso', '&Eacute;xito', {"progressBar": true,"preventDuplicates": true});
  }
  function msg_error() {
  	toastr.error('Error al ejecutar proceso', 'Error', {"progressBar": true,"preventDuplicates": true});
  }
  function msg_info(mensaje) {
  	toastr.info(mensaje, 'Informaci&oacute;n', {"progressBar": true,"preventDuplicates": true});
  }
  function msg_advertencia(mensaje) {
  	toastr.warning(mensaje, 'Advertencia', {"progressBar": true,"preventDuplicates": true});
  }

  function iniciarBloqueo(){
	  $.blockUI({
        message: '<div class="ft-refresh-cw icon-spin font-medium-2"></div>',
        fadeIn: 1000,
        overlayCSS: {
            backgroundColor: '#FFF',
            opacity: 0.8,
            cursor: 'wait'
        },
        css: {
            border: 0,
            padding: 0,
            color: '#333',
            backgroundColor: 'transparent'
        }
      });
  }
  
  function finBloqueo(){
	  $.unblockUI();
  }
  
  function nameImage(input, container){	  
	  $('#'+input).trigger('click');
	  $('input[id='+input+']').change(function() {
	  console.log($(this).val());
	      var mainValue = $(this).val();
	      if(mainValue == ""){
	    	  $('#'+container).hide().html('');
	      }else{
	    	  $('#'+container).show().html(mainValue.replace("C:\\fakepath\\", ""));
	      }
	  });	  
  }
  
  function destroyDataTable(valor){
	  var table = $(valor).DataTable();
  	  table.destroy();
  }
  
  function initDataTable(valor){
	  $(valor).DataTable({
	        language:{
	            "sProcessing":     "Procesando...",
	            "sLengthMenu":     "Mostrar _MENU_ registros",
	            "sZeroRecords":    "No se encontraron resultados",
	            "sEmptyTable":     "Sin registros para mostrar",
//	            "sInfo":           "Página _START_ de _END_ de (_TOTAL_ registros)",
	            "sInfo":           "Página _PAGE_ de _PAGES_ de (_TOTAL_ registros)",
	            "sInfoEmpty":      "Página 0 de 0  (0 registros)",
	            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	            "sInfoPostFix":    "",
	            "sSearch":         "Buscar:",
	            "sUrl":            "",
	            "sInfoThousands":  ",",
	            "sLoadingRecords": "Cargando...",
	            "oPaginate": {
	                "sFirst":    "Primero",
	                "sLast":     "Último",
	                "sNext":     ">",
	                "sPrevious": "<"
	            },
	            "oAria": {
	                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	            }
	        }
	  });
  }


  	

	  
