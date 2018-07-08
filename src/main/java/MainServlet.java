import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bogdan on 08.07.18.
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"hello"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        out.print("Hello, World!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null) name = "World";
        request.setAttribute("user", name);
        request.getRequestDispatcher("response.jsp").forward(request, response);
    }
}
