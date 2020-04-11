package com.smile24es.lazy.sample0.student;

import com.smile24es.lazy.beans.suite.TestSuite;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.wrapper.Assert;

import static com.smile24es.lazy.sample0.student.StudentApiTestScenarios.createStudentSuccessScenario;

public class StudentApiSuite {

    public static TestSuite studentApiTestSuite() throws LazyCoreException {
        TestSuite studentApiTestSuite = new TestSuite("Student API Test Suite");
        studentApiTestSuite.getStack().getDefaultValues().setContextPath("lazy-mock-api"); //We are configuring context path
        studentApiTestSuite.getStack().getDefaultValues().setHostName("localhost");
        studentApiTestSuite.getStack().getDefaultValues().setPort(8181);
        studentApiTestSuite.getStack().addDefaultAssertionRule(Assert.responseTimeLessThan("300"));
        studentApiTestSuite.getTestScenarios().add(createStudentSuccessScenario());
        return studentApiTestSuite;
    }
}
