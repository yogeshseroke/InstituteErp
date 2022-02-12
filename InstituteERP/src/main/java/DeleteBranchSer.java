

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Datahelper;
import java.sql.*;


/**
 * Servlet implementation class DeleteBranchSer
 */
@WebServlet("/DeleteBranchSer")
public class DeleteBranchSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBranchSer() {
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
		PrintWriter out = response.getWriter();
		try
		  {
			Datahelper.connection();
			int x=Datahelper.dmlOpe("DELETE FROM branch WHERE Branchid='"+request.getParameter("txtbranchid")+"'");
            Datahelper.closeConn();
			  if(x!=0)
			  {
				   response.sendRedirect("AdminBranch.jsp");
			  }
			  else
			  {
				  response.sendRedirect("AdminBranch.jsp?q=data not deleted");
			  }
		  }
		  catch(Exception ex)
		  {
			 out.print(ex.getMessage().toString()); 
		  }

	}

}
