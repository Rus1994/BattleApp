package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Смертельная битва");
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("MK_Logo.png")));
        primaryStage.show();

        String sound = "MK.mp3";
        Media hit = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
