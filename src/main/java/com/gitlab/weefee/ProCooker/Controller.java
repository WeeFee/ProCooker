package com.gitlab.weefee.ProCooker;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Random;

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
				if (CookingGame.usedIngredients.size() < 3) {
					System.out.println("tes");
					return;
				}
				// Total dishes cooked in career
				PlayerData.editSaveData(3, String.valueOf(Integer.parseInt(PlayerData.getSaveData(3)) + 1));
				Main.currentRound += 1;
				if (Main.currentRound == 4) {
					int playerScore = new Random().nextInt(20) + 80;
					int computerScore = new Random().nextInt(100);

					String winner = "COMPUTER";

					if (playerScore > computerScore) {
						winner = "PLAYER";
						// Total wins earned in career
						PlayerData.editSaveData(7, String.valueOf(Integer.parseInt(PlayerData.getSaveData(7)) + 1));
					}

					// Total games played in career
					PlayerData.editSaveData(4, String.valueOf(Integer.parseInt(PlayerData.getSaveData(4)) + 1));
					// Total points earned in career
					PlayerData.editSaveData(5, String.valueOf(Integer.parseInt(PlayerData.getSaveData(5)) + playerScore));
					// Total ingredients used
					PlayerData.editSaveData(6, String.valueOf(Integer.parseInt(PlayerData.getSaveData(6)) + CookingGame.usedIngredients.size()));

					// Save player data
					PlayerData.savePlayerData();

					StringBuilder finalFood = new StringBuilder();

					for (String food: CookingGame.usedIngredients) {
						finalFood.append(food);
						finalFood.append(" ");
					}

					FileWriter userWriter = null;
					try {
						userWriter = new FileWriter("./output.txt");
						userWriter.write(finalFood + "\nRESULTS:\nYOUR SCORE: "+playerScore+"\nCOMPUTER'S SCORE: "+computerScore+"\n"+winner+" WINS");
						userWriter.close();
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
					System.exit(0);
				}
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
