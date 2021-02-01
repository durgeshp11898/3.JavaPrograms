import java.io.*;
class MyThread extends Thread
{
  String arr;
    MyThread (String a)
  {
    arr = a;
  }
  public synchronized void run ()
  {
    try
    {
      while (true)
	{
	  System.out.
	    println ("pass the message as a parameter to the constructor" +
		     arr);
	  Thread.sleep (5000);
	}
    }
    catch (InterruptedException e)
    {
    }
  }
}

public class ex2a1
{
  public static void main (String args[]) throws Exception,
    InterruptedException
  {
    MyThread t1 = new MyThread ("Thread1");
    MyThread t2 = new MyThread ("Thread2");
      System.out.println ("t1");
      System.out.println ("t2");
      t1.start ();
      Thread.sleep (2000);
      t2.start ();
      Thread.sleep (2000);
  }
}
