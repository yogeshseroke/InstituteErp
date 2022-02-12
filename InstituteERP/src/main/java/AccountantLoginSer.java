

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountantLoginSer
 */
@WebServlet("/AccountantLoginSer")
public class AccountantLoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantLoginSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		try {
			String uid=request.getParameter("txtuid");
			String pass=request.getParameter("txtpass");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/instituteerp","root","");
            Statement st=con.createStatement();
            ResultSet x=st.executeQuery("select * from `accountant` where `userid`='"+uid+"' and `password`='"+pass+"'");
            if(x.next())
            {
            	HttpSession session=request.getSession();
            	session.setAttribute("uid",uid);
            	response.sendRedirect("AccountantEnquiry.jsp");
            }
            else {
            	response.sendRedirect("AccountantLogin.jsp");
            }
		}
		catch(Exception ex)
		{
			out.println(ex.getMessage().toString());
		}
	}

}
