package com.lazy.example1;

import com.smile.lazy.LazyApplication;
import com.smile.lazy.beans.LazySuite;
import com.smile.lazy.beans.result.AssertionResultList;
import com.smile.lazy.manager.LazyManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;


@SpringBootTest(classes = LazyApplication.class)
public class TestSuiteExecution1 {

    @Autowired
    private LazyManager lazyManager;

    @Test
    public void testEmployee() {
        try {
            LazySuite sampleLazySuite = SampleLazySuite.populateSampleTestSuite();
            AssertionResultList results = lazyManager.executeLazySuite(sampleLazySuite);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getResults());
            results.getResults().forEach(result -> Assert.assertTrue(result.getPass(), result.getActualValue()));
        } catch (Exception ex) {
            Assert.fail("Success scenarios should not be failed", ex);
        }
    }
}
