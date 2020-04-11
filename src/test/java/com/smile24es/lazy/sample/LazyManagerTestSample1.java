package com.smile24es.lazy.sample;

import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.beans.executor.LazyExecutionData;
import com.smile24es.lazy.sample1.SmileLazySuite1;
import com.smile24es.lazy.wrapper.Executor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LazyManagerTestSample1 extends BaseTest {

    @Autowired
    private Executor executor;

    @Test
    public void lazySample1Test() {
        try {
            LazySuite sampleLazySuite = SmileLazySuite1.populateSampleLazySuite();
            LazyExecutionData results = executor.executeLazySuite(sampleLazySuite);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

}
