package com.gitlab.weefee.ProCooker;

import javax.sound.sampled.*;
import java.io.IOException;

public class Audio {
    public Clip getBGM(String song) {
        try {
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/" + song + ".wav"));
            AudioFormat musicFormat = musicStream.getFormat();
            DataLine.Info musicInfo = new DataLine.Info(Clip.class, musicFormat);
            Clip musicClip = (Clip) AudioSystem.getLine(musicInfo);
            musicClip.open(musicStream);
            return musicClip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Clip getSFX(String sfx) {
        try {
            AudioInputStream sfxStream = AudioSystem.getAudioInputStream(getClass().getResource("/sfx/" + sfx + ".wav"));
            AudioFormat sfxFormat = sfxStream.getFormat();
            DataLine.Info sfxInfo = new DataLine.Info(Clip.class, sfxFormat);
            Clip sfxClip = (Clip) AudioSystem.getLine(sfxInfo);
            sfxClip.open(sfxStream);
            return sfxClip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }
}
