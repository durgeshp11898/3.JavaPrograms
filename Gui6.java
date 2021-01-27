import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
class Gui6
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5;
	JButton b1;
	JPanel p1,p2,p3;

	Gui6()
	{
		f=new JFrame("Registration form");
		f.setBounds(500,500,500,500);
		f.setLayout(new BorderLayout());
		
		l1=new JLabel("Name");
		l2=new JLabel("Login Name");
		l3=new JLabel("Password");
		l4=new JLabel("Confirm Password");
		
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		
		
		final double a=Math.floor(Math.random()*10);
		final double b=Math.floor(Math.random()*10);
		String s=new String("captcha:" + a + b);
		l5=new JLabel("Captcha");
		l6=new JLabel(a +"+"+ b );
		b1=new JButton("Submit");
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(5,2));
		p2=new JPanel();
		p3=new JPanel();
		p3.setLayout(new GridLayout(1,3));
		
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p3.add(l5);
		p3.add(l6);
		p3.add(t5);
		
		p2.add(b1);
		
		f.add(p1,BorderLayout.NORTH);
		f.add(p3,BorderLayout.CENTER);
		f.add(p2,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int s1=Integer.parseInt(t5.getText());
				int c=(int) (a+b);
				String X=t3.getText();
				String M=t4.getText();
				int y=X.length();
				
				if(y>=6)
				{
				if(X.equals(M))	
				{
				if(s1==c)
				{
				System.out.println("Registration Succesful");
				}
				}
				}	
				else
				{
					System.out.println("Registration Failed");
				}

			}
		});
	}
		
		public static void main(String args[])
		{
			new Gui6();
		}	
	}
