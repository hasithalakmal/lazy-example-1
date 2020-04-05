package com.smile24es.lazy.sample.suites;

import com.smile24es.lazy.beans.suite.TestSuite;
import com.smile24es.lazy.exception.LazyCoreException;

import java.util.Arrays;

import static com.smile24es.lazy.sample.scenarios.CreateAccountTestScenario.getAccountCreationTestScenario;


public class AccountApiTestSuite {

    public static TestSuite getAccountApiTestSuite() throws LazyCoreException {
        TestSuite testSuite1 = new TestSuite("Account Test Suite");
        testSuite1.getTestScenarios().add(getAccountCreationTestScenario());
        testSuite1.setAssignGroups(Arrays.asList("account-bvt"));
        return testSuite1;
    }
}
