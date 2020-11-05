package com.gitlab.weefee.ProCooker;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;

/**
 * Controller management for ProCooker.
 */
public class Controller implements ActionListener {
	
	private CookingGame game;
	//private CookingGUI cookGui;
	
	private JButton[] buttons;
	private JButton reset;
	private JButton finishCooking;
	
	public Controller(CookingGame game, JButton[] buttons, JButton reset, JButton finishCooking, Clip sfx) {
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
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Tomatoes");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});

		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Oranges");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Apples");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Lemons");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Sour Cream");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Wine");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Pickles");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Steak");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[9].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Chicken");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[10].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Fish");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[11].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Crab");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[12].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Rice");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[13].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Noodles");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Bread");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[15].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Tofu");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		
		buttons[16].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CookingGame.setIngredients("Grapefruit");
				sfx.setFramePosition(0);
				sfx.start();
			}
		});
		
		//Dish submission
		buttons[17].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		buttons[18].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});



	}

	public void actionPerformed(ActionEvent e) {
		
		//try {
			
		//}
		
	}

}
