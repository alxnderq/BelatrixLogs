package com.belatrixsf.belatrixlogs.services.impl;

import com.belatrixsf.belatrixlogs.services.IJobLoggerService;
import com.belatrixsf.belatrixlogs.services.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JobLoggerService implements IJobLoggerService {

    private ILogService logMessageService;
    private ILogService logConsoleService;
    private ILogService logDatabaseService;

    @Value("${logs.config.logMessage}")
    private boolean logMessage;
    @Value("${logs.config.logWarning}")
    private boolean logWarning;
    @Value("${logs.config.logError}")
    private boolean logError;
    @Value("${logs.config.logToFile}")
    private boolean logToFile;
    @Value("${logs.config.logToConsole}")
    private boolean logToConsole;
    @Value("${logs.config.logToDatabase}")
    private boolean logToDatabase;

    @Autowired
    public JobLoggerService(@Qualifier("logMessageService") ILogService logMessageService,
                            @Qualifier("logConsoleService") ILogService logConsoleService,
                            @Qualifier("logDatabaseService") ILogService logDatabaseService) {
        this.logMessageService = logMessageService;
        this.logConsoleService = logConsoleService;
        this.logDatabaseService = logDatabaseService;
    }

    @Override
    public void saveLog(String message, Integer level) {
    }

    private void validateConfig(String message, Integer level) throws Exception {
        if (!isValidMessage(message)) {
            throw new Exception("Message is empty");
        }
        if (!isValidConfiguration()) {
            throw new Exception("Configuration is invalid");
        }
    }

    private boolean isValidMessage(String message) {
        return message != null && !message.trim().isEmpty();
    }

    private boolean isValidConfiguration() {
        return logToFile || logToConsole || logToDatabase;
    }
}
