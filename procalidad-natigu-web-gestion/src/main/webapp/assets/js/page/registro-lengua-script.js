$('#input-11').on('ifChecked', function(event){
  $("#cl_B").show(300);
});
$('#input-11').on('ifUnchecked', function(event){
  $("#cl_B").hide(300);
  $('#cl_B input').iCheck('uncheck');
});

$('#input-12').on('ifChecked', function(event){
  $("#cl_I").show(300);
});
$('#input-12').on('ifUnchecked', function(event){
  $("#cl_I").hide(300);
  $('#cl_I input').iCheck('uncheck');
});

$('#input-13').on('ifChecked', function(event){
  $("#cl_A").show(300);
});
$('#input-13').on('ifUnchecked', function(event){
  $("#cl_A").hide(300);
  $('#cl_A input').iCheck('uncheck');
});

