import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SaveLanguageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");

        // Save language in a cookie
        Cookie languageCookie = new Cookie("favoriteLanguage", language);
        languageCookie.setMaxAge(60*60*24); // Cookie lasts for one day
        response.addCookie(languageCookie);

        // Generate response page with link to book recommendations
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Thank you for selecting " + language + "!</h2>");
        out.println("<a href='RecommendServlet'>View Book Recommendations</a>");
        out.println("</body></html>");
    }
}
