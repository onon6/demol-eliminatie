package com.dpeeters.molelim;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.awt.image.BufferedImage;

public class AnimatedGif {

    private CustomAnimation customAnimation;

    public AnimatedGif( String filename, double durationMs) {

        GifDecoder d = new GifDecoder();
        d.read( filename);

        Image[] sequence = new Image[ d.getFrameCount()];
        for( int i=0; i < d.getFrameCount(); i++) {

            WritableImage wimg = null;
            BufferedImage bimg = d.getFrame(i);
            sequence[i] = SwingFXUtils.toFXImage( bimg, wimg);

        }
        customAnimation = new CustomAnimation(sequence, durationMs);
    }

    public CustomAnimation getAnimation() {
        return customAnimation;
    }

    public void setAnimation(CustomAnimation customAnimation) {
        this.customAnimation = customAnimation;
    }
}
