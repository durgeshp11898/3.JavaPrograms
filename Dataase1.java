import java.io.*;
import java.sql.*;

class a3
{
        public static void main(String args[]) throws Exception
        {
                Class.forName("org.postgresql.Driver");
                Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.16.1:5441/ty23","ty23","");
                Statement s=con.createStatement();


                ResultSet rst=s.executeQuery("select * from student12");
		ResultSetMetaData rsmd=rst.getMetaData();
		
		int c=rsmd.getColumnCount();
                System.out.println("\nNumber of columns="+c);
		System.out.println("\n\nColumn no-- ColumnName-- ColumnType\n");

		for(int i=1;i<=c;i++)
		{
			System.out.print(i+"\t");
                        System.out.print(rsmd.getColumnName(i)+"\t\t");
                        System.out.print(rsmd.getColumnTypeName(i)+"\n");
                        
		}

		System.out.println("\n\n");
                rst.close();
		s.close();
		con.close();
        }
}                                                                 
