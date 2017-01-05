/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpman2;

import java.io.FileInputStream;
	import javafx.application.Application;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.image.*;
	import javafx.scene.paint.Color;
	import javafx.scene.paint.CycleMethod;
	import javafx.scene.paint.LinearGradient;
	import javafx.scene.paint.Stop;
	import javafx.scene.shape.Rectangle;
	import javafx.scene.text.Font;
	import javafx.scene.text.FontWeight;
	import javafx.scene.text.Text;
	import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.control.*;
	import javafx.stage.*;
	import javafx.scene.*;
	import javafx.scene.layout.*;
	import javafx.scene.control.*;
	import javafx.geometry.*;
	import javafx.scene.shape.*;
	import javafx.scene.effect.*;
	import javafx.scene.paint.*;
	import javafx.scene.text.*;
        import sun.audio.*;
        import javafx.scene.media.*;
/**
 *
 * @author ezhou
 */
public class JumpMan2 extends Application {
    Boolean visible = false;
    BorderPane window = new BorderPane();
     BorderPane homeWindow = new BorderPane();
     MediaPlayer mediaPlayer;
     
    public static void main(String[] args) {
        
        launch(args);
         
    }
    
     
     
    @Override
    public void start(Stage primaryStage) {
        Stage stage = primaryStage;
        
        
    
   
    
    //Top portion of the game screen
        
    //game Window is pane for the game 
    //cre
        BorderPane gameWindow = new BorderPane();
        Text gameTitle = new Text("JumpMan 2.0");
        
        Button menuButton = new Button("Menu");
        menuButton.setPrefSize(100, 40);
        
    //Sets up the buttons to the pane    
        
        gameWindow.setCenter(gameTitle);
        gameWindow.setRight(menuButton);
        
    //Window is takes in the gameWindow Pane    
    //intial gamewindow is not visible
       gameWindow.setVisible(visible);
        
       
        
        
     
        
    //    
        BorderPane homeWindow = new BorderPane();
        Label Score = new Label("High Score: 9999999");
        
        
        //homebox is set for the homescreen 
        Button buttonEnter= new Button("Enter Game: ");
        buttonEnter.setPrefSize(100, 40);
        VBox homebox = new VBox(30);
        buttonEnter.setOnAction(e -> {
                visible = true;  
                homebox.setVisible(!visible);
                gameWindow.setVisible(visible);
        });
        Label devLabel = new Label("Developed By: Jackson Merkel and Eddie Zhou");
        
      
        homebox.setAlignment(Pos.CENTER);
        homebox.getChildren().addAll(buttonEnter,Score,devLabel);
       
        
        

//pane -> scene -> Stage
       BorderPane RootPane = new BorderPane();
       //RootPane.getChildren().addAll(gameWindow, homeWindow);
        
       
        RootPane.setCenter(homebox);
        RootPane.setTop(gameWindow);
       
        Scene scene = new Scene(RootPane,800,500);
        
      
        
        Media musicFile = new Media("file:///C:/Users/Eddie/Documents/GitHub/Jump-Shoot-Man/mozart.mp3"); 
        mediaPlayer = new MediaPlayer(musicFile);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0);
//        String mozart = "mozart.mp3";
//        Media hit = new Media(mozart);
//        MediaPlayer media = new MediaPlayer(hit);
//        media.play();



       
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }
   
      
 

}