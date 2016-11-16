package de.anghenfil.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUItools {
	
	static void createFrame(){
		JFrame mainFrame = new JFrame("TextGameProject v.01");
		mainFrame.setSize(1024, 720);
		mainFrame.setVisible(true);
		
		JEditorPane konsolenausgabe = new JEditorPane();
		konsolenausgabe.setPreferredSize(new Dimension(100, 100));
		konsolenausgabe.setBackground(Color.red);
		
		 JScrollPane scrollPane = new JScrollPane(konsolenausgabe);
	        mainFrame.add(scrollPane);
	 
	        mainFrame.setVisible(true);
		
	}
}
