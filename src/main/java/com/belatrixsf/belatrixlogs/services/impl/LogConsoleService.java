package com.belatrixsf.belatrixlogs.services.impl;

import com.belatrixsf.belatrixlogs.services.ILogService;
import com.belatrixsf.belatrixlogs.utils.LevelUtils;
import org.springframework.stereotype.Service;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

@Service
public class LogConsoleService implements ILogService {

    private Logger LOG = Logger.getLogger("MyLog");

    @Override
    public void saveLog(String message, Integer level) {
        LOG.addHandler(new ConsoleHandler());
        LOG.log(LevelUtils.getLevel(level), message);
    }
}
