package com.smile24es.lazy.sample2.testcase;

import com.smile24es.lazy.beans.suite.TestCase;
import com.smile24es.lazy.beans.suite.assertions.AssertionRule;
import com.smile24es.lazy.beans.suite.assertions.AssertionRuleGroup;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.sample2.apicall.AccountApiCalls;
import com.smile24es.lazy.wrapper.Assert;

import java.util.Arrays;
import java.util.List;

public class CreateAccountSuccessTestCase {

    public static TestCase getCreateAccountTestCase() throws LazyCoreException {
        TestCase testCase1 = new TestCase("Create Account successfully - 1");
        testCase1.getStack().addDefaultAssertionGroup(createDefaultAssertionRuleGroup());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCallWithJsonFile());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCallWithTemplateFile());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCallWithTemplateFileComplex());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCallDemoAssertionEnablement());
        return testCase1;
    }

    public static TestCase getCreateAccountTestCase2() throws LazyCoreException {
        TestCase testCase1 = new TestCase("Create Account successfully - 2");
        testCase1.getStack().addDefaultAssertionGroup(createDefaultAssertionRuleGroup());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCallWithJsonFile());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCallWithTemplateFile());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.createAccountApiCallWithTemplateFileComplex());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCall());
        testCase1.getApiCalls().add(AccountApiCalls.getAccountApiCallDemoAssertionEnablement());

        testCase1.setAssignGroups(Arrays.asList("BVT_TC"));

        return testCase1;
    }


    private static AssertionRuleGroup createDefaultAssertionRuleGroup() {
        AssertionRuleGroup defaultCreateAssertionGroup = new AssertionRuleGroup("Test case assertion group");
        List<AssertionRule> assertionRules = defaultCreateAssertionGroup.getAssertionRules();
        //Performance impacted assertion
        AssertionRule responseTimeAssertion = Assert.responseTimeLessThan("500");
        responseTimeAssertion.setAssertionRuleKey("high.performance.response.time.assertion");
        assertionRules.add(responseTimeAssertion);
        return defaultCreateAssertionGroup;
    }


}
