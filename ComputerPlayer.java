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
        
        for (int i = 0; i < this.getNumCards(); i++) {
            if (cards[i].getColor().equals(c.getColor())) {
                if (cards[i].getValue() > highestValue) {
                    highestValue = i;
                }
            }
            
            if (cards[i].getValue() == c.getValue()) {
                return i;
            }
            
            if (cards[i].matches(c) == false) {
                noMatch++;
            }

        }
        
        if (noMatch == this.getNumCards()) {
            return -1;
        }
        
        return highestValue;
    }
 
}