import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HobbyServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String data=req.getParameter("hobby");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body>");
		Cookie[] cookies=req.getCookies();
		if(cookies!=null)
		{
			out.println("Existing cookies: ");
			for(int i=0;i<cookies.length;i++)
			{
				String name=cookies[i].getName();
				String value=cookies[i].getValue();
				out.println("Name = "+name+"Value = "+value+"<br>");
			}
			for(int i=0;i<cookies.length;i++)
				if(cookies[i].getValue().equals(data))
				{
					out.println("Cookie exists for "+data);
					return;
				}
		}
		Cookie c=new Cookie("hobby",data);
		c.setMaxAge(6000);
		res.addCookie(c);
		out.println("Cookie added for Hobby "+data);
		out.println("</body></html>");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doPost(req,res);
	}
}
