/*
 * Card.java
 * 
 * Calvin Yung (cyung20@bu.edu)
 * 12/07/2013
 * 
 * This program keeps track of the colors and values of each of the Player's cards
 * 
 */

public class Card {
    private String color;
    private int value;
    
    /*
     * Constructor that takes two parameters, a string for the card's color and
     * an integer for the card's value, and checks if the inputted value is valid.
     */
    public Card(String iColor, int iValue) {
        if (iValue < 0 || iValue > 9) {
            throw new IllegalArgumentException();
        }
        
        this.color = iColor;
        this.value = iValue;
    }
    
    /*
     * getColor returns the card's color.
     */
    public String getColor() {
        return this.color;
    }
        
    /*
     * getValue returns the card's value.
     */
    public int getValue() {
        return this.value;
    }
    
    /*
     * matches takes another Card object as a parameter and returns true if the
     * current Card object matches the color and/or value of the other Card object.
     */
    public boolean matches(Card c) {
        return (c.value == this.value || 
              c.color.equals(this.color));  
    }
        
    /*
     * toString reutns a string representation of the card in the form of
     * "color value"
     */
    public String toString() {
        return this.color + " " + this.value;
    }

    
}