<%@ page isELIgnored="false" import="java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table border="1" align="center" bgcolor="cyan">
  <tr>
    <th>No</th><th>Languajes</th>
  </tr>
  <tr>
    <c:set var="inc" scope="request" value="0" ></c:set>
   <c:forEach var="count" items="${lang}">
   
   <tr><td><c:out value="${inc=inc+1}"></c:out><td><c:out value="${count}"></c:out></td></tr>
   </c:forEach>
  </tr>
</table>
<a href="welcome.htm">home</a>

