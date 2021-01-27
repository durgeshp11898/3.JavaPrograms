import java.io.*;
class DemoFile
{
	public static void main (String args[]) throws FileNotFoundException,
	       IOException
	       {
		       if (args.length != 1)
		       {
			       System.out.println ("Invalid Argument.");
			       return;
		       }
		       File f1 = new File (args[0]);
		       BufferedReader br =
			       new BufferedReader (new InputStreamReader (System.in));
		       String rply;
		       if (f1.isFile ())
		       {
			       System.out.println (args[0] + " is a File.");
			       System.out.println ("Path: " + f1.getAbsolutePath ());
			       System.out.println ("Size: " + f1.length ());
			       if (f1.canRead ())
				       System.out.println ("Read: Yes");
			       else
				       System.out.println ("Read: No");
			       if (f1.canWrite ())
				       System.out.println ("Write: Yes");
			       else
				       System.out.println ("Write: No");
		       }
		       else if (f1.isDirectory ())
		       {
			       System.out.println (args[0] + " is a Directory.");
			       String list[] = f1.list ();
			       int count = 0;
			       File f2;
			       for (int i = 0; i < list.length; i++)
			       {
				       count++;
			       }
			       System.out.println ("Total File Found: " + count);
			       for (int i = 0; i < list.length; i++)
			       {
				       f2 = new File (f1, list[i]);
				       if (f2.isFile ())
				       {
					       System.out.println ("File: " + f2.getName ());
					       if (list[i].endsWith (".txt"))
					       {
						       System.out.println ("File extension is .txt");
						       System.out.print ("Do you want to delete this file(y/n)");
						       rply = br.readLine ();
						       if (rply.equals ("y") || rply.equals ("Y"))
						       {
							       if (f2.delete ())
								       System.out.println ("File SuccessFully deleted.");
							       else
								       System.out.println ("Unable to Delete File.");
						       }
						       else
						       {
							       System.out.println ("File not deleted.");
						       }
					       }
				       }
			       }
		       }
	       }
}
