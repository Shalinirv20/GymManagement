package com.gms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.gms.model.Participant;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addParticipant
 */
public class addParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addParticipant() {
        super();
        // TODO Auto-generated constructor stub
    }
    


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
       
        String participantName = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        
        if (participantName == null || participantName.isEmpty()) {
            pw.println("<p>Error: participantName parameter is missing or empty!</p>");
            return; 
        }

        
        String batchIdParameter = request.getParameter("bid");
        int batchId;
        if (batchIdParameter != null && !batchIdParameter.isEmpty()) {
            batchId = Integer.parseInt(batchIdParameter);
        } else {
            pw.println("<p>Error: batchId parameter is missing or empty!</p>");
            return; 
        }

        
        String url = "jdbc:mysql://localhost:3306/zumba";
        String username = "root";
        String password = "VICKY007vicky@$";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO participant (name, phone, email, batch_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, participantName);
                statement.setString(2, phone);
                statement.setString(3, email);
                statement.setInt(4, batchId);
                statement.executeUpdate();
            }
            pw.println("<p>Participant created successfully!</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            pw.println("<p>Error creating participant!</p>");
        }
       
        
       
        
    }

    

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
