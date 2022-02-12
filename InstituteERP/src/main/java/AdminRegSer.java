

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
 * Servlet implementation class AdminRegSer
 */
@WebServlet("/AdminRegSer")
public class AdminRegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegSer() {
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
			ResultSet res=Datahelper.dqlOpe("SELECT * FROM reg WHERE regid='"+request.getParameter("txtregid")+"'");
		if(res.next())
		{
			 response.sendRedirect("AdminReg.jsp?q=This ID is already exist");
		}
		else
		{ 
			
		    int x=Datahelper.dmlOpe("INSERT INTO `reg` (`regid`, `coursename`,`regdate`,`totalfees`,`submittedfee`,`remainingfee`,`discount`,`enqid`) VALUES('"+request.getParameter("txtregid")+"','"+request.getParameter("txtcoursename")+"','"+request.getParameter("txtregdate")+"','"+request.getParameter("txttotalfees")+"','"+request.getParameter("txtsubmittedfee")+"','"+request.getParameter("txtremainingfee")+"','"+request.getParameter("txtdiscount")+"','"+request.getParameter("txtenqid")+"')");
		      Datahelper.closeConn();
		  if(x!=0)
		  {
			   response.sendRedirect("AdminReg.jsp");
		  }
		  else
		  {
			  response.sendRedirect("AdminReg.jsp?q=data not inserted successfully");
		  }
			}
		
		}
	catch(Exception ex)
		{
		 out.print(ex.getMessage().toString());
		}

	}

}
