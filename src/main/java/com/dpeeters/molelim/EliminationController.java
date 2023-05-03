package com.dpeeters.molelim;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;

public class EliminationController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgResult;

    @FXML
    private TextField inputFieldName;

    @FXML
    private StackPane root;

    @FXML
    private MediaView mediaViewResult;

    public void init() {
        imgBackground.fitWidthProperty().bind(root.widthProperty());
        imgBackground.fitHeightProperty().bind(root.heightProperty());
        imgResult.fitWidthProperty().bind(root.widthProperty());
        imgResult.fitHeightProperty().bind(root.heightProperty());
        //mediaViewResult.fitWidthProperty().bind(root.widthProperty());
        //mediaViewResult.fitHeightProperty().bind(root.heightProperty());


        ResultDelegator resultDelegator = new ResultDelegator(root);
        resultDelegator.initializeBackgroundMusic();

        inputFieldName.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                resultDelegator.enterPressed(inputFieldName.getText());
            }
        });
    }

}