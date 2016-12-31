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
	import javafx.scene.canvas.*;
	import javafx.animation.*;

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

		BorderPane gameWindow = new BorderPane();
		gameWindow.setPrefSize(800, 500);
		gameWindow.setStyle("-fx-background-image: url(\"/images/background.jpg\");-fx-background-size: 1600, 500;-fx-background-repeat: no-repeat;");

		Group root = new Group();
		Canvas canvas = new Canvas(700,350);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image gameBackground = new Image("images/background.jpg");
		Image square = new Image("images/square.jpg");

		final long startNanoTime = System.nanoTime();

		new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {
				final double dxdt = 5.0; //Speed
				final double dydt = 0.0; //vertical speed
				final double t = (currentNanoTime - startNanoTime) / 1000000000.0;
				final double x = dxdt * t;
				final double y = dydt * t;

				gc.drawImage(circle, x, y);
			}
		}.start();

		gameWindow.setCenter(root);
		Scene scene = new Scene(gameWindow);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Run & Jump Man");
		stage.show();
	}
}