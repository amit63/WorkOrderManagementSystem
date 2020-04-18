<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
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
<head>Facility Manager Home Page
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Facility Manager Home Page</title>
</head>
<body>


    <sql:setDataSource var="myDS"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/mac_managment1"
	user="root" password="root"/>
     
    <sql:query var="listUsers" dataSource="${myDS}">SELECT * FROM facilities ;</sql:query>
     
<br><br>

<form name="viewprofileform" action="/workordersystem/profileController?viewprofile" method="post">
 
<input  name = "username" type="hidden" value = "${check1}"> 	
<input name="action" type="hidden" value="viewprofile">
<input  type="submit" value="ViewProfile">

</form>


<form name="createmar" action="/workordersystem/reportController?createmar" method="post">
<input  name = "username" type="hidden" value = "${check1}"> 
<input name="action" type="hidden" value="createmar"> <br> <br>
<input  type="submit" value="Create MAR">

</form>
<br>
<form name="viewmarform" action="/workordersystem/reportController?viewmar" method="post">
<tr>
    <td> Date (*): </td>
   <td> <input type="text"  name="reporteddate" id="searchMARDate" value=""  placeholder="yyyy-mm-dd"> </td>
    <td> <input name="assignfacilitydateerror"  value= "${assignfacilitydateerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
   
 	</tr>
 	<tr>
 	<td>
 	<input name="action" type="hidden" value="viewmar"> <br> <br>
 	<input  type="submit" id="mar" value="Search MAR">
 	</td>
 	</tr>
</form>



<form name="viewaddfacilityform" action="/workordersystem/facilityController?viewaddfacility" method="post">
  <br>
<%-- <input  name = "username" type="hidden" value = "<%= session.getAttribute("check1")%>"> 	 --%>
<input name="action" type="hidden" value="viewaddfacility">
<input  type="submit" value="Add Facility">

</form>



<form name="viewfacilityform" action="/workordersystem/facilityController?viewfacility" method="post">
 <br>
<input name="action" type="hidden" value="viewfacility"> 
<input  type="submit" id= "SearchFacility" value="Search Facility"> <br> <br>
</form>


<form name="viewrepairscheduleform" action="/workordersystem/reservationController?viewrepairschedule" method="post">
 <br>
 
  		    <select name="repairer">
			<option value = "Repairer1">Repairer1</option>
			<option value = "Repairer2">Repairer2</option>
		</select>
<input name="action" type="hidden" value="viewrepairschedule">
<input  type="submit" value="View Repairer Schedule"> <br> <br>
</form>


<form name="viewspecificfacilityform" action="/workordersystem/facilityController?viewspecificfacility" method="post">
 <br>

Building Name (*): 
		    <select name="facilitytype">
		    <c:forEach var="facility" items="${listUsers.rows}">
		
			<option value = "<c:out value="${facility.facilitytype}" />"><c:out value="${facility.facilitytype}" /></option>
			</c:forEach>
		</select>
<br>   <br>   <br> 
 Room Number (*):  		    <select name="facilityname">
		    <c:forEach var="facility" items="${listUsers.rows}">
		
			<option value ="<c:out value="${facility.facilityname}" />"><c:out value="${facility.facilityname}" /></option>
			</c:forEach>
		</select>
<input name="action" type="hidden" value="viewspecificfacility"> <br> <br>
<input  type="submit" value="View Facility Details"> <br> <br>
</form>


<%
session.removeAttribute("assignfacilitydateerror");

%>
<form name="logout" action="/workordersystem/index.jsp" method="post">

<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
</body>
</html>