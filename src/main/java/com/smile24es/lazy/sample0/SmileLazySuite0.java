package com.smile24es.lazy.sample0;

import com.smile24es.lazy.beans.LazySuite;
import com.smile24es.lazy.exception.LazyCoreException;

import static com.smile24es.lazy.sample0.student.StudentApiSuite.studentApiTestSuite;

public class SmileLazySuite0 {

    public static LazySuite populateSampleLazySuite() throws LazyCoreException {
        LazySuite lazySuite = new LazySuite("Smile API suite");
        lazySuite.getTestSuites().add(studentApiTestSuite());
        return lazySuite;
    }
}
