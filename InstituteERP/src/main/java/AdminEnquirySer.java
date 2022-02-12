

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
 * Servlet implementation class AdminEnquirySer
 */
@WebServlet("/AdminEnquirySer")
public class AdminEnquirySer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEnquirySer() {
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
			ResultSet res=Datahelper.dqlOpe("SELECT * FROM enquiry WHERE enqid='"+request.getParameter("txtEnquiryid")+"'");
		if(res.next())
		{
			 response.sendRedirect("AdminEnquiry.jsp?q=This ID is already exist");
		}
		else
		{ 
			
		    int x=Datahelper.dmlOpe("INSERT INTO `enquiry` (`enqid`, `Fullname`, `mobile`, `email`, `dob`, `collegename`, `higherqualification`, `enqdate`, `coursename`, `enquierysource`, `branchid`, `staffid`) VALUES('"+request.getParameter("txtEnquiryid")+"','"+request.getParameter("txtFullName")+"','"+request.getParameter("txtMobile")+"','"+request.getParameter("txtemail")+"','"+request.getParameter("txtdob")+"','"+request.getParameter("txtcollegename")+"','"+request.getParameter("txtheigerqualification")+"','"+request.getParameter("txtenqdate")+"','"+request.getParameter("txtcoursename")+"','"+request.getParameter("txtenquirysource")+"','"+request.getParameter("txtbranchid")+"','"+request.getParameter("txtstaffid")+"')");
		      Datahelper.closeConn();
		  if(x!=0)
		  {
			   response.sendRedirect("AdminEnquiry.jsp");
		  }
		  else
		  {
			  response.sendRedirect("AdminEnquiry.jsp?q=data not inserted successfully");
		  }
			}
		
		}
	catch(Exception ex)
		{
		 out.print(ex.getMessage().toString());
		}


	}

}
