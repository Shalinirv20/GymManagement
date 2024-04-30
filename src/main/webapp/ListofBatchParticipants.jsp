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
<title>Participant List</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
 
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
<script>
    function filterParticipants() {
        var batchId = document.getElementById("batch_id").value;
        // Redirect to the same page with the batch ID as a query parameter
        window.location.href = "showParticipants.jsp?batch_id=" + batchId;
    }
</script>
</head>
<body>
<!-- Participant List Form -->
<div class="form-container" align="center">
    <h2>Participant List</h2>
    <form >
        
        <label for="batch_id"></label>
        <input type="text" class="form-control" id="batch_id" name="batch_id" placeholder="Enter Batch Id" required>
               <br>
        <button type="button" onclick="filterParticipants()" class="btn btn-primary">Search</button>
    </form>
</div>


<table >
    
    <%
        Connection con = ConnectionDb.getConn();
        Statement statement = con.createStatement();
        // Get the batchId from the request parameter
        String batchId = request.getParameter("batch_id");
        if (batchId != null && !batchId.isEmpty()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM participant WHERE batch_id = '" + batchId + "'");
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
        }
    %>
</table>

 <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
