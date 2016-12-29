package de.anghenfil.textdesign;
import de.anghenfil.maingame.MainGame;
import de.anghenfil.messages.Messages;

public class TD {
	public static void headline(String content){
		de.anghenfil.gui.Window window = MainGame.getWindow();
		int countchars;
		String line = ""; //$NON-NLS-1$
		try{
			countchars = content.length();
			for(int i = 0;i<countchars+2;i++){
				line = line.concat("="); //$NON-NLS-1$
			}
			window.addText("<b>"+ line + "</b>"); //$NON-NLS-1$ //$NON-NLS-2$
			window.addText("<b>"+content+"</b>"); //$NON-NLS-1$ //$NON-NLS-2$
			window.addText("<b>"+ line + "</b>"); //$NON-NLS-1$ //$NON-NLS-2$
		}catch(NullPointerException e){
		}
	}public static void input_question(String content){
		de.anghenfil.gui.Window window = MainGame.getWindow();
		window.addText("|| "); //$NON-NLS-1$
		window.addText(content);
	}public static void input(String content){
		de.anghenfil.gui.Window window = MainGame.getWindow();
		window.addText("> " + content); //$NON-NLS-1$
	}public static void description(String content){
		try{
			de.anghenfil.gui.Window window = MainGame.getWindow();
			window.addText(content);
		}catch(NullPointerException e){
		}
	}public static void error(String content){
			de.anghenfil.gui.Window window = MainGame.getWindow();
			window.addText("<b color='red'>"+content+"</b>"); //$NON-NLS-1$ //$NON-NLS-2$
	}public static void error(){
		error(Messages.getString("Error.answercouldntidentified")); //$NON-NLS-1$
	}
}
