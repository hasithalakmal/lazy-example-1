package com.smile24es.lazy.sample0.student;

import com.smile24es.lazy.beans.suite.ApiCall;
import com.smile24es.lazy.beans.suite.actions.Action;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.wrapper.Actions;
import com.smile24es.lazy.wrapper.Assert;

import java.util.Arrays;

import static java.text.MessageFormat.format;

public class StudentApiCall {

    public static ApiCall createStudentApiCall() throws LazyCoreException {
        ApiCall getAccountApiCall = new ApiCall("Create StudentApi");
        getAccountApiCall.getStack().getDefaultValues().setHttpMethod("POST");
        getAccountApiCall.setUri("v1/accounts");
        getAccountApiCall.setRequestBodyFromJson("request-body/student-api/create-student.json");

        //Http Code Assertion
        getAccountApiCall.addAssertionRule(Assert.responseCodeEqual(201));

        getAccountApiCall.addAssertionRule(Assert.equal("$.studentId", 1));

        getAccountApiCall.getPostActions().add(Actions.createGlobalVariableFromResponseBody("created.student.id", "$.studentId"));
        return getAccountApiCall;
    }

    public static ApiCall getStudentById() throws LazyCoreException {
        ApiCall getAccountApiCall = new ApiCall("Get Student by Student Id");
        getAccountApiCall.setUri("v1/accounts/{{lazy.global.created.student.id}}");

        //Http Code Assertion
        getAccountApiCall.addAssertionRule(Assert.responseCodeEqual(200));

        //Null/Not Null assertions
        getAccountApiCall.addAssertionRule(Assert.notNull("$.studentId"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.studentName"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.isActive"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.weight"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.phone"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.phone.number"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[0].id"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[0].key"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[0].value"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[0].isActive"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[0].amount"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].id"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].key"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].value"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].isActive"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].amount"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].paymentMethods"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].paymentMethods[0].type"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].paymentMethods[0].minValue"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].paymentMethods[1].type"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.settings[1].paymentMethods[1].allowd"));

        getAccountApiCall.addAssertionRule(Assert.isKeyAvailable("$.studentName"));
        getAccountApiCall.addAssertionRule(Assert.isKeyUnavailable("$.invalidKey"));

        //Equal assertions
        getAccountApiCall.addAssertionRule(Assert.equal("$.studentId", 1));
        getAccountApiCall.addAssertionRule(Assert.equal("$.studentName", "Jone Doe"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.isActive", true));
        getAccountApiCall.addAssertionRule(Assert.equal("$.weight", 60.75));
        getAccountApiCall.addAssertionRule(Assert.equal("$.phone.number", "12345678"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[0].id", 840));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[0].key", "school.fee.payment.period"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[0].value", "monthly"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[0].isActive", true));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[0].amount", 10.00));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].id", 841));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].key", "sport.club.payment.period"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].value", "annually"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].isActive", false));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].amount", 20.85));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].paymentMethods[0].type", "Card"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].paymentMethods[0].minValue", 10));
        getAccountApiCall.addAssertionRule(Assert.equal("$.settings[1].paymentMethods[1].type", "Cash"));

        //String operations
        getAccountApiCall.addAssertionRule(Assert.contains("$.studentName", "Jone"));
        getAccountApiCall.addAssertionRule(Assert.notContains("$.studentName", "Alex"));


        //Max min - numeric logic
        getAccountApiCall.addAssertionRule(Assert.greaterThan("$.weight", 50.00));
        getAccountApiCall.addAssertionRule(Assert.lessThan("$.weight", 70.00));
        getAccountApiCall.addAssertionRule(Assert.greaterThanOrEqual("$.weight", 60.75));
        getAccountApiCall.addAssertionRule(Assert.lessThanOrEqual("$.weight", 60.75));
        getAccountApiCall.addAssertionRule(Assert.between("$.weight", 60.00, 70.00));

        //List related logic
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[*].key", Arrays.asList("school.fee.payment.period", "sport.club.payment.period")));
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[*].id", Arrays.asList(840, 841)));
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[*].amount", Arrays.asList(10.00, 20.85)));
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[*].isActive", Arrays.asList(true, true)));

        getAccountApiCall.addAssertionRule(Assert.containsAll("$.settings[*].key", Arrays.asList("school.fee.payment.period")));
        getAccountApiCall.addAssertionRule(Assert.containsAll("$.settings[*].id", Arrays.asList(840)));
        getAccountApiCall.addAssertionRule(Assert.containsAll("$.settings[*].amount", Arrays.asList(10.00)));
        getAccountApiCall.addAssertionRule(Assert.containsAll("$.settings[*].isActive", Arrays.asList(true)));

        getAccountApiCall.addAssertionRule(Assert.containsAny("$.settings[*].key", Arrays.asList("school.fee.payment.period", "INVALID")));
        getAccountApiCall.addAssertionRule(Assert.containsAny("$.settings[*].id", Arrays.asList(840, 1000)));
        getAccountApiCall.addAssertionRule(Assert.containsAny("$.settings[*].amount", Arrays.asList(10.00, 1000)));
        getAccountApiCall.addAssertionRule(Assert.containsAny("$.settings[*].isActive", Arrays.asList(true, false)));

        //Advanced list related logic
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[?(@.key=='school.fee.payment.period')].value", Arrays.asList("monthly")));
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[?(@.paymentMethods)].id", Arrays.asList(841)));
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[?(@.paymentMethods)].paymentMethods.[?(@.type == 'Card')].minValue",
              Arrays.asList(10)));
        getAccountApiCall.addAssertionRule(Assert.containsExactly("$.settings[?(@.paymentMethods)].paymentMethods.[?(@.type == 'Cash')].allowd[*]", Arrays.asList("SLR", "USD")));

        return getAccountApiCall;
    }
}
