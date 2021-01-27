import java.io.*;

class Staff
{
String name,address;

 Staff()
  {
   name=null;
   address=null;
  }
  
 Staff(String name,String address)
  {
   this.name=name;
   this.address=address;
  }
  
 void display()
  {
   System.out.println("\n NAME: "+name+"\n ADDRESS: "+address);
  }
}

class FullTimeStaff extends Staff
{
 String dept;
 float sal;
  
  FullTimeStaff()
   {
    dept=null;
    sal=0f;
   }

 FullTimeStaff(String name,String address,String dept,float sal)
  {
   super(name,address);
    this.dept=dept;
    this.sal=sal;
  }
  
 void display()
  {
   System.out.println("PART TIME STAFF");
   super.display();
   System.out.println(" DEPARTMENT: "+dept+"\n SALARY:"+sal);
  }
} 

class PartTimeStaff extends Staff
{
 int no_of_hrs,rate_per_hr;
  
 PartTimeStaff()
   {
    no_of_hrs=0;
    rate_per_hr=0;
   }

 PartTimeStaff(String name,String address,int n,int r)
  {
   super(name,address);
    no_of_hrs=n;
    rate_per_hr=r;
  }
  
 void display()
  {
   System.out.println("FULL TIME STAFF");
   super.display();
   System.out.println(" NO OF HOURS: "+no_of_hrs+"\n RATE PER HOUR: "+rate_per_hr);
  }
} 

class StaffAssign
{
 public static void main(String args[]) throws IOException
  {
   System.out.println("Enter the no of staff:");
   BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
   int n=Integer.parseInt(b.readLine());
   Staff s[]=new Staff[n];
   
   for(int i=0;i<n;i++)
    {
     System.out.println("---------------------------------------------------");
     
     System.out.println("Enter the name:");
     String name=b.readLine();
     
     System.out.println("Enter address:");
     String address=b.readLine();

     System.out.println("plz enter the type of staff: \n 1)FULL TIME STAFF \n 2)PART TIME STAFF");
     int type=Integer.parseInt(b.readLine());
     
      if(type==1)
       {
        System.out.println("enter dept");
        String dept=b.readLine();
        
        System.out.println("enter salary");
        float sal=Float.parseFloat(b.readLine());
        s[i]=new FullTimeStaff(name,address,dept,sal);
       }
       
       else if(type==2)
       {
        System.out.println("Enter no of hours worked");
        int no=Integer.parseInt(b.readLine());

        System.out.println("Enter rate per hour");
        int r=Integer.parseInt(b.readLine());

        s[i]=new PartTimeStaff(name,address,no,r);
       }
     }
    for(int j=0;j<n;j++) 
     {
      System.out.println("------------STAFF"+(j+1)+"----------------");
       s[j].display();
     } 
System.out.println();
  }
}
