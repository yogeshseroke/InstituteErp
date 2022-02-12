

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AccountantLogoutSer")
public class AccountantLogoutSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AccountantLogoutSer() {
        super();
        // TODO Auto-generated constructor stub
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession session=request.getSession();
		//session.removeAttribute("uid");
		//session.invalidate();
		//response.sendRedirect("index.jsp");
		HttpSession ses = request.getSession();
		ses.removeAttribute("uid");
		ses.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		//response.sendRedirect("home.jsp");
		response.sendRedirect("index.jsp");

}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
