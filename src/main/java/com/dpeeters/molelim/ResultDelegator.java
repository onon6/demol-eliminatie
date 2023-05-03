package com.dpeeters.molelim;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultDelegator {

    private boolean isShowingResult;

    private static final MusicPlayer musicPlayer = new MusicPlayer();
    private final ImageModel imageModel;
    private final Pane root;

    public ResultDelegator(Pane root) {
        this.isShowingResult = false;
        imageModel = new ImageModel();
        this.root = root;
    }

    public void enterPressed(String candidateName) {
        if (isShowingResult) {
            root.getChildren().remove(imageModel.getLastImageView());
            isShowingResult = false;
            musicPlayer.playBackgroundMusic();
            return;
        }
        List<String> geelimineerdenList = new ArrayList<>();
        ImageView resultImageView;
        try {
            geelimineerdenList = GeelimineerdenReader.getGeelimineerden();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        if (geelimineerdenList.contains(candidateName)) {
            resultImageView = imageModel.getImageView(ResultType.RED);
            musicPlayer.playEliminatedScreenSound();
            musicPlayer.stopBackgroundMusic();
        } else {
            resultImageView = imageModel.getImageView(ResultType.GREEN);
            musicPlayer.playPassScreenSound();
        }

        resultImageView.setFitWidth(root.getWidth());
        resultImageView.setFitHeight(root.getHeight());
        root.getChildren().add(resultImageView);
        isShowingResult = true;
    }

    public void initializeBackgroundMusic() {
        musicPlayer.playBackgroundMusic();
    }

}
