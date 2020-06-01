/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.*;
import java.util.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.swing.*;

/**
 *
 * @author mahmoud
 */
public class  Bouncingballs2 extends  Application{
    
    
    public void start(Stage primaryStage) {
        //group shape
        Pane root = new Pane();
        //set dimention of the scence , title  and color background 
        Scene scene = new Scene(root, 600,600);
        scene.setFill(Color.OLDLACE);
        primaryStage.setTitle("Bouncing Balls");
        primaryStage.setScene(scene);
        primaryStage.show();
        Random rand =new Random();
        for(int i =0 ; i<10 ; i++){
            // make random raduis in every loop
           int  r = 3+rand.nextInt(30);
           double x = rand.nextInt(600);
           double y = rand.nextInt(600);
           //making random color for circles
           int red=rand.nextInt(255);
           int green = rand.nextInt(255);
           int blue = rand.nextInt(255);
           Color c = Color.rgb(red,green,blue);
           //solving the error number one 
           if (x-r<0)  x= x+r;
           if (x+r>600) x= x-r;
           if (y-r<0) y=y+r ;
           if (y+r>600) y=y - r;
           //draw the circle and get its place
           Circle circle = new Circle(r,c);
           circle.relocate(x, y);
           root.getChildren().add(circle); 
           final Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000),new EventHandler<ActionEvent>() {
            // putting random value of speed V_x , V_y
            double v_x = 1+ rand.nextInt(20);
            double v_y = 1+ rand.nextInt(20);
 
            public void handle(final ActionEvent t) {
            // changning the x,y of the ball every 1 s
            circle.setLayoutX(circle.getLayoutX() + v_x);
            circle.setLayoutY(circle.getLayoutY() + v_y);
            // make condtion that if it hit the wall of pane should rveerse 
            if (circle.getLayoutX()>(600-r) ||circle.getLayoutX()<r) {
                v_x*= -1; }
            if (circle.getLayoutY()>(600-r)||circle.getLayoutY() < r) {
                v_y *= -1 ;}
            }
            }));
            //make the balls run all the timeline at the same time
            loop.setCycleCount(Timeline.INDEFINITE);
            loop.play();}
    }
      
        
   
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
 