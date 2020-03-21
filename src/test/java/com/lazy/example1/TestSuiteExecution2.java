package com.lazy.example1;

import com.smile.lazy.LazyApplication;
import com.smile.lazy.beans.executor.LazyExecutionData;
import com.smile.lazy.utils.JsonUtil;
import com.smile.lazy.wrapper.Executor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static com.lazy.example1.SampleLazySuite.populateSampleTestSuite;


@SpringBootTest(classes = LazyApplication.class)
public class TestSuiteExecution2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSuiteExecution2.class);

    @Autowired
    private Executor executor;

    @Test
    public void testWithWrapper() {
        try {
            LazyExecutionData results = executor.executeLazySuite(populateSampleTestSuite());
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
//            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
//            LOGGER.info("Execution results \n [{}]", resultString);
        } catch (Exception ex) {
            Assert.fail("Success scenarios should not be failed", ex);
        }
    }
}
