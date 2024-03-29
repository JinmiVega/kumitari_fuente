<ul class="nav nav-tabs nav-linetriangle no-hover-bg">
	<li class="nav-item">
		<a class="nav-link active" id="base-tab41" data-toggle="tab" aria-controls="tab41" href="#tab41" aria-expanded="true">Material</a>
	</li>
	<%-- <li class="nav-item">
		<a class="nav-link" id="base-tab42" data-toggle="tab" aria-controls="tab42" href="#tab42" aria-expanded="false">Actividad</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" id="base-tab43" data-toggle="tab" aria-controls="tab43" href="#tab43" aria-expanded="true">Traducci&oacute;n</a>
	</li> --%>
</ul>
<div class="tab-content px-1 pt-1">
	<div role="tabpanel" class="tab-pane active" id="tab41" aria-expanded="true" aria-labelledby="base-tab41">
		<div class="form-body">
	        <div class="col-xs-5">
	          <img src="../assets/img/usar_imagen.jpg" alt="element 01" class="img-fluid" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;">
	        </div>
	        <div class="col-xs-7">
	          <div class="form-group">
	            <label for="timesheetinput1">T&iacute;tulo del audio</label>
	            <div class="position-relative has-icon-left">
	              <input type="text" id="timesheetinput1" class="form-control" name="employeename">
	              <div class="form-control-position">
	                <i class="ft-user"></i>
	              </div>
	            </div>
	          </div>
	          <div class="form-group">
				<img src="../assets/img/usar_audio.jpg" width="50" class="img-fluid" data-toggle="modal" data-target="#xlarge" style="cursor: pointer;">
	          </div>

			  <div class="form-group text-left mb-1">
			      <button type="button" class="btn btn-outline-info btn-min-width">
			        <i class="ft-search"></i> Siguiente
			      </button>
			  </div>
	        </div>
	      </div>
	</div>




	 	<div class="tab-pane" id="tab42" aria-labelledby="base-tab42">
		<div class="row">
	        <div class="col-xs-6">
	          <div class="form-group">
	            <label for="timesheetinput7">Pregunta</label>
	            <div class="position-relative has-icon-left">
	              <textarea id="timesheetinput7" rows="3" class="form-control input-sm" name="notes"></textarea>
	              <div class="form-control-position">
	                <i class="ft-file"></i>
	              </div>
	            </div>
	          </div>
	          <div class="form-group">
	          <div class="col-md-12">
			    <label for="nombreUnidadLec">Respuesta 01</label> </div>
			    <div class="col-md-10">
				<fieldset>
					<div class="input-group input-group-xs ">
						<span class="input-group-addon" id="radio-addon1">
							<label class="custom-control custom-radio inline">
								<input type="radio" name="rpst" class="custom-control-input">
								<span class="custom-control-indicator"></span>
							</label>
						</span>
						<input type="text" class="form-control" aria-describedby="radio-addon1">
					</div>
				</fieldset>
				</div>


					<div class="form-group col-md-2 ">

				      <button type="button" class="btn btn-outline-info btn-min" style="margin-top:-18px">
				        <i class="ft-plus"></i></button>
			 	</div>
	          </div>
	           <div class="form-group">
	          <div class="col-md-12">
			    <label for="nombreUnidadLec">Respuesta 02</label> </div>
			    <div class="col-md-10">
				<fieldset>
					<div class="input-group input-group-xs ">
						<span class="input-group-addon" id="radio-addon1">
							<label class="custom-control custom-radio inline">
								<input type="radio" name="rpst" class="custom-control-input">
								<span class="custom-control-indicator"></span>
							</label>
						</span>
						<input type="text" class="form-control" aria-describedby="radio-addon1">
					</div>
				</fieldset>
				</div>



	          </div>

			  <div class="form-group text-right mb-1 " >
			      <button type="button" class="btn btn-outline-info btn-min-width mt-1"  >
			        <i class="fa fa-floppy-o"></i> Guardar
			      </button>
			  </div>
	        </div>
	        <div class="col-xs-6">
				<div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th width="30">N�</th>
                                <th>Pregunta</th>
                                <th width="107">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Applies the hover color to a particular row or cell</td>
                                <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Indicates a successful or positive action</td>
                                <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Indicates a neutral informative change or action</td>
                                <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Indicates a warning that might need attention</td>
                                <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>Indicates a dangerous or potentially negative action</td>
                                <td><button type="button" class="btn btn-outline-success btn-sm"><i class="icon-pencil"></i></button>
                                                          <button type="button" class="btn btn-outline-danger btn-sm"><i class="icon-trash"></i></button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
	      	</div>
	      </div>

	</div>
	<div class="tab-pane" id="tab43" aria-labelledby="base-tab43">
		<p>Sugar plum tootsie roll biscuit caramels. Liquorice brownie pastry cotton candy oat cake fruitcake jelly chupa chups. Pudding caramels pastry powder cake soufflé wafer caramels. Jelly-o pie cupcake.</p>
	</div>
</div>

