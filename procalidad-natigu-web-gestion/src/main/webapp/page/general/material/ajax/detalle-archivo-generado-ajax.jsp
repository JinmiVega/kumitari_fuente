<%@ page contentType="text/html; charset=UTF-8" %>
<div class="row">
  <div class="col-md-12">
    <div id="cmm_descarga" class="bs-callout-info callout-border-right callout-square callout-right callout-bordered callout-transparent mt-1 p-1 hidden">
      <div class="row">
        <div class="col-sm-9">
          <table class="table">
            <thead>
              <tr>
                <th colspan="4">Informaci&oacute;n</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Lengua</td>
                <td><b id="cmm_info_leng"></b></td>
                <td>Nivel</td>
                <td><b id="cmm_info_nivel"></b></td>
              </tr>
              <tr>
                <td>Sub Nivel</td>
                <td><b id="cmm_info_s_nivel"></b></td>
                <td>Unidad</td>
                <td><b id="cmm_info_unidades"></b></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="col-sm-3">
          <div class="form-group">
              <a href="${pageContext.request.contextPath}/cargaMasivaController/descargarArchivo?fileName=${nombreArchivo}" class="btn btn-lg btn-block font-medium-1 btn-outline-success mt-1  mb-1 onblock-callback"><i class="ft-download-cloud"></i> Descargar</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>