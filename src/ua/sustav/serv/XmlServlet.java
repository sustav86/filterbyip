package ua.sustav.serv;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by ukr-sustavov
 * on 24.01.2018.
 */
@WebServlet(urlPatterns = { "/xmlservlet"}, initParams = {@WebInitParam(name = "defaultUser", value = "Tyson")})
public class XmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String userName = req.getParameter("name");
        ServletContext context = req.getServletContext();

        HttpSession session = req.getSession();
        if (userName != null && !userName.isEmpty()) {
            session.setAttribute("savedUserName", userName);
            context.setAttribute("savedUserName", userName);
        }

        printWriter.println("Hello from GET method " + userName);
        printWriter.println("Session from GET method " + session.getAttribute("savedUserName"));
        printWriter.println("ServletContext from GET method " + context.getAttribute("savedUserName"));
        printWriter.println("ServletContext init user name " + getServletConfig().getInitParameter("defaultUser"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String userName = req.getParameter("userName");
        String fullName = req.getParameter("fullName");
        printWriter.println(" Hello from POST method! User! " + userName + " " + fullName);
        String prof = req.getParameter("prof");
        printWriter.println(" U a a " + prof);
//        String location = req.getParameter("location");
        String[] location = req.getParameterValues("location");
        printWriter.println(" Your location are " + Arrays.toString(location));

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
