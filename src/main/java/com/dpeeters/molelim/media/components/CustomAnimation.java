package com.dpeeters.molelim.media.components;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CustomAnimation extends Transition {

    private ImageView imageView;
    private int count;

    private int lastIndex;

    private Image[] sequence;

    private CustomAnimation() {
    }

    public CustomAnimation(Image[] sequence, double durationMs) {
        init( sequence, durationMs);
    }

    public void init( Image[] sequence, double durationMs) {
        this.imageView = new ImageView(sequence[0]);
        this.sequence = sequence;
        this.count = sequence.length;

        setCycleCount(1);
        setCycleDuration(Duration.millis(durationMs));
        setInterpolator(Interpolator.LINEAR);

    }

    protected void interpolate(double k) {

        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            imageView.setImage(sequence[index]);
            lastIndex = index;
        }

    }

    public ImageView getView() {
        return imageView;
    }

}