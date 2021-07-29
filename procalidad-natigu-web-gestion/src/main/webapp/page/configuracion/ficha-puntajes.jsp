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
    <title>Ficha de puntajes</title>
    <link rel="apple-touch-icon" href="../app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/custom.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/checkboxes-radios.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
<script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">



    $('#custom7').on('change', function(){
   this.value = this.checked ? 1 : 0;
 //alert(this.value);
}).change();


     function deshabilitar(){
            $("#btn-save-reg").hide();
            $("#btnmodi").show();
            // var valor1 = $("#btn-save-reg");
            // var valor2 = $("btnmodi");
            // valor1.disabled=true;
            // valor2.disabled=false;
             // $('#btn-save-reg').css("cursor", "default");
             $("#idTablaPremio td .icheckbox_square-red input[type='checkbox']").prop({disabled: true});
             $("#idTablaPremio td .iCheck-helper").css("cursor","not-allowed");



            for(var i=0;i<$('#idTablaPremio >tr').length;i++){
            	  document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[5].getElementsByTagName('input')[0].disabled=true;
              document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[6].getElementsByTagName('input')[0].disabled=true;
              document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[7].getElementsByTagName('input')[0].disabled=true;
            // document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].disabled=true;
            // document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].disabled=true;
            // document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[2].getElementsByTagName('input')[0].disabled=true;


            }
          }

          function habilitar(){
            $("#btn-save-reg").show();
            $("#btnmodi").hide();
            $("#idTablaPremio td .icheckbox_square-red input[type='checkbox']").prop({disabled: false});
            $("#idTablaPremio td .iCheck-helper").css("cursor","pointer");

            // var valor2 = document.getElementById("btn-save-reg");
            // var valor3 = document.getElementById("btnmodi");
            // valor2.disabled=false;
            // valor3.disabled=true;
            // $('#btnmodi').css("cursor", "default");

              for(var i=0;i<$('#idTablaPremio >tr').length;i++){
             document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[7].getElementsByTagName('input')[0].disabled=false;
              document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[6].getElementsByTagName('input')[0].disabled=false;
           //  document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].disabled=false;
           //  document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].disabled=false;
           //  document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[2].getElementsByTagName('input')[0].disabled=false;
            }

          }




    function actualizarPremio(codigo,basico,honorifico,premium,monedas,gemas){

// 	console.log({codigo,basico,honorifico,premium,monedas,gemas})
    var pathUrl = "${pageContext.request.contextPath}/fichaPuntajeController/actualizar?p_codconfp="+codigo+"&p_flgbas="+basico+"&p_flghom="+honorifico+"&p_flgprem="+premium+"&p_cntmone="+monedas+"&p_cntgema="+gemas;
    var html = "";

    $.ajax({
        type : "POST",
        url : pathUrl,
//        data : {codigoinst:numero},

        success : function(data) {




          //console.log("SUCCESS: ", data);

        },
        error : function() {
          //console.log("ERROR: ");
        }
      });
    }


        function prueba(){

            var codigo=0;
            var basico="";
            var honorifico="";
            var premium="";
            var monedas=0;
            var gemas =0;


          for(var i=0;i<$('#idTablaPremio >tr').length;i++){


       /*  alert(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[5].getElementsByTagName('input').innerHTML);*/
      /* alert(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[5].getElementsByTagName('input')[0].value);*/
       /* alert(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].checked);*/


      /*  if(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[4].getElementsByTagName('input').cheked==true){
          alert("True");

        }else{
          alert("False");
        }*/

      //  document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].getElementsByTagName('center')[0].innerHTML
        codigo  = document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].getElementsByTagName('center')[0].innerHTML;
      //  console.log(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].checked);
        if(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].checked==true){
            basico   ="1";

        }else{
           basico   ="0";
        }
       
           



            if(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[4].getElementsByTagName('input')[0].checked==true){
                honorifico   ="1";

            }else{
               honorifico   ="0";
            }

            if(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[5].getElementsByTagName('input')[0].checked==true){
            premium    ="1";

            }else{
               premium   ="0";
            }

            monedas    = document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[6].getElementsByTagName('input')[0].value;
            gemas      = document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[7].getElementsByTagName('input')[0].value;
            
