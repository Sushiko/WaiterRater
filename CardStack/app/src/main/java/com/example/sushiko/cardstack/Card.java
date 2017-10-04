package com.example.sushiko.cardstack;

/**
 * Created by Sushiko on 10/2/17.
 */

public class Card {
    int number;
    Suits suit;

    public Card(){
        this.number = 0;
        this.suit = null;
    }

    public Card(int number, Suits mySuit){
        this.number = number;
        this.suit = mySuit;
    }

    public void setNumber(int x){
        this.number = x;
    }
    public int getNumber(){
        return number;
    }
    public void setSuit(Suits x){
        this.suit = x;
    }
    public Suits getSuit(){
        return suit;
    }
}
