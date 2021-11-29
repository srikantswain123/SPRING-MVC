<%@ page isELIgnored="false"%>
<%@  taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<head>
<title><tiles:insertAttribute name="title"/></title>
</head>
<table border="1" height="100%" width="100%">
  <tr height="20%">
    <td colspan="2" bgcolor="green"><tiles:insertAttribute name="header"/></td>
  </tr>
  <tr height="70%">
   <td width="20%" bgcolor="cyan"><tiles:insertAttribute name="menu"/></td>
   <td width="80%"  ><tiles:insertAttribute name="body"/></td>
  </tr>
  <tr height="10%">
   <td colspan="2" bgcolor="green"><tiles:insertAttribute name="footer"/></td>
  </tr>
</table>

