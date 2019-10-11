package com.belatrixsf.belatrixlogs.utils;

public class LevelLogUtils {

    public static String getMessageWithLevel(Integer level) {
        switch (level) {
            case 1:
                return "message";
            case 2:
                return "error";
            case 3:
                return "warning";
            default:
                return null;
        }
    }
}
