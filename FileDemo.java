/*Name:Hakima Zahidi
 * Rollno:23
 * Assin6 set b q2*/

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
class FileDemo extends JFrame implements ActionListener,ItemListener
{
	JFrame f;
	JMenuBar mb;
	JMenu m1, m2, m3, m4;
	JMenuItem it[] = new JMenuItem[10];
	JRadioButtonMenuItem r1, r2;
	JTextArea t;
	int c[] = new int[20];
	String fname = "";
	FileDemo ()
	{
		f = new JFrame ();
		mb = new JMenuBar ();
		m1 = new JMenu ("File");
		m2 = new JMenu ("compute");
		m3 = new JMenu ("Operation");
		m4 = new JMenu ();
		mb.add (m1);
		mb.add (m2);
		mb.add (m3);
		t = new JTextArea (5, 5);
		it[0] = new JMenuItem ("Load");
		it[1] = new JMenuItem ("Save");
		it[2] = new JMenuItem ("Exit");
		it[3] = new JMenuItem ("Sum");
		it[4] = new JMenuItem ("Average");
		it[5] = new JMenuItem ("Maximum");
		it[6] = new JMenuItem ("Minimum");
		it[7] = new JMenuItem ("Median");
		it[8] = new JMenuItem ("Search");
		it[9] = new JMenuItem ("Sort");
		r1 = new JRadioButtonMenuItem ("Ascending");
		r2 = new JRadioButtonMenuItem ("Descending");
		for (int i = 0; i < 3; i++)
		{
			m1.add (it[i]);
			it[i].addActionListener (this);
		}
		for (int i = 3; i < 8; i++)
		{
			m2.add (it[i]);
			it[i].addActionListener (this);
		}
		for (int i = 8; i < 10; i++)
		{
			m3.add (it[i]);
			it[i].addActionListener (this);
		}
		r1.addItemListener (this);
		r2.addItemListener (this);
		m3.insertSeparator (1);
		m3.add (m4);
		m4.add (r1);
		m4.add (r2);
		f.setLayout (new GridLayout (2, 1, 5, 5));
		f.setJMenuBar (mb);
		f.add (t);
		f.setSize (500, 500);
		f.setVisible (true);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);}
	public void actionPerformed(ActionEvent ae)
	{
		JMenuItem btn = (JMenuItem) ae.getSource ();
		if (btn == it[0])
		{
			loadf ();}
		if (btn == it[1])
		{
			save ();}
		if (btn == it[2])
		{
			System.exit (0);}
		if (btn == it[3])
		{
			sum ();}
		if (btn == it[4])
		{
			average ();}
		if (btn == it[5])
		{
			maximum ();}
		if (btn == it[6])
		{
			minimum ();}
		if (btn == it[7])
		{
			median ();}
		if (btn == it[8])
		{
			search ();}}

	public void itemStateChanged (ItemEvent ie)
	{
		if (r1.isSelected ())ascending ();
		if (r2.isSelected ())descending ();}
	public void loadf ()
	{
		JFrame f = new JFrame ();
		JFileChooser jc = new JFileChooser ();
		jc.setCurrentDirectory (new File ("."));
		jc.setMultiSelectionEnabled (true);
		jc.showOpenDialog (f);
		fname += jc.getSelectedFile (); 
		try
		{
			String line = "";
			int s;
			FileReader fr = new FileReader (jc.getSelectedFile ());
			FileReader fr1=new FileReader (jc.getSelectedFile());
			BufferedReader bf = new BufferedReader (fr1);
			while ((s = fr.read ()) != -1){
				line +=(char) s;}
			int i = 0;
			do
			{
				String line1 = bf.readLine ();
				if (line1 == null)
					break; 
				c[i] = Integer.parseInt (line1);
				i++;}
			while (true); bf.close ();
			t.setText (line);}
		catch (Exception e)
		{
		}
	}
	public void sum ()
	{
		int sum = 0, i = 0;
		do
		{
			if (c[i] == '\0') break;
			else
				sum = sum + c[i]; i++;}
		while (true);
		JOptionPane.showMessageDialog (null,
				"sum is:" +
				sum);}
		public void average ()
		{
			int sum = 0, i = 0;
			do
			{
				if (c[i] == '\0') break;
				else
					sum = sum + c[i]; i++;
			} while (true);
			int avg = sum / (i);
			JOptionPane.showMessageDialog (null,
					"Average is:"
					+ avg);}
			public void maximum()
			{
				int max = c[0];
				for (int i = 1; i < c.length; i++)
				{
					if (max <= c[i])
						max = c[i];
				}
				JOptionPane.showMessageDialog (null, "Maximum is:" + max);
			}
			public void minimum ()
			{
				int min = c[0];
				for (int i = 0; c[i] != '\0'; i++)
				{
					if (min >= c[i])
						min = c[i];
				}
				JOptionPane.showMessageDialog (null, "minimum is:" + min);
			}
			public void search ()
			{
				String d =
					JOptionPane.
					showInputDialog ("Enter the no to be searched");
				int n = Integer.parseInt (d);
				int flag = 0;
				for (int i = 0; c[i] != '\0'; i++)
				{
					if (n == c[i])
					{
						JOptionPane.showMessageDialog (null,
								"No Found at Position:"
								+ (i + 1));
						flag = 1;
						break;
					}
				}
				if (flag == 0)
					JOptionPane.showMessageDialog (null, "Number not found!");
			}
			public void descending ()
			{
				String s = "";
				int n = c.length;
				for (int i = 0; i < n; i++)
				{
					for (int j = 0; j < n - i - 1; j++)
					{
						if (c[j] <= c[j + 1]){
							int t = c[j];
							c[j] = c[j + 1];
							c[j + 1] = t;
						}}}
				for (int i = 0; c[i] != '\0'; i++)
				{
					//s+="\n";
					s += Integer.toString (c[i]) + "\n";
				}
				t.setText (s);
			}
			public void ascending ()
			{
				String s = "";
				int n = 0;
				for (int i = 0; c[i] != '\0'; i++)
					n++;
				for (int i = 0; i < n; i++)
				{
					for (int j = 0; j < n - i - 1; j++)
					{
						if (c[j] >= c[j + 1])
						{
							int t = c[j];
							c[j] = c[j + 1];
							c[j + 1] = t;
						}
					}}
				for (int i = 0; c[i] != '\0'; i++)
				{
					//s+="\n";
					s += Integer.toString (c[i]) + "\n";
				}
				t.setText (s);
			}

			public void median ()
			{
				int n = 0;
				float mid = 0;
				for (int i = 0; c[i] != '\0'; i++)
					n++;
				for (int i = 0; i < n; i++)
				{
					for (int j = 0; j < n - i - 1; j++)
					{
						if (c[j] >= c[j + 1])
						{
							int t = c[j];
							c[j] = c[j + 1];
							c[j + 1] = t;
						}
					}}
				if (n % 2 == 0)
				{
					mid = (c[(n / 2)] + c[(n / 2) + 1]) / 2;
				}
				else
					mid = c[n / 2];
				JOptionPane.showMessageDialog (null, "Median is:" + mid);
			}
			public void save ()
			{
				try
				{
					FileWriter fw = new FileWriter (fname);
					String d = "";
					d += t.getText ();
					fw.write (d);
					fw.close ();
				}
				catch (Exception e)
				{
				}
			}
			public static void main (String args[])
			{
				new FileDemo ();
			}
}
