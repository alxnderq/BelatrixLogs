package com.belatrixsf.belatrixlogs.services;

import com.belatrixsf.belatrixlogs.enums.LevelEnum;
import com.belatrixsf.belatrixlogs.exceptions.InvalidLevelLogException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobLoggerServiceTest {

    @Autowired
    private IJobLoggerService jobLoggerService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void messageTest() throws Exception {
        jobLoggerService.saveLog("Test message", LevelEnum.MESSAGE.getLevel());
    }

    @Test
    public void warningTest() throws Exception {
        jobLoggerService.saveLog("Warning message", LevelEnum.WARNING.getLevel());
    }

    @Test
    public void errorTest() throws Exception {
        jobLoggerService.saveLog("Error message", LevelEnum.ERROR.getLevel());
    }

    @Test
    public void emptyMessageTest() throws Exception {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Message is null or empty!");
        jobLoggerService.saveLog("", LevelEnum.MESSAGE.getLevel());
    }

    @Test
    public void nullMessageTest() throws Exception {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Message is null or empty!");
        jobLoggerService.saveLog(null, LevelEnum.WARNING.getLevel());
    }

    @Test
    public void errorLevelTest() throws Exception {
        thrown.expect(InvalidLevelLogException.class);
        thrown.expectMessage("Level log must be specified!");
        jobLoggerService.saveLog("Test message", 4);
    }

}
