import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class DisplayRecord extends JFrame
{
	DefaultTableModel model;
	JTable table;
	JScrollPane jsp;
	
	Connection con;
	Statement stmt;
	ResultSet rs;

	DisplayRecord()
	{
		setLayout(null);
	
		model=new DefaultTableModel();
		table=new JTable(model);
		
		model.addColumn("Rollno");
		model.addColumn("Name");
		model.addColumn("Percentage");

		jsp=new JScrollPane(table);
		jsp.setBounds(100,50,600,200);
		add(jsp);

		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://192.168.16.1:5432/ty146","ty146","");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from student1");
			
			int f=0;
			while(rs.next())
			{			
				f=1;
				model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
			}
			if(f==0)
			{
				JOptionPane.showMessageDialog(null,"Record not found");
			}
			rs.close(); stmt.close(); con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception caught:"+e);
		}

		setSize(900,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Student Records");	
	}//constructor

	public static void main(String args[])
	{	
		new DisplayRecord();
	}
}//display record
