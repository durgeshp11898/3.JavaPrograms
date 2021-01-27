import java.io.*;
interface CreditCardInterface
{
  public void viewCreditAmount ();
  public void useCard (float b);
  public void payCredit (float c);
  public void increaseLimit (int d);
}
class SilverCardCustomer implements CreditCardInterface
{
  String name;
  String cardno;
  public float credamt, creditAmount;
  int creditLimit;
    SilverCardCustomer (String naam, String cardno, float ca, float cA,
			int cL)
  {
    name = naam;
    this.cardno = cardno;
    credamt = ca;
    creditAmount = cA;
    creditLimit = cL;
  }
  public void viewCreditAmount ()
  {
    System.out.println ("Credit Amount is " + creditAmount);
  }
  public void useCard (float b)
  {
    credamt = creditAmount + b;
    if (credamt > creditLimit)
      System.out.println ("Exceeding credit limit. Transaction FAILED!");
    else
      {
	creditAmount = credamt;
	System.out.println ("Transaction Successful");
      }
    credamt = 0.0f;
  }
  public void payCredit (float c)
  {
    credamt = creditAmount - c;
    if (credamt < 0.0f)
      System.out.println ("You are trying to pay more than available !");
    else
      {
	creditAmount = credamt;
	System.out.println ("Transaction Successful");
      }
    credamt = 0.0f;
  }
  public void increaseLimit (int d)
  {
  }
}

class GoldCardCustomer extends SilverCardCustomer
{
//float creditAmount;
  GoldCardCustomer (String naam, String cno, float ca, float cA, int cL)
  {
    super (naam, cno, ca, cA, cL);
  }
  public void viewCreditAmount ()
  {
    System.out.println ("Credit Amount is " + creditAmount);
  }
  public void useCard (float b)
  {
    if (creditAmount + b> creditLimit)
      System.out.println ("Exceeding credit limit. Transaction FAILED!");
    else
      {
	creditAmount = creditAmount + b;
	System.out.println ("Transaction Successful"+creditAmount);
      }
   // credamt = 0.0f;
  }
  public void payCredit (float c)
  {
    credamt = creditAmount - c;
    if (credamt < 0.0f)
      System.out.println ("You are trying to pay more than available!");
    else
      {
	creditAmount = credamt;
	System.out.println ("Transaction Successful");
      }
    credamt = 0.0f;
  }
  public void increaseLimit (int d)
  {
    if (d <= 5000)
      creditLimit = creditLimit + d;
    else
      System.out.println ("Cannot increase by more than 5000");
  }
}

class Credit
{
  public static void main (String args[]) throws IOException
  {
    String aa = "sc";
    String bb = "SC";
    String cc = "gc";
    String dd = "GC";
    int ilflag = 0;
    float z = 0.0f;
    int y = 50000;
    int x = 100000;
    BufferedReader br =
      new BufferedReader (new InputStreamReader (System.in));
      System.out.println ("Enter name : \t");
    String n = br.readLine ();
      System.out.println ("Enter card number : \t");
    String cn = br.readLine ();
    while (cn.length () != 16)
      {
	System.out.println ("Card no must be 16 digits long. Try again : \n");
	cn = br.readLine ();
      }
    System.out.println ("Silver Card (SC) or Gold Card (GC) Customer? : ");
    String type = br.readLine ();
    if ((type.equals (aa)) || (type.equals (bb)))
      {
SilverCardCustomer s = new SilverCardCustomer (n, cn, z, z, y);
	while (true)
	  {
	    System.out.println
	      ("1. View Credit Amount \n 2. Pay(Deposit) credit into Card \n 3. Use Credit Card \n 0. Exit \n");
	    int ch = Integer.parseInt (br.readLine ());
	    switch (ch)
	      {
	      case 1:
		s.viewCreditAmount ();
		break;
		case 2:System.out.println ("How much do you wish to deposit? : \n");
		float amt = Float.parseFloat (br.readLine ());
		  s.useCard (amt);
		  break;
                  case 3:System.out.println ("Enter amount to be spent : \n");
		float pc = Float.parseFloat (br.readLine ());
		  s.payCredit (pc);
		  break;
		case 0:System.exit (0);
		  break;
		default:System.out.println ("Invalid Option");
		  break;
	      }
	  }
      }
    else if ((type.equals (cc)) || (type.equals (dd)))
      {	    
GoldCardCustomer g = new GoldCardCustomer (n, cn, z, z, x);
	while (true)
	  {
	    System.out.println
	      ("1. View Credit Amount \n 2. Pay(Deposit) credit into Card \n 3. Use Credit Card \n 4. Increase Limit \n 0. Exit \n");
	    int ch = Integer.parseInt (br.readLine ());

	    switch (ch)
	      {
	      case 0:
		System.exit (0);
		break;
	      case 1:
		g.viewCreditAmount ();
		break;
                  case 2:
                System.out.println ("How much do you wish to deposit \n");
	      	float amt = Float.parseFloat (br.readLine ());
		g.useCard (amt);
		break;
                 case 3:
                System.out.println ("Enter amount to be spent : \n");
		float pc = Float.parseFloat (br.readLine ());
		g.payCredit (pc);
		break;
	      case 4:
		if (ilflag < 4)
		  {
		    System.out.println
		      ("How much do you want to increase the limit by? : \n");
		    int il = Integer.parseInt (br.readLine ());
		    g.increaseLimit (il);
		    ilflag++;
		  }
		else
		  System.out.println
		    ("Limit increased 3 times. Cannot increase anymore.");
		break;
	      default:
		System.out.println ("Invalid Option");
		break;
	      }
	  }
      }
  }
}
