package com.belatrixsf.belatrixlogs.services.impl;

import com.belatrixsf.belatrixlogs.services.ILogService;
import com.belatrixsf.belatrixlogs.utils.LevelUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Service
public class LogFileService implements ILogService {

    private Logger LOG = Logger.getLogger("MyLog");

    @Value("${logs.config.path}")
    private String path;
    @Value("${logs.config.filename}")
    private String filename;

    @Override
    public void saveLog(String message, Integer level) throws IOException {
        String file = path.concat(filename);
        Path pathFile = Paths.get(file).getParent();
        if (!Files.exists(pathFile)) {
            Files.createDirectories(pathFile);
        }
        FileHandler fileHandler = new FileHandler(file);
        LOG.addHandler(fileHandler);
        LOG.log(LevelUtils.getLevel(level), message);
    }
}
