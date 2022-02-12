

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
 * Servlet implementation class AdminFeesSer
 */
@WebServlet("/AdminFeesSer")
public class AdminFeesSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFeesSer() {
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
			ResultSet res=Datahelper.dqlOpe("SELECT * FROM fees WHERE feesid='"+request.getParameter("txtfeesid")+"'");
		if(res.next())
		{
			 response.sendRedirect("AdminFees.jsp?q=This ID is already exist");
		}
		else
		{ 
			
		    int x=Datahelper.dmlOpe("INSERT INTO `fees` (`feesid`, `regid`,`courseid`,`installment`,`amount`,`remainingamount`) VALUES('"+request.getParameter("txtfeesid")+"','"+request.getParameter("txtregid")+"','"+request.getParameter("txtcourseid")+"','"+request.getParameter("txtinstallment")+"','"+request.getParameter("txtamount")+"','"+request.getParameter("remainingamount")+"')");
		      Datahelper.closeConn();
		  if(x!=0)
		  {
			   response.sendRedirect("AdminFees.jsp");
		  }
		  else
		  {
			  response.sendRedirect("AdminFees.jsp?q=data not inserted successfully");
		  }
			}
		
		}
	catch(Exception ex)
		{
		 out.print(ex.getMessage().toString());
		}

	}

}
