package com.smile24es.lazy.sample1;

import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.sample1.account.AccountTestSuite;

public class SmileLazySuite1 {
    public static LazySuite populateSampleLazySuite() throws LazyCoreException {
        LazySuite lazySuite = new LazySuite("Smile API suite");
        lazySuite.getTestSuites().add(AccountTestSuite.getAccountApiTestSuite());
        return lazySuite;
    }
}
