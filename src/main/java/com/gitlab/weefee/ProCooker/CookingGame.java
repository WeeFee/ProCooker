package com.gitlab.weefee.ProCooker;

import java.util.Arrays;

public class CookingGame extends Object {
    private String gameState = "starting";

    private int timeRemaining = this.totalTime;
    private final int totalTime = 120;

    private int playerCookingScore = 0;
    private int[] score = new int[2];

    private boolean[][] dishesJudged = new boolean[2][3];

    private String[][] usedIngredients = new String[2][5];

    public void setGUI(cookingGUI currentGUI) {
        Main.mainWindow.getContentPane().removeAll();
        Main.mainWindow.add(currentGUI);
        Main.mainWindow.repaint();
    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    public boolean isTimeOver() {
        if (timeRemaining == 0) {
            gameState = "judging";
            return true;
        } else {
            return false;
        }
    }

    public String[] getIngredients() {
        return usedIngredients[0];
    }

    public int calculateScore() {
        return (totalTime - (totalTime - timeRemaining)) * playerCookingScore;
    }

    public String getWinner() {
        if (score[0] > score[1]) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    public boolean endGame() {
        boolean fullyJudged = true;
        for(boolean[] players: dishesJudged) {
            for (boolean judged: players) {
                if (!judged) {
                    fullyJudged = false;
                    break;
                }
            }
        }
        return fullyJudged;
    }

    public void resetValues() {
        gameState = "starting";
        timeRemaining = this.totalTime;
        playerCookingScore = 0;
        for (boolean[] booleans : dishesJudged) {
            Arrays.fill(booleans, false);
        }
        for (String[] strings : usedIngredients) {
            Arrays.fill(strings, "");
        }
    }
}
