import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PasswordFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String password = req.getParameter("password");
        if(password.equals("admin"))
            chain.doFilter(req,resp);
        else{
            out.println("Username or Password is incorrect");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req,resp);
        }
    }

    public void destroy() {
    }

}
