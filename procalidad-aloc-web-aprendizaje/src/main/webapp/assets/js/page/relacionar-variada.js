$("#lst-preg li").draggable({
  helper:'clone'
});

$("#lst-respRV li").droppable({
  drop:eventoDrop
});

function eventoDrop(evento, ui){
//  debugger;
  var draggable = ui.draggable;
  var tempData = draggable.data('preg');
  var tempRsp = $(this).data('rsp');

     // $(this).children(".rspt").html(draggable.text());
     //  draggable.draggable("disable").css({
     //    'cursor': 'normal',
     //    'opacity': '.3'
     //  });
  if(tempData == tempRsp){
      envetoPuntos("c"); 
     $(this).css({'border-color': 'green'});
     $(this).children(".rspt").html(draggable.text()); 
      draggable.draggable("disable").css({
        'cursor': 'default',
        'opacity': '.3'
      });
     }else{
     // $(this).addClass('active-txt-orafail');  
      show_msj_masc_fallo('Que pena, no es correcto. Vuelve a intentarlo, tú puedes.');
      insertarIntento();
      
     }
}

  var punto=0;
 function envetoPuntos(val){
    if(val=="c"){
       punto++;
       }//else{
        if(punto==tamanoPReg.length){
        show_msj_masc_exito('Muy bien, has respondido correctamente. Puedes continuar.');
        $("#btnevaluar").removeClass("disabled");
      
       }
     //  punto-1;
      // }

//  alert(punto);

   //alert(punto);

  }