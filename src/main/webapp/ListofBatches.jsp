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
<title>Insert title here</title>
<style>
        
        .form-container {
             margin: auto;
            width: 60%;
            border: 3px solid #009999;
            border-radius : 20px;
            padding: 20px;
            margin-top: 50px;
         background-color: #cce6ff;
           }body{
            background-image: url('https://zoesafe.com/wp-content/uploads/2020/12/gym.jpg');
        }
    </style>
</head>
<body>
<!--  All DOctor shows-->
    <h1 align="center">List of Batches</h1>
    <table class="form-container">
      <tr>
        <td><b>Batch Id</b></td>
        <td><b>StartDate</b></td>
        <td><b>Instructor</b></td>
        <td><b>MaxParticipants</b> </td>
       
        
       
      </tr>

      <%
        Connection con = ConnectionDb.getConn();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from batch");
        while (resultSet.next()) {
      %>

      <tr>
        <td>
          <%
            out.print(resultSet.getInt(1));
          %>
        </td>
        <td>
          <%
            out.print(resultSet.getString(2));
          %>
        </td>
        <td>
          <%
            out.print(resultSet.getString(3));
          %>
        </td>
        <td>
          <%
            out.print(resultSet.getString(4));
          %>
        </td>
        
         
        

        
      <%
}
%>


    </table>
    <div align="center">
    <a href="updateBatch.jsp">Update Batch</a> | <a href="deleteBatch.jsp">Delete Batch</a> | <a href="ListofBatchParticipants.jsp">Show Participants</a>
</div>

</body>
</html>