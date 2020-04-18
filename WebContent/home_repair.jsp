<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<head>Repairer Home Page
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Repairer Home Page</title>
<h5 align="right"> <font color="red"> (*) Denotes Required Field</font></h5>
</head>
<body>

<br><br>
<form name="viewprofileform" action="/workordersystem/profileController?viewprofile" method="post">
 
<input  name = "username" type="hidden" value = "${check1}"> 	
<input name="action" type="hidden" value="viewprofile">
<input  type="submit" value="ViewProfile">


</form>


<form name="viewrepairscheduleform" action="/workordersystem/reservationController?viewrepairschedule" method="post">
 <br>
 <input  name = "repairer" type="hidden" value = "${check1}" placeholder="Repairer Name"> 
<input name="action" type="hidden" value="viewrepairschedule"> <br> <br>
<input  type="submit" value="View Repairer Schedule"> <br> <br>
</form>


<br><br>

<%-- <a href="/workordersystem/view_reservation.jsp?username=${check1}">View reservation</a>
<br>


<form name="viewfacilityform" action="/workordersystem/facilityController?viewfacility" method="post">
 <br>
<input name="action" type="hidden" value="viewfacility"> <br> <br>
<input  type="submit" value="Search Facility"> <br> <br>
</form>
 --%>


<form name="logout" action="/workordersystem/index.jsp" method="post">
 <br><br>
<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
</body>
</html>