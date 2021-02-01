import java.io.*;
import java.sql.*;

public class MenuDriven
{
	BufferedReader br;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	MenuDriven()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://192.168.16.1/ty146","ty146","");
		}
		catch(Exception e)
		{
			System.out.println("\nException--"+e);
		}
	}
	
	void insert() throws IOException
	{
		System.out.println("\nEnter student's Name=");
		String sname=br.readLine();
		System.out.println("\nEnter Roll Number=");
		int rno=Integer.parseInt(br.readLine());
		System.out.println("Enter percentage=");
		double per=Double.parseDouble(br.readLine());
	
		try
		{
			ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1,rno);
			ps.setString(2,sname);
			ps.setDouble(3,per);
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Record inserted successfully");
			}
			ps.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	void modify() throws IOException
	{
		System.out.println("\nEnter Roll Number=");
		int rno=Integer.parseInt(br.readLine());
		try
		{
			ps=con.prepareStatement("select * from student where rno=?");
			ps.setInt(1,rno);
			rs=ps.executeQuery();
			int f=0;
			while(rs.next())
			{
				f=1;
			}
			if(f==0)
			{
				System.out.println("\nNo record found for student having roll number "+rno);
				return;
			}
			else
			{
				System.out.println("\nEnter student's name=");
				String sname=br.readLine();
				System.out.println("\nEnter Percentage=");
				double per=Double.parseDouble(br.readLine());
				
				ps=con.prepareStatement("update student set name=?,percentage=? where rno=?");
				ps.setString(1,sname);
				ps.setDouble(2,per);
				ps.setInt(3,rno);
				
					int i=ps.executeUpdate();
					if(i>0)
					{
						System.out.println("Record updated successfully");
					}
			}
			ps.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}


void delete_rec() throws IOException
{
	                System.out.println("\nEnter Roll Number=");
                int rno=Integer.parseInt(br.readLine());
                try
                {
                        ps=con.prepareStatement("select * from student where rno=?");
                        ps.setInt(1,rno);
                        rs=ps.executeQuery();
                        int f=0;
                        while(rs.next())
                        {
                                f=1;
                        }
                        if(f==0)
                        {
                                System.out.println("\nNo record found for student having roll number "+rno);
                                return;
                        }
                        else
                        {
    		                    ps=con.prepareStatement("delete from student where rno=?");
                		    ps.setInt(1,rno);
				    int i=ps.executeUpdate();
				    if(i>0)
				    {
  					System.out.println("Record deleted successfully");
				    }
			ps.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}


void search() throws IOException
{
	
	   System.out.println("\nEnter Roll Number=");
                int rno=Integer.parseInt(br.readLine());
                try
                {
                        ps=con.prepareStatement("select * from student where rno=?");
                        ps.setInt(1,rno);
                        rs=ps.executeQuery();
                        int f=0;
                        while(rs.next())
                        {
                                f=1;
				System.out.println("\nRoll Number="+rs.getInt(1)+"\nName="+rs.getString(2)+"\nPercentage="+rs.getString(3));
			}
			if(f==0)
			{
				 System.out.println("\nNo record found for student having roll number "+rno);
				return;
			}
			ps.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}


void viewAll()
{
	try
	{
		       ps=con.prepareStatement("select * from student");
 rs=ps.executeQuery();
                        int f=0;
                        while(rs.next())
                        {
                                f=1;
                                System.out.println("\nRoll Number="+rs.getInt(1)+"\nName="+rs.getString(2)+"\nPercentage="+rs.getString(3));
                        }
                        if(f==0)
                        {
                                 System.out.println("\nNo record found");
			        return;
                        }
                        ps.close();
                }
                catch(Exception e)
                {
                        System.out.println(e);
                }
}

public static void main(String args[]) throws Exception
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	MenuDriven ob=new MenuDriven();
	int ch;
	while(true)
	{
		System.out.print("\n\n1.Insert\n2.Modify\n3.Delete\n4.Search\n5.viewALL\n6.Exit\nSelect any option:");
		ch=Integer.parseInt(br.readLine());
		
		switch(ch)
		{
			case 1:
				ob.insert();break;
			case 2:
				ob.modify();break;
			case 3:ob.delete_rec();break;
			case 4:ob.search(); break;
			case 5:ob.viewAll();break;
			case 6:
				ob.rs.close();
				ob.ps.close();
				ob.con.close();
				System.exit(0);
			default: System.out.println("\nInvalid option");
		}
	}
}
}		
