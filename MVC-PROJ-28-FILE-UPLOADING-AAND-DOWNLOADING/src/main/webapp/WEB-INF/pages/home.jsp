<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 style="color: red; text-align: center">FileUploading</h1>
<form:form modelAttribute="job" enctype="multipart/form-data">
	<table bgcolor="cyan" align="center" border="1">
		<tr>
			<td>EnterName</td><td><form:input path="jsname" /></td>
		</tr>
		<tr>
			<td>EnterQlfy</td><td><form:input path="jsqlfy" /></td>
		</tr>
		<tr>
			<td>UploadPhoto</td><td><input type="file" name="jsphoto" /></td>
		</tr>
		<tr>
			<td>UploadResume</td><td><input type="file" name="jsresume" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="submit"/></td>
		</tr>
	</table>
</form:form>