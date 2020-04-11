package com.smile24es.lazy.sample0.student;

import com.smile24es.lazy.beans.suite.TestCase;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.sample0.dto.StudentDto;
import com.smile24es.lazy.sample0.dto.StudentSetting;
import com.smile24es.lazy.sample1.account.AccountApiCall;
import com.smile24es.lazy.sample1.dto.AccountSetting;
import com.smile24es.lazy.sample1.dto.ErrorTo;

import static com.smile24es.lazy.sample0.student.StudentApiCall.createStudentApiCall;
import static com.smile24es.lazy.sample0.student.StudentApiCall.getStudentById;
import static com.smile24es.lazy.sample1.account.AccountApiCall.mockApiCall;
import static java.text.MessageFormat.format;

public class StudentApiTestCases {

    public static TestCase createStudentSuccessTestCase() throws LazyCoreException {
        TestCase createStudentTC = new TestCase("Create Student successfully");
        createStudentTC.getApiCalls().add(createStudentApiCall());
        createStudentTC.getApiCalls().add(getStudentById());
        return createStudentTC;
    }
}
