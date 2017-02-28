import java.util.*;
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;

public class DealStage extends Pane
{
    private Controller controller;
    private ArrayList<Node> Screen_K;
    private Group buttons;
    private Group pHand;
    private Group dHand;
    private DealStage me;
    
    public DealStage(Controller controller){
        super();
        this.controller = controller;
        me = this;
        Screen_K = new ArrayList<Node>();
        
        //Screen K
        Button btn_K = new Button();
        Screen_K.add(btn_K);
        btn_K.relocate(175,220);
        btn_K.setText("Start");
        getChildren().add(btn_K);
        btn_K.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                controller.sendMsg("Start",me);
            }
        });
        
        
        //Screen Game
        pHand = new Group();
        buttons = new Group();
        dHand = new Group();
        
        //Hit
        Button btn_Hit = new Button();
        buttons.getChildren().add(btn_Hit);
        btn_Hit.relocate(25,470);
        btn_Hit.setText("Hit");
        btn_Hit.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                controller.sendMsg("Hit",me);
            }
        });
        
        //Stand
        Button btn_Stand = new Button();
        buttons.getChildren().add(btn_Stand);
        btn_Stand.relocate(60,470);
        btn_Stand.setText("Stand");
        btn_Stand.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                controller.sendMsg("Stand",me);
            }
        });
        
        //Double
        Button btn_Dbl = new Button();
        buttons.getChildren().add(btn_Dbl);
        btn_Dbl.relocate(110,470);
        btn_Dbl.setText("Dbl Down");
        btn_Dbl.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                controller.sendMsg("DblD",me);
            }
        });
    }
    
    public void updatePHand(Group hand){
        pHand = hand;
        pHand.relocate(50,280);
    }
    
    public void updateDHand(Group hand){
        dHand = hand;
        dHand.relocate(50,50);
    }
    
    
    public void show_Game(){
        getChildren().clear();
        getChildren().add(pHand);
        getChildren().add(dHand);
        getChildren().add(buttons);
        requestLayout();    
    }

}
