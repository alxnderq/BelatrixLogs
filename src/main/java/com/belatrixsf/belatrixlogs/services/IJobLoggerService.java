package com.belatrixsf.belatrixlogs.services;

public interface IJobLoggerService {

    void saveLog(String message, Integer level) throws Exception;

}
