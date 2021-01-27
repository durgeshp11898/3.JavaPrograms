import java.util.Date;
import java.text.SimpleDateFormat;
class Date_t
{
  public static void main (String args[])
  {
    Date d = new Date ();
      System.out.println ("\nThe current Date is:" +
			  new SimpleDateFormat ("dd/MM/yyyy").format (d));
      System.out.println ("\nThe current Date is:" +
			  new SimpleDateFormat ("MM/dd/yyyy").format (d));

      System.out.println ("\nThe current Date is:" +
			  new SimpleDateFormat ("EEEE MMMM dd/yyyy").
			  format (d));

      System.out.println ("\nThe current Date is:" + d);

      System.out.println ("\nThe current Time is:" +
			  new SimpleDateFormat ("dd/MM/yyyy: HH:mm:ss a Z").
			  format (d));

      System.out.println ("\nThe current Time is:" +
			  new SimpleDateFormat ("HH:mm:ss").format (d));

      System.out.println ("\nThe current Week of the year:" +
			  new SimpleDateFormat ("w").format (d));
      System.out.println ("\nThe current Week of the year:" +
			  new SimpleDateFormat ("W").format (d));
      System.out.println ("\nThe current Day of the year:" +
			  new SimpleDateFormat ("D").format (d));
  }
}
