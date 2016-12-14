package de.anghenfil.textdesign;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TDError {
	public static void outError(String errormsg){
		JFrame errorframe = new JFrame("Error.");
		JOptionPane.showMessageDialog(errorframe, errormsg);
	}
}
