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
        
        
        //Screen Next
        pHand = new Group();
        buttons = new Group();
        Button btn_Next = new Button();
        buttons.getChildren().add(btn_Next);
        btn_Next.relocate(25,470);
        btn_Next.setText("Hit");
        btn_Next.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                controller.sendMsg("Hit",me);
            }
        });
    }
    
    public void updatePHand(Group hand){
        pHand = hand;
        pHand.relocate(50,280);
        show_Game();
        
    }
    
    
    public void show_Game(){
        getChildren().clear();
        getChildren().add(pHand);
        getChildren().add(buttons);
        requestLayout();
      
    }

}
