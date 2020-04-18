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
<title>Assign MAR</title>
<h5 align="right"> <font color="red"> (*) Denotes Required Field</font></h5>
</head>
<body>


 <sql:setDataSource var="myDS"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/mac_managment1"
	user="root" password="root"/>
<sql:query var="listUsers" dataSource="${myDS}">SELECT * FROM action_report where mar_number='<%=request.getParameter("username") %>' ;</sql:query>

<form name="assignmarform" action="/workordersystem/reportController?assignmar" method="post">
<table>
<c:forEach var="assignmar" items="${listUsers.rows}">
 	<tr>
    <td> MAR Number(*): </td>
    <td> 

    
    <input name="marnumber" value="<c:out value="${assignmar.mar_number}" />" type="text" style=" border: none;  background: transparent " readonly>  </td>
 	</tr>
 	 	 	<tr>
 	<td>
 	Assign to (*): </td>
 	<td> 	    <select name="assignedto">
			<option value = "Repairer1">Repairer1</option>
			<option value = "Repairer2">Repairer2</option>
		</select></td>
 	</tr>
 	
 	
 	
	<tr>
    <td> Assign Date (*): </td>
    <td> <input type="text"  name="assigneddate"
       value="" placeholder="yyyy-mm-dd"
      > </td>
 	<td> <input name="assignfacilitydateerror"  value= "${assignfacilitydateerror}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
 	
 	<tr>
 	<td>
 	<input name="action" type="hidden" value="assignmar"> <br> <br>
<input  type="submit" value="Update"> <br> <br>
 	</td>
 	</tr>
 	
 	</c:forEach></table>
 	
 	</form>


<form name="logout" action="/workordersystem/index.jsp" method="post">
 <br><br>
<input  type="submit" id="logout" value="Logout"> <br> <br>
</form>
    
</body>
</html>