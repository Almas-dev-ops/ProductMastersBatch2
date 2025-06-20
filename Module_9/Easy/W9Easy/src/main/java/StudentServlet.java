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
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO students (name, group_name, is_attended) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, groupName);
            stmt.setBoolean(3, isAttended);

            stmt.executeUpdate();

            response.sendRedirect(request.getContextPath() + "/attendance");
        } catch (Exception e) {
            throw new ServletException("Ошибĸа при сохранении студента", e);
        } finally {

            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ignored) {}
        }
    }
}

