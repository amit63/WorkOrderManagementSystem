<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<head>Add New Facility
<meta charset="ISO-8859-1">
<title>Add New Facility</title>
<h5 align="right"> <font color="red"> (*) Denotes Required Field</font></h5>
</head>
<body>
<br><br>
<form name="addfacilityform" action="/workordersystem/facilityController?addfacility" method="post">
 <table style="width: 700px; ">

    <tr>
    <td> Building Name (*): </td>
    <td> <input name="facilitytype" value="" type="text" maxlength="56"> </td>
  	  	<td> <input name="facilitytypeerror"  value= "${facilitytypeerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none;   disabled="disabled" maxlength="60"> </td>
 
  	</tr>
  	    <tr>
    <td> Room Number (*): </td>
    <td> <input name="facilityname" value="" type="text" maxlength="50"> </td>
 
    	<td> <input name="facilitynameerror"  value= "${facilitynameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none;  disabled="disabled" maxlength="60"> </td>
  
  	</tr>
 	 	  	
	<tr>
 	<td>
<input name="action" type="hidden" value="addfacility">
<input  type="submit" value="Submit">
 	</tr>
 	</table>
 </form>

 <form name="logout" action="/workordersystem/index.jsp" method="post">
 <br><br>
<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
</body>
</html>