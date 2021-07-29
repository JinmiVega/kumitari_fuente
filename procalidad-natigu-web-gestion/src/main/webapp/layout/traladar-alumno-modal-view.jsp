    <!-- Modal -->
    <div class="modal fade text-xs-left" id="trasladar-alumno-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Trasladar Alumno</b></label>
        </div>
        <form>
        <div class="modal-body">
          <div class="row">
            <div class="col-md-4 form-group">
                    <label for="projectinput2">Grupo</label>
                     <select id="situacionUsuario" name="interested" class="form-control">
                      <option value="none" selected="" disabled="">Selecionar</option>
                  </select>
            </div>
            <div class="col-md-4 mb-2">
                <label>Nombre alumno</label>
                <input type="text" class="form-control" name="fname">
            </div>

              <div class="form-group col-md-4 text-right">
                  <button type="button" class="btn btn-default mt-2">
                    <i class="ft-search"></i> Buscar
                  </button>
              </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <table class="table table-striped table-bordered zero-configuration">
                  <thead>
                      <tr>
                          <th>Nombre de alumno
                          </th>
                          <th>Grupo actual
                          </th>
                          <th width="50">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>Augusto Salazar Bondy</td>
                          <td>Aula 01</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right" data-toggle="modal" data-target="#md_confirmacion_alumno_select"></i></button>
                          </td>
                      </tr>
                      <tr>
                          <td>Luis Sanchez Uriol</td>
                          <td>Aula 01</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right" data-toggle="modal" data-target="#md_confirmacion_alumno_select"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>Jeniffer Soto Paredes</td>
                          <td>Aula 02</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right" data-toggle="modal" data-target="#md_confirmacion_alumno_select"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>C&eacute;sar Trujillo Vallejo</td>
                          <td>Aula 01</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right" data-toggle="modal" data-target="#md_confirmacion_alumno_select"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>Aracelly Melgar Diaz</td>
                          <td>Aula 01</td>

                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right" data-toggle="modal" data-target="#md_confirmacion_alumno_select"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>Karolina Col&aacute;n Martinez</td>
                          <td>Aula 01</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right" data-toggle="modal" data-target="#md_confirmacion_alumno_select"></i></button>

                          </td>
                      </tr>

                  </tbody>
              </table>
            </div>
          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Salir</button>
        </div>
        </form>
      </div>
      </div>
    </div>