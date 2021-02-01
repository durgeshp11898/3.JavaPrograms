import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ListIterator;

class LinkedListIteration {
	public static void main(String ss[]) {
		LinkedList li = new LinkedList();
		li.add("RED");
		li.add("BLUE");
		li.add("YELLOW");
		li.add("ORANGE");
		
		Iterator it = li.iterator();
		System.out.print("\n\nElements in original insertion order : \n");
		while(it.hasNext()) {
			System.out.println(it.next() + "\t");
		}
		
		
		ListIterator lit = li.listIterator();
		while(lit.hasNext()) {
			//System.out.println(lit.next() + "\t");
			lit.next();
		}
		
		System.out.print("\n\nElements in reverse insertion order : \n");
		while(lit.hasPrevious()) {
			System.out.println(lit.previous() + "\t");
		}
		
		LinkedList linew = new LinkedList();
		linew.add("PINK");
		linew.add("GREEN");
		
		ListIterator litnew = linew.listIterator();
		lit.next();
		lit.next();
		while(litnew.hasNext()) {
			lit.add(litnew.next() + "");
		}
		while(lit.hasPrevious()) {
			lit.previous();
		}
		
		System.out.print("\n\nNew Elements : \n");
		while(lit.hasNext()) {
			System.out.println(lit.next() + "\t");
		}
		System.out.print("\n\n");
	}
}
