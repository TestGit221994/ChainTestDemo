$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/featureFiles/demo1.feature");
formatter.feature({
  "name": "Verify Demo API",
  "description": "  Description : Verify CRUD operation",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify demo POST API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"\u003cTestName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "I hit the \"\u003cRequestMethod\u003e\" method of POST USER API with \"\u003cURL\u003e\" end point",
  "keyword": "When "
});
formatter.step({
  "name": "Validate the status code of POST API is \"\u003cStatusCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Validate user details in POST API response",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "TestName",
        "URL",
        "RequestMethod",
        "StatusCode"
      ]
    },
    {
      "cells": [
        "POST Demo API",
        "/users",
        "POST",
        "201"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify demo POST API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"POST Demo API\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DemoStepDefinition.iWantToCreateTestCase(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hit the \"POST\" method of POST USER API with \"/users\" end point",
  "keyword": "When "
});
formatter.match({
  "location": "DemoStepDefinition.iHitTheMethodOfPOSTUSERAPIWithEndPoint(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the status code of POST API is \"201\"",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateTheStatusCodeOfPOSTAPIIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate user details in POST API response",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateUserDetailsInPOSTAPIResponse()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify demo GET API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"\u003cTestName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "I hit the \"\u003cRequestMethod\u003e\" method of GET USER API with \"\u003cURL\u003e\" end point",
  "keyword": "When "
});
formatter.step({
  "name": "Validate the status code of GET API is \"\u003cStatusCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Validate user details in GET API response",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "TestName",
        "URL",
        "RequestMethod",
        "StatusCode"
      ]
    },
    {
      "cells": [
        "GET Demo API",
        "/users/2",
        "GET",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify demo GET API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"GET Demo API\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DemoStepDefinition.iWantToCreateTestCase(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hit the \"GET\" method of GET USER API with \"/users/2\" end point",
  "keyword": "When "
});
formatter.match({
  "location": "DemoStepDefinition.iHitTheMethodOfGETUSERAPIWithEndPoint(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the status code of GET API is \"200\"",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateTheStatusCodeOfGETAPIIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate user details in GET API response",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateUserDetailsInGETAPIResponse()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/featureFiles/demo2.feature");
formatter.feature({
  "name": "Verify Demo API",
  "description": "  Description : Verify CRUD operation",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify demo PUT API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"\u003cTestName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "I hit the \"\u003cRequestMethod\u003e\" method of PUT USER API with \"\u003cURL\u003e\" end point",
  "keyword": "When "
});
formatter.step({
  "name": "Validate the status code is \"\u003cStatusCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Validate user details in PUT API response",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "TestName",
        "URL",
        "RequestMethod",
        "StatusCode"
      ]
    },
    {
      "cells": [
        "PUT Demo API",
        "/users/2",
        "PUT",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify demo PUT API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"PUT Demo API\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DemoStepDefinition.iWantToCreateTestCase(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hit the \"PUT\" method of PUT USER API with \"/users/2\" end point",
  "keyword": "When "
});
formatter.match({
  "location": "DemoStepDefinition.iHitTheMethodOfPUTUSERAPIWithEndPoint(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the status code is \"200\"",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateTheStatusCodeIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate user details in PUT API response",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateUserDetailsInPUTAPIResponse()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify demo DELETE API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"\u003cTestName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "I hit the \"\u003cRequestMethod\u003e\" method of DELETE USER API with \"\u003cURL\u003e\" end point",
  "keyword": "When "
});
formatter.step({
  "name": "Validate the status code is \"\u003cStatusCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Validate user details in DELETE API response",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "TestName",
        "URL",
        "RequestMethod",
        "StatusCode"
      ]
    },
    {
      "cells": [
        "DELETE Demo API",
        "/users/2",
        "DELETE",
        "204"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify demo DELETE API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "name": "I want to create test case \"DELETE Demo API\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DemoStepDefinition.iWantToCreateTestCase(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hit the \"DELETE\" method of DELETE USER API with \"/users/2\" end point",
  "keyword": "When "
});
formatter.match({
  "location": "DemoStepDefinition.iHitTheMethodOfDELETEUSERAPIWithEndPoint(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the status code is \"204\"",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateTheStatusCodeIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate user details in DELETE API response",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoStepDefinition.validateUserDetailsInDELETEAPIResponse()"
});
formatter.result({
  "status": "passed"
});
});