import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PalindromeGUI extends JFrame {

	JTextField userInput;
	JPanel myPanel;
	JButton checkButton;
	String phrase;
	String testPhrase = "";
	String reverseTestPhrase = "";

	PalindromeGUI() {

		setTitle("Palindrome Checker (Letters, Words or Phrases. No numericals)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 100);
		setVisible(true);

		myPanel = new JPanel();
		add(myPanel);

		userInput = new JTextField(50);
		myPanel.add(userInput);

		checkButton = new JButton("Check");
		myPanel.add(checkButton);

		checkString();
	}

	private void checkString() {
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testPhrase = "";
				reverseTestPhrase = "";
				phrase = userInput.getText();
				userInput.setText("");
				// remove spaces & symbols
				for (int i = 0; i < phrase.length(); i++) {
					if (Character.isLetter(phrase.charAt(i)))
						testPhrase = testPhrase + phrase.charAt(i);
				}
				// convert to lower case
				testPhrase = testPhrase.toLowerCase();
				// reverse testPhrase
				for (int i = testPhrase.length() - 1; i >= 0; i--) {
					reverseTestPhrase = reverseTestPhrase
							+ testPhrase.charAt(i);
				}

				// display dialog boxes

				// check for numerical
				if (phrase.matches(".*\\d.*")) {
					JOptionPane.showMessageDialog(null, "No Numbers allowed");
					// check if only one letter
				} else if (testPhrase.length() < 2) {
					JOptionPane.showMessageDialog(null,
							"Enter at least two letters");
					// check strings equal. display Is a Palindrome
				} else if (testPhrase.equals(reverseTestPhrase)) {
					JOptionPane.showMessageDialog(null, phrase
							+ "\nIs a Palindrome");
					// display is not Palindrome
				} else
					JOptionPane.showMessageDialog(null, phrase
							+ "\nIs not a Palindrome");
			}
		});
	}

	public static void main(String[] args) {

		new PalindromeGUI();
	}
}