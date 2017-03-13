package blackjack;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Deck{
    
    private ArrayList<Card> deck;
    
    public Deck(){
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        deck = new ArrayList<Card>();
        for(int i = 1; i<= 13; i++)
            createBlock(i);
        
        while(deck.size() > 0)
            tempDeck.add(deck.remove(ThreadLocalRandom.current().nextInt(0, deck.size())));
        while(tempDeck.size() > 0)
            deck.add(tempDeck.remove(ThreadLocalRandom.current().nextInt(0, tempDeck.size())));
    }
    
    public Card draw(){
        return deck.remove(0);
    }
    
    private void createBlock(int val)
    {
        deck.add(new Card(Suit.CLUB,val));
        deck.add(new Card(Suit.DIAM,val));
        deck.add(new Card(Suit.HEART,val));
        deck.add(new Card(Suit.SPADE,val));
    }
}
