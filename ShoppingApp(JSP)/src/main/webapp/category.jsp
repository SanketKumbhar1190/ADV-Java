<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
</head>
<body>
    <h2>Product Categories</h2>
    <p>Welcome, <%= session.getAttribute("username") %>!</p>
    
    <table border='1'>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
        </tr>

        <%
        Connection dbConnection = null;
        PreparedStatement psCategory = null;
        ResultSet result = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/advjavab2", "root", "cdac");
            psCategory = dbConnection.prepareStatement("select * from category");
            
            result = psCategory.executeQuery();
            
            while(result.next()) {
        %>
            <tr>
                <td><%=result.getString("categoryName")%></td>
                <td><%=result.getString("categoryDescription")%></td>
                <td><img src='Images/<%=result.getString("categoryImageUrl")%>' height='60px' width='60px'/></td>
            </tr>
        <%
            }
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            if(result != null) result.close();
            if(psCategory != null) psCategory.close();
            if(dbConnection != null) dbConnection.close();
        }
        %>
    </table>
    
    <br/>
    <a href="logout.jsp">Logout</a>
</body>
</html>
