import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;

class IntegerStore {
	public static void main(String s[]) {
		int n, temp;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many integers? : ");
		n = sc.nextInt();
		
		TreeSet ts = new TreeSet();
		System.out.println("\nEnter the "+ n +" integers :\n(Duplicate Entries, if any, will be automatically removed)\n\n");

		for(int i = 0; i < n; i++) {
			temp = sc.nextInt();
			
			ts.add(temp);
		}
		
		System.out.print("\n\nThe Integers entered in sorted order are : \n\n");
		Iterator it = ts.iterator();
		while(it.hasNext()) {
			temp = Integer.parseInt("" + it.next());
			System.out.print(temp + "\t");
		}
		System.out.print("\n\n");
	}
}
