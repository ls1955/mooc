/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */

import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        for(Card card : this.cards) {
            System.out.println(card);
        }
    }
    
    public void sort() {
        Collections.sort(this.cards, (card1, card2) -> card1.compareTo(card2));
    }
    
    public int cardValues() {
        int total = 0;
        for(Card card : this.cards) {
            total += card.getValue();
        }
        
        return total;
    }

    public int compareTo(Hand hand) {
        return this.cardValues() - hand.cardValues();
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
}
