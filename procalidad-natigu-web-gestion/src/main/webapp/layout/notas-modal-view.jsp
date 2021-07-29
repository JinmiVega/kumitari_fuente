   <%@ page contentType="text/html; charset=UTF-8" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>     
   
    <!-- Modal -->
    <div class="modal fade text-xs-left" id="notas-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true" data-backdrop="static" data-keyboard="false">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Notas por sub nivel</b></label>
        </div>
         
   
         <div class="modal-body"> 
 
		 
          <div class="row">
            <div class="col-xs-12" id="listadonotasalumno">
              <table id="tb_notas" class="table table-striped table-bordered">
                  <thead>
                      <tr>
                      		<th>N°</th>
                      	  
                          <th>Sub nivel</th>
                          <th>Notas</th>
                           
                      </tr>
                  </thead>
                  <tbody > 
                  		 <c:forEach var="evaluacionBean" items="${lstEvaluacionBean}" varStatus="theCount">
                  		  
                      <tr>
                      	  <td>${theCount.count}</td>
                      	 
                          <td>${evaluacionBean.subNivel.nombreLargo}</td>
                          <td>${evaluacionBean.nota}</td>
                        
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
      </div>
      </div>
    </div>
