package com.dpeeters.molelim;

import javafx.application.Platform;
import javafx.concurrent.Task;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import javax.sound.sampled.*;

public class MusicPlayer {



    public void playBackgroundMusic() {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getMusicFromResources("/com/dpeeters/molelim/sounds/elimEdited.wav"));
                Clip clip = AudioSystem.getClip();
                clip.loop(10);
                clip.open(audioStream);
                clip.start();
                return null;
            }
        };

        task.run();
    }

    private InputStream getMusicFromResources(String path) {
        return new BufferedInputStream(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }
}
