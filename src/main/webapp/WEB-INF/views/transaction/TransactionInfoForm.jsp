<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="TransactionInfoForm" commandName="transactionInfo" method="post" action="${actionUrl }" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<div class="pure-control-group">
			<label for="transactionId">Transaction Id</label>
			<form:input name = "transactionId" path="transactionId" placeholder="Transaction Id" />
		</div>
		<div class="pure-control-group">
			<label for="transactionDate">Transaction Date</label>	
			<form:input path="transactionDate"
				placeholder="YYYY-MM-DD" class="datepicker" />
		</div>
		<div class="pure-control-group">
			<label for="transactionStatus">Transaction Status</label>
			
			<form:select path="transactionStatus" placeholder="transactionStatus">
			<form:option value="Initiated">Initiated</form:option>  
             <form:option value="InProgress">In Progress</form:option>  
                <form:option value="Success">Success</form:option>  
                <form:option value="No transaction">No transaction</form:option>  
            </form:select>
		</div>

	</fieldset>
</form:form>