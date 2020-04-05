package com.smile24es.lazy.sample;

import com.smile24es.lazy.sample.suites.AccountApiTestSuite;
import com.smile24es.lazy.beans.DefaultValues;
import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.beans.suite.Stack;
import com.smile24es.lazy.exception.LazyCoreException;

import static com.smile24es.lazy.utils.SampleDefaultValues.createDefaultValues;

public class SampleLazySuite1 {

    private SampleLazySuite1() {
        //This is a private constructor
    }

    public static LazySuite populateSampleLazySuite() throws LazyCoreException {
        DefaultValues defaultValues = createDefaultValues();
        defaultValues.setContextPath("account-api");
        Stack lazySuiteStack = new Stack(defaultValues);
        LazySuite lazySuite = new LazySuite("Sample lazy suite 1", lazySuiteStack);
        lazySuite.getTestSuites().add(AccountApiTestSuite.getAccountApiTestSuite());
        return lazySuite;
    }
}
