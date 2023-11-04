package _06_overloading;

import javax.swing.JOptionPane;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		String popup = JOptionPane.showInputDialog("What do you want the FIRST pop-up to say?");
		
		LeagueOptionPane.showMessageDialog(popup);
		
		popup = JOptionPane.showInputDialog("What do you want the SECOND pop-up to say?");
		String title = JOptionPane.showInputDialog("What do you want the SECOND title to say?");
		
		LeagueOptionPane.showMessageDialog(popup, title);
		
		popup = JOptionPane.showInputDialog("What do you want the THIRD pop-up to say?");
		title = JOptionPane.showInputDialog("What do you want the THIRD title to say?");
		String image = JOptionPane.showInputDialog("What do you want the THIRD image to be (java, league, or leagueDark)?");
		
		LeagueOptionPane.showMessageDialog(popup, title, image);
	}
}
