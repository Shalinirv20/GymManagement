package com.gms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteParticipant extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public deleteParticipant() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String participantIdParameter = request.getParameter("pid");

        if (participantIdParameter == null || participantIdParameter.isEmpty()) {
            pw.println("<p>Error: participant ID parameter is missing or empty!</p>");
            return;
        }

        int participantId;
        try {
            participantId = Integer.parseInt(participantIdParameter);
        } catch (NumberFormatException e) {
            pw.println("<p>Error: Invalid participant ID!</p>");
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
            String sql = "DELETE FROM participant WHERE participant_id=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, participantId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    pw.println("<p>Participant deleted successfully!</p>");
                } else {
                    pw.println("<p>Participant with ID " + participantId + " not found!</p>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            pw.println("<p>Error deleting participant!</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
