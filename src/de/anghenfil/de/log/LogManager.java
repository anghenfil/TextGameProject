package de.anghenfil.de.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.textdesign.TDError;

public class LogManager {
	private static File log = new File(MainMenu.PATH + "/log.txt");
	
	public static void checkLog(){
		
		if(!log.exists()){
			try {
				
				
				if(log.createNewFile() == false){
					JFrame errorframe = new JFrame("ERROR"); //$NON-NLS-1$
					JOptionPane.showMessageDialog(errorframe, "ERROR. Couldn't create log file.");
					System.exit(1);
				}
			} catch (IOException e) {
				JFrame errorframe = new JFrame("ERROR"); //$NON-NLS-1$
				JOptionPane.showMessageDialog(errorframe, e.toString());
				System.exit(1);
			}
		}else{
			clearLog();
		}
	}
	private static void clearLog(){
		try {
			PrintWriter pw = new PrintWriter(MainMenu.PATH + "/log.txt");
			pw.close();
		} catch (FileNotFoundException e) {
		}
	}
	public static void add(String type, String msg){
		//Types. WARN; INFO; CRIT
		String typeprefix;
		if(type == "WARN"){
			typeprefix = "[WARN]";
		}else if(type == "INFO"){
			typeprefix = "[INFO]";
		}else if(type == "CRIT"){
			typeprefix = "[CRITICAL]";
		}else{
			typeprefix = "[UNKOWN]";
		}
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss").format(Calendar.getInstance().getTime());
		msg = timeStamp+" "+typeprefix+" "+msg+"\n";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(log, true));
			writer.write(msg);
			writer.newLine();
			writer.close();
		} catch (IOException e1) {
			JFrame errorframe = new JFrame("ERROR"); //$NON-NLS-1$
			JOptionPane.showMessageDialog(errorframe, "ERROR. Couldn't write to log file: "+e1.getMessage());
			System.exit(1);
		}
	}
	public static void add(String type, Exception e){
		add(type, e.getMessage());
		if(type == "CRIT"){
			TDError.outError("CRITICAL ERROR: "+e.getMessage());
			System.exit(1);
		}
	}
}
