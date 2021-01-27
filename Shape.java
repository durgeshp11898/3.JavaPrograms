import java.io.*;
abstract class Shape
{
	abstract void calc_area();
	abstract void calc_volume();
}

class Sphere extends Shape{
	float radius,area,volume;
	Sphere(float ra)
	{
		radius=ra;
	}

	void calc_area()
	{
		area=4*3.14f*radius*radius;
		System.out.println("Area of sphere is\t:"+area);
	}
	void calc_volume()
	{
		volume=(4*3.14f*radius*radius*radius)/3;
		System.out.println("Volsume of sphere is:\t"+volume);
	}
}
class Cylinder extends Shape{
	float radius,area,volume,height;
	Cylinder(float ra,float ha)
	{
		radius=ra;
		height=ha;
	}
	void calc_area()
	{
		area=2*3.14f*radius*(height+radius);
		System.out.println("Area of Cyl is:\t"+area);
	}
	
	void calc_volume()
	{
		volume=3.14f*radius*radius*height;
		System.out.println("Volume of cyl is:\t"+volume);
	}
}

class Cone extends Shape
{
	float radius,area,volume,length,height;
	Cone(float ra,float ha,float la)
	{
		radius=ra;
		length=la;
		height=ha;
	}

	void calc_area()
	{
		area=3.14f*radius*(1+radius);
		System.out.println("Area of Cone is:\t"+area);
	}

	void calc_volume(){
		volume=(3.14f*radius*radius*height)/3;
		System.out.println("Volume of cone is:\t"+volume);
	}
}

class Shape1
{
	public static void main(String args[]) //throws Exception
	{
		Sphere sp=new Sphere(5.2f);
		sp.calc_area();
		sp.calc_volume();
		System.out.println("\n");
		Cylinder cp=new Cylinder(5.2f,3.2f);
		cp.calc_area();
		cp.calc_volume();
		System.out.println("\n");
		Cone co=new Cone(2.3f,1.2f,5.2f);
		co.calc_area();
		co.calc_volume();
		System.out.println("\n");
	}
}

