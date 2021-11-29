<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-black">
<form:form action="customer" method="POST" modelAttribute="cust">
<div class="table-responsive">
<h1 align="center"class="text-danger">Customer Registration</h1>
<table border="1" align="center" class=".active">
<tr><td class="text-success">CUSTOMER ID</td><td><form:input path="cid" readonly="true" /></td></tr>
<tr><td class="text-success">CUSTOMER NAME</td><td><form:input path="cname"/></td></tr>
<tr><td class="text-success">CUSTOMER ADDRESS</td><td><form:input path="cadd"/></td></tr>
<tr><td class="text-success">BILL AMOUNT</td><td><form:input path="camt"/></td></tr>
<tr><td colspan="2" class="text-success"><input type="submit" value="Register"/></td></tr>
</table>
</div>
</form:form>
</body>