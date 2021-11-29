<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form  modelAttribute="emp">
<table bgcolor="#33cc66" align="center" boredr="1">
<tr>
<td>EmployeeId</td><td><form:input path="eid" readonly="true"/></td></tr>
<tr><td>EmployeeName</td><td><form:input path="ename"/></td></tr>
<tr><td>EmployeeAddress</td><td><form:input path="eadd"/></td></tr>
<tr><td>EmployeeDesination</td><td><form:input path="desg"/></td></tr>
<tr><td>EmployeeSallary</td><td><form:input path="esal"/></td></tr>
<tr><td colspan="2"><input type="submit" align="center"  value="EditAndUpdate"/></td></tr>


</table>



</form:form>
