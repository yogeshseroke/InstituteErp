

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
 * Servlet implementation class EditEnquirySer
 */
@WebServlet("/EditEnquirySer")
public class EditEnquirySer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEnquirySer() {
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
			//int x=Datahelper.dmlOpe("UPDATE `enquiry` SET `enqid`='"+request.getParameter("txtEnquiryid")+"' `Fullname`='"+request.getParameter("txtFullName")+"',`mobile`='"+request.getParameter("txtMobile")+"',`email`='"+request.getParameter("txtemail")+"',`dob`='"+request.getParameter("txtdob")+"',`collegename`='"+request.getParameter("txtcollegename")+"',`heigerqualification`='"+request.getParameter("txtheigerqualification")+"',`enqdate`='"+request.getParameter("txtenqdate")+"',`coursename`='"+request.getParameter("txtcoursename")+"',`enquirysource`='"+request.getParameter("txtenquirysource")+"',`branchid`='"+request.getParameter("txtbranchid")+"',`staffid`='"+request.getParameter("txtstaffid")+"' WHERE 1");
			int x=Datahelper.dmlOpe("UPDATE `enquiry` SET `enqid`='"+request.getParameter("txtEnquiryid")+"',`Fullname`='"+request.getParameter("txtFullName")+"',`mobile`='"+request.getParameter("txtMobile")+"',`email`='"+request.getParameter("txtemail")+"',`dob`='"+request.getParameter("txtdob")+"',`collegename`='"+request.getParameter("txtcollegename")+"',`higherqualification`='"+request.getParameter("txtheigerqualification")+"',`enqdate`='"+request.getParameter("txtenqdate")+"',`coursename`='"+request.getParameter("txtcoursename")+"',`enquierysource`='"+request.getParameter("txtenquirysource")+"',`branchid`='"+request.getParameter("txtbranchid")+"',`staffid`='"+request.getParameter("txtstaffid")+"' WHERE 1 ");
			Datahelper.closeConn();
           if(x!=0)
           {
        	   response.sendRedirect("AdminEnquiry.jsp?q=data update");
           }
           else
           {
        	   response.sendRedirect("AdminEnquiry.jsp?q=data not update");
           }
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}

	}

}
