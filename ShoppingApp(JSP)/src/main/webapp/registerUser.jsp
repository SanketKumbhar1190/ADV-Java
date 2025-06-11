<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Complete</title>
</head>
<body>
    <jsp:useBean id="objUser" scope="session" 
    type="com.shop.beans.User"/>

    <%
    Connection dbConnection = null;
    PreparedStatement psUser = null;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/advjavab2", "root", "cdac");
        psUser = dbConnection.prepareStatement("insert into assign1 (username, password, name, email) values(?,?,?,?)");
        
        psUser.setString(1, objUser.getUserName());
        psUser.setString(2, objUser.getPassword());
        psUser.setString(3, objUser.getName());
        psUser.setString(4, objUser.getEmail());
        
        psUser.executeUpdate();
        
        out.println("<h3 style='color: green;'>User registered successfully!</h3>");
        out.println("<p>Welcome " + objUser.getName() + "! You can now login with your credentials.</p>");
        
    } catch(Exception e) {
        out.println("<h3 style='color: red;'>Registration failed!</h3>");
        out.println("<p>Error: " + e.getMessage() + "</p>");
    } finally {
        if(psUser != null) psUser.close();
        if(dbConnection != null) dbConnection.close();
    }
    %>
    
    <br/>
    <a href="login.jsp">Go to Login</a>
</body>
</html>
