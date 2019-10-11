package com.belatrixsf.belatrixlogs.repository;

import com.belatrixsf.belatrixlogs.entities.Log;
import com.belatrixsf.belatrixlogs.enums.LevelEnum;
import com.belatrixsf.belatrixlogs.mocks.LogDummyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ILogRepositoryTest {

    @Autowired
    ILogRepository repository;

    private Log inputLog;

    @Before
    public void setUp() {
        LogDummyMock dummyMock = new LogDummyMock();
        inputLog = dummyMock.buildMock();
    }

    @Test
    public void insertLevelMessageLogTest() {
        Log result = repository.save(inputLog);

        Assert.assertNotNull(result);
        Assert.assertEquals(inputLog.getMessage(), result.getMessage());
        Assert.assertEquals(inputLog.getLevel(), result.getLevel());
    }

    @Test
    public void insertLevelErrorLogTest() {
        inputLog.setLevel(LevelEnum.ERROR.getLevel());
        Log result = repository.save(inputLog);

        Assert.assertNotNull(result);
        Assert.assertEquals(inputLog.getMessage(), result.getMessage());
        Assert.assertEquals(inputLog.getLevel(), result.getLevel());
    }

    @Test
    public void insertLevelWarningLogTest() {
        inputLog.setLevel(LevelEnum.WARNING.getLevel());
        Log result = repository.save(inputLog);
        Assert.assertNotNull(result);
        Assert.assertEquals(inputLog.getMessage(), result.getMessage());
        Assert.assertEquals(inputLog.getLevel(), result.getLevel());
    }


}
