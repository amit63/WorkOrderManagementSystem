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
<head>Admin Home Page
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
<h5 align="right"> <font color="red"> (*) Denotes Required Field</font></h5>
</head>
<body>



<form name="viewprofileform" action="/workordersystem/profileController?viewprofile" method="post">
 <br> <br> <br>
	
<input  name = "username" type="hidden" value = "${check1}"> 	
<input name="action" type="hidden" value="viewprofile">
<input  type="submit" value="ViewProfile">


</form>

 <br> <br> <br>
<form name="viewuserprofileform" action="/workordersystem/profileController?viewuserprofile" method="post">
 
	View Specific user profile<br> <br>
<input  name = "username" type="text" value = "" placeholder="Enter username"> 
     <input name="usernameerror"  value= "${usernameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; disabled="disabled" maxlength="60">
  	 <br> <br>
<input name="action" type="hidden" value="viewprofile1">
<input  type="submit" value="View User Profile">


</form>

 <br> <br> <br>
<form name="changeroleform" action="/workordersystem/profileController?changerole" method="post">
 
	Change Role<br> <br>
<input  name = "user" type="text" value = "" placeholder="Enter username"> 
     <input name="usernameerror1"  value= "${usernameerror1}" type="text"  style ="background-color: #F8F8FF; color: red; border: none;  disabled="disabled" maxlength="60">
  
	    <select name="role">
			<option value = "User">User</option>
		    <option value = "FacilityManager">Facility Manager</option>
			<option value = "Repairer">Repairer</option>
			<option value = "Admin">Admin</option>				
		</select><br> <br>
<input name="action" type="hidden" value="changerole">
<input  type="submit" value="Change">


</form>
<form name="logout" action="/workordersystem/index.jsp" method="post">
 <br><br>
<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
</body>
</html>