import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {
    private List<String> inventory = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        if (item != null) {
            inventory.add(item);
            response.getWriter().println("Item added: " + item);
        } else {
            response.getWriter().println("Invalid input.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Inventory List:</h1>");
        for (String item : inventory) {
            out.println("Item: " + item + "<br>");
        }
    }
}
