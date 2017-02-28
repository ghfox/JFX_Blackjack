import java.util.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class Hand{
    private ArrayList<Card> cards;
    private int aces;
    private boolean cover;
    
    public Hand(){
        this.cards = new ArrayList<Card>();
        aces = 0;
        this.cover = false;
    }
    
    public int addCard(Card newCard){
        cards.add(newCard);
        if(newCard.getVal()==1)
            aces++;
        System.out.println("Hand at :: " + count());
        return cards.size();    
    }
    
    public Card getCard(int card){
        try{
            return cards.get(card);
            }catch(Exception e) {
            System.out.println("Oh No!!!!");
            }
        return new Card(Suit.CLUB,' ');
    }
    
    public int count(){
        int curCount = 0;
        for(int i = 0; i < cards.size(); i++)
            curCount += cards.get(i).getVal();
        if(aces > 0 && curCount < 12)
            curCount += 10;
        return curCount;
    }
    
    public void setCover(boolean tf){
        cover = tf;
    }
    
    public Group makeHand()
    {
        int x = 40;
        int y = 30;
        Group g = new Group();
        for(int i = 0; i < cards.size(); i++){
            System.out.println("Trying to draw " + cards.get(i).toString()); 
            Group card = new Group(cards.get(i).makeCard());
            card.relocate(x,y);
            g.getChildren().add(card);
            
            if(cover && i == 0){
                Rectangle r = new Rectangle();
                r.setWidth(75);
                r.setHeight(150);
                r.setFill(Color.GREY);
                r.relocate(x,y);
                g.getChildren().add(r);
            }
            x += 80;
        }
        return g;
    }
}
