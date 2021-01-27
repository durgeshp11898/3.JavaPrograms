import java.awt. * ;
import javax.swing. * ;
import java.awt.event. * ;

public class GUIdemo extends JFrame implements ItemListener
{
  String title;
  Choice choice1, choice2;
  JLabel l1, l2, l3;
  JTextField t1;
  JCheckBox c1, c2, c3;

  public GUIdemo (String title)
  {
    super (title);
    t1 = new JTextField (20);
    l1 = new JLabel ("Font");
    l2 = new JLabel ("Style");
    l3 = new JLabel ("Size");
    choice1 = new Choice ();
    choice1.add ("Arial");
    choice1.add ("Arial Black");
    choice1.add ("Roman");
    choice2 = new Choice ();
    choice2.add ("10");
    choice2.add ("15");
    choice2.add ("20");
    c1 = new JCheckBox ("Bold");
    c2 = new JCheckBox ("Italic");
    c3 = new JCheckBox ("underline");
    JPanel p1 = new JPanel ();
    JPanel p2 = new JPanel ();
      p1.setLayout (new GridLayout (4, 2));
      p1.add (l1);
      p1.add (l2);
      p1.add (choice1);
      p1.add (c1);
      p1.add (l3);
      p1.add (c2);
      p1.add (choice2);
      p1.add (c3);
      p1.add (t1);
      choice1.addItemListener (this);
      choice2.addItemListener (this);
      add (p1.BorderLayout.CENTER);
      add (p2.BorderLayout.SOUTH);
      setSize (200, 200);
      setVisible (true);
  }
  public void itemStateChange (ItemEvent ie)
  {
  }
  public static void main (String args[])
  {
    new GUIdemo ("CHOICE");
  }
}
