package com.lazy.example1.testcase;

import com.smile.lazy.beans.suite.TestCase;

import static com.lazy.example1.apicall.AccountApiCalls.createAccountApiCall;
import static com.lazy.example1.apicall.AccountApiCalls.createAccountApiCallWithJsonFile;
import static com.lazy.example1.apicall.AccountApiCalls.getAccountApiCall;

public class CreateAccountSuccessTestCase {

    public static TestCase getCreateAccountTestCase() {
        TestCase testCase1 = new TestCase( "Create Account successfully");
        testCase1.getApiCalls().add(createAccountApiCall());
        testCase1.getApiCalls().add(getAccountApiCall());
        testCase1.getApiCalls().add(createAccountApiCallWithJsonFile());
        testCase1.getApiCalls().add(getAccountApiCall());
        return testCase1;
    }
}
