package com.dpeeters.molelim.media;

import javafx.concurrent.Task;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import javax.sound.sampled.*;

public class MusicPlayer {

    Task<Clip> backgroundMusicTask;
    Task<Clip> eliminatedMusicTask;


    public void playBackgroundMusic() {
        if (backgroundMusicTask != null) return;

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

    private void playEliminatedMusic() {
        eliminatedMusicTask = new Task<>() {
            @Override
            protected Clip call() throws Exception {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getMusicFromResources("/com/dpeeters/molelim/sounds/afvaller.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                return clip;
            }
        };
        eliminatedMusicTask.run();
    }

    public void playPassScreenSound() {
        getScreenTask("/com/dpeeters/molelim/sounds/green.wav").run();
    }

    public void playEliminatedScreenSound() {
        LineListener listener = (event) -> {
            if (event.getType() == LineEvent.Type.STOP) {
                playEliminatedMusic();
            }
        };
        getScreenTask("/com/dpeeters/molelim/sounds/red.wav", listener).run();
    }

    public void stopEliminatedMusic() {
        stopMusic(eliminatedMusicTask);
        eliminatedMusicTask = null;
    }

    public void stopBackgroundMusic() {
        stopMusic(backgroundMusicTask);
        backgroundMusicTask = null;
    }

    private void stopMusic(Task<Clip> clipTask) {
        if (clipTask == null) return;
        try {
            clipTask.get().stop();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    private InputStream getMusicFromResources(String path) {
        return new BufferedInputStream(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }

    private Task<Void> getScreenTask(String path, LineListener onStopListener) {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getMusicFromResources(path));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                clip.addLineListener(onStopListener);
                return null;
            }
        };
    }

    private Task<Void> getScreenTask(String path) {
        return getScreenTask(path, null);
    }
}
