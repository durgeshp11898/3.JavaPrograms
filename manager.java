import java.io.*;

class employee
{
private int id;
private int sal;
private String name;
private String dept;

employee()
{
id=0;
sal=0;
name=null;
dept=null;
}

employee(int id,int sal,String name,String dept)
{
this.id=id;
this.sal=sal;
this.name=name;
this.dept=dept;
}


void accept(int id,int sal,String name,String dept)
{
this.id=id;
this.sal=sal;
this.name=name;
this.dept=dept;
}

void display()
{
System.out.println("Id is: "+id);
System.out.println("Salary is: "+sal);
System.out.println("Name is: "+name);
System.out.println("Department is: "+dept);
}



int get_sal()
{
return sal;
}
}


class manager extends employee
{
private int bonus;

manager()
{
bonus=0;
}

manager(int i,int s,String nm,String dp,int bonus)
{
super(i,s,nm,dp);
this.bonus=bonus;
}


void accept(int i,int s,String nm,String dp,int bonus)
{
super.accept(i,s,nm,dp);
this.bonus=bonus;
}

void display()
{
super.display();
System.out.println("Bonus is: "+bonus);
}


int total_sal()
{
int s=get_sal();
int totalsal=s+bonus;
return totalsal;
}

public static void main(String args[]) throws IOException
{
BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

int r,sa,n,b;
String nm,d;
System.out.println("\nHow many Employees: ");
n=Integer.parseInt(br.readLine());
manager m[]=new manager[n];
for(int i=0;i<n;i++)
{
System.out.println("\nEnter Id:");
r=Integer.parseInt(br.readLine());

System.out.println("\nEnter Name:");
nm=br.readLine();

System.out.println("\nEnter Salary:");
sa=Integer.parseInt(br.readLine());

System.out.println("\nEnter Department:");
d=br.readLine();

System.out.println("\nEnter Bonus:");
b=Integer.parseInt(br.readLine());


m[i]=new manager(r,sa,nm,d,b);
m[i].display();

}

int max=0;
manager m1= new manager();
for(int i=0;i<n;i++)
{
if((m[i].total_sal())> max)
{
max=m[i].total_sal();

m1=m[i];
}
}

System.out.println("Employee details having Maximum Salary");
m1.display();
int tot=m1.total_sal();
System.out.println("Maximum Salary is: "+tot);
}
}
