package com.lazy.example1;

import com.smile.lazy.LazyApplication;
import com.smile.lazy.beans.LazySuite;
import com.smile.lazy.beans.executor.LazyExecutionData;
import com.smile.lazy.manager.LazyManager;
import com.smile.lazy.utils.JsonUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;


@SpringBootTest(classes = LazyApplication.class)
public class TestSuiteExecution1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSuiteExecution1.class);

    @Autowired
    private LazyManager lazyManager;

    @Test
    public void testWithManager() {
        try {
            LazySuite sampleLazySuite = SampleLazySuite.populateSampleTestSuite();
            LazyExecutionData results = lazyManager.executeLazySuite(sampleLazySuite);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
//            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
//            LOGGER.info("Execution results \n [{}]", resultString);
        } catch (Exception ex) {
            Assert.fail("Success scenarios should not be failed", ex);
        }
    }
}
