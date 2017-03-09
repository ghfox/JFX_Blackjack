
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class Card {
     
     int val;
     Suit suit;
     String face;
    
    public Card(Suit newSuit, int newVal){
        this.suit = newSuit;
        if(newVal <= 10){
            if(newVal == 1)
                this.face = "A";
            else
                face = ("" + newVal);
            this.val = newVal;
        }
        else
        {
            this.val = 10;
            switch(newVal){
                case 11:
                    this.face = "J";
                    break;
                case 12:
                    this.face = "Q";
                    break;
                case 13:
                    this.face = "K";
                    break;
            }
        }
    }
    
    public int getVal(){
        return val;
    }
    
    public String getFace(){
        return face;
    }
    
    public Character getSuit(){
        return suit.getChar();
    } 
       
    public String toString(){
        return face + getSuit();
    }   
    
    public String getSuitImg(){
        return suit.getImage();
    }
    
    public Group makeCard(){
        Group g = new Group();
        Rectangle r = new Rectangle();
        r.setWidth(75);
        r.setHeight(150);
        r.setFill(Color.GREY);
        g.getChildren().add(r);
        g.getChildren().add(new Text(15,20,face));
        g.getChildren().add(new Text(50,130,face));
        g.getChildren().add(new Text(25,45,getSuitImg()));
        return g;
    }
}
