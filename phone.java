import java.io.*;
class phone
{
	public static void main(String s[])throws Exception
	{
		FileInputStream fis=new FileInputStream("phone.txt");
		int ch=0;
		boolean f=false;
		String name=null;
		System.out.println("\nTotal bytes="+fis.available());
		fis.close();
		while(ch!=3)
		{
			System.out.print("1.Search name and display number.\n2.Add new name-phone number.\n3.Exit.\n"); System.out.print("\nEnter your choice:");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			ch=Integer.parseInt(br.readLine());
			switch(ch)
			{
				case 1:
					FileReader fr=new FileReader("phone.txt");
					BufferedReader br1=new BufferedReader(fr);
					System.out.print("\nEnter Name:");
					name=br.readLine();
					String s1=null;
					while((s1=br1.readLine())!=null)
					{
						String tok[]=s1.split("[ ]");
						if(name.compareTo(tok[0])==0)
						{
							f=true;
							System.out.println("\nName="+tok[0]+"\nPhone Number="+tok[1]);
							break;
						}
						else f=false;
					}
					if(f==false)
					{
						System.out.println("\nRecord not found!");
					}
					fr.close();
					break;
				case 2:
					BufferedWriter out=new BufferedWriter(new FileWriter("phone.txt",true));
					System.out.print("Enter name:");
					name=br.readLine();
					String pn=null;
					int k=0;
					do
					{
						System.out.println("Enter phone number:");
						pn=br.readLine();
						if(pn.length()!=10)
						{
							if(pn.length()==11)
							{
								k=0;
							}
							else
							{
								System.out.println("Invalid phone number!");
								k++;
							}
						}
					}while(k!=0);
					out.write(name);
					out.write(" ");
					out.write(pn+"\n");
					out.close();
					System.out.print("\n\n");
					BufferedReader in=new BufferedReader(new FileReader("phone.txt"));
					String str;
					while((str=in.readLine())!=null)
						System.out.println(str);
					in.close();
					break;
				case 3:
					System.exit(0);
					//System.out.println("Invalid choice");
			}
		}
	}
}
