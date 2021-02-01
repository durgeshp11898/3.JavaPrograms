import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.swing.*;

public class Search extends HttpServlet
{
       Connection con=null;
		Statement st=null;
		ResultSet rs=null;

  public void init()
  {
    try
    {
      Class.forName("org.postgresql.Driver");
       con=DriverManager.getConnection("jdbc:postgresql://192.168.16.1/ty131","ty131","");	
	 }
	  catch(Exception e)
    {}
  } 
		
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
 {
     res.setContentType("text/html");
  //  HttpSession s=req.getSession(true);
    int roll=Integer.parseInt(req.getParameter("r"));
  PrintWriter pw=res.getWriter();
     try
     {
       st=con.createStatement();
	   rs=st.executeQuery("select * from stud where roll="+roll);
     
		      if(rs==null)
		        pw.print("\n Error");
		      else
		      {
		        while(rs.next())
                                {
                                      pw.print("<table border=2>");
                                      pw.print("<tr>");
                                      pw.print("<td>"+rs.getInt(1)+"</td>");
                                      pw.print("<td>"+rs.getString(2)+"</td>");
                                     pw.print("<td>"+rs.getInt(3)+"</td>");
                                }
		      }
		    }
		    catch(Exception e1)
		    {}  
    }
    
   
    
 }
 

