/*
 * Player.java
 * 
 * Calvin Yung (cyung20@bu.edu)
 * 12/07/2013
 * 
 * This method changes a person's hand based on how he or she plays.
 * 
 */

import java.util.*;

public class Player {
    private String name;
    private Card[] cards;
    private int cardCount;

    /*
     * This constructor takes a single parameter for the name of the 
     * player. It initializes all of the fields and it creates the array 
     * that will store the cards.
     */
    public Player(String iName) {
        this.name = iName;
        this.cardCount = 0;
        this.cards = new Card[BUno.MAX_CARDS];        
    }
    
    /*
     * getName returns the player's name.
     */
    public String getName() {
        return this.name;
    }
    
    /*
     * getNumCards reutnrs the current number of cards in the player's hand.
     */
    public int getNumCards() {
        return this.cardCount;
    }
    
    /*
     * toString returnsthe player's name
     */
    public String toString() {
        return this.name;
    }
    
    /*
     * addCardToHand takes a reference to a Card object as a parameter and adds
     * the specified card to the player's hand. Throws an IllegalState Exception
     * if the player's hand already has the manimum number of cards.
     */
    public void addCardToHand(Card c) {
        if (this.cardCount == BUno.MAX_CARDS) {
            throw new IllegalStateException();
        }
        
        this.cards[this.cardCount] = c;
        this.cardCount++;
    }
    
    /*
     * getCardFromHand takes an integer index as a parameter and returns the Card at the
     * specified position in the player's hand without removing the card from the hand.
     */
    public Card getCardFromHand(int index) {
        if (index < 0 || index > this.cardCount) {
            throw new IndexOutOfBoundsException();
        }
        
        return this.cards[index];
    }
    
    /*
     * printHands prints the current contents of the player's hand, preceded by a heading that
     * includes the player's name. Each card will be printed on a separate line, preceded by 
     * the index of its position in the hand
     */
    public void printHand() {
        System.out.println(this.name + "'s hand:");
        for (int i = 0; i < this.cardCount; i++) {
            System.out.println("  " + i + ": " + this.cards[i].getColor() + " " + this.cards[i].getValue());
        }
    }
    
    /*
     * getHandValue computes and returns the total value of the player's current hand.
     */
    public int getHandValue() {
        int sum = 0;
        for (int i = 0; i < this.cardCount; i++) {
            sum += this.cards[i].getValue();
        }
        
        if (this.cardCount == BUno.MAX_CARDS) {
            return sum + BUno.MAX_CARDS_PENALTY;
        }
        
        return sum;
    }
            
    /*
     * removeCardFromHand takes an integer index as a parameter and both removes and returns the
     * Card at that position of the player's hand.
     */
    public Card removeCardFromHand(int index) {
        if (index < 0 || index > this.cardCount) {
            throw new IndexOutOfBoundsException();
        }
        
        Card removed = this.cards[index];
        
        this.cards[index] = this.cards[this.cardCount - 1];
        this.cards[this.cardCount - 1] = null;
        this.cardCount--;
        
        return removed;
    }
    
    /*
     * getPlay takes two paramters: a Scanner object and a Card opbject representing the card that is 
     * currently at the top of the discard pile. This method determines and returns the number corresponding 
     * to the player's next play: either -1 if the players wants to draw a card, or the number/index of one 
     * of the card that the players wants to discard from his/her hand.
     */
    public int getPlay(Scanner console, Card c) {
        System.out.print(this.name + ": number of card to play (-1 to draw)?");
        int index = console.nextInt();
        while (index != -1 && (index > this.cardCount || index < -1)) {
            console.nextLine();
            System.out.print("Number entered is not valid. Try again: ");
        }
        
        return index;
    }

}