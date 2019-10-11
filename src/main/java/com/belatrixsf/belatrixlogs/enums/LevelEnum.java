package com.belatrixsf.belatrixlogs.enums;

public enum LevelEnum {

    MESSAGE(1), ERROR(2), WARNING(3);

    private Integer level;

    LevelEnum(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
