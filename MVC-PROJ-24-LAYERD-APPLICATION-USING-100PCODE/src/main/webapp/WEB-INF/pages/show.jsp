<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
</head>

<div class="bg-info" align="center" >
 <c:choose>
	<c:when test="${!empty empDetails }">
	<h1 class="text-dark">Result page</h1>
	<table class="table-bordered table-hover">
	<tr class="text-warning" >
		<td class="font-weight-bold">EMPLOYEE NO</td>
		<td class="font-weight-bold">EMPLOYEE NAME</td>
		<td class="font-weight-bold">JOB</td>
		<td class="font-weight-bold">SALLARY</td>
	</tr>
	<c:forEach var="row" items="${empDetails}">
		<tr>
			<td>${row.eno}</td>
			<td>${row.ename}</td>
			<td>${row.job}</td>
			<td>${row.sal}</td>
		</tr>
	</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
	   <h1 class="danger">Details Not available</h1>
	</c:otherwise>
	</c:choose>
</div>
<div class="bg-secondary">
<center ><input type="button" value="Print" onclick="window.print()" /></center>
<br>
<center><a href="welcome" class="text-warning">HOME</a></center>
</div>
<div class="bg-dark" >
<marquee behavior="scroll" direction="down">
<pre class="text-warning">

Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle)and released in 1995 as a core component of Sun Microsystems' Java platform. The original and reference 
implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process,
 Sun had relicensed most of its Java technologies under the GNU General Public License. Oracle offers  its own HotSpot Java Virtual Machine, however the official reference implementation is the OpenJDK
JVM which is free open source software and used by most developers and is the default JVM for almost  all Linux distributions.
As of September 2020, the latest version is Java 15, with Java 11, a currently supported long-term support(LTS) version, released on September 25, 2018. Oracle released the last zero-cost public update for the legacy
 version Java 8 LTS in January 2019 for commercial use, although it will otherwise still support  Java 8 with public updates for personal use indefinitely. Other vendors have begun to offer zero-cost
  builds of OpenJDK 8 and 11 that are still receiving security and other upgrades.Oracle (and others) highly recommend uninstalling outdated versions of Java because of serious risks due to 
unresolved security issues.[22] Since Java 9, 10, 12, 13 and 14 are no longer supported, Oracle advises its users to immediately transition to the latest version (currently Java 15) or an LTS release.

</pre>
</marquee>



</div>
