<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Participant</title>
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
<body  >
  <form class="form-container" action="updateParticipant" method="post" >
    <h2 align="center">Update Participant</h2>
   
    <table >
     
      <div class="form-group">
                    <label for="participant_id">Participant Id:</label>
                    <input type="text" class="form-control" id="participant_id" name="participant_id" placeholder="Enter Pid" required>
                </div>
      <div class="form-group">
                    <label for="name">Full Name:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="John Watson" required>
                </div>
      
      <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="+91 99999 11111" required>
                </div>
      
      <div class="form-group">
                    <label for="email">Full Email :</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="john@example.com" required>
                </div>
      
      
      <div class="form-group">
                    <label for="bid">Batch ID:</label>
                    <input type="text" class="form-control" id="bid" name="bid" placeholder="Morning=1 or Evening=2" required>
                </div>
      <tr>
        <td></td>
        <td align="center"><input type="submit" name="Action"
          value="update" class="btn btn-primary"></td>
      </tr>
    </table>
     <p align="right">
      <a href="ListofParticipants.jsp" >Back to Participants List</a>
       | 
      <a href="index.html" >Home</a>
   
    </p>
    

  </form>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>