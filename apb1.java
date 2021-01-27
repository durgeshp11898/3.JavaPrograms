import java.awt.*;
import java.awt.event.KeyAdapter.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
/*
   <applet code="apb1.class" width=500 height=200>
   </applet>
   */
public class apb1 extends Applet 
{
	JTextField t;
	String m="";

	public void init()
	{
		t=new JTextField(30);
		add(t);
		t.addKeyListener(new KeyAdapter()
				{
					public void keyPressed(KeyEvent ke)
					{
						m="Key Pressed"+ke.getKeyChar();
						t.setText(m);
						repaint();
					}
				});
		addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent me)
					{
						int a=me.getButton();
						String b="";

						switch(a)
						{
							case 1:
								{
									b="Left Button ";
									break;
								}
							case 2:
								{
									b="Wheel ";
									break;
								}
							case 3:
								{
									b="Right Button ";
									break;
								}
						}
						m="Mouse Clicked: X ="+me.getX()+"y="+me.getY();
						repaint();
					}
					public void mousePressed(MouseEvent me)
					{
						int a=me.getButton();
						String b="";
						switch(a)
						{
							case 1:
								{
									b="Left Button ";
									break;
								}
							case 2:
								{
									b="Wheel ";
									break;
								}
							case 3:
								{
									b="Right Button ";
									break;
								}
						}
						m="Mouse Pressed : X="+me.getX()+"Y ="+me.getY();
						repaint();
					}
				});
		addMouseMotionListener(new MouseMotionAdapter()
				{
					public void mouseMoved(MouseEvent me)
					{
						m="Mouse Moved :X ="+me.getX()+"Y = "+me.getY();
						repaint();
					}
					public void mouseDragged(MouseEvent me)
					{
						m="Mouse Dragged :X ="+me.getX()+"Y = "+me.getY();
						repaint();
					}});
	}
	public void paint(Graphics g)
	{
		g.drawString(m,200,200);
	}
}

