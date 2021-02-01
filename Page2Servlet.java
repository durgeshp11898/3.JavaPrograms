import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page2Servlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int sum2=0;
		String[] values=req.getParameterValues("item");
		if(values!=null)
		{
			for(int i=0;i<values.length;i++)
				sum2=sum2+Integer.parseInt(values[i]);
		}
		HttpSession hs=req.getSession();
		int sum1=((Integer)hs.getAttribute("page1")).intValue();
		out.println("<html>");
		out.println("<title>Summary</title><body>");
		out.println("Total of page 1 = "+sum1+"\n");
		out.println("Total of page 2 = "+sum2+"\n");
		int total=sum1+sum2;
		out.println("Total bill = "+total+"\n");
		out.println("</body></html>");
	}
}
