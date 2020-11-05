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
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Cherries");
			}
		});
		
		buttons[1].addActionListener(e -> CookingGame.setIngredients("Tomatoes"));

		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Oranges");
			}
		});
		
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Apples");
			}
		});
		
		
		buttons[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Lemons");
			}
		});
		
		
		buttons[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Sour Cream");
			}
		});
		
		
		buttons[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Wine");
			}
		});
		
		
		buttons[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Pickles");
			}
		});
		
		
		buttons[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Steak");
			}
		});
		
		
		buttons[9].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Chicken");
			}
		});
		
		
		buttons[10].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Fish");
			}
		});
		
		
		buttons[11].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Crab");
			}
		});
		
		
		buttons[12].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Rice");
			}
		});
		
		
		buttons[13].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Noodles");
			}
		});
		
		
		buttons[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Bread");
			}
		});
		
		
		buttons[15].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Tofu");
			}
		});
		
		
		buttons[16].addActionListener(new ActionListener() {
			
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
