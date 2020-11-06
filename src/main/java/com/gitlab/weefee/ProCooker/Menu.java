package com.gitlab.weefee.ProCooker;

import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("ProCooker");
	
		JLabel menuName = new JLabel("ProCooker"); // dialogue of the game's events, judge speech, etc.
		
		JButton start = new JButton("BEGIN"); // button to begin the game
		JButton exit = new JButton("EXIT"); // button to exit the game
	
		//Image section
		JPanel options = new JPanel();
		options.setLayout(new FlowLayout());
		options.add(start);
		options.add(exit);
		options.setBorder(BorderFactory.createTitledBorder("Options"));
		
		//Rules section
		JPanel rules = new JPanel();
		rules.setLayout(new GridLayout(25, 0));
		
		JLabel ruling = new JLabel("You're a chef tasked with creating a 3-round dinner with only 4 ingredients per meal.");
		JLabel ruling2 = new JLabel("Certain ingredients taste better or worse when paired with others. Find the best combinations in order to take home the crown of best ProCooker,");
		JLabel ruling3 = new JLabel("as long as you can defeat the great evil known as the computer player.");
		
		rules.add(ruling);
		rules.add(ruling2);
		rules.setBorder(BorderFactory.createTitledBorder("Rules"));
			
		//Text Box section
		JPanel title = new JPanel();
		title.add(menuName);
		title.setBorder(BorderFactory.createTitledBorder("By Alcide Viau and Allan Yang"));
			
			
		frame.setLayout(new BorderLayout());
		frame.add(title, BorderLayout.NORTH);
		frame.add(options, BorderLayout.SOUTH);
		frame.add(rules, BorderLayout.CENTER);
		frame.setSize(860, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			
		}
}
	