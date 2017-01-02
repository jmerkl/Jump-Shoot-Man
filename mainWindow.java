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
		int windowWidth = 750;

		BorderPane gameWindow = new BorderPane();
		gameWindow.setPrefSize(windowWidth, windowHeight);
		gameWindow.setStyle("-fx-background-color: #000000;");

		Scene scene = new Scene(gameWindow);

		Group root = new Group();
			Canvas canvas = new Canvas(windowWidth, windowHeight);

			Label scoreLabel = new Label("Score: ");
			scoreLabel.setFont(new Font("Verdana", 20));
			scoreLabel.setFont(Font.font(null, FontWeight.BOLD, 20));
			scoreLabel.setPadding(new Insets(0,5,10,5));
		root.getChildren().addAll(canvas,scoreLabel);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image gameBackground = new Image("images/background.jpg");
		Image mainCharacter = new Image("images/sombrero.PNG", 50.0, 40.0, true, true);
		Image singleSpike = new Image("images/trumpWall2.PNG", 50.0, 80.0, true, true);

		final long startNanoTime = System.nanoTime();
		final double dxdt = 0.0; //Speed
		final double scrollSpeed = -400.0; //speed of obstacles & background
		final double dydt = 75.0; //vertical speed
		final double g = 400.0; //Restoring gravity
		final double groundLevel = 325.0; //Ground level position
		final ArrayList<Double> timeList = new ArrayList<Double>();
		final double[] spikeLocations = {100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0, 1000.0};

		MainCharacter mc = new MainCharacter(mainCharacter, dxdt, dydt, 100.0, groundLevel);
		ScrollingBackground scrollBg = new ScrollingBackground(gameBackground, scrollSpeed, 0.0, 0.0);
		Spike spike = new Spike(singleSpike, scrollSpeed, 800.0, groundLevel-35.0);

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
				final double xx = -scrollSpeed*t;
				final double y = groundLevel;

				// Jump-Key Sequence
				scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
				      if(key.getCode()==KeyCode.SPACE) {
				          if (!mc.isFlying(groundLevel)) {
				          	mc.setJump(true);
				          } else if (mc.getJump() & !mc.getDoubleJump()) {
				          	mc.setDoubleJump(true);
				          }
				      }
				});

				// Jump Physics Sequence
				if (mc.getJump()) {
					mc.jump(dydt, g, dt, groundLevel);
				} else if (mc.getDoubleJump()) {
					mc.doubleJump(dydt, g, dt, groundLevel);
				} else if (mc.isFlying(groundLevel)) {
					mc.jump(dydt, g, dt, groundLevel);
				} else {
					mc.setTime(0.0);
				}

				// Check for Collision
				double spikeLeft = spike.getX() - (spike.getImage().getWidth()/2.0);
				double spikeRight = spike.getX() + (spike.getImage().getWidth()/2.0);

				if (xx > spikeLeft && xx < spikeRight) {
					if (mc.getY() > (spike.getY() - spike.getImage().getHeight())) {
						mc.death();
					} else {
						spike.setDxdt(spike.getDxdt() * 1.2);
						//scrollBg.setDxdt(scrollBg.getDxdt() * 1.2);
					}
				}

				System.out.println(spike.getDxdt());

				if (xx > spikeLeft*1.2) {
					spike.setX(xx+750.0);
				}

				//Continue or terminate the game
				if (mc.isAlive()) {
					double score = t * 12;
					scoreLabel.setText("Score: " + Integer.toString((int)score));

					gc.drawImage(scrollBg.getImage(),scrollBg.scroll(x,dt),0);
					gc.drawImage(spike.getImage(),spike.scroll(spike.getX(),dt),spike.getY());
					gc.drawImage(mc.getImage(), mc.getX(), mc.getY());
				} else {
					gameWindow.setStyle("-fx-background-color: #FFFFFF;");
					gameWindow.setCenter(new Label("your waifu is shit"));
				}
				
			}
		}.start();

		gameWindow.setCenter(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Run & Jump Man");
		stage.show();
	}
}