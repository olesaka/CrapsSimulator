import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
/**
 * Craps simulator for a user to play.
 * 
 * @author Andrew Olesak
 * @version October 21, 2015
 */
public class Craps
{
    private GVDie die1;
    private GVDie die2;
    private int currentPoint;
    private int creditBalance;
    private String currentMessage;
    private boolean comeOut;

    /**
     * Constructor sets values to the privates of the class
     */
    public Craps(){
        this.die1 = new GVDie();
        this.die2 = new GVDie();
        this.currentPoint = -1;
        this.creditBalance = 10;
        this.currentMessage = "Welcome to Andy's Game of Craps!";
        this.comeOut = true;
    }

    /**
     * Returns the number of credits.
     */
    public int getCredits(){
        return this.creditBalance;
    }

    /**
     * Returns the current point.
     */
    public int getPoint(){
        return this.currentPoint;
    }

    /**
     * Returns the current message during the game.
     */
    public String getMessage(){
        return this.currentMessage;
    }

    /**
     * Returns the appropriate die.
     * 
     * @param num the number of the die that should be returned
     * @return this.die1 the first die
     * @return this.die2 the second die
     */
    public GVDie getDie(int num){
        if(num == 1){
            return this.die1;
        }else if(num == 2){
            return this.die2;
        } else{
            return null;
        }
    }

    /**
     * Rolls the dice
     * Responds to the outcome of the two dice for coming out.
     */
    public void comeOut(){
        if((!okToRoll()) && (this.creditBalance > 0)){
            this.die1.roll();
            this.die2.roll();
            int d1 = this.die1.getValue();
            int d2 = this.die2.getValue();
            int roll = d1 + d2;
            if((roll == 7)  || (roll == 11)){
                this.creditBalance++;
                this.comeOut = true;
                this.currentMessage = "You rolled " + roll + " and Win!";
            } else if((roll == 2) || ( roll == 3) || ( roll == 12)){
                this.creditBalance--;
                this.comeOut = true;
                this.currentMessage = "You rolled " + roll + " and Lose!";
            } else{
                this.currentPoint = roll;
                this.comeOut = false;
                this.currentMessage = "The point has been set to " + this.currentPoint + 
                ". Please Roll.";
            }
        } else if((!okToRoll()) && (this.creditBalance == 0)){
            this.currentMessage = "Game Over!";
        } else{
            this.currentMessage = "You need to roll!";
        }
    }

    /**
     * Rolls the dice. 
     * Responds to the outcome of the two dice for rolling.
     */
    public void roll(){
        if(okToRoll()){
            this.die1.roll();
            this.die2.roll();
            int d1 = this.die1.getValue();
            int d2 = this.die2.getValue();
            int roll = d1 + d2;
            if(roll == 7){
                this.creditBalance--;
                this.currentPoint = -1;
                this.comeOut = true;
                this.currentMessage = "You rolled " + roll + " and Lose!";
            } else if(roll == this.currentPoint){
                this.creditBalance++;
                this.comeOut = true;
                this.currentMessage = "You rolled " + roll + " and Win!";
                this.currentPoint = -1;
            } else{
                this.comeOut = false;
                this.currentMessage = "You rolled " + roll + " and your point is " +
                this.currentPoint + ". Roll Again.";
            }
        } else{
            this.currentMessage = "You need to come out!";
        }
    }

    /**
     * Decides whether it is time to come out or roll.
     */
    public boolean okToRoll(){
        if(this.comeOut){
            return false;
        } else{
            return true;
        }
    }

    /**
     * Sets the credit balance to amount.
     * 
     * @param amount the number of credits
     */
    public void setCredits(int amount){
        if(amount >= 0){
            this.creditBalance = amount;
        }
    }
}