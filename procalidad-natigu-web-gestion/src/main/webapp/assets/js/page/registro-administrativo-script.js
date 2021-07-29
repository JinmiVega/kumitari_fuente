(function(window, document, $) {
	'use strict';

	// Input, Select, Textarea validations except submit button
	$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();

	// Square Checkbox & Radio
    // $('.skin-square input').iCheck({
    //     checkboxClass: 'icheckbox_square-green',
    //     radioClass: 'iradio_square-green',
    // });

	// Touch Spin
	$(".touchspin").TouchSpin();

	var i = 0;
	if (Array.prototype.forEach) {
		var elems = Array.prototype.slice.call(document.querySelectorAll('.switchery'));

		elems.forEach(function (html) {
			var switchery = new Switchery(html);
		});
	} else {
		var elems1 = document.querySelectorAll('.switchery');

		for (i = 0; i < elems1.length; i++) {
			var switchery = new Switchery(elems1[i]);
		}
	}

	//Phone with extra
	$('#telefonoUsuario').inputmask("(999) 999-9999 / 999-999-999");
	// Email mask
	$('.email-inputmask').inputmask({
		mask: "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@*{1,20}[*{2,6}][*{1,2}].*{1,}[.*{2,6}][.*{1,2}]",
		greedy: false,
		onBeforePaste: function (pastedValue, opts) {
			pastedValue = pastedValue.toLowerCase();
			return pastedValue.replace("mailto:", "");
		},
		definitions: {
			'*': {
				validator: "[0-9A-Za-z!#$%&'*+/=?^_`{|}~/-]",
				cardinality: 1,
				casing: "lower"
			}
		}
	});


})(window, document, jQuery);


function limpiarFiltros(form){
	$(form+" input[type='text']").val("");
	$(form+" input[type='date']").val("");
	$(form+" .select-del").prop('selectedIndex',0);
	$('.form-group').removeClass('issue');
	$('.form-group').removeClass('validate');
	$('.help-block').html("");
	  
}

function limpiarFiltrosv2(form){
	$(form+" input[type='text']").val("");
	$(form+" input[type='date']").val("");
	$(form+" .select-del").prop('selectedIndex',0);
	$('.form-group').removeClass('issue');
	$('.form-group').removeClass('validate');
	$('.help-block').html("");
	  
}

function limpiarDataTable(form){
	   var tablaMenus = $(form).dataTable();
	   tablaMenus.fnClearTable();
	}