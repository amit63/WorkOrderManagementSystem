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
<head>MAR Form
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Work Order</title>
<h5 align="right"> <font color="red"> (*) Denotes Required Field</font></h5>
</head>
<body>


<sql:setDataSource var="myDS"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/mac_managment1"
	user="root" password="root"/>
     
    <sql:query var="listUsers" dataSource="${myDS}">SELECT * FROM facilities ;</sql:query>
     


<table>
  <tr>
   <td>
    <form name="createmarform" action="/workordersystem/reportController?writemar" method="post">
    <table style="width: 1200px; ">
 	
 	<tr>
 	<td> Building Name (*): </td>
		  <td>  <select name="facilitytype">
		    <c:forEach var="facility" items="${listUsers.rows}">
		
			<option value = "<c:out value="${facility.facilitytype}" />"><c:out value="${facility.facilitytype}" /></option>
			</c:forEach>
		</select></td></tr>
		
		<tr>
<td>Room number (*):  	</td>
<td>	    <select name="facilityname">
		    <c:forEach var="facility" items="${listUsers.rows}">
		
			<option value ="<c:out value="${facility.facilityname}" />"><c:out value="${facility.facilityname}" /></option>
			</c:forEach>
		</select></td>
 	</tr>



 	 <tr>
    <td> Urgency (*): </td>
    <td>
	    <select name="urgency">
			<option value = "Major">Major</option>
			<option value = "Medium">Medium</option>
			<option value = "Minor">Minor</option>
	
		</select>
	</td>
 	</tr> 
 	
 	
 	  <tr>
    <td> Description (*): </td>
    <td> <TEXTAREA name="description" value="" ROWS="5" COLUMNS="7" placeholder="Write something here" ></TEXTAREA>
             <input name="facilitydecriptionerror"  value= "${facilitydecriptionerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none"  maxlength="60">
    
          </td>
 	</tr>
 	

    <tr>
    <td> Reported by (*): </td>
    <td> <input name="reportedby" value="${check1}" type="text" maxlength="10" style=" border: none;  background: transparent " readonly>
  </td>
 	</tr>
 	
 	<tr>
    <td> Date (*): </td>
    <td> <input type="text"  name="reporteddate"
       value="" placeholder="yyyy-mm-dd"
      > 
 	<input name="facilitydateerror"  value= "${facilitydateerror}" type="text"  style ="background-color: #F8F8FF; color: red; border: none; "  disabled="disabled" maxlength="60">
   </td> </tr>
 	
 	<tr>
 	<td>
 	<input name="action" type="hidden" value="writemar"> <br> <br>
<input  type="submit" value="Submit Work Order"> <br> <br>

 	
</form>

<form name="logout" action="/workordersystem/index.jsp" method="post">
 <br><br>
<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
</table>
</body>
</html>