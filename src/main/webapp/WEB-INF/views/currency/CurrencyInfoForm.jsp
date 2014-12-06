<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="CurrencyInfoForm" commandName="currencyInfo" method="post" action="${actionUrl }" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>
		<div class="pure-form pure-form-aligned">
			<label for="country">Country</label>
			<form:select path="country" placeholder="country">
			<form:option value="Bulgaria">Bulgaria</form:option>  
			<form:option value="India">India</form:option>  
			<form:option value="Poland">Poland</form:option>  
             <form:option value="Romania">Romania</form:option>  


            </form:select>
            
		</div>
		
		<div>
			<tr>
			</tr>
		</div>
		
		<div class="pure-form  pure-form-aligned">	<label for="currencyPrice">Currency Price</label>
			<form:input name = "currencyPrice" path="currencyPrice" placeholder="Today's Price" />
		</div>
	
	</fieldset>
</form:form>