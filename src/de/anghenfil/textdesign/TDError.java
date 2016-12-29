package de.anghenfil.textdesign;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.anghenfil.messages.Messages;

public class TDError {
	public static void outError(String errormsg){
		JFrame errorframe = new JFrame(Messages.getString("Error.error")); //$NON-NLS-1$
		JOptionPane.showMessageDialog(errorframe, errormsg);
	}
}
