<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Participant</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
   
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
<body >
<div class="form-container">
  <h2>Delete Doctor</h2>
  
  <form  class="form-group" action="deleteParticipant" method="post" >
    Enter ID<input class="form-control" type="text" name="pid" placeholder="Enter Pid" > <input type="submit" 
      value="Delete" name="Action" class="btn btn-primary">
  </form>
  <p align="right" >
    <a href="ListofParticipants.jsp">Back to Participants list</a> | 
    <a href="index.html">Home</a>
  </p>
  </div>
  
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>