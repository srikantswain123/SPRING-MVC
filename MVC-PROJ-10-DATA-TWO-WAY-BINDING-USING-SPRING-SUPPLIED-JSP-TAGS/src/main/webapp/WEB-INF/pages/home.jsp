<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:red;text-align:center">Student Registration</h1>
<form:form  method="POST" modelAttribute="stud">
<table border="1" align="center" bgcolor="cyan">
  <tr><td>Student no</td><td><form:input path="sno"/></td></tr>
  <tr><td>Student name</td><td><form:input path="sname"/></td></tr>
  <tr><td>Student addrs</td><td><form:input path="saddr"/></td></tr>
  <tr><td>Student marks</td><td><form:input path="smarks"/></td></tr>
  <tr><td colspan="2"><input type="submit" value="submit"></td></tr>
</table>
</form:form>
