package com.gitlab.weefee.ProCooker;

import java.awt.*;
import javax.swing.*;

public class CookingGUI extends JPanel {
	
	//Instance Variables
	private CookingGame game;
	
	// dialogue of the game's events, judge speech, etc.
	private JTextField dialogue = new JTextField(75);
	
	// makes a JLabel. This JLabel contains an ImageIcon, but the ImageIcon also resizes the image in the same line which is why it's quite long
	private JLabel appBG = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/kitchensprites/appetizer.png")).getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT)));
	private JLabel entBG = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/kitchensprites/main.png")).getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT)));
	private JLabel desBG = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/kitchensprites/dessert.png")).getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT)));
	private JLabel pan = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/kitchensprites/pan.png")).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
	
	// makes JButtons to end cooking prematurely or reset the game instantly.
	public JButton cookNow = new JButton("END COOKING NOW (This Round)"); // button to end cooking earlier
	public JButton reset = new JButton("RESET GAME"); // button to immediately reset game
	
	// JButton array of every ingredient
	public JButton[] ingredientList = new JButton[17];
	
	public JPanel CookingGUI(CookingGame game) {
		//super();
		this.game = game;
		
		//Image section
		JPanel visual = new JPanel();
		visual.setLayout(new BorderLayout());
		visual.add(appBG, BorderLayout.CENTER);
		visual.add(pan, BorderLayout.SOUTH);
		visual.setBorder(BorderFactory.createTitledBorder("Display of Ingredients Used"));
		
		//adding to JButton array of every ingredient
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
		ingredientList[16] = new JButton("Grapefruit"); //used as a base for testing
		
		
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
		entexit.add(this.cookNow);
		entexit.add(this.reset);
		entexit.setBorder(BorderFactory.createTitledBorder("Some options which may prove helpful:"));

		JPanel frame = new JPanel();

		frame.setLayout(new BorderLayout());
		frame.add(visual, BorderLayout.WEST);
		frame.add(communication, BorderLayout.NORTH);
		frame.add(ingredients, BorderLayout.EAST);
		frame.add(entexit, BorderLayout.SOUTH);
		frame.setVisible(true);
		
		return frame;
	}
	
	public JPanel update() {
		JPanel frame = new JPanel();
		
		JLabel apples = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/apple.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel bread = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/bread.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel cherries = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/cherries.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel chicken = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/chicken.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel crab = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/crab.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel fish = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/fish.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel grapefruit = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/grapefruit.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel lemon = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/lemon.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel oranges = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/oranges.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel pasta = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/pasta.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel pickles = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/pickles.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel rice = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/rice.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel sourcream = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/sourcream.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel steak = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/steak.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel tofu = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/tofu.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel tomatoes = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/tomatoes.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel wine = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/foodsprites/wine.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		if(CookingGame.usedIngredients.contains("Apples")) {
			frame.add(apples);
		}
		
		if(CookingGame.usedIngredients.contains("Bread")) {
			frame.add(bread);
		}
		
		if(CookingGame.usedIngredients.contains("Cherries")) {
			frame.add(cherries);
		}
		
		if(CookingGame.usedIngredients.contains("Chicken")) {
			frame.add(chicken);
		}
		
		if(CookingGame.usedIngredients.contains("Crab")) {
			frame.add(crab);
		}
		
		if(CookingGame.usedIngredients.contains("Fish")) {
			frame.add(fish);
		}
		
		if(CookingGame.usedIngredients.contains("Grapefruit")) {
			frame.add(grapefruit);
		}
		
		if(CookingGame.usedIngredients.contains("Lemon")) {
			frame.add(lemon);
		}
		
		if(CookingGame.usedIngredients.contains("Oranges")) {
			frame.add(oranges);
		}
		
		if(CookingGame.usedIngredients.contains("Pasta")) {
			frame.add(pasta);
		}
		
		if(CookingGame.usedIngredients.contains("Pickles")) {
			frame.add(pickles);
		}
		
		if(CookingGame.usedIngredients.contains("Rice")) {
			frame.add(rice);
		}
		
		if(CookingGame.usedIngredients.contains("Sour Cream")) {
			frame.add(sourcream);
		}
		
		if(CookingGame.usedIngredients.contains("Steak")) {
			frame.add(steak);
		}
		
		if(CookingGame.usedIngredients.contains("Tofu")) {
			frame.add(tofu);
		}
		
		if(CookingGame.usedIngredients.contains("Tomatoes")) {
			frame.add(tomatoes);
		}
		
		if(CookingGame.usedIngredients.contains("Wine")) {
			frame.add(wine);
		}
		
		return frame;

	}

}
	

