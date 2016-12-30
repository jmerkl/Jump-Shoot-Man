//Imports
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

	import java.util.*;
	import javafx.collections.FXCollections;
	import javafx.collections.ListChangeListener;
	import javafx.collections.ObservableList;

public class mainWindow extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {

		BorderPane window = new BorderPane();
		window.setPrefSize(600, 500);
		window.setStyle("-fx-background-color: #007FFF;");

		//Top Portion
			BorderPane titleBox = new BorderPane();

				Text titleLabel = new Text("Tic Tac Plus");
				titleLabel.setFont(new Font("Verdana", 40));
				titleLabel.setFont(Font.font(null, FontWeight.BOLD, 40));

				Button newGameButton = new Button("New Game");
				newGameButton.setStyle("-fx-font: 14 verdana; -fx-base: #7fd87f;");
				newGameButton.setPrefSize(100, 40);

				Button optionButton = new Button("Options");
				optionButton.setStyle("-fx-font: 14 verdana; -fx-base: #D3D3D3;");
				optionButton.setPrefSize(100, 40);

			titleBox.setCenter(titleLabel);
			titleBox.setRight(optionButton);
			titleBox.setLeft(newGameButton);
			titleBox.setStyle("-fx-background-color: #E3E3E3;");
			titleBox.setPadding(new Insets(10,10,10,10));
		
		window.setTop(titleBox);

		//Bottom Layout
			HBox bottomBoxPrev = new HBox(10);

				turnLabel.setFont(new Font("Verdana", 30));
				turnLabel.setFont(Font.font(null, FontWeight.BOLD, 30));

			bottomBoxPrev.getChildren().addAll(turnLabel);
			bottomBoxPrev.setPadding(new Insets(10,10,10,10));
			bottomBoxPrev.setAlignment(Pos.CENTER);
			bottomBoxPrev.setStyle("-fx-background-color: #ffd27f");

		window.setBottom(bottomBoxPrev);

		//Set Scene

			Scene scene = new Scene(window);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Shitty Tic Tac Toe Game");
			stage.show();
	}
}