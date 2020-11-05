package com.gitlab.weefee.ProCooker;

import javax.swing.*;
import java.awt.event.*;

public class Controller implements ActionListener {
	
	private CookingGame game;
	//private CookingGUI cookGui;
	
	private JButton[] buttons;
	private JButton reset;
	private JButton finishCooking;
	
	public Controller(CookingGame game, JButton[] buttons, JButton reset, JButton finishCooking) {
		this.game = game;
		//this.cookGui = cookGui;
		this.buttons = buttons;
		this.reset = reset;
		this.finishCooking = finishCooking;
		
		
		//adds actionlisteners to the ingredient buttons
		CookingGUI.ingredientList[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Cherries");
			}
		});
		
		CookingGUI.ingredientList[1].addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Tomatoes");
			}
		});
		
		
		CookingGUI.ingredientList[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Oranges");
			}
		});
		
		
		CookingGUI.ingredientList[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Apples");
			}
		});
		
		
		CookingGUI.ingredientList[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Lemons");
			}
		});
		
		
		CookingGUI.ingredientList[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Sour Cream");
			}
		});
		
		
		CookingGUI.ingredientList[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Wine");
			}
		});
		
		
		CookingGUI.ingredientList[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Pickles");
			}
		});
		
		
		CookingGUI.ingredientList[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Steak");
			}
		});
		
		
		CookingGUI.ingredientList[9].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Chicken");
			}
		});
		
		
		CookingGUI.ingredientList[10].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Fish");
			}
		});
		
		
		CookingGUI.ingredientList[11].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Crab");
			}
		});
		
		
		CookingGUI.ingredientList[12].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Rice");
			}
		});
		
		
		CookingGUI.ingredientList[13].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Noodles");
			}
		});
		
		
		CookingGUI.ingredientList[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Bread");
			}
		});
		
		
		CookingGUI.ingredientList[15].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Tofu");
			}
		});
		
		
		CookingGUI.ingredientList[16].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Grapefruit");
			}
		});



	}

	public void actionPerformed(ActionEvent e) {
		
		//try {
			
		//}
		
	}

}
