package de.anghenfil.gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import de.anghenfil.maingame.MainControl;
import de.anghenfil.maingame.MainGame;
import de.anghenfil.messages.Messages;
import de.anghenfil.textdesign.TD;
import de.anghenfil.user.User;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Window {

	private JFrame frmTheTextgameprojectV;
	private JTextField textField;
	private JTextPane textPane;
	private HTMLEditorKit kit = new HTMLEditorKit();
	private HTMLDocument doc = new HTMLDocument();
	private JProgressBar hpBar = new JProgressBar();
	private JProgressBar apBar = new JProgressBar();
	private User user = MainGame.getUser();
	private JLabel level;
	private JButton settingGear;
	private JLabel cname;
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
		frmTheTextgameprojectV.setBounds(100, 100, 686, 352);
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
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textPane.setContentType("text/html"); //$NON-NLS-1$
		textPane.setEditorKit(kit);
		textPane.setDocument(doc);
		textPane.setMargin(new Insets(1, 1, 1, 1));
		textPane.setEditable(false);
	
		scrollPane.setViewportView(textPane);
		scrollPane.setHorizontalScrollBarPolicy(31);
		scrollPane.setAutoscrolls(true);
		
		JLabel lblHp = new JLabel(Messages.getString("MainGame.lblHp.text"));
		lblHp.setBounds(498, 107, 125, 14);
		apBar.setBounds(498, 164, 146, 14);
		apBar.setMaximum(user.getMaxActionPoints());
		apBar.setValue(user.getActionPoints());
		apBar.setStringPainted(true);
		apBar.setString(user.getActionPoints() + " " + Messages.getString("MainGame.points"));
		
		JLabel lblap = new JLabel(Messages.getString("MainGame.lblap.text"));
		lblap.setBounds(498, 149, 125, 14);
		hpBar.setBounds(498, 124, 146, 14);
		hpBar.setMaximum(user.getMaxHealthPoints());
		hpBar.setValue(user.getHealthPoints());
		hpBar.setStringPainted(true);
		hpBar.setString(user.getHealthPoints() + " " + Messages.getString("MainGame.points"));
		frmTheTextgameprojectV.getContentPane().setLayout(null);
		frmTheTextgameprojectV.getContentPane().add(scrollPane);
		frmTheTextgameprojectV.getContentPane().add(textField);
		frmTheTextgameprojectV.getContentPane().add(label);
		frmTheTextgameprojectV.getContentPane().add(hpBar);
		frmTheTextgameprojectV.getContentPane().add(lblap);
		frmTheTextgameprojectV.getContentPane().add(apBar);
		frmTheTextgameprojectV.getContentPane().add(lblHp);
		
		level = new JLabel("" + user.getLevel());
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setBounds(568, 44, 34, 14);
		frmTheTextgameprojectV.getContentPane().add(level);
	
		JLabel levelicon = new JLabel(Messages.getString("Window.lblNewLabel.text")); //$NON-NLS-1$
		levelicon.setIcon(new ImageIcon(Window.class.getResource("/circle-50p.png")));
		levelicon.setBounds(559, 22, 50, 57);
		frmTheTextgameprojectV.getContentPane().add(levelicon);
		
		settingGear = new JButton("");
		settingGear.setRequestFocusEnabled(false);
		settingGear.setBorderPainted(false);
		settingGear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		settingGear.setContentAreaFilled(false);
		settingGear.setIcon(new ImageIcon(Window.class.getResource("/gear-25p.png")));
		settingGear.setBounds(643, 291, 34, 28);
		frmTheTextgameprojectV.getContentPane().add(settingGear);
		
		cname = new JLabel(user.getName());
		cname.setHorizontalAlignment(SwingConstants.CENTER);
		cname.setBackground(Color.LIGHT_GRAY);
		cname.setBounds(498, 79, 172, 14);
		frmTheTextgameprojectV.getContentPane().add(cname);
		
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
	public void updateCharacterInfo(){
		level.setText("" + user.getLevel());
		cname.setText(user.getName());
	}
	public void exit(){
		System.exit(1);
	}
}
