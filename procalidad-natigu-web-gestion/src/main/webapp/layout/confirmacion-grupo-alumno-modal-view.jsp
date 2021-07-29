<%@ page contentType="text/html; charset=UTF-8" %>
<div class="modal fade text-xs-left" id="md_confirmacion_alumno_select" tabindex="-1" role="dialog" aria-labelledby="myModalLabel19" aria-hidden="true">
  <div class="modal-dialog modal-sm" role="document">
  <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title" id="myModalLabel19">Mensaje de confirmación</h4>
    </div>
    <div class="modal-body">
    <p>¿Estás seguro que deseas eliminar el registro seleccionado?</p>
    <div class="row">
      <div class="col-md-12 mb-0">
          <label>Grupo</label>
          <select id="situacionUsuario" name="interested" class="form-control">
              <option value="design">Aula 01</option>
              <option value="development">Aula 02</option>
              <option value="development">Aula 03</option>
          </select>
      </div>
    </div>
    </div>
    <div class="modal-footer">
    <button type="button" class="btn grey btn-outline-secondary" data-dismiss="modal">NO</button>
    <button type="button" class="btn btn-outline-primary">SI</button>
    </div>
  </div>
  </div>
</div>