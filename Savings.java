import java.io.*;

class InsufficientFundsException extends Exception
{
 InsufficientFundsException()
  {
   System.out.println("\nInsufficient Funds");
  }
}

class LowBalanceException extends Exception
{
 LowBalanceException()
  {
   System.out.println("Low Balance");
  }
}

class NegativeNumberException extends Exception
{
 NegativeNumberException()
  {
   System.out.println("Negative Number Exception");
  }
}

class SavingAccount
{
int acNo;
String name;
float amt;

 SavingAccount()
  {
   acNo=0;
   name=null;
   amt=500;
  }
  
  SavingAccount(int acNo,String name,float amt)
   {
    this.acNo=acNo;
    this.name=name;
    this.amt=amt;
   }
   
   void withdraw(float w_amt) 
    {
     try
     {
       if(amt <= 500)
        throw new LowBalanceException();
       else if(w_amt > amt)
        throw new InsufficientFundsException();
       else
        amt=amt-w_amt;
        //viewBalance();
      }
      
      catch(Exception e)
       {
        System.out.println("Exception caught");
       }
    }
    
   void deposit()
    {
     try
      {
       System.out.println("enter the amount to be deposited");
       BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
       float d_amt=Float.parseFloat(b.readLine());
        if(d_amt < 0)
         throw new NegativeNumberException();
         //System.out.println("amount cannot be less than zero");
        else
         {
          amt=amt+d_amt;
          //viewBalance();
         }
      }
      
     catch(Exception e)
      {
       System.out.println("Exception caught");
      }
    }
    
    void viewBalance()
     {
      try
      {
       if(amt < 0)
        throw new NegativeNumberException();
      
       else
        System.out.println("\nBalance : " + amt);
       }
       
      catch(Exception e)
       {
        System.out.println("Exception caught");
       }
     }
}

class Savings
{
 public static void main(String args[])
  {
   try
   {
    System.out.println("Enter account number");
    BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    int ano=Integer.parseInt(b.readLine());
    
    System.out.println("Enter name");
    String name=(b.readLine());
    
    System.out.println("Enter amt");
    float amt=Float.parseFloat(b.readLine());
     if(amt < 0)
      throw new NegativeNumberException();
   
    SavingAccount s=new SavingAccount(ano,name,amt);
    int ch;
    
   do
   {
    System.out.println("\n\nenter ur choice: \n0)Exit \n1)Deposit \n2)Withdraw \n3)view balance");
    ch=Integer.parseInt(b.readLine());

    switch(ch)
    {
    case 1:s.deposit();
           break;
    case 2:System.out.println("enter the amount to be withdrawn");
           float w_amt=Float.parseFloat(b.readLine());
           s.withdraw(w_amt);
     	      break;
    case 3:s.viewBalance();
           break;
    }          
   }while(ch!=0);
  } 
   catch(Exception e)
    {
     System.out.println("Exception caught");
    }
  }
}
