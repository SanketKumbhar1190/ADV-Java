<%@ page import="java.util.Iterator"%>
<%@ page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <table border='1'>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
        </tr>
        <%
            String data = (String)request.getAttribute("allContacts");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(data);
            Iterator<JsonNode> elements = root.elements();
            while(elements.hasNext()) {
                JsonNode oneElement = elements.next();
                String firstName = oneElement.path("firstName").asText();
                String lastName = oneElement.path("lastName").asText();
                String email = oneElement.path("email").asText();
                String phone = oneElement.path("phone").asText();
        %>
        <tr>
            <td><%=firstName%></td>
            <td><%=lastName%></td>
            <td><%=email%></td>
            <td><%=phone%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>