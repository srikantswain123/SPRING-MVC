<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" import="java.time.LocalDate"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1 style="color: red; text-align: center">
	<spring:message code="customer.submit" />
</h1>
<form:form action="customer" modelAttribute="cust">
	<table bgcolor="cyan" align="center">
		<tr>
			<td><spring:message code="customer.name" /></td>
			<td><form:input path="cname" /></td>
		</tr>
		<tr>
			<td><spring:message code="customer.addrs" /></td>
			<td><form:input path="cadd" /></td>
		</tr>
		<tr>
			<td><spring:message code="customer.amt" /></td>
			<td><form:input path="camt" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="customer.regist"/>"></td>
		</tr>
	</table>
</form:form>
<br>
<br>
<br>
<a href="?lang=en_US">English</a>
&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>
&nbsp;&nbsp;
<a href="?lang=od_OR">Odia</a>
&nbsp;&nbsp;
<a href="?lang=de_ZR">germany</a>
<hr>
<br>
<br>
<h1>
<fmt:setLocale value="${pageContext.response.locale}"/>
<fmt:formatDate value="${sysdate}" var="date" type="both"/>

<fmt:formatNumber var="amt" value="${amount}" type="currency"/>
sysdate::${date}<br><br>
Balance::${amt}

</h1>
