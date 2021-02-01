import java.util.*;
import java.io.*;


class collection3
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of students : ");
		int n=Integer.parseInt(br.readLine());
		Hashtable ht=new Hashtable();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the name of the student: ");
			String name=br.readLine();
			System.out.println("Enter the Percentage: ");
			int per=Integer.parseInt(br.readLine());

			ht.put(name,per);
		}

		Enumeration keys=ht.keys();
		Enumeration values=ht.elements();
		System.out.println("Details in the Hash Table are: ");
		while(keys.hasMoreElements())
			System.out.println("NAME:= "+keys.nextElement()+"\tPERCENTAGE:= "+values.nextElement());

		System.out.println("Enter the name of the student you want to search: ");
		String nme=br.readLine();
		System.out.println("The percentage of student: "+ht.get(nme));


	}
}
