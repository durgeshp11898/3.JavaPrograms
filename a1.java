import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class a1 implements ItemListener
{	
	JFrame f;
	
	JTextField jtf;
	JCheckBox jc1,jc2,jc3;
	JComboBox jcc1,jcc2;
	JLabel l1,l2,l3;
	public a1()
	{
		f=new JFrame();
		f.setLayout(new FlowLayout());
		f.setSize(300,400);
		f.setVisible (true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel p1=new JPanel(new GridLayout(4,0));
		JPanel p2=new JPanel(new GridLayout(4,0));
		JPanel p3=new JPanel(new GridLayout(1,2));
		JPanel p4=new JPanel();
		
		l1=new JLabel("font");
		l2=new JLabel("style");
		l3=new JLabel("size");
		
	
		
		jcc1=new JComboBox();
		
		jcc1.addItem("Arial");
		jcc1.addItem("Arial Black");
		jcc1.addItem("Roman");
		jcc1.addItem("Meera");
		jcc1.addItemListener(this);
		
		jcc2=new JComboBox();
		
		jcc2.addItem("10");
		jcc2.addItem("16");
		jcc2.addItem("20");
		jcc2.addItem("24");
		jcc2.addItemListener(this);
		
		jc1=new JCheckBox("bold");
		jc2=new JCheckBox("italic");
		jc3=new JCheckBox("underline");
		jc1.addItemListener(this);
		jc2.addItemListener(this);
		jc3.addItemListener(this);
		
		jtf=new JTextField(15);
		
		p1.add(l1);
		p1.add(jcc1);
		p1.add(l3);
		p1.add(jcc2);
		p2.add(l2);
		p2.add(jc1);
		p2.add(jc2);
		p2.add(jc3);
		p4.add(jtf);
		p3.add(p1);
		p3.add(p2);
		f.add(p3);
		f.add(p4);
	
		f.setVisible (true);
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(jc1.isSelected())
		{
			String temp=jtf.getText();
			String str1=(String)jcc1.getSelectedItem();
			String str2=(String)jcc2.getSelectedItem();
			int size=Integer.parseInt(str2);
			Font f=new Font(str1,Font.BOLD,size);
			jtf.setFont(f);
			jtf.setText(temp);
		}
		if(jc2.isSelected())
		{
			String temp=jtf.getText();
			String str1=(String)jcc1.getSelectedItem();
			String str2=(String)jcc2.getSelectedItem();
			int size=Integer.parseInt(str2);
			Font f=new Font(str1,Font.ITALIC,size);
			jtf.setFont(f);
			jtf.setText(temp);
		}
		/*if(jc3.isSelected())
		{
			String temp=jtf.getText();
			String str1=(String)jcc1.getSelectedItem();
			String str2=(String)jcc2.getSelectedItem();
			int size=Integer.parseInt(str2);
			Font f=new Font(str1,Font.UNDERLINE,size);
			jtf.setFont(f);
			jtf.setText(temp);
		}*/
	}
	
	
	public static void main(String[] args)
	{
		new a1();
	}
}
