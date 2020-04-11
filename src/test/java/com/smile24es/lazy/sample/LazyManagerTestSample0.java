package com.smile24es.lazy.sample;

import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.beans.executor.LazyExecutionData;
import com.smile24es.lazy.sample0.SmileLazySuite0;
import com.smile24es.lazy.wrapper.Executor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LazyManagerTestSample0 extends BaseTest {

    @Autowired
    private Executor executor;

    @Test
    public void lazySample0Test() {
        try {
            LazySuite sampleLazySuite = SmileLazySuite0.populateSampleLazySuite();
            LazyExecutionData results = executor.executeLazySuite(sampleLazySuite);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }
}
