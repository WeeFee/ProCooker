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
	}

	public void actionPerformed(ActionEvent e) {
		
		//try {
			
		//}
		
	}

}
