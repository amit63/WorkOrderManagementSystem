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
<head>User Home Page
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>




<form name="viewprofileform" action="/workordersystem/profileController?viewprofile" method="post">
 <br> <br>

<input  name = "username" type=hidden value = "${check1}" > 	
<input name="action" type="hidden" value="viewprofile">
<input  type="submit" value="ViewProfile">

</form>

<form name="createmar" action="/workordersystem/reportController?createmar" method="post">
 <br>
<input  name = "username" type="hidden" value = "${check1}"> 	
<input name="action" type="hidden" value="createmar"> 
<input  type="submit" value="Submit Work Order"> <br> <br>
</form>


<a href="/workordersystem/search_user_mar.jsp?username=${check1}">Search MAR</a>
<br>

<!-- <form name="viewfacilityform" action="/workordersystem/facilityController?viewfacility" method="post">

<input name="action" type="hidden" value="viewfacility"> <br>
<input  type="submit" value="Search Facility"> <br> <br>
</form> -->

<form name="logout" action="/workordersystem/index.jsp" method="post">

<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
</body>
</html>