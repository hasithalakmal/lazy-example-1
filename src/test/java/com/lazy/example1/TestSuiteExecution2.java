package com.lazy.example1;

import com.smile.lazy.LazyApplication;
import com.smile.lazy.beans.result.AssertionResultList;
import com.smile.lazy.wrapper.Executor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static com.lazy.example1.SampleLazySuite.populateSampleTestSuite;


@SpringBootTest(classes = LazyApplication.class)
public class TestSuiteExecution2 {

    @Autowired
    private Executor executor;

    @Test
    public void testEmployee() {
        try {
            AssertionResultList results = executor.executeLazySuite(populateSampleTestSuite());
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getResults());
            results.getResults().forEach(result -> Assert.assertTrue(result.getPass(), result.getActualValue()));
        } catch (Exception ex) {
            Assert.fail("Success scenarios should not be failed", ex);
        }
    }
}
