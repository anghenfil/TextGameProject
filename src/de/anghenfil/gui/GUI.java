package de.anghenfil.gui;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class GUI {
	public static void mainGUI(){
		JFrame mainFrame = new JFrame("The TextGameProject V0.1");
		JTextPane textausgabe = new JTextPane();
		StyledDocument doc = (StyledDocument) textausgabe.getDocument();
		textausgabe.setContentType("text/plain");
		textausgabe.setEditable(false);
		textausgabe.setText("Hallo ich bin ein Penistext");
		mainFrame.add(textausgabe);
		mainFrame.setSize(1200,780);
		mainFrame.setVisible(true);
		try {
			doc.insertString(doc.getLength(), "I append later!", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