//             console.log(document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[7].getElementsByTagName('input')[0].value);

			if(monedas == ""){
				document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[6].getElementsByTagName('input')[0].value = 0;
				monedas = 0;
			}
			
			if(gemas == ""){
				document.getElementById("idTablaPremio").getElementsByTagName('tr')[i].getElementsByTagName('td')[7].getElementsByTagName('input')[0].value = 0;
				gemas = 0;
			}

            actualizarPremio(codigo,basico,honorifico,premium,monedas,gemas);

            deshabilitar();

          }
           msg_exito();


        /*alert(document.getElementById("idTablaPremio").tBodies[1].rows[1].cells[1].innerHTML);
        alert(document.getElementById("1").length);*/

          /*alert(" filas "+ $('#1 >tbody >tr').length);*/
       /*   alert(" filas "+ $('#idTablaPremio >tr').length);
            alert(document.getElementById("prueba1").innerHTML);*/

        }











 function deshabilitar2(){
            $("#btn-save-reg2").hide();
            $("#btnmodi2").show();


            for(var i=0;i<$('#idTablaIntento >tr').length;i++){
              document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].disabled=true;
              document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[1].disabled=true;
               document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[2].disabled=true;



            }
          }

          function habilitar2(){
            $("#btn-save-reg2").show();
            $("#btnmodi2").hide();



              for(var i=0;i<$('#idTablaIntento >tr').length;i++){
             document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].disabled=false;
              document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[1].disabled=false;
              document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[2].disabled=false;

            }

          }




    function actualizarIntento(codigo,i1,i2,i3){


    var pathUrl = "${pageContext.request.contextPath}/fichaPuntajeController/actualizar2?p_codconf="+codigo+"&p_int1="+i1+"&p_int2="+i2+"&p_int3="+i3;
    var html = "";

    $.ajax({
        type : "POST",
        url : pathUrl,
//        data : {codigoinst:numero},

        success : function(data) {




          //console.log("SUCCESS: ", data);

        },
        error : function() {
          //console.log("ERROR: ");
        }
      });
    }


        function prueba2(){

            var codigo=0;
            var i1=0;
            var i2 =0;
            var i3 =0;


          for(var i=0;i<$('#idTablaIntento >tr').length;i++){

            codigo  = document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;


            i1    = document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].value;
            i2      = document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[1].value;
            i3      = document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[2].value;

			if(i1 == ""){
				document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[0].value == "0";
				i1 = 0;
			}
			
			if(i2 == ""){
				 document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[1].value == "0";
				i2 = 0;
			}
			
			if(i3 == ""){
				document.getElementById("idTablaIntento").getElementsByTagName('tr')[i].getElementsByTagName('td')[3].getElementsByTagName('input')[2].value == "0";
				i3 = 0;
			}
			
            actualizarIntento(codigo,i1,i2,i3);

             deshabilitar2();

          }
           msg_exito();

        }





    </script>

  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

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

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
<!--                   <li class="breadcrumb-item"><a href="#">Otros</a> -->
<!--                   </li> -->
                  <li class="breadcrumb-item active">Configuraci&oacute;n
                  </li>
                  <li class="breadcrumb-item active">Ficha de puntajes
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
                                  <h4 class="card-title">Ficha de puntajes</h4>
                                  <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                                  <div class="heading-elements" style="display: none">
                                      <ul class="list-inline mb-0">
                                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                          <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                                      </ul>
                                  </div>
                              </div>
                              <div class="card-body collapse in">
                                  <div class="card-block card-dashboard">
                                    <div class="col-md-12">
                                      <ul class="nav nav-tabs nav-top-border no-hover-bg"> <!--
                                        <li class="nav-item">
                                          <a class="nav-link active" id="base-tab11" data-toggle="tab" aria-controls="tab11" href="#tab11" aria-expanded="true">Nivel</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab12" data-toggle="tab" aria-controls="tab12" href="#tab12" aria-expanded="false">Sub-Nivel</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link" id="base-tab13" data-toggle="tab" aria-controls="tab13" href="#tab13" aria-expanded="false">Unidad</a>
                                        </li> -->

                                        <li class="nav-item">
                                          <a class="nav-link  active" id="base-tab17" data-toggle="tab" aria-controls="tab17" href="#tab17" aria-expanded="false">Premios</a>
                                        </li>
                                        <li class="nav-item">
                                          <a class="nav-link " id="base-tab15" data-toggle="tab" aria-controls="tab15" href="#tab15" aria-expanded="false">Intentos</a>
                                        </li>
                                       <!-- <li class="nav-item">
                                          <a class="nav-link" id="base-tab14" data-toggle="tab" aria-controls="tab14" href="#tab14" aria-expanded="false">Ex&aacute;men</a>
                                        </li>
                                         <li class="nav-item">
                                          <a class="nav-link" id="base-tab16" data-toggle="tab" aria-controls="tab16" href="#tab16" aria-expanded="false">Operador por Instituci&oacute;n (OI)</a>
                                        </li> -->
                                      </ul>
                                      <div class="tab-content px-1 pt-1">
                                        <div role="tabpanel" class="tab-pane " id="tab11" aria-expanded="true" aria-labelledby="base-tab11">
                                          <form class="form mt-1">
                                            <div class="form-body">

                                              <div class="row">
                                                <div class="form-group col-md-3 mb-2">
                                                  <label >Nivel</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">B&aacute;sico</option>
                                                      <option value="development">Intermedio</option>
                                                      <option value="development">Avanzado</option>
                                                  </select>
                                                </div>
                                                <div class="col-md-3">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Puntaje M&iacute;nimo para aprobar</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                                <div class="col-md-3">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Puntaje M&aacute;ximo</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                              </div>

                                              <div class="row">
                                                  <div class="form-group col-md-9 text-right">
                                                      <button type="button" class="btn btn-secondary mr-1">
                                                        <i class="ft-search"></i> Limpiar
                                                      </button>
                                                      <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a>

                                                  </div>
                                              </div>
                                              <div class="row">
                                          <div class="col-xs-9">
                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">Id</th>
                                                        <th>Nivel</th>
                                                        <th>P.M&aacute;nimo</th>
                                                        <th>P. M&iacute;ximo</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>B&aacute;sico </td>
                                                        <td>600 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>

                                                    <tr>
                                                        <td>2</td>
                                                        <td>Intermedio </td>
                                                        <td>550 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>Avanzado </td>
                                                        <td>500 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>


                                                </tbody>

                                            </table>
                                          </div>
                                        </div>
                                            </div>
                                          </form>
                                        </div>
                                        <div class="tab-pane" id="tab12" aria-labelledby="base-tab12">
                                          <form class="form mt-1">
                                            <div class="form-body">
                                              <div class="row">
                                                <div class="form-group col-md-3 mb-2">
                                                  <label >Sub-Nivel</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">B&aacute;sico I</option>
                                                      <option value="development">B&aacute;sico II</option>
                                                      <option value="development">B&aacute;sico III</option>
                                                      <option value="development">Intermedio I</option>
                                                      <option value="development">Intermedio II</option>
                                                      <option value="development">Intermedio III</option>
                                                      <option value="development">Avanzado I</option>
                                                      <option value="development">Avanzado II</option>
                                                  </select>
                                                </div>
                                                <div class="col-md-3">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Puntaje M&iacute;nimo para aprobar</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                                <div class="col-md-3">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Puntaje M&aacute;ximo</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                              </div>

                                              <div class="row">
                                                  <div class="form-group col-md-9 text-right">
                                                      <button type="button" class="btn btn-secondary mr-1">
                                                        <i class="ft-search"></i> Limpiar
                                                      </button>
                                                      <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a>

                                                  </div>
                                              </div>
                                              <div class="row">
                                          <div class="col-xs-9">
                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">Id</th>
                                                        <th>Sub-Nivel</th>
                                                        <th>P.M&aacute;nimo</th>
                                                        <th>P. M&iacute;ximo</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <tr>
                                                        <td>1</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>600 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <td>B&aacute;sico 2 </td>
                                                        <td>600 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>B&aacute;sico 3 </td>
                                                        <td>600 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>

                                                    <tr>
                                                        <td>4</td>
                                                        <td>Intermedio 1 </td>
                                                        <td>550 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>5</td>
                                                        <td>Intermedio 2 </td>
                                                        <td>550 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>5</td>
                                                        <td>Intermedio 3 </td>
                                                        <td>550 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>7</td>
                                                        <td>Avanzado 1</td>
                                                        <td>500 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>8</td>
                                                        <td>Avanzado 2</td>
                                                        <td>500 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>9</td>
                                                        <td>Avanzado 3</td>
                                                        <td>500 </td>
                                                        <td>720 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>


                                                </tbody>

                                            </table>
                                          </div>
                                        </div>
                                            </div>
                                          </form>
                                        </div>
                                        <div class="tab-pane" id="tab13" aria-labelledby="base-tab13">
                                          <form class="form mt-1">
                                            <div class="form-body">
                                              <div class="row">
                                                <div class="form-group col-md-4 mb-2">
                                                  <label >Sub-Nivel</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">B&aacute;sico I</option>
                                                      <option value="development">B&aacute;sico II</option>
                                                      <option value="development">B&aacute;sico III</option>
                                                      <option value="development">Intermedio I</option>
                                                      <option value="development">Intermedio II</option>
                                                      <option value="development">Intermedio III</option>
                                                      <option value="development">Avanzado I</option>
                                                      <option value="development">Avanzado II</option>
                                                  </select>
                                                </div>

                                                <div class="form-group col-md-4 mb-2">
                                                  <label >Unidad</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">     Unidad 1</option>
                                                      <option value="development">Unidad 2</option>
                                                      <option value="development">Unidad 3</option>
                                                      <option value="development">Unidad 4</option>
                                                  </select>
                                                </div>
                                              </div>

                                               <div class="row">
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Puntaje M&iacute;nimo para aprobar</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                                <div class="col-md-4">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Puntaje M&aacute;ximo</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                               </div>

                                              <div class="row">
                                                  <div class="form-group col-md-8 text-right">
                                                      <button type="button" class="btn btn-secondary mr-1">
                                                        <i class="ft-search"></i> Limpiar
                                                      </button>
                                                      <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a>

                                                  </div>
                                              </div>
                                              <div class="row">
                                          <div class="col-xs-8">
                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Sub-Nivel</th>
                                                        <th>Unidad</th>
                                                        <th>P. Aprobaci&oacute;n</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 1 </td>
                                                        <td>60 </td>
                                                        <td>40 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 2 </td>
                                                        <td>60 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 3 </td>
                                                        <td>45 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>4</td>
                                                        <td>B&aacute;sico 3 </td>
                                                        <td>Unidad 4 </td>
                                                        <td>45 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>

                                                    <tr>
                                                        <td>5</td>
                                                        <td>Intermedio 1 </td>
                                                        <td>Unidad 1 </td>
                                                        <td>45 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>6</td>
                                                        <td>Intermedio 2 </td>
                                                        <td>Unidad 1 </td>
                                                        <td>60 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>7</td>
                                                        <td>Intermedio 2 </td>
                                                        <td>Unidad 2 </td>
                                                        <td>90 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>8</td>
                                                        <td>Intermedio 3 </td>
                                                        <td>Unidad 1 </td>
                                                        <td>60 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>7</td>
                                                        <td>Avanzado 1</td>
                                                        <td>Unidad 1 </td>
                                                        <td>60 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>8</td>
                                                        <td>Avanzado 2</td>
                                                        <td>Unidad 1 </td>
                                                        <td>60 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>9</td>
                                                        <td>Avanzado 2</td>
                                                        <td>Unidad 2 </td>
                                                        <td>60 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>


                                                </tbody>

                                            </table>
                                          </div>
                                        </div>
                                            </div>
                                          </form>
                                        </div>

                                        <div class="tab-pane" id="tab14" aria-labelledby="base-tab14">
                                          <form class="form mt-1">
                                            <div class="form-body">
                                              <div class="row">
                                                <div class="form-group col-md-3 mb-2">
                                                  <label >Sub-Nivel</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">B&aacute;sico I</option>
                                                      <option value="development">B&aacute;sico II</option>
                                                      <option value="development">B&aacute;sico III</option>
                                                      <option value="development">Intermedio I</option>
                                                      <option value="development">Intermedio II</option>
                                                      <option value="development">Intermedio III</option>
                                                      <option value="development">Avanzado I</option>
                                                      <option value="development">Avanzado II</option>
                                                  </select>
                                                </div>

                                                <div class="form-group col-md-3 mb-2">
                                                  <label >Unidad</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">     Unidad 1</option>
                                                      <option value="development">Unidad 2</option>
                                                      <option value="development">Unidad 3</option>
                                                      <option value="development">Unidad 4</option>
                                                  </select>
                                                </div>

                                                <div class="form-group col-md-3 mb-2">
                                                  <label >Lecci&oacute;n</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">     Lecci&oacute;n 1</option>
                                                      <option value="development">Lecci&oacute;n 2</option>
                                                      <option value="development">Lecci&oacute;n 3</option>
                                                  </select>
                                                </div>
                                              </div>

                                               <div class="row">
                                                <div class="col-md-3">
                                                  <div class="form-group mb-2">
                                                    <label for="nombreUnidadLec">Puntaje de aprobaci&oacute;n</label>
                                                    <input type="text"  class="form-control" name="fname">
                                                  </div>
                                                </div>
                                                <div class="col-md-3">
                                                </div>
                                               </div>

                                              <div class="row">
                                                  <div class="form-group col-md-9 text-right">
                                                      <button type="button" class="btn btn-secondary mr-1">
                                                        <i class="ft-search"></i> Limpiar
                                                      </button>
                                                      <a class="btn btn-primary" id="confirm-text" title=""><i class="fa fa-floppy-o"></i> Guardar</a>

                                                  </div>
                                              </div>
                                              <div class="row">
                                          <div class="col-xs-9">
                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                        <th>Sub-Nivel</th>
                                                        <th>Unidad</th>
                                                        <th>Lecci&oacute;n</th>
                                                        <th>P. de Aprobaci&oacute;n</th>
                                                        <th width="90">Acci&oacute;n</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="itemExamenConfig" items="${lstExamenConfig}">
                                                    <tr>
                                                        <td>${itemExamenConfig.codigo}</td>
                                                        <td>${itemExamenConfig.subnivel.nombreLargo}</td>
                                                        <td>${itemExamenConfig.unidad.nombreCorto}</td>
                                                        <td>${itemExamenConfig.leccion.nombreCorto}</td>
                                                        <td>70 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>

                                                   <!-- <tr>
                                                        <td>2</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 1 </td>
                                                        <td>Lecci&oacute;n 2 </td>
                                                        <td>40 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 1 </td>
                                                        <td>Lecci&oacute;n 3 </td>
                                                        <td>60 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>4</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 2 </td>
                                                        <td>Lecci&oacute;n 1 </td>
                                                        <td>50 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>

                                                    <tr>
                                                        <td>5</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 2 </td>
                                                        <td>Lecci&oacute;n 2 </td>
                                                        <td>40 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>6</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 2 </td>
                                                        <td>Lecci&oacute;n 3 </td>
                                                        <td>70 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>7</td>
                                                        <td>B&aacute;sico 1 </td>
                                                        <td>Unidad 3 </td>
                                                        <td>Lecci&oacute;n 1 </td>
                                                        <td>80 </td>
                                                        <td>
                                                          <button type="button" class="btn btn-outline-success btn-sm "
                                                          data-toggle="tooltip"   data-original-title="Editar"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"  data-toggle="tooltip" data-placement="top" title="" data-original-title="Eliminar" onclick="confirmar_accion();"><i class="icon-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                    -->
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                          </div>
                                        </div>
                                            </div>
                                          </form>
                                        </div>

                                        <div class="tab-pane active" id="tab17" aria-labelledby="base-tab17">
                                          <form class="form mt-1">
                                          <div class="form-body">
                                          <f:form id="frmRegistroPremio" class="form-horizontal" role="form" method="post" >
                                       <div class="form-group text-right">

                                          <button  id="btnmodi" onclick="habilitar();"  type="button" class="btn btn-flat btn-secondary">
                                            <i class="icon-pencil"></i> Modificar
                                          </button>

                                           <button id="btn-save-reg" onclick="prueba();" type="button" name="guar"
                                            class="btn btn-flat btn-primary">
                                            <i class="fa fa-floppy-o"></i>
                                            Guardar
                                          </button>
                                       </div>
                                              <div class="row">
                                          <div class="col-xs-12">

                                              <table class="table table-striped table-bordered dataTable ">
                                                <thead>
                                                  <tr>
                                                		<th rowspan="2" width="10">N°</th>	
                                                    <th rowspan="2" style="display: none">Id</th>
                                                    <th rowspan="2"><center>Categoría</center></th>
                                                    <th colspan="3"   style="border-bottom-width: 0;border-right-width: 0;"> <center> Medallas </center></th>
                                                    <th rowspan="2" style="border-left-width: 1px;" width="80">Monedas<br></th>
                                                    <th rowspan="2" width="80">Gemas<br></th>
                                                  </tr>
                                                  <tr>
