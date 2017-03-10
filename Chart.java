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
    int hands;
    private ArrayList<Double> record, pastRecord;
    
    public Chart(double startVal){
        max = startVal + 1;
        min = startVal - 1;
        avg = startVal;
        total = 0;
        hands = 0;
        record = new ArrayList<Double>();
        pastRecord = new ArrayList<Double>();
        record.add(startVal);
    }
    
    public void add(double newVal){
        hands++;
        record.add(newVal);
        max = newVal > max ? newVal : max;
        min = newVal < min ? newVal : min;
        total += newVal;
        avg = total / hands;
        if(record.size() >= 10)
            condenseStats();
    }
    
    public double range(){
        return Math.floor(Math.abs(max - min));
    }
    
    public void condenseStats(){
        Double cTotal = 0.0, cAvg = 0.0;
        for(int i = 0; i < record.size(); i++)
            cTotal += record.get(i);
        cTotal = cTotal/record.size();
        pastRecord.add(cTotal);
        if(pastRecord.size() > 10)
            pastRecord.remove(0);
        record.clear();
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
        if(pastRecord.size() > 0)
            for(int i = 0; i < pastRecord.size(); i++)
                gc.fillOval( 10 + (10* i), HEIGHT - (int)((pastRecord.get(i) - min ) / range() * HEIGHT) - 6, 6, 6);
        double avgY = HEIGHT - (int)((avg - min ) / range() * HEIGHT);
        gc.setStroke(Color.BLUE);
        gc.strokeLine(0, avgY, WIDTH, avgY);
        
        g.getChildren().add(can);
        Text maxT = new Text(0,0,"" + max);
        Text minT = new Text(0,HEIGHT+12,"" + min);
        Text avgT = new Text(-20,HEIGHT/2+6,"" + (int)avg);
        g.getChildren().add(minT);
        g.getChildren().add(avgT);
        g.getChildren().add(maxT);
        return g;
    }
        



}
