function addCurrencyPrice() {
	$('#currencyDialog').dialog("option", "CurrencyPrice", 'Add CurrencyPrice');
	$('#currencyDialog').dialog('open');
}

function editCurrencyPrice(id) {

	$.get("get/" + country, function(result) {

		$("#currencyDialog").html(result);
		$('#currencyDialog').dialog("option", "CurrencyPrice", 'Edit CurrencyPrice');
		$("#currencyDialog").dialog('open');
		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#currencyDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#CurrencyInfoForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#CurrencyInfoForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
