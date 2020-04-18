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
<title>Modify/Delete Reservation</title>
</head>
<body>


 <sql:setDataSource var="myDS"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/mac_managment1"
	user="root" password="root"/>
<sql:query var="listUsers" dataSource="${myDS}">SELECT * FROM reservation where reservationid='<%=request.getParameter("username") %>' ;</sql:query>

<form name="requestreservation" action="/workordersystem/reservationController?modifyreservation" method="post">
   
<br><br><br>

<table style="width: 600px; ">
<c:forEach var="repair" items="${listUsers.rows}">
    <tr>
    <td> Reservation Number (*): </td>
    <td>
<input  name = "reservationnumber" type="text" value = "<c:out value="${repair.reservationid}" />" style=" border: none;  background: transparent " readonly> 	
	</td>
 	</tr>

     	<tr>
    <td> Facility Name (*): </td>
    <td>
    <input  name = "facilityname" type="text" value = "<c:out value="${repair.facilityname}" />" style=" border: none;  background: transparent " readonly>
	</td>
 	</tr>
 	
 	    <tr>
    <td> MAR Number (*): </td>
    <td>
<input  name = "marnumber" type="text" value = "<c:out value="${repair.mar_number}" />" style=" border: none;  background: transparent " readonly> 	
	</td>
 	</tr>
 	 <%-- 	<tr>
 	<td>
 	Time Slot(*): </td>
 	<td> 	 
 	    <select name="interval" value="<c:out value="${repair.intervalto}" />">
			<option value = "60">1 hour</option>
			<option value = "120">2 hour</option>
			<option value = "30">30 mins</option>
		</select>
 
</td>
 	</tr> --%>
 	
  	<tr>
    <td> Date (*): </td>
    <td> 
        <input  name = "repairdate" type="text" value = "<c:out value="${repair.repairdate}" />" style=" border: none;  background: transparent " readonly>
 </td>
 	</tr>

 	
 	<tr>
 	<td>
 	<input name="action" type="hidden" value="modifyreservation"> <br>
<input  type="submit" value="Modify"> 
 	
 	</table>
 	</form>


 	<form name="logout" action="/workordersystem/reservationController?deletereservation" method="post">
 <br><br>
     <tr>
    <td>
<input  name = "reservationnumber" type="hidden" value = "<c:out value="${repair.reservationid}" />"> 	
	</td>
 	</tr>
 	<input name="action" type="hidden" value="deletereservation">
<input  type="submit" value="Delete"> <br> <br>
</c:forEach>
</form>
</body>
</html>