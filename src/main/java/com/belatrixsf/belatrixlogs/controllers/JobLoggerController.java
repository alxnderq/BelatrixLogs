package com.belatrixsf.belatrixlogs.controllers;

import com.belatrixsf.belatrixlogs.enums.LevelEnum;
import com.belatrixsf.belatrixlogs.services.impl.JobLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("logs")
public class JobLoggerController {

    private JobLoggerService jobLoggerService;

    @Autowired
    public JobLoggerController(JobLoggerService jobLoggerService) {
        this.jobLoggerService = jobLoggerService;
    }

    @GetMapping(path = "message")
    public void saveMessageLog() {
        String message = "This is a message!";
        jobLoggerService.saveLog(message, LevelEnum.MESSAGE.getLevel());
    }

    @GetMapping(path = "message")
    public void saveErrorLog() {
        String message = "This is a error!";
        jobLoggerService.saveLog(message, LevelEnum.ERROR.getLevel());
    }

    @GetMapping(path = "message")
    public void saveWarningLog() {
        String message = "This is a warning!";
        jobLoggerService.saveLog(message, LevelEnum.WARNING.getLevel());
    }
}
