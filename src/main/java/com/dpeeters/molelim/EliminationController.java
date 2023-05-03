package com.dpeeters.molelim;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

public class EliminationController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgResult;

    @FXML
    private TextField inputFieldName;

    @FXML
    private StackPane root;

    public void init() {
        imgBackground.fitWidthProperty().bind(root.widthProperty());
        imgBackground.fitHeightProperty().bind(root.heightProperty());
        imgResult.fitWidthProperty().bind(root.widthProperty());
        imgResult.fitHeightProperty().bind(root.heightProperty());


        ResultDelegator resultDelegator = new ResultDelegator(root);
        resultDelegator.initializeBackgroundMusic();

        inputFieldName.setOnKeyPressed(keyEvent -> {
            switch(keyEvent.getCode()) {
              case ENTER -> {
                resultDelegator.enterPressed(inputFieldName.getText());
                inputFieldName.setText("");
              }
              case ESCAPE -> Platform.exit();
            }
        });
    }

}