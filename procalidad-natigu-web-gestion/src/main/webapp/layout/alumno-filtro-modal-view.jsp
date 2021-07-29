    <!-- Modal -->
    <div class="modal fade text-xs-left" id="alumno-modal-filter" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
      <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Alumnos</b></label>
        </div>
        <form>
        <div class="modal-body">
          <div class="row">
            <div class="col-md-3 mb-2">
                <label>Nombre alumno</label>
                <input type="text" class="form-control" name="fname">
            </div>
            <div class="col-md-3 mb-2">
                <label>Nivel</label>
                <select id="situacionUsuario" name="interested" class="form-control">
                    <option value="none" selected="" disabled="">Todos</option>
                    <option value="design">Básico</option>
                    <option value="development">Intermedio</option>
                    <option value="development">Avanzado</option>
                </select>
            </div>
            <div class="col-md-3 mb-2">
                <label>Situaci&oacute;n</label>
                <select id="situacionUsuario" name="interested" class="form-control">
                    <option value="none" selected="" disabled="">Todos</option>
                    <option value="design">Finalizado</option>
                    <option value="development">Proceso</option>
                    <option value="development">Retirado</option>
                </select>
            </div>
              <div class="form-group col-md-3 text-right">
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
                          <th>Nombre de alumno</th>
                          <th>Nivel</th>
                          <th width="100">Situaci&oacute;n</th>
                          <th width="50">Acci&oacute;n</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>Augusto Salazar Bondy</td>
                          <td>Básico</td>
                          <td>Retirado</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button>
                          </td>
                      </tr>
                      <tr>
                          <td>Luis Sanchez Uriol</td>
                          <td>Intermedio</td>
                          <td>Finalizado</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>Jeniffer Soto Paredes</td>
                          <td>Básico</td>
                          <td>Proceso</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>C&eacute;sar Trujillo Vallejo</td>
                          <td>Básico</td>
                          <td>Finalizado</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>Aracelly Melgar Diaz</td>
                          <td>Básico</td>
                          <td>Finalizado</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button>

                          </td>
                      </tr>
                      <tr>
                          <td>Karolina Col&aacute;n Martinez</td>
                          <td>Básico</td>
                          <td>Finalizado</td>
                          <td>
                            <button type="button" class="btn btn-outline-success btn-sm"><i class="icon-arrow-right"></i></button>

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