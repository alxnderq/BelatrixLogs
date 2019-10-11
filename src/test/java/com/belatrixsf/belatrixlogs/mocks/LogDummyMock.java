package com.belatrixsf.belatrixlogs.mocks;

import com.belatrixsf.belatrixlogs.entities.Log;
import com.belatrixsf.belatrixlogs.enums.LevelEnum;

public class LogDummyMock {

    public Log buildMock() {
        return new Log("Test message", LevelEnum.MESSAGE.getLevel());
    }
}
