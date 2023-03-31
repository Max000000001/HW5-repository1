package h05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainClass {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLocation(500, 500);
		frame.setTitle("My Frame");
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		
		final JTextField firstField = new JTextField("                         ");
		frame.add(firstField);
		final JComboBox<String> operationCombo = new JComboBox<String>(new String[] {"+", "-", "*", "/"});
		frame.add(operationCombo);
		final JTextField secondField = new JTextField("                          ");
		frame.add(secondField);
		final JButton calculateButton = new JButton("=");
		frame.add(calculateButton);
		final JTextField resultField = new JTextField("                          ");
		frame.add(resultField);
		
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float result = 0;
				String result1 = "";
				try {
					float x = Float.parseFloat(firstField.getText());
					float y = Float.parseFloat(secondField.getText());
					
					if (operationCombo.getSelectedItem().equals("+")) {
						result = x+y;
						result1=Float.toString(result);
					}
					else if (operationCombo.getSelectedItem().equals("-")) {
						result = x-y;
						result1=Float.toString(result);
					}
					else if (operationCombo.getSelectedItem().equals("*")) {
						result = x*y;
						result1=Float.toString(result);
					}
					else if (operationCombo.getSelectedItem().equals("/")) {
						if (y!=0) {
							result = x/y;
							result1=Float.toString(result);
						}
						else {
							result1 = "Calculation error";
						}
					}
				}
				catch (NumberFormatException nfe) {
					result1 = "Calculation error";
				}
				resultField.setText(String.valueOf(result1));
			}			
		});
		
		
		
	}
}
