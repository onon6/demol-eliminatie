package com.dpeeters.molelim;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageModel {

    Image imageGreen;

    public ImageModel() {
        imageGreen = new Image(getClass().getResourceAsStream("/com/dpeeters/molelim/img/green_edited.png"));
    }


    public void setImage(ImageView imageView) {
        Platform.runLater(() -> {
            imageView.setImage(imageGreen);
        });
    }
}
