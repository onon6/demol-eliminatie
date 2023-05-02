package com.dpeeters.molelim;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageModel {

    Image imageGreen;
    Image imageRed;
    ImageView resultImage;

    public ImageModel(ImageView resultImage) {
        this.resultImage = resultImage;
        imageGreen = new Image(getClass().getResourceAsStream("/com/dpeeters/molelim/img/green_edited.png"));
        imageRed = new Image(getClass().getResourceAsStream("/com/dpeeters/molelim/img/red_edited.png"));
    }


    public void setImage(ResultType resultType) {
        Platform.runLater(() -> {
            switch (resultType) {
                case GREEN -> resultImage.setImage(imageGreen);
                case RED -> resultImage.setImage(imageRed);
            }
        });
    }

    public void clearImage() {
        Platform.runLater(() -> resultImage.setImage(null));
    }
}
