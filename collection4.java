import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class collection4 implements ActionListener
{
JFrame f;
JTextField tf1,tf2,tf3,tf4,tf5;
JButton b1,b2,b3;
JPanel p1,p2,p3,p4,p5;
Hashtable ht=new Hashtable();

collection4()
{
f=new JFrame("Phone Book");
f.setSize(400,400);
f.setVisible(true);
f.setLayout(new GridLayout(1,2));

p1=new JPanel();
tf1=new JTextField(30);
p1.add(tf1);

p2=new JPanel(new BorderLayout());
p3=new JPanel();
tf2=new JTextField("cityname",10);
tf3=new JTextField("citycode",10);
p3.add(tf2);
p3.add(tf3);

p4=new JPanel();
b1=new JButton("ADD");
p4.add(b1);

p5=new JPanel(new GridLayout(2,2));
tf4=new JTextField(10);
tf5=new JTextField(10);
b2=new JButton("REMOVE");
b3=new JButton("SEARCH");
p5.add(tf4);
p5.add(tf5);
p5.add(b2);
p5.add(b3);
p2.add(p3,BorderLayout.NORTH);
p2.add(p4,BorderLayout.CENTER);
p2.add(p5,BorderLayout.SOUTH);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
f.add(p1);
f.add(p2);

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public void actionPerformed(ActionEvent e)
{
if(e.getActionCommand().equals("ADD"))
{
String nm=tf2.getText();
String code=tf3.getText();
ht.put(nm,code);
tf1.setText(tf1.getText()+"\n"+nm+"\t"+code+"\n");
}

if(e.getActionCommand().equals("REMOVE"))
{
String nm=tf4.getText();
ht.remove(nm);
tf1.setText("City "+nm+" removed.");
}

if(e.getActionCommand().equals("SEARCH"))
{
String nm=tf5.getText();
String code=(String)ht.get(nm);
if(code == null)
tf1.setText("City not found" );
else
tf1.setText(code);
}
}

public static void main(String args[])
{
new collection4();
}
}

