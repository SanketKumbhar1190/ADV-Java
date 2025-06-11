<%@ page import="java.sql.Connection" pageEncoding="UTF-8"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentication</title>
</head>
<body>

<%
Connection dbConnection = null;
PreparedStatement psAuthenticate = null;
ResultSet resultAuthenticate = null;

try {
    String url = "jdbc:mysql://localhost:3306/advjavab2";
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    dbConnection = DriverManager.getConnection(url, "root", "cdac");
    
    psAuthenticate = dbConnection.prepareStatement("select * from assign1 where username=? and password=?");
    
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    
    psAuthenticate.setString(1, userName);
    psAuthenticate.setString(2, password);
    
    resultAuthenticate = psAuthenticate.executeQuery();
    
    if(resultAuthenticate.next()) {
        HttpSession userSession = request.getSession();
        userSession.setAttribute("username", userName);
        response.sendRedirect("category.jsp");
    } else {
        out.println("<font color='red'>Invalid username password</font>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.include(request, response);
    }
} catch(Exception e) {
    out.println("Error: " + e.getMessage());
    e.printStackTrace();
} finally {
    if(resultAuthenticate != null) resultAuthenticate.close();
    if(psAuthenticate != null) psAuthenticate.close();
    if(dbConnection != null) dbConnection.close();
}
%>

</body>
</html>