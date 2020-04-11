package com.smile24es.lazy.sample;

import com.smile24es.lazy.beans.DefaultValues;
import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.beans.executor.ApiCallExecutionData;
import com.smile24es.lazy.beans.executor.LazyExecutionData;
import com.smile24es.lazy.beans.executor.LazyExecutionGroup;
import com.smile24es.lazy.beans.executor.TestCaseExecutionData;
import com.smile24es.lazy.beans.executor.TestScenarioExecutionData;
import com.smile24es.lazy.beans.executor.TestSuiteExecutionData;
import com.smile24es.lazy.beans.suite.ApiCall;
import com.smile24es.lazy.beans.suite.Stack;
import com.smile24es.lazy.beans.suite.TestCase;
import com.smile24es.lazy.beans.suite.TestScenario;
import com.smile24es.lazy.beans.suite.TestSuite;
import com.smile24es.lazy.sample0.SmileLazySuite0;
import com.smile24es.lazy.sample1.SampleLazySuite1;
import com.smile24es.lazy.sample1.suites.AccountApiTestSuite;
import com.smile24es.lazy.utils.JsonUtil;
import com.smile24es.lazy.wrapper.Executor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.Arrays;

import static com.smile24es.lazy.common.SampleDefaultValues.createDefaultValues;
import static com.smile24es.lazy.sample1.apicall.AccountApiCalls.createAccountApiCall;
import static com.smile24es.lazy.sample1.scenarios.CreateAccountTestScenario.getAccountCreationTestScenario;
import static com.smile24es.lazy.sample1.testcase.CreateAccountSuccessTestCase.getCreateAccountTestCase;

public class LazyManagerTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LazyManagerTest.class);
    @Autowired
    private Executor executor;

    @Test
    public void accountApiSample0() {
        try {
            LazySuite sampleLazySuite = SmileLazySuite0.populateSampleLazySuite();
            LazyExecutionData results = executor.executeLazySuite(sampleLazySuite);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
//            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
//            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);
        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeSampleLazySuite() {
        try {
            LazySuite sampleLazySuite = SampleLazySuite1.populateSampleLazySuite();
            LazyExecutionData results = executor.executeLazySuite(sampleLazySuite);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeSampleTestSuite() {
        try {
            TestSuite sampleTestSuite = AccountApiTestSuite.getAccountApiTestSuite();
            DefaultValues defaultValues = createDefaultValues();
            Stack stack = new Stack(defaultValues);
            TestSuiteExecutionData results = executor.executeTestSuite(sampleTestSuite, stack);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestScenarioExecutionData());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeSampleTestScenario() {
        try {
            TestScenario sampleTestScenario = getAccountCreationTestScenario();
            DefaultValues defaultValues = createDefaultValues();
            defaultValues.setContextPath("account-api");
            Stack stack = new Stack(defaultValues);
            TestScenarioExecutionData results = executor.executeTestScenario(sampleTestScenario, stack);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestCaseExecutionDataList());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeSampleTestCase() {
        try {
            TestCase sampleTestCase = getCreateAccountTestCase();
            DefaultValues defaultValues = createDefaultValues();
            defaultValues.setContextPath("account-api");
            Stack stack = new Stack(defaultValues);
            TestCaseExecutionData results = executor.executeTestCase(sampleTestCase, stack);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getApiCallExecutionDataList());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeSampleApiCall() {
        try {
            ApiCall sampleApiCall = createAccountApiCall();
            DefaultValues defaultValues = createDefaultValues();
            defaultValues.setContextPath("account-api");
            Stack stack = new Stack(defaultValues);
            ApiCallExecutionData results = executor.executeApiCall(sampleApiCall, stack);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getAssertionExecutionDataList());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeTestSuiteByApiCallGroupName() {
        try {
            LazySuite sampleLazySuite = SampleLazySuite1.populateSampleLazySuite();
            LazyExecutionGroup lazyExecutionGroup = new LazyExecutionGroup();
            lazyExecutionGroup.setApiCallExecutionGroupNames(Arrays.asList("BVT"));
            LazyExecutionData results = executor.executeLazySuite(sampleLazySuite, lazyExecutionGroup);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeTestSuiteByApiCaseGroupName() {
        try {
            LazySuite sampleLazySuite = SampleLazySuite1.populateSampleLazySuite();
            LazyExecutionGroup lazyExecutionGroup = new LazyExecutionGroup();
            lazyExecutionGroup.setTestCaseExecutionGroupNames(Arrays.asList("BVT_TC"));
            LazyExecutionData results = executor.executeLazySuite(sampleLazySuite, lazyExecutionGroup);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

    @Test
    public void executeTestSuiteCombination() {
        try {
            LazySuite sampleLazySuite = SampleLazySuite1.populateSampleLazySuite();
            LazyExecutionGroup lazyExecutionGroup = new LazyExecutionGroup();
            lazyExecutionGroup.setTestCaseExecutionGroupNames(Arrays.asList("BVT_TC"));
            lazyExecutionGroup.setApiCallExecutionGroupNames(Arrays.asList("BVT"));
            LazyExecutionData results = executor.executeLazySuite(sampleLazySuite, lazyExecutionGroup);
            Assert.assertNotNull(results);
            Assert.assertNotNull(results.getTestSuiteExecutionData());
            String resultString = JsonUtil.getJsonStringFromObjectProtectedAndPublic(results);
            LOGGER.debug(EXECUTION_RESULTS_LOG, resultString);

        } catch (Exception ex) {
            Assert.fail(SUCCESS_SCENARIOS_SHOULD_NOT_BE_FAILED, ex);
        }
    }

}
