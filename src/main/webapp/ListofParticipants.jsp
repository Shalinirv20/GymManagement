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
    <h1 align="center">List of Participants</h1>
    <table class="form-container">
      <tr>
        <td><b>Pid</b></td>
        <td><b>Name</b></td>
        <td><b>Phone</b></td>
        <td><b>Email</b></td>
       
        <td><b> BatchId</b></td>
       
      </tr>

      <%
        Connection con = ConnectionDb.getConn();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from participant" );
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
        <td>
        
          <%
            out.print(resultSet.getInt(5));
          %>
        </td>
         
        

        
      <%
}
%>


    </table>
    <div align="center" >
    
    <a href="update.jsp">Update Participant</a> | <a href="delete.jsp">Delete Participant</a>
    
</div>

</body>
</html>