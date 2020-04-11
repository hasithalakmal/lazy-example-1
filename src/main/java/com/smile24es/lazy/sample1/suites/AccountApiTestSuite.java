package com.smile24es.lazy.sample1.suites;

import com.smile24es.lazy.beans.suite.TestSuite;
import com.smile24es.lazy.exception.LazyCoreException;

import java.util.Arrays;

import static com.smile24es.lazy.sample1.scenarios.CreateAccountTestScenario.getAccountCreationTestScenario;


public class AccountApiTestSuite {

    public static TestSuite getAccountApiTestSuite() throws LazyCoreException {
        TestSuite testSuite1 = new TestSuite("Account Test Suite");
        testSuite1.getStack().getDefaultValues().setContextPath("account-api");
        testSuite1.getTestScenarios().add(getAccountCreationTestScenario());
        testSuite1.setAssignGroups(Arrays.asList("account-bvt"));
        return testSuite1;
    }
}
