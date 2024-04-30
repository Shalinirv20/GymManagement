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

public class deleteBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public deleteBatchServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String batchIdParameter = request.getParameter("batch_id");

        if (batchIdParameter == null || batchIdParameter.isEmpty()) {
            pw.println("<p>Error: Batch ID parameter is missing or empty!</p>");
            return;
        }

        int batchId;
        try {
        	batchId = Integer.parseInt(batchIdParameter);
        } catch (NumberFormatException e) {
            pw.println("<p>Error: Invalid Batch ID!</p>");
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
            String sql = "DELETE FROM batch WHERE batch_id=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, batchId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    pw.println("<p>Batch deleted successfully!</p>");
                } else {
                    pw.println("<p>Batch with ID " + batchId + " not found!</p>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            pw.println("<p>Error deleting Batch!</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
