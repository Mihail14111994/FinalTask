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
  "name": "User is able to book a ticket",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    },
    {
      "name": "@book"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "User is logged in with valid credentials",
  "keyword": "Given "
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "And "
});
formatter.step({
  "name": "\u003csection\u003e is selected",
  "keyword": "When "
});
formatter.step({
  "name": "User submits \u003cnr\u003e tickets for an event of the \u003csection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "The total price is displayed correct for \u003cnr\u003e tickets",
  "keyword": "And "
});
formatter.step({
  "name": "All fields of booking are filled with \u003cfirstName\u003e, \u003clastName\u003e, \u003cphone\u003e and submited",
  "keyword": "And "
});
formatter.step({
  "name": "Booking is successfully accepted",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "nr",
        "section",
        "firstName",
        "lastName",
        "phone"
      ]
    },
    {
      "cells": [
        "2",
        "Party",
        "latinlatinlatinlatinlatinlatinlatinlatinlatinlatin",
        "latinlatinlatinlatinlatinlatinlatinlatinlatinlatin",
        "078524163"
      ]
    },
    {
      "cells": [
        "10",
        "Conferințe",
        "Ion",
        "Ion",
        "076852146"
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is able to book a ticket",
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
      "name": "@positive"
    },
    {
      "name": "@book"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "User is logged in with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.userIsLoggedInWithValidCredentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Party is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User submits 2 tickets for an event of the Party",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The total price is displayed correct for 2 tickets",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.theTotalPriceOfTicketsIsDisplayedCorrect(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All fields of booking are filled with latinlatinlatinlatinlatinlatinlatinlatinlatinlatin, latinlatinlatinlatinlatinlatinlatinlatinlatinlatin, 078524163 and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Booking is successfully accepted",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.bookingIsSuccessfullyAccepted()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is able to book a ticket",
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
      "name": "@positive"
    },
    {
      "name": "@book"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "User is logged in with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.userIsLoggedInWithValidCredentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Conferințe is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User submits 10 tickets for an event of the Conferințe",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The total price is displayed correct for 10 tickets",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.theTotalPriceOfTicketsIsDisplayedCorrect(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All fields of booking are filled with Ion, Ion, 076852146 and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Booking is successfully accepted",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.bookingIsSuccessfullyAccepted()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "name": "User is unable to book a ticket after checkout with invalid data",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@negative"
    },
    {
      "name": "@book"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "\u003csection\u003e is selected",
  "keyword": "When "
});
formatter.step({
  "name": "User submits \u003cnr\u003e tickets for an event of the \u003csection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "All fields of booking are filled with \u003cfirstName\u003e, \u003clastName\u003e, \u003cphone\u003e and submited",
  "keyword": "And "
});
formatter.step({
  "name": "\u003cerrorMessage\u003e occurs under each field",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "nr",
        "section",
        "firstName",
        "lastName",
        "phone",
        "errorMessage"
      ]
    },
    {
      "cells": [
        "1",
        "Party",
        "",
        "",
        "",
        "Acest câmp nu poate fi gol."
      ]
    },
    {
      "cells": [
        "4",
        "Conferințe",
        "latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl",
        "latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl",
        "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789011234567890",
        "Acest câmp nu poate avea mai mult de"
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is unable to book a ticket after checkout with invalid data",
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
      "name": "@negative"
    },
    {
      "name": "@book"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Party is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User submits 1 tickets for an event of the Party",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All fields of booking are filled with , ,  and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Acest câmp nu poate fi gol. occurs under each field",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.aWarningMessageOccursUnderEachField(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is unable to book a ticket after checkout with invalid data",
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
      "name": "@negative"
    },
    {
      "name": "@book"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Conferințe is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User submits 4 tickets for an event of the Conferințe",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All fields of booking are filled with latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl, latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl, 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789011234567890 and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Acest câmp nu poate avea mai mult de occurs under each field",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.aWarningMessageOccursUnderEachField(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "name": "User is able to set an alert for an event",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@alert"
    },
    {
      "name": "@functional"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "User is logged in with valid credentials",
  "keyword": "Given "
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "And "
});
formatter.step({
  "name": "Sport is selected",
  "keyword": "When "
});
formatter.step({
  "name": "User clicks on \"Detalii\" button of an event of \u003csection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "\u003coption\u003e for alert is selected and submited",
  "keyword": "And "
});
formatter.step({
  "name": "The alert is successfully set and deleted",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "section",
        "option"
      ]
    },
    {
      "cells": [
        "Sport",
        "În ziua evenimentului"
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is able to set an alert for an event",
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
      "name": "@alert"
    },
    {
      "name": "@functional"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "User is logged in with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.userIsLoggedInWithValidCredentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "And "
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
  "name": "În ziua evenimentului for alert is selected and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnOptionForAlertAndSubmit(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The alert is successfully set and deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.theAlertIsSuccessfullySet()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "name": "User is not able to book a empty number of tickets",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@negative"
    },
    {
      "name": "@tickets"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "\u003csection\u003e is selected",
  "keyword": "When "
});
formatter.step({
  "name": "User selects \u003cnr\u003e tickets for an event of the \u003csection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "Submit button is enabled",
  "keyword": "And "
});
formatter.step({
  "name": "User selects \u003cempty\u003e tickets for the same event",
  "keyword": "And "
});
formatter.step({
  "name": "Submit button is disabled",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "nr",
        "section",
        "empty"
      ]
    },
    {
      "cells": [
        "2",
        "Conferințe",
        "0"
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "User is not able to book a empty number of tickets",
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
      "name": "@negative"
    },
    {
      "name": "@tickets"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Conferințe is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User selects 2 tickets for an event of the Conferințe",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Submit button is enabled",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.submitButtonIsEnabledDisabled(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User selects 0 tickets for the same event",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsEmptyTicketsForTheSameEvent(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Submit button is disabled",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.submitButtonIsEnabledDisabled(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
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
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
});
});