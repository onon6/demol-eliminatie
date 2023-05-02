package com.dpeeters.molelim;

import javafx.application.Platform;
import javafx.concurrent.Task;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import javax.sound.sampled.*;

public class MusicPlayer {

    Task<Clip> backgroundMusicTask;


    public void playBackgroundMusic() {
        backgroundMusicTask = new Task<>() {
            @Override
            protected Clip call() throws Exception {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getMusicFromResources("/com/dpeeters/molelim/sounds/elimEdited.wav"));
                Clip clip = AudioSystem.getClip();
                clip.loop(10);
                clip.open(audioStream);
                clip.start();
                return clip;
            }
        };
        backgroundMusicTask.run();
    }

    public void playPassScreenSound() {
        getScreenTask("/com/dpeeters/molelim/sounds/green.wav").run();
    }

    public void playEliminatedScreenSound() {
        getScreenTask("/com/dpeeters/molelim/sounds/red.wav").run();
    }

    public void stopBackgroundMusic() {
        try {
            backgroundMusicTask.get().stop();
            backgroundMusicTask = null;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    private InputStream getMusicFromResources(String path) {
        return new BufferedInputStream(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }

    private Task<Void> getScreenTask(String path) {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getMusicFromResources(path));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                return null;
            }
        };
    }
}
