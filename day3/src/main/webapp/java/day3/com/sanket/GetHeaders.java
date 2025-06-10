package day3.com.sanket;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getHeaders")
public class GetHeaders extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Enumeration<String> headerNames = request.getHeaderNames();

        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr><th>Name</th><th>Value</th></tr>");

        while (headerNames.hasMoreElements()) {
            String nameHeader = headerNames.nextElement();
            String valueHeader = request.getHeader(nameHeader);
            out.println("<tr><td>" + nameHeader + "</td><td>" + valueHeader + "</td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
