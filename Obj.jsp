<html>
<body>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
Current Time is  <% out.print(new java.util.Date());%><br>



<% PrintWriter pw=response.getWriter();
pw.print("THIS IS JSP"); %><br>
       

<%=request.getLocale().toString() %><br>

       


<%=config.getServletName() %><br>




<%=session.getCreationTime() %><br>



<%=page.getClass().getName() %><br>



<% pageContext.setAttribute("hi","hello");%>
<%=pageContext.getAttribute("hi") %><br>



<%=application.getServerInfo() %><br>

</body>
</html>
