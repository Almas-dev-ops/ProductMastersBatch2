import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.*;
@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/database";
    private static final String DB_USER = "your_user";
    private static final String DB_PASSWORD = "your_password";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("attendance.jsp");
            return;
        }
        int studentId = Integer.parseInt(idParam);
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE id
                             = ?")) {
                     Class.forName("org.postgresql.Driver");
             stmt.setInt(1, studentId);
             stmt.executeUpdate();
} catch (Exception e) {
        throw new ServletException("Ошибĸа при удалении студента", e);
    }
response.sendRedirect("attendance.jsp");
}
}
