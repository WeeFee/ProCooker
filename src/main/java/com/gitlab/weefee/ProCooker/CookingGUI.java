package com.gitlab.weefee.ProCooker;

import java.awt.*;
import javax.swing.*;

public class CookingGUI extends JPanel {
	
	private CookingGame game; // game model
	
	private JTextField dialogue = new JTextField(6); // dialogue of the game's events, judge speech, etc.
	
	private JButton[] ingredients = new JButton[16]; // JButton array of every ingredient
	
	private JButton cookNow = new JButton(); // button to end cooking earlier
	private JButton reset = new JButton(); // button to immediately reset game
	
	public CookingGUI(CookingGame newGame) {
		super();
		this.game = newGame;
		this.game.setGUI(this);
		//this.layoutView();
		//this.registerControllers();
		//this.update();
	}
	
	private void layoutView() {
		//Image section
		JPanel visual = new JPanel();
		visual.setBorder(BorderFactory.createTitledBorder("The cook!"));
		
		//Text Box section
		JPanel communication = new JPanel();
		communication.add(dialogue);
		communication.setBorder(BorderFactory.createTitledBorder("What's going on:"));
		
		//List of ingredients section
		JPanel ingredients = new JPanel();
		
		for(int i = 0; i < 16; i++) {
			ingredients.add(this.ingredients[i]);
		}
		
		ingredients.setBorder(BorderFactory.createTitledBorder("Your ingredients:"));
		
		//Buttons to enter and exit
		JPanel entexit = new JPanel();
		entexit.add(cookNow);
		entexit.add(reset);
		entexit.setBorder(BorderFactory.createTitledBorder("Some options which may prove helpful:"));
		
		this.setLayout(new BorderLayout());
		this.add(visual, BorderLayout.WEST);
		this.add(communication, BorderLayout.NORTH);
		this.add(ingredients, BorderLayout.EAST);
		this.add(entexit, BorderLayout.SOUTH);
		
	}
	
	
	
	
}
