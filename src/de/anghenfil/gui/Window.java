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
import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.textdesign.TD;
import de.anghenfil.user.UserManager;

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
	 */
	public void initialize() {
		frmTheTextgameprojectV = new JFrame();
		frmTheTextgameprojectV.setPreferredSize(new Dimension(1280, 720));
		frmTheTextgameprojectV.setTitle("The TextGameProject V.0.1");
		frmTheTextgameprojectV.setBounds(100, 100, 784, 466);
		frmTheTextgameprojectV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheTextgameprojectV.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setMargin(new Insets(1, 1, 1, 1));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = "unset";
				if(MainMenu.getCreatenew()){ //If we are in User Creation
					input = textField.getText();
					UserManager.checkInput();
				}
				input = textField.getText();
				TD.input(input);
				MainControl.checkInputs(input);
				textField.setText(""); //Remove input in textfield after pressing enter
			}
		});
		textField.setColumns(10);
		
		JLabel label = new JLabel(">");
		GroupLayout groupLayout = new GroupLayout(frmTheTextgameprojectV.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
					.addContainerGap(282, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		
		textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setEditorKit(kit);
		textPane.setDocument(doc);
		textPane.setMargin(new Insets(1, 1, 1, 1));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		scrollPane.setHorizontalScrollBarPolicy(31);
		frmTheTextgameprojectV.getContentPane().setLayout(groupLayout);
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
