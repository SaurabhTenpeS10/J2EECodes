<%@page import="com.jspiders.servelets.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.jspiders.servelets.userdb.DataAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    h1 {
        color: #333;
    }

    table {
        width: 80%;
        margin: 20px 0;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
        color: #555;
        font-weight: bold;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    a {
        color: #007bff;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    .container {
        width: 100%;
        display: flex;
        justify-content: center;
    }

    .message {
        color: #777;
        font-size: 18px;
        text-align: center;
    }
</style>
</head>
<body>
    
    <h1>Users:</h1>
    <%! DataAccess dataAccess = new DataAccess(); %>
    <%
        List<User> users = dataAccess.findAllUsers();
        if (users.size() > 0) {
    %>
    <div class="container">
    <table>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        <% 
            for (User user : users) {
        %>
        <tr> 
            <td><%=user.getUsername() %></td>
            <td><%=user.getEmail() %></td>
            <td><%=user.getMobile() %></td>
            <td><%=user.getPassword() %></td>
            <td>
                <a href="./update-user?email=<%= user.getEmail()%>">Update</a> | 
                <a href="./delete-user?email=<%= user.getEmail()%>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
    </div>
    <%
        } else {
    %>
    <div class="message">
        <h2>Users not found</h2>
    </div>
    <%
        } 
    %>
</body>
</html>
