package com.dpeeters.molelim;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class EliminationController {

    @FXML
    private ImageView imgResult;

    @FXML
    private AnchorPane innerAnchor;

    @FXML
    private TextField inputFieldName;

    public void init() {
        MusicPlayer musicPlayer = new MusicPlayer();
        ImageModel imageModel = new ImageModel();
        musicPlayer.playBackgroundMusic();
        inputFieldName.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                System.out.println("result");
                imageModel.setImage(imgResult);
            }
        });
    }

}