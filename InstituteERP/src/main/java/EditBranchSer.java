

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
 * Servlet implementation class EditBranchSer
 */
@WebServlet("/EditBranchSer")
public class EditBranchSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBranchSer() {
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
		try
		{
			Datahelper.connection();
			int x=Datahelper.dmlOpe("UPDATE `branch` SET `branchname`='"+request.getParameter("txtbranchname")+"' WHERE `branchid`='"+request.getParameter("txtbranchid")+"'");
			Datahelper.closeConn();
           if(x!=0)
           {
        	   response.sendRedirect("AdminBranch.jsp?q=data update");
           }
           else
           {
        	   response.sendRedirect("AdminBranch.jsp?q=data not update");
           }
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}

	}

}
