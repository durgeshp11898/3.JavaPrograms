import java.io.*;
class SearchString extends Thread
{
  String search_str;
  File fp;
  int line,flag;
    SearchString (File f, String str)
  {
    fp = f;
    search_str = str;
    line = 1;
    flag = 0;
  }
  public void run ()
  {
    try
    {
      FileReader fr = new FileReader (fp);
      BufferedReader br = new BufferedReader (fr);
      String s = "";
      while ((s = br.readLine ()) != null)
      {
	if (s.contains (search_str))
	{
	  flag = 1;
	  System.out.println ("\nString" + search_str + " found in file" +
			      fp.getName () + " at line" + line++);
	}
	else
	line++;
      }
      if (flag == 0)
	{
	  System.out.println ("\n\nString" + search_str +
			      " not found in file" + fp.getName ());
	}
    }
    catch (Exception e)
    {
      System.out.println ("Exception caught:" + e);
    }
  }
  public static void main (String args[]) throws Exception
  {
    File dname = new File (".");
    int i, j;
    File fnames[] = dname.listFiles ();
    SearchString f[] = new SearchString[fnames.length];
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
      System.out.println ("Enter a string to be searched=");
    String str = br.readLine ();
    for (i = 0, j = 0; i < fnames.length; i++)
      {
	if ((fnames[i].getName ()).endsWith (".txt")
	    || (fnames[i].getName ()).endsWith (".java"))
	  {
	    f[j] = new SearchString (fnames[i],str);
	    f[j].start ();
	    j++;
	  }
      }
  }
}
