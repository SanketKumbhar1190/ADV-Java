<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Registration</title>
</head>
<body>
    <h3>Confirm Your Registration Details</h3>

    <jsp:useBean id="objUser" 
    class="com.shop.beans.User" 
    scope="session"/>

    <jsp:setProperty name="objUser" property="*"/>
    
    <!-- Display user information for confirmation -->
    <p><strong>User Name:</strong> <jsp:getProperty name="objUser" property="userName"/></p>
    <p><strong>Name:</strong> <jsp:getProperty name="objUser" property="name"/></p>
    <p><strong>Email:</strong> <jsp:getProperty name="objUser" property="email"/></p>
    <p><strong>City:</strong> <jsp:getProperty name="objUser" property="city"/></p>
    
    <br/>
    <a href='registerUser.jsp'>Confirm Registration</a><br/>
    <a href='newUser.jsp'>Cancel and Edit</a><br/>

</body>
</html>
