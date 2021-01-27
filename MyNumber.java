class MyNumber
{
	private int no;
	MyNumber ()
	{
		no = 0;
	}
	MyNumber (int no)
	{
		this.no = no;
	}
	boolean isNegative ()
	{
		return (no < 0) ? true : false;
	}
	boolean isPositive ()
	{
		return (no > 0) ? true : false;
	}
	boolean isEven ()
	{
		return (no % 2 == 0) ? true : false;
	}
	boolean isOdd ()
	{
		return (no % 2 != 0) ? true : false;
	}
	boolean isZero ()
	{
		return (no == 0) ? true : false;
	}
	public static void main (String args[])
	{
		if (args.length > 0)
		{
			MyNumber n = new MyNumber (Integer.parseInt (args[0]));
			if (n.isEven ())
			{
				System.out.println (Integer.
						parseInt (args[0]) +
						"is even");}
				if (n.isOdd ())
				{
					System.out.println(Integer.parseInt(args[0])+"is odd");
				}
				if(n.isPositive())
				{
					System.out.println(Integer.parseInt(args[0])+" is positive ");
				}
				if(n.isNegative())
				{
					System.out.println(Integer.parseInt(args[0])+" is Negative ");
				}
				if(n.isZero())
				{
					System.out.println(Integer.parseInt(args[0])+" is zero ");
				}
		}
		else
			System.out.println(" Insufficient Argument ");
	}
}


