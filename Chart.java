import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Chart{
    
    final int HEIGHT = 50;
    final int WIDTH = 110;
    double max;
    double min;
    double avg;
    double total;
    private ArrayList<Double> record;
    
    public Chart(double startVal){
        max = startVal + 1;
        min = startVal - 1;
        avg = startVal;
        total = startVal;
        record = new ArrayList<Double>();
        record.add(startVal);
    }
    
    public void add(double newVal){
        record.add(newVal);
        max = newVal > max ? newVal : max;
        min = newVal < min ? newVal : min;
        total += newVal;
        avg = total / record.size();
    }
    
    public double range(){
        return Math.floor(Math.abs(max - min));
    }

    public Group makeChart(){
        
        Group g = new Group();
        Canvas can = new Canvas(200,200);
        GraphicsContext gc = can.getGraphicsContext2D();
        
        Rectangle r = new Rectangle();
        r.setWidth(WIDTH);
        r.setHeight(HEIGHT);
        r.setFill(Color.GREY);
        g.getChildren().add(r);
        
        gc.setFill(Color.RED);
        //gc.fillOval(0, (((record.get(record.size()-1)- min)/range())*HEIGHT - 6), 6, 6);
        //Circle c = new Circle(0,HEIGHT - ( (record.get(0)/range())*HEIGHT ) , 6,Color.RED);
        //g.getChildren().add(c);
        
        
        
        if(record.size() > 10)
            for(int i = 0; i < 10; i++)
            {
                int iter = ((int)(record.size()/10));
                if(iter * 10 > record.size())
                    iter--;
                System.out.println("I = " + i + " :: " + record.get(i*iter));
                gc.fillOval( 10 + (10* i), HEIGHT - (int)((record.get(i * iter) - min ) / range() * HEIGHT) - 6, 6, 6);
            }
       
        
        g.getChildren().add(can);
        Text maxT = new Text(0,0,"" + max);
        Text minT = new Text(0,HEIGHT+12,"" + min);
        g.getChildren().add(minT);
        g.getChildren().add(maxT);
        //
        
        //for
        
        return g;
    }
        



}
