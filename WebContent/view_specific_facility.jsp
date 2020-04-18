<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Facilities</title>
</head>
<body>

    <sql:setDataSource var="myDS"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/mac_managment1"
	user="root" password="root"/>
     
    <sql:query var="listUsers" dataSource="${myDS}">SELECT * FROM facilities where facilitytype='${facilitytype}' and facilityname='${facilityname}';</sql:query>

<div align="center">
        <table border="1" cellpadding="5">
	<caption>
	Facility Details</caption>
	<tr>
	<th>Facility Type</th>
	<th>Facility Name</th>
	<th>Interval</th>
	<th>Venue</th>
	<th>Status</th>
	
	</tr>
	<c:forEach var="facility" items="${listUsers.rows}">
                <tr>
	<td><c:out value="${facility.facilitytype}" /></td>
	<td><c:out value="${facility.facilityname}" /></td>
	<td><c:out value="${facility.intervalto}" /></td>
	<td><c:out value="${facility.venue}" /></td>
		<td><c:out value="${facility.status}" /></td>
	
	</tr>
            </c:forEach>
	</table>
    </div>
<form name="logout" action="/workordersystem/index.jsp" method="post">
 <br><br>
<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
</body>
</html>