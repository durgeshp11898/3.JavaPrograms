import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Hashtable;
import java.util.Enumeration;

class CityDetails implements ActionListener {
	static JFrame homeFrame;
	static JButton addButton, removeButton, searchButton;
	static JTextField addCity, addCode, removeCity, searchCity;
	static JTextArea display;
	static Font font;
	static Hashtable ht;
	static Enumeration enKeys, enValues;

	CityDetails() {
		ht = new Hashtable();
	
		font = new Font("CM Roman", Font.PLAIN, 18);
		
		homeFrame = new JFrame("City Details");
		homeFrame.setSize(600,430);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setLayout(null);
		
		display = new JTextArea(400,270);
		display.setFont(font);
		display.setEditable(false);
		display.setLineWrap(true);
		display.setBounds(10,10,270,400);
		homeFrame.add(display);
		
		addCity = new JTextField(140);
		addCity.setFont(font);
		addCity.setBounds(300,10,140,90);
		homeFrame.add(addCity);
		
		addCode = new JTextField(140);
		addCode.setFont(font);
		addCode.setBounds(450,10,140,90);
		homeFrame.add(addCode);
		
		addButton = new JButton("ADD");
		addButton.setFont(font);
		addButton.setBounds(370,110,140,90);
		addButton.addActionListener(this);
		homeFrame.add(addButton);
		
		removeCity = new JTextField(140);
		removeCity.setFont(font);
		removeCity.setBounds(300,210,140,90);
		homeFrame.add(removeCity);
		
		searchCity = new JTextField(140);
		searchCity.setFont(font);
		searchCity.setBounds(450,210,140,90);
		homeFrame.add(searchCity);
		
		removeButton = new JButton("REMOVE");
		removeButton.setFont(font);
		removeButton.setBounds(300,310,140,90);
		removeButton.addActionListener(this);
		homeFrame.add(removeButton);
		
		searchButton = new JButton("SEARCH");
		searchButton.setFont(font);
		searchButton.setBounds(450,310,140,90);
		searchButton.addActionListener(this);
		homeFrame.add(searchButton);
		
		homeFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		display.setText("");
	
		enKeys = ht.keys();
		enValues = ht.elements();
		while(enKeys.hasMoreElements()) {
			String nK = enKeys.nextElement() + "";
			String nV = enValues.nextElement() + "";
			display.append(nK  + " : " + nV + "\n");
			System.out.println(nK  + " : " + nV);
		}
		
		JButton source = (JButton) ae.getSource();
		
		System.out.println(source.getText());
		
		if(source.getText().equals("ADD")) {
			if(ht.contains(addCity.getText())) {
				JOptionPane.showMessageDialog(homeFrame, "Duplicate Value will not be accepted!");
			} else {
				JOptionPane.showMessageDialog(homeFrame, "Duplicate Value will be updated!");
				ht.put(addCity.getText(), addCode.getText());
			}
		} else if(source.getText().equals("REMOVE")) {
			if(ht.contains(removeCity.getText())) {
				JOptionPane.showMessageDialog(homeFrame, "Invalid Entry!");
			} else {
				ht.remove(removeCity.getText());
			}
		} else if(source.getText().equals("SEARCH")) {
			if(ht.contains(searchCity.getText())) {
				JOptionPane.showMessageDialog(homeFrame, "Invalid Entry!");
			} else {
				if(ht.get(searchCity.getText()).equals("")) {
					JOptionPane.showMessageDialog(homeFrame, "City not Found!");
				} else {
					JOptionPane.showMessageDialog(homeFrame, "City Code for '"+ searchCity.getText() +"' is : " + ht.get(searchCity.getText()));
				}
			}
		}
		
		display.setText("");
		enKeys = ht.keys();
		enValues = ht.elements();
		while(enKeys.hasMoreElements()) {
			String nK = enKeys.nextElement() + "";
			String nV = enValues.nextElement() + "";
			display.append(nK  + " : " + nV + "\n");
		}
		
		addCity.setText("");
		addCode.setText("");
		searchCity.setText("");
		removeCity.setText("");
	}
	
	public static void main(String ss[]) {
		new CityDetails();
		
	}
}
