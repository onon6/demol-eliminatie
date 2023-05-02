package com.dpeeters.molelim;

import javafx.scene.image.ImageView;

public class ResultDelegator {

    private boolean isShowingResult;

    private static final MusicPlayer musicPlayer = new MusicPlayer();
    private final ImageModel imageModel;

    public ResultDelegator(ImageView resultView) {
        this.isShowingResult = false;
        imageModel = new ImageModel(resultView);
    }


    public void enterPressed() {
        if (isShowingResult) {
            imageModel.clearImage();
            isShowingResult = false;
        } else {
            //imageModel.setImage(ResultType.RED);
            //musicPlayer.stopBackgroundMusic();
            //musicPlayer.playEliminatedScreenSound();
            //isShowingResult = true;
            imageModel.setImage(ResultType.GREEN);
            musicPlayer.playPassScreenSound();
            isShowingResult = true;
        }
    }

    public void initializeBackgroundMusic() {
        musicPlayer.playBackgroundMusic();
    }

}
