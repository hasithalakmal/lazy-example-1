package com.smile24es.lazy.sample2;

import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.sample2.suites.AccountApiTestSuite;

public class SampleLazySuite2 {

    public static LazySuite populateSampleLazySuite() throws LazyCoreException {
        LazySuite lazySuite = new LazySuite("Sample lazy suite 1");
        lazySuite.getTestSuites().add(AccountApiTestSuite.getAccountApiTestSuite());
        return lazySuite;
    }
}
