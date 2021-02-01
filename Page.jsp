<%@ page import="java.util.*"%>
<%  java.util.Date d = new java.util.Date();
int h= d.getHours();

String name=request.getParameter("pg");

	if(h>1 && h<12)
	  out.println("Good Morning  "+name);
	if(h>=12 && h<17) 
	   out.println("Good Afternoon  "+name);
	if(h>=17 && h<24) 
	   out.println("Good Evening  "+name);

%>
