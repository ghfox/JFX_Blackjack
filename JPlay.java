/*
 * JPlay.java
 * 
 * 
 */

import java.util.*;
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;

public class JPlay extends Application { 
       
    private Controller controller;
    
    public static void main (String []  args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        controller = new Controller();
        primaryStage.setTitle("Cards");
        Scene sceneDeal = new Scene(new DealStage(controller),500,500);
        primaryStage.setScene(sceneDeal);
        primaryStage.show();
    }    
}





