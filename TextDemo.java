import java.util.*;
import java.io.*;
class TextDemo
{
  public static void main (String args[]) throws Exception
  {
    int a;
    String s1 = null;
    String name = args[0];
    File f1 = new File (name);
    if (!f1.exists ())
        System.out.println ("\nFile Dose not exist!");
    else
      {
	ArrayList a1 = new ArrayList ();
	FileReader fr = new FileReader (name);
	BufferedReader br = new BufferedReader (fr);
	BufferedReader br1 =
	  new BufferedReader (new InputStreamReader (System.in));
	while ((s1 = br.readLine ()) != null)
	  a1.add (s1);
	  System.out.println ("\nContents of list is" + a1);
	do
	  {
	    System.out.
	      println
	      ("\n1.Insert line\n2.Delete line\n3.Append line\n4.Modify line\n5.exit");
	    a = Integer.parseInt (br1.readLine ());
	    switch (a)
	      {
	      case 1:
		System.out.
		  println ("\nEnter the position of line u want to insert.");
		int i = Integer.parseInt (br1.readLine ());
		  System.out.println ("\nEnter the line:");
		String s = br1.readLine ();
		  a1.add (i, s);
		  System.out.println ("\nContents of list is " + a1);
		  break;

		case 2:System.out.
		  println ("\nEnter the position of line u want to delete.");
		int d = Integer.parseInt (br1.readLine ());
		  a1.remove (d);
		  System.out.println ("\nContents of list is " + a1);
		  break;

		case 3:System.out.println ("\nEnter the  line.");
		String s2 = br1.readLine ();
		int a2 = a1.size();
		  a1.add (a2, s2);
		  System.out.println ("\nContents of list is " + a1);
		  break;

		case 4:System.out.
		  println ("\nEnter the position of line u want to modify.");
		int i1 = Integer.parseInt (br1.readLine ());
		  System.out.println ("\nEnter the modified line:");
		String s3 = br1.readLine ();
		  a1.set (i1, s3);
		  System.out.println ("\nContents of list is " + a1);
		  break;

		case 5:BufferedWriter wr =
		  new BufferedWriter (new FileWriter (name));
		for (Object o : a1)
		  {
		    String s4 = (String) o;
		      wr.write (s4);
		      wr.write ("\n");
		  }
		wr.close ();
		  System.exit (0);
	      }
	  }
	while (a != 5);
      }
  }
}
