package com.dpeeters.molelim;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.MalformedURLException;

public class MediaModel {

    Media mediaGreen;
    Media mediaRed;
    MediaView resultMedia;
    MediaPlayer greenMediaPlayer;

    public MediaModel(MediaView resultMedia) {
        this.resultMedia = resultMedia;
        File file = new File("C:\\Users\\danil\\Desktop\\demol-eliminatie\\media\\green_glitched.mp4");
        try {
            mediaGreen = new Media(file.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        //imageRed = new Image(getClass().getResourceAsStream("/com/dpeeters/molelim/img/red_edited.png"));
        greenMediaPlayer = new MediaPlayer(mediaGreen);
    }


    public void setImage(ResultType resultType) {
        Platform.runLater(() -> {
            switch (resultType) {
                case GREEN -> {
                    resultMedia.setMediaPlayer(greenMediaPlayer);

                }
                //case RED -> resultImage.setImage(imageRed);
            }
        });
    }

    public void clearImage() {
        Platform.runLater(() -> resultMedia.setMediaPlayer(null));
    }
}
