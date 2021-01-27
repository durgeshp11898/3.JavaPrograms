import java.io.*;
class file3
{
	public static void main(String s[])throws Exception
	{
		File f=new File("item.dat");
		RandomAccessFile rf=new RandomAccessFile(f,"rw");
		if(!f.exists())
		{
			System.out.println(f.getName()+"Not Found");
			System.exit(0);
		}
		if(!f.isFile())
		{
			System.out.println(f.getName()+"Is not a File");
			System.exit(0);
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
lab:while(true)
    {
	    System.out.println("\n1.Search for a specific item by name.\n2.Find Costliest Item.\n3.Items & their total cost.\n4.Exit\n\nEnter your choice:");
	    int ch=Integer.parseInt(br.readLine());
	    switch(ch)
	    {
		    case 1:
			    rf.seek(0);
			    System.out.print("\nEnter item name:");
			    String name=br.readLine();
			    while((str=rf.readLine())!=null)
			    {
				    String tok[]=str.split("[ ]");
				    if(name.compareTo(tok[1])==0)
				    {
					    System.out.println("\nRecord Found.");
					    continue lab;
				    }
			    }
			    System.out.println("\nRecord not Found.");
			    break;
		    case 2:
			    rf.seek(0);
			    int max=0;
			    name=null;
			    while((str=rf.readLine())!=null)
			    {
				    String tok[]=str.split("[ ]");
				    int p=Integer.parseInt(tok[2]);
				    int q=Integer.parseInt(tok[3]);
				    if(max<(p*q))
				    {
					    max=(p*q);
					    name=tok[1];
				    }

			    }
			    System.out.println("\nCostliest item is:"+name);
			    break;
		    case 3:
			    rf.seek(0);
			    System.out.println("\nCode \t\t Name \t\t Total cost");
			    {
				    while((str=rf.readLine())!=null)
				    {
					    String tok[]=str.split("[ ]");
					    int p=Integer.parseInt(tok[2]);
					    int q=Integer.parseInt(tok[3]);
					    System.out.println(tok[0]+"\t\t"+tok[1]+"\t\t"+(p*q));
				    }
			    }
			    break;
		    case 4:
			    rf.close();
			    System.exit(0);
			    break;
		    default:
			    System.out.println("\nInvalid Choice!");
	    }
    }
	}
}
