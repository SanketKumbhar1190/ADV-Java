<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Registration</title>
</head>
<body>
    <h3>User Registration</h3>
    
    <form action="confirmUser.jsp" method="post">
        User name : <input type="text" name="username" required/><br/><br/>
        Password : <input type="password" name="password" required/><br/><br/>
        Name : <input type="text" name="name" required/><br/><br/>
        Email : <input type="email" name="email" required/><br/><br/>
        City : <input type="text" name="city"/><br/><br/>
        <input type="submit" value="Register"/>
    </form>
    
    <br/>
    <a href="login.jsp">Already have an account? Login</a>
</body>
</html>

