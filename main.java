import java.io.*;

class Vehicle
{
  String comp;
  int price;

    Vehicle ()
  {
    comp = null;
    price = 0;
  }

  Vehicle (String comp, int price)
  {
    this.comp = comp;
    this.price = price;
  }

  void display ()
  {
    System.out.println ("Company name is: " + comp);
    System.out.println ("Price is: " + price);
  }
}

class LightMotorVehicle extends Vehicle
{
  float mileage;

    LightMotorVehicle ()
  {
    mileage = 0.0f;
  }

  LightMotorVehicle (String c, int p, int mileage)
  {
    super (c, p);
    this.mileage = mileage;
  }

  void display ()
  {
    super.display ();
    System.out.println ("Mileage of Light Motor Vehicle is: " + mileage);
  }
}


class HeavyMotorVehicle extends Vehicle
{
  float capacity;

    HeavyMotorVehicle ()
  {
    capacity = 0.0f;
  }

  HeavyMotorVehicle (String c, int p, int capacity)
  {
    super (c, p);
    this.capacity = capacity;
  }

  void display ()
  {
    super.display ();
    System.out.println ("Capacity of Heavy Motor Vehicle is: " + capacity);
  }
}


class main
{
  public static void main (String args[]) throws IOException
  {
    BufferedReader br =
      new BufferedReader (new InputStreamReader (System.in));
      System.out.println ("Enter how many vehicles: ");
    int n = Integer.parseInt (br.readLine ());
    Vehicle v[] = new Vehicle[n];
    for (int i = 0; i < n; i++)
      {
	System.out.println ("\n1)Light Motor Vehicle: ");
	System.out.println ("\n2)Heavy Motor Vehicle: ");
	System.out.println ("\n0)Exit ");
	System.out.println ("\nEnter your Choice: ");
	int ch = Integer.parseInt (br.readLine ());
	if (ch == 1)
	  {
	    System.out.println ("Enter Company names: ");
	    String s = br.readLine ();
	      System.out.println ("Enter Price: ");
	    int p = Integer.parseInt (br.readLine ());
	      System.out.println ("Enter mileage: ");
	    int m = Integer.parseInt (br.readLine ());
	      v[i] = new LightMotorVehicle (s, p, m);
	      v[i].display ();
	  }
	else if (ch == 2)
	  {
	    System.out.println ("Enter Company names: ");
	    String t = br.readLine ();
	      System.out.println ("Enter Price: ");
	    int u = Integer.parseInt (br.readLine ());
	      System.out.println ("Enter capacity: ");
	    int k = Integer.parseInt (br.readLine ());
	      v[i] = new LightMotorVehicle (t, u, k);
	      v[i].display ();
	  }
	else if (ch == 0)
	  System.exit (0);
      }
  }
}
