<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>


<table bgcolor="cyan" align="center">
  <form:form modelAttribute="stu"  action="submit">
  <tr><td><spring:message code="student.id"/></td><td><form:input path="id"/></td></tr>
  <tr><td><spring:message code="student.name"/></td><td><form:input path="name"/></td></tr>
  <tr><td><spring:message code="student.addrs"/></td><td><form:input path="addrs"/></td></tr>
  <tr><td><spring:message code="student.age"/></td><td><form:input path="age"/></td></tr>
  <tr><td><input type="submit" value="submit"/></td></tr>
  </form:form>
</table>

<br>
<a href="welcome?lang=hi_IN">HINDI</a>

