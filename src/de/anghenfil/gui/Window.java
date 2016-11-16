package de.anghenfil.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.Component;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import de.anghenfil.maingame.MainControl;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class Window {

	private JFrame frmTheTextgameprojectV;
	private JTextField textField;
	private JTextPane textPane;
	public static JTextPane getTextPane() {
		return window.textPane;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmTheTextgameprojectV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheTextgameprojectV = new JFrame();
		frmTheTextgameprojectV.setPreferredSize(new Dimension(1280, 720));
		frmTheTextgameprojectV.setTitle("The TextGameProject V.0.1");
		frmTheTextgameprojectV.setBounds(100, 100, 784, 466);
		frmTheTextgameprojectV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setMargin(new Insets(1, 1, 1, 1));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.checkInputs(textField.getText());
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
		textPane.setMargin(new Insets(1, 1, 1, 1));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		frmTheTextgameprojectV.getContentPane().setLayout(groupLayout);
	}
	
}
