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
	import javafx.scene.Node;
	import javafx.stage.*;
	import javafx.scene.*;
	import javafx.scene.input.*;
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

		int windowHeight = 400;
		int windowWidth = 800;

		BorderPane gameWindow = new BorderPane();
		gameWindow.setPrefSize(windowWidth, windowHeight);
		gameWindow.setStyle("-fx-background-color: #000000;");

		Scene scene = new Scene(gameWindow);

		Group root = new Group();
		Canvas canvas = new Canvas(windowWidth, windowHeight);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image gameBackground = new Image("images/background.jpg");
		Image square = new Image("images/square.jpg");

		final long startNanoTime = System.nanoTime();
		final double dxdt = 0.0; //Speed
		final double dydt = 20.0; //vertical speed
		final double g = 75.0; //Restoring gravity
		final double groundLevel = 332.0; //Ground level position
		final ArrayList<Double> timeList = new ArrayList<Double>();

		MainCharacter mc = new MainCharacter(square, dxdt, dydt, 100.0, groundLevel);


		new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {		
				final double t = (currentNanoTime - startNanoTime) / 1000000000.0;

				timeList.add(t);
				int endLoc = timeList.size();
				double dt = 0.016;
				if (endLoc > 2) {
					dt = timeList.get(endLoc-1) - timeList.get(endLoc-2);
				}

				final double x = dxdt*t;
				final double y = groundLevel;

				scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
				      if(key.getCode()==KeyCode.SPACE) {
				          if (!mc.isFlying(groundLevel)) {
				          	mc.setJump(true);
				          } else if (mc.getJump() & !mc.getDoubleJump()) {
				          	mc.setDoubleJump(true);
				          }
				      }
				});

				if (mc.getJump()) {
					mc.jump(dydt, g, dt, groundLevel);
				} else if (mc.getDoubleJump()) {
					mc.doubleJump(dydt, g, dt, groundLevel);
				} else if (mc.isFlying(groundLevel)) {
					mc.jump(dydt, g, dt, groundLevel);
				} else {
					mc.setTime(0.0);
				}

				gc.drawImage(gameBackground,0,0);
				gc.drawImage(mc.getImage(), mc.getX(), mc.getY());
			}
		}.start();

		gameWindow.setCenter(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Run & Jump Man");
		stage.show();
	}
}