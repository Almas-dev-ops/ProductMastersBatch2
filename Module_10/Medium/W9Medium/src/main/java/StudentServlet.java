import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.*;
@WebServlet("/submit-student") // URL сервлета
public class StudentServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
    String name = request.getParameter("name");
    String groupName = request.getParameter("groupName");
    String isAttendedParam = request.getParameter("isAttended");
    boolean isAttended = "on".equalsIgnoreCase(isAttendedParam) ||
            "true".equalsIgnoreCase(isAttendedParam);
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        int groupId = -1;
        String selectGroupSQL = "SELECT id FROM groups WHERE name = ?";
        stmt = conn.prepareStatement(selectGroupSQL);
        stmt.setString(1, groupName);
        rs = stmt.executeQuery();
        if (rs.next()) {
            groupId = rs.getInt("id");
        } else {

            String insertGroupSQL = "INSERT INTO groups (name) VALUES (?) RETURNING id";
            stmt.close();
            stmt = conn.prepareStatement(insertGroupSQL);
            stmt.setString(1, groupName);
            rs.close();
            rs = stmt.executeQuery();
            if (rs.next()) {
                groupId = rs.getInt("id");
            }
        }

        String insertStudentSQL = "INSERT INTO students (name, is_attended, group_id) VALUES
        (?, ?, ?)";
        stmt.close();
        stmt = conn.prepareStatement(insertStudentSQL);
        stmt.setString(1, name);
        stmt.setBoolean(2, isAttended);
        stmt.setInt(3, groupId);
        stmt.executeUpdate();
        response.sendRedirect(request.getContextPath() + "/attendance");
    } catch (Exception e) {
        throw new ServletException("Ошибĸа при сохранении студента с группой", e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ignored) {}