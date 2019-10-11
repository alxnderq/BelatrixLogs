package com.belatrixsf.belatrixlogs.services.impl;

import com.belatrixsf.belatrixlogs.services.ILogService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LogMessageService implements ILogService {

    private Logger LOG = Logger.getLogger("MyLog");

    @Override
    public void saveLog(String message, Integer level) {

    }
}
