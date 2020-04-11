package com.smile24es.lazy.sample1.account;

import com.smile24es.lazy.beans.suite.TestSuite;
import com.smile24es.lazy.beans.suite.assertions.AssertionRule;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.wrapper.Assert;

public class AccountTestSuite {

    public static TestSuite getAccountApiTestSuite() throws LazyCoreException {
        TestSuite accountApiTestSuite = new TestSuite("Account Test Suite");
        accountApiTestSuite.getStack().getDefaultValues().setContextPath("account-api"); //We are configuring context path
        accountApiTestSuite.getStack().getDefaultValues().setHostName("localhost");
        AssertionRule assertionRule = Assert.responseTimeLessThan("150");
        assertionRule.setAssertionRuleKey("account.api.max.response.time");
        accountApiTestSuite.getStack().addDefaultAssertionRule(assertionRule);
        accountApiTestSuite.getTestScenarios().add(GetAccountTestScenarios.createAccountTestScenario());
        accountApiTestSuite.getTestScenarios().add(GetAccountTestScenarios.getAccountErrorScenarios());
        return accountApiTestSuite;
    }
}
