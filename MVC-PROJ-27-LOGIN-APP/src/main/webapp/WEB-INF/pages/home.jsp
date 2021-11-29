<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 style="colo: red; text-align: center">Authentication</h1>

<form:form modelAttribute="user">
	<table border="1" align="center" bgcolor="cyan">
		<tr>
			<td>Enter UserName</td>
			<td><form:input path="user" /></td>
		</tr>
		<tr>
			<td>Enter Password</td>
			<td><form:input path="pwd" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="login" /></td>
		</tr>
	</table>
</form:form>

<c:if test="${!empty result}">
<h1 style="color:red;text-align:center">${result}</h1>
</c:if>