package com.dpeeters.molelim;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

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

    public ImageView test() {
     return imageModel.getImageView(ResultType.GREEN);
    }

    public void enterPressed(String candidateName) {
        if (isShowingResult) {
            root.getChildren().remove(imageModel.getLastImageView());
            isShowingResult = false;
        } else {
            //imageModel.setImage(ResultType.RED);
            //musicPlayer.stopBackgroundMusic();
            //musicPlayer.playEliminatedScreenSound();
            //isShowingResult = true;
            ImageView resultImageView = imageModel.getImageView(ResultType.RED);
            resultImageView.setFitWidth(root.getWidth());
            resultImageView.setFitHeight(root.getHeight());
            root.getChildren().add(resultImageView);
            //mediaModel.setImage(ResultType.GREEN);
            musicPlayer.playEliminatedScreenSound();
            isShowingResult = true;
        }
    }

    public void initializeBackgroundMusic() {
        musicPlayer.playBackgroundMusic();
    }

}
