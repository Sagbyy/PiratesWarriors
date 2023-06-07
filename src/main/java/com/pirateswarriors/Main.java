package com.pirateswarriors;

import com.pirateswarriors.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("view.fxml"));
            Scene scene = new Scene(root);

            // Chargement du fichier audio
            Media mediaMusic = new Media(getClass().getResource("/com/pirateswarriors/sounds/PiratesWarriorsMusic.mp3").toString());
            // Creation du lecteur media
            mediaPlayer = new MediaPlayer(mediaMusic);

            // Lecture du media au lancement
            mediaPlayer.setVolume(0.44); //  disregarding the volume I set
            mediaPlayer.play();

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        // Arrêt du lecteur média lorsque l'application se ferme
        mediaPlayer.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}