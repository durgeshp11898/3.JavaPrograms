import java.util.*;
import java.io.*;

class collection1
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter how many elements you want in this set: ");
		int n=Integer.parseInt(br.readLine());
		TreeSet t=new TreeSet();
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter elements: ");
			int num=Integer.parseInt(br.readLine());
			t.add(num);
		}

		System.out.println("Contents of the HashSet in sorted order are: "+t);
		System.out.println("ENTER THE ELEMENTS YOU WANT TO SEARCH : ");
		n=Integer.parseInt(br.readLine());
		if(t.contains(n))
		{
			System.out.println("Number"+n+" is Found at position "+(t.headSet(n).size()+1));
		}
		else
		{
			System.out.println("Number"+n+" not found!");
		}
	}
}
