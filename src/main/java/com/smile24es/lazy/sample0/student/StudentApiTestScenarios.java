package com.smile24es.lazy.sample0.student;

import com.smile24es.lazy.beans.suite.TestScenario;
import com.smile24es.lazy.exception.LazyCoreException;

import static com.smile24es.lazy.sample0.student.StudentApiTestCases.createStudentSuccessTestCase;

public class StudentApiTestScenarios {

    public static TestScenario createStudentSuccessScenario() throws LazyCoreException {
        TestScenario successStudentCreation = new TestScenario("Create Account Success scenario");
        successStudentCreation.getTestCases().add(createStudentSuccessTestCase());
        return successStudentCreation;
    }
}
