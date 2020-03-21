package com.lazy.example1.apicall;

import com.smile.lazy.beans.suite.ApiCall;
import com.smile.lazy.beans.suite.assertions.AssertionRule;
import com.smile.lazy.beans.suite.assertions.AssertionRuleGroup;
import com.smile.lazy.wrapper.Actions;
import com.smile.lazy.wrapper.Assert;

import java.util.List;

import static com.lazy.example1.common.AssertionKeys.ACCOUNT_ID;
import static com.lazy.example1.common.AssertionKeys.ACCOUNT_NAME;

public class AccountApiCalls {

    public static ApiCall createAccountApiCall() {
        ApiCall apiCall1 = new ApiCall(1, "Create Account");
        apiCall1.setUri("service/accounts");
        apiCall1.setHttpMethod("POST");
        apiCall1.setRequestBody("{\"status\":\"ACTIVE\",\"createdBy\":\"12345\",\"parentId\":\"1\",\"enterpriseId\":\"1\","
              + "\"accountName\":\"Sathara-1577641690\",\"ownerName\":\"Hasitha-1577641690\",\"versionId\":\"1.0.0\","
              + "\"settings\":[{\"key\":\"setting1\",\"value\":\"1577641690\"},{\"key\":\"setting2\",\"value\":\"1577641690\"}]}");
        apiCall1.addAssertionGroup(accountAssertionGroup1("Sathara-1577641690"));
        apiCall1.getPostActions().add(Actions.createGlobalVariableFromBody("created.account.id.1", ACCOUNT_ID));
        apiCall1.getPostActions().add(Actions.createGlobalVariableFromBody("created.account.name.1", ACCOUNT_NAME));
        return apiCall1;
    }

    public static ApiCall createAccountApiCallWithJsonFile() {
        ApiCall apiCall1 = new ApiCall(1, "Create Account");
        apiCall1.setUri("service/accounts");
        apiCall1.setHttpMethod("POST");
        apiCall1.setRequestBodyFromJson("request-body/account-api/create-account/create-simple-account.json");
        apiCall1.addAssertionGroup(accountAssertionGroup1("Sathara-1577641690"));
        apiCall1.getPostActions().add(Actions.createGlobalVariableFromBody("created.account.id.1", ACCOUNT_ID));
        apiCall1.getPostActions().add(Actions.createGlobalVariableFromBody("created.account.name.1", ACCOUNT_NAME));
        return apiCall1;
    }

    public static ApiCall getAccountApiCall() {
        ApiCall apiCall2 = new ApiCall(2, "Get Account by Id");
        apiCall2.disableAssertion("created.http.status.assertion");
        apiCall2.setUri("service/accounts/{{lazy.global.created.account.id.1}}");
        apiCall2.addAssertionGroup(accountAssertionGroup1("{{lazy.global.created.account.name.1}}"));
        apiCall2.addAssertionRule(Assert.equalBodyValueAssertion(ACCOUNT_ID, "{{lazy.global.created.account.id.1}}"));
        apiCall2.addAssertionRule(Assert.responseCodeAssertion("200"));
        return apiCall2;
    }

    private static AssertionRuleGroup accountAssertionGroup1(String expectedAccountName) {
        AssertionRuleGroup assertionRuleGroup1 = new AssertionRuleGroup(1000, "Create Account success assertions");
        List<AssertionRule> assertionRules = assertionRuleGroup1.getAssertionRules();
        assertionRules.add(Assert.notNullBodyValueAssertion(ACCOUNT_NAME));
        assertionRules.add(Assert.equalBodyValueAssertion(ACCOUNT_NAME, expectedAccountName));
        return assertionRuleGroup1;
    }
}
