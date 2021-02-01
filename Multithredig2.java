import java.io.*;
class MyThread extends Thread
{
  int[] arr;
  int sum = 0, pos;
    MyThread (int p, int[]a)
  {
    arr = a;
    pos = p;
  }
  public void run ()
  {
    for (int i = pos; i < pos + 20; i++)
      {
	sum += arr[i];
      }
    System.out.println ("sum:" + sum);
  }
  int getSum ()
  {
    return sum;
  }
}

public class ex2a2
{
  public static void main (String args[]) throws InterruptedException
  {
    int sum = 0, sum1 = 0;
    int myArray[] = new int[100];
    for (int i = 0; i < 100; i++)
      {
	myArray[i] = i + 1;
      }
    MyThread[] t = new MyThread[5];
    for (int i = 0; i < 5; i++)
      {
	t[i] = new MyThread (i + 20, myArray);
	t[i].start ();
	t[i].join ();
      }
    for (int i = 0; i < 5; i++)
      sum += t[i].getSum ();
    System.out.println ("Total sum=" + sum);
    System.out.println ("Average=" + sum / 100);
  }
}
