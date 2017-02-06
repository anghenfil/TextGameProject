package de.anghenfil.gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import de.anghenfil.maingame.MainControl;
import de.anghenfil.maingame.MainGame;
import de.anghenfil.messages.Messages;
import de.anghenfil.textdesign.TD;
import de.anghenfil.user.User;
import de.anghenfil.user.UserManager;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Window {

	private JFrame frmTheTextgameprojectV;
	private JTextField textField;
	private JTextPane textPane;
	private HTMLEditorKit kit = new HTMLEditorKit();
	private HTMLDocument doc = new HTMLDocument();
	private JProgressBar hpBar = new JProgressBar();
	private JProgressBar apBar = new JProgressBar();
	private User user = MainGame.getUser();
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
		frmTheTextgameprojectV.setBounds(100, 100, 686, 366);
		frmTheTextgameprojectV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheTextgameprojectV.setVisible(true);
		frmTheTextgameprojectV.setResizable(false);
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
		scrollPane.setAutoscrolls(true);
		
		frmTheTextgameprojectV.getContentPane().setLayout(null);
		frmTheTextgameprojectV.getContentPane().add(label);
		frmTheTextgameprojectV.getContentPane().add(textField);
		frmTheTextgameprojectV.getContentPane().add(scrollPane);
		
		JLabel lblHp = new JLabel(Messages.getString("MainGame.lblHp.text")); //$NON-NLS-1$
		lblHp.setBounds(498, 22, 125, 14);
		frmTheTextgameprojectV.getContentPane().add(lblHp);
		frmTheTextgameprojectV.getContentPane().add(apBar);
		apBar.setBounds(498, 79, 146, 14);
		apBar.setMaximum(user.getMaxActionPoints());
		apBar.setValue(user.getActionPoints());
		apBar.setStringPainted(true);
		apBar.setString(user.getActionPoints() + " " + Messages.getString("MainGame.points"));
		
		JLabel lblap = new JLabel(Messages.getString("MainGame.lblap.text")); //$NON-NLS-1$
		lblap.setBounds(498, 64, 125, 14);
		frmTheTextgameprojectV.getContentPane().add(lblap);
		
		hpBar.setBounds(498, 81, 146, 14);
		frmTheTextgameprojectV.getContentPane().add(hpBar);
		hpBar.setBounds(498, 39, 146, 14);
		hpBar.setMaximum(user.getMaxHealthPoints());
		hpBar.setValue(user.getHealthPoints());
		hpBar.setStringPainted(true);
		hpBar.setString(user.getHealthPoints() + " " + Messages.getString("MainGame.points"));
	}
	public void updateHpBar(int hp){
		hpBar.setValue(hp);
		hpBar.setString(user.getHealthPoints() + " " + Messages.getString("MainGame.points"));
	}
	public void updateApBar(int ap){
		apBar.setValue(ap);
		apBar.setString(user.getActionPoints() + " " + Messages.getString("MainGame.points"));
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
