

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import dao.Datahelper;


/**
 * Servlet implementation class AdminRecruitSer
 */
@WebServlet("/AdminRecruitSer")
public class AdminRecruitSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRecruitSer() {
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
			Datahelper.connection();
			ResultSet res=Datahelper.dqlOpe("SELECT * FROM recruit WHERE recruitid='"+request.getParameter("txtrecruitid")+"'");
		if(res.next())
		{
			 response.sendRedirect("AdminRecruit.jsp?q=This ID is already exist");
		}
		else
		{ 
			
		    int x=Datahelper.dmlOpe("INSERT INTO `recruit` (`recruitid`, `email`, `password`, `staffname`, `joiningdate`, `designation`, `experience`) VALUES('"+request.getParameter("txtrecruitid")+"','"+request.getParameter("txtemail")+"','"+request.getParameter("txtpassword")+"','"+request.getParameter("txtstaffname")+"','"+request.getParameter("txtjoiningdate")+"','"+request.getParameter("txtdesignation")+"','"+request.getParameter("txtexperience")+"')");
		      Datahelper.closeConn();
		  if(x!=0)
		  {
			   response.sendRedirect("AdminRecruit.jsp");
		  }
		  else
		  {
			  response.sendRedirect("AdminRecruit.jsp?q=data not inserted successfully");
		  }
			}
		
		}
	catch(Exception ex)
		{
		 out.print(ex.getMessage().toString());
		}

	}

}
