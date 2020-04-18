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
<title>User Profile</title>
</head>
<body>


<table>
  <tr>
   <td>
    <form name="profileform" action="/workordersystem/profileController?updateprofile1" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> UserName: </td>
    <td> <input name="username" value="${username}" type="text" maxlength="16" style=" border: none;  background: transparent " readonly > </td>
  	<td> <input name="usernameerror"  value= "${usernameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60" > </td>
  	</tr>

    <tr>
    <td> Password: </td>
    <td> <input name="password" value="${password}" type="password" maxlength="45">  </td>
    <td> <input name="passworderror"  value= "${passworderror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
 	</tr>
 	
 	<tr>
    <td> LastName: </td>
    <td> <input name="lastname" value="${lastname}" type="text" maxlength="45" style=" border: none;  background: transparent " readonly>  </td>
    <td> <input name="lastnameerror"  value= "${lastnameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
 	</tr>
 	
 	<tr>
    <td> FirstName: </td>
    <td> <input name="firstname" value="${firstname}" type="text" maxlength="45" style=" border: none;  background: transparent " readonly>  </td>
 	 <td> <input name="firstnameerror"  value= "${firstnameerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    </tr>
 	
 	<tr>
    <td> Phone: </td>
    <td> <input name="phone" value="${phone1}" type="text" maxlength="45">  </td>
 	<td> <input name="phoneerror"  value= "${phoneerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    </tr>
 	
 	<tr>
    <td> Email: </td>
    <td> <input name="email" value="${email}" type="email" maxlength="45">  </td>
 	<td> <input name="emailerror"  value= "${emailerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    </tr>
 	<%-- <tr>
    <td> UTA ID: </td>
    <td> <input name="uta_id" value="${uta_id1}" type="uta_id" maxlength="45" style=" border: none;  background: transparent " readonly>  </td>
 	<td> <input name="utaiderror"  value= "${utaiderror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    </tr> --%>
 	
 	
 	
	<tr>
    <td> Address: </td>
    <td> <input name="address" value="${address}" type="text" maxlength="100">  </td>
 	<td> <input name="addresserror"  value= "${addresserror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    </tr>
<%--  	 	<tr>
    <td> City: </td>
    <td> <input name="city" value="${city}" type="text" maxlength="50">  </td>
 	<td> <input name="cityerror"  value= "${cityerror}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr> --%>
 	<tr>
    <td> State : </td>
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
    <td> ZipCode: </td>
    <td> <input name="zipcode" value="${zipcode1}" type="text" maxlength="50">  </td>
 	 <td> <input name="zipcodeerror"  value= "${zipcodeerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60"> </td>
    </tr>
 	
 	<tr>
    <td> Role: </td>
    <td>
		 <input name="role" value="${role}" type="text" maxlength="50" style=" border: none;  background: transparent " readonly>  </td>
	
 	</tr>
 	<tr>

    <td>
<input name="action" type="hidden" value="updateprofile1">
<input  type="submit" id="logout" value="updateprofile1"> </td>
	

 	<tr>   
 	



</form>


<form name="logout" action="/workordersystem/index.jsp" method="post">
 <br><br>
<input  type="submit" value="Logout"> <br> <br>
</form>
</table>
</body>
</html>