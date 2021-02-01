import java.util.Hashtable;
import java.util.Scanner;
import java.util.Enumeration;
import java.util.ListIterator;

class StudentHashtable {
	public static void main(String ss[]) {
		String name = null;
		
		Scanner sc = new Scanner(System.in);
		
		Hashtable ht = new Hashtable();
		
		ht.put("Shubham", 60.0f);
		ht.put("Akash", 77.0f);
		ht.put("Rohan", 75.0f);
		ht.put("Prathamesh", 92.0f);
		ht.put("Venkatesh", 66.0f);
		
		System.out.print("\n\nHashtable entries are :\n");
		Enumeration entriesK = ht.keys();
		Enumeration entriesV = ht.elements();
		while(entriesK.hasMoreElements()) {
			System.out.println(entriesK.nextElement() + " : " + entriesV.nextElement());
		}
		
		System.out.print("\n\nTo search for specific student :\nEnter name of the Student : ");
		name = sc.nextLine();
		if(ht.containsKey(name)) {
			System.out.println("\nPercentage of Student named '" + name + "' : " + ht.get(name) + "\n");
		}
	}
}
