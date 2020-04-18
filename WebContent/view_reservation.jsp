<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Reservation</title>
</head>
<body>
    <sql:setDataSource var="myDS"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/mac_managment1"
	user="root" password="root"/>
     
    <sql:query var="listUsers" dataSource="${myDS}">SELECT * FROM reservation where repairer='<%=request.getParameter("username") %>' ;</sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
	<caption>
	Reservation List</caption>
	<tr>
	<th>Reservation Number</th>
	<th>Facility Name</th>
	<th>MAR Number</th>
	<th>Date</th>
	<th>Time slot</th>
	<th>Action</th>
	
	</tr>
	<c:forEach var="repair" items="${listUsers.rows}">
                <tr>
	<td><c:out value="${repair.reservationid}" /></td>
	<td><c:out value="${repair.facilityname}" /></td>
		<td><c:out value="${repair.mar_number}" /></td>
	<td><c:out value="${repair.repairdate}" /></td>
	<td><c:out value="${repair.intervalto}" /></td>
	<td><a href="/workordersystem/modify_reservation.jsp?username=${repair.reservationid}">View</a></td>
	
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