<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="admin">
    <meta name="keywords" content="admin">
    <meta name="author" content="PIXINVENT">
    <title>Inicio</title>
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/charts/jquery-jvectormap-2.0.3.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/charts/morris.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/unslider.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/weather-icons/climacons.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">

    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
    <!-- END Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/colors/palette-climacon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/inicioController/listar" class="navbar-brand"><img id="logo-k" alt="stack admin logo" src="${pageContext.request.contextPath}/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
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
        </div>
        <div class="content-body"><!-- Analytics spakline & chartjs  -->
          <div class="row" style="display: none">
              <div class="col-xs-12">
                  <div class="card">
                      <div class="card-body">
                          <div class="card-block">
                              <div class="row">
                                  <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5 clearfix">
                                      <div class="media">
                                          <div class="media-left">
                                              <img class="media-object img-xl" src="${pageContext.request.contextPath}/app-assets/images/portrait/small/avatar-s-5.png" alt="Generic placeholder image">
                                          </div>
                                          <div class="media-body">
                                              <h6 class="text-bold-500 pt-1 mb-0">Alumnos</h6>
                                              <p>4500</p>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5 clearfix">
                                      <p>Distance <span class="text-muted">(Last Week)</span></p>
                                      <progress class="progress progress-sm progress-success mb-1" value="45" max="100"></progress>
                                      <h6 class="text-bold-500 mb-0">80 KM</h6>
                                  </div>
                                  <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5 clearfix py-2 text-xs-center">
                                      <div id="fitness-stats"><canvas width="216" height="30" style="display: inline-block; width: 216px; height: 30px; vertical-align: top;"></canvas></div>
                                  </div>
                                  <div class="col-xl-3 col-lg-6 col-md-12 text-xs-center clearfix">
                                      <h6 class="pt-1"><span class="icon-clock"></span> 56:55 Hrs</h6>
                                      <p>Anverage Running Time</p>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>

          <div class="row">
              <div class="col-xs-12">
                  <div class="card">
                      <div class="card-body">
                          <div class="row">
                              <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1">
                                      <div class="card-header mb-2 pt-0 text-xs-center">

                                          <h5 class="primary">Total estudiantes</h5>                                         

                                          <h3 class="font-large-2 text-bold-200" id="textTotalAlumnos">0</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                              <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1 text-xs-center">
                                      <div class="card-header mb-2 pt-0">
                                          <h5 class="danger">B&aacute;sico</h5>
                                          <h3 class="font-large-2 text-bold-200" id="textTotalBasico">0</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                              <div class="col-xl-3 col-lg-6 col-md-12 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1 text-xs-center">
                                      <div class="card-header mb-2 pt-0">
                                          <h5 class="warning">Intermedio</h5>
                                          <h3 class="font-large-2 text-bold-200" id="textTotalIntermedio">0</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                              <div class="col-xl-3 col-lg-6 col-md-12">
                                  <div class="my-1 text-xs-center">
                                      <div class="card-header mb-2 pt-0">
                                          <h5 class="success">Avanzado</h5>
                                          <h3 class="font-large-2 text-bold-200" id="textTotalAvanzado">0</h3>
                                      </div>
                                      <div class="card-body">
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>

          <div class="row">
          	  <input type="hidden" id="idInstitucionUsu" value="${idInstitucion}">
              <div class="col-xs-12">
                  <div class="card">
                      <div class="card-body">
                          <div class="row">
                          	  <div class="col-xl-6 col-lg-6 col-md-6 border-right-blue-grey border-right-lighten-5">
                                  <div class="my-1">
                                      <div class="card-header mb-0 pt-1 text-xs-center">
                                          <h5 class="primary">Instituciones</h5>
                                      </div>
                                      <div class="card-body">
                                        <div class="ml-1">
                                          <div id="daily-activity" class="table-responsive ps-container ps-theme-default ps-active-y">
                                              <table id="tablaInsitucion" class="table table-hover mb-0">
                                                  <thead>
                                                      <tr>
                                                      	   <th>N°</th>
                                                          <th>Nombre</th>
                                                      </tr>
                                                  </thead>
                                                  <tbody>
                                                  	  <c:forEach var="institucion" items="${listaInstitucion}" varStatus="theCount">
                                                  	  	
                                                  	  	<tr id="tr_selecc_${institucion.codigo}"
                                                  	  		data-id="${institucion.codigo}"
                                                  	  		onclick="cargarLenguas(${institucion.codigo},'#tablaLenguaXInst')"
                                                  	  		class="fila_seleccionada"
                                                  	  		style="cursor: pointer;">
                                                  	  	  <td>${theCount.count}</td>
                                                          <td class="text-truncate">
                                                            <div class="media-body">
                                                              ${institucion.nombreInstitucion}
                                                            </div>
                                                          </td>
                                                      	</tr>
                                                  	  </c:forEach>
                                                  </tbody>
                                                  <tfoot>
                                                      <tr>
                                                      	   <th>N°</th>
                                                          <th>Nombre</th>
                                                      </tr>
                                                  </tfoot>
                                              </table>
                                          </div>
                                        </div>
                                      </div>
                                  </div>
                              </div>

                              <div class="col-xl-6 col-lg-6 col-md-6">
                                  <div class="my-1" style="display:none;" id="divContentCuadroLengua">
                                      <div class="card-header mb-0 pt-1 text-xs-center">
                                          <h5 class="primary">Cuadro estad&iacute;stico general</h5>
                                      </div>
                                      <div class="card-body">
                                        <div class="ml-1">
                                          <div id="daily-activity" class="table-responsive ps-container ps-theme-default ps-active-y">
                                              <table id="tablaLenguaXInst" class="table table-hover mb-0">
                                                  <thead>
                                                      <tr>
                                                          <th>N°</th>
                                                          <th>Lenguas</th>
                                                          <th>B</th>
                                                          <th>I</th>
                                                          <th>A</th>
                                                          <!-- <th>Finalizados</th> -->
                                                          <th>Total</th>
                                                      </tr>
                                                  </thead>
                                                  <tbody id="tbodyListLenguas">
                                                      <%-- <tr>
                                                          <td class="text-truncate">
                                                            <span class="tag tag-default tag-pill bg-default float-xs-right">4500</span>
                                                            <div class="media-left">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_01.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">

                                                            </div>
                                                            <div class="media-body">
                                                              Quechua
                                                            </div>
                                                          </td>
                                                          <td class="text-truncate">650</td>
                                                          <td class="text-truncate">256</td>
                                                          <td class="text-truncate">150</td>
                                                          <td class="text-truncate">25</td>
                                                      </tr>
                                                      <tr>
                                                          <td class="text-truncate">
                                                            <span class="tag tag-default tag-pill bg-default float-xs-right">3100</span>
                                                            <div class="media-left">
                                                              <img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_05.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">

                                                            </div>
                                                            <div class="media-body">
                                                             Ashaninka
                                                            </div>
                                                          </td>
                                                          <td class="text-truncate">890</td>
                                                          <td class="text-truncate">186</td>
                                                          <td class="text-truncate">350</td>
                                                          <td class="text-truncate">25</td>
                                                      </tr> --%>
                                                  </tbody>
                                                   <tfoot>
                                                      <tr>
                                                          <th>N°</th>
                                                          <th>Lenguas</th>
                                                          <th>B</th>
                                                          <th>I</th>
                                                          <th>A</th>
                                                          <!-- <th>Finalizados</th> -->
                                                          <th>Total</th>
                                                          
                                                      </tr>
                                                  </tfoot>
                                              </table>
                                          </div>
                                        </div>
                                                   <div class="my-1" style=" text-align: center;">
                                        <div class="media-left" style="display: inline-flex;text-align: center;">
                                        	<div class="media-object" style="padding-right: 10px;">
                                        		<span class="tag tag-default tag-pill bg-default "><b>B</b></span>  <b>  Básico    </b> 
                                        		<b>  |</b>
                                        	</div>
                                        	<div class="media-object" style="padding-right: 10px;">
                                        		<span class="tag tag-default tag-pill bg-default "><b>I</b></span>  <b>  Intermedio   </b> 
                                        		<b>  |</b>
                                        	</div>
                                        	<div class="media-object" style="padding-right: 10px;">
                                        		<span class="tag tag-default tag-pill bg-default"><b>A</b></span> <b> Avanzado  </b>
                                        	</div>
                                        </div>
                                        </div>
                                      </div>
                                  </div>
                              </div>

                          </div>
                      </div>
                  </div>
              </div>
          </div>
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <jsp:include page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/jquery.knob.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/knob.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/charts/raphael-min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/charts/morris.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/charts/jvector/jquery-jvectormap-2.0.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/charts/jvector/jquery-jvectormap-world-mill.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/data/jvector/visitor-data.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/charts/chart.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/charts/jquery.sparkline.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/unslider-min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js" type="text/javascript"></script>
    <!-- END STACK JS-->

    <script src="${pageContext.request.contextPath}/assets/js/scripts.js" type="text/javascript"></script>

    <script type="text/javascript">

	    $(document).ready(function() {
		    $('#tablaInsitucion').DataTable({
		        "language":{
		            "sProcessing":     "Procesando...",
		            "sLengthMenu":     "Mostrar _MENU_ registros",
		            "sZeroRecords":    "Sin registros para mostrar",
		            "sEmptyTable":     "Ningún dato disponible en esta tabla",
		            //"sInfo":           "Mostrando de _START_ al _END_ de un total de _TOTAL_ registros",
		            //"sInfoEmpty":      "Mostrando de 0 al 0 de un total de 0 registros",
		            //"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
//	            "sInfo":           "Página _START_ de _END_ de (_TOTAL_ registros)",
	            "sInfo":           "Página _PAGE_ de _PAGES_ de (_TOTAL_ registros)",
		            "sInfoEmpty":      "Página 0 de 0  (0 registros)",
		            "sInfoFiltered":   "(filtrado de _MAX_ registros)",
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
		    
		     $('#tablaLenguaXInst').DataTable({
		        "language":{
		            "sProcessing":     "Procesando...",
		            "sLengthMenu":     "Mostrar _MENU_ registros",
		            "sZeroRecords":    "Sin registros para mostrar",
		            "sEmptyTable":     "Ningún dato disponible en esta tabla",
		            //"sInfo":           "Mostrando de _START_ al _END_ de un total de _TOTAL_ registros",
		            //"sInfoEmpty":      "Mostrando de 0 al 0 de un total de 0 registros",
		            //"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
//	            "sInfo":           "Página _START_ de _END_ de (_TOTAL_ registros)",
	            "sInfo":           "Página _PAGE_ de _PAGES_ de (_TOTAL_ registros)",
		            "sInfoEmpty":      "Página 0 de 0  (0 registros)",
		            "sInfoFiltered":   "(filtrado de _MAX_ registros)",
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

			var arrayIdInst = [];
		    $('#tablaInsitucion .fila_seleccionada').each(function(){
		    	arrayIdInst.push($(this).attr('data-id'));
			});

			var idInstUsu = $('#idInstitucionUsu').val();
			//console.log(arrayIdInst);
		    if(arrayIdInst.length>0){
		    	cargarLenguas(idInstUsu);
			}
		});

		function seleccionarFilaInst(valor){
			$("#tablaInsitucion .fila_seleccionada").css("background-color", "");
			//$("#tablaInsitucion #tr_selecc_"+valor).css("background-color", "#ECF8E0");
			$("#tablaInsitucion #tr_selecc_"+valor).css("background-color", "rgba(218, 228, 208, 1)");
		}

		function cargarLenguas(codinst,form) {

			seleccionarFilaInst(codinst);

			  var html = '';
			  var contextPath = '${pageContext.request.contextPath}';
			  var tieneDatos = false;
			  var tablaMenus = $(form).dataTable();
			  $('#divContentCuadroLengua').hide();

			  iniciarBloqueo();
			  $.ajax({
			    type: "GET",
			    data: {codinst : codinst},
			    url: contextPath+"/inicioController/reporteLenguas",
			    success: function(data){
			    	//console.log(data);
			    	if(data!=null && data.length>0){
			    		tieneDatos = true;
			    		for (var i = 0; i < data.length; i++) {
			    			html +=
					    		'<tr>'+
					    			'<td class="text-truncate" >'+(i+1)+'</td>'+
		                            '<td class="text-truncate" style="font-size: 10px;">'+
		                              '<span class="tag tag-default tag-pill bg-default float-xs-right" style="display:none;">'+(data[i].totalBasico + data[i].totalIntermedio + data[i].totalAvanzado)+'</span>'+
		                              '<div class="media-left">';
		                                if(data[i].lenguaBean.imagenNombre){
		                                	//html += '<img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_01.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">';
		                                	html += '<img class="media-object" src="${pageContext.request.contextPath}/lengua/'+data[i].lenguaBean.imagenNombre+'" alt="'+data[i].lenguaBean.imagenNombre+'" style="width: 32px;height: 32px;">';
			                            }else{
											html += '<img class="media-object" src="${pageContext.request.contextPath}/assets/img/idioma_01.jpg" alt="Generic placeholder image" style="width: 32px;height: 32px;">';
					                    }
		                              html +=
			                          '</div>'+
		                              '<div class="media-body">'+
		                                data[i].lenguaBean.nombre+
		                              '</div>'+
		                            '</td>'+
		                            '<td class="text-truncate" style="font-size: 10px;">'+data[i].totalBasico+'</td>'+
		                            '<td class="text-truncate" style="font-size: 10px;">'+data[i].totalIntermedio+'</td>'+
		                            '<td class="text-truncate" style="font-size: 10px;">'+data[i].totalAvanzado+'</td>'+
		                            '<td class="text-truncate" style="font-size: 10px;text-align: center;">'+(data[i].totalBasico + data[i].totalIntermedio + data[i].totalAvanzado)+'</td>'+
		                        '</tr>';
					    }
				    }else{
						html +=
							'<tr>'+
								'<td class="text-truncate" colspan="5">Sin mostrar registros</td>'+
							'</tr>';
					}
			    },error: function(xhr,status,er) {
		            //console.log("error: " + xhr + " status: " + status + " er:" + er);
					    if(xhr.status==500) {
					    	//console.log(er);
					    	//Error_500(er);
					    }
					    if(xhr.status==901) {
				    	//console.log(er);
				    	//spire_session_901(er);
		     			}
			    },
			    complete: function(){
			    	finBloqueo();
			    	
					  /* tablaMenus.fnClearTable();  */
			  	    $('#tablaLenguaXInst').DataTable().destroy();
			    	$('#tbodyListLenguas').empty();
					$('#tbodyListLenguas').html(html);
					$('#tablaLenguaXInst').DataTable();
			    	$('#divContentCuadroLengua').show();
			    	if(tieneDatos){
			    		calcularTotales();
					}
			    }
			  });
		}

		function calcularTotales(){

			var totalAlumnos = 0;
			var totalBasico = 0;
			var totalIntermedio = 0;
			var totalAvanzado = 0;

			$('#tablaLenguaXInst #tbodyListLenguas tr').each(function(index){

				$(this).children("td").each(function (index2)
		        {
		        	if(index2 == 1 ){ // BASICO
		        		totalBasico +=  parseInt($(this).text());
		        	}
					if(index2 == 2 ){ // INTERMEDIO
						totalIntermedio +=  parseInt($(this).text());
					}
					if(index2 == 3 ){ // AVANZADO
						totalAvanzado +=  parseInt($(this).text());
					}
		        })

			});

			totalAlumnos = totalBasico + totalIntermedio + totalAvanzado;

			$('#textTotalBasico').html(totalBasico);
			$('#textTotalIntermedio').html(totalIntermedio);
			$('#textTotalAvanzado').html(totalAvanzado);
			$('#textTotalAlumnos').html(totalAlumnos);
		}

    </script>

  </body>
</html>