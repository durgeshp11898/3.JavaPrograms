import java.io.*;

class ZeroValueException extends Exception
{
	ZeroValueException()
	{
		System.out.println("ZERO VALUE EXCEPTION");
	}
}


class CricketPlayer
{
	String name;
	int no_of_innings;
	int no_of_times_notout,total_runs;
	float bat_avg;

	CricketPlayer()
	{
		name=null;
		no_of_innings=0;
		no_of_times_notout=0;
		total_runs=0;
	}

	CricketPlayer(String name,int no_of_innings,int no_of_times_notout,int total_runs)
	{
		this.name=name;
		this.no_of_innings=no_of_innings;
		this.no_of_times_notout=no_of_times_notout;
		this.total_runs=total_runs;
	}

	void display()
	{
		System.out.println("---------------------------------------");
		System.out.println("\nName: "+name +"\n No of innings: " +no_of_innings + "\n No of times not out: " +  no_of_times_notout + "\n Total runs: " +total_runs + "\n average: " +bat_avg);
	}

	static float cal_avg(int tr,int n_innings)
	{
		float b=0;
		try
		{
			if(n_innings < 0)
				throw new ArithmeticException(); 
			else 
			{ 
				b=(tr/n_innings);
				//return b;
			}
		}

		catch(ArithmeticException e)
		{
			System.out.println("\nDivide By Zero Exception caught\n\n");
		}
		return b;
	}

	void avg(float b)
	{
		bat_avg=b;
	}

	static void sort(CricketPlayer c[])
	{
		CricketPlayer temp;
		for(int i=1;i<c.length;i++)
		{
			for(int j=0;j<(c.length-i);j++)
			{
				if(c[j].bat_avg > c[j+1].bat_avg)
				{
					temp=c[j];
					c[j]=c[j+1];
					c[j+1]=temp;
				}
			}
		}
	}
	//}

	//class Cricket
	//{
public static void main(String args[])
{
	try
	{
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the no of players");
		int n=Integer.parseInt(b.readLine());
		if(n < 0)
			throw new ZeroValueException();

		int ni,nt,tot_runs;
		String name;
		CricketPlayer c[]=new CricketPlayer[n];
		CricketPlayer c1=new CricketPlayer();

		for(int i=0;i<n;i++)
		{
			System.out.println("Enter name:");
			name=b.readLine();

			System.out.println("Enter no of innings:");
			ni=Integer.parseInt(b.readLine());

			System.out.println("Enter no of times(NOT OUt):");
			nt=Integer.parseInt(b.readLine());

			System.out.println("Enter total runs:");
			tot_runs=Integer.parseInt(b.readLine());

			if(nt < 0 || tot_runs < 0)
				throw new ZeroValueException();

			//else if(tot_runs < 0)
			//throw new ZeroValueException();

			else
			{      
				c[i]=new CricketPlayer(name,ni,nt,tot_runs);
				float average=c[i].cal_avg(tot_runs,ni);
				c[i].avg(average);
			}
		}

		System.out.println("The data is:");
		for(int i=0;i<n;i++)
			c[i].display();

		System.out.println("\n\nthe sorted data is:");
		sort(c);
		for(int i=0;i<n;i++)
		{
			c[i].display();
		}
	}

	catch(Exception e)
	{
		System.out.println("Exception caught");
	}
	//}
	}
}
