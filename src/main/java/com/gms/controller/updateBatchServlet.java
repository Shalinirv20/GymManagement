package com.gms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateBatch")
public class updateBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String batchIdParameter = request.getParameter("batch_id");
        int batchId;
        if (batchIdParameter != null && !batchIdParameter.isEmpty()) {
            batchId = Integer.parseInt(batchIdParameter);
        } else {
            pw.println("<p>Error: Batch ID parameter is missing or empty!</p>");
            return;
        }

        String startDate = request.getParameter("start_date");
        String instructor = request.getParameter("instructor");
        String maxParticipants = request.getParameter("max_participants");

       
        String url = "jdbc:mysql://localhost:3306/zumba";
        String username = "root";
        String password = "VICKY007vicky@$";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE batch SET start_date=?, instructor=?, max_participants=? WHERE batch_id=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, startDate);
                statement.setString(2, instructor);
                statement.setString(3, maxParticipants);
                statement.setInt(4, batchId);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    pw.println("<p>Batch updated successfully!</p>");
                } else {
                    pw.println("<p>Error: No batch found with ID " + batchId + "</p>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            pw.println("<p>Error updating batch!</p>");
        }
    }
}
