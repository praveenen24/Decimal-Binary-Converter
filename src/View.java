import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class View extends JFrame {
	private JTextField value;
	private JTextField results;
	private JRadioButton binaryToDecimal;
	private JRadioButton decimalToBinary;


	public View() {
		super("Binary/Decimal Converter");
		add(getMainPanel());
		setSize(300, 300);
	}

	private ActionListener convertListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (binaryToDecimal.isSelected()) {
				int result = ConvertToDecimal.getDecimal(value.getText());
				StringBuilder builder = new StringBuilder();
				builder.append(result);
				if (result == -1) {
					JOptionPane.showMessageDialog(getContentPane(), "Invalid Value");
					return;
				}
				results.setText(builder.toString());
			} else {
				if (value.getText().length() <= 10) {
					String result = ConvertToBinary.getBinary(Integer.parseInt(value.getText()));
					results.setText(result);
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Value too large");
				}
			}
		}

	};

	private JPanel getMainPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Enter Value To Convert"));
		value = new JTextField();
		value.addActionListener(convertListener);
		results = new JTextField();
		panel.add(value);
		panel.add(new JLabel("Result"));
		panel.add(results);
		ButtonGroup group = new ButtonGroup();
		binaryToDecimal = new JRadioButton("Binary-To-Decimal");
		binaryToDecimal.setSelected(true);
		decimalToBinary = new JRadioButton("Decimal-To-Binary");
		group.add(binaryToDecimal);
		group.add(decimalToBinary);
		panel.add(binaryToDecimal);
		panel.add(decimalToBinary);
		JButton convert = new JButton("Convert");
		convert.addActionListener(convertListener);
		panel.add(convert);
		return panel;
	}

}
