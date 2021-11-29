<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: green; text-align: center">EmployeeAllDetails</h1>

<table border="1" align="center" bgcolor="#8080ff">
	<c:choose>
		<c:when test="${!empty pageEmpList.getContent()}">
			<tr>
				<th>EmployeeId</th>
				<th>EmployeeName</th>
				<th>EmployeeAddress</th>
				<th>EmployeeDesgination</th>
				<th>EmployeeSallary</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="et" items="${pageEmpList.getContent()}">
				<tr>
					<td>${et.eid}</td>
					<td>${et.ename}</td>
					<td>${et.eadd}</td>
					<td>${et.desg}</td>
					<td>${et.esal}</td>
					<td><a href="edit?no=${et.eid}"><img alt="Edit" src="images/edit.png"
							height="30px;" width="30px;" autofocus="autofocus"></a></td>
					<td><a href="delete?no=${et.eid}" onclick="return confirm('Aru you sure to delete?')"><img alt="Delete"
							src="images/delete.jpg" height="30px;" width="30px;" autofocus="autofocus"></a></td>
				</tr>
			</c:forEach></table>
			<p style="color:blue;text-align:center">
			<c:if test="${!pageEmpList.isFirst()}">
			  <a href="report_paging?page=${pageEmpList.getNumber()-1}">Previous</a>
			</c:if>
			<c:forEach var="i" begin="0" end="${pageEmpList.getTotalPages()-1}" >
			  <a href="report_paging?page=${i}">${i+1}</a>
			</c:forEach>
			<c:if test="${!pageEmpList.isLast()}">
			  <a href="report_paging?page=${pageEmpList.getNumber()+1}">Next</a>
			</c:if>
			</p>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No Record Found</h1>
		</c:otherwise>
	</c:choose>

<h1 style="color:green;text-align:center">${updateResult}</h1>
<h1 style="color:green;text-align:center">${deleteObject}</h1>

