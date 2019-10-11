package com.belatrixsf.belatrixlogs.services.impl;

import com.belatrixsf.belatrixlogs.enums.LevelEnum;
import com.belatrixsf.belatrixlogs.services.IJobLoggerService;
import com.belatrixsf.belatrixlogs.services.ILogService;
import com.belatrixsf.belatrixlogs.utils.LevelLogUtils;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;

@Service
public class JobLoggerService implements IJobLoggerService {

    private ILogService logFileService;
    private ILogService logConsoleService;
    private ILogService logDatabaseService;

    @Value("${logs.config.logMessage}")
    private boolean logMessage;
    @Value("${logs.config.logError}")
    private boolean logError;
    @Value("${logs.config.logWarning}")
    private boolean logWarning;
    @Value("${logs.config.logToFile}")
    private boolean logToFile;
    @Value("${logs.config.logToConsole}")
    private boolean logToConsole;
    @Value("${logs.config.logToDatabase}")
    private boolean logToDatabase;

    @Autowired
    public JobLoggerService(@Qualifier("logFileService") ILogService logFileService,
                            @Qualifier("logConsoleService") ILogService logConsoleService,
                            @Qualifier("logDatabaseService") ILogService logDatabaseService) {
        this.logFileService = logFileService;
        this.logConsoleService = logConsoleService;
        this.logDatabaseService = logDatabaseService;
    }

    @Override
    public void saveLog(String message, Integer level) throws Exception {
        validateConfig(message, level);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LevelLogUtils.getMessageWithLevel(level))
            .append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
            .append(" ")
            .append(message.trim());

        if (logToFile) {
            logFileService.saveLog(stringBuilder.toString(), level);
        }
        if (logToConsole) {
            logConsoleService.saveLog(stringBuilder.toString(), level);
        }
        if (logToDatabase) {
            logDatabaseService.saveLog(stringBuilder.toString(), level);
        }
    }

    private void validateConfig(String message, Integer level) throws Exception {
        if (!isValidMessage(message)) {
            throw new Exception("Message is empty!");
        }
        if (!isValidConfiguration()) {
            throw new Exception("Configuration is invalid!");
        }
        if (!isValidLevelLog(level)) {
            throw new Exception("Level log must be specified!");
        }
    }

    private boolean isValidMessage(String message) {
        return message != null && !message.trim().isEmpty();
    }

    private boolean isValidConfiguration() {
        return logToFile || logToConsole || logToDatabase;
    }

    private boolean isValidLevelLog(Integer level) {
        return (logMessage || logError || logWarning) && EnumUtils.isValidEnum(LevelEnum.class, String.valueOf(level));
    }
}
