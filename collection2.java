import java.util.*;
import java.io.*;


class collection2
{
	public static void main(String args[])
	{
		LinkedList list=new LinkedList();
		list.add("red");
		list.add("blue");
		list.add("yellow");
		list.add("orange");
		Iterator it=list.iterator();

		System.out.println("Contents of the list are: ");
		while(it.hasNext())
		{
			String str=(String)it.next();
			System.out.println(str);
		}
		int size=list.size();
		ListIterator it1=list.listIterator(size);

		System.out.println("Contents of the list in reverse order are: ");
		while(it1.hasPrevious())
		{
			String str=(String)it1.previous();
			System.out.println(str);
		}

		LinkedList list1=new LinkedList();
		list1.add("pink");
		list1.add("green");
		int index=list.indexOf("blue");
		//System.out.println("Index of blue is: "+index);
		list.addAll(index+1,list1);
		System.out.println("Contents of the new list are: "+list);
	}
}
