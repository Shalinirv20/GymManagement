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
public class addBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
       
        String startDate = request.getParameter("start_date");
        String instructor = request.getParameter("instructor");
        String maxparticipants = request.getParameter("max_participants");

       
        if (startDate == null || startDate.isEmpty()) {
            pw.println("<p>Error: startDate parameter is missing or empty!</p>");
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
            String sql = "INSERT INTO batch (batch_id, start_date, instructor, max_participants) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, batchId);
                statement.setString(2, startDate);
                statement.setString(3, instructor);
                statement.setString(4, maxparticipants);
                statement.executeUpdate();
            }
            pw.println("<p>batch created successfully!</p>");
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
