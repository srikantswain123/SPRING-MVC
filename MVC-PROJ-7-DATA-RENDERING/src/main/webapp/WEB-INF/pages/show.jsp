<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<b>courses::${books}</b>
<hr>
<b>numbers::${numbers}</b>
<hr>
<b>author::${author}</b>
<hr>
<c:forEach var="col" items="${colors}">
  ${col}..
</c:forEach>

<hr>
<b>Employee details::${employee}</b>