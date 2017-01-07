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
    import javafx.geometry.*;
    import javafx.scene.control.*;

    public class optionMenu{

    	public static void display(String title, String message){
    		Stage window = new Stage();

    		window.initModality(Modality.APPLICATION_MODAL);
    		window.setTitle(title);
    		//window.setPrefSize(100,100);

    		Label label = new Label();
    		label.setText("Hello");
    		Button closeButton = new Button("Close");
    		closeButton.setOnAction(e -> window.close());

    		VBox layout = new VBox();
    		layout.getChildren().addAll(label,closeButton);
    		layout.setAlignment(Pos.CENTER);
    		
    		Scene scene = new Scene(layout, 300, 300);
    		window.setScene(scene);
    		window.showAndWait();



    	}


    }