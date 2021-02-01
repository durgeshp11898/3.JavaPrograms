import java.applet.*;
import java.awt.*;
/*<applet code = "SignalWithTimer" height=300 width=100> </applet>
*/

public class SignalWithTimer extends Applet implements Runnable
{
  Thread t = null;
  int time, cnt;
  public void init ()
  {
    t = new Thread (this);
    time = 10;
    cnt = 0;
    t.start ();
  }
  public void run ()
  {
    try  {
	  while (true)
	  {
	  	while (time >= 0)
	  	{
	  		repaint ();
	  		Thread.sleep (1000);
	  		time--;
	  	}
	  	cnt = (cnt + 1) % 3; 
	  	time = 10; 
	  	if (cnt == 1) 
	  		time = 5;
	  }
	  }
	  catch (InterruptedException e)
	  {
	
	  }
   }
	  public void paint (Graphics g)
	  {
	  	g.setColor (Color.black);
	 	g.drawOval (20, 25, 50, 50);
	  	g.drawOval (20, 75, 50, 50);
	  	g.drawOval (20, 125, 50, 50);
	  	String message = "Time=" + time;
	  	g.drawString (message, 25, 195); 
	  	if (cnt == 0)
	  	{
	 		 g.setColor (Color.green); 
	 	 	 g.fillOval (20, 125, 50, 50);
	 	 }
	  	else if (cnt == 1)
	  	{
	  		g.setColor (Color.orange);
	  		g.fillOval (20, 75, 50, 50);
	  	}
	  	else
	  	{
	 	 	g.setColor (Color.red);
		 	g.fillOval (20, 25, 50, 50);
	  	}
	  }
}
