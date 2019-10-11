package com.belatrixsf.belatrixlogs.services.impl;

import com.belatrixsf.belatrixlogs.entities.Log;
import com.belatrixsf.belatrixlogs.repository.ILogRepository;
import com.belatrixsf.belatrixlogs.services.ILogService;
import com.belatrixsf.belatrixlogs.utils.LevelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LogDatabaseService implements ILogService {

    private Logger LOG = Logger.getLogger("MyLog");

    private ILogRepository logRepository;

    @Autowired
    public LogDatabaseService(ILogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void saveLog(String message, Integer level) {
        logRepository.save(new Log(message, level));
        LOG.log(LevelUtils.getLevel(level), message);
    }
}
