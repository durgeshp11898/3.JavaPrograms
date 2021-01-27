import java.io.*;

class InvalidDateException extends Exception
{
 InvalidDateException()
  {
    System.out.println("Exception for invalid date");
  }
}

class Mydate
{
int day,month,year;

 Mydate()
  {
   day=0;
   month=0;
   year=0;
  }
  
 Mydate(int day,int month,int year)
  {
   this.day=day;
   this.month=month;
   this.year=year;
  }
  
 void accept() throws InvalidDateException
 {
   try
   {
   BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
   
   System.out.println("enter day:");
   int day=Integer.parseInt(b.readLine());
   
 /*   if(day < 0 || day > 31)
     {
      throw new InvalidDateException();
     }
  */
   
   System.out.println("enter month:");
   int month=Integer.parseInt(b.readLine());
   
   System.out.println("enter year:");
   int year=Integer.parseInt(b.readLine());

   if(month < 0 || month > 12)
   {
    this.month=0;
    throw new InvalidDateException();
   }

   if(year < 0)
     throw new InvalidDateException();

   if(month <= 7)
    {
     if((month%2)==0)          
      {
       if(month==2)
        {
         if(year % 4 != 0)
          {
           if(day > 28 || day <= 0)
            {
             this.day=0;
             throw new InvalidDateException();
            }            
          }
        }
      else
       {
        if(day > 30 || day <= 0)
         {
          this.day=0;
          throw new InvalidDateException();
         }
        }
      }
     else if(day > 31 || day <= 0)
      throw new InvalidDateException();
    }
    
   if(month >= 7)
    {
     if((month%2)!=0)
      {
       if(day > 30 || day <= 0)
        {
         this.day=0;
         throw new InvalidDateException();
        }
      }
      
      else 
      {
       if(day > 31 || day <= 0) 
         throw new InvalidDateException();
      }
   }


   this.day=day;
   this.month=month;
   this.year=year;
  }
   
   catch(IOException i)
    {
     System.out.println("Exception Caught");
    }
  }
  
void display()
 {
  System.out.println("DAY/MONTH/YEAR :"+day+"/"+month+"/"+year);
 }  
 
public static void main(String args[])
 {
  Mydate d=new Mydate();
  try
  {
   d.accept();
   d.display();
  }
  
  catch(Exception e)
   {
    System.out.println("Exception caught");
   }
  System.out.println();
 } 
}
