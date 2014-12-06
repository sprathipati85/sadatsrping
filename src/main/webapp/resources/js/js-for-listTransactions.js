function addTransaction() {
	$('#transactionDialog').dialog("option", "title", 'Add Transaction');
	$('#transactionDialog').dialog('open');
}

function editTransaction(id) {

	$.get("get/" + id, function(result) {

		$("#transactionDialog").html(result);

		$('#transactionDialog').dialog("option", "title", 'Edit Transaction');

		$("#transactionDialog").dialog('open');

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

	$('#transactionDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#TransactionInfoForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#TransactionInfoForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
