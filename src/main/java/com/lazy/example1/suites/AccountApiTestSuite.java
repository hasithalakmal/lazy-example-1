package com.lazy.example1.suites;

import com.smile.lazy.beans.suite.TestSuite;

import static com.lazy.example1.scenarios.CreateAccountTestScenario.getAccountCreationTestScenario;


public class AccountApiTestSuite {

    public static TestSuite getAccountApiTestSuite() {
        TestSuite testSuite1 = new TestSuite("Account Test Suite");
        testSuite1.getTestScenarios().add(getAccountCreationTestScenario());
        return testSuite1;
    }
}