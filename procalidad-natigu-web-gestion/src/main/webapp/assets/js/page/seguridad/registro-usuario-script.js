function seleccionarPersonaUsuario(){
	$('#idUlContentTab #base-tab12').trigger("click");
	$('#idUlContentTab .nav-item .nav-link').removeClass("active");
	$('#idUlContentTab #base-tab12').css("display","block");
	$('#idUlContentTab #base-tab12').addClass("active");
}

function limpiarDatoPersonaBusqueda(){
    $('#formularioPersona').find('input').each(function() {
      switch(this.type) {
         //case 'password':
         case 'text':
        	 $(this).val('');
             break;
         case 'hidden':
              $(this).val(0);
              break;
         //case 'checkbox':
         //case 'radio':
           //   this.checked = false;
      }
    });
 
    $('#formularioPersona #tipoDocumento').val(1);
    $('#idUlContentTab #base-tab12').css("display","none");
}