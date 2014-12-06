<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Sadat Exchange - List Of Currency Prices</title>

<link rel="stylesheet" 	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>
<link rel="stylesheet" 	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" 	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>


	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="css/bootstrap-theme.css" media="screen">
	<link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen" />
	<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css">

<style type="text/css">
th {
	text-align: left
}
</style>
</head>

<body>
<!-- Fixed navbar -->
	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#">
					<img src="../views/images/logo.png" alt="Sadat Exchange"></a>
			</div>
						</div>
									</div>

	<div style="width: 95%; margin: 0 auto;">

		<div id="currencyDialog" style="display: none;">
			<%@ include file="CurrencyInfoForm.jsp"%>
		</div>

		<h1>List Of Currency</h1>

		<button class="pure-button pure-button-primary" onclick="addCurrencyPrice()"> <i class="fa fa-plus"></i> Add Currency Price </button>
		<br>
		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="10%"></th>
					<th width="10%">Serial No</th>
				<!--  	<th width="25%">Currency ID</th> -->
					<th width="45%">Country</th>
					<th width="35%">Currency Price</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${currencyInfoList}" var="currencyInfo" varStatus="loopCounter">
					<tr>
					<td><c:out value="" /></td>
						<td><c:out value="${loopCounter.count}" /></td>
				<!--  		<td><c:out value="${currencyInfo.currencyId}" /></td> -->
						<td><c:out value="${currencyInfo.country}" /></td>
						<td><c:out value="${currencyInfo.currencyPrice}" /></td>

						<td><nobr>
								<button class="pure-button pure-button-primary" onclick="editCurrencyPrice(${currencyInfo.country});">
									<i class="fa fa-pencil"></i> Edit
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this CurrencyPrice?');"
									href="delete/${currencyInfo.country}"> <i class="fa fa-times"></i>Delete
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript" 	src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'> </script>
	<script type="text/javascript" 	src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript" 	src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript" 	src='<c:url value="/web-resources/js/js-for-listCurrency.js"/>'></script>
</body>
</html>