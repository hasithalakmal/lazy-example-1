package com.smile24es.lazy.sample0.student;

import com.smile24es.lazy.beans.suite.TestCase;
import com.smile24es.lazy.exception.LazyCoreException;

import static com.smile24es.lazy.sample0.student.StudentApiCall.createStudentApiCall;
import static com.smile24es.lazy.sample0.student.StudentApiCall.getStudentById;

public class StudentApiTestCases {

    public static TestCase createStudentSuccessTestCase() throws LazyCoreException {
        TestCase createStudentTC = new TestCase("Create Student successfully");
        createStudentTC.getApiCalls().add(createStudentApiCall());
        createStudentTC.getApiCalls().add(getStudentById());
        return createStudentTC;
    }
}
