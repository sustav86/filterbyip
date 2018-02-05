package ua.sustav.serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ukr-sustavov
 * on 23.01.2018.
 */
@WebServlet(description = "sdasfd", urlPatterns = {"/ServY"})
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("Hello from GET method.");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h3> Hello World </h3>");
    }
}
