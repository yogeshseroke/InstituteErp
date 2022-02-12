

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
 * Servlet implementation class AdminBranchSer
 */
@WebServlet("/AdminBranchSer")
public class AdminBranchSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBranchSer() {
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
			ResultSet res=Datahelper.dqlOpe("SELECT * FROM branch WHERE branchid='"+request.getParameter("txtbranchid")+"'");
		if(res.next())
		{
			 response.sendRedirect("AdminBranch.jsp?q=This ID is already exist");
		}
		else
		{ 
			
		    int x=Datahelper.dmlOpe("INSERT INTO `branch` (`branchid`, `branchname`) VALUES('"+request.getParameter("txtbranchid")+"','"+request.getParameter("txtbranchname")+"')");
		      Datahelper.closeConn();
		  if(x!=0)
		  {
			   response.sendRedirect("AdminBranch.jsp");
		  }
		  else
		  {
			  response.sendRedirect("AdminBranch.jsp?q=data not inserted successfully");
		  }
			}
		
		}
	catch(Exception ex)
		{
		 out.print(ex.getMessage().toString());
		}

	}

}
