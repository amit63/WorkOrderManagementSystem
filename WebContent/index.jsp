<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
    /* //background-color: #F8F8FF; */
    vertical-align: middle;
    background-image: url('w.jpg');
}

input {
  font-family: "Times New Roman", Times, serif;
  color: #18B0C7
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<h1> <img src="e2_50.jpg"><center><font color="#144A80" size="10">Work Order Management System</font></center></h1>
<h5 align="right"> <font color="red"> (*) Denotes Required Field</font></h5>


</head>
<body style = vertical-align: middle;>
<center>
<br><br><br>
<a href=index.jsp  target="_top"><span> Login</span>



</a><br><br>

<table style = margin-left:auto;margin-right:auto;vertical-align: middle;>
  <tr>
   <td>
    <form name="loginform" action="/workordersystem/profileController?login" method="post">
    <center>
    <table style = margin-left:auto;margin-right:auto;vertical-align: middle;>
    <tr>
    <center>
    <td> UserName(*): </td>
    <td > <input color= "#18B0C7" name="username" value="" type="text" maxlength="17" placeholder="username" > 
    <input name="usernameerror"  value= "${usernameerror}" type="text"  style ="background-color:rgba(0, 0, 0, 0); color: red; border: none;   disabled="disabled"; maxlength="30"> </td>
    </center>
  	</tr>
    <tr> 
    <center>
    <td> Password(*): </td>
    <td > <input name="password" color= "#18B0C7" value="" type="password" maxlength="45">  
        <input name="passworderror"  value= "${passworderror}" type="text"  style ="background-color:rgba(0, 0, 0, 0); color: red; border: none; disabled="disabled";  maxlength="30"> </td>
    </center>
 	</tr>
 	<tr>
 	<td>
 	
 	
<input name="action" type="hidden" value="Login">
<input  type="submit" value="Login"><br><br>




<a href=register.jsp  target="_top"><span> Register

<%
session.removeAttribute("usernameerror");
session.removeAttribute("passworderror");
session.removeAttribute("username");
session.removeAttribute("password");
session.removeAttribute("lastname");
session.removeAttribute("firstname");
session.removeAttribute("phone");
session.removeAttribute("email");
session.removeAttribute("uta_id");
session.removeAttribute("address");
session.removeAttribute("zipcode");

%>
</span></a>

</center>
</form>
</table>

        <input name="loginerror"  value= "${loginerror}" type="text"  style ="background-color:rgba(0, 0, 0, 0); color: red; border: none;  disabled="disabled" maxlength="60"> </td>
  <br>
  </center>
</body>
</html>