<!--                                                     <th width="10">Item</th> -->
                                                    <th><center>B&aacute;sica</center></th>
                                                    <th><center>Honor&iacute;fica</center></th>
                                                    <th><center>Premium</center></th>
                                                  </tr>
                                                </thead>
                                                <tbody id="idTablaPremio">
                                                
                                                  <c:forEach var="itemPremioConfig" items="${lstPremioConfig}" varStatus="theCount">
                                             
                                                 <tr id="${itemPremioConfig.codigo}"> 
<%-- <td>${itemPremioConfig.codigo}</td> --%>
											

<%--                                                      <td><center>${theCount.count}</td> --%>
													<td><center>${theCount.count}</center></td>
                                                    <td style="display: none" id="prueba1">${itemPremioConfig.codigo}</td>
                                                    <td>${itemPremioConfig.categoria.nombreCorto}</td>
                                                    <!--
                                                    <td><input type="checkbox"  name="custom7" value="1" id="custom7"  ></td>
                                                    <td><input type="checkbox"   name="custom7" value="1" id="custom7" ></td>
                                                    <td><input type="checkbox"   name="custom7" value="1" id="custom7" ><div>12</div></td>
                                                    -->
                                                    <td> <c:if  test="${itemPremioConfig.flagBasico=='1'}">
                                                       <div id="blok-check" class="row skin skin-square">
                                                            <center> <input  type="checkbox" value="1" id="bas" name="bas" checked="true"  > </center>
                                                       </div>
                                                          </c:if>

                                                          <c:if  test="${itemPremioConfig.flagBasico!='1'}">
                                                           <div id="blok-check" class="row skin skin-square">
                                                            <center> <input type="checkbox" value="0" id="bas" name="bas"   > </center>
                                                            </div>
                                                          </c:if>
                                                    </td>


                                                    <td> <c:if  test="${itemPremioConfig.flagHonorifico=='1'}">
                                                     <div id="blok-check" class="row skin skin-square">
                                                            <center> <input  type="checkbox" value="1" id="hon" name="hon" checked="true"  > </center>
                                                            </div>
                                                          </c:if>

                                                          <c:if  test="${itemPremioConfig.flagHonorifico!='1'}">
                                                           <div id="blok-check" class="row skin skin-square">
                                                            <center> <input type="checkbox" value="0" id="hon" name="hon"   > </center>
                                                            </div>
                                                          </c:if>
                                                    </td>


                                                    <td> <c:if  test="${itemPremioConfig.flagPremium=='1'}">
                                                     <div id="blok-check" class="row skin skin-square">
                                                            <center> <input  type="checkbox" value="1" id="pre" name="pre" checked="true"  > </center>
                                                            </div>
                                                          </c:if>

                                                          <c:if  test="${itemPremioConfig.flagPremium!='1'}">
                                                           <div id="blok-check" class="row skin skin-square">
                                                            <center> <input type="checkbox" value="0" id="pre" name="pre"  > </center>
                                                            </div>
                                                          </c:if>
                                                    </td>


                                                    <td>
                                                      <div class="col-md-6">
                                                      <div class="controls">
                                                      <input type="text"  onkeypress="return valida(event)" value="${itemPremioConfig.monedas}" id="moneda" class="form-control" name="moneda" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"   maxlength="5" onpaste="return false;" />
                                                      </div></div>
                                                    </td>

                                                    <td>
                                                      <div class="col-md-6">
                                                      <div class="controls">
                                                        <input type="text" onkeypress="return valida(event)" onpaste="return false;" value="${itemPremioConfig.gemas}" id="gema" class="form-control" name="gema" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"  maxlength="5">
                                                       </div>
                                                       </div>
                                                        </td>

                                                  </tr>
                                                   <!-- <tr>
                                                    <td>2</td>
                                                    <td>unidad</td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td>
                                                      <div class="col-md-6">
                                                        <input type="text" value="0" id="" class="form-control" name="fname"></td>
                                                      </div>
                                                    <td>
                                                      <div class="col-md-6">
                                                        <input type="text" value="0" id="" class="form-control" name="fname"></td>
                                                      </div>
                                                  </tr>
                                                  <tr>
                                                    <td>3</td>
                                                    <td>Subnivel</td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td>
                                                      <div class="col-md-6">
                                                        <input type="text" value="0" id="" class="form-control" name="fname"></td>
                                                      </div>
                                                    <td>
                                                      <div class="col-md-6">
                                                        <input type="text" value="0" id="" class="form-control" name="fname"></td>
                                                      </div>
                                                  </tr>
                                                  <tr>
                                                    <td>4</td>
                                                    <td>Nivel<br></td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td><input type="checkbox" id="input-13" ></td>
                                                    <td>
                                                      <div class="col-md-6">
                                                        <input type="text" value="0" id="" class="form-control" name="fname"></td>
                                                      </div>
                                                    <td>
                                                      <div class="col-md-6">
                                                        <input type="text" value="0" id="" class="form-control" name="fname"></td>
                                                      </div>
                                                  </tr> -->

                                                   </c:forEach>
                                                    <thead>
                                                  <tr>
                                                        <th rowspan="2"  width="10">N°</th>	
                                                    <th rowspan="2" style="display: none">Id</th>
                                                    <th rowspan="2"><center>Categoría</center></th>
                                                   <th colspan="3" colspan="3" style="border-bottom-width: 0;border-right-width: 0;"></th>  
                                                    <th rowspan="2" style="border-left-width: 1px;" width="80">Monedas<br></th>
                                                    <th rowspan="2" width="80">Gemas<br></th>
                                                  </tr>
                                                  <tr>
<!--                                                      <th width="10">Item</th> -->
                                                    <th><center>B&aacute;sica</center></th>
                                                    <th><center>Honor&iacute;fica</center></th>
                                                    <th><center>Premium</center></th>
                                                  </tr>
                                                </thead>
                                                </tbody>
                                              </table>


                                          </div>
                                        </div>
                                            </div>
                                         </f:form>
                                        </div>


                                        <div class="tab-pane " id="tab15" aria-labelledby="base-tab15">
                                          <form class="form mt-1">
                                          <div class="form-body">

                                          <f:form id="frmRegistroIntento" class="form-horizontal" role="form" method="post" >
                                       <div class="form-group text-right">

                                          <button  id="btnmodi2" onclick="habilitar2();"  type="button" class="btn btn-flat btn-secondary">
                                            <i class="icon-pencil"></i> Modificar
                                          </button>

                                           <button id="btn-save-reg2" onclick="prueba2();" type="button" name="guar2"
                                            class="btn btn-flat btn-primary">
                                            <i class="fa fa-floppy-o"></i>
                                            Guardar
                                          </button>
                                       </div>



                                        <!--
                                              <div class="row">
                                                <div class="form-group col-md-3 ">
                                                  <label >Nivel</label>
                                                  <select id="situacionUsuario" name="interested" class="form-control">
                                                      <option value="none" selected="" disabled="">Seleccionar</option>
                                                      <option value="design">B&aacute;sico</option>
                                                      <option value="development">Intermedio</option>
                                                      <option value="development">Avanzado</option>
                                                  </select>
                                                </div>
                                                  <button id="btn-save-reg" onclick="prueba2();" type="button" name="guar"
                                            class="btn btn-flat btn-primary">
                                            <i class="fa fa-floppy-o"></i>
                                            Guardar
                                          </button>
                                              </div> -->
                                              <div class="row">
                                          <div class="col-xs-12">

                                            <table class="table table-striped table-bordered  ">
                                                <thead>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                     <!--   <th width="40">Nivel</th> -->
                                                        <th>Ejercicio</th>
                                                        <th>Descripci&oacute;n</th>
                                                        <th width="280"><center>Valor(Monedas)</center></th>
                                                    </tr>
                                                </thead>





                                                <tbody id="idTablaIntento">
                                                <c:forEach var="itemIntentoConfig" items="${lstIntentoConfig}" varStatus="theCount">
                                                    <tr id="${itemIntentoConfig.codigo}">
                                                        <td id="prueba1">${itemIntentoConfig.codigo}</td>
                                                      <!--     <td>B&aacute;sico</td> -->
                                                        <td>${itemIntentoConfig.ejercicio.nombreLargo}</td>
                                                         <td>${itemIntentoConfig.ejercicio.valor1}</td>

                                                        <td>
                                                          <div class="form-group col-md-4 mb-0">
                                                            <label for="">Intento 1</label>
                                                            <input type="text"  onkeypress="return valida(event)" onpaste="return false;" value="${itemIntentoConfig.intento1}" id="inte1" class="form-control" name="inte1" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"   maxlength="5"  />
                                                          </div>
                                                          <div class="form-group col-md-4 mb-0">
                                                            <label for="">Intento 2</label>
                                                            <input type="text"  onkeypress="return valida(event)" value="${itemIntentoConfig.intento2}" id="inte2" class="form-control" name="inte2" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"   maxlength="5" onpaste="return false;" />
                                                          </div>
                                                          <div class="form-group col-md-4 mb-0">
                                                            <label for="">Intento 3</label>
                                                            <input type="text"  onkeypress="return valida(event)" value="${itemIntentoConfig.intento3}" id="inte3" class="form-control" name="inte3" data-validation-required-message="Este campo es requerido" pattern="[0-9]{1,}"   maxlength="5" onpaste="return false;" />
                                                          </div>
                                                        </td>
                                                    </tr>
                                                     </c:forEach>
                                                     <thead>
                                                    <tr>
                                                        <th width="40">N°</th>
                                                     <!--   <th width="40">Nivel</th> -->
                                                        <th>Ejercicio</th>
                                                        <th>Descripci&oacute;n</th>
                                                        <th width="280"><center>Valor(Monedas)</center></th>
                                                    </tr>
                                                </thead>
                                                </tbody>

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



    <jsp:include page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />

    <!-- BEGIN VENDOR JS-->
      <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
