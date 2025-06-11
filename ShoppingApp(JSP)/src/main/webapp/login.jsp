<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Time Server</title>
<style>
    body { font-family: Arial, sans-serif; margin: 50px; }
    form { max-width: 300px; }
    input[type="text"], input[type="password"] { 
        width: 100%; padding: 8px; margin: 5px 0; 
    }
    input[type="submit"] { 
        background-color: #4CAF50; color: white; padding: 10px 20px; 
        border: none; cursor: pointer; 
    }
</style>
</head>
<body>
    <h3>Welcome to the Time Server</h3>
    
    <form action="authenticate.jsp" method="post">
        User Name: <input type="text" name="username" required/><br/>
        Password: <input type="password" name="password" required/><br/>
        <input type="submit" value="Login"/>
    </form>
    
    <br/>
    <a href="newUser.jsp">New User? Register Here</a>
</body>
</html>