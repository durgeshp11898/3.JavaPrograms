import java.io.*;

abstract class Staff
{
	String name;
	String add;

	void accept() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter name: ");
		name=br.readLine();

		System.out.println("\nEnter address: ");
		add=br.readLine();
	}

	void display()
	{
		System.out.println("Name is: "+name);
		System.out.println("Address is: "+add);
	}

}

class FullTimeStaff extends Staff
{
	String dept;
	int sal;

	void accept() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		super.accept();
		System.out.println("\nEnter Department: ");
		dept=br.readLine();

		System.out.println("\nEnter Salary: ");
		sal=Integer.parseInt(br.readLine());
	}

	void display()
	{
		super.display();
		System.out.println("Department is: "+dept);
		System.out.println("Salary is: "+sal);
	}
}

class PartTimeStaff extends Staff
{
	int noh;
	int rph;

	void accept() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		super.accept();
		System.out.println("\nEnter Number of hours: ");
		noh=Integer.parseInt(br.readLine());

		System.out.println("\nEnter  Rate per Hour: ");
		rph=Integer.parseInt(br.readLine());
	}

	void display()
	{
		super.display();
		System.out.println("Number of hours is: "+noh);
		System.out.println("Rate per hour is: "+rph);
	}
}

class staff
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of Staff members: ");
		int n=Integer.parseInt(br.readLine());
		Staff s[]=new Staff[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("\n1)Full Time Employee: ");
			System.out.println("\n2)Part Time Employee: ");
			System.out.println("\n0)Exit ");
			System.out.println("\nEnter your Choice: ");
			int ch=Integer.parseInt(br.readLine());
			if(ch==1)
			{


				s[i]=new FullTimeStaff();
				s[i].accept();
				s[i].display();
			}
			else if(ch==2)
			{

				s[i]=new PartTimeStaff();
				s[i].accept();
				s[i].display();
			}
			else if(ch==0)
				System.exit(0);
		}
	}
}
