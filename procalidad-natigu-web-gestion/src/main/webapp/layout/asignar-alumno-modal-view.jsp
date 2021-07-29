   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
   <script type="text/javascript">

	 function listadoAlumnosXMatricula(){
	    	

		var nombre =$('#nombreAlumno').val();
		var codinst =$('#lblInstitu').val();
		
		var html = "";
		$.ajax({
			
			type : "GET",

			url : "${pageContext.request.contextPath}/asignarUsuarioController/buscaralumnosxinst?nombrealumno="+nombre+"&codigoinst="+codinst,
//			data : {codigoinst:numero},

			success : function(data) {

 				for(var i=0;i<data.length;i++){
//						alert(data[i].personaBean.nombrePersona);
//  					html+="<tr>"+"<td>"+data[i].personaBean.nombrePersona +" "+ data[i].personaBean.apellidoPaterno+" "+data[i].personaBean.apellidoMaterno"</td>"+"<td>"+data[i].personaBean.numeroDocumento+"</td>"+"<td> <button type='button' class='btn btn-outline-success btn-sm'><i class='icon-arrow-right'></i> </button> </td>"+"</tr>";
 					
 					html=html+"<tr><td>"+data[i].alumnoBean.personaBean.nombrePersona +" "+data[i].alumnoBean.personaBean.apellidoPaterno+" "+ data[i].alumnoBean.personaBean.apellidoMaterno+"</td><td>"+data[i].matriculaBean.lengua.nombre+"</td><td>"+data[i].matriculaBean.nivel.nombreCorto+"</td><td><a title='Asignar' data-placement='top' data-toggle='tooltip' class='btn btn-outline-success btn-sm' href='asignarusuario?codigoalumno="+data[i].alumnoBean.codigo+"&codigoinst="+data[i].matriculaBean.insti.codigo+"'><i class='icon-arrow-right'></i></a></td></tr>";
 					

 					}
 				
 				document.getElementById("tablaListaAlumnosXInstitucionCodigoInscripcion").innerHTML=html;


			},
			error : function() {
				console.log("ERROR: ");
			}
		});

}






	
   
</script>
   
   
    <!-- Modal -->
    <div class="modal fade text-xs-left" id="alumno-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Asignar Usuario a Alumno</b></label>
        </div>
        <f:form class="form">
        <div class="modal-body">
          <div class="row">
            <div class="col-md-8 mb-2">
                <label>Nombre alumno</label>
                <input id="nombreAlumno" type="text" class="form-control" name="fname">
            </div>

              <div class="form-group col-md-4 text-right">
                  <button type="button" onclick="listadoAlumnosXMatricula();" class="btn btn-default mt-2">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <table class="table table-striped table-bordered zero-configuration">
                  <thead>
                      <tr>
                          <th>Nombre de alumno</th>
                          <th>Lengua</th>
                          <th>Nivel</th>
              
                          <th width="50">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody id="tablaListaAlumnosXInstitucionCodigoInscripcion">
                     <c:forEach var="alumno" items="${lstMatriculaAlumno}">
                      <tr>
                          <td>${alumno.alumnoBean.personaBean.nombrePersona} ${alumno.alumnoBean.personaBean.apellidoPaterno} ${alumno.alumnoBean.personaBean.apellidoMaterno} </td>
                          <td>${alumno.matriculaBean.nivel.nombreCorto}</td>
                          <td>${alumno.matriculaBean.lengua.nombre}</td>
                      
                          <td>
                           <a title="Asignar"  data-placement="top" data-toggle="tooltip" class="btn btn-outline-success btn-sm " href="asignarusuario?codigoalumno=${alumno.alumnoBean.codigo}&codigoinst=${alumno.matriculaBean.insti.codigo}"><i class="icon-arrow-right"></i></a>
<!--                             <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button> -->
                          </td>
                      </tr>
                       </c:forEach>
                     
                    
                   

                  </tbody>
              </table>
            </div>
          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
        </div>
        </f:form>
      </div>
      </div>
    </div>