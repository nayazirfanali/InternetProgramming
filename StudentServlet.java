import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private Map<String, String> students = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        if (id != null && name != null) {
            students.put(id, name);
            response.getWriter().println("Student added: " + name);
        } else {
            response.getWriter().println("Invalid input.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Student List:</h1>");
        for (Map.Entry<String, String> entry : students.entrySet()) {
            out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue() + "<br>");
        }
    }
}
