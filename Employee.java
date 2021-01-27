import java.io.*;
public class Employee
{
	private int eid;
	private String ename;
	private String department;
	private double salary;
	
	public Employee()
	{
		eid=0;
		ename="";
		department="";
		salary=0.0;
	}
	public Employee(int eid,String ename,String department,double salary)
	{
		this.eid=eid;
		this.ename=ename;
		this.department=department;
		this.salary=salary;
	}
	void accept()
	{
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\nEnter the employee id:");
			eid=Integer.parseInt(br.readLine());
			System.out.println("\nEnter the employee name:");
			ename=br.readLine();
			System.out.println("\nEnter the name of the Department:");
			department=br.readLine();
			System.out.println("\nEnter the salary of Employee:");
			salary=Double.parseDouble(br.readLine());
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
	}
	int getid()
	{
		return eid;
	}
	String getname()
	{
		return ename;
	}
	String getdept()
	{
		return department;
	}
	double getsal()
	{
		return salary;
	}
	
	void display()
	{
		System.out.println("\t\tid: "+eid);
		System.out.println("\t\tname: "+ename);
		System.out.println("\t\tDepartment: "+department);
		System.out.println("\t\tsalary: "+salary);
	}
}
class Manager extends Employee
{
	private double bonus;
	Manager(){
	super();
	bonus=0.0;
	}
	Manager(int eid,String ename,String department,double salary,double b)
	{
		super(eid,ename,department,salary);
		bonus=b;
	}
	double getbonus()
	{
		return bonus;
	}
	void accept()
	{
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader	(System.in));
			super.accept();
			System.out.println("\nEnter the manager bonus::");
			bonus=Double.parseDouble(br.readLine());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void display()
	{
		super.display();
		System.out.println("\nBonus="+bonus);
		/*public double managerWithMaxTotalSalary()
		{
			double salary=super.getSalary();
			return salary+bonus;
		}*/
	}
	static void maxsal(Manager m[])
	{
		int num=m.length;
		double max=0;
		double total;
		int temp=0;
		for(int i=0;i<num;i++)
		{
			total=(m[i].getbonus())+(m[i].getsal());
			if(total>max)
			{
				max=total;
				temp=i;
			}
		}
		System.out.println("\nEmployee with max salary:");
		m[temp].display();
	}
}

class Empdemo
{
	public static void main(String args[])
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the no.of employee:\n");
			int n=Integer.parseInt(br.readLine());
			Manager m[]=new Manager[n];
			for(int i=0;i<n;i++)
			{
				m[i]=new Manager();
				m[i].accept();
			}
		Manager.maxsal(m);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
