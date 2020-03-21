package com.lazy.example1;

import com.smile.lazy.beans.DefaultValues;
import com.smile.lazy.beans.LazySuite;
import com.smile.lazy.beans.suite.Global;
import com.smile.lazy.beans.suite.Stack;

import static com.lazy.example1.suites.AccountApiTestSuite.getAccountApiTestSuite;
import static com.smile.lazy.utils.SampleDefaultValues.createDefaultValues;

public class SampleLazySuite {

    public static LazySuite populateSampleTestSuite() {
        DefaultValues defaultValues = createDefaultValues();
        Stack lazySuiteStack = new Stack(defaultValues);
        Global global = new Global();
        LazySuite lazySuite = new LazySuite("Sample lazy suite 1", lazySuiteStack, global);
        lazySuite.getTestSuites().add(getAccountApiTestSuite());
        return lazySuite;
    }
}
