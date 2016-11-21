package de.anghenfil.textdesign;
import de.anghenfil.mainmenu.MainMenu;

public class TD {
	public static void headline(String content){
		de.anghenfil.gui.Window window = MainMenu.getWindow();
		int countchars;
		String line = "";

		countchars = content.length();
		for(int i = 0;i<countchars+2;i++){
			line = line.concat("=");
		}
		window.addText("<b>"+ line + "</b>");
		window.addText("<b>"+content+"</b>");
		window.addText("<b>"+ line + "</b>");
	}public static void input_question(String content){
		de.anghenfil.gui.Window window = MainMenu.getWindow();
		window.addText("|| ");
		window.addText(content);
	}public static void input(String content){
		de.anghenfil.gui.Window window = MainMenu.getWindow();
		window.addText("> " + content);
	}public static void description(String content){
		de.anghenfil.gui.Window window = MainMenu.getWindow();
		window.addText("<b>"+content+"</b>");
	}public static void error(String content){
		de.anghenfil.gui.Window window = MainMenu.getWindow();
		window.addText("<b>"+content+"</b>");
	}public static void error(){
		error("Deine Antwort konnte nicht erkannt werden. Bitte wiederhole deine Eingabe!");
	}
}
