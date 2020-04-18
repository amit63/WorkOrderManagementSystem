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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<h1> <center><font color="#1B8464">Work Order Management System</font></center></h1>
<h5 align="right"> <font color="red"> (*) Denotes Required Field</font></h5>

</head>
<body>
<br><br>
<table>
  <tr>
   <td>
    <form name="registerform" action="/workordersystem/profileController?register" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> UserName (*): </td>
    <td> <input name="username" value="${username}" type="text" maxlength="16"> </td>
    <td> <input name="usernameerror"  value= "${usernameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    
  	</tr>

    <tr>
    <td> Password (*): </td>
    <td> <input name="password" value="" type="password" maxlength="45">  </td>
    <td> <input name="passworderror"  value= "${passworderror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
 	</tr>
 	
 	<tr>
    <td> LastName (*): </td>
    <td> <input name="lastname" value="${lastname}" type="text" maxlength="45">  </td>
    <td> <input name="lastnameerror"  value= "${lastnameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    
 	</tr>
 	
 	<tr>
    <td> FirstName (*): </td>
    <td> <input name="firstname" value="${firstname}" type="text" maxlength="45">  </td>
    <td> <input name="firstnameerror"  value= "${firstnameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    
 	</tr>
 	
 	<tr>
    <td> Phone (*): </td>
    <td> <input name="phone" value="${phone}" type="text" maxlength="45">  </td>
    <td> <input name="phoneerror"  value= "${phoneerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    
 	</tr>
 	
 	<tr>
    <td> Email (*): </td>
    <td> <input name="email" value="${email}" type="text" maxlength="45">  </td>
    <td> <input name="emailerror"  value= "${emailerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    
 	</tr>
 	<tr>
    <%-- <td> UTA ID (*): </td>
    <td> <input name="uta_id" value="${uta_id}" type="text" maxlength="45">  </td>
    <td> <input name="utaiderror"  value= "${utaiderror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    
 	</tr> --%>
	<tr>
    <td> Address (*): </td>
    <td> <input name="address" value="${address}" type="text" maxlength="100">  </td>
    <td> <input name="addresserror"  value= "${addresserror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    
 	</tr>
 	
<%--  	
 	 	<tr>
    <td> City (*): </td>
    <td> <input name="city" value="${city}" type="text" maxlength="50">  </td>
    <td> <input name="cityerror"  value= "${cityerror}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    
 	</tr> --%>
 	
 	<tr>
    <td> State (*): </td>
    <td>
	    <select name="state">
			<option value="AL">Alabama</option>
	<option value="AK">Alaska</option>
	<option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option>
	<option value="CA">California</option>
	<option value="CO">Colorado</option>
	<option value="CT">Connecticut</option>
	<option value="DE">Delaware</option>
	<option value="DC">District Of Columbia</option>
	<option value="FL">Florida</option>
	<option value="GA">Georgia</option>
	<option value="HI">Hawaii</option>
	<option value="ID">Idaho</option>
	<option value="IL">Illinois</option>
	<option value="IN">Indiana</option>
	<option value="IA">Iowa</option>
	<option value="KS">Kansas</option>
	<option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option>
	<option value="ME">Maine</option>
	<option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option>
	<option value="MI">Michigan</option>
	<option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option>
	<option value="MO">Missouri</option>
	<option value="MT">Montana</option>
	<option value="NE">Nebraska</option>
	<option value="NV">Nevada</option>
	<option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option>
	<option value="NM">New Mexico</option>
	<option value="NY">New York</option>
	<option value="NC">North Carolina</option>
	<option value="ND">North Dakota</option>
	<option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option>
	<option value="OR">Oregon</option>
	<option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option>
	<option value="SC">South Carolina</option>
	<option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option>
	<option value="TX">Texas</option>
	<option value="UT">Utah</option>
	<option value="VT">Vermont</option>
	<option value="VA">Virginia</option>
	<option value="WA">Washington</option>
	<option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option>
	<option value="WY">Wyoming</option>
		</select>
	</td>
 	</tr>
 	
 	<tr>
    <td> ZipCode (*): </td>
    <td> <input name="zipcode" value="${zipcode}" type="text" maxlength="50">  </td>
    <td> <input name="zipcodeerror"  value= "${zipcodeerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none;   disabled="disabled" maxlength="60"> </td>
    
 	</tr>
 	
 	<tr>
    <td> Role (*): </td>
    <td>
	    <select name="role">
			<option value = "User">User</option>
			<option value = "FacilityManager">Facility Manager</option>
			<option value = "Repairer">Repairer</option>
			<option value = "Admin">Admin</option>
		</select>
	</td>
 	</tr>
<tr>
<td>
<input name="action" type="hidden" value="register">
<input  type="submit" value="Sign Up"></td></tr>
</form>



<a href=index.jsp  target="_top"><span> Login

<%
session.removeAttribute("usernameerror");
session.removeAttribute("passworderror");
session.removeAttribute("lastnameerror");
session.removeAttribute("firstnameerror");
session.removeAttribute("phoneerror");
session.removeAttribute("emailerror");
/* session.removeAttribute("utaiderror"); */
session.removeAttribute("addresserror");
session.removeAttribute("zipcodeerror");
%>
</span></a>
</table>
</body>
</html>
