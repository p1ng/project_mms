package game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class EternalEmpire extends Application {
	MediaPlayer mediaPlayer, mediaPlayer2;
	@Override
	public void start(Stage theStage) throws Exception {
		
		final Image titleScreen = new Image("asset/Title_Screen.png");
		final Image village = new Image("asset/Village.png");
		final Image icon = new Image("asset/Icon.png");
		final ImageView flashScreen_node = new ImageView();
		flashScreen_node.setImage(titleScreen);
		flashScreen_node.setFitHeight(1080);
		flashScreen_node.setFitWidth(1920);
		
		theStage.setTitle("Eternal Empire");
		theStage.getIcons().add(icon);

		Media sound = new Media(new File("Title_Screen.mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		
		final double CANVAS_WIDTH = 1920;
		final double CANVAS_HEIGHT = 980;
		
		Group root = new Group();
		root.getChildren().addAll(flashScreen_node);
		
		Scene theScene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
		Scene scene2;
		
		
		theStage.setScene(theScene);
		
		
		mediaPlayer.play();	
		
		//Scene2	
		Button button1 = new Button();
		
		Font myFontloadFontAirstream = 
	            Font.loadFont(getClass()
	                .getResourceAsStream("/asset/KAISG.ttf"), 90);
		button1.setFont(myFontloadFontAirstream);
		button1.setText("Start");
		button1.setMinSize(100, 50);
		button1.setLayoutX(800);
		button1.setLayoutY(400);
		button1.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");

		
		
		Media sound2 = new Media(new File("Town.mp3").toURI().toString());
		mediaPlayer2 = new MediaPlayer(sound2);
		mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
		
	    final ImageView flashScreen_node2 = new ImageView();
		flashScreen_node2.setImage(village);
		flashScreen_node2.setFitHeight(1080);
		flashScreen_node2.setFitWidth(1920);
		
		Group root2 = new Group();
		root2.getChildren().addAll(flashScreen_node2);
		
		
		scene2 = new Scene(root2, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
        
	    button1.setOnAction(e ->  {
	    	theStage.setFullScreen(false);
	    	theStage.setScene(scene2);
	    	theStage.setFullScreen(true);
		    mediaPlayer.stop();
		    mediaPlayer2.play();
	    });
	    
	    
	    //Close Button
	    Button buttonClose = new Button();
		
		
		buttonClose.setFont(myFontloadFontAirstream);
		
		buttonClose.setText("Close");
		buttonClose.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");
		buttonClose.setMinSize(100, 50);
		buttonClose.setLayoutX(800);
		buttonClose.setLayoutY(600);
		
		
		buttonClose.setOnAction(e ->  {
	    	theStage.close();
	    });
	    
	    
	    root.getChildren().addAll(button1, buttonClose);
	    theStage.setFullScreen(true);
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
