<html>
<form action="file_search.jsp" method=get>
Extension<input type=text name=fname>
<br><input type=submit value=ok>
</form>
</html>
<%@ page import="java.io.*" %>
<% String end=request.getParameter("fname");
  	try{
  	File f=new File(".");
  	File f1[]=f.listFiles();
  	   for(int i=0;i<f1.length;i++)
  	   {
  	       if(f1[i].getName().endsWith(end))
  	       {
  	          %>
  	          <a href="a.txt"><%=f1[i].getName()%></a>
  	     <%  }
  	        }   
  	   }
  	   catch(Exception e)
  	   {}
%>


