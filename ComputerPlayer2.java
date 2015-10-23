/*
 * ComputerPlayer.java
 * 
 * Calvin Yung (cyung20@bu.edu)
 * 12/07/2013
 * 
 * This method serves as a blueprint for objects that represent a computer player.
 * 
 */

import java.util.*;

public class ComputerPlayer extends Player {
    
    /*
     * This constructor takes the name of the player as a parameter and calls the
     * constructor of the superclass to do the actual work of initializing the
     * inherited fields.
     */
    public ComputerPlayer(String name) {
        super(name);
    }
    
    /*
     * printHand overrides the inherited version of that method.
     */
    public void printHand() {
        String cards = "";
        if (this.getNumCards() == 1) {
            cards = "card";
        } else {
            cards = "cards";
        }
        
        System.out.println(this.getName() + "'s hand: ");
        System.out.println("  " + this.getNumCards() + " " + cards);
    }
    
    /*
     * getPlay overrides the inherited version of that method. This version figures out if
     * the computer has a card that matches the card at the top of the discard pile.
     * If the computer doesn't have a matching card, the method returns -1 so the computer
     * will draw a card.
     */
    public int getPlay(Scanner console, Card c) {   //c represents the card on the top of the discard pile
        Card[] cards = new Card[BUno.MAX_CARDS];
        for (int i = 0; i < this.getNumCards(); i++) {
            cards[i] = this.getCardFromHand(i);
        }
        
        int highestValue = 0;
        int noMatch = 0;
        int[] colorArr = new int[4];
        int color = 0;
        String colorName = "";
        for (int i = 0; i < this.getNumCards(); i++) {
            if (cards[i].getColor().equals(c.getColor())) {
                if (cards[i].getValue() >= highestValue) {
                    highestValue = i;
                }
            }
            
            if (cards[i].getValue() == c.getValue()) {
                if (cards[i].getColor().equalsIgnoreCase("Blue")) {
                    colorArr[0]++;
                }
                if (cards[i].getColor().equalsIgnoreCase("Red")) {
                    colorArr[1]++;
                }
                if (cards[i].getColor().equalsIgnoreCase("Green")) {
                    colorArr[2]++;
                }
                if (cards[i].getColor().equalsIgnoreCase("Yellow")) {
                    colorArr[3]++;
                }
                
                for (int j = 0; j < 4; j++) {
                    for (int k = j + 1; k < 4; k++) {
                        if (colorArr[j] > colorArr[k]) {
                            color = j;
                            if (color == 0) {
                                colorName = "Blue";
                            }
                            if (color == 1) {
                                colorName = "Red";
                            }
                            if (color == 2) {
                                colorName = "Green";
                            }
                            if (color == 3) {
                                colorName = "Yellow";
                            }
                        }
                    }
                }
                                  
            }
            
            if (cards[i].matches(c) == false) {
                noMatch++;
            }

        }
        
        for (int i = 0; i < this.getNumCards(); i++) {
            if (cards[i].getValue() == c.getValue() && cards[i].getColor().equals(color)) {
                return i;
            }
        }
        
        if (noMatch == this.getNumCards()) {
            return -1;
        }
        
        return highestValue;
    }
    
}