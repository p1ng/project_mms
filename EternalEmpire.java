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
	//Mediaplayer only works on the outside of the class
	MediaPlayer mediaPlayer, mediaPlayer2;
	@Override
	public void start(Stage theStage) throws Exception {
		
		final Image titleScreen = new Image("asset/Title_Screen.png");
		final Image village = new Image("asset/Village.png");
		final Image icon = new Image("asset/Icon.png");
		final double CANVAS_WIDTH = 1920;
		final double CANVAS_HEIGHT = 980;
		
		theStage.setTitle("Eternal Empire");
		theStage.getIcons().add(icon);
		theStage.setFullScreen(true);
		
		//Font for buttons and text
		Font myFontloadFontAirstream = 
	            Font.loadFont(getClass()
	                .getResourceAsStream("/asset/KAISG.ttf"), 90);
		
		//Set title screen image
		final ImageView flashScreen_node = new ImageView();
		flashScreen_node.setImage(titleScreen);
		flashScreen_node.setFitHeight(1080);
		flashScreen_node.setFitWidth(1920);
		
		//Set village image
		final ImageView flashScreen_node2 = new ImageView();
		flashScreen_node2.setImage(village);
		flashScreen_node2.setFitHeight(1080);
		flashScreen_node2.setFitWidth(1920);
		
		//Set the music for the title screen and loop it
		Media soundTitle = new Media(new File("Title_Screen.mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(soundTitle);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		
		//Set the music for the town and loop it
		Media soundVillage = new Media(new File("Town.mp3").toURI().toString());
		mediaPlayer2 = new MediaPlayer(soundVillage);
		mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
		
		//Create the village scene and add everything
		Group rootVillage = new Group();
		rootVillage.getChildren().addAll(flashScreen_node2);
		Scene scene2;
		scene2 = new Scene(rootVillage, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
        
		//Start button	
		Button buttonStart = new Button();
		buttonStart.setFont(myFontloadFontAirstream);
		buttonStart.setText("Start");
		buttonStart.setMinSize(100, 50);
		buttonStart.setLayoutX(800);
		buttonStart.setLayoutY(400);
		buttonStart.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");
				
	    buttonStart.setOnAction(e ->  {
	    	theStage.setFullScreen(false);
	    	theStage.setScene(scene2);
	    	theStage.setFullScreen(true);
		    mediaPlayer.stop();
		    mediaPlayer2.play();
	    });
	    
	    
	    //Close button
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
	    
	    //Create the title scene and add everything to the first scene
		Group rootTitle = new Group();
		rootTitle.getChildren().addAll(flashScreen_node, buttonStart, buttonClose);
		Scene theScene = new Scene(rootTitle, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
		
		//play the first scene and its music
	    theStage.setScene(theScene);
		mediaPlayer.play();
		
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
