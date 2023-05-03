package com.dpeeters.molelim;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageModel {

    private CustomAnimation customAnimationGreen;
    private CustomAnimation customAnimationRed;
    private ImageView lastImageView;

    public ImageModel() {
        customAnimationGreen = new AnimatedGif(getClass().getResource("/com/dpeeters/molelim/img/green.gif").toExternalForm(), 1000).getAnimation();
        customAnimationGreen.setCycleCount(1);
        customAnimationRed = new AnimatedGif(getClass().getResource("/com/dpeeters/molelim/img/red.gif").toExternalForm(), 1000).getAnimation();
        customAnimationRed.setCycleCount(1);
    }

    public ImageView getImageView(ResultType resultType) {
        switch (resultType) {
            case GREEN -> {
                customAnimationGreen.play();
                lastImageView = customAnimationGreen.getView();
                return lastImageView;
            }
            case RED -> {
                customAnimationRed.play();
                lastImageView = customAnimationRed.getView();
                return lastImageView;
            }
        }
        return null;
    }

    public ImageView getLastImageView() {
        return lastImageView;
    }
}
