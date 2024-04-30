<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.gms.Db.ConnectionDb"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Participants</title>
<style>
    .form-container {
        margin: auto;
        width: 60%;
        border: 3px solid #009999;
        border-radius: 20px;
        padding: 20px;
        margin-top: 50px;
        background-color: #cce6ff;
    }
    body {
        background-image: url('https://zoesafe.com/wp-content/uploads/2020/12/gym.jpg');
    }
</style>
</head>
<body>
<!-- List of Participants -->
<h1 align="center">Show Participants</h1>
<table class="form-container">
    <tr>
        <td><b>Pid</b></td>
        <td><b>Name</b></td>
        <td><b>Phone</b></td>
        <td><b>Email</b></td>
        <td><b>BatchId</b></td>
    </tr>

    <%
        Connection con = ConnectionDb.getConn();
        Statement statement = con.createStatement();
        // Check if batch_id parameter exists in the request
        String batchId = request.getParameter("batch_id");
        // If batch_id parameter is not null or empty, filter by batch ID
        String query = "SELECT * FROM participant";
        if (batchId != null && !batchId.isEmpty()) {
            query += " WHERE batch_id = '" + batchId + "'";
        }
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
    %>

    <tr>
        <td><%= resultSet.getInt(1) %></td>
        <td><%= resultSet.getString(2) %></td>
        <td><%= resultSet.getString(3) %></td>
        <td><%= resultSet.getString(4) %></td>
        <td><%= resultSet.getInt(5) %></td>
    </tr>

    <%
        }
    %>
</table>
<div align="center">
     <a href="index.html">Home</a>
</div>
</body>
</html>
