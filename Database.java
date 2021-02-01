

import java.io.*;
import java.sql.*;

class a2
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("localhost:8080/","durgesh","    ");
		DatabaseMetaData dbmd=con.getMetaData();
		System.out.println("\nDatabase Product Name="+dbmd.getDatabaseProductName());
		System.out.println("\nDatabase User Name="+dbmd.getUserName());	
 		System.out.println("\nDatabase DRiver Name="+dbmd.getDriverName());
		System.out.println("\nDatabase Driver Version="+dbmd.getDriverVersion());
		System.out.println("\nDatabase Version="+dbmd.getDriverMajorVersion());

		ResultSet rst=dbmd.getTables(null,null,null,new String[]{"TABLE"});
		System.out.println("\nTables present in the database are:");
		while(rst.next())
		{
			String tablename=rst.getString("TABLE_NAME");		
			System.out.println(tablename);
		}
	}
}

