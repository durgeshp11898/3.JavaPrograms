import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class a3 extends JFrame implements ItemListener
{
	JLabel name,Class,Hobbies;
	JCheckBox C1[]=new JCheckBox[3];
	JTextField t1,t2;
	ButtonGroup bg1;
	JRadioButton bg[]=new JRadioButton[3];
	JPanel p1,p2,p3;

	public a3()
	{
		name=new JLabel("Your Name :");
		Class=new JLabel("Your Class :");
		Hobbies=new JLabel("Your Hobbies :");

		t1=new JTextField();
		t2=new JTextField(30);

		bg1=new ButtonGroup();

		bg[0]=new JRadioButton("FY");
		bg[1]=new JRadioButton("SY");
		bg[2]=new JRadioButton("TY");

		C1[0]=new JCheckBox("Music");
		C1[1]=new JCheckBox("Dance");
		C1[2]=new JCheckBox("Sport");

		p1=new JPanel();

		p1.setLayout(new GridLayout(1,2));
		p1.add(name);
		p1.add(t1);

		p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
		p2.add(Class);
		for(int i=0;i<3;i++)
		{
			p2.add(bg[i]);
			bg1.add(bg[i]);
		}
		JPanel p4=new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
		p4.add(Hobbies);
		for(int i=0;i<3;i++)
		{
			p4.add(C1[i]);
		}
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		c.add(p1);
		c.add(p2);
		c.add(p4);
		c.add(t2);
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bg[0].addItemListener(this);
		bg[1].addItemListener(this);
		bg[2].addItemListener(this);
		C1[0].addItemListener(this);
		C1[1].addItemListener(this);
		C1[2].addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		String N="Name :",C="Class :",H="Hobbies :";
		N+=t1.getText();
		for(int i=0;i<3;i++)
		{
			if(bg[i].isSelected())
				C+=bg[i].getText()+"";
			if(C1[i].isSelected())
				H+=C1[i].getText()+"";
			t2.setText(N+H+C);
		}
	}
	public static void main(String args[])
	{
		new a3();
	}

