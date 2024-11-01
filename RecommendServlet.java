import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RecommendServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = null;

        // Retrieve the language from the cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("favoriteLanguage")) {
                    language = cookie.getValue();
                    break;
                }
            }
        }

        // Generate book recommendations
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (language != null) {
            out.println("<h2>Book Recommendations for " + language + "</h2>");
            out.println("<ul>");
            if (language.equals("Java")) {
                out.println("<li>Effective Java by Joshua Bloch</li>");
                out.println("<li>Java: The Complete Reference by Herbert Schildt</li>");
            } else if (language.equals("Python")) {
                out.println("<li>Learning Python by Mark Lutz</li>");
                out.println("<li>Python Crash Course by Eric Matthes</li>");
            } else if (language.equals("JavaScript")) {
                out.println("<li>You Don’t Know JS by Kyle Simpson</li>");
                out.println("<li>JavaScript: The Good Parts by Douglas Crockford</li>");
            } else if (language.equals("C++")) {
                out.println("<li>The C++ Programming Language by Bjarne Stroustrup</li>");
                out.println("<li>Effective Modern C++ by Scott Meyers</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<h2>No favorite language selected.</h2>");
        }
        out.println("</body></html>");
    }
}
