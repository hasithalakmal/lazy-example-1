package com.smile24es.lazy.sample1.account;

import com.smile24es.lazy.beans.suite.ApiCall;
import com.smile24es.lazy.exception.LazyCoreException;
import com.smile24es.lazy.sample1.dto.AccountTo;
import com.smile24es.lazy.sample1.dto.ErrorTo;
import com.smile24es.lazy.wrapper.Actions;
import com.smile24es.lazy.wrapper.Assert;

import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;

public class AccountApiCall {

    public static ApiCall getInvalidAccountApiCall(String accountId, ErrorTo errorTo) {
        ApiCall getAccountApiCall = new ApiCall("Get invalid account by Id");
        getAccountApiCall.setUri(format("service/accounts/{0}", accountId));
        getAccountApiCall.addAssertionRule(Assert.responseCodeEqual(404));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.code"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.description"));
        getAccountApiCall.addAssertionRule(Assert.notNull("$.additionalInfo"));
        getAccountApiCall.addAssertionRule(Assert.equal("$.code", errorTo.getCode()));
        getAccountApiCall.addAssertionRule(Assert.equal("$.description", errorTo.getDescription()));
        getAccountApiCall.addAssertionRule(Assert.equal("$.additionalInfo", errorTo.getAdditionalInfo()));
        return getAccountApiCall;
    }

    public static ApiCall getValidAccountApiCall(AccountTo accountTo) {
        ApiCall getAccountApiCall = new ApiCall("Get Account by Id");
        getAccountApiCall.setUri("service/accounts/{{lazy.global.created.account.id}}");
        getAccountApiCall.addAssertionRule(Assert.responseCodeEqual(200));
        accountDetailAssertion(accountTo, getAccountApiCall);
        getAccountApiCall.addAssertionRule(Assert.equal("custom", "$.accountName", "{{lazy.global.created.account.accountName}}"));
        return getAccountApiCall;
    }

    public static ApiCall createSuccessAccount(AccountTo accountTo) throws LazyCoreException {
        ApiCall createAccountApiCall = new ApiCall("Create Account");
        createAccountApiCall.setUri("service/accounts");
        createAccountApiCall.setUri("service/accounts");
        createAccountApiCall.setHttpMethod("POST");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("accountName", accountTo.getAccountName());
        templateData.put("accountStatus", accountTo.getAccountStatus());
        templateData.put("enterpriseId", accountTo.getEnterpriseId());
        templateData.put("versionId", accountTo.getVersionId());
        templateData.put("settings", accountTo.getAccountSettings());

        createAccountApiCall.setRequestBodyFromJsonTemplate("request-body/account-api/templates/create-account.ftl", templateData);
        accountDetailAssertion(accountTo, createAccountApiCall);

        createAccountApiCall.disableAssertion("account.api.max.response.time");
        createAccountApiCall.addAssertionRule(Assert.responseTimeLessThan("300"));

        createAccountApiCall.getPostActions().add(Actions.createGlobalVariableFromResponseBody("created.account.id", "$.accountId"));
        createAccountApiCall.getPostActions().add(Actions.createGlobalVariableFromResponseBody("created.account.accountName", "$.accountName"));

        return createAccountApiCall;
    }


    private static void accountDetailAssertion(AccountTo accountTo, ApiCall accountApiCall) {
        accountApiCall.addAssertionRule(Assert.notNull("Account Name not null assertion", "$.accountName"));
        accountApiCall.addAssertionRule(Assert.equal("$.accountName", accountTo.getAccountName()));
        accountApiCall.addAssertionRule(Assert.equal("$.status", accountTo.getAccountStatus()));
        accountApiCall.addAssertionRule(Assert.equal("$.enterpriseId", accountTo.getEnterpriseId()));
        accountApiCall.addAssertionRule(Assert.equal("$.versionId", accountTo.getVersionId()));

        accountApiCall.addAssertionRule(Assert.notNull("Settings not null assertion", "$.settings"));
        accountApiCall.addAssertionRule(Assert.equal("Account setting length assertion", "$.settings.length()", accountTo.getAccountSettings().size()));

        accountApiCall.addAssertionRule(Assert.equal("setting - 1 - key", "$.settings[0].key", accountTo.getAccountSettings().get(0).getKey()));
        accountApiCall.addAssertionRule(Assert.equal("setting - 1 - value", "$.settings[0].value", accountTo.getAccountSettings().get(0).getValue()));
        accountApiCall.addAssertionRule(Assert.notNull("setting - 1 - id", "$.settings[0].id"));
        accountApiCall.addAssertionRule(Assert.equal("setting - 1 - status", "$.settings[0].settingStatus", "ACTIVE"));
        accountApiCall.addAssertionRule(Assert.equal("setting - 2 - key", "$.settings[1].key", accountTo.getAccountSettings().get(1).getKey()));
        accountApiCall.addAssertionRule(Assert.equal("setting - 2 - value", "$.settings[1].value", accountTo.getAccountSettings().get(1).getValue()));
        accountApiCall.addAssertionRule(Assert.notNull("setting - 2 - id", "$.settings[1].id"));
        accountApiCall.addAssertionRule(Assert.equal("setting - 2 - status", "$.settings[1].settingStatus", "ACTIVE"));

    }
}
