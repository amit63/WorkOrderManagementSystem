<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
    background-color: #F8F8FF;
    vertical-align: middle;
}

input {
  font-family: "Times New Roman", Times, serif;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>


    <sql:setDataSource var="myDS"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/mac_managment1"
	user="root" password="root"/>
     
    <sql:query var="listUsers" dataSource="${myDS}">SELECT * FROM action_report where reporteddate='${reporteddate1}';</sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
	<caption>
	MAR</caption>
	<tr>
	<th>MAR Number</th>
	<th>Building Name</th>
	<th>Room Number</th>
	<th>Description</th>
   	<th>Reported by</th>
   	<th>Reported Date</th>
   	<th>Urgency</th>
   	<th>Assigned to</th>
   	<th>Status</th>
	</tr>
	<c:forEach var="mar" items="${listUsers.rows}">
                <tr>
	<td><c:out value="${mar.mar_number}" /></td>
	<td><c:out value="${mar.facilitytype}" /></td>
	<td><c:out value="${mar.facilityname}" /></td>
	<td><c:out value="${mar.description}" /></td>
	<td><c:out value="${mar.reportedby}" /></td>
	<td><c:out value="${mar.reporteddate}" /></td>
	<td><c:out value="${mar.urgency}" /></td>
		<td><c:out value="${mar.assignedto}" /></td>
		<td><c:out value="${mar.status}" /></td>			
		<td><a href="/workordersystem/assign_mar.jsp?username=${mar.mar_number}">Assign</a></td>
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