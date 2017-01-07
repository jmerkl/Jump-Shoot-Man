/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    import java.io.FileInputStream;
	import javafx.scene.media.Media;
    import javafx.scene.media.MediaPlayer;

/**
 *
 * @author ezhou
 */
public class startScreen extends Application {
    //Boolean visible = false;
        
    BorderPane homeWindow = new BorderPane();
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
        Text gameTitle = new Text("Jump Over the Wall");
        
        Button menuButton = new Button("Menu");
        menuButton.setPrefSize(100, 40);
        
    //Sets up the buttons to the pane    
        
        gameWindow.setCenter(gameTitle);
        gameWindow.setRight(menuButton);
        
    //Window is takes in the gameWindow Pane    
    //intial gamewindow is not visible
       gameWindow.setVisible(false);

        
       
        
        
     
        
        
        BorderPane homeWindow = new BorderPane();
        Label Score = new Label("High Score: 9999999");
        Label devLabel = new Label("By: Jackson Merkl & Eddie Zhou");
        
        Button optionsButton = new Button("options");
        optionsButton.setPrefSize(80, 40);


        Button buttonEnter= new Button("Enter Game: ");
        buttonEnter.setPrefSize(80, 40);
        
        Label placeHolder = new Label("Place holder for actual game");
        placeHolder.setVisible(false);
        
        VBox box1 = new VBox(40);
        box1.getChildren().addAll(buttonEnter, Score, optionsButton,devLabel);
        box1.setAlignment(Pos.CENTER);
        homeWindow.setCenter(box1);
        homeWindow.setStyle("-fx-background-color: #FFFAF0;");
    
       
        placeHolder.setAlignment(Pos.CENTER);
        
        gameWindow.setBottom(placeHolder);

        
        //The box for the options in the option (Alert window)
        VBox optBox = new VBox(20);
        


        
        

    
        
       
    //pane -> scene -> Stage
       BorderPane Root = new BorderPane();
       //Root.setCenter(placeHolder);
       Root.setBottom(placeHolder);
       Root.setTop(gameWindow);
       Root.setCenter(homeWindow);

       buttonEnter.setOnAction(e -> {
                
                homeWindow.setVisible(false);
                
                gameWindow.setVisible(true);
                placeHolder.setVisible(true);
                Root.setCenter(placeHolder);

        });
       optionsButton.setOnAction(e -> {
        optionMenu.display("Title of Windowsettings","settings ");

       });

       Scene scene = new Scene(Root,800,500);
      
        
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    
    }
    
 }

