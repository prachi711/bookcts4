<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<style>
 form{
  
  background-color : #ffc;
  
 
  width:200px;border:1px dotted black;padding:25px;
  margin: 100px auto;
  }
  
</style>
<body>

<form action="registeruser" method="post">
<input type="text" name="name" align="top" placeholder="Name of user" class="form" ><br><br>
<input type="text" name="uname" align="top" placeholder="UserName" class="form"><br><br>
<input type="password" name="pname" align="top" placeholder="Password" class="form" ><br><br>
<input type="text" name="dob" align="top" placeholder="DOB" class="form" ><br><br>
<input type="text" name="address" align="top" placeholder="Address" class="form" ><br><br>


<input type="submit" value="Register" class="for">
	
</form>
</body>
</html>