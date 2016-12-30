package de.anghenfil.gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.LayoutStyle.ComponentPlacement;

import de.anghenfil.maingame.MainControl;
import de.anghenfil.messages.Messages;
import de.anghenfil.textdesign.TD;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;

public class Window {

	private JFrame frmTheTextgameprojectV;
	private JTextField textField;
	private JTextPane textPane;
	private HTMLEditorKit kit = new HTMLEditorKit();
	private HTMLDocument doc = new HTMLDocument();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frmTheTextgameprojectV = new JFrame();
		frmTheTextgameprojectV.setPreferredSize(new Dimension(1280, 720));
		frmTheTextgameprojectV.setTitle(Messages.getString("General.gametitel")); //$NON-NLS-1$
		frmTheTextgameprojectV.setBounds(100, 100, 784, 353);
		frmTheTextgameprojectV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheTextgameprojectV.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 22, 462, 257);
		
		textField = new JTextField();
		textField.setBounds(26, 285, 462, 21);
		textField.setMargin(new Insets(1, 1, 1, 1));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = "unset"; //$NON-NLS-1$
				input = textField.getText();
				TD.input(input);
				MainControl.checkInputs(input);
				textField.setText(""); //Remove input in textfield after pressing enter //$NON-NLS-1$
			}
		});
		textField.setColumns(10);
		
		JLabel label = new JLabel(">");
		label.setBounds(12, 281, 21, 28);
		
		textPane = new JTextPane();
		textPane.setContentType("text/html"); //$NON-NLS-1$
		textPane.setEditorKit(kit);
		textPane.setDocument(doc);
		textPane.setMargin(new Insets(1, 1, 1, 1));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		scrollPane.setHorizontalScrollBarPolicy(31);
		frmTheTextgameprojectV.getContentPane().setLayout(null);
		frmTheTextgameprojectV.getContentPane().add(label);
		frmTheTextgameprojectV.getContentPane().add(textField);
		frmTheTextgameprojectV.getContentPane().add(scrollPane);
	}
	public void addText(String inhalt){
		try {
			kit.insertHTML(doc, doc.getLength(), inhalt, 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void exit(){
		System.exit(1);
	}
}
