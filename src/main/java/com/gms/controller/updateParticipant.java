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

public class updateParticipant extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public updateParticipant() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        String participantIdParameter = request.getParameter("participant_id");
        int participantId;
        if (participantIdParameter != null && !participantIdParameter.isEmpty()) {
            participantId = Integer.parseInt(participantIdParameter);
        } else {
            pw.println("<p>Error: participant_id parameter is missing or empty!</p>");
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
            String sql = "UPDATE participant SET name=?, phone=?, email=?, batch_id=? WHERE participant_id=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, participantName);
                statement.setString(2, phone);
                statement.setString(3, email);
                statement.setInt(4, batchId);
                statement.setInt(5, participantId);
                statement.executeUpdate();
            }
            pw.println("<p>Participant updated successfully!</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            pw.println("<p>Error updating participant!</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
