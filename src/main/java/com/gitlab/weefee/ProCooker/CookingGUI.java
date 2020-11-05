package com.gitlab.weefee.ProCooker;

import java.awt.*;
import javax.swing.*;

public class CookingGUI extends JPanel {
	
	//Instance Variables
	private CookingGame game;
	
	// dialogue of the game's events, judge speech, etc.
	private JTextField dialogue = new JTextField(75);
	
	// makes a JLabel. This JLabel contains an ImageIcon, but the ImageIcon also resizes the image in the same line which is why it's quite long
	private JLabel appBG = new JLabel(new ImageIcon(new ImageIcon("src/res/appetizer.png").getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT)));
	private JLabel entBG = new JLabel(new ImageIcon(new ImageIcon("src/res/entree.png").getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT)));
	private JLabel desBG = new JLabel(new ImageIcon(new ImageIcon("src/res/dessert.png").getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT)));
			
	/*frame.setLayout(new BorderLayout());
	frame.add(visual, BorderLayout.WEST);
	frame.add(communication, BorderLayout.NORTH);
	frame.add(ingredients, BorderLayout.EAST);
	frame.add(entexit, BorderLayout.SOUTH);
	frame.setSize(860, 540);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);*/
	
	public CookingGUI(CookingGame game) {
		super();
		this.game = game;
		this.game.setGUI(this);
		
		// JButton array of every ingredient
		JButton[] ingredientList = new JButton[16]; 
		ingredientList[0] = new JButton("Cherries");
		ingredientList[1] = new JButton("Tomatoes");
		ingredientList[2] = new JButton("Oranges");
		ingredientList[3] = new JButton("Apples");
		ingredientList[4] = new JButton("Lemons");
		ingredientList[5] = new JButton("Sour Cream");
		ingredientList[6] = new JButton("Wine");
		ingredientList[7] = new JButton("Pickles");
		ingredientList[8] = new JButton("Steak");
		ingredientList[9] = new JButton("Chicken");
		ingredientList[10] = new JButton("Fish");
		ingredientList[11] = new JButton("Crab");
		ingredientList[12] = new JButton("Rice");
		ingredientList[13] = new JButton("Noodles");
		ingredientList[14] = new JButton("Bread");
		ingredientList[15] = new JButton("Tofu");
		
		//Image section
		JPanel visual = new JPanel();
		visual.setLayout(new BorderLayout());
		visual.add(appBG, BorderLayout.CENTER);
		visual.setBorder(BorderFactory.createTitledBorder("The cook!"));
		
		// makes JButtons to end cooking prematurely or reset the game instantly.
		JButton cookNow = new JButton("END COOKING NOW (This Round)"); // button to end cooking earlier
		JButton reset = new JButton("RESET GAME"); // button to immediately reset game
		
		//Text Box section
		JPanel communication = new JPanel();
		communication.add(dialogue);
		communication.setBorder(BorderFactory.createTitledBorder("What's going on:"));
					
		//List of ingredients section, each creates its own section of 4 ingredients with a specific flavor
		//First 4
		JPanel ingredients1 = new JPanel();
					
		for(int i = 0; i < 4; i++) {
			ingredients1.add(ingredientList[i]);
		}
				
		ingredients1.setBorder(BorderFactory.createTitledBorder("Sweet"));
				
		//5-8
		JPanel ingredients2 = new JPanel();
		
		for(int i = 0; i < 4; i++) {
			ingredients2.add(ingredientList[i + 4]);
		}
				
		ingredients2.setBorder(BorderFactory.createTitledBorder("Sour"));
				
		//9-12
		JPanel ingredients3 = new JPanel();
					
		for(int i = 0; i < 4; i++) {
			ingredients3.add(ingredientList[i + 8]);
		}
				
		ingredients3.setBorder(BorderFactory.createTitledBorder("Meats"));
				
		//13-16
		JPanel ingredients4 = new JPanel();
				
		for(int i = 0; i < 4; i++) {
			ingredients4.add(ingredientList[i + 12]);
		}
				
		ingredients4.setBorder(BorderFactory.createTitledBorder("Starches"));
		
		//create JPanel for the ingredients using GridLayout, so they stack on top of each other.
		JPanel ingredients = new JPanel();
		ingredients.setLayout(new GridLayout(4, 0));
		ingredients.add(ingredients1);
		ingredients.add(ingredients2);
		ingredients.add(ingredients3);
		ingredients.add(ingredients4);

		ingredients.setBorder(BorderFactory.createTitledBorder("Your ingredients:"));
		
		//Buttons to enter and exit
		JPanel entexit = new JPanel();
		entexit.add(cookNow);
		entexit.add(reset);
		entexit.setBorder(BorderFactory.createTitledBorder("Some options which may prove helpful:"));
		
	}
	

}
	

