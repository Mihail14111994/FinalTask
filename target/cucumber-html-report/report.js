$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/EventsNavigation.feature");
formatter.feature({
  "name": "Buy/book a ticket and get event information",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Doina"
    },
    {
      "name": "@All"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User is able to visualise details of any event",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@UI"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "\u003csection\u003e is selected",
  "keyword": "When "
});
formatter.step({
  "name": "All events of \u003csection\u003e have \"Detalii\" button",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on \"Detalii\" button of an event of \u003csection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "The information of the event is displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "section"
      ]
    },
    {
      "cells": [
        "Expoziții"
      ]
    },
    {
      "cells": [
        "Sport"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md home page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.HomePageIsDisplayed()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is able to visualise details of any event",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Doina"
    },
    {
      "name": "@All"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Expoziții is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All events of Expoziții have \"Detalii\" button",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allEventsOnThePageHaveDetails(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks on \"Detalii\" button of an event of Expoziții",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userClicksOnButtonOfAnEvent(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The information of the event is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.theInformationOfTheEventIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\n",
  "status": "failed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md home page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.HomePageIsDisplayed()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is able to visualise details of any event",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Doina"
    },
    {
      "name": "@All"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Sport is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All events of Sport have \"Detalii\" button",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allEventsOnThePageHaveDetails(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks on \"Detalii\" button of an event of Sport",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userClicksOnButtonOfAnEvent(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The information of the event is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.theInformationOfTheEventIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\n",
  "status": "failed"
});
formatter.uri("file:src/test/features/Registration.feature");
formatter.feature({
  "name": "Registration",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@All"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md home page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.HomePageIsDisplayed()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\n\tat ✽.Fest.md home page is displayed(file:src/test/features/Registration.feature:5)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Registration window UI check",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@All"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Valik"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerPageIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the following elements are visible on Register page",
  "rows": [
    {
      "cells": [
        "Register title"
      ]
    },
    {
      "cells": [
        "Email field"
      ]
    },
    {
      "cells": [
        "Password field"
      ]
    },
    {
      "cells": [
        "Confirm password field"
      ]
    },
    {
      "cells": [
        "Register button"
      ]
    },
    {
      "cells": [
        "Login button"
      ]
    },
    {
      "cells": [
        "Login with facebook button"
      ]
    },
    {
      "cells": [
        "Recieve newletter checkbox"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.theFollowingElementsAreVisible(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\n",
  "status": "failed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md home page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.HomePageIsDisplayed()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\n\tat ✽.Fest.md home page is displayed(file:src/test/features/Registration.feature:5)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Login window UI check",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@All"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Login page is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.loginPageIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the following elements are visible on Login page",
  "rows": [
    {
      "cells": [
        "Login title"
      ]
    },
    {
      "cells": [
        "Email field"
      ]
    },
    {
      "cells": [
        "Password field"
      ]
    },
    {
      "cells": [
        "Register button"
      ]
    },
    {
      "cells": [
        "Login button"
      ]
    },
    {
      "cells": [
        "Login with facebook button"
      ]
    },
    {
      "cells": [
        "Forgot password link"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.theFollowingElementsAreVisibleOnLoginPage(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\n",
  "status": "failed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md home page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.HomePageIsDisplayed()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\n\tat ✽.Fest.md home page is displayed(file:src/test/features/Registration.feature:5)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Registration/Login page UI check",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@All"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register_Login page is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerLoginPageIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the following elements are visible on Register_Login page",
  "rows": [
    {
      "cells": [
        "Register title"
      ]
    },
    {
      "cells": [
        "Login title"
      ]
    },
    {
      "cells": [
        "LoginRegister title"
      ]
    },
    {
      "cells": [
        "Email register field"
      ]
    },
    {
      "cells": [
        "Email login field"
      ]
    },
    {
      "cells": [
        "Password register field"
      ]
    },
    {
      "cells": [
        "Password login field"
      ]
    },
    {
      "cells": [
        "Confirm password field"
      ]
    },
    {
      "cells": [
        "Forgot Password Link"
      ]
    },
    {
      "cells": [
        "Register button"
      ]
    },
    {
      "cells": [
        "Login button"
      ]
    },
    {
      "cells": [
        "Facebook login register button"
      ]
    },
    {
      "cells": [
        "Recieve newletter checkbox"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.theFollowingElementsAreVisibleOnRegisterLoginPage(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\n",
  "status": "failed"
});
});