<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align="center" border="1" bgcolor="cyan">

	<c:choose>
		<c:when test="${!empty jobdata }">
			<tr>
				<th>Jobid</th>
				<th>Name</th>
				<th>Qualification</th>
				<th>Photo</th>
				<th>Resume</th>
			</tr>
			<c:forEach var="js" items="${jobdata}">
				<tr>
					<td>${js.jsid}</td>
					<td>${js.jsname}</td>
					<td>${js.jsqlfy}</td>
					<td><a href="download?fname=${js.jsphoto}">Download</a></td>
					<td><a href="download?fname=${js.jsresume}">Download</a></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No data Found For
				Downlaod</h1>
		</c:otherwise>
	</c:choose>
</table>

