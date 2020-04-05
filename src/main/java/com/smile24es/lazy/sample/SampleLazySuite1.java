package com.smile24es.lazy.sample;

import com.smile24es.lazy.sample.suites.AccountApiTestSuite;
import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.exception.LazyCoreException;

public class SampleLazySuite1 {

    private SampleLazySuite1() {
        //This is a private constructor
    }

    public static LazySuite populateSampleLazySuite() throws LazyCoreException {
        LazySuite lazySuite = new LazySuite("Sample lazy suite 1");
        lazySuite.getTestSuites().add(AccountApiTestSuite.getAccountApiTestSuite());
        return lazySuite;
    }
}
