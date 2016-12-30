/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpman;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
/**
 *
 * @author ezhou
 */



public class JumpMan extends Application {
    Stage window;
    Scene scene1, scene2;
    //scene 2 will be the game scene


    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        //button to enter the game by going to the next scene
        Button button1 = new Button();
        button1.setText("Enter New Game");
        Label label1 = new Label("Welcome to the Jump man! ");
        button1.setOnAction(e -> window.setScene(scene2));
        
        //layout laid out vertical
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);
        
        
        //Button2 to exit the game back to main menu 
        Button button2 = new Button("Give up!");
        button2.setOnAction(e -> window.setScene(scene1));
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);
        
        
    
       window.setTitle("Game");
        window.setScene(scene1);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
