<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<noscript>
<h1 style="color:red;text-align:center">Plz Enable JavaScript</h1>
</noscript>


<script type="text/javascript" src="js/validation.js"></script>
<body class="bg-black">
	<form:form action="customer" method="POST" modelAttribute="cust"
		onsubmit="return validate(this)">
		<div class="table-responsive">
			<h1 align="center" class="text-danger">Customer Registration</h1>
			<table border="1" align="center" class=".active">
				<%-- <p><form:errors path="*" /></p> --%>
				<tr>
					<td class="text-success">CUSTOMER ID</td>
					<td><form:input path="cid" readonly="true" /></td>
				</tr>
				<tr>
					<td class="text-success">CUSTOMER NAME</td>
					<td><form:input path="cname" /> <form:errors
							style="color:red" path="cname" /><span id="cnameErr"
						style="color: green">*</span></td>

				</tr>
				<tr>
					<td class="text-success">CUSTOMER ADDRESS</td>
					<td><form:input path="cadd" /> <form:errors style="color:red"
							path="cadd" /><span id="caddErr" style="color: green">*</span></td>

				</tr>
				<tr>
					<td class="text-success">BILL AMOUNT</td>
					<td><form:input path="camt" /> <form:errors style="color:red"
							path="camt" /><span id="camtErr" style="color: green">*</span></td>

				</tr>
				<tr>
					<td colspan="2" class="text-success"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
		</div>
		<form:hidden path="vflag" />
	</form:form>
</body>