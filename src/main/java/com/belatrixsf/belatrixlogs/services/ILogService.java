package com.belatrixsf.belatrixlogs.services;

import java.io.IOException;

public interface ILogService {

    void saveLog(String message, Integer level) throws IOException;
}