<!--     <script src="../app-assets/vendors/js/vendors.min.js" type="text/javascript"></script> -->
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
<!--     <script src="../app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/typeahead/handlebars.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js" type="text/javascript"></script>
    <script src="../app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
  
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
  
<script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
<!--     <script src="../app-assets/js/core/app-menu.js" type="text/javascript"></script> -->
<!--     <script src="../app-assets/js/core/app.js" type="text/javascript"></script> -->
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- <script src="../app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script> -->
    <!-- END PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js" type="text/javascript"></script>
    <!-- <script src="../app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script> -->
    <!-- <script src="../app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script> -->
    <!-- <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script> -->
    <!-- <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script> -->
<!--     <script src="../app-assets/js/scripts/forms/extended/form-typeahead.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/extended/form-inputmask.js" type="text/javascript"></script>
    <script src="../app-assets/js/scripts/forms/extended/form-maxlength.js" type="text/javascript"></script> -->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/checkbox-radio.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/validation.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/page/general/institucion/registro-institucion-script.js"></script>
    
     <script type="text/javascript" charset="utf-8" >
       function confirmar_accion(){
        $('#md_confirmacion').modal('show');
       }

        window.onload = function() {
              deshabilitar();
              deshabilitar2();
        };

    </script>
  </body>
</html>