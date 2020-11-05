/* SPDX-License-Identifier: GPL-3.0-or-later */

package com.gitlab.weefee.ProCooker;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * Sound library.
 */
public class Audio {
    /**
     * Plays a song n the background.
     * @param song The song to play.
     * @return A controllable clip.
     */
    public Clip getBGM(String song) {
        try {
            // Gets the audio input stream from an internal resource
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/" + song + ".wav"));
            // Prepare the audio to be played
            AudioFormat musicFormat = musicStream.getFormat();
            DataLine.Info musicInfo = new DataLine.Info(Clip.class, musicFormat);
            // Create the clip for controlling the audio
            Clip musicClip = (Clip) AudioSystem.getLine(musicInfo);
            // Open the audio stream and attach it to the clip
            musicClip.open(musicStream);
            return musicClip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Plays a sound effect.
     * @param sfx The sound effect to play.
     * @return A controllable clip.
     */
    public Clip getSFX(String sfx) {
        try {
            // Gets the audio input stream from an internal resource
            AudioInputStream sfxStream = AudioSystem.getAudioInputStream(getClass().getResource("/sfx/" + sfx + ".wav"));
            // Prepare the audio to be played
            AudioFormat sfxFormat = sfxStream.getFormat();
            DataLine.Info sfxInfo = new DataLine.Info(Clip.class, sfxFormat);
            // Create the clip for controlling the audio
            Clip sfxClip = (Clip) AudioSystem.getLine(sfxInfo);
            // Open the audio stream and attach it to the clip
            sfxClip.open(sfxStream);
            return sfxClip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }
}
