package game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.awt.Toolkit; 

public class EternalEmpire extends Application {
	//Mediaplayer only works on the outside of the class
	MediaPlayer mediaPlayerTitle, mediaPlayerVillage, mediaPlayerForest, mediaPlayerDeath;
	int hp = 20;
	int monsterHp = 20;
	
	@Override
	public void start(Stage theStage) throws Exception {
		
		final Image titleScreen = new Image("asset/Title_Screen.png");
		final Image village = new Image("asset/Village.png");
		final Image forest = new Image("asset/Forest.png");
		final Image death = new Image("asset/Skull.png");
		final Image icon = new Image("asset/Icon.png");
		final double CANVAS_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		final double CANVAS_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		theStage.setTitle("Eternal Empire");
		theStage.getIcons().add(icon);
		theStage.setMaximized(true);
		
		//Font for buttons and text
		Font myFontloadFontAirstream = 
	            Font.loadFont(getClass()
	                .getResourceAsStream("/asset/KAISG.ttf"), 60);
		
		//Set title screen image
		final ImageView flashScreen_title = new ImageView();
		flashScreen_title.setImage(titleScreen);
		flashScreen_title.setFitHeight(CANVAS_HEIGHT);
		flashScreen_title.setFitWidth(CANVAS_WIDTH);
		
		//Set village image
		final ImageView flashScreen_village = new ImageView();
		flashScreen_village.setImage(village);
		flashScreen_village.setFitHeight(CANVAS_HEIGHT);
		flashScreen_village.setFitWidth(CANVAS_WIDTH);
		
		//Set forest image
		final ImageView flashScreen_forest = new ImageView();
		flashScreen_forest.setImage(forest);
		flashScreen_forest.setFitHeight(CANVAS_HEIGHT);
		flashScreen_forest.setFitWidth(CANVAS_WIDTH);
		
		//Set forest image
		final ImageView flashScreen_death = new ImageView();
		flashScreen_death.setImage(death);
		flashScreen_death.setFitHeight(CANVAS_HEIGHT);
		flashScreen_death.setFitWidth(CANVAS_WIDTH);
		
		//Set the music for the title screen and loop it
		Media soundTitle = new Media(new File("Title_Screen.mp3").toURI().toString());
		mediaPlayerTitle = new MediaPlayer(soundTitle);
		mediaPlayerTitle.setCycleCount(MediaPlayer.INDEFINITE);
		
		//Set the music for the town and loop it
		Media soundVillage = new Media(new File("Town.mp3").toURI().toString());
		mediaPlayerVillage = new MediaPlayer(soundVillage);
		mediaPlayerVillage.setCycleCount(MediaPlayer.INDEFINITE);
		
		//Set the music for the forest and loop it
		Media soundForest = new Media(new File("Forest.mp3").toURI().toString());
		mediaPlayerForest = new MediaPlayer(soundForest);
		mediaPlayerForest.setCycleCount(MediaPlayer.INDEFINITE);
		
		//Set the music for the death screen
		Media soundDeath = new Media(new File("Death.mp3").toURI().toString());
		mediaPlayerDeath = new MediaPlayer(soundDeath);
		
		//Create the village scene and add everything
		Group rootVillage = new Group();
		rootVillage.getChildren().addAll(flashScreen_village);
		Scene sceneVillage = new Scene(rootVillage, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
		
		//Create the forest scene and add everything
		Group rootForest = new Group();
		rootForest.getChildren().addAll(flashScreen_forest);
		Scene sceneForest = new Scene(rootForest, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
		
		//Create the death scene
		Group rootDeath = new Group();
		rootDeath.getChildren().addAll(flashScreen_death);
		Scene sceneDeath = new Scene(rootDeath, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
		
		//Hp forest
		Text forestHp = new Text("Player HP: " + hp);
		forestHp.setFont(Font.loadFont(getClass().getResourceAsStream("/asset/KAISG.ttf"), 60));
		forestHp.setFill(Color.WHITE);
		forestHp.setLayoutX(0);
		forestHp.setLayoutY(50);
		
		//Monster hp
		Text monster = new Text("Monster HP: " + monsterHp);
		monster.setFont(Font.loadFont(getClass().getResourceAsStream("/asset/KAISG.ttf"), 60));
		monster.setFill(Color.WHITE);
		monster.setLayoutX(CANVAS_WIDTH-monster.getBoundsInLocal().getWidth());
		monster.setLayoutY(50);
		
		//Death text
		Text deathText = new Text("You Died!");
		deathText.setFont(Font.loadFont(getClass().getResourceAsStream("/asset/KAISG.ttf"), 200));
		deathText.setFill(Color.RED);
		deathText.setLayoutX(CANVAS_WIDTH/2-deathText.getBoundsInLocal().getWidth()/2);
		deathText.setLayoutY(CANVAS_HEIGHT/2 - 150);
		
		//Start button	
		Button buttonStart = new Button();
		buttonStart.setFont(myFontloadFontAirstream);
		buttonStart.setText("Start");
		buttonStart.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");
		buttonStart.setLayoutX(CANVAS_WIDTH/2 - 196.9199981689453/2);
		buttonStart.setLayoutY(CANVAS_HEIGHT/2 - 150);
		
				
	    buttonStart.setOnAction(e ->  {
	    	theStage.setScene(sceneVillage);
		    mediaPlayerTitle.stop();
		    mediaPlayerVillage.play();
	    });
	    
	    
	    //Close button
	    Button buttonClose = new Button();
		buttonClose.setFont(myFontloadFontAirstream);
		buttonClose.setText("Close");
		buttonClose.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");
		buttonClose.setMinSize(100, 50);
		buttonClose.setLayoutX(CANVAS_WIDTH/2 - 198.44000244140625/2);
		buttonClose.setLayoutY(CANVAS_HEIGHT/2);
		
		buttonClose.setOnAction(e ->  {
	    	theStage.close();
	    });
		
		//Go to forest button
		Button buttonForest = new Button();
		buttonForest.setFont(myFontloadFontAirstream);
		buttonForest.setText("Go to the forest");
		buttonForest.setMinSize(100, 50);
		buttonForest.setLayoutX(CANVAS_WIDTH/2 - 399.1199645996094/2);
		buttonForest.setLayoutY(CANVAS_HEIGHT/2 + 150);
		buttonForest.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");
		
	    buttonForest.setOnAction(e ->  {
	    	theStage.setScene(sceneForest);
		    mediaPlayerVillage.stop();
		    mediaPlayerForest.play();
	    });
	    	
	    //Return to Village
	    Button buttonReturn = new Button();
		buttonReturn.setFont(myFontloadFontAirstream);
		buttonReturn.setText("Return to the village");
		buttonReturn.setLayoutX(CANVAS_WIDTH/2 - 495.60003662109375/2);
		buttonReturn.setLayoutY(CANVAS_HEIGHT/2 + 150);
		buttonReturn.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");
					
		buttonReturn.setOnAction(e ->  {
		    theStage.setScene(sceneVillage);
		   	mediaPlayerForest.stop();
		   	mediaPlayerVillage.play();
		});
		
		 //Attack monster
	    Button buttonAttack = new Button();
		buttonAttack.setFont(myFontloadFontAirstream);
		buttonAttack.setText("Attack!");
		buttonAttack.setLayoutX(150);
		buttonAttack.setLayoutY(CANVAS_HEIGHT/2 + 150);
		buttonAttack.setStyle("-fx-background-color: rgba(36, 36, 36, .7); -fx-text-fill: white");
		
		buttonAttack.setOnAction(e ->  {
		    int monsterDamage = 0;
		    int playerDamage = 0;	
		    monsterDamage = new java.util.Random().nextInt(6);
			hp -= monsterDamage;
			playerDamage = new java.util.Random().nextInt(12);
			monsterHp -= playerDamage;		
			rootForest.getChildren().removeAll(forestHp, monster);
						
			//Check who wins the fight
		    if(monsterHp <= 0) {
		    	monsterHp = 0;
		    	System.out.println("You win");
		    }  
		    if(hp <= 0) {
		    	hp = 0;
		    	mediaPlayerForest.stop();
		    	mediaPlayerDeath.play();
		    	rootDeath.getChildren().addAll(deathText, buttonClose);
		    	theStage.setFullScreen(false);
		    	theStage.setScene(sceneDeath);
		    	theStage.setFullScreen(true);
		    }
		    
		    forestHp.setText("Player HP: " + hp);
			monster.setText("Monster HP: " + monsterHp);
			rootForest.getChildren().addAll(forestHp, monster);
		});
	
	    //Add buttons/text to the scenes	
	    rootVillage.getChildren().addAll(buttonForest);
	    rootForest.getChildren().addAll(buttonReturn, buttonAttack, forestHp, monster);
	    
	    //Create the title scene and add everything to the first scene
		Group rootTitle = new Group();
		rootTitle.getChildren().addAll(flashScreen_title, buttonStart, buttonClose);
		Scene sceneTitle = new Scene(rootTitle, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
		
		
		//play the first scene and its music
	    theStage.setScene(sceneTitle);
		mediaPlayerTitle.play();
		theStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
