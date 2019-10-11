package com.belatrixsf.belatrixlogs.utils;

import java.util.logging.Level;

public class LevelUtils {

    public static Level getLevel(final Integer level) {
        switch (level) {
            case 1:
                return Level.INFO;
            case 2:
                return Level.WARNING;
            default:
                return Level.SEVERE;
        }
    }
}